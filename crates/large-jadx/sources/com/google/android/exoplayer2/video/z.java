package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.decoder.d;
import com.google.android.exoplayer2.decoder.e;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;

/* loaded from: classes2.dex */
public interface z {

    public static final class a {

        private final Handler a = null;
        private final com.google.android.exoplayer2.video.z b;
        public a(Handler handler, com.google.android.exoplayer2.video.z z2) {
            super();
            if (z2 != null) {
                g.e(handler);
            }
            final int obj1 = 0;
            this.b = z2;
        }

        private void g(String string, long l2, long l3) {
            final com.google.android.exoplayer2.video.z zVar = this.b;
            p0.i(zVar);
            (z)zVar.H(string, l2, obj4);
        }

        private void i(String string) {
            final com.google.android.exoplayer2.video.z zVar = this.b;
            p0.i(zVar);
            (z)zVar.E(string);
        }

        private void k(d d) {
            d.c();
            final com.google.android.exoplayer2.video.z zVar = this.b;
            p0.i(zVar);
            (z)zVar.h0(d);
        }

        private void m(int i, long l2) {
            final com.google.android.exoplayer2.video.z zVar = this.b;
            p0.i(zVar);
            (z)zVar.R(i, l2);
        }

        private void o(d d) {
            final com.google.android.exoplayer2.video.z zVar = this.b;
            p0.i(zVar);
            (z)zVar.Z(d);
        }

        private void q(i1 i1, e e2) {
            com.google.android.exoplayer2.video.z zVar = this.b;
            p0.i(zVar);
            (z)zVar.Y(i1);
            com.google.android.exoplayer2.video.z zVar2 = this.b;
            p0.i(zVar2);
            (z)zVar2.a0(i1, e2);
        }

        private void s(Object object, long l2) {
            final com.google.android.exoplayer2.video.z zVar = this.b;
            p0.i(zVar);
            (z)zVar.W(object, l2);
        }

        private void u(long l, int i2) {
            final com.google.android.exoplayer2.video.z zVar = this.b;
            p0.i(zVar);
            (z)zVar.m0(l, i2);
        }

        private void w(Exception exception) {
            final com.google.android.exoplayer2.video.z zVar = this.b;
            p0.i(zVar);
            (z)zVar.f0(exception);
        }

        private void y(com.google.android.exoplayer2.video.a0 a0) {
            final com.google.android.exoplayer2.video.z zVar = this.b;
            p0.i(zVar);
            (z)zVar.b(a0);
        }

        public void A(Object object) {
            Handler elapsedRealtime;
            Handler handler;
            com.google.android.exoplayer2.video.f fVar;
            if (this.a != null) {
                fVar = new f(this, object, SystemClock.elapsedRealtime(), obj1);
                this.a.post(fVar);
            }
        }

        public void B(long l, int i2) {
            com.google.android.exoplayer2.video.k kVar;
            final Handler handler = this.a;
            if (handler != null) {
                kVar = new k(this, l, i2, obj5);
                handler.post(kVar);
            }
        }

        public void C(Exception exception) {
            com.google.android.exoplayer2.video.d dVar;
            final Handler handler = this.a;
            if (handler != null) {
                dVar = new d(this, exception);
                handler.post(dVar);
            }
        }

        public void D(com.google.android.exoplayer2.video.a0 a0) {
            com.google.android.exoplayer2.video.i iVar;
            final Handler handler = this.a;
            if (handler != null) {
                iVar = new i(this, a0);
                handler.post(iVar);
            }
        }

        public void a(String string, long l2, long l3) {
            com.google.android.exoplayer2.video.h hVar;
            Object obj;
            String str;
            long l;
            Object obj2;
            com.google.android.exoplayer2.video.h hVar2;
            final Handler handler = this.a;
            if (handler != null) {
                super(this, string, l2, obj5, obj13, obj7);
                handler.post(hVar2);
            }
        }

        public void b(String string) {
            com.google.android.exoplayer2.video.c cVar;
            final Handler handler = this.a;
            if (handler != null) {
                cVar = new c(this, string);
                handler.post(cVar);
            }
        }

        public void c(d d) {
            com.google.android.exoplayer2.video.b bVar;
            d.c();
            final Handler handler = this.a;
            if (handler != null) {
                bVar = new b(this, d);
                handler.post(bVar);
            }
        }

        public void d(int i, long l2) {
            com.google.android.exoplayer2.video.g gVar;
            final Handler handler = this.a;
            if (handler != null) {
                gVar = new g(this, i, l2, obj5);
                handler.post(gVar);
            }
        }

        public void e(d d) {
            com.google.android.exoplayer2.video.e eVar;
            final Handler handler = this.a;
            if (handler != null) {
                eVar = new e(this, d);
                handler.post(eVar);
            }
        }

        public void f(i1 i1, e e2) {
            com.google.android.exoplayer2.video.j jVar;
            final Handler handler = this.a;
            if (handler != null) {
                jVar = new j(this, i1, e2);
                handler.post(jVar);
            }
        }

        public void h(String string, long l2, long l3) {
            g(string, l2, l3);
        }

        public void j(String string) {
            i(string);
        }

        public void l(d d) {
            k(d);
        }

        public void n(int i, long l2) {
            m(i, l2);
        }

        public void p(d d) {
            o(d);
        }

        public void r(i1 i1, e e2) {
            q(i1, e2);
        }

        public void t(Object object, long l2) {
            s(object, l2);
        }

        public void v(long l, int i2) {
            u(l, i2);
        }

        public void x(Exception exception) {
            w(exception);
        }

        public void z(com.google.android.exoplayer2.video.a0 a0) {
            y(a0);
        }
    }
    public void E(String string) {
    }

    public void H(String string, long l2, long l3) {
    }

    public void R(int i, long l2) {
    }

    public void W(Object object, long l2) {
    }

    @Deprecated
    public void Y(i1 i1) {
    }

    public void Z(d d) {
    }

    public void a0(i1 i1, e e2) {
    }

    public void b(com.google.android.exoplayer2.video.a0 a0) {
    }

    public void f0(Exception exception) {
    }

    public void h0(d d) {
    }

    public void m0(long l, int i2) {
    }
}
