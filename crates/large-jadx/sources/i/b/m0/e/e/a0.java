package i.b.m0.e.e;

import i.b.a0;
import i.b.d0;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.c.d;
import i.b.p0.a;
import i.b.r;
import i.b.w;
import i.b.y;

/* compiled from: ObservableCountSingle.java */
/* loaded from: classes3.dex */
public final class a0<T> extends a0<Long> implements d<Long> {

    final w<T> a;

    static final class a implements y<Object>, b {

        final d0<? super Long> a;
        b b;
        long c;
        a(d0<? super Long> d0Var) {
            super();
            this.a = d0Var;
        }

        public void dispose() {
            this.b.dispose();
            this.b = c.DISPOSED;
        }

        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        public void onComplete() {
            this.b = c.DISPOSED;
            this.a.onSuccess(Long.valueOf(this.c));
        }

        public void onError(Throwable th) {
            this.b = c.DISPOSED;
            this.a.onError(th);
        }

        public void onNext(Object object) {
            this.c++;
        }

        public void onSubscribe(b bVar) {
            if (c.validate(this.b, bVar)) {
                this.b = bVar;
                this.a.onSubscribe(this);
            }
        }
    }
    public a0(w<T> wVar) {
        super();
        this.a = wVar;
    }

    @Override // i.b.a0
    public r<Long> a() {
        return a.n(new z(this.a));
    }

    @Override // i.b.a0
    public void subscribeActual(d0<? super Long> d0Var) {
        this.a.subscribe(new a0.a(d0Var));
    }
}
