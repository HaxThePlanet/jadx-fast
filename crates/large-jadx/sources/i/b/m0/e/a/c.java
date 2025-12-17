package i.b.m0.e.a;

import i.b.b;
import i.b.d;
import i.b.f;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.z;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class c extends b {

    final f a;
    final long b;
    final TimeUnit c;
    final z v;
    final boolean w;

    static final class a extends AtomicReference<b> implements d, Runnable, b {

        private static final long serialVersionUID = 465972761105851022L;
        final long delay;
        final boolean delayError;
        final d downstream;
        Throwable error;
        final z scheduler;
        final TimeUnit unit;
        a(d d, long l2, TimeUnit timeUnit3, z z4, boolean z5) {
            super();
            this.downstream = d;
            this.delay = l2;
            this.unit = z4;
            this.scheduler = z5;
            this.delayError = obj6;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            return c.isDisposed((b)get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            c.replace(this, this.scheduler.d(this, this.delay, obj2));
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            long delay;
            this.error = throwable;
            delay = this.delayError != null ? this.delay : 0;
            c.replace(this, this.scheduler.d(this, delay, obj1));
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            boolean obj1;
            if (c.setOnce(this, b)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void run() {
            Object downstream2;
            d downstream;
            downstream2 = this.error;
            this.error = 0;
            if (downstream2 != null) {
                this.downstream.onError(downstream2);
            } else {
                this.downstream.onComplete();
            }
        }
    }
    public c(f f, long l2, TimeUnit timeUnit3, z z4, boolean z5) {
        super();
        this.a = f;
        this.b = l2;
        this.c = z4;
        this.v = z5;
        this.w = obj6;
    }

    @Override // i.b.b
    protected void x(d d) {
        super(d, this.b, obj4, this.c, this.v, this.w);
        this.a.b(aVar2);
    }
}
