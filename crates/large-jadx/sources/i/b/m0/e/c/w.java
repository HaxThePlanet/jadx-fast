package i.b.m0.e.c;

import i.b.l;
import i.b.m0.a.c;
import i.b.p;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeZipArray.java */
/* loaded from: classes3.dex */
public final class w<T, R> extends l<R> {

    final p<? extends T>[] a;
    final i.b.l0.n<? super Object[], ? extends R> b;

    final class a implements i.b.l0.n<T, R> {

        final /* synthetic */ w a;
        a() {
            this.a = wVar;
            super();
        }

        public R apply(T t) {
            Object[] arr = new Object[1];
            final Object apply = this.a.b.apply(new Object[] { t });
            b.e(apply, "The zipper returned a null value");
            return apply;
        }
    }

    static final class b<T, R> extends AtomicInteger implements i.b.j0.b {

        private static final long serialVersionUID = -5556924161382950569L;
        final i.b.n<? super R> downstream;
        final w.c<T>[] observers;
        final Object[] values;
        final i.b.l0.n<? super Object[], ? extends R> zipper;
        b(i.b.n<? super R> nVar, int i, i.b.l0.n<? super Object[], ? extends R> nVar2) {
            super(i);
            this.downstream = nVar;
            this.zipper = nVar2;
            i.b.m0.e.c.w.c[] arr = new w.c[i];
            i = 0;
            while (i < i) {
                arr[i] = new w.c(this, i);
                i = i + 1;
            }
            this.observers = arr;
            this.values = new Object[i];
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a(int i) {
            int i2 = 0;
            int i3;
            i2 = 0;
            while (i2 < i) {
                observers2[i2].a();
                i2 = i2 + 1;
            }
            i3 = i3 + 1;
            for (int i2 : observers2) {
                i2.a();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b(int i) {
            if (getAndSet(0) > 0) {
                a(i);
                this.downstream.onComplete();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void c(Throwable th, int i) {
            if (getAndSet(0) > 0) {
                a(i);
                this.downstream.onError(th);
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void d(T t, int i) {
            this.values[i] = t;
            if (decrementAndGet() == 0) {
                try {
                    Object apply = this.zipper.apply(this.values);
                    b.e(apply, "The zipper returned a null value");
                } catch (Throwable th) {
                    a.b(th);
                    this.downstream.onError(th);
                }
                this.downstream.onSuccess(apply);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            int i = 0;
            i.b.m0.e.c.w.c cVar;
            i = 0;
            if (getAndSet(i) > 0) {
                length = observers2.length;
                for (i.b.m0.e.c.w.c cVar : observers2) {
                    cVar.a();
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            boolean z = true;
            int r0 = get() <= 0 ? 1 : 0;
            return (get() <= 0 ? 1 : 0);
        }
    }

    static final class c<T> extends AtomicReference<i.b.j0.b> implements i.b.n<T> {

        private static final long serialVersionUID = 3323743579927613702L;
        final int index;
        final w.b<T, ?> parent;
        c(w.b<T, ?> bVar, int i) {
            super();
            this.parent = bVar;
            this.index = i;
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
        public void onError(Throwable th) {
            this.parent.c(th, this.index);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(i.b.j0.b bVar) {
            c.setOnce(this, bVar);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSuccess(T t) {
            this.parent.d(t, this.index);
        }
    }
    public w(p<? extends T>[] pVarArr, i.b.l0.n<? super Object[], ? extends R> nVar) {
        super();
        this.a = pVarArr;
        this.b = nVar;
    }

    @Override // i.b.l
    protected void w(i.b.n<? super R> nVar) {
        int i = 0;
        int length = objArr.length;
        i = 0;
        if (length == 1) {
            objArr[0].b(new o.a(nVar, new w.a(this)));
            return;
        }
        i.b.m0.e.c.w.b bVar = new w.b(nVar, length, this.b);
        nVar.onSubscribe(bVar);
        while (i < length) {
            p pVar = objArr[i];
            if (pVar == null) {
                bVar.c(new NullPointerException("One of the sources is null"), i);
                return;
            }
        }
    }
}
