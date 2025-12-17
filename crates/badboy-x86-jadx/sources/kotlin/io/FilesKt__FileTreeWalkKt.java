package kotlin.io;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0007", d2 = {"walk", "Lkotlin/io/FileTreeWalk;", "Ljava/io/File;", "direction", "Lkotlin/io/FileWalkDirection;", "walkBottomUp", "walkTopDown", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/FilesKt")
class FilesKt__FileTreeWalkKt extends kotlin.io.FilesKt__FileReadWriteKt {
    public static final kotlin.io.FileTreeWalk walk(File $this$walk, kotlin.io.FileWalkDirection direction) {
        Intrinsics.checkNotNullParameter($this$walk, "<this>");
        Intrinsics.checkNotNullParameter(direction, "direction");
        FileTreeWalk fileTreeWalk = new FileTreeWalk($this$walk, direction);
        return fileTreeWalk;
    }

    public static kotlin.io.FileTreeWalk walk$default(File file, kotlin.io.FileWalkDirection fileWalkDirection2, int i3, Object object4) {
        kotlin.io.FileWalkDirection obj1;
        if (i3 &= 1 != 0) {
            obj1 = FileWalkDirection.TOP_DOWN;
        }
        return FilesKt.walk(file, obj1);
    }

    public static final kotlin.io.FileTreeWalk walkBottomUp(File $this$walkBottomUp) {
        Intrinsics.checkNotNullParameter($this$walkBottomUp, "<this>");
        return FilesKt.walk($this$walkBottomUp, FileWalkDirection.BOTTOM_UP);
    }

    public static final kotlin.io.FileTreeWalk walkTopDown(File $this$walkTopDown) {
        Intrinsics.checkNotNullParameter($this$walkTopDown, "<this>");
        return FilesKt.walk($this$walkTopDown, FileWalkDirection.TOP_DOWN);
    }
}
