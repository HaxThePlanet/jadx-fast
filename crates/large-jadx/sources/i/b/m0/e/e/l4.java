package i.b.m0.e.e;

import i.b.l0.n;
import i.b.m0.a.d;
import i.b.m0.j.l;
import i.b.w;
import i.b.y;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: ObservableWithLatestFromMany.java */
/* loaded from: classes3.dex */
public final class l4<T, R> extends a<T, R> {

    final w<?>[] b;
    final Iterable<? extends w<?>> c;
    final n<? super Object[], R> v;

    final class a implements n<T, R> {

        final /* synthetic */ l4 a;
        a() {
            this.a = l4Var;
            super();
        }

        public R apply(T t) {
            Object[] arr = new Object[1];
            final Object apply = this.a.v.apply(new Object[] { t });
            b.e(apply, "The combiner returned a null value");
            return apply;
        }
    }

    static final class b<T, R> extends AtomicInteger implements y<T>, i.b.j0.b {

        private static final long serialVersionUID = 1577321883966341961L;
        final n<? super Object[], R> combiner;
        volatile boolean done;
        final y<? super R> downstream;
        final i.b.m0.j.c error = new c();
        final l4.c[] observers;
        final AtomicReference<i.b.j0.b> upstream = new AtomicReference<>();
        final AtomicReferenceArray<Object> values = new AtomicReferenceArray<>();
        b(y<? super R> yVar, n<? super Object[], R> nVar, int i) {
            super();
            this.downstream = yVar;
            this.combiner = nVar;
            i.b.m0.e.e.l4.c[] arr = new l4.c[i];
            i = 0;
            while (i < i) {
                arr[i] = new l4.c(this, i);
                i = i + 1;
            }
            this.observers = arr;
            AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(i);
            AtomicReference atomicReference = new AtomicReference();
            i.b.m0.j.c cVar2 = new c();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a(int i) {
            int i2 = 0;
            int length;
            i2 = 0;
            length = observers2.length;
            while (i2 < observers2.length) {
                i2 = i2 + 1;
                length = observers2.length;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b(int i, boolean z) {
            if (!z) {
                this.done = true;
                a(i);
                l.a(this.downstream, this, this.error);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void c(int i, Throwable th) {
            this.done = true;
            c.dispose(this.upstream);
            a(i);
            l.c(this.downstream, th, this, this.error);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void d(int i, Object object) {
            this.values.set(i, object);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            int i = 0;
            c.dispose(this.upstream);
            i = 0;
            for (i.b.m0.e.e.l4.c cVar : observers2) {
                cVar.a();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void e(w<?>[] wVarArr, int i) {
            Object obj;
            i = 0;
            while (i < i) {
                if (this.done) {
                    break;
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return c.isDisposed((b)this.upstream.get());
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                a(-1);
                l.a(this.downstream, this, this.error);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable th) {
            if (this.done) {
                a.t(th);
                return;
            }
            this.done = true;
            a(-1);
            l.c(this.downstream, th, this, this.error);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onNext(T t) {
            int i = 0;
            if (this.done) {
                return;
            }
            int length = this.values.length();
            Object[] arr = new Object[length + 1];
            i = 0;
            arr[i] = t;
            while (i < length) {
                Object obj = this.values.get(i);
                if (obj == null) {
                    return;
                }
            }
            try {
                Object apply = this.combiner.apply(arr);
                b.e(apply, "combiner returned a null value");
            } catch (Throwable th) {
                a.b(th);
                dispose();
                onError(th);
                return;
            }
            l.e(this.downstream, apply, this, this.error);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(i.b.j0.b bVar) {
            c.setOnce(this.upstream, bVar);
        }
    }

    static final class c extends AtomicReference<i.b.j0.b> implements y<Object> {

        private static final long serialVersionUID = 3256684027868224024L;
        boolean hasValue;
        final int index;
        final l4.b<?, ?> parent;
        c(l4.b<?, ?> bVar, int i) {
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
            this.parent.b(this.index, this.hasValue);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            this.parent.c(this.index, th);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onNext(Object object) {
            if (!this.hasValue) {
                boolean hasValue2 = true;
                this.hasValue = hasValue2;
            }
            this.parent.d(this.index, object);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(i.b.j0.b bVar) {
            c.setOnce(this, bVar);
        }
    }
    public l4(w<T> wVar, w<?>[] wVarArr, n<? super Object[], R> nVar) {
        super(wVar);
        this.b = wVarArr;
        this.c = null;
        this.v = nVar;
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super R> yVar) {
        w[] arr;
        int length;
        int i;
        if (this.b == null) {
            arr = new w[8];
            try {
                Iterator it = this.c.iterator();
                length = 0;
                length2 = arr.length;
                if (length == arr.length) {
                    length2 = (length >> 1) + length;
                    Object[] copy = Arrays.copyOf(arr, length2);
                }
                i = length + 1;
                arr[length] = (w)it.next();
            } catch (Throwable th) {
                a.b(th);
                d.error(th, yVar);
                return;
            }
        } else {
            length = arr.length;
        }
        if (length == 0) {
            new v1(this.a, new l4.a(this)).subscribeActual(yVar);
            return;
        }
        i.b.m0.e.e.l4.b bVar = new l4.b(yVar, this.v, length);
        yVar.onSubscribe(bVar);
        bVar.e(arr, length);
        this.a.subscribe(bVar);
    }

    public l4(w<T> wVar, Iterable<? extends w<?>> iterable, n<? super Object[], R> nVar) {
        super(wVar);
        this.b = null;
        this.c = iterable;
        this.v = nVar;
    }
}
