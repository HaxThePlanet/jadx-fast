package i.b.m0.e.e;

import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.r;
import i.b.w;
import i.b.y;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableConcatWithSingle.java */
/* loaded from: classes3.dex */
public final class y<T> extends a<T, T> {

    final g0<? extends T> b;

    static final class a<T> extends AtomicReference<b> implements y<T>, d0<T>, b {

        private static final long serialVersionUID = -1953724749712440952L;
        final y<? super T> downstream;
        boolean inSingle;
        g0<? extends T> other;
        a(y<? super T> yVar, g0<? extends T> g0Var) {
            super();
            this.downstream = yVar;
            this.other = g0Var;
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
            this.inSingle = true;
            b bVar = null;
            c.replace(this, bVar);
            this.other = bVar;
            this.other.subscribe(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b bVar) {
            if (c.setOnce(this, bVar) && !this.inSingle) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSuccess(T t) {
            this.downstream.onNext(t);
            this.downstream.onComplete();
        }
    }
    public y(r<T> rVar, g0<? extends T> g0Var) {
        super(rVar);
        this.b = g0Var;
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super T> yVar) {
        this.a.subscribe(new y.a(yVar, this.b));
    }
}
