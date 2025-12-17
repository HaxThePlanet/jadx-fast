package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.m0.d.y;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class p0<T>  extends a0<T> {

    final g0<? extends T> a;
    final n<? super Throwable, ? extends g0<? extends T>> b;

    static final class a extends AtomicReference<b> implements d0<T>, b {

        private static final long serialVersionUID = -5314538511045349925L;
        final d0<? super T> downstream;
        final n<? super Throwable, ? extends g0<? extends T>> nextFunction;
        a(d0<? super T> d0, n<? super Throwable, ? extends g0<? extends T>> n2) {
            super();
            this.downstream = d0;
            this.nextFunction = n2;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            return c.isDisposed((b)get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            try {
                Object apply = this.nextFunction.apply(throwable);
                b.e(apply, "The nextFunction returned a null SingleSource.");
                y obj6 = new y(this, this.downstream);
                (g0)apply.subscribe(obj6);
                a.b(th);
                int arr = 2;
                arr = new Throwable[arr];
                arr[0] = throwable;
                throwable = 1;
                arr[throwable] = th;
                CompositeException compositeException = new CompositeException(arr);
                this.downstream.onError(compositeException);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            boolean obj1;
            if (c.setOnce(this, b)) {
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }
    }
    public p0(g0<? extends T> g0, n<? super Throwable, ? extends g0<? extends T>> n2) {
        super();
        this.a = g0;
        this.b = n2;
    }

    protected void subscribeActual(d0<? super T> d0) {
        p0.a aVar = new p0.a(d0, this.b);
        this.a.subscribe(aVar);
    }
}
