package i.b.m0.e.e;

import i.b.d;
import i.b.f;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.r;
import i.b.w;
import i.b.y;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableConcatWithCompletable.java */
/* loaded from: classes3.dex */
public final class w<T> extends a<T, T> {

    final f b;

    static final class a<T> extends AtomicReference<b> implements y<T>, d, b {

        private static final long serialVersionUID = -1953724749712440952L;
        final y<? super T> downstream;
        boolean inCompletable;
        f other;
        a(y<? super T> yVar, f fVar) {
            super();
            this.downstream = yVar;
            this.other = fVar;
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
            if (this.inCompletable) {
                this.downstream.onComplete();
            } else {
                this.inCompletable = true;
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
            if (c.setOnce(this, bVar) && !this.inCompletable) {
                this.downstream.onSubscribe(this);
            }
        }
    }
    public w(r<T> rVar, f fVar) {
        super(rVar);
        this.b = fVar;
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super T> yVar) {
        this.a.subscribe(new w.a(yVar, this.b));
    }
}
