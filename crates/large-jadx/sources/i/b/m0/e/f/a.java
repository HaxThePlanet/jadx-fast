package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.m0.a.d;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: SingleAmb.java */
/* loaded from: classes3.dex */
public final class a<T> extends a0<T> {

    private final g0<? extends T>[] a;
    private final Iterable<? extends g0<? extends T>> b;

    static final class a<T> implements d0<T> {

        final i.b.j0.a a;
        final d0<? super T> b;
        final AtomicBoolean c;
        b v;
        a(d0<? super T> d0Var, i.b.j0.a aVar, AtomicBoolean atomicBoolean) {
            super();
            this.b = d0Var;
            this.a = aVar;
            this.c = atomicBoolean;
        }

        public void onError(Throwable th) {
            if (this.c.compareAndSet(false, true)) {
                this.a.c(this.v);
                this.a.dispose();
                this.b.onError(th);
            } else {
                a.t(th);
            }
        }

        public void onSubscribe(b bVar) {
            this.v = bVar;
            this.a.b(bVar);
        }

        public void onSuccess(T t) {
            boolean z = false;
            if (this.c.compareAndSet(z, true)) {
                this.a.c(this.v);
                this.a.dispose();
                this.b.onSuccess(t);
            }
        }
    }
    public a(g0<? extends T>[] g0VarArr, Iterable<? extends g0<? extends T>> iterable) {
        super();
        this.a = g0VarArr;
        this.b = iterable;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super T> d0Var) {
        g0[] arr;
        int length;
        String str = "One of the sources is null";
        length = 0;
        if (this.a == null) {
            arr = new g0[8];
            try {
                Iterator it = this.b.iterator();
                Object item = it.next();
                d.error(new NullPointerException(str), d0Var);
                return;
            } catch (Throwable th) {
                a.b(th);
                d.error(th, d0Var);
                return;
            }
        } else {
            length = arr.length;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        i.b.j0.a aVar2 = new a();
        d0Var.onSubscribe(aVar2);
        for (g0 g0Var : arr) {
            if (g0Var == null) {
                aVar2.dispose();
                java.lang.NullPointerException nullPointerException2 = new NullPointerException(str);
            }
        }
    }
}
