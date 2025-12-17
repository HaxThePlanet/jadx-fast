package i.b.m0.e.c;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.d.l;
import i.b.n;
import i.b.r;
import i.b.y;

/* loaded from: classes3.dex */
public final class v<T>  extends r<T> {

    static final class a extends l<T> implements n<T> {

        private static final long serialVersionUID = 7603343402964826922L;
        b upstream;
        a(y<? super T> y) {
            super(y);
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
        public void onError(Throwable throwable) {
            c(throwable);
        }

        @Override // i.b.m0.d.l
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.upstream, b)) {
                this.upstream = b;
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            b(t);
        }
    }
    public static <T> n<T> c(y<? super T> y) {
        v.a aVar = new v.a(y);
        return aVar;
    }
}
