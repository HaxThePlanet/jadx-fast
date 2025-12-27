package com.bumptech.glide.t;

import d.e.a;
import d.e.g;

/* compiled from: CachedHashCodeArrayMap.java */
/* loaded from: classes.dex */
public final class b<K, V> extends a<K, V> {

    private int A;
    @Override // d.e.a
    public void clear() {
        this.A = 0;
        super.clear();
    }

    @Override // d.e.a
    public int hashCode() {
        if (this.A == 0) {
            this.A = super.hashCode();
        }
        return this.A;
    }

    @Override // d.e.a
    public void k(g<? extends K, ? extends V> gVar) {
        this.A = 0;
        super.k(gVar);
    }

    @Override // d.e.a
    public V l(int i) {
        this.A = 0;
        return super.l(i);
    }

    @Override // d.e.a
    public V m(int i, V v) {
        this.A = 0;
        return super.m(i, v);
    }

    @Override // d.e.a
    public V put(K k, V v) {
        this.A = 0;
        return super.put(k, v);
    }
}
