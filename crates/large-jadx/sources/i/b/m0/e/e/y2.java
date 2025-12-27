package i.b.m0.e.e;

import i.b.l0.n;
import i.b.m0.a.d;
import i.b.m0.b.b;
import i.b.m0.c.e;
import i.b.r;
import i.b.w;
import i.b.y;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableScalarXMap.java */
/* loaded from: classes3.dex */
public final class y2 {

    static final class b<T, R> extends r<R> {

        final T a;
        final n<? super T, ? extends w<? extends R>> b;
        b(T t, n<? super T, ? extends w<? extends R>> nVar) {
            super();
            this.a = t;
            this.b = nVar;
        }

        @Override // i.b.r
        public void subscribeActual(y<? super R> yVar) {
            try {
                Object apply = this.b.apply(this.a);
                b.e(apply, "The mapper returned a null ObservableSource");
            } catch (Throwable th) {
                a.b(th);
                d.error(th, yVar);
                return;
            }
            z = apply instanceof Callable;
            if (apply instanceof Callable) {
                try {
                    apply = apply.call();
                } catch (Throwable th) {
                    a.b(th);
                    d.error(th, yVar);
                    return;
                }
                if (this.b == null) {
                    d.complete(yVar);
                    return;
                }
                i.b.m0.e.e.y2.a aVar = new y2.a(yVar, apply);
                yVar.onSubscribe(aVar);
                aVar.run();
            } else {
                apply.subscribe(yVar);
            }
        }
    }

    public static final class a<T> extends AtomicInteger implements e<T>, Runnable {

        private static final long serialVersionUID = 3880992722410194083L;
        final y<? super T> observer;
        final T value;
        public a(y<? super T> yVar, T t) {
            super();
            this.observer = yVar;
            this.value = t;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void clear() {
            lazySet(3);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            set(3);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            boolean z = true;
            int r0 = get() == 3 ? 1 : 0;
            return (get() == 3 ? 1 : 0);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isEmpty() {
            boolean z = true;
            if (get() == 1) {
                int i3 = 0;
            }
            return z;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public T poll() {
            if (get() == 1) {
                lazySet(3);
                return this.value;
            }
            return null;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public int requestFusion(int i) {
            final int i2 = 1;
            if (i & i2 != 0) {
                lazySet(i2);
                return i2;
            }
            return 0;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void run() {
            if (get() == 0) {
                int i2 = 2;
                if (compareAndSet(0, i2)) {
                    this.observer.onNext(this.value);
                    if (get() == i2) {
                        lazySet(3);
                        this.observer.onComplete();
                    }
                }
            }
        }
    }
    public static <T, U> r<U> a(T t, n<? super T, ? extends w<? extends U>> nVar) {
        return a.n(new y2.b(t, nVar));
    }

    public static <T, R> boolean b(w<T> wVar, y<? super R> yVar, n<? super T, ? extends w<? extends R>> nVar) {
        if (wVar instanceof Callable) {
            boolean z3 = true;
            try {
                Object call = wVar.call();
            } catch (Throwable th) {
                a.b(th);
                d.error(th, yVar);
                return z;
            }
            if (call == null) {
                d.complete(yVar);
                return true;
            }
            try {
                Object apply = nVar.apply(call);
                b.e(apply, "The mapper returned a null ObservableSource");
            } catch (Throwable th) {
                a.b(th);
                d.error(th, yVar);
                return z;
            }
            if (apply instanceof Callable) {
                try {
                    apply = apply.call();
                } catch (Throwable th) {
                    a.b(th);
                    d.error(th, yVar);
                    return z;
                }
                if (apply == null) {
                    d.complete(yVar);
                    return true;
                }
                i.b.m0.e.e.y2.a aVar = new y2.a(yVar, apply);
                yVar.onSubscribe(aVar);
                aVar.run();
            } else {
                apply.subscribe(yVar);
            }
            return true;
        }
        return false;
    }
}
