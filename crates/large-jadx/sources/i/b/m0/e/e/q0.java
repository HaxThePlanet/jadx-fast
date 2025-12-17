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

/* loaded from: classes3.dex */
public final class q0<T>  extends l<T> implements d<T> {

    final w<T> a;
    final long b;

    static final class a implements y<T>, b {

        final n<? super T> a;
        final long b;
        b c;
        long v;
        boolean w;
        a(n<? super T> n, long l2) {
            super();
            this.a = n;
            this.b = l2;
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
            if (!this.w) {
                this.w = true;
                this.a.onComplete();
            }
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            if (this.w) {
                a.t(throwable);
            }
            this.w = true;
            this.a.onError(throwable);
        }

        public void onNext(T t) {
            if (this.w) {
            }
            long l = this.v;
            if (Long.compare(l, l2) == 0) {
                this.w = true;
                this.c.dispose();
                this.a.onSuccess(t);
            }
            this.v = l += i3;
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
    public q0(w<T> w, long l2) {
        super();
        this.a = w;
        this.b = l2;
    }

    public r<T> a() {
        super(this.a, this.b, obj3, 0, 0);
        return a.n(p0Var2);
    }

    public void w(n<? super T> n) {
        q0.a aVar = new q0.a(n, this.b, obj3);
        this.a.subscribe(aVar);
    }
}
