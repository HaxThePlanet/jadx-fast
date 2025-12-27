package i.b.t0;

import i.b.j0.b;
import i.b.m0.j.a.a;
import i.b.m0.j.n;
import i.b.r;
import i.b.y;

/* compiled from: SerializedSubject.java */
/* loaded from: classes3.dex */
final class c<T> extends d<T> implements a.a<Object> {

    final d<T> a;
    boolean b;
    i.b.m0.j.a<Object> c;
    volatile boolean v;
    c(d<T> dVar) {
        super();
        this.a = dVar;
    }

    @Override // i.b.t0.d
    void d() {
        synchronized (this) {
            try {
                this.b = false;
                return;
            } catch (Throwable th) {
            }
        }
        this.c.d(this);
    }

    @Override // i.b.t0.d
    public void onComplete() {
        i.b.m0.j.a aVar;
        if (this.v) {
            return;
        }
        synchronized (this) {
            try {
                if (this.v) {
                    return;
                }
                if (this.c == null) {
                    this.c = new a(4);
                }
                aVar.c(n.complete());
                return;
            } catch (Throwable th) {
            }
        }
        this.a.onComplete();
    }

    @Override // i.b.t0.d
    public void onError(Throwable th) {
        i.b.m0.j.a aVar;
        int i = 1;
        if (this.v) {
            a.t(th);
            return;
        }
        synchronized (this) {
            try {
                boolean z = true;
                if (!this.v) {
                    this.v = z;
                    if (this.b && this.c == null) {
                        this.c = new a(4);
                        aVar.e(n.error(th));
                        return;
                    }
                    i = 0;
                    this.b = z;
                }
            } catch (Throwable th) {
            }
        }
        if (i != 0) {
            a.t(th);
            return;
        }
        this.a.onError(th);
    }

    @Override // i.b.t0.d
    public void onNext(T t) {
        i.b.m0.j.a aVar;
        if (this.v) {
            return;
        }
        synchronized (this) {
            try {
                if (this.v) {
                    return;
                }
                if (this.b && this.c == null) {
                    int i = 4;
                    this.c = new a(i);
                    aVar.c(n.next(t));
                    return;
                }
            } catch (Throwable th) {
            }
        }
        this.a.onNext(th);
        d();
    }

    @Override // i.b.t0.d
    public void onSubscribe(b bVar) {
        boolean z = false;
        i.b.m0.j.a aVar;
        boolean z2 = true;
        z2 = true;
        if (!this.v) {
            synchronized (this) {
                try {
                    if (!this.v) {
                        if (this.b && this.c == null) {
                            int i2 = 4;
                            this.c = new a(i2);
                            aVar.c(n.disposable(bVar));
                            return;
                        }
                        this.b = true;
                    }
                } catch (Throwable th) {
                }
            }
        }
        if (z2) {
            th.dispose();
        } else {
            this.a.onSubscribe(th);
            d();
        }
    }

    @Override // i.b.t0.d
    protected void subscribeActual(y<? super T> yVar) {
        this.a.subscribe(yVar);
    }

    @Override // i.b.t0.d
    public boolean test(Object object) {
        return n.acceptFull(object, this.a);
    }
}
