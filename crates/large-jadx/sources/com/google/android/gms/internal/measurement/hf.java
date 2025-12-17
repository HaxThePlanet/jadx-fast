package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class hf extends com.google.android.gms.internal.measurement.j {

    private final com.google.android.gms.internal.measurement.a8 c;
    final Map<String, com.google.android.gms.internal.measurement.j> v;
    public hf(com.google.android.gms.internal.measurement.a8 a8) {
        super("require");
        HashMap hashMap = new HashMap();
        this.v = hashMap;
        this.c = a8;
    }

    public final com.google.android.gms.internal.measurement.q a(com.google.android.gms.internal.measurement.b5 b5, List<com.google.android.gms.internal.measurement.q> list2) {
        boolean z;
        int i;
        Object obj4;
        b6.h("require", 1, list2);
        String obj3 = b5.b((q)list2.get(0)).zzi();
        if (this.v.containsKey(obj3)) {
            return (q)this.v.get(obj3);
        }
        obj4 = this.c;
        if (obj4.a.containsKey(obj3)) {
            obj4 = (Callable)obj4.a.get(obj3).call();
        } else {
            obj4 = q.h;
        }
        if (obj4 instanceof j) {
            this.v.put(obj3, (j)obj4);
        }
        return obj4;
    }
}
