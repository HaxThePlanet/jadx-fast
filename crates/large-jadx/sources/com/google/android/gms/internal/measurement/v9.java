package com.google.android.gms.internal.measurement;

import com.google.android.exoplayer2.drm.d0;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class v9 extends com.google.android.gms.internal.measurement.n {

    private final com.google.android.gms.internal.measurement.c b;
    public v9(com.google.android.gms.internal.measurement.c c) {
        super();
        this.b = c;
    }

    public final com.google.android.gms.internal.measurement.q m(String string, com.google.android.gms.internal.measurement.b5 b52, List<com.google.android.gms.internal.measurement.q> list3) {
        boolean equals2;
        int next;
        boolean equals;
        int i;
        final Object obj = this;
        String str = string;
        com.google.android.gms.internal.measurement.b5 b5Var = b52;
        List list = list3;
        int i3 = 4;
        final int i5 = 3;
        final String str8 = "setEventName";
        final String str9 = "setParamValue";
        final String str10 = "getParams";
        final String str11 = "getParamValue";
        final String str12 = "getTimestamp";
        final String str13 = "getEventName";
        final int i8 = 2;
        final int i9 = 1;
        i = 0;
        switch (equals) {
            case 21624207:
                next = i;
                next = -1;
                break;
            case 45521504:
                next = i5;
                next = -1;
                break;
            case 146575578:
                next = i9;
                next = -1;
                break;
            case 700587132:
                next = i8;
                next = -1;
                break;
            case 920706790:
                next = 5;
                next = -1;
                break;
            case 1570616835:
                next = i3;
                next = -1;
                break;
            default:
                next = -1;
        }
        if (next != 0 && next != i9 && next != i8 && next != i5 && next != i3 && next != 5) {
            if (next != i9) {
                if (next != i8) {
                    if (next != i5) {
                        if (next != i3) {
                            if (next != 5) {
                                return super.m(string, b52, list3);
                            }
                            b6.h(str9, i8, list);
                            com.google.android.gms.internal.measurement.q qVar6 = b5Var.b((q)list.get(i9));
                            obj.b.b().g(b5Var.b((q)list.get(i)).zzi(), b6.f(qVar6));
                            return qVar6;
                        }
                        b6.h(str8, i9, list);
                        com.google.android.gms.internal.measurement.q qVar3 = b5Var.b((q)list.get(i));
                        if (q.h.equals(qVar3)) {
                        } else {
                            if (q.i.equals(qVar3)) {
                            } else {
                                obj.b.b().f(qVar3.zzi());
                                u uVar2 = new u(qVar3.zzi());
                                return uVar2;
                            }
                        }
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Illegal event name");
                        throw illegalArgumentException;
                    }
                    b6.h(str12, i, list);
                    i iVar = new i(Double.valueOf((double)l));
                    return iVar;
                }
                b6.h(str10, i, list);
                Map map = obj.b.b().e();
                n nVar = new n();
                Iterator iterator = map.keySet().iterator();
                for (String next : iterator) {
                    nVar.i(next, c7.b(map.get(next)));
                }
                return nVar;
            }
            b6.h(str11, i9, list);
            return c7.b(obj.b.b().c(b5Var.b((q)list.get(i)).zzi()));
        }
        b6.h(str13, i, list);
        u uVar = new u(obj.b.b().d());
        return uVar;
    }
}
