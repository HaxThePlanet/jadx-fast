package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0010\u0007\n\u0002\u0008\u0005\u0008\u0007\u0018\u00002\u00020\u0001B#\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J \u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J(\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J(\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\tR\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"Landroidx/compose/animation/core/FloatTweenSpec;", "Landroidx/compose/animation/core/FloatAnimationSpec;", "duration", "", "delay", "easing", "Landroidx/compose/animation/core/Easing;", "(IILandroidx/compose/animation/core/Easing;)V", "getDelay", "()I", "delayNanos", "", "getDuration", "durationNanos", "clampPlayTimeNanos", "playTimeNanos", "getDurationNanos", "initialValue", "", "targetValue", "initialVelocity", "getValueFromNanos", "getVelocityFromNanos", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FloatTweenSpec implements androidx.compose.animation.core.FloatAnimationSpec {

    public static final int $stable;
    private final int delay;
    private final long delayNanos;
    private final int duration;
    private final long durationNanos;
    private final androidx.compose.animation.core.Easing easing;
    static {
    }

    public FloatTweenSpec() {
        super(0, 0, 0, 7, 0);
    }

    public FloatTweenSpec(int duration, int delay, androidx.compose.animation.core.Easing easing) {
        super();
        this.duration = duration;
        this.delay = delay;
        this.easing = easing;
        final int i3 = 1000000;
        this.durationNanos = l *= i3;
        this.delayNanos = l2 *= i3;
    }

    public FloatTweenSpec(int i, int i2, androidx.compose.animation.core.Easing easing3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int obj1;
        int obj2;
        androidx.compose.animation.core.Easing obj3;
        obj1 = i4 & 1 != 0 ? 300 : obj1;
        obj2 = i4 & 2 != 0 ? 0 : obj2;
        if (i4 &= 4 != 0) {
            obj3 = EasingKt.getFastOutSlowInEasing();
        }
        super(obj1, obj2, obj3);
    }

    private final long clampPlayTimeNanos(long playTimeNanos) {
        return RangesKt.coerceIn(playTimeNanos - delayNanos, obj3, 0);
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public final int getDelay() {
        return this.delay;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public final int getDuration() {
        return this.duration;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public long getDurationNanos(float initialValue, float targetValue, float initialVelocity) {
        return l *= i3;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float getValueFromNanos(long playTimeNanos, float initialValue, float targetValue, float initialVelocity) {
        int i;
        float f;
        int $this$fastCoerceAtMost$iv$iv;
        if (this.duration == 0) {
            i = 1065353216;
        } else {
            f2 /= f;
        }
        int i2 = 0;
        final int i3 = 1065353216;
        final int i5 = 0;
        int i6 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv, i2) < 0) {
            $this$fastCoerceAtMost$iv$iv = i2;
        }
        int i7 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv, i3) > 0) {
            $this$fastCoerceAtMost$iv$iv = i3;
        }
        return VectorConvertersKt.lerp(targetValue, initialVelocity, this.easing.transform($this$fastCoerceAtMost$iv$iv));
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float getVelocityFromNanos(long playTimeNanos, float initialValue, float targetValue, float initialVelocity) {
        final long clampPlayTimeNanos = clampPlayTimeNanos(playTimeNanos);
        int i4 = 0;
        if (Long.compare(clampPlayTimeNanos, i4) < 0) {
            return 0;
        }
        if (Long.compare(clampPlayTimeNanos, i4) == 0) {
            return obj16;
        }
        return i2 *= i6;
    }
}
