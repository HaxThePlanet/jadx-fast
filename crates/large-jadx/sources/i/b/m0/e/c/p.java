package i.b.m0.e.c;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.n;
import i.b.p;
import i.b.z;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeObserveOn.java */
/* loaded from: classes3.dex */
public final class p<T> extends a<T, T> {

    final z b;

    static final class a<T> extends AtomicReference<b> implements n<T>, b, Runnable {

        private static final long serialVersionUID = 8571289934935992137L;
        final n<? super T> downstream;
        Throwable error;
        final z scheduler;
        T value;
        a(n<? super T> nVar, z zVar) {
            super();
            this.downstream = nVar;
            this.scheduler = zVar;
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
            c.replace(this, this.scheduler.c(this));
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            this.error = th;
            c.replace(this, this.scheduler.c(this));
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b bVar) {
            if (c.setOnce(this, bVar)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSuccess(T t) {
            this.value = t;
            c.replace(this, this.scheduler.c(this));
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void run() {
            Throwable th = null;
            if (this.error != null) {
                this.error = th;
                this.downstream.onError(this.error);
            } else {
                if (this.value != null) {
                    this.value = th;
                    this.downstream.onSuccess(this.value);
                } else {
                    this.downstream.onComplete();
                }
            }
        }
    }
    public p(p<T> pVar, z zVar) {
        super(pVar);
        this.b = zVar;
    }

    @Override // i.b.m0.e.c.a
    protected void w(n<? super T> nVar) {
        this.a.b(new p.a(nVar, this.b));
    }
}
