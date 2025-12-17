package com.bumptech.glide.t;

import d.e.a;
import d.e.g;

/* loaded from: classes.dex */
public final class b<K, V>  extends a<K, V> {

    private int A;
    @Override // d.e.a
    public void clear() {
        this.A = 0;
        super.clear();
    }

    @Override // d.e.a
    public int hashCode() {
        int i;
        if (this.A == 0) {
            this.A = super.hashCode();
        }
        return this.A;
    }

    public void k(g<? extends K, ? extends V> g) {
        this.A = 0;
        super.k(g);
    }

    public V l(int i) {
        this.A = 0;
        return super.l(i);
    }

    public V m(int i, V v2) {
        this.A = 0;
        return super.m(i, v2);
    }

    public V put(K k, V v2) {
        this.A = 0;
        return super.put(k, v2);
    }
}
