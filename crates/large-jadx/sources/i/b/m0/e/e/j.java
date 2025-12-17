package i.b.m0.e.e;

import i.b.a0;
import i.b.d0;
import i.b.j0.b;
import i.b.l0.o;
import i.b.m0.a.c;
import i.b.m0.c.d;
import i.b.p0.a;
import i.b.r;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;

/* loaded from: classes3.dex */
public final class j<T>  extends a0<Boolean> implements d<Boolean> {

    final w<T> a;
    final o<? super T> b;

    static final class a implements y<T>, b {

        final d0<? super Boolean> a;
        final o<? super T> b;
        b c;
        boolean v;
        a(d0<? super Boolean> d0, o<? super T> o2) {
            super();
            this.a = d0;
            this.b = o2;
        }

        @Override // i.b.y
        public void dispose() {
            this.c.dispose();
        }

        @Override // i.b.y
        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        @Override // i.b.y
        public void onComplete() {
            boolean z;
            Boolean fALSE;
            if (!this.v) {
                this.v = true;
                this.a.onSuccess(Boolean.FALSE);
            }
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            if (this.v) {
                a.t(throwable);
            }
            this.v = true;
            this.a.onError(throwable);
        }

        public void onNext(T t) {
            Object tRUE;
            boolean obj2;
            if (this.v) {
            }
            if (this.b.test(t)) {
                this.v = true;
                this.c.dispose();
                this.a.onSuccess(Boolean.TRUE);
            }
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.c, b)) {
                this.c = b;
                this.a.onSubscribe(this);
            }
        }
    }
    public j(w<T> w, o<? super T> o2) {
        super();
        this.a = w;
        this.b = o2;
    }

    public r<Boolean> a() {
        i iVar = new i(this.a, this.b);
        return a.n(iVar);
    }

    protected void subscribeActual(d0<? super Boolean> d0) {
        j.a aVar = new j.a(d0, this.b);
        this.a.subscribe(aVar);
    }
}
