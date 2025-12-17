package i.b.m0.e.c;

import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.n;
import i.b.p;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class q<T>  extends i.b.m0.e.c.a<T, T> {

    final n<? super Throwable, ? extends p<? extends T>> b;
    final boolean c;

    static final class a extends AtomicReference<b> implements n<T>, b {

        private static final long serialVersionUID = 2026620218879969836L;
        final boolean allowFatal;
        final n<? super T> downstream;
        final n<? super Throwable, ? extends p<? extends T>> resumeFunction;
        a(n<? super T> n, n<? super Throwable, ? extends p<? extends T>> n2, boolean z3) {
            super();
            this.downstream = n;
            this.resumeFunction = n2;
            this.allowFatal = z3;
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
        public void onError(Throwable throwable) {
            boolean allowFatal;
            if (!this.allowFatal && throwable instanceof Exception == null) {
                if (throwable instanceof Exception == null) {
                    this.downstream.onError(throwable);
                }
            }
            Object apply = this.resumeFunction.apply(throwable);
            b.e(apply, "The resumeFunction returned a null MaybeSource");
            c.replace(this, 0);
            q.a.a obj6 = new q.a.a(this.downstream, this);
            (p)apply.b(obj6);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            boolean obj1;
            if (c.setOnce(this, b)) {
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }
    }
    public q(p<T> p, n<? super Throwable, ? extends p<? extends T>> n2, boolean z3) {
        super(p);
        this.b = n2;
        this.c = z3;
    }

    protected void w(n<? super T> n) {
        q.a aVar = new q.a(n, this.b, this.c);
        this.a.b(aVar);
    }
}
