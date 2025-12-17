package i.b.t0;

import i.b.j0.b;
import i.b.m0.a.d;
import i.b.m0.b.b;
import i.b.m0.c.j;
import i.b.m0.d.b;
import i.b.m0.f.c;
import i.b.p0.a;
import i.b.r;
import i.b.y;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class e<T>  extends i.b.t0.d<T> {

    final b<T> A;
    boolean B;
    final c<T> a;
    final AtomicReference<y<? super T>> b;
    final AtomicReference<Runnable> c;
    final boolean v;
    volatile boolean w;
    volatile boolean x;
    Throwable y;
    final AtomicBoolean z;

    final class a extends b<T> {

        private static final long serialVersionUID = 7926949470189395511L;
        final i.b.t0.e this$0;
        a(i.b.t0.e e) {
            this.this$0 = e;
            super();
        }

        @Override // i.b.m0.d.b
        public void clear() {
            this$0.a.clear();
        }

        @Override // i.b.m0.d.b
        public void dispose() {
            boolean andIncrement;
            int i;
            this$02.w = true;
            this.this$0.g();
            i = 0;
            this$04.b.lazySet(i);
            this$06.b.lazySet(i);
            andIncrement = this.this$0;
            if (!this$0.w && this$05.A.getAndIncrement() == 0 && !andIncrement.B) {
                this$02.w = true;
                this.this$0.g();
                i = 0;
                this$04.b.lazySet(i);
                if (this$05.A.getAndIncrement() == 0) {
                    this$06.b.lazySet(i);
                    andIncrement = this.this$0;
                    if (!andIncrement.B) {
                        andIncrement.a.clear();
                    }
                }
            }
        }

        @Override // i.b.m0.d.b
        public boolean isDisposed() {
            return this$0.w;
        }

        @Override // i.b.m0.d.b
        public boolean isEmpty() {
            return this$0.a.isEmpty();
        }

        public T poll() {
            return this$0.a.poll();
        }

        @Override // i.b.m0.d.b
        public int requestFusion(int i) {
            final int i2 = 2;
            if (i &= i2 != 0) {
                obj3.B = true;
                return i2;
            }
            return 0;
        }
    }
    e(int i, Runnable runnable2, boolean z3) {
        super();
        b.f(i, "capacityHint");
        c cVar = new c(i);
        this.a = cVar;
        b.e(runnable2, "onTerminate");
        AtomicReference obj3 = new AtomicReference(runnable2);
        this.c = obj3;
        this.v = z3;
        obj3 = new AtomicReference();
        this.b = obj3;
        obj3 = new AtomicBoolean();
        this.z = obj3;
        obj3 = new e.a(this);
        this.A = obj3;
    }

    e(int i, boolean z2) {
        super();
        b.f(i, "capacityHint");
        c cVar = new c(i);
        this.a = cVar;
        AtomicReference obj3 = new AtomicReference();
        this.c = obj3;
        this.v = z2;
        obj3 = new AtomicReference();
        this.b = obj3;
        obj3 = new AtomicBoolean();
        this.z = obj3;
        obj3 = new e.a(this);
        this.A = obj3;
    }

    public static <T> i.b.t0.e<T> d() {
        e eVar = new e(r.bufferSize(), 1);
        return eVar;
    }

    public static <T> i.b.t0.e<T> e(int i) {
        e eVar = new e(i, 1);
        return eVar;
    }

    public static <T> i.b.t0.e<T> f(int i, Runnable runnable2) {
        e eVar = new e(i, runnable2, 1);
        return eVar;
    }

    @Override // i.b.t0.d
    void g() {
        boolean compareAndSet;
        int i;
        Object obj = this.c.get();
        if (obj != null && this.c.compareAndSet((Runnable)obj, 0)) {
            if (this.c.compareAndSet(obj, 0)) {
                obj.run();
            }
        }
    }

    @Override // i.b.t0.d
    void h() {
        Object obj;
        int andGet;
        if (this.A.getAndIncrement() != 0) {
        }
        obj = this.b.get();
        andGet = 1;
        while (obj != null) {
            obj = this.b.get();
        }
        if (this.B) {
            i(obj);
        } else {
            j(obj);
        }
    }

    void i(y<? super T> y) {
        int andGet;
        b bVar;
        int i;
        boolean z;
        i = 0;
        while (this.w) {
            boolean z4 = this.x;
            y.onNext(i);
            i = 0;
        }
        this.b.lazySet(i);
    }

    void j(y<? super T> y) {
        int i3;
        int andGet;
        boolean z;
        Object poll;
        int i;
        int i2;
        final c cVar = this.a;
        final int i6 = 1;
        andGet = i3;
        while (this.w) {
            poll = this.a.poll();
            i = 0;
            if (poll == null) {
            } else {
            }
            i2 = i;
            y.onNext(poll);
            i3 = i;
            i2 = i6;
        }
        this.b.lazySet(0);
        cVar.clear();
    }

    void k(y<? super T> y) {
        this.b.lazySet(0);
        Throwable th = this.y;
        if (th != null) {
            y.onError(th);
        } else {
            y.onComplete();
        }
    }

    boolean l(j<T> j, y<? super T> y2) {
        final Throwable th = this.y;
        if (th != null) {
            this.b.lazySet(0);
            j.clear();
            y2.onError(th);
            return 1;
        }
        return 0;
    }

    @Override // i.b.t0.d
    public void onComplete() {
        boolean z;
        if (!this.x) {
            if (this.w) {
            } else {
                this.x = true;
                g();
                h();
            }
        }
    }

    @Override // i.b.t0.d
    public void onError(Throwable throwable) {
        boolean z;
        b.e(throwable, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.x && this.w) {
            if (this.w) {
            }
            this.y = throwable;
            this.x = true;
            g();
            h();
        }
        a.t(throwable);
    }

    public void onNext(T t) {
        boolean z;
        b.e(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.x) {
            if (this.w) {
            } else {
                this.a.offer(t);
                h();
            }
        }
    }

    @Override // i.b.t0.d
    public void onSubscribe(b b) {
        boolean z;
        if (!this.x) {
            if (this.w) {
                b.dispose();
            }
        } else {
        }
    }

    protected void subscribeActual(y<? super T> y) {
        boolean compareAndSet;
        Object illegalStateException;
        int str;
        int i;
        Object obj4;
        if (!this.z.get() && this.z.compareAndSet(false, true)) {
            if (this.z.compareAndSet(false, true)) {
                y.onSubscribe(this.A);
                this.b.lazySet(y);
                if (this.w) {
                    this.b.lazySet(0);
                }
                h();
            } else {
                illegalStateException = new IllegalStateException("Only a single observer allowed.");
                d.error(illegalStateException, y);
            }
        } else {
        }
    }
}
