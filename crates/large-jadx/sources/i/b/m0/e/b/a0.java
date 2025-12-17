package i.b.m0.e.b;

import i.b.h;
import i.b.k;
import i.b.m0.i.g;
import i.b.m0.j.d;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import m.c.b;
import m.c.c;

/* loaded from: classes3.dex */
public final class a0<T>  extends i.b.m0.e.b.a<T, T> {

    static final class a extends AtomicInteger implements k<T>, c {

        private static final long serialVersionUID = 163080509307634843L;
        volatile boolean cancelled;
        final AtomicReference<T> current;
        volatile boolean done;
        final b<? super T> downstream;
        Throwable error;
        final AtomicLong requested;
        c upstream;
        a(b<? super T> b) {
            super();
            AtomicLong atomicLong = new AtomicLong();
            this.requested = atomicLong;
            AtomicReference atomicReference = new AtomicReference();
            this.current = atomicReference;
            this.downstream = b;
        }

        boolean a(boolean z, boolean z2, b<?> b3, AtomicReference<T> atomicReference4) {
            Throwable obj4;
            final int i = 0;
            final int i2 = 1;
            if (this.cancelled) {
                atomicReference4.lazySet(i);
                return i2;
            }
            obj4 = this.error;
            if (z != null && obj4 != null) {
                obj4 = this.error;
                if (obj4 != null) {
                    atomicReference4.lazySet(i);
                    b3.onError(obj4);
                    return i2;
                }
                if (z2) {
                    b3.onComplete();
                    return i2;
                }
            }
            return 0;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b() {
            int andGet;
            int cmp3;
            int i3;
            int cmp;
            int cmp2;
            int i;
            long andSet;
            int i2;
            if (getAndIncrement() != 0) {
            }
            b downstream = this.downstream;
            final AtomicLong requested = this.requested;
            final AtomicReference current = this.current;
            final int i4 = 1;
            andGet = i4;
            while (/* condition */) {
                while (Long.compare(i3, l) != 0) {
                    andSet = current.getAndSet(0);
                    if (andSet == null) {
                    } else {
                    }
                    i2 = i;
                    downstream.onNext(andSet);
                    i3 += cmp;
                    i2 = i4;
                }
                if (Long.compare(i3, i6) != 0) {
                }
                int i6 = 0;
                i3 = i6;
                d.d(requested, i3);
                if (current.get() == null) {
                }
                i = i4;
                andSet = current.getAndSet(0);
                if (andSet == null) {
                } else {
                }
                i2 = i;
                downstream.onNext(andSet);
                i3 += cmp;
                i2 = i4;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void cancel() {
            boolean andIncrement;
            int i;
            this.cancelled = true;
            this.upstream.cancel();
            if (!this.cancelled && getAndIncrement() == 0) {
                this.cancelled = true;
                this.upstream.cancel();
                if (getAndIncrement() == 0) {
                    this.current.lazySet(0);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            this.done = true;
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable throwable) {
            this.error = throwable;
            this.done = true;
            b();
        }

        public void onNext(T t) {
            this.current.lazySet(t);
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(c c) {
            boolean validate;
            if (g.validate(this.upstream, c)) {
                this.upstream = c;
                this.downstream.onSubscribe(this);
                c.request(Long.MAX_VALUE);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void request(long l) {
            boolean requested;
            if (g.validate(l)) {
                d.a(this.requested, l);
                b();
            }
        }
    }
    public a0(h<T> h) {
        super(h);
    }

    protected void c0(b<? super T> b) {
        a0.a aVar = new a0.a(b);
        this.b.b0(aVar);
    }
}
