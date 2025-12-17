package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public final class y8 extends com.google.android.gms.internal.measurement.j {

    private final com.google.android.gms.internal.measurement.c c;
    public y8(com.google.android.gms.internal.measurement.c c) {
        super("internal.eventLogger");
        this.c = c;
    }

    public final com.google.android.gms.internal.measurement.q a(com.google.android.gms.internal.measurement.b5 b5, List<com.google.android.gms.internal.measurement.q> list2) {
        Object obj5;
        b6.h(this.a, 3, list2);
        obj5 = b5.b((q)list2.get(2));
        if (obj5 instanceof n) {
            obj5 = b6.g((n)obj5);
        } else {
            obj5 = new HashMap();
        }
        this.c.e(b5.b((q)list2.get(0)).zzi(), (long)d, obj2);
        return q.h;
    }
}
