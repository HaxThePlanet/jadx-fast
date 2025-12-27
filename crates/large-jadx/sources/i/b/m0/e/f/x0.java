package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.l0.f;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.a.d;
import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleUsing.java */
/* loaded from: classes3.dex */
public final class x0<T, U> extends a0<T> {

    final Callable<U> a;
    final n<? super U, ? extends g0<? extends T>> b;
    final f<? super U> c;
    final boolean v;

    static final class a<T, U> extends AtomicReference<Object> implements d0<T>, i.b.j0.b {

        private static final long serialVersionUID = -5331524057054083935L;
        final f<? super U> disposer;
        final d0<? super T> downstream;
        final boolean eager;
        i.b.j0.b upstream;
        a(d0<? super T> d0Var, U u, boolean z, f<? super U> fVar) {
            super(u);
            this.downstream = d0Var;
            this.eager = z;
            this.disposer = fVar;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        void a() {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.disposer.accept(andSet);
                } catch (Throwable th) {
                    a.b(th);
                    a.t(th);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            this.upstream.dispose();
            this.upstream = c.DISPOSED;
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            Throwable th3;
            this.upstream = c.DISPOSED;
            if (this.eager && andSet != this) {
                try {
                    this.disposer.accept(andSet);
                } catch (Throwable th) {
                    a.b(th);
                    int arr = 2;
                    arr = new Throwable[arr];
                    arr[0] = th;
                    th = 1;
                    arr[th] = th;
                    th = new CompositeException(arr);
                }
            }
            this.downstream.onError(th3);
            if (!this.eager) {
                a();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSuccess(T t) {
            this.upstream = c.DISPOSED;
            if (this.eager && andSet != this) {
                try {
                    this.disposer.accept(andSet);
                } catch (Throwable th) {
                    a.b(th);
                    this.downstream.onError(th);
                }
            }
            this.downstream.onSuccess(th);
            if (!this.eager) {
                a();
            }
        }
    }
    public x0(Callable<U> callable, n<? super U, ? extends g0<? extends T>> nVar, f<? super U> fVar, boolean z) {
        super();
        this.a = callable;
        this.b = nVar;
        this.c = fVar;
        this.v = z;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super T> d0Var) {
        Throwable th;
        boolean z;
        CompositeException compositeException;
        int arr;
        try {
            Object call = this.a.call();
        } catch (Throwable th) {
            a.b(th);
        }
        try {
            Object apply = this.b.apply(call);
            b.e(apply, "The singleFunction returned a null SingleSource");
        } catch (Throwable th) {
            a.b(th);
            a.t(th);
        }
        apply.subscribe(new x0.a(th, call, this.v, this.c));
    }
}
