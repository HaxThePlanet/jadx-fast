package com.google.android.exoplayer2.n2;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class k {

    public final int a;
    private final com.google.android.exoplayer2.n2.j[] b;
    private int c;
    public k(com.google.android.exoplayer2.n2.j... jArr) {
        super();
        this.b = jArr;
        this.a = jArr.length;
    }

    public com.google.android.exoplayer2.n2.j a(int i) {
        return this.b[i];
    }

    public boolean equals(Object object) {
        Class<com.google.android.exoplayer2.n2.k> obj;
        Class class;
        if (this == object) {
            return 1;
        }
        if (object != null && k.class != object.getClass()) {
            if (k.class != object.getClass()) {
            }
            return Arrays.equals(this.b, object.b);
        }
        return 0;
    }

    public int hashCode() {
        int i2;
        int i;
        if (this.c == 0) {
            this.c = i4 += i;
        }
        return this.c;
    }
}
