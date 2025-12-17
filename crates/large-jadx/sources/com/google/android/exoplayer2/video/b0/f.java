package com.google.android.exoplayer2.video.b0;

import android.opengl.Matrix;
import com.google.android.exoplayer2.util.l0;

/* loaded from: classes2.dex */
final class f {

    private final float[] a;
    private final float[] b;
    private final l0<float[]> c;
    private boolean d;
    public f() {
        super();
        int i = 16;
        this.a = new float[i];
        this.b = new float[i];
        l0 l0Var = new l0();
        this.c = l0Var;
    }

    public static void a(float[] fArr, float[] f2Arr2) {
        int i = 0;
        Matrix.setIdentityM(fArr, i);
        final int i7 = 10;
        int i12 = 8;
        final int i18 = f2Arr2[i12];
        float f = (float)sqrt;
        fArr[i] = i15 /= f;
        fArr[2] = i2 /= f;
        fArr[i12] = i5 /= f;
        fArr[i7] = obj7 /= f;
    }

    private static void b(float[] fArr, float[] f2Arr2) {
        double degrees;
        float[] fArr2;
        int i2;
        float f;
        int i4;
        int i;
        int i3;
        final int i5 = 0;
        final int i6 = f2Arr2[i5];
        int i9 = -i8;
        int obj13 = -obj13;
        float length = Matrix.length(i6, i9, obj13);
        if (Float.compare(length, i11) != 0) {
            Matrix.setRotateM(fArr, 0, (float)degrees, i6 / length, i9 / length, obj13 / length);
        } else {
            Matrix.setIdentityM(fArr, i5);
        }
    }

    public boolean c(float[] fArr, long l2) {
        l0 l0Var;
        boolean obj9;
        obj9 = this.c.j(l2);
        if ((float[])obj9 == null) {
            return 0;
        }
        f.b(this.b, (float[])obj9);
        int obj10 = 1;
        if (!this.d) {
            f.a(this.a, this.b);
            this.d = obj10;
        }
        Matrix.multiplyMM(fArr, 0, this.a, 0, this.b, 0);
        return obj10;
    }

    public void d() {
        this.c.c();
        this.d = false;
    }

    public void e(long l, float[] f2Arr2) {
        this.c.a(l, f2Arr2);
    }
}
