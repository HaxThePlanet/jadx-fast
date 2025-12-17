package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.f;
import i.b.m0.a.c;
import i.b.m0.j.k;
import i.b.n0.a;
import i.b.p0.a;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class f2<T>  extends a<T> implements i.b.m0.e.e.h2 {

    final w<T> a;
    final AtomicReference<i.b.m0.e.e.f2.b<T>> b;
    final w<T> c;

    static final class a extends AtomicReference<Object> implements b {

        private static final long serialVersionUID = -1100270633763673112L;
        final y<? super T> child;
        a(y<? super T> y) {
            super();
            this.child = y;
        }

        void a(i.b.m0.e.e.f2.b<T> f2$b) {
            if (!compareAndSet(0, b)) {
                b.b(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            final Object andSet = getAndSet(this);
            if (andSet != null && andSet != this) {
                if (andSet != this) {
                    (f2.b)andSet.b(this);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            int i;
            i = get() == this ? 1 : 0;
            return i;
        }
    }

    static final class b implements y<T>, b {

        static final i.b.m0.e.e.f2.a[] w;
        static final i.b.m0.e.e.f2.a[] x;
        final AtomicReference<i.b.m0.e.e.f2.b<T>> a;
        final AtomicReference<i.b.m0.e.e.f2.a<T>[]> b;
        final AtomicBoolean c;
        final AtomicReference<b> v;
        static {
            int i = 0;
            f2.b.w = new f2.a[i];
            f2.b.x = new f2.a[i];
        }

        b(AtomicReference<i.b.m0.e.e.f2.b<T>> atomicReference) {
            super();
            AtomicReference atomicReference2 = new AtomicReference();
            this.v = atomicReference2;
            AtomicReference atomicReference3 = new AtomicReference(f2.b.w);
            this.b = atomicReference3;
            this.a = atomicReference;
            AtomicBoolean obj3 = new AtomicBoolean();
            this.c = obj3;
        }

        boolean a(i.b.m0.e.e.f2.a<T> f2$a) {
            Object obj = this.b.get();
            final int i = 0;
            while ((f2.a[])obj == f2.b.x) {
                int length = obj.length;
                i.b.m0.e.e.f2.a[] arr = new f2.a[length + 1];
                System.arraycopy((f2.a[])obj, i, arr, i, length);
                arr[length] = a;
                obj = this.b.get();
                i = 0;
            }
            return i;
        }

        void b(i.b.m0.e.e.f2.a<T> f2$a) {
            i.b.m0.e.e.f2.a[] objArr;
            int i;
            int i3;
            int i2;
            boolean equals;
            Object obj = this.b.get();
            int length = obj.length;
            while (length == 0) {
                i = -1;
                i3 = 0;
                i2 = i3;
                while (i2 < length) {
                    if ((f2.a[])obj[i2].equals(a)) {
                        break loop_3;
                    } else {
                    }
                    i2++;
                }
                int i6 = 1;
                if (length == i6) {
                } else {
                }
                equals = new f2.a[length + -1];
                System.arraycopy(obj, i3, equals, i3, i);
                System.arraycopy(obj, i + 1, equals, i, i4 -= i6);
                objArr = equals;
                obj = this.b.get();
                length = obj.length;
                objArr = f2.b.w;
                if ((f2.a[])obj[i2].equals(a)) {
                } else {
                }
                i2++;
                i = i2;
            }
        }

        @Override // i.b.y
        public void dispose() {
            Object andSet;
            i.b.m0.e.e.f2.a[] objArr;
            objArr = f2.b.x;
            if ((f2.a[])this.b.getAndSet(objArr) != objArr) {
                this.a.compareAndSet(this, 0);
                c.dispose(this.v);
            }
        }

        @Override // i.b.y
        public boolean isDisposed() {
            int i;
            i = this.b.get() == f2.b.x ? 1 : 0;
            return i;
        }

        @Override // i.b.y
        public void onComplete() {
            int i;
            y child;
            this.a.compareAndSet(this, 0);
            Object andSet = this.b.getAndSet(f2.b.x);
            i = 0;
            while (i < andSet.length) {
                obj.child.onComplete();
                i++;
            }
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            int length;
            int i;
            y child;
            this.a.compareAndSet(this, 0);
            Object andSet = this.b.getAndSet(f2.b.x);
            if (andSet.length != 0) {
                i = 0;
                while (i < andSet.length) {
                    obj.child.onError(throwable);
                    i++;
                }
            } else {
                a.t(throwable);
            }
        }

        public void onNext(T t) {
            int i;
            y child;
            Object obj = this.b.get();
            i = 0;
            while (i < obj.length) {
                obj2.child.onNext(t);
                i++;
            }
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            c.setOnce(this.v, b);
        }
    }

    static final class c implements w<T> {

        private final AtomicReference<i.b.m0.e.e.f2.b<T>> a;
        c(AtomicReference<i.b.m0.e.e.f2.b<T>> atomicReference) {
            super();
            this.a = atomicReference;
        }

        public void subscribe(y<? super T> y) {
            i.b.m0.e.e.f2.b bVar;
            AtomicReference atomicReference;
            y obj4;
            f2.a aVar = new f2.a(y);
            y.onSubscribe(aVar);
            obj4 = this.a.get();
            do {
                obj4 = this.a.get();
                bVar = new f2.b(this.a);
                if (this.a.compareAndSet((f2.b)(f2.b)obj4, bVar) == null) {
                } else {
                }
                obj4 = bVar;
                if (!obj4.a(aVar)) {
                }
                if (obj4.isDisposed()) {
                }
            } while ((f2.b)obj4 != null);
            aVar.a(obj4);
        }
    }
    private f2(w<T> w, w<T> w2, AtomicReference<i.b.m0.e.e.f2.b<T>> atomicReference3) {
        super();
        this.c = w;
        this.a = w2;
        this.b = atomicReference3;
    }

    public static <T> a<T> f(w<T> w) {
        AtomicReference atomicReference = new AtomicReference();
        f2.c cVar = new f2.c(atomicReference);
        f2 f2Var = new f2(cVar, w, atomicReference);
        return a.q(f2Var);
    }

    public w<T> b() {
        return this.a;
    }

    public void c(f<? super b> f) {
        Object obj;
        boolean bVar;
        boolean compareAndSet;
        AtomicReference atomicReference;
        int i;
        Object obj5;
        obj = this.b.get();
        while ((f2.b)obj != null) {
            if ((f2.b)obj.isDisposed()) {
                break;
            }
            bVar = new f2.b(this.b);
            if (this.b.compareAndSet(obj, bVar)) {
                break;
            } else {
            }
            obj = this.b.get();
        }
        final int i2 = 0;
        if (!obj.c.get() && obj.c.compareAndSet(i2, true)) {
            if (obj.c.compareAndSet(i2, i)) {
            } else {
                i = i2;
            }
        } else {
        }
        f.accept(obj);
        if (i != 0) {
            this.a.subscribe(obj);
        }
    }

    protected void subscribeActual(y<? super T> y) {
        this.c.subscribe(y);
    }
}
