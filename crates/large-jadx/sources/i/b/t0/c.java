package i.b.t0;

import i.b.j0.b;
import i.b.m0.j.a;
import i.b.m0.j.a.a;
import i.b.m0.j.n;
import i.b.p0.a;
import i.b.r;
import i.b.y;

/* loaded from: classes3.dex */
final class c<T>  extends i.b.t0.d<T> implements a.a<Object> {

    final i.b.t0.d<T> a;
    boolean b;
    a<Object> c;
    volatile boolean v;
    c(i.b.t0.d<T> d) {
        super();
        this.a = d;
    }

    @Override // i.b.t0.d
    void d() {
        a aVar = this.c;
        synchronized (this) {
            try {
                this.b = false;
                this.c = 0;
                aVar.d(this);
                throw th;
            }
        }
    }

    @Override // i.b.t0.d
    public void onComplete() {
        a aVar;
        boolean z;
        if (this.v) {
        }
        synchronized (this) {
        }
    }

    @Override // i.b.t0.d
    public void onError(Throwable throwable) {
        boolean z;
        a aVar;
        int i;
        if (this.v) {
            a.t(throwable);
        }
        i = 1;
        synchronized (this) {
            try {
                if (i != 0) {
                }
                a.t(throwable);
                this.a.onError(throwable);
                throw throwable;
            }
        }
    }

    public void onNext(T t) {
        a aVar;
        int i;
        if (this.v) {
        }
        synchronized (this) {
        }
    }

    @Override // i.b.t0.d
    public void onSubscribe(b b) {
        boolean z;
        a aVar;
        int i;
        if (!this.v) {
            synchronized (this) {
            }
        }
        if (i != 0) {
            b.dispose();
        } else {
            this.a.onSubscribe(b);
            d();
        }
    }

    protected void subscribeActual(y<? super T> y) {
        this.a.subscribe(y);
    }

    @Override // i.b.t0.d
    public boolean test(Object object) {
        return n.acceptFull(object, this.a);
    }
}
