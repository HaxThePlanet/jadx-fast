package i.b.m0.e.f;

import i.b.d0;
import i.b.g0;
import i.b.h;
import i.b.j0.b;
import i.b.k;
import i.b.l0.n;
import i.b.m0.b.b;
import i.b.m0.i.g;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import m.c.a;
import m.c.b;
import m.c.c;

/* loaded from: classes3.dex */
public final class c0<T, R>  extends h<R> {

    final g0<T> b;
    final n<? super T, ? extends a<? extends R>> c;

    static final class a extends AtomicLong implements d0<S>, k<T>, c {

        private static final long serialVersionUID = 7759721921468635667L;
        b disposable;
        final b<? super T> downstream;
        final n<? super S, ? extends a<? extends T>> mapper;
        final AtomicReference<c> parent;
        a(b<? super T> b, n<? super S, ? extends a<? extends T>> n2) {
            super();
            this.downstream = b;
            this.mapper = n2;
            AtomicReference obj1 = new AtomicReference();
            this.parent = obj1;
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void cancel() {
            this.disposable.dispose();
            g.cancel(this.parent);
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void onError(Throwable throwable) {
            this.downstream.onError(throwable);
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void onSubscribe(b b) {
            this.disposable = b;
            this.downstream.onSubscribe(this);
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void onSubscribe(c c) {
            g.deferredSetOnce(this.parent, this, c);
        }

        public void onSuccess(S s) {
            try {
                final Object obj2 = this.mapper.apply(s);
                b.e(obj2, "the mapper returned a null Publisher");
                (a)obj2.a(this);
                a.b(s);
                this.downstream.onError(s);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void request(long l) {
            g.deferredRequest(this.parent, this, l);
        }
    }
    public c0(g0<T> g0, n<? super T, ? extends a<? extends R>> n2) {
        super();
        this.b = g0;
        this.c = n2;
    }

    protected void c0(b<? super R> b) {
        c0.a aVar = new c0.a(b, this.c);
        this.b.subscribe(aVar);
    }
}
