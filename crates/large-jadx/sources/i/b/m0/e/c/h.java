package i.b.m0.e.c;

import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.n;
import i.b.p;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class h<T, R>  extends i.b.m0.e.c.a<T, R> {

    final n<? super T, ? extends p<? extends R>> b;

    static final class a extends AtomicReference<b> implements n<T>, b {

        private static final long serialVersionUID = 4375739915521278546L;
        final n<? super R> downstream;
        final n<? super T, ? extends p<? extends R>> mapper;
        b upstream;
        a(n<? super R> n, n<? super T, ? extends p<? extends R>> n2) {
            super();
            this.downstream = n;
            this.mapper = n2;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this);
            this.upstream.dispose();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            return c.isDisposed((b)get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            this.downstream.onError(throwable);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.upstream, b)) {
                this.upstream = b;
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            boolean aVar;
            try {
                final Object obj2 = this.mapper.apply(t);
                b.e(obj2, "The mapper returned a null MaybeSource");
                if (!isDisposed()) {
                }
                aVar = new h.a.a(this);
                (p)obj2.b(aVar);
                a.b(t);
                this.downstream.onError(t);
            }
        }
    }
    public h(p<T> p, n<? super T, ? extends p<? extends R>> n2) {
        super(p);
        this.b = n2;
    }

    protected void w(n<? super R> n) {
        h.a aVar = new h.a(n, this.b);
        this.a.b(aVar);
    }
}
