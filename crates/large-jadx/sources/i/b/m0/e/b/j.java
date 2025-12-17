package i.b.m0.e.b;

import i.b.h;
import i.b.l0.o;
import i.b.m0.c.a;
import i.b.m0.c.j;
import i.b.m0.h.a;
import i.b.m0.h.b;
import m.c.b;
import m.c.c;

/* loaded from: classes3.dex */
public final class j<T>  extends i.b.m0.e.b.a<T, T> {

    final o<? super T> c;

    static final class a extends a<T, T> {

        final o<? super T> x;
        a(a<? super T> a, o<? super T> o2) {
            super(a);
            this.x = o2;
        }

        public boolean c(T t) {
            int i;
            boolean test;
            Object obj4;
            if (this.v) {
                return 0;
            }
            if (this.w != 0) {
                return this.a.c(0);
            }
            if (this.x.test(t) && this.a.c(t)) {
                if (this.a.c(t)) {
                    i = i4;
                }
            }
            return i;
        }

        public void onNext(T t) {
            int i;
            boolean obj3;
            if (!c(t)) {
                this.b.request(1);
            }
        }

        public T poll() {
            int i2;
            int i;
            i.b.m0.c.g gVar = this.c;
            Object poll = gVar.poll();
            while (poll == null) {
                i = 2;
                if (this.w == i) {
                }
                poll = gVar.poll();
                gVar.request(1);
            }
            return 0;
        }

        @Override // i.b.m0.h.a
        public int requestFusion(int i) {
            return e(i);
        }
    }

    static final class b extends b<T, T> implements a<T> {

        final o<? super T> x;
        b(b<? super T> b, o<? super T> o2) {
            super(b);
            this.x = o2;
        }

        public boolean c(T t) {
            int i;
            if (this.v) {
                return 0;
            }
            if (this.w != 0) {
                this.a.onNext(0);
                return 1;
            }
            boolean test = this.x.test(t);
            if (test) {
                this.a.onNext(t);
            }
            return test;
        }

        public void onNext(T t) {
            int i;
            boolean obj3;
            if (!c(t)) {
                this.b.request(1);
            }
        }

        public T poll() {
            int i;
            int i2;
            i.b.m0.c.g gVar = this.c;
            Object poll = gVar.poll();
            while (poll == null) {
                i2 = 2;
                if (this.w == i2) {
                }
                poll = gVar.poll();
                gVar.request(1);
            }
            return 0;
        }

        @Override // i.b.m0.h.b
        public int requestFusion(int i) {
            return e(i);
        }
    }
    public j(h<T> h, o<? super T> o2) {
        super(h);
        this.c = o2;
    }

    protected void c0(b<? super T> b) {
        h hVar;
        Object aVar;
        o oVar;
        if (b instanceof a) {
            aVar = new j.a((a)b, this.c);
            this.b.b0(aVar);
        } else {
            aVar = new j.b(b, this.c);
            this.b.b0(aVar);
        }
    }
}
