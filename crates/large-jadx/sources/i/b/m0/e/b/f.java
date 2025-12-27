package i.b.m0.e.b;

import i.b.h;
import i.b.l0.f;
import i.b.m0.c.j;
import i.b.m0.j.k;
import io.reactivex.exceptions.CompositeException;

/* compiled from: FlowableDoOnEach.java */
/* loaded from: classes3.dex */
public final class f<T> extends a<T, T> {

    final f<? super T> c;
    final f<? super Throwable> v;
    final i.b.l0.a w;
    final i.b.l0.a x;

    static final class a<T> extends i.b.m0.h.a<T, T> {

        final i.b.l0.a A;
        final f<? super T> x;
        final f<? super Throwable> y;
        final i.b.l0.a z;
        a(i.b.m0.c.a<? super T> aVar, f<? super T> fVar, f<? super Throwable> fVar2, i.b.l0.a aVar2, i.b.l0.a aVar3) {
            super(aVar);
            this.x = fVar;
            this.y = fVar2;
            this.z = aVar2;
            this.A = aVar3;
        }

        @Override // i.b.m0.h.a
        public boolean c(T t) {
            if (this.v) {
                return false;
            }
            try {
                this.x.accept(t);
            } catch (Throwable th) {
                d(th);
                return z2;
            }
            return this.a.c(th);
        }

        @Override // i.b.m0.h.a
        public void onComplete() {
            if (this.v) {
                return;
            }
            try {
                this.z.run();
            } catch (Throwable th) {
                a.b(th);
                a.t(th);
            }
            this.v = true;
            this.a.onComplete();
            try {
                this.A.run();
            } catch (Throwable th) {
                a.b(th);
                a.t(th);
            }
        }

        @Override // i.b.m0.h.a
        public void onError(Throwable th) {
            boolean z = true;
            if (this.v) {
                a.t(th);
                return;
            }
            z = true;
            this.v = z;
            try {
                this.y.accept(th);
            } catch (Throwable th) {
                a.b(th);
                a.t(th);
            }
            if (this.v) {
                this.a.onError(th);
            }
            try {
                this.A.run();
            } catch (Throwable th) {
                a.b(th);
                a.t(th);
            }
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
                this.x.accept(t);
            } catch (Throwable th) {
                d(th);
                return;
            }
            this.a.onNext(th);
        }

        @Override // i.b.m0.h.a
        public T poll() {
            try {
                Object poll = this.c.poll();
            } catch (Throwable th) {
            }
            if (this.c != null) {
                try {
                    this.x.accept(poll);
                } catch (Throwable unused) {
                }
                this.A.run();
            } else {
                if (this.w == 1) {
                    this.z.run();
                    this.A.run();
                }
            }
            return poll;
        }

        @Override // i.b.m0.h.a
        public int requestFusion(int i) {
            return e(i);
        }
    }

    static final class b<T> extends i.b.m0.h.b<T, T> {

        final i.b.l0.a A;
        final f<? super T> x;
        final f<? super Throwable> y;
        final i.b.l0.a z;
        b(m.c.b<? super T> bVar, f<? super T> fVar, f<? super Throwable> fVar2, i.b.l0.a aVar, i.b.l0.a aVar2) {
            super(bVar);
            this.x = fVar;
            this.y = fVar2;
            this.z = aVar;
            this.A = aVar2;
        }

        @Override // i.b.m0.h.b
        public void onComplete() {
            if (this.v) {
                return;
            }
            try {
                this.z.run();
            } catch (Throwable th) {
                a.b(th);
                a.t(th);
            }
            this.v = true;
            this.a.onComplete();
            try {
                this.A.run();
            } catch (Throwable th) {
                a.b(th);
                a.t(th);
            }
        }

        @Override // i.b.m0.h.b
        public void onError(Throwable th) {
            boolean z = true;
            if (this.v) {
                a.t(th);
                return;
            }
            z = true;
            this.v = z;
            try {
                this.y.accept(th);
            } catch (Throwable th) {
                a.b(th);
                a.t(th);
            }
            if (this.v) {
                this.a.onError(th);
            }
            try {
                this.A.run();
            } catch (Throwable th) {
                a.b(th);
                a.t(th);
            }
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
                this.x.accept(t);
            } catch (Throwable th) {
                d(th);
                return;
            }
            this.a.onNext(th);
        }

        @Override // i.b.m0.h.b
        public T poll() {
            try {
                Object poll = this.c.poll();
            } catch (Throwable th) {
            }
            if (this.c != null) {
                try {
                    this.x.accept(poll);
                } catch (Throwable unused) {
                }
                this.A.run();
            } else {
                if (this.w == 1) {
                    this.z.run();
                    this.A.run();
                }
            }
            return poll;
        }

        @Override // i.b.m0.h.b
        public int requestFusion(int i) {
            return e(i);
        }
    }
    public f(h<T> hVar, f<? super T> fVar, f<? super Throwable> fVar2, i.b.l0.a aVar, i.b.l0.a aVar2) {
        super(hVar);
        this.c = fVar;
        this.v = fVar2;
        this.w = aVar;
        this.x = aVar2;
    }

    @Override // i.b.m0.e.b.a
    protected void c0(m.c.b<? super T> bVar) {
        if (bVar instanceof a) {
            f.a aVar = new f.a((a)bVar, this.c, this.v, this.w, this.x);
            this.b.b0(aVar);
        } else {
            f.b bVar2 = new f.b(bVar, this.c, this.v, this.w, this.x);
            this.b.b0(bVar2);
        }
    }
}
