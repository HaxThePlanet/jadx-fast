package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class g9 extends com.google.android.gms.internal.measurement.l7<String> implements RandomAccess, com.google.android.gms.internal.measurement.h9 {

    private static final com.google.android.gms.internal.measurement.g9 c;
    private final List<Object> b;
    static {
        g9 g9Var = new g9(10);
        g9.c = g9Var;
        g9Var.zzb();
    }

    public g9() {
        super(10);
    }

    public g9(int i) {
        ArrayList arrayList = new ArrayList(i);
        super();
        this.b = arrayList;
    }

    private g9(ArrayList<Object> arrayList) {
        super();
        this.b = arrayList;
    }

    private static String g(Object object) {
        if (object instanceof String != null) {
            return (String)object;
        }
        if (object instanceof x7) {
            return (x7)object.v(d9.a);
        }
        return d9.h((byte[])object);
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final com.google.android.gms.internal.measurement.h9 a() {
        if (zzc()) {
            cb cbVar = new cb(this);
            return cbVar;
        }
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final void add(int i, Object object2) {
        b();
        this.b.add(i, (String)object2);
        this.modCount = obj2++;
    }

    public final boolean addAll(int i, Collection<? extends String> collection2) {
        Object obj3;
        b();
        if (collection2 instanceof h9) {
            obj3 = (h9)collection2.zzh();
        }
        this.modCount = obj3++;
        return this.b.addAll(i, obj3);
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final void clear() {
        b();
        this.b.clear();
        this.modCount = modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final String d(int i) {
        boolean z2;
        boolean z;
        Object obj = this.b.get(i);
        if (obj instanceof String != null) {
            return (String)obj;
        }
        String str = (x7)obj.v(d9.a);
        if (obj instanceof x7 && obj.p()) {
            str = (x7)obj.v(d9.a);
            if (obj.p()) {
                this.b.set(i, str);
            }
            return str;
        }
        String str2 = d9.h((byte[])obj);
        if (d9.i(obj)) {
            this.b.set(i, str2);
        }
        return str2;
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final com.google.android.gms.internal.measurement.c9 f(int i) {
        if (i < size()) {
        } else {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.b);
            g9 obj2 = new g9(arrayList);
            return obj2;
        }
        obj2 = new IllegalArgumentException();
        throw obj2;
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final Object get(int i) {
        return d(i);
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final Object j(int i) {
        return this.b.get(i);
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final void r(com.google.android.gms.internal.measurement.x7 x7) {
        b();
        this.b.add(x7);
        this.modCount = obj2++;
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final Object remove(int i) {
        b();
        this.modCount = modCount++;
        return g9.g(this.b.remove(i));
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final Object set(int i, Object object2) {
        b();
        return g9.g(this.b.set(i, (String)object2));
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final int size() {
        return this.b.size();
    }

    public final List<?> zzh() {
        return Collections.unmodifiableList(this.b);
    }
}
