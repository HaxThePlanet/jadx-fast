package i.b.m0.e.e;

import i.b.d;
import i.b.f;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.r;
import i.b.w;
import i.b.y;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class w<T>  extends i.b.m0.e.e.a<T, T> {

    final f b;

    static final class a extends AtomicReference<b> implements y<T>, d, b {

        private static final long serialVersionUID = -1953724749712440952L;
        final y<? super T> downstream;
        boolean inCompletable;
        f other;
        a(y<? super T> y, f f2) {
            super();
            this.downstream = y;
            this.other = f2;
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
            y downstream;
            f other;
            if (this.inCompletable) {
                this.downstream.onComplete();
            } else {
                this.inCompletable = true;
                downstream = 0;
                c.replace(this, downstream);
                this.other = downstream;
                this.other.b(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            this.downstream.onError(throwable);
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            boolean obj1;
            if (c.setOnce(this, b) && !this.inCompletable) {
                if (!this.inCompletable) {
                    this.downstream.onSubscribe(this);
                }
            }
        }
    }
    public w(r<T> r, f f2) {
        super(r);
        this.b = f2;
    }

    protected void subscribeActual(y<? super T> y) {
        w.a aVar = new w.a(y, this.b);
        this.a.subscribe(aVar);
    }
}
