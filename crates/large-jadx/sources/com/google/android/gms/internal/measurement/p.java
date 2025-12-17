package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class p extends com.google.android.gms.internal.measurement.j implements com.google.android.gms.internal.measurement.m {

    protected final List<String> c;
    protected final List<com.google.android.gms.internal.measurement.q> v;
    protected com.google.android.gms.internal.measurement.b5 w;
    private p(com.google.android.gms.internal.measurement.p p) {
        super(p.a);
        ArrayList arrayList = new ArrayList(p.c.size());
        this.c = arrayList;
        arrayList.addAll(p.c);
        ArrayList arrayList2 = new ArrayList(p.v.size());
        this.v = arrayList2;
        arrayList2.addAll(p.v);
        this.w = p.w;
    }

    public p(String string, List<com.google.android.gms.internal.measurement.q> list2, List<com.google.android.gms.internal.measurement.q> list3, com.google.android.gms.internal.measurement.b5 b54) {
        boolean obj1;
        String obj2;
        com.google.android.gms.internal.measurement.b5 obj4;
        super(string);
        obj1 = new ArrayList();
        this.c = obj1;
        this.w = b54;
        if (!list2.isEmpty()) {
            obj1 = list2.iterator();
            for (q obj2 : obj1) {
                this.c.add(obj2.zzi());
            }
        }
        obj1 = new ArrayList(list3);
        this.v = obj1;
    }

    public final com.google.android.gms.internal.measurement.q a(com.google.android.gms.internal.measurement.b5 b5, List<com.google.android.gms.internal.measurement.q> list2) {
        int i;
        Object obj;
        int size;
        com.google.android.gms.internal.measurement.q qVar;
        boolean obj6;
        com.google.android.gms.internal.measurement.b5 b5Var2 = this.w.a();
        i = 0;
        while (i < this.c.size()) {
            if (i < list2.size()) {
            } else {
            }
            b5Var2.e((String)this.c.get(i), q.h);
            i++;
            b5Var2.e((String)this.c.get(i), b5.b((q)list2.get(i)));
        }
        Iterator obj5 = this.v.iterator();
        while (obj5.hasNext()) {
            obj6 = obj5.next();
            if (i instanceof r != 0) {
            }
            i = b5Var2.b(obj6);
        }
        return q.h;
    }

    @Override // com.google.android.gms.internal.measurement.j
    public final com.google.android.gms.internal.measurement.q b() {
        p pVar = new p(this);
        return pVar;
    }
}
