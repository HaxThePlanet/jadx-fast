package i.b.m0.e.e;

import i.b.l0.n;
import i.b.m0.a.d;
import i.b.r;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableZip.java */
/* loaded from: classes3.dex */
public final class m4<T, R> extends r<R> {

    final w<? extends T>[] a;
    final Iterable<? extends w<? extends T>> b;
    final n<? super Object[], ? extends R> c;
    final int v;
    final boolean w;

    static final class a<T, R> extends AtomicInteger implements i.b.j0.b {

        private static final long serialVersionUID = 2983708048395377667L;
        volatile boolean cancelled;
        final boolean delayError;
        final y<? super R> downstream;
        final m4.b<T, R>[] observers;
        final T[] row;
        final n<? super Object[], ? extends R> zipper;
        a(y<? super R> yVar, n<? super Object[], ? extends R> nVar, int i, boolean z) {
            super();
            this.downstream = yVar;
            this.zipper = nVar;
            this.observers = new m4.b[i];
            this.row = new Object[i];
            this.delayError = z;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            d();
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b() {
            int i = 0;
            i = 0;
            for (i.b.m0.e.e.m4.b bVar : observers2) {
                bVar.a();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        boolean c(boolean z, boolean z2, y<? super R> yVar, boolean z3, m4.b<?, ?> bVar) {
            z3 = true;
            if (this.cancelled) {
                a();
                return true;
            }
            if (z && z3 && z2) {
                this.cancelled = z3;
                a();
                if (bVar.v != null) {
                    yVar.onError(bVar.v);
                } else {
                    yVar.onComplete();
                }
                return true;
            }
            return false;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void d() {
            int i = 0;
            i = 0;
            for (i.b.m0.e.e.m4.b bVar : observers2) {
                bVar.b.clear();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                b();
                if (getAndIncrement() == 0) {
                    d();
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void e() {
            Object obj = null;
            String str;
            boolean z;
            y downstream2;
            boolean delayError2;
            i.b.m0.e.e.m4.b bVar;
            int andGet;
            int i;
            Object poll;
            final Object obj3 = this;
            if (getAndIncrement() != 0) {
                return;
            }
            final boolean z5 = true;
            andGet = z5;
            while (/* condition */) {
                for (i.b.m0.e.e.m4.b bVar : observers2) {
                    if (row2[i] != null) {
                    }
                }
                if (i != 0) {
                }
                bVar = observers2[i];
                if (row2[i] != null) {
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void f(w<? extends T>[] wVarArr, int i) {
            final int length = observers2.length;
            i = 0;
            while (i < length) {
                this.observers[i] = new m4.b(this, i);
                i = i + 1;
            }
            lazySet(i);
            this.downstream.onSubscribe(this);
            while (i < length) {
                if (this.cancelled) {
                    return;
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    static final class b<T, R> implements y<T> {

        final m4.a<T, R> a;
        final i.b.m0.f.c<T> b = new c<>();
        volatile boolean c;
        Throwable v;
        final AtomicReference<i.b.j0.b> w = new AtomicReference<>();
        b(m4.a<T, R> aVar, int i) {
            super();
            final AtomicReference atomicReference = new AtomicReference();
            this.a = aVar;
            final i.b.m0.f.c cVar = new c(i);
        }

        public void a() {
            c.dispose(this.w);
        }

        public void onComplete() {
            this.c = true;
            this.a.e();
        }

        public void onError(Throwable th) {
            this.v = th;
            this.c = true;
            this.a.e();
        }

        public void onNext(T t) {
            this.b.offer(t);
            this.a.e();
        }

        public void onSubscribe(i.b.j0.b bVar) {
            c.setOnce(this.w, bVar);
        }
    }
    public m4(w<? extends T>[] wVarArr, Iterable<? extends w<? extends T>> iterable, n<? super Object[], ? extends R> nVar, int i, boolean z) {
        super();
        this.a = wVarArr;
        this.b = iterable;
        this.c = nVar;
        this.v = i;
        this.w = z;
    }

    @Override // i.b.r
    public void subscribeActual(y<? super R> yVar) {
        w[] arr;
        int length;
        if (this.a == null) {
            arr = new w[8];
            Iterator it = this.b.iterator();
            length = 0;
            while (it.hasNext()) {
                length2 = arr.length;
                length = length + 1;
                arr[length] = (w)it.next();
            }
        } else {
            length = arr.length;
        }
        if (length == 0) {
            d.complete(yVar);
            return;
        }
        new m4.a(yVar, this.c, length, this.w).f(arr, this.v);
    }
}
