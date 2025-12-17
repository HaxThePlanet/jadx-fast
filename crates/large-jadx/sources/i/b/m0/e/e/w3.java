package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.r;
import i.b.w;
import i.b.y;
import i.b.z;
import i.b.z.c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class w3<T>  extends i.b.m0.e.e.a<T, T> {

    final long b;
    final TimeUnit c;
    final z v;
    final boolean w;

    static final class a extends AtomicInteger implements y<T>, b, Runnable {

        private static final long serialVersionUID = -8296689127439125014L;
        volatile boolean cancelled;
        volatile boolean done;
        final y<? super T> downstream;
        final boolean emitLast;
        Throwable error;
        final AtomicReference<T> latest;
        final long timeout;
        volatile boolean timerFired;
        boolean timerRunning;
        final TimeUnit unit;
        b upstream;
        final z.c worker;
        a(y<? super T> y, long l2, TimeUnit timeUnit3, z.c z$c4, boolean z5) {
            super();
            this.downstream = y;
            this.timeout = l2;
            this.unit = c4;
            this.worker = z5;
            this.emitLast = obj6;
            AtomicReference obj1 = new AtomicReference();
            this.latest = obj1;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            int emitLast;
            int andGet;
            boolean timerRunning;
            int timeout;
            int error;
            int unit;
            if (getAndIncrement() != 0) {
            }
            AtomicReference latest = this.latest;
            final y downstream = this.downstream;
            emitLast = 1;
            andGet = emitLast;
            timeout = 0;
            while (this.cancelled) {
                boolean done = this.done;
                unit = 0;
                if (latest.get() == null) {
                } else {
                }
                error = unit;
                downstream.onNext(latest.getAndSet(timeout));
                this.timerFired = unit;
                this.timerRunning = emitLast;
                this.worker.c(this, this.timeout, error);
                timeout = 0;
                if (this.timerFired) {
                }
                this.timerRunning = unit;
                this.timerFired = unit;
                error = emitLast;
            }
            latest.lazySet(timeout);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            int andIncrement;
            int i;
            this.cancelled = true;
            this.upstream.dispose();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.latest.lazySet(0);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            this.done = true;
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable throwable) {
            this.error = throwable;
            this.done = true;
            a();
        }

        public void onNext(T t) {
            this.latest.set(t);
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.upstream, b)) {
                this.upstream = b;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void run() {
            this.timerFired = true;
            a();
        }
    }
    public w3(r<T> r, long l2, TimeUnit timeUnit3, z z4, boolean z5) {
        super(r);
        this.b = l2;
        this.c = z4;
        this.v = z5;
        this.w = obj6;
    }

    protected void subscribeActual(y<? super T> y) {
        super(y, this.b, obj4, this.c, this.v.a(), this.w);
        this.a.subscribe(aVar2);
    }
}
