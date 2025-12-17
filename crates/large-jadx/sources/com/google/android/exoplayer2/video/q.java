package com.google.android.exoplayer2.video;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class q {

    private com.google.android.exoplayer2.video.q.a a;
    private com.google.android.exoplayer2.video.q.a b;
    private boolean c;
    private boolean d;
    private long e = -9223372036854775807L;
    private int f;

    private static final class a {

        private long a;
        private long b;
        private long c;
        private long d;
        private long e;
        private long f;
        private final boolean[] g;
        private int h;
        public a() {
            super();
            this.g = new boolean[15];
        }

        private static int c(long l) {
            return (int)obj2;
        }

        public long a() {
            int i;
            final long l = this.e;
            if (Long.compare(l, i) == 0) {
            } else {
                l2 /= l;
            }
            return i;
        }

        public long b() {
            return this.f;
        }

        public boolean d() {
            long l = this.d;
            if (Long.compare(l, i4) == 0) {
                return 0;
            }
            return this.g[q.a.c(l -= i5)];
        }

        public boolean e() {
            int cmp;
            int i;
            if (Long.compare(l, i2) > 0 && this.h == 0) {
                i = this.h == 0 ? 1 : 0;
            } else {
            }
            return i;
        }

        public void f(long l) {
            int l2;
            long zArr;
            int cmp;
            boolean z;
            int i;
            l2 = this.d;
            final int i7 = 1;
            if (Long.compare(l2, i6) == 0) {
                this.a = l;
            } else {
                cmp = Long.compare(l2, i7);
                if (cmp == 0) {
                    l2 = l - l3;
                    this.b = l2;
                    this.f = l2;
                    this.e = i7;
                } else {
                    int i8 = l - l7;
                    l2 = q.a.c(l2);
                    cmp = 1;
                    if (Long.compare(l6, i) <= 0) {
                        this.e = l8 += i7;
                        this.f = l9 += i8;
                        zArr = this.g;
                        if (zArr[l2]) {
                            zArr[l2] = 0;
                            this.h = i3 -= cmp;
                        }
                    } else {
                        zArr = this.g;
                        if (!zArr[l2]) {
                            zArr[l2] = cmp;
                            this.h = i2 += cmp;
                        }
                    }
                }
            }
            this.d = l4 += i7;
            this.c = l;
        }

        public void g() {
            int i = 0;
            this.d = i;
            this.e = i;
            this.f = i;
            int i2 = 0;
            this.h = i2;
            Arrays.fill(this.g, i2);
        }
    }
    public q() {
        super();
        q.a aVar = new q.a();
        this.a = aVar;
        q.a aVar2 = new q.a();
        this.b = aVar2;
        long l = -9223372036854775807L;
    }

    public long a() {
        long l;
        if (e()) {
            l = this.a.a();
        } else {
            l = -9223372036854775807L;
        }
        return l;
    }

    public float b() {
        float f;
        double d;
        if (e()) {
            f = (float)i;
        } else {
            f = -1082130432;
        }
        return f;
    }

    public int c() {
        return this.f;
    }

    public long d() {
        long l;
        if (e()) {
            l = this.a.b();
        } else {
            l = -9223372036854775807L;
        }
        return l;
    }

    public boolean e() {
        return this.a.e();
    }

    public void f(long l) {
        boolean cmp;
        boolean z2;
        boolean z;
        int i;
        long l3;
        long l2;
        boolean obj8;
        this.a.f(l);
        i = 0;
        if (this.a.e() && !this.d) {
            if (!this.d) {
                this.c = i;
            } else {
                if (Long.compare(l3, l2) != 0) {
                    if (this.c) {
                        if (this.b.d()) {
                            this.b.g();
                            this.b.f(this.e);
                        }
                    } else {
                    }
                    this.c = true;
                    this.b.f(l);
                }
            }
        } else {
        }
        if (this.c && this.b.e()) {
            if (this.b.e()) {
                this.a = this.b;
                this.b = this.a;
                this.c = i;
                this.d = i;
            }
        }
        this.e = l;
        if (this.a.e()) {
        } else {
            i = obj8 + 1;
        }
        this.f = i;
    }

    public void g() {
        this.a.g();
        this.b.g();
        int i = 0;
        this.c = i;
        this.e = -9223372036854775807L;
        this.f = i;
    }
}
