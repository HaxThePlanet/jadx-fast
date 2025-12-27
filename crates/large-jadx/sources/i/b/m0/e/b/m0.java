package i.b.m0.e.b;

import i.b.h;
import i.b.k;
import i.b.m0.i.d;
import i.b.m0.i.g;
import io.reactivex.exceptions.a;
import java.util.Collection;
import java.util.concurrent.Callable;

/* compiled from: FlowableToList.java */
/* loaded from: classes3.dex */
public final class m0<T, U extends Collection<? super T>> extends a<T, U> {

    final Callable<U> c;

    static final class a<T, U extends Collection<? super T>> extends i.b.m0.i.c<U> implements k<T>, m.c.c {

        private static final long serialVersionUID = -8134157938864266736L;
        m.c.c upstream;
        a(m.c.b<? super U> bVar, U u) {
            super(bVar);
            this.value = u;
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
        public void onError(Throwable th) {
            this.value = null;
            this.downstream.onError(th);
        }

        @Override // i.b.m0.i.c
        public void onNext(T t) {
            if (value2 != null) {
                value2.add(t);
            }
        }

        @Override // i.b.m0.i.c
        public void onSubscribe(m.c.c cVar) {
            if (g.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
                cVar.request(Long.MAX_VALUE);
            }
        }
    }
    public m0(h<T> hVar, Callable<U> callable) {
        super(hVar);
        this.c = callable;
    }

    @Override // i.b.m0.e.b.a
    protected void c0(m.c.b<? super U> bVar) {
        try {
            Object call = this.c.call();
            b.e(call, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            a.b(th);
            d.error(th, bVar);
            return;
        }
        this.b.b0(new m0.a(bVar, call));
    }
}
