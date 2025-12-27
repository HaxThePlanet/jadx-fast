package i.b.m0.e.c;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.n;
import i.b.p;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeSwitchIfEmpty.java */
/* loaded from: classes3.dex */
public final class t<T> extends a<T, T> {

    final p<? extends T> b;

    static final class a<T> extends AtomicReference<b> implements n<T>, b {

        private static final long serialVersionUID = -2223459372976438024L;
        final n<? super T> downstream;
        final p<? extends T> other;
        a(n<? super T> nVar, p<? extends T> pVar) {
            super();
            this.downstream = nVar;
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
            Object obj = get();
            if (obj != c.DISPOSED) {
                if (compareAndSet(obj, null)) {
                    this.other.b(new t.a.a(this.downstream, this));
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b bVar) {
            if (c.setOnce(this, bVar)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }
    }
    public t(p<T> pVar, p<? extends T> pVar2) {
        super(pVar);
        this.b = pVar2;
    }

    @Override // i.b.m0.e.c.a
    protected void w(n<? super T> nVar) {
        this.a.b(new t.a(nVar, this.b));
    }
}
