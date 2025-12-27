package i.b.n0;

import i.b.j0.b;
import i.b.l0.f;
import i.b.m0.e.e.g2;
import i.b.m0.e.e.h2;
import i.b.m0.e.e.o2;
import i.b.p0.a;
import i.b.r;

/* compiled from: ConnectableObservable.java */
/* loaded from: classes3.dex */
public abstract class a<T> extends r<T> {
    private a<T> d() {
        if (this instanceof h2) {
            return a.q(new g2((h2)this.b()));
        }
        return this;
    }

    @Override // i.b.r
    public r<T> e() {
        return a.n(new o2(d()));
    }

    @Override // i.b.r
    public abstract void c(f<? super b> fVar);
}
