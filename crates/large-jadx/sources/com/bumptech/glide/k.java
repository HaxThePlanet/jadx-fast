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
import com.bumptech.glide.o.m;
import com.bumptech.glide.o.q;
import com.bumptech.glide.o.r;
import com.bumptech.glide.o.u;
import com.bumptech.glide.r.a;
import com.bumptech.glide.r.f;
import com.bumptech.glide.r.g;
import com.bumptech.glide.r.k.h;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: RequestManager.java */
/* loaded from: classes.dex */
public class k implements ComponentCallbacks2, m {

    private static final g D;
    private final CopyOnWriteArrayList<f<Object>> A;
    private g B;
    private boolean C;
    protected final c a;
    protected final Context b;
    final com.bumptech.glide.o.l c;
    private final r v;
    private final q w;
    private final u x;
    private final Runnable y;
    private final c z;

    class a implements Runnable {

        final /* synthetic */ k a;
        a() {
            this.a = kVar;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            kVar.c.a(this.a);
        }
    }

    private class b implements c.a {

        private final r a;
        final /* synthetic */ k b;
        b(r rVar) {
            this.b = kVar;
            super();
            this.a = rVar;
        }

        public void a(boolean z) {
            if (z) {
                synchronized (kVar) {
                    try {
                        this.a.e();
                    } catch (Throwable th) {
                    }
                }
            }
        }
    }
    static {
        k.D = (g)g.r0(Bitmap.class).S();
    }

    public k(c cVar, com.bumptech.glide.o.l lVar, q qVar, Context context) {
        this(cVar, lVar, qVar, new r(), cVar.g(), context);
    }

    private void u(h<?> hVar) {
        final com.bumptech.glide.r.d request = hVar.getRequest();
        if (!t(hVar)) {
            if (!this.a.p(hVar) && request != null) {
                hVar.setRequest(null);
                request.clear();
            }
        }
    }

    public k a(f<Object> fVar) {
        this.A.add(fVar);
        return this;
    }

    public <ResourceType> j<ResourceType> b(Class<ResourceType> cls) {
        return new j(this.a, this, cls, this.b);
    }

    public j<Bitmap> c() {
        return b(Bitmap.class).r0(k.D);
    }

    public j<Drawable> d() {
        return b(Drawable.class);
    }

    public void e(h<?> hVar) {
        if (hVar == null) {
            return;
        }
        u(hVar);
    }

    List<f<Object>> f() {
        return this.A;
    }

    synchronized g g() {
        return this.B;
    }

    <T> l<?, T> h(Class<T> cls) {
        return this.a.i().e(cls);
    }

    public j<Drawable> i(Drawable drawable) {
        return d().F0(drawable);
    }

    public j<Drawable> j(Uri uri) {
        return d().G0(uri);
    }

    public j<Drawable> k(Integer integer) {
        return d().H0(integer);
    }

    public j<Drawable> l(Object object) {
        return d().I0(object);
    }

    public j<Drawable> m(String str) {
        return d().K0(str);
    }

    public synchronized void n() {
        this.v.c();
    }

    public synchronized void o() {
        n();
        Iterator it = this.w.a().iterator();
        (k)it.next().n();
    }

    public synchronized void onDestroy() {
        this.x.onDestroy();
        Iterator it = this.x.b().iterator();
        while (it.hasNext()) {
            e((h)it.next());
        }
        this.x.a();
        this.v.b();
        this.c.b(this);
        this.c.b(this.z);
        l.v(this.y);
        this.a.s(this);
    }

    public synchronized void onStart() {
        q();
        this.x.onStart();
    }

    public synchronized void onStop() {
        p();
        this.x.onStop();
    }

    public void onTrimMemory(int i) {
        if (this.C == 60 && this.C) {
            o();
        }
    }

    public synchronized void p() {
        this.v.d();
    }

    public synchronized void q() {
        this.v.f();
    }

    protected synchronized void r(g gVar) {
        this.B = (g)(g)gVar.d().b();
    }

    synchronized void s(h<?> hVar, com.bumptech.glide.r.d dVar) {
        this.x.c(hVar);
        this.v.g(dVar);
    }

    synchronized boolean t(h<?> hVar) {
        com.bumptech.glide.r.d request = hVar.getRequest();
        final boolean z2 = true;
        if (request == null) {
            return true;
        }
        this.x.d(hVar);
        hVar.setRequest(null);
        return false;
    }

    @Override // java.lang.Object
    public synchronized String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String object = super.toString();
        String str2 = "{tracker=";
        String str3 = ", treeNode=";
        String str4 = "}";
        str = object + str2 + this.v + str3 + this.w + str4;
        return str;
    }

    k(c cVar, com.bumptech.glide.o.l lVar, q qVar, r rVar, com.bumptech.glide.o.d dVar, Context context) {
        super();
        this.x = new u();
        com.bumptech.glide.k.a aVar = new k.a(this);
        this.y = aVar;
        this.a = cVar;
        this.c = lVar;
        this.w = qVar;
        this.v = rVar;
        this.b = context;
        c cVar2 = dVar.a(context.getApplicationContext(), new k.b(this, rVar));
        this.z = cVar2;
        if (l.q()) {
            l.u(aVar);
        } else {
            lVar.a(this);
        }
        lVar.a(cVar2);
        this.A = new CopyOnWriteArrayList(cVar.i().c());
        r(cVar.i().d());
        cVar.o(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }
}
