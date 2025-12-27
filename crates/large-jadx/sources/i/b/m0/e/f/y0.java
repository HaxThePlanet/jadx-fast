package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.l0.n;
import i.b.m0.a.c;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleZipArray.java */
/* loaded from: classes3.dex */
public final class y0<T, R> extends a0<R> {

    final g0<? extends T>[] a;
    final n<? super Object[], ? extends R> b;

    final class a implements n<T, R> {

        final /* synthetic */ y0 a;
        a() {
            this.a = y0Var;
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
        final d0<? super R> downstream;
        final y0.c<T>[] observers;
        final Object[] values;
        final n<? super Object[], ? extends R> zipper;
        b(d0<? super R> d0Var, int i, n<? super Object[], ? extends R> nVar) {
            super(i);
            this.downstream = d0Var;
            this.zipper = nVar;
            i.b.m0.e.f.y0.c[] arr = new y0.c[i];
            i = 0;
            while (i < i) {
                arr[i] = new y0.c(this, i);
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
        void b(Throwable th, int i) {
            if (getAndSet(0) > 0) {
                a(i);
                this.downstream.onError(th);
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void c(T t, int i) {
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
            i.b.m0.e.f.y0.c cVar;
            i = 0;
            if (getAndSet(i) > 0) {
                length = observers2.length;
                for (i.b.m0.e.f.y0.c cVar : observers2) {
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

    static final class c<T> extends AtomicReference<i.b.j0.b> implements d0<T> {

        private static final long serialVersionUID = 3323743579927613702L;
        final int index;
        final y0.b<T, ?> parent;
        c(y0.b<T, ?> bVar, int i) {
            super();
            this.parent = bVar;
            this.index = i;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void a() {
            c.dispose(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            this.parent.b(th, this.index);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(i.b.j0.b bVar) {
            c.setOnce(this, bVar);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSuccess(T t) {
            this.parent.c(t, this.index);
        }
    }
    public y0(g0<? extends T>[] g0VarArr, n<? super Object[], ? extends R> nVar) {
        super();
        this.a = g0VarArr;
        this.b = nVar;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super R> d0Var) {
        int i = 0;
        int length = objArr.length;
        i = 0;
        if (length == 1) {
            objArr[0].subscribe(new k0.a(d0Var, new y0.a(this)));
            return;
        }
        i.b.m0.e.f.y0.b bVar = new y0.b(d0Var, length, this.b);
        d0Var.onSubscribe(bVar);
        while (i < length) {
            g0 g0Var = objArr[i];
            if (g0Var == null) {
                bVar.b(new NullPointerException("One of the sources is null"), i);
                return;
            }
        }
    }
}
