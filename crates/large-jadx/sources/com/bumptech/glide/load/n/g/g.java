package com.bumptech.glide.load.n.g;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.f;
import com.bumptech.glide.r.g;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GifFrameLoader.java */
/* loaded from: classes.dex */
class g {

    private final com.bumptech.glide.n.a a;
    private final Handler b;
    private final List<g.b> c;
    final com.bumptech.glide.k d;
    private final e e;
    private boolean f;
    private boolean g;
    private boolean h;
    private com.bumptech.glide.j<Bitmap> i;
    private g.a j;
    private boolean k;
    private g.a l;
    private Bitmap m;
    private com.bumptech.glide.load.l<Bitmap> n;
    private g.a o;
    private g.d p;
    private int q;
    private int r;
    private int s;

    public interface b {
        void a();
    }

    private class c implements Handler.Callback {

        final /* synthetic */ g a;
        c() {
            this.a = gVar;
            super();
        }

        @Override // android.os.Handler$Callback
        public boolean handleMessage(Message message) {
            int i = 1;
            if (message.what == i) {
                this.a.m((g.a)message.obj);
                return true;
            }
            if (message.what == 2) {
                this.a.d.e((g.a)message.obj);
            }
            return false;
        }
    }

    interface d {
        void a();
    }

    static class a extends com.bumptech.glide.r.k.c<Bitmap> {

        private final Handler a;
        final int b;
        private final long c;
        private Bitmap v;
        a(Handler handler, int i, long j) {
            super();
            this.a = handler;
            this.b = i;
            this.c = j;
        }

        @Override // com.bumptech.glide.r.k.c
        Bitmap a() {
            return this.v;
        }

        @Override // com.bumptech.glide.r.k.c
        public void b(Bitmap bitmap, com.bumptech.glide.r.l.d<? super Bitmap> dVar) {
            this.v = bitmap;
            this.a.sendMessageAtTime(this.a.obtainMessage(1, this), this.c);
        }

        @Override // com.bumptech.glide.r.k.c
        public void onLoadCleared(Drawable drawable) {
            this.v = null;
        }
    }
    g(com.bumptech.glide.c cVar, com.bumptech.glide.n.a aVar, int i, int i2, com.bumptech.glide.load.l<Bitmap> lVar, Bitmap bitmap) {
        this(cVar.f(), c.t(cVar.h()), aVar, null, g.i(c.t(cVar.h()), i, i2), lVar, bitmap);
    }

    private static f g() {
        return new d(Double.valueOf(Math.random()));
    }

    private static com.bumptech.glide.j<Bitmap> i(com.bumptech.glide.k kVar, int i, int i2) {
        final boolean z = true;
        return kVar.c().r0((g)(g)g.s0(j.a).p0(z).i0(z).Y(i, i2));
    }

    private void l() {
        boolean z4;
        boolean z3 = false;
    }

    private void n() {
        if (this.m != null) {
            this.e.c(this.m);
            Bitmap bitmap = null;
            this.m = bitmap;
        }
    }

    private void p() {
        if (this.f) {
            return;
        }
        this.f = true;
        this.k = false;
        l();
    }

    private void q() {
        this.f = false;
    }

    void a() {
        com.bumptech.glide.k kVar;
        this.c.clear();
        n();
        q();
        final com.bumptech.glide.load.n.g.g.a aVar5 = null;
        if (this.j != null) {
            this.d.e(this.j);
            this.j = aVar5;
        }
        if (this.l != null) {
            this.d.e(this.l);
            this.l = aVar5;
        }
        if (this.o != null) {
            this.d.e(this.o);
            this.o = aVar5;
        }
        this.a.clear();
        this.k = true;
    }

    ByteBuffer b() {
        return this.a.getData().asReadOnlyBuffer();
    }

    Bitmap c() {
        Bitmap bitmap;
        if (this.j != null) {
            bitmap = this.j.a();
        } else {
        }
        return bitmap;
    }

    int d() {
        int i = -1;
        int r0 = this.j != null ? aVar.b : -1;
        return (this.j != null ? aVar.b : -1);
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
        return this.a.getByteSize() + this.q;
    }

    int k() {
        return this.r;
    }

    void m(g.a aVar) {
        Object item;
        int i;
        if (this.p != null) {
            this.p.a();
        }
        this.g = false;
        final int i3 = 2;
        if (this.k) {
            this.b.obtainMessage(i3, aVar).sendToTarget();
            return;
        }
        if (!this.f) {
            if (this.h) {
                this.b.obtainMessage(i3, aVar).sendToTarget();
            } else {
                this.o = aVar;
            }
            return;
        }
        if (aVar.a() != null) {
            n();
            this.j = aVar;
            i = this.c.size() - 1;
            while (this.c >= 0) {
                (g.b)this.c.get(i).a();
                i = i - 1;
            }
            if (this.j != null) {
                this.b.obtainMessage(i3, this.j).sendToTarget();
            }
        }
        l();
    }

    void o(com.bumptech.glide.load.l<Bitmap> lVar, Bitmap bitmap) {
        k.d(lVar);
        this.n = (l)lVar;
        k.d(bitmap);
        this.m = (Bitmap)bitmap;
        this.i = this.i.r0(new g().k0(lVar));
        this.q = l.g(bitmap);
        this.r = bitmap.getWidth();
        this.s = bitmap.getHeight();
    }

    void r(g.b bVar) {
        if (this.k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        } else {
            if (this.c.contains(bVar)) {
                throw new IllegalStateException("Cannot subscribe twice in a row");
            } else {
                this.c.add(bVar);
                if (this.c.isEmpty()) {
                    p();
                }
                return;
            }
        }
    }

    void s(g.b bVar) {
        this.c.remove(bVar);
        if (this.c.isEmpty()) {
            q();
        }
    }

    g(e eVar, com.bumptech.glide.k kVar, com.bumptech.glide.n.a aVar, Handler handler, com.bumptech.glide.j<Bitmap> jVar, com.bumptech.glide.load.l<Bitmap> lVar, Bitmap bitmap) {
        super();
        this.c = new ArrayList();
        this.d = kVar;
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper(), new g.c(this));
        }
        this.e = eVar;
        this.b = handler;
        this.i = jVar;
        this.a = aVar;
        o(lVar, bitmap);
    }
}
