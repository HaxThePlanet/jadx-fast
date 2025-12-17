package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0007\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\u0008\u0010\u0012\u001a\u00020\u0004H\u0016J,\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u00150\u0014\"\u0008\u0008\u0001\u0010\u0015*\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00150\u0018H\u0016R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u0019", d2 = {"Landroidx/compose/animation/core/TweenSpec;", "T", "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "durationMillis", "", "delay", "easing", "Landroidx/compose/animation/core/Easing;", "(IILandroidx/compose/animation/core/Easing;)V", "getDelay", "()I", "getDurationMillis", "getEasing", "()Landroidx/compose/animation/core/Easing;", "equals", "", "other", "", "hashCode", "vectorize", "Landroidx/compose/animation/core/VectorizedTweenSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TweenSpec<T>  implements androidx.compose.animation.core.DurationBasedAnimationSpec<T> {

    public static final int $stable;
    private final int delay;
    private final int durationMillis;
    private final androidx.compose.animation.core.Easing easing;
    static {
    }

    public TweenSpec() {
        super(0, 0, 0, 7, 0);
    }

    public TweenSpec(int durationMillis, int delay, androidx.compose.animation.core.Easing easing) {
        super();
        this.durationMillis = durationMillis;
        this.delay = delay;
        this.easing = easing;
    }

    public TweenSpec(int i, int i2, androidx.compose.animation.core.Easing easing3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
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

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec
    public boolean equals(Object other) {
        boolean durationMillis;
        int i;
        androidx.compose.animation.core.Easing durationMillis2;
        i = 0;
        if (other instanceof TweenSpec) {
            if (obj.durationMillis == this.durationMillis && obj2.delay == this.delay && Intrinsics.areEqual(obj3.easing, this.easing)) {
                if (obj2.delay == this.delay) {
                    if (Intrinsics.areEqual(obj3.easing, this.easing)) {
                        i = 1;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec
    public final int getDelay() {
        return this.delay;
    }

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec
    public final int getDurationMillis() {
        return this.durationMillis;
    }

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec
    public final androidx.compose.animation.core.Easing getEasing() {
        return this.easing;
    }

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec
    public int hashCode() {
        return i3 += delay;
    }

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec
    public androidx.compose.animation.core.VectorizedAnimationSpec vectorize(androidx.compose.animation.core.TwoWayConverter converter) {
        return (VectorizedAnimationSpec)vectorize(converter);
    }

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec
    public androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec vectorize(androidx.compose.animation.core.TwoWayConverter converter) {
        return (VectorizedDurationBasedAnimationSpec)vectorize(converter);
    }

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec
    public androidx.compose.animation.core.VectorizedFiniteAnimationSpec vectorize(androidx.compose.animation.core.TwoWayConverter converter) {
        return (VectorizedFiniteAnimationSpec)vectorize(converter);
    }

    public <V extends androidx.compose.animation.core.AnimationVector> androidx.compose.animation.core.VectorizedTweenSpec<V> vectorize(androidx.compose.animation.core.TwoWayConverter<T, V> converter) {
        VectorizedTweenSpec vectorizedTweenSpec = new VectorizedTweenSpec(this.durationMillis, this.delay, this.easing);
        return vectorizedTweenSpec;
    }
}
