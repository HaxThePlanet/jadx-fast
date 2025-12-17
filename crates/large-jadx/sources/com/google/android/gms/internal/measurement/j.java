package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class j implements com.google.android.gms.internal.measurement.q, com.google.android.gms.internal.measurement.m {

    protected final String a;
    protected final Map<String, com.google.android.gms.internal.measurement.q> b;
    public j(String string) {
        super();
        HashMap hashMap = new HashMap();
        this.b = hashMap;
        this.a = string;
    }

    public abstract com.google.android.gms.internal.measurement.q a(com.google.android.gms.internal.measurement.b5 b5, List<com.google.android.gms.internal.measurement.q> list2);

    @Override // com.google.android.gms.internal.measurement.q
    public com.google.android.gms.internal.measurement.q b() {
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final String c() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final Boolean d() {
        return Boolean.TRUE;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final boolean equals(Object object) {
        if (this == object) {
            return 1;
        }
        final int i = 0;
        if (!object instanceof j) {
            return i;
        }
        String str = this.a;
        if (str != null) {
            return str.equals(object.a);
        }
        return i;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final boolean g(String string) {
        return this.b.containsKey(string);
    }

    public final Iterator<com.google.android.gms.internal.measurement.q> h() {
        return k.b(this.b);
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final int hashCode() {
        String str = this.a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final void i(String string, com.google.android.gms.internal.measurement.q q2) {
        if (q2 == null) {
            this.b.remove(string);
        }
        this.b.put(string, q2);
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final com.google.android.gms.internal.measurement.q l(String string) {
        if (this.b.containsKey(string)) {
            return (q)this.b.get(string);
        }
        return q.h;
    }

    public final com.google.android.gms.internal.measurement.q m(String string, com.google.android.gms.internal.measurement.b5 b52, List<com.google.android.gms.internal.measurement.q> list3) {
        if ("toString".equals(string)) {
            u obj2 = new u(this.a);
            return obj2;
        }
        u uVar = new u(string);
        return k.a(this, uVar, b52, list3);
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final Double zzh() {
        return Double.valueOf(9221120237041090560L);
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final String zzi() {
        return this.a;
    }
}
