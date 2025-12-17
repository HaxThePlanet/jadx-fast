package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotContextElement;
import androidx.compose.runtime.snapshots.SnapshotContextElement.DefaultImpls;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.ThreadContextElement;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0001\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000c\u001a\u00020\rH\u0016R\u0018\u0010\u0006\u001a\u0006\u0012\u0002\u0008\u00030\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Landroidx/compose/runtime/SnapshotContextElementImpl;", "Landroidx/compose/runtime/snapshots/SnapshotContextElement;", "Lkotlinx/coroutines/ThreadContextElement;", "Landroidx/compose/runtime/snapshots/Snapshot;", "snapshot", "(Landroidx/compose/runtime/snapshots/Snapshot;)V", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "updateThreadContext", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SnapshotContextElementImpl implements SnapshotContextElement, ThreadContextElement<Snapshot> {

    public static final int $stable = 8;
    private final Snapshot snapshot;
    static {
        final int i = 8;
    }

    public SnapshotContextElementImpl(Snapshot snapshot) {
        super();
        this.snapshot = snapshot;
    }

    public <R> R fold(R initial, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
        return SnapshotContextElement.DefaultImpls.fold(this, initial, operation);
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return SnapshotContextElement.DefaultImpls.get(this, key);
    }

    public CoroutineContext.Key<?> getKey() {
        return (CoroutineContext.Key)SnapshotContextElement.Key;
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return SnapshotContextElement.DefaultImpls.minusKey(this, key);
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotContextElement
    public CoroutineContext plus(CoroutineContext context) {
        return SnapshotContextElement.DefaultImpls.plus(this, context);
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotContextElement
    public void restoreThreadContext(CoroutineContext context, Snapshot oldState) {
        this.snapshot.unsafeLeave(oldState);
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotContextElement
    public void restoreThreadContext(CoroutineContext context, Object oldState) {
        restoreThreadContext(context, (Snapshot)oldState);
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotContextElement
    public Snapshot updateThreadContext(CoroutineContext context) {
        return this.snapshot.unsafeEnter();
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotContextElement
    public Object updateThreadContext(CoroutineContext context) {
        return updateThreadContext(context);
    }
}
