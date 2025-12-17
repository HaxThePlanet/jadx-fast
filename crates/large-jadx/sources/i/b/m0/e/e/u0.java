package i.b.m0.e.e;

import i.b.l0.o;
import i.b.m0.c.j;
import i.b.m0.d.a;
import i.b.w;
import i.b.y;

/* loaded from: classes3.dex */
public final class u0<T>  extends i.b.m0.e.e.a<T, T> {

    final o<? super T> b;

    static final class a extends a<T, T> {

        final o<? super T> x;
        a(y<? super T> y, o<? super T> o2) {
            super(y);
            this.x = o2;
        }

        public void onNext(T t) {
            boolean test;
            Object obj2;
            if (this.w == 0) {
                if (this.x.test(t)) {
                    this.a.onNext(t);
                }
            } else {
                try {
                    this.a.onNext(0);
                }
            }
        }

        public T poll() {
            boolean test;
            Object poll = this.c.poll();
            while (poll != null) {
                if (!this.x.test(poll)) {
                }
                poll = this.c.poll();
            }
            return poll;
        }

        @Override // i.b.m0.d.a
        public int requestFusion(int i) {
            return d(i);
        }
    }
    public u0(w<T> w, o<? super T> o2) {
        super(w);
        this.b = o2;
    }

    public void subscribeActual(y<? super T> y) {
        u0.a aVar = new u0.a(y, this.b);
        this.a.subscribe(aVar);
    }
}
