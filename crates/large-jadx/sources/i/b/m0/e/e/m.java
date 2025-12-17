package i.b.m0.e.e;

import i.b.j0.a;
import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.m0.f.c;
import i.b.m0.j.c;
import i.b.p0.a;
import i.b.r;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class m<T, U extends Collection<? super T>, Open, Close>  extends i.b.m0.e.e.a<T, U> {

    final Callable<U> b;
    final w<? extends Open> c;
    final n<? super Open, ? extends w<? extends Close>> v;

    static final class a extends AtomicInteger implements y<T>, b {

        private static final long serialVersionUID = -8466418554264089604L;
        final n<? super Open, ? extends w<? extends Close>> bufferClose;
        final w<? extends Open> bufferOpen;
        final Callable<C> bufferSupplier;
        Map<Long, C> buffers;
        volatile boolean cancelled;
        volatile boolean done;
        final y<? super C> downstream;
        final c errors;
        long index;
        final a observers;
        final c<C> queue;
        final AtomicReference<b> upstream;
        a(y<? super C> y, w<? extends Open> w2, n<? super Open, ? extends w<? extends Close>> n3, Callable<C> callable4) {
            super();
            this.downstream = y;
            this.bufferSupplier = callable4;
            this.bufferOpen = w2;
            this.bufferClose = n3;
            c obj1 = new c(r.bufferSize());
            this.queue = obj1;
            obj1 = new a();
            this.observers = obj1;
            obj1 = new AtomicReference();
            this.upstream = obj1;
            obj1 = new LinkedHashMap();
            this.buffers = obj1;
            obj1 = new c();
            this.errors = obj1;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a(b b, Throwable throwable2) {
            c.dispose(this.upstream);
            this.observers.c(b);
            onError(throwable2);
        }

        void b(i.b.m0.e.e.m.b<T, C> m$b, long l2) {
            int obj4;
            this.observers.c(b);
            int i = 1;
            if (this.observers.f() == 0) {
                c.dispose(this.upstream);
                obj4 = i;
            } else {
                obj4 = 0;
            }
            final Map buffers = this.buffers;
            synchronized (this) {
            }
            this.done = i;
            c();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void c() {
            int andGet;
            boolean done;
            Object poll;
            int i;
            if (getAndIncrement() != 0) {
            }
            y downstream = this.downstream;
            c queue = this.queue;
            final int i2 = 1;
            andGet = i2;
            while (this.cancelled) {
                done = this.done;
                poll = queue.poll();
                if ((Collection)poll == null) {
                } else {
                }
                i = 0;
                downstream.onNext((Collection)poll);
                i = i2;
            }
            queue.clear();
        }

        void d(Open open) {
            Object call = this.bufferSupplier.call();
            b.e(call, "The bufferSupplier returned a null Collection");
            final Object obj6 = this.bufferClose.apply(open);
            b.e(obj6, "The bufferClose returned a null ObservableSource");
            long index = this.index;
            this.index = i += index;
            Map buffers = this.buffers;
            synchronized (this) {
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            boolean andIncrement;
            this.cancelled = true;
            this.observers.dispose();
            this.buffers = 0;
            if (c.dispose(this.upstream) && getAndIncrement() != 0) {
                this.cancelled = true;
                this.observers.dispose();
                this.buffers = 0;
                synchronized (this) {
                    this.cancelled = true;
                    this.observers.dispose();
                    this.buffers = 0;
                }
                this.queue.clear();
            }
        }

        void e(i.b.m0.e.e.m.a.a<Open> m$a$a) {
            int obj2;
            this.observers.c(a);
            if (this.observers.f() == 0) {
                c.dispose(this.upstream);
                this.done = true;
                c();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return c.isDisposed((b)this.upstream.get());
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            Object next;
            c queue;
            this.observers.dispose();
            Map buffers = this.buffers;
            synchronized (this) {
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable throwable) {
            Throwable obj2;
            if (this.errors.a(throwable)) {
                this.observers.dispose();
                this.buffers = 0;
                this.done = true;
                c();
                synchronized (this) {
                    this.observers.dispose();
                    this.buffers = 0;
                    this.done = true;
                    c();
                }
            } else {
                a.t(throwable);
            }
        }

        public void onNext(T t) {
            Object next;
            Map buffers = this.buffers;
            synchronized (this) {
                try {
                    Iterator iterator = buffers.values().iterator();
                    for (Collection next : iterator) {
                        next.add(t);
                    }
                    (Collection)iterator.next().add(t);
                    throw t;
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(b b) {
            Object bufferOpen;
            boolean obj2;
            if (c.setOnce(this.upstream, b)) {
                obj2 = new m.a.a(this);
                this.observers.b(obj2);
                this.bufferOpen.subscribe(obj2);
            }
        }
    }

    static final class b extends AtomicReference<b> implements y<Object>, b {

        private static final long serialVersionUID = -8498650778633225126L;
        final long index;
        final i.b.m0.e.e.m.a<T, C, ?, ?> parent;
        b(i.b.m0.e.e.m.a<T, C, ?, ?> m$a, long l2) {
            super();
            this.parent = a;
            this.index = l2;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            int i;
            i = get() == c.DISPOSED ? 1 : 0;
            return i;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            Object parent;
            c dISPOSED;
            dISPOSED = c.DISPOSED;
            if (get() != dISPOSED) {
                lazySet(dISPOSED);
                this.parent.b(this, this.index);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            Object parent;
            final c dISPOSED = c.DISPOSED;
            if (get() != dISPOSED) {
                lazySet(dISPOSED);
                this.parent.a(this, throwable);
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
                lazySet(dISPOSED);
                (b)obj3.dispose();
                this.parent.b(this, this.index);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            c.setOnce(this, b);
        }
    }
    public m(w<T> w, w<? extends Open> w2, n<? super Open, ? extends w<? extends Close>> n3, Callable<U> callable4) {
        super(w);
        this.c = w2;
        this.v = n3;
        this.b = callable4;
    }

    protected void subscribeActual(y<? super U> y) {
        m.a aVar = new m.a(y, this.c, this.v, this.b);
        y.onSubscribe(aVar);
        this.a.subscribe(aVar);
    }
}
