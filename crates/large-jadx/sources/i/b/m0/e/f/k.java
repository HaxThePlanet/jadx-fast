package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.l;
import i.b.m0.a.c;
import i.b.q;
import io.reactivex.exceptions.a;

/* compiled from: SingleDematerialize.java */
/* loaded from: classes3.dex */
public final class k<T, R> extends l<R> {

    final a0<T> a;
    final i.b.l0.n<? super T, q<R>> b;

    static final class a<T, R> implements d0<T>, i.b.j0.b {

        final i.b.n<? super R> a;
        final i.b.l0.n<? super T, q<R>> b;
        i.b.j0.b c;
        a(i.b.n<? super R> nVar, i.b.l0.n<? super T, q<R>> nVar2) {
            super();
            this.a = nVar;
            this.b = nVar2;
        }

        public void dispose() {
            this.c.dispose();
        }

        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        public void onError(Throwable th) {
            this.a.onError(th);
        }

        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.c, bVar)) {
                this.c = bVar;
                this.a.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            try {
                Object apply = this.b.apply(t);
                b.e(apply, "The selector returned a null Notification");
            } catch (Throwable th) {
                a.b(th);
                this.a.onError(th);
                return;
            }
            if (apply.h()) {
                this.a.onSuccess(apply.e());
            } else {
                if (apply.f()) {
                    this.a.onComplete();
                } else {
                    this.a.onError(apply.d());
                }
            }
        }
    }
    public k(a0<T> a0Var, i.b.l0.n<? super T, q<R>> nVar) {
        super();
        this.a = a0Var;
        this.b = nVar;
    }

    @Override // i.b.l
    protected void w(i.b.n<? super R> nVar) {
        this.a.subscribe(new k.a(nVar, this.b));
    }
}
