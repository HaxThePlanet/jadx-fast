package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.l0.n;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;

/* compiled from: SingleOnErrorReturn.java */
/* loaded from: classes3.dex */
public final class o0<T> extends a0<T> {

    final g0<? extends T> a;
    final n<? super Throwable, ? extends T> b;
    final T c;

    final class a implements d0<T> {

        private final d0<? super T> a;
        final /* synthetic */ o0 b;
        a(d0 d0Var) {
            this.b = o0Var;
            super();
            this.a = d0Var;
        }

        public void onError(Throwable th) {
            Object apply;
            if (o0Var.b != null) {
                try {
                    apply = o0Var.b.apply(th);
                } catch (Throwable th) {
                    a.b(th);
                    int arr = 2;
                    arr = new Throwable[arr];
                    arr[0] = th;
                    th = 1;
                    arr[th] = th;
                    this.a.onError(new CompositeException(arr));
                    return;
                }
            } else {
            }
            if (o0Var.c == null) {
                java.lang.NullPointerException nullPointerException = new NullPointerException("Value supplied was null");
                nullPointerException.initCause(th);
                this.a.onError(nullPointerException);
                return;
            }
            this.a.onSuccess(apply);
        }

        public void onSubscribe(b bVar) {
            this.a.onSubscribe(bVar);
        }

        public void onSuccess(T t) {
            this.a.onSuccess(t);
        }
    }
    public o0(g0<? extends T> g0Var, n<? super Throwable, ? extends T> nVar, T t) {
        super();
        this.a = g0Var;
        this.b = nVar;
        this.c = t;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super T> d0Var) {
        this.a.subscribe(new o0.a(this, d0Var));
    }
}
