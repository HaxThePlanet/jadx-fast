package i.b.m0.e.e;

import i.b.a0;
import i.b.d0;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.w;
import i.b.y;
import java.util.NoSuchElementException;

/* compiled from: ObservableLastSingle.java */
/* loaded from: classes3.dex */
public final class t1<T> extends a0<T> {

    final w<T> a;
    final T b;

    static final class a<T> implements y<T>, b {

        final d0<? super T> a;
        final T b;
        b c;
        T v;
        a(d0<? super T> d0Var, T t) {
            super();
            this.a = d0Var;
            this.b = t;
        }

        public void dispose() {
            this.c.dispose();
            this.c = c.DISPOSED;
        }

        public boolean isDisposed() {
            boolean z = true;
            int r0 = this.c == c.DISPOSED ? 1 : 0;
            return (this.c == c.DISPOSED ? 1 : 0);
        }

        public void onComplete() {
            this.c = c.DISPOSED;
            if (this.v != null) {
                this.v = null;
                this.a.onSuccess(this.v);
            } else {
                if (this.b != null) {
                    this.a.onSuccess(this.b);
                } else {
                    this.a.onError(new NoSuchElementException());
                }
            }
        }

        public void onError(Throwable th) {
            this.c = c.DISPOSED;
            this.v = null;
            this.a.onError(th);
        }

        public void onNext(T t) {
            this.v = t;
        }

        public void onSubscribe(b bVar) {
            if (c.validate(this.c, bVar)) {
                this.c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }
    public t1(w<T> wVar, T t) {
        super();
        this.a = wVar;
        this.b = t;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super T> d0Var) {
        this.a.subscribe(new t1.a(d0Var, this.b));
    }
}
