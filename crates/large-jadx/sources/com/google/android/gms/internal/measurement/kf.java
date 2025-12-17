package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public final class kf {

    final TreeMap<Integer, com.google.android.gms.internal.measurement.p> a;
    final TreeMap<Integer, com.google.android.gms.internal.measurement.p> b;
    public kf() {
        super();
        TreeMap treeMap = new TreeMap();
        this.a = treeMap;
        TreeMap treeMap2 = new TreeMap();
        this.b = treeMap2;
    }

    private static final int c(com.google.android.gms.internal.measurement.b5 b5, com.google.android.gms.internal.measurement.p p2, com.google.android.gms.internal.measurement.q q3) {
        com.google.android.gms.internal.measurement.q obj0 = p2.a(b5, Collections.singletonList(q3));
        final boolean obj1 = obj0 instanceof i;
        if (obj1 != null) {
            return b6.b(obj0.zzh().doubleValue());
        }
        return -1;
    }

    public final void a(String string, int i2, com.google.android.gms.internal.measurement.p p3, String string4) {
        TreeMap obj1;
        String obj2;
        if ("create".equals(string4)) {
            obj1 = this.b;
            if (obj1.containsKey(Integer.valueOf(i2))) {
                obj2++;
            }
            obj1.put(Integer.valueOf(obj2), p3);
        } else {
            if ("edit".equals(string4)) {
                obj1 = this.a;
            }
        }
        obj2 = String.valueOf(string4);
        final String obj3 = "Unknown callback type: ";
        if (obj2.length() != 0) {
            obj2 = obj3.concat(obj2);
        } else {
            obj2 = new String(obj3);
        }
        obj1 = new IllegalStateException(obj2);
        throw obj1;
    }

    public final void b(com.google.android.gms.internal.measurement.b5 b5, com.google.android.gms.internal.measurement.c c2) {
        Iterator iterator;
        int i2;
        boolean next;
        com.google.android.gms.internal.measurement.b bVar;
        int i;
        v9 v9Var = new v9(c2);
        iterator = this.a.keySet().iterator();
        while (iterator.hasNext()) {
            i2 = kf.c(b5, (p)this.a.get((Integer)iterator.next()), v9Var);
            if (i2 != 2) {
            } else {
            }
            c2.f(c2.b().b());
            if (i2 == -1) {
            }
        }
        Iterator obj7 = this.b.keySet().iterator();
        for (Integer next3 : obj7) {
            kf.c(b5, (p)this.b.get(next3), v9Var);
        }
    }
}
