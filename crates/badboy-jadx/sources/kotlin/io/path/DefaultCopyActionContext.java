package kotlin.io.path;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t", d2 = {"Lkotlin/io/path/DefaultCopyActionContext;", "Lkotlin/io/path/CopyActionContext;", "()V", "copyToIgnoringExistingDirectory", "Lkotlin/io/path/CopyActionResult;", "Ljava/nio/file/Path;", "target", "followLinks", "", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class DefaultCopyActionContext implements kotlin.io.path.CopyActionContext {

    public static final kotlin.io.path.DefaultCopyActionContext INSTANCE;
    static {
        DefaultCopyActionContext defaultCopyActionContext = new DefaultCopyActionContext();
        DefaultCopyActionContext.INSTANCE = defaultCopyActionContext;
    }

    @Override // kotlin.io.path.CopyActionContext
    public kotlin.io.path.CopyActionResult copyToIgnoringExistingDirectory(Path $this$copyToIgnoringExistingDirectory, Path target, boolean followLinks) {
        boolean directory;
        LinkOption[] length;
        int i;
        LinkOption nOFOLLOW_LINKS;
        Intrinsics.checkNotNullParameter($this$copyToIgnoringExistingDirectory, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        LinkOption[] linkOptions = LinkFollowing.INSTANCE.toLinkOptions(followLinks);
        Object[] copyOf = Arrays.copyOf(linkOptions, linkOptions.length);
        if (Files.isDirectory($this$copyToIgnoringExistingDirectory, (LinkOption[])Arrays.copyOf((LinkOption[])copyOf, copyOf.length)) != null) {
            int i2 = 1;
            length = new LinkOption[i2];
            length[0] = LinkOption.NOFOLLOW_LINKS;
            if (Files.isDirectory(target, (LinkOption[])Arrays.copyOf(length, i2)) == null) {
                Object[] copyOf4 = Arrays.copyOf(linkOptions, linkOptions.length);
                Intrinsics.checkNotNullExpressionValue(Files.copy($this$copyToIgnoringExistingDirectory, target, (CopyOption[])Arrays.copyOf((CopyOption[])copyOf4, copyOf4.length)), "copy(...)");
            }
        } else {
        }
        return CopyActionResult.CONTINUE;
    }
}
