package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0003\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016J,\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u0002H\u00130\u0012\"\u0008\u0008\u0001\u0010\u0013*\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00130\u0016H\u0016R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u0017", d2 = {"Landroidx/compose/animation/core/StartDelayAnimationSpec;", "T", "Landroidx/compose/animation/core/AnimationSpec;", "animationSpec", "startDelayNanos", "", "(Landroidx/compose/animation/core/AnimationSpec;J)V", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "getStartDelayNanos", "()J", "equals", "", "other", "", "hashCode", "", "vectorize", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class StartDelayAnimationSpec<T>  implements androidx.compose.animation.core.AnimationSpec<T> {

    private final androidx.compose.animation.core.AnimationSpec<T> animationSpec;
    private final long startDelayNanos;
    public StartDelayAnimationSpec(androidx.compose.animation.core.AnimationSpec<T> animationSpec, long startDelayNanos) {
        super();
        this.animationSpec = animationSpec;
        this.startDelayNanos = startDelayNanos;
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public boolean equals(Object other) {
        int equal;
        int i;
        long startDelayNanos;
        if (!other instanceof StartDelayAnimationSpec) {
            return 0;
        }
        if (Long.compare(startDelayNanos, startDelayNanos2) == 0 && Intrinsics.areEqual(obj2.animationSpec, this.animationSpec)) {
            if (Intrinsics.areEqual(obj2.animationSpec, this.animationSpec)) {
                i = 1;
            } else {
            }
        } else {
        }
        return i;
    }

    public final androidx.compose.animation.core.AnimationSpec<T> getAnimationSpec() {
        return this.animationSpec;
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public final long getStartDelayNanos() {
        return this.startDelayNanos;
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public int hashCode() {
        return i2 += i4;
    }

    public <V extends androidx.compose.animation.core.AnimationVector> androidx.compose.animation.core.VectorizedAnimationSpec<V> vectorize(androidx.compose.animation.core.TwoWayConverter<T, V> converter) {
        StartDelayVectorizedAnimationSpec startDelayVectorizedAnimationSpec = new StartDelayVectorizedAnimationSpec(this.animationSpec.vectorize(converter), this.startDelayNanos, obj3);
        return (VectorizedAnimationSpec)startDelayVectorizedAnimationSpec;
    }
}
