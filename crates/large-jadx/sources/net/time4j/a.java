package net.time4j;

import net.time4j.g1.d;

/* loaded from: classes3.dex */
abstract class a<V extends Comparable<V>>  extends d<V> implements net.time4j.c<V, net.time4j.g0> {
    a(String string) {
        super(string);
        j obj2 = new j(this, 0);
        obj2 = new j(this, 1);
    }

    public net.time4j.p<net.time4j.g0> k(V v) {
        j jVar = new j(this, 6, v);
        return jVar;
    }
}
