package i.b.m0.e.b;

import i.b.h;
import i.b.k;
import i.b.m0.b.b;
import i.b.m0.i.c;
import i.b.m0.i.d;
import i.b.m0.i.g;
import io.reactivex.exceptions.a;
import java.util.Collection;
import java.util.concurrent.Callable;
import m.c.b;
import m.c.c;

/* loaded from: classes3.dex */
public final class m0<T, U extends Collection<? super T>>  extends i.b.m0.e.b.a<T, U> {

    final Callable<U> c;

    static final class a extends c<U> implements k<T>, c {

        private static final long serialVersionUID = -8134157938864266736L;
        c upstream;
        a(b<? super U> b, U u2) {
            super(b);
            this.value = u2;
        }

        @Override // i.b.m0.i.c
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }

        @Override // i.b.m0.i.c
        public void onComplete() {
            a(this.value);
        }

        @Override // i.b.m0.i.c
        public void onError(Throwable throwable) {
            this.value = 0;
            this.downstream.onError(throwable);
        }

        public void onNext(T t) {
            final Object value = this.value;
            if ((Collection)value != null) {
                (Collection)value.add(t);
            }
        }

        @Override // i.b.m0.i.c
        public void onSubscribe(c c) {
            boolean validate;
            if (g.validate(this.upstream, c)) {
                this.upstream = c;
                this.downstream.onSubscribe(this);
                c.request(Long.MAX_VALUE);
            }
        }
    }
    public m0(h<T> h, Callable<U> callable2) {
        super(h);
        this.c = callable2;
    }

    protected void c0(b<? super U> b) {
        try {
            Object call = this.c.call();
            b.e(call, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
            m0.a aVar = new m0.a(b, (Collection)call);
            this.b.b0(aVar);
            a.b(th);
            d.error(th, b);
        }
    }
}
