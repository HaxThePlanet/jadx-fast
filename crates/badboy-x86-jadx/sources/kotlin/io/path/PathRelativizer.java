package kotlin.io.path;

import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"Lkotlin/io/path/PathRelativizer;", "", "()V", "emptyPath", "Ljava/nio/file/Path;", "kotlin.jvm.PlatformType", "parentPath", "tryRelativeTo", "path", "base", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class PathRelativizer {

    public static final kotlin.io.path.PathRelativizer INSTANCE;
    private static final Path emptyPath;
    private static final Path parentPath;
    static {
        PathRelativizer pathRelativizer = new PathRelativizer();
        PathRelativizer.INSTANCE = pathRelativizer;
        int i = 0;
        PathRelativizer.emptyPath = Paths.get("", new String[i]);
        PathRelativizer.parentPath = Paths.get("..", new String[i]);
    }

    public final Path tryRelativeTo(Path path, Path base) {
        int i;
        boolean string;
        Path path2;
        int nameCount;
        Path parentPath;
        int i2;
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(base, "base");
        Path normalize = base.normalize();
        final Path normalize2 = path.normalize();
        final Path relativize = normalize.relativize(normalize2);
        i = 0;
        while (i < Math.min(normalize.getNameCount(), normalize2.getNameCount())) {
            i++;
        }
        if (!Intrinsics.areEqual(normalize2, normalize) && Intrinsics.areEqual(normalize, PathRelativizer.emptyPath)) {
            if (Intrinsics.areEqual(normalize, PathRelativizer.emptyPath)) {
                path2 = normalize2;
            } else {
                string = relativize.toString();
                String separator = relativize.getFileSystem().getSeparator();
                Intrinsics.checkNotNullExpressionValue(separator, "getSeparator(...)");
                i2 = 0;
                if (StringsKt.endsWith$default(string, separator, i2, 2, 0)) {
                    path2 = relativize.getFileSystem().getPath(StringsKt.dropLast(string, relativize.getFileSystem().getSeparator().length()), new String[i2]);
                } else {
                    path2 = relativize;
                }
            }
        } else {
        }
        Intrinsics.checkNotNull(path2);
        return path2;
    }
}
