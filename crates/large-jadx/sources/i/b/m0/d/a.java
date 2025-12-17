package i.b.m0.d;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.c.e;
import i.b.m0.c.f;
import i.b.m0.c.j;
import i.b.p0.a;
import i.b.y;
import io.reactivex.exceptions.a;

/* loaded from: classes3.dex */
public abstract class a<T, R>  implements y<T>, e<R> {

    protected final y<? super R> a;
    protected b b;
    protected e<T> c;
    protected boolean v;
    protected int w;
    public a(y<? super R> y) {
        super();
        this.a = y;
    }

    @Override // i.b.y
    protected void a() {
    }

    @Override // i.b.y
    protected boolean b() {
        return 1;
    }

    @Override // i.b.y
    protected final void c(Throwable throwable) {
        a.b(throwable);
        this.b.dispose();
        onError(throwable);
    }

    @Override // i.b.y
    public void clear() {
        this.c.clear();
    }

    @Override // i.b.y
    protected final int d(int i) {
        int i2;
        final e eVar = this.c;
        int obj3 = eVar.requestFusion(i);
        if (eVar != null && i & 4 == 0 && obj3 != null) {
            if (i & 4 == 0) {
                obj3 = eVar.requestFusion(i);
                if (obj3 != null) {
                    this.w = obj3;
                }
                return obj3;
            }
        }
        return 0;
    }

    @Override // i.b.y
    public void dispose() {
        this.b.dispose();
    }

    @Override // i.b.y
    public boolean isDisposed() {
        return this.b.isDisposed();
    }

    @Override // i.b.y
    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    public final boolean offer(R r) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Should not be called!");
        throw obj2;
    }

    @Override // i.b.y
    public void onComplete() {
        if (this.v) {
        }
        this.v = true;
        this.a.onComplete();
    }

    @Override // i.b.y
    public void onError(Throwable throwable) {
        if (this.v) {
            a.t(throwable);
        }
        this.v = true;
        this.a.onError(throwable);
    }

    @Override // i.b.y
    public final void onSubscribe(b b) {
        boolean validate;
        b obj2;
        this.b = b;
        if (c.validate(this.b, b) && b instanceof e) {
            this.b = b;
            if (b instanceof e) {
                this.c = (e)b;
            }
            if (b()) {
                this.a.onSubscribe(this);
                a();
            }
        }
    }
}
