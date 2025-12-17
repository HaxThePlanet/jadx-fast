package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.ui.MotionDurationScale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* loaded from: classes.dex */
@Deprecated(message = "Please use the snapFlingBehavior function", replaceWith = @ReplaceWith(...))
@Metadata(d1 = "\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0008¢\u0006\u0002\u0010\tJ\u0013\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\u0008\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J:\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001b0\u001a*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00062\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020 0\u001fH\u0082@¢\u0006\u0002\u0010!J.\u0010\"\u001a\u00020\u0006*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00062\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020 0\u001fH\u0096@¢\u0006\u0002\u0010!JQ\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001b0\u001a*\u00020\u001c2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062!\u0010&\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008'\u0012\u0008\u0008(\u0012\u0004\u0008\u0008()\u0012\u0004\u0012\u00020 0\u001fH\u0082@¢\u0006\u0002\u0010*JB\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001b0,*\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020 0\u001fH\u0082@¢\u0006\u0002\u0010*R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR\u0014\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006.", d2 = {"Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "snapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;)V", "motionScaleDuration", "Landroidx/compose/ui/MotionDurationScale;", "getMotionScaleDuration$foundation_release", "()Landroidx/compose/ui/MotionDurationScale;", "setMotionScaleDuration$foundation_release", "(Landroidx/compose/ui/MotionDurationScale;)V", "equals", "", "other", "", "hashCode", "", "isDecayApproachPossible", "offset", "velocity", "fling", "Landroidx/compose/foundation/gestures/snapping/AnimationResult;", "Landroidx/compose/animation/core/AnimationVector1D;", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "onRemainingScrollOffsetUpdate", "Lkotlin/Function1;", "", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performFling", "onRemainingDistanceUpdated", "runApproach", "initialTargetOffset", "onAnimationStep", "Lkotlin/ParameterName;", "name", "delta", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryApproach", "Landroidx/compose/animation/core/AnimationState;", "updateRemainingScrollOffset", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SnapFlingBehavior implements TargetedFlingBehavior {

    public static final int $stable;
    private final DecayAnimationSpec<Float> decayAnimationSpec;
    private MotionDurationScale motionScaleDuration;
    private final AnimationSpec<Float> snapAnimationSpec;
    private final androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider snapLayoutInfoProvider;
    static {
    }

    public SnapFlingBehavior(androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider snapLayoutInfoProvider, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> snapAnimationSpec) {
        super();
        this.snapLayoutInfoProvider = snapLayoutInfoProvider;
        this.decayAnimationSpec = decayAnimationSpec;
        this.snapAnimationSpec = snapAnimationSpec;
        this.motionScaleDuration = ScrollableKt.getDefaultScrollMotionDurationScale();
    }

    public static final Object access$fling(androidx.compose.foundation.gestures.snapping.SnapFlingBehavior $this, ScrollScope $receiver, float initialVelocity, Function1 onRemainingScrollOffsetUpdate, Continuation $completion) {
        return $this.fling($receiver, initialVelocity, onRemainingScrollOffsetUpdate, $completion);
    }

    public static final DecayAnimationSpec access$getDecayAnimationSpec$p(androidx.compose.foundation.gestures.snapping.SnapFlingBehavior $this) {
        return $this.decayAnimationSpec;
    }

    public static final AnimationSpec access$getSnapAnimationSpec$p(androidx.compose.foundation.gestures.snapping.SnapFlingBehavior $this) {
        return $this.snapAnimationSpec;
    }

    public static final androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider access$getSnapLayoutInfoProvider$p(androidx.compose.foundation.gestures.snapping.SnapFlingBehavior $this) {
        return $this.snapLayoutInfoProvider;
    }

    public static final Object access$runApproach(androidx.compose.foundation.gestures.snapping.SnapFlingBehavior $this, ScrollScope $receiver, float initialTargetOffset, float initialVelocity, Function1 onAnimationStep, Continuation $completion) {
        return $this.runApproach($receiver, initialTargetOffset, initialVelocity, onAnimationStep, $completion);
    }

    public static final Object access$tryApproach(androidx.compose.foundation.gestures.snapping.SnapFlingBehavior $this, ScrollScope $receiver, float offset, float velocity, Function1 updateRemainingScrollOffset, Continuation $completion) {
        return $this.tryApproach($receiver, offset, velocity, updateRemainingScrollOffset, $completion);
    }

    private final Object fling(ScrollScope scrollScope, float f2, Function1<? super Float, Unit> function13, Continuation<? super androidx.compose.foundation.gestures.snapping.AnimationResult<Float, AnimationVector1D>> continuation4) {
        boolean anon;
        int i2;
        int i;
        androidx.compose.foundation.gestures.snapping.SnapFlingBehavior.fling.result.1 label;
        androidx.compose.foundation.gestures.snapping.SnapFlingBehavior snapFlingBehavior;
        float f;
        Object function1;
        ScrollScope scrollScope2;
        int i3;
        Object obj9;
        int obj10;
        Object obj12;
        anon = continuation4;
        i = Integer.MIN_VALUE;
        if (continuation4 instanceof SnapFlingBehavior.fling.1 && label2 &= i != 0) {
            anon = continuation4;
            i = Integer.MIN_VALUE;
            if (label2 &= i != 0) {
                anon.label = obj12 -= i;
            } else {
                anon = new SnapFlingBehavior.fling.1(this, continuation4);
            }
        } else {
        }
        obj12 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj12);
                snapFlingBehavior = this;
                function1 = function13;
                label = new SnapFlingBehavior.fling.result.1(snapFlingBehavior, f2, function1, scrollScope, 0);
                anon.L$0 = function1;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
            case 1:
                ResultKt.throwOnFailure(obj12);
                function1 = obj9;
                obj9 = obj12;
                break;
            default:
                obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj9;
        }
        function1.invoke(Boxing.boxFloat(0));
        return (AnimationResult)obj9;
    }

    private final boolean isDecayApproachPossible(float offset, float velocity) {
        int i;
        int i3 = 0;
        i = Float.compare(f, f2) >= 0 ? 1 : 0;
        return i;
    }

    private final Object runApproach(ScrollScope $this$runApproach, float initialTargetOffset, float initialVelocity, Function1<? super Float, Unit> onAnimationStep, Continuation<? super androidx.compose.foundation.gestures.snapping.AnimationResult<Float, AnimationVector1D>> $completion) {
        Object $i$f$debugLog;
        Object decayAnimationSpec;
        if (isDecayApproachPossible(initialTargetOffset, initialVelocity)) {
            int i = 0;
            $i$f$debugLog = new DecayApproachAnimation(this.decayAnimationSpec);
        } else {
            int i2 = 0;
            $i$f$debugLog = new TargetApproachAnimation(this.snapAnimationSpec);
        }
        return SnapFlingBehaviorKt.access$approach($this$runApproach, initialTargetOffset, initialVelocity, $i$f$debugLog, onAnimationStep, $completion);
    }

    private final Object tryApproach(ScrollScope scrollScope, float f2, float f3, Function1<? super Float, Unit> function14, Continuation<? super AnimationState<Float, AnimationVector1D>> continuation5) {
        Object obj;
        boolean anon;
        int i7;
        Object cOROUTINE_SUSPENDED;
        int i;
        int label;
        Function1 function1;
        float f;
        int cmp;
        int i6;
        int i2;
        int i3;
        int i4;
        int i8;
        int i5;
        androidx.compose.foundation.gestures.snapping.SnapFlingBehavior obj13;
        Object obj14;
        float obj16;
        Function1 obj17;
        androidx.compose.foundation.gestures.snapping.SnapFlingBehavior.tryApproach.1 obj18;
        obj = continuation5;
        anon = obj;
        i = Integer.MIN_VALUE;
        if (obj instanceof SnapFlingBehavior.tryApproach.1 && label3 &= i != 0) {
            anon = obj;
            i = Integer.MIN_VALUE;
            if (label3 &= i != 0) {
                anon.label = label2 -= i;
            } else {
                anon = new SnapFlingBehavior.tryApproach.1(this, obj);
            }
        } else {
        }
        Object result = anon.result;
        cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(result);
                label = this;
                function1 = function14;
                f = f3;
                i6 = 0;
                i3 = 1;
                cmp = i3;
                cmp = i2;
                i2 = i3;
                anon.label = i3;
                return cOROUTINE_SUSPENDED;
                label = scrollScope;
                obj14 = snapFlingBehavior;
                cOROUTINE_SUSPENDED = function1;
                obj14 = AnimationStateKt.AnimationState$default(f2, f, 0, i6, false, i3, 0);
                return obj14;
            case 1:
                ResultKt.throwOnFailure(result);
                obj14 = result;
                break;
            default:
                obj14 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj14;
        }
        obj14 = (AnimationResult)obj14.getCurrentAnimationState();
    }

    @Override // androidx.compose.foundation.gestures.TargetedFlingBehavior
    public boolean equals(Object other) {
        boolean equal;
        int i;
        Object snapLayoutInfoProvider;
        i = 0;
        if (other instanceof SnapFlingBehavior) {
            if (Intrinsics.areEqual(obj.snapAnimationSpec, this.snapAnimationSpec) && Intrinsics.areEqual(obj2.decayAnimationSpec, this.decayAnimationSpec) && Intrinsics.areEqual(obj3.snapLayoutInfoProvider, this.snapLayoutInfoProvider)) {
                if (Intrinsics.areEqual(obj2.decayAnimationSpec, this.decayAnimationSpec)) {
                    if (Intrinsics.areEqual(obj3.snapLayoutInfoProvider, this.snapLayoutInfoProvider)) {
                        i = 1;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.foundation.gestures.TargetedFlingBehavior
    public final MotionDurationScale getMotionScaleDuration$foundation_release() {
        return this.motionScaleDuration;
    }

    @Override // androidx.compose.foundation.gestures.TargetedFlingBehavior
    public int hashCode() {
        int i4 = 0;
        int i2 = 0;
        int i3 = 0;
        return i9 += i13;
    }

    public Object performFling(ScrollScope scrollScope, float f2, Function1<? super Float, Unit> function13, Continuation<? super Float> continuation4) {
        boolean anon;
        int i2;
        int i3;
        int label;
        int i;
        Object obj5;
        Object obj6;
        float obj7;
        Object obj8;
        anon = continuation4;
        i3 = Integer.MIN_VALUE;
        if (continuation4 instanceof SnapFlingBehavior.performFling.1 && label2 &= i3 != 0) {
            anon = continuation4;
            i3 = Integer.MIN_VALUE;
            if (label2 &= i3 != 0) {
                anon.label = obj8 -= i3;
            } else {
                anon = new SnapFlingBehavior.performFling.1(this, continuation4);
            }
        } else {
        }
        obj8 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj8);
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
            case 1:
                ResultKt.throwOnFailure(obj8);
                obj5 = obj8;
                break;
            default:
                obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj5;
        }
        obj7 = 0;
        if (Float.compare(obj6, obj7) == 0) {
        } else {
            i = 0;
        }
        if (i != 0) {
        } else {
            obj7 = (Number)obj5.component2().getVelocity().floatValue();
        }
        return Boxing.boxFloat(obj7);
    }

    @Override // androidx.compose.foundation.gestures.TargetedFlingBehavior
    public final void setMotionScaleDuration$foundation_release(MotionDurationScale <set-?>) {
        this.motionScaleDuration = <set-?>;
    }
}
