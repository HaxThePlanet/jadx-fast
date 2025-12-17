package com.airbnb.lottie.v.k;

import com.airbnb.lottie.y.b;
import com.airbnb.lottie.y.g;

/* loaded from: classes.dex */
public class c {

    private final float[] a;
    private final int[] b;
    public c(float[] fArr, int[] i2Arr2) {
        super();
        this.a = fArr;
        this.b = i2Arr2;
    }

    public int[] a() {
        return this.b;
    }

    public float[] b() {
        return this.a;
    }

    public int c() {
        return iArr.length;
    }

    public void d(com.airbnb.lottie.v.k.c c, com.airbnb.lottie.v.k.c c2, float f3) {
        int i3;
        int length;
        int i2;
        int i;
        if (iArr.length != iArr2.length) {
        } else {
            i3 = 0;
            while (i3 < iArr3.length) {
                this.a[i3] = g.k(c.a[i3], c2.a[i3], f3);
                this.b[i3] = b.c(f3, c.b[i3], c2.b[i3]);
                i3++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot interpolate between gradients. Lengths vary (");
        stringBuilder.append(obj5.length);
        stringBuilder.append(" vs ");
        stringBuilder.append(obj5.length);
        stringBuilder.append(")");
        IllegalArgumentException obj7 = new IllegalArgumentException(stringBuilder.toString());
        throw obj7;
    }
}
