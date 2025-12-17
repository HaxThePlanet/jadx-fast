package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class c7 {
    public static com.google.android.gms.internal.measurement.q a(com.google.android.gms.internal.measurement.u5 u5) {
        int i;
        if (u5 == null) {
            return q.h;
        }
        i2--;
        i = 0;
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            i = 0;
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                    } else {
                        ArrayList arrayList = new ArrayList();
                        Iterator iterator = u5.A().iterator();
                        for (u5 next2 : iterator) {
                            arrayList.add(c7.a(next2));
                        }
                        r rVar = new r(u5.y(), arrayList);
                        return rVar;
                    }
                    IllegalArgumentException obj3 = new IllegalArgumentException("Unknown type found. Cannot convert entity");
                    throw obj3;
                }
                if (u5.C()) {
                    g gVar = new g(Boolean.valueOf(u5.B()));
                    return gVar;
                }
                obj3 = new g(i);
                return obj3;
            }
            if (u5.D()) {
                i iVar = new i(Double.valueOf(u5.w()));
                return iVar;
            }
            obj3 = new i(i);
            return obj3;
        }
        if (u5.E()) {
            u uVar = new u(u5.z());
            return uVar;
        }
        return q.o;
    }

    public static com.google.android.gms.internal.measurement.q b(Object object) {
        com.google.android.gms.internal.measurement.q qVar2;
        double string;
        com.google.android.gms.internal.measurement.q qVar;
        boolean z;
        if (object == null) {
            return q.i;
        }
        if (object instanceof String != null) {
            u uVar = new u((String)object);
            return uVar;
        }
        if (object instanceof Double) {
            i iVar3 = new i((Double)object);
            return iVar3;
        }
        if (object instanceof Long) {
            i iVar = new i(Double.valueOf((Long)object.doubleValue()));
            return iVar;
        }
        if (object instanceof Integer) {
            i iVar2 = new i(Double.valueOf((Integer)object.doubleValue()));
            return iVar2;
        }
        if (object instanceof Boolean) {
            g gVar = new g((Boolean)object);
            return gVar;
        }
        if (object instanceof Map != null) {
            n nVar = new n();
            Iterator iterator = (Map)object.keySet().iterator();
            while (iterator.hasNext()) {
                string = iterator.next();
                if (string != 0 && string instanceof String == null) {
                }
                if (string instanceof String == null) {
                }
                nVar.i((String)string, c7.b(object.get(string)));
                string = string.toString();
            }
            return nVar;
        }
        if (object instanceof List == null) {
        } else {
            f fVar = new f();
            Iterator obj5 = (List)object.iterator();
            for (Object next2 : obj5) {
                fVar.A(fVar.q(), c7.b(next2));
            }
            return fVar;
        }
        obj5 = new IllegalArgumentException("Invalid value type");
        throw obj5;
    }
}
