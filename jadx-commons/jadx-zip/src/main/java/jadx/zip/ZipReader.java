package jadx.zip;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jadx.zip.fallback.FallbackZipParser;
import jadx.zip.parser.JadxZipParser;
import jadx.zip.security.IJadxZipSecurity;
import jadx.zip.security.JadxZipSecurity;

/**
 * Jadx wrapper to provide custom zip parser ({@link JadxZipParser})
 * with fallback to default Java implementation.
 */
public class ZipReader {
	private static final Logger LOG = LoggerFactory.getLogger(ZipReader.class);
	// Use 25% of available processors to optimize for physical cores, not hyperthreads
	private static final int DEFAULT_THREAD_COUNT = Math.max(1, Runtime.getRuntime().availableProcessors() / 4);

	private final ZipReaderOptions options;

	public ZipReader() {
		this(ZipReaderOptions.getDefault());
	}

	public ZipReader(Set<ZipReaderFlags> flags) {
		this(new ZipReaderOptions(new JadxZipSecurity(), flags));
	}

	public ZipReader(IJadxZipSecurity security) {
		this(new ZipReaderOptions(security, ZipReaderFlags.none()));
	}

	public ZipReader(ZipReaderOptions options) {
		this.options = options;
	}

	@SuppressWarnings("resource")
	public ZipContent open(File zipFile) throws IOException {
		try {
			JadxZipParser jadxParser = new JadxZipParser(zipFile, options);
			IZipParser detectedParser = detectParser(zipFile, jadxParser);
			if (detectedParser != jadxParser) {
				jadxParser.close();
			}
			return detectedParser.open();
		} catch (Exception e) {
			if (options.getFlags().contains(ZipReaderFlags.DONT_USE_FALLBACK)) {
				throw new IOException("Failed to open zip: " + zipFile, e);
			}
			// switch to fallback parser
			return buildFallbackParser(zipFile).open();
		}
	}

	/**
	 * Visit valid entries in a zip file.
	 * Return not null value from visitor to stop iteration.
	 */
	public <R> @Nullable R visitEntries(File file, Function<IZipEntry, R> visitor) {
		try (ZipContent content = open(file)) {
			for (IZipEntry entry : content.getEntries()) {
				R result = visitor.apply(entry);
				if (result != null) {
					return result;
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("Failed to process zip file: " + file.getAbsolutePath(), e);
		}
		return null;
	}

	public void readEntries(File file, BiConsumer<IZipEntry, InputStream> visitor) {
		boolean useParallel = options.getFlags().contains(ZipReaderFlags.PARALLEL_EXTRACTION);
		if (useParallel) {
			readEntriesParallel(file, visitor);
		} else {
			readEntriesSequential(file, visitor);
		}
	}

	private void readEntriesSequential(File file, BiConsumer<IZipEntry, InputStream> visitor) {
		visitEntries(file, entry -> {
			if (!entry.isDirectory()) {
				try (InputStream in = entry.getInputStream()) {
					visitor.accept(entry, in);
				} catch (Exception e) {
					throw new RuntimeException("Failed to process zip entry: " + entry, e);
				}
			}
			return null;
		});
	}

	private void readEntriesParallel(File file, BiConsumer<IZipEntry, InputStream> visitor) {
		try (ZipContent content = open(file)) {
			List<IZipEntry> entries = content.getEntries();
			int parallelism = DEFAULT_THREAD_COUNT;

			// For small zip files, use fewer threads
			if (entries.size() < parallelism) {
				parallelism = Math.max(1, entries.size());
			}
			LOG.debug("Processing {} entries using ForkJoinPool with parallelism {}", entries.size(), parallelism);

			// Use ForkJoinPool with custom parallelism for work-stealing
			ConcurrentHashMap<String, Object> processedEntries = new ConcurrentHashMap<>();

			// Filter out directories
			List<IZipEntry> filesToProcess = entries.stream()
					.filter(entry -> !entry.isDirectory())
					.collect(Collectors.toList());

			// Process in parallel with work-stealing
			java.util.concurrent.ForkJoinPool customThreadPool =
					new java.util.concurrent.ForkJoinPool(parallelism);

			try {
				customThreadPool.submit(() -> filesToProcess.parallelStream().forEach(entry -> {
					try (InputStream in = entry.getInputStream()) {
						visitor.accept(entry, in);
						processedEntries.put(entry.getName(), Boolean.TRUE);
					} catch (Exception e) {
						throw new RuntimeException("Failed to process zip entry: " + entry, e);
					}
				})).get(); // Wait for completion
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				throw new RuntimeException("Parallel processing interrupted", e);
			} catch (ExecutionException e) {
				throw new RuntimeException("Error in parallel processing", e.getCause());
			} finally {
				customThreadPool.shutdown();
				try {
					if (!customThreadPool.awaitTermination(1, TimeUnit.MINUTES)) {
						LOG.warn("Thread pool did not terminate in the specified time");
						customThreadPool.shutdownNow();
					}
				} catch (InterruptedException e) {
					customThreadPool.shutdownNow();
					Thread.currentThread().interrupt();
				}
			}

			LOG.debug("Processed {} entries in parallel with work stealing", processedEntries.size());
		} catch (Exception e) {
			throw new RuntimeException("Failed to process zip file: " + file.getAbsolutePath(), e);
		}
	}

	public ZipReaderOptions getOptions() {
		return options;
	}

	private IZipParser detectParser(File zipFile, JadxZipParser jadxParser) {
		if (zipFile.getName().endsWith(".apk")
				|| options.getFlags().contains(ZipReaderFlags.DONT_USE_FALLBACK)) {
			return jadxParser;
		}
		if (!jadxParser.canOpen()) {
			return buildFallbackParser(zipFile);
		}
		// default
		if (options.getFlags().contains(ZipReaderFlags.FALLBACK_AS_DEFAULT)) {
			return buildFallbackParser(zipFile);
		}
		return jadxParser;
	}

	private FallbackZipParser buildFallbackParser(File zipFile) {
		return new FallbackZipParser(zipFile, options);
	}
}
