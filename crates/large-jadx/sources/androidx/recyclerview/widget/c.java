package androidx.recyclerview.widget;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class c<T>  {

    private final Executor a;
    private final Executor b;
    private final androidx.recyclerview.widget.h.f<T> c;

    public static final class a {

        private static final Object d;
        private static Executor e;
        private Executor a;
        private Executor b;
        private final androidx.recyclerview.widget.h.f<T> c;
        static {
            Object object = new Object();
            c.a.d = object;
        }

        public a(androidx.recyclerview.widget.h.f<T> h$f) {
            super();
            this.c = f;
        }

        public androidx.recyclerview.widget.c<T> a() {
            Executor executor;
            Object fixedThreadPool;
            Object obj = c.a.d;
            if (this.b == null && c.a.e == null) {
                obj = c.a.d;
                synchronized (obj) {
                    c.a.e = Executors.newFixedThreadPool(2);
                    this.b = c.a.e;
                }
            }
            c cVar = new c(this.a, this.b, this.c);
            return cVar;
        }
    }
    c(Executor executor, Executor executor2, androidx.recyclerview.widget.h.f<T> h$f3) {
        super();
        this.a = executor;
        this.b = executor2;
        this.c = f3;
    }

    public Executor a() {
        return this.b;
    }

    public androidx.recyclerview.widget.h.f<T> b() {
        return this.c;
    }

    public Executor c() {
        return this.a;
    }
}
