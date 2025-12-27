package i.b.m0.e.e;

import i.b.l0.f;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.r;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ObservableUsing.java */
/* loaded from: classes3.dex */
public final class e4<T, D> extends r<T> {

    final Callable<? extends D> a;
    final n<? super D, ? extends w<? extends T>> b;
    final f<? super D> c;
    final boolean v;

    static final class a<T, D> extends AtomicBoolean implements y<T>, i.b.j0.b {

        private static final long serialVersionUID = 5904473792286235046L;
        final f<? super D> disposer;
        final y<? super T> downstream;
        final boolean eager;
        final D resource;
        i.b.j0.b upstream;
        a(y<? super T> yVar, D d, f<? super D> fVar, boolean z) {
            super();
            this.downstream = yVar;
            this.resource = d;
            this.disposer = fVar;
            this.eager = z;
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        void a() {
            boolean z = true;
            if (compareAndSet(false, z)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th) {
                    a.b(th);
                    a.t(th);
                }
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
            boolean z = true;
            if (this.eager) {
                z = true;
                if (compareAndSet(false, z)) {
                    try {
                        this.disposer.accept(this.resource);
                    } catch (Throwable th) {
                        a.b(th);
                        this.downstream.onError(th);
                        return;
                    }
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
        public void onError(Throwable th) {
            boolean compareAndSet;
            Object resource2;
            int obj;
            Throwable th2;
            if (this.eager) {
                boolean z = true;
                if (compareAndSet(false, z)) {
                    try {
                        this.disposer.accept(this.resource);
                    } catch (Throwable th) {
                        a.b(th);
                        int arr = 2;
                        arr = new Throwable[arr];
                        arr[i] = th;
                        arr[i3] = th;
                        th = new CompositeException(arr);
                    }
                }
                this.upstream.dispose();
                this.downstream.onError(th2);
            } else {
                this.downstream.onError(th);
                this.upstream.dispose();
                a();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }
    public e4(Callable<? extends D> callable, n<? super D, ? extends w<? extends T>> nVar, f<? super D> fVar, boolean z) {
        super();
        this.a = callable;
        this.b = nVar;
        this.c = fVar;
        this.v = z;
    }

    @Override // i.b.r
    public void subscribeActual(y<? super T> yVar) {
        try {
            Object call = this.a.call();
        } catch (Throwable th) {
            a.b(th);
        }
        try {
            Object apply = this.b.apply(call);
            b.e(apply, "The sourceSupplier returned a null ObservableSource");
        } catch (Throwable th) {
            a.b(th);
        }
        apply.subscribe(new e4.a(yVar, call, this.c, this.v));
    }
}
