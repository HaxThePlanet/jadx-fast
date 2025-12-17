package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0008\u0008\u0007\u0018\u00002\u00020\u0001B#\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J \u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J(\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J(\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u0008R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Landroidx/compose/animation/core/FloatSpringSpec;", "Landroidx/compose/animation/core/FloatAnimationSpec;", "dampingRatio", "", "stiffness", "visibilityThreshold", "(FFF)V", "getDampingRatio", "()F", "spring", "Landroidx/compose/animation/core/SpringSimulation;", "getStiffness", "getDurationNanos", "", "initialValue", "targetValue", "initialVelocity", "getEndVelocity", "getValueFromNanos", "playTimeNanos", "getVelocityFromNanos", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FloatSpringSpec implements androidx.compose.animation.core.FloatAnimationSpec {

    public static final int $stable = 8;
    private final float dampingRatio;
    private final androidx.compose.animation.core.SpringSimulation spring;
    private final float stiffness;
    private final float visibilityThreshold;
    static {
        final int i = 8;
    }

    public FloatSpringSpec() {
        super(0, 0, 0, 7, 0);
    }

    public FloatSpringSpec(float dampingRatio, float stiffness, float visibilityThreshold) {
        super();
        this.dampingRatio = dampingRatio;
        this.stiffness = stiffness;
        this.visibilityThreshold = visibilityThreshold;
        SpringSimulation springSimulation = new SpringSimulation(1065353216);
        androidx.compose.animation.core.SpringSimulation springSimulation2 = springSimulation;
        final int i2 = 0;
        springSimulation2.setDampingRatio(this.dampingRatio);
        springSimulation2.setStiffness(this.stiffness);
        this.spring = springSimulation;
    }

    public FloatSpringSpec(float f, float f2, float f3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int obj1;
        int obj2;
        int obj3;
        obj1 = i4 & 1 != 0 ? 1065353216 : obj1;
        obj2 = i4 & 2 != 0 ? 1153138688 : obj2;
        obj3 = i4 &= 4 != 0 ? 1008981770 : obj3;
        super(obj1, obj2, obj3);
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public long getDurationNanos(float initialValue, float targetValue, float initialVelocity) {
        return estimateAnimationDurationMillis *= i4;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float getEndVelocity(float initialValue, float targetValue, float initialVelocity) {
        return 0;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public final float getStiffness() {
        return this.stiffness;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float getValueFromNanos(long playTimeNanos, float initialValue, float targetValue, float initialVelocity) {
        this.spring.setFinalPosition(initialVelocity);
        return Motion.getValue-impl(this.spring.updateValues-IJZedt4$animation_core_release(targetValue, obj9, playTimeNanos / i));
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float getVelocityFromNanos(long playTimeNanos, float initialValue, float targetValue, float initialVelocity) {
        this.spring.setFinalPosition(initialVelocity);
        return Motion.getVelocity-impl(this.spring.updateValues-IJZedt4$animation_core_release(targetValue, obj9, playTimeNanos / i));
    }
}
