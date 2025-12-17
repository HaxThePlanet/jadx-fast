package kotlin.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010(\n\u0002\u0008\u0006\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001a\u001b\u001cB\u0019\u0008\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0089\u0001\u0008\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\u0008\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0008\u00128\u0010\u000c\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u000e\u0012\u0008\u0008\u000f\u0012\u0004\u0008\u0008(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\u000c\u0008\u000e\u0012\u0008\u0008\u000f\u0012\u0004\u0008\u0008(\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r\u0012\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\u000f\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0017H\u0096\u0002J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0014J\u001a\u0010\u0007\u001a\u00020\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0008J \u0010\u000c\u001a\u00020\u00002\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\rJ\u001a\u0010\n\u001a\u00020\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u0008R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\u000c\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u000e\u0012\u0008\u0008\u000f\u0012\u0004\u0008\u0008(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\u000c\u0008\u000e\u0012\u0008\u0008\u000f\u0012\u0004\u0008\u0008(\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d", d2 = {"Lkotlin/io/FileTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/io/File;", "start", "direction", "Lkotlin/io/FileWalkDirection;", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)V", "onEnter", "Lkotlin/Function1;", "", "onLeave", "", "onFail", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "f", "Ljava/io/IOException;", "e", "maxDepth", "", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;I)V", "iterator", "", "depth", "function", "DirectoryState", "FileTreeWalkIterator", "WalkState", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FileTreeWalk implements Sequence<File> {

    private final kotlin.io.FileWalkDirection direction;
    private final int maxDepth;
    private final Function1<File, Boolean> onEnter;
    private final Function2<File, IOException, Unit> onFail;
    private final Function1<File, Unit> onLeave;
    private final File start;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\"\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0008", d2 = {"Lkotlin/io/FileTreeWalk$WalkState;", "", "root", "Ljava/io/File;", "(Ljava/io/File;)V", "getRoot", "()Ljava/io/File;", "step", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static abstract class WalkState {

        private final File root;
        public WalkState(File root) {
            Intrinsics.checkNotNullParameter(root, "root");
            super();
            this.root = root;
        }

        public final File getRoot() {
            return this.root;
        }

        public abstract File step();
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\"\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005", d2 = {"Lkotlin/io/FileTreeWalk$DirectoryState;", "Lkotlin/io/FileTreeWalk$WalkState;", "rootDir", "Ljava/io/File;", "(Ljava/io/File;)V", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static abstract class DirectoryState extends kotlin.io.FileTreeWalk.WalkState {
        public DirectoryState(File rootDir) {
            Intrinsics.checkNotNullParameter(rootDir, "rootDir");
            super(rootDir);
            if (rootDir.isDirectory() == null) {
            } else {
            }
            int i = 0;
            AssertionError assertionError = new AssertionError("rootDir must be verified to be directory beforehand.");
            throw assertionError;
        }
    }

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0082\u0004\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\r\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0007\u001a\u00020\u0008H\u0014J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u000b\u0010\u000c\u001a\u0004\u0018\u00010\u0002H\u0082\u0010R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;", "Lkotlin/collections/AbstractIterator;", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk;)V", "state", "Ljava/util/ArrayDeque;", "Lkotlin/io/FileTreeWalk$WalkState;", "computeNext", "", "directoryState", "Lkotlin/io/FileTreeWalk$DirectoryState;", "root", "gotoNext", "BottomUpDirectoryState", "SingleFileState", "TopDownDirectoryState", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class FileTreeWalkIterator extends AbstractIterator<File> {

        private final ArrayDeque<kotlin.io.FileTreeWalk.WalkState> state;
        final kotlin.io.FileTreeWalk this$0;
        public FileTreeWalkIterator(kotlin.io.FileTreeWalk this$0) {
            ArrayDeque state;
            kotlin.io.FileTreeWalk.WalkState singleFileState;
            File file;
            this.this$0 = this$0;
            super();
            ArrayDeque arrayDeque = new ArrayDeque();
            this.state = arrayDeque;
            if (FileTreeWalk.access$getStart$p(this.this$0).isDirectory() != null) {
                this.state.push(directoryState(FileTreeWalk.access$getStart$p(this.this$0)));
            } else {
                if (FileTreeWalk.access$getStart$p(this.this$0).isFile() != null) {
                    singleFileState = new FileTreeWalk.FileTreeWalkIterator.SingleFileState(this, FileTreeWalk.access$getStart$p(this.this$0));
                    this.state.push(singleFileState);
                } else {
                    done();
                }
            }
        }

        private final kotlin.io.FileTreeWalk.DirectoryState directoryState(File root) {
            kotlin.io.FileTreeWalk.DirectoryState topDownDirectoryState;
            switch (i) {
                case 1:
                    topDownDirectoryState = new FileTreeWalk.FileTreeWalkIterator.TopDownDirectoryState(this, root);
                    break;
                case 2:
                    topDownDirectoryState = new FileTreeWalk.FileTreeWalkIterator.BottomUpDirectoryState(this, root);
                    break;
                default:
                    NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                    throw noWhenBranchMatchedException;
            }
            return topDownDirectoryState;
        }

        private final File gotoNext() {
            Object peek;
            File step;
            ArrayDeque state;
            boolean directory;
            kotlin.io.FileTreeWalk.DirectoryState directoryState;
            peek = this.state.peek();
            while ((FileTreeWalk.WalkState)peek == null) {
                step = (FileTreeWalk.WalkState)peek.step();
                this.state.push(directoryState(step));
                peek = this.state.peek();
                this.state.pop();
            }
            return null;
        }

        @Override // kotlin.collections.AbstractIterator
        protected void computeNext() {
            final File gotoNext = gotoNext();
            if (gotoNext != null) {
                setNext(gotoNext);
            } else {
                done();
            }
        }
    }
    public FileTreeWalk(File start, kotlin.io.FileWalkDirection direction) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(direction, "direction");
        super(start, direction, 0, 0, 0, 0, 32, 0);
    }

    public FileTreeWalk(File file, kotlin.io.FileWalkDirection fileWalkDirection2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        kotlin.io.FileWalkDirection obj2;
        obj2 = i3 &= 2 != 0 ? FileWalkDirection.TOP_DOWN : obj2;
        super(file, obj2);
    }

    private FileTreeWalk(File start, kotlin.io.FileWalkDirection direction, Function1<? super File, Boolean> onEnter, Function1<? super File, Unit> onLeave, Function2<? super File, ? super IOException, Unit> onFail, int maxDepth) {
        super();
        this.start = start;
        this.direction = direction;
        this.onEnter = onEnter;
        this.onLeave = onLeave;
        this.onFail = onFail;
        this.maxDepth = maxDepth;
    }

    FileTreeWalk(File file, kotlin.io.FileWalkDirection fileWalkDirection2, Function1 function13, Function1 function14, Function2 function25, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker8) {
        kotlin.io.FileWalkDirection fileWalkDirection;
        int i;
        kotlin.io.FileWalkDirection obj9;
        int obj13;
        fileWalkDirection = i7 & 2 != 0 ? obj9 : fileWalkDirection2;
        i = i7 & 32 != 0 ? obj13 : i6;
        super(file, fileWalkDirection, function13, function14, function25, i);
    }

    public static final kotlin.io.FileWalkDirection access$getDirection$p(kotlin.io.FileTreeWalk $this) {
        return $this.direction;
    }

    public static final int access$getMaxDepth$p(kotlin.io.FileTreeWalk $this) {
        return $this.maxDepth;
    }

    public static final Function1 access$getOnEnter$p(kotlin.io.FileTreeWalk $this) {
        return $this.onEnter;
    }

    public static final Function2 access$getOnFail$p(kotlin.io.FileTreeWalk $this) {
        return $this.onFail;
    }

    public static final Function1 access$getOnLeave$p(kotlin.io.FileTreeWalk $this) {
        return $this.onLeave;
    }

    public static final File access$getStart$p(kotlin.io.FileTreeWalk $this) {
        return $this.start;
    }

    public Iterator<File> iterator() {
        FileTreeWalk.FileTreeWalkIterator fileTreeWalkIterator = new FileTreeWalk.FileTreeWalkIterator(this);
        return (Iterator)fileTreeWalkIterator;
    }

    @Override // kotlin.sequences.Sequence
    public final kotlin.io.FileTreeWalk maxDepth(int depth) {
        if (depth <= 0) {
        } else {
            FileTreeWalk fileTreeWalk = new FileTreeWalk(this.start, this.direction, this.onEnter, this.onLeave, this.onFail, depth);
            return fileTreeWalk;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException obj8 = new IllegalArgumentException(stringBuilder.append("depth must be positive, but was ").append(depth).append('.').toString());
        throw obj8;
    }

    public final kotlin.io.FileTreeWalk onEnter(Function1<? super File, Boolean> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        FileTreeWalk fileTreeWalk = new FileTreeWalk(this.start, this.direction, function, this.onLeave, this.onFail, this.maxDepth);
        return fileTreeWalk;
    }

    public final kotlin.io.FileTreeWalk onFail(Function2<? super File, ? super IOException, Unit> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        FileTreeWalk fileTreeWalk = new FileTreeWalk(this.start, this.direction, this.onEnter, this.onLeave, function, this.maxDepth);
        return fileTreeWalk;
    }

    public final kotlin.io.FileTreeWalk onLeave(Function1<? super File, Unit> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        FileTreeWalk fileTreeWalk = new FileTreeWalk(this.start, this.direction, this.onEnter, function, this.onFail, this.maxDepth);
        return fileTreeWalk;
    }
}
