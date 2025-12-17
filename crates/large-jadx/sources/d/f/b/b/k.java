package d.f.b.b;

import android.view.View;
import android.view.View.MeasureSpec;
import androidx.constraintlayout.widget.a;
import d.f.a.k.a.b;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
class k implements Comparable<d.f.b.b.k> {

    static String[] I;
    float A = NaNf;
    int B = 2143289344;
    int C = 2143289344;
    d.f.b.b.g D = null;
    LinkedHashMap<String, a> E;
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
        k.I = /* result */;
    }

    public k() {
        super();
        int i = 0;
        int i3 = 2143289344;
        int i4 = d.a;
        int i5 = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.E = linkedHashMap;
        int i2 = 18;
        this.G = new double[i2];
        this.H = new double[i2];
    }

    @Override // java.lang.Comparable
    public int a(d.f.b.b.k k) {
        return Float.compare(this.v, k.v);
    }

    @Override // java.lang.Comparable
    void c(double d, int[] i2Arr2, double[] d3Arr3, float[] f4Arr4, double[] d5Arr5, float[] f6Arr6) {
        int i10;
        float f6;
        float f3;
        float f2;
        float f4;
        float f;
        d.f.b.b.g gVar;
        int fArr;
        int i3;
        int i;
        int i8;
        int i5;
        int i4;
        int i2;
        int i6;
        float f7;
        int length;
        int i7;
        int i9;
        float f5;
        double d2;
        float obj20;
        final Object obj = this;
        int[] iArr = d3Arr3;
        f6 = obj.w;
        f3 = obj.x;
        f2 = obj.y;
        f4 = obj.z;
        i3 = 0;
        i = 0;
        i8 = 0;
        i4 = 0;
        i2 = 0;
        length = iArr.length;
        i9 = 1;
        while (i3 < length) {
            f = (float)l;
            f7 = (float)l2;
            i7 = iArr[i3];
            if (i7 != i9) {
            } else {
            }
            f6 = f;
            i = f7;
            i3++;
            length = iArr.length;
            i9 = 1;
            if (i7 != 2) {
            } else {
            }
            f3 = f;
            i4 = f7;
            if (i7 != 3) {
            } else {
            }
            f2 = f;
            i8 = f7;
            if (i7 != 4) {
            } else {
            }
            f4 = f;
            i2 = f7;
        }
        i10 = 1073741824;
        i25 += i;
        i27 += i4;
        gVar = obj.D;
        if (gVar != null) {
            int i24 = 2;
            float[] fArr2 = new float[i24];
            fArr = new float[i24];
            gVar.b(d, length, fArr2);
            int i23 = 0;
            double d3 = (double)f6;
            double d6 = (double)f3;
            f5 = f2;
            double d8 = (double)i;
            double d9 = (double)i4;
            i6 = (float)i31;
            i5 = f9;
            f6 = f10;
            f3 = f8;
            i10 = 1073741824;
        } else {
            f5 = f2;
        }
        int i20 = 0;
        int i22 = 0;
        d5Arr5[i22] = i13 += i20;
        d5Arr5[i9] = i16 += i20;
        obj26[i22] = i5;
        obj26[i9] = i6;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object object) {
        return a((k)object);
    }

    @Override // java.lang.Comparable
    void e(float f, View view2, int[] i3Arr3, double[] d4Arr4, double[] d5Arr5, double[] d6Arr6) {
        int[] naN4;
        boolean naN3;
        float naN2;
        long[] lArr;
        boolean naN;
        float f5;
        double length;
        float f6;
        float f3;
        int measureSpec;
        float f2;
        int measureSpec2;
        int dArr2;
        double[] length2;
        float i12;
        int measuredHeight;
        int i2;
        int i7;
        int dArr;
        int i3;
        int i5;
        int i4;
        double d;
        int degrees;
        int i6;
        int i11;
        long l;
        int i9;
        int i;
        int i8;
        int i10;
        float f4;
        double d2;
        long l2;
        float obj21;
        long[] obj24;
        final Object obj = this;
        final Object obj2 = view2;
        naN4 = i3Arr3;
        f5 = obj.w;
        f6 = obj.x;
        f3 = obj.y;
        f2 = obj.z;
        i2 = 1;
        if (naN4.length != 0 && dArr6.length <= naN4[length4 -= i2]) {
            if (dArr6.length <= naN4[length4 -= i2]) {
                i36 += i2;
                obj.G = new double[i37];
                obj.H = new double[i37];
            }
        }
        Arrays.fill(obj.G, 9221120237041090560L);
        i3 = 0;
        for (int i6 : obj2) {
            obj.G[naN4[i3]] = d4Arr4[i3];
            obj.H[i6] = d5Arr5[i3];
        }
        i5 = 2143289344;
        degrees = 0;
        i11 = 0;
        i9 = 0;
        i = 0;
        i8 = 0;
        double[] dArr3 = obj.G;
        for (long l2 : obj2) {
            if (Double.isNaN(dArr3[degrees])) {
            } else {
            }
            if (d6Arr6 != null) {
            }
            if (Double.isNaN(obj.G[degrees])) {
            } else {
            }
            i10 += l2;
            obj24 = i5;
            length2 = (float)i38;
            naN4 = (float)d3;
            if (degrees != 1) {
            } else {
            }
            i5 = obj24;
            i11 = naN4;
            f5 = length2;
            lArr = d5Arr5;
            i2 = 1;
            dArr3 = obj.G;
            if (degrees != 2) {
            } else {
            }
            i5 = obj24;
            i9 = naN4;
            f6 = length2;
            if (degrees != 3) {
            } else {
            }
            i5 = obj24;
            i = naN4;
            f3 = length2;
            if (degrees != 4) {
            } else {
            }
            i5 = obj24;
            i8 = naN4;
            f2 = length2;
            if (degrees != 5) {
            } else {
            }
            i5 = length2;
            i5 = obj24;
            i10 = d6Arr6[degrees];
            if (d6Arr6 != null) {
            } else {
            }
            obj24 = i5;
            if (Double.compare(l2, i10) == 0) {
            } else {
            }
        }
        obj24 = i5;
        d.f.b.b.g gVar = obj.D;
        if (gVar != null) {
            int i13 = 2;
            float[] fArr = new float[i13];
            float[] fArr2 = new float[i13];
            gVar.b((double)f12, i8, fArr);
            int i21 = 0;
            int i48 = 1;
            double d4 = (double)f5;
            double d7 = (double)f6;
            f4 = f2;
            double d16 = (double)i11;
            i11 = (double)i9;
            i12 = (float)i34;
            i50 += i15;
            naN2 = (float)i;
            double[] dArr5 = d5Arr5;
            if (dArr5.length >= 2) {
                dArr5[0] = (double)i12;
                dArr5[1] = (double)naN2;
            } else {
                i7 = 0;
                i4 = 1;
            }
            if (!Float.isNaN(obj24)) {
                obj2.setRotation((float)naN);
            }
            f5 = obj21;
            f6 = f2;
        } else {
            naN = obj24;
            f4 = f2;
            i7 = 0;
            i4 = 1;
            if (!Float.isNaN(naN)) {
                int i16 = 1073741824;
                i /= i16;
                i11 += i;
                obj2.setRotation((float)f2);
            }
        }
        if (obj2 instanceof c) {
            (c)obj2.a(f5, f6, f3 += f5, f6 + f4);
        }
        int i19 = 1056964608;
        f5 += i19;
        int i23 = (int)i24;
        f6 += i19;
        int i20 = (int)i28;
        int i26 = (int)i25;
        int i30 = (int)i29;
        measureSpec = i26 - i23;
        measureSpec2 = i30 - i20;
        if (measureSpec == view2.getMeasuredWidth()) {
            if (measureSpec2 != view2.getMeasuredHeight()) {
                i7 = i4;
            }
        } else {
        }
        if (i7 != 0) {
            measuredHeight = 1073741824;
            obj2.measure(View.MeasureSpec.makeMeasureSpec(measureSpec, measuredHeight), View.MeasureSpec.makeMeasureSpec(measureSpec2, measuredHeight));
        }
        obj2.layout(i23, i20, i26, i30);
    }
}
