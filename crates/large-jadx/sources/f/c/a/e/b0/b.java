package f.c.a.e.b0;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.StateSet;
import com.google.android.exoplayer2.audio.AudioSink.WriteException;
import d.h.f.a;

/* loaded from: classes2.dex */
public class b {

    public static final boolean a = false;
    private static final int[] b;
    private static final int[] c;
    private static final int[] d;
    private static final int[] e;
    private static final int[] f;
    private static final int[] g;
    private static final int[] h;
    private static final int[] i;
    private static final int[] j;
    private static final int[] k;
    static final String l;
    static {
        int i6 = 1;
        final int i7 = 0;
        if (Build.VERSION.SDK_INT >= 21) {
            int i2 = i6;
        }
        int i3 = i7;
        int[] iArr = new int[i6];
        iArr[i7] = 16842919;
        b.b = iArr;
        int i4 = 2;
        int[] iArr4 = new int[i4];
        iArr4 = new int[]{16843623, 16842908};
        b.c = iArr4;
        int[] iArr5 = new int[i6];
        iArr5[i7] = 16842908;
        b.d = iArr5;
        int[] iArr6 = new int[i6];
        iArr6[i7] = 16843623;
        b.e = iArr6;
        int[] iArr7 = new int[i4];
        iArr7 = new int[]{16842913, 16842919};
        b.f = iArr7;
        int[] iArr8 = new int[3];
        iArr8 = new int[]{16842913, 16843623, 16842908};
        b.g = iArr8;
        int[] iArr9 = new int[i4];
        iArr9 = new int[]{16842913, 16842908};
        b.h = iArr9;
        int[] iArr10 = new int[i4];
        iArr10 = new int[]{16842913, 16843623};
        b.i = iArr10;
        int[] iArr3 = new int[i6];
        iArr3[i7] = 16842913;
        b.j = iArr3;
        int[] iArr2 = new int[i4];
        iArr2 = new int[]{16842910, 16842919};
        b.k = iArr2;
        b.l = b.class.getSimpleName();
    }

    public static ColorStateList a(ColorStateList colorStateList) {
        int i2 = 2;
        int i9 = 1;
        int i15 = 0;
        if (b.a) {
            int[][] iArr = new int[i2];
            int[] iArr3 = new int[i2];
            iArr[i15] = b.j;
            iArr3[i15] = b.c(colorStateList, b.f);
            iArr[i9] = StateSet.NOTHING;
            iArr3[i9] = b.c(colorStateList, b.b);
            ColorStateList obj6 = new ColorStateList(iArr, iArr3);
            return obj6;
        }
        int i = 10;
        int[][] iArr14 = new int[i];
        int[] iArr2 = new int[i];
        int[] iArr15 = b.f;
        iArr14[i15] = iArr15;
        iArr2[i15] = b.c(colorStateList, iArr15);
        int[] iArr16 = b.g;
        iArr14[i9] = iArr16;
        iArr2[i9] = b.c(colorStateList, iArr16);
        int[] iArr4 = b.h;
        iArr14[i2] = iArr4;
        iArr2[i2] = b.c(colorStateList, iArr4);
        int i3 = 3;
        int[] iArr5 = b.i;
        iArr14[i3] = iArr5;
        iArr2[i3] = b.c(colorStateList, iArr5);
        int i4 = 4;
        iArr14[i4] = b.j;
        iArr2[i4] = i15;
        int i5 = 5;
        int[] iArr7 = b.b;
        iArr14[i5] = iArr7;
        iArr2[i5] = b.c(colorStateList, iArr7);
        int i6 = 6;
        int[] iArr8 = b.c;
        iArr14[i6] = iArr8;
        iArr2[i6] = b.c(colorStateList, iArr8);
        int i7 = 7;
        int[] iArr9 = b.d;
        iArr14[i7] = iArr9;
        iArr2[i7] = b.c(colorStateList, iArr9);
        int i8 = 8;
        int[] iArr10 = b.e;
        iArr14[i8] = iArr10;
        iArr2[i8] = b.c(colorStateList, iArr10);
        obj6 = 9;
        iArr14[obj6] = StateSet.NOTHING;
        iArr2[obj6] = i15;
        obj6 = new ColorStateList(iArr14, iArr2);
        return obj6;
    }

    private static int b(int i) {
        return a.i(i, Math.min(alpha *= 2, 255));
    }

    private static int c(ColorStateList colorStateList, int[] i2Arr2) {
        int defaultColor;
        int obj1;
        if (colorStateList != null) {
            obj1 = colorStateList.getColorForState(i2Arr2, colorStateList.getDefaultColor());
        } else {
            obj1 = 0;
        }
        if (b.a) {
            obj1 = b.b(obj1);
        }
        return obj1;
    }

    public static ColorStateList d(ColorStateList colorStateList) {
        int alpha;
        int sDK_INT;
        int i;
        alpha = 0;
        sDK_INT = Build.VERSION.SDK_INT;
        if (colorStateList != null && sDK_INT >= 22 && sDK_INT <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(b.k, alpha)) != 0) {
            sDK_INT = Build.VERSION.SDK_INT;
            if (sDK_INT >= 22) {
                if (sDK_INT <= 27) {
                    if (Color.alpha(colorStateList.getDefaultColor()) == 0) {
                        if (Color.alpha(colorStateList.getColorForState(b.k, alpha)) != 0) {
                            Log.w(b.l, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
                        }
                    }
                }
            }
            return colorStateList;
        }
        return ColorStateList.valueOf(alpha);
    }

    public static boolean e(int[] iArr) {
        int i2;
        int i3;
        int i7;
        int i4;
        int i5;
        int i6;
        int i;
        i4 = i7;
        i5 = 1;
        while (i3 < iArr.length) {
            i6 = iArr[i3];
            if (i6 == 16842910) {
            } else {
            }
            if (i6 == 16842908) {
            } else {
            }
            if (i6 == 16842919) {
            } else {
            }
            if (i6 == 16843623) {
            }
            i3++;
            i5 = 1;
            i4 = i5;
            i7 = i5;
        }
        if (i7 != 0 && i4 != 0) {
            if (i4 != 0) {
                i2 = i5;
            }
        }
        return i2;
    }
}
