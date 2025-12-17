package androidx.compose.animation.core;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H&J \u0010\u0008\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H&J(\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H&J,\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\r\"\u0008\u0008\u0000\u0010\u000e*\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u000e0\u0011H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0012À\u0006\u0003", d2 = {"Landroidx/compose/animation/core/FloatAnimationSpec;", "Landroidx/compose/animation/core/AnimationSpec;", "", "getDurationNanos", "", "initialValue", "targetValue", "initialVelocity", "getEndVelocity", "getValueFromNanos", "playTimeNanos", "getVelocityFromNanos", "vectorize", "Landroidx/compose/animation/core/VectorizedFloatAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FloatAnimationSpec extends androidx.compose.animation.core.AnimationSpec<Float> {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static float getEndVelocity(androidx.compose.animation.core.FloatAnimationSpec $this, float initialValue, float targetValue, float initialVelocity) {
            return FloatAnimationSpec.access$getEndVelocity$jd($this, initialValue, targetValue, initialVelocity);
        }

        @Deprecated
        public static <V extends androidx.compose.animation.core.AnimationVector> androidx.compose.animation.core.VectorizedFloatAnimationSpec<V> vectorize(androidx.compose.animation.core.FloatAnimationSpec $this, androidx.compose.animation.core.TwoWayConverter<Float, V> converter) {
            return FloatAnimationSpec.access$vectorize$jd($this, converter);
        }
    }
    public static float access$getEndVelocity$jd(androidx.compose.animation.core.FloatAnimationSpec $this, float initialValue, float targetValue, float initialVelocity) {
        return super.getEndVelocity(initialValue, targetValue, initialVelocity);
    }

    public static androidx.compose.animation.core.VectorizedFloatAnimationSpec access$vectorize$jd(androidx.compose.animation.core.FloatAnimationSpec $this, androidx.compose.animation.core.TwoWayConverter converter) {
        return super.vectorize(converter);
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public abstract long getDurationNanos(float f, float f2, float f3);

    @Override // androidx.compose.animation.core.AnimationSpec
    public float getEndVelocity(float initialValue, float targetValue, float initialVelocity) {
        return this.getVelocityFromNanos(getDurationNanos(initialValue, targetValue, initialVelocity), obj2, initialValue, targetValue);
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public abstract float getValueFromNanos(long l, float f2, float f3, float f4);

    @Override // androidx.compose.animation.core.AnimationSpec
    public abstract float getVelocityFromNanos(long l, float f2, float f3, float f4);

    @Override // androidx.compose.animation.core.AnimationSpec
    public androidx.compose.animation.core.VectorizedAnimationSpec vectorize(androidx.compose.animation.core.TwoWayConverter converter) {
        return (VectorizedAnimationSpec)vectorize(converter);
    }

    public <V extends androidx.compose.animation.core.AnimationVector> androidx.compose.animation.core.VectorizedFloatAnimationSpec<V> vectorize(androidx.compose.animation.core.TwoWayConverter<Float, V> converter) {
        VectorizedFloatAnimationSpec vectorizedFloatAnimationSpec = new VectorizedFloatAnimationSpec(this);
        return vectorizedFloatAnimationSpec;
    }
}
