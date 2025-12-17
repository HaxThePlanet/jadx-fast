package androidx.core.content.res;

import androidx.core.graphics.ColorUtils;

/* loaded from: classes5.dex */
public class CamColor {

    private static final float CHROMA_SEARCH_ENDPOINT = 0.4f;
    private static final float DE_MAX = 1f;
    private static final float DL_MAX = 0.2f;
    private static final float LIGHTNESS_SEARCH_ENDPOINT = 0.01f;
    private final float mAstar;
    private final float mBstar;
    private final float mChroma;
    private final float mHue;
    private final float mJ;
    private final float mJstar;
    private final float mM;
    private final float mQ;
    private final float mS;
    CamColor(float hue, float chroma, float j, float q, float m, float s, float jStar, float aStar, float bStar) {
        super();
        this.mHue = hue;
        this.mChroma = chroma;
        this.mJ = j;
        this.mQ = q;
        this.mM = m;
        this.mS = s;
        this.mJstar = jStar;
        this.mAstar = aStar;
        this.mBstar = bStar;
    }

    private static androidx.core.content.res.CamColor findCamByJ(float hue, float chroma, float lstar) {
        int low;
        int high;
        int mid;
        int bestdL;
        int bestdE;
        int bestCam;
        androidx.core.content.res.CamColor cmp;
        int viewedInSrgb;
        float lStarFromInt;
        float f;
        int camClipped;
        int color;
        int distance;
        int cmp2;
        low = 0;
        high = 1120403456;
        mid = 0;
        bestdL = 1148846080;
        bestdE = 1148846080;
        bestCam = 0;
        while (Float.compare(f2, viewedInSrgb) > 0) {
            mid = low + i3;
            viewedInSrgb = CamColor.fromJch(mid, chroma, hue).viewedInSrgb();
            lStarFromInt = CamUtils.lStarFromInt(viewedInSrgb);
            f = Math.abs(lstar - lStarFromInt);
            color = CamColor.fromColor(viewedInSrgb);
            distance = color.distance(CamColor.fromJch(color.getJ(), color.getChroma(), hue));
            if (Float.compare(f, i6) < 0 && Float.compare(distance, i7) <= 0) {
            }
            camClipped = 0;
            if (Float.compare(bestdL, camClipped) == 0) {
                break;
            } else {
            }
            if (Float.compare(lStarFromInt, lstar) < 0) {
            } else {
            }
            high = mid;
            low = mid;
            if (Float.compare(bestdE, camClipped) == 0) {
                break;
            } else {
            }
            color = CamColor.fromColor(viewedInSrgb);
            distance = color.distance(CamColor.fromJch(color.getJ(), color.getChroma(), hue));
            if (Float.compare(distance, i7) <= 0) {
            }
            bestdL = f;
            bestdE = distance;
            bestCam = color;
        }
        return bestCam;
    }

    static androidx.core.content.res.CamColor fromColor(int color) {
        float[] fArr = new float[7];
        int i2 = 3;
        final float[] fArr2 = new float[i2];
        CamColor.fromColorInViewingConditions(color, ViewingConditions.DEFAULT, fArr, fArr2);
        int i6 = 0;
        int i8 = i7;
        CamColor camColor = new CamColor(fArr2[i6], fArr2[i8], fArr[i6], fArr[i8], fArr[2], fArr[i2], fArr[4], fArr[5], fArr[6]);
        return camColor;
    }

    static void fromColorInViewingConditions(int color, androidx.core.content.res.ViewingConditions viewingConditions, float[] outCamColor, float[] outM3HCT) {
        int i2;
        int i;
        int i3;
        int i11 = color;
        CamUtils.xyzFromInt(i11, outM3HCT);
        int[] iArr = outM3HCT;
        float[][] xYZ_TO_CAM16RGB = CamUtils.XYZ_TO_CAM16RGB;
        int i54 = 0;
        int i85 = 1;
        int i93 = 2;
        i70 += i105;
        f28 *= i71;
        f31 *= i109;
        f32 *= i117;
        float f34 = Math.abs(i122);
        long l4 = 4636737291354636288L;
        final int i136 = i54;
        final int i137 = i71;
        long l2 = 4601237667291888353L;
        float f33 = (float)d26;
        int i138 = i85;
        float f19 = (float)d22;
        float f = (float)d2;
        int i55 = 1137180672;
        int i72 = 1104742973;
        i13 /= i95;
        i97 /= i128;
        i130 /= i73;
        final float f38 = f;
        final int i141 = i14;
        f2 /= i15;
        int[] iArr2 = iArr;
        long l7 = 4611686018427387904L;
        f7 /= i35;
        int i36 = 1101004800;
        i80 /= i36;
        float[][] arr = xYZ_TO_CAM16RGB;
        float f15 = (float)atan2;
        int i49 = 1127481344;
        int i82 = 1078530011;
        i64 /= i82;
        int i150 = 1135869952;
        i = Float.compare(i65, i148) < 0 ? i65 + i150 : cmp3 >= 0 ? i65 - i150 : i65;
        int i152 = i;
        i83 /= i49;
        nbb *= i147;
        final int i135 = i6;
        int i149 = i18;
        float f40 = f15;
        final int i162 = i50;
        int i19 = 1120403456;
        f3 *= i19;
        int i51 = 1082130432;
        int i163 = i51;
        int i134 = i65;
        i39 *= flRoot;
        int i22 = i152;
        i3 = Double.compare(d16, l10) < 0 ? i22 + i150 : i22;
        int i52 = i3;
        int i66 = i40;
        f9 *= i41;
        i44 *= ncb;
        int i153 = i27;
        i46 /= i29;
        int i145 = i52;
        final int i166 = i98;
        final float f41 = f12;
        int i67 = i47;
        f17 *= f13;
        f14 *= i53;
        flRoot2 *= i31;
        aw2 += i163;
        int i160 = 1065353216;
        i2 = 1110405192;
        int i161 = i8;
        outM3HCT[i136] = i22;
        outM3HCT[i138] = i31;
        if (outCamColor != null) {
            outCamColor[i136] = i7;
            outCamColor[i138] = i66;
            outCamColor[i93] = i48;
            outCamColor[3] = f21 *= i100;
            outCamColor[4] = i102 /= i156;
            outCamColor[5] = f5 *= i161;
            outCamColor[6] = f6 *= i161;
        }
    }

    private static androidx.core.content.res.CamColor fromJch(float j, float c, float h) {
        return CamColor.fromJchInFrame(j, c, h, ViewingConditions.DEFAULT);
    }

    private static androidx.core.content.res.CamColor fromJchInFrame(float j, float c, float h, androidx.core.content.res.ViewingConditions viewingConditions) {
        int i10 = 1082130432;
        long l3 = 4636737291354636288L;
        final int i25 = c * flRoot;
        final int i34 = i7 / i12;
        int i16 = 1110405192;
        final int i35 = f5 * i16;
        CamColor camColor = new CamColor(h, c, j, i3 * flRoot2, i25, f4 * i11, i9 / i15, i35 * f6, i35 * f7);
        return camColor;
    }

    public static void getM3HCTfromColor(int color, float[] outM3HCT) {
        CamColor.fromColorInViewingConditions(color, ViewingConditions.DEFAULT, 0, outM3HCT);
        outM3HCT[2] = CamUtils.lStarFromInt(color);
    }

    public static int toColor(float hue, float chroma, float lStar) {
        return CamColor.toColor(hue, chroma, lStar, ViewingConditions.DEFAULT);
    }

    static int toColor(float hue, float chroma, float lstar, androidx.core.content.res.ViewingConditions viewingConditions) {
        int cmp;
        float i2;
        float mid;
        long l;
        int low;
        int isFirstLoop;
        int answer;
        androidx.core.content.res.CamColor camByJ;
        int i3;
        int i;
        int obj8;
        if (Double.compare(d, l) >= 0 && Double.compare(d2, l) > 0) {
            if (Double.compare(d2, l) > 0) {
                if (Double.compare(d3, l) >= 0) {
                } else {
                    if (Float.compare(hue, i2) < 0) {
                    } else {
                        i2 = Math.min(1135869952, hue);
                    }
                    obj8 = chroma;
                    mid = chroma;
                    low = 0;
                    isFirstLoop = 1;
                    answer = 0;
                    while (Float.compare(f, i6) >= 0) {
                        camByJ = CamColor.findCamByJ(i2, mid, lstar);
                        i3 = 1073741824;
                        if (camByJ == null) {
                        } else {
                        }
                        answer = camByJ;
                        low = mid;
                        mid = low + i;
                        obj8 = mid;
                        isFirstLoop = 0;
                        mid = low + i;
                    }
                    if (answer == 0) {
                        return CamUtils.intFromLStar(lstar);
                    }
                }
                return answer.viewed(viewingConditions);
            }
        }
        return CamUtils.intFromLStar(lstar);
    }

    float distance(androidx.core.content.res.CamColor other) {
        jStar -= jStar2;
        aStar -= aStar2;
        bStar -= bStar2;
        int i8 = i3 * i3;
        return (float)i9;
    }

    float getAStar() {
        return this.mAstar;
    }

    float getBStar() {
        return this.mBstar;
    }

    float getChroma() {
        return this.mChroma;
    }

    float getHue() {
        return this.mHue;
    }

    float getJ() {
        return this.mJ;
    }

    float getJStar() {
        return this.mJstar;
    }

    float getM() {
        return this.mM;
    }

    float getQ() {
        return this.mQ;
    }

    float getS() {
        return this.mS;
    }

    int viewed(androidx.core.content.res.ViewingConditions viewingConditions) {
        int i;
        int cmp;
        float f;
        double sqrt;
        int i14 = 0;
        long l = 4636737291354636288L;
        if (Double.compare(d, i14) != 0) {
            if (Double.compare(d2, i14) == 0) {
                i = 0;
            } else {
                chroma2 /= f;
            }
        } else {
        }
        l7 -= d28;
        long l3 = 4607682818758614130L;
        float f15 = (float)d24;
        i37 /= i40;
        i48 /= d20;
        i31 *= ncb;
        int i34 = i45 / nbb;
        float f25 = (float)d32;
        float f26 = (float)d34;
        int i55 = 1102577664;
        i53 /= i58;
        int i59 = i54 * f26;
        int i66 = i54 * f25;
        int i67 = 1139146752;
        int i80 = 1152344064;
        i74 /= i80;
        i84 /= i80;
        i70 /= i80;
        long l9 = 4628329633800288993L;
        int i81 = i;
        final float f31 = f15;
        long l10 = 4645744490609377280L;
        float f4 = (float)d11;
        int i24 = 1120403456;
        signum *= i17;
        int i104 = i24;
        final float f35 = f4;
        f17 *= i112;
        float f5 = (float)d6;
        int i26 = i104 / fl2;
        signum2 *= i26;
        final float f40 = f5;
        int i11 = i121 * f6;
        float f9 = (float)d8;
        int i27 = i104 / fl3;
        signum3 *= i27;
        float f27 = f9;
        int i13 = i94 * f10;
        int i21 = 0;
        int i28 = i120 / f11;
        int i95 = 1;
        int i8 = i99 / f12;
        int i102 = 2;
        int i100 = i13 / f30;
        final float[][] cAM16RGB_TO_XYZ = CamUtils.CAM16RGB_TO_XYZ;
        final int i118 = i21;
        int i22 = i106 + i114;
        int i103 = i13;
        int i111 = i28;
        int i98 = i33;
        int i117 = i22;
        return ColorUtils.XYZToColor((double)i22, obj33, (double)gF);
    }

    int viewedInSrgb() {
        return viewed(ViewingConditions.DEFAULT);
    }
}
