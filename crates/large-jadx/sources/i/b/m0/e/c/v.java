package i.b.m0.e.c;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.d.l;
import i.b.n;
import i.b.r;
import i.b.y;

/* compiled from: MaybeToObservable.java */
/* loaded from: classes3.dex */
public final class v<T> extends r<T> {

    static final class a<T> extends l<T> implements n<T> {

        private static final long serialVersionUID = 7603343402964826922L;
        b upstream;
        a(y<? super T> yVar) {
            super(yVar);
        }

        @Override // i.b.m0.d.l
        public void dispose() {
            super.dispose();
            this.upstream.dispose();
        }

        @Override // i.b.m0.d.l
        public void onComplete() {
            a();
        }

        @Override // i.b.m0.d.l
        public void onError(Throwable th) {
            c(th);
        }

        @Override // i.b.m0.d.l
        public void onSubscribe(b bVar) {
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // i.b.m0.d.l
        public void onSuccess(T t) {
            b(t);
        }
    }
    public static <T> n<T> c(y<? super T> yVar) {
        return new v.a(yVar);
    }
}
