package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class cb extends AbstractList<String> implements RandomAccess, com.google.android.gms.internal.measurement.h9 {

    private final com.google.android.gms.internal.measurement.h9 a;
    public cb(com.google.android.gms.internal.measurement.h9 h9) {
        super();
        this.a = h9;
    }

    static com.google.android.gms.internal.measurement.h9 b(com.google.android.gms.internal.measurement.cb cb) {
        return cb.a;
    }

    @Override // java.util.AbstractList
    public final com.google.android.gms.internal.measurement.h9 a() {
        return this;
    }

    @Override // java.util.AbstractList
    public final Object get(int i) {
        return (g9)this.a.d(i);
    }

    public final Iterator<String> iterator() {
        bb bbVar = new bb(this);
        return bbVar;
    }

    @Override // java.util.AbstractList
    public final Object j(int i) {
        return this.a.j(i);
    }

    public final ListIterator<String> listIterator(int i) {
        ab abVar = new ab(this, i);
        return abVar;
    }

    @Override // java.util.AbstractList
    public final void r(com.google.android.gms.internal.measurement.x7 x7) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    @Override // java.util.AbstractList
    public final int size() {
        return this.a.size();
    }

    public final List<?> zzh() {
        return this.a.zzh();
    }
}
