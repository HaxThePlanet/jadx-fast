package i.b.q0;

import i.b.m0.b.b;
import i.b.m0.f.c;
import i.b.m0.i.a;
import i.b.m0.i.d;
import i.b.m0.i.g;
import i.b.m0.j.d;
import i.b.p0.a;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import m.c.b;
import m.c.c;

/* loaded from: classes3.dex */
public final class c<T>  extends i.b.q0.a<T> {

    final AtomicBoolean A;
    final a<T> B;
    final AtomicLong C;
    boolean D;
    final c<T> b;
    final AtomicReference<Runnable> c;
    final boolean v;
    volatile boolean w;
    Throwable x;
    final AtomicReference<b<? super T>> y;
    volatile boolean z;

    final class a extends a<T> {

        private static final long serialVersionUID = -4896760517184205454L;
        final i.b.q0.c this$0;
        a(i.b.q0.c c) {
            this.this$0 = c;
            super();
        }

        @Override // i.b.m0.i.a
        public void cancel() {
            int andIncrement;
            int i;
            if (this$0.z) {
            }
            this$02.z = true;
            this.this$0.j0();
            i = 0;
            this$04.y.lazySet(i);
            this$06.y.lazySet(i);
            andIncrement = this.this$0;
            if (this$05.B.getAndIncrement() == 0 && !andIncrement.D) {
                this$06.y.lazySet(i);
                andIncrement = this.this$0;
                if (!andIncrement.D) {
                    andIncrement.b.clear();
                }
            }
        }

        @Override // i.b.m0.i.a
        public void clear() {
            this$0.b.clear();
        }

        @Override // i.b.m0.i.a
        public boolean isEmpty() {
            return this$0.b.isEmpty();
        }

        public T poll() {
            return this$0.b.poll();
        }

        @Override // i.b.m0.i.a
        public void request(long l) {
            boolean validate;
            Object obj2;
            if (g.validate(l)) {
                d.a(this$0.C, l);
                this.this$0.k0();
            }
        }

        @Override // i.b.m0.i.a
        public int requestFusion(int i) {
            final int i2 = 2;
            if (i &= i2 != 0) {
                obj3.D = true;
                return i2;
            }
            return 0;
        }
    }
    c(int i) {
        super(i, 0, 1);
    }

    c(int i, Runnable runnable2, boolean z3) {
        super();
        b.f(i, "capacityHint");
        c cVar = new c(i);
        this.b = cVar;
        AtomicReference obj3 = new AtomicReference(runnable2);
        this.c = obj3;
        this.v = z3;
        obj3 = new AtomicReference();
        this.y = obj3;
        obj3 = new AtomicBoolean();
        this.A = obj3;
        obj3 = new c.a(this);
        this.B = obj3;
        obj3 = new AtomicLong();
        this.C = obj3;
    }

    public static <T> i.b.q0.c<T> i0(int i) {
        c cVar = new c(i);
        return cVar;
    }

    protected void c0(b<? super T> b) {
        boolean compareAndSet;
        java.lang.IllegalStateException illegalStateException;
        int str;
        int i;
        Object obj4;
        if (!this.A.get() && this.A.compareAndSet(false, true)) {
            if (this.A.compareAndSet(false, true)) {
                b.onSubscribe(this.B);
                this.y.set(b);
                if (this.z) {
                    this.y.lazySet(0);
                } else {
                    k0();
                }
            } else {
                illegalStateException = new IllegalStateException("This processor allows only a single Subscriber");
                d.error(illegalStateException, b);
            }
        } else {
        }
    }

    boolean h0(boolean z, boolean z2, boolean z3, b<? super T> b4, c<T> c5) {
        Throwable obj4;
        final int i = 1;
        final int i2 = 0;
        if (this.z) {
            c5.clear();
            this.y.lazySet(i2);
            return i;
        }
        if (z2 && z != null && this.x != null) {
            if (z != null) {
                if (this.x != null) {
                    c5.clear();
                    this.y.lazySet(i2);
                    b4.onError(this.x);
                    return i;
                }
            }
            if (z3) {
                obj4 = this.x;
                this.y.lazySet(i2);
                if (obj4 != null) {
                    b4.onError(obj4);
                } else {
                    b4.onComplete();
                }
                return i;
            }
        }
        return 0;
    }

    @Override // i.b.q0.a
    void j0() {
        Object andSet = this.c.getAndSet(0);
        if ((Runnable)andSet != null) {
            (Runnable)andSet.run();
        }
    }

    @Override // i.b.q0.a
    void k0() {
        int andGet;
        Object obj;
        if (this.B.getAndIncrement() != 0) {
        }
        andGet = 1;
        obj = this.y.get();
        while (obj != null) {
            obj = this.y.get();
        }
        if (this.D) {
            l0(obj);
        } else {
            m0(obj);
        }
    }

    void l0(b<? super T> b) {
        int andGet;
        a aVar;
        int i;
        Throwable th;
        i = 0;
        while (this.z) {
            boolean z3 = this.w;
            b.onNext(i);
            i = 0;
        }
        this.y.lazySet(i);
    }

    void m0(b<? super T> b) {
        boolean z;
        AtomicLong num;
        int cmp;
        int i4;
        boolean z2;
        int empty;
        int i3;
        c cVar;
        int i2;
        int andGet;
        long l;
        int i;
        int cmp2;
        int i5;
        final Object obj3 = this;
        final c cVar2 = obj3.b;
        final int i8 = z ^ 1;
        andGet = i2;
        while (/* condition */) {
            cmp2 = Long.compare(l, i3);
            while (cmp2 != 0) {
                Object poll = cVar2.poll();
                if (poll == null) {
                } else {
                }
                i5 = num;
                b.onNext(poll);
                i3 = num;
                i2 = 1;
                cmp2 = Long.compare(l, i3);
                i5 = i2;
            }
            i = i3;
            cVar = b;
            if (Long.compare(i, i7) != 0 && Long.compare(l, l2) != 0) {
            }
            i2 = 1;
            l = obj3.C.get();
            i3 = 0;
            if (Long.compare(l, l2) != 0) {
            }
            obj3.C.addAndGet(-i);
            poll = cVar2.poll();
            if (poll == null) {
            } else {
            }
            i5 = num;
            b.onNext(poll);
            i3 = num;
            i2 = 1;
            i5 = i2;
        }
    }

    @Override // i.b.q0.a
    public void onComplete() {
        boolean z;
        if (!this.w) {
            if (this.z) {
            } else {
                this.w = true;
                j0();
                k0();
            }
        }
    }

    @Override // i.b.q0.a
    public void onError(Throwable throwable) {
        boolean z;
        b.e(throwable, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.w && this.z) {
            if (this.z) {
            }
            this.x = throwable;
            this.w = true;
            j0();
            k0();
        }
        a.t(throwable);
    }

    public void onNext(T t) {
        boolean z;
        b.e(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.w) {
            if (this.z) {
            } else {
                this.b.offer(t);
                k0();
            }
        }
    }

    @Override // i.b.q0.a
    public void onSubscribe(c c) {
        long z;
        if (!this.w) {
            if (this.z) {
                c.cancel();
            } else {
                c.request(Long.MAX_VALUE);
            }
        } else {
        }
    }
}
