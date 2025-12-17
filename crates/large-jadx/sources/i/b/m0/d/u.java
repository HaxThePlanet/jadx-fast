package i.b.m0.d;

import i.b.j0.b;
import i.b.m0.c.i;
import i.b.m0.c.j;
import i.b.m0.j.o;
import i.b.m0.j.r;
import i.b.y;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public abstract class u<T, U, V>  extends i.b.m0.d.w implements y<T>, o<U, V> {

    protected final y<? super V> b;
    protected final i<U> c;
    protected volatile boolean v;
    protected volatile boolean w;
    protected Throwable x;
    public u(y<? super V> y, i<U> i2) {
        super();
        this.b = y;
        this.c = i2;
    }

    @Override // i.b.m0.d.w
    public final boolean a() {
        return this.v;
    }

    public void b(y<? super V> y, U u2) {
    }

    @Override // i.b.m0.d.w
    public final int c(int i) {
        return this.a.addAndGet(i);
    }

    @Override // i.b.m0.d.w
    public final boolean d() {
        int i;
        i = this.a.getAndIncrement() == 0 ? 1 : 0;
        return i;
    }

    @Override // i.b.m0.d.w
    public final boolean done() {
        return this.w;
    }

    @Override // i.b.m0.d.w
    public final boolean e() {
        int compareAndSet;
        int i;
        final int i2 = 0;
        if (this.a.get() == 0 && this.a.compareAndSet(i2, 1)) {
            if (this.a.compareAndSet(i2, i)) {
            } else {
                i = i2;
            }
        } else {
        }
        return i;
    }

    protected final void f(U u, boolean z2, b b3) {
        boolean compareAndSet;
        int i;
        int i2;
        int obj6;
        final y yVar = this.b;
        final i iVar = this.c;
        if (this.a.get() == 0 && this.a.compareAndSet(0, 1)) {
            if (this.a.compareAndSet(0, 1)) {
                b(yVar, u);
                if (c(-1) == 0) {
                }
            } else {
                iVar.offer(u);
                if (!d()) {
                }
            }
        } else {
        }
        r.c(iVar, yVar, z2, b3, this);
    }

    protected final void g(U u, boolean z2, b b3) {
        int compareAndSet;
        int i2;
        int i;
        boolean obj6;
        final y yVar = this.b;
        final i iVar = this.c;
        if (this.a.get() == 0 && this.a.compareAndSet(0, 1)) {
            if (this.a.compareAndSet(0, 1)) {
                if (iVar.isEmpty()) {
                    b(yVar, u);
                    if (c(-1) == 0) {
                    }
                } else {
                    iVar.offer(u);
                }
            } else {
                iVar.offer(u);
                if (!d()) {
                }
            }
        } else {
        }
        r.c(iVar, yVar, z2, b3, this);
    }

    @Override // i.b.m0.d.w
    public final Throwable l() {
        return this.x;
    }
}
