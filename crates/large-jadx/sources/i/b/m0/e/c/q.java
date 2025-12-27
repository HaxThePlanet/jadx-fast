package i.b.m0.e.c;

import i.b.m0.a.c;
import i.b.p;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeOnErrorNext.java */
/* loaded from: classes3.dex */
public final class q<T> extends a<T, T> {

    final i.b.l0.n<? super Throwable, ? extends p<? extends T>> b;
    final boolean c;

    static final class a<T> extends AtomicReference<i.b.j0.b> implements i.b.n<T>, i.b.j0.b {

        private static final long serialVersionUID = 2026620218879969836L;
        final boolean allowFatal;
        final i.b.n<? super T> downstream;
        final i.b.l0.n<? super Throwable, ? extends p<? extends T>> resumeFunction;
        a(i.b.n<? super T> nVar, i.b.l0.n<? super Throwable, ? extends p<? extends T>> nVar2, boolean z) {
            super();
            this.downstream = nVar;
            this.resumeFunction = nVar2;
            this.allowFatal = z;
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
            this.downstream.onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            if (!this.allowFatal && !(th instanceof Exception)) {
                this.downstream.onError(th);
                return;
            }
            try {
                Object apply = this.resumeFunction.apply(th);
                b.e(apply, "The resumeFunction returned a null MaybeSource");
            } catch (Throwable th) {
                a.b(th);
                int arr = 2;
                arr = new Throwable[arr];
                arr[0] = th;
                th = 1;
                arr[th] = th;
                this.downstream.onError(new CompositeException(arr));
                return;
            }
            c.replace(this, null);
            apply.b(new q.a.a(this.downstream, this));
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(i.b.j0.b bVar) {
            if (c.setOnce(this, bVar)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }
    }
    public q(p<T> pVar, i.b.l0.n<? super Throwable, ? extends p<? extends T>> nVar, boolean z) {
        super(pVar);
        this.b = nVar;
        this.c = z;
    }

    @Override // i.b.m0.e.c.a
    protected void w(i.b.n<? super T> nVar) {
        this.a.b(new q.a(nVar, this.b, this.c));
    }
}
