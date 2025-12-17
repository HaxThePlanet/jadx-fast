package com.google.android.gms.internal.firebase-auth-api;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

/* loaded from: classes2.dex */
final class u0 extends AbstractSet<Map.Entry> {

    final com.google.android.gms.internal.firebase-auth-api.v0 a;
    u0(com.google.android.gms.internal.firebase-auth-api.v0 v0, com.google.android.gms.internal.firebase-auth-api.o0 o02) {
        this.a = v0;
        super();
    }

    @Override // java.util.AbstractSet
    public final boolean add(Object object) {
        if (!contains((Map.Entry)object)) {
            this.a.f((Comparable)object.getKey(), object.getValue());
            return 1;
        }
        return 0;
    }

    @Override // java.util.AbstractSet
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractSet
    public final boolean contains(Object object) {
        int i;
        Object obj4;
        Object obj = this.a.get((Map.Entry)object.getKey());
        obj4 = object.getValue();
        if (obj != obj4) {
            if (obj != null && obj.equals(obj4)) {
                if (obj.equals(obj4)) {
                    i = i2;
                }
                return 0;
            }
        } else {
        }
        return i;
    }

    public final Iterator<Map.Entry> iterator() {
        t0 t0Var = new t0(this.a, 0);
        return t0Var;
    }

    @Override // java.util.AbstractSet
    public final boolean remove(Object object) {
        if (contains((Map.Entry)object)) {
            this.a.remove(object.getKey());
            return 1;
        }
        return 0;
    }

    @Override // java.util.AbstractSet
    public final int size() {
        return this.a.size();
    }
}
