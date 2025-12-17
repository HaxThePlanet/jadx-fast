package com.google.android.gms.internal.measurement;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

/* loaded from: classes2.dex */
final class sa extends AbstractSet<Map.Entry> {

    final com.google.android.gms.internal.measurement.ta a;
    sa(com.google.android.gms.internal.measurement.ta ta, com.google.android.gms.internal.measurement.ma ma2) {
        this.a = ta;
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
        ra raVar = new ra(this.a, 0);
        return raVar;
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
