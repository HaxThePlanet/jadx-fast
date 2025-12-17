package com.iterable.iterableapi.k1;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public class a<T>  {

    private static final ExecutorService d;
    private Handler a;
    private final List<com.iterable.iterableapi.k1.a.e<T>> b;
    private final List<com.iterable.iterableapi.k1.a.d> c;

    class a implements Runnable {

        final Callable a;
        final com.iterable.iterableapi.k1.a b;
        a(com.iterable.iterableapi.k1.a a, Callable callable2) {
            this.b = a;
            this.a = callable2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Object call;
            com.iterable.iterableapi.k1.a aVar;
            try {
                a.a(this.b, this.a.call());
                a.b(this.b, th);
            }
        }
    }

    class b implements Runnable {

        final Object a;
        final com.iterable.iterableapi.k1.a b;
        b(com.iterable.iterableapi.k1.a a, Object object2) {
            this.b = a;
            this.a = object2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList;
            List list;
            List list2 = a.c(this.b);
            arrayList = new ArrayList(a.c(this.b));
            Iterator iterator = arrayList.iterator();
            synchronized (list2) {
                list2 = a.c(this.b);
                arrayList = new ArrayList(a.c(this.b));
                iterator = arrayList.iterator();
            }
            while (iterator.hasNext()) {
                arrayList = iterator.next();
                if ((a.e)arrayList != null) {
                }
                (a.e)arrayList.onSuccess(this.a);
            }
        }
    }

    class c implements Runnable {

        final Throwable a;
        final com.iterable.iterableapi.k1.a b;
        c(com.iterable.iterableapi.k1.a a, Throwable throwable2) {
            this.b = a;
            this.a = throwable2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList;
            List list;
            List list2 = a.d(this.b);
            arrayList = new ArrayList(a.d(this.b));
            Iterator iterator = arrayList.iterator();
            synchronized (list2) {
                list2 = a.d(this.b);
                arrayList = new ArrayList(a.d(this.b));
                iterator = arrayList.iterator();
            }
            while (iterator.hasNext()) {
                arrayList = iterator.next();
                if ((a.d)arrayList != null) {
                }
                (a.d)arrayList.a(this.a);
            }
        }
    }

    public interface d {
        public abstract void a(Throwable throwable);
    }

    public interface e {
        public abstract void onSuccess(T t);
    }
    static {
        a.d = Executors.newCachedThreadPool();
    }

    private a(Callable<T> callable) {
        Looper mainLooper;
        super();
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.c = arrayList2;
        if (Looper.myLooper() == null) {
            mainLooper = Looper.getMainLooper();
        }
        Handler handler = new Handler(mainLooper);
        this.a = handler;
        a.a aVar = new a.a(this, callable);
        a.d.submit(aVar);
    }

    static void a(com.iterable.iterableapi.k1.a a, Object object2) {
        a.f(object2);
    }

    static void b(com.iterable.iterableapi.k1.a a, Throwable throwable2) {
        a.e(throwable2);
    }

    static List c(com.iterable.iterableapi.k1.a a) {
        return a.b;
    }

    static List d(com.iterable.iterableapi.k1.a a) {
        return a.c;
    }

    private void e(Throwable throwable) {
        a.c cVar = new a.c(this, throwable);
        this.a.post(cVar);
    }

    private void f(T t) {
        a.b bVar = new a.b(this, t);
        this.a.post(bVar);
    }

    public static <T> com.iterable.iterableapi.k1.a<T> i(Callable<T> callable) {
        a aVar = new a(callable);
        return aVar;
    }

    public com.iterable.iterableapi.k1.a<T> g(com.iterable.iterableapi.k1.a.d a$d) {
        final List list = this.c;
        this.c.add(d);
        return this;
        synchronized (list) {
            list = this.c;
            this.c.add(d);
            return this;
        }
    }

    public com.iterable.iterableapi.k1.a<T> h(com.iterable.iterableapi.k1.a.e<T> a$e) {
        final List list = this.b;
        this.b.add(e);
        return this;
        synchronized (list) {
            list = this.b;
            this.b.add(e);
            return this;
        }
    }
}
