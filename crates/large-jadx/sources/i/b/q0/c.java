package i.b.q0;

import i.b.m0.i.g;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: UnicastProcessor.java */
/* loaded from: classes3.dex */
public final class c<T> extends a<T> {

    final AtomicBoolean A;
    final i.b.m0.i.a<T> B;
    final AtomicLong C;
    boolean D;
    final i.b.m0.f.c<T> b;
    final AtomicReference<Runnable> c;
    final boolean v;
    volatile boolean w;
    Throwable x;
    final AtomicReference<m.c.b<? super T>> y;
    volatile boolean z;

    final class a extends i.b.m0.i.a<T> {

        private static final long serialVersionUID = -4896760517184205454L;
        a() {
            super();
        }

        @Override // i.b.m0.i.a
        public void cancel() {
            if (c.this.z) {
                return;
            }
            c.this.z = true;
            c.this.j0();
            Object obj = null;
            c.this.y.lazySet(obj);
            if (c.this.B.getAndIncrement() == 0) {
                c.this.y.lazySet(obj);
                if (!this$027.D) {
                    this$027.b.clear();
                }
            }
        }

        @Override // i.b.m0.i.a
        public void clear() {
            c.this.b.clear();
        }

        @Override // i.b.m0.i.a
        public boolean isEmpty() {
            return c.this.b.isEmpty();
        }

        @Override // i.b.m0.i.a
        public T poll() {
            return c.this.b.poll();
        }

        @Override // i.b.m0.i.a
        public void request(long j) {
            if (g.validate(j)) {
                d.a(c.this.C, j);
                c.this.k0();
            }
        }

        @Override // i.b.m0.i.a
        public int requestFusion(int i) {
            final int i2 = 2;
            if (i & i2 != 0) {
                c.this.D = true;
                return i2;
            }
            return 0;
        }
    }
    c(int i) {
        this(i, null, true);
    }

    public static <T> c<T> i0(int i) {
        return new c(i);
    }

    @Override // i.b.q0.a
    protected void c0(m.c.b<? super T> bVar) {
        boolean z2 = true;
        if (!this.A.get()) {
            z2 = true;
            if (!this.A.compareAndSet(false, z2)) {
                str = "This processor allows only a single Subscriber";
                d.error(new IllegalStateException(str), bVar);
            } else {
                bVar.onSubscribe(this.B);
                this.y.set(bVar);
                if (this.z) {
                    this.y.lazySet(null);
                } else {
                    k0();
                }
            }
        }
    }

    @Override // i.b.q0.a
    boolean h0(boolean z, boolean z2, boolean z3, m.c.b<? super T> bVar, i.b.m0.f.c<T> cVar) {
        Throwable th;
        final boolean z5 = true;
        final Object obj = null;
        if (this.z) {
            cVar.clear();
            this.y.lazySet(obj);
            return true;
        }
        if (z2 && this.y) {
            if (this.x != null) {
                cVar.clear();
                this.y.lazySet(obj);
                bVar.onError(this.x);
                return true;
            }
            if (z3) {
                this.y.lazySet(obj);
                if (this.x != null) {
                    bVar.onError(this.x);
                } else {
                    bVar.onComplete();
                }
                return true;
            }
        }
        return false;
    }

    @Override // i.b.q0.a
    void j0() {
        Object andSet = this.c.getAndSet(null);
        if (andSet != null) {
            andSet.run();
        }
    }

    @Override // i.b.q0.a
    void k0() {
        int andGet = 1;
        m.c.b bVar;
        if (this.B.getAndIncrement() != 0) {
            return;
        }
        andGet = 1;
        Object obj = this.y.get();
        while (this.y != null) {
            if (this.B.addAndGet(-andGet) == 0) {
                return;
            }
        }
        if (this.D) {
            l0(bVar);
        } else {
            m0(bVar);
        }
    }

    @Override // i.b.q0.a
    void l0(m.c.b<? super T> bVar) {
        int andGet = 1;
        Throwable th;
        andGet = 1;
        Object obj = null;
        while (this.z) {
            bVar.onNext(obj);
            if (this.B.addAndGet(-andGet) == 0) {
                return;
            }
            obj = null;
        }
        this.y.lazySet(obj);
    }

    @Override // i.b.q0.a
    void m0(m.c.b<? super T> bVar) {
        AtomicLong atomicLong;
        int i;
        boolean z2;
        boolean empty;
        int i2 = 0;
        m.c.b bVar2;
        int andGet = 1;
        int cmp2;
        final Object bVar3 = this;
        andGet = 1;
        final int i5 = !bVar3.v;
        while (/* condition */) {
            while (l != i2) {
                Object poll = bVar3.b.poll();
            }
            bVar2 = bVar;
            i = -andGet;
            if (bVar3.B.addAndGet(i) == 0) {
                return;
            }
            poll = bVar3.b.poll();
        }
    }

    @Override // i.b.q0.a
    public void onComplete() {
    }

    @Override // i.b.q0.a
    public void onError(Throwable th) {
        b.e(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        a.t(th);
    }

    @Override // i.b.q0.a
    public void onNext(T t) {
        b.e(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
    }

    @Override // i.b.q0.a
    public void onSubscribe(m.c.c cVar) {
        boolean z;
        if (this.w || this.z) {
            cVar.cancel();
        }
    }

    c(int i, Runnable runnable, boolean z) {
        super();
        b.f(i, "capacityHint");
        this.b = new c(i);
        this.c = new AtomicReference(runnable);
        this.v = z;
        this.y = new AtomicReference();
        this.A = new AtomicBoolean();
        this.B = new c.a(this);
        this.C = new AtomicLong();
    }
}
