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
import java.util.NoSuchElementException;

/* compiled from: ObservableElementAtSingle.java */
/* loaded from: classes3.dex */
public final class r0<T> extends a0<T> implements d<T> {

    final w<T> a;
    final long b;
    final T c;

    static final class a<T> implements y<T>, b {

        final d0<? super T> a;
        final long b;
        final T c;
        b v;
        long w;
        boolean x;
        a(d0<? super T> d0Var, long j, T t) {
            super();
            this.a = d0Var;
            this.b = j;
            this.c = t;
        }

        public void dispose() {
            this.v.dispose();
        }

        public boolean isDisposed() {
            return this.v.isDisposed();
        }

        public void onComplete() {
            if (!this.x) {
                this.x = true;
                if (this.c != null) {
                    this.a.onSuccess(this.c);
                } else {
                    this.a.onError(new NoSuchElementException());
                }
            }
        }

        public void onError(Throwable th) {
            if (this.x) {
                a.t(th);
                return;
            }
            this.x = true;
            this.a.onError(th);
        }

        public void onNext(T t) {
            if (this.x) {
                return;
            }
            if (this.w == this.b) {
                this.x = true;
                this.v.dispose();
                this.a.onSuccess(t);
                return;
            }
            this.w++;
        }

        public void onSubscribe(b bVar) {
            if (c.validate(this.v, bVar)) {
                this.v = bVar;
                this.a.onSubscribe(this);
            }
        }
    }
    public r0(w<T> wVar, long j, T t) {
        super();
        this.a = wVar;
        this.b = j;
        this.c = t;
    }

    @Override // i.b.a0
    public r<T> a() {
        p0 p0Var = new p0(this.a, this.b, obj, this.c, 1);
        return a.n(p0Var);
    }

    @Override // i.b.a0
    public void subscribeActual(d0<? super T> d0Var) {
        this.a.subscribe(new r0.a(d0Var, this.b, r3, this.c));
    }
}
