package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.o0.e;
import i.b.p0.a;
import i.b.w;
import i.b.y;
import i.b.z;
import i.b.z.c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class d0<T>  extends i.b.m0.e.e.a<T, T> {

    final long b;
    final TimeUnit c;
    final z v;

    static final class a extends AtomicReference<b> implements Runnable, b {

        private static final long serialVersionUID = 6812032969491025141L;
        final long idx;
        final AtomicBoolean once;
        final i.b.m0.e.e.d0.b<T> parent;
        final T value;
        a(T t, long l2, i.b.m0.e.e.d0.b<T> d0$b3) {
            super();
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            this.once = atomicBoolean;
            this.value = t;
            this.idx = l2;
            this.parent = obj5;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void a(b b) {
            c.replace(this, b);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            int i;
            i = get() == c.DISPOSED ? 1 : 0;
            return i;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void run() {
            boolean compareAndSet;
            int idx;
            Object value;
            final int i = 1;
            if (this.once.compareAndSet(false, i)) {
                this.parent.a(this.idx, i, this.value);
            }
        }
    }

    static final class b implements y<T>, b {

        final y<? super T> a;
        final long b;
        final TimeUnit c;
        final z.c v;
        b w;
        b x;
        volatile long y;
        boolean z;
        b(y<? super T> y, long l2, TimeUnit timeUnit3, z.c z$c4) {
            super();
            this.a = y;
            this.b = l2;
            this.c = c4;
            this.v = obj5;
        }

        void a(long l, T t2, i.b.m0.e.e.d0.a<T> d0$a3) {
            int obj3;
            if (Long.compare(l, l2) == 0) {
                this.a.onNext(a3);
                obj6.dispose();
            }
        }

        @Override // i.b.y
        public void dispose() {
            this.w.dispose();
            this.v.dispose();
        }

        @Override // i.b.y
        public boolean isDisposed() {
            return this.v.isDisposed();
        }

        @Override // i.b.y
        public void onComplete() {
            if (this.z) {
            }
            this.z = true;
            b bVar = this.x;
            if (bVar != null) {
                bVar.dispose();
            }
            if ((d0.a)bVar != null) {
                (d0.a)bVar.run();
            }
            this.a.onComplete();
            this.v.dispose();
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            if (this.z) {
                a.t(throwable);
            }
            b bVar = this.x;
            if (bVar != null) {
                bVar.dispose();
            }
            this.z = true;
            this.a.onError(throwable);
            this.v.dispose();
        }

        public void onNext(T t) {
            if (this.z) {
            }
            l += i2;
            this.y = i;
            b bVar = this.x;
            if (bVar != null) {
                bVar.dispose();
            }
            d0.a aVar = new d0.a(t, i, obj1, this);
            this.x = aVar;
            aVar.a(this.v.c(aVar, this.b, obj1));
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.w, b)) {
                this.w = b;
                this.a.onSubscribe(this);
            }
        }
    }
    public d0(w<T> w, long l2, TimeUnit timeUnit3, z z4) {
        super(w);
        this.b = l2;
        this.c = z4;
        this.v = obj5;
    }

    public void subscribeActual(y<? super T> y) {
        e eVar = new e(y);
        super(eVar, this.b, obj4, this.c, this.v.a());
        this.a.subscribe(bVar2);
    }
}
