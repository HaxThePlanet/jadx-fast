package i.b.m0.e.e;

import i.b.l0.n;
import i.b.m0.b.b;
import i.b.m0.c.j;
import i.b.m0.d.a;
import i.b.w;
import i.b.y;

/* loaded from: classes3.dex */
public final class v1<T, U>  extends i.b.m0.e.e.a<T, U> {

    final n<? super T, ? extends U> b;

    static final class a extends a<T, U> {

        final n<? super T, ? extends U> x;
        a(y<? super U> y, n<? super T, ? extends U> n2) {
            super(y);
            this.x = n2;
        }

        public void onNext(T t) {
            if (this.v) {
            }
            if (this.w != 0) {
                this.a.onNext(0);
            }
            Object obj2 = this.x.apply(t);
            b.e(obj2, "The mapper function returned a null value.");
            this.a.onNext(obj2);
        }

        public U poll() {
            Object apply;
            String str;
            Object poll = this.c.poll();
            if (poll != null) {
                b.e(this.x.apply(poll), "The mapper function returned a null value.");
            } else {
                apply = 0;
            }
            return apply;
        }

        @Override // i.b.m0.d.a
        public int requestFusion(int i) {
            return d(i);
        }
    }
    public v1(w<T> w, n<? super T, ? extends U> n2) {
        super(w);
        this.b = n2;
    }

    public void subscribeActual(y<? super U> y) {
        v1.a aVar = new v1.a(y, this.b);
        this.a.subscribe(aVar);
    }
}
