package io.grpc.k1;

import com.google.common.base.n;
import io.grpc.j1.d.a;
import io.grpc.k1.r.j.c;
import l.f;

/* loaded from: classes3.dex */
class p {

    private final io.grpc.k1.h a;
    private final c b;
    private int c = 65535;
    private final io.grpc.k1.p.b d;

    static class a {
    }

    private final class b {

        final f a;
        final int b;
        int c;
        int d;
        io.grpc.k1.g e;
        boolean f;
        final io.grpc.k1.p g;
        b(io.grpc.k1.p p, int i2, int i3) {
            this.g = p;
            super();
            this.f = false;
            this.b = i2;
            this.c = i3;
            f obj1 = new f();
            this.a = obj1;
        }

        b(io.grpc.k1.p p, io.grpc.k1.g g2, int i3) {
            super(p, g2.Q(), i3);
            this.e = g2;
        }

        void a(int i) {
            this.d = i2 += i;
        }

        int b() {
            return this.d;
        }

        void c() {
            this.d = 0;
        }

        void d(f f, int i2, boolean z3) {
            this.a.write(f, (long)i2);
            this.f = obj4 |= z3;
        }

        boolean e() {
            int i;
            i = Long.compare(size, i2) > 0 ? 1 : 0;
            return i;
        }

        int f(int i) {
            int i3;
            int i2;
            if (i > 0) {
                if (i4 -= i < this.c) {
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Window size overflow for stream: ");
                stringBuilder.append(this.b);
                IllegalArgumentException obj3 = new IllegalArgumentException(stringBuilder.toString());
                throw obj3;
            }
            i5 += i;
            this.c = i6;
            return i6;
        }

        int g() {
            return Math.max(0, Math.min(this.c, (int)size));
        }

        int h() {
            return i -= i3;
        }

        int i() {
            return this.c;
        }

        int j() {
            return Math.min(this.c, p.a(this.g).i());
        }

        void k(f f, int i2, boolean z3) {
            int i;
            int i3 = Math.min(i2, p.b(this.g).maxDataLength());
            int i4 = -i3;
            p.a(this.g).f(i4);
            f(i4);
            do {
                i3 = Math.min(i2, p.b(this.g).maxDataLength());
                i4 = -i3;
                p.a(this.g).f(i4);
                f(i4);
                i = 0;
                p.b(this.g).data(i, this.b, f, i3);
                this.e.S().q(i3);
                if (i2 -= i3 > 0) {
                }
                if (z3) {
                } else {
                }
                i = 1;
            } while (Long.compare(size, l) == 0);
        }

        int l(int i, io.grpc.k1.p.c p$c2) {
            int i2;
            int i3;
            int i4;
            f fVar;
            boolean z;
            long size;
            i2 = Math.min(i, j());
            final int i8 = 0;
            i3 = i8;
            while (e()) {
                if (i2 > 0) {
                }
                if (Long.compare(l, size) >= 0) {
                } else {
                }
                i3 += i2;
                k(this.a, i2, i8);
                c2.b();
                i2 = Math.min(i - i3, j());
                i3 += i7;
                i2 = this.a;
                k(i2, (int)size3, this.f);
            }
            return i3;
        }
    }

    private static final class c {

        int a;
        c(io.grpc.k1.p.a p$a) {
            super();
        }

        boolean a() {
            int i;
            i = this.a > 0 ? 1 : 0;
            return i;
        }

        void b() {
            this.a = i++;
        }
    }
    p(io.grpc.k1.h h, c c2) {
        super();
        n.p(h, "transport");
        this.a = (h)h;
        n.p(c2, "frameWriter");
        this.b = (c)c2;
        p.b obj3 = new p.b(this, 0, 65535);
        this.d = obj3;
    }

    static io.grpc.k1.p.b a(io.grpc.k1.p p) {
        return p.d;
    }

    static c b(io.grpc.k1.p p) {
        return p.b;
    }

    private io.grpc.k1.p.b f(io.grpc.k1.g g) {
        Object bVar;
        int i;
        if ((p.b)g.O() == null) {
            bVar = new p.b(this, g, this.c);
            g.R(bVar);
        }
        return bVar;
    }

    void c(boolean z, int i2, f f3, boolean z4) {
        int i;
        boolean z2;
        n.p(f3, "source");
        io.grpc.k1.g obj6 = this.a.a0(i2);
        if (obj6 == null) {
        }
        obj6 = f(obj6);
        i = obj6.j();
        z2 = obj6.e();
        int i3 = (int)size2;
        if (!z2 && i >= i3) {
            if (i >= i3) {
                obj6.k(f3, i3, z);
            } else {
                if (!z2 && i > 0) {
                    if (i > 0) {
                        obj6.k(f3, i, false);
                    }
                }
                obj6.d(f3, (int)size, z);
            }
        } else {
        }
        if (z4) {
            d();
        }
    }

    void d() {
        try {
            this.b.flush();
            RuntimeException runtimeException = new RuntimeException(th);
            throw runtimeException;
        }
    }

    boolean e(int i) {
        int i2;
        int i4;
        io.grpc.k1.g gVar;
        Object bVar;
        int i3;
        if (i < 0) {
        } else {
            int i6 = i - i5;
            this.c = i;
            io.grpc.k1.g[] obj8 = this.a.V();
            i4 = i2;
            while (i4 < obj8.length) {
                gVar = obj8[i4];
                bVar = gVar.O();
                if ((p.b)bVar == null) {
                } else {
                }
                (p.b)bVar.f(i6);
                i4++;
                bVar = new p.b(this, gVar, this.c);
                gVar.R(bVar);
            }
            if (i6 > 0) {
                i2 = 1;
            }
            return i2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid initial window size: ");
        stringBuilder.append(i);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    int g(io.grpc.k1.g g, int i2) {
        io.grpc.k1.p.c cVar;
        int i;
        int obj3;
        int obj4;
        if (g == null) {
            obj3 = this.d.f(i2);
            h();
        } else {
            obj3 = f(g);
            cVar = new p.c(0);
            obj3.l(obj3.j(), cVar);
            if (cVar.a()) {
                d();
            }
            obj3 = obj4;
        }
        return obj3;
    }

    void h() {
        int i4;
        int length;
        int i;
        int i5;
        int i3;
        io.grpc.k1.g gVar;
        int i2;
        int i6;
        io.grpc.k1.g[] objArr = this.a.V();
        i4 = this.d.i();
        length = objArr.length;
        while (length > 0) {
            if (i4 > 0) {
            }
            float f2 = (float)length;
            i3 = i;
            while (i3 < length) {
                if (i4 > 0) {
                }
                gVar = objArr[i3];
                io.grpc.k1.p.b bVar2 = f(gVar);
                i6 = Math.min(i4, Math.min(bVar2.h(), (int)ceil));
                if (i6 > 0) {
                }
                if (bVar2.h() > 0) {
                }
                i3++;
                objArr[i] = gVar;
                i = i2;
                bVar2.a(i6);
                i4 -= i6;
            }
            length = i;
            if (i4 > 0) {
            }
            gVar = objArr[i3];
            bVar2 = f(gVar);
            i6 = Math.min(i4, Math.min(bVar2.h(), i5));
            if (i6 > 0) {
            }
            if (bVar2.h() > 0) {
            }
            i3++;
            objArr[i] = gVar;
            i = i2;
            bVar2.a(i6);
            i4 -= i6;
        }
        p.c cVar = new p.c(0);
        io.grpc.k1.g[] objArr2 = this.a.V();
        while (i < objArr2.length) {
            i5 = f(objArr2[i]);
            i5.l(i5.b(), cVar);
            i5.c();
            i++;
        }
        if (cVar.a()) {
            d();
        }
    }
}
