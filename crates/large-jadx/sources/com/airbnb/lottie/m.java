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
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* compiled from: LottieTask.java */
/* loaded from: classes.dex */
public class m<T> {

    public static Executor e;
    private final Set<h<T>> a;
    private final Set<h<Throwable>> b;
    private final Handler c;
    private volatile l<T> d;

    class a implements Runnable {

        final /* synthetic */ m a;
        a() {
            this.a = mVar;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.d == null) {
                return;
            }
            com.airbnb.lottie.l lVar2 = this.a.d;
            if (lVar2.b() != null) {
                this.a.i(lVar2.b());
            } else {
                this.a.g(lVar2.a());
            }
        }
    }

    private class b extends FutureTask<l<T>> {

        final /* synthetic */ m a;
        b(Callable callable) {
            this.a = mVar;
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (isCancelled()) {
                return;
            }
            try {
                this.a.l((l)get());
            } catch (java.util.concurrent.ExecutionException execution) {
            } catch (java.lang.InterruptedException interrupted1) {
            }
        }
    }
    static {
        m.e = Executors.newCachedThreadPool();
    }

    public m(Callable<l<T>> callable) {
        this(callable, false);
    }

    static /* synthetic */ l a(m mVar) {
        return mVar.d;
    }

    static /* synthetic */ void b(m mVar, Object object) {
        mVar.i(object);
    }

    static /* synthetic */ void c(m mVar, Throwable th) {
        mVar.g(th);
    }

    static /* synthetic */ void d(m mVar, l lVar) {
        mVar.l(lVar);
    }

    private synchronized void g(Throwable th) {
        ArrayList arrayList = new ArrayList(this.b);
        d.d("Lottie encountered an error but no failure listener was added:", th);
        Iterator it = arrayList.iterator();
        (h)it.next().a(th);
    }

    private void h() {
        this.c.post(new m.a(this));
    }

    private synchronized void i(T t) {
        Iterator it = new ArrayList(this.a).iterator();
        (h)it.next().a(t);
    }

    private void l(l<T> lVar) {
        if (this.d != null) {
            throw new IllegalStateException("A task may only be set once.");
        } else {
            this.d = lVar;
            h();
            return;
        }
    }

    public synchronized m<T> e(h<Throwable> hVar) {
        if (this.d != null && this.d.a() != null) {
            hVar.a(this.d.a());
        }
        this.b.add(hVar);
        return this;
    }

    public synchronized m<T> f(h<T> hVar) {
        if (this.d != null && this.d.b() != null) {
            hVar.a(this.d.b());
        }
        this.a.add(hVar);
        return this;
    }

    public synchronized m<T> j(h<Throwable> hVar) {
        this.b.remove(hVar);
        return this;
    }

    public synchronized m<T> k(h<T> hVar) {
        this.a.remove(hVar);
        return this;
    }

    m(Callable<l<T>> callable, boolean z) {
        super();
        int i = 1;
        this.a = new LinkedHashSet(i);
        this.b = new LinkedHashSet(i);
        this.c = new Handler(Looper.getMainLooper());
        com.airbnb.lottie.l lVar = null;
        this.d = lVar;
        if (z != null) {
            try {
                l((l)callable.call());
            } catch (Throwable th) {
                z = new l(th);
                l(z);
            }
        } else {
            m.e.execute(new m.b(this, th));
        }
    }
}
