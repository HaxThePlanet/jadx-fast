package com.google.android.gms.internal.firebase-auth-api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class h extends com.google.android.gms.internal.firebase-auth-api.kq<String> implements RandomAccess, com.google.android.gms.internal.firebase-auth-api.i {

    private static final com.google.android.gms.internal.firebase-auth-api.h c;
    private final List<Object> b;
    static {
        h hVar = new h(10);
        h.c = hVar;
        hVar.zzb();
    }

    public h() {
        super(10);
    }

    public h(int i) {
        ArrayList arrayList = new ArrayList(i);
        super();
        this.b = arrayList;
    }

    private h(ArrayList<Object> arrayList) {
        super();
        this.b = arrayList;
    }

    private static String g(Object object) {
        if (object instanceof String != null) {
            return (String)object;
        }
        if (object instanceof wq) {
            return (wq)object.A(e.a);
        }
        return e.h((byte[])object);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final com.google.android.gms.internal.firebase-auth-api.i a() {
        if (zzc()) {
            e1 e1Var = new e1(this);
            return e1Var;
        }
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final void add(int i, Object object2) {
        b();
        this.b.add(i, (String)object2);
        this.modCount = obj2++;
    }

    public final boolean addAll(int i, Collection<? extends String> collection2) {
        Object obj3;
        b();
        if (collection2 instanceof i) {
            obj3 = (i)collection2.zzh();
        }
        this.modCount = obj3++;
        return this.b.addAll(i, obj3);
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final void clear() {
        b();
        this.b.clear();
        this.modCount = modCount++;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final String d(int i) {
        boolean z;
        boolean z2;
        Object obj = this.b.get(i);
        if (obj instanceof String != null) {
            return (String)obj;
        }
        String str = (wq)obj.A(e.a);
        if (obj instanceof wq && obj.s()) {
            str = (wq)obj.A(e.a);
            if (obj.s()) {
                this.b.set(i, str);
            }
            return str;
        }
        String str2 = e.h((byte[])obj);
        if (e.i(obj)) {
            this.b.set(i, str2);
        }
        return str2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final com.google.android.gms.internal.firebase-auth-api.d f(int i) {
        if (i < size()) {
        } else {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.b);
            h obj2 = new h(arrayList);
            return obj2;
        }
        obj2 = new IllegalArgumentException();
        throw obj2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final Object get(int i) {
        return d(i);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final Object j(int i) {
        return this.b.get(i);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final Object remove(int i) {
        b();
        this.modCount = modCount++;
        return h.g(this.b.remove(i));
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final Object set(int i, Object object2) {
        b();
        return h.g(this.b.set(i, (String)object2));
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final int size() {
        return this.b.size();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final void x(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        b();
        this.b.add(wq);
        this.modCount = obj2++;
    }

    public final List<?> zzh() {
        return Collections.unmodifiableList(this.b);
    }
}
