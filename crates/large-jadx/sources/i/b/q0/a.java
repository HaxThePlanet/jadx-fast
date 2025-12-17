package i.b.q0;

import i.b.h;
import i.b.k;
import m.c.a;
import m.c.b;

/* loaded from: classes3.dex */
public abstract class a<T>  extends h<T> implements b, a, k {
    public final i.b.q0.a<T> g0() {
        if (this instanceof b) {
            return this;
        }
        b bVar = new b(this);
        return bVar;
    }
}
