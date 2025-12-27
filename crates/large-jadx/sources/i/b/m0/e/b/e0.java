package i.b.m0.e.b;

import i.b.h;
import i.b.k;
import i.b.l0.n;
import i.b.m0.i.d;
import i.b.m0.i.f;
import i.b.m0.i.g;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableRepeatWhen.java */
/* loaded from: classes3.dex */
public final class e0<T> extends a<T, T> {

    final n<? super h<Object>, ? extends m.c.a<?>> c;

    static final class b<T, U> extends AtomicInteger implements k<Object>, m.c.c {

        private static final long serialVersionUID = 2827772011130406689L;
        final AtomicLong requested = new AtomicLong();
        final m.c.a<T> source;
        e0.c<T, U> subscriber;
        final AtomicReference<m.c.c> upstream = new AtomicReference<>();
        b(m.c.a<T> aVar) {
            super();
            this.source = aVar;
            AtomicReference atomicReference = new AtomicReference();
            AtomicLong atomicLong = new AtomicLong();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void cancel() {
            g.cancel(this.upstream);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            this.subscriber.cancel();
            this.subscriber.downstream.onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable th) {
            this.subscriber.cancel();
            this.subscriber.downstream.onError(th);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onNext(Object object) {
            if (getAndIncrement() == 0) {
                while (this.upstream.get() == g.CANCELLED) {
                    this.source.a(this.subscriber);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                return;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(m.c.c cVar) {
            g.deferredSetOnce(this.upstream, this.requested, cVar);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void request(long j) {
            g.deferredRequest(this.upstream, this.requested, j);
        }
    }

    static abstract class c<T, U> extends f implements k<T> {

        private static final long serialVersionUID = -5604623027276966720L;
        protected final m.c.b<? super T> downstream;
        protected final i.b.q0.a<U> processor;
        private long produced;
        protected final m.c.c receiver;
        c(m.c.b<? super T> bVar, i.b.q0.a<U> aVar, m.c.c cVar) {
            super(false);
            this.downstream = bVar;
            this.processor = aVar;
            this.receiver = cVar;
        }

        @Override // i.b.m0.i.f
        public final void cancel() {
            super.cancel();
            this.receiver.cancel();
        }

        @Override // i.b.m0.i.f
        protected final void h(U u) {
            g(d.INSTANCE);
            final long l = 0L;
            if (this.produced != l) {
                this.produced = l;
                f(this.produced);
            }
            this.receiver.request(1L);
            this.processor.onNext(u);
        }

        @Override // i.b.m0.i.f
        public final void onNext(T t) {
            this.produced++;
            this.downstream.onNext(t);
        }

        @Override // i.b.m0.i.f
        public final void onSubscribe(m.c.c cVar) {
            g(cVar);
        }
    }

    static final class a<T> extends e0.c<T, Object> {

        private static final long serialVersionUID = -2680129890138081029L;
        a(m.c.b<? super T> bVar, i.b.q0.a<Object> aVar, m.c.c cVar) {
            super(bVar, aVar, cVar);
        }

        @Override // i.b.m0.e.b.e0$c
        public void onComplete() {
            h(null);
        }

        @Override // i.b.m0.e.b.e0$c
        public void onError(Throwable th) {
            this.receiver.cancel();
            this.downstream.onError(th);
        }
    }
    public e0(h<T> hVar, n<? super h<Object>, ? extends m.c.a<?>> nVar) {
        super(hVar);
        this.c = nVar;
    }

    @Override // i.b.m0.e.b.a
    public void c0(m.c.b<? super T> bVar) {
        i.b.q0.a aVar2 = c.i0(8).g0();
        try {
            Object apply = this.c.apply(aVar2);
            b.e(apply, "handler returned a null Publisher");
        } catch (Throwable th) {
            a.b(th);
            d.error(th, bVar);
            return;
        }
        i.b.m0.e.b.e0.b bVar2 = new e0.b(this.b);
        i.b.m0.e.b.e0.a aVar3 = new e0.a(new a(bVar), aVar2, bVar2);
        bVar2.subscriber = aVar3;
        bVar.onSubscribe(aVar3);
        apply.a(bVar2);
        bVar2.onNext(null);
    }
}
