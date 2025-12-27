package i.b.t0;

import i.b.m0.a.d;
import i.b.m0.c.j;
import i.b.m0.f.c;
import i.b.p0.a;
import i.b.r;
import i.b.y;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: UnicastSubject.java */
/* loaded from: classes3.dex */
public final class e<T> extends d<T> {

    final i.b.m0.d.b<T> A = new e$a<>();
    boolean B;
    final c<T> a = new c<>();
    final AtomicReference<y<? super T>> b = new AtomicReference<>();
    final AtomicReference<Runnable> c = new AtomicReference<>();
    final boolean v;
    volatile boolean w;
    volatile boolean x;
    Throwable y;
    final AtomicBoolean z = new AtomicBoolean();

    final class a extends i.b.m0.d.b<T> {

        private static final long serialVersionUID = 7926949470189395511L;
        a() {
            super();
        }

        @Override // i.b.m0.d.b
        public void clear() {
            e.this.a.clear();
        }

        @Override // i.b.m0.d.b
        public void dispose() {
            if (!e.this.w) {
                e.this.w = true;
                e.this.g();
                Object obj = null;
                e.this.b.lazySet(obj);
                if (e.this.A.getAndIncrement() == 0) {
                    e.this.b.lazySet(obj);
                    if (!this$027.B) {
                        this$027.a.clear();
                    }
                }
            }
        }

        @Override // i.b.m0.d.b
        public boolean isDisposed() {
            return e.this.w;
        }

        @Override // i.b.m0.d.b
        public boolean isEmpty() {
            return e.this.a.isEmpty();
        }

        @Override // i.b.m0.d.b
        public T poll() {
            return e.this.a.poll();
        }

        @Override // i.b.m0.d.b
        public int requestFusion(int i) {
            final int i2 = 2;
            if (i & i2 != 0) {
                e.this.B = true;
                return i2;
            }
            return 0;
        }
    }
    e(int i, boolean z) {
        super();
        b.f(i, "capacityHint");
        final c cVar = new c(i);
        AtomicReference atomicReference = new AtomicReference();
        this.v = z;
        AtomicReference atomicReference2 = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        i.b.t0.e.a aVar = new e.a(this);
    }

    public static <T> e<T> d() {
        return new e(r.bufferSize(), true);
    }

    public static <T> e<T> e(int i) {
        return new e(i, true);
    }

    public static <T> e<T> f(int i, Runnable runnable) {
        return new e(i, runnable, true);
    }

    @Override // i.b.t0.d
    void g() {
        Object obj2 = this.c.get();
        if (obj2 != null) {
            Object obj = null;
            if (this.c.compareAndSet(obj2, obj)) {
                obj2.run();
            }
        }
    }

    @Override // i.b.t0.d
    void h() {
        y yVar;
        int andGet = 1;
        if (this.A.getAndIncrement() != 0) {
            return;
        }
        Object obj = this.b.get();
        andGet = 1;
        while (this.A != null) {
            if (this.A.addAndGet(-andGet) == 0) {
                return;
            }
        }
        if (this.B) {
            i(yVar);
        } else {
            j(yVar);
        }
    }

    @Override // i.b.t0.d
    void i(y<? super T> yVar) {
        int andGet = 1;
        boolean z;
        andGet = 1;
        Object obj = null;
        while (this.w) {
            yVar.onNext(obj);
            if (this.A.addAndGet(-andGet) == 0) {
                return;
            }
            obj = null;
        }
        this.b.lazySet(obj);
    }

    @Override // i.b.t0.d
    void j(y<? super T> yVar) {
        int andGet;
        andGet = 1;
        while (this.w) {
            Object poll = this.a.poll();
            andGet = 0;
            int r8 = andGet;
            if (andGet != 0) {
            }
        }
        this.b.lazySet(null);
        this.a.clear();
    }

    @Override // i.b.t0.d
    void k(y<? super T> yVar) {
        this.b.lazySet(null);
        if (this.y != null) {
            yVar.onError(this.y);
        } else {
            yVar.onComplete();
        }
    }

    @Override // i.b.t0.d
    boolean l(j<T> jVar, y<? super T> yVar) {
        if (this.y != null) {
            this.b.lazySet(null);
            jVar.clear();
            yVar.onError(this.y);
            return true;
        }
        return false;
    }

    @Override // i.b.t0.d
    public void onComplete() {
    }

    @Override // i.b.t0.d
    public void onError(Throwable th) {
        b.e(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        a.t(th);
    }

    @Override // i.b.t0.d
    public void onNext(T t) {
        b.e(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
    }

    @Override // i.b.t0.d
    public void onSubscribe(i.b.j0.b bVar) {
        boolean z;
        if (this.x || this.w) {
            bVar.dispose();
        }
    }

    @Override // i.b.t0.d
    protected void subscribeActual(y<? super T> yVar) {
        boolean z2 = true;
        if (!this.z.get()) {
            z2 = true;
            if (this.z.compareAndSet(false, z2)) {
                yVar.onSubscribe(this.A);
                this.b.lazySet(yVar);
                if (this.w) {
                    this.b.lazySet(null);
                    return;
                }
                h();
            } else {
                str = "Only a single observer allowed.";
                d.error(new IllegalStateException(str), yVar);
            }
        }
    }

    e(int i, Runnable runnable, boolean z) {
        super();
        b.f(i, "capacityHint");
        c cVar = new c(i);
        b.e(runnable, "onTerminate");
        AtomicReference atomicReference = new AtomicReference(runnable);
        this.v = z;
        AtomicReference atomicReference2 = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        i.b.t0.e.a aVar = new e.a(this);
    }
}
