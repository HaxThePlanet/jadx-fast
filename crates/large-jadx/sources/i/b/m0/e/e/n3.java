package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.m0.c.f;
import i.b.m0.c.j;
import i.b.m0.f.c;
import i.b.m0.j.c;
import i.b.p0.a;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class n3<T, R>  extends i.b.m0.e.e.a<T, R> {

    final n<? super T, ? extends w<? extends R>> b;
    final int c;
    final boolean v;

    static final class a extends AtomicReference<b> implements y<R> {

        private static final long serialVersionUID = 3837284832786408377L;
        final int bufferSize;
        volatile boolean done;
        final long index;
        final i.b.m0.e.e.n3.b<T, R> parent;
        volatile j<R> queue;
        a(i.b.m0.e.e.n3.b<T, R> n3$b, long l2, int i3) {
            super();
            this.parent = b;
            this.index = l2;
            this.bufferSize = obj4;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void a() {
            c.dispose(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            int parent;
            if (Long.compare(index, unique) == 0) {
                this.done = true;
                this.parent.b();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            this.parent.c(this, throwable);
        }

        public void onNext(R r) {
            int queue;
            Object obj5;
            if (Long.compare(index, unique) == 0 && r != null) {
                if (r != null) {
                    this.queue.offer(r);
                }
                this.parent.b();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            boolean bufferSize;
            boolean requestFusion;
            int i;
            Object obj3;
            requestFusion = (e)b.requestFusion(7);
            int i3 = 1;
            if (c.setOnce(this, b) && b instanceof e && requestFusion == i3) {
                if (b instanceof e) {
                    requestFusion = (e)b.requestFusion(7);
                    i3 = 1;
                    if (requestFusion == i3) {
                        this.queue = b;
                        this.done = i3;
                        this.parent.b();
                    }
                    if (requestFusion == 2) {
                        this.queue = b;
                    }
                }
                obj3 = new c(this.bufferSize);
                this.queue = obj3;
            }
        }
    }

    static final class b extends AtomicInteger implements y<T>, b {

        static final i.b.m0.e.e.n3.a<Object, Object> a = null;
        private static final long serialVersionUID = -3491074160481096299L;
        final AtomicReference<i.b.m0.e.e.n3.a<T, R>> active;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final y<? super R> downstream;
        final c errors;
        final n<? super T, ? extends w<? extends R>> mapper;
        volatile long unique;
        b upstream;
        static {
            n3.a aVar = new n3.a(0, -1, obj3, 1);
            n3.b.a = aVar;
            aVar.a();
        }

        b(y<? super R> y, n<? super T, ? extends w<? extends R>> n2, int i3, boolean z4) {
            super();
            AtomicReference atomicReference = new AtomicReference();
            this.active = atomicReference;
            this.downstream = y;
            this.mapper = n2;
            this.bufferSize = i3;
            this.delayErrors = z4;
            c obj2 = new c();
            this.errors = obj2;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            Object andSet;
            final i.b.m0.e.e.n3.a aVar = n3.b.a;
            andSet = this.active.getAndSet(aVar);
            if ((n3.a)this.active.get() != aVar && (n3.a)andSet != aVar && (n3.a)andSet != null) {
                andSet = this.active.getAndSet(aVar);
                if ((n3.a)(n3.a)andSet != aVar) {
                    if ((n3.a)(n3.a)andSet != null) {
                        (n3.a)(n3.a)andSet.a();
                    }
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b() {
            int andGet;
            Object obj2;
            int done2;
            int i;
            Object queue;
            Throwable empty;
            Object obj;
            Object done;
            Object poll;
            int i2;
            if (getAndIncrement() != 0) {
            }
            y downstream = this.downstream;
            AtomicReference active = this.active;
            final boolean delayErrors = this.delayErrors;
            final int i3 = 1;
            andGet = i3;
            while (this.cancelled) {
                i = 0;
                obj2 = active.get();
                queue = obj2.queue;
                obj = 0;
                empty = i;
                while (this.cancelled) {
                    poll = queue.poll();
                    if (poll == null) {
                    } else {
                    }
                    i2 = i;
                    downstream.onNext(poll);
                    i2 = i3;
                    a.b(empty);
                    this.errors.a(empty);
                    obj1.compareAndSet(obj5, obj9);
                    if (obj2 == null) {
                    } else {
                    }
                    a();
                    empty = this.upstream;
                    empty.dispose();
                    this.done = obj3;
                    obj5.a();
                    empty = obj3;
                }
                poll = queue.poll();
                if (poll == null) {
                } else {
                }
                i2 = i;
                downstream.onNext(poll);
                active.compareAndSet((n3.a)obj2, obj);
                empty = i3;
                i2 = i3;
                empty = queue.isEmpty();
                active.compareAndSet(obj2, obj);
                active.compareAndSet(obj2, obj);
                if (active.get() == null) {
                } else {
                }
                done2 = i;
                done2 = i3;
                a.b(empty);
                this.errors.a(empty);
                obj1.compareAndSet(obj5, obj9);
                if (obj2 == null) {
                } else {
                }
                a();
                empty = this.upstream;
                empty.dispose();
                this.done = obj3;
                obj5.a();
                empty = obj3;
            }
        }

        void c(i.b.m0.e.e.n3.a<T, R> n3$a, Throwable throwable2) {
            int cmp;
            boolean obj6;
            if (Long.compare(index, unique) == 0 && this.errors.a(throwable2)) {
                if (this.errors.a(throwable2)) {
                    cmp = 1;
                    if (!this.delayErrors) {
                        this.upstream.dispose();
                        this.done = cmp;
                    }
                    a.done = cmp;
                    b();
                } else {
                    a.t(throwable2);
                }
            } else {
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            boolean cancelled;
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
            boolean done;
            if (!this.done) {
                this.done = true;
                b();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable throwable) {
            boolean done;
            Throwable obj2;
            if (!this.done && this.errors.a(throwable)) {
                if (this.errors.a(throwable)) {
                    if (!this.delayErrors) {
                        a();
                    }
                    this.done = true;
                    b();
                } else {
                    a.t(throwable);
                }
            } else {
            }
        }

        public void onNext(T t) {
            int compareAndSet;
            int active;
            unique += i;
            this.unique = compareAndSet;
            Object obj = this.active.get();
            if ((n3.a)obj != null) {
                (n3.a)obj.a();
            }
            final Object obj5 = this.mapper.apply(t);
            b.e(obj5, "The ObservableSource returned is null");
            n3.a aVar = new n3.a(this, compareAndSet, obj1, this.bufferSize);
            compareAndSet = this.active.get();
            while ((n3.a)compareAndSet == n3.b.a) {
                compareAndSet = this.active.get();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.upstream, b)) {
                this.upstream = b;
                this.downstream.onSubscribe(this);
            }
        }
    }
    public n3(w<T> w, n<? super T, ? extends w<? extends R>> n2, int i3, boolean z4) {
        super(w);
        this.b = n2;
        this.c = i3;
        this.v = z4;
    }

    public void subscribeActual(y<? super R> y) {
        if (y2.b(this.a, y, this.b)) {
        }
        n3.b bVar = new n3.b(y, this.b, this.c, this.v);
        this.a.subscribe(bVar);
    }
}
