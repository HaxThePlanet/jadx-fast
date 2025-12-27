package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.e;
import i.b.m0.a.g;
import i.b.r;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableRepeatUntil.java */
/* loaded from: classes3.dex */
public final class q2<T> extends a<T, T> {

    final e b;

    static final class a<T> extends AtomicInteger implements y<T> {

        private static final long serialVersionUID = -7098360935104053232L;
        final y<? super T> downstream;
        final w<? extends T> source;
        final e stop;
        final g upstream;
        a(y<? super T> yVar, e eVar, g gVar, w<? extends T> wVar) {
            super();
            this.downstream = yVar;
            this.upstream = gVar;
            this.source = wVar;
            this.stop = eVar;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            int andIncrement = 1;
            if (getAndIncrement() == 0) {
                andIncrement = 1;
                this.source.subscribe(this);
                while (addAndGet(-andIncrement) == 0) {
                    this.source.subscribe(this);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            try {
            } catch (Throwable th) {
                a.b(th);
                this.downstream.onError(th);
                return;
            }
            if (this.stop.a()) {
                this.downstream.onComplete();
            } else {
                a();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(b bVar) {
            this.upstream.a(bVar);
        }
    }
    public q2(r<T> rVar, e eVar) {
        super(rVar);
        this.b = eVar;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super T> yVar) {
        final g gVar = new g();
        yVar.onSubscribe(gVar);
        new q2.a(yVar, this.b, gVar, this.a).a();
    }
}
