package d.f.b.b;

import android.view.View;
import android.view.View.MeasureSpec;
import androidx.constraintlayout.widget.a;
import d.f.a.k.a.b;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* compiled from: MotionPaths.java */
/* loaded from: classes.dex */
class k implements Comparable<k> {

    static String[] I;
    float A = NaNf;
    int B;
    int C;
    g D = null;
    LinkedHashMap<String, a> E = new LinkedHashMap<>();
    int F = 0;
    double[] G;
    double[] H;
    b a;
    int b = 0;
    float c;
    float v;
    float w;
    float x;
    float y;
    float z;
    static {
        k.I = new String[] { "position", "x", "y", "width", "height", "pathRotate" };
    }

    public k() {
        super();
        int i4 = d.a;
        this.B = i4;
        this.C = i4;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i2 = 18;
        this.G = new double[i2];
        this.H = new double[i2];
    }

    public int a(k kVar) {
        return Float.compare(this.v, kVar.v);
    }

    void c(double d, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f = 1073741824;
        float d2;
        int i;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        float f2;
        int i5 = 0;
        int i6 = 0;
        float f4;
        final Object d4 = this;
        int[] dArr32 = iArr;
        i2 = 0;
        i3 = 0;
        i4 = 0;
        i5 = 0;
        i6 = 0;
        length = dArr32.length;
        int i8 = 1;
        while (i2 < length) {
            d2 = (float)dArr[i2];
            f3 = (float)dArr2[i2];
            int i7 = dArr32[i2];
            i2 = i2 + 1;
        }
        f = 2f;
        f2 = (i4 / f) + i3;
        f4 = (i6 / f) + i5;
        if (d4.D != null) {
            int i14 = 2;
            fArr2 = new float[i14];
            fArr = new float[i14];
            d4.D.b(d, fArr2, fArr);
            int i13 = 0;
            double d5 = (double)d2;
            double d9 = (double)d2;
            double d11 = (double)i3;
            double d13 = (double)i5;
            f4 = (float)(double)d2 - (d11 * Math.cos(d9)) + (Math.sin(d9) * d13);
            int i10 = 1073741824;
        } else {
        }
        float f11 = 0.0f;
        int i12 = 0;
        fArr[i12] = (d2 + (d2 / f)) + f11;
        fArr[i8] = (d2 + (d2 / f)) + f11;
        fArr2[i12] = f2;
        fArr2[i8] = f4;
    }

    void e(float f, View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        boolean naN;
        float f3;
        long[] dArr52;
        int i = 4;
        boolean naN3;
        float f5;
        int length2;
        int measuredHeight;
        int i2 = 1;
        int i3 = 0;
        int i5 = 0;
        int dArr42 = 2143289344;
        int i6 = 0;
        float f8;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        float[] fArr = null;
        double d3 = 0;
        long l2;
        double d5;
        final Object f10 = this;
        final Object view22 = view;
        iArr32 = iArr;
        length = iArr32.length;
        i2 = 1;
        if (iArr32.length != 0) {
            length = f10.G.length;
            if (f10.G.length <= iArr32[iArr32.length - i2]) {
                int i22 = (iArr32[iArr32.length - i2]) + i2;
                f10.G = new double[i22];
                f10.H = new double[i22];
            }
        }
        Arrays.fill(f10.G, Double.NaN);
        i5 = 0;
        while (iArr32.length < iArr32.length) {
            f10.G[iArr32[i5]] = dArr[i5];
            f10.H[iArr32[i5]] = dArr2[i5];
            i5 = i5 + 1;
        }
        dArr42 = 2143289344;
        i6 = 0;
        i8 = 0;
        i9 = 0;
        i10 = 0;
        int i27 = 0;
        length2 = dArr3.length;
        for (long d35 : dArr3) {
            d3 = 0.0d;
            dArr52 = dArr2;
            i2 = 1;
        }
        float f6 = 2f;
        if (f10.D != null) {
            int i12 = 2;
            float[] fArr2 = new float[i12];
            float[] fArr3 = new float[i12];
            f10.D.b((double)f, fArr2, fArr3);
            int i15 = 0;
            int i26 = 1;
            double d7 = (double)f5;
            double d14 = (double)f5;
            f8 = f5 / 2f;
            f5 = (float)(double)f7 - (Math.cos(d14) * d7) - (double)f8;
            double d27 = (double)i8;
            d4 = (double)i9;
            double d = (double)fArr3[i15] + (Math.sin(d14) * d27) + (Math.cos(d14) * d7) * d4;
            f6 = (float)d;
            d2 = (double)f4 - (d27 * Math.cos(d14)) + (d7 * Math.sin(d14)) * d4;
            f3 = (float)d2;
            double[] dArr62 = dArr2;
            if (dArr62.length >= 2) {
                i3 = 0;
                dArr62[i3] = d;
                i3 = 1;
                dArr62[i3] = d2;
            } else {
                i3 = 0;
                i3 = 1;
            }
            if (!Float.isNaN(dArr42)) {
                f3 = (float)(double)dArr42 + (Math.toDegrees(Math.atan2(d2, d)));
                view22.setRotation(f3);
            }
        } else {
            i3 = 0;
            i3 = 1;
            if (!Float.isNaN(dArr42)) {
                float f11 = 2f;
                i10 /= f11;
                i8 += f23;
                f9 = fArr / f11;
                f3 = (float)(double)0 + (double)dArr42 + (Math.toDegrees(Math.atan2((double)(i9 + f9), (double)f20)));
                view22.setRotation(f3);
            }
        }
        if (view22 instanceof c) {
            view22.a(f5, f5, f5 + f5, f5 + f5);
            return;
        }
        float f12 = 0.5f;
        f5 += f12;
        int i16 = (int)f13;
        f5 += f12;
        int i14 = (int)f15;
        int i17 = (int)(f13 + f5);
        int i19 = (int)(f15 + f5);
        measureSpec = i17 - i16;
        measureSpec2 = i19 - i14;
        int r9 = i3;
        if (i3 != 0) {
            measuredHeight = 1073741824;
            view22.measure(View.MeasureSpec.makeMeasureSpec(measureSpec, measuredHeight), View.MeasureSpec.makeMeasureSpec(measureSpec2, measuredHeight));
        }
        view22.layout(i16, i14, i17, i19);
    }
}
