package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.o.c;
import com.bumptech.glide.o.c.a;
import com.bumptech.glide.o.d;
import com.bumptech.glide.o.l;
import com.bumptech.glide.o.m;
import com.bumptech.glide.o.q;
import com.bumptech.glide.o.r;
import com.bumptech.glide.o.u;
import com.bumptech.glide.r.a;
import com.bumptech.glide.r.d;
import com.bumptech.glide.r.f;
import com.bumptech.glide.r.g;
import com.bumptech.glide.r.k.h;
import com.bumptech.glide.t.l;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class k implements ComponentCallbacks2, m {

    private static final g D;
    private final CopyOnWriteArrayList<f<Object>> A;
    private g B;
    private boolean C;
    protected final com.bumptech.glide.c a;
    protected final Context b;
    final l c;
    private final r v;
    private final q w;
    private final u x;
    private final Runnable y;
    private final c z;

    class a implements Runnable {

        final com.bumptech.glide.k a;
        a(com.bumptech.glide.k k) {
            this.a = k;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            final com.bumptech.glide.k kVar = this.a;
            kVar.c.a(kVar);
        }
    }

    private class b implements c.a {

        private final r a;
        final com.bumptech.glide.k b;
        b(com.bumptech.glide.k k, r r2) {
            this.b = k;
            super();
            this.a = r2;
        }

        @Override // com.bumptech.glide.o.c$a
        public void a(boolean z) {
            Object th;
            com.bumptech.glide.k obj2;
            if (z != null) {
                obj2 = this.b;
                this.a.e();
                synchronized (obj2) {
                    obj2 = this.b;
                    this.a.e();
                }
            }
        }
    }
    static {
        k.D = (g)g.r0(Bitmap.class).S();
        a aVar2 = g.r0(c.class).S();
        a aVar4 = (g)g.s0(j.b).b0(h.LOW).i0(true);
    }

    public k(com.bumptech.glide.c c, l l2, q q3, Context context4) {
        r rVar = new r();
        super(c, l2, q3, rVar, c.g(), context4);
    }

    k(com.bumptech.glide.c c, l l2, q q3, r r4, d d5, Context context6) {
        super();
        u uVar = new u();
        this.x = uVar;
        k.a aVar = new k.a(this);
        this.y = aVar;
        this.a = c;
        this.c = l2;
        this.w = q3;
        this.v = r4;
        this.b = context6;
        k.b obj7 = new k.b(this, r4);
        c obj4 = d5.a(context6.getApplicationContext(), obj7);
        this.z = obj4;
        if (l.q()) {
            l.u(aVar);
        } else {
            l2.a(this);
        }
        l2.a(obj4);
        CopyOnWriteArrayList obj3 = new CopyOnWriteArrayList(c.i().c());
        this.A = obj3;
        r(c.i().d());
        c.o(this);
    }

    private void u(h<?> h) {
        boolean z;
        final d request = h.getRequest();
        if (!t(h) && !this.a.p(h) && request != null) {
            if (!this.a.p(h)) {
                if (request != null) {
                    h.setRequest(0);
                    request.clear();
                }
            }
        }
    }

    public com.bumptech.glide.k a(f<Object> f) {
        this.A.add(f);
        return this;
    }

    public <ResourceType> com.bumptech.glide.j<ResourceType> b(Class<ResourceType> class) {
        j jVar = new j(this.a, this, class, this.b);
        return jVar;
    }

    public com.bumptech.glide.j<Bitmap> c() {
        return b(Bitmap.class).r0(k.D);
    }

    public com.bumptech.glide.j<Drawable> d() {
        return b(Drawable.class);
    }

    public void e(h<?> h) {
        if (h == null) {
        }
        u(h);
    }

    List<f<Object>> f() {
        return this.A;
    }

    @Override // android.content.ComponentCallbacks2
    g g() {
        return this.B;
        synchronized (this) {
            return this.B;
        }
    }

    <T> com.bumptech.glide.l<?, T> h(Class<T> class) {
        return this.a.i().e(class);
    }

    public com.bumptech.glide.j<Drawable> i(Drawable drawable) {
        return d().F0(drawable);
    }

    public com.bumptech.glide.j<Drawable> j(Uri uri) {
        return d().G0(uri);
    }

    public com.bumptech.glide.j<Drawable> k(Integer integer) {
        return d().H0(integer);
    }

    public com.bumptech.glide.j<Drawable> l(Object object) {
        return d().I0(object);
    }

    public com.bumptech.glide.j<Drawable> m(String string) {
        return d().K0(string);
    }

    @Override // android.content.ComponentCallbacks2
    public void n() {
        this.v.c();
        return;
        synchronized (this) {
            this.v.c();
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void o() {
        Object next;
        n();
        Iterator iterator = this.w.a().iterator();
        synchronized (this) {
            try {
                for (k next : iterator) {
                    next.n();
                }
                (k)iterator.next().n();
                throw th;
            }
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks2
    public void onDestroy() {
        Object next;
        this.x.onDestroy();
        Iterator iterator = this.x.b().iterator();
        synchronized (this) {
            try {
                for (h next : iterator) {
                    e(next);
                }
                e((h)iterator.next());
                this.x.a();
                this.v.b();
                this.c.b(this);
                this.c.b(this.z);
                l.v(this.y);
                this.a.s(this);
                throw th;
            }
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public void onStart() {
        q();
        this.x.onStart();
        return;
        synchronized (this) {
            q();
            this.x.onStart();
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void onStop() {
        p();
        this.x.onStop();
        return;
        synchronized (this) {
            p();
            this.x.onStop();
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        int obj2;
        if (i == 60 && this.C) {
            if (this.C) {
                o();
            }
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void p() {
        this.v.d();
        return;
        synchronized (this) {
            this.v.d();
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void q() {
        this.v.f();
        return;
        synchronized (this) {
            this.v.f();
        }
    }

    @Override // android.content.ComponentCallbacks2
    protected void r(g g) {
        this.B = (g)(g)g.d().b();
        return;
        synchronized (this) {
            this.B = (g)(g)g.d().b();
        }
    }

    void s(h<?> h, d d2) {
        this.x.c(h);
        this.v.g(d2);
        return;
        synchronized (this) {
            this.x.c(h);
            this.v.g(d2);
        }
    }

    boolean t(h<?> h) {
        d request = h.getRequest();
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.v.a(request)) {
                }
                this.x.d(h);
                h.setRequest(0);
                return i2;
                return 0;
            }
        }
    }

    @Override // android.content.ComponentCallbacks2
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("{tracker=");
        stringBuilder.append(this.v);
        stringBuilder.append(", treeNode=");
        stringBuilder.append(this.w);
        stringBuilder.append("}");
        return stringBuilder.toString();
        synchronized (this) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(super.toString());
            stringBuilder.append("{tracker=");
            stringBuilder.append(this.v);
            stringBuilder.append(", treeNode=");
            stringBuilder.append(this.w);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }
}
