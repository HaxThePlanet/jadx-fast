package i.b.m0.e.b;

import i.b.h;
import i.b.j0.b;
import i.b.k;
import i.b.m0.i.g;
import i.b.m0.j.d;
import i.b.z;
import i.b.z.c;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import m.c.a;
import m.c.b;
import m.c.c;

/* loaded from: classes3.dex */
public final class l0<T>  extends i.b.m0.e.b.a<T, T> {

    final z c;
    final boolean v;

    static final class a extends AtomicReference<Thread> implements k<T>, c, Runnable {

        private static final long serialVersionUID = 8094547886072529208L;
        final b<? super T> downstream;
        final boolean nonScheduledRequests;
        final AtomicLong requested;
        a<T> source;
        final AtomicReference<c> upstream;
        final z.c worker;
        a(b<? super T> b, z.c z$c2, a<T> a3, boolean z4) {
            super();
            this.downstream = b;
            this.worker = c2;
            this.source = a3;
            AtomicReference obj1 = new AtomicReference();
            this.upstream = obj1;
            obj1 = new AtomicLong();
            this.requested = obj1;
            this.nonScheduledRequests = z4 ^ 1;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        void a(long l, c c2) {
            z.c nonScheduledRequests;
            Object aVar;
            if (!this.nonScheduledRequests) {
                if (Thread.currentThread() == get()) {
                    obj5.request(l);
                } else {
                    aVar = new l0.a.a(obj5, l, c2);
                    this.worker.b(aVar);
                }
            } else {
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void cancel() {
            g.cancel(this.upstream);
            this.worker.dispose();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            this.downstream.onComplete();
            this.worker.dispose();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            this.downstream.onError(throwable);
            this.worker.dispose();
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(c c) {
            boolean once;
            int i;
            long andSet;
            i = 0;
            andSet = this.requested.getAndSet(i);
            if (g.setOnce(this.upstream, c) && Long.compare(andSet, i) != 0) {
                i = 0;
                andSet = this.requested.getAndSet(i);
                if (Long.compare(andSet, i) != 0) {
                    a(andSet, obj4);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void request(long l) {
            boolean requested;
            long andSet;
            long obj5;
            long obj6;
            if (g.validate(l)) {
                requested = this.upstream.get();
                if ((c)requested != null) {
                    a(l, obj6);
                } else {
                    d.a(this.requested, l);
                    obj5 = this.upstream.get();
                    requested = 0;
                    andSet = this.requested.getAndSet(requested);
                    if ((c)obj5 != null && Long.compare(andSet, requested) != 0) {
                        requested = 0;
                        andSet = this.requested.getAndSet(requested);
                        if (Long.compare(andSet, requested) != 0) {
                            a(andSet, obj3);
                        }
                    }
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void run() {
            lazySet(Thread.currentThread());
            this.source = 0;
            this.source.a(this);
        }
    }
    public l0(h<T> h, z z2, boolean z3) {
        super(h);
        this.c = z2;
        this.v = z3;
    }

    public void c0(b<? super T> b) {
        z.c cVar = this.c.a();
        l0.a aVar = new l0.a(b, cVar, this.b, this.v);
        b.onSubscribe(aVar);
        cVar.b(aVar);
    }
}
