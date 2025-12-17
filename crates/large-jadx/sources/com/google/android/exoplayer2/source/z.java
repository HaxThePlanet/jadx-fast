package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.w0;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public interface z {

    public static class a {

        public final int a;
        public final com.google.android.exoplayer2.source.y.a b;
        private final CopyOnWriteArrayList<com.google.android.exoplayer2.source.z.a.a> c;
        private final long d;
        public a() {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            super(copyOnWriteArrayList, 0, 0, 0, obj5);
        }

        private a(CopyOnWriteArrayList<com.google.android.exoplayer2.source.z.a.a> copyOnWriteArrayList, int i2, com.google.android.exoplayer2.source.y.a y$a3, long l4) {
            super();
            this.c = copyOnWriteArrayList;
            this.a = i2;
            this.b = a3;
            this.d = l4;
        }

        private long b(long l) {
            long l2;
            final long obj4 = w0.e(l);
            if (Long.compare(obj4, l2) == 0) {
            } else {
                l3 += obj4;
            }
            return l2;
        }

        private void e(com.google.android.exoplayer2.source.z z, com.google.android.exoplayer2.source.v v2) {
            z.I(this.a, this.b, v2);
        }

        private void g(com.google.android.exoplayer2.source.z z, com.google.android.exoplayer2.source.s s2, com.google.android.exoplayer2.source.v v3) {
            z.J(this.a, this.b, s2, v3);
        }

        private void i(com.google.android.exoplayer2.source.z z, com.google.android.exoplayer2.source.s s2, com.google.android.exoplayer2.source.v v3) {
            z.g0(this.a, this.b, s2, v3);
        }

        private void k(com.google.android.exoplayer2.source.z z, com.google.android.exoplayer2.source.s s2, com.google.android.exoplayer2.source.v v3, IOException iOException4, boolean z5) {
            z.l0(this.a, this.b, s2, v3, iOException4, z5);
        }

        private void m(com.google.android.exoplayer2.source.z z, com.google.android.exoplayer2.source.s s2, com.google.android.exoplayer2.source.v v3) {
            z.N(this.a, this.b, s2, v3);
        }

        private void o(com.google.android.exoplayer2.source.z z, com.google.android.exoplayer2.source.y.a y$a2, com.google.android.exoplayer2.source.v v3) {
            z.K(this.a, a2, v3);
        }

        public void A(com.google.android.exoplayer2.source.s s, int i2, int i3, i1 i14, int i5, Object object6, long l7, long l8) {
            final Object obj = this;
            super(i2, i3, i14, i5, object6, b(l7), obj8, b(obj21), obj10);
            com.google.android.exoplayer2.source.s sVar = s;
            B(s, vVar2);
        }

        public void B(com.google.android.exoplayer2.source.s s, com.google.android.exoplayer2.source.v v2) {
            Handler handler;
            com.google.android.exoplayer2.source.z zVar;
            com.google.android.exoplayer2.source.f fVar;
            Iterator iterator = this.c.iterator();
            for (z.a.a next2 : iterator) {
                fVar = new f(this, next2.b, s, v2);
                p0.v0(next2.a, fVar);
            }
        }

        public void C(com.google.android.exoplayer2.source.z z) {
            Object next;
            Object obj;
            Iterator iterator = this.c.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (next.b == z) {
                }
                this.c.remove((z.a.a)next);
            }
        }

        public void D(int i, long l2, long l3) {
            final Object obj = this;
            long l = l2;
            super(1, i, 0, 3, 0, b(l2), obj8, b(obj16), obj10);
            E(vVar2);
        }

        public void E(com.google.android.exoplayer2.source.v v) {
            Handler handler;
            com.google.android.exoplayer2.source.z zVar;
            com.google.android.exoplayer2.source.b bVar;
            final com.google.android.exoplayer2.source.y.a aVar = this.b;
            g.e(aVar);
            Iterator iterator = this.c.iterator();
            for (z.a.a next2 : iterator) {
                bVar = new b(this, next2.b, (y.a)aVar, v);
                p0.v0(next2.a, bVar);
            }
        }

        public com.google.android.exoplayer2.source.z.a F(int i, com.google.android.exoplayer2.source.y.a y$a2, long l3) {
            super(this.c, i, a2, l3, obj5);
            return aVar3;
        }

        public void a(Handler handler, com.google.android.exoplayer2.source.z z2) {
            g.e(handler);
            g.e(z2);
            z.a.a aVar = new z.a.a(handler, z2);
            this.c.add(aVar);
        }

        public void c(int i, i1 i12, int i3, Object object4, long l5) {
            final Object obj = this;
            super(1, i, i12, i3, object4, b(l5), obj8, -9223372036854775807L, obj10);
            d(vVar2);
        }

        public void d(com.google.android.exoplayer2.source.v v) {
            Handler handler;
            com.google.android.exoplayer2.source.z zVar;
            com.google.android.exoplayer2.source.e eVar;
            Iterator iterator = this.c.iterator();
            for (z.a.a next2 : iterator) {
                eVar = new e(this, next2.b, v);
                p0.v0(next2.a, eVar);
            }
        }

        public void f(com.google.android.exoplayer2.source.z z, com.google.android.exoplayer2.source.v v2) {
            e(z, v2);
        }

        public void h(com.google.android.exoplayer2.source.z z, com.google.android.exoplayer2.source.s s2, com.google.android.exoplayer2.source.v v3) {
            g(z, s2, v3);
        }

        public void j(com.google.android.exoplayer2.source.z z, com.google.android.exoplayer2.source.s s2, com.google.android.exoplayer2.source.v v3) {
            i(z, s2, v3);
        }

        public void l(com.google.android.exoplayer2.source.z z, com.google.android.exoplayer2.source.s s2, com.google.android.exoplayer2.source.v v3, IOException iOException4, boolean z5) {
            k(z, s2, v3, iOException4, z5);
        }

        public void n(com.google.android.exoplayer2.source.z z, com.google.android.exoplayer2.source.s s2, com.google.android.exoplayer2.source.v v3) {
            m(z, s2, v3);
        }

        public void p(com.google.android.exoplayer2.source.z z, com.google.android.exoplayer2.source.y.a y$a2, com.google.android.exoplayer2.source.v v3) {
            o(z, a2, v3);
        }

        public void q(com.google.android.exoplayer2.source.s s, int i2) {
            this.r(s, i2, -1, 0, 0, 0, -9223372036854775807L, obj8);
        }

        public void r(com.google.android.exoplayer2.source.s s, int i2, int i3, i1 i14, int i5, Object object6, long l7, long l8) {
            final Object obj = this;
            super(i2, i3, i14, i5, object6, b(l7), obj8, b(obj21), obj10);
            com.google.android.exoplayer2.source.s sVar = s;
            s(s, vVar2);
        }

        public void s(com.google.android.exoplayer2.source.s s, com.google.android.exoplayer2.source.v v2) {
            Handler handler;
            com.google.android.exoplayer2.source.z zVar;
            com.google.android.exoplayer2.source.g gVar;
            Iterator iterator = this.c.iterator();
            for (z.a.a next2 : iterator) {
                gVar = new g(this, next2.b, s, v2);
                p0.v0(next2.a, gVar);
            }
        }

        public void t(com.google.android.exoplayer2.source.s s, int i2) {
            this.u(s, i2, -1, 0, 0, 0, -9223372036854775807L, obj8);
        }

        public void u(com.google.android.exoplayer2.source.s s, int i2, int i3, i1 i14, int i5, Object object6, long l7, long l8) {
            final Object obj = this;
            super(i2, i3, i14, i5, object6, b(l7), obj8, b(obj21), obj10);
            com.google.android.exoplayer2.source.s sVar = s;
            v(s, vVar2);
        }

        public void v(com.google.android.exoplayer2.source.s s, com.google.android.exoplayer2.source.v v2) {
            Handler handler;
            com.google.android.exoplayer2.source.z zVar;
            com.google.android.exoplayer2.source.d dVar;
            Iterator iterator = this.c.iterator();
            for (z.a.a next2 : iterator) {
                dVar = new d(this, next2.b, s, v2);
                p0.v0(next2.a, dVar);
            }
        }

        public void w(com.google.android.exoplayer2.source.s s, int i2, int i3, i1 i14, int i5, Object object6, long l7, long l8, IOException iOException9, boolean z10) {
            final Object obj = this;
            super(i2, i3, i14, i5, object6, b(l7), obj8, b(iOException9), obj10);
            com.google.android.exoplayer2.source.s sVar = s;
            y(s, vVar2, obj23, obj24);
        }

        public void x(com.google.android.exoplayer2.source.s s, int i2, IOException iOException3, boolean z4) {
            this.w(s, i2, -1, 0, 0, 0, -9223372036854775807L, obj8, -9223372036854775807L, obj10);
        }

        public void y(com.google.android.exoplayer2.source.s s, com.google.android.exoplayer2.source.v v2, IOException iOException3, boolean z4) {
            Handler handler;
            com.google.android.exoplayer2.source.c cVar;
            Object obj;
            com.google.android.exoplayer2.source.z zVar;
            com.google.android.exoplayer2.source.s sVar;
            com.google.android.exoplayer2.source.v vVar;
            IOException exc;
            boolean z;
            com.google.android.exoplayer2.source.c cVar2;
            Iterator iterator = this.c.iterator();
            for (z.a.a next2 : iterator) {
                super(this, next2.b, s, v2, iOException3, z4);
                p0.v0(next2.a, cVar2);
            }
        }

        public void z(com.google.android.exoplayer2.source.s s, int i2) {
            this.A(s, i2, -1, 0, 0, 0, -9223372036854775807L, obj8);
        }
    }
    public void I(int i, com.google.android.exoplayer2.source.y.a y$a2, com.google.android.exoplayer2.source.v v3) {
    }

    public void J(int i, com.google.android.exoplayer2.source.y.a y$a2, com.google.android.exoplayer2.source.s s3, com.google.android.exoplayer2.source.v v4) {
    }

    public void K(int i, com.google.android.exoplayer2.source.y.a y$a2, com.google.android.exoplayer2.source.v v3) {
    }

    public void N(int i, com.google.android.exoplayer2.source.y.a y$a2, com.google.android.exoplayer2.source.s s3, com.google.android.exoplayer2.source.v v4) {
    }

    public void g0(int i, com.google.android.exoplayer2.source.y.a y$a2, com.google.android.exoplayer2.source.s s3, com.google.android.exoplayer2.source.v v4) {
    }

    public void l0(int i, com.google.android.exoplayer2.source.y.a y$a2, com.google.android.exoplayer2.source.s s3, com.google.android.exoplayer2.source.v v4, IOException iOException5, boolean z6) {
    }
}
