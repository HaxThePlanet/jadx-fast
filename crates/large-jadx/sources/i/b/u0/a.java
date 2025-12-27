package i.b.u0;

import i.b.k;
import i.b.m0.i.g;
import i.b.m0.j.n;
import m.c.b;
import m.c.c;

/* compiled from: SerializedSubscriber.java */
/* loaded from: classes3.dex */
public final class a<T> implements k<T>, c {

    final b<? super T> a;
    final boolean b;
    c c;
    boolean v;
    i.b.m0.j.a<Object> w;
    volatile boolean x;
    public a(b<? super T> bVar) {
        this(bVar, false);
    }

    void a() {
        synchronized (this) {
            try {
                this.v = false;
                return;
            } catch (Throwable th) {
            }
        }
        if (this.w.b(this.a)) {
            return;
        }
    }

    public void cancel() {
        this.c.cancel();
    }

    public void onComplete() {
        i.b.m0.j.a aVar;
        if (this.x) {
            return;
        }
        synchronized (this) {
            try {
                if (this.x) {
                    return;
                }
                if (this.v && this.w == null) {
                    int i = 4;
                    this.w = new a(i);
                    aVar.c(n.complete());
                    return;
                }
            } catch (Throwable th) {
            }
        }
        this.a.onComplete();
    }

    public void onError(Throwable th) {
        i.b.m0.j.a aVar;
        boolean z2 = true;
        if (this.x) {
            a.t(th);
            return;
        }
        synchronized (this) {
            try {
                z2 = true;
                if (!this.x) {
                    if (this.v) {
                        this.x = z2;
                        if (this.w == null) {
                            this.w = new a(4);
                        }
                        final Object error = n.error(th);
                        if (this.b) {
                            aVar.c(error);
                        } else {
                            aVar.e(error);
                        }
                        return;
                    }
                    this.x = z2;
                    this.v = z2;
                    int i2 = 0;
                }
            } catch (Throwable th) {
            }
        }
        if (this.b) {
            a.t(th);
            return;
        }
        this.a.onError(th);
    }

    public void onNext(T t) {
        i.b.m0.j.a aVar;
        if (this.x) {
            return;
        }
        if (t == null) {
            this.c.cancel();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            try {
                if (this.x) {
                    return;
                }
                if (this.v && this.w == null) {
                    int i = 4;
                    this.w = new a(i);
                    aVar.c(n.next(t));
                    return;
                }
            } catch (Throwable th) {
            }
        }
        this.a.onNext(th);
        a();
    }

    public void onSubscribe(c cVar) {
        if (g.validate(this.c, cVar)) {
            this.c = cVar;
            this.a.onSubscribe(this);
        }
    }

    public void request(long j) {
        this.c.request(j);
    }

    public a(b<? super T> bVar, boolean z) {
        super();
        this.a = bVar;
        this.b = z;
    }
}
