package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u001a1\u0010\u0002\u001a\u00020\u0003\"\u0008\u0008\u0000\u0010\u0004*\u00020\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u0001H\u00042\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0008H\u0002¢\u0006\u0002\u0010\n\u001a\u0018\u0010\u000b\u001a\u00020\u000c*\u0006\u0012\u0002\u0008\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000cH\u0000\u001a9\u0010\u000f\u001a\u00020\u000c\"\u0008\u0008\u0000\u0010\u0004*\u00020\u0005*\u0008\u0012\u0004\u0012\u0002H\u00040\u00102\u0006\u0010\u0011\u001a\u0002H\u00042\u0006\u0010\u0012\u001a\u0002H\u00042\u0006\u0010\u0013\u001a\u0002H\u0004H\u0000¢\u0006\u0002\u0010\u0014\u001aA\u0010\u0015\u001a\u0002H\u0004\"\u0008\u0008\u0000\u0010\u0004*\u00020\u0005*\u0008\u0012\u0004\u0012\u0002H\u00040\u00102\u0006\u0010\u0016\u001a\u00020\u000c2\u0006\u0010\u0017\u001a\u0002H\u00042\u0006\u0010\u0018\u001a\u0002H\u00042\u0006\u0010\u0019\u001a\u0002H\u0004H\u0000¢\u0006\u0002\u0010\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b", d2 = {"InfiniteIterations", "", "createSpringAnimations", "Landroidx/compose/animation/core/Animations;", "V", "Landroidx/compose/animation/core/AnimationVector;", "visibilityThreshold", "dampingRatio", "", "stiffness", "(Landroidx/compose/animation/core/AnimationVector;FF)Landroidx/compose/animation/core/Animations;", "clampPlayTime", "", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "playTime", "getDurationMillis", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getValueFromMillis", "playTimeMillis", "start", "end", "startVelocity", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class VectorizedAnimationSpecKt {

    private static final int InfiniteIterations = Integer.MAX_VALUE;
    public static final androidx.compose.animation.core.Animations access$createSpringAnimations(androidx.compose.animation.core.AnimationVector visibilityThreshold, float dampingRatio, float stiffness) {
        return VectorizedAnimationSpecKt.createSpringAnimations(visibilityThreshold, dampingRatio, stiffness);
    }

    public static final long clampPlayTime(androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec<?> $this$clampPlayTime, long playTime) {
        return RangesKt.coerceIn(playTime - l, obj3, 0);
    }

    private static final <V extends androidx.compose.animation.core.AnimationVector> androidx.compose.animation.core.Animations createSpringAnimations(V visibilityThreshold, float dampingRatio, float stiffness) {
        if (visibilityThreshold != null) {
            VectorizedAnimationSpecKt.createSpringAnimations.1 anon = new VectorizedAnimationSpecKt.createSpringAnimations.1(visibilityThreshold, dampingRatio, stiffness);
            return (Animations)anon;
        }
        VectorizedAnimationSpecKt.createSpringAnimations.2 anon2 = new VectorizedAnimationSpecKt.createSpringAnimations.2(dampingRatio, stiffness);
        return (Animations)anon2;
    }

    public static final <V extends androidx.compose.animation.core.AnimationVector> long getDurationMillis(androidx.compose.animation.core.VectorizedAnimationSpec<V> $this$getDurationMillis, V initialValue, V targetValue, V initialVelocity) {
        return durationNanos /= i2;
    }

    public static final <V extends androidx.compose.animation.core.AnimationVector> V getValueFromMillis(androidx.compose.animation.core.VectorizedAnimationSpec<V> $this$getValueFromMillis, long playTimeMillis, V start, V end, V startVelocity) {
        return $this$getValueFromMillis.getValueFromNanos(playTimeMillis * i, obj4, end, startVelocity);
    }
}
