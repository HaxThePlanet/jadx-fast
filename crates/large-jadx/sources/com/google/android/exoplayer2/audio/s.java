package com.google.android.exoplayer2.audio;

import android.os.Handler;
import com.google.android.exoplayer2.decoder.d;
import com.google.android.exoplayer2.decoder.e;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;

/* loaded from: classes2.dex */
public interface s {

    public static final class a {

        private final Handler a = null;
        private final com.google.android.exoplayer2.audio.s b;
        public a(Handler handler, com.google.android.exoplayer2.audio.s s2) {
            super();
            if (s2 != null) {
                g.e(handler);
            }
            final int obj1 = 0;
            this.b = s2;
        }

        private void h(Exception exception) {
            final com.google.android.exoplayer2.audio.s sVar = this.b;
            p0.i(sVar);
            (s)sVar.d0(exception);
        }

        private void j(Exception exception) {
            final com.google.android.exoplayer2.audio.s sVar = this.b;
            p0.i(sVar);
            (s)sVar.t(exception);
        }

        private void l(String string, long l2, long l3) {
            final com.google.android.exoplayer2.audio.s sVar = this.b;
            p0.i(sVar);
            (s)sVar.Q(string, l2, obj4);
        }

        private void n(String string) {
            final com.google.android.exoplayer2.audio.s sVar = this.b;
            p0.i(sVar);
            (s)sVar.P(string);
        }

        private void p(d d) {
            d.c();
            final com.google.android.exoplayer2.audio.s sVar = this.b;
            p0.i(sVar);
            (s)sVar.D(d);
        }

        private void r(d d) {
            final com.google.android.exoplayer2.audio.s sVar = this.b;
            p0.i(sVar);
            (s)sVar.F(d);
        }

        private void t(i1 i1, e e2) {
            com.google.android.exoplayer2.audio.s sVar = this.b;
            p0.i(sVar);
            (s)sVar.e0(i1);
            com.google.android.exoplayer2.audio.s sVar2 = this.b;
            p0.i(sVar2);
            (s)sVar2.T(i1, e2);
        }

        private void v(long l) {
            final com.google.android.exoplayer2.audio.s sVar = this.b;
            p0.i(sVar);
            (s)sVar.b0(l);
        }

        private void x(boolean z) {
            final com.google.android.exoplayer2.audio.s sVar = this.b;
            p0.i(sVar);
            (s)sVar.a(z);
        }

        private void z(int i, long l2, long l3) {
            final com.google.android.exoplayer2.audio.s sVar = this.b;
            p0.i(sVar);
            (s)sVar.k0(i, l2, obj4);
        }

        public void A(int i, long l2, long l3) {
            z(i, l2, l3);
        }

        public void B(long l) {
            com.google.android.exoplayer2.audio.i iVar;
            final Handler handler = this.a;
            if (handler != null) {
                iVar = new i(this, l, obj4);
                handler.post(iVar);
            }
        }

        public void C(boolean z) {
            com.google.android.exoplayer2.audio.b bVar;
            final Handler handler = this.a;
            if (handler != null) {
                bVar = new b(this, z);
                handler.post(bVar);
            }
        }

        public void D(int i, long l2, long l3) {
            com.google.android.exoplayer2.audio.j jVar;
            Object obj;
            int i2;
            long l;
            Object obj2;
            com.google.android.exoplayer2.audio.j jVar2;
            final Handler handler = this.a;
            if (handler != null) {
                super(this, i, l2, obj5, obj13, obj7);
                handler.post(jVar2);
            }
        }

        public void a(Exception exception) {
            com.google.android.exoplayer2.audio.d dVar;
            final Handler handler = this.a;
            if (handler != null) {
                dVar = new d(this, exception);
                handler.post(dVar);
            }
        }

        public void b(Exception exception) {
            com.google.android.exoplayer2.audio.e eVar;
            final Handler handler = this.a;
            if (handler != null) {
                eVar = new e(this, exception);
                handler.post(eVar);
            }
        }

        public void c(String string, long l2, long l3) {
            com.google.android.exoplayer2.audio.g gVar;
            Object obj;
            String str;
            long l;
            Object obj2;
            com.google.android.exoplayer2.audio.g gVar2;
            final Handler handler = this.a;
            if (handler != null) {
                super(this, string, l2, obj5, obj13, obj7);
                handler.post(gVar2);
            }
        }

        public void d(String string) {
            com.google.android.exoplayer2.audio.h hVar;
            final Handler handler = this.a;
            if (handler != null) {
                hVar = new h(this, string);
                handler.post(hVar);
            }
        }

        public void e(d d) {
            com.google.android.exoplayer2.audio.c cVar;
            d.c();
            final Handler handler = this.a;
            if (handler != null) {
                cVar = new c(this, d);
                handler.post(cVar);
            }
        }

        public void f(d d) {
            com.google.android.exoplayer2.audio.k kVar;
            final Handler handler = this.a;
            if (handler != null) {
                kVar = new k(this, d);
                handler.post(kVar);
            }
        }

        public void g(i1 i1, e e2) {
            com.google.android.exoplayer2.audio.f fVar;
            final Handler handler = this.a;
            if (handler != null) {
                fVar = new f(this, i1, e2);
                handler.post(fVar);
            }
        }

        public void i(Exception exception) {
            h(exception);
        }

        public void k(Exception exception) {
            j(exception);
        }

        public void m(String string, long l2, long l3) {
            l(string, l2, l3);
        }

        public void o(String string) {
            n(string);
        }

        public void q(d d) {
            p(d);
        }

        public void s(d d) {
            r(d);
        }

        public void u(i1 i1, e e2) {
            t(i1, e2);
        }

        public void w(long l) {
            v(l);
        }

        public void y(boolean z) {
            x(z);
        }
    }
    public void D(d d) {
    }

    public void F(d d) {
    }

    public void P(String string) {
    }

    public void Q(String string, long l2, long l3) {
    }

    public void T(i1 i1, e e2) {
    }

    public void a(boolean z) {
    }

    public void b0(long l) {
    }

    public void d0(Exception exception) {
    }

    @Deprecated
    public void e0(i1 i1) {
    }

    public void k0(int i, long l2, long l3) {
    }

    public void t(Exception exception) {
    }
}
