package i.b.m0.d;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.c.e;
import i.b.m0.c.f;
import i.b.m0.c.j;
import i.b.y;

/* compiled from: BasicFuseableObserver.java */
/* loaded from: classes3.dex */
public abstract class a<T, R> implements y<T>, e<R> {

    protected final y<? super R> a;
    protected b b;
    protected e<T> c;
    protected boolean v;
    protected int w;
    public a(y<? super R> yVar) {
        super();
        this.a = yVar;
    }

    protected final void c(Throwable th) {
        a.b(th);
        this.b.dispose();
        onError(th);
    }

    public void clear() {
        this.c.clear();
    }

    protected final int d(int i) {
        if (this.c != null) {
            i2 = i & 4;
            if (i & 4 == 0 && requestFusion != 0) {
                this.w = requestFusion;
                return requestFusion;
            }
        }
        return 0;
    }

    public void dispose() {
        this.b.dispose();
    }

    public boolean isDisposed() {
        return this.b.isDisposed();
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

    public final void onSubscribe(b bVar) {
        if (c.validate(this.b, bVar)) {
            this.b = bVar;
            validate = bVar instanceof e;
            if (bVar instanceof e) {
                this.c = bVar;
            }
            if (b()) {
                this.a.onSubscribe(this);
                a();
            }
        }
    }

    protected void a() {
    }

    protected boolean b() {
        return true;
    }
}
