package i.b.u0;

import i.b.k;
import i.b.m0.i.g;
import i.b.m0.j.a;
import i.b.m0.j.n;
import i.b.p0.a;
import m.c.b;
import m.c.c;

/* loaded from: classes3.dex */
public final class a<T>  implements k<T>, c {

    final b<? super T> a;
    final boolean b;
    c c;
    boolean v;
    a<Object> w;
    volatile boolean x;
    public a(b<? super T> b) {
        super(b, 0);
    }

    public a(b<? super T> b, boolean z2) {
        super();
        this.a = b;
        this.b = z2;
    }

    @Override // i.b.k
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

    @Override // i.b.k
    public void cancel() {
        this.c.cancel();
    }

    @Override // i.b.k
    public void onComplete() {
        a aVar;
        int i;
        if (this.x) {
        }
        synchronized (this) {
        }
    }

    @Override // i.b.k
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
            this.c.cancel();
            NullPointerException obj3 = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            onError(obj3);
        }
        synchronized (this) {
        }
    }

    @Override // i.b.k
    public void onSubscribe(c c) {
        Object obj2;
        if (g.validate(this.c, c)) {
            this.c = c;
            this.a.onSubscribe(this);
        }
    }

    @Override // i.b.k
    public void request(long l) {
        this.c.request(l);
    }
}
