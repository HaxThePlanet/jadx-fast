package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.f;
import com.bumptech.glide.t.k;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: ActiveResources.java */
/* loaded from: classes.dex */
final class a {

    private final boolean a;
    final Map<f, a.d> b;
    private final ReferenceQueue<p<?>> c;
    private p.a d;
    private volatile boolean e;
    private volatile a.c f;

    class a implements ThreadFactory {
        a() {
            super();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(new a.a.a(this, runnable), "glide-active-resources");
        }
    }

    class b implements Runnable {

        final /* synthetic */ a a;
        b() {
            this.a = aVar;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.b();
        }
    }

    interface c {
        void a();
    }

    static final class d extends WeakReference<p<?>> {

        final f a;
        final boolean b;
        u<?> c = null;
        d(f fVar, p<?> pVar, ReferenceQueue<? super p<?>> referenceQueue, boolean z) {
            super(pVar, referenceQueue);
            k.d(fVar);
            this.a = fVar;
            if (pVar.e() && z) {
                k.d(pVar.d());
            }
            this.b = pVar.e();
        }

        @Override // java.lang.ref.WeakReference
        void a() {
            this.c = null;
            clear();
        }
    }
    a(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new a.a()));
    }

    synchronized void a(f fVar, p<?> pVar) {
        final Object obj = this.b.put(fVar, new a.d(fVar, pVar, this.c, this.a));
        if (obj != null) {
            obj.a();
        }
    }

    void b() {
        while (!this.e) {
            try {
                c((a.d)this.c.remove());
                this.f.a();
            } catch (java.lang.InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    void c(a.d dVar) {
        synchronized (this) {
            try {
                this.b.remove(dVar.a);
            } catch (Throwable unused) {
            }
            try {
                return;
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
        p pVar = new p(uVar, true, false, th.a, this.d);
        this.d.d(th.a, pVar);
    }

    synchronized void d(f fVar) {
        final Object remove = this.b.remove(fVar);
        if (remove != null) {
            remove.a();
        }
    }

    synchronized p<?> e(f fVar) {
        Object value = this.b.get(fVar);
        if (value == null) {
            return null;
        }
        Object obj = value.get();
        if (obj == null) {
            c(value);
        }
        return obj;
    }

    void f(p.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                try {
                    this.d = aVar;
                } catch (Throwable th) {
                }
            }
        }
        try {
        } catch (Throwable th) {
        }
    }

    a(boolean z, Executor executor) {
        super();
        this.b = new HashMap();
        this.c = new ReferenceQueue();
        this.a = z;
        executor.execute(new a.b(this));
    }
}
