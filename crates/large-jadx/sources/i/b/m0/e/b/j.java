package i.b.m0.e.b;

import i.b.h;
import i.b.l0.o;
import i.b.m0.c.j;
import m.c.c;

/* compiled from: FlowableFilter.java */
/* loaded from: classes3.dex */
public final class j<T> extends a<T, T> {

    final o<? super T> c;

    static final class a<T> extends i.b.m0.h.a<T, T> {

        final o<? super T> x;
        a(i.b.m0.c.a<? super T> aVar, o<? super T> oVar) {
            super(aVar);
            this.x = oVar;
        }

        @Override // i.b.m0.h.a
        public boolean c(T t) {
            boolean z = false;
            z = false;
            if (this.v) {
                return false;
            }
            if (this.w != 0) {
                return this.a.c(null);
            }
            try {
            } catch (Throwable th) {
                d(th);
                return z3;
            }
            if (this.x.test(t)) {
                if (this.a.c(th)) {
                    int i4 = 1;
                }
            }
            return z;
        }

        @Override // i.b.m0.h.a
        public void onNext(T t) {
            if (!c(t)) {
                long l = 1L;
                this.b.request(l);
            }
        }

        @Override // i.b.m0.h.a
        public T poll() {
            Object poll = this.c.poll();
            while (poll == null) {
                if (this.x.test(poll)) {
                    return poll;
                }
            }
            return null;
        }

        @Override // i.b.m0.h.a
        public int requestFusion(int i) {
            return e(i);
        }
    }

    static final class b<T> extends i.b.m0.h.b<T, T> implements i.b.m0.c.a<T> {

        final o<? super T> x;
        b(m.c.b<? super T> bVar, o<? super T> oVar) {
            super(bVar);
            this.x = oVar;
        }

        @Override // i.b.m0.h.b
        public boolean c(T t) {
            if (this.v) {
                return false;
            }
            int i = 1;
            if (this.w != 0) {
                this.a.onNext(null);
                return true;
            }
            try {
                boolean test = this.x.test(t);
            } catch (Throwable th) {
                d(th);
                return z2;
            }
            if (this.v) {
                this.a.onNext(th);
            }
            return test;
        }

        @Override // i.b.m0.h.b
        public void onNext(T t) {
            if (!c(t)) {
                long l = 1L;
                this.b.request(l);
            }
        }

        @Override // i.b.m0.h.b
        public T poll() {
            Object poll = this.c.poll();
            while (poll == null) {
                if (this.x.test(poll)) {
                    return poll;
                }
            }
            return null;
        }

        @Override // i.b.m0.h.b
        public int requestFusion(int i) {
            return e(i);
        }
    }
    public j(h<T> hVar, o<? super T> oVar) {
        super(hVar);
        this.c = oVar;
    }

    @Override // i.b.m0.e.b.a
    protected void c0(m.c.b<? super T> bVar) {
        if (bVar instanceof a) {
            this.b.b0(new j.a(bVar, this.c));
        } else {
            this.b.b0(new j.b(bVar, this.c));
        }
    }
}
