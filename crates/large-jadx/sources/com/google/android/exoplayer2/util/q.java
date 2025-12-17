package com.google.android.exoplayer2.util;

import android.util.SparseBooleanArray;

/* loaded from: classes2.dex */
public final class q {

    private final SparseBooleanArray a;

    static class a {
    }

    public static final class b {

        private final SparseBooleanArray a;
        private boolean b;
        public b() {
            super();
            SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
            this.a = sparseBooleanArray;
        }

        public com.google.android.exoplayer2.util.q.b a(int i) {
            final int i3 = 1;
            g.f(z ^= i3);
            this.a.append(i, i3);
            return this;
        }

        public com.google.android.exoplayer2.util.q.b b(com.google.android.exoplayer2.util.q q) {
            int i;
            int i2;
            i = 0;
            while (i < q.d()) {
                a(q.c(i));
                i++;
            }
            return this;
        }

        public com.google.android.exoplayer2.util.q.b c(int... iArr) {
            int i2;
            int i;
            i2 = 0;
            while (i2 < iArr.length) {
                a(iArr[i2]);
                i2++;
            }
            return this;
        }

        public com.google.android.exoplayer2.util.q.b d(int i, boolean z2) {
            if (z2) {
                a(i);
            }
            return this;
        }

        public com.google.android.exoplayer2.util.q e() {
            int i2 = 1;
            g.f(z ^= i2);
            this.b = i2;
            q qVar = new q(this.a, 0);
            return qVar;
        }
    }
    private q(SparseBooleanArray sparseBooleanArray) {
        super();
        this.a = sparseBooleanArray;
    }

    q(SparseBooleanArray sparseBooleanArray, com.google.android.exoplayer2.util.q.a q$a2) {
        super(sparseBooleanArray);
    }

    public boolean a(int i) {
        return this.a.get(i);
    }

    public boolean b(int... iArr) {
        int i;
        boolean z;
        final int i2 = 0;
        i = i2;
        while (i < iArr.length) {
            i++;
        }
        return i2;
    }

    public int c(int i) {
        g.c(i, 0, d());
        return this.a.keyAt(i);
    }

    public int d() {
        return this.a.size();
    }

    public boolean equals(Object object) {
        int i2;
        int i3;
        int i;
        int i4 = 1;
        if (this == object) {
            return i4;
        }
        final int i7 = 0;
        if (!object instanceof q) {
            return i7;
        }
        if (p0.a < 24 && d() != (q)object.d()) {
            if (d() != object.d()) {
                return i7;
            }
            i2 = i7;
            while (i2 < d()) {
                i2++;
            }
            return i4;
        }
        return this.a.equals(object.a);
    }

    public int hashCode() {
        int i2;
        int i;
        int i3;
        if (p0.a < 24) {
            i2 = d();
            i = 0;
            while (i < d()) {
                i6 += i3;
                i++;
            }
            return i2;
        }
        return this.a.hashCode();
    }
}
