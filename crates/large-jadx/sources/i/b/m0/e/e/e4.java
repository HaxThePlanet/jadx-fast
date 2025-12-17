package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.f;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.m0.b.b;
import i.b.p0.a;
import i.b.r;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class e4<T, D>  extends r<T> {

    final Callable<? extends D> a;
    final n<? super D, ? extends w<? extends T>> b;
    final f<? super D> c;
    final boolean v;

    static final class a extends AtomicBoolean implements y<T>, b {

        private static final long serialVersionUID = 5904473792286235046L;
        final f<? super D> disposer;
        final y<? super T> downstream;
        final boolean eager;
        final D resource;
        b upstream;
        a(y<? super T> y, D d2, f<? super D> f3, boolean z4) {
            super();
            this.downstream = y;
            this.resource = d2;
            this.disposer = f3;
            this.eager = z4;
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        void a() {
            boolean compareAndSet;
            int resource;
            if (compareAndSet(false, true)) {
                this.disposer.accept(this.resource);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void dispose() {
            a();
            this.upstream.dispose();
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public boolean isDisposed() {
            return get();
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onComplete() {
            boolean compareAndSet;
            Object downstream;
            int downstream2;
            if (this.eager) {
                if (compareAndSet(false, true)) {
                    this.disposer.accept(this.resource);
                }
                this.upstream.dispose();
                this.downstream.onComplete();
            } else {
                this.downstream.onComplete();
                this.upstream.dispose();
                a();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onError(Throwable throwable) {
            y downstream;
            int i;
            boolean compareAndSet;
            Object compositeException;
            int arr;
            Object obj6;
            if (this.eager) {
                if (compareAndSet(false, true)) {
                    this.disposer.accept(this.resource);
                }
                this.upstream.dispose();
                this.downstream.onError(obj6);
            } else {
                this.downstream.onError(throwable);
                this.upstream.dispose();
                a();
            }
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.upstream, b)) {
                this.upstream = b;
                this.downstream.onSubscribe(this);
            }
        }
    }
    public e4(Callable<? extends D> callable, n<? super D, ? extends w<? extends T>> n2, f<? super D> f3, boolean z4) {
        super();
        this.a = callable;
        this.b = n2;
        this.c = f3;
        this.v = z4;
    }

    public void subscribeActual(y<? super T> y) {
        try {
            Object call = this.a.call();
            Object apply = this.b.apply(call);
            b.e(apply, "The sourceSupplier returned a null ObservableSource");
            e4.a aVar = new e4.a(y, call, this.c, this.v);
            (w)apply.subscribe(aVar);
            a.b(th);
            f compositeException = this.c;
            compositeException.accept(obj);
            d.error(th, y);
            a.b(obj);
            int arr = 2;
            arr = new Throwable[arr];
            arr[0] = th;
            Throwable th = 1;
            arr[th] = obj;
            compositeException = new CompositeException(arr);
            d.error(compositeException, y);
            a.b(obj);
            d.error(obj, y);
        } catch (Throwable th) {
        }
    }
}
