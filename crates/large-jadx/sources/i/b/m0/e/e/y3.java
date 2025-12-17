package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.a.g;
import i.b.m0.b.b;
import i.b.p0.a;
import i.b.r;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class y3<T, U, V>  extends i.b.m0.e.e.a<T, T> {

    final w<U> b;
    final n<? super T, ? extends w<V>> c;
    final w<? extends T> v;

    static final class a extends AtomicReference<b> implements y<Object>, b {

        private static final long serialVersionUID = 8708641127342403073L;
        final long idx;
        final i.b.m0.e.e.y3.d parent;
        a(long l, i.b.m0.e.e.y3.d y3$d2) {
            super();
            this.idx = l;
            this.parent = obj3;
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
        public void onComplete() {
            Object parent;
            c dISPOSED;
            dISPOSED = c.DISPOSED;
            if (get() != dISPOSED) {
                lazySet(dISPOSED);
                this.parent.a(this.idx);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            Object parent;
            long dISPOSED;
            dISPOSED = c.DISPOSED;
            if (get() != dISPOSED) {
                lazySet(dISPOSED);
                this.parent.b(this.idx, obj2);
            } else {
                a.t(throwable);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onNext(Object object) {
            c dISPOSED;
            Object obj3;
            obj3 = get();
            dISPOSED = c.DISPOSED;
            if ((b)obj3 != dISPOSED) {
                (b)obj3.dispose();
                lazySet(dISPOSED);
                this.parent.a(this.idx);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            c.setOnce(this, b);
        }
    }

    interface d extends i.b.m0.e.e.z3.d {
        @Override // i.b.m0.e.e.z3$d
        public abstract void b(long l, Throwable throwable2);
    }

    static final class b extends AtomicReference<b> implements y<T>, b, i.b.m0.e.e.y3.d {

        private static final long serialVersionUID = -7508389464265974549L;
        final y<? super T> downstream;
        w<? extends T> fallback;
        final AtomicLong index;
        final n<? super T, ? extends w<?>> itemTimeoutIndicator;
        final g task;
        final AtomicReference<b> upstream;
        b(y<? super T> y, n<? super T, ? extends w<?>> n2, w<? extends T> w3) {
            super();
            this.downstream = y;
            this.itemTimeoutIndicator = n2;
            g obj1 = new g();
            this.task = obj1;
            this.fallback = w3;
            obj1 = new AtomicLong();
            this.index = obj1;
            obj1 = new AtomicReference();
            this.upstream = obj1;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void a(long l) {
            Object downstream;
            boolean obj4;
            long obj5;
            if (this.index.compareAndSet(l, obj5)) {
                c.dispose(this.upstream);
                this.fallback = 0;
                obj5 = new z3.a(this.downstream, this);
                this.fallback.subscribe(obj5);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void b(long l, Throwable throwable2) {
            y obj4;
            if (this.index.compareAndSet(l, throwable2)) {
                c.dispose(this);
                this.downstream.onError(obj6);
            } else {
                a.t(obj6);
            }
        }

        void c(w<?> w) {
            i.b.m0.e.e.y3.a aVar;
            boolean z;
            aVar = new y3.a(0, obj2, this);
            if (w != null && this.task.a(aVar)) {
                aVar = new y3.a(0, obj2, this);
                if (this.task.a(aVar)) {
                    w.subscribe(aVar);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this.upstream);
            c.dispose(this);
            this.task.dispose();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            return c.isDisposed((b)get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            int task;
            final long l = Long.MAX_VALUE;
            if (Long.compare(andSet, l) != 0) {
                this.task.dispose();
                this.downstream.onComplete();
                this.task.dispose();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            y downstream;
            Object obj6;
            final long l = Long.MAX_VALUE;
            if (Long.compare(andSet, l) != 0) {
                this.task.dispose();
                this.downstream.onError(throwable);
                this.task.dispose();
            } else {
                a.t(throwable);
            }
        }

        public void onNext(T t) {
            long compareAndSet;
            int index;
            int i;
            Object obj8;
            compareAndSet = this.index.get();
            if (Long.compare(compareAndSet, l) != 0) {
                i2 += compareAndSet;
                if (!this.index.compareAndSet(compareAndSet, obj1)) {
                } else {
                    Object obj = this.task.get();
                    if ((b)obj != null) {
                        (b)obj.dispose();
                    }
                    this.downstream.onNext(t);
                    obj8 = this.itemTimeoutIndicator.apply(t);
                    b.e(obj8, "The itemTimeoutIndicator returned a null ObservableSource.");
                    y3.a aVar = new y3.a(i, obj6, this);
                    if (this.task.a(aVar)) {
                        (w)obj8.subscribe(aVar);
                    }
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            c.setOnce(this.upstream, b);
        }
    }

    static final class c extends AtomicLong implements y<T>, b, i.b.m0.e.e.y3.d {

        private static final long serialVersionUID = 3764492702657003550L;
        final y<? super T> downstream;
        final n<? super T, ? extends w<?>> itemTimeoutIndicator;
        final g task;
        final AtomicReference<b> upstream;
        c(y<? super T> y, n<? super T, ? extends w<?>> n2) {
            super();
            this.downstream = y;
            this.itemTimeoutIndicator = n2;
            g obj1 = new g();
            this.task = obj1;
            obj1 = new AtomicReference();
            this.upstream = obj1;
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void a(long l) {
            boolean obj3;
            long obj4;
            if (compareAndSet(l, obj4)) {
                c.dispose(this.upstream);
                obj4 = new TimeoutException();
                this.downstream.onError(obj4);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void b(long l, Throwable throwable2) {
            y obj3;
            if (compareAndSet(l, throwable2)) {
                c.dispose(this.upstream);
                this.downstream.onError(obj5);
            } else {
                a.t(obj5);
            }
        }

        void c(w<?> w) {
            i.b.m0.e.e.y3.a aVar;
            boolean z;
            aVar = new y3.a(0, obj2, this);
            if (w != null && this.task.a(aVar)) {
                aVar = new y3.a(0, obj2, this);
                if (this.task.a(aVar)) {
                    w.subscribe(aVar);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void dispose() {
            c.dispose(this.upstream);
            this.task.dispose();
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public boolean isDisposed() {
            return c.isDisposed((b)this.upstream.get());
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void onComplete() {
            int downstream;
            long l = Long.MAX_VALUE;
            if (Long.compare(andSet, l) != 0) {
                this.task.dispose();
                this.downstream.onComplete();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void onError(Throwable throwable) {
            y downstream;
            long l = Long.MAX_VALUE;
            if (Long.compare(andSet, l) != 0) {
                this.task.dispose();
                this.downstream.onError(throwable);
            } else {
                a.t(throwable);
            }
        }

        public void onNext(T t) {
            long compareAndSet;
            int cmp;
            Object obj7;
            compareAndSet = get();
            if (Long.compare(compareAndSet, l) != 0) {
                i += compareAndSet;
                if (!compareAndSet(compareAndSet, obj1)) {
                } else {
                    Object obj = this.task.get();
                    if ((b)obj != null) {
                        (b)obj.dispose();
                    }
                    this.downstream.onNext(t);
                    obj7 = this.itemTimeoutIndicator.apply(t);
                    b.e(obj7, "The itemTimeoutIndicator returned a null ObservableSource.");
                    y3.a aVar = new y3.a(cmp, obj5, this);
                    if (this.task.a(aVar)) {
                        (w)obj7.subscribe(aVar);
                    }
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void onSubscribe(b b) {
            c.setOnce(this.upstream, b);
        }
    }
    public y3(r<T> r, w<U> w2, n<? super T, ? extends w<V>> n3, w<? extends T> w4) {
        super(r);
        this.b = w2;
        this.c = n3;
        this.v = w4;
    }

    protected void subscribeActual(y<? super T> y) {
        Object cVar;
        n nVar;
        w wVar;
        w obj4;
        if (this.v == null) {
            cVar = new y3.c(y, this.c);
            y.onSubscribe(cVar);
            cVar.c(this.b);
            this.a.subscribe(cVar);
        } else {
            cVar = new y3.b(y, this.c, this.v);
            y.onSubscribe(cVar);
            cVar.c(this.b);
            this.a.subscribe(cVar);
        }
    }
}
