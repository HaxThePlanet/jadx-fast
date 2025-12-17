package com.bumptech.glide.load.n.g;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.c;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.l;
import com.bumptech.glide.n.a;
import com.bumptech.glide.r.a;
import com.bumptech.glide.r.g;
import com.bumptech.glide.r.k.c;
import com.bumptech.glide.r.l.d;
import com.bumptech.glide.s.d;
import com.bumptech.glide.t.k;
import com.bumptech.glide.t.l;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class g {

    private final a a;
    private final Handler b;
    private final List<com.bumptech.glide.load.n.g.g.b> c;
    final k d;
    private final e e;
    private boolean f;
    private boolean g;
    private boolean h;
    private j<Bitmap> i;
    private com.bumptech.glide.load.n.g.g.a j;
    private boolean k;
    private com.bumptech.glide.load.n.g.g.a l;
    private Bitmap m;
    private l<Bitmap> n;
    private com.bumptech.glide.load.n.g.g.a o;
    private com.bumptech.glide.load.n.g.g.d p;
    private int q;
    private int r;
    private int s;

    public interface b {
        public abstract void a();
    }

    private class c implements Handler.Callback {

        final com.bumptech.glide.load.n.g.g a;
        c(com.bumptech.glide.load.n.g.g g) {
            this.a = g;
            super();
        }

        @Override // android.os.Handler$Callback
        public boolean handleMessage(Message message) {
            int what;
            Object obj3;
            what = message.what;
            int i = 1;
            if (what == i) {
                this.a.m((g.a)message.obj);
                return i;
            }
            if (what == 2) {
                gVar2.d.e((g.a)message.obj);
            }
            return 0;
        }
    }

    interface d {
        public abstract void a();
    }

    static class a extends c<Bitmap> {

        private final Handler a;
        final int b;
        private final long c;
        private Bitmap v;
        a(Handler handler, int i2, long l3) {
            super();
            this.a = handler;
            this.b = i2;
            this.c = l3;
        }

        @Override // com.bumptech.glide.r.k.c
        Bitmap a() {
            return this.v;
        }

        public void b(Bitmap bitmap, d<? super Bitmap> d2) {
            this.v = bitmap;
            this.a.sendMessageAtTime(this.a.obtainMessage(1, this), this.c);
        }

        @Override // com.bumptech.glide.r.k.c
        public void onLoadCleared(Drawable drawable) {
            this.v = 0;
        }

        @Override // com.bumptech.glide.r.k.c
        public void onResourceReady(Object object, d d2) {
            b((Bitmap)object, d2);
        }
    }
    g(c c, a a2, int i3, int i4, l<Bitmap> l5, Bitmap bitmap6) {
        super(c.f(), c.t(c.h()), a2, 0, g.i(c.t(c.h()), i3, i4), l5, bitmap6);
    }

    g(e e, k k2, a a3, Handler handler4, j<Bitmap> j5, l<Bitmap> l6, Bitmap bitmap7) {
        Object arrayList;
        Object obj3;
        Handler obj5;
        super();
        arrayList = new ArrayList();
        this.c = arrayList;
        this.d = k2;
        if (handler4 == null) {
            arrayList = new g.c(this);
            obj5 = new Handler(Looper.getMainLooper(), arrayList);
        }
        this.e = e;
        this.b = obj5;
        this.i = j5;
        this.a = a3;
        o(l6, bitmap7);
    }

    private static f g() {
        d dVar = new d(Double.valueOf(Math.random()));
        return dVar;
    }

    private static j<Bitmap> i(k k, int i2, int i3) {
        final int i = 1;
        return k.c().r0((g)(g)g.s0(j.a).p0(i).i0(i).Y(i2, i3));
    }

    private void l() {
        boolean z;
        boolean z2;
        int i2;
        com.bumptech.glide.load.n.g.g.a aVar;
        int i3;
        Handler str;
        int i;
        if (this.f) {
            if (this.g) {
            } else {
                int i5 = 1;
                if (this.h) {
                    i3 = 0;
                    i2 = this.o == null ? i5 : i3;
                    k.a(i2, "Pending target must be null when starting from the first frame");
                    this.a.f();
                    this.h = i3;
                }
                com.bumptech.glide.load.n.g.g.a aVar2 = this.o;
                if (aVar2 != null) {
                    this.o = 0;
                    m(aVar2);
                }
                this.g = i5;
                this.a.b();
                g.a aVar5 = new g.a(this.b, this.a.g(), uptimeMillis += l, i3);
                this.l = aVar5;
                this.i.r0(g.u0(g.g())).I0(this.a).z0(this.l);
            }
        }
    }

    private void n() {
        Bitmap bitmap;
        e eVar;
        bitmap = this.m;
        if (bitmap != null) {
            this.e.c(bitmap);
            this.m = 0;
        }
    }

    private void p() {
        if (this.f) {
        }
        this.f = true;
        this.k = false;
        l();
    }

    private void q() {
        this.f = false;
    }

    void a() {
        k kVar;
        this.c.clear();
        n();
        q();
        com.bumptech.glide.load.n.g.g.a aVar = this.j;
        final int i2 = 0;
        if (aVar != null) {
            this.d.e(aVar);
            this.j = i2;
        }
        com.bumptech.glide.load.n.g.g.a aVar2 = this.l;
        if (aVar2 != null) {
            this.d.e(aVar2);
            this.l = i2;
        }
        com.bumptech.glide.load.n.g.g.a aVar3 = this.o;
        if (aVar3 != null) {
            this.d.e(aVar3);
            this.o = i2;
        }
        this.a.clear();
        this.k = true;
    }

    ByteBuffer b() {
        return this.a.getData().asReadOnlyBuffer();
    }

    Bitmap c() {
        Bitmap bitmap;
        com.bumptech.glide.load.n.g.g.a aVar = this.j;
        if (aVar != null) {
            bitmap = aVar.a();
        } else {
            bitmap = this.m;
        }
        return bitmap;
    }

    int d() {
        int i;
        com.bumptech.glide.load.n.g.g.a aVar = this.j;
        i = aVar != null ? aVar.b : -1;
        return i;
    }

    Bitmap e() {
        return this.m;
    }

    int f() {
        return this.a.c();
    }

    int h() {
        return this.s;
    }

    int j() {
        return byteSize += i2;
    }

    int k() {
        return this.r;
    }

    void m(com.bumptech.glide.load.n.g.g.a g$a) {
        Object bitmap;
        Handler z;
        Object obj;
        Object obj4;
        com.bumptech.glide.load.n.g.g.d dVar = this.p;
        if (dVar != null) {
            dVar.a();
        }
        this.g = false;
        final int i2 = 2;
        if (this.k) {
            this.b.obtainMessage(i2, a).sendToTarget();
        }
        if (!this.f) {
            if (this.h) {
                this.b.obtainMessage(i2, a).sendToTarget();
            } else {
                this.o = a;
            }
        }
        if (a.a() != null) {
            n();
            bitmap = this.j;
            this.j = a;
            obj4--;
            while (obj4 >= 0) {
                (g.b)this.c.get(obj4).a();
                obj4--;
            }
            if (bitmap != null) {
                this.b.obtainMessage(i2, bitmap).sendToTarget();
            }
        }
        l();
    }

    void o(l<Bitmap> l, Bitmap bitmap2) {
        k.d(l);
        this.n = (l)l;
        k.d(bitmap2);
        this.m = (Bitmap)bitmap2;
        g gVar = new g();
        this.i = this.i.r0(gVar.k0(l));
        this.q = l.g(bitmap2);
        this.r = bitmap2.getWidth();
        this.s = bitmap2.getHeight();
    }

    void r(com.bumptech.glide.load.n.g.g.b g$b) {
        if (this.k) {
        } else {
            if (this.c.contains(b)) {
            } else {
                this.c.add(b);
                if (this.c.isEmpty()) {
                    p();
                }
            }
            IllegalStateException obj3 = new IllegalStateException("Cannot subscribe twice in a row");
            throw obj3;
        }
        obj3 = new IllegalStateException("Cannot subscribe to a cleared frame loader");
        throw obj3;
    }

    void s(com.bumptech.glide.load.n.g.g.b g$b) {
        this.c.remove(b);
        if (this.c.isEmpty()) {
            q();
        }
    }
}
