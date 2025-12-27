package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.f;
import i.b.m0.a.c;
import i.b.m0.j.k;
import i.b.w;
import i.b.y;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservablePublish.java */
/* loaded from: classes3.dex */
public final class f2<T> extends i.b.n0.a<T> implements h2 {

    final w<T> a;
    final AtomicReference<f2.b<T>> b;
    final w<T> c;

    static final class a<T> extends AtomicReference<Object> implements b {

        private static final long serialVersionUID = -1100270633763673112L;
        final y<? super T> child;
        a(y<? super T> yVar) {
            super();
            this.child = yVar;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        void a(f2.b<T> bVar) {
            if (!compareAndSet(null, bVar)) {
                bVar.b(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            final Object andSet = getAndSet(this);
            if (andSet != null && andSet != this) {
                andSet.b(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            boolean z = true;
            int r0 = get() == this ? 1 : 0;
            return (get() == this ? 1 : 0);
        }
    }

    static final class b<T> implements y<T>, b {

        static final f2.a[] w;
        static final f2.a[] x;
        final AtomicReference<f2.b<T>> a;
        final AtomicReference<f2.a<T>[]> b = new AtomicReference<>();
        final AtomicBoolean c = new AtomicBoolean();
        final AtomicReference<b> v = new AtomicReference<>();
        static {
            int i = 0;
            f2.b.w = new f2.a[i];
            f2.b.x = new f2.a[i];
        }

        b(AtomicReference<f2.b<T>> atomicReference) {
            super();
            AtomicReference atomicReference2 = new AtomicReference();
            AtomicReference atomicReference3 = new AtomicReference(f2.b.w);
            this.a = atomicReference;
            final AtomicBoolean atomicBoolean = new AtomicBoolean();
        }

        boolean a(f2.a<T> aVar) {
            Object obj = this.b.get();
            final int i = 0;
            while (obj == f2.b.x) {
                int length = obj.length;
                i.b.m0.e.e.f2.a[] arr = new f2.a[length + 1];
                System.arraycopy(obj, i, arr, i, length);
                arr[length] = aVar;
                if (this.b.compareAndSet(obj, arr)) {
                    return true;
                }
                obj = this.b.get();
                i = 0;
            }
            return false;
        }

        void b(f2.a<T> aVar) {
            i.b.m0.e.e.f2.a[] arr;
            int i = -1;
            boolean equals;
            Object obj = this.b.get();
            int length = obj.length;
            while (length == 0) {
                i = -1;
                i = 0;
                for (Object obj2 : obj) {
                    if (obj2.equals(aVar)) {
                        break loop_3;
                    }
                }
                int i4 = 1;
                if (this.b.compareAndSet(obj, arr)) {
                    return;
                }
            }
        }

        public void dispose() {
            objArr = f2.b.x;
            if ((f2.a[])this.b.getAndSet(objArr) != f2.b.x) {
                this.a.compareAndSet(this, null);
                c.dispose(this.v);
            }
        }

        public boolean isDisposed() {
            boolean z = true;
            int r0 = this.b.get() == f2.b.x ? 1 : 0;
            return (this.b.get() == f2.b.x ? 1 : 0);
        }

        public void onComplete() {
            int i = 0;
            this.a.compareAndSet(this, null);
            Object andSet = this.b.getAndSet(f2.b.x);
            i = 0;
            for (Object obj : andSet) {
                obj.child.onComplete();
            }
        }

        public void onError(Throwable th) {
            int i = 0;
            y child2;
            this.a.compareAndSet(this, null);
            Object andSet = this.b.getAndSet(f2.b.x);
            length = andSet.length;
            if (andSet.length != 0) {
                length = andSet.length;
                i = 0;
                for (Object obj : andSet) {
                    obj.child.onError(th);
                }
            } else {
                a.t(th);
            }
        }

        public void onNext(T t) {
            int i = 0;
            Object obj = this.b.get();
            i = 0;
            for (Object obj2 : obj) {
                obj2.child.onNext(t);
            }
        }

        public void onSubscribe(b bVar) {
            c.setOnce(this.v, bVar);
        }
    }

    static final class c<T> implements w<T> {

        private final AtomicReference<f2.b<T>> a;
        c(AtomicReference<f2.b<T>> atomicReference) {
            super();
            this.a = atomicReference;
        }

        public void subscribe(y<? super T> yVar) {
            i.b.m0.e.e.f2.b bVar;
            AtomicReference atomicReference;
            final i.b.m0.e.e.f2.a aVar = new f2.a(yVar);
            yVar.onSubscribe(aVar);
            Object obj = this.a.get();
            do {
                obj = this.a.get();
                bVar = new f2.b(this.a);
                if (bVar.a(aVar)) {
                    aVar.a(bVar);
                    return;
                }
            } while (obj != null);
            aVar.a(bVar);
        }
    }
    private f2(w<T> wVar, w<T> wVar2, AtomicReference<f2.b<T>> atomicReference) {
        super();
        this.c = wVar;
        this.a = wVar2;
        this.b = atomicReference;
    }

    public static <T> i.b.n0.a<T> f(w<T> wVar) {
        final AtomicReference atomicReference = new AtomicReference();
        return a.q(new f2(new f2.c(atomicReference), wVar, atomicReference));
    }

    @Override // i.b.n0.a
    public w<T> b() {
        return this.a;
    }

    @Override // i.b.n0.a
    public void c(f<? super b> fVar) {
        i.b.m0.e.e.f2.b bVar;
        boolean compareAndSet;
        boolean z = true;
        Object obj = this.b.get();
        while (obj != null) {
            bVar = new f2.b(this.b);
            if (this.b.compareAndSet(obj, bVar)) {
                break;
            }
        }
        z = true;
        z = false;
        if (!bVar.c.get()) {
            if (!(bVar.c.compareAndSet(z, true))) {
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
        this.c.subscribe(yVar);
    }
}
