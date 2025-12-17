package com.google.android.exoplayer2.drm;

import android.os.Handler;
import com.google.android.exoplayer2.source.y.a;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public interface u {

    public static class a {

        public final int a;
        public final y.a b;
        private final CopyOnWriteArrayList<com.google.android.exoplayer2.drm.u.a.a> c;
        public a() {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            super(copyOnWriteArrayList, 0, 0);
        }

        private a(CopyOnWriteArrayList<com.google.android.exoplayer2.drm.u.a.a> copyOnWriteArrayList, int i2, y.a y$a3) {
            super();
            this.c = copyOnWriteArrayList;
            this.a = i2;
            this.b = a3;
        }

        private void h(com.google.android.exoplayer2.drm.u u) {
            u.c0(this.a, this.b);
        }

        private void j(com.google.android.exoplayer2.drm.u u) {
            u.U(this.a, this.b);
        }

        private void l(com.google.android.exoplayer2.drm.u u) {
            u.n0(this.a, this.b);
        }

        private void n(com.google.android.exoplayer2.drm.u u, int i2) {
            u.X(this.a, this.b);
            u.i0(this.a, this.b, i2);
        }

        private void p(com.google.android.exoplayer2.drm.u u, Exception exception2) {
            u.M(this.a, this.b, exception2);
        }

        private void r(com.google.android.exoplayer2.drm.u u) {
            u.j0(this.a, this.b);
        }

        public void a(Handler handler, com.google.android.exoplayer2.drm.u u2) {
            g.e(handler);
            g.e(u2);
            u.a.a aVar = new u.a.a(handler, u2);
            this.c.add(aVar);
        }

        public void b() {
            Handler handler;
            com.google.android.exoplayer2.drm.u uVar;
            com.google.android.exoplayer2.drm.i iVar;
            Iterator iterator = this.c.iterator();
            for (u.a.a next2 : iterator) {
                iVar = new i(this, next2.b);
                p0.v0(next2.a, iVar);
            }
        }

        public void c() {
            Handler handler;
            com.google.android.exoplayer2.drm.u uVar;
            com.google.android.exoplayer2.drm.h hVar;
            Iterator iterator = this.c.iterator();
            for (u.a.a next2 : iterator) {
                hVar = new h(this, next2.b);
                p0.v0(next2.a, hVar);
            }
        }

        public void d() {
            Handler handler;
            com.google.android.exoplayer2.drm.u uVar;
            com.google.android.exoplayer2.drm.j jVar;
            Iterator iterator = this.c.iterator();
            for (u.a.a next2 : iterator) {
                jVar = new j(this, next2.b);
                p0.v0(next2.a, jVar);
            }
        }

        public void e(int i) {
            Handler handler;
            com.google.android.exoplayer2.drm.u uVar;
            com.google.android.exoplayer2.drm.l lVar;
            Iterator iterator = this.c.iterator();
            for (u.a.a next2 : iterator) {
                lVar = new l(this, next2.b, i);
                p0.v0(next2.a, lVar);
            }
        }

        public void f(Exception exception) {
            Handler handler;
            com.google.android.exoplayer2.drm.u uVar;
            com.google.android.exoplayer2.drm.k kVar;
            Iterator iterator = this.c.iterator();
            for (u.a.a next2 : iterator) {
                kVar = new k(this, next2.b, exception);
                p0.v0(next2.a, kVar);
            }
        }

        public void g() {
            Handler handler;
            com.google.android.exoplayer2.drm.u uVar;
            com.google.android.exoplayer2.drm.g gVar;
            Iterator iterator = this.c.iterator();
            for (u.a.a next2 : iterator) {
                gVar = new g(this, next2.b);
                p0.v0(next2.a, gVar);
            }
        }

        public void i(com.google.android.exoplayer2.drm.u u) {
            h(u);
        }

        public void k(com.google.android.exoplayer2.drm.u u) {
            j(u);
        }

        public void m(com.google.android.exoplayer2.drm.u u) {
            l(u);
        }

        public void o(com.google.android.exoplayer2.drm.u u, int i2) {
            n(u, i2);
        }

        public void q(com.google.android.exoplayer2.drm.u u, Exception exception2) {
            p(u, exception2);
        }

        public void s(com.google.android.exoplayer2.drm.u u) {
            r(u);
        }

        public void t(com.google.android.exoplayer2.drm.u u) {
            Object next;
            Object obj;
            Iterator iterator = this.c.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (next.b == u) {
                }
                this.c.remove((u.a.a)next);
            }
        }

        public com.google.android.exoplayer2.drm.u.a u(int i, y.a y$a2) {
            u.a aVar = new u.a(this.c, i, a2);
            return aVar;
        }
    }
    public void M(int i, y.a y$a2, Exception exception3) {
    }

    public void U(int i, y.a y$a2) {
    }

    @Deprecated
    public void X(int i, y.a y$a2) {
    }

    public void c0(int i, y.a y$a2) {
    }

    public void i0(int i, y.a y$a2, int i3) {
    }

    public void j0(int i, y.a y$a2) {
    }

    public void n0(int i, y.a y$a2) {
    }
}
