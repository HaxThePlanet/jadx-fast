package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class k {
    public static com.google.android.gms.internal.measurement.q a(com.google.android.gms.internal.measurement.m m, com.google.android.gms.internal.measurement.q q2, com.google.android.gms.internal.measurement.b5 b53, List<com.google.android.gms.internal.measurement.q> list4) {
        final int i = 0;
        final int i2 = 1;
        if (m.g(q2.zzi())) {
            com.google.android.gms.internal.measurement.q obj4 = m.l(q2.zzi());
            if (!obj4 instanceof j) {
            } else {
                return (j)obj4.a(b53, list4);
            }
            Object[] obj6 = new Object[i2];
            obj6[i] = q2.zzi();
            obj4 = new IllegalArgumentException(String.format("%s is not a function", obj6));
            throw obj4;
        }
        final String str4 = "hasOwnProperty";
        if (!str4.equals(q2.zzi())) {
        } else {
            b6.h(str4, i2, list4);
            if (m.g(b53.b((q)list4.get(i)).zzi())) {
                return q.m;
            }
            return q.n;
        }
        obj6 = new Object[i2];
        obj6[i] = q2.zzi();
        obj4 = new IllegalArgumentException(String.format("Object has no function %s", obj6));
        throw obj4;
    }

    public static Iterator<com.google.android.gms.internal.measurement.q> b(Map<String, com.google.android.gms.internal.measurement.q> map) {
        l lVar = new l(map.keySet().iterator());
        return lVar;
    }
}
