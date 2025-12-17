package net.time4j;

import net.time4j.engine.p;
import net.time4j.engine.u;

/* loaded from: classes3.dex */
public abstract class p<T>  implements u<T> {

    private final p<?> a;
    private final int b;
    p(p<?> p, int i2) {
        super();
        this.a = p;
        this.b = i2;
    }

    @Override // net.time4j.engine.u
    int a() {
        return this.b;
    }
}
