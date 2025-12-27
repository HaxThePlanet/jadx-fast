package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.r;
import i.b.w;
import i.b.y;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableAmb.java */
/* loaded from: classes3.dex */
public final class h<T> extends r<T> {

    final w<? extends T>[] a;
    final Iterable<? extends w<? extends T>> b;

    static final class a<T> implements b {

        final y<? super T> a;
        final h.b<T>[] b;
        final AtomicInteger c = new AtomicInteger();
        a(y<? super T> yVar, int i) {
            super();
            final AtomicInteger atomicInteger = new AtomicInteger();
            this.a = yVar;
            this.b = new h.b[i];
        }

        public void a(w<? extends T>[] wVarArr) {
            int i = 0;
            i.b.m0.e.e.h.b bVar;
            final int length = objArr.length;
            i = 0;
            while (i < length) {
                i = i + 1;
                this.b[i] = new h.b(this, i, this.a);
            }
            this.c.lazySet(i);
            this.a.onSubscribe(this);
            while (i < length) {
                if (this.c.get() != 0) {
                    return;
                }
            }
        }

        public boolean b(int i) {
            boolean z = true;
            int i2 = 0;
            int i3 = this.c.get();
            z = true;
            i2 = 0;
            if (i3 == 0) {
                if (this.c.compareAndSet(i2, i)) {
                    while (i2 < objArr.length) {
                        i2 = i2 + 1;
                    }
                    return true;
                }
                return false;
            }
            if (i3 != i) {
            }
            return z;
        }

        public void dispose() {
            int i2 = 0;
            i.b.m0.e.e.h.b bVar;
            int length = -1;
            if (this.c.get() != length) {
                this.c.lazySet(length);
                length = objArr.length;
                i2 = 0;
                for (i.b.m0.e.e.h.b bVar : objArr) {
                    bVar.a();
                }
            }
        }

        public boolean isDisposed() {
            boolean z = true;
            int r0 = this.c.get() == -1 ? 1 : 0;
            return (this.c.get() == -1 ? 1 : 0);
        }
    }

    static final class b<T> extends AtomicReference<b> implements y<T> {

        private static final long serialVersionUID = -1185974347409665484L;
        final y<? super T> downstream;
        final int index;
        final h.a<T> parent;
        boolean won;
        b(h.a<T> aVar, int i, y<? super T> yVar) {
            super();
            this.parent = aVar;
            this.index = i;
            this.downstream = yVar;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void a() {
            c.dispose(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            if (this.won) {
                this.downstream.onComplete();
            } else {
                if (this.parent.b(this.index)) {
                    this.won = true;
                    this.downstream.onComplete();
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            if (this.won) {
                this.downstream.onError(th);
            } else {
                if (this.parent.b(this.index)) {
                    this.won = true;
                    this.downstream.onError(th);
                } else {
                    a.t(th);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onNext(T t) {
            if (this.won) {
                this.downstream.onNext(t);
            } else {
                if (this.parent.b(this.index)) {
                    this.won = true;
                    this.downstream.onNext(t);
                } else {
                    (b)get().dispose();
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b bVar) {
            c.setOnce(this, bVar);
        }
    }
    public h(w<? extends T>[] wVarArr, Iterable<? extends w<? extends T>> iterable) {
        super();
        this.a = wVarArr;
        this.b = iterable;
    }

    @Override // i.b.r
    public void subscribeActual(y<? super T> yVar) {
        w[] arr;
        int length;
        length = 0;
        if (this.a == null) {
            arr = new w[8];
            try {
                Iterator it = this.b.iterator();
                Object item = it.next();
                d.error(new NullPointerException("One of the sources is null"), yVar);
                return;
            } catch (Throwable th) {
                a.b(th);
                d.error(th, yVar);
                return;
            }
        } else {
            length = arr.length;
        }
        if (length == 0) {
            d.complete(yVar);
            return;
        }
        if (length == 1) {
            arr[length].subscribe(yVar);
            return;
        }
        new h.a(yVar, length).a(arr);
    }
}
