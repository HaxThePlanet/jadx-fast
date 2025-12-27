package i.b.m0.e.e;

import i.b.a0;
import i.b.d0;
import i.b.w;
import i.b.y;

/* compiled from: ObservableReduceSeedSingle.java */
/* loaded from: classes3.dex */
public final class m2<T, R> extends a0<R> {

    final w<T> a;
    final R b;
    final i.b.l0.c<R, ? super T, R> c;

    static final class a<T, R> implements y<T>, i.b.j0.b {

        final d0<? super R> a;
        final i.b.l0.c<R, ? super T, R> b;
        R c;
        i.b.j0.b v;
        a(d0<? super R> d0Var, i.b.l0.c<R, ? super T, R> cVar, R r) {
            super();
            this.a = d0Var;
            this.c = r;
            this.b = cVar;
        }

        public void dispose() {
            this.v.dispose();
        }

        public boolean isDisposed() {
            return this.v.isDisposed();
        }

        public void onComplete() {
            if (this.c != null) {
                this.c = null;
                this.a.onSuccess(this.c);
            }
        }

        public void onError(Throwable th) {
            if (this.c != null) {
                this.c = null;
                this.a.onError(th);
            } else {
                a.t(th);
            }
        }

        public void onNext(T t) {
            if (this.c != null) {
                try {
                    Object apply = this.b.apply(this.c, t);
                    b.e(apply, "The reducer returned a null value");
                    this.c = apply;
                } catch (Throwable th) {
                    a.b(th);
                    this.v.dispose();
                    onError(th);
                }
            }
        }

        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.v, bVar)) {
                this.v = bVar;
                this.a.onSubscribe(this);
            }
        }
    }
    public m2(w<T> wVar, R r, i.b.l0.c<R, ? super T, R> cVar) {
        super();
        this.a = wVar;
        this.b = r;
        this.c = cVar;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super R> d0Var) {
        this.a.subscribe(new m2.a(d0Var, this.c, this.b));
    }
}
