package i.b.q0;

import i.b.h;
import i.b.k;
import i.b.m0.j.a;
import i.b.m0.j.n;
import i.b.p0.a;
import m.c.b;
import m.c.c;

/* loaded from: classes3.dex */
final class b<T>  extends i.b.q0.a<T> {

    final i.b.q0.a<T> b;
    boolean c;
    a<Object> v;
    volatile boolean w;
    b(i.b.q0.a<T> a) {
        super();
        this.b = a;
    }

    protected void c0(b<? super T> b) {
        this.b.a(b);
    }

    @Override // i.b.q0.a
    void h0() {
        a aVar = this.v;
        synchronized (this) {
            try {
                this.c = false;
                this.v = 0;
                aVar.b(this.b);
                throw th;
            }
        }
    }

    @Override // i.b.q0.a
    public void onComplete() {
        a aVar;
        boolean z;
        if (this.w) {
        }
        synchronized (this) {
        }
    }

    @Override // i.b.q0.a
    public void onError(Throwable throwable) {
        boolean z;
        a aVar;
        int i;
        if (this.w) {
            a.t(throwable);
        }
        i = 1;
        synchronized (this) {
            try {
                if (i != 0) {
                }
                a.t(throwable);
                this.b.onError(throwable);
                throw throwable;
            }
        }
    }

    public void onNext(T t) {
        a aVar;
        int i;
        if (this.w) {
        }
        synchronized (this) {
        }
    }

    @Override // i.b.q0.a
    public void onSubscribe(c c) {
        boolean z;
        a aVar;
        int i;
        if (!this.w) {
            synchronized (this) {
            }
        }
        if (i != 0) {
            c.cancel();
        } else {
            this.b.onSubscribe(c);
            h0();
        }
    }
}
