package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public class n implements com.google.android.gms.internal.measurement.q, com.google.android.gms.internal.measurement.m {

    final Map<String, com.google.android.gms.internal.measurement.q> a;
    public n() {
        super();
        HashMap hashMap = new HashMap();
        this.a = hashMap;
    }

    public final List<String> a() {
        ArrayList arrayList = new ArrayList(this.a.keySet());
        return arrayList;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final com.google.android.gms.internal.measurement.q b() {
        Object value;
        Map map;
        Object key;
        n nVar = new n();
        Iterator iterator = this.a.entrySet().iterator();
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            if (value3 instanceof m) {
            } else {
            }
            nVar.a.put((String)next2.getKey(), (q)next2.getValue().b());
            nVar.a.put((String)next2.getKey(), (q)next2.getValue());
        }
        return nVar;
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
        if (!object instanceof n) {
            return 0;
        }
        return this.a.equals(object.a);
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final boolean g(String string) {
        return this.a.containsKey(string);
    }

    public final Iterator<com.google.android.gms.internal.measurement.q> h() {
        return k.b(this.a);
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final void i(String string, com.google.android.gms.internal.measurement.q q2) {
        if (q2 == null) {
            this.a.remove(string);
        }
        this.a.put(string, q2);
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final com.google.android.gms.internal.measurement.q l(String string) {
        if (this.a.containsKey(string)) {
            return (q)this.a.get(string);
        }
        return q.h;
    }

    public com.google.android.gms.internal.measurement.q m(String string, com.google.android.gms.internal.measurement.b5 b52, List<com.google.android.gms.internal.measurement.q> list3) {
        if ("toString".equals(string)) {
            u obj2 = new u(toString());
            return obj2;
        }
        u uVar = new u(string);
        return k.a(this, uVar, b52, list3);
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final String toString() {
        boolean lastIndexOf;
        boolean format;
        Object[] arr;
        int i;
        Map map;
        StringBuilder stringBuilder = new StringBuilder("{");
        if (!this.a.isEmpty()) {
            Iterator iterator = this.a.keySet().iterator();
            for (String next : iterator) {
                arr = new Object[2];
                stringBuilder.append(String.format("%s: %s,", next, this.a.get(next)));
            }
            stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final Double zzh() {
        return Double.valueOf(9221120237041090560L);
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final String zzi() {
        return "[object Object]";
    }
}
