package i.b.m0.e.b;

import i.b.h;
import i.b.k;
import i.b.l0.d;
import i.b.m0.i.f;
import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicInteger;
import m.c.b;
import m.c.c;

/* compiled from: FlowableRetryBiPredicate.java */
/* loaded from: classes3.dex */
public final class f0<T> extends a<T, T> {

    final d<? super Integer, ? super Throwable> c;

    static final class a<T> extends AtomicInteger implements k<T> {

        private static final long serialVersionUID = -7098360935104053232L;
        final b<? super T> downstream;
        final d<? super Integer, ? super Throwable> predicate;
        long produced;
        int retries;
        final f sa;
        final m.c.a<? extends T> source;
        a(b<? super T> bVar, d<? super Integer, ? super Throwable> dVar, f fVar, m.c.a<? extends T> aVar) {
            super();
            this.downstream = bVar;
            this.sa = fVar;
            this.source = aVar;
            this.predicate = dVar;
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
            this.downstream.onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable th) {
            try {
                this.retries++;
            } catch (Throwable th) {
                a.b(th);
                int arr = 2;
                arr = new Throwable[arr];
                arr[0] = th;
                arr[i] = th;
                this.downstream.onError(new CompositeException(arr));
                return;
            }
            if (!this.predicate.a(Integer.valueOf(i3), th)) {
                this.downstream.onError(th);
                return;
            }
            a();
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
    public f0(h<T> hVar, d<? super Integer, ? super Throwable> dVar) {
        super(hVar);
        this.c = dVar;
    }

    @Override // i.b.m0.e.b.a
    public void c0(b<? super T> bVar) {
        final f fVar = new f(false);
        bVar.onSubscribe(fVar);
        new f0.a(bVar, this.c, fVar, this.b).a();
    }
}
