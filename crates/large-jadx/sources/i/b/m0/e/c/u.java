package i.b.m0.e.c;

import i.b.h;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.i.c;
import i.b.n;
import i.b.p;
import m.c.b;

/* loaded from: classes3.dex */
public final class u<T>  extends h<T> {

    final p<T> b;

    static final class a extends c<T> implements n<T> {

        private static final long serialVersionUID = 7603343402964826922L;
        b upstream;
        a(b<? super T> b) {
            super(b);
        }

        @Override // i.b.m0.i.c
        public void cancel() {
            super.cancel();
            this.upstream.dispose();
        }

        @Override // i.b.m0.i.c
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // i.b.m0.i.c
        public void onError(Throwable throwable) {
            this.downstream.onError(throwable);
        }

        @Override // i.b.m0.i.c
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.upstream, b)) {
                this.upstream = b;
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            a(t);
        }
    }
    public u(p<T> p) {
        super();
        this.b = p;
    }

    protected void c0(b<? super T> b) {
        u.a aVar = new u.a(b);
        this.b.b(aVar);
    }
}
