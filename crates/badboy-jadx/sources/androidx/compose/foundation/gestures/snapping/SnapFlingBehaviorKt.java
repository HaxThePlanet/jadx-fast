package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref.FloatRef;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0080\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a*\u0010\n\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u00082\u0006\u0010\u000e\u001a\u00020\u0008H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u000f\u0010\u0010\u001a\u0017\u0010\u0011\u001a\u00020\u00122\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u0014H\u0082\u0008\u001a\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010\u001a\u001a*\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u000c\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u001d2\u000c\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u001f\u001ak\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\"0!*\u00020#2\u0006\u0010$\u001a\u00020\u00082\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\"0&2\u000c\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u001d2!\u0010'\u001a\u001d\u0012\u0013\u0012\u00110\u0008¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(+\u0012\u0004\u0012\u00020\u00120(H\u0082@¢\u0006\u0002\u0010,\u001as\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\"0!*\u00020#2\u0006\u0010$\u001a\u00020\u00082\u0006\u0010.\u001a\u00020\u00082\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\"0&2\u000c\u0010/\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u001f2!\u0010'\u001a\u001d\u0012\u0013\u0012\u00110\u0008¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(+\u0012\u0004\u0012\u00020\u00120(H\u0082@¢\u0006\u0002\u00100\u001ae\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\"0!*\u00020#2\u0006\u00102\u001a\u00020\u00082\u0006\u00103\u001a\u00020\u00082\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\"052!\u0010'\u001a\u001d\u0012\u0013\u0012\u00110\u0008¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(+\u0012\u0004\u0012\u00020\u00120(H\u0082@¢\u0006\u0002\u00106\u001a\u0014\u00107\u001a\u00020\u0008*\u00020\u00082\u0006\u00108\u001a\u00020\u0008H\u0002\u001a(\u00109\u001a\u0002H:\"\u000e\u0008\u0000\u0010:*\u0008\u0012\u0004\u0012\u0002H:0;*\u0008\u0012\u0004\u0012\u0002H:0<H\u0082\u0002¢\u0006\u0002\u0010=\u001a(\u0010>\u001a\u0002H:\"\u000e\u0008\u0000\u0010:*\u0008\u0012\u0004\u0012\u0002H:0;*\u0008\u0012\u0004\u0012\u0002H:0<H\u0082\u0002¢\u0006\u0002\u0010=\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\u0008\u0004\u0010\u0005\"\u000e\u0010\u0007\u001a\u00020\u0008X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0008X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006?", d2 = {"DEBUG", "", "MinFlingVelocityDp", "Landroidx/compose/ui/unit/Dp;", "getMinFlingVelocityDp", "()F", "F", "NoDistance", "", "NoVelocity", "calculateFinalOffset", "snappingOffset", "Landroidx/compose/foundation/gestures/snapping/FinalSnappingItem;", "lowerBound", "upperBound", "calculateFinalOffset-Fhqu1e0", "(IFF)F", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "rememberSnapFlingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "snapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "(Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "snapFlingBehavior", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "animateDecay", "Landroidx/compose/foundation/gestures/snapping/AnimationResult;", "Landroidx/compose/animation/core/AnimationVector1D;", "Landroidx/compose/foundation/gestures/ScrollScope;", "targetOffset", "animationState", "Landroidx/compose/animation/core/AnimationState;", "onAnimationStep", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "delta", "(Landroidx/compose/foundation/gestures/ScrollScope;FLandroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateWithTarget", "cancelOffset", "animationSpec", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLandroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "approach", "initialTargetOffset", "initialVelocity", "animation", "Landroidx/compose/foundation/gestures/snapping/ApproachAnimation;", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLandroidx/compose/foundation/gestures/snapping/ApproachAnimation;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coerceToTarget", "target", "component1", "T", "", "Lkotlin/ranges/ClosedFloatingPointRange;", "(Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "component2", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SnapFlingBehaviorKt {

    private static final boolean DEBUG = false;
    private static final float MinFlingVelocityDp;
    public static final float NoDistance;
    public static final float NoVelocity;
    static {
        final int i2 = 0;
        SnapFlingBehaviorKt.MinFlingVelocityDp = Dp.constructor-impl((float)i);
    }

    public static final Object access$animateDecay(ScrollScope $receiver, float targetOffset, AnimationState animationState, DecayAnimationSpec decayAnimationSpec, Function1 onAnimationStep, Continuation $completion) {
        return SnapFlingBehaviorKt.animateDecay($receiver, targetOffset, animationState, decayAnimationSpec, onAnimationStep, $completion);
    }

    public static final void access$animateDecay$consumeDelta(AnimationScope $receiver, ScrollScope $this_animateDecay, Function1 $onAnimationStep, float delta) {
        SnapFlingBehaviorKt.animateDecay$consumeDelta($receiver, $this_animateDecay, $onAnimationStep, delta);
    }

    public static final Object access$animateWithTarget(ScrollScope $receiver, float targetOffset, float cancelOffset, AnimationState animationState, AnimationSpec animationSpec, Function1 onAnimationStep, Continuation $completion) {
        return SnapFlingBehaviorKt.animateWithTarget($receiver, targetOffset, cancelOffset, animationState, animationSpec, onAnimationStep, $completion);
    }

    public static final Object access$approach(ScrollScope $receiver, float initialTargetOffset, float initialVelocity, androidx.compose.foundation.gestures.snapping.ApproachAnimation animation, Function1 onAnimationStep, Continuation $completion) {
        return SnapFlingBehaviorKt.approach($receiver, initialTargetOffset, initialVelocity, animation, onAnimationStep, $completion);
    }

    public static final float access$coerceToTarget(float $receiver, float target) {
        return SnapFlingBehaviorKt.coerceToTarget($receiver, target);
    }

    private static final Object animateDecay(ScrollScope scrollScope, float f2, AnimationState<Float, AnimationVector1D> animationState3, DecayAnimationSpec<Float> decayAnimationSpec4, Function1<? super Float, Unit> function15, Continuation<? super androidx.compose.foundation.gestures.snapping.AnimationResult<Float, AnimationVector1D>> continuation6) {
        boolean anon;
        int i2;
        int i5;
        Ref.FloatRef floatRef;
        int i4;
        int i;
        int i3;
        androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt.animateDecay.2 anon2;
        float obj6;
        Object obj7;
        Object obj8;
        Object obj11;
        anon = continuation6;
        i5 = Integer.MIN_VALUE;
        if (continuation6 instanceof SnapFlingBehaviorKt.animateDecay.1 && label &= i5 != 0) {
            anon = continuation6;
            i5 = Integer.MIN_VALUE;
            if (label &= i5 != 0) {
                anon.label = obj11 -= i5;
            } else {
                anon = new SnapFlingBehaviorKt.animateDecay.1(continuation6);
            }
        } else {
        }
        obj11 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (floatRef) {
            case 0:
                ResultKt.throwOnFailure(obj11);
                floatRef = new Ref.FloatRef();
                i3 = 1;
                i4 = i3;
                i4 = 0;
                anon2 = new SnapFlingBehaviorKt.animateDecay.2(f2, floatRef, scrollScope, function15);
                anon.L$0 = animationState3;
                anon.L$1 = floatRef;
                anon.F$0 = f2;
                anon.label = i3;
                return cOROUTINE_SUSPENDED;
                obj6 = f2;
                obj7 = floatRef;
                break;
            case 1:
                obj6 = anon.F$0;
                obj7 = anon.L$1;
                obj8 = anon.L$0;
                ResultKt.throwOnFailure(obj11);
                break;
            default:
                obj6 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj6;
        }
        int obj9 = 0;
        obj9 = new AnimationResult(Boxing.boxFloat(obj6 - obj10), obj8);
        return obj9;
    }

    private static final void animateDecay$consumeDelta(AnimationScope<Float, AnimationVector1D> $this$animateDecay_u24consumeDelta, ScrollScope $this_animateDecay, Function1<? super Float, Unit> $onAnimationStep, float delta) {
        final float scrollBy = $this_animateDecay.scrollBy(delta);
        $onAnimationStep.invoke(Float.valueOf(scrollBy));
        if (Float.compare(f, i2) > 0) {
            $this$animateDecay_u24consumeDelta.cancelAnimation();
        }
    }

    private static final Object animateWithTarget(ScrollScope scrollScope, float f2, float f3, AnimationState<Float, AnimationVector1D> animationState4, AnimationSpec<Float> animationSpec5, Function1<? super Float, Unit> function16, Continuation<? super androidx.compose.foundation.gestures.snapping.AnimationResult<Float, AnimationVector1D>> continuation7) {
        Object obj2;
        boolean animateTo;
        int i;
        float f$1;
        int i4;
        androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt.animateWithTarget.1 $this$animateWithTarget;
        Object l$1;
        Object l$0;
        float f;
        Object obj;
        Function1 function1;
        Ref.FloatRef floatRef;
        float floatValue;
        Float boxFloat;
        int i5;
        int i3;
        int i2;
        androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt.animateWithTarget.2 anon;
        Object obj17;
        Float obj18;
        AnimationSpec obj19;
        int obj20;
        androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt.animateWithTarget.2 obj21;
        androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt.animateWithTarget.1 obj22;
        obj2 = continuation7;
        animateTo = obj2;
        i4 = Integer.MIN_VALUE;
        if (obj2 instanceof SnapFlingBehaviorKt.animateWithTarget.1 && label2 &= i4 != 0) {
            animateTo = obj2;
            i4 = Integer.MIN_VALUE;
            if (label2 &= i4 != 0) {
                animateTo.label = label -= i4;
            } else {
                animateTo = new SnapFlingBehaviorKt.animateWithTarget.1(obj2);
            }
        } else {
        }
        Object result = animateTo.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure(result);
                f = f2;
                Object obj3 = animationState4;
                floatRef = new Ref.FloatRef();
                floatValue = (Number)obj3.getVelocity().floatValue();
                i2 = 1;
                i5 = i2;
                i5 = 0;
                anon = new SnapFlingBehaviorKt.animateWithTarget.2(f3, floatRef, scrollScope, function16);
                animateTo.L$0 = obj3;
                animateTo.L$1 = floatRef;
                animateTo.F$0 = f;
                animateTo.F$1 = floatValue;
                animateTo.label = i2;
                obj22 = animateTo;
                obj17 = obj3;
                $this$animateWithTarget = obj22;
                return cOROUTINE_SUSPENDED;
                l$1 = floatRef;
                f$1 = floatValue;
                obj = l$0;
                break;
            case 1:
                f$1 = animateTo.F$1;
                l$1 = animateTo.L$1;
                ResultKt.throwOnFailure(result);
                f = f$0;
                $this$animateWithTarget = animateTo;
                obj = l$0;
                break;
            default:
                androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt.animateWithTarget.1 anon2 = animateTo;
                IllegalStateException $result2 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw $result2;
        }
        int i6 = 0;
        AnimationResult animationResult = new AnimationResult(Boxing.boxFloat(f - element), AnimationStateKt.copy$default(obj, 0, SnapFlingBehaviorKt.coerceToTarget((Number)obj.getVelocity().floatValue(), f$1), 0, boxFloat, false, i2, 0));
        return animationResult;
    }

    private static final Object approach(ScrollScope $this$approach, float initialTargetOffset, float initialVelocity, androidx.compose.foundation.gestures.snapping.ApproachAnimation<Float, AnimationVector1D> animation, Function1<? super Float, Unit> onAnimationStep, Continuation<? super androidx.compose.foundation.gestures.snapping.AnimationResult<Float, AnimationVector1D>> $completion) {
        return animation.approachAnimation($this$approach, Boxing.boxFloat(initialTargetOffset), Boxing.boxFloat(initialVelocity), onAnimationStep, $completion);
    }

    public static final float calculateFinalOffset-Fhqu1e0(int snappingOffset, float lowerBound, float upperBound) {
        int cmp;
        float f2;
        int i;
        float f;
        int i2 = 0;
        if (FinalSnappingItem.equals-impl0(snappingOffset, FinalSnappingItem.Companion.getClosestItem-bbeMdSM())) {
            if (Float.compare(f3, f) <= 0) {
                f2 = upperBound;
            } else {
                f2 = lowerBound;
            }
        } else {
            if (FinalSnappingItem.equals-impl0(snappingOffset, FinalSnappingItem.Companion.getNextItem-bbeMdSM())) {
            } else {
                if (FinalSnappingItem.equals-impl0(snappingOffset, FinalSnappingItem.Companion.getPreviousItem-bbeMdSM())) {
                } else {
                    f2 = i;
                }
            }
        }
        if (SnapFlingBehaviorKt.calculateFinalOffset_Fhqu1e0$isValidDistance(f2)) {
            i = f2;
        } else {
        }
        return i;
    }

    private static final boolean calculateFinalOffset_Fhqu1e0$isValidDistance(float $this$calculateFinalOffset_Fhqu1e0_u24isValidDistance) {
        int i2;
        int i;
        i = 1;
        final int i5 = 0;
        i2 = Float.compare($this$calculateFinalOffset_Fhqu1e0_u24isValidDistance, i3) == 0 ? i : i5;
        if (i2 == 0) {
            i2 = Float.compare($this$calculateFinalOffset_Fhqu1e0_u24isValidDistance, i4) == 0 ? i : i5;
            if (i2 == 0) {
            } else {
                i = i5;
            }
        } else {
        }
        return i;
    }

    private static final float coerceToTarget(float $this$coerceToTarget, float target) {
        float coerceAtLeast;
        int i;
        int i2 = 0;
        i = Float.compare(target, i2) == 0 ? 1 : 0;
        if (i != 0) {
            return i2;
        }
        if (Float.compare(target, i2) > 0) {
            coerceAtLeast = RangesKt.coerceAtMost($this$coerceToTarget, target);
        } else {
            coerceAtLeast = RangesKt.coerceAtLeast($this$coerceToTarget, target);
        }
        return coerceAtLeast;
    }

    private static final <T extends Comparable<? super T>> T component1(ClosedFloatingPointRange<T> $this$component1) {
        return $this$component1.getStart();
    }

    private static final <T extends Comparable<? super T>> T component2(ClosedFloatingPointRange<T> $this$component2) {
        return $this$component2.getEndInclusive();
    }

    private static final void debugLog(Function0<String> generateMsg) {
        final int i = 0;
    }

    public static final float getMinFlingVelocityDp() {
        return SnapFlingBehaviorKt.MinFlingVelocityDp;
    }

    public static final TargetedFlingBehavior rememberSnapFlingBehavior(androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider snapLayoutInfoProvider, Composer $composer, int $changed) {
        boolean traceInProgress;
        int i2;
        String str;
        boolean changed;
        Object $i$a$CacheSnapFlingBehaviorKt$rememberSnapFlingBehavior$1;
        Object empty;
        androidx.compose.animation.core.SpringSpec spring$default;
        int i;
        int i3;
        int i4;
        int i5 = -1921733134;
        ComposerKt.sourceInformationMarkerStart($composer, i5, "C(rememberSnapFlingBehavior)257@10415L7,258@10485L26,259@10523L340:SnapFlingBehavior.kt#ppz6w6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i5, $changed, -1, "androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior (SnapFlingBehavior.kt:256)");
        }
        int i6 = 0;
        int i9 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($composer);
        DecayAnimationSpec rememberSplineBasedDecay = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay($composer, 0);
        ComposerKt.sourceInformationMarkerStart($composer, 962717891, "CC(remember):SnapFlingBehavior.kt#9igjgp");
        int i13 = 4;
        if (i12 ^= 6 > i13) {
            if (!$composer.changed(snapLayoutInfoProvider)) {
                if ($changed & 6 == i13) {
                    i2 = 1;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i14 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i15 = 0;
        if (i7 |= changed3 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                int i16 = 0;
                i4 = 0;
                composer.updateRememberedValue(SnapFlingBehaviorKt.snapFlingBehavior(snapLayoutInfoProvider, rememberSplineBasedDecay, (AnimationSpec)AnimationSpecKt.spring$default(0, 1137180672, i4, 5, i4)));
            } else {
                $i$a$CacheSnapFlingBehaviorKt$rememberSnapFlingBehavior$1 = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (TargetedFlingBehavior)$i$a$CacheSnapFlingBehaviorKt$rememberSnapFlingBehavior$1;
    }

    public static final TargetedFlingBehavior snapFlingBehavior(androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider snapLayoutInfoProvider, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> snapAnimationSpec) {
        SnapFlingBehavior snapFlingBehavior = new SnapFlingBehavior(snapLayoutInfoProvider, decayAnimationSpec, snapAnimationSpec);
        return (TargetedFlingBehavior)snapFlingBehavior;
    }
}
