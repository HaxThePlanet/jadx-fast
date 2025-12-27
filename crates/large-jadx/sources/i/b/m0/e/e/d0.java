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

/* compiled from: ObservableDebounceTimed.java */
/* loaded from: classes3.dex */
public final class d0<T> extends a<T, T> {

    final long b;
    final TimeUnit c;
    final z v;

    static final class a<T> extends AtomicReference<b> implements Runnable, b {

        private static final long serialVersionUID = 6812032969491025141L;
        final long idx;
        final AtomicBoolean once = new AtomicBoolean();
        final d0.b<T> parent;
        final T value;
        a(T t, long j, d0.b<T> bVar) {
            super();
            final AtomicBoolean atomicBoolean = new AtomicBoolean();
            this.value = t;
            this.idx = j;
            this.parent = bVar;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void a(b bVar) {
            c.replace(this, bVar);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            boolean z = true;
            int r0 = get() == c.DISPOSED ? 1 : 0;
            return (get() == c.DISPOSED ? 1 : 0);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void run() {
            boolean z = false;
            final boolean z2 = true;
            if (this.once.compareAndSet(z, z2)) {
                this.parent.a(this.idx, this.value, this);
            }
        }
    }

    static final class b<T> implements y<T>, b {

        final y<? super T> a;
        final long b;
        final TimeUnit c;
        final z.c v;
        b w;
        b x;
        volatile long y;
        boolean z;
        b(y<? super T> yVar, long j, TimeUnit timeUnit, z.c cVar) {
            super();
            this.a = yVar;
            this.b = j;
            this.c = timeUnit;
            this.v = cVar;
        }

        void a(long j, T t, d0.a<T> aVar) {
            if (j == this.y) {
                this.a.onNext(t);
                aVar.dispose();
            }
        }

        public void dispose() {
            this.w.dispose();
            this.v.dispose();
        }

        public boolean isDisposed() {
            return this.v.isDisposed();
        }

        public void onComplete() {
            if (this.z) {
                return;
            }
            this.z = true;
            if (this.x != null) {
                this.x.dispose();
            }
            if (bVar != null) {
                bVar.run();
            }
            this.a.onComplete();
            this.v.dispose();
        }

        public void onError(Throwable th) {
            if (this.z) {
                a.t(th);
                return;
            }
            if (this.x != null) {
                this.x.dispose();
            }
            this.z = true;
            this.a.onError(th);
            this.v.dispose();
        }

        public void onNext(T t) {
            if (this.z) {
                return;
            }
            this.y++;
            if (this.x != null) {
                this.x.dispose();
            }
            i.b.m0.e.e.d0.a aVar = new d0.a(t, l2, bVar, this);
            this.x = aVar;
            aVar.a(this.v.c(aVar, this.b, this.c));
        }

        public void onSubscribe(b bVar) {
            if (c.validate(this.w, bVar)) {
                this.w = bVar;
                this.a.onSubscribe(this);
            }
        }
    }
    public d0(w<T> wVar, long j, TimeUnit timeUnit, z zVar) {
        super(wVar);
        this.b = j;
        this.c = timeUnit;
        this.v = zVar;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super T> yVar) {
        d0.b bVar = new d0.b(new e(yVar), this.b, timeUnit, this.c, this.v.a());
        this.a.subscribe(bVar);
    }
}
