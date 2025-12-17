package androidx.compose.animation.core;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u0005\u0008f\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003J%\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00028\u00002\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fR\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007R\u0012\u0010\u0008\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0010À\u0006\u0003", d2 = {"Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "delayMillis", "", "getDelayMillis", "()I", "durationMillis", "getDurationMillis", "getDurationNanos", "", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface VectorizedDurationBasedAnimationSpec<V extends androidx.compose.animation.core.AnimationVector>  extends androidx.compose.animation.core.VectorizedFiniteAnimationSpec<V> {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <V extends androidx.compose.animation.core.AnimationVector> long getDurationNanos(androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec<V> $this, V initialValue, V targetValue, V initialVelocity) {
            return VectorizedDurationBasedAnimationSpec.access$getDurationNanos$jd($this, initialValue, targetValue, initialVelocity);
        }

        @Deprecated
        public static <V extends androidx.compose.animation.core.AnimationVector> V getEndVelocity(androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec<V> $this, V initialValue, V targetValue, V initialVelocity) {
            return VectorizedDurationBasedAnimationSpec.access$getEndVelocity$jd($this, initialValue, targetValue, initialVelocity);
        }

        @Deprecated
        public static <V extends androidx.compose.animation.core.AnimationVector> boolean isInfinite(androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec<V> $this) {
            return VectorizedDurationBasedAnimationSpec.access$isInfinite$jd($this);
        }
    }
    public static long access$getDurationNanos$jd(androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec $this, androidx.compose.animation.core.AnimationVector initialValue, androidx.compose.animation.core.AnimationVector targetValue, androidx.compose.animation.core.AnimationVector initialVelocity) {
        return super.getDurationNanos(initialValue, targetValue, initialVelocity);
    }

    public static androidx.compose.animation.core.AnimationVector access$getEndVelocity$jd(androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec $this, androidx.compose.animation.core.AnimationVector initialValue, androidx.compose.animation.core.AnimationVector targetValue, androidx.compose.animation.core.AnimationVector initialVelocity) {
        return super.getEndVelocity(initialValue, targetValue, initialVelocity);
    }

    public static boolean access$isInfinite$jd(androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec $this) {
        return super.isInfinite();
    }

    @Override // androidx.compose.animation.core.VectorizedFiniteAnimationSpec
    public abstract int getDelayMillis();

    @Override // androidx.compose.animation.core.VectorizedFiniteAnimationSpec
    public abstract int getDurationMillis();

    public long getDurationNanos(V initialValue, V targetValue, V initialVelocity) {
        return l *= i3;
    }
}
