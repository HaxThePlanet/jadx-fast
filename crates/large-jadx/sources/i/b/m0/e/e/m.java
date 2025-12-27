package i.b.m0.e.e;

import i.b.l0.n;
import i.b.r;
import i.b.w;
import i.b.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableBufferBoundary.java */
/* loaded from: classes3.dex */
public final class m<T, U extends Collection<? super T>, Open, Close> extends a<T, U> {

    final Callable<U> b;
    final w<? extends Open> c;
    final n<? super Open, ? extends w<? extends Close>> v;

    static final class a<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements y<T>, i.b.j0.b {

        private static final long serialVersionUID = -8466418554264089604L;
        final n<? super Open, ? extends w<? extends Close>> bufferClose;
        final w<? extends Open> bufferOpen;
        final Callable<C> bufferSupplier;
        Map<Long, C> buffers = new LinkedHashMap<>();
        volatile boolean cancelled;
        volatile boolean done;
        final y<? super C> downstream;
        final i.b.m0.j.c errors = new c();
        long index;
        final i.b.j0.a observers = new a();
        final i.b.m0.f.c<C> queue = new c<>();
        final AtomicReference<i.b.j0.b> upstream = new AtomicReference<>();
        a(y<? super C> yVar, w<? extends Open> wVar, n<? super Open, ? extends w<? extends Close>> nVar, Callable<C> callable) {
            super();
            this.downstream = yVar;
            this.bufferSupplier = callable;
            this.bufferOpen = wVar;
            this.bufferClose = nVar;
            i.b.m0.f.c cVar = new c(r.bufferSize());
            i.b.j0.a aVar = new a();
            AtomicReference atomicReference = new AtomicReference();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            i.b.m0.j.c cVar2 = new c();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a(i.b.j0.b bVar, Throwable th) {
            c.dispose(this.upstream);
            this.observers.c(bVar);
            onError(th);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b(m.b<T, C> bVar, long j) {
            int i = 0;
            this.observers.c(bVar);
            boolean z = true;
            if (this.observers.f() == 0) {
                c.dispose(this.upstream);
                i = z;
            } else {
                i = 0;
            }
            synchronized (this) {
                try {
                    if (this.buffers == null) {
                        return;
                    }
                    this.queue.offer(this.buffers.remove(Long.valueOf(j)));
                } catch (Throwable th) {
                }
            }
            if (this.upstream != null) {
                this.done = z;
            }
            c();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void c() {
            int andGet;
            Object poll;
            if (getAndIncrement() != 0) {
                return;
            }
            andGet = 1;
            while (this.cancelled) {
                poll = this.queue.poll();
                int r6 = poll == null ? andGet : 0;
                if (andGet != 0) {
                }
            }
            this.queue.clear();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void d(Open open) {
            try {
                Object call = this.bufferSupplier.call();
                b.e(call, "The bufferSupplier returned a null Collection");
                final Object apply = this.bufferClose.apply(open);
                b.e(apply, "The bufferClose returned a null ObservableSource");
            } catch (Throwable th) {
            }
            this.index = 1L + index2;
            synchronized (this) {
                try {
                    if (this.buffers == null) {
                        return;
                    }
                    this.buffers.put(Long.valueOf(this.index), call);
                } catch (Throwable th) {
                }
            }
            i.b.m0.e.e.m.b bVar = new m.b(this, index2, l);
            this.observers.b(bVar);
            apply.subscribe(bVar);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            if (c.dispose(this.upstream)) {
                this.cancelled = true;
                this.observers.dispose();
                synchronized (this) {
                    try {
                        this.buffers = null;
                    } catch (Throwable th) {
                    }
                }
                if (getAndIncrement() != 0) {
                    this.queue.clear();
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void e(m.a.a<Open> aVar) {
            this.observers.c(aVar);
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
            this.observers.dispose();
            synchronized (this) {
                try {
                    if (this.buffers == null) {
                        return;
                    }
                    Iterator it = this.buffers.values().iterator();
                    while (it.hasNext()) {
                        this.queue.offer((Collection)it.next());
                    }
                    this.buffers = null;
                } catch (Throwable th) {
                }
            }
            this.done = true;
            c();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable th) {
            if (this.errors.a(th)) {
                this.observers.dispose();
                synchronized (this) {
                    try {
                        this.buffers = null;
                    } catch (Throwable th) {
                    }
                }
                boolean z = true;
                this.done = z;
                c();
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onNext(T t) {
            synchronized (this) {
                try {
                    if (this.buffers == null) {
                        return;
                    }
                    Iterator it = this.buffers.values().iterator();
                    while (it.hasNext()) {
                        (Collection)it.next().add(t);
                    }
                    return;
                } catch (Throwable th) {
                }
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) th;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(i.b.j0.b bVar) {
            if (c.setOnce(this.upstream, bVar)) {
                i.b.m0.e.e.m.a.a aVar = new m.a.a(this);
                this.observers.b(aVar);
                this.bufferOpen.subscribe(aVar);
            }
        }
    }

    static final class b<T, C extends Collection<? super T>> extends AtomicReference<i.b.j0.b> implements y<Object>, i.b.j0.b {

        private static final long serialVersionUID = -8498650778633225126L;
        final long index;
        final m.a<T, C, ?, ?> parent;
        b(m.a<T, C, ?, ?> aVar, long j) {
            super();
            this.parent = aVar;
            this.index = j;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            boolean z = true;
            int r0 = get() == c.DISPOSED ? 1 : 0;
            return (get() == c.DISPOSED ? 1 : 0);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            dISPOSED2 = c.DISPOSED;
            if (get() != c.DISPOSED) {
                lazySet(c.DISPOSED);
                this.parent.b(this, this.index);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            final i.b.m0.a.c dISPOSED2 = c.DISPOSED;
            if (get() != c.DISPOSED) {
                lazySet(c.DISPOSED);
                this.parent.a(this, th);
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onNext(Object object) {
            Object obj = get();
            dISPOSED2 = c.DISPOSED;
            if (obj != c.DISPOSED) {
                lazySet(c.DISPOSED);
                obj.dispose();
                this.parent.b(this, this.index);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(i.b.j0.b bVar) {
            c.setOnce(this, bVar);
        }
    }
    public m(w<T> wVar, w<? extends Open> wVar2, n<? super Open, ? extends w<? extends Close>> nVar, Callable<U> callable) {
        super(wVar);
        this.c = wVar2;
        this.v = nVar;
        this.b = callable;
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super U> yVar) {
        final i.b.m0.e.e.m.a aVar = new m.a(yVar, this.c, this.v, this.b);
        yVar.onSubscribe(aVar);
        this.a.subscribe(aVar);
    }
}
