package i.b.m0.e.b;

import i.b.h;
import i.b.k;
import i.b.l0.f;
import i.b.m0.i.g;
import i.b.m0.j.d;
import java.util.concurrent.atomic.AtomicLong;
import m.c.b;
import m.c.c;

/* compiled from: FlowableOnBackpressureDrop.java */
/* loaded from: classes3.dex */
public final class y<T> extends a<T, T> implements f<T> {

    final f<? super T> c;

    static final class a<T> extends AtomicLong implements k<T>, c {

        private static final long serialVersionUID = -6246093802440953054L;
        boolean done;
        final b<? super T> downstream;
        final f<? super T> onDrop;
        c upstream;
        a(b<? super T> bVar, f<? super T> fVar) {
            super();
            this.downstream = bVar;
            this.onDrop = fVar;
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
                try {
                    this.onDrop.accept(t);
                } catch (Throwable th) {
                    a.b(th);
                    cancel();
                    onError(th);
                }
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
    public y(h<T> hVar) {
        super(hVar);
        this.c = this;
    }

    @Override // i.b.m0.e.b.a
    protected void c0(b<? super T> bVar) {
        this.b.b0(new y.a(bVar, this.c));
    }

    @Override // i.b.m0.e.b.a
    public void accept(T t) {
    }
}
