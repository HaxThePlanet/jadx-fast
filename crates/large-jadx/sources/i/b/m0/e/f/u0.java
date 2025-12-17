package i.b.m0.e.f;

import i.b.d0;
import i.b.g0;
import i.b.h;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.i.c;
import m.c.b;

/* loaded from: classes3.dex */
public final class u0<T>  extends h<T> {

    final g0<? extends T> b;

    static final class a extends c<T> implements d0<T> {

        private static final long serialVersionUID = 187782011903685568L;
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
    public u0(g0<? extends T> g0) {
        super();
        this.b = g0;
    }

    public void c0(b<? super T> b) {
        u0.a aVar = new u0.a(b);
        this.b.subscribe(aVar);
    }
}
