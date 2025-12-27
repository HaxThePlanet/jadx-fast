package i.b.m0.d;

import i.b.j0.b;
import i.b.m0.c.i;
import i.b.m0.c.j;
import i.b.m0.j.o;
import i.b.m0.j.r;
import i.b.y;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: QueueDrainObserver.java */
/* loaded from: classes3.dex */
public abstract class u<T, U, V> extends w implements y<T>, o<U, V> {

    protected final y<? super V> b;
    protected final i<U> c;
    protected volatile boolean v;
    protected volatile boolean w;
    protected Throwable x;
    public u(y<? super V> yVar, i<U> iVar) {
        super();
        this.b = yVar;
        this.c = iVar;
    }

    @Override // i.b.m0.d.w
    public final boolean a() {
        return this.v;
    }

    @Override // i.b.m0.d.w
    public final int c(int i) {
        return this.a.addAndGet(i);
    }

    @Override // i.b.m0.d.w
    public final boolean d() {
        boolean z = true;
        int r0 = this.a.getAndIncrement() == 0 ? 1 : 0;
        return (this.a.getAndIncrement() == 0 ? 1 : 0);
    }

    @Override // i.b.m0.d.w
    public final boolean done() {
        return this.w;
    }

    @Override // i.b.m0.d.w
    public final boolean e() {
        int i;
        boolean z = true;
        final int i2 = 0;
        if (this.a.get() == 0) {
            if (!(this.a.compareAndSet(i2, 1))) {
            }
        }
        return z;
    }

    @Override // i.b.m0.d.w
    protected final void f(U u, boolean z, b bVar) {
        int i;
        int i2 = 0;
        int i3 = 1;
        if (this.a.get() == 0) {
            i2 = 0;
            i3 = 1;
            if (this.a.compareAndSet(i2, i3)) {
                b(this.b, u);
                if (c(-1) == 0) {
                    return;
                }
            } else {
                this.c.offer(u);
                if (!d()) {
                    return;
                }
            }
        }
        r.c(this.c, this.b, z, bVar, this);
    }

    @Override // i.b.m0.d.w
    protected final void g(U u, boolean z, b bVar) {
        int i;
        int i2 = 0;
        int i3 = 1;
        if (this.a.get() == 0) {
            i2 = 0;
            i3 = 1;
            if (this.a.compareAndSet(i2, i3)) {
                if (this.c.isEmpty()) {
                    b(this.b, u);
                    if (c(-1) == 0) {
                        return;
                    }
                } else {
                    this.c.offer(u);
                }
            } else {
                this.c.offer(u);
                if (!d()) {
                    return;
                }
            }
        }
        r.c(this.c, this.b, z, bVar, this);
    }

    @Override // i.b.m0.d.w
    public final Throwable l() {
        return this.x;
    }

    @Override // i.b.m0.d.w
    public void b(y<? super V> yVar, U u) {
    }
}
