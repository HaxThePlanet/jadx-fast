package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0005\u0008\u0001\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\u0008J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005J\u0016\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005R\u001c\u0010\t\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\n0\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\u000c\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0016", d2 = {"Landroidx/compose/animation/core/ArcSpline;", "", "arcModes", "", "timePoints", "", "y", "", "([I[F[[F)V", "arcs", "Landroidx/compose/animation/core/ArcSpline$Arc;", "[[Landroidx/compose/animation/core/ArcSpline$Arc;", "isExtrapolate", "", "getPos", "", "time", "", "v", "getSlope", "Arc", "Companion", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ArcSpline {

    public static final int $stable = 0;
    public static final int ArcAbove = 5;
    public static final int ArcBelow = 4;
    public static final int ArcStartFlip = 3;
    public static final int ArcStartHorizontal = 2;
    public static final int ArcStartLinear = 0;
    public static final int ArcStartVertical = 1;
    public static final androidx.compose.animation.core.ArcSpline.Companion Companion = null;
    private static final int DownArc = 4;
    private static final int StartHorizontal = 2;
    private static final int StartLinear = 3;
    private static final int StartVertical = 1;
    private static final int UpArc = 5;
    private final androidx.compose.animation.core.ArcSpline.Arc[][] arcs;
    private final boolean isExtrapolate;

    @Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0014\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u000e\u0008\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B?\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0008\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ(\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0008\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0006\u0010 \u001a\u00020\u0005J\u0006\u0010!\u001a\u00020\u0005J\u0006\u0010\"\u001a\u00020\u0005J\u0006\u0010#\u001a\u00020\u0005J\u0006\u0010$\u001a\u00020\u0005J\u0006\u0010%\u001a\u00020\u0005J\u000e\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005J\u000e\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0002J\u000e\u0010+\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u0005R\u000e\u0010\u000c\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-", d2 = {"Landroidx/compose/animation/core/ArcSpline$Arc;", "", "mode", "", "time1", "", "time2", "x1", "y1", "x2", "y2", "(IFFFFFF)V", "arcDistance", "arcVelocity", "ellipseA", "ellipseB", "ellipseCenterX", "ellipseCenterY", "isLinear", "", "()Z", "isVertical", "lut", "", "oneOverDeltaTime", "getTime1", "()F", "getTime2", "tmpCosAngle", "tmpSinAngle", "buildTable", "", "calcDX", "calcDY", "calcX", "calcY", "getLinearDX", "getLinearDY", "getLinearX", "time", "getLinearY", "lookup", "v", "setPoint", "Companion", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Arc {

        public static final int $stable = 0;
        public static final androidx.compose.animation.core.ArcSpline.Arc.Companion Companion = null;
        private static final float Epsilon = 0.001f;
        private static float[] _ourPercent;
        private float arcDistance;
        private final float arcVelocity = 0.000000000000000000000000000000000000000000001f;
        private final float ellipseA;
        private final float ellipseB;
        private final float ellipseCenterX = 0.000000000000000000000000000000000000000000001f;
        private final float ellipseCenterY = 0.000000000000000000000000000000000000000000001f;
        private final boolean isLinear = true;
        private final boolean isVertical = true;
        private final float[] lut;
        private final float oneOverDeltaTime = 0f;
        private final float time1;
        private final float time2;
        private float tmpCosAngle;
        private float tmpSinAngle;
        private final float x1;
        private final float x2;
        private final float y1;
        private final float y2;
        static {
            ArcSpline.Arc.Companion companion = new ArcSpline.Arc.Companion(0);
            ArcSpline.Arc.Companion = companion;
            ArcSpline.Arc.$stable = 8;
        }

        public Arc(int mode, float time1, float time2, float x1, float y1, float x2, float y2) {
            int isLinear;
            int i;
            int i3;
            float cmp;
            int i2;
            super();
            this.time1 = time1;
            this.time2 = time2;
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            f -= f2;
            f3 -= f4;
            int i6 = 0;
            int i8 = 0;
            i3 = 1;
            switch (mode) {
                case 1:
                    int i9 = i3;
                    f5 /= i10;
                    isLinear = 0;
                    int i12 = 101;
                    i2 = 981668463;
                    this.lut = new float[i12];
                    int i24 = -1;
                    i = i24;
                    i = i3;
                    this.ellipseA = f6 *= i4;
                    i3 = i24;
                    this.ellipseB = f7 *= i5;
                    float f12 = this.x2;
                    float f8 = this.x1;
                    float f11 = this.y1;
                    float f9 = this.y2;
                    buildTable(this.x1, this.y1, this.x2, this.y2);
                    arcDistance *= oneOverDeltaTime;
                    int isLinear2 = 1;
                    this.arcDistance = (float)hypot;
                    this.arcVelocity = arcDistance2 *= oneOverDeltaTime2;
                    this.ellipseCenterX = i4 / i20;
                    this.ellipseCenterY = i5 / i22;
                    this.lut = new float[i12];
                    int i16 = 2143289344;
                    this.ellipseA = i16;
                    this.ellipseB = i16;
                case 2:
                    break;
                case 3:
                    int i17 = i3;
                    break;
                default:
                    int i18 = i3;
            }
            isLinear = 1;
        }

        public static final float[] access$get_ourPercent$cp() {
            return ArcSpline.Arc._ourPercent;
        }

        public static final void access$set_ourPercent$cp(float[] <set-?>) {
            ArcSpline.Arc._ourPercent = <set-?>;
        }

        private final void buildTable(float x1, float y1, float x2, float y2) {
            int i4;
            int i;
            int i5;
            int i2;
            int lx;
            int ly;
            int dist;
            int i3;
            int length;
            float f3;
            float f;
            float f2;
            double lut;
            int i8;
            double d;
            int i6;
            int a;
            int i7;
            final Object obj = this;
            i4 = x2 - x1;
            i2 = y1 - y2;
            lx = 0;
            ly = 0;
            dist = 0;
            i3 = 0;
            while (i3 < fArr2.length) {
                i17 /= d2;
                f3 = (float)radians;
                lut = i4 * f;
                i8 = i2 * f2;
                if (i3 > 0) {
                } else {
                }
                a = i4;
                i7 = i2;
                lx = lut;
                ly = i8;
                i3++;
                i4 = a;
                i2 = i7;
                a = i4;
                i7 = i2;
                ArcSpline.Arc.Companion.access$getOurPercent(ArcSpline.Arc.Companion)[i3] = dist += f4;
            }
            int a3 = i4;
            int i23 = i2;
            obj.arcDistance = dist;
            i = 0;
            while (i < fArr.length) {
                i3 = ArcSpline.Arc.Companion.access$getOurPercent(ArcSpline.Arc.Companion);
                i3[i] = i12 /= dist;
                i++;
            }
            i5 = 0;
            while (i5 < lut2.length) {
                f = f5 / f6;
                i3 = ArraysKt.binarySearch$default(ArcSpline.Arc.Companion.access$getOurPercent(ArcSpline.Arc.Companion), f, 0, 0, 6, 0);
                if (i3 >= 0) {
                } else {
                }
                if (i3 == -1) {
                } else {
                }
                i11 += -2;
                obj.lut[i5] = i16 /= f10;
                i5++;
                obj.lut[i5] = 0;
                obj.lut[i5] = f7 /= f2;
            }
        }

        private final float lookup(float v) {
            int i = 0;
            if (Float.compare(v, i) <= 0) {
                return i;
            }
            int i2 = 1065353216;
            if (Float.compare(v, i2) >= 0) {
                return i2;
            }
            f *= v;
            int i5 = (int)i4;
            return f3 += i10;
        }

        public final float calcDX() {
            int i;
            ellipseA *= tmpCosAngle;
            arcVelocity /= f;
            i = this.isVertical ? i6 * i5 : i2 * i5;
            return i;
        }

        public final float calcDY() {
            int i;
            i3 *= tmpSinAngle;
            arcVelocity /= f;
            i = this.isVertical ? i6 * i5 : i4 * i5;
            return i;
        }

        public final float calcX() {
            return ellipseCenterX += i2;
        }

        public final float calcY() {
            return ellipseCenterY += i2;
        }

        public final float getLinearDX() {
            return this.ellipseCenterX;
        }

        public final float getLinearDY() {
            return this.ellipseCenterY;
        }

        public final float getLinearX(float time) {
            return t += i6;
        }

        public final float getLinearY(float time) {
            return t += i6;
        }

        public final float getTime1() {
            return this.time1;
        }

        public final float getTime2() {
            return this.time2;
        }

        public final boolean isLinear() {
            return this.isLinear;
        }

        public final void setPoint(float time) {
            int i;
            i = this.isVertical ? time2 - time : time - time1;
            lookup *= i3;
            this.tmpSinAngle = (float)d2;
            this.tmpCosAngle = (float)d4;
        }
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u000b\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Landroidx/compose/animation/core/ArcSpline$Companion;", "", "()V", "ArcAbove", "", "ArcBelow", "ArcStartFlip", "ArcStartHorizontal", "ArcStartLinear", "ArcStartVertical", "DownArc", "StartHorizontal", "StartLinear", "StartVertical", "UpArc", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        ArcSpline.Companion companion = new ArcSpline.Companion(0);
        ArcSpline.Companion = companion;
        ArcSpline.$stable = 8;
    }

    public ArcSpline(int[] arcModes, float[] timePoints, float[][] y) {
        int mode;
        int last;
        int i11;
        androidx.compose.animation.core.ArcSpline.Arc[] arr;
        int i4;
        int i;
        androidx.compose.animation.core.ArcSpline.Arc arc;
        int i6;
        int i10;
        int i8;
        int i12;
        int i3;
        int i9;
        int i13;
        int i7;
        int i5;
        int i2;
        final Object obj2 = this;
        final int[] iArr = timePoints;
        super();
        final int i14 = 1;
        obj2.isExtrapolate = i14;
        mode = 1;
        last = 1;
        length2 -= i14;
        final androidx.compose.animation.core.ArcSpline.Arc[][] arr2 = new ArcSpline.Arc[i17];
        final int i18 = 0;
        i11 = i18;
        while (i11 < i17) {
            int i20 = 2;
            i6 = mode;
            i15 += i19;
            arr = new ArcSpline.Arc[i16];
            i = i18;
            while (i < i16) {
                i7 = i * 2;
                int i22 = i21;
                arc = new ArcSpline.Arc(i6, iArr[i11], iArr[i22], y[i11][i7], y[i11][i7 + 1], y[i22][i7], y[i22][i7 + 1]);
                arr[i] = arc;
                i++;
            }
            arr2[i11] = arr;
            i11++;
            mode = i6;
            i7 = i * 2;
            i22 = i21;
            arc = new ArcSpline.Arc(i6, iArr[i11], iArr[i22], y[i11][i7], y[i11][i7 + 1], y[i22][i7], y[i22][i7 + 1]);
            arr[i] = arc;
            i++;
            i6 = mode;
            i6 = mode;
            if (last == i14) {
            } else {
            }
            i4 = i14;
            mode = i4;
            last = mode;
            i6 = mode;
            i4 = i20;
            mode = 2;
            last = mode;
            i6 = mode;
            mode = 1;
            last = mode;
            i6 = mode;
            i6 = mode;
        }
        obj2.arcs = arr2;
    }

    public final void getPos(float time, float[] v) {
        float t;
        int cmp;
        int populated;
        float time1;
        int cmp2;
        int i2;
        int i3;
        int i5;
        int k;
        int p;
        int j2;
        int i;
        int j;
        int length;
        int linearY;
        int i4;
        t = time;
        int i7 = 0;
        if (this.isExtrapolate) {
            if (Float.compare(t, time12) >= 0) {
                if (Float.compare(t, time2) > 0) {
                    int i6 = 0;
                    int i9 = 0;
                    if (Float.compare(t, time23) > 0) {
                        length6--;
                        time1 = this.arcs[length8--][i7].getTime2();
                    } else {
                        p = 0;
                        time1 = this.arcs[i7][i7].getTime1();
                    }
                    int i8 = t - time1;
                    i5 = 0;
                    j = 0;
                    while (i5 < v.length) {
                        if (this.arcs[p][j].isLinear()) {
                        } else {
                        }
                        this.arcs[p][j].setPoint(time1);
                        v[i5] = calcX2 += i13;
                        v[i5 + 1] = calcY += i4;
                        i5 += 2;
                        j++;
                        v[i5] = linearX2 += i12;
                        v[i5 + 1] = linearY2 += i4;
                    }
                }
                populated = 0;
                i2 = 0;
                while (i2 < arcs6.length) {
                    k = 0;
                    j2 = 0;
                    while (j2 < v.length) {
                        if (Float.compare(t, time24) <= 0) {
                        }
                        j2 += 2;
                        k++;
                        if (this.arcs[i2][k].isLinear()) {
                        } else {
                        }
                        this.arcs[i2][k].setPoint(t);
                        v[j2] = this.arcs[i2][k].calcX();
                        v[j2 + 1] = this.arcs[i2][k].calcY();
                        populated = 1;
                        v[j2] = this.arcs[i2][k].getLinearX(t);
                        v[j2 + 1] = this.arcs[i2][k].getLinearY(t);
                        populated = 1;
                    }
                    i2++;
                    if (Float.compare(t, time24) <= 0) {
                    }
                    j2 += 2;
                    k++;
                    if (this.arcs[i2][k].isLinear()) {
                    } else {
                    }
                    this.arcs[i2][k].setPoint(t);
                    v[j2] = this.arcs[i2][k].calcX();
                    v[j2 + 1] = this.arcs[i2][k].calcY();
                    populated = 1;
                    v[j2] = this.arcs[i2][k].getLinearX(t);
                    v[j2 + 1] = this.arcs[i2][k].getLinearY(t);
                    populated = 1;
                }
            } else {
            }
        }
        if (Float.compare(t, time13) < 0) {
            t = this.arcs[i7][i7].getTime1();
        }
        if (Float.compare(t, time22) > 0) {
            t = this.arcs[length5--][i7].getTime2();
        }
    }

    public final void getSlope(float time, float[] v) {
        float t;
        androidx.compose.animation.core.ArcSpline.Arc cmp;
        int populated;
        int i;
        int i2;
        int j;
        int k;
        int length;
        float linearDY;
        t = time;
        int i3 = 0;
        if (Float.compare(t, time1) < 0) {
            t = this.arcs[i3][i3].getTime1();
        } else {
            if (Float.compare(t, time2) > 0) {
                t = this.arcs[length4--][i3].getTime2();
            }
        }
        populated = 0;
        i = 0;
        while (i < arcs5.length) {
            j = 0;
            k = 0;
            while (j < v.length) {
                if (Float.compare(t, time22) <= 0) {
                }
                j += 2;
                k++;
                if (this.arcs[i][k].isLinear()) {
                } else {
                }
                this.arcs[i][k].setPoint(t);
                v[j] = this.arcs[i][k].calcDX();
                v[j + 1] = this.arcs[i][k].calcDY();
                populated = 1;
                v[j] = this.arcs[i][k].getLinearDX();
                v[j + 1] = this.arcs[i][k].getLinearDY();
                populated = 1;
            }
            i++;
            if (Float.compare(t, time22) <= 0) {
            }
            j += 2;
            k++;
            if (this.arcs[i][k].isLinear()) {
            } else {
            }
            this.arcs[i][k].setPoint(t);
            v[j] = this.arcs[i][k].calcDX();
            v[j + 1] = this.arcs[i][k].calcDY();
            populated = 1;
            v[j] = this.arcs[i][k].getLinearDX();
            v[j + 1] = this.arcs[i][k].getLinearDY();
            populated = 1;
        }
    }
}
