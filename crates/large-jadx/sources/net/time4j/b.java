package net.time4j;

import net.time4j.g1.d;

/* loaded from: classes3.dex */
abstract class b<V extends Comparable<V>>  extends d<V> implements net.time4j.c<V, net.time4j.h0> {
    b(String string) {
        super(string);
        r0 obj2 = new r0(this, 0);
        obj2 = new r0(this, 1);
    }

    public net.time4j.p<net.time4j.h0> k(V v) {
        r0 r0Var = new r0(this, 6, v);
        return r0Var;
    }
}
