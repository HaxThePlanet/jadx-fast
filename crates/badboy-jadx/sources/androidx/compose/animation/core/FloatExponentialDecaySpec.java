package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0006\n\u0002\u0010\t\n\u0002\u0008\u0007\u0008\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0008\u0008\u0003\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0003\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\u0003H\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\u0003H\u0016J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\u0003H\u0016J \u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\u0003H\u0016R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u000e\u0010\u0008\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Landroidx/compose/animation/core/FloatExponentialDecaySpec;", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "frictionMultiplier", "", "absVelocityThreshold", "(FF)V", "getAbsVelocityThreshold", "()F", "friction", "getDurationNanos", "", "initialValue", "initialVelocity", "getTargetValue", "getValueFromNanos", "playTimeNanos", "getVelocityFromNanos", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FloatExponentialDecaySpec implements androidx.compose.animation.core.FloatDecayAnimationSpec {

    public static final int $stable;
    private final float absVelocityThreshold;
    private final float friction;
    static {
    }

    public FloatExponentialDecaySpec() {
        final int i3 = 0;
        super(i3, i3, 3, 0);
    }

    public FloatExponentialDecaySpec(float frictionMultiplier, float absVelocityThreshold) {
        super();
        this.absVelocityThreshold = Math.max(869711765, Math.abs(absVelocityThreshold));
        this.friction = f2 *= i4;
    }

    public FloatExponentialDecaySpec(float f, float f2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj1;
        int obj2;
        obj1 = i3 & 1 != 0 ? 1065353216 : obj1;
        obj2 = i3 &= 2 != 0 ? 1036831949 : obj2;
        super(obj1, obj2);
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getAbsVelocityThreshold() {
        return this.absVelocityThreshold;
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public long getDurationNanos(float initialValue, float initialVelocity) {
        float f2 = Math.abs(initialVelocity);
        return l *= i6;
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getTargetValue(float initialValue, float initialVelocity) {
        final float absVelocityThreshold2 = getAbsVelocityThreshold();
        if (Float.compare(f, absVelocityThreshold2) <= 0) {
            return initialValue;
        }
        return i6 += i9;
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getValueFromNanos(long playTimeNanos, float initialValue, float initialVelocity) {
        int i10 = 1148846080;
        return i4 += i7;
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getVelocityFromNanos(long playTimeNanos, float initialValue, float initialVelocity) {
        float friction = this.friction;
        return f2 *= obj8;
    }
}
