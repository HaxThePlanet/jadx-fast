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

/* compiled from: SingleTimeout.java */
/* loaded from: classes3.dex */
public final class s0<T> extends a0<T> {

    final g0<T> a;
    final long b;
    final TimeUnit c;
    final z v;
    final g0<? extends T> w;

    static final class a<T> extends AtomicReference<b> implements d0<T>, Runnable, b {

        private static final long serialVersionUID = 37497744973048446L;
        final d0<? super T> downstream;
        final s0.a.a<T> fallback;
        g0<? extends T> other;
        final AtomicReference<b> task = new AtomicReference<>();
        final long timeout;
        final TimeUnit unit;
        a(d0<? super T> d0Var, g0<? extends T> g0Var, long j, TimeUnit timeUnit) {
            super();
            this.downstream = d0Var;
            this.other = g0Var;
            this.timeout = j;
            this.unit = timeUnit;
            final AtomicReference atomicReference = new AtomicReference();
            if (g0Var != null) {
                this.fallback = new s0.a.a(d0Var);
            } else {
                i.b.m0.e.f.s0.a.a aVar = null;
                this.fallback = aVar;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this);
            c.dispose(this.task);
            if (this.fallback != null) {
                c.dispose(this.fallback);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            return c.isDisposed((b)get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            Object obj;
            obj = get();
            final c dISPOSED2 = c.DISPOSED;
            if (obj == c.DISPOSED || !this.compareAndSet(obj, c.DISPOSED)) {
                a.t(th);
            } else {
                c.dispose(this.task);
                this.downstream.onError(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b bVar) {
            c.setOnce(this, bVar);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSuccess(T t) {
            Object obj = get();
            final c dISPOSED2 = c.DISPOSED;
            if (obj != c.DISPOSED && this.compareAndSet(obj, c.DISPOSED)) {
                c.dispose(this.task);
                this.downstream.onSuccess(t);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void run() {
            Object obj = get();
            dISPOSED2 = c.DISPOSED;
            if (obj != c.DISPOSED && this.compareAndSet(obj, c.DISPOSED) && obj != null) {
                obj.dispose();
                if (this.other == null) {
                    this.downstream.onError(new TimeoutException(k.d(this.timeout, this.unit)));
                } else {
                    this.other = null;
                    this.other.subscribe(this.fallback);
                }
            }
        }
    }
    public s0(g0<T> g0Var, long j, TimeUnit timeUnit, z zVar, g0<? extends T> g0Var2) {
        super();
        this.a = g0Var;
        this.b = j;
        this.c = timeUnit;
        this.v = zVar;
        this.w = g0Var2;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super T> d0Var) {
        s0.a aVar = new s0.a(d0Var, g0Var, this.b, timeUnit2, this.c);
        d0Var.onSubscribe(aVar);
        c.replace(aVar.task, this.v.d(aVar, this.b, this.c));
        this.a.subscribe(aVar);
    }
}
