package net.time4j;

import net.time4j.g1.d;

/* compiled from: AbstractTimeElement.java */
/* loaded from: classes3.dex */
abstract class b<V extends Comparable<V>> extends d<V> implements c<V, h0> {
    b(String str) {
        super(str);
        net.time4j.r0 r0Var = new r0(this, 0);
        net.time4j.r0 r0Var2 = new r0(this, 1);
    }

    @Override // net.time4j.g1.d
    public p<h0> k(V v) {
        return new r0(this, 6, v);
    }
}
