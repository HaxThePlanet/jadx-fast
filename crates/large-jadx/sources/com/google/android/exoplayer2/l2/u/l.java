package com.google.android.exoplayer2.l2.u;

import com.google.android.exoplayer2.l2.j;
import com.google.android.exoplayer2.util.d0;

/* loaded from: classes2.dex */
final class l {

    public com.google.android.exoplayer2.l2.u.e a;
    public long b;
    public long c;
    public long d;
    public int e;
    public int f;
    public long[] g;
    public int[] h;
    public int[] i;
    public int[] j;
    public long[] k;
    public boolean[] l;
    public boolean m;
    public boolean[] n;
    public com.google.android.exoplayer2.l2.u.k o;
    public final d0 p;
    public boolean q;
    public long r;
    public boolean s;
    public l() {
        super();
        int i = 0;
        this.g = new long[i];
        this.h = new int[i];
        this.i = new int[i];
        this.j = new int[i];
        this.k = new long[i];
        this.l = new boolean[i];
        this.n = new boolean[i];
        d0 d0Var = new d0();
        this.p = d0Var;
    }

    public void a(j j) {
        final int i2 = 0;
        j.readFully(this.p.d(), i2, this.p.f());
        this.p.I(i2);
        this.q = i2;
    }

    public void b(d0 d0) {
        final int i2 = 0;
        d0.j(this.p.d(), i2, this.p.f());
        this.p.I(i2);
        this.q = i2;
    }

    public long c(int i) {
        return l += l2;
    }

    public void d(int i) {
        this.p.E(i);
        final int obj2 = 1;
        this.m = obj2;
        this.q = obj2;
    }

    public void e(int i, int i2) {
        int lArr;
        int obj2;
        int obj3;
        this.e = i;
        this.f = i2;
        if (iArr.length < i) {
            this.g = new long[i];
            this.h = new int[i];
        }
        if (obj2.length < i2) {
            obj3 /= 100;
            this.i = new int[obj3];
            this.j = new int[obj3];
            this.k = new long[obj3];
            this.l = new boolean[obj3];
            this.n = new boolean[obj3];
        }
    }

    public void f() {
        int i = 0;
        this.e = i;
        this.r = 0;
        this.s = i;
        this.m = i;
        this.q = i;
        this.o = 0;
    }

    public boolean g(int i) {
        boolean z;
        int obj2;
        if (this.m && this.n[i]) {
            obj2 = this.n[i] ? 1 : 0;
        } else {
        }
        return obj2;
    }
}
