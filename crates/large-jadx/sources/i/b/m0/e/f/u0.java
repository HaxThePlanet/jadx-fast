package i.b.m0.e.f;

import i.b.d0;
import i.b.g0;
import i.b.h;

/* compiled from: SingleToFlowable.java */
/* loaded from: classes3.dex */
public final class u0<T> extends h<T> {

    final g0<? extends T> b;

    static final class a<T> extends i.b.m0.i.c<T> implements d0<T> {

        private static final long serialVersionUID = 187782011903685568L;
        i.b.j0.b upstream;
        a(m.c.b<? super T> bVar) {
            super(bVar);
        }

        @Override // i.b.m0.i.c
        public void cancel() {
            super.cancel();
            this.upstream.dispose();
        }

        @Override // i.b.m0.i.c
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // i.b.m0.i.c
        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // i.b.m0.i.c
        public void onSuccess(T t) {
            a(t);
        }
    }
    public u0(g0<? extends T> g0Var) {
        super();
        this.b = g0Var;
    }

    @Override // i.b.h
    public void c0(m.c.b<? super T> bVar) {
        this.b.subscribe(new u0.a(bVar));
    }
}
