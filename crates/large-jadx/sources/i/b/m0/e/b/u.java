package i.b.m0.e.b;

import i.b.m0.i.e;
import m.c.b;

/* compiled from: FlowableJust.java */
/* loaded from: classes3.dex */
public final class u<T> extends i.b.h<T> implements i.b.m0.c.h<T> {

    private final T b;
    public u(T t) {
        super();
        this.b = t;
    }

    @Override // i.b.h
    protected void c0(b<? super T> bVar) {
        bVar.onSubscribe(new e(bVar, this.b));
    }

    @Override // i.b.h
    public T call() {
        return this.b;
    }
}
