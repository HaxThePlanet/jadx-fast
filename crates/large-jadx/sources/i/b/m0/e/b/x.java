package i.b.m0.e.b;

import i.b.h;
import i.b.k;
import i.b.l0.a;
import i.b.m0.c.i;
import i.b.m0.c.j;
import i.b.m0.f.b;
import i.b.m0.f.c;
import i.b.m0.i.a;
import i.b.m0.i.g;
import i.b.m0.j.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import m.c.b;
import m.c.c;

/* loaded from: classes3.dex */
public final class x<T>  extends i.b.m0.e.b.a<T, T> {

    final int c;
    final boolean v;
    final boolean w;
    final a x;

    static final class a extends a<T> implements k<T> {

        private static final long serialVersionUID = -2514538129242366402L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        final b<? super T> downstream;
        Throwable error;
        final a onOverflow;
        boolean outputFused;
        final i<T> queue;
        final AtomicLong requested;
        c upstream;
        a(b<? super T> b, int i2, boolean z3, boolean z4, a a5) {
            Object obj2;
            super();
            AtomicLong atomicLong = new AtomicLong();
            this.requested = atomicLong;
            this.downstream = b;
            this.onOverflow = a5;
            this.delayError = z4;
            if (z3) {
                obj2 = new c(i2);
            } else {
                obj2 = new b(i2);
            }
            this.queue = obj2;
        }

        boolean a(boolean z, boolean z2, b<? super T> b3) {
            Throwable obj3;
            final int i = 1;
            if (this.cancelled) {
                this.queue.clear();
                return i;
            }
            if (z != null) {
                if (this.delayError != null) {
                    if (z2) {
                        obj3 = this.error;
                        if (obj3 != null) {
                            b3.onError(obj3);
                        } else {
                            b3.onComplete();
                        }
                        return i;
                    }
                } else {
                    obj3 = this.error;
                    if (obj3 != null) {
                        this.queue.clear();
                        b3.onError(obj3);
                        return i;
                    }
                    if (z2) {
                        b3.onComplete();
                        return i;
                    }
                }
            }
            return 0;
        }

        @Override // i.b.m0.i.a
        void b() {
            int andIncrement;
            b downstream;
            int i3;
            int andGet;
            long requested;
            boolean empty2;
            int cmp;
            int i2;
            int cmp2;
            boolean empty;
            Object poll;
            int i;
            if (getAndIncrement() == 0) {
                andIncrement = this.queue;
                downstream = this.downstream;
                i3 = 1;
                andGet = i3;
                while (a(this.done, andIncrement.isEmpty(), downstream)) {
                    requested = this.requested.get();
                    int i5 = 0;
                    i2 = i5;
                    cmp2 = Long.compare(i2, requested);
                    while (cmp2 != 0) {
                        poll = andIncrement.poll();
                        if (poll == null) {
                        } else {
                        }
                        i = 0;
                        downstream.onNext(poll);
                        i2 += cmp2;
                        cmp2 = Long.compare(i2, requested);
                        i = i3;
                    }
                    cmp = Long.MAX_VALUE;
                    if (Long.compare(i2, i5) != 0 && Long.compare(requested, cmp) != 0) {
                    }
                    cmp = Long.MAX_VALUE;
                    if (Long.compare(requested, cmp) != 0) {
                    }
                    this.requested.addAndGet(-i2);
                    poll = andIncrement.poll();
                    if (poll == null) {
                    } else {
                    }
                    i = 0;
                    downstream.onNext(poll);
                    i2 += cmp2;
                    i = i3;
                }
            }
        }

        @Override // i.b.m0.i.a
        public void cancel() {
            boolean andIncrement;
            this.cancelled = true;
            this.upstream.cancel();
            if (!this.cancelled && !this.outputFused && getAndIncrement() == 0) {
                this.cancelled = true;
                this.upstream.cancel();
                if (!this.outputFused) {
                    if (getAndIncrement() == 0) {
                        this.queue.clear();
                    }
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
            b outputFused;
            this.done = true;
            if (this.outputFused) {
                this.downstream.onComplete();
            } else {
                b();
            }
        }

        @Override // i.b.m0.i.a
        public void onError(Throwable throwable) {
            b outputFused;
            this.error = throwable;
            this.done = true;
            if (this.outputFused) {
                this.downstream.onError(throwable);
            } else {
                b();
            }
        }

        public void onNext(T t) {
            a onOverflow;
            int queue;
            b obj2;
            if (!this.queue.offer(t)) {
                this.upstream.cancel();
                obj2 = new MissingBackpressureException("Buffer is full");
                this.onOverflow.run();
                onError(obj2);
            }
            if (this.outputFused) {
                this.downstream.onNext(0);
            } else {
                b();
            }
        }

        @Override // i.b.m0.i.a
        public void onSubscribe(c c) {
            boolean validate;
            if (g.validate(this.upstream, c)) {
                this.upstream = c;
                this.downstream.onSubscribe(this);
                c.request(Long.MAX_VALUE);
            }
        }

        public T poll() {
            return this.queue.poll();
        }

        @Override // i.b.m0.i.a
        public void request(long l) {
            boolean outputFused;
            if (!this.outputFused && g.validate(l)) {
                if (g.validate(l)) {
                    d.a(this.requested, l);
                    b();
                }
            }
        }

        @Override // i.b.m0.i.a
        public int requestFusion(int i) {
            final int i2 = 2;
            if (i &= i2 != 0) {
                this.outputFused = true;
                return i2;
            }
            return 0;
        }
    }
    public x(h<T> h, int i2, boolean z3, boolean z4, a a5) {
        super(h);
        this.c = i2;
        this.v = z3;
        this.w = z4;
        this.x = a5;
    }

    protected void c0(b<? super T> b) {
        super(b, this.c, this.v, this.w, this.x);
        this.b.b0(aVar3);
    }
}
