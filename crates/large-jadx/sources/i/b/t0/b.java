package i.b.t0;

import i.b.j0.b;
import i.b.m0.b.b;
import i.b.p0.a;
import i.b.y;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class b<T>  extends i.b.t0.d<T> {

    static final i.b.t0.b.a[] c;
    static final i.b.t0.b.a[] v;
    final AtomicReference<i.b.t0.b.a<T>[]> a;
    Throwable b;

    static final class a extends AtomicBoolean implements b {

        private static final long serialVersionUID = 3562861878281475070L;
        final y<? super T> downstream;
        final i.b.t0.b<T> parent;
        a(y<? super T> y, i.b.t0.b<T> b2) {
            super();
            this.downstream = y;
            this.parent = b2;
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void a() {
            boolean downstream;
            if (!get()) {
                this.downstream.onComplete();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void b(Throwable throwable) {
            boolean downstream;
            if (get()) {
                a.t(throwable);
            } else {
                this.downstream.onError(throwable);
            }
        }

        public void c(T t) {
            boolean downstream;
            if (!get()) {
                this.downstream.onNext(t);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void dispose() {
            boolean compareAndSet;
            if (compareAndSet(false, true)) {
                this.parent.f(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public boolean isDisposed() {
            return get();
        }
    }
    static {
        int i = 0;
        b.c = new b.a[i];
        b.v = new b.a[i];
    }

    b() {
        super();
        AtomicReference atomicReference = new AtomicReference(b.v);
        this.a = atomicReference;
    }

    public static <T> i.b.t0.b<T> e() {
        b bVar = new b();
        return bVar;
    }

    boolean d(i.b.t0.b.a<T> b$a) {
        Object obj = this.a.get();
        final int i = 0;
        while ((b.a[])obj == b.c) {
            int length = obj.length;
            i.b.t0.b.a[] arr = new b.a[length + 1];
            System.arraycopy((b.a[])obj, i, arr, i, length);
            arr[length] = a;
            obj = this.a.get();
            i = 0;
        }
        return i;
    }

    void f(i.b.t0.b.a<T> b$a) {
        Object compareAndSet;
        i.b.t0.b.a[] objArr;
        AtomicReference atomicReference;
        int i3;
        int i;
        int i2;
        int i4;
        Object arr;
        compareAndSet = this.a.get();
        while ((b.a[])compareAndSet != b.c) {
            if ((b.a[])compareAndSet == b.v) {
                break;
            } else {
            }
            int length = compareAndSet.length;
            i3 = -1;
            i = 0;
            i4 = i;
            while (i4 < length) {
                if ((b.a[])compareAndSet[i4] == a) {
                    break loop_4;
                } else {
                }
                i4++;
            }
            i2 = 1;
            if (length == i2) {
            } else {
            }
            arr = new b.a[length + -1];
            System.arraycopy(compareAndSet, i, arr, i, i3);
            System.arraycopy(compareAndSet, i3 + 1, arr, i3, i5 -= i2);
            objArr = arr;
            if (!this.a.compareAndSet(compareAndSet, objArr)) {
                break;
            }
            compareAndSet = this.a.get();
            objArr = b.v;
            if ((b.a[])compareAndSet[i4] == a) {
            } else {
            }
            i4++;
            i3 = i4;
        }
    }

    @Override // i.b.t0.d
    public void onComplete() {
        int i;
        Object obj;
        i.b.t0.b.a[] objArr = b.c;
        if (this.a.get() == objArr) {
        }
        Object andSet = this.a.getAndSet(objArr);
        i = 0;
        while (i < andSet.length) {
            (b.a[])andSet[i].a();
            i++;
        }
    }

    @Override // i.b.t0.d
    public void onError(Throwable throwable) {
        int i;
        Object obj;
        b.e(throwable, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        i.b.t0.b.a[] objArr = b.c;
        if (this.a.get() == objArr) {
            a.t(throwable);
        }
        this.b = throwable;
        Object andSet = this.a.getAndSet(objArr);
        i = 0;
        while (i < andSet.length) {
            (b.a[])andSet[i].b(throwable);
            i++;
        }
    }

    public void onNext(T t) {
        int i;
        Object obj;
        b.e(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        Object obj2 = this.a.get();
        i = 0;
        while (i < obj2.length) {
            (b.a[])obj2[i].c(t);
            i++;
        }
    }

    @Override // i.b.t0.d
    public void onSubscribe(b b) {
        if (this.a.get() == b.c) {
            b.dispose();
        }
    }

    protected void subscribeActual(y<? super T> y) {
        Object aVar;
        y obj3;
        aVar = new b.a(y, this);
        y.onSubscribe(aVar);
        if (d(aVar)) {
            if (aVar.isDisposed()) {
                f(aVar);
            }
        } else {
            aVar = this.b;
            if (aVar != null) {
                y.onError(aVar);
            } else {
                y.onComplete();
            }
        }
    }
}
