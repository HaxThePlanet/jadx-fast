package i.b.m0.e.b;

import i.b.h;
import i.b.l0.n;
import i.b.m0.c.j;

/* compiled from: FlowableMap.java */
/* loaded from: classes3.dex */
public final class v<T, U> extends a<T, U> {

    final n<? super T, ? extends U> c;

    static final class a<T, U> extends i.b.m0.h.a<T, U> {

        final n<? super T, ? extends U> x;
        a(i.b.m0.c.a<? super U> aVar, n<? super T, ? extends U> nVar) {
            super(aVar);
            this.x = nVar;
        }

        @Override // i.b.m0.h.a
        public boolean c(T t) {
            if (this.v) {
                return false;
            }
            try {
                Object apply = this.x.apply(t);
                b.e(apply, "The mapper function returned a null value.");
            } catch (Throwable th) {
                d(th);
                th = 1;
                return true;
            }
            return this.a.c(apply);
        }

        @Override // i.b.m0.h.a
        public void onNext(T t) {
            if (this.v) {
                return;
            }
            if (this.w != 0) {
                this.a.onNext(null);
                return;
            }
            try {
                Object apply = this.x.apply(t);
                b.e(apply, "The mapper function returned a null value.");
            } catch (Throwable th) {
                d(th);
                return;
            }
            this.a.onNext(apply);
        }

        @Override // i.b.m0.h.a
        public U poll() {
            Object apply = null;
            Object poll = this.c.poll();
            if (poll != null) {
                str = "The mapper function returned a null value.";
                b.e(this.x.apply(poll), str);
            } else {
                int i = 0;
            }
            return apply;
        }

        @Override // i.b.m0.h.a
        public int requestFusion(int i) {
            return e(i);
        }
    }

    static final class b<T, U> extends i.b.m0.h.b<T, U> {

        final n<? super T, ? extends U> x;
        b(m.c.b<? super U> bVar, n<? super T, ? extends U> nVar) {
            super(bVar);
            this.x = nVar;
        }

        @Override // i.b.m0.h.b
        public void onNext(T t) {
            if (this.v) {
                return;
            }
            if (this.w != 0) {
                this.a.onNext(null);
                return;
            }
            try {
                Object apply = this.x.apply(t);
                b.e(apply, "The mapper function returned a null value.");
            } catch (Throwable th) {
                d(th);
                return;
            }
            this.a.onNext(apply);
        }

        @Override // i.b.m0.h.b
        public U poll() {
            Object apply = null;
            Object poll = this.c.poll();
            if (poll != null) {
                str = "The mapper function returned a null value.";
                b.e(this.x.apply(poll), str);
            } else {
                int i = 0;
            }
            return apply;
        }

        @Override // i.b.m0.h.b
        public int requestFusion(int i) {
            return e(i);
        }
    }
    public v(h<T> hVar, n<? super T, ? extends U> nVar) {
        super(hVar);
        this.c = nVar;
    }

    @Override // i.b.m0.e.b.a
    protected void c0(m.c.b<? super U> bVar) {
        if (bVar instanceof a) {
            this.b.b0(new v.a(bVar, this.c));
        } else {
            this.b.b0(new v.b(bVar, this.c));
        }
    }
}
