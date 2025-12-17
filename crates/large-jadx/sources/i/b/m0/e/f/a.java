package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.a;
import i.b.j0.b;
import i.b.m0.a.d;
import i.b.p0.a;
import io.reactivex.exceptions.a;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class a<T>  extends a0<T> {

    private final g0<? extends T>[] a;
    private final Iterable<? extends g0<? extends T>> b;

    static final class a implements d0<T> {

        final a a;
        final d0<? super T> b;
        final AtomicBoolean c;
        b v;
        a(d0<? super T> d0, a a2, AtomicBoolean atomicBoolean3) {
            super();
            this.b = d0;
            this.a = a2;
            this.c = atomicBoolean3;
        }

        @Override // i.b.d0
        public void onError(Throwable throwable) {
            d0 compareAndSet;
            b i;
            if (this.c.compareAndSet(false, true)) {
                this.a.c(this.v);
                this.a.dispose();
                this.b.onError(throwable);
            } else {
                a.t(throwable);
            }
        }

        @Override // i.b.d0
        public void onSubscribe(b b) {
            this.v = b;
            this.a.b(b);
        }

        public void onSuccess(T t) {
            boolean compareAndSet;
            int i;
            if (this.c.compareAndSet(false, true)) {
                this.a.c(this.v);
                this.a.dispose();
                this.b.onSuccess(t);
            }
        }
    }
    public a(g0<? extends T>[] g0Arr, Iterable<? extends g0<? extends T>> iterable2) {
        super();
        this.a = g0Arr;
        this.b = iterable2;
    }

    protected void subscribeActual(d0<? super T> d0) {
        g0[] arr;
        Iterator iterator;
        int length;
        Object next;
        int i2;
        int length2;
        int i;
        g0 g0Var;
        i.b.m0.e.f.a.a aVar;
        arr = this.a;
        String str = "One of the sources is null";
        final int i5 = 0;
        if (arr == null) {
            arr = new g0[8];
            iterator = this.b.iterator();
            length = i5;
            for (g0 next : iterator) {
                if (length == arr.length) {
                }
                arr[length] = next;
                length = i2;
                length2 = new g0[i6 += length];
                System.arraycopy(arr, i5, length2, i5, length);
                arr = length2;
            }
        } else {
            length = arr.length;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        a aVar2 = new a();
        d0.onSubscribe(aVar2);
        i = i5;
        try {
            while (i < length) {
                g0Var = arr[i];
                aVar = new a.a(d0, aVar2, atomicBoolean);
                g0Var.subscribe(aVar);
                i++;
            }
            g0Var = arr[i];
            if (aVar2.isDisposed()) {
            } else {
            }
            if (g0Var == null) {
            } else {
            }
            aVar2.dispose();
            NullPointerException nullPointerException2 = new NullPointerException(str);
            if (atomicBoolean.compareAndSet(i5, true)) {
            } else {
            }
            d0.onError(nullPointerException2);
            a.t(nullPointerException2);
            aVar = new a.a(d0, aVar2, atomicBoolean);
            g0Var.subscribe(aVar);
            i++;
        }
    }
}
