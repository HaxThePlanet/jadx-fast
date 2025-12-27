package com.iterable.iterableapi.k1;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: Future.java */
/* loaded from: classes2.dex */
public class a<T> {

    private static final ExecutorService d;
    private Handler a = new Handler();
    private final List<a.e<T>> b = new ArrayList<>();
    private final List<a.d> c = new ArrayList<>();

    class a implements Runnable {

        final /* synthetic */ Callable a;
        final /* synthetic */ a b;
        a(Callable callable) {
            this.b = aVar;
            this.a = callable;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.b.f(this.a.call());
            } catch (Exception e) {
                this.b.e(e);
            }
        }
    }

    class b implements Runnable {

        final /* synthetic */ Object a;
        final /* synthetic */ a b;
        b(Object object) {
            this.b = aVar;
            this.a = object;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            List list;
            List list2 = this.b.b;
            synchronized (list2) {
                try {
                } catch (Throwable th) {
                }
            }
            Iterator it = new ArrayList(this.b.b).iterator();
            while (it.hasNext()) {
                ArrayList arrayList = it.next();
            }
        }
    }

    class c implements Runnable {

        final /* synthetic */ Throwable a;
        final /* synthetic */ a b;
        c(Throwable th) {
            this.b = aVar;
            this.a = th;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            List list;
            List list2 = this.b.c;
            synchronized (list2) {
                try {
                } catch (Throwable th) {
                }
            }
            Iterator it = new ArrayList(this.b.c).iterator();
            while (it.hasNext()) {
                ArrayList arrayList = it.next();
            }
        }
    }

    public interface d {
        void a(Throwable th);
    }

    public interface e<T> {
        void onSuccess(T t);
    }
    static {
        a.d = Executors.newCachedThreadPool();
    }

    private a(Callable<T> callable) {
        Looper mainLooper;
        super();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Looper.myLooper() == null) {
            mainLooper = Looper.getMainLooper();
        }
        Handler handler = new Handler(mainLooper);
        a.d.submit(new a.a(this, callable));
    }

    static /* synthetic */ void a(a aVar, Object object) {
        aVar.f(object);
    }

    static /* synthetic */ void b(a aVar, Throwable th) {
        aVar.e(th);
    }

    static /* synthetic */ List c(a aVar) {
        return aVar.b;
    }

    static /* synthetic */ List d(a aVar) {
        return aVar.c;
    }

    private void e(Throwable th) {
        this.a.post(new a.c(this, th));
    }

    private void f(T t) {
        this.a.post(new a.b(this, t));
    }

    public static <T> a<T> i(Callable<T> callable) {
        return new a(callable);
    }

    public a<T> g(a.d dVar) {
        synchronized (list) {
            try {
                this.c.add(dVar);
                return this;
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }

    public a<T> h(a.e<T> eVar) {
        synchronized (list) {
            try {
                this.b.add(eVar);
                return this;
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }
}
