package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.l0.f;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;

/* loaded from: classes3.dex */
public final class q<T>  extends a0<T> {

    final g0<T> a;
    final f<? super Throwable> b;

    final class a implements d0<T> {

        private final d0<? super T> a;
        final i.b.m0.e.f.q b;
        a(i.b.m0.e.f.q q, d0 d02) {
            this.b = q;
            super();
            this.a = d02;
        }

        @Override // i.b.d0
        public void onError(Throwable throwable) {
            f fVar;
            CompositeException compositeException;
            int arr;
            int i;
            Object obj5;
            try {
                qVar.b.accept(throwable);
                a.b(th);
                arr = 2;
                arr = new Throwable[arr];
                arr[0] = throwable;
                throwable = 1;
                arr[throwable] = th;
                compositeException = new CompositeException(arr);
                throwable = compositeException;
                this.a.onError(obj5);
            }
        }

        @Override // i.b.d0
        public void onSubscribe(b b) {
            this.a.onSubscribe(b);
        }

        public void onSuccess(T t) {
            this.a.onSuccess(t);
        }
    }
    public q(g0<T> g0, f<? super Throwable> f2) {
        super();
        this.a = g0;
        this.b = f2;
    }

    protected void subscribeActual(d0<? super T> d0) {
        q.a aVar = new q.a(this, d0);
        this.a.subscribe(aVar);
    }
}
