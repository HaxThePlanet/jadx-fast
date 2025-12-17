package androidx.compose.animation;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u000e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000c\u001a\u00020\u0003J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000c\u001a\u00020\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000c\u001a\u00020\u0003H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Landroidx/compose/animation/FlingCalculator;", "", "friction", "", "density", "Landroidx/compose/ui/unit/Density;", "(FLandroidx/compose/ui/unit/Density;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "magicPhysicalCoefficient", "computeDeceleration", "flingDistance", "velocity", "flingDuration", "", "flingInfo", "Landroidx/compose/animation/FlingCalculator$FlingInfo;", "getSplineDeceleration", "", "FlingInfo", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FlingCalculator {

    public static final int $stable;
    private final Density density;
    private final float friction;
    private final float magicPhysicalCoefficient;

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u000e\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0006J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u000e\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\t¨\u0006\u001b", d2 = {"Landroidx/compose/animation/FlingCalculator$FlingInfo;", "", "initialVelocity", "", "distance", "duration", "", "(FFJ)V", "getDistance", "()F", "getDuration", "()J", "getInitialVelocity", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "position", "time", "toString", "", "velocity", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class FlingInfo {

        public static final int $stable;
        private final float distance;
        private final long duration;
        private final float initialVelocity;
        static {
        }

        public FlingInfo(float initialVelocity, float distance, long duration) {
            super();
            this.initialVelocity = initialVelocity;
            this.distance = distance;
            this.duration = duration;
        }

        public static androidx.compose.animation.FlingCalculator.FlingInfo copy$default(androidx.compose.animation.FlingCalculator.FlingInfo flingCalculator$FlingInfo, float f2, float f3, long l4, int i5, Object object6) {
            float obj1;
            float obj2;
            long obj3;
            if (object6 & 1 != 0) {
                obj1 = flingInfo.initialVelocity;
            }
            if (object6 & 2 != 0) {
                obj2 = flingInfo.distance;
            }
            if (object6 &= 4 != 0) {
                obj3 = flingInfo.duration;
            }
            return flingInfo.copy(obj1, obj2, obj3);
        }

        public final float component1() {
            return this.initialVelocity;
        }

        public final float component2() {
            return this.distance;
        }

        public final long component3() {
            return this.duration;
        }

        public final androidx.compose.animation.FlingCalculator.FlingInfo copy(float f, float f2, long l3) {
            FlingCalculator.FlingInfo flingInfo = new FlingCalculator.FlingInfo(f, f2, l3, obj5);
            return flingInfo;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof FlingCalculator.FlingInfo) {
                return i2;
            }
            Object obj = object;
            if (Float.compare(this.initialVelocity, obj.initialVelocity) != 0) {
                return i2;
            }
            if (Float.compare(this.distance, obj.distance) != 0) {
                return i2;
            }
            if (Long.compare(duration, duration2) != 0) {
                return i2;
            }
            return i;
        }

        public final float getDistance() {
            return this.distance;
        }

        public final long getDuration() {
            return this.duration;
        }

        public final float getInitialVelocity() {
            return this.initialVelocity;
        }

        public int hashCode() {
            return i2 += i7;
        }

        public final float position(long time) {
            int i;
            float f;
            if (Long.compare(duration, i4) > 0) {
                f2 /= f;
            } else {
                i = 1065353216;
            }
            return i2 *= distanceCoefficient;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("FlingInfo(initialVelocity=").append(this.initialVelocity).append(", distance=").append(this.distance).append(", duration=").append(this.duration).append(')').toString();
        }

        public final float velocity(long time) {
            int i;
            float f;
            if (Long.compare(duration, i6) > 0) {
                f2 /= f;
            } else {
                i = 1065353216;
            }
            return i4 *= i7;
        }
    }
    static {
    }

    public FlingCalculator(float friction, Density density) {
        super();
        this.friction = friction;
        this.density = density;
        this.magicPhysicalCoefficient = computeDeceleration(this.density);
    }

    private final float computeDeceleration(Density density) {
        return FlingCalculatorKt.access$computeDeceleration(1062668861, density.getDensity());
    }

    private final double getSplineDeceleration(float velocity) {
        return AndroidFlingSpline.INSTANCE.deceleration(velocity, friction *= magicPhysicalCoefficient);
    }

    public final float flingDistance(float velocity) {
        return (float)i3;
    }

    public final long flingDuration(float velocity) {
        return (long)i3;
    }

    public final androidx.compose.animation.FlingCalculator.FlingInfo flingInfo(float velocity) {
        final double splineDeceleration = getSplineDeceleration(velocity);
        d -= l;
        double d5 = Math.exp(i6 *= splineDeceleration);
        FlingCalculator.FlingInfo flingInfo = new FlingCalculator.FlingInfo(velocity, (float)i3, (long)i5, d5);
        return flingInfo;
    }

    public final Density getDensity() {
        return this.density;
    }
}
