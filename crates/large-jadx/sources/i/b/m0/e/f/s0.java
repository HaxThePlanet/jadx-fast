package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.j.k;
import i.b.p0.a;
import i.b.z;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class s0<T>  extends a0<T> {

    final g0<T> a;
    final long b;
    final TimeUnit c;
    final z v;
    final g0<? extends T> w;

    static final class a extends AtomicReference<b> implements d0<T>, Runnable, b {

        private static final long serialVersionUID = 37497744973048446L;
        final d0<? super T> downstream;
        final i.b.m0.e.f.s0.a.a<T> fallback = null;
        g0<? extends T> other;
        final AtomicReference<b> task;
        final long timeout;
        final TimeUnit unit;
        a(d0<? super T> d0, g0<? extends T> g02, long l3, TimeUnit timeUnit4) {
            d0 obj1;
            Object obj2;
            super();
            this.downstream = d0;
            this.other = g02;
            this.timeout = l3;
            this.unit = obj5;
            AtomicReference obj3 = new AtomicReference();
            this.task = obj3;
            if (g02 != null) {
                obj2 = new s0.a.a(d0);
                this.fallback = obj2;
            } else {
                obj1 = 0;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this);
            c.dispose(this.task);
            i.b.m0.e.f.s0.a.a fallback = this.fallback;
            if (fallback != null) {
                c.dispose(fallback);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            return c.isDisposed((b)get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            Object compareAndSet;
            compareAndSet = get();
            final c dISPOSED = c.DISPOSED;
            if (compareAndSet != dISPOSED && compareAndSet((b)compareAndSet, dISPOSED)) {
                if (compareAndSet(compareAndSet, dISPOSED)) {
                    c.dispose(this.task);
                    this.downstream.onError(throwable);
                } else {
                    a.t(throwable);
                }
            } else {
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            c.setOnce(this, b);
        }

        public void onSuccess(T t) {
            Object compareAndSet;
            compareAndSet = get();
            final c dISPOSED = c.DISPOSED;
            if (compareAndSet != dISPOSED && compareAndSet((b)compareAndSet, dISPOSED)) {
                if (compareAndSet(compareAndSet, dISPOSED)) {
                    c.dispose(this.task);
                    this.downstream.onSuccess(t);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void run() {
            Object downstream;
            c timeoutException;
            String str;
            TimeUnit unit;
            downstream = get();
            timeoutException = c.DISPOSED;
            if (downstream != timeoutException && compareAndSet((b)downstream, timeoutException) && downstream != null) {
                if (compareAndSet(downstream, timeoutException)) {
                    if (downstream != null) {
                        downstream.dispose();
                    }
                    downstream = this.other;
                    if (downstream == null) {
                        timeoutException = new TimeoutException(k.d(this.timeout, obj3));
                        this.downstream.onError(timeoutException);
                    } else {
                        this.other = 0;
                        downstream.subscribe(this.fallback);
                    }
                }
            }
        }
    }
    public s0(g0<T> g0, long l2, TimeUnit timeUnit3, z z4, g0<? extends T> g05) {
        super();
        this.a = g0;
        this.b = l2;
        this.c = z4;
        this.v = g05;
        this.w = obj6;
    }

    protected void subscribeActual(d0<? super T> d0) {
        final g0 g0Var = this.w;
        super(d0, g0Var, this.b, obj4, this.c);
        d0.onSubscribe(aVar2);
        c.replace(aVar2.task, this.v.d(aVar2, this.b, g0Var));
        this.a.subscribe(aVar2);
    }
}
