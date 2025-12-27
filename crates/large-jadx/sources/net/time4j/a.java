package net.time4j;

import net.time4j.g1.d;

/* compiled from: AbstractDateElement.java */
/* loaded from: classes3.dex */
abstract class a<V extends Comparable<V>> extends d<V> implements c<V, g0> {
    a(String str) {
        super(str);
        net.time4j.j jVar = new j(this, 0);
        net.time4j.j jVar2 = new j(this, 1);
    }

    @Override // net.time4j.g1.d
    public p<g0> k(V v) {
        return new j(this, 6, v);
    }
}
