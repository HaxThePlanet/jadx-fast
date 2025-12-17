package androidx.compose.animation.core;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0010\u0008\u0007\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B\u001f\u0008\u0017\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008B'\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ%\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J-\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001bJ-\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\rH\u0002J-\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00028\u00002\u0006\u0010 \u001a\u00028\u00002\u0006\u0010!\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001bR\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000c\u001a\u00020\rX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\"", d2 = {"Landroidx/compose/animation/core/VectorizedInfiniteRepeatableSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "animation", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "repeatMode", "Landroidx/compose/animation/core/RepeatMode;", "(Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;)V", "initialStartOffset", "Landroidx/compose/animation/core/StartOffset;", "(Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "durationNanos", "", "getDurationNanos$animation_core_release", "()J", "initialOffsetNanos", "isInfinite", "", "()Z", "getDurationNanos", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getValueFromNanos", "playTimeNanos", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "repetitionPlayTimeNanos", "repetitionStartVelocity", "start", "startVelocity", "end", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VectorizedInfiniteRepeatableSpec<V extends androidx.compose.animation.core.AnimationVector>  implements androidx.compose.animation.core.VectorizedAnimationSpec<V> {

    public static final int $stable = 8;
    private final androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec<V> animation;
    private final long durationNanos;
    private final long initialOffsetNanos;
    private final androidx.compose.animation.core.RepeatMode repeatMode;
    static {
        final int i = 8;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This method has been deprecated in favor of the constructor that accepts start offset.")
    public VectorizedInfiniteRepeatableSpec(androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec animation, androidx.compose.animation.core.RepeatMode repeatMode) {
        final int i3 = 0;
        super(animation, repeatMode, StartOffset.constructor-impl$default(i3, i3, 2, 0), obj7, 0);
    }

    public VectorizedInfiniteRepeatableSpec(androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec vectorizedDurationBasedAnimationSpec, androidx.compose.animation.core.RepeatMode repeatMode2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        androidx.compose.animation.core.RepeatMode obj2;
        obj2 = i3 &= 2 != 0 ? RepeatMode.Restart : obj2;
        super(vectorizedDurationBasedAnimationSpec, obj2);
    }

    private VectorizedInfiniteRepeatableSpec(androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec<V> animation, androidx.compose.animation.core.RepeatMode repeatMode, long initialStartOffset) {
        super();
        this.animation = animation;
        this.repeatMode = repeatMode;
        int i3 = 1000000;
        this.durationNanos = l *= i3;
        this.initialOffsetNanos = i3 *= initialStartOffset;
    }

    public VectorizedInfiniteRepeatableSpec(androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec vectorizedDurationBasedAnimationSpec, androidx.compose.animation.core.RepeatMode repeatMode2, long l3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        androidx.compose.animation.core.RepeatMode repeatMode;
        long l;
        androidx.compose.animation.core.RepeatMode obj8;
        long obj9;
        int obj10;
        repeatMode = defaultConstructorMarker5 & 2 != 0 ? obj8 : repeatMode2;
        if (defaultConstructorMarker5 & 4 != 0) {
            obj9 = 0;
            l = obj9;
        } else {
            l = l3;
        }
        super(vectorizedDurationBasedAnimationSpec, repeatMode, l, obj4, 0);
    }

    public VectorizedInfiniteRepeatableSpec(androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec vectorizedDurationBasedAnimationSpec, androidx.compose.animation.core.RepeatMode repeatMode2, long l3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(vectorizedDurationBasedAnimationSpec, repeatMode2, l3, defaultConstructorMarker4);
    }

    private final long repetitionPlayTimeNanos(long playTimeNanos) {
        int cmp;
        androidx.compose.animation.core.RepeatMode repeatMode;
        cmp = 0;
        if (Long.compare(i, cmp) <= 0) {
            return cmp;
        }
        initialOffsetNanos2 += playTimeNanos;
        int i9 = i2 / durationNanos2;
        if (this.repeatMode != RepeatMode.Restart && Long.compare(repeatMode, cmp) == 0) {
            if (Long.compare(repeatMode, cmp) == 0) {
            }
            return i5 -= i2;
        }
        return i2 - i7;
    }

    private final V repetitionStartVelocity(long playTimeNanos, V start, V startVelocity, V end) {
        androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec animation;
        int durationNanos;
        androidx.compose.animation.core.AnimationVector start2;
        androidx.compose.animation.core.AnimationVector animationVector2;
        androidx.compose.animation.core.AnimationVector animationVector;
        androidx.compose.animation.core.AnimationVector obj10;
        if (Long.compare(i, durationNanos) > 0) {
            obj10 = this.animation.getVelocityFromNanos(durationNanos2 -= initialOffsetNanos2, obj3, startVelocity, obj12);
        } else {
            start2 = startVelocity;
            animationVector2 = obj12;
            obj10 = animationVector;
        }
        return obj10;
    }

    public long getDurationNanos(V initialValue, V targetValue, V initialVelocity) {
        return Long.MAX_VALUE;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
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

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public boolean isInfinite() {
        return 1;
    }
}
