package i.b.o0;

import i.b.d;
import i.b.d0;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.c.e;
import i.b.m0.c.f;
import i.b.m0.c.j;
import i.b.n;
import i.b.y;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public class f<T>  extends i.b.o0.a<T, i.b.o0.f<T>> implements y<T>, b, n<T>, d0<T>, d {

    private final AtomicReference<b> A;
    private e<T> B;
    private final y<? super T> z;

    static enum a implements y<Object> {

        INSTANCE;
        @Override // java.lang.Enum
        public void onComplete() {
        }

        @Override // java.lang.Enum
        public void onError(Throwable throwable) {
        }

        @Override // java.lang.Enum
        public void onNext(Object object) {
        }

        @Override // java.lang.Enum
        public void onSubscribe(b b) {
        }
    }
    public f() {
        super(f.a.INSTANCE);
    }

    public f(y<? super T> y) {
        super();
        AtomicReference atomicReference = new AtomicReference();
        this.A = atomicReference;
        this.z = y;
    }

    @Override // i.b.o0.a
    public final void a() {
        dispose();
    }

    @Override // i.b.o0.a
    public final void dispose() {
        c.dispose(this.A);
    }

    @Override // i.b.o0.a
    public final boolean isDisposed() {
        return c.isDisposed((b)this.A.get());
    }

    @Override // i.b.o0.a
    public void onComplete() {
        boolean z;
        Object illegalStateException;
        String str;
        this.w = true;
        if (!this.w && this.A.get() == null) {
            this.w = true;
            if (this.A.get() == null) {
                illegalStateException = new IllegalStateException("onSubscribe not called in proper order");
                this.c.add(illegalStateException);
            }
        }
        Thread.currentThread();
        this.v = l += i3;
        this.z.onComplete();
        this.a.countDown();
    }

    @Override // i.b.o0.a
    public void onError(Throwable throwable) {
        boolean z;
        List list;
        java.lang.IllegalStateException nullPointerException;
        String str;
        this.w = true;
        if (!this.w && this.A.get() == null) {
            this.w = true;
            if (this.A.get() == null) {
                nullPointerException = new IllegalStateException("onSubscribe not called in proper order");
                this.c.add(nullPointerException);
            }
        }
        Thread.currentThread();
        if (throwable == null) {
            nullPointerException = new NullPointerException("onError received a null Throwable");
            this.c.add(nullPointerException);
        } else {
            this.c.add(throwable);
        }
        this.z.onError(throwable);
        this.a.countDown();
    }

    public void onNext(T t) {
        boolean z;
        List list;
        int i;
        java.lang.IllegalStateException illegalStateException;
        int nullPointerException;
        String str;
        Object obj4;
        this.w = true;
        if (!this.w && this.A.get() == null) {
            this.w = true;
            if (this.A.get() == null) {
                illegalStateException = new IllegalStateException("onSubscribe not called in proper order");
                this.c.add(illegalStateException);
            }
        }
        Thread.currentThread();
        if (this.y == 2) {
        }
        this.b.add(t);
        if (t == null) {
            nullPointerException = new NullPointerException("onNext received a null value");
            this.c.add(nullPointerException);
        }
        this.z.onNext(t);
    }

    @Override // i.b.o0.a
    public void onSubscribe(b b) {
        Object obj;
        int requestFusion;
        c dISPOSED;
        Object illegalStateException;
        int i;
        StringBuilder stringBuilder;
        String str;
        Object obj5;
        Thread.currentThread();
        if (b == null) {
            NullPointerException nullPointerException = new NullPointerException("onSubscribe received a null Subscription");
            this.c.add(nullPointerException);
        }
        b.dispose();
        if (!this.A.compareAndSet(0, b) && this.A.get() != c.DISPOSED) {
            b.dispose();
            if (this.A.get() != c.DISPOSED) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("onSubscribe received multiple subscriptions: ");
                stringBuilder.append(b);
                illegalStateException = new IllegalStateException(stringBuilder.toString());
                this.c.add(illegalStateException);
            }
        }
        requestFusion = this.x;
        Object obj2 = b;
        this.B = (e)obj2;
        requestFusion = obj2.requestFusion(requestFusion);
        this.y = requestFusion;
        i = 1;
        if (requestFusion != 0 && b instanceof e && requestFusion == i) {
            if (b instanceof e) {
                obj2 = b;
                this.B = (e)obj2;
                requestFusion = obj2.requestFusion(requestFusion);
                this.y = requestFusion;
                i = 1;
                if (requestFusion == i) {
                    this.w = i;
                    Thread.currentThread();
                    obj5 = this.B.poll();
                    while (obj5 != null) {
                        this.b.add(obj5);
                        obj5 = this.B.poll();
                    }
                    this.v = l += i3;
                    this.A.lazySet(c.DISPOSED);
                }
            }
        }
        this.z.onSubscribe(b);
    }

    public void onSuccess(T t) {
        onNext(t);
        onComplete();
    }
}
