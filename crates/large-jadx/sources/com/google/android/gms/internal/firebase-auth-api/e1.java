package com.google.android.gms.internal.firebase-auth-api;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class e1 extends AbstractList<String> implements RandomAccess, com.google.android.gms.internal.firebase-auth-api.i {

    private final com.google.android.gms.internal.firebase-auth-api.i a;
    public e1(com.google.android.gms.internal.firebase-auth-api.i i) {
        super();
        this.a = i;
    }

    static com.google.android.gms.internal.firebase-auth-api.i b(com.google.android.gms.internal.firebase-auth-api.e1 e1) {
        return e1.a;
    }

    @Override // java.util.AbstractList
    public final com.google.android.gms.internal.firebase-auth-api.i a() {
        return this;
    }

    @Override // java.util.AbstractList
    public final Object get(int i) {
        return (h)this.a.d(i);
    }

    public final Iterator<String> iterator() {
        d1 d1Var = new d1(this);
        return d1Var;
    }

    @Override // java.util.AbstractList
    public final Object j(int i) {
        return this.a.j(i);
    }

    public final ListIterator<String> listIterator(int i) {
        c1 c1Var = new c1(this, i);
        return c1Var;
    }

    @Override // java.util.AbstractList
    public final int size() {
        return this.a.size();
    }

    @Override // java.util.AbstractList
    public final void x(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    public final List<?> zzh() {
        return this.a.zzh();
    }
}
