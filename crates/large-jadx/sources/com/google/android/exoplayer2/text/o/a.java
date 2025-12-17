package com.google.android.exoplayer2.text.o;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.c.b;
import com.google.android.exoplayer2.text.d;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.Inflater;

/* loaded from: classes2.dex */
public final class a extends d {

    private final d0 n;
    private final d0 o;
    private final com.google.android.exoplayer2.text.o.a.a p;
    private Inflater q;

    private static final class a {

        private final d0 a;
        private final int[] b;
        private boolean c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
        public a() {
            super();
            d0 d0Var = new d0();
            this.a = d0Var;
            this.b = new int[256];
        }

        static void a(com.google.android.exoplayer2.text.o.a.a a$a, d0 d02, int i3) {
            a.g(d02, i3);
        }

        static void b(com.google.android.exoplayer2.text.o.a.a a$a, d0 d02, int i3) {
            a.e(d02, i3);
        }

        static void c(com.google.android.exoplayer2.text.o.a.a a$a, d0 d02, int i3) {
            a.f(d02, i3);
        }

        private void e(d0 d0, int i2) {
            int i4;
            int i;
            int i3;
            d0 d0Var;
            d0 obj4;
            int obj5;
            int i5 = 4;
            if (i2 < i5) {
            }
            d0.J(3);
            i = i7 &= 128 != 0 ? 1 : 0;
            i2 += -4;
            if (i != 0 && obj5 < 7) {
                if (obj5 < 7) {
                }
                int i11 = d0.A();
                if (i11 < i5) {
                }
                this.h = d0.D();
                this.i = d0.D();
                this.a.E(i11 -= i5);
                obj5 += -7;
            }
            i4 = this.a.e();
            i3 = this.a.f();
            if (i4 < i3 && obj5 > 0) {
                if (obj5 > 0) {
                    obj5 = Math.min(obj5, i3 -= i4);
                    d0.j(this.a.d(), i4, obj5);
                    this.a.I(i4 += obj5);
                }
            }
        }

        private void f(d0 d0, int i2) {
            if (i2 < 19) {
            }
            this.d = d0.D();
            this.e = d0.D();
            d0.J(11);
            this.f = d0.D();
            this.g = d0.D();
        }

        private void g(d0 d0, int i2) {
            int i9;
            int i5;
            int i10;
            int i3;
            int i11;
            int i;
            int i4;
            int i8;
            int i6;
            int i7;
            long l;
            int obj19;
            final Object obj = this;
            int i14 = 2;
            if (i2 % 5 != i14) {
            }
            d0.J(i14);
            i9 = 0;
            Arrays.fill(obj.b, i9);
            i5 = i9;
            while (i5 < i2 / 5) {
                double d3 = (double)i20;
                double d2 = (double)i26;
                double d = (double)i29;
                i = 255;
                i4 = 0;
                obj.b[d0.x()] = i18 |= i3;
                i5 = obj19 + 1;
                i9 = i4;
            }
            obj.c = true;
        }

        public c d() {
            int i5;
            int i3;
            int i2;
            int i4;
            int i;
            int i6;
            int[] iArr;
            if (this.d != 0 && this.e != 0 && this.h != 0 && this.i != 0 && this.a.f() != 0 && this.a.e() == this.a.f()) {
                if (this.e != 0) {
                    if (this.h != 0) {
                        if (this.i != 0) {
                            if (this.a.f() != 0) {
                                if (this.a.e() == this.a.f()) {
                                    if (!this.c) {
                                    } else {
                                        int i19 = 0;
                                        this.a.I(i19);
                                        i8 *= i22;
                                        int[] iArr2 = new int[i9];
                                        i2 = i19;
                                        while (i2 < i9) {
                                            int i26 = this.a.x();
                                            if (i26 != 0) {
                                            } else {
                                            }
                                            i4 = this.a.x();
                                            if (i4 != 0) {
                                            }
                                            if (i4 & 64 == 0) {
                                            } else {
                                            }
                                            i30 |= iArr;
                                            if (i4 &= 128 == 0) {
                                            } else {
                                            }
                                            i4 = this.b[this.a.x()];
                                            Arrays.fill(iArr2, i2, i6 += i2, i4);
                                            i2 = i;
                                            i4 = i19;
                                            i6 = i4 & 63;
                                            i = i2 + 1;
                                            iArr2[i2] = this.b[i26];
                                        }
                                    }
                                    c.b bVar = new c.b();
                                    bVar.f(Bitmap.createBitmap(iArr2, this.h, this.i, Bitmap.Config.ARGB_8888));
                                    bVar.k(f /= f7);
                                    bVar.l(i19);
                                    bVar.h(f2 /= f8, i19);
                                    bVar.i(i19);
                                    bVar.n(f3 /= f5);
                                    bVar.g(f4 /= f6);
                                    return bVar.a();
                                }
                            }
                        }
                    }
                }
            }
            return null;
        }

        public void h() {
            final int i = 0;
            this.d = i;
            this.e = i;
            this.f = i;
            this.g = i;
            this.h = i;
            this.i = i;
            this.a.E(i);
            this.c = i;
        }
    }
    public a() {
        super("PgsDecoder");
        d0 d0Var = new d0();
        this.n = d0Var;
        d0 d0Var2 = new d0();
        this.o = d0Var2;
        a.a aVar = new a.a();
        this.p = aVar;
    }

    private void C(d0 d0) {
        Inflater inflater;
        int i;
        int i2;
        if (d0.a() > 0 && d0.h() == 120 && this.q == null) {
            if (d0.h() == 120) {
                if (this.q == null) {
                    inflater = new Inflater();
                    this.q = inflater;
                }
                if (p0.e0(d0, this.o, this.q)) {
                    d0.G(this.o.d(), this.o.f());
                }
            }
        }
    }

    private static c D(d0 d0, com.google.android.exoplayer2.text.o.a.a a$a2) {
        int i;
        int i2 = d0.f();
        final int i4 = d0.x();
        final int i5 = d0.D();
        i6 += i5;
        if (i7 > i2) {
            d0.I(i2);
            return null;
        }
        if (i4 != 128) {
            switch (i4) {
                case 20:
                    a.a.a(a2, d0, i5);
                    break;
                case 21:
                    a.a.b(a2, d0, i5);
                    break;
                case 22:
                    a.a.c(a2, d0, i5);
                    break;
                default:
            }
        } else {
            i = a2.d();
            a2.h();
        }
        d0.I(i7);
        return i;
    }

    @Override // com.google.android.exoplayer2.text.d
    protected f z(byte[] bArr, int i2, boolean z3) {
        int obj2;
        d0 obj3;
        this.n.G(bArr, i2);
        C(this.n);
        this.p.h();
        ArrayList obj1 = new ArrayList();
        while (this.n.a() >= 3) {
            obj2 = a.D(this.n, this.p);
            if (obj2 != null) {
            }
            obj1.add(obj2);
        }
        obj2 = new b(Collections.unmodifiableList(obj1));
        return obj2;
    }
}
