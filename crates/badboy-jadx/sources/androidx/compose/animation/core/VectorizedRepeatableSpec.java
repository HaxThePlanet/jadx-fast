package androidx.compose.animation.core;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0012\u0008\u0007\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B'\u0008\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nB/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c¢\u0006\u0002\u0010\rJ%\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J-\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001aJ-\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J-\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00028\u00002\u0006\u0010 \u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001aR\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!", d2 = {"Landroidx/compose/animation/core/VectorizedRepeatableSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "iterations", "", "animation", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "repeatMode", "Landroidx/compose/animation/core/RepeatMode;", "(ILandroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;)V", "initialStartOffset", "Landroidx/compose/animation/core/StartOffset;", "(ILandroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "durationNanos", "", "getDurationNanos$animation_core_release", "()J", "initialOffsetNanos", "getDurationNanos", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getValueFromNanos", "playTimeNanos", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "repetitionPlayTimeNanos", "repetitionStartVelocity", "start", "startVelocity", "end", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VectorizedRepeatableSpec<V extends androidx.compose.animation.core.AnimationVector>  implements androidx.compose.animation.core.VectorizedFiniteAnimationSpec<V> {

    public static final int $stable = 8;
    private final androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec<V> animation;
    private final long durationNanos;
    private final long initialOffsetNanos;
    private final int iterations;
    private final androidx.compose.animation.core.RepeatMode repeatMode;
    static {
        final int i = 8;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This method has been deprecated in favor of the constructor that accepts start offset.")
    public VectorizedRepeatableSpec(int iterations, androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec animation, androidx.compose.animation.core.RepeatMode repeatMode) {
        final int i3 = 0;
        super(iterations, animation, repeatMode, StartOffset.constructor-impl$default(i3, i3, 2, 0), obj8, 0);
    }

    public VectorizedRepeatableSpec(int i, androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec vectorizedDurationBasedAnimationSpec2, androidx.compose.animation.core.RepeatMode repeatMode3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        androidx.compose.animation.core.RepeatMode obj3;
        obj3 = i4 &= 4 != 0 ? RepeatMode.Restart : obj3;
        super(i, vectorizedDurationBasedAnimationSpec2, obj3);
    }

    private VectorizedRepeatableSpec(int iterations, androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec<V> animation, androidx.compose.animation.core.RepeatMode repeatMode, long initialStartOffset) {
        super();
        this.iterations = iterations;
        this.animation = animation;
        this.repeatMode = repeatMode;
        if (this.iterations < 1) {
        } else {
            int i4 = 1000000;
            this.durationNanos = l *= i4;
            this.initialOffsetNanos = i4 *= initialStartOffset;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Iterations count can't be less than 1");
        throw illegalArgumentException;
    }

    public VectorizedRepeatableSpec(int i, androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec vectorizedDurationBasedAnimationSpec2, androidx.compose.animation.core.RepeatMode repeatMode3, long l4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        androidx.compose.animation.core.RepeatMode repeatMode;
        long l;
        androidx.compose.animation.core.RepeatMode obj10;
        long obj11;
        int obj12;
        repeatMode = defaultConstructorMarker6 & 4 != 0 ? obj10 : repeatMode3;
        if (defaultConstructorMarker6 & 8 != 0) {
            obj12 = 0;
            l = obj11;
        } else {
            l = l4;
        }
        super(i, vectorizedDurationBasedAnimationSpec2, repeatMode, l, obj5, 0);
    }

    public VectorizedRepeatableSpec(int i, androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec vectorizedDurationBasedAnimationSpec2, androidx.compose.animation.core.RepeatMode repeatMode3, long l4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(i, vectorizedDurationBasedAnimationSpec2, repeatMode3, l4, defaultConstructorMarker5);
    }

    private final long repetitionPlayTimeNanos(long playTimeNanos) {
        int cmp;
        androidx.compose.animation.core.RepeatMode repeatMode;
        cmp = 0;
        if (Long.compare(i, cmp) <= 0) {
            return cmp;
        }
        initialOffsetNanos2 += playTimeNanos;
        int i8 = 1;
        long l = Math.min(i2 / durationNanos3, obj5);
        if (this.repeatMode != RepeatMode.Restart && Long.compare(repeatMode, cmp) == 0) {
            if (Long.compare(repeatMode, cmp) == 0) {
            }
            return i10 -= i2;
        }
        return i2 - i3;
    }

    private final V repetitionStartVelocity(long playTimeNanos, V start, V startVelocity, V end) {
        long durationNanos;
        long initialOffsetNanos;
        Object obj;
        int i;
        androidx.compose.animation.core.AnimationVector start2;
        androidx.compose.animation.core.AnimationVector animationVector;
        Object obj2;
        androidx.compose.animation.core.AnimationVector obj13;
        if (Long.compare(i2, initialOffsetNanos) > 0) {
            obj13 = this.getVelocityFromNanos(durationNanos - initialOffsetNanos, obj6, startVelocity, end);
        } else {
            start2 = startVelocity;
            obj2 = obj15;
            obj13 = animationVector;
        }
        return obj13;
    }

    public long getDurationNanos(V initialValue, V targetValue, V initialVelocity) {
        return i -= initialOffsetNanos;
    }

    @Override // androidx.compose.animation.core.VectorizedFiniteAnimationSpec
    public final long getDurationNanos$animation_core_release() {
        return this.durationNanos;
    }

    public V getValueFromNanos(long playTimeNanos, V initialValue, V targetValue, V initialVelocity) {
        long l = playTimeNanos;
        final androidx.compose.animation.core.AnimationVector animationVector3 = targetValue;
        final androidx.compose.animation.core.AnimationVector animationVector5 = initialVelocity;
        final long obj11 = l;
        return this.animation.getValueFromNanos(repetitionPlayTimeNanos(playTimeNanos), obj2, animationVector3, animationVector5);
    }

    public V getVelocityFromNanos(long playTimeNanos, V initialValue, V targetValue, V initialVelocity) {
        long l = playTimeNanos;
        final androidx.compose.animation.core.AnimationVector animationVector3 = targetValue;
        final androidx.compose.animation.core.AnimationVector animationVector5 = initialVelocity;
        final long obj11 = l;
        return this.animation.getVelocityFromNanos(repetitionPlayTimeNanos(playTimeNanos), obj2, animationVector3, animationVector5);
    }
}
