package i.b.q0;

import i.b.h;
import i.b.k;
import m.c.a;
import m.c.b;

/* compiled from: FlowableProcessor.java */
/* loaded from: classes3.dex */
public abstract class a<T> extends h<T> implements b, a, k {
    @Override // i.b.h
    public final a<T> g0() {
        if (this instanceof b) {
            return this;
        }
        return new b(this);
    }
}
