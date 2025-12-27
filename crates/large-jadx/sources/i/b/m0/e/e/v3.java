package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.o0.e;
import i.b.p0.a;
import i.b.w;
import i.b.y;
import i.b.z;
import i.b.z.c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableThrottleFirstTimed.java */
/* loaded from: classes3.dex */
public final class v3<T> extends a<T, T> {

    final long b;
    final TimeUnit c;
    final z v;

    static final class a<T> extends AtomicReference<b> implements y<T>, b, Runnable {

        private static final long serialVersionUID = 786994795061867455L;
        boolean done;
        final y<? super T> downstream;
        volatile boolean gate;
        final long timeout;
        final TimeUnit unit;
        b upstream;
        final z.c worker;
        a(y<? super T> yVar, long j, TimeUnit timeUnit, z.c cVar) {
            super();
            this.downstream = yVar;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = cVar;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            this.upstream.dispose();
            this.worker.dispose();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            return this.worker.isDisposed();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.downstream.onComplete();
                this.worker.dispose();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            if (this.done) {
                a.t(th);
            } else {
                this.done = true;
                this.downstream.onError(th);
                this.worker.dispose();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onNext(T t) {
            if (!this.gate && !this.done) {
                this.gate = true;
                this.downstream.onNext(t);
                Object obj = get();
                if (obj != null) {
                    obj.dispose();
                }
                c.replace(this, this.worker.c(this, this.timeout, this.unit));
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b bVar) {
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void run() {
            this.gate = false;
        }
    }
    public v3(w<T> wVar, long j, TimeUnit timeUnit, z zVar) {
        super(wVar);
        this.b = j;
        this.c = timeUnit;
        this.v = zVar;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super T> yVar) {
        v3.a aVar = new v3.a(new e(yVar), this.b, timeUnit, this.c, this.v.a());
        this.a.subscribe(aVar);
    }
}
