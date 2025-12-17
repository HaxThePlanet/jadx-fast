package com.google.android.exoplayer2.n2;

import com.google.android.exoplayer2.b2;
import com.google.android.exoplayer2.util.p0;

/* loaded from: classes2.dex */
public final class o {

    public final int a;
    public final b2[] b;
    public final com.google.android.exoplayer2.n2.g[] c;
    public final Object d;
    public o(b2[] b2Arr, com.google.android.exoplayer2.n2.g[] g2Arr2, Object object3) {
        super();
        this.b = b2Arr;
        this.c = (g[])g2Arr2.clone();
        this.d = object3;
        this.a = b2Arr.length;
    }

    public boolean a(com.google.android.exoplayer2.n2.o o) {
        int length;
        int i;
        int length2;
        final int i2 = 0;
        if (o != null) {
            if (objArr.length != objArr2.length) {
            } else {
                i = i2;
                while (i < objArr3.length) {
                    i++;
                }
            }
            return 1;
        }
        return i2;
    }

    public boolean b(com.google.android.exoplayer2.n2.o o, int i2) {
        int i;
        boolean z;
        Object obj4;
        if (o == null) {
            return 0;
        }
        if (p0.b(this.b[i2], o.b[i2]) && p0.b(this.c[i2], o.c[i2])) {
            if (p0.b(this.c[i2], o.c[i2])) {
                i = 1;
            }
        }
        return i;
    }

    public boolean c(int i) {
        int obj2;
        obj2 = this.b[i] != null ? 1 : 0;
        return obj2;
    }
}
