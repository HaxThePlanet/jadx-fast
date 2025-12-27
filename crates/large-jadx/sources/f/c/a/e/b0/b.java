package f.c.a.e.b0;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.StateSet;
import com.google.android.exoplayer2.audio.AudioSink.WriteException;
import d.h.f.a;

/* compiled from: RippleUtils.java */
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
        int i2 = 1;
        final int i3 = 0;
        int[] iArr = new int[i2];
        b.b = new int[] { 0x010100a7 /* Unknown resource */ };
        b.c = new int[] { 0x01010367 /* Unknown resource */, 0x0101009c /* Unknown resource */ };
        int[] iArr5 = new int[i2];
        b.d = new int[] { 0x0101009c /* Unknown resource */ };
        int[] iArr6 = new int[i2];
        b.e = new int[] { 0x01010367 /* Unknown resource */ };
        b.f = new int[] { 0x010100a1 /* Unknown resource */, 0x010100a7 /* Unknown resource */ };
        b.g = new int[] { 0x010100a1 /* Unknown resource */, 0x01010367 /* Unknown resource */, 0x0101009c /* Unknown resource */ };
        b.h = new int[] { 0x010100a1 /* Unknown resource */, 0x0101009c /* Unknown resource */ };
        b.i = new int[] { 0x010100a1 /* Unknown resource */, 0x01010367 /* Unknown resource */ };
        int[] iArr3 = new int[i2];
        b.j = new int[] { 0x010100a1 /* Unknown resource */ };
        b.k = new int[] { 0x0101009e /* Unknown resource */, 0x010100a7 /* Unknown resource */ };
        b.l = b.class.getSimpleName();
    }

    private b() {
        super();
    }

    public static ColorStateList a(ColorStateList list) {
        int i2 = 2;
        int i9 = 1;
        int i15 = 0;
        if (b.a) {
            int[][] iArr = new int[i2];
            int[] iArr3 = new int[i2];
            return new ColorStateList(iArr, iArr3);
        }
        int i = 10;
        int[][] iArr14 = new int[i];
        int[] iArr2 = new int[i];
        int[] iArr15 = b.f;
        iArr14[i15] = iArr15;
        iArr2[i15] = b.c(list, iArr15);
        int[] iArr16 = b.g;
        iArr14[i9] = iArr16;
        iArr2[i9] = b.c(list, iArr16);
        int[] iArr4 = b.h;
        iArr14[i2] = iArr4;
        iArr2[i2] = b.c(list, iArr4);
        int i3 = 3;
        int[] iArr5 = b.i;
        iArr14[i3] = iArr5;
        iArr2[i3] = b.c(list, iArr5);
        int i4 = 4;
        iArr14[i4] = b.j;
        iArr2[i4] = i15;
        int i5 = 5;
        int[] iArr7 = b.b;
        iArr14[i5] = iArr7;
        iArr2[i5] = b.c(list, iArr7);
        int i6 = 6;
        int[] iArr8 = b.c;
        iArr14[i6] = iArr8;
        iArr2[i6] = b.c(list, iArr8);
        int i7 = 7;
        int[] iArr9 = b.d;
        iArr14[i7] = iArr9;
        iArr2[i7] = b.c(list, iArr9);
        int i8 = 8;
        int[] iArr10 = b.e;
        iArr14[i8] = iArr10;
        iArr2[i8] = b.c(list, iArr10);
        int i21 = 9;
        iArr14[i21] = StateSet.NOTHING;
        iArr2[i21] = i15;
        return new ColorStateList(iArr14, iArr2);
    }

    private static int b(int i) {
        return a.i(i, Math.min(Color.alpha(i) * 2, 255));
    }

    private static int c(ColorStateList list, int[] iArr) {
        int colorForState = 0;
        if (list != null) {
            colorForState = list.getColorForState(iArr, list.getDefaultColor());
        } else {
            colorForState = 0;
        }
        if (b.a) {
            colorForState = b.b(colorForState);
        }
        return colorForState;
    }

    public static ColorStateList d(ColorStateList list) {
        int alpha = 0;
        if (list != null) {
            alpha2 = Build.VERSION.SDK_INT;
            int i = 22;
            if (Build.VERSION.SDK_INT >= 22 && Build.VERSION.SDK_INT <= 27) {
                if (Color.alpha(list.getDefaultColor()) == 0) {
                    if (Color.alpha(list.getColorForState(b.k, alpha)) != 0) {
                        Log.w(b.l, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
                    }
                }
            }
            return list;
        }
        return ColorStateList.valueOf(alpha);
    }

    public static boolean e(int[] iArr) {
        boolean z = false;
        int i;
        int i3 = 16842908;
        i = 1;
        for (int i2 : iArr) {
            i3 = 16842910;
        }
        if (i != 0 && i != 0) {
        }
        return z;
    }
}
