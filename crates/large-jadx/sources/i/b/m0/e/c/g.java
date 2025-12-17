package i.b.m0.e.c;

import i.b.b;
import i.b.d;
import i.b.f;
import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.n;
import i.b.p;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class g<T>  extends b {

    final p<T> a;
    final n<? super T, ? extends f> b;

    static final class a extends AtomicReference<b> implements n<T>, d, b {

        private static final long serialVersionUID = -2177128922851101253L;
        final d downstream;
        final n<? super T, ? extends f> mapper;
        a(d d, n<? super T, ? extends f> n2) {
            super();
            this.downstream = d;
            this.mapper = n2;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this);
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
            c.replace(this, b);
        }

        public void onSuccess(T t) {
            try {
                final Object obj2 = this.mapper.apply(t);
                b.e(obj2, "The mapper returned a null CompletableSource");
                if (!isDisposed()) {
                }
                (f)obj2.b(this);
                a.b(t);
                onError(t);
            }
        }
    }
    public g(p<T> p, n<? super T, ? extends f> n2) {
        super();
        this.a = p;
        this.b = n2;
    }

    @Override // i.b.b
    protected void x(d d) {
        g.a aVar = new g.a(d, this.b);
        d.onSubscribe(aVar);
        this.a.b(aVar);
    }
}
