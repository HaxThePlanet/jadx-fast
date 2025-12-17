package i.b.m0.e.e;

import i.b.l0.d;
import i.b.l0.n;
import i.b.m0.c.j;
import i.b.m0.d.a;
import i.b.w;
import i.b.y;

/* loaded from: classes3.dex */
public final class k0<T, K>  extends i.b.m0.e.e.a<T, T> {

    final n<? super T, K> b;
    final d<? super K, ? super K> c;

    static final class a extends a<T, T> {

        boolean A;
        final n<? super T, K> x;
        final d<? super K, ? super K> y;
        K z;
        a(y<? super T> y, n<? super T, K> n2, d<? super K, ? super K> d3) {
            super(y);
            this.x = n2;
            this.y = d3;
        }

        public void onNext(T t) {
            int i;
            Object obj;
            if (this.v) {
            }
            if (this.w != 0) {
                this.a.onNext(t);
            }
            Object apply = this.x.apply(t);
            if (this.A) {
                this.z = apply;
                if (this.y.a(this.z, apply)) {
                }
            } else {
                this.A = true;
                this.z = apply;
            }
            this.a.onNext(t);
        }

        public T poll() {
            Object poll = this.c.poll();
            while (poll == null) {
                Object apply = this.x.apply(poll);
                this.z = apply;
                poll = this.c.poll();
            }
            return 0;
        }

        @Override // i.b.m0.d.a
        public int requestFusion(int i) {
            return d(i);
        }
    }
    public k0(w<T> w, n<? super T, K> n2, d<? super K, ? super K> d3) {
        super(w);
        this.b = n2;
        this.c = d3;
    }

    protected void subscribeActual(y<? super T> y) {
        k0.a aVar = new k0.a(y, this.b, this.c);
        this.a.subscribe(aVar);
    }
}
