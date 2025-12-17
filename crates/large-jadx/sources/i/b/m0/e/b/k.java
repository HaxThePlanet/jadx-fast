package i.b.m0.e.b;

import i.b.h;
import i.b.j0.b;
import i.b.k;
import i.b.l0.n;
import i.b.m0.b.b;
import i.b.m0.c.f;
import i.b.m0.c.i;
import i.b.m0.c.j;
import i.b.m0.f.b;
import i.b.m0.f.c;
import i.b.m0.i.g;
import i.b.m0.j.c;
import i.b.m0.j.d;
import i.b.m0.j.k;
import i.b.p0.a;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import m.c.a;
import m.c.b;
import m.c.c;

/* loaded from: classes3.dex */
public final class k<T, U>  extends i.b.m0.e.b.a<T, U> {

    final n<? super T, ? extends a<? extends U>> c;
    final boolean v;
    final int w;
    final int x;

    static final class a extends AtomicReference<c> implements k<U>, b {

        private static final long serialVersionUID = -4606175640614850599L;
        final int bufferSize;
        volatile boolean done;
        int fusionMode;
        final long id;
        final int limit;
        final i.b.m0.e.b.k.b<T, U> parent;
        long produced;
        volatile j<U> queue;
        a(i.b.m0.e.b.k.b<T, U> k$b, long l2) {
            super();
            this.id = l2;
            this.parent = b;
            int obj1 = b.bufferSize;
            this.bufferSize = obj1;
            this.limit = obj1 >>= 2;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        void a(long l) {
            int fusionMode;
            int obj3;
            final int i = 1;
            if (this.fusionMode != i) {
                produced += l;
                if (Long.compare(fusionMode, obj3) >= 0) {
                    this.produced = 0;
                    (c)get().request(fusionMode);
                } else {
                    this.produced = fusionMode;
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            g.cancel(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            int i;
            i = get() == g.CANCELLED ? 1 : 0;
            return i;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            this.done = true;
            this.parent.f();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            lazySet(g.CANCELLED);
            this.parent.j(this, throwable);
        }

        public void onNext(U u) {
            i.b.m0.e.b.k.b fusionMode;
            Object obj3;
            if (this.fusionMode != 2) {
                this.parent.l(u, this);
            } else {
                this.parent.f();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(c c) {
            boolean once;
            boolean z;
            int requestFusion;
            int i;
            z = c;
            requestFusion = (g)z.requestFusion(7);
            int i3 = 1;
            if (g.setOnce(this, c) && c instanceof g && requestFusion == i3) {
                if (c instanceof g) {
                    z = c;
                    requestFusion = (g)z.requestFusion(7);
                    i3 = 1;
                    if (requestFusion == i3) {
                        this.fusionMode = requestFusion;
                        this.queue = z;
                        this.done = i3;
                        this.parent.f();
                    }
                    if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = z;
                    }
                }
                c.request((long)bufferSize);
            }
        }
    }

    static final class b extends AtomicInteger implements k<T>, c {

        static final i.b.m0.e.b.k.a<?, ?>[] a = null;
        static final i.b.m0.e.b.k.a<?, ?>[] b = null;
        private static final long serialVersionUID = -2117620485640801370L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final b<? super U> downstream;
        final c errs;
        long lastId;
        int lastIndex;
        final n<? super T, ? extends a<? extends U>> mapper;
        final int maxConcurrency;
        volatile i<U> queue;
        final AtomicLong requested;
        int scalarEmitted;
        final int scalarLimit;
        final AtomicReference<i.b.m0.e.b.k.a<?, ?>[]> subscribers;
        long uniqueId;
        c upstream;
        static {
            int i = 0;
            k.b.a = new k.a[i];
            k.b.b = new k.a[i];
        }

        b(b<? super U> b, n<? super T, ? extends a<? extends U>> n2, boolean z3, int i4, int i5) {
            super();
            c cVar = new c();
            this.errs = cVar;
            AtomicReference atomicReference = new AtomicReference();
            this.subscribers = atomicReference;
            AtomicLong atomicLong = new AtomicLong();
            this.requested = atomicLong;
            this.downstream = b;
            this.mapper = n2;
            this.delayErrors = z3;
            this.maxConcurrency = i4;
            this.bufferSize = i5;
            this.scalarLimit = Math.max(1, i4 >> 1);
            atomicReference.lazySet(k.b.a);
        }

        boolean a(i.b.m0.e.b.k.a<T, U> k$a) {
            Object obj = this.subscribers.get();
            final int i = 0;
            while ((k.a[])obj == k.b.b) {
                int length = obj.length;
                i.b.m0.e.b.k.a[] arr = new k.a[length + 1];
                System.arraycopy((k.a[])obj, i, arr, i, length);
                arr[length] = a;
                obj = this.subscribers.get();
                i = 0;
            }
            a.dispose();
            return i;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        boolean b() {
            boolean delayErrors;
            Object downstream;
            final int i2 = 1;
            if (this.cancelled) {
                d();
                return i2;
            }
            d();
            Throwable th = this.errs.b();
            if (!this.delayErrors && this.errs.get() != null && th != k.a) {
                if (this.errs.get() != null) {
                    d();
                    th = this.errs.b();
                    if (th != k.a) {
                        this.downstream.onError(th);
                    }
                    return i2;
                }
            }
            return 0;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void cancel() {
            boolean andIncrement;
            this.cancelled = true;
            this.upstream.cancel();
            e();
            andIncrement = this.queue;
            if (!this.cancelled && getAndIncrement() == 0 && andIncrement != null) {
                this.cancelled = true;
                this.upstream.cancel();
                e();
                if (getAndIncrement() == 0) {
                    andIncrement = this.queue;
                    if (andIncrement != null) {
                        andIncrement.clear();
                    }
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void d() {
            final i queue = this.queue;
            if (queue != null) {
                queue.clear();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void e() {
            Object andSet;
            i.b.m0.e.b.k.a[] length;
            int i;
            Object obj;
            length = k.b.b;
            andSet = this.subscribers.getAndSet(length);
            if ((k.a[])this.subscribers.get() != length && (k.a[])andSet != length) {
                andSet = this.subscribers.getAndSet(length);
                if ((k.a[])(k.a[])andSet != length) {
                    i = 0;
                    while (i < andSet.length) {
                        (k.a[])(k.a[])andSet[i].dispose();
                        i++;
                    }
                    andSet = this.errs.b();
                    if (andSet != null && andSet != k.a) {
                        if (andSet != k.a) {
                            a.t(andSet);
                        }
                    }
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void f() {
            if (getAndIncrement() == 0) {
                g();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void g() {
            Throwable cancelled;
            boolean empty2;
            int lastIndex;
            int i2;
            int i15;
            long lastId;
            int i11;
            int andGet2;
            int i3;
            long andGet;
            int i14;
            i.b.m0.e.b.k.a aVar;
            long cmp3;
            int queue;
            int i8;
            Object obj;
            int i4;
            Throwable poll;
            int length;
            boolean empty;
            int i13;
            int i5;
            long queue2;
            int i10;
            int queue3;
            int i;
            int i7;
            boolean z;
            int i12;
            int i16;
            int cmp2;
            int i6;
            int i9;
            int cmp;
            final Object obj2 = this;
            final b downstream = obj2.downstream;
            andGet2 = 1;
            while (b()) {
                i queue4 = obj2.queue;
                if (Long.compare(andGet, cmp3) == 0) {
                } else {
                }
                i4 = 0;
                queue3 = 1;
                i7 = 0;
                i12 = i7;
                queue = obj2.queue;
                obj = obj2.subscribers.get();
                length = obj.length;
                i16 = andGet2;
                aVar = 1;
                i3 = i7;
                i15 = i12;
                poll = 0;
                if (Long.compare(i15, i3) != 0 && !obj2.cancelled) {
                }
                andGet2 = i16;
                if (!obj2.cancelled) {
                }
                obj2.upstream.request(i15);
                lastId = obj2.lastId;
                lastIndex = obj2.lastIndex;
                if (length > lastIndex) {
                } else {
                }
                if (length <= lastIndex) {
                }
                queue = 0;
                while (queue < length) {
                    if (Long.compare(l2, lastId) == 0) {
                        break loop_37;
                    } else {
                    }
                    if (lastIndex++ == length) {
                    }
                    queue++;
                    lastIndex = 0;
                }
                obj2.lastIndex = lastIndex;
                obj2.lastId = obj3.id;
                i11 = lastIndex;
                i2 = 0;
                andGet2 = 0;
                while (andGet2 < length) {
                    Object obj4 = obj[i11];
                    i10 = 0;
                    while (b()) {
                        queue3 = obj4.queue;
                        i9 = i10;
                        i5 = i7;
                        while (Long.compare(andGet, i7) != 0) {
                            Object poll2 = queue3.poll();
                            downstream.onNext(poll2);
                            i6 = 1;
                            andGet -= i6;
                            i5 += i6;
                            i9 = poll2;
                            i7 = 0;
                        }
                        if (Long.compare(i5, i7) != 0) {
                        } else {
                        }
                        length = i7;
                        length = i;
                        i10 = i9;
                        i7 = 0;
                        if (i4 == 0) {
                        } else {
                        }
                        andGet = Long.MAX_VALUE;
                        obj4.a(i5);
                        length = 0;
                        andGet = obj2.requested.addAndGet(-i5);
                        poll2 = queue3.poll();
                        downstream.onNext(poll2);
                        i6 = 1;
                        andGet -= i6;
                        i5 += i6;
                        i9 = poll2;
                        i7 = 0;
                        i9 = poll2;
                        i7 = 0;
                    }
                    queue3 = obj4.queue;
                    i9 = i10;
                    i5 = i7;
                    while (Long.compare(andGet, i7) != 0) {
                        poll2 = queue3.poll();
                        downstream.onNext(poll2);
                        i6 = 1;
                        andGet -= i6;
                        i5 += i6;
                        i9 = poll2;
                        i7 = 0;
                    }
                    if (Long.compare(i5, i7) != 0) {
                    } else {
                    }
                    length = i7;
                    queue2 = obj4.queue;
                    i13 = 1;
                    if (i11++ == i) {
                    }
                    queue = 1;
                    andGet2 += queue;
                    length = i;
                    i7 = 0;
                    i11 = 0;
                    obj2.k(obj4);
                    i12 += i13;
                    i2 = 1;
                    length = i;
                    i10 = i9;
                    i7 = 0;
                    if (i4 == 0) {
                    } else {
                    }
                    andGet = Long.MAX_VALUE;
                    obj4.a(i5);
                    length = 0;
                    andGet = obj2.requested.addAndGet(-i5);
                    poll2 = queue3.poll();
                    downstream.onNext(poll2);
                    i6 = 1;
                    andGet -= i6;
                    i5 += i6;
                    i9 = poll2;
                    i7 = 0;
                    i9 = poll2;
                    i7 = 0;
                    i = length;
                    poll = cancelled;
                    a.b(poll);
                    aVar.dispose();
                    cancelled = obj1.errs;
                    cancelled.a(poll);
                    cancelled = obj1.delayErrors;
                    if (cancelled == null) {
                    }
                    cancelled = obj1.upstream;
                    cancelled.cancel();
                    cancelled = b();
                    obj1.k(aVar);
                    cancelled = 1;
                    aVar = 1;
                    poll = 1;
                }
                aVar = 1;
                poll = i2;
                obj2.lastIndex = i11;
                obj2.lastId = empty2.id;
                i15 = i12;
                i3 = 0;
                obj4 = obj[i11];
                i10 = 0;
                while (b()) {
                    queue3 = obj4.queue;
                    i9 = i10;
                    i5 = i7;
                    while (Long.compare(andGet, i7) != 0) {
                        poll2 = queue3.poll();
                        downstream.onNext(poll2);
                        i6 = 1;
                        andGet -= i6;
                        i5 += i6;
                        i9 = poll2;
                        i7 = 0;
                    }
                    if (Long.compare(i5, i7) != 0) {
                    } else {
                    }
                    length = i7;
                    length = i;
                    i10 = i9;
                    i7 = 0;
                    if (i4 == 0) {
                    } else {
                    }
                    andGet = Long.MAX_VALUE;
                    obj4.a(i5);
                    length = 0;
                    andGet = obj2.requested.addAndGet(-i5);
                    poll2 = queue3.poll();
                    downstream.onNext(poll2);
                    i6 = 1;
                    andGet -= i6;
                    i5 += i6;
                    i9 = poll2;
                    i7 = 0;
                    i9 = poll2;
                    i7 = 0;
                }
                queue3 = obj4.queue;
                i9 = i10;
                i5 = i7;
                while (Long.compare(andGet, i7) != 0) {
                    poll2 = queue3.poll();
                    downstream.onNext(poll2);
                    i6 = 1;
                    andGet -= i6;
                    i5 += i6;
                    i9 = poll2;
                    i7 = 0;
                }
                if (Long.compare(i5, i7) != 0) {
                } else {
                }
                length = i7;
                queue2 = obj4.queue;
                i13 = 1;
                if (i11++ == i) {
                }
                queue = 1;
                andGet2 += queue;
                length = i;
                i7 = 0;
                i11 = 0;
                poll = i2;
                aVar = 1;
                obj2.k(obj4);
                i12 += i13;
                i2 = 1;
                length = i;
                i10 = i9;
                i7 = 0;
                if (i4 == 0) {
                } else {
                }
                andGet = Long.MAX_VALUE;
                obj4.a(i5);
                length = 0;
                andGet = obj2.requested.addAndGet(-i5);
                poll2 = queue3.poll();
                downstream.onNext(poll2);
                i6 = 1;
                andGet -= i6;
                i5 += i6;
                i9 = poll2;
                i7 = 0;
                i9 = poll2;
                i7 = 0;
                i = length;
                if (Long.compare(l2, lastId) == 0) {
                } else {
                }
                if (lastIndex++ == length) {
                }
                queue++;
                lastIndex = 0;
                lastIndex = 0;
                if (Long.compare(queue2, lastId) != 0 && length <= lastIndex) {
                }
                while (/* condition */) {
                    while (Long.compare(andGet, i7) != 0) {
                        poll = queue4.poll();
                        downstream.onNext(poll);
                        i12 += queue3;
                        i8 += queue3;
                        andGet -= queue3;
                        i16 = poll;
                    }
                    if (Long.compare(i8, i7) != 0) {
                    }
                    cmp3 = Long.MAX_VALUE;
                    i8 = i7;
                    i16 = 0;
                    if (i4 != 0) {
                    } else {
                    }
                    andGet = obj2.requested.addAndGet(-i8);
                    andGet = Long.MAX_VALUE;
                    poll = queue4.poll();
                    downstream.onNext(poll);
                    i12 += queue3;
                    i8 += queue3;
                    andGet -= queue3;
                    i16 = poll;
                    i16 = poll;
                }
                while (Long.compare(andGet, i7) != 0) {
                    poll = queue4.poll();
                    downstream.onNext(poll);
                    i12 += queue3;
                    i8 += queue3;
                    andGet -= queue3;
                    i16 = poll;
                }
                if (Long.compare(i8, i7) != 0) {
                }
                cmp3 = Long.MAX_VALUE;
                if (i4 != 0) {
                } else {
                }
                andGet = obj2.requested.addAndGet(-i8);
                andGet = Long.MAX_VALUE;
                poll = queue4.poll();
                downstream.onNext(poll);
                i12 += queue3;
                i8 += queue3;
                andGet -= queue3;
                i16 = poll;
                i16 = poll;
                i4 = 1;
                poll = cancelled;
                a.b(poll);
                aVar.dispose();
                cancelled = obj1.errs;
                cancelled.a(poll);
                cancelled = obj1.delayErrors;
                if (cancelled == null) {
                }
                cancelled = obj1.upstream;
                cancelled.cancel();
                cancelled = b();
                obj1.k(aVar);
                cancelled = 1;
                aVar = 1;
                poll = 1;
            }
        }

        j<U> h(i.b.m0.e.b.k.a<T, U> k$a) {
            j bVar;
            int bufferSize;
            if (a.queue == null) {
                bVar = new b(this.bufferSize);
                a.queue = bVar;
            }
            return bVar;
        }

        j<U> i() {
            Object bVar;
            int maxConcurrency;
            if (this.queue == null) {
                if (this.maxConcurrency == Integer.MAX_VALUE) {
                    bVar = new c(this.bufferSize);
                } else {
                    bVar = new b(this.maxConcurrency);
                }
                this.queue = bVar;
            }
            return bVar;
        }

        void j(i.b.m0.e.b.k.a<T, U> k$a, Throwable throwable2) {
            boolean z;
            Object obj;
            Object obj3;
            Throwable obj4;
            if (this.errs.a(throwable2)) {
                a.done = true;
                if (!this.delayErrors) {
                    this.upstream.cancel();
                    obj3 = this.subscribers.getAndSet(k.b.b);
                    z = 0;
                    while (z < obj3.length) {
                        (k.a[])obj3[z].dispose();
                        z++;
                    }
                }
                f();
            } else {
                a.t(throwable2);
            }
        }

        void k(i.b.m0.e.b.k.a<T, U> k$a) {
            i.b.m0.e.b.k.a[] objArr;
            int i3;
            int i;
            int i2;
            Object arr;
            Object obj = this.subscribers.get();
            int length = obj.length;
            while (length == 0) {
                i3 = -1;
                i = 0;
                i2 = i;
                while (i2 < length) {
                    if ((k.a[])obj[i2] == a) {
                        break loop_3;
                    } else {
                    }
                    i2++;
                }
                int i6 = 1;
                if (length == i6) {
                } else {
                }
                arr = new k.a[length + -1];
                System.arraycopy(obj, i, arr, i, i3);
                System.arraycopy(obj, i3 + 1, arr, i3, i4 -= i6);
                objArr = arr;
                obj = this.subscribers.get();
                length = obj.length;
                objArr = k.b.a;
                if ((k.a[])obj[i2] == a) {
                } else {
                }
                i2++;
                i3 = i2;
            }
        }

        void l(U u, i.b.m0.e.b.k.a<T, U> k$a2) {
            int compareAndSet;
            j bVar;
            int bufferSize;
            int empty;
            int obj7;
            final String str = "Inner queue full?!";
            if (get() == 0 && compareAndSet(0, 1)) {
                if (compareAndSet(0, 1)) {
                    bufferSize = this.requested.get();
                    bVar = a2.queue;
                    if (Long.compare(bufferSize, i2) != 0) {
                        if (bVar != null) {
                            if (bVar.isEmpty()) {
                                this.downstream.onNext(u);
                                if (Long.compare(bufferSize, l) != 0) {
                                    this.requested.decrementAndGet();
                                }
                                a2.a(1);
                            } else {
                                if (bVar == null) {
                                    bVar = h(a2);
                                }
                                if (!bVar.offer(u)) {
                                    obj7 = new MissingBackpressureException(str);
                                    onError(obj7);
                                }
                            }
                        } else {
                        }
                    } else {
                    }
                    if (decrementAndGet() == 0) {
                    }
                } else {
                    if (a2.queue == null) {
                        bVar = new b(this.bufferSize);
                        a2.queue = bVar;
                    }
                    if (!bVar.offer(u)) {
                        obj7 = new MissingBackpressureException(str);
                        onError(obj7);
                    }
                    if (getAndIncrement() != 0) {
                    }
                }
            } else {
            }
            g();
        }

        void m(U u) {
            int i2;
            String scalarLimit;
            int i;
            boolean compareAndSet;
            j queue;
            int empty;
            int obj9;
            scalarLimit = "Scalar queue full?!";
            i2 = 0;
            i = 1;
            if (get() == 0 && compareAndSet(i2, i)) {
                i2 = 0;
                i = 1;
                if (compareAndSet(i2, i)) {
                    compareAndSet = this.requested.get();
                    queue = this.queue;
                    if (Long.compare(compareAndSet, i3) != 0) {
                        if (queue != null) {
                            if (queue.isEmpty()) {
                                this.downstream.onNext(u);
                                if (Long.compare(compareAndSet, queue) != 0) {
                                    this.requested.decrementAndGet();
                                }
                                obj9 += i;
                                this.scalarEmitted = obj9;
                                scalarLimit = this.scalarLimit;
                                if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled && obj9 == scalarLimit) {
                                    if (!this.cancelled) {
                                        obj9 += i;
                                        this.scalarEmitted = obj9;
                                        scalarLimit = this.scalarLimit;
                                        if (obj9 == scalarLimit) {
                                            this.scalarEmitted = i2;
                                            this.upstream.request((long)scalarLimit);
                                        }
                                    }
                                }
                            } else {
                                if (queue == null) {
                                    queue = i();
                                }
                                if (!queue.offer(u)) {
                                    obj9 = new IllegalStateException(scalarLimit);
                                    onError(obj9);
                                }
                            }
                        } else {
                        }
                    } else {
                    }
                    if (decrementAndGet() == 0) {
                    }
                } else {
                    if (!i().offer(u)) {
                        obj9 = new IllegalStateException(scalarLimit);
                        onError(obj9);
                    }
                    if (getAndIncrement() != 0) {
                    }
                }
            } else {
            }
            g();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            if (this.done) {
            }
            this.done = true;
            f();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable throwable) {
            boolean length;
            int i;
            Object obj;
            boolean obj4;
            if (this.done) {
                a.t(throwable);
            }
            if (this.errs.a(throwable)) {
                this.done = true;
                if (!this.delayErrors) {
                    obj4 = this.subscribers.getAndSet(k.b.b);
                    i = 0;
                    while (i < obj4.length) {
                        (k.a[])obj4[i].dispose();
                        i++;
                    }
                }
                f();
            } else {
                a.t(throwable);
            }
        }

        public void onNext(T t) {
            int scalarLimit;
            boolean z;
            int i;
            int obj6;
            if (this.done) {
            }
            obj6 = this.mapper.apply(t);
            b.e(obj6, "The mapper returned a null Publisher");
            if (obj6 instanceof Callable) {
                obj6 = (Callable)(a)obj6.call();
                if (obj6 != null) {
                    m(obj6);
                } else {
                    try {
                        obj6++;
                        this.scalarEmitted = obj6;
                        scalarLimit = this.scalarLimit;
                        if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled && obj6 == scalarLimit) {
                        }
                        if (!this.cancelled) {
                        }
                        obj6++;
                        this.scalarEmitted = obj6;
                        scalarLimit = this.scalarLimit;
                        if (obj6 == scalarLimit) {
                        }
                        this.scalarEmitted = 0;
                        this.upstream.request((long)scalarLimit);
                        a.b(t);
                        c upstream = this.errs;
                        upstream.a(t);
                        f();
                        long uniqueId = this.uniqueId;
                        this.uniqueId = i2 += uniqueId;
                        scalarLimit = new k.a(this, uniqueId, obj2);
                        if (a(scalarLimit)) {
                        }
                        obj6.a(scalarLimit);
                        a.b(t);
                        upstream = this.upstream;
                        upstream.cancel();
                        onError(t);
                    } catch (Throwable th) {
                    }
                }
            } else {
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(c c) {
            boolean cancelled;
            int i;
            this.upstream = c;
            this.downstream.onSubscribe(this);
            if (g.validate(this.upstream, c) && !this.cancelled) {
                this.upstream = c;
                this.downstream.onSubscribe(this);
                if (!this.cancelled) {
                    int maxConcurrency = this.maxConcurrency;
                    i = Integer.MAX_VALUE;
                    if (maxConcurrency == i) {
                        c.request(Long.MAX_VALUE);
                    } else {
                        c.request((long)maxConcurrency);
                    }
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void request(long l) {
            boolean requested;
            if (g.validate(l)) {
                d.a(this.requested, l);
                f();
            }
        }
    }
    public k(h<T> h, n<? super T, ? extends a<? extends U>> n2, boolean z3, int i4, int i5) {
        super(h);
        this.c = n2;
        this.v = z3;
        this.w = i4;
        this.x = i5;
    }

    public static <T, U> k<T> g0(b<? super U> b, n<? super T, ? extends a<? extends U>> n2, boolean z3, int i4, int i5) {
        super(b, n2, z3, i4, i5);
        return bVar3;
    }

    protected void c0(b<? super U> b) {
        if (i0.b(this.b, b, this.c)) {
        }
        this.b.b0(k.g0(b, this.c, this.v, this.w, this.x));
    }
}
