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

/* loaded from: classes.dex */
final class a {

    private final boolean a;
    final Map<f, com.bumptech.glide.load.engine.a.d> b;
    private final ReferenceQueue<com.bumptech.glide.load.engine.p<?>> c;
    private com.bumptech.glide.load.engine.p.a d;
    private volatile boolean e;
    private volatile com.bumptech.glide.load.engine.a.c f;

    class a implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            a.a.a aVar = new a.a.a(this, runnable);
            Thread thread = new Thread(aVar, "glide-active-resources");
            return thread;
        }
    }

    class b implements Runnable {

        final com.bumptech.glide.load.engine.a a;
        b(com.bumptech.glide.load.engine.a a) {
            this.a = a;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.b();
        }
    }

    interface c {
        public abstract void a();
    }

    static final class d extends WeakReference<com.bumptech.glide.load.engine.p<?>> {

        final f a;
        final boolean b;
        com.bumptech.glide.load.engine.u<?> c = null;
        d(f f, com.bumptech.glide.load.engine.p<?> p2, ReferenceQueue<? super com.bumptech.glide.load.engine.p<?>> referenceQueue3, boolean z4) {
            super(p2, referenceQueue3);
            k.d(f);
            this.a = (f)f;
            if (p2.e() && z4) {
                if (z4) {
                    k.d(p2.d());
                }
            }
            int obj1 = 0;
            this.b = p2.e();
        }

        @Override // java.lang.ref.WeakReference
        void a() {
            this.c = 0;
            clear();
        }
    }
    a(boolean z) {
        a.a aVar = new a.a();
        super(z, Executors.newSingleThreadExecutor(aVar));
    }

    a(boolean z, Executor executor2) {
        super();
        HashMap hashMap = new HashMap();
        this.b = hashMap;
        ReferenceQueue referenceQueue = new ReferenceQueue();
        this.c = referenceQueue;
        this.a = z;
        a.b obj2 = new a.b(this);
        executor2.execute(obj2);
    }

    void a(f f, com.bumptech.glide.load.engine.p<?> p2) {
        a.d dVar = new a.d(f, p2, this.c, this.a);
        final Object obj4 = this.b.put(f, dVar);
        synchronized (this) {
            try {
                (a.d)obj4.a();
                throw f;
            }
        }
    }

    void b() {
        com.bumptech.glide.load.engine.a.c cVar;
        while (!this.e) {
            c((a.d)this.c.remove());
            cVar = this.f;
            if (cVar != null) {
            }
            cVar.a();
        }
        try {
        }
    }

    void c(com.bumptech.glide.load.engine.a.d a$d) {
        com.bumptech.glide.load.engine.u uVar;
        this.b.remove(d.a);
        synchronized (this) {
            try {
                uVar = d.c;
                if (uVar == null) {
                }
                super(uVar, 1, 0, d.a, this.d);
                this.d.d(d.a, pVar);
                throw d;
            }
        }
    }

    void d(f f) {
        final Object obj2 = this.b.remove(f);
        synchronized (this) {
            try {
                (a.d)obj2.a();
                throw f;
            }
        }
    }

    com.bumptech.glide.load.engine.p<?> e(f f) {
        Object obj2 = this.b.get(f);
        synchronized (this) {
            try {
                return 0;
                Object obj = (a.d)obj2.get();
                if ((p)obj == null) {
                }
                c(obj2);
                return (p)obj;
                throw f;
            }
        }
    }

    void f(com.bumptech.glide.load.engine.p.a p$a) {
        this.d = a;
        return;
        synchronized (a) {
            this.d = a;
        }
    }
}
