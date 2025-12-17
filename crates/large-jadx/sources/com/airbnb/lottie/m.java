package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import com.airbnb.lottie.y.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* loaded from: classes.dex */
public class m<T>  {

    public static Executor e;
    private final Set<com.airbnb.lottie.h<T>> a;
    private final Set<com.airbnb.lottie.h<Throwable>> b;
    private final Handler c;
    private volatile com.airbnb.lottie.l<T> d;

    class a implements Runnable {

        final com.airbnb.lottie.m a;
        a(com.airbnb.lottie.m m) {
            this.a = m;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            com.airbnb.lottie.m mVar;
            if (m.a(this.a) == null) {
            }
            com.airbnb.lottie.l lVar2 = m.a(this.a);
            if (lVar2.b() != null) {
                m.b(this.a, lVar2.b());
            } else {
                m.c(this.a, lVar2.a());
            }
        }
    }

    private class b extends FutureTask<com.airbnb.lottie.l<T>> {

        final com.airbnb.lottie.m a;
        b(com.airbnb.lottie.m m, Callable callable2) {
            this.a = m;
            super(callable2);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            com.airbnb.lottie.m mVar;
            Object obj;
            com.airbnb.lottie.l lVar;
            if (isCancelled()) {
            }
            m.d(this.a, (l)get());
        }
    }
    static {
        m.e = Executors.newCachedThreadPool();
    }

    public m(Callable<com.airbnb.lottie.l<T>> callable) {
        super(callable, 0);
    }

    m(Callable<com.airbnb.lottie.l<T>> callable, boolean z2) {
        com.airbnb.lottie.m.b bVar;
        Object obj3;
        Object obj4;
        super();
        int i = 1;
        LinkedHashSet linkedHashSet = new LinkedHashSet(i);
        this.a = linkedHashSet;
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(i);
        this.b = linkedHashSet2;
        Handler handler = new Handler(Looper.getMainLooper());
        this.c = handler;
        this.d = 0;
        if (z2 != null) {
            l((l)callable.call());
        } else {
            bVar = new m.b(this, callable);
            m.e.execute(bVar);
        }
    }

    static com.airbnb.lottie.l a(com.airbnb.lottie.m m) {
        return m.d;
    }

    static void b(com.airbnb.lottie.m m, Object object2) {
        m.i(object2);
    }

    static void c(com.airbnb.lottie.m m, Throwable throwable2) {
        m.g(throwable2);
    }

    static void d(com.airbnb.lottie.m m, com.airbnb.lottie.l l2) {
        m.l(l2);
    }

    private void g(Throwable throwable) {
        boolean empty;
        ArrayList arrayList = new ArrayList(this.b);
        synchronized (this) {
            try {
                d.d("Lottie encountered an error but no failure listener was added:", throwable);
                Iterator iterator = arrayList.iterator();
                for (h empty : iterator) {
                    empty.a(throwable);
                }
                (h)iterator.next().a(throwable);
                throw throwable;
            }
        }
    }

    private void h() {
        m.a aVar = new m.a(this);
        this.c.post(aVar);
    }

    private void i(T t) {
        Set next;
        ArrayList arrayList = new ArrayList(this.a);
        Iterator iterator = arrayList.iterator();
        synchronized (this) {
            try {
                for (h next : iterator) {
                    next.a(t);
                }
                (h)iterator.next().a(t);
                throw t;
            }
        }
    }

    private void l(com.airbnb.lottie.l<T> l) {
        if (this.d != null) {
        } else {
            this.d = l;
            h();
        }
        IllegalStateException obj2 = new IllegalStateException("A task may only be set once.");
        throw obj2;
    }

    public com.airbnb.lottie.m<T> e(com.airbnb.lottie.h<Throwable> h) {
        Object lVar;
        synchronized (this) {
            try {
                if (this.d.a() != null) {
                }
                h.a(this.d.a());
                this.b.add(h);
                return this;
                throw h;
            }
        }
    }

    public com.airbnb.lottie.m<T> f(com.airbnb.lottie.h<T> h) {
        Object lVar;
        synchronized (this) {
            try {
                if (this.d.b() != null) {
                }
                h.a(this.d.b());
                this.a.add(h);
                return this;
                throw h;
            }
        }
    }

    public com.airbnb.lottie.m<T> j(com.airbnb.lottie.h<Throwable> h) {
        this.b.remove(h);
        return this;
        synchronized (this) {
            this.b.remove(h);
            return this;
        }
    }

    public com.airbnb.lottie.m<T> k(com.airbnb.lottie.h<T> h) {
        this.a.remove(h);
        return this;
        synchronized (this) {
            this.a.remove(h);
            return this;
        }
    }
}
