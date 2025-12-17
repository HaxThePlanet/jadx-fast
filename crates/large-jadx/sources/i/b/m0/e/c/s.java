package i.b.m0.e.c;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.a.g;
import i.b.n;
import i.b.p;
import i.b.z;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class s<T>  extends i.b.m0.e.c.a<T, T> {

    final z b;

    static final class b implements Runnable {

        final n<? super T> a;
        final p<T> b;
        b(n<? super T> n, p<T> p2) {
            super();
            this.a = n;
            this.b = p2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.b(this.a);
        }
    }

    static final class a extends AtomicReference<b> implements n<T>, b {

        private static final long serialVersionUID = 8571289934935992137L;
        final n<? super T> downstream;
        final g task;
        a(n<? super T> n) {
            super();
            this.downstream = n;
            g obj1 = new g();
            this.task = obj1;
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
        public void onError(Throwable throwable) {
            this.downstream.onError(throwable);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            c.setOnce(this, b);
        }

        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }
    }
    public s(p<T> p, z z2) {
        super(p);
        this.b = z2;
    }

    protected void w(n<? super T> n) {
        s.a aVar = new s.a(n);
        n.onSubscribe(aVar);
        s.b bVar2 = new s.b(aVar, this.a);
        aVar.task.a(this.b.c(bVar2));
    }
}
