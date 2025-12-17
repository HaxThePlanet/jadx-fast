package androidx.core.content.res;

import android.graphics.Canvas;
import android.graphics.Color;
import androidx.core.graphics.ColorUtils;

/* loaded from: classes5.dex */
final class CamUtils {

    static final float[][] CAM16RGB_TO_XYZ;
    static final float[][] SRGB_TO_XYZ;
    static final float[] WHITE_POINT_D65;
    static final float[][] XYZ_TO_CAM16RGB;
    static {
        int i2 = 3;
        float[] fArr3 = new float[i2];
        fArr3 = new int[]{1053652383, 1059484093, -1118648123};
        float[] fArr9 = new float[i2];
        fArr9 = new int[]{-1098898655, 1067067965, 1027330407};
        float[] fArr12 = new float[i2];
        fArr12 = new int[]{-1157087275, 1028162020, 1064566818};
        CamUtils.XYZ_TO_CAM16RGB = /* result */;
        float[] fArr5 = new float[i2];
        fArr5 = new int[]{1072584765, -1082036021, 1041810539};
        float[] fArr10 = new float[i2];
        fArr10 = new int[]{1053190625, 1059002158, -1139603558};
        float[] fArr13 = new float[i2];
        fArr13 = new int[]{-1132345847, -1123302273, 1065772348};
        CamUtils.CAM16RGB_TO_XYZ = /* result */;
        float[] fArr7 = new float[i2];
        fArr7 = new int[]{1119754256, 1120403456, 1121567769};
        CamUtils.WHITE_POINT_D65 = fArr7;
        float[] fArr8 = new float[i2];
        fArr8 = new int[]{1054023191, 1052187149, 1043912633};
        float[] fArr11 = new float[i2];
        fArr11 = new int[]{1046066128, 1060575065, 1033100696};
        float[] fArr = new float[i2];
        fArr = new int[]{1017006063, 1039404073, 1064520140};
        CamUtils.SRGB_TO_XYZ = /* result */;
    }

    static int intFromLStar(float lStar) {
        int i;
        int i6;
        int i5;
        int i3;
        int i4;
        int i2;
        if (Float.compare(lStar, i7) < 0) {
            return -16777216;
        }
        if (Float.compare(lStar, i9) > 0) {
            return -1;
        }
        int i11 = 1098907648;
        i6 = 1122500608;
        i14 /= i6;
        final int i20 = i15;
        final int i21 = i15;
        final int i22 = 1147261687;
        int i25 = 1;
        final int i26 = 0;
        i5 = Float.compare(lStar, i24) > 0 ? i25 : i26;
        i3 = i5 != 0 ? i27 * i15 : lStar / i22;
        i4 = Float.compare(i29, i23) > 0 ? i25 : i26;
        if (i4 != 0) {
            i30 *= i21;
        } else {
            i32 /= i22;
        }
        if (i4 != 0) {
            i12 *= i20;
        } else {
            i = i6 / i22;
        }
        final int i35 = i;
        final int i34 = i15;
        return ColorUtils.XYZToColor((double)i17, obj14, (double)i18);
    }

    static float lStarFromInt(int argb) {
        return CamUtils.lStarFromY(CamUtils.yFromInt(argb));
    }

    static float lStarFromY(float y) {
        y /= i;
        int i2 = 1007753895;
        if (Float.compare(obj4, i3) <= 0) {
            return i4 *= obj4;
        }
        return i7 -= i9;
    }

    static float lerp(float start, float stop, float amount) {
        return i2 += start;
    }

    static float linearized(int rgbComponent) {
        f /= i2;
        final int i11 = 1120403456;
        if (Float.compare(i, i3) <= 0) {
            return i5 *= i11;
        }
        return f2 *= i11;
    }

    static void xyzFromInt(int argb, float[] outXYZ) {
        float linearized = CamUtils.linearized(Color.red(argb));
        float linearized2 = CamUtils.linearized(Color.green(argb));
        float linearized3 = CamUtils.linearized(Color.blue(argb));
        final float[][] sRGB_TO_XYZ = CamUtils.SRGB_TO_XYZ;
        int i2 = 0;
        final int i18 = 1;
        final int i19 = 2;
        outXYZ[i2] = i7 += i15;
        outXYZ[i18] = i10 += i17;
        outXYZ[i19] = i4 += i13;
    }

    static float yFromInt(int argb) {
        final float[][] sRGB_TO_XYZ = CamUtils.SRGB_TO_XYZ;
        int i2 = 1;
        return i5 += i3;
    }

    static float yFromLStar(float lstar) {
        final int i6 = 1120403456;
        if (Float.compare(lstar, i) > 0) {
            return f *= i6;
        }
        return i4 *= i6;
    }
}
