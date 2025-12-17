package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class c {

    private com.google.android.gms.internal.measurement.b a;
    private com.google.android.gms.internal.measurement.b b;
    private final List<com.google.android.gms.internal.measurement.b> c;
    public c() {
        super();
        final String str = "";
        final int i = 0;
        final int i2 = 0;
        b bVar = new b(str, i, obj3, i2);
        this.a = bVar;
        b bVar2 = new b(str, i, obj3, i2);
        this.b = bVar2;
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
    }

    public c(com.google.android.gms.internal.measurement.b b) {
        super();
        this.a = b;
        this.b = b.b();
        ArrayList obj1 = new ArrayList();
        this.c = obj1;
    }

    public final com.google.android.gms.internal.measurement.b a() {
        return this.a;
    }

    public final com.google.android.gms.internal.measurement.b b() {
        return this.b;
    }

    public final List<com.google.android.gms.internal.measurement.b> c() {
        return this.c;
    }

    public final Object clone() {
        com.google.android.gms.internal.measurement.b bVar;
        List list;
        c cVar = new c(this.a.b());
        Iterator iterator = this.c.iterator();
        for (b next2 : iterator) {
            cVar.c.add(next2.b());
        }
        return cVar;
    }

    public final void d(com.google.android.gms.internal.measurement.b b) {
        this.a = b;
        this.b = b.b();
        this.c.clear();
    }

    public final void e(String string, long l2, Map<String, Object> map3) {
        b bVar = new b(string, l2, map3, obj6);
        this.c.add(bVar);
    }

    public final void f(com.google.android.gms.internal.measurement.b b) {
        this.b = b;
    }
}
