package i.b.m0.e.b;

import i.b.h;
import i.b.k;
import i.b.l0.f;
import i.b.m0.i.g;
import i.b.m0.j.d;
import i.b.p0.a;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicLong;
import m.c.b;
import m.c.c;

/* loaded from: classes3.dex */
public final class y<T>  extends i.b.m0.e.b.a<T, T> implements f<T> {

    final f<? super T> c;

    static final class a extends AtomicLong implements k<T>, c {

        private static final long serialVersionUID = -6246093802440953054L;
        boolean done;
        final b<? super T> downstream;
        final f<? super T> onDrop;
        c upstream;
        a(b<? super T> b, f<? super T> f2) {
            super();
            this.downstream = b;
            this.onDrop = f2;
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
            int onDrop;
            Object obj5;
            if (this.done) {
            }
            if (Long.compare(l, i) != 0) {
                this.downstream.onNext(t);
                d.d(this, 1);
            } else {
                this.onDrop.accept(t);
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
    public y(h<T> h) {
        super(h);
        this.c = this;
    }

    public void accept(T t) {
    }

    protected void c0(b<? super T> b) {
        y.a aVar = new y.a(b, this.c);
        this.b.b0(aVar);
    }
}
