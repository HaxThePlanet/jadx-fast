package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;

/* compiled from: SingleDoOnEvent.java */
/* loaded from: classes3.dex */
public final class r<T> extends a0<T> {

    final g0<T> a;
    final i.b.l0.b<? super T, ? super Throwable> b;

    final class a implements d0<T> {

        private final d0<? super T> a;
        final /* synthetic */ r b;
        a(d0 d0Var) {
            this.b = rVar;
            super();
            this.a = d0Var;
        }

        public void onError(Throwable th) {
            Throwable th3;
            try {
                Object obj = null;
                this.b.b.a(obj, th);
            } catch (Throwable th) {
                a.b(th);
                int arr = 2;
                arr = new Throwable[arr];
                arr[0] = th;
                th = 1;
                arr[th] = th;
                th = new CompositeException(arr);
            }
            this.a.onError(th3);
        }

        public void onSubscribe(i.b.j0.b bVar) {
            this.a.onSubscribe(bVar);
        }

        public void onSuccess(T t) {
            try {
                this.b.b.a(t, null);
            } catch (Throwable th) {
                a.b(th);
                this.a.onError(th);
                return;
            }
            this.a.onSuccess(th);
        }
    }
    public r(g0<T> g0Var, i.b.l0.b<? super T, ? super Throwable> bVar) {
        super();
        this.a = g0Var;
        this.b = bVar;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super T> d0Var) {
        this.a.subscribe(new r.a(this, d0Var));
    }
}
