package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.k;
import i.b.m0.a.c;
import i.b.m0.i.g;
import i.b.p0.a;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import m.c.a;
import m.c.c;

/* loaded from: classes3.dex */
public final class r0<T, U>  extends a0<T> {

    final g0<T> a;
    final a<U> b;

    static final class a extends AtomicReference<b> implements d0<T>, b {

        private static final long serialVersionUID = -622603812305745221L;
        final d0<? super T> downstream;
        final i.b.m0.e.f.r0.b other;
        a(d0<? super T> d0) {
            super();
            this.downstream = d0;
            r0.b obj1 = new r0.b(this);
            this.other = obj1;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        void a(Throwable throwable) {
            Object andSet;
            final c dISPOSED = c.DISPOSED;
            andSet = getAndSet(dISPOSED);
            if ((b)get() != dISPOSED && (b)andSet != dISPOSED && (b)andSet != null) {
                andSet = getAndSet(dISPOSED);
                if ((b)(b)andSet != dISPOSED) {
                    if ((b)(b)andSet != null) {
                        (b)(b)andSet.dispose();
                    }
                    this.downstream.onError(throwable);
                }
            }
            a.t(throwable);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this);
            this.other.a();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            return c.isDisposed((b)get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            Object andSet;
            this.other.a();
            final c dISPOSED = c.DISPOSED;
            if ((b)get() != dISPOSED && (b)getAndSet(dISPOSED) != dISPOSED) {
                if ((b)getAndSet(dISPOSED) != dISPOSED) {
                    this.downstream.onError(throwable);
                }
            }
            a.t(throwable);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            c.setOnce(this, b);
        }

        public void onSuccess(T t) {
            Object dISPOSED;
            this.other.a();
            dISPOSED = c.DISPOSED;
            if ((b)getAndSet(dISPOSED) != dISPOSED) {
                this.downstream.onSuccess(t);
            }
        }
    }

    static final class b extends AtomicReference<c> implements k<Object> {

        private static final long serialVersionUID = 5170026210238877381L;
        final i.b.m0.e.f.r0.a<?> parent;
        b(i.b.m0.e.f.r0.a<?> r0$a) {
            super();
            this.parent = a;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void a() {
            g.cancel(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            Object parent;
            Object cancellationException;
            cancellationException = g.CANCELLED;
            if (get() != cancellationException) {
                lazySet(cancellationException);
                cancellationException = new CancellationException();
                this.parent.a(cancellationException);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            this.parent.a(throwable);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onNext(Object object) {
            CancellationException cancellationException;
            boolean obj2;
            if (g.cancel(this)) {
                cancellationException = new CancellationException();
                this.parent.a(cancellationException);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(c c) {
            g.setOnce(this, c, Long.MAX_VALUE);
        }
    }
    public r0(g0<T> g0, a<U> a2) {
        super();
        this.a = g0;
        this.b = a2;
    }

    protected void subscribeActual(d0<? super T> d0) {
        r0.a aVar = new r0.a(d0);
        d0.onSubscribe(aVar);
        this.b.a(aVar.other);
        this.a.subscribe(aVar);
    }
}
