package i.b.m0.e.b;

import i.b.h;
import i.b.k;
import i.b.m0.i.g;
import i.b.m0.j.d;
import i.b.p0.a;
import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicLong;
import m.c.b;
import m.c.c;

/* compiled from: FlowableOnBackpressureError.java */
/* loaded from: classes3.dex */
public final class z<T> extends a<T, T> {

    static final class a<T> extends AtomicLong implements k<T>, c {

        private static final long serialVersionUID = -3176480756392482682L;
        boolean done;
        final b<? super T> downstream;
        c upstream;
        a(b<? super T> bVar) {
            super();
            this.downstream = bVar;
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.downstream.onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void onError(Throwable th) {
            if (this.done) {
                a.t(th);
                return;
            }
            this.done = true;
            this.downstream.onError(th);
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long l = get();
            if (l != 0) {
                this.downstream.onNext(t);
                AtomicLong atomicLong = 1;
                d.d(this, atomicLong);
            } else {
                onError(new MissingBackpressureException("could not emit value due to lack of requests"));
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void onSubscribe(c cVar) {
            if (g.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
                cVar.request(Long.MAX_VALUE);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void request(long j) {
            if (g.validate(j)) {
                d.a(this, j);
            }
        }
    }
    public z(h<T> hVar) {
        super(hVar);
    }

    @Override // i.b.m0.e.b.a
    protected void c0(b<? super T> bVar) {
        this.b.b0(new z.a(bVar));
    }
}
