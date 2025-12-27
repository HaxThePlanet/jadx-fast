package i.b.m0.e.c;

import i.b.h;
import i.b.n;
import i.b.p;

/* compiled from: MaybeToFlowable.java */
/* loaded from: classes3.dex */
public final class u<T> extends h<T> {

    final p<T> b;

    static final class a<T> extends i.b.m0.i.c<T> implements n<T> {

        private static final long serialVersionUID = 7603343402964826922L;
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
        public void onComplete() {
            this.downstream.onComplete();
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
    public u(p<T> pVar) {
        super();
        this.b = pVar;
    }

    @Override // i.b.h
    protected void c0(m.c.b<? super T> bVar) {
        this.b.b(new u.a(bVar));
    }
}
