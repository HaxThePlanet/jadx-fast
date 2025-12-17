package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\u0000\n\u0002\u0008\n\n\u0002\u0010\u0008\n\u0000\u0008\u0003\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\t2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J%\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J-\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J-\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u0008\u0010\u001b\u001a\u00020\u001cH\u0016R\u0014\u0010\u0008\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001d", d2 = {"Landroidx/compose/animation/core/StartDelayVectorizedAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "vectorizedAnimationSpec", "startDelayNanos", "", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;J)V", "isInfinite", "", "()Z", "getStartDelayNanos", "()J", "getVectorizedAnimationSpec", "()Landroidx/compose/animation/core/VectorizedAnimationSpec;", "equals", "other", "", "getDurationNanos", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getValueFromNanos", "playTimeNanos", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "hashCode", "", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class StartDelayVectorizedAnimationSpec<V extends androidx.compose.animation.core.AnimationVector>  implements androidx.compose.animation.core.VectorizedAnimationSpec<V> {

    private final long startDelayNanos;
    private final androidx.compose.animation.core.VectorizedAnimationSpec<V> vectorizedAnimationSpec;
    public StartDelayVectorizedAnimationSpec(androidx.compose.animation.core.VectorizedAnimationSpec<V> vectorizedAnimationSpec, long startDelayNanos) {
        super();
        this.vectorizedAnimationSpec = vectorizedAnimationSpec;
        this.startDelayNanos = startDelayNanos;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public boolean equals(Object other) {
        int equal;
        int i;
        long vectorizedAnimationSpec;
        if (!other instanceof StartDelayVectorizedAnimationSpec) {
            return 0;
        }
        if (Long.compare(vectorizedAnimationSpec, startDelayNanos) == 0 && Intrinsics.areEqual(obj2.vectorizedAnimationSpec, this.vectorizedAnimationSpec)) {
            if (Intrinsics.areEqual(obj2.vectorizedAnimationSpec, this.vectorizedAnimationSpec)) {
                i = 1;
            } else {
            }
        } else {
        }
        return i;
    }

    public long getDurationNanos(V initialValue, V targetValue, V initialVelocity) {
        return durationNanos += startDelayNanos;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public final long getStartDelayNanos() {
        return this.startDelayNanos;
    }

    public V getValueFromNanos(long playTimeNanos, V initialValue, V targetValue, V initialVelocity) {
        androidx.compose.animation.core.VectorizedAnimationSpec vectorizedAnimationSpec;
        int i;
        androidx.compose.animation.core.AnimationVector animationVector;
        androidx.compose.animation.core.AnimationVector animationVector2;
        Object obj;
        androidx.compose.animation.core.AnimationVector obj10;
        if (Long.compare(playTimeNanos, startDelayNanos) < 0) {
            animationVector = targetValue;
            animationVector2 = initialVelocity;
            obj = obj12;
        } else {
            obj10 = this.vectorizedAnimationSpec.getValueFromNanos(playTimeNanos - startDelayNanos2, obj3, targetValue, initialVelocity);
        }
        return obj10;
    }

    public final androidx.compose.animation.core.VectorizedAnimationSpec<V> getVectorizedAnimationSpec() {
        return this.vectorizedAnimationSpec;
    }

    public V getVelocityFromNanos(long playTimeNanos, V initialValue, V targetValue, V initialVelocity) {
        androidx.compose.animation.core.VectorizedAnimationSpec vectorizedAnimationSpec;
        int i;
        androidx.compose.animation.core.AnimationVector animationVector2;
        androidx.compose.animation.core.AnimationVector animationVector3;
        androidx.compose.animation.core.AnimationVector animationVector;
        androidx.compose.animation.core.AnimationVector obj10;
        if (Long.compare(playTimeNanos, startDelayNanos) < 0) {
            animationVector2 = targetValue;
            animationVector3 = initialVelocity;
            animationVector = obj10;
        } else {
            obj10 = this.vectorizedAnimationSpec.getVelocityFromNanos(playTimeNanos - startDelayNanos2, obj3, targetValue, initialVelocity);
        }
        return obj10;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public int hashCode() {
        return i2 += i4;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public boolean isInfinite() {
        return this.vectorizedAnimationSpec.isInfinite();
    }
}
