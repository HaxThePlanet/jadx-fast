package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.l0.f;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;

/* compiled from: SingleDoOnError.java */
/* loaded from: classes3.dex */
public final class q<T> extends a0<T> {

    final g0<T> a;
    final f<? super Throwable> b;

    final class a implements d0<T> {

        private final d0<? super T> a;
        final /* synthetic */ q b;
        a(d0 d0Var) {
            this.b = qVar;
            super();
            this.a = d0Var;
        }

        public void onError(Throwable th) {
            Throwable th3;
            try {
                this.b.b.accept(th);
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
            this.a.onSuccess(t);
        }
    }
    public q(g0<T> g0Var, f<? super Throwable> fVar) {
        super();
        this.a = g0Var;
        this.b = fVar;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super T> d0Var) {
        this.a.subscribe(new q.a(this, d0Var));
    }
}
