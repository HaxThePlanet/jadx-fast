package i.b.m0.e.b;

import i.b.h;
import i.b.m0.c.j;
import i.b.m0.i.g;
import i.b.m0.j.d;
import i.b.m0.j.n;
import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import m.c.c;

/* compiled from: FlowablePublish.java */
/* loaded from: classes3.dex */
public final class b0<T> extends i.b.k0.a<T> {

    final h<T> b;
    final AtomicReference<b0.c<T>> c;
    final int v;
    final m.c.a<T> w;

    static final class a<T> implements m.c.a<T> {

        private final AtomicReference<b0.c<T>> a;
        private final int b;
        a(AtomicReference<b0.c<T>> atomicReference, int i) {
            super();
            this.a = atomicReference;
            this.b = i;
        }

        public void a(m.c.b<? super T> bVar) {
            i.b.m0.e.b.b0.c cVar;
            AtomicReference atomicReference;
            int i;
            boolean compareAndSet;
            final i.b.m0.e.b.b0.b bVar2 = new b0.b(bVar);
            bVar.onSubscribe(bVar2);
            Object obj = this.a.get();
            do {
                obj = this.a.get();
                cVar = new b0.c(this.a, this.b);
            } while (obj != null);
            long l = bVar2.get();
            if (l == -9223372036854775808L) {
                compareAndSet.e(bVar2);
            } else {
                bVar2.parent = compareAndSet;
            }
            compareAndSet.d();
        }
    }

    static final class b<T> extends AtomicLong implements c {

        private static final long serialVersionUID = -4453897557930727610L;
        final m.c.b<? super T> child;
        long emitted;
        volatile b0.c<T> parent;
        b(m.c.b<? super T> bVar) {
            super();
            this.child = bVar;
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void cancel() {
            long l = get();
            final long l2 = Long.MIN_VALUE;
            if (l != Long.MIN_VALUE) {
                long andSet = getAndSet(Long.MIN_VALUE);
                if (andSet != Long.MIN_VALUE && this.parent != null) {
                    this.parent.e(this);
                    this.parent.d();
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void request(long j) {
            if (g.validate(j)) {
                d.b(this, j);
                if (this.parent != null) {
                    this.parent.d();
                }
            }
        }
    }

    static final class c<T> extends AtomicInteger implements i.b.k<T>, i.b.j0.b {

        static final b0.b[] a;
        static final b0.b[] b;
        private static final long serialVersionUID = -202316842419149694L;
        final int bufferSize;
        final AtomicReference<b0.c<T>> current;
        volatile j<T> queue;
        final AtomicBoolean shouldConnect = new AtomicBoolean();
        int sourceMode;
        final AtomicReference<b0.b<T>[]> subscribers = new AtomicReference<>();
        volatile Object terminalEvent;
        final AtomicReference<c> upstream = new AtomicReference<>();
        static {
            int i = 0;
            b0.c.a = new b0.b[i];
            b0.c.b = new b0.b[i];
        }

        c(AtomicReference<b0.c<T>> atomicReference, int i) {
            super();
            AtomicReference atomicReference2 = new AtomicReference();
            AtomicReference atomicReference3 = new AtomicReference(b0.c.a);
            this.current = atomicReference;
            final AtomicBoolean atomicBoolean = new AtomicBoolean();
            this.bufferSize = i;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        boolean a(b0.b<T> bVar) {
            Object obj = this.subscribers.get();
            final int i = 0;
            while (obj == b0.c.b) {
                int length = obj.length;
                i.b.m0.e.b.b0.b[] arr = new b0.b[length + 1];
                System.arraycopy(obj, i, arr, i, length);
                arr[length] = bVar;
                if (this.subscribers.compareAndSet(obj, arr)) {
                    return true;
                }
                obj = this.subscribers.get();
                i = 0;
            }
            return false;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        boolean b(Object object, boolean z) {
            int i = 0;
            Object obj = null;
            i = 0;
            if (object != null) {
                obj = null;
                int i2 = 1;
                if (n.isComplete(object)) {
                    if (z) {
                        this.current.compareAndSet(this, obj);
                        Object andSet = this.subscribers.getAndSet(b0.c.b);
                        for (Object obj2 : andSet) {
                            obj2.child.onComplete();
                        }
                        return true;
                    }
                } else {
                    Throwable error = n.getError(object);
                    this.current.compareAndSet(this, obj);
                    Object andSet2 = this.subscribers.getAndSet(b0.c.b);
                    length = andSet2.length;
                    if (andSet2.length != 0) {
                        length = andSet2.length;
                        for (Object obj3 : andSet2) {
                            obj3.child.onError(error);
                        }
                    } else {
                        a.t(error);
                    }
                }
                return true;
            }
            return false;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void d() {
            Object terminalEvent2;
            Object terminalEvent22;
            int cmp2;
            int andGet = 1;
            Object cmp;
            j queue2;
            boolean z2;
            Object poll;
            boolean length2;
            Object poll2;
            long l = 1;
            long l2;
            int i;
            long l3;
            int i2 = 0;
            int i3;
            long min;
            long l4 = -9223372036854775808L;
            long l5;
            long l6 = 9223372036854775807L;
            int cmp3;
            final Object obj4 = this;
            if (getAndIncrement() != 0) {
                return;
            }
            andGet = 1;
            while (obj4.queue != null) {
                length = cmp.length;
                i2 = 0;
                i3 = 0;
                min = Long.MAX_VALUE;
                l4 = Long.MIN_VALUE;
                for (boolean z2 : cmp) {
                    l5 = z2.get();
                }
                z2 = cmp[i2];
                l5 = z2.get();
                i2 = i2 + 1;
                l = 1L;
                try {
                    poll = obj4.queue.poll();
                } catch (Throwable th) {
                    Throwable error = th;
                    a.b(error);
                    th = obj3.upstream.get();
                    th.cancel();
                    th = n.error(error);
                    obj3.terminalEvent = th;
                    error = null;
                }
                error = th;
                a.b(error);
                th = th.get();
                th.cancel();
                th = n.error(error);
                obj3.terminalEvent = th;
                int i6 = poll == null ? andGet : 0;
                if (obj4.b(obj4.terminalEvent, (poll == null ? andGet : 0))) {
                    return;
                }
                i = 0;
                l3 = (long)i;
                while (l3 < min) {
                    try {
                        poll2 = queue2.poll();
                    } catch (Throwable th) {
                        error = th;
                        a.b(error);
                        th = th.get();
                        th.cancel();
                        th = n.error(error);
                        obj3.terminalEvent = th;
                        error = null;
                    }
                    i6 = poll2 == null ? andGet : 0;
                    length2 = cmp.length;
                    i2 = 0;
                    i3 = 0;
                    for (Object obj : cmp) {
                        long l11 = obj.get();
                        andGet = 1;
                    }
                    Object obj = cmp[i2];
                    l11 = obj.get();
                    i2 = i2 + 1;
                    andGet = 1;
                    l6 = Long.MAX_VALUE;
                    i = i + 1;
                    cmp = obj4.subscribers.get();
                }
                try {
                    poll2 = queue2.poll();
                } catch (Throwable th) {
                    error = th;
                    a.b(error);
                    th = th.get();
                    th.cancel();
                    th = n.error(error);
                    obj3.terminalEvent = th;
                    error = null;
                }
                i6 = poll2 == null ? andGet : 0;
                length2 = (poll2 == null ? andGet : 0);
                length2 = cmp.length;
                i2 = 0;
                i3 = 0;
                for (Object obj : cmp) {
                    l11 = obj.get();
                    andGet = 1;
                }
                obj = cmp[i2];
                l11 = obj.get();
                i2 = i2 + 1;
                andGet = 1;
                l6 = Long.MAX_VALUE;
                i = i + 1;
                cmp = obj4.subscribers.get();
                if (i3 != 0 || cmp != cmp) {
                }
                long l9 = 0L;
                if (min != l9 && !length2) {
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            objArr = b0.c.b;
            if (this.subscribers.get() != b0.c.b) {
                if ((b0.b[])this.subscribers.getAndSet(b0.c.b) != b0.c.b) {
                    this.current.compareAndSet(this, null);
                    g.cancel(this.upstream);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void e(b0.b<T> bVar) {
            i.b.m0.e.b.b0.b[] arr;
            int i = -1;
            boolean equals;
            Object obj = this.subscribers.get();
            int length = obj.length;
            while (length == 0) {
                i = -1;
                i = 0;
                for (Object obj2 : obj) {
                    if (obj2.equals(bVar)) {
                        break loop_3;
                    }
                }
                int i2 = 1;
                if (this.subscribers.compareAndSet(obj, arr)) {
                    return;
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            boolean z = true;
            int r0 = this.subscribers.get() == b0.c.b ? 1 : 0;
            return (this.subscribers.get() == b0.c.b ? 1 : 0);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            if (this.terminalEvent == null) {
                this.terminalEvent = n.complete();
                d();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable th) {
            if (this.terminalEvent == null) {
                this.terminalEvent = n.error(th);
                d();
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onNext(T t) {
            if (this.sourceMode == 0) {
                if (!this.queue.offer(t)) {
                    onError(new MissingBackpressureException("Prefetch queue is full?!"));
                    return;
                }
            }
            d();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(c cVar) {
            int i = 2;
            if (g.setOnce(this.upstream, cVar)) {
                z = cVar instanceof g;
                if (cVar instanceof g) {
                    c cVar2 = cVar;
                    int requestFusion = cVar2.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = cVar2;
                        this.terminalEvent = n.complete();
                        d();
                        return;
                    }
                    i = 2;
                    if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = cVar2;
                        cVar.request((long)this.bufferSize);
                        return;
                    }
                }
                this.queue = new b(bufferSize2);
                cVar.request((long)this.bufferSize);
            }
        }
    }
    private b0(m.c.a<T> aVar, h<T> hVar, AtomicReference<b0.c<T>> atomicReference, int i) {
        super();
        this.w = aVar;
        this.b = hVar;
        this.c = atomicReference;
        this.v = i;
    }

    public static <T> i.b.k0.a<T> i0(h<T> hVar, int i) {
        final AtomicReference atomicReference = new AtomicReference();
        return a.p(new b0(new b0.a(atomicReference, i), hVar, atomicReference, i));
    }

    @Override // i.b.k0.a
    protected void c0(m.c.b<? super T> bVar) {
        this.w.a(bVar);
    }

    @Override // i.b.k0.a
    public void h0(i.b.l0.f<? super i.b.j0.b> fVar) {
        i.b.m0.e.b.b0.c cVar;
        boolean compareAndSet;
        boolean z = true;
        Object obj = this.c.get();
        while (obj != null) {
            cVar = new b0.c(this.c, this.v);
            if (this.c.compareAndSet(obj, cVar)) {
                break;
            }
        }
        z = true;
        z = false;
        if (!cVar.shouldConnect.get()) {
            if (!(cVar.shouldConnect.compareAndSet(z, true))) {
            }
        }
        try {
            fVar.accept(cVar);
        } finally {
            a.b(fVar);
            fVar = k.e(fVar);
            throw fVar;
        }
        if (this.c) {
            this.b.b0(cVar);
        }
    }
}
