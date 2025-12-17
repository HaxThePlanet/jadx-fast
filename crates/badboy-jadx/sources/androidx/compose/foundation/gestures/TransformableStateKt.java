package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref.FloatRef;
import kotlin.jvm.internal.Ref.LongRef;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001aS\u0010\u0000\u001a\u00020\u00012K\u0010\u0002\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0013\u0012\u00110\u0008¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\n\u0012\u0004\u0012\u00020\u000b0\u0003\u001aZ\u0010\u000c\u001a\u00020\u00012K\u0010\u0002\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0013\u0012\u00110\u0008¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\n\u0012\u0004\u0012\u00020\u000b0\u0003H\u0007¢\u0006\u0002\u0010\r\u001a/\u0010\u000e\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00082\u000e\u0008\u0002\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0011H\u0086@ø\u0001\u0000¢\u0006\u0004\u0008\u0012\u0010\u0013\u001a*\u0010\u0014\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00042\u000e\u0008\u0002\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0011H\u0086@¢\u0006\u0002\u0010\u0016\u001a*\u0010\u0017\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00042\u000e\u0008\u0002\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0011H\u0086@¢\u0006\u0002\u0010\u0016\u001a\u001f\u0010\u0019\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0008H\u0086@ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001b\u001a\u001a\u0010\u001c\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u001d\u001a\u001c\u0010\u001e\u001a\u00020\u000b*\u00020\u00012\u0008\u0008\u0002\u0010\u001f\u001a\u00020 H\u0086@¢\u0006\u0002\u0010!\u001a\u001a\u0010\"\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u001d\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006#", d2 = {"TransformableState", "Landroidx/compose/foundation/gestures/TransformableState;", "onTransformation", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "zoomChange", "Landroidx/compose/ui/geometry/Offset;", "panChange", "rotationChange", "", "rememberTransformableState", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/TransformableState;", "animatePanBy", "offset", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "animatePanBy-ubNVwUQ", "(Landroidx/compose/foundation/gestures/TransformableState;JLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateRotateBy", "degrees", "(Landroidx/compose/foundation/gestures/TransformableState;FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateZoomBy", "zoomFactor", "panBy", "panBy-d-4ec7I", "(Landroidx/compose/foundation/gestures/TransformableState;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rotateBy", "(Landroidx/compose/foundation/gestures/TransformableState;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopTransformation", "terminationPriority", "Landroidx/compose/foundation/MutatePriority;", "(Landroidx/compose/foundation/gestures/TransformableState;Landroidx/compose/foundation/MutatePriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zoomBy", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TransformableStateKt {
    public static final androidx.compose.foundation.gestures.TransformableState TransformableState(Function3<? super Float, ? super Offset, ? super Float, Unit> onTransformation) {
        DefaultTransformableState defaultTransformableState = new DefaultTransformableState(onTransformation);
        return (TransformableState)defaultTransformableState;
    }

    public static final Object animatePanBy-ubNVwUQ(androidx.compose.foundation.gestures.TransformableState $this$animatePanBy_u2dubNVwUQ, long offset, AnimationSpec<Offset> animationSpec, Continuation<? super Unit> $completion) {
        Ref.LongRef longRef = new Ref.LongRef();
        final Ref.LongRef num = longRef;
        num.element = Offset.Companion.getZero-F1C5BW0();
        TransformableStateKt.animatePanBy.2 anon = new TransformableStateKt.animatePanBy.2(num, offset, obj4, $completion, 0);
        Object transform$default = TransformableState.transform$default($this$animatePanBy_u2dubNVwUQ, 0, (Function2)anon, obj13, 1, 0);
        if (transform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return transform$default;
        }
        return Unit.INSTANCE;
    }

    public static Object animatePanBy-ubNVwUQ$default(androidx.compose.foundation.gestures.TransformableState transformableState, long l2, AnimationSpec animationSpec3, Continuation continuation4, int i5, Object object6) {
        SpringSpec springSpec;
        int i6;
        int i2;
        int i;
        int i3;
        int i4;
        SpringSpec obj9;
        if (object6 &= 2 != 0) {
            springSpec = new SpringSpec(0, 1128792064, 0, 5, 0);
            obj9 = springSpec;
        }
        return TransformableStateKt.animatePanBy-ubNVwUQ(transformableState, l2, animationSpec3, obj9);
    }

    public static final Object animateRotateBy(androidx.compose.foundation.gestures.TransformableState $this$animateRotateBy, float degrees, AnimationSpec<Float> animationSpec, Continuation<? super Unit> $completion) {
        Ref.FloatRef floatRef = new Ref.FloatRef();
        TransformableStateKt.animateRotateBy.2 anon = new TransformableStateKt.animateRotateBy.2(floatRef, degrees, animationSpec, 0);
        Object obj9 = TransformableState.transform$default($this$animateRotateBy, 0, (Function2)anon, $completion, 1, 0);
        if (obj9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj9;
        }
        return Unit.INSTANCE;
    }

    public static Object animateRotateBy$default(androidx.compose.foundation.gestures.TransformableState transformableState, float f2, AnimationSpec animationSpec3, Continuation continuation4, int i5, Object object6) {
        SpringSpec springSpec;
        int i3;
        int i;
        int i6;
        int i2;
        int i4;
        SpringSpec obj8;
        if (i5 &= 2 != 0) {
            springSpec = new SpringSpec(0, 1128792064, 0, 5, 0);
            obj8 = springSpec;
        }
        return TransformableStateKt.animateRotateBy(transformableState, f2, obj8, continuation4);
    }

    public static final Object animateZoomBy(androidx.compose.foundation.gestures.TransformableState $this$animateZoomBy, float zoomFactor, AnimationSpec<Float> animationSpec, Continuation<? super Unit> $completion) {
        int i;
        i = Float.compare(zoomFactor, i2) > 0 ? 1 : 0;
        if (i == 0) {
        } else {
            Ref.FloatRef floatRef = new Ref.FloatRef();
            floatRef.element = 1065353216;
            TransformableStateKt.animateZoomBy.3 anon = new TransformableStateKt.animateZoomBy.3(floatRef, zoomFactor, animationSpec, 0);
            Object obj9 = TransformableState.transform$default($this$animateZoomBy, 0, (Function2)anon, $completion, 1, 0);
            if (obj9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return obj9;
            }
            return Unit.INSTANCE;
        }
        androidx.compose.foundation.gestures.TransformableState $this$animateZoomBy2 = $this$animateZoomBy;
        Continuation continuation = $completion;
        obj9 = 0;
        obj9 = new IllegalArgumentException("zoom value should be greater than 0".toString());
        throw obj9;
    }

    public static Object animateZoomBy$default(androidx.compose.foundation.gestures.TransformableState transformableState, float f2, AnimationSpec animationSpec3, Continuation continuation4, int i5, Object object6) {
        SpringSpec springSpec;
        int i3;
        int i;
        int i4;
        int i2;
        int i6;
        SpringSpec obj8;
        if (i5 &= 2 != 0) {
            springSpec = new SpringSpec(0, 1128792064, 0, 5, 0);
            obj8 = springSpec;
        }
        return TransformableStateKt.animateZoomBy(transformableState, f2, obj8, continuation4);
    }

    public static final Object panBy-d-4ec7I(androidx.compose.foundation.gestures.TransformableState $this$panBy_u2dd_u2d4ec7I, long offset, Continuation<? super Unit> $completion) {
        TransformableStateKt.panBy.2 anon = new TransformableStateKt.panBy.2(offset, $completion, 0);
        Object obj8 = TransformableState.transform$default($this$panBy_u2dd_u2d4ec7I, 0, (Function2)anon, obj11, 1, 0);
        if (obj8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj8;
        }
        return Unit.INSTANCE;
    }

    public static final androidx.compose.foundation.gestures.TransformableState rememberTransformableState(Function3<? super Float, ? super Offset, ? super Float, Unit> onTransformation, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        Object $i$a$CacheTransformableStateKt$rememberTransformableState$1;
        androidx.compose.foundation.gestures.TransformableStateKt.rememberTransformableState.1.1 anon;
        int i = 1681419281;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(rememberTransformableState)117@5191L38,118@5241L80:TransformableState.kt#8bwon0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.gestures.rememberTransformableState (TransformableState.kt:116)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -586916430, "CC(remember):TransformableState.kt#9igjgp");
        int i4 = 0;
        Composer composer = $composer;
        final int i5 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i6 = 0;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            int i7 = 0;
            anon = new TransformableStateKt.rememberTransformableState.1.1(SnapshotStateKt.rememberUpdatedState(onTransformation, $composer, $changed & 14));
            composer.updateRememberedValue(TransformableStateKt.TransformableState((Function3)anon));
        } else {
            $i$a$CacheTransformableStateKt$rememberTransformableState$1 = rememberedValue;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (TransformableState)$i$a$CacheTransformableStateKt$rememberTransformableState$1;
    }

    public static final Object rotateBy(androidx.compose.foundation.gestures.TransformableState $this$rotateBy, float degrees, Continuation<? super Unit> $completion) {
        TransformableStateKt.rotateBy.2 anon = new TransformableStateKt.rotateBy.2(degrees, 0);
        Object obj8 = TransformableState.transform$default($this$rotateBy, 0, (Function2)anon, $completion, 1, 0);
        if (obj8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj8;
        }
        return Unit.INSTANCE;
    }

    public static final Object stopTransformation(androidx.compose.foundation.gestures.TransformableState $this$stopTransformation, MutatePriority terminationPriority, Continuation<? super Unit> $completion) {
        TransformableStateKt.stopTransformation.2 anon = new TransformableStateKt.stopTransformation.2(0);
        Object transform = $this$stopTransformation.transform(terminationPriority, (Function2)anon, $completion);
        if (transform == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return transform;
        }
        return Unit.INSTANCE;
    }

    public static Object stopTransformation$default(androidx.compose.foundation.gestures.TransformableState transformableState, MutatePriority mutatePriority2, Continuation continuation3, int i4, Object object5) {
        MutatePriority obj1;
        if (i4 &= 1 != 0) {
            obj1 = MutatePriority.Default;
        }
        return TransformableStateKt.stopTransformation(transformableState, obj1, continuation3);
    }

    public static final Object zoomBy(androidx.compose.foundation.gestures.TransformableState $this$zoomBy, float zoomFactor, Continuation<? super Unit> $completion) {
        TransformableStateKt.zoomBy.2 anon = new TransformableStateKt.zoomBy.2(zoomFactor, 0);
        Object obj8 = TransformableState.transform$default($this$zoomBy, 0, (Function2)anon, $completion, 1, 0);
        if (obj8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj8;
        }
        return Unit.INSTANCE;
    }
}
