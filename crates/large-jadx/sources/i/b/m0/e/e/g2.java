package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.j.k;
import i.b.w;
import i.b.y;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservablePublishAlt.java */
/* loaded from: classes3.dex */
public final class g2<T> extends i.b.n0.a<T> implements i.b.m0.a.f {

    final w<T> a;
    final AtomicReference<g2.b<T>> b = new AtomicReference<>();

    static final class a<T> extends AtomicReference<g2.b<T>> implements b {

        private static final long serialVersionUID = 7463222674719692880L;
        final y<? super T> downstream;
        a(y<? super T> yVar, g2.b<T> bVar) {
            super();
            this.downstream = yVar;
            lazySet(bVar);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            Object andSet = getAndSet(null);
            if (andSet != null) {
                andSet.b(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            boolean z = true;
            int r0 = get() == null ? 1 : 0;
            return (get() == null ? 1 : 0);
        }
    }

    static final class b<T> extends AtomicReference<g2.a<T>[]> implements y<T>, b {

        static final g2.a[] a;
        static final g2.a[] b;
        private static final long serialVersionUID = -3251430252873581268L;
        final AtomicBoolean connect = new AtomicBoolean();
        final AtomicReference<g2.b<T>> current;
        Throwable error;
        final AtomicReference<b> upstream = new AtomicReference<>();
        static {
            int i = 0;
            g2.b.a = new g2.a[i];
            g2.b.b = new g2.a[i];
        }

        b(AtomicReference<g2.b<T>> atomicReference) {
            super();
            final AtomicBoolean atomicBoolean = new AtomicBoolean();
            this.current = atomicReference;
            AtomicReference atomicReference2 = new AtomicReference();
            lazySet(g2.b.a);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean a(g2.a<T> aVar) {
            Object obj = get();
            final int i = 0;
            while (obj == g2.b.b) {
                int length = obj.length;
                i.b.m0.e.e.g2.a[] arr = new g2.a[length + 1];
                System.arraycopy(obj, i, arr, i, length);
                arr[length] = aVar;
                if (compareAndSet(obj, arr)) {
                    return true;
                }
                obj = get();
                i = 0;
            }
            return false;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void b(g2.a<T> aVar) {
            int i = -1;
            i.b.m0.e.e.g2.a[] arr;
            Object obj;
            Object obj2 = get();
            length = obj2.length;
            while (length == 0) {
                i = -1;
                i = 0;
                for (Object obj : obj2) {
                    if (obj == aVar) {
                        break loop_3;
                    }
                }
                arr = g2.b.a;
                int i4 = 1;
                if (compareAndSet(obj2, arr)) {
                    return;
                }
                obj2 = get();
                length = obj2.length;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            getAndSet(g2.b.b);
            this.current.compareAndSet(this, null);
            c.dispose(this.upstream);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            boolean z = true;
            int r0 = get() == g2.b.b ? 1 : 0;
            return (get() == g2.b.b ? 1 : 0);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            int i = 0;
            this.upstream.lazySet(c.DISPOSED);
            Object andSet = getAndSet(g2.b.b);
            i = 0;
            for (Object obj : andSet) {
                obj.downstream.onComplete();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            int i = 0;
            this.error = th;
            this.upstream.lazySet(c.DISPOSED);
            Object andSet = getAndSet(g2.b.b);
            i = 0;
            for (Object obj : andSet) {
                obj.downstream.onError(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onNext(T t) {
            int i = 0;
            final Object obj = get();
            i = 0;
            for (Object obj2 : obj) {
                obj2.downstream.onNext(t);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b bVar) {
            c.setOnce(this.upstream, bVar);
        }
    }
    public g2(w<T> wVar) {
        super();
        this.a = wVar;
        final AtomicReference atomicReference = new AtomicReference();
    }

    @Override // i.b.n0.a
    public void a(b bVar) {
        this.b.compareAndSet(bVar, null);
    }

    @Override // i.b.n0.a
    public void c(i.b.l0.f<? super b> fVar) {
        i.b.m0.e.e.g2.b bVar;
        boolean compareAndSet;
        boolean z = true;
        Object obj = this.b.get();
        while (obj != null) {
            bVar = new g2.b(this.b);
            if (this.b.compareAndSet(obj, bVar)) {
                break;
            }
        }
        z = true;
        z = false;
        if (!bVar.connect.get()) {
            if (!(bVar.connect.compareAndSet(z, true))) {
            }
        }
        try {
            fVar.accept(bVar);
        } finally {
            a.b(fVar);
            fVar = k.e(fVar);
            throw fVar;
        }
        if (this.b) {
            this.a.subscribe(bVar);
        }
    }

    @Override // i.b.n0.a
    protected void subscribeActual(y<? super T> yVar) {
        i.b.m0.e.e.g2.b bVar;
        Object obj = this.b.get();
        while (obj == null) {
            bVar = new g2.b(this.b);
            if (this.b.compareAndSet(obj, bVar)) {
                break;
            }
        }
        i.b.m0.e.e.g2.a aVar = new g2.a(yVar, bVar);
        yVar.onSubscribe(aVar);
        if (bVar.a(aVar) && aVar.isDisposed()) {
            bVar.b(aVar);
            return;
        }
        if (bVar.error != null) {
            yVar.onError(bVar.error);
        } else {
            yVar.onComplete();
        }
    }
}
