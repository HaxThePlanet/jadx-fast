package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuation.DefaultImpls;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0008\u0010\u0011\u001a\u00020\u000cH\u0016J\u0008\u0010\u0012\u001a\u00020\u000cH\u0016J\u0016\u0010\u0013\u001a\u00020\u000c2\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0016R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0004\u0010\u0008R\u0014\u0010\t\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\u0008R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000c\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000eX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u0017", d2 = {"Landroidx/compose/material3/TooltipStateImpl;", "Landroidx/compose/material3/TooltipState;", "initialIsVisible", "", "isPersistent", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "(ZZLandroidx/compose/foundation/MutatorMutex;)V", "()Z", "isVisible", "job", "Lkotlinx/coroutines/CancellableContinuation;", "", "transition", "Landroidx/compose/animation/core/MutableTransitionState;", "getTransition", "()Landroidx/compose/animation/core/MutableTransitionState;", "dismiss", "onDispose", "show", "mutatePriority", "Landroidx/compose/foundation/MutatePriority;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class TooltipStateImpl implements androidx.compose.material3.TooltipState {

    private final boolean isPersistent;
    private CancellableContinuation<? super Unit> job;
    private final MutatorMutex mutatorMutex;
    private final MutableTransitionState<Boolean> transition;
    public TooltipStateImpl(boolean initialIsVisible, boolean isPersistent, MutatorMutex mutatorMutex) {
        super();
        this.isPersistent = isPersistent;
        this.mutatorMutex = mutatorMutex;
        MutableTransitionState mutableTransitionState = new MutableTransitionState(Boolean.valueOf(initialIsVisible));
        this.transition = mutableTransitionState;
    }

    public static final void access$setJob$p(androidx.compose.material3.TooltipStateImpl $this, CancellableContinuation <set-?>) {
        $this.job = <set-?>;
    }

    @Override // androidx.compose.material3.TooltipState
    public void dismiss() {
        getTransition().setTargetState(false);
    }

    public MutableTransitionState<Boolean> getTransition() {
        return this.transition;
    }

    @Override // androidx.compose.material3.TooltipState
    public boolean isPersistent() {
        return this.isPersistent;
    }

    @Override // androidx.compose.material3.TooltipState
    public boolean isVisible() {
        int i;
        boolean booleanValue;
        if (!(Boolean)getTransition().getCurrentState().booleanValue()) {
            if ((Boolean)getTransition().getTargetState().booleanValue()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.material3.TooltipState
    public void onDispose() {
        int i;
        int i2;
        final CancellableContinuation job = this.job;
        if (job != null) {
            i2 = 0;
            CancellableContinuation.DefaultImpls.cancel$default(job, i2, 1, i2);
        }
    }

    public Object show(MutatePriority mutatePriority, Continuation<? super Unit> $completion) {
        int i = 0;
        TooltipStateImpl.show.cancellableShow.1 anon = new TooltipStateImpl.show.cancellableShow.1(this, i);
        TooltipStateImpl.show.2 anon2 = new TooltipStateImpl.show.2(this, (Function1)anon, mutatePriority, i);
        Object mutate = this.mutatorMutex.mutate(mutatePriority, (Function1)anon2, $completion);
        if (mutate == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return mutate;
        }
        return Unit.INSTANCE;
    }
}
