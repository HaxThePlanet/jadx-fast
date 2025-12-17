package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.Transition.DeferredAnimation;
import androidx.compose.animation.core.Transition.DeferredAnimation;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0017\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0008\u0001\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0008R\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u000c¢\u0006\u0002\u0010\rJ\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\tJ,\u00106\u001a\u0002032\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0008R\u0008\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000b\u001a\u00020\u000cRW\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0008R\u0008\u0012\u0004\u0012\u00020\u00060\u00052\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0008R\u0008\u0012\u0004\u0012\u00020\u00060\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0013\u0010\u0014\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012R \u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001aR;\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008!\u0010\u0014\u001a\u0004\u0008\u001d\u0010\u001e\"\u0004\u0008\u001f\u0010 R+\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u000c8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008&\u0010\u0014\u001a\u0004\u0008\"\u0010#\"\u0004\u0008$\u0010%R\u0011\u0010'\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008'\u0010(R\u0011\u0010)\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008*\u0010(R\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010,R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010.R\u0013\u0010/\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\u00080\u00101¨\u00067", d2 = {"Landroidx/compose/animation/BoundsAnimation;", "", "transitionScope", "Landroidx/compose/animation/SharedTransitionScope;", "transition", "Landroidx/compose/animation/core/Transition;", "", "animation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/animation/core/AnimationVector4D;", "boundsTransform", "Landroidx/compose/animation/BoundsTransform;", "(Landroidx/compose/animation/SharedTransitionScope;Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/BoundsTransform;)V", "<set-?>", "getAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "setAnimation", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;)V", "animation$delegate", "Landroidx/compose/runtime/MutableState;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "Landroidx/compose/runtime/State;", "animationState", "getAnimationState", "()Landroidx/compose/runtime/State;", "setAnimationState", "(Landroidx/compose/runtime/State;)V", "animationState$delegate", "getBoundsTransform", "()Landroidx/compose/animation/BoundsTransform;", "setBoundsTransform", "(Landroidx/compose/animation/BoundsTransform;)V", "boundsTransform$delegate", "isRunning", "()Z", "target", "getTarget", "getTransition", "()Landroidx/compose/animation/core/Transition;", "getTransitionScope", "()Landroidx/compose/animation/SharedTransitionScope;", "value", "getValue", "()Landroidx/compose/ui/geometry/Rect;", "animate", "", "currentBounds", "targetBounds", "updateAnimation", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BoundsAnimation {

    public static final int $stable = 8;
    private final MutableState animation$delegate;
    private FiniteAnimationSpec<Rect> animationSpec;
    private final MutableState animationState$delegate;
    private final MutableState boundsTransform$delegate;
    private final Transition<Boolean> transition;
    private final androidx.compose.animation.SharedTransitionScope transitionScope;
    static {
        final int i = 8;
    }

    public BoundsAnimation(androidx.compose.animation.SharedTransitionScope transitionScope, Transition<Boolean> transition, Transition.DeferredAnimation<Boolean, Rect, AnimationVector4D> animation, androidx.compose.animation.BoundsTransform boundsTransform) {
        super();
        this.transitionScope = transitionScope;
        this.transition = transition;
        int i = 0;
        final int i2 = 2;
        this.animation$delegate = SnapshotStateKt.mutableStateOf$default(animation, i, i2, i);
        this.boundsTransform$delegate = SnapshotStateKt.mutableStateOf$default(boundsTransform, i, i2, i);
        this.animationSpec = (FiniteAnimationSpec)BoundsAnimationKt.access$getDefaultBoundsAnimation$p();
        this.animationState$delegate = SnapshotStateKt.mutableStateOf$default(i, i, i2, i);
    }

    private final androidx.compose.animation.BoundsTransform getBoundsTransform() {
        final int i = 0;
        final int i2 = 0;
        return (BoundsTransform)(State)this.boundsTransform$delegate.getValue();
    }

    private final void setAnimation(Transition.DeferredAnimation<Boolean, Rect, AnimationVector4D> <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.animation$delegate.setValue(<set-?>);
    }

    private final void setBoundsTransform(androidx.compose.animation.BoundsTransform <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.boundsTransform$delegate.setValue(<set-?>);
    }

    public final void animate(Rect currentBounds, Rect targetBounds) {
        Object animationState;
        boolean transitionActive;
        androidx.compose.animation.BoundsAnimation.animate.1 anon;
        androidx.compose.animation.BoundsAnimation.animate.2 anon2;
        if (this.transitionScope.isTransitionActive() && getAnimationState() == null) {
            if (getAnimationState() == null) {
                this.animationSpec = getBoundsTransform().transform(currentBounds, targetBounds);
            }
            anon = new BoundsAnimation.animate.1(this);
            anon2 = new BoundsAnimation.animate.2(this, targetBounds, currentBounds);
            setAnimationState(getAnimation().animate((Function1)anon, (Function1)anon2));
        }
    }

    public final Transition.DeferredAnimation<Boolean, Rect, AnimationVector4D> getAnimation() {
        final int i = 0;
        final int i2 = 0;
        return (Transition.DeferredAnimation)(State)this.animation$delegate.getValue();
    }

    public final FiniteAnimationSpec<Rect> getAnimationSpec() {
        return this.animationSpec;
    }

    public final State<Rect> getAnimationState() {
        final int i = 0;
        final int i2 = 0;
        return (State)(State)this.animationState$delegate.getValue();
    }

    public final boolean getTarget() {
        return (Boolean)this.transition.getTargetState().booleanValue();
    }

    public final Transition<Boolean> getTransition() {
        return this.transition;
    }

    public final androidx.compose.animation.SharedTransitionScope getTransitionScope() {
        return this.transitionScope;
    }

    public final Rect getValue() {
        boolean transitionActive;
        int i;
        i = 0;
        if (this.transitionScope.isTransitionActive()) {
            transitionActive = getAnimationState();
            if (transitionActive != null) {
                i = transitionActive;
            }
        } else {
        }
        return i;
    }

    public final boolean isRunning() {
        Transition parent;
        Transition parentTransition;
        parent = this.transition;
        while (parent.getParentTransition() != null) {
            parentTransition = parent.getParentTransition();
            Intrinsics.checkNotNull(parentTransition);
            parent = parentTransition;
        }
        return equal ^= 1;
    }

    public final void setAnimationSpec(FiniteAnimationSpec<Rect> <set-?>) {
        this.animationSpec = <set-?>;
    }

    public final void setAnimationState(State<Rect> <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.animationState$delegate.setValue(<set-?>);
    }

    public final void updateAnimation(Transition.DeferredAnimation<Boolean, Rect, AnimationVector4D> animation, androidx.compose.animation.BoundsTransform boundsTransform) {
        boolean equal;
        if (!Intrinsics.areEqual(getAnimation(), animation)) {
            setAnimation(animation);
            setAnimationState(0);
            this.animationSpec = (FiniteAnimationSpec)BoundsAnimationKt.access$getDefaultBoundsAnimation$p();
        }
        setBoundsTransform(boundsTransform);
    }
}
