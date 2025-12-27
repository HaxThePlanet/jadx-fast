package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.n;
import i.b.p;
import i.b.r;
import i.b.w;
import i.b.y;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableConcatWithMaybe.java */
/* loaded from: classes3.dex */
public final class x<T> extends a<T, T> {

    final p<? extends T> b;

    static final class a<T> extends AtomicReference<b> implements y<T>, n<T>, b {

        private static final long serialVersionUID = -1953724749712440952L;
        final y<? super T> downstream;
        boolean inMaybe;
        p<? extends T> other;
        a(y<? super T> yVar, p<? extends T> pVar) {
            super();
            this.downstream = yVar;
            this.other = pVar;
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
            if (this.inMaybe) {
                this.downstream.onComplete();
            } else {
                this.inMaybe = true;
                b bVar = null;
                c.replace(this, bVar);
                this.other = bVar;
                this.other.b(this);
            }
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
            if (c.setOnce(this, bVar) && !this.inMaybe) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSuccess(T t) {
            this.downstream.onNext(t);
            this.downstream.onComplete();
        }
    }
    public x(r<T> rVar, p<? extends T> pVar) {
        super(rVar);
        this.b = pVar;
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super T> yVar) {
        this.a.subscribe(new x.a(yVar, this.b));
    }
}
