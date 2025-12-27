package i.b.m0.e.b;

import i.b.h;
import i.b.k;
import i.b.m0.c.i;
import i.b.m0.c.j;
import i.b.m0.i.g;
import i.b.m0.j.d;
import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableOnBackpressureBuffer.java */
/* loaded from: classes3.dex */
public final class x<T> extends a<T, T> {

    final int c;
    final boolean v;
    final boolean w;
    final i.b.l0.a x;

    static final class a<T> extends i.b.m0.i.a<T> implements k<T> {

        private static final long serialVersionUID = -2514538129242366402L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        final m.c.b<? super T> downstream;
        Throwable error;
        final i.b.l0.a onOverflow;
        boolean outputFused;
        final i<T> queue = new b<>();
        final AtomicLong requested = new AtomicLong();
        m.c.c upstream;
        a(m.c.b<? super T> bVar, int i, boolean z, boolean z2, i.b.l0.a aVar) {
            super();
            final AtomicLong atomicLong = new AtomicLong();
            this.downstream = bVar;
            this.onOverflow = aVar;
            this.delayError = z2;
            if (z) {
                i.b.m0.f.c cVar = new c(i);
            }
            i.b.m0.f.b bVar2 = new b(i);
        }

        @Override // i.b.m0.i.a
        boolean a(boolean z, boolean z2, m.c.b<? super T> bVar) {
            final boolean z3 = true;
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (this.delayError != null && this.delayError != null && z2 && this.error != null) {
                bVar.onError(this.error);
                return true;
            }
            return false;
        }

        @Override // i.b.m0.i.a
        void b() {
            int andGet;
            long l;
            boolean empty;
            int cmp = 9223372036854775807L;
            int i;
            int cmp2;
            boolean empty2;
            Object poll;
            boolean z;
            if (getAndIncrement() == 0) {
                andGet = 1;
                while (a(this.done, this.queue.isEmpty(), this.downstream)) {
                    l = this.requested.get();
                    long l2 = 0L;
                    i = l2;
                    while (i != this.done) {
                        poll = this.queue.poll();
                        int r13 = poll == null ? andGet : 0;
                    }
                    if (addAndGet(-andGet) == 0) {
                        return;
                    }
                    poll = this.queue.poll();
                    r13 = poll == null ? andGet : 0;
                }
                return;
            }
        }

        @Override // i.b.m0.i.a
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                if (!this.outputFused && this.getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        @Override // i.b.m0.i.a
        public void clear() {
            this.queue.clear();
        }

        @Override // i.b.m0.i.a
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // i.b.m0.i.a
        public void onComplete() {
            this.done = true;
            if (this.outputFused) {
                this.downstream.onComplete();
            } else {
                b();
            }
        }

        @Override // i.b.m0.i.a
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (this.outputFused) {
                this.downstream.onError(th);
            } else {
                b();
            }
        }

        @Override // i.b.m0.i.a
        public void onNext(T t) {
            if (!this.queue.offer(t)) {
                this.upstream.cancel();
                try {
                    this.onOverflow.run();
                } catch (Throwable th) {
                    a.b(th);
                    t.initCause(th);
                }
                onError(new MissingBackpressureException("Buffer is full"));
                return;
            }
            if (this.outputFused) {
                Object obj = null;
                this.downstream.onNext(obj);
            } else {
                b();
            }
        }

        @Override // i.b.m0.i.a
        public void onSubscribe(m.c.c cVar) {
            if (g.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
                cVar.request(Long.MAX_VALUE);
            }
        }

        @Override // i.b.m0.i.a
        public T poll() {
            return this.queue.poll();
        }

        @Override // i.b.m0.i.a
        public void request(long j) {
            if (!this.outputFused && g.validate(j, r3)) {
                d.a(this.requested, j);
                b();
            }
        }

        @Override // i.b.m0.i.a
        public int requestFusion(int i) {
            final int i2 = 2;
            if (i & i2 != 0) {
                this.outputFused = true;
                return i2;
            }
            return 0;
        }
    }
    public x(h<T> hVar, int i, boolean z, boolean z2, i.b.l0.a aVar) {
        super(hVar);
        this.c = i;
        this.v = z;
        this.w = z2;
        this.x = aVar;
    }

    @Override // i.b.m0.e.b.a
    protected void c0(m.c.b<? super T> bVar) {
        x.a aVar = new x.a(bVar, this.c, this.v, this.w, this.x);
        this.b.b0(aVar);
    }
}
