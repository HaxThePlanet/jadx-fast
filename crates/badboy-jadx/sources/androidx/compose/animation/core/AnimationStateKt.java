package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u001ai\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0002\"\u0004\u0008\u0000\u0010\u0005\"\u0008\u0008\u0001\u0010\u0006*\u00020\u00072\u0012\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\t2\u0006\u0010\n\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u0002H\u00052\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0001¢\u0006\u0002\u0010\u0010\u001aB\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00022\u0006\u0010\n\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0001\u001ak\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0002\"\u0004\u0008\u0000\u0010\u0005\"\u0008\u0008\u0001\u0010\u0006*\u00020\u0007*\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u00022\u0008\u0008\u0002\u0010\u0014\u001a\u0002H\u00052\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u0001H\u00062\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0001¢\u0006\u0002\u0010\u0016\u001aT\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0002*\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00022\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0001\u001a3\u0010\u0018\u001a\u0002H\u0006\"\u0004\u0008\u0000\u0010\u0005\"\u0008\u0008\u0001\u0010\u0006*\u00020\u0007*\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\t2\u0006\u0010\u0014\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0019\"\u001d\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0000\u0010\u0003¨\u0006\u001a", d2 = {"isFinished", "", "Landroidx/compose/animation/core/AnimationState;", "(Landroidx/compose/animation/core/AnimationState;)Z", "AnimationState", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "initialVelocity", "lastFrameTimeNanos", "", "finishedTimeNanos", "isRunning", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;JJZ)Landroidx/compose/animation/core/AnimationState;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "copy", "value", "velocityVector", "(Landroidx/compose/animation/core/AnimationState;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;JJZ)Landroidx/compose/animation/core/AnimationState;", "velocity", "createZeroVectorFrom", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;)Landroidx/compose/animation/core/AnimationVector;", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AnimationStateKt {
    public static final androidx.compose.animation.core.AnimationState<Float, androidx.compose.animation.core.AnimationVector1D> AnimationState(float initialValue, float initialVelocity, long lastFrameTimeNanos, long finishedTimeNanos, boolean isRunning) {
        AnimationState animationState = new AnimationState(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Float.valueOf(initialValue), (AnimationVector)AnimationVectorsKt.AnimationVector(initialVelocity), lastFrameTimeNanos, obj5, isRunning, obj7, obj15);
        return animationState;
    }

    public static final <T, V extends androidx.compose.animation.core.AnimationVector> androidx.compose.animation.core.AnimationState<T, V> AnimationState(androidx.compose.animation.core.TwoWayConverter<T, V> typeConverter, T initialValue, T initialVelocity, long lastFrameTimeNanos, long finishedTimeNanos, boolean isRunning) {
        AnimationState animationState = new AnimationState(typeConverter, initialValue, (AnimationVector)typeConverter.getConvertToVector().invoke(initialVelocity), lastFrameTimeNanos, obj5, isRunning, obj7, obj16);
        return animationState;
    }

    public static androidx.compose.animation.core.AnimationState AnimationState$default(float f, float f2, long l3, long l4, boolean z5, int i6, Object object7) {
        int obj3;
        long obj4;
        long obj6;
        int obj8;
        int obj10;
        if (obj9 & 2 != 0) {
            obj3 = 0;
        }
        final long l = Long.MIN_VALUE;
        if (obj9 & 4 != 0) {
            obj4 = l;
        }
        if (obj9 & 8 != 0) {
            obj6 = l;
        }
        obj9 &= 16;
        obj10 = obj9 != null ? obj8 : object7;
        return AnimationStateKt.AnimationState(f, obj3, obj4, i6, obj6);
    }

    public static androidx.compose.animation.core.AnimationState AnimationState$default(androidx.compose.animation.core.TwoWayConverter twoWayConverter, Object object2, Object object3, long l4, long l5, boolean z6, int i7, Object object8) {
        long obj5;
        long obj7;
        int obj9;
        final long l = Long.MIN_VALUE;
        if (obj10 & 8 != 0) {
            obj5 = l;
        }
        if (obj10 & 16 != 0) {
            obj7 = l;
        }
        if (obj10 &= 32 != 0) {
            obj9 = 0;
        }
        return AnimationStateKt.AnimationState(twoWayConverter, object2, object3, obj5, l5, obj7);
    }

    public static final androidx.compose.animation.core.AnimationState<Float, androidx.compose.animation.core.AnimationVector1D> copy(androidx.compose.animation.core.AnimationState<Float, androidx.compose.animation.core.AnimationVector1D> $this$copy, float value, float velocity, long lastFrameTimeNanos, long finishedTimeNanos, boolean isRunning) {
        AnimationState animationState = new AnimationState($this$copy.getTypeConverter(), Float.valueOf(value), (AnimationVector)AnimationVectorsKt.AnimationVector(velocity), lastFrameTimeNanos, obj5, isRunning, obj7, obj16);
        return animationState;
    }

    public static final <T, V extends androidx.compose.animation.core.AnimationVector> androidx.compose.animation.core.AnimationState<T, V> copy(androidx.compose.animation.core.AnimationState<T, V> $this$copy, T value, V velocityVector, long lastFrameTimeNanos, long finishedTimeNanos, boolean isRunning) {
        AnimationState animationState = new AnimationState($this$copy.getTypeConverter(), value, velocityVector, lastFrameTimeNanos, obj5, isRunning, obj7, obj16);
        return animationState;
    }

    public static androidx.compose.animation.core.AnimationState copy$default(androidx.compose.animation.core.AnimationState animationState, float f2, float f3, long l4, long l5, boolean z6, int i7, Object object8) {
        float obj1;
        float obj2;
        long obj3;
        long obj5;
        boolean obj7;
        boolean obj9;
        if (obj8 & 1 != 0) {
            obj1 = (Number)animationState.getValue().floatValue();
        }
        if (obj8 & 2 != 0) {
            obj2 = (AnimationVector1D)animationState.getVelocityVector().getValue();
        }
        if (obj8 & 4 != 0) {
            obj3 = animationState.getLastFrameTimeNanos();
        }
        if (obj8 & 8 != 0) {
            obj5 = animationState.getFinishedTimeNanos();
        }
        obj8 &= 16;
        if (obj8 != null) {
            obj9 = obj7;
        } else {
            obj9 = object8;
        }
        return AnimationStateKt.copy(animationState, obj1, obj2, obj3, i7, obj5);
    }

    public static androidx.compose.animation.core.AnimationState copy$default(androidx.compose.animation.core.AnimationState animationState, Object object2, androidx.compose.animation.core.AnimationVector animationVector3, long l4, long l5, boolean z6, int i7, Object object8) {
        Object obj1;
        androidx.compose.animation.core.AnimationVector obj2;
        long obj3;
        long obj5;
        boolean obj7;
        boolean obj9;
        if (obj8 & 1 != 0) {
            obj1 = animationState.getValue();
        }
        if (obj8 & 2 != 0) {
            obj2 = AnimationVectorsKt.copy(animationState.getVelocityVector());
        }
        if (obj8 & 4 != 0) {
            obj3 = animationState.getLastFrameTimeNanos();
        }
        if (obj8 & 8 != 0) {
            obj5 = animationState.getFinishedTimeNanos();
        }
        obj8 &= 16;
        if (obj8 != null) {
            obj9 = obj7;
        } else {
            obj9 = object8;
        }
        return AnimationStateKt.copy(animationState, obj1, obj2, obj3, i7, obj5);
    }

    public static final <T, V extends androidx.compose.animation.core.AnimationVector> V createZeroVectorFrom(androidx.compose.animation.core.TwoWayConverter<T, V> $this$createZeroVectorFrom, T value) {
        Object invoke = $this$createZeroVectorFrom.getConvertToVector().invoke(value);
        final int i = 0;
        (AnimationVector)invoke.reset$animation_core_release();
        return (AnimationVector)invoke;
    }

    public static final boolean isFinished(androidx.compose.animation.core.AnimationState<?, ?> $this$isFinished) {
        int i;
        i = Long.compare(finishedTimeNanos, l) != 0 ? 1 : 0;
        return i;
    }
}
