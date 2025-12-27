package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l;
import i.b.m0.a.c;
import i.b.m0.c.d;
import i.b.n;
import i.b.p0.a;
import i.b.r;
import i.b.w;
import i.b.y;

/* compiled from: ObservableElementAtMaybe.java */
/* loaded from: classes3.dex */
public final class q0<T> extends l<T> implements d<T> {

    final w<T> a;
    final long b;

    static final class a<T> implements y<T>, b {

        final n<? super T> a;
        final long b;
        b c;
        long v;
        boolean w;
        a(n<? super T> nVar, long j) {
            super();
            this.a = nVar;
            this.b = j;
        }

        public void dispose() {
            this.c.dispose();
        }

        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        public void onComplete() {
            if (!this.w) {
                this.w = true;
                this.a.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.w) {
                a.t(th);
                return;
            }
            this.w = true;
            this.a.onError(th);
        }

        public void onNext(T t) {
            if (this.w) {
                return;
            }
            if (this.v == this.b) {
                this.w = true;
                this.c.dispose();
                this.a.onSuccess(t);
                return;
            }
            this.v++;
        }

        public void onSubscribe(b bVar) {
            if (c.validate(this.c, bVar)) {
                this.c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }
    public q0(w<T> wVar, long j) {
        super();
        this.a = wVar;
        this.b = j;
    }

    @Override // i.b.l
    public r<T> a() {
        p0 p0Var = new p0(this.a, this.b, obj, false, 0);
        return a.n(p0Var);
    }

    @Override // i.b.l
    public void w(n<? super T> nVar) {
        this.a.subscribe(new q0.a(nVar, this.b, r3));
    }
}
