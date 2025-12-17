package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.a.g;
import i.b.m0.j.k;
import i.b.p0.a;
import i.b.r;
import i.b.w;
import i.b.y;
import i.b.z;
import i.b.z.c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class z3<T>  extends i.b.m0.e.e.a<T, T> {

    final long b;
    final TimeUnit c;
    final z v;
    final w<? extends T> w;

    interface d {
        public abstract void a(long l);
    }

    static final class e implements Runnable {

        final i.b.m0.e.e.z3.d a;
        final long b;
        e(long l, i.b.m0.e.e.z3.d z3$d2) {
            super();
            this.b = l;
            this.a = obj3;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.b);
        }
    }

    static final class a implements y<T> {

        final y<? super T> a;
        final AtomicReference<b> b;
        a(y<? super T> y, AtomicReference<b> atomicReference2) {
            super();
            this.a = y;
            this.b = atomicReference2;
        }

        @Override // i.b.y
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            this.a.onError(throwable);
        }

        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            c.replace(this.b, b);
        }
    }

    static final class b extends AtomicReference<b> implements y<T>, b, i.b.m0.e.e.z3.d {

        private static final long serialVersionUID = 3764492702657003550L;
        final y<? super T> downstream;
        w<? extends T> fallback;
        final AtomicLong index;
        final g task;
        final long timeout;
        final TimeUnit unit;
        final AtomicReference<b> upstream;
        final z.c worker;
        b(y<? super T> y, long l2, TimeUnit timeUnit3, z.c z$c4, w<? extends T> w5) {
            super();
            this.downstream = y;
            this.timeout = l2;
            this.unit = c4;
            this.worker = w5;
            this.fallback = obj6;
            g obj1 = new g();
            this.task = obj1;
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
                this.worker.dispose();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        void c(long l) {
            z3.e eVar = new z3.e(l, obj6, this);
            this.task.a(this.worker.c(eVar, this.timeout, obj6));
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this.upstream);
            c.dispose(this);
            this.worker.dispose();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            return c.isDisposed((b)get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            int worker;
            final long l = Long.MAX_VALUE;
            if (Long.compare(andSet, l) != 0) {
                this.task.dispose();
                this.downstream.onComplete();
                this.worker.dispose();
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
                this.worker.dispose();
            } else {
                a.t(throwable);
            }
        }

        public void onNext(T t) {
            long compareAndSet;
            int index;
            int i;
            compareAndSet = this.index.get();
            if (Long.compare(compareAndSet, l) != 0) {
                i2 += compareAndSet;
                if (!this.index.compareAndSet(compareAndSet, obj1)) {
                } else {
                    (b)this.task.get().dispose();
                    this.downstream.onNext(t);
                    c(i);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            c.setOnce(this.upstream, b);
        }
    }

    static final class c extends AtomicLong implements y<T>, b, i.b.m0.e.e.z3.d {

        private static final long serialVersionUID = 3764492702657003550L;
        final y<? super T> downstream;
        final g task;
        final long timeout;
        final TimeUnit unit;
        final AtomicReference<b> upstream;
        final z.c worker;
        c(y<? super T> y, long l2, TimeUnit timeUnit3, z.c z$c4) {
            super();
            this.downstream = y;
            this.timeout = l2;
            this.unit = c4;
            this.worker = obj5;
            g obj1 = new g();
            this.task = obj1;
            obj1 = new AtomicReference();
            this.upstream = obj1;
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void a(long l) {
            long l2;
            TimeUnit unit;
            boolean obj4;
            long obj5;
            if (compareAndSet(l, obj5)) {
                c.dispose(this.upstream);
                obj5 = new TimeoutException(k.d(this.timeout, obj1));
                this.downstream.onError(obj5);
                this.worker.dispose();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        void c(long l) {
            z3.e eVar = new z3.e(l, obj6, this);
            this.task.a(this.worker.c(eVar, this.timeout, obj6));
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void dispose() {
            c.dispose(this.upstream);
            this.worker.dispose();
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public boolean isDisposed() {
            return c.isDisposed((b)this.upstream.get());
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void onComplete() {
            int worker;
            long l = Long.MAX_VALUE;
            if (Long.compare(andSet, l) != 0) {
                this.task.dispose();
                this.downstream.onComplete();
                this.worker.dispose();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void onError(Throwable throwable) {
            y downstream;
            Object obj5;
            long l = Long.MAX_VALUE;
            if (Long.compare(andSet, l) != 0) {
                this.task.dispose();
                this.downstream.onError(throwable);
                this.worker.dispose();
            } else {
                a.t(throwable);
            }
        }

        public void onNext(T t) {
            long compareAndSet;
            int cmp;
            compareAndSet = get();
            if (Long.compare(compareAndSet, l) != 0) {
                i += compareAndSet;
                if (!compareAndSet(compareAndSet, obj1)) {
                } else {
                    (b)this.task.get().dispose();
                    this.downstream.onNext(t);
                    c(cmp);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void onSubscribe(b b) {
            c.setOnce(this.upstream, b);
        }
    }
    public z3(r<T> r, long l2, TimeUnit timeUnit3, z z4, w<? extends T> w5) {
        super(r);
        this.b = l2;
        this.c = z4;
        this.v = w5;
        this.w = obj6;
    }

    protected void subscribeActual(y<? super T> y) {
        Object cVar;
        Object obj;
        y yVar;
        long l;
        TimeUnit time;
        z.c cVar2;
        w wVar;
        w obj11;
        final int i = 0;
        if (this.w == null) {
            super(y, this.b, obj6, this.c, this.v.a());
            y.onSubscribe(cVar);
            cVar.c(i);
            this.a.subscribe(cVar);
        } else {
            super(y, this.b, obj6, this.c, this.v.a(), this.w);
            y.onSubscribe(cVar);
            cVar.c(i);
            this.a.subscribe(cVar);
        }
    }
}
