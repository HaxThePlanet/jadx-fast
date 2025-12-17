package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.l0.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;

/* loaded from: classes3.dex */
public final class r<T>  extends a0<T> {

    final g0<T> a;
    final b<? super T, ? super Throwable> b;

    final class a implements d0<T> {

        private final d0<? super T> a;
        final i.b.m0.e.f.r b;
        a(i.b.m0.e.f.r r, d0 d02) {
            this.b = r;
            super();
            this.a = d02;
        }

        @Override // i.b.d0
        public void onError(Throwable throwable) {
            b bVar;
            int i2;
            int arr;
            int i;
            Object obj5;
            try {
                rVar.b.a(0, throwable);
                a.b(th);
                arr = 2;
                arr = new Throwable[arr];
                arr[0] = throwable;
                throwable = 1;
                arr[throwable] = th;
                CompositeException compositeException = new CompositeException(arr);
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
                rVar.b.a(t, 0);
                this.a.onSuccess(t);
                a.b(t);
                this.a.onError(t);
            }
        }
    }
    public r(g0<T> g0, b<? super T, ? super Throwable> b2) {
        super();
        this.a = g0;
        this.b = b2;
    }

    protected void subscribeActual(d0<? super T> d0) {
        r.a aVar = new r.a(this, d0);
        this.a.subscribe(aVar);
    }
}
