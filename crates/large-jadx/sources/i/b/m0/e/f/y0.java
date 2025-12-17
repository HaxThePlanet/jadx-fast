package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.p0.a;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class y0<T, R>  extends a0<R> {

    final g0<? extends T>[] a;
    final n<? super Object[], ? extends R> b;

    final class a implements n<T, R> {

        final i.b.m0.e.f.y0 a;
        a(i.b.m0.e.f.y0 y0) {
            this.a = y0;
            super();
        }

        public R apply(T t) {
            Object[] arr = new Object[1];
            final Object obj4 = y0Var.b.apply(arr);
            b.e(obj4, "The zipper returned a null value");
            return obj4;
        }
    }

    static final class b extends AtomicInteger implements b {

        private static final long serialVersionUID = -5556924161382950569L;
        final d0<? super R> downstream;
        final i.b.m0.e.f.y0.c<T>[] observers;
        final Object[] values;
        final n<? super Object[], ? extends R> zipper;
        b(d0<? super R> d0, int i2, n<? super Object[], ? extends R> n3) {
            i.b.m0.e.f.y0.c cVar;
            int obj4;
            super(i2);
            this.downstream = d0;
            this.zipper = n3;
            i.b.m0.e.f.y0.c[] obj2 = new y0.c[i2];
            obj4 = 0;
            while (obj4 < i2) {
                cVar = new y0.c(this, obj4);
                obj2[obj4] = cVar;
                obj4++;
            }
            this.observers = obj2;
            this.values = new Object[i2];
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a(int i) {
            int i2;
            i.b.m0.e.f.y0.c cVar;
            int obj5;
            final i.b.m0.e.f.y0.c[] observers = this.observers;
            i2 = 0;
            while (i2 < i) {
                observers[i2].a();
                i2++;
            }
            obj5++;
            while (obj5 < observers.length) {
                observers[obj5].a();
                obj5++;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b(Throwable throwable, int i2) {
            d0 obj3;
            if (getAndSet(0) > 0) {
                a(i2);
                this.downstream.onError(throwable);
            } else {
                a.t(throwable);
            }
        }

        void c(T t, int i2) {
            int obj2;
            int obj3;
            this.values[i2] = t;
            if (decrementAndGet() == 0) {
                obj2 = this.zipper.apply(this.values);
                b.e(obj2, "The zipper returned a null value");
                this.downstream.onSuccess(obj2);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            int i;
            int andSet;
            int length;
            i.b.m0.e.f.y0.c cVar;
            if (getAndSet(0) > 0) {
                andSet = this.observers;
                while (i < andSet.length) {
                    andSet[i].a();
                    i++;
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            int i;
            i = get() <= 0 ? 1 : 0;
            return i;
        }
    }

    static final class c extends AtomicReference<b> implements d0<T> {

        private static final long serialVersionUID = 3323743579927613702L;
        final int index;
        final i.b.m0.e.f.y0.b<T, ?> parent;
        c(i.b.m0.e.f.y0.b<T, ?> y0$b, int i2) {
            super();
            this.parent = b;
            this.index = i2;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void a() {
            c.dispose(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            this.parent.b(throwable, this.index);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            c.setOnce(this, b);
        }

        public void onSuccess(T t) {
            this.parent.c(t, this.index);
        }
    }
    public y0(g0<? extends T>[] g0Arr, n<? super Object[], ? extends R> n2) {
        super();
        this.a = g0Arr;
        this.b = n2;
    }

    protected void subscribeActual(d0<? super R> d0) {
        int i;
        n nVar;
        d0 obj6;
        g0[] objArr = this.a;
        int length = objArr.length;
        if (length == 1) {
            y0.a aVar2 = new y0.a(this);
            k0.a aVar = new k0.a(d0, aVar2);
            objArr[0].subscribe(aVar);
        }
        y0.b bVar = new y0.b(d0, length, this.b);
        d0.onSubscribe(bVar);
        while (i < length) {
            obj6 = objArr[i];
            obj6.subscribe(bVar.observers[i]);
            i++;
        }
    }
}
