package i.b.m0.e.e;

import i.b.l0.n;
import i.b.m0.c.f;
import i.b.m0.c.j;
import i.b.w;
import i.b.y;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableSwitchMap.java */
/* loaded from: classes3.dex */
public final class n3<T, R> extends a<T, R> {

    final n<? super T, ? extends w<? extends R>> b;
    final int c;
    final boolean v;

    static final class a<T, R> extends AtomicReference<i.b.j0.b> implements y<R> {

        private static final long serialVersionUID = 3837284832786408377L;
        final int bufferSize;
        volatile boolean done;
        final long index;
        final n3.b<T, R> parent;
        volatile j<R> queue;
        a(n3.b<T, R> bVar, long j, int i) {
            super();
            this.parent = bVar;
            this.index = j;
            this.bufferSize = i;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void a() {
            c.dispose(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            if (this.index == this.parent.unique) {
                this.done = true;
                this.parent.b();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            this.parent.c(this, th);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onNext(R r) {
            int cmp;
            if (this.index == this.parent.unique && r != null) {
                this.queue.offer(r);
                this.parent.b();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(i.b.j0.b bVar) {
            int i = 2;
            if (c.setOnce(this, bVar)) {
                z = bVar instanceof e;
                if (bVar instanceof e) {
                    int requestFusion = bVar.requestFusion(7);
                    int i3 = 1;
                    if (requestFusion == i3) {
                        this.queue = bVar;
                        this.done = true;
                        this.parent.b();
                        return;
                    }
                    i = 2;
                    if (requestFusion == 2) {
                        this.queue = bVar;
                        return;
                    }
                }
                this.queue = new c(this.bufferSize);
            }
        }
    }

    static final class b<T, R> extends AtomicInteger implements y<T>, i.b.j0.b {

        static final n3.a<Object, Object> a = null;
        private static final long serialVersionUID = -3491074160481096299L;
        final AtomicReference<n3.a<T, R>> active = new AtomicReference<>();
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final y<? super R> downstream;
        final i.b.m0.j.c errors = new c();
        final n<? super T, ? extends w<? extends R>> mapper;
        volatile long unique;
        i.b.j0.b upstream;
        static {
            final i.b.m0.e.e.n3.a aVar = new n3.a(null, -1L, r3, 1);
            n3.b.a = aVar;
            aVar.a();
        }

        b(y<? super R> yVar, n<? super T, ? extends w<? extends R>> nVar, int i, boolean z) {
            super();
            final AtomicReference atomicReference = new AtomicReference();
            this.downstream = yVar;
            this.mapper = nVar;
            this.bufferSize = i;
            this.delayErrors = z;
            final i.b.m0.j.c cVar = new c();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            final i.b.m0.e.e.n3.a aVar = n3.b.a;
            if ((n3.a)this.active.get() != n3.b.a) {
                Object andSet = this.active.getAndSet(n3.b.a);
                if (andSet != n3.b.a && andSet != null) {
                    andSet.a();
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b() {
            int andGet;
            j queue2;
            Throwable th4;
            boolean empty;
            Object obj2 = null;
            Object obj3;
            Object poll;
            if (getAndIncrement() != 0) {
                return;
            }
            andGet = 1;
            while (this.cancelled) {
                andGet = 0;
                Object obj = this.active.get();
                if (addAndGet(-andGet) == 0) {
                    return;
                }
                obj2 = null;
                while (this.cancelled) {
                    try {
                        poll = obj.queue.poll();
                    } catch (Throwable th) {
                        a.b(th);
                        this.errors.a(th);
                        obj4.compareAndSet(obj7, obj10);
                    }
                    int r12 = andGet;
                    a();
                    this.upstream.dispose();
                    this.done = z;
                    obj7.a();
                    th = z;
                    if (andGet != 0) {
                    }
                }
                try {
                    poll = obj.queue.poll();
                } catch (Throwable th) {
                    a.b(this.upstream);
                    this.errors.a(this.upstream);
                    obj4.compareAndSet(obj7, obj10);
                }
                r12 = andGet;
                if (!obj.done) {
                }
                empty = obj.queue.isEmpty();
                if (!obj.done) {
                }
                if (!obj.done) {
                }
                Object obj7 = andGet;
                a();
                this.upstream.dispose();
                this.done = z;
                obj7.a();
                th = z;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void c(n3.a<T, R> aVar, Throwable th) {
            int cmp;
            boolean delayErrors2;
            if (aVar.index == this.unique) {
                if (this.errors.a(th)) {
                    boolean z2 = true;
                    if (!this.delayErrors) {
                        this.upstream.dispose();
                        this.done = z2;
                    }
                    aVar.done = z2;
                    b();
                } else {
                    a.t(th);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.dispose();
                a();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            if (!this.done) {
                boolean done2 = true;
                this.done = done2;
                b();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable th) {
            boolean done2;
            if (!this.done) {
                if (this.errors.a(th)) {
                    if (!this.delayErrors) {
                        a();
                    }
                    boolean z = true;
                    this.done = z;
                    b();
                } else {
                    a.t(th);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onNext(T t) {
            this.unique++;
            Object obj2 = this.active.get();
            if (obj2 != null) {
                obj2.a();
            }
            try {
                final Object apply = this.mapper.apply(t);
                b.e(apply, "The ObservableSource returned is null");
            } catch (Throwable th) {
                a.b(th);
                this.upstream.dispose();
                onError(th);
                return;
            }
            i.b.m0.e.e.n3.a aVar2 = new n3.a(this, l, r1, this.bufferSize);
            Object obj = this.active.get();
            while (obj == n3.b.a) {
                if (this.active.compareAndSet(obj, aVar2)) {
                    apply.subscribe(aVar2);
                }
                obj = this.active.get();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }
    public n3(w<T> wVar, n<? super T, ? extends w<? extends R>> nVar, int i, boolean z) {
        super(wVar);
        this.b = nVar;
        this.c = i;
        this.v = z;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super R> yVar) {
        if (y2.b(this.a, yVar, this.b)) {
            return;
        }
        this.a.subscribe(new n3.b(yVar, this.b, this.c, this.v));
    }
}
