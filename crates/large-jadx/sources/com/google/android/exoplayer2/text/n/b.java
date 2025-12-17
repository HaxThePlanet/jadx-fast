package com.google.android.exoplayer2.text.n;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.c.b;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import com.vimeo.stag.generated.Stag.u0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class b {

    private static final byte[] h;
    private static final byte[] i;
    private static final byte[] j;
    private final Paint a;
    private final Paint b;
    private final Canvas c;
    private final com.google.android.exoplayer2.text.n.b.b d;
    private final com.google.android.exoplayer2.text.n.b.a e;
    private final com.google.android.exoplayer2.text.n.b.h f;
    private Bitmap g;

    private static final class a {

        public final int a;
        public final int[] b;
        public final int[] c;
        public final int[] d;
        public a(int i, int[] i2Arr2, int[] i3Arr3, int[] i4Arr4) {
            super();
            this.a = i;
            this.b = i2Arr2;
            this.c = i3Arr3;
            this.d = i4Arr4;
        }
    }

    private static final class b {

        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public b(int i, int i2, int i3, int i4, int i5, int i6) {
            super();
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
        }
    }

    private static final class c {

        public final int a;
        public final boolean b;
        public final byte[] c;
        public final byte[] d;
        public c(int i, boolean z2, byte[] b3Arr3, byte[] b4Arr4) {
            super();
            this.a = i;
            this.b = z2;
            this.c = b3Arr3;
            this.d = b4Arr4;
        }
    }

    private static final class d {

        public final int a;
        public final int b;
        public final SparseArray<com.google.android.exoplayer2.text.n.b.e> c;
        public d(int i, int i2, int i3, SparseArray<com.google.android.exoplayer2.text.n.b.e> sparseArray4) {
            super();
            this.a = i2;
            this.b = i3;
            this.c = sparseArray4;
        }
    }

    private static final class e {

        public final int a;
        public final int b;
        public e(int i, int i2) {
            super();
            this.a = i;
            this.b = i2;
        }
    }

    private static final class f {

        public final int a;
        public final boolean b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        public final SparseArray<com.google.android.exoplayer2.text.n.b.g> j;
        public f(int i, boolean z2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, SparseArray<com.google.android.exoplayer2.text.n.b.g> sparseArray11) {
            super();
            this.a = i;
            this.b = z2;
            this.c = i3;
            this.d = i4;
            this.e = i6;
            this.f = i7;
            this.g = i8;
            this.h = i9;
            this.i = i10;
            this.j = sparseArray11;
        }

        public void a(com.google.android.exoplayer2.text.n.b.f b$f) {
            int i;
            SparseArray sparseArray;
            int keyAt;
            Object valueAt;
            final SparseArray obj5 = f.j;
            i = 0;
            while (i < obj5.size()) {
                this.j.put(obj5.keyAt(i), (b.g)obj5.valueAt(i));
                i++;
            }
        }
    }

    private static final class g {

        public final int a;
        public final int b;
        public g(int i, int i2, int i3, int i4, int i5, int i6) {
            super();
            this.a = i3;
            this.b = i4;
        }
    }

    private static final class h {

        public final int a;
        public final int b;
        public final SparseArray<com.google.android.exoplayer2.text.n.b.f> c;
        public final SparseArray<com.google.android.exoplayer2.text.n.b.a> d;
        public final SparseArray<com.google.android.exoplayer2.text.n.b.c> e;
        public final SparseArray<com.google.android.exoplayer2.text.n.b.a> f;
        public final SparseArray<com.google.android.exoplayer2.text.n.b.c> g;
        public com.google.android.exoplayer2.text.n.b.b h;
        public com.google.android.exoplayer2.text.n.b.d i;
        public h(int i, int i2) {
            super();
            this.a = i;
            this.b = i2;
            SparseArray obj1 = new SparseArray();
            this.c = obj1;
            obj1 = new SparseArray();
            this.d = obj1;
            obj1 = new SparseArray();
            this.e = obj1;
            obj1 = new SparseArray();
            this.f = obj1;
            obj1 = new SparseArray();
            this.g = obj1;
        }

        public void a() {
            this.c.clear();
            this.d.clear();
            this.e.clear();
            this.f.clear();
            this.g.clear();
            int i = 0;
            this.h = i;
            this.i = i;
        }
    }
    static {
        int i = 4;
        final byte[] bArr3 = new byte[i];
        bArr3 = new byte[]{0, 7, 8, 15};
        b.h = bArr3;
        byte[] bArr = new byte[i];
        bArr = new byte[]{0, 119, -120, -1};
        b.i = bArr;
        byte[] bArr2 = new byte[16];
        bArr2 = new byte[]{0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
        b.j = bArr2;
    }

    public b(int i, int i2) {
        super();
        Paint paint = new Paint();
        this.a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        paint.setXfermode(porterDuffXfermode);
        int i3 = 0;
        paint.setPathEffect(i3);
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        PorterDuffXfermode porterDuffXfermode2 = new PorterDuffXfermode(PorterDuff.Mode.DST_OVER);
        paint2.setXfermode(porterDuffXfermode2);
        paint2.setPathEffect(i3);
        Canvas canvas = new Canvas();
        this.c = canvas;
        final int i6 = 0;
        super(719, 575, i6, 719, 0, 575);
        this.d = bVar;
        b.a aVar = new b.a(i6, b.c(), b.d(), b.e());
        this.e = aVar;
        b.h hVar = new b.h(i, i2);
        this.f = hVar;
    }

    private static byte[] a(int i, int i2, c0 c03) {
        int i3;
        byte b;
        final byte[] bArr = new byte[i];
        i3 = 0;
        while (i3 < i) {
            bArr[i3] = (byte)i4;
            i3++;
        }
        return bArr;
    }

    private static int[] c() {
        int[] iArr = new int[4];
        iArr = new int[]{0, -1, -16777216, -8421505};
        return iArr;
    }

    private static int[] d() {
        int i5;
        int i7;
        int i3;
        int i6;
        int i;
        int i4;
        int i8;
        int i2;
        final int i9 = 16;
        final int[] iArr = new int[i9];
        final int i10 = 0;
        iArr[i10] = i10;
        i5 = 1;
        while (i5 < i9) {
            i = 255;
            if (i5 < 8) {
            } else {
            }
            i4 = 127;
            if (i5 & 1 != 0) {
            } else {
            }
            i6 = i10;
            if (i5 & 2 != 0) {
            } else {
            }
            i8 = i10;
            if (i5 & 4 != 0) {
            } else {
            }
            i4 = i10;
            iArr[i5] = b.f(i, i6, i8, i4);
            i5++;
            i8 = i4;
            i6 = i4;
            if (i5 & 1 != 0) {
            } else {
            }
            i3 = i10;
            if (i5 & 2 != 0) {
            } else {
            }
            i4 = i10;
            if (i5 & 4 != 0) {
            } else {
            }
            i8 = i10;
            iArr[i5] = b.f(i, i3, i4, i8);
            i8 = i;
            i4 = i;
            i3 = i;
        }
        return iArr;
    }

    private static int[] e() {
        int i19;
        int i4;
        int i20;
        int i21;
        int i5;
        int i;
        int i23;
        int i8;
        int i7;
        int i6;
        int i24;
        int i14;
        int i10;
        int i17;
        int i9;
        int i12;
        int i13;
        int i15;
        int i16;
        int i22;
        int i2;
        int i18;
        int i3;
        int i11;
        final int i25 = 256;
        final int[] iArr = new int[i25];
        final int i26 = 0;
        iArr[i26] = i26;
        i19 = i26;
        while (i19 < i25) {
            int i27 = 8;
            i23 = 255;
            if (i19 < i27) {
            } else {
            }
            i6 = i19 & 136;
            i15 = 170;
            i16 = 85;
            if (i6 != 0) {
            } else {
            }
            if (i19 & 1 != 0) {
            } else {
            }
            i20 = i26;
            if (i19 & 16 != 0) {
            } else {
            }
            i24 = i26;
            if (i19 & 2 != 0) {
            } else {
            }
            i14 = i26;
            if (i19 & 32 != 0) {
            } else {
            }
            i2 = i26;
            if (i19 & 4 != 0) {
            } else {
            }
            i16 = i26;
            if (i19 & 64 != 0) {
            } else {
            }
            i15 = i26;
            iArr[i19] = b.f(i23, i20 += i24, i14 += i2, i16 += i15);
            i19++;
            i2 = i15;
            i14 = i16;
            i24 = i15;
            i20 = i16;
            i22 = 127;
            if (i6 != i27) {
            } else {
            }
            if (i19 & 1 != 0) {
            } else {
            }
            i21 = i26;
            if (i19 & 16 != 0) {
            } else {
            }
            i8 = i26;
            if (i19 & 2 != 0) {
            } else {
            }
            i7 = i26;
            if (i19 & 32 != 0) {
            } else {
            }
            i10 = i26;
            if (i19 & 4 != 0) {
            } else {
            }
            i16 = i26;
            if (i19 & 64 != 0) {
            } else {
            }
            i15 = i26;
            iArr[i19] = b.f(i22, i21 += i8, i7 += i10, i16 += i15);
            i10 = i15;
            i7 = i16;
            i8 = i15;
            i21 = i16;
            i15 = 43;
            if (i6 != 128) {
            } else {
            }
            if (i19 & 1 != 0) {
            } else {
            }
            i5 = i26;
            if (i19 & 16 != 0) {
            } else {
            }
            i17 = i26;
            if (i19 & 2 != 0) {
            } else {
            }
            i9 = i26;
            if (i19 & 32 != 0) {
            } else {
            }
            i11 = i26;
            if (i19 & 4 != 0) {
            } else {
            }
            i15 = i26;
            if (i19 & 64 != 0) {
            } else {
            }
            i16 = i26;
            iArr[i19] = b.f(i23, i35 += i17, i48 += i11, i52 += i16);
            i11 = i16;
            i9 = i15;
            i17 = i16;
            i5 = i15;
            if (i6 != 136) {
            } else {
            }
            if (i19 & 1 != 0) {
            } else {
            }
            i = i26;
            if (i19 & 16 != 0) {
            } else {
            }
            i12 = i26;
            if (i19 & 2 != 0) {
            } else {
            }
            i13 = i26;
            if (i19 & 32 != 0) {
            } else {
            }
            i18 = i26;
            if (i19 & 4 != 0) {
            } else {
            }
            i15 = i26;
            if (i19 & 64 != 0) {
            } else {
            }
            i16 = i26;
            iArr[i19] = b.f(i23, i += i12, i13 += i18, i15 += i16);
            i18 = i16;
            i13 = i15;
            i12 = i16;
            i = i15;
            if (i19 & 1 != 0) {
            } else {
            }
            i6 = i26;
            if (i19 & 2 != 0) {
            } else {
            }
            i15 = i26;
            if (i19 & 4 != 0) {
            } else {
            }
            i23 = i26;
            iArr[i19] = b.f(63, i6, i15, i23);
            i15 = i23;
            i6 = i23;
        }
        return iArr;
    }

    private static int f(int i, int i2, int i3, int i4) {
        return obj0 |= i4;
    }

    private static int g(c0 c0, int[] i2Arr2, byte[] b3Arr3, int i4, int i5, Paint paint6, Canvas canvas7) {
        int i10;
        int i8;
        int i6;
        boolean z;
        int i11;
        int i2;
        int i9;
        Paint paint;
        int i;
        int i7;
        int i3;
        final Object obj = c0;
        final int i12 = i5;
        final Paint paint2 = paint6;
        final int i21 = 0;
        i = i4;
        i10 = i21;
        i8 = 2;
        i2 = 1;
        while (c0.h(i8) != 0) {
            i7 = i10;
            i3 = i2;
            if (i3 != 0 && paint2 != null && b3Arr3 != null) {
            }
            if (i7 == 0) {
            }
            i10 = i7;
            i8 = 2;
            i2 = 1;
            i9 = 3;
            if (c0.g()) {
            } else {
            }
            if (c0.g()) {
            } else {
            }
            z = c0.h(i8);
            if (z != 0) {
            } else {
            }
            i7 = i2;
            i3 = i6;
            if (z != i2) {
            } else {
            }
            i7 = i10;
            i3 = i8;
            i6 = i21;
            if (z != i8) {
            } else {
            }
            i19 += 12;
            i8 = c0.h(i8);
            i7 = i10;
            i3 = i11;
            i6 = i8;
            if (z != i9) {
            } else {
            }
            i17 += 29;
            i8 = c0.h(i8);
            i7 = i10;
            i7 = i10;
            i3 = i2;
            i20 += i9;
            i8 = c0.h(i8);
            if (paint2 != null) {
            }
            if (b3Arr3 != null) {
            }
            paint2.setColor(i2Arr2[i6]);
            canvas7.drawRect((float)i, (float)i12, (float)i14, (float)i15, paint6);
            i6 = b3Arr3[i6];
        }
        return i += i3;
    }

    private static int h(c0 c0, int[] i2Arr2, byte[] b3Arr3, int i4, int i5, Paint paint6, Canvas canvas7) {
        int i2;
        int i;
        int i3;
        boolean z;
        int i11;
        int i6;
        int i10;
        int i7;
        int i8;
        int i9;
        final Object obj = c0;
        final int i12 = i5;
        final Paint paint = paint6;
        final int i20 = 0;
        i7 = i4;
        i2 = i20;
        i = 4;
        i11 = 2;
        i6 = 1;
        while (c0.h(i) != 0) {
            i8 = i2;
            i9 = i6;
            if (i9 != 0 && paint != null && b3Arr3 != null) {
            }
            if (i8 == 0) {
            }
            i2 = i8;
            i = 4;
            i11 = 2;
            i6 = 1;
            i10 = 3;
            if (!c0.g()) {
            } else {
            }
            if (!c0.g()) {
            } else {
            }
            z = c0.h(i11);
            if (z) {
            } else {
            }
            i8 = i2;
            i9 = i6;
            i3 = i20;
            if (z != i6) {
            } else {
            }
            i8 = i2;
            i9 = i11;
            if (z != i11) {
            } else {
            }
            i11 = i18 + 9;
            i3 = c0.h(i);
            i8 = i2;
            i9 = i11;
            if (z != i10) {
            } else {
            }
            i11 = i17 + 25;
            i3 = c0.h(i);
            i8 = i2;
            i9 = i3;
            i11 = i19 + 4;
            i3 = c0.h(i);
            i = c0.h(i10);
            if (i != 0) {
            } else {
            }
            i8 = i6;
            i11 = i + 2;
            if (paint != null) {
            }
            if (b3Arr3 != null) {
            }
            paint.setColor(i2Arr2[i3]);
            canvas7.drawRect((float)i7, (float)i12, (float)i14, (float)i15, paint6);
            i3 = b3Arr3[i3];
        }
        return i7 += i9;
    }

    private static int i(c0 c0, int[] i2Arr2, byte[] b3Arr3, int i4, int i5, Paint paint6, Canvas canvas7) {
        int i9;
        int i8;
        int i;
        int i3;
        int i6;
        Paint paint;
        int i7;
        int i2;
        int i10;
        final Object obj = c0;
        final int i11 = i5;
        final Paint paint2 = paint6;
        final int i16 = 0;
        i7 = i4;
        i9 = i16;
        i8 = 8;
        i3 = 1;
        while (c0.h(i8) != 0) {
            i2 = i9;
            i10 = i3;
            if (i10 != 0 && paint2 != null && b3Arr3 != null) {
            }
            if (i2 == 0) {
            }
            i9 = i2;
            i8 = 8;
            i3 = 1;
            i6 = 7;
            if (!c0.g()) {
            } else {
            }
            i2 = i9;
            i10 = i15;
            i = i8;
            i8 = c0.h(i6);
            if (i8 != 0) {
            } else {
            }
            i2 = i3;
            i10 = i;
            i2 = i9;
            i10 = i8;
            i = i16;
            if (paint2 != null) {
            }
            if (b3Arr3 != null) {
            }
            paint2.setColor(i2Arr2[i]);
            canvas7.drawRect((float)i7, (float)i11, (float)i13, (float)i14, paint6);
            i = b3Arr3[i];
        }
        return i7 += i10;
    }

    private static void j(byte[] bArr, int[] i2Arr2, int i3, int i4, int i5, Paint paint6, Canvas canvas7) {
        byte[] bArr2;
        int i;
        int[] iArr;
        int i6;
        int i8;
        int i7;
        Paint paint;
        Canvas canvas;
        int i9;
        int i10;
        int i11;
        int i2;
        final int i12 = i3;
        bArr2 = bArr;
        c0 c0Var = new c0(bArr);
        final int i15 = 0;
        i8 = i4;
        i9 = i5;
        i2 = i11;
        while (c0Var.b() != 0) {
            bArr2 = 8;
            iArr = c0Var.h(bArr2);
            if (iArr != 240) {
            } else {
            }
            i9 += 2;
            i8 = i4;
            int i14 = 3;
            i6 = 4;
            i11 = b.a(16, bArr2, c0Var);
            i10 = b.a(i6, bArr2, c0Var);
            i2 = b.a(i6, i6, c0Var);
            i8 = b.i(c0Var, i2Arr2, 0, i8, i9, paint6, canvas7);
            if (i12 == i14) {
            } else {
            }
            i6 = i15;
            i8 = b.h(c0Var, i2Arr2, i6, i8, i9, paint6, canvas7);
            c0Var.c();
            if (i11 == 0) {
            } else {
            }
            bArr2 = i11;
            i6 = bArr2;
            bArr2 = b.j;
            if (i12 == i14) {
            } else {
            }
            if (i12 == 2) {
            } else {
            }
            i6 = i15;
            i8 = b.g(c0Var, i2Arr2, i6, i8, i9, paint6, canvas7);
            c0Var.c();
            if (i2 == 0) {
            } else {
            }
            i = i2;
            i6 = i;
            i = b.h;
            if (i10 == 0) {
            } else {
            }
            i = i10;
            i = b.i;
        }
    }

    private static void k(com.google.android.exoplayer2.text.n.b.c b$c, com.google.android.exoplayer2.text.n.b.a b$a2, int i3, int i4, int i5, Paint paint6, Canvas canvas7) {
        int i;
        int[] obj8;
        obj8 = i3 == 3 ? a2.d : i3 == i ? a2.c : a2.b;
        final int[] iArr = obj8;
        final int i2 = i3;
        final int i6 = i4;
        final Paint paint = paint6;
        final Canvas canvas = canvas7;
        b.j(c.c, iArr, i2, i6, i5, paint, canvas);
        b.j(c.d, iArr, i2, i6, i5 + 1, paint, canvas);
    }

    private static com.google.android.exoplayer2.text.n.b.a l(c0 c0, int i2) {
        int i10;
        int i14;
        int i9;
        int i5;
        int i6;
        int i4;
        int i11;
        int i;
        int[] iArr2;
        int[] iArr;
        int i7;
        int i3;
        int i8;
        byte b;
        int i15;
        int i16;
        int i13;
        long l;
        int i12;
        long l2;
        int i17;
        int obj23;
        Object obj = c0;
        i10 = 8;
        i14 = obj.h(i10);
        obj.q(i10);
        i9 = 2;
        i5 = i2 + -2;
        final int[] iArr3 = b.c();
        final int[] iArr4 = b.d();
        final int[] iArr5 = b.e();
        while (i5 > 0) {
            int i30 = obj.h(i10);
            i5 += -2;
            if (i30 & 128 != 0) {
            } else {
            }
            if (i30 & 64 != 0) {
            } else {
            }
            iArr2 = iArr5;
            if (i30 &= 1 != 0) {
            } else {
            }
            int i41 = 4;
            i8 = i46 << 4;
            i28 += -2;
            i15 = i35;
            i = i40;
            i7 = i17;
            i13 = 255;
            if (i == 0) {
            }
            double d2 = (double)i;
            double d = (double)i38;
            double d3 = (double)i3;
            int i27 = 0;
            int i29 = 255;
            iArr2[obj.h(i10)] = b.f((byte)i43, p0.p((int)i32, i27, i29), p0.p((int)i19, i27, i29), p0.p((int)i26, i27, i29));
            i5 = obj23;
            i14 = i12;
            i10 = 8;
            i9 = 2;
            i15 = i13;
            i7 = 0;
            i8 = 0;
            i = obj.h(i10);
            i7 = obj.h(i10);
            i8 = obj.h(i10);
            i15 = obj.h(i10);
            i28 += -4;
            iArr2 = iArr4;
            iArr2 = iArr3;
        }
        b.a aVar = new b.a(i14, iArr3, iArr4, iArr5);
        return aVar;
    }

    private static com.google.android.exoplayer2.text.n.b.b m(c0 c0) {
        int z;
        int i2;
        int i3;
        int i5;
        int i4;
        int i;
        int obj9;
        c0.q(4);
        c0.q(3);
        int i8 = 16;
        final int i9 = c0.h(i8);
        final int i10 = c0.h(i8);
        if (c0.g()) {
            i = obj9;
            i5 = i2;
            i4 = i11;
            i3 = z;
        } else {
            i4 = i3;
            i5 = i9;
            i = i10;
        }
        super(i9, i10, i3, i5, i4, i);
        return obj9;
    }

    private static com.google.android.exoplayer2.text.n.b.c n(c0 c0) {
        int i2;
        int i3;
        byte[] bArr2;
        int i;
        byte[] bArr;
        i2 = 16;
        c0.q(4);
        i3 = c0.h(2);
        i = 1;
        c0.q(i);
        bArr = p0.f;
        if (i3 == i) {
            c0.q(i8 *= i2);
            bArr2 = bArr;
        } else {
            if (i3 == 0) {
                i3 = c0.h(i2);
                i2 = c0.h(i2);
                i = 0;
                if (i3 > 0) {
                    c0.j(new byte[i3], i, i3);
                }
                if (i2 > 0) {
                    c0.j(new byte[i2], i, i2);
                } else {
                }
            } else {
            }
        }
        b.c obj6 = new b.c(c0.h(i2), c0.g(), bArr, bArr2);
        return obj6;
    }

    private static com.google.android.exoplayer2.text.n.b.d o(c0 c0, int i2) {
        int i4;
        int i;
        int i3;
        com.google.android.exoplayer2.text.n.b.e eVar;
        int obj10;
        final int i5 = 8;
        int i9 = 2;
        c0.q(i9);
        i2 -= i9;
        SparseArray sparseArray = new SparseArray();
        while (obj10 > 0) {
            c0.q(i5);
            int i11 = 16;
            obj10 += -6;
            eVar = new b.e(c0.h(i11), c0.h(i11));
            sparseArray.put(c0.h(i5), eVar);
        }
        b.d obj9 = new b.d(c0.h(i5), c0.h(4), c0.h(i9), sparseArray);
        return obj9;
    }

    private static com.google.android.exoplayer2.text.n.b.f p(c0 c0, int i2) {
        int i5;
        int i6;
        int i10;
        int i16;
        int i7;
        int i8;
        int i11;
        int i12;
        com.google.android.exoplayer2.text.n.b.g gVar;
        int i9;
        int i4;
        int i13;
        int i3;
        int i;
        int i14;
        int i15;
        Object obj = c0;
        int i17 = 8;
        i5 = 4;
        obj.q(i5);
        int i20 = 3;
        obj.q(i20);
        i16 = 16;
        i6 = 2;
        obj.q(i6);
        i7 = obj.h(i6);
        obj.q(i6);
        i8 = i2 + -10;
        SparseArray sparseArray = new SparseArray();
        while (i8 > 0) {
            int i23 = obj.h(i6);
            int i21 = 12;
            int i38 = 4;
            obj.q(i38);
            if (i23 != 1) {
            } else {
            }
            i10 = 8;
            i8 += -2;
            i = i11;
            i14 = i12;
            super(i23, obj.h(i6), obj.h(i21), obj.h(i21), i, i14);
            sparseArray.put(obj.h(i16), gVar2);
            i5 = i38;
            i7 = i15;
            i6 = 2;
            i16 = 16;
            if (i23 == 2) {
            } else {
            }
            i14 = i;
        }
        super(obj.h(i17), c0.g(), obj.h(i16), obj.h(i16), obj.h(i20), obj.h(i20), obj.h(i17), obj.h(i17), obj.h(i5), i7, sparseArray);
        return fVar;
    }

    private static void q(c0 c0, com.google.android.exoplayer2.text.n.b.h b$h2) {
        int i2;
        int i;
        int i3;
        int i4;
        int i5;
        Object obj7;
        int i9 = 16;
        i4 = c0.h(i9);
        i3 = c0.h(i9);
        if (i3 * 8 > c0.b()) {
            v.h("DvbParser", "Data field length exceeds limit");
            c0.q(c0.b());
        }
        switch (i) {
            case 16:
                i = h2.i;
                i3 = b.o(c0, i3);
                h2.i = i3;
                h2.c.clear();
                h2.d.clear();
                h2.e.clear();
                h2.i = i3;
                break;
            case 17:
                i = h2.i;
                i3 = b.p(c0, i3);
                i2 = h2.c.get(i3.a);
                i3.a((b.f)i2);
                h2.c.put(i3.a, i3);
                break;
            case 18:
                i = b.l(c0, i3);
                h2.d.put(i.a, i);
                i = b.l(c0, i3);
                h2.f.put(i.a, i);
                break;
            case 19:
                i = b.n(c0);
                h2.e.put(i.a, i);
                i = b.n(c0);
                h2.g.put(i.a, i);
                break;
            case 20:
                h2.h = b.m(c0);
                break;
            default:
        }
        c0.r(i11 -= obj7);
    }

    public List<c> b(byte[] bArr, int i2) {
        com.google.android.exoplayer2.text.n.b.b bVar;
        byte[] bArr2;
        int i10;
        int i12;
        Bitmap bitmap;
        int height;
        Bitmap.Config config;
        int i13;
        Canvas canvas2;
        PorterDuff.Mode cLEAR;
        float f2;
        c.b bVar2;
        Object obj;
        int i8;
        float f;
        int i6;
        int i7;
        boolean z;
        int i3;
        Canvas valueAt;
        int i11;
        int i5;
        int i4;
        float f3;
        int i9;
        SparseArray sparseArray2;
        Paint paint;
        SparseArray sparseArray;
        Canvas canvas;
        int i;
        final Object obj2 = this;
        c0 c0Var = new c0(bArr, i2);
        while (c0Var.b() >= 48) {
            if (c0Var.h(8) == 15) {
            }
            b.q(c0Var, obj2.f);
        }
        com.google.android.exoplayer2.text.n.b.h hVar = obj2.f;
        com.google.android.exoplayer2.text.n.b.d dVar = hVar.i;
        if (dVar == null) {
            return Collections.emptyList();
        }
        if (hVar.h != null) {
        } else {
            bVar = obj2.d;
        }
        bitmap = obj2.g;
        if (bitmap != null && i20++ == bitmap.getWidth()) {
            if (i20++ == bitmap.getWidth()) {
                if (i17++ != obj2.g.getHeight()) {
                    bitmap = Bitmap.createBitmap(i15++, i18++, Bitmap.Config.ARGB_8888);
                    obj2.g = bitmap;
                    obj2.c.setBitmap(bitmap);
                }
            } else {
            }
        } else {
        }
        ArrayList arrayList = new ArrayList();
        SparseArray sparseArray3 = dVar.c;
        int i21 = 0;
        i13 = i21;
        while (i13 < sparseArray3.size()) {
            obj2.c.save();
            Object valueAt2 = sparseArray3.valueAt(i13);
            Object obj3 = hVar2.c.get(sparseArray3.keyAt(i13));
            i30 += i35;
            i22 += i36;
            obj2.c.clipRect(i31, i23, Math.min(i37 += i31, bVar.d), Math.min(i45 += i23, bVar.f));
            if ((b.a)hVar3.d.get(obj3.f) == null && (b.a)hVar4.f.get(obj3.f) == null) {
            }
            sparseArray2 = obj3.j;
            i9 = i21;
            while (i9 < sparseArray2.size()) {
                int keyAt2 = sparseArray2.keyAt(i9);
                valueAt = sparseArray2.valueAt(i9);
                i5 = hVar5.e.get(keyAt2);
                if ((b.c)i5 == null) {
                } else {
                }
                i6 = i5;
                if (i6 != 0) {
                } else {
                }
                i = i9;
                sparseArray = sparseArray2;
                i9 = i + 1;
                sparseArray2 = sparseArray;
                if (i6.b) {
                } else {
                }
                i4 = obj2.a;
                i = i9;
                sparseArray = sparseArray2;
                b.k(i6, obj, obj3.e, i52 += i31, i23 + i51, i4, obj2.c);
                i4 = 0;
                i6 = hVar6.g.get(keyAt2);
            }
            if (obj3.b) {
            }
            bVar2 = new c.b();
            bVar2.f(Bitmap.createBitmap(obj2.g, i31, i23, obj3.c, obj3.d));
            bVar2.k(f8 /= f);
            bVar2.l(i21);
            bVar2.h(f4 /= f9, i21);
            bVar2.i(i21);
            bVar2.n(f5 /= f2);
            bVar2.g(f6 /= f7);
            arrayList.add(bVar2.a());
            obj2.c.drawColor(i21, PorterDuff.Mode.CLEAR);
            obj2.c.restore();
            i13++;
            int i48 = obj3.e;
            if (i48 == 3) {
            } else {
            }
            if (i48 == 2) {
            } else {
            }
            i8 = obj.b[obj3.i];
            obj2.b.setColor(i8);
            obj2.c.drawRect((float)i31, (float)i23, (float)i41, (float)i43, obj2.b);
            i8 = obj.c[obj3.h];
            i8 = obj.d[obj3.g];
            keyAt2 = sparseArray2.keyAt(i9);
            valueAt = sparseArray2.valueAt(i9);
            i5 = hVar5.e.get(keyAt2);
            if ((b.c)(b.c)i5 == null) {
            } else {
            }
            i6 = i5;
            if (i6 != 0) {
            } else {
            }
            i = i9;
            sparseArray = sparseArray2;
            i9 = i + 1;
            sparseArray2 = sparseArray;
            if (i6.b) {
            } else {
            }
            i4 = obj2.a;
            i = i9;
            sparseArray = sparseArray2;
            b.k(i6, obj, obj3.e, i52 += i31, i23 + i51, i4, obj2.c);
            i4 = 0;
            i6 = hVar6.g.get(keyAt2);
            if ((b.a)hVar4.f.get(obj3.f) == null) {
            }
            obj = obj2.e;
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void r() {
        this.f.a();
    }
}
