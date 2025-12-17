package androidx.compose.animation.core;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0007\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0013\u001a\u00020\u00142\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0016H\u0010¢\u0006\u0002\u0008\u0017J\r\u0010\u0018\u001a\u00020\u0014H\u0010¢\u0006\u0002\u0008\u0019R+\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u00008V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\u0008\n\u0010\u000b\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\u0004R\u0011\u0010\u000c\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\u000eR+\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u00008V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0012\u0010\u000b\u001a\u0004\u0008\u0010\u0010\u0008\"\u0004\u0008\u0011\u0010\u0004¨\u0006\u001a", d2 = {"Landroidx/compose/animation/core/MutableTransitionState;", "S", "Landroidx/compose/animation/core/TransitionState;", "initialState", "(Ljava/lang/Object;)V", "<set-?>", "currentState", "getCurrentState", "()Ljava/lang/Object;", "setCurrentState$animation_core_release", "currentState$delegate", "Landroidx/compose/runtime/MutableState;", "isIdle", "", "()Z", "targetState", "getTargetState", "setTargetState", "targetState$delegate", "transitionConfigured", "", "transition", "Landroidx/compose/animation/core/Transition;", "transitionConfigured$animation_core_release", "transitionRemoved", "transitionRemoved$animation_core_release", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MutableTransitionState<S>  extends androidx.compose.animation.core.TransitionState<S> {

    public static final int $stable;
    private final MutableState currentState$delegate;
    private final MutableState targetState$delegate;
    static {
    }

    public MutableTransitionState(S initialState) {
        int i = 0;
        super(i);
        final int i2 = 2;
        this.currentState$delegate = SnapshotStateKt.mutableStateOf$default(initialState, i, i2, i);
        this.targetState$delegate = SnapshotStateKt.mutableStateOf$default(initialState, i, i2, i);
    }

    public S getCurrentState() {
        final int i = 0;
        final int i2 = 0;
        return (State)this.currentState$delegate.getValue();
    }

    public S getTargetState() {
        final int i = 0;
        final int i2 = 0;
        return (State)this.targetState$delegate.getValue();
    }

    @Override // androidx.compose.animation.core.TransitionState
    public final boolean isIdle() {
        boolean running$animation_core_release;
        int i;
        if (Intrinsics.areEqual(getCurrentState(), getTargetState()) && !isRunning$animation_core_release()) {
            i = !isRunning$animation_core_release() ? 1 : 0;
        } else {
        }
        return i;
    }

    public void setCurrentState$animation_core_release(S <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.currentState$delegate.setValue(<set-?>);
    }

    public void setTargetState(S <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.targetState$delegate.setValue(<set-?>);
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void setTargetState$animation_core_release(Object <set-?>) {
        setTargetState(<set-?>);
    }

    public void transitionConfigured$animation_core_release(androidx.compose.animation.core.Transition<S> transition) {
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void transitionRemoved$animation_core_release() {
    }
}
