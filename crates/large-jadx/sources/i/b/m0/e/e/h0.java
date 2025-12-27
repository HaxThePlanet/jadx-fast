package i.b.m0.e.e;

import i.b.l0.n;
import i.b.m0.a.c;
import i.b.q;
import i.b.w;
import i.b.y;

/* compiled from: ObservableDematerialize.java */
/* loaded from: classes3.dex */
public final class h0<T, R> extends a<T, R> {

    final n<? super T, ? extends q<R>> b;

    static final class a<T, R> implements y<T>, i.b.j0.b {

        final y<? super R> a;
        final n<? super T, ? extends q<R>> b;
        boolean c;
        i.b.j0.b v;
        a(y<? super R> yVar, n<? super T, ? extends q<R>> nVar) {
            super();
            this.a = yVar;
            this.b = nVar;
        }

        public void dispose() {
            this.v.dispose();
        }

        public boolean isDisposed() {
            return this.v.isDisposed();
        }

        public void onComplete() {
            if (this.c) {
                return;
            }
            this.c = true;
            this.a.onComplete();
        }

        public void onError(Throwable th) {
            if (this.c) {
                a.t(th);
                return;
            }
            this.c = true;
            this.a.onError(th);
        }

        public void onNext(T t) {
            if (this.c) {
                z = t instanceof q;
                if (t instanceof q) {
                    if (t.g()) {
                        a.t(t.d());
                    }
                }
                return;
            }
            try {
                Object apply = this.b.apply(t);
                b.e(apply, "The selector returned a null Notification");
            } catch (Throwable th) {
                a.b(th);
                this.v.dispose();
                onError(th);
                return;
            }
            if (apply.g()) {
                this.v.dispose();
                onError(apply.d());
            } else {
                if (apply.f()) {
                    this.v.dispose();
                    onComplete();
                } else {
                    this.a.onNext(apply.e());
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
    public h0(w<T> wVar, n<? super T, ? extends q<R>> nVar) {
        super(wVar);
        this.b = nVar;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super R> yVar) {
        this.a.subscribe(new h0.a(yVar, this.b));
    }
}
