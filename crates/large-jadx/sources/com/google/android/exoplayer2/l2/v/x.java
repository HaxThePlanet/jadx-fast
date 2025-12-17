package com.google.android.exoplayer2.l2.v;

import com.google.android.exoplayer2.l2.k;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.m0;
import com.google.android.exoplayer2.util.v;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes2.dex */
public final class x implements com.google.android.exoplayer2.l2.v.e0 {

    private final com.google.android.exoplayer2.l2.v.n a;
    private final c0 b;
    private int c = 0;
    private int d;
    private m0 e;
    private boolean f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private boolean k;
    private long l;
    public x(com.google.android.exoplayer2.l2.v.n n) {
        super();
        this.a = n;
        c0 obj2 = new c0(new byte[10]);
        this.b = obj2;
        obj2 = 0;
    }

    private boolean d(d0 d0, byte[] b2Arr2, int i3) {
        int i;
        int i2;
        int i5 = Math.min(d0.a(), i3 - i6);
        if (i5 <= 0) {
            return 1;
        }
        if (b2Arr2 == null) {
            d0.J(i5);
        } else {
            d0.j(b2Arr2, this.d, i5);
        }
        obj4 += i5;
        this.d = obj4;
        if (obj4 == i3) {
        } else {
            i = 0;
        }
        return i;
    }

    private boolean e() {
        int string;
        int str;
        Object stringBuilder;
        int i4 = 0;
        this.b.o(i4);
        int i = this.b.h(24);
        String str2 = "PesReader";
        int i8 = 1;
        final int i10 = -1;
        if (i != i8) {
            StringBuilder stringBuilder2 = new StringBuilder(41);
            stringBuilder2.append("Unexpected start code prefix: ");
            stringBuilder2.append(i);
            v.h(str2, stringBuilder2.toString());
            this.j = i10;
            return i4;
        }
        int i5 = 8;
        this.b.q(i5);
        string = this.b.h(16);
        this.b.q(5);
        this.k = this.b.g();
        this.b.q(2);
        this.f = this.b.g();
        this.g = this.b.g();
        int i14 = 6;
        this.b.q(i14);
        str = this.b.h(i5);
        this.i = str;
        if (string == null) {
            this.j = i10;
        } else {
            i3 -= str;
            this.j = string;
            if (string < 0) {
                stringBuilder = new StringBuilder(47);
                stringBuilder.append("Found negative packet payload size: ");
                stringBuilder.append(string);
                v.h(str2, stringBuilder.toString());
                this.j = i10;
            }
        }
        return i8;
    }

    @RequiresNonNull("timestampAdjuster")
    private void f() {
        int i4;
        boolean z;
        int i2;
        int i3;
        int i6;
        boolean z2;
        int i5;
        int i;
        long l;
        this.b.o(0);
        this.l = -9223372036854775807L;
        i2 = 4;
        this.b.q(i2);
        i3 = 3;
        i4 = 30;
        i5 = 1;
        this.b.q(i5);
        i = 15;
        this.b.q(i5);
        this.b.q(i5);
        if (this.f && !this.h && this.g) {
            i2 = 4;
            this.b.q(i2);
            i3 = 3;
            i4 = 30;
            i5 = 1;
            this.b.q(i5);
            i = 15;
            this.b.q(i5);
            this.b.q(i5);
            if (!this.h) {
                if (this.g) {
                    this.b.q(i2);
                    i2 = (long)i10;
                    this.b.q(i5);
                    this.b.q(i5);
                    this.b.q(i5);
                    this.e.b(i9 |= i);
                    this.h = i5;
                }
            }
            this.l = this.e.b(i15 |= l);
        }
    }

    private void g(int i) {
        this.c = i;
        this.d = 0;
    }

    @Override // com.google.android.exoplayer2.l2.v.e0
    public void a(m0 m0, k k2, com.google.android.exoplayer2.l2.v.e0.d e0$d3) {
        this.e = m0;
        this.a.e(k2, d3);
    }

    @Override // com.google.android.exoplayer2.l2.v.e0
    public final void b(d0 d0, int i2) {
        int str2;
        int string;
        String str3;
        String str;
        StringBuilder stringBuilder;
        int obj10;
        g.h(this.e);
        final int i7 = -1;
        final int i8 = 3;
        final int i9 = 2;
        final int i10 = 1;
        str2 = this.c;
        str3 = "PesReader";
        if (i2 & 1 != 0 && str2 != null && str2 != i10 && str2 != i9) {
            str2 = this.c;
            if (str2 != null) {
                if (str2 != i10) {
                    str3 = "PesReader";
                    if (str2 != i9) {
                        if (str2 != i8) {
                        } else {
                            string = this.j;
                            if (string != i7) {
                                stringBuilder = new StringBuilder(59);
                                stringBuilder.append("Unexpected start indicator: expected ");
                                stringBuilder.append(string);
                                stringBuilder.append(" more bytes");
                                v.h(str3, stringBuilder.toString());
                            }
                            this.a.d();
                        }
                        IllegalStateException obj9 = new IllegalStateException();
                        throw obj9;
                    }
                    v.h(str3, "Unexpected start indicator reading extended header");
                }
            }
            g(i10);
        }
        while (d0.a() > 0) {
            int i3 = this.c;
            d0.J(d0.a());
            str3 = 0;
            if (d(d0, c0Var.a, 9) != 0 && e() != 0) {
            }
            if (e() != 0) {
            }
            g(str3);
            str3 = i9;
            str = this.i;
            f();
            if (d(d0, c0Var2.a, Math.min(10, this.i)) != 0 && d(d0, 0, str) != 0 && this.k) {
            }
            str = this.i;
            if (d(d0, 0, str) != 0) {
            }
            f();
            if (this.k) {
            }
            this.a.f(this.l, str);
            g(i8);
            str3 = 4;
            str2 = d0.a();
            str = this.j;
            if (str == i7) {
            } else {
            }
            str3 = str2 - str;
            if (str3 > 0) {
            }
            this.a.b(d0);
            str3 = this.j;
            str3 -= str2;
            this.j = str3;
            if (str3 != i7 && str3 == null) {
            }
            str3 -= str2;
            this.j = str3;
            if (str3 == null) {
            }
            this.a.d();
            g(i10);
            d0.H(i11 += str2);
        }
    }

    @Override // com.google.android.exoplayer2.l2.v.e0
    public final void c() {
        int i = 0;
        this.c = i;
        this.d = i;
        this.h = i;
        this.a.c();
    }
}
