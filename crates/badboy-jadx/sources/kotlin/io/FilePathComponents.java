package kotlin.io;

import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\r\u0008\u0080\u0008\u0018\u00002\u00020\u0001B\u001d\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u0018\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00082\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0013HÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0013J\t\u0010\u001f\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u00088F¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u000c\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0015¨\u0006 ", d2 = {"Lkotlin/io/FilePathComponents;", "", "root", "Ljava/io/File;", "segments", "", "(Ljava/io/File;Ljava/util/List;)V", "isRooted", "", "()Z", "getRoot", "()Ljava/io/File;", "rootName", "", "getRootName", "()Ljava/lang/String;", "getSegments", "()Ljava/util/List;", "size", "", "getSize", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "subPath", "beginIndex", "endIndex", "toString", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FilePathComponents {

    private final File root;
    private final List<File> segments;
    public FilePathComponents(File root, List<? extends File> segments) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(segments, "segments");
        super();
        this.root = root;
        this.segments = segments;
    }

    public static kotlin.io.FilePathComponents copy$default(kotlin.io.FilePathComponents filePathComponents, File file2, List list3, int i4, Object object5) {
        File obj1;
        List obj2;
        if (i4 & 1 != 0) {
            obj1 = filePathComponents.root;
        }
        if (i4 &= 2 != 0) {
            obj2 = filePathComponents.segments;
        }
        return filePathComponents.copy(obj1, obj2);
    }

    public final File component1() {
        return this.root;
    }

    public final List<File> component2() {
        return this.segments;
    }

    public final kotlin.io.FilePathComponents copy(File file, List<? extends File> list2) {
        Intrinsics.checkNotNullParameter(file, "root");
        Intrinsics.checkNotNullParameter(list2, "segments");
        FilePathComponents filePathComponents = new FilePathComponents(file, list2);
        return filePathComponents;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object instanceof FilePathComponents == null) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.root, obj.root)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.segments, obj.segments)) {
            return i2;
        }
        return i;
    }

    public final File getRoot() {
        return this.root;
    }

    public final String getRootName() {
        String path = this.root.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        return path;
    }

    public final List<File> getSegments() {
        return this.segments;
    }

    public final int getSize() {
        return this.segments.size();
    }

    public int hashCode() {
        return i2 += i4;
    }

    public final boolean isRooted() {
        int i;
        String path = this.root.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        i = (CharSequence)path.length() > 0 ? 1 : 0;
        return i;
    }

    public final File subPath(int beginIndex, int endIndex) {
        int size;
        if (beginIndex < 0) {
        } else {
            if (beginIndex > endIndex) {
            } else {
                if (endIndex > getSize()) {
                } else {
                    String separator = File.separator;
                    Intrinsics.checkNotNullExpressionValue(separator, "separator");
                    File file = new File(CollectionsKt.joinToString$default((Iterable)this.segments.subList(beginIndex, endIndex), (CharSequence)separator, 0, 0, 0, 0, 0, 62, 0));
                    return file;
                }
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("FilePathComponents(root=").append(this.root).append(", segments=").append(this.segments).append(')').toString();
    }
}
