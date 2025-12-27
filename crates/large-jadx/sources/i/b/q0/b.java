package i.b.q0;

import i.b.h;
import i.b.k;
import i.b.m0.j.n;
import m.c.b;
import m.c.c;

/* compiled from: SerializedProcessor.java */
/* loaded from: classes3.dex */
final class b<T> extends a<T> {

    final a<T> b;
    boolean c;
    i.b.m0.j.a<Object> v;
    volatile boolean w;
    b(a<T> aVar) {
        super();
        this.b = aVar;
    }

    @Override // i.b.q0.a
    protected void c0(b<? super T> bVar) {
        this.b.a(bVar);
    }

    @Override // i.b.q0.a
    void h0() {
        synchronized (this) {
            try {
                this.c = false;
                return;
            } catch (Throwable th) {
            }
        }
        this.v.b(this.b);
    }

    @Override // i.b.q0.a
    public void onComplete() {
        i.b.m0.j.a aVar;
        if (this.w) {
            return;
        }
        synchronized (this) {
            try {
                if (this.w) {
                    return;
                }
                if (this.v == null) {
                    this.v = new a(4);
                }
                aVar.c(n.complete());
                return;
            } catch (Throwable th) {
            }
        }
        this.b.onComplete();
    }

    @Override // i.b.q0.a
    public void onError(Throwable th) {
        i.b.m0.j.a aVar;
        int i = 1;
        if (this.w) {
            a.t(th);
            return;
        }
        synchronized (this) {
            try {
                boolean z = true;
                if (!this.w) {
                    this.w = z;
                    if (this.c && this.v == null) {
                        this.v = new a(4);
                        aVar.e(n.error(th));
                        return;
                    }
                    i = 0;
                    this.c = z;
                }
            } catch (Throwable th) {
            }
        }
        if (i != 0) {
            a.t(th);
            return;
        }
        this.b.onError(th);
    }

    @Override // i.b.q0.a
    public void onNext(T t) {
        i.b.m0.j.a aVar;
        if (this.w) {
            return;
        }
        synchronized (this) {
            try {
                if (this.w) {
                    return;
                }
                if (this.c && this.v == null) {
                    int i = 4;
                    this.v = new a(i);
                    aVar.c(n.next(t));
                    return;
                }
            } catch (Throwable th) {
            }
        }
        this.b.onNext(th);
        h0();
    }

    @Override // i.b.q0.a
    public void onSubscribe(c cVar) {
        boolean z = false;
        i.b.m0.j.a aVar;
        boolean z2 = true;
        z2 = true;
        if (!this.w) {
            synchronized (this) {
                try {
                    if (!this.w) {
                        if (this.c && this.v == null) {
                            int i2 = 4;
                            this.v = new a(i2);
                            aVar.c(n.subscription(cVar));
                            return;
                        }
                        this.c = true;
                    }
                } catch (Throwable th) {
                }
            }
        }
        if (z2) {
            th.cancel();
        } else {
            this.b.onSubscribe(th);
            h0();
        }
    }
}
