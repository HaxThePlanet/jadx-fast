package i.b.m0.e.e;

import i.b.l0.n;
import i.b.m0.a.d;
import i.b.m0.b.b;
import i.b.m0.c.e;
import i.b.p0.a;
import i.b.r;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class y2 {

    static final class b extends r<R> {

        final T a;
        final n<? super T, ? extends w<? extends R>> b;
        b(T t, n<? super T, ? extends w<? extends R>> n2) {
            super();
            this.a = t;
            this.b = n2;
        }

        public void subscribeActual(y<? super R> y) {
            Object apply;
            boolean aVar;
            try {
                apply = this.b.apply(this.a);
                b.e(apply, "The mapper returned a null ObservableSource");
                if (apply instanceof Callable) {
                } else {
                }
                apply = (Callable)(w)apply.call();
                if (apply == null) {
                }
                d.complete(y);
                aVar = new y2.a(y, apply);
                y.onSubscribe(aVar);
                aVar.run();
                a.b(th);
                d.error(th, y);
                apply.subscribe(y);
                d.error(th, y);
            } catch (Throwable th) {
            }
        }
    }

    public static final class a extends AtomicInteger implements e<T>, Runnable {

        private static final long serialVersionUID = 3880992722410194083L;
        final y<? super T> observer;
        final T value;
        public a(y<? super T> y, T t2) {
            super();
            this.observer = y;
            this.value = t2;
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
            int i;
            i = get() == 3 ? 1 : 0;
            return i;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isEmpty() {
            int i;
            if (get() != 1) {
            } else {
                i = 0;
            }
            return i;
        }

        public boolean offer(T t) {
            UnsupportedOperationException obj2 = new UnsupportedOperationException("Should not be called!");
            throw obj2;
        }

        public T poll() {
            if (get() == 1) {
                lazySet(3);
                return this.value;
            }
            return 0;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public int requestFusion(int i) {
            final int i2 = 1;
            if (i &= i2 != 0) {
                lazySet(i2);
                return i2;
            }
            return 0;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void run() {
            int compareAndSet;
            int i;
            Object value;
            i = 2;
            this.observer.onNext(this.value);
            if (get() == 0 && compareAndSet(0, i) && get() == i) {
                i = 2;
                if (compareAndSet(0, i)) {
                    this.observer.onNext(this.value);
                    if (get() == i) {
                        lazySet(3);
                        this.observer.onComplete();
                    }
                }
            }
        }
    }
    public static <T, U> r<U> a(T t, n<? super T, ? extends w<? extends U>> n2) {
        y2.b bVar = new y2.b(t, n2);
        return a.n(bVar);
    }

    public static <T, R> boolean b(w<T> w, y<? super R> y2, n<? super T, ? extends w<? extends R>> n3) {
        Object obj1;
        boolean obj3;
        int i = 1;
        obj1 = (Callable)w.call();
        if (w instanceof Callable && obj1 == null) {
            i = 1;
            obj1 = (Callable)w.call();
            if (obj1 == null) {
                d.complete(y2);
                return i;
            }
            obj1 = n3.apply(obj1);
            b.e(obj1, "The mapper returned a null ObservableSource");
            if (obj1 instanceof Callable) {
                obj1 = (Callable)(w)obj1.call();
                if (obj1 == null) {
                    try {
                        d.complete(y2);
                        return i;
                        obj3 = new y2.a(y2, obj1);
                        y2.onSubscribe(obj3);
                        obj3.run();
                        a.b(w);
                        d.error(w, y2);
                        return obj0;
                        obj1.subscribe(y2);
                        return i;
                        a.b(w);
                        d.error(w, y2);
                        return obj0;
                    } catch (Throwable th) {
                    }
                }
            } else {
            }
        }
        return 0;
    }
}
