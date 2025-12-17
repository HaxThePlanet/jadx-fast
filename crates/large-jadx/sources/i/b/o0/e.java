package i.b.o0;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.j.a;
import i.b.m0.j.n;
import i.b.p0.a;
import i.b.y;

/* loaded from: classes3.dex */
public final class e<T>  implements y<T>, b {

    final y<? super T> a;
    final boolean b;
    b c;
    boolean v;
    a<Object> w;
    volatile boolean x;
    public e(y<? super T> y) {
        super(y, 0);
    }

    public e(y<? super T> y, boolean z2) {
        super();
        this.a = y;
        this.b = z2;
    }

    @Override // i.b.y
    void a() {
        a aVar = this.w;
        synchronized (this) {
            try {
                this.v = false;
                this.w = 0;
                throw th;
            }
        }
    }

    @Override // i.b.y
    public void dispose() {
        this.c.dispose();
    }

    @Override // i.b.y
    public boolean isDisposed() {
        return this.c.isDisposed();
    }

    @Override // i.b.y
    public void onComplete() {
        a aVar;
        int i;
        if (this.x) {
        }
        synchronized (this) {
        }
    }

    @Override // i.b.y
    public void onError(Throwable throwable) {
        boolean z;
        a aVar;
        int i;
        if (this.x) {
            a.t(throwable);
        }
        i = 1;
        synchronized (this) {
            if (i != 0) {
            }
            this.a.onError(throwable);
        }
        a.t(throwable);
    }

    public void onNext(T t) {
        a aVar;
        int i;
        if (this.x) {
        }
        if (t == null) {
            this.c.dispose();
            NullPointerException obj3 = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            onError(obj3);
        }
        synchronized (this) {
        }
    }

    @Override // i.b.y
    public void onSubscribe(b b) {
        Object obj2;
        if (c.validate(this.c, b)) {
            this.c = b;
            this.a.onSubscribe(this);
        }
    }
}
