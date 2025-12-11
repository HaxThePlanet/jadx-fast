package jadx.zip;

import java.util.EnumSet;
import java.util.Set;

public enum ZipReaderFlags {
	/**
	 * Search all local file headers by signature without reading
	 * 'central directory' and 'end of central directory' entries
	 */
	IGNORE_CENTRAL_DIR_ENTRIES,

	/**
	 * Enable additional checks to verify zip data and report possible tampering
	 */
	REPORT_TAMPERING,

	/**
	 * Use fallback (java built-in implementation) parser as default.
	 * Custom implementation will be used for '*.apk' files only.
	 */
	FALLBACK_AS_DEFAULT,

	/**
	 * Use only jadx custom parser and do not switch to fallback on errors.
	 */
	DONT_USE_FALLBACK,

	/**
	 * Enable parallel processing of zip entries.
	 * Significantly improves extraction speed on multi-core systems.
	 */
	PARALLEL_EXTRACTION;

	public static Set<ZipReaderFlags> none() {
		return EnumSet.noneOf(ZipReaderFlags.class);
	}

	public static Set<ZipReaderFlags> defaultSet() {
		return EnumSet.of(PARALLEL_EXTRACTION);
	}
}
