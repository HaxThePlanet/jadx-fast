package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\t\n\u0002\u0010\t\n\u0002\u0008\n\u0008\u0002\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001d\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J\u001d\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J%\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001aJ%\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001aR\u0014\u0010\u0007\u001a\u00020\u0008X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0010\u0010\r\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u0010\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u001c", d2 = {"Landroidx/compose/animation/core/VectorizedFloatDecaySpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedDecayAnimationSpec;", "floatDecaySpec", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "(Landroidx/compose/animation/core/FloatDecayAnimationSpec;)V", "absVelocityThreshold", "", "getAbsVelocityThreshold", "()F", "getFloatDecaySpec", "()Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "targetVector", "Landroidx/compose/animation/core/AnimationVector;", "valueVector", "velocityVector", "getDurationNanos", "", "initialValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getTargetValue", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getValueFromNanos", "playTimeNanos", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class VectorizedFloatDecaySpec<V extends androidx.compose.animation.core.AnimationVector>  implements androidx.compose.animation.core.VectorizedDecayAnimationSpec<V> {

    private final float absVelocityThreshold;
    private final androidx.compose.animation.core.FloatDecayAnimationSpec floatDecaySpec;
    private V targetVector;
    private V valueVector;
    private V velocityVector;
    public VectorizedFloatDecaySpec(androidx.compose.animation.core.FloatDecayAnimationSpec floatDecaySpec) {
        super();
        this.floatDecaySpec = floatDecaySpec;
        this.absVelocityThreshold = this.floatDecaySpec.getAbsVelocityThreshold();
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public float getAbsVelocityThreshold() {
        return this.absVelocityThreshold;
    }

    public long getDurationNanos(V initialValue, V initialVelocity) {
        int maxDuration;
        androidx.compose.animation.core.AnimationVector velocityVector;
        int i;
        androidx.compose.animation.core.AnimationVector velocityVector2;
        long l;
        float f;
        float f2;
        maxDuration = 0;
        if (this.velocityVector == null) {
            this.velocityVector = AnimationVectorsKt.newInstance(initialValue);
        }
        i = 0;
        if (this.velocityVector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            velocityVector2 = 0;
        }
        while (i < velocityVector2.getSize$animation_core_release()) {
            f = initialValue.get$animation_core_release(i);
            maxDuration = l;
            i++;
        }
        return maxDuration;
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public final androidx.compose.animation.core.FloatDecayAnimationSpec getFloatDecaySpec() {
        return this.floatDecaySpec;
    }

    public V getTargetValue(V initialValue, V initialVelocity) {
        androidx.compose.animation.core.AnimationVector targetVector2;
        int i;
        androidx.compose.animation.core.AnimationVector targetVector;
        androidx.compose.animation.core.AnimationVector i2;
        androidx.compose.animation.core.AnimationVector targetVector3;
        float targetValue;
        float f;
        float f2;
        if (this.targetVector == null) {
            this.targetVector = AnimationVectorsKt.newInstance(initialValue);
        }
        i = 0;
        i2 = 0;
        final String str = "targetVector";
        if (this.targetVector == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            targetVector = i2;
        }
        while (i < targetVector.getSize$animation_core_release()) {
            if (this.targetVector == null) {
            }
            targetVector3.set$animation_core_release(i, this.floatDecaySpec.getTargetValue(initialValue.get$animation_core_release(i), initialVelocity.get$animation_core_release(i)));
            i++;
            Intrinsics.throwUninitializedPropertyAccessException(str);
            targetVector3 = i2;
        }
        androidx.compose.animation.core.AnimationVector i3 = this.targetVector;
        if (i3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        } else {
            i2 = i3;
        }
        return i2;
    }

    public V getValueFromNanos(long playTimeNanos, V initialValue, V initialVelocity) {
        androidx.compose.animation.core.AnimationVector valueVector3;
        int i;
        androidx.compose.animation.core.AnimationVector valueVector2;
        androidx.compose.animation.core.AnimationVector i2;
        androidx.compose.animation.core.AnimationVector valueVector;
        float valueFromNanos;
        float f;
        float f2;
        if (this.valueVector == null) {
            this.valueVector = AnimationVectorsKt.newInstance(initialVelocity);
        }
        i = 0;
        i2 = 0;
        final String str = "valueVector";
        if (this.valueVector == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            valueVector2 = i2;
        }
        while (i < valueVector2.getSize$animation_core_release()) {
            if (this.valueVector == null) {
            }
            valueVector.set$animation_core_release(i, this.floatDecaySpec.getValueFromNanos(playTimeNanos, initialValue, initialVelocity.get$animation_core_release(i)));
            i++;
            Intrinsics.throwUninitializedPropertyAccessException(str);
            valueVector = i2;
        }
        androidx.compose.animation.core.AnimationVector i3 = this.valueVector;
        if (i3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        } else {
            i2 = i3;
        }
        return i2;
    }

    public V getVelocityFromNanos(long playTimeNanos, V initialValue, V initialVelocity) {
        androidx.compose.animation.core.AnimationVector velocityVector;
        int i2;
        androidx.compose.animation.core.AnimationVector velocityVector3;
        androidx.compose.animation.core.AnimationVector i;
        androidx.compose.animation.core.AnimationVector velocityVector2;
        float velocityFromNanos;
        float f;
        float f2;
        if (this.velocityVector == null) {
            this.velocityVector = AnimationVectorsKt.newInstance(initialVelocity);
        }
        i2 = 0;
        i = 0;
        final String str = "velocityVector";
        if (this.velocityVector == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            velocityVector3 = i;
        }
        while (i2 < velocityVector3.getSize$animation_core_release()) {
            if (this.velocityVector == null) {
            }
            velocityVector2.set$animation_core_release(i2, this.floatDecaySpec.getVelocityFromNanos(playTimeNanos, initialValue, initialVelocity.get$animation_core_release(i2)));
            i2++;
            Intrinsics.throwUninitializedPropertyAccessException(str);
            velocityVector2 = i;
        }
        androidx.compose.animation.core.AnimationVector i3 = this.velocityVector;
        if (i3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        } else {
            i = i3;
        }
        return i;
    }
}
