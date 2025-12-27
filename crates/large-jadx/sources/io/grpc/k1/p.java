package io.grpc.k1;

import com.google.common.base.n;
import io.grpc.j1.d.a;
import io.grpc.k1.r.j.c;
import java.io.IOException;
import l.f;

/* compiled from: OutboundFlowController.java */
/* loaded from: classes3.dex */
class p {

    private final h a;
    private final c b;
    private int c = 65535;
    private final p.b d = new p$b();

    static class a {
    }

    private final class b {

        final f a;
        final int b;
        int c;
        int d;
        g e;
        boolean f;
        final /* synthetic */ p g;
        b(int i, int i2) {
            this.g = pVar;
            super();
            this.f = false;
            this.b = i;
            this.c = i2;
            this.a = new f();
        }

        void a(int i) {
            this.d += i;
        }

        int b() {
            return this.d;
        }

        void c() {
            this.d = 0;
        }

        void d(f fVar, int i, boolean z) {
            this.a.write(fVar, (long)i);
            this.f |= z;
        }

        boolean e() {
            boolean z = true;
            long size = this.a.size();
            int r0 = size > 0 ? 1 : 0;
            return (size > 0 ? 1 : 0);
        }

        int f(int i) {
            if (i > 0) {
                i2 = (0x7fffffff /* Unknown resource */) - i;
                if (0x7fffffff /* Unknown resource */ - i < this.c) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str = "Window size overflow for stream: ";
                    r0 = str + this.b;
                    throw new IllegalArgumentException(r0);
                }
            }
            this.c += i;
            return i6;
        }

        int g() {
            return Math.max(0, Math.min(this.c, (int)this.a.size()));
        }

        int h() {
            return g() - this.d;
        }

        int i() {
            return this.c;
        }

        int j() {
            return Math.min(this.c, this.g.d.i());
        }

        void k(f fVar, int i, boolean z) {
            do {
                int min = Math.min(i, this.g.b.maxDataLength());
                int i4 = -min;
                this.g.d.f(i4);
                f(i4);
                try {
                    long size = fVar.size();
                    long l = (long)min;
                    int r1 = size == l && z ? 1 : 0;
                    p.b(this.g).data((size == l && z ? 1 : 0), this.b, fVar, min);
                } catch (java.io.IOException ioException) {
                    i = new RuntimeException(ioException);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                }
                this.e.S().q(min);
                if (i - min <= 0) {
                    return;
                }
            } while (/* condition */);
        }

        int l(int i, p.c cVar) {
            int min;
            int i2;
            boolean z;
            min = Math.min(i, j());
            final boolean z2 = false;
            i2 = z2;
            while (e()) {
                if (min <= 0) {
                    return i2;
                }
            }
            return i2;
        }

        b(g gVar, int i) {
            this(pVar, gVar.Q(), i);
            this.e = gVar;
        }
    }

    private static final class c {

        int a;
        private c() {
            super();
        }

        boolean a() {
            boolean z = true;
            int r0 = this.a > 0 ? 1 : 0;
            return (this.a > 0 ? 1 : 0);
        }

        void b() {
            this.a++;
        }

        /* synthetic */ c(p.a aVar) {
            this();
        }
    }
    p(h hVar, c cVar) {
        super();
        n.p(hVar, "transport");
        this.a = hVar;
        n.p(cVar, "frameWriter");
        this.b = cVar;
        final io.grpc.k1.p.b bVar = new p.b(this, 0, 65535);
    }

    static /* synthetic */ p.b a(p pVar) {
        return pVar.d;
    }

    static /* synthetic */ c b(p pVar) {
        return pVar.b;
    }

    private p.b f(g gVar) {
        Object obj;
        if ((p.b)gVar.O() == null) {
            gVar.R(new p.b(this, gVar, this.c));
        }
        return obj;
    }

    void c(boolean z, int i, f fVar, boolean z2) {
        n.p(fVar, "source");
        io.grpc.k1.g gVar = this.a.a0(i);
        if (gVar == null) {
            return;
        }
        io.grpc.k1.p.b bVar = f(gVar);
        i = bVar.j();
        z2 = bVar.e();
        int i3 = (int)fVar.size();
        if (z2 || i < i3) {
            if (!z2 && i > 0) {
                z2 = false;
                bVar.k(fVar, i, z2);
            }
            i = (int)fVar.size();
            bVar.d(fVar, i, z);
        } else {
            bVar.k(fVar, i3, z);
        }
        if (z2) {
            d();
        }
    }

    void d() {
        try {
            this.b.flush();
        } catch (java.io.IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }

    boolean e(int i) {
        boolean z = false;
        int i2;
        Object obj;
        int i3;
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Invalid initial window size: ";
            i = str + i;
            throw new IllegalArgumentException(i);
        } else {
            int i5 = i - this.c;
            this.c = i;
            io.grpc.k1.g[] objArr = this.a.V();
            for (io.grpc.k1.g gVar : objArr) {
                obj = gVar.O();
            }
            if (i5 > 0) {
                int i6 = 1;
            }
            return z;
        }
    }

    int g(g gVar, int i) {
        int i22;
        if (gVar == null) {
            i22 = this.d.f(i);
            h();
        } else {
            io.grpc.k1.p.b bVar2 = f(gVar);
            io.grpc.k1.p.c cVar = new p.c(null);
            bVar2.l(bVar2.j(), cVar);
            if (cVar.a()) {
                d();
            }
        }
        return i22;
    }

    void h() {
        int i;
        int length;
        int i2;
        io.grpc.k1.g gVar;
        int min;
        io.grpc.k1.g[] objArr = this.a.V();
        i = this.d.i();
        length = objArr.length;
        length = 0;
        while (length > 0) {
            if (this.d <= 0) {
                break;
            }
        }
        io.grpc.k1.p.c cVar = new p.c(null);
        io.grpc.k1.g[] objArr2 = this.a.V();
        for (io.grpc.k1.g gVar2 : objArr2) {
            io.grpc.k1.p.b bVar2 = f(gVar2);
            bVar2.l(bVar2.b(), cVar);
            bVar2.c();
        }
        if (cVar.a()) {
            d();
        }
    }
}
