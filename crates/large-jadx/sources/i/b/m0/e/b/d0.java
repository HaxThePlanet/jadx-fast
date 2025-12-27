package i.b.m0.e.b;

import i.b.h;
import i.b.k;
import i.b.l0.e;
import i.b.m0.i.f;
import java.util.concurrent.atomic.AtomicInteger;
import m.c.b;
import m.c.c;

/* compiled from: FlowableRepeatUntil.java */
/* loaded from: classes3.dex */
public final class d0<T> extends a<T, T> {

    final e c;

    static final class a<T> extends AtomicInteger implements k<T> {

        private static final long serialVersionUID = -7098360935104053232L;
        final b<? super T> downstream;
        long produced;
        final f sa;
        final m.c.a<? extends T> source;
        final e stop;
        a(b<? super T> bVar, e eVar, f fVar, m.c.a<? extends T> aVar) {
            super();
            this.downstream = bVar;
            this.sa = fVar;
            this.source = aVar;
            this.stop = eVar;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            int andIncrement = 1;
            long l = 0;
            if (getAndIncrement() == 0) {
                andIncrement = 1;
                while (this.sa.d()) {
                    l = 0L;
                    this.source.a(this);
                    if (addAndGet(-andIncrement) == 0) {
                        return;
                    }
                }
                return;
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
            this.produced++;
            this.downstream.onNext(t);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(c cVar) {
            this.sa.g(cVar);
        }
    }
    public d0(h<T> hVar, e eVar) {
        super(hVar);
        this.c = eVar;
    }

    @Override // i.b.m0.e.b.a
    public void c0(b<? super T> bVar) {
        final f fVar = new f(false);
        bVar.onSubscribe(fVar);
        new d0.a(bVar, this.c, fVar, this.b).a();
    }
}
