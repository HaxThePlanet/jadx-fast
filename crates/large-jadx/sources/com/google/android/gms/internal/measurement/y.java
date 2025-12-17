package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class y {

    final Map<String, com.google.android.gms.internal.measurement.x> a;
    final com.google.android.gms.internal.measurement.l0 b;
    public y() {
        super();
        HashMap hashMap = new HashMap();
        this.a = hashMap;
        l0 l0Var = new l0();
        this.b = l0Var;
        w wVar = new w();
        b(wVar);
        z zVar = new z();
        b(zVar);
        a0 a0Var = new a0();
        b(a0Var);
        e0 e0Var = new e0();
        b(e0Var);
        j0 j0Var = new j0();
        b(j0Var);
        k0 k0Var = new k0();
        b(k0Var);
        m0 m0Var = new m0();
        b(m0Var);
    }

    public final com.google.android.gms.internal.measurement.q a(com.google.android.gms.internal.measurement.b5 b5, com.google.android.gms.internal.measurement.q q2) {
        Object l0Var;
        b6.c(b5);
        if (q2 instanceof r) {
            final String obj4 = q2.a();
            if (this.a.containsKey(obj4)) {
                l0Var = this.a.get(obj4);
            } else {
                l0Var = this.b;
            }
            return l0Var.a(obj4, b5, (r)q2.c());
        }
        return q2;
    }

    final void b(com.google.android.gms.internal.measurement.x x) {
        String string;
        Map map;
        Iterator iterator = x.a.iterator();
        for (n0 next2 : iterator) {
            this.a.put(next2.zzb().toString(), x);
        }
    }
}
