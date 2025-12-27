package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import io.reactivex.exceptions.CompositeException;

/* compiled from: SingleDoOnTerminate.java */
/* loaded from: classes3.dex */
public final class u<T> extends a0<T> {

    final g0<T> a;
    final i.b.l0.a b;

    final class a implements d0<T> {

        final d0<? super T> a;
        final /* synthetic */ u b;
        a(d0 d0Var) {
            this.b = uVar;
            super();
            this.a = d0Var;
        }

        public void onError(Throwable th) {
            Throwable th3;
            try {
                this.b.b.run();
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

        public void onSubscribe(b bVar) {
            this.a.onSubscribe(bVar);
        }

        public void onSuccess(T t) {
            try {
                this.b.b.run();
            } catch (Throwable th) {
                a.b(th);
                this.a.onError(th);
                return;
            }
            this.a.onSuccess(th);
        }
    }
    public u(g0<T> g0Var, i.b.l0.a aVar) {
        super();
        this.a = g0Var;
        this.b = aVar;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super T> d0Var) {
        this.a.subscribe(new u.a(this, d0Var));
    }
}
