package i.b.m0.e.b;

import i.b.h;
import i.b.j0.b;
import i.b.k;
import i.b.m0.c.a;
import i.b.m0.c.f;
import i.b.m0.c.j;
import i.b.m0.f.b;
import i.b.m0.i.a;
import i.b.m0.i.g;
import i.b.m0.j.d;
import i.b.p0.a;
import i.b.z;
import i.b.z.c;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import m.c.b;
import m.c.c;

/* loaded from: classes3.dex */
public final class w<T>  extends i.b.m0.e.b.a<T, T> {

    final z c;
    final boolean v;
    final int w;

    static abstract class a extends a<T> implements k<T>, Runnable {

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
        final AtomicLong requested;
        int sourceMode;
        c upstream;
        final z.c worker;
        a(z.c z$c, boolean z2, int i3) {
            super();
            this.worker = c;
            this.delayError = z2;
            this.prefetch = i3;
            AtomicLong obj1 = new AtomicLong();
            this.requested = obj1;
            this.limit = i3 -= obj1;
        }

        final boolean a(boolean z, boolean z2, b<?> b3) {
            Throwable obj3;
            final int i = 1;
            if (this.cancelled) {
                clear();
                return i;
            }
            if (z != null) {
                if (this.delayError != null) {
                    if (z2) {
                        this.cancelled = i;
                        obj3 = this.error;
                        if (obj3 != null) {
                            b3.onError(obj3);
                        } else {
                            b3.onComplete();
                        }
                        this.worker.dispose();
                        return i;
                    }
                } else {
                    obj3 = this.error;
                    if (obj3 != null) {
                        this.cancelled = i;
                        clear();
                        b3.onError(obj3);
                        this.worker.dispose();
                        return i;
                    }
                    if (z2) {
                        this.cancelled = i;
                        b3.onComplete();
                        this.worker.dispose();
                        return i;
                    }
                }
            }
            return 0;
        }

        @Override // i.b.m0.i.a
        abstract void b();

        @Override // i.b.m0.i.a
        public final void cancel() {
            boolean andIncrement;
            if (this.cancelled) {
            }
            this.cancelled = true;
            this.upstream.cancel();
            this.worker.dispose();
            if (!this.outputFused && getAndIncrement() == 0) {
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        @Override // i.b.m0.i.a
        public final void clear() {
            this.queue.clear();
        }

        @Override // i.b.m0.i.a
        abstract void d();

        @Override // i.b.m0.i.a
        abstract void e();

        @Override // i.b.m0.i.a
        final void f() {
            if (getAndIncrement() != 0) {
            }
            this.worker.b(this);
        }

        @Override // i.b.m0.i.a
        public final boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // i.b.m0.i.a
        public final void onComplete() {
            boolean done;
            if (!this.done) {
                this.done = true;
                f();
            }
        }

        @Override // i.b.m0.i.a
        public final void onError(Throwable throwable) {
            if (this.done) {
                a.t(throwable);
            }
            this.error = throwable;
            this.done = true;
            f();
        }

        public final void onNext(T t) {
            Object queue;
            boolean obj3;
            if (this.done) {
            }
            if (this.sourceMode == 2) {
                f();
            }
            if (!this.queue.offer(t)) {
                this.upstream.cancel();
                obj3 = new MissingBackpressureException("Queue is full?!");
                this.error = obj3;
                this.done = true;
            }
            f();
        }

        @Override // i.b.m0.i.a
        public final void request(long l) {
            boolean requested;
            if (g.validate(l)) {
                d.a(this.requested, l);
                f();
            }
        }

        @Override // i.b.m0.i.a
        public final int requestFusion(int i) {
            final int i2 = 2;
            if (i &= i2 != 0) {
                this.outputFused = true;
                return i2;
            }
            return 0;
        }

        @Override // i.b.m0.i.a
        public final void run() {
            boolean outputFused;
            int i;
            if (this.outputFused) {
                d();
            } else {
                if (this.sourceMode == 1) {
                    e();
                } else {
                    b();
                }
            }
        }
    }

    static final class b extends i.b.m0.e.b.w.a<T> {

        private static final long serialVersionUID = 644624475404284533L;
        long consumed;
        final a<? super T> downstream;
        b(a<? super T> a, z.c z$c2, boolean z3, int i4) {
            super(c2, z3, i4);
            this.downstream = a;
        }

        @Override // i.b.m0.e.b.w$a
        void b() {
            long produced;
            long consumed;
            int andGet;
            int i2;
            long l;
            boolean empty;
            int upstream;
            boolean z;
            Object poll;
            int i;
            final a downstream = this.downstream;
            final j queue = this.queue;
            produced = this.produced;
            consumed = this.consumed;
            final int i3 = 1;
            andGet = i3;
            while (/* condition */) {
                upstream = Long.compare(produced, l);
                while (upstream != null) {
                    poll = queue.poll();
                    if (poll == null) {
                    } else {
                    }
                    i = 0;
                    z = 1;
                    if (downstream.c(poll)) {
                    }
                    consumed += z;
                    if (Long.compare(consumed, l2) == 0) {
                    }
                    upstream = Long.compare(produced, l);
                    this.upstream.request(consumed);
                    consumed = 0L;
                    produced += z;
                    i = i3;
                }
                i2 = get();
                andGet = i2;
                this.produced = produced;
                this.consumed = consumed;
                poll = queue.poll();
                if (poll == null) {
                } else {
                }
                i = 0;
                z = 1;
                if (downstream.c(poll)) {
                }
                consumed += z;
                if (Long.compare(consumed, l2) == 0) {
                }
                this.upstream.request(consumed);
                consumed = 0L;
                produced += z;
                i = i3;
            }
        }

        @Override // i.b.m0.e.b.w$a
        void d() {
            Object downstream;
            int andGet;
            boolean done;
            a downstream2;
            int i;
            int i2 = 1;
            andGet = i2;
            while (this.cancelled) {
                this.downstream.onNext(0);
            }
        }

        @Override // i.b.m0.e.b.w$a
        void e() {
            long produced;
            int andGet;
            int i;
            int cmp;
            boolean cancelled;
            a downstream = this.downstream;
            final j queue = this.queue;
            produced = this.produced;
            final int i2 = 1;
            andGet = i2;
            while (/* condition */) {
                while (Long.compare(produced, l) != 0) {
                    Object poll = queue.poll();
                    if (downstream.c(poll)) {
                    }
                    produced += cmp;
                }
                i = get();
                andGet = i;
                this.produced = produced;
                poll = queue.poll();
                if (downstream.c(poll)) {
                }
                produced += cmp;
            }
        }

        @Override // i.b.m0.e.b.w$a
        public void onSubscribe(c c) {
            boolean validate;
            boolean z;
            int requestFusion;
            int i;
            this.upstream = c;
            z = c;
            requestFusion = (g)z.requestFusion(7);
            int i3 = 1;
            if (g.validate(this.upstream, c) && c instanceof g && requestFusion == i3) {
                this.upstream = c;
                if (c instanceof g) {
                    z = c;
                    requestFusion = (g)z.requestFusion(7);
                    i3 = 1;
                    if (requestFusion == i3) {
                        this.sourceMode = i3;
                        this.queue = z;
                        this.done = i3;
                        this.downstream.onSubscribe(this);
                    }
                    i = 2;
                    if (requestFusion == i) {
                        this.sourceMode = i;
                        this.queue = z;
                        this.downstream.onSubscribe(this);
                        c.request((long)prefetch2);
                    }
                }
                requestFusion = this.prefetch;
                b bVar = new b(requestFusion);
                this.queue = bVar;
                this.downstream.onSubscribe(this);
                c.request((long)prefetch);
            }
        }

        public T poll() {
            int sourceMode;
            int i;
            c upstream;
            Object poll = this.queue.poll();
            i = 1;
            if (poll != null && this.sourceMode != i) {
                i = 1;
                if (this.sourceMode != i) {
                    consumed += i2;
                    if (Long.compare(sourceMode, l) == 0) {
                        this.consumed = 0;
                        this.upstream.request(sourceMode);
                    } else {
                        this.consumed = sourceMode;
                    }
                }
            }
            return poll;
        }
    }

    static final class c extends i.b.m0.e.b.w.a<T> implements k<T> {

        private static final long serialVersionUID = -4547113800637756442L;
        final b<? super T> downstream;
        c(b<? super T> b, z.c z$c2, boolean z3, int i4) {
            super(c2, z3, i4);
            this.downstream = b;
        }

        @Override // i.b.m0.e.b.w$a
        void b() {
            long produced;
            int andGet;
            int i2;
            long andGet2;
            boolean empty;
            int upstream;
            boolean z;
            Object poll;
            int i;
            final b downstream = this.downstream;
            final j queue = this.queue;
            produced = this.produced;
            final int i3 = 1;
            andGet = i3;
            while (/* condition */) {
                upstream = Long.compare(produced, andGet2);
                while (upstream != null) {
                    poll = queue.poll();
                    if (poll == null) {
                    } else {
                    }
                    i = 0;
                    downstream.onNext(poll);
                    produced += i5;
                    int cmp = Long.compare(andGet2, l2);
                    if (Long.compare(produced, l) == 0 && cmp != 0) {
                    }
                    upstream = Long.compare(produced, andGet2);
                    cmp = Long.compare(andGet2, l2);
                    if (cmp != 0) {
                    }
                    this.upstream.request(produced);
                    produced = 0L;
                    andGet2 = this.requested.addAndGet(-produced);
                    i = i3;
                }
                i2 = get();
                andGet = i2;
                andGet2 = this.requested.get();
                this.produced = produced;
                poll = queue.poll();
                if (poll == null) {
                } else {
                }
                i = 0;
                downstream.onNext(poll);
                produced += i5;
                cmp = Long.compare(andGet2, l2);
                if (Long.compare(produced, l) == 0 && cmp != 0) {
                }
                cmp = Long.compare(andGet2, l2);
                if (cmp != 0) {
                }
                this.upstream.request(produced);
                produced = 0L;
                andGet2 = this.requested.addAndGet(-produced);
                i = i3;
            }
        }

        @Override // i.b.m0.e.b.w$a
        void d() {
            Object downstream2;
            int andGet;
            boolean done;
            b downstream;
            int i;
            int i2 = 1;
            andGet = i2;
            while (this.cancelled) {
                this.downstream.onNext(0);
            }
        }

        @Override // i.b.m0.e.b.w$a
        void e() {
            long produced;
            int andGet;
            int i;
            int cmp;
            boolean cancelled;
            b downstream = this.downstream;
            final j queue = this.queue;
            produced = this.produced;
            final int i2 = 1;
            andGet = i2;
            while (/* condition */) {
                while (Long.compare(produced, l) != 0) {
                    Object poll = queue.poll();
                    downstream.onNext(poll);
                    produced += cmp;
                }
                i = get();
                andGet = i;
                this.produced = produced;
                poll = queue.poll();
                downstream.onNext(poll);
                produced += cmp;
            }
        }

        @Override // i.b.m0.e.b.w$a
        public void onSubscribe(c c) {
            boolean validate;
            boolean z;
            int requestFusion;
            int i;
            this.upstream = c;
            z = c;
            requestFusion = (g)z.requestFusion(7);
            int i3 = 1;
            if (g.validate(this.upstream, c) && c instanceof g && requestFusion == i3) {
                this.upstream = c;
                if (c instanceof g) {
                    z = c;
                    requestFusion = (g)z.requestFusion(7);
                    i3 = 1;
                    if (requestFusion == i3) {
                        this.sourceMode = i3;
                        this.queue = z;
                        this.done = i3;
                        this.downstream.onSubscribe(this);
                    }
                    i = 2;
                    if (requestFusion == i) {
                        this.sourceMode = i;
                        this.queue = z;
                        this.downstream.onSubscribe(this);
                        c.request((long)prefetch2);
                    }
                }
                requestFusion = this.prefetch;
                b bVar = new b(requestFusion);
                this.queue = bVar;
                this.downstream.onSubscribe(this);
                c.request((long)prefetch);
            }
        }

        public T poll() {
            int sourceMode;
            int i;
            c upstream;
            Object poll = this.queue.poll();
            i = 1;
            if (poll != null && this.sourceMode != i) {
                i = 1;
                if (this.sourceMode != i) {
                    produced += i2;
                    if (Long.compare(sourceMode, l) == 0) {
                        this.produced = 0;
                        this.upstream.request(sourceMode);
                    } else {
                        this.produced = sourceMode;
                    }
                }
            }
            return poll;
        }
    }
    public w(h<T> h, z z2, boolean z3, int i4) {
        super(h);
        this.c = z2;
        this.v = z3;
        this.w = i4;
    }

    public void c0(b<? super T> b) {
        h hVar;
        i.b.m0.e.b.w.a bVar;
        boolean z;
        int i;
        z.c cVar = this.c.a();
        if (b instanceof a) {
            bVar = new w.b((a)b, cVar, this.v, this.w);
            this.b.b0(bVar);
        } else {
            bVar = new w.c(b, cVar, this.v, this.w);
            this.b.b0(bVar);
        }
    }
}
