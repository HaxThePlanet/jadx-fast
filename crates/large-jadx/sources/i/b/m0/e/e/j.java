package i.b.m0.e.e;

import i.b.a0;
import i.b.d0;
import i.b.j0.b;
import i.b.l0.o;
import i.b.m0.a.c;
import i.b.m0.c.d;
import i.b.r;
import i.b.w;
import i.b.y;

/* compiled from: ObservableAnySingle.java */
/* loaded from: classes3.dex */
public final class j<T> extends a0<Boolean> implements d<Boolean> {

    final w<T> a;
    final o<? super T> b;

    static final class a<T> implements y<T>, b {

        final d0<? super Boolean> a;
        final o<? super T> b;
        b c;
        boolean v;
        a(d0<? super Boolean> d0Var, o<? super T> oVar) {
            super();
            this.a = d0Var;
            this.b = oVar;
        }

        public void dispose() {
            this.c.dispose();
        }

        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        public void onComplete() {
            if (!this.v) {
                this.v = true;
                this.a.onSuccess(Boolean.FALSE);
            }
        }

        public void onError(Throwable th) {
            if (this.v) {
                a.t(th);
                return;
            }
            this.v = true;
            this.a.onError(th);
        }

        public void onNext(T t) {
            if (this.v) {
                return;
            }
            try {
            } catch (Throwable th) {
                a.b(th);
                this.c.dispose();
                onError(th);
                return;
            }
            if (this.b.test(t)) {
                this.v = true;
                this.c.dispose();
                this.a.onSuccess(Boolean.TRUE);
            }
        }

        public void onSubscribe(b bVar) {
            if (c.validate(this.c, bVar)) {
                this.c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }
    public j(w<T> wVar, o<? super T> oVar) {
        super();
        this.a = wVar;
        this.b = oVar;
    }

    @Override // i.b.a0
    public r<Boolean> a() {
        return a.n(new i(this.a, this.b));
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super Boolean> d0Var) {
        this.a.subscribe(new j.a(d0Var, this.b));
    }
}
