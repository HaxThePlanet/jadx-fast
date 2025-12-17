package i.b.m0.e.b;

import i.b.h;
import i.b.k;
import i.b.l0.n;
import i.b.m0.b.b;
import i.b.m0.i.d;
import i.b.m0.i.f;
import i.b.m0.i.g;
import i.b.q0.a;
import i.b.q0.c;
import i.b.u0.a;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import m.c.a;
import m.c.b;
import m.c.c;

/* loaded from: classes3.dex */
public final class e0<T>  extends i.b.m0.e.b.a<T, T> {

    final n<? super h<Object>, ? extends a<?>> c;

    static final class b extends AtomicInteger implements k<Object>, c {

        private static final long serialVersionUID = 2827772011130406689L;
        final AtomicLong requested;
        final a<T> source;
        i.b.m0.e.b.e0.c<T, U> subscriber;
        final AtomicReference<c> upstream;
        b(a<T> a) {
            super();
            this.source = a;
            AtomicReference obj1 = new AtomicReference();
            this.upstream = obj1;
            obj1 = new AtomicLong();
            this.requested = obj1;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void cancel() {
            g.cancel(this.upstream);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            this.subscriber.cancel();
            subscriber2.downstream.onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable throwable) {
            this.subscriber.cancel();
            subscriber2.downstream.onError(throwable);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onNext(Object object) {
            i.b.m0.e.b.e0.c subscriber;
            int obj2;
            if (getAndIncrement() == 0) {
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(c c) {
            g.deferredSetOnce(this.upstream, this.requested, c);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void request(long l) {
            g.deferredRequest(this.upstream, this.requested, l);
        }
    }

    static abstract class c extends f implements k<T> {

        private static final long serialVersionUID = -5604623027276966720L;
        protected final b<? super T> downstream;
        protected final a<U> processor;
        private long produced;
        protected final c receiver;
        c(b<? super T> b, a<U> a2, c c3) {
            super(0);
            this.downstream = b;
            this.processor = a2;
            this.receiver = c3;
        }

        @Override // i.b.m0.i.f
        public final void cancel() {
            super.cancel();
            this.receiver.cancel();
        }

        protected final void h(U u) {
            g(d.INSTANCE);
            long produced = this.produced;
            final int i2 = 0;
            if (Long.compare(produced, i2) != 0) {
                this.produced = i2;
                f(produced);
            }
            this.receiver.request(1);
            this.processor.onNext(u);
        }

        public final void onNext(T t) {
            this.produced = produced += i2;
            this.downstream.onNext(t);
        }

        @Override // i.b.m0.i.f
        public final void onSubscribe(c c) {
            g(c);
        }
    }

    static final class a extends i.b.m0.e.b.e0.c<T, Object> {

        private static final long serialVersionUID = -2680129890138081029L;
        a(b<? super T> b, a<Object> a2, c c3) {
            super(b, a2, c3);
        }

        @Override // i.b.m0.e.b.e0$c
        public void onComplete() {
            h(0);
        }

        @Override // i.b.m0.e.b.e0$c
        public void onError(Throwable throwable) {
            this.receiver.cancel();
            this.downstream.onError(throwable);
        }
    }
    public e0(h<T> h, n<? super h<Object>, ? extends a<?>> n2) {
        super(h);
        this.c = n2;
    }

    public void c0(b<? super T> b) {
        a aVar = new a(b);
        a aVar2 = c.i0(8).g0();
        Object apply = this.c.apply(aVar2);
        b.e(apply, "handler returned a null Publisher");
        e0.b bVar = new e0.b(this.b);
        e0.a aVar3 = new e0.a(aVar, aVar2, bVar);
        bVar.subscriber = aVar3;
        b.onSubscribe(aVar3);
        (a)apply.a(bVar);
        bVar.onNext(0);
    }
}
