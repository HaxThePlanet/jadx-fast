package i.b.m0.e.b;

import i.b.a0;
import i.b.d0;
import i.b.h;
import i.b.k;
import i.b.m0.i.g;
import i.b.p0.a;
import java.util.NoSuchElementException;
import m.c.c;

/* compiled from: FlowableSingleSingle.java */
/* loaded from: classes3.dex */
public final class k0<T> extends a0<T> implements i.b.m0.c.b<T> {

    final h<T> a;
    final T b;

    static final class a<T> implements k<T>, i.b.j0.b {

        final d0<? super T> a;
        final T b;
        c c;
        boolean v;
        T w;
        a(d0<? super T> d0Var, T t) {
            super();
            this.a = d0Var;
            this.b = t;
        }

        public void dispose() {
            this.c.cancel();
            this.c = g.CANCELLED;
        }

        public boolean isDisposed() {
            boolean z = true;
            int r0 = this.c == g.CANCELLED ? 1 : 0;
            return (this.c == g.CANCELLED ? 1 : 0);
        }

        public void onComplete() {
            Object obj;
            if (this.v) {
                return;
            }
            this.v = true;
            this.c = g.CANCELLED;
            this.w = null;
            if (this.w == null) {
            }
            if (this.w != null) {
                this.a.onSuccess(obj);
            } else {
                this.a.onError(new NoSuchElementException());
            }
        }

        public void onError(Throwable th) {
            if (this.v) {
                a.t(th);
                return;
            }
            this.v = true;
            this.c = g.CANCELLED;
            this.a.onError(th);
        }

        public void onNext(T t) {
            if (this.v) {
                return;
            }
            if (this.w != null) {
                this.v = true;
                this.c.cancel();
                this.c = g.CANCELLED;
                this.a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                return;
            }
            this.w = t;
        }

        public void onSubscribe(c cVar) {
            if (g.validate(this.c, cVar)) {
                this.c = cVar;
                this.a.onSubscribe(this);
                cVar.request(Long.MAX_VALUE);
            }
        }
    }
    public k0(h<T> hVar, T t) {
        super();
        this.a = hVar;
        this.b = t;
    }

    @Override // i.b.a0
    public h<T> c() {
        return a.l(new j0(this.a, this.b, true));
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super T> d0Var) {
        this.a.b0(new k0.a(d0Var, this.b));
    }
}
