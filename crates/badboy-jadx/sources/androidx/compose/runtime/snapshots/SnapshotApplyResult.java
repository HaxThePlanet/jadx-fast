package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00087\u0018\u00002\u00020\u0001:\u0002\t\nB\u0007\u0008\u0004¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0007\u001a\u00020\u0008H&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0001\u0002\u000b\u000c¨\u0006\r", d2 = {"Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "", "()V", "succeeded", "", "getSucceeded", "()Z", "check", "", "Failure", "Success", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult$Failure;", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult$Success;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class SnapshotApplyResult {

    public static final int $stable;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u000b\u001a\u00020\u000cH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\n¨\u0006\r", d2 = {"Landroidx/compose/runtime/snapshots/SnapshotApplyResult$Failure;", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "(Landroidx/compose/runtime/snapshots/Snapshot;)V", "getSnapshot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "succeeded", "", "getSucceeded", "()Z", "check", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Failure extends androidx.compose.runtime.snapshots.SnapshotApplyResult {

        public static final int $stable = 8;
        private final androidx.compose.runtime.snapshots.Snapshot snapshot;
        static {
            final int i = 8;
        }

        public Failure(androidx.compose.runtime.snapshots.Snapshot snapshot) {
            super(0);
            this.snapshot = snapshot;
        }

        @Override // androidx.compose.runtime.snapshots.SnapshotApplyResult
        public void check() {
            this.snapshot.dispose();
            SnapshotApplyConflictException snapshotApplyConflictException = new SnapshotApplyConflictException(this.snapshot);
            throw snapshotApplyConflictException;
        }

        @Override // androidx.compose.runtime.snapshots.SnapshotApplyResult
        public final androidx.compose.runtime.snapshots.Snapshot getSnapshot() {
            return this.snapshot;
        }

        @Override // androidx.compose.runtime.snapshots.SnapshotApplyResult
        public boolean getSucceeded() {
            return 0;
        }
    }

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0007\u001a\u00020\u0008H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\t", d2 = {"Landroidx/compose/runtime/snapshots/SnapshotApplyResult$Success;", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "()V", "succeeded", "", "getSucceeded", "()Z", "check", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Success extends androidx.compose.runtime.snapshots.SnapshotApplyResult {

        public static final int $stable;
        public static final androidx.compose.runtime.snapshots.SnapshotApplyResult.Success INSTANCE;
        static {
            SnapshotApplyResult.Success success = new SnapshotApplyResult.Success();
            SnapshotApplyResult.Success.INSTANCE = success;
        }

        private Success() {
            super(0);
        }

        @Override // androidx.compose.runtime.snapshots.SnapshotApplyResult
        public void check() {
        }

        @Override // androidx.compose.runtime.snapshots.SnapshotApplyResult
        public boolean getSucceeded() {
            return 1;
        }
    }
    static {
    }

    public SnapshotApplyResult(DefaultConstructorMarker defaultConstructorMarker) {
        super();
    }

    public abstract void check();

    public abstract boolean getSucceeded();
}
