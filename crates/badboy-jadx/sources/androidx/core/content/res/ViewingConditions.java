package androidx.core.content.res;

/* loaded from: classes5.dex */
final class ViewingConditions {

    static final androidx.core.content.res.ViewingConditions DEFAULT;
    private final float mAw;
    private final float mC;
    private final float mFl;
    private final float mFlRoot;
    private final float mN;
    private final float mNbb;
    private final float mNc;
    private final float mNcb;
    private final float[] mRgbD;
    private final float mZ;
    static {
        final int i = 1112014848;
        ViewingConditions.DEFAULT = ViewingConditions.make(CamUtils.WHITE_POINT_D65, (float)i3, i, 1073741824, false);
    }

    private ViewingConditions(float n, float aw, float nbb, float ncb, float c, float nc, float[] rgbD, float fl, float fLRoot, float z) {
        super();
        this.mN = n;
        this.mAw = aw;
        this.mNbb = nbb;
        this.mNcb = ncb;
        this.mC = c;
        this.mNc = nc;
        this.mRgbD = rgbD;
        this.mFl = fl;
        this.mFlRoot = fLRoot;
        this.mZ = z;
    }

    static androidx.core.content.res.ViewingConditions make(float[] whitepoint, float adaptingLuminance, float backgroundLstar, float surround, boolean discountingIlluminant) {
        float lerp;
        int i;
        int i2;
        int cmp;
        int i3;
        long l;
        int i4 = adaptingLuminance;
        final float[][] xYZ_TO_CAM16RGB = CamUtils.XYZ_TO_CAM16RGB;
        int[] iArr = whitepoint;
        int i5 = 0;
        int i21 = 1;
        int i30 = 2;
        i10 += i40;
        i43 += i48;
        i51 += i56;
        int i57 = 1092616192;
        int i64 = 1061997773;
        i62 += i64;
        int i96 = 1058474557;
        if (Double.compare(d12, l4) >= 0) {
            lerp = CamUtils.lerp(i96, 1060152279, i84 *= i57);
        } else {
            lerp = CamUtils.lerp(1057384038, i96, i82 *= i57);
        }
        int i58 = 1065353216;
        if (discountingIlluminant) {
            i2 = i58;
        } else {
            int i95 = 1119354880;
            i81 *= i63;
        }
        i3 = Double.compare(d13, l) > 0 ? i58 : cmp3 < 0 ? 0 : i2;
        final int i121 = i3;
        int i65 = 1120403456;
        int i109 = 3;
        float[] fArr13 = new float[i109];
        fArr13[i5] = i87 -= i121;
        fArr13[i21] = i99 -= i121;
        fArr13[i30] = i68 -= i121;
        final float[] fArr14 = fArr13;
        final int i122 = i58 / i72;
        final int i123 = i74 * i122;
        i58 -= i123;
        int i101 = i5;
        i75 += i92;
        int i12 = whitepoint[i21];
        int i93 = yFromLStar / i12;
        int i13 = 1069379748;
        int i117 = i30;
        i14 /= f4;
        long l6 = 4636737291354636288L;
        final int i125 = i7;
        int i119 = i15;
        long l2 = 4601237667291888353L;
        final int i126 = i101;
        float[] fArr12 = new float[3];
        fArr12[i126] = (float)d9;
        fArr12[i125] = (float)d16;
        fArr12[i117] = (float)d7;
        float[] fArr = fArr12;
        int i25 = 1137180672;
        int i106 = 1104742973;
        float[] fArr3 = new float[3];
        fArr3[i126] = i17 /= i33;
        fArr3[i125] = i34 /= i110;
        fArr3[i117] = i111 /= i26;
        float[][] arr = xYZ_TO_CAM16RGB;
        int[] iArr2 = iArr;
        final float[] fArr15 = fArr;
        androidx.core.content.res.ViewingConditions fl = viewingConditions;
        super(i93, i38 * i119, i119, i15, lerp, i63, fArr14, i76, (float)d2, f3 + i13);
        return fl;
    }

    float getAw() {
        return this.mAw;
    }

    float getC() {
        return this.mC;
    }

    float getFl() {
        return this.mFl;
    }

    float getFlRoot() {
        return this.mFlRoot;
    }

    float getN() {
        return this.mN;
    }

    float getNbb() {
        return this.mNbb;
    }

    float getNc() {
        return this.mNc;
    }

    float getNcb() {
        return this.mNcb;
    }

    float[] getRgbD() {
        return this.mRgbD;
    }

    float getZ() {
        return this.mZ;
    }
}
