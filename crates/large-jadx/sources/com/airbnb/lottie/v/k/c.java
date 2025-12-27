package com.airbnb.lottie.v.k;

import com.airbnb.lottie.y.b;
import com.airbnb.lottie.y.g;

/* compiled from: GradientColor.java */
/* loaded from: classes.dex */
public class c {

    private final float[] a;
    private final int[] b;
    public c(float[] fArr, int[] iArr) {
        super();
        this.a = fArr;
        this.b = iArr;
    }

    public int[] a() {
        return this.b;
    }

    public float[] b() {
        return this.a;
    }

    public int c() {
        return this.b.length;
    }

    public void d(c cVar, c cVar2, float f) {
        int i = 0;
        length = cVar2.b.length;
        if (cVar.b.length != cVar2.b.length) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Cannot interpolate between gradients. Lengths vary (";
            int length4 = cVar.b.length;
            String str2 = " vs ";
            int length5 = cVar2.b.length;
            String str3 = ")";
            cVar = str + length4 + str2 + length5 + str3;
            throw new IllegalArgumentException(cVar);
        } else {
            i = 0;
            while (cVar.b.length < cVar.b.length) {
                this.a[i] = g.k(cVar.a[i], cVar2.a[i], f);
                this.b[i] = b.c(f, cVar.b[i], cVar2.b[i]);
                i = i + 1;
            }
            return;
        }
    }
}
