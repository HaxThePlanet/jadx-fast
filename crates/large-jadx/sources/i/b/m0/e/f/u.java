package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.l0.a;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;

/* loaded from: classes3.dex */
public final class u<T>  extends a0<T> {

    final g0<T> a;
    final a b;

    final class a implements d0<T> {

        final d0<? super T> a;
        final i.b.m0.e.f.u b;
        a(i.b.m0.e.f.u u, d0 d02) {
            this.b = u;
            super();
            this.a = d02;
        }

        @Override // i.b.d0
        public void onError(Throwable throwable) {
            a aVar;
            CompositeException compositeException;
            int arr;
            int i;
            Object obj5;
            try {
                uVar.b.run();
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
            try {
                uVar.b.run();
                this.a.onSuccess(t);
                a.b(t);
                this.a.onError(t);
            }
        }
    }
    public u(g0<T> g0, a a2) {
        super();
        this.a = g0;
        this.b = a2;
    }

    protected void subscribeActual(d0<? super T> d0) {
        u.a aVar = new u.a(this, d0);
        this.a.subscribe(aVar);
    }
}
