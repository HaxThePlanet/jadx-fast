package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.drm.u;
import com.google.android.exoplayer2.drm.u.a;
import com.google.android.exoplayer2.g2;
import com.google.android.exoplayer2.upstream.b0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class l<T>  extends com.google.android.exoplayer2.source.j {

    private final HashMap<T, com.google.android.exoplayer2.source.l.b<T>> g;
    private Handler h;
    private b0 i;

    private static final class b {

        public final com.google.android.exoplayer2.source.y a;
        public final com.google.android.exoplayer2.source.y.b b;
        public final com.google.android.exoplayer2.source.l.a<T> c;
        public b(com.google.android.exoplayer2.source.y y, com.google.android.exoplayer2.source.y.b y$b2, com.google.android.exoplayer2.source.l.a<T> l.a3) {
            super();
            this.a = y;
            this.b = b2;
            this.c = l.a3;
        }
    }

    private final class a implements com.google.android.exoplayer2.source.z, u {

        private final T a;
        private com.google.android.exoplayer2.source.z.a b;
        private u.a c;
        final com.google.android.exoplayer2.source.l v;
        public a(com.google.android.exoplayer2.source.l l, Object object2) {
            this.v = l;
            super();
            final int i = 0;
            this.b = l.s(i);
            this.c = l.q(i);
            this.a = object2;
        }

        private boolean a(int i, com.google.android.exoplayer2.source.y.a y$a2) {
            com.google.android.exoplayer2.source.l lVar;
            com.google.android.exoplayer2.source.z.a aVar;
            com.google.android.exoplayer2.source.l aVar2;
            Object obj;
            int i2;
            u.a obj4;
            int obj5;
            if (a2 != null) {
                if (this.v.z(this.a, a2) == null) {
                    return 0;
                }
            } else {
                obj5 = 0;
            }
            this.v.B(this.a, i);
            aVar = this.b;
            if (aVar.a == i) {
                if (!p0.b(aVar.b, obj5)) {
                    this.b = this.v.r(i, obj5, 0);
                }
            } else {
            }
            aVar2 = this.c;
            if (aVar2.a == i) {
                if (!p0.b(aVar2.b, obj5)) {
                    this.c = this.v.p(i, obj5);
                }
            } else {
            }
            return 1;
        }

        private com.google.android.exoplayer2.source.v b(com.google.android.exoplayer2.source.v v) {
            int cmp;
            final long l3 = v.f;
            this.v.A(this.a, l3);
            final long l4 = v.g;
            this.v.A(this.a, l4);
            if (Long.compare(l3, l) == 0 && Long.compare(l4, l2) == 0) {
                if (Long.compare(l4, l2) == 0) {
                    return v;
                }
            }
            super(v.a, v.b, v.c, v.d, v.e, l3, obj9, l4, obj11);
            return vVar;
        }

        @Override // com.google.android.exoplayer2.source.z
        public void I(int i, com.google.android.exoplayer2.source.y.a y$a2, com.google.android.exoplayer2.source.v v3) {
            boolean obj1;
            Object obj2;
            if (a(i, a2)) {
                this.b.d(b(v3));
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void J(int i, com.google.android.exoplayer2.source.y.a y$a2, com.google.android.exoplayer2.source.s s3, com.google.android.exoplayer2.source.v v4) {
            boolean obj1;
            Object obj2;
            if (a(i, a2)) {
                this.b.s(s3, b(v4));
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void K(int i, com.google.android.exoplayer2.source.y.a y$a2, com.google.android.exoplayer2.source.v v3) {
            boolean obj1;
            Object obj2;
            if (a(i, a2)) {
                this.b.E(b(v3));
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void M(int i, com.google.android.exoplayer2.source.y.a y$a2, Exception exception3) {
            boolean obj1;
            if (a(i, a2)) {
                this.c.f(exception3);
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void N(int i, com.google.android.exoplayer2.source.y.a y$a2, com.google.android.exoplayer2.source.s s3, com.google.android.exoplayer2.source.v v4) {
            boolean obj1;
            Object obj2;
            if (a(i, a2)) {
                this.b.B(s3, b(v4));
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void U(int i, com.google.android.exoplayer2.source.y.a y$a2) {
            boolean obj1;
            if (a(i, a2)) {
                this.c.c();
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void c0(int i, com.google.android.exoplayer2.source.y.a y$a2) {
            boolean obj1;
            if (a(i, a2)) {
                this.c.b();
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void g0(int i, com.google.android.exoplayer2.source.y.a y$a2, com.google.android.exoplayer2.source.s s3, com.google.android.exoplayer2.source.v v4) {
            boolean obj1;
            Object obj2;
            if (a(i, a2)) {
                this.b.v(s3, b(v4));
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void i0(int i, com.google.android.exoplayer2.source.y.a y$a2, int i3) {
            boolean obj1;
            if (a(i, a2)) {
                this.c.e(i3);
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void j0(int i, com.google.android.exoplayer2.source.y.a y$a2) {
            boolean obj1;
            if (a(i, a2)) {
                this.c.g();
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void l0(int i, com.google.android.exoplayer2.source.y.a y$a2, com.google.android.exoplayer2.source.s s3, com.google.android.exoplayer2.source.v v4, IOException iOException5, boolean z6) {
            boolean obj1;
            Object obj2;
            if (a(i, a2)) {
                this.b.y(s3, b(v4), iOException5, z6);
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void n0(int i, com.google.android.exoplayer2.source.y.a y$a2) {
            boolean obj1;
            if (a(i, a2)) {
                this.c.d();
            }
        }
    }
    protected l() {
        super();
        HashMap hashMap = new HashMap();
        this.g = hashMap;
    }

    private void C(Object object, com.google.android.exoplayer2.source.y y2, g2 g23) {
        E(object, y2, g23);
    }

    protected long A(T t, long l2) {
        return l2;
    }

    protected int B(T t, int i2) {
        return i2;
    }

    @Override // com.google.android.exoplayer2.source.j
    public void D(Object object, com.google.android.exoplayer2.source.y y2, g2 g23) {
        C(object, y2, g23);
    }

    protected abstract void E(T t, com.google.android.exoplayer2.source.y y2, g2 g23);

    protected final void F(T t, com.google.android.exoplayer2.source.y y2) {
        g.a(key ^= 1);
        a aVar = new a(this, t);
        l.a aVar2 = new l.a(this, t);
        l.b bVar = new l.b(y2, aVar, aVar2);
        this.g.put(t, bVar);
        Handler obj5 = this.h;
        g.e(obj5);
        y2.d(obj5, aVar2);
        obj5 = this.h;
        g.e(obj5);
        y2.h(obj5, aVar2);
        y2.n(aVar, this.i);
        if (!v()) {
            y2.f(aVar);
        }
    }

    @Override // com.google.android.exoplayer2.source.j
    public void j() {
        com.google.android.exoplayer2.source.y yVar;
        Iterator iterator = this.g.values().iterator();
        for (l.b next2 : iterator) {
            next2.a.j();
        }
    }

    @Override // com.google.android.exoplayer2.source.j
    protected void t() {
        com.google.android.exoplayer2.source.y.b bVar;
        com.google.android.exoplayer2.source.y yVar;
        Iterator iterator = this.g.values().iterator();
        for (l.b next2 : iterator) {
            next2.a.f(next2.b);
        }
    }

    @Override // com.google.android.exoplayer2.source.j
    protected void u() {
        com.google.android.exoplayer2.source.y.b bVar;
        com.google.android.exoplayer2.source.y yVar;
        Iterator iterator = this.g.values().iterator();
        for (l.b next2 : iterator) {
            next2.a.o(next2.b);
        }
    }

    @Override // com.google.android.exoplayer2.source.j
    protected void w(b0 b0) {
        this.i = b0;
        this.h = p0.u();
    }

    @Override // com.google.android.exoplayer2.source.j
    protected void y() {
        com.google.android.exoplayer2.source.l.a aVar2;
        com.google.android.exoplayer2.source.y yVar;
        com.google.android.exoplayer2.source.l.a aVar;
        Iterator iterator = this.g.values().iterator();
        for (l.b next2 : iterator) {
            next2.a.b(next2.b);
            next2.a.e(next2.c);
            next2.a.i(next2.c);
        }
        this.g.clear();
    }

    protected com.google.android.exoplayer2.source.y.a z(T t, com.google.android.exoplayer2.source.y.a y$a2) {
        return a2;
    }
}
