package i.b.m0.e.c;

import i.b.j0.b;
import i.b.l;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.n;
import i.b.p;
import i.b.p0.a;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class w<T, R>  extends l<R> {

    final p<? extends T>[] a;
    final n<? super Object[], ? extends R> b;

    final class a implements n<T, R> {

        final i.b.m0.e.c.w a;
        a(i.b.m0.e.c.w w) {
            this.a = w;
            super();
        }

        public R apply(T t) {
            Object[] arr = new Object[1];
            final Object obj4 = wVar.b.apply(arr);
            b.e(obj4, "The zipper returned a null value");
            return obj4;
        }
    }

    static final class b extends AtomicInteger implements b {

        private static final long serialVersionUID = -5556924161382950569L;
        final n<? super R> downstream;
        final i.b.m0.e.c.w.c<T>[] observers;
        final Object[] values;
        final n<? super Object[], ? extends R> zipper;
        b(n<? super R> n, int i2, n<? super Object[], ? extends R> n3) {
            i.b.m0.e.c.w.c cVar;
            int obj4;
            super(i2);
            this.downstream = n;
            this.zipper = n3;
            i.b.m0.e.c.w.c[] obj2 = new w.c[i2];
            obj4 = 0;
            while (obj4 < i2) {
                cVar = new w.c(this, obj4);
                obj2[obj4] = cVar;
                obj4++;
            }
            this.observers = obj2;
            this.values = new Object[i2];
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a(int i) {
            int i2;
            i.b.m0.e.c.w.c cVar;
            int obj5;
            final i.b.m0.e.c.w.c[] observers = this.observers;
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
        void b(int i) {
            int obj2;
            if (getAndSet(0) > 0) {
                a(i);
                this.downstream.onComplete();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void c(Throwable throwable, int i2) {
            n obj3;
            if (getAndSet(0) > 0) {
                a(i2);
                this.downstream.onError(throwable);
            } else {
                a.t(throwable);
            }
        }

        void d(T t, int i2) {
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
            i.b.m0.e.c.w.c cVar;
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

    static final class c extends AtomicReference<b> implements n<T> {

        private static final long serialVersionUID = 3323743579927613702L;
        final int index;
        final i.b.m0.e.c.w.b<T, ?> parent;
        c(i.b.m0.e.c.w.b<T, ?> w$b, int i2) {
            super();
            this.parent = b;
            this.index = i2;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void a() {
            c.dispose(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            this.parent.b(this.index);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            this.parent.c(throwable, this.index);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            c.setOnce(this, b);
        }

        public void onSuccess(T t) {
            this.parent.d(t, this.index);
        }
    }
    public w(p<? extends T>[] pArr, n<? super Object[], ? extends R> n2) {
        super();
        this.a = pArr;
        this.b = n2;
    }

    protected void w(n<? super R> n) {
        int i;
        n nVar;
        n obj6;
        p[] objArr = this.a;
        int length = objArr.length;
        if (length == 1) {
            w.a aVar2 = new w.a(this);
            o.a aVar = new o.a(n, aVar2);
            objArr[0].b(aVar);
        }
        w.b bVar = new w.b(n, length, this.b);
        n.onSubscribe(bVar);
        while (i < length) {
            obj6 = objArr[i];
            obj6.b(bVar.observers[i]);
            i++;
        }
    }
}
