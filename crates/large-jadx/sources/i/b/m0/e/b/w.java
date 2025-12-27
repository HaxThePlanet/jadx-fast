package i.b.m0.e.b;

import i.b.h;
import i.b.k;
import i.b.m0.c.f;
import i.b.m0.c.j;
import i.b.m0.i.g;
import i.b.m0.j.d;
import i.b.z;
import i.b.z.c;
import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import m.c.c;

/* compiled from: FlowableObserveOn.java */
/* loaded from: classes3.dex */
public final class w<T> extends a<T, T> {

    final z c;
    final boolean v;
    final int w;

    static abstract class a<T> extends i.b.m0.i.a<T> implements k<T>, Runnable {

        private static final long serialVersionUID = -8241002408341274697L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final int limit;
        boolean outputFused;
        final int prefetch;
        long produced;
        j<T> queue;
        final AtomicLong requested = new AtomicLong();
        int sourceMode;
        c upstream;
        final z.c worker;
        a(z.c cVar, boolean z, int i) {
            super();
            this.worker = cVar;
            this.delayError = z;
            this.prefetch = i;
            AtomicLong atomicLong = new AtomicLong();
            this.limit = i - (i >> 2);
        }

        @Override // i.b.m0.i.a
        final boolean a(boolean z, boolean z2, m.c.b<?> bVar) {
            final boolean z3 = true;
            if (this.cancelled) {
                clear();
                return true;
            }
            if (this.delayError != null && this.delayError != null && z2) {
                this.cancelled = z3;
                if (this.error != null) {
                    bVar.onError(this.error);
                } else {
                    bVar.onComplete();
                }
                this.worker.dispose();
                return true;
            }
            return false;
        }

        @Override // i.b.m0.i.a
        public final void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            this.worker.dispose();
            if (!this.outputFused && this.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // i.b.m0.i.a
        public final void clear() {
            this.queue.clear();
        }

        @Override // i.b.m0.i.a
        final void f() {
            if (getAndIncrement() != 0) {
                return;
            }
            this.worker.b(this);
        }

        @Override // i.b.m0.i.a
        public final boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // i.b.m0.i.a
        public final void onComplete() {
            if (!this.done) {
                boolean done2 = true;
                this.done = done2;
                f();
            }
        }

        @Override // i.b.m0.i.a
        public final void onError(Throwable th) {
            if (this.done) {
                a.t(th);
                return;
            }
            this.error = th;
            this.done = true;
            f();
        }

        @Override // i.b.m0.i.a
        public final void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.sourceMode == 2) {
                f();
                return;
            }
            if (!this.queue.offer(t)) {
                this.upstream.cancel();
                this.error = new MissingBackpressureException("Queue is full?!");
                boolean offer = true;
                this.done = offer;
            }
            f();
        }

        @Override // i.b.m0.i.a
        public final void request(long j) {
            if (g.validate(j)) {
                d.a(this.requested, j);
                f();
            }
        }

        @Override // i.b.m0.i.a
        public final int requestFusion(int i) {
            final int i2 = 2;
            if (i & i2 != 0) {
                this.outputFused = true;
                return i2;
            }
            return 0;
        }

        @Override // i.b.m0.i.a
        public final void run() {
            if (this.outputFused) {
                d();
            } else {
                int i = 1;
                if (this.sourceMode == 1) {
                    e();
                } else {
                    b();
                }
            }
        }

        @Override // i.b.m0.i.a
        abstract void b();

        @Override // i.b.m0.i.a
        abstract void d();

        @Override // i.b.m0.i.a
        abstract void e();
    }

    static final class b<T> extends w.a<T> {

        private static final long serialVersionUID = 644624475404284533L;
        long consumed;
        final i.b.m0.c.a<? super T> downstream;
        b(i.b.m0.c.a<? super T> aVar, z.c cVar, boolean z, int i) {
            super(cVar, z, i);
            this.downstream = aVar;
        }

        @Override // i.b.m0.e.b.w$a
        void b() {
            long produced2;
            long consumed2;
            int andGet;
            boolean empty;
            int cmp;
            boolean z;
            Object poll;
            boolean z2;
            andGet = 1;
            while (/* condition */) {
                while (this.produced != l) {
                    try {
                        poll = this.queue.poll();
                    } catch (Throwable th) {
                        a.b(th);
                        this.cancelled = z3;
                        this.upstream.cancel();
                        obj.clear();
                        worker2.onError(th);
                        this.worker.dispose();
                        return;
                    }
                    int r13 = poll == null ? andGet : 0;
                }
                andGet = get();
                if (andGet == andGet) {
                    this.produced = produced2;
                    this.consumed = consumed2;
                }
                try {
                    poll = this.queue.poll();
                } catch (Throwable th) {
                    a.b(th);
                    this.cancelled = z3;
                    this.upstream.cancel();
                    obj.clear();
                    this.worker.onError(th);
                    this.worker.dispose();
                    return;
                }
                r13 = poll == null ? andGet : 0;
            }
        }

        @Override // i.b.m0.e.b.w$a
        void d() {
            int andGet;
            boolean z = true;
            andGet = z;
            while (this.cancelled) {
                Object obj = null;
                this.downstream.onNext(obj);
                if (addAndGet(-andGet) == 0) {
                    return;
                }
            }
        }

        @Override // i.b.m0.e.b.w$a
        void e() {
            long produced2;
            int andGet;
            int cmp;
            boolean cancelled2;
            final boolean z3 = true;
            andGet = z3;
            while (/* condition */) {
                while (this.produced != l) {
                    try {
                        Object poll = this.queue.poll();
                    } catch (Throwable th) {
                        a.b(th);
                        this.cancelled = z2;
                        this.upstream.cancel();
                        worker2.onError(th);
                        this.worker.dispose();
                        return;
                    }
                    if (poll == null) {
                        this.cancelled = z3;
                        this.downstream.onComplete();
                        this.worker.dispose();
                        return;
                    }
                }
                andGet = get();
                if (andGet == andGet) {
                    this.produced = produced2;
                }
                try {
                    poll = this.queue.poll();
                } catch (Throwable th) {
                    a.b(th);
                    this.cancelled = z2;
                    this.upstream.cancel();
                    this.worker.onError(th);
                    this.worker.dispose();
                    return;
                }
                if (poll == null) {
                    this.cancelled = z3;
                    this.downstream.onComplete();
                    this.worker.dispose();
                    return;
                }
            }
        }

        @Override // i.b.m0.e.b.w$a
        public void onSubscribe(c cVar) {
            int i = 2;
            if (g.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                z = cVar instanceof g;
                if (cVar instanceof g) {
                    c cVar2 = cVar;
                    int requestFusion = cVar2.requestFusion(7);
                    int i3 = 1;
                    if (requestFusion == i3) {
                        this.sourceMode = i3;
                        this.queue = cVar2;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                    i = 2;
                    if (requestFusion == i) {
                        this.sourceMode = i;
                        this.queue = cVar2;
                        this.downstream.onSubscribe(this);
                        cVar.request((long)this.prefetch);
                        return;
                    }
                }
                this.queue = new b(prefetch2);
                this.downstream.onSubscribe(this);
                cVar.request((long)this.prefetch);
            }
        }

        @Override // i.b.m0.e.b.w$a
        public T poll() {
            Object poll = this.queue.poll();
            if (poll != null) {
                int i = 1;
                if (this.sourceMode != i) {
                    long l2 = (long)this.limit;
                    if (this.sourceMode == this.limit) {
                        this.consumed = 0L;
                        this.upstream.request(l);
                    } else {
                        this.consumed++;
                    }
                }
            }
            return poll;
        }
    }

    static final class c<T> extends w.a<T> implements k<T> {

        private static final long serialVersionUID = -4547113800637756442L;
        final m.c.b<? super T> downstream;
        c(m.c.b<? super T> bVar, z.c cVar, boolean z, int i) {
            super(cVar, z, i);
            this.downstream = bVar;
        }

        @Override // i.b.m0.e.b.w$a
        void b() {
            long produced2;
            int andGet;
            long andGet2;
            boolean empty;
            int i;
            int cmp;
            boolean z;
            Object poll;
            boolean z2;
            andGet = 1;
            while (/* condition */) {
                while (this.produced != andGet2) {
                    try {
                        poll = this.queue.poll();
                    } catch (Throwable th) {
                        a.b(th);
                        this.cancelled = z3;
                        this.upstream.cancel();
                        obj.clear();
                        worker2.onError(th);
                        this.worker.dispose();
                        return;
                    }
                    int r11 = poll == null ? andGet : 0;
                }
                andGet = get();
                if (andGet == andGet) {
                    this.produced = produced2;
                }
                try {
                    poll = this.queue.poll();
                } catch (Throwable th) {
                    a.b(th);
                    this.cancelled = z3;
                    this.upstream.cancel();
                    obj.clear();
                    this.worker.onError(th);
                    this.worker.dispose();
                    return;
                }
                r11 = poll == null ? andGet : 0;
            }
        }

        @Override // i.b.m0.e.b.w$a
        void d() {
            int andGet;
            boolean z = true;
            andGet = z;
            while (this.cancelled) {
                Object obj = null;
                this.downstream.onNext(obj);
                if (addAndGet(-andGet) == 0) {
                    return;
                }
            }
        }

        @Override // i.b.m0.e.b.w$a
        void e() {
            long produced2;
            int andGet;
            int cmp;
            boolean cancelled2;
            final boolean z2 = true;
            andGet = z2;
            while (/* condition */) {
                while (this.produced != l) {
                    try {
                        Object poll = this.queue.poll();
                    } catch (Throwable th) {
                        a.b(th);
                        this.cancelled = z;
                        this.upstream.cancel();
                        worker2.onError(th);
                        this.worker.dispose();
                        return;
                    }
                    if (poll == null) {
                        this.cancelled = z2;
                        this.downstream.onComplete();
                        this.worker.dispose();
                        return;
                    }
                }
                andGet = get();
                if (andGet == andGet) {
                    this.produced = produced2;
                }
                try {
                    poll = this.queue.poll();
                } catch (Throwable th) {
                    a.b(th);
                    this.cancelled = z;
                    this.upstream.cancel();
                    this.worker.onError(th);
                    this.worker.dispose();
                    return;
                }
                if (poll == null) {
                    this.cancelled = z2;
                    this.downstream.onComplete();
                    this.worker.dispose();
                    return;
                }
            }
        }

        @Override // i.b.m0.e.b.w$a
        public void onSubscribe(c cVar) {
            int i = 2;
            if (g.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                z = cVar instanceof g;
                if (cVar instanceof g) {
                    c cVar2 = cVar;
                    int requestFusion = cVar2.requestFusion(7);
                    int i3 = 1;
                    if (requestFusion == i3) {
                        this.sourceMode = i3;
                        this.queue = cVar2;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                    i = 2;
                    if (requestFusion == i) {
                        this.sourceMode = i;
                        this.queue = cVar2;
                        this.downstream.onSubscribe(this);
                        cVar.request((long)this.prefetch);
                        return;
                    }
                }
                this.queue = new b(prefetch2);
                this.downstream.onSubscribe(this);
                cVar.request((long)this.prefetch);
            }
        }

        @Override // i.b.m0.e.b.w$a
        public T poll() {
            Object poll = this.queue.poll();
            if (poll != null) {
                int i = 1;
                if (this.sourceMode != i) {
                    long l2 = (long)this.limit;
                    if (this.produced == this.limit) {
                        this.produced = 0L;
                        this.upstream.request(l);
                    } else {
                        this.produced++;
                    }
                }
            }
            return poll;
        }
    }
    public w(h<T> hVar, z zVar, boolean z, int i) {
        super(hVar);
        this.c = zVar;
        this.v = z;
        this.w = i;
    }

    @Override // i.b.m0.e.b.a
    public void c0(m.c.b<? super T> bVar) {
        z.c cVar = this.c.a();
        if (bVar instanceof a) {
            this.b.b0(new w.b(bVar, cVar, this.v, this.w));
        } else {
            this.b.b0(new w.c(bVar, cVar, this.v, this.w));
        }
    }
}
