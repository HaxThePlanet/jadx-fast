package kotlin.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u001a*\u0010\t\u001a\u00020\u00022\u0008\u0008\u0002\u0010\n\u001a\u00020\u00012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u0002H\u0007\u001a*\u0010\r\u001a\u00020\u00022\u0008\u0008\u0002\u0010\n\u001a\u00020\u00012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u0002H\u0007\u001a8\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u000f2\u001a\u0008\u0002\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013\u001a&\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u0018\u001a\n\u0010\u0019\u001a\u00020\u000f*\u00020\u0002\u001a\u0012\u0010\u001a\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u0012\u0010\u001a\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0001\u001a\n\u0010\u001c\u001a\u00020\u0002*\u00020\u0002\u001a\u001d\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u001d*\u0008\u0012\u0004\u0012\u00020\u00020\u001dH\u0002¢\u0006\u0002\u0008\u001e\u001a\u0011\u0010\u001c\u001a\u00020\u001f*\u00020\u001fH\u0002¢\u0006\u0002\u0008\u001e\u001a\u0012\u0010 \u001a\u00020\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0014\u0010\"\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0012\u0010#\u001a\u00020\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0001\u001a\u0012\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0002\u001a\u0012\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0001\u001a\u0012\u0010'\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u0012\u0010'\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0001\u001a\u0012\u0010(\u001a\u00020\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u001b\u0010)\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0008*\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0004\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\u0004¨\u0006+", d2 = {"extension", "", "Ljava/io/File;", "getExtension", "(Ljava/io/File;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath", "nameWithoutExtension", "getNameWithoutExtension", "createTempDir", "prefix", "suffix", "directory", "createTempFile", "copyRecursively", "", "target", "overwrite", "onError", "Lkotlin/Function2;", "Ljava/io/IOException;", "Lkotlin/io/OnErrorAction;", "copyTo", "bufferSize", "", "deleteRecursively", "endsWith", "other", "normalize", "", "normalize$FilesKt__UtilsKt", "Lkotlin/io/FilePathComponents;", "relativeTo", "base", "relativeToOrNull", "relativeToOrSelf", "resolve", "relative", "resolveSibling", "startsWith", "toRelativeString", "toRelativeStringOrNull", "toRelativeStringOrNull$FilesKt__UtilsKt", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/FilesKt")
class FilesKt__UtilsKt extends kotlin.io.FilesKt__FileTreeWalkKt {
    public static final boolean copyRecursively(File $this$copyRecursively, File target, boolean overwrite, Function2<? super File, ? super IOException, ? extends kotlin.io.OnErrorAction> onError) {
        kotlin.io.FilesKt__UtilsKt.copyRecursively.2 relativeString;
        int i2;
        Object tERMINATE2;
        kotlin.io.NoSuchFileException src;
        Object dstFile;
        int invoke;
        String tERMINATE;
        int i;
        int length;
        boolean obj14;
        Intrinsics.checkNotNullParameter($this$copyRecursively, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(onError, "onError");
        i2 = 1;
        final int i3 = 0;
        if (!$this$copyRecursively.exists()) {
            Object obj = $this$copyRecursively;
            NoSuchFileException noSuchFileException = new NoSuchFileException(obj, 0, "The source file doesn't exist.", 2, 0);
            if (onError.invoke(obj, noSuchFileException) != OnErrorAction.TERMINATE) {
            } else {
                i2 = i3;
            }
            return i2;
        }
        Object $this$copyRecursively2 = $this$copyRecursively;
        relativeString = new FilesKt__UtilsKt.copyRecursively.2(onError);
        Iterator obj12 = FilesKt.walkTopDown($this$copyRecursively2).onFail((Function2)relativeString).iterator();
        for (File next2 : obj12) {
            Object obj2 = next2;
            dstFile = obj2;
            tERMINATE2 = new File(target, FilesKt.toRelativeString(dstFile, $this$copyRecursively2));
            invoke = obj14;
            src = dstFile;
            dstFile = src;
            obj14 = invoke;
            obj14 = new IOException("Source file wasn't copied completely, length of destination file differs.");
            obj14 = invoke;
            tERMINATE2.mkdirs();
            if (obj14 == null) {
            } else {
            }
            if (tERMINATE2.isDirectory() != null) {
            } else {
            }
            if (!tERMINATE2.delete()) {
            } else {
            }
            src = i3;
            FileAlreadyExistsException fileAlreadyExistsException = new FileAlreadyExistsException(dstFile, tERMINATE2, "The destination file already exists.");
            src = i2;
            if (FilesKt.deleteRecursively(tERMINATE2) == null) {
            } else {
            }
            src = i3;
            src = i2;
            src = i2;
            dstFile = obj2;
            src = new NoSuchFileException(dstFile, 0, "The source file doesn't exist.", 2, 0);
        }
        return i2;
    }

    public static boolean copyRecursively$default(File file, File file2, boolean z3, Function2 function24, int i5, Object object6) {
        int obj2;
        kotlin.io.FilesKt__UtilsKt.copyRecursively.1 obj3;
        if (i5 & 2 != 0) {
            obj2 = 0;
        }
        if (i5 &= 4 != 0) {
            obj3 = FilesKt__UtilsKt.copyRecursively.1.INSTANCE;
        }
        return FilesKt.copyRecursively(file, file2, obj2, obj3);
    }

    public static final File copyTo(File $this$copyTo, File target, boolean overwrite, int bufferSize) {
        boolean exists;
        int output;
        FileInputStream inputStream3;
        FileInputStream inputStream2;
        int i;
        FileOutputStream outputStream;
        int i2;
        FileInputStream inputStream;
        FileOutputStream outputStream2;
        Intrinsics.checkNotNullParameter($this$copyTo, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        if (!$this$copyTo.exists()) {
        } else {
            if (target.exists()) {
                if (!overwrite) {
                } else {
                    if (!target.delete()) {
                    } else {
                    }
                    FileAlreadyExistsException fileAlreadyExistsException = new FileAlreadyExistsException($this$copyTo, target, "Tried to overwrite the destination, but failed to delete it.");
                    throw fileAlreadyExistsException;
                }
                FileAlreadyExistsException fileAlreadyExistsException2 = new FileAlreadyExistsException($this$copyTo, target, "The destination file already exists.");
                throw fileAlreadyExistsException2;
            }
            if ($this$copyTo.isDirectory() != null) {
                if (!target.mkdirs()) {
                } else {
                    return target;
                }
                FileSystemException fileSystemException = new FileSystemException($this$copyTo, target, "Failed to create target directory.");
                throw fileSystemException;
            }
            File parentFile = target.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileInputStream fileInputStream = new FileInputStream($this$copyTo);
            inputStream3 = fileInputStream;
            i = 0;
            FileOutputStream fileOutputStream = new FileOutputStream(target);
            outputStream = fileOutputStream;
            i2 = 0;
            ByteStreamsKt.copyTo((InputStream)(FileInputStream)(Closeable)inputStream3, (OutputStream)(FileOutputStream)(Closeable)outputStream, bufferSize);
            output = 0;
            CloseableKt.closeFinally(outputStream, output);
            CloseableKt.closeFinally(inputStream3, output);
        }
        NoSuchFileException noSuchFileException = new NoSuchFileException($this$copyTo, 0, "The source file doesn't exist.", 2, 0);
        throw noSuchFileException;
    }

    public static File copyTo$default(File file, File file2, boolean z3, int i4, int i5, Object object6) {
        int obj2;
        int obj3;
        if (i5 & 2 != 0) {
            obj2 = 0;
        }
        if (i5 &= 4 != 0) {
            obj3 = 8192;
        }
        return FilesKt.copyTo(file, file2, obj2, obj3);
    }

    @Deprecated(message = "Avoid creating temporary directories in the default temp location with this function due to too wide permissions on the newly created directory. Use kotlin.io.path.createTempDirectory instead.")
    public static final File createTempDir(String prefix, String suffix, File directory) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        File tempFile = File.createTempFile(prefix, suffix, directory);
        tempFile.delete();
        if (tempFile.mkdir() == null) {
        } else {
            Intrinsics.checkNotNull(tempFile);
            return tempFile;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IOException iOException = new IOException(stringBuilder.append("Unable to create temporary directory ").append(tempFile).append('.').toString());
        throw iOException;
    }

    public static File createTempDir$default(String string, String string2, File file3, int i4, Object object5) {
        String obj1;
        int obj2;
        int obj3;
        if (i4 & 1 != 0) {
            obj1 = "tmp";
        }
        final int i = 0;
        if (i4 & 2 != 0) {
            obj2 = i;
        }
        if (i4 &= 4 != 0) {
            obj3 = i;
        }
        return FilesKt.createTempDir(obj1, obj2, obj3);
    }

    @Deprecated(message = "Avoid creating temporary files in the default temp location with this function due to too wide permissions on the newly created file. Use kotlin.io.path.createTempFile instead or resort to java.io.File.createTempFile.")
    public static final File createTempFile(String prefix, String suffix, File directory) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        File tempFile = File.createTempFile(prefix, suffix, directory);
        Intrinsics.checkNotNullExpressionValue(tempFile, "createTempFile(...)");
        return tempFile;
    }

    public static File createTempFile$default(String string, String string2, File file3, int i4, Object object5) {
        String obj1;
        int obj2;
        int obj3;
        if (i4 & 1 != 0) {
            obj1 = "tmp";
        }
        final int i = 0;
        if (i4 & 2 != 0) {
            obj2 = i;
        }
        if (i4 &= 4 != 0) {
            obj3 = i;
        }
        return FilesKt.createTempFile(obj1, obj2, obj3);
    }

    public static final boolean deleteRecursively(File $this$deleteRecursively) {
        int accumulator$iv;
        Object next;
        Object obj;
        int i3;
        int i;
        int i2;
        boolean delete;
        Intrinsics.checkNotNullParameter($this$deleteRecursively, "<this>");
        final int i5 = 0;
        accumulator$iv = i4;
        final Iterator iterator = (Sequence)FilesKt.walkBottomUp($this$deleteRecursively).iterator();
        while (iterator.hasNext()) {
            obj = next;
            i = 0;
            if ((File)obj.delete() == null) {
            } else {
            }
            if (accumulator$iv != 0) {
            } else {
            }
            i2 = 0;
            accumulator$iv = i2;
            i2 = 1;
            if (!obj.exists() && accumulator$iv != 0) {
            } else {
            }
        }
        return accumulator$iv;
    }

    public static final boolean endsWith(File $this$endsWith, File other) {
        int equals;
        List segments;
        Intrinsics.checkNotNullParameter($this$endsWith, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        kotlin.io.FilePathComponents components = FilesKt.toComponents($this$endsWith);
        final kotlin.io.FilePathComponents components2 = FilesKt.toComponents(other);
        if (components2.isRooted()) {
            return Intrinsics.areEqual($this$endsWith, other);
        }
        size -= size2;
        if (i < 0) {
            equals = 0;
        } else {
            equals = components.getSegments().subList(i, components.getSize()).equals(components2.getSegments());
        }
        return equals;
    }

    public static final boolean endsWith(File $this$endsWith, String other) {
        Intrinsics.checkNotNullParameter($this$endsWith, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        File file = new File(other);
        return FilesKt.endsWith($this$endsWith, file);
    }

    public static final String getExtension(File $this$extension) {
        Intrinsics.checkNotNullParameter($this$extension, "<this>");
        String name = $this$extension.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return StringsKt.substringAfterLast(name, '.', "");
    }

    public static final String getInvariantSeparatorsPath(File $this$invariantSeparatorsPath) {
        String replace$default;
        String path;
        char separatorChar;
        int i;
        int i3;
        int i4;
        int i2;
        Intrinsics.checkNotNullParameter($this$invariantSeparatorsPath, "<this>");
        final String str2 = "getPath(...)";
        if (File.separatorChar != 47) {
            path = $this$invariantSeparatorsPath.getPath();
            Intrinsics.checkNotNullExpressionValue(path, str2);
            replace$default = StringsKt.replace$default(path, File.separatorChar, '/', false, 4, 0);
        } else {
            Intrinsics.checkNotNullExpressionValue($this$invariantSeparatorsPath.getPath(), str2);
        }
        return replace$default;
    }

    public static final String getNameWithoutExtension(File $this$nameWithoutExtension) {
        Intrinsics.checkNotNullParameter($this$nameWithoutExtension, "<this>");
        String name = $this$nameWithoutExtension.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        int i = 0;
        return StringsKt.substringBeforeLast$default(name, ".", i, 2, i);
    }

    public static final File normalize(File $this$normalize) {
        Intrinsics.checkNotNullParameter($this$normalize, "<this>");
        kotlin.io.FilePathComponents components = FilesKt.toComponents($this$normalize);
        final int i = 0;
        String separator = File.separator;
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        return FilesKt.resolve(components.getRoot(), CollectionsKt.joinToString$default((Iterable)FilesKt__UtilsKt.normalize$FilesKt__UtilsKt(components.getSegments()), (CharSequence)separator, 0, 0, 0, 0, 0, 62, 0));
    }

    private static final List<File> normalize$FilesKt__UtilsKt(List<? extends File> $this$normalize) {
        Object next;
        String equal2;
        boolean equal;
        ArrayList arrayList = new ArrayList($this$normalize.size());
        Iterator iterator = $this$normalize.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            equal2 = (File)next.getName();
            if (!Intrinsics.areEqual(equal2, ".")) {
            }
            equal = "..";
            if (Intrinsics.areEqual(equal2, equal)) {
            } else {
            }
            (List)arrayList.add(next);
            if (!arrayList.isEmpty() && Intrinsics.areEqual((File)CollectionsKt.last(arrayList).getName(), equal) == null) {
            } else {
            }
            arrayList.add(next);
            if (Intrinsics.areEqual((File)CollectionsKt.last(arrayList).getName(), equal) == null) {
            } else {
            }
            arrayList.remove(size2--);
        }
        return arrayList;
    }

    private static final kotlin.io.FilePathComponents normalize$FilesKt__UtilsKt(kotlin.io.FilePathComponents $this$normalize) {
        FilePathComponents filePathComponents = new FilePathComponents($this$normalize.getRoot(), FilesKt__UtilsKt.normalize$FilesKt__UtilsKt($this$normalize.getSegments()));
        return filePathComponents;
    }

    public static final File relativeTo(File $this$relativeTo, File base) {
        Intrinsics.checkNotNullParameter($this$relativeTo, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        File file = new File(FilesKt.toRelativeString($this$relativeTo, base));
        return file;
    }

    public static final File relativeToOrNull(File $this$relativeToOrNull, File base) {
        int i;
        File file;
        Intrinsics.checkNotNullParameter($this$relativeToOrNull, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        String relativeStringOrNull$FilesKt__UtilsKt = FilesKt__UtilsKt.toRelativeStringOrNull$FilesKt__UtilsKt($this$relativeToOrNull, base);
        if (relativeStringOrNull$FilesKt__UtilsKt != null) {
            i = 0;
            file = new File(relativeStringOrNull$FilesKt__UtilsKt);
        } else {
            file = 0;
        }
        return file;
    }

    public static final File relativeToOrSelf(File $this$relativeToOrSelf, File base) {
        int i;
        Object file;
        Intrinsics.checkNotNullParameter($this$relativeToOrSelf, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        String relativeStringOrNull$FilesKt__UtilsKt = FilesKt__UtilsKt.toRelativeStringOrNull$FilesKt__UtilsKt($this$relativeToOrSelf, base);
        if (relativeStringOrNull$FilesKt__UtilsKt != null) {
            i = 0;
            file = new File(relativeStringOrNull$FilesKt__UtilsKt);
        } else {
            file = $this$relativeToOrSelf;
        }
        return file;
    }

    public static final File resolve(File $this$resolve, File relative) {
        int endsWith$default;
        File file;
        String string;
        char separatorChar;
        int i2;
        int i;
        Intrinsics.checkNotNullParameter($this$resolve, "<this>");
        Intrinsics.checkNotNullParameter(relative, "relative");
        if (FilesKt.isRooted(relative) != null) {
            return relative;
        }
        String string2 = $this$resolve.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        int i3 = 0;
        endsWith$default = (CharSequence)string2.length() == 0 ? 1 : i3;
        if (endsWith$default == 0) {
            if (StringsKt.endsWith$default((CharSequence)string2, File.separatorChar, i3, 2, 0) != null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                file = new File(stringBuilder2.append(string2).append(relative).toString());
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                file = new File(stringBuilder.append(string2).append(File.separatorChar).append(relative).toString());
            }
        } else {
        }
        return file;
    }

    public static final File resolve(File $this$resolve, String relative) {
        Intrinsics.checkNotNullParameter($this$resolve, "<this>");
        Intrinsics.checkNotNullParameter(relative, "relative");
        File file = new File(relative);
        return FilesKt.resolve($this$resolve, file);
    }

    public static final File resolveSibling(File $this$resolveSibling, File relative) {
        File subPath;
        String str;
        Intrinsics.checkNotNullParameter($this$resolveSibling, "<this>");
        Intrinsics.checkNotNullParameter(relative, "relative");
        kotlin.io.FilePathComponents components = FilesKt.toComponents($this$resolveSibling);
        if (components.getSize() == 0) {
            subPath = new File("..");
        } else {
            subPath = components.subPath(0, size2--);
        }
        return FilesKt.resolve(FilesKt.resolve(components.getRoot(), subPath), relative);
    }

    public static final File resolveSibling(File $this$resolveSibling, String relative) {
        Intrinsics.checkNotNullParameter($this$resolveSibling, "<this>");
        Intrinsics.checkNotNullParameter(relative, "relative");
        File file = new File(relative);
        return FilesKt.resolveSibling($this$resolveSibling, file);
    }

    public static final boolean startsWith(File $this$startsWith, File other) {
        int subList;
        int equals;
        int size;
        Intrinsics.checkNotNullParameter($this$startsWith, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        kotlin.io.FilePathComponents components = FilesKt.toComponents($this$startsWith);
        final kotlin.io.FilePathComponents components2 = FilesKt.toComponents(other);
        equals = 0;
        if (!Intrinsics.areEqual(components.getRoot(), components2.getRoot())) {
            return equals;
        }
        if (components.getSize() < components2.getSize()) {
        } else {
            equals = components.getSegments().subList(equals, components2.getSize()).equals(components2.getSegments());
        }
        return equals;
    }

    public static final boolean startsWith(File $this$startsWith, String other) {
        Intrinsics.checkNotNullParameter($this$startsWith, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        File file = new File(other);
        return FilesKt.startsWith($this$startsWith, file);
    }

    public static final String toRelativeString(File $this$toRelativeString, File base) {
        Intrinsics.checkNotNullParameter($this$toRelativeString, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        String relativeStringOrNull$FilesKt__UtilsKt = FilesKt__UtilsKt.toRelativeStringOrNull$FilesKt__UtilsKt($this$toRelativeString, base);
        if (relativeStringOrNull$FilesKt__UtilsKt == null) {
        } else {
            return relativeStringOrNull$FilesKt__UtilsKt;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("this and base files have different roots: ").append($this$toRelativeString).append(" and ").append(base).append('.').toString());
        throw illegalArgumentException;
    }

    private static final String toRelativeStringOrNull$FilesKt__UtilsKt(File $this$toRelativeStringOrNull, File base) {
        int separatorChar;
        int i3;
        int i9;
        int separatorChar2;
        boolean equal;
        Object obj;
        int i8;
        int i5;
        int i2;
        int i4;
        int i6;
        int i7;
        int i;
        kotlin.io.FilePathComponents normalize$FilesKt__UtilsKt = FilesKt__UtilsKt.normalize$FilesKt__UtilsKt(FilesKt.toComponents($this$toRelativeStringOrNull));
        kotlin.io.FilePathComponents normalize$FilesKt__UtilsKt2 = FilesKt__UtilsKt.normalize$FilesKt__UtilsKt(FilesKt.toComponents(base));
        separatorChar = 0;
        if (Intrinsics.areEqual(normalize$FilesKt__UtilsKt.getRoot(), normalize$FilesKt__UtilsKt2.getRoot()) == null) {
            return separatorChar;
        }
        int size = normalize$FilesKt__UtilsKt2.getSize();
        final int size2 = normalize$FilesKt__UtilsKt.getSize();
        File file = $this$toRelativeStringOrNull;
        int i10 = 0;
        i9 = 0;
        while (i9 < Math.min(size2, size)) {
            if (Intrinsics.areEqual(normalize$FilesKt__UtilsKt.getSegments().get(i9), normalize$FilesKt__UtilsKt2.getSegments().get(i9)) != null) {
            }
            i9++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (i9 <= size + -1) {
        }
        if (i9 < size2 && i9 < size) {
            if (i9 < size) {
                stringBuilder.append(File.separatorChar);
            }
            separatorChar = File.separator;
            Intrinsics.checkNotNullExpressionValue(separatorChar, "separator");
            CollectionsKt.joinTo$default((Iterable)CollectionsKt.drop((Iterable)normalize$FilesKt__UtilsKt.getSegments(), i9), (Appendable)stringBuilder, (CharSequence)separatorChar, 0, 0, 0, 0, 0, 124, 0);
        }
        return stringBuilder.toString();
    }
}
