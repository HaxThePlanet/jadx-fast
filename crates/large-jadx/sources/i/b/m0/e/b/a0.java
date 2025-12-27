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

/* compiled from: FlowableOnBackpressureLatest.java */
/* loaded from: classes3.dex */
public final class a0<T> extends a<T, T> {

    static final class a<T> extends AtomicInteger implements k<T>, c {

        private static final long serialVersionUID = 163080509307634843L;
        volatile boolean cancelled;
        final AtomicReference<T> current = new AtomicReference<>();
        volatile boolean done;
        final b<? super T> downstream;
        Throwable error;
        final AtomicLong requested = new AtomicLong();
        c upstream;
        a(b<? super T> bVar) {
            super();
            AtomicLong atomicLong = new AtomicLong();
            AtomicReference atomicReference = new AtomicReference();
            this.downstream = bVar;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        boolean a(boolean z, boolean z2, b<?> bVar, AtomicReference<T> atomicReference) {
            final Object obj = null;
            final boolean z3 = true;
            if (this.cancelled) {
                atomicReference.lazySet(obj);
                return true;
            }
            if (this.error != null && this.error != null) {
                atomicReference.lazySet(obj);
                bVar.onError(this.error);
                return true;
            }
            return false;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b() {
            int andGet;
            long l3;
            int cmp2;
            int i;
            boolean z4 = false;
            long l;
            Object andSet;
            boolean z;
            if (getAndIncrement() != 0) {
                return;
            }
            andGet = 1;
            while (/* condition */) {
                long l5 = this.requested.get();
                i = 0;
                while (l3 != l5) {
                    andSet = this.current.getAndSet(null);
                    int r12 = andSet == null ? andGet : 0;
                }
                l = this.requested.get();
                if (addAndGet(-andGet) == 0) {
                    return;
                }
                long l2 = 0L;
                int i3 = l2;
                andSet = this.current.getAndSet(null);
                r12 = andSet == null ? andGet : i;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                if (getAndIncrement() == 0) {
                    Object obj = null;
                    this.current.lazySet(obj);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            this.done = true;
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onNext(T t) {
            this.current.lazySet(t);
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(c cVar) {
            if (g.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
                cVar.request(Long.MAX_VALUE);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void request(long j) {
            if (g.validate(j)) {
                d.a(this.requested, j);
                b();
            }
        }
    }
    public a0(h<T> hVar) {
        super(hVar);
    }

    @Override // i.b.m0.e.b.a
    protected void c0(b<? super T> bVar) {
        this.b.b0(new a0.a(bVar));
    }
}
