package net.time4j;

import net.time4j.engine.p;
import net.time4j.engine.u;

/* compiled from: ElementOperator.java */
/* loaded from: classes3.dex */
public abstract class p<T> implements u<T> {

    private final p<?> a;
    private final int b;
    p(p<?> pVar, int i) {
        super();
        this.a = pVar;
        this.b = i;
    }

    int a() {
        return this.b;
    }
}
