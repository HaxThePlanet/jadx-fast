package androidx.room;

import d.s.a.k;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public abstract class b1 {

    private final AtomicBoolean a;
    private final androidx.room.u0 b;
    private volatile k c;
    public b1(androidx.room.u0 u0) {
        super();
        AtomicBoolean atomicBoolean = new AtomicBoolean(0);
        this.a = atomicBoolean;
        this.b = u0;
    }

    private k c() {
        return this.b.d(d());
    }

    private k e(boolean z) {
        k obj1;
        if (z) {
            if (this.c == null) {
                this.c = c();
            }
            obj1 = this.c;
        } else {
            obj1 = c();
        }
        return obj1;
    }

    public k a() {
        b();
        return e(this.a.compareAndSet(false, true));
    }

    protected void b() {
        this.b.a();
    }

    protected abstract String d();

    public void f(k k) {
        k kVar;
        Object obj2;
        if (k == this.c) {
            this.a.set(false);
        }
    }
}
