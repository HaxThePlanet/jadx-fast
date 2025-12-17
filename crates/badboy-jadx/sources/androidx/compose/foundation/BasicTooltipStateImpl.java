package androidx.compose.foundation;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuation.DefaultImpls;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0008\u0010\u0012\u001a\u00020\u0011H\u0016J\u0008\u0010\u0013\u001a\u00020\u0011H\u0016J\u0016\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0004\u0010\u0008R+\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\n\u0010\u0008\"\u0004\u0008\u000b\u0010\u000cR\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018", d2 = {"Landroidx/compose/foundation/BasicTooltipStateImpl;", "Landroidx/compose/foundation/BasicTooltipState;", "initialIsVisible", "", "isPersistent", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "(ZZLandroidx/compose/foundation/MutatorMutex;)V", "()Z", "<set-?>", "isVisible", "setVisible", "(Z)V", "isVisible$delegate", "Landroidx/compose/runtime/MutableState;", "job", "Lkotlinx/coroutines/CancellableContinuation;", "", "dismiss", "onDispose", "show", "mutatePriority", "Landroidx/compose/foundation/MutatePriority;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class BasicTooltipStateImpl implements androidx.compose.foundation.BasicTooltipState {

    private final boolean isPersistent;
    private final MutableState isVisible$delegate;
    private CancellableContinuation<? super Unit> job;
    private final androidx.compose.foundation.MutatorMutex mutatorMutex;
    public BasicTooltipStateImpl(boolean initialIsVisible, boolean isPersistent, androidx.compose.foundation.MutatorMutex mutatorMutex) {
        super();
        this.isPersistent = isPersistent;
        this.mutatorMutex = mutatorMutex;
        final int i = 0;
        this.isVisible$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(initialIsVisible), i, 2, i);
    }

    public static final void access$setJob$p(androidx.compose.foundation.BasicTooltipStateImpl $this, CancellableContinuation <set-?>) {
        $this.job = <set-?>;
    }

    @Override // androidx.compose.foundation.BasicTooltipState
    public void dismiss() {
        setVisible(false);
    }

    @Override // androidx.compose.foundation.BasicTooltipState
    public boolean isPersistent() {
        return this.isPersistent;
    }

    @Override // androidx.compose.foundation.BasicTooltipState
    public boolean isVisible() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.isVisible$delegate.getValue().booleanValue();
    }

    @Override // androidx.compose.foundation.BasicTooltipState
    public void onDispose() {
        int i;
        int i2;
        final CancellableContinuation job = this.job;
        if (job != null) {
            i2 = 0;
            CancellableContinuation.DefaultImpls.cancel$default(job, i2, 1, i2);
        }
    }

    @Override // androidx.compose.foundation.BasicTooltipState
    public void setVisible(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.isVisible$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    public Object show(androidx.compose.foundation.MutatePriority mutatePriority, Continuation<? super Unit> $completion) {
        int i = 0;
        BasicTooltipStateImpl.show.cancellableShow.1 anon = new BasicTooltipStateImpl.show.cancellableShow.1(this, i);
        BasicTooltipStateImpl.show.2 anon2 = new BasicTooltipStateImpl.show.2(this, (Function1)anon, i);
        Object mutate = this.mutatorMutex.mutate(mutatePriority, (Function1)anon2, $completion);
        if (mutate == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return mutate;
        }
        return Unit.INSTANCE;
    }
}
