package i.b.m0.e.b;

import i.b.h;
import i.b.k;
import i.b.m0.i.g;
import i.b.m0.j.d;
import i.b.z;
import i.b.z.c;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import m.c.a;
import m.c.c;

/* compiled from: FlowableSubscribeOn.java */
/* loaded from: classes3.dex */
public final class l0<T> extends a<T, T> {

    final z c;
    final boolean v;

    static final class a<T> extends AtomicReference<Thread> implements k<T>, c, Runnable {

        private static final long serialVersionUID = 8094547886072529208L;
        final m.c.b<? super T> downstream;
        final boolean nonScheduledRequests;
        final AtomicLong requested = new AtomicLong();
        a<T> source;
        final AtomicReference<c> upstream = new AtomicReference<>();
        final z.c worker;
        a(m.c.b<? super T> bVar, z.c cVar, a<T> aVar, boolean z) {
            super();
            this.downstream = bVar;
            this.worker = cVar;
            this.source = aVar;
            AtomicReference atomicReference = new AtomicReference();
            AtomicLong atomicLong = new AtomicLong();
            this.nonScheduledRequests = z ^ 1;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        void a(long j, c cVar) {
            boolean nonScheduledRequests2;
            Object obj;
            if (!this.nonScheduledRequests) {
                if (Thread.currentThread() == get()) {
                    cVar.request(j);
                } else {
                    this.worker.b(new l0.a.a(cVar, j, r4));
                }
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
        public void onError(Throwable th) {
            this.downstream.onError(th);
            this.worker.dispose();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(c cVar) {
            if (g.setOnce(this.upstream, cVar)) {
                long l = 0L;
                long andSet = this.requested.getAndSet(l);
                if (andSet != l) {
                    a(andSet, cVar);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void request(long j) {
            if (g.validate(j)) {
                Object obj2 = this.upstream.get();
                if (obj2 != null) {
                    a(j, obj2);
                } else {
                    d.a(this.requested, j);
                    Object obj = this.upstream.get();
                    if (obj != null) {
                        long l = 0L;
                        long andSet = this.requested.getAndSet(l);
                        if (andSet != l) {
                            a(andSet, obj);
                        }
                    }
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void run() {
            lazySet(Thread.currentThread());
            this.source = null;
            this.source.a(this);
        }
    }
    public l0(h<T> hVar, z zVar, boolean z) {
        super(hVar);
        this.c = zVar;
        this.v = z;
    }

    @Override // i.b.m0.e.b.a
    public void c0(m.c.b<? super T> bVar) {
        z.c cVar = this.c.a();
        final i.b.m0.e.b.l0.a aVar = new l0.a(bVar, cVar, this.b, this.v);
        bVar.onSubscribe(aVar);
        cVar.b(aVar);
    }
}
