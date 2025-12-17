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

/* loaded from: classes3.dex */
public final class v3<T>  extends i.b.m0.e.e.a<T, T> {

    final long b;
    final TimeUnit c;
    final z v;

    static final class a extends AtomicReference<b> implements y<T>, b, Runnable {

        private static final long serialVersionUID = 786994795061867455L;
        boolean done;
        final y<? super T> downstream;
        volatile boolean gate;
        final long timeout;
        final TimeUnit unit;
        b upstream;
        final z.c worker;
        a(y<? super T> y, long l2, TimeUnit timeUnit3, z.c z$c4) {
            super();
            this.downstream = y;
            this.timeout = l2;
            this.unit = c4;
            this.worker = obj5;
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
            boolean worker;
            if (!this.done) {
                this.done = true;
                this.downstream.onComplete();
                this.worker.dispose();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            boolean downstream;
            Object obj2;
            if (this.done) {
                a.t(throwable);
            } else {
                this.done = true;
                this.downstream.onError(throwable);
                this.worker.dispose();
            }
        }

        public void onNext(T t) {
            boolean timeout;
            TimeUnit unit;
            Object obj4;
            this.gate = true;
            this.downstream.onNext(t);
            obj4 = get();
            if (!this.gate && !this.done && (b)obj4 != null) {
                if (!this.done) {
                    this.gate = true;
                    this.downstream.onNext(t);
                    obj4 = get();
                    if ((b)(b)obj4 != null) {
                        (b)(b)obj4.dispose();
                    }
                    c.replace(this, this.worker.c(this, this.timeout, obj1));
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.upstream, b)) {
                this.upstream = b;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void run() {
            this.gate = false;
        }
    }
    public v3(w<T> w, long l2, TimeUnit timeUnit3, z z4) {
        super(w);
        this.b = l2;
        this.c = z4;
        this.v = obj5;
    }

    public void subscribeActual(y<? super T> y) {
        e eVar = new e(y);
        super(eVar, this.b, obj4, this.c, this.v.a());
        this.a.subscribe(aVar2);
    }
}
