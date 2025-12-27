package i.b.m0.h;

import i.b.k;
import i.b.m0.c.f;
import i.b.m0.c.j;
import m.c.b;
import m.c.c;

/* compiled from: BasicFuseableSubscriber.java */
/* loaded from: classes3.dex */
public abstract class b<T, R> implements k<T>, i.b.m0.c.g<R> {

    protected final b<? super R> a;
    protected c b;
    protected i.b.m0.c.g<T> c;
    protected boolean v;
    protected int w;
    public b(b<? super R> bVar) {
        super();
        this.a = bVar;
    }

    public void cancel() {
        this.b.cancel();
    }

    public void clear() {
        this.c.clear();
    }

    protected final void d(Throwable th) {
        a.b(th);
        this.b.cancel();
        onError(th);
    }

    protected final int e(int i) {
        if (this.c != null) {
            i2 = i & 4;
            if (i & 4 == 0 && requestFusion != 0) {
                this.w = requestFusion;
                return requestFusion;
            }
        }
        return 0;
    }

    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public void onComplete() {
        if (this.v) {
            return;
        }
        this.v = true;
        this.a.onComplete();
    }

    public void onError(Throwable th) {
        if (this.v) {
            a.t(th);
            return;
        }
        this.v = true;
        this.a.onError(th);
    }

    public final void onSubscribe(c cVar) {
        if (g.validate(this.b, cVar)) {
            this.b = cVar;
            validate = cVar instanceof g;
            if (cVar instanceof g) {
                this.c = cVar;
            }
            if (b()) {
                this.a.onSubscribe(this);
                a();
            }
        }
    }

    public void request(long j) {
        this.b.request(j);
    }

    protected void a() {
    }

    protected boolean b() {
        return true;
    }
}
