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

/* compiled from: ObservableThrottleLatest.java */
/* loaded from: classes3.dex */
public final class w3<T> extends a<T, T> {

    final long b;
    final TimeUnit c;
    final z v;
    final boolean w;

    static final class a<T> extends AtomicInteger implements y<T>, b, Runnable {

        private static final long serialVersionUID = -8296689127439125014L;
        volatile boolean cancelled;
        volatile boolean done;
        final y<? super T> downstream;
        final boolean emitLast;
        Throwable error;
        final AtomicReference<T> latest = new AtomicReference<>();
        final long timeout;
        volatile boolean timerFired;
        boolean timerRunning;
        final TimeUnit unit;
        b upstream;
        final z.c worker;
        a(y<? super T> yVar, long j, TimeUnit timeUnit, z.c cVar, boolean z) {
            super();
            this.downstream = yVar;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = cVar;
            this.emitLast = z;
            final AtomicReference atomicReference = new AtomicReference();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            int andGet;
            boolean timerFired2;
            TimeUnit timeUnit;
            if (getAndIncrement() != 0) {
                return;
            }
            boolean z = true;
            andGet = z;
            Object obj = null;
            while (this.cancelled) {
                boolean z2 = false;
                boolean r6 = this.latest.get() == null ? z : z2;
                if (!this.timerRunning || this.timerFired) {
                }
            }
            this.latest.lazySet(obj);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                Object obj = null;
                this.latest.lazySet(obj);
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
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onNext(T t) {
            this.latest.set(t);
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(b bVar) {
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void run() {
            this.timerFired = true;
            a();
        }
    }
    public w3(r<T> rVar, long j, TimeUnit timeUnit, z zVar, boolean z) {
        super(rVar);
        this.b = j;
        this.c = timeUnit;
        this.v = zVar;
        this.w = z;
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super T> yVar) {
        w3.a aVar = new w3.a(yVar, this.b, timeUnit, this.c, this.v.a(), this.w);
        this.a.subscribe(aVar);
    }
}
