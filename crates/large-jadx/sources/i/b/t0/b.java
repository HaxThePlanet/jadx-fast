package i.b.t0;

import i.b.p0.a;
import i.b.y;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: PublishSubject.java */
/* loaded from: classes3.dex */
public final class b<T> extends d<T> {

    static final b.a[] c;
    static final b.a[] v;
    final AtomicReference<b.a<T>[]> a = new AtomicReference<>();
    Throwable b;

    static final class a<T> extends AtomicBoolean implements i.b.j0.b {

        private static final long serialVersionUID = 3562861878281475070L;
        final y<? super T> downstream;
        final b<T> parent;
        a(y<? super T> yVar, b<T> bVar) {
            super();
            this.downstream = yVar;
            this.parent = bVar;
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void a() {
            if (!get()) {
                this.downstream.onComplete();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void b(Throwable th) {
            if (get()) {
                a.t(th);
            } else {
                this.downstream.onError(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void c(T t) {
            if (!get()) {
                this.downstream.onNext(t);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void dispose() {
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
        final AtomicReference atomicReference = new AtomicReference(b.v);
    }

    public static <T> b<T> e() {
        return new b();
    }

    @Override // i.b.t0.d
    boolean d(b.a<T> aVar) {
        Object obj = this.a.get();
        final int i = 0;
        while (obj == b.c) {
            int length = obj.length;
            i.b.t0.b.a[] arr = new b.a[length + 1];
            System.arraycopy(obj, i, arr, i, length);
            arr[length] = aVar;
            if (this.a.compareAndSet(obj, arr)) {
                return true;
            }
            obj = this.a.get();
            i = 0;
        }
        return false;
    }

    @Override // i.b.t0.d
    void f(b.a<T> aVar) {
        i.b.t0.b.a[] arr;
        int i = -1;
        Object obj2;
        Object obj = this.a.get();
        while (obj != b.c) {
            int length = obj.length;
            i = -1;
            i = 0;
            for (Object obj2 : obj) {
                if (obj2 == aVar) {
                    break loop_4;
                }
            }
            if (i < 0) {
                return;
            }
        }
    }

    @Override // i.b.t0.d
    public void onComplete() {
        int i = 0;
        i.b.t0.b.a[] objArr = b.c;
        if (this.a.get() == b.c) {
            return;
        }
        Object andSet = this.a.getAndSet(b.c);
        i = 0;
        for (Object obj : andSet) {
            obj.a();
        }
    }

    @Override // i.b.t0.d
    public void onError(Throwable th) {
        int i = 0;
        b.e(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        i.b.t0.b.a[] objArr = b.c;
        if (this.a.get() == b.c) {
            a.t(th);
            return;
        }
        this.b = th;
        Object andSet = this.a.getAndSet(b.c);
        i = 0;
        for (Object obj : andSet) {
            obj.b(th);
        }
    }

    @Override // i.b.t0.d
    public void onNext(T t) {
        int i = 0;
        b.e(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        Object obj2 = this.a.get();
        i = 0;
        for (Object obj : obj2) {
            obj.c(t);
        }
    }

    @Override // i.b.t0.d
    public void onSubscribe(i.b.j0.b bVar) {
        if (this.a.get() == b.c) {
            bVar.dispose();
        }
    }

    @Override // i.b.t0.d
    protected void subscribeActual(y<? super T> yVar) {
        i.b.t0.b.a aVar = new b.a(yVar, this);
        yVar.onSubscribe(aVar);
        if (d(aVar)) {
            if (aVar.isDisposed()) {
                f(aVar);
            }
        } else {
            if (this.b != null) {
                yVar.onError(this.b);
            } else {
                yVar.onComplete();
            }
        }
    }
}
