package com.airbnb.lottie.x;

import android.graphics.Color;
import com.airbnb.lottie.v.k.c;
import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.k0.c.b;
import com.airbnb.lottie.y.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class l implements com.airbnb.lottie.x.j0<c> {

    private int a;
    public l(int i) {
        super();
        this.a = i;
    }

    private void b(c c, List<Float> list2) {
        int i2;
        int i3;
        int i;
        double d;
        int green;
        int obj9;
        i4 *= 4;
        if (list2.size() <= i2) {
        }
        i6 /= 2;
        final double[] dArr2 = new double[i7];
        double[] dArr = new double[i7];
        i = i3;
        while (i2 < list2.size()) {
            if (i2 % 2 == 0) {
            } else {
            }
            dArr[i] = (double)floatValue;
            i++;
            i2++;
            dArr2[i] = (double)floatValue2;
        }
        while (i3 < c.c()) {
            obj9 = c.a()[i3];
            c.a()[i3] = Color.argb(c((double)f, green, dArr2), Color.red(obj9), Color.green(obj9), Color.blue(obj9));
            i3++;
        }
    }

    private int c(double d, double[] d2Arr2, double[] d3Arr3) {
        double l3;
        int i3;
        int length;
        long l4;
        long l5;
        long l;
        int cmp;
        int i2;
        int i;
        long l2;
        long[] lArr = d3Arr3;
        final long[] lArr2 = obj23;
        final int i7 = 1;
        i3 = i7;
        for (long l6 : obj0) {
            length = i3 + -1;
            l5 = lArr[length];
        }
        l3 = lArr2[length2 -= i7];
        return (int)i5;
    }

    @Override // com.airbnb.lottie.x.j0
    public Object a(c c, float f2) {
        return d(c, f2);
    }

    @Override // com.airbnb.lottie.x.j0
    public c d(c c, float f2) {
        int i2;
        c.b bEGIN_ARRAY;
        int i;
        int i4;
        double d;
        int i3;
        int i7;
        int argb;
        int i8;
        int i5;
        long l;
        int i6;
        int obj13;
        ArrayList obj14 = new ArrayList();
        final int i10 = 1;
        i4 = 0;
        i2 = c.w() == c.b.BEGIN_ARRAY ? i10 : i4;
        if (i2 != 0) {
            c.c();
        }
        while (c.j()) {
            obj14.add(Float.valueOf((float)d));
        }
        if (i2 != 0) {
            c.f();
        }
        if (this.a == -1) {
            this.a = obj13 /= 4;
        }
        obj13 = this.a;
        float[] fArr = new float[obj13];
        obj13 = new int[obj13];
        i3 = i;
        while (i4 < i11 *= 4) {
            i7 = i4 / 4;
            argb = (double)floatValue;
            i5 = i4 % 4;
            if (i5 != 0) {
            } else {
            }
            fArr[i7] = (float)argb;
            i4++;
            l = 4643176031446892544L;
            if (i5 != i10) {
            } else {
            }
            i = (int)argb;
            if (i5 != 2) {
            } else {
            }
            i3 = (int)argb;
            if (i5 != 3) {
            } else {
            }
            obj13[i7] = Color.argb(255, i, i3, (int)i13);
        }
        c cVar = new c(fArr, obj13);
        b(cVar, obj14);
        return cVar;
    }
}
