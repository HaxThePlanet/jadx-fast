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

/* loaded from: classes3.dex */
public final class z<T>  extends i.b.m0.e.b.a<T, T> {

    static final class a extends AtomicLong implements k<T>, c {

        private static final long serialVersionUID = -3176480756392482682L;
        boolean done;
        final b<? super T> downstream;
        c upstream;
        a(b<? super T> b) {
            super();
            this.downstream = b;
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void onComplete() {
            if (this.done) {
            }
            this.done = true;
            this.downstream.onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void onError(Throwable throwable) {
            if (this.done) {
                a.t(throwable);
            }
            this.done = true;
            this.downstream.onError(throwable);
        }

        public void onNext(T t) {
            int str;
            Object obj5;
            if (this.done) {
            }
            if (Long.compare(l, i) != 0) {
                this.downstream.onNext(t);
                d.d(this, 1);
            } else {
                obj5 = new MissingBackpressureException("could not emit value due to lack of requests");
                onError(obj5);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void onSubscribe(c c) {
            boolean validate;
            if (g.validate(this.upstream, c)) {
                this.upstream = c;
                this.downstream.onSubscribe(this);
                c.request(Long.MAX_VALUE);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void request(long l) {
            if (g.validate(l)) {
                d.a(this, l);
            }
        }
    }
    public z(h<T> h) {
        super(h);
    }

    protected void c0(b<? super T> b) {
        z.a aVar = new z.a(b);
        this.b.b0(aVar);
    }
}
