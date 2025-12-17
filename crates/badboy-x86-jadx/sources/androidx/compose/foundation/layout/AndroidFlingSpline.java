package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0014\n\u0002\u0008\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008Â\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u000bJ\u001b\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0010\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0013", d2 = {"Landroidx/compose/foundation/layout/AndroidFlingSpline;", "", "()V", "NbSamples", "", "SplinePositions", "", "SplineTimes", "deceleration", "", "velocity", "", "friction", "flingPosition", "Landroidx/compose/foundation/layout/AndroidFlingSpline$FlingResult;", "time", "flingPosition-LfoxSSI", "(F)J", "FlingResult", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class AndroidFlingSpline {

    public static final androidx.compose.foundation.layout.AndroidFlingSpline INSTANCE = null;
    private static final int NbSamples = 100;
    private static final float[] SplinePositions;
    private static final float[] SplineTimes;

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\u0008\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\u0008\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0019", d2 = {"Landroidx/compose/foundation/layout/AndroidFlingSpline$FlingResult;", "", "packedValue", "", "constructor-impl", "(J)J", "distanceCoefficient", "", "getDistanceCoefficient-impl", "(J)F", "velocityCoefficient", "getVelocityCoefficient-impl", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @JvmInline
    public static final class FlingResult {

        private final long packedValue;
        private FlingResult(long packedValue) {
            super();
            this.packedValue = packedValue;
        }

        public static final androidx.compose.foundation.layout.AndroidFlingSpline.FlingResult box-impl(long l) {
            AndroidFlingSpline.FlingResult flingResult = new AndroidFlingSpline.FlingResult(l, obj2);
            return flingResult;
        }

        public static long constructor-impl(long l) {
            return l;
        }

        public static boolean equals-impl(long l, Object object2) {
            final int i2 = 0;
            if (obj6 instanceof AndroidFlingSpline.FlingResult == null) {
                return i2;
            }
            if (Long.compare(l, unbox-impl) != 0) {
                return i2;
            }
            return 1;
        }

        public static final boolean equals-impl0(long l, long l2) {
            int i;
            i = Long.compare(l, obj3) == 0 ? 1 : 0;
            return i;
        }

        public static final float getDistanceCoefficient-impl(long arg0) {
            final int i2 = 0;
            final int i6 = 0;
            return Float.intBitsToFloat((int)i4);
        }

        public static final float getVelocityCoefficient-impl(long arg0) {
            final int i = 0;
            final int i4 = 0;
            return Float.intBitsToFloat((int)i2);
        }

        public static int hashCode-impl(long l) {
            return Long.hashCode(l);
        }

        public static String toString-impl(long l) {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("FlingResult(packedValue=").append(l).append(')').toString();
        }

        public boolean equals(Object object) {
            return AndroidFlingSpline.FlingResult.equals-impl(this.packedValue, obj1);
        }

        public int hashCode() {
            return AndroidFlingSpline.FlingResult.hashCode-impl(this.packedValue);
        }

        public String toString() {
            return AndroidFlingSpline.FlingResult.toString-impl(this.packedValue);
        }

        public final long unbox-impl() {
            return this.packedValue;
        }
    }
    static {
        int xMin;
        int yMin;
        int i4;
        int xMax;
        float[] splineTimes;
        int i;
        int i9;
        int x;
        int tx;
        int coef;
        int cmp;
        int i8;
        int i2;
        int yMax;
        int i3;
        int i6;
        int y;
        int i5;
        long l;
        int dy;
        int i10;
        int i7;
        AndroidFlingSpline androidFlingSpline = new AndroidFlingSpline();
        AndroidFlingSpline.INSTANCE = androidFlingSpline;
        int i11 = 101;
        AndroidFlingSpline.SplinePositions = new float[i11];
        AndroidFlingSpline.SplineTimes = new float[i11];
        xMin = 0;
        yMin = 0;
        i4 = 0;
        int i13 = 100;
        i = 1065353216;
        while (i4 < i13) {
            f4 /= f;
            xMax = 1065353216;
            x = 0;
            tx = 0;
            coef = 0;
            x = xMin + i15;
            coef = i21 * i27;
            i3 = 1043542835;
            i6 = 1051931444;
            tx = i25 + i30;
            l = 4532020583610935537L;
            while (Double.compare(y, l) >= 0) {
                if (Float.compare(tx, i9) > 0) {
                } else {
                }
                xMin = x;
                x = xMin + i15;
                coef = i21 * i27;
                i3 = 1043542835;
                i6 = 1051931444;
                tx = i25 + i30;
                l = 4532020583610935537L;
                xMax = x;
            }
            i5 = 1056964608;
            AndroidFlingSpline.SplinePositions[i4] = i34 += i37;
            yMax = 1065353216;
            y = 0;
            dy = 0;
            y = yMin + i39;
            coef = i40 * i46;
            dy = i44 + i48;
            i7 = i;
            while (Double.compare(d, l) >= 0) {
                if (Float.compare(dy, i9) > 0) {
                } else {
                }
                yMin = y;
                i = i7;
                i8 = 1077936128;
                i2 = 1073741824;
                y = yMin + i39;
                coef = i40 * i46;
                dy = i44 + i48;
                i7 = i;
                yMax = y;
            }
            AndroidFlingSpline.SplineTimes[i4] = i19 += i2;
            i4++;
            i13 = 100;
            i = 1065353216;
            if (Float.compare(dy, i9) > 0) {
            } else {
            }
            yMin = y;
            i = i7;
            i8 = 1077936128;
            i2 = 1073741824;
            yMax = y;
            if (Float.compare(tx, i9) > 0) {
            } else {
            }
            xMin = x;
            xMax = x;
        }
        AndroidFlingSpline.SplineTimes[i13] = i;
        AndroidFlingSpline.SplinePositions[i13] = AndroidFlingSpline.SplineTimes[i13];
    }

    public final double deceleration(float velocity, float friction) {
        f *= i;
        return Math.log(d /= d3);
    }

    public final long flingPosition-LfoxSSI(float time) {
        int i3;
        float f;
        int distanceCoef;
        int velocityCoef;
        int i;
        float f2;
        int i4;
        int i2;
        i3 = 100;
        f = (float)i3;
        int i7 = (int)i6;
        distanceCoef = 1065353216;
        velocityCoef = 0;
        if (i7 < i3) {
            f3 /= f;
            f = AndroidFlingSpline.SplinePositions[i7];
            distanceCoef = f + i4;
        }
        int tInf = 0;
        int i5 = 32;
        return AndroidFlingSpline.FlingResult.constructor-impl(i12 | i13);
    }
}
