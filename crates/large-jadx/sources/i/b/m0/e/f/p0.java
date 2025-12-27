package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.d.y;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleResumeNext.java */
/* loaded from: classes3.dex */
public final class p0<T> extends a0<T> {

    final g0<? extends T> a;
    final n<? super Throwable, ? extends g0<? extends T>> b;

    static final class a<T> extends AtomicReference<i.b.j0.b> implements d0<T>, i.b.j0.b {

        private static final long serialVersionUID = -5314538511045349925L;
        final d0<? super T> downstream;
        final n<? super Throwable, ? extends g0<? extends T>> nextFunction;
        a(d0<? super T> d0Var, n<? super Throwable, ? extends g0<? extends T>> nVar) {
            super();
            this.downstream = d0Var;
            this.nextFunction = nVar;
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
        public void onError(Throwable th) {
            try {
                Object apply = this.nextFunction.apply(th);
                b.e(apply, "The nextFunction returned a null SingleSource.");
            } catch (Throwable th) {
                a.b(th);
                int arr = 2;
                arr = new Throwable[arr];
                arr[0] = th;
                th = 1;
                arr[th] = th;
                this.downstream.onError(new CompositeException(arr));
                return;
            }
            apply.subscribe(new y(this, this.downstream));
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(i.b.j0.b bVar) {
            if (c.setOnce(this, bVar)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }
    }
    public p0(g0<? extends T> g0Var, n<? super Throwable, ? extends g0<? extends T>> nVar) {
        super();
        this.a = g0Var;
        this.b = nVar;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super T> d0Var) {
        this.a.subscribe(new p0.a(d0Var, this.b));
    }
}
