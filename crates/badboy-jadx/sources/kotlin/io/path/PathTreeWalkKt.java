package kotlin.io.path;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000$\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0002\u0010\u0007\u001a\u000c\u0010\u0008\u001a\u00020\t*\u00020\nH\u0002¨\u0006\u000b", d2 = {"keyOf", "", "path", "Ljava/nio/file/Path;", "linkOptions", "", "Ljava/nio/file/LinkOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/lang/Object;", "createsCycle", "", "Lkotlin/io/path/PathNode;", "kotlin-stdlib-jdk7"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class PathTreeWalkKt {
    public static final boolean access$createsCycle(kotlin.io.path.PathNode $receiver) {
        return PathTreeWalkKt.createsCycle($receiver);
    }

    public static final Object access$keyOf(Path path, LinkOption[] linkOptions) {
        return PathTreeWalkKt.keyOf(path, linkOptions);
    }

    private static final boolean createsCycle(kotlin.io.path.PathNode $this$createsCycle) {
        kotlin.io.path.PathNode ancestor;
        Throwable sameFile;
        Object key;
        int i;
        Object path;
        ancestor = $this$createsCycle.getParent();
        while (ancestor != null) {
            i = 1;
            ancestor = ancestor.getParent();
        }
        return 0;
    }

    private static final Object keyOf(Path path, LinkOption[] linkOptions) {
        Object fileKey;
        String str;
        Object[] copyOf = Arrays.copyOf(linkOptions, linkOptions.length);
        BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class, (LinkOption[])Arrays.copyOf((LinkOption[])copyOf, copyOf.length));
        Intrinsics.checkNotNullExpressionValue(attributes, "readAttributes(...)");
        fileKey = attributes.fileKey();
        return fileKey;
    }
}
