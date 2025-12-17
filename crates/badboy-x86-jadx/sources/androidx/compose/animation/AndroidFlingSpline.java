package androidx.compose.animation;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0014\n\u0002\u0008\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008À\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Landroidx/compose/animation/AndroidFlingSpline;", "", "()V", "NbSamples", "", "SplinePositions", "", "SplineTimes", "deceleration", "", "velocity", "", "friction", "flingPosition", "Landroidx/compose/animation/AndroidFlingSpline$FlingResult;", "time", "FlingResult", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidFlingSpline {

    public static final int $stable = 0;
    public static final androidx.compose.animation.AndroidFlingSpline INSTANCE = null;
    private static final int NbSamples = 100;
    private static final float[] SplinePositions;
    private static final float[] SplineTimes;

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0013", d2 = {"Landroidx/compose/animation/AndroidFlingSpline$FlingResult;", "", "distanceCoefficient", "", "velocityCoefficient", "(FF)V", "getDistanceCoefficient", "()F", "getVelocityCoefficient", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class FlingResult {

        public static final int $stable;
        private final float distanceCoefficient;
        private final float velocityCoefficient;
        static {
        }

        public FlingResult(float distanceCoefficient, float velocityCoefficient) {
            super();
            this.distanceCoefficient = distanceCoefficient;
            this.velocityCoefficient = velocityCoefficient;
        }

        public static androidx.compose.animation.AndroidFlingSpline.FlingResult copy$default(androidx.compose.animation.AndroidFlingSpline.FlingResult androidFlingSpline$FlingResult, float f2, float f3, int i4, Object object5) {
            float obj1;
            float obj2;
            if (i4 & 1 != 0) {
                obj1 = flingResult.distanceCoefficient;
            }
            if (i4 &= 2 != 0) {
                obj2 = flingResult.velocityCoefficient;
            }
            return flingResult.copy(obj1, obj2);
        }

        public final float component1() {
            return this.distanceCoefficient;
        }

        public final float component2() {
            return this.velocityCoefficient;
        }

        public final androidx.compose.animation.AndroidFlingSpline.FlingResult copy(float f, float f2) {
            AndroidFlingSpline.FlingResult flingResult = new AndroidFlingSpline.FlingResult(f, f2);
            return flingResult;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (object instanceof AndroidFlingSpline.FlingResult == null) {
                return i2;
            }
            Object obj = object;
            if (Float.compare(this.distanceCoefficient, obj.distanceCoefficient) != 0) {
                return i2;
            }
            if (Float.compare(this.velocityCoefficient, obj.velocityCoefficient) != 0) {
                return i2;
            }
            return i;
        }

        public final float getDistanceCoefficient() {
            return this.distanceCoefficient;
        }

        public final float getVelocityCoefficient() {
            return this.velocityCoefficient;
        }

        public int hashCode() {
            return i2 += i4;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("FlingResult(distanceCoefficient=").append(this.distanceCoefficient).append(", velocityCoefficient=").append(this.velocityCoefficient).append(')').toString();
        }
    }
    static {
        AndroidFlingSpline androidFlingSpline = new AndroidFlingSpline();
        AndroidFlingSpline.INSTANCE = androidFlingSpline;
        int i = 101;
        AndroidFlingSpline.SplinePositions = new float[i];
        AndroidFlingSpline.SplineTimes = new float[i];
        SplineBasedDecayKt.access$computeSplineInfo(AndroidFlingSpline.SplinePositions, AndroidFlingSpline.SplineTimes, 100);
        AndroidFlingSpline.$stable = 8;
    }

    public final double deceleration(float velocity, float friction) {
        f *= i;
        return Math.log(d /= d3);
    }

    public final androidx.compose.animation.AndroidFlingSpline.FlingResult flingPosition(float time) {
        int i;
        float f2;
        int distanceCoef;
        int velocityCoef;
        int i2;
        float f;
        int i4;
        int i3;
        float coerceIn = RangesKt.coerceIn(time, 0, 1065353216);
        i = 100;
        f2 = (float)i;
        int i8 = (int)i7;
        distanceCoef = 1065353216;
        velocityCoef = 0;
        if (i8 < i) {
            f3 /= f2;
            f2 = AndroidFlingSpline.SplinePositions[i8];
            distanceCoef = f2 + i4;
        }
        AndroidFlingSpline.FlingResult tInf = new AndroidFlingSpline.FlingResult(distanceCoef, velocityCoef);
        return tInf;
    }
}
