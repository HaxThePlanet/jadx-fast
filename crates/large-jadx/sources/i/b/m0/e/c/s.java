package i.b.m0.e.c;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.a.g;
import i.b.n;
import i.b.p;
import i.b.z;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeSubscribeOn.java */
/* loaded from: classes3.dex */
public final class s<T> extends a<T, T> {

    final z b;

    static final class b<T> implements Runnable {

        final n<? super T> a;
        final p<T> b;
        b(n<? super T> nVar, p<T> pVar) {
            super();
            this.a = nVar;
            this.b = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.b(this.a);
        }
    }

    static final class a<T> extends AtomicReference<b> implements n<T>, b {

        private static final long serialVersionUID = 8571289934935992137L;
        final n<? super T> downstream;
        final g task = new g();
        a(n<? super T> nVar) {
            super();
            this.downstream = nVar;
            final g gVar = new g();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this);
            this.task.dispose();
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
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b bVar) {
            c.setOnce(this, bVar);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }
    }
    public s(p<T> pVar, z zVar) {
        super(pVar);
        this.b = zVar;
    }

    @Override // i.b.m0.e.c.a
    protected void w(n<? super T> nVar) {
        i.b.m0.e.c.s.a aVar = new s.a(nVar);
        nVar.onSubscribe(aVar);
        aVar.task.a(this.b.c(new s.b(aVar, this.a)));
    }
}
