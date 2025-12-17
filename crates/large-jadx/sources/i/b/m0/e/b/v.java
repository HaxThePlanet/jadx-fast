package i.b.m0.e.b;

import i.b.h;
import i.b.l0.n;
import i.b.m0.b.b;
import i.b.m0.c.a;
import i.b.m0.c.j;
import i.b.m0.h.a;
import i.b.m0.h.b;
import m.c.b;

/* loaded from: classes3.dex */
public final class v<T, U>  extends i.b.m0.e.b.a<T, U> {

    final n<? super T, ? extends U> c;

    static final class a extends a<T, U> {

        final n<? super T, ? extends U> x;
        a(a<? super U> a, n<? super T, ? extends U> n2) {
            super(a);
            this.x = n2;
        }

        public boolean c(T t) {
            if (this.v) {
                return 0;
            }
            Object obj2 = this.x.apply(t);
            b.e(obj2, "The mapper function returned a null value.");
            return this.a.c(obj2);
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

        @Override // i.b.m0.h.a
        public int requestFusion(int i) {
            return e(i);
        }
    }

    static final class b extends b<T, U> {

        final n<? super T, ? extends U> x;
        b(b<? super U> b, n<? super T, ? extends U> n2) {
            super(b);
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

        @Override // i.b.m0.h.b
        public int requestFusion(int i) {
            return e(i);
        }
    }
    public v(h<T> h, n<? super T, ? extends U> n2) {
        super(h);
        this.c = n2;
    }

    protected void c0(b<? super U> b) {
        h hVar;
        Object aVar;
        n nVar;
        if (b instanceof a) {
            aVar = new v.a((a)b, this.c);
            this.b.b0(aVar);
        } else {
            aVar = new v.b(b, this.c);
            this.b.b0(aVar);
        }
    }
}
