package i.b.m0.e.b;

import i.b.h;
import i.b.l0.a;
import i.b.l0.f;
import i.b.m0.c.a;
import i.b.m0.c.j;
import i.b.m0.h.a;
import i.b.m0.h.b;
import i.b.m0.j.k;
import i.b.p0.a;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import m.c.b;

/* loaded from: classes3.dex */
public final class f<T>  extends i.b.m0.e.b.a<T, T> {

    final f<? super T> c;
    final f<? super Throwable> v;
    final a w;
    final a x;

    static final class a extends a<T, T> {

        final a A;
        final f<? super T> x;
        final f<? super Throwable> y;
        final a z;
        a(a<? super T> a, f<? super T> f2, f<? super Throwable> f3, a a4, a a5) {
            super(a);
            this.x = f2;
            this.y = f3;
            this.z = a4;
            this.A = a5;
        }

        public boolean c(T t) {
            if (this.v) {
                return 0;
            }
            this.x.accept(t);
            return this.a.c(t);
        }

        @Override // i.b.m0.h.a
        public void onComplete() {
            a aVar;
            if (this.v) {
            }
            this.z.run();
            this.v = true;
            this.a.onComplete();
            this.A.run();
        }

        @Override // i.b.m0.h.a
        public void onError(Throwable throwable) {
            int i;
            f fVar;
            a aVar;
            CompositeException compositeException;
            int arr;
            a obj7;
            if (this.v) {
                a.t(throwable);
            }
            this.v = true;
            final int i3 = 0;
            this.y.accept(throwable);
            if (i != 0) {
                this.a.onError(throwable);
            }
            this.A.run();
        }

        public void onNext(T t) {
            if (this.v) {
            }
            if (this.w != 0) {
                this.a.onNext(0);
            }
            this.x.accept(t);
            this.a.onNext(t);
        }

        public T poll() {
            int i;
            f fVar;
            int i2 = 0;
            final int i3 = 2;
            Object poll = this.c.poll();
            if (poll != null) {
                this.x.accept(poll);
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

    static final class b extends b<T, T> {

        final a A;
        final f<? super T> x;
        final f<? super Throwable> y;
        final a z;
        b(b<? super T> b, f<? super T> f2, f<? super Throwable> f3, a a4, a a5) {
            super(b);
            this.x = f2;
            this.y = f3;
            this.z = a4;
            this.A = a5;
        }

        @Override // i.b.m0.h.b
        public void onComplete() {
            a aVar;
            if (this.v) {
            }
            this.z.run();
            this.v = true;
            this.a.onComplete();
            this.A.run();
        }

        @Override // i.b.m0.h.b
        public void onError(Throwable throwable) {
            int i;
            f fVar;
            b bVar;
            CompositeException compositeException;
            int arr;
            a obj7;
            if (this.v) {
                a.t(throwable);
            }
            this.v = true;
            final int i3 = 0;
            this.y.accept(throwable);
            if (i != 0) {
                this.a.onError(throwable);
            }
            this.A.run();
        }

        public void onNext(T t) {
            if (this.v) {
            }
            if (this.w != 0) {
                this.a.onNext(0);
            }
            this.x.accept(t);
            this.a.onNext(t);
        }

        public T poll() {
            int i;
            f fVar;
            int i2 = 0;
            final int i3 = 2;
            Object poll = this.c.poll();
            if (poll != null) {
                this.x.accept(poll);
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
    public f(h<T> h, f<? super T> f2, f<? super Throwable> f3, a a4, a a5) {
        super(h);
        this.c = f2;
        this.v = f3;
        this.w = a4;
        this.x = a5;
    }

    protected void c0(b<? super T> b) {
        h hVar;
        Object obj2;
        Object obj;
        f fVar2;
        f fVar;
        a aVar2;
        a aVar3;
        Object aVar;
        if (b instanceof a) {
            super((a)b, this.c, this.v, this.w, this.x);
            this.b.b0(aVar);
        } else {
            super(b, this.c, this.v, this.w, this.x);
            this.b.b0(aVar);
        }
    }
}
