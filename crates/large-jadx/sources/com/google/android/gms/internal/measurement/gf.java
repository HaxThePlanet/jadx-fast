package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes2.dex */
public final class gf extends com.google.android.gms.internal.measurement.j {

    private final com.google.android.gms.internal.measurement.kf c;
    public gf(com.google.android.gms.internal.measurement.kf kf) {
        super("internal.registerCallback");
        this.c = kf;
    }

    public final com.google.android.gms.internal.measurement.q a(com.google.android.gms.internal.measurement.b5 b5, List<com.google.android.gms.internal.measurement.q> list2) {
        String doubleValue;
        int obj5;
        b6.h(this.a, 3, list2);
        com.google.android.gms.internal.measurement.q qVar2 = b5.b((q)list2.get(1));
        if (!qVar2 instanceof p) {
        } else {
            obj5 = b5.b((q)list2.get(2));
            if (!obj5 instanceof n) {
            } else {
                String obj6 = "type";
                if (!(n)obj5.g(obj6)) {
                } else {
                    doubleValue = "priority";
                    final boolean z3 = obj5.g(doubleValue);
                    if (z3) {
                        obj5 = b6.b(obj5.l(doubleValue).zzh().doubleValue());
                    } else {
                        obj5 = 1000;
                    }
                    this.c.a(b5.b((q)list2.get(0)).zzi(), obj5, (p)qVar2, obj5.l(obj6).zzi());
                    return q.h;
                }
                obj5 = new IllegalArgumentException("Undefined rule type");
                throw obj5;
            }
            obj5 = new IllegalArgumentException("Invalid callback params");
            throw obj5;
        }
        obj5 = new IllegalArgumentException("Invalid callback type");
        throw obj5;
    }
}
