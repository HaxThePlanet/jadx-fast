package i.b.m0.e.b;

import i.b.h;
import i.b.j0.b;
import i.b.k;
import i.b.l;
import i.b.m0.c.b;
import i.b.m0.i.g;
import i.b.n;
import i.b.p0.a;
import m.c.c;

/* loaded from: classes3.dex */
public final class h<T>  extends l<T> implements b<T> {

    final h<T> a;
    final long b;

    static final class a implements k<T>, b {

        final n<? super T> a;
        final long b;
        c c;
        long v;
        boolean w;
        a(n<? super T> n, long l2) {
            super();
            this.a = n;
            this.b = l2;
        }

        @Override // i.b.k
        public void dispose() {
            this.c.cancel();
            this.c = g.CANCELLED;
        }

        @Override // i.b.k
        public boolean isDisposed() {
            int i;
            i = this.c == g.CANCELLED ? 1 : 0;
            return i;
        }

        @Override // i.b.k
        public void onComplete() {
            boolean z;
            this.c = g.CANCELLED;
            if (!this.w) {
                this.w = true;
                this.a.onComplete();
            }
        }

        @Override // i.b.k
        public void onError(Throwable throwable) {
            if (this.w) {
                a.t(throwable);
            }
            this.w = true;
            this.c = g.CANCELLED;
            this.a.onError(throwable);
        }

        public void onNext(T t) {
            if (this.w) {
            }
            long l = this.v;
            if (Long.compare(l, l2) == 0) {
                this.w = true;
                this.c.cancel();
                this.c = g.CANCELLED;
                this.a.onSuccess(t);
            }
            this.v = l += i3;
        }

        @Override // i.b.k
        public void onSubscribe(c c) {
            boolean validate;
            if (g.validate(this.c, c)) {
                this.c = c;
                this.a.onSubscribe(this);
                c.request(Long.MAX_VALUE);
            }
        }
    }
    public h(h<T> h, long l2) {
        super();
        this.a = h;
        this.b = l2;
    }

    public h<T> c() {
        super(this.a, this.b, obj3, 0, 0);
        return a.l(gVar2);
    }

    protected void w(n<? super T> n) {
        h.a aVar = new h.a(n, this.b, obj3);
        this.a.b0(aVar);
    }
}
