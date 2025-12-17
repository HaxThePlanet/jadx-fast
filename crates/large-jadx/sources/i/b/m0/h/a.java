package i.b.m0.h;

import i.b.k;
import i.b.m0.c.a;
import i.b.m0.c.f;
import i.b.m0.c.g;
import i.b.m0.c.j;
import i.b.m0.i.g;
import i.b.p0.a;
import io.reactivex.exceptions.a;
import m.c.b;
import m.c.c;

/* loaded from: classes3.dex */
public abstract class a<T, R>  implements a<T>, g<R> {

    protected final a<? super R> a;
    protected c b;
    protected g<T> c;
    protected boolean v;
    protected int w;
    public a(a<? super R> a) {
        super();
        this.a = a;
    }

    @Override // i.b.m0.c.a
    protected void a() {
    }

    @Override // i.b.m0.c.a
    protected boolean b() {
        return 1;
    }

    @Override // i.b.m0.c.a
    public void cancel() {
        this.b.cancel();
    }

    @Override // i.b.m0.c.a
    public void clear() {
        this.c.clear();
    }

    @Override // i.b.m0.c.a
    protected final void d(Throwable throwable) {
        a.b(throwable);
        this.b.cancel();
        onError(throwable);
    }

    @Override // i.b.m0.c.a
    protected final int e(int i) {
        int i2;
        final g gVar = this.c;
        int obj3 = gVar.requestFusion(i);
        if (gVar != null && i & 4 == 0 && obj3 != null) {
            if (i & 4 == 0) {
                obj3 = gVar.requestFusion(i);
                if (obj3 != null) {
                    this.w = obj3;
                }
                return obj3;
            }
        }
        return 0;
    }

    @Override // i.b.m0.c.a
    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    public final boolean offer(R r) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Should not be called!");
        throw obj2;
    }

    @Override // i.b.m0.c.a
    public void onComplete() {
        if (this.v) {
        }
        this.v = true;
        this.a.onComplete();
    }

    @Override // i.b.m0.c.a
    public void onError(Throwable throwable) {
        if (this.v) {
            a.t(throwable);
        }
        this.v = true;
        this.a.onError(throwable);
    }

    @Override // i.b.m0.c.a
    public final void onSubscribe(c c) {
        boolean validate;
        c obj2;
        this.b = c;
        if (g.validate(this.b, c) && c instanceof g) {
            this.b = c;
            if (c instanceof g) {
                this.c = (g)c;
            }
            if (b()) {
                this.a.onSubscribe(this);
                a();
            }
        }
    }

    @Override // i.b.m0.c.a
    public void request(long l) {
        this.b.request(l);
    }
}
