package i.b.m0.e.b;

import i.b.h;
import i.b.k;
import i.b.l;
import i.b.m0.i.g;
import i.b.n;
import i.b.p0.a;
import m.c.c;

/* compiled from: FlowableElementAtMaybe.java */
/* loaded from: classes3.dex */
public final class h<T> extends l<T> implements i.b.m0.c.b<T> {

    final h<T> a;
    final long b;

    static final class a<T> implements k<T>, i.b.j0.b {

        final n<? super T> a;
        final long b;
        c c;
        long v;
        boolean w;
        a(n<? super T> nVar, long j) {
            super();
            this.a = nVar;
            this.b = j;
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
            this.c = g.CANCELLED;
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
            this.c = g.CANCELLED;
            this.a.onError(th);
        }

        public void onNext(T t) {
            if (this.w) {
                return;
            }
            if (this.v == this.b) {
                this.w = true;
                this.c.cancel();
                this.c = g.CANCELLED;
                this.a.onSuccess(t);
                return;
            }
            this.v++;
        }

        public void onSubscribe(c cVar) {
            if (g.validate(this.c, cVar)) {
                this.c = cVar;
                this.a.onSubscribe(this);
                cVar.request(Long.MAX_VALUE);
            }
        }
    }
    public h(h<T> hVar, long j) {
        super();
        this.a = hVar;
        this.b = j;
    }

    @Override // i.b.l
    public h<T> c() {
        g gVar = new g(this.a, this.b, obj, false, 0);
        return a.l(gVar);
    }

    @Override // i.b.l
    protected void w(n<? super T> nVar) {
        this.a.b0(new h.a(nVar, this.b, r3));
    }
}
