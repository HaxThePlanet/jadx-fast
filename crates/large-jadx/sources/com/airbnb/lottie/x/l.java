package com.airbnb.lottie.x;

import android.graphics.Color;
import com.airbnb.lottie.x.k0.c.b;
import com.airbnb.lottie.y.g;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GradientColorParser.java */
/* loaded from: classes.dex */
public class l implements j0<com.airbnb.lottie.v.k.c> {

    private int a;
    public l(int i) {
        super();
        this.a = i;
    }

    private void b(com.airbnb.lottie.v.k.c cVar, List<Float> list) {
        int i;
        int i2 = 0;
        double[] dArr3;
        double d;
        i = this.a * 4;
        if (list.size() <= this.a) {
            return;
        }
        int i6 = (list.size() - i) / 2;
        final double[] dArr2 = new double[i6];
        double[] dArr = new double[i6];
        i2 = 0;
        while (this.a < list.size()) {
            i = i + 1;
        }
        while (i2 < cVar.c()) {
            int i9 = cVar.a()[i2];
            cVar.a()[i2] = Color.argb(c((double)cVar.b()[i2], dArr2, dArr), Color.red(i9), Color.green(i9), Color.blue(i9));
            i2 = i2 + 1;
        }
    }

    private int c(double d, double[] dArr, double[] dArr2) {
        double d2;
        int i;
        long l;
        long l2;
        int cmp;
        long[] dArr32 = dArr;
        final long[] lArr = dArr2;
        i = 1;
        length = dArr32.length;
        double d3 = 255d;
        while (i < dArr32.length) {
            length = i - 1;
            l = dArr32[length];
            long l5 = dArr32[i];
            if (l5 >= d) {
                d5 = (d - l) / (dArr32[i] - l);
                double d6 = 0.0d;
                long l3 = 4607182418800017408L;
                d2 = g.j(lArr[length], lArr[i], g.b(d5, d6, l3));
            }
        }
        long l4 = lArr[lArr.length - i];
        return (int)(d2 * 255d);
    }

    public com.airbnb.lottie.v.k.c d(com.airbnb.lottie.x.k0.c cVar, float f) {
        int i;
        double d2;
        int i3;
        double d3;
        int i5;
        final ArrayList arrayList = new ArrayList();
        i = 1;
        i = 0;
        int r0 = i;
        if (i != 0) {
            cVar.c();
        }
        while (cVar.j()) {
            arrayList.add(Float.valueOf((float)cVar.m()));
        }
        if (i != 0) {
            cVar.f();
        }
        if (this.a == -1) {
            i6 = arrayList.size() / 4;
            this.a = i6;
        }
        float[] fArr = new float[i11];
        int[] iArr = new int[i11];
        while (i < this.a * 4) {
            i2 = i / 4;
            float value = (Float)arrayList.get(i).floatValue();
            d2 = (double)value;
            i4 = i % 4;
            i = i + 1;
        }
        com.airbnb.lottie.v.k.c cVar2 = new c(fArr, iArr);
        b(cVar2, arrayList);
        return cVar2;
    }
}
