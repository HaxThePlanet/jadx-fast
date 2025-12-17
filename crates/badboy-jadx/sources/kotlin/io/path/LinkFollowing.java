package kotlin.io.path;

import java.nio.file.FileVisitOption;
import java.nio.file.LinkOption;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u0006\u0010\r\u001a\u00020\u000eR\u0016\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Lkotlin/io/path/LinkFollowing;", "", "()V", "followLinkOption", "", "Ljava/nio/file/LinkOption;", "[Ljava/nio/file/LinkOption;", "followVisitOption", "", "Ljava/nio/file/FileVisitOption;", "nofollowLinkOption", "nofollowVisitOption", "toLinkOptions", "followLinks", "", "(Z)[Ljava/nio/file/LinkOption;", "toVisitOptions", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LinkFollowing {

    public static final kotlin.io.path.LinkFollowing INSTANCE;
    private static final LinkOption[] followLinkOption;
    private static final Set<FileVisitOption> followVisitOption;
    private static final LinkOption[] nofollowLinkOption;
    private static final Set<FileVisitOption> nofollowVisitOption;
    static {
        LinkFollowing linkFollowing = new LinkFollowing();
        LinkFollowing.INSTANCE = linkFollowing;
        LinkOption[] arr = new LinkOption[1];
        final int i2 = 0;
        arr[i2] = LinkOption.NOFOLLOW_LINKS;
        LinkFollowing.nofollowLinkOption = arr;
        LinkFollowing.followLinkOption = new LinkOption[i2];
        LinkFollowing.nofollowVisitOption = SetsKt.emptySet();
        LinkFollowing.followVisitOption = SetsKt.setOf(FileVisitOption.FOLLOW_LINKS);
    }

    public final LinkOption[] toLinkOptions(boolean followLinks) {
        LinkOption[] nofollowLinkOption;
        nofollowLinkOption = followLinks ? LinkFollowing.followLinkOption : LinkFollowing.nofollowLinkOption;
        return nofollowLinkOption;
    }

    public final Set<FileVisitOption> toVisitOptions(boolean followLinks) {
        Set nofollowVisitOption;
        nofollowVisitOption = followLinks ? LinkFollowing.followVisitOption : LinkFollowing.nofollowVisitOption;
        return nofollowVisitOption;
    }
}
