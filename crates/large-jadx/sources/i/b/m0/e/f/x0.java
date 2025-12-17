package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.l0.f;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.m0.b.b;
import i.b.p0.a;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class x0<T, U>  extends a0<T> {

    final Callable<U> a;
    final n<? super U, ? extends g0<? extends T>> b;
    final f<? super U> c;
    final boolean v;

    static final class a extends AtomicReference<Object> implements d0<T>, b {

        private static final long serialVersionUID = -5331524057054083935L;
        final f<? super U> disposer;
        final d0<? super T> downstream;
        final boolean eager;
        b upstream;
        a(d0<? super T> d0, U u2, boolean z3, f<? super U> f4) {
            super(u2);
            this.downstream = d0;
            this.eager = z3;
            this.disposer = f4;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        void a() {
            Object andSet;
            f disposer;
            andSet = getAndSet(this);
            if (andSet != this) {
                this.disposer.accept(andSet);
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
        public void onError(Throwable throwable) {
            boolean andSet;
            Object compositeException;
            int arr;
            int i;
            Object obj5;
            this.upstream = c.DISPOSED;
            andSet = getAndSet(this);
            if (this.eager && andSet != this) {
                andSet = getAndSet(this);
                if (andSet != this) {
                    this.disposer.accept(andSet);
                }
            }
            this.downstream.onError(obj5);
            if (!this.eager) {
                a();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.upstream, b)) {
                this.upstream = b;
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            boolean andSet;
            f disposer;
            Throwable obj3;
            this.upstream = c.DISPOSED;
            andSet = getAndSet(this);
            if (this.eager && andSet != this) {
                andSet = getAndSet(this);
                if (andSet != this) {
                    this.disposer.accept(andSet);
                }
            }
            this.downstream.onSuccess(t);
            if (!this.eager) {
                a();
            }
        }
    }
    public x0(Callable<U> callable, n<? super U, ? extends g0<? extends T>> n2, f<? super U> f3, boolean z4) {
        super();
        this.a = callable;
        this.b = n2;
        this.c = f3;
        this.v = z4;
    }

    protected void subscribeActual(d0<? super T> d0) {
        Throwable th;
        boolean z;
        CompositeException compositeException;
        int arr;
        int i;
        try {
            Object call = this.a.call();
            Object apply = this.b.apply(call);
            b.e(apply, "The singleFunction returned a null SingleSource");
            x0.a aVar = new x0.a(d0, call, this.v, this.c);
            (g0)apply.subscribe(aVar);
            a.b(th);
            z = this.v;
            if (z) {
            }
            z = this.c;
            z.accept(obj);
            a.b(z);
            arr = 2;
            arr = new Throwable[arr];
            arr[0] = th;
            th = 1;
            arr[th] = z;
            compositeException = new CompositeException(arr);
            th = compositeException;
            d.error(th, d0);
            d0 = this.v;
            if (d0 == null) {
            }
            d0 = this.c;
            d0.accept(obj);
        } catch (Throwable th) {
        }
    }
}
