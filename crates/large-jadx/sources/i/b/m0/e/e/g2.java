package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.f;
import i.b.m0.a.c;
import i.b.m0.a.f;
import i.b.m0.j.k;
import i.b.n0.a;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class g2<T>  extends a<T> implements f {

    final w<T> a;
    final AtomicReference<i.b.m0.e.e.g2.b<T>> b;

    static final class a extends AtomicReference<i.b.m0.e.e.g2.b<T>> implements b {

        private static final long serialVersionUID = 7463222674719692880L;
        final y<? super T> downstream;
        a(y<? super T> y, i.b.m0.e.e.g2.b<T> g2$b2) {
            super();
            this.downstream = y;
            lazySet(b2);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            Object andSet = getAndSet(0);
            if ((g2.b)andSet != null) {
                (g2.b)andSet.b(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            int i;
            i = get() == null ? 1 : 0;
            return i;
        }
    }

    static final class b extends AtomicReference<i.b.m0.e.e.g2.a<T>[]> implements y<T>, b {

        static final i.b.m0.e.e.g2.a[] a = null;
        static final i.b.m0.e.e.g2.a[] b = null;
        private static final long serialVersionUID = -3251430252873581268L;
        final AtomicBoolean connect;
        final AtomicReference<i.b.m0.e.e.g2.b<T>> current;
        Throwable error;
        final AtomicReference<b> upstream;
        static {
            int i = 0;
            g2.b.a = new g2.a[i];
            g2.b.b = new g2.a[i];
        }

        b(AtomicReference<i.b.m0.e.e.g2.b<T>> atomicReference) {
            super();
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            this.connect = atomicBoolean;
            this.current = atomicReference;
            AtomicReference obj2 = new AtomicReference();
            this.upstream = obj2;
            lazySet(g2.b.a);
        }

        public boolean a(i.b.m0.e.e.g2.a<T> g2$a) {
            Object obj = get();
            final int i = 0;
            while ((g2.a[])obj == g2.b.b) {
                int length = obj.length;
                i.b.m0.e.e.g2.a[] arr = new g2.a[length + 1];
                System.arraycopy((g2.a[])obj, i, arr, i, length);
                arr[length] = a;
                obj = get();
                i = 0;
            }
            return i;
        }

        public void b(i.b.m0.e.e.g2.a<T> g2$a) {
            int length;
            int i2;
            int i;
            int i3;
            i.b.m0.e.e.g2.a[] arr;
            Object obj;
            Object obj2 = get();
            length = obj2.length;
            while (length == 0) {
                i2 = -1;
                i = 0;
                i3 = i;
                while (i3 < length) {
                    if ((g2.a[])obj2[i3] == a) {
                        break loop_3;
                    } else {
                    }
                    i3++;
                }
                arr = g2.b.a;
                int i6 = 1;
                if (length != i6) {
                }
                obj2 = get();
                length = obj2.length;
                arr = new g2.a[length + -1];
                System.arraycopy((g2.a[])obj2, i, arr, i, i2);
                System.arraycopy(obj2, i2 + 1, arr, i2, i4 -= i6);
                if (obj2[i3] == a) {
                } else {
                }
                i3++;
                i2 = i3;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            getAndSet(g2.b.b);
            this.current.compareAndSet(this, 0);
            c.dispose(this.upstream);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            int i;
            i = get() == g2.b.b ? 1 : 0;
            return i;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            int i;
            y downstream;
            this.upstream.lazySet(c.DISPOSED);
            Object andSet = getAndSet(g2.b.b);
            i = 0;
            while (i < andSet.length) {
                obj.downstream.onComplete();
                i++;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            int i;
            y downstream;
            this.error = throwable;
            this.upstream.lazySet(c.DISPOSED);
            Object andSet = getAndSet(g2.b.b);
            i = 0;
            while (i < andSet.length) {
                obj.downstream.onError(throwable);
                i++;
            }
        }

        public void onNext(T t) {
            int i;
            y downstream;
            final Object obj = get();
            i = 0;
            while (i < obj.length) {
                obj2.downstream.onNext(t);
                i++;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            c.setOnce(this.upstream, b);
        }
    }
    public g2(w<T> w) {
        super();
        this.a = w;
        AtomicReference obj1 = new AtomicReference();
        this.b = obj1;
    }

    @Override // i.b.n0.a
    public void a(b b) {
        this.b.compareAndSet((g2.b)b, 0);
    }

    public void c(f<? super b> f) {
        Object obj;
        boolean bVar;
        boolean compareAndSet;
        AtomicReference atomicReference;
        int i;
        Object obj5;
        obj = this.b.get();
        while ((g2.b)obj != null) {
            if ((g2.b)obj.isDisposed()) {
                break;
            }
            bVar = new g2.b(this.b);
            if (this.b.compareAndSet(obj, bVar)) {
                break;
            } else {
            }
            obj = this.b.get();
        }
        final int i2 = 0;
        if (!obj.connect.get() && obj.connect.compareAndSet(i2, true)) {
            if (obj.connect.compareAndSet(i2, i)) {
            } else {
                i = i2;
            }
        } else {
        }
        f.accept(obj);
        if (i != 0) {
            this.a.subscribe(obj);
        }
    }

    protected void subscribeActual(y<? super T> y) {
        Object obj;
        i.b.m0.e.e.g2.b bVar;
        AtomicReference atomicReference;
        obj = this.b.get();
        while ((g2.b)obj == null) {
            bVar = new g2.b(this.b);
            if (this.b.compareAndSet((g2.b)obj, bVar)) {
                break;
            } else {
            }
            obj = this.b.get();
        }
        g2.a aVar = new g2.a(y, obj);
        y.onSubscribe(aVar);
        if (obj.a(aVar) && aVar.isDisposed()) {
            if (aVar.isDisposed()) {
                obj.b(aVar);
            }
        }
        Throwable error = obj.error;
        if (error != null) {
            y.onError(error);
        } else {
            y.onComplete();
        }
    }
}
