package kotlin.io.path;

import java.nio.file.FileSystemLoopException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010(\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0008\u0002\u0008\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0015H\u0002J\u000e\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0015H\u0002J\u000f\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0015H\u0096\u0002JB\u0010\u0018\u001a\u00020\u0019*\u0008\u0012\u0004\u0012\u00020\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0018\u0010\u001f\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0!\u0012\u0004\u0012\u00020\u00190 H\u0082H¢\u0006\u0002\u0010\"R\u0014\u0010\u0008\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0014\u0010\u000c\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#", d2 = {"Lkotlin/io/path/PathTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/nio/file/Path;", "start", "options", "", "Lkotlin/io/path/PathWalkOption;", "(Ljava/nio/file/Path;[Lkotlin/io/path/PathWalkOption;)V", "followLinks", "", "getFollowLinks", "()Z", "includeDirectories", "getIncludeDirectories", "isBFS", "linkOptions", "Ljava/nio/file/LinkOption;", "getLinkOptions", "()[Ljava/nio/file/LinkOption;", "[Lkotlin/io/path/PathWalkOption;", "bfsIterator", "", "dfsIterator", "iterator", "yieldIfNeeded", "", "Lkotlin/sequences/SequenceScope;", "node", "Lkotlin/io/path/PathNode;", "entriesReader", "Lkotlin/io/path/DirectoryEntriesReader;", "entriesAction", "Lkotlin/Function1;", "", "(Lkotlin/sequences/SequenceScope;Lkotlin/io/path/PathNode;Lkotlin/io/path/DirectoryEntriesReader;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PathTreeWalk implements Sequence<Path> {

    private final kotlin.io.path.PathWalkOption[] options;
    private final Path start;
    public PathTreeWalk(Path start, kotlin.io.path.PathWalkOption[] options) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(options, "options");
        super();
        this.start = start;
        this.options = options;
    }

    public static final boolean access$getFollowLinks(kotlin.io.path.PathTreeWalk $this) {
        return $this.getFollowLinks();
    }

    public static final boolean access$getIncludeDirectories(kotlin.io.path.PathTreeWalk $this) {
        return $this.getIncludeDirectories();
    }

    public static final LinkOption[] access$getLinkOptions(kotlin.io.path.PathTreeWalk $this) {
        return $this.getLinkOptions();
    }

    public static final Path access$getStart$p(kotlin.io.path.PathTreeWalk $this) {
        return $this.start;
    }

    private final Iterator<Path> bfsIterator() {
        PathTreeWalk.bfsIterator.1 anon = new PathTreeWalk.bfsIterator.1(this, 0);
        return SequencesKt.iterator((Function2)anon);
    }

    private final Iterator<Path> dfsIterator() {
        PathTreeWalk.dfsIterator.1 anon = new PathTreeWalk.dfsIterator.1(this, 0);
        return SequencesKt.iterator((Function2)anon);
    }

    private final boolean getFollowLinks() {
        return ArraysKt.contains(this.options, PathWalkOption.FOLLOW_LINKS);
    }

    private final boolean getIncludeDirectories() {
        return ArraysKt.contains(this.options, PathWalkOption.INCLUDE_DIRECTORIES);
    }

    private final LinkOption[] getLinkOptions() {
        return LinkFollowing.INSTANCE.toLinkOptions(getFollowLinks());
    }

    private final boolean isBFS() {
        return ArraysKt.contains(this.options, PathWalkOption.BREADTH_FIRST);
    }

    private final Object yieldIfNeeded(SequenceScope<? super Path> $this$yieldIfNeeded, kotlin.io.path.PathNode node, kotlin.io.path.DirectoryEntriesReader entriesReader, Function1<? super List<kotlin.io.path.PathNode>, Unit> entriesAction, Continuation<? super Unit> $completion) {
        boolean directory;
        int length;
        int i;
        LinkOption nOFOLLOW_LINKS;
        final int i2 = 0;
        final Path path = node.getPath();
        if (node.getParent() != null) {
            PathsKt.checkFileName(path);
        }
        LinkOption[] objArr = PathTreeWalk.access$getLinkOptions(this);
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        if (Files.isDirectory(path, (LinkOption[])Arrays.copyOf((LinkOption[])copyOf, copyOf.length)) != null) {
            if (PathTreeWalkKt.access$createsCycle(node)) {
            } else {
                if (PathTreeWalk.access$getIncludeDirectories(this)) {
                    $this$yieldIfNeeded.yield(path, $completion);
                }
                LinkOption[] objArr2 = PathTreeWalk.access$getLinkOptions(this);
                Object[] copyOf3 = Arrays.copyOf(objArr2, objArr2.length);
                if (Files.isDirectory(path, (LinkOption[])Arrays.copyOf((LinkOption[])copyOf3, copyOf3.length)) != null) {
                    entriesAction.invoke(entriesReader.readEntries(node));
                }
                return Unit.INSTANCE;
            }
            FileSystemLoopException fileSystemLoopException = new FileSystemLoopException(path.toString());
            throw fileSystemLoopException;
        }
        int i3 = 1;
        length = new LinkOption[i3];
        length[0] = LinkOption.NOFOLLOW_LINKS;
        if (Files.exists(path, (LinkOption[])Arrays.copyOf(length, i3)) != null) {
            $this$yieldIfNeeded.yield(path, $completion);
            return Unit.INSTANCE;
        }
    }

    public Iterator<Path> iterator() {
        Iterator bfsIterator;
        if (isBFS()) {
            bfsIterator = bfsIterator();
        } else {
            bfsIterator = dfsIterator();
        }
        return bfsIterator;
    }
}
