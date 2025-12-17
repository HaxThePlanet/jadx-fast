package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.e5;
import com.google.android.gms.internal.measurement.f5;
import com.google.android.gms.internal.measurement.g5;
import com.google.android.gms.internal.measurement.h5;
import com.google.android.gms.internal.measurement.k4;
import com.google.android.gms.internal.measurement.l4;
import com.google.android.gms.internal.measurement.m4;
import com.google.android.gms.internal.measurement.n4;
import com.google.android.gms.internal.measurement.t8;
import com.google.android.gms.internal.measurement.yc;
import d.e.a;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
final class ra {

    private String a;
    private boolean b;
    private f5 c;
    private BitSet d;
    private BitSet e;
    private Map<Integer, Long> f;
    private Map<Integer, List<Long>> g;
    final com.google.android.gms.measurement.internal.xa h;
    ra(com.google.android.gms.measurement.internal.xa xa, String string2, f5 f53, BitSet bitSet4, BitSet bitSet5, Map map6, Map map7, com.google.android.gms.measurement.internal.qa qa8) {
        String obj2;
        BitSet obj4;
        BitSet obj5;
        this.h = xa;
        super();
        this.a = string2;
        this.d = bitSet4;
        this.e = bitSet5;
        this.f = map6;
        a obj1 = new a();
        this.g = obj1;
        obj1 = map7.keySet().iterator();
        for (Integer obj2 : obj1) {
            obj4 = new ArrayList();
            obj4.add((Long)map7.get(obj2));
            this.g.put(obj2, obj4);
        }
        this.b = false;
        this.c = f53;
    }

    ra(com.google.android.gms.measurement.internal.xa xa, String string2, com.google.android.gms.measurement.internal.qa qa3) {
        this.h = xa;
        super();
        this.a = string2;
        this.b = true;
        BitSet obj1 = new BitSet();
        this.d = obj1;
        obj1 = new BitSet();
        this.e = obj1;
        obj1 = new a();
        this.f = obj1;
        obj1 = new a();
        this.g = obj1;
    }

    static BitSet b(com.google.android.gms.measurement.internal.ra ra) {
        return ra.d;
    }

    final l4 a(int i) {
        int i2;
        Object emptyList;
        ArrayList arrayList;
        boolean intValue;
        Object obj;
        Object valueOf;
        final k4 k4Var = l4.x();
        k4Var.s(i);
        k4Var.u(this.b);
        f5 obj7 = this.c;
        if (obj7 != null) {
            k4Var.v(obj7);
        }
        obj7 = f5.B();
        obj7.t(da.J(this.d));
        obj7.v(da.J(this.e));
        Map map = this.f;
        if (map == null) {
            i2 = 0;
        } else {
            arrayList = new ArrayList(map.size());
            Iterator iterator2 = this.f.keySet().iterator();
            while (iterator2.hasNext()) {
                intValue = (Integer)iterator2.next().intValue();
                obj = this.f.get(Integer.valueOf(intValue));
                if ((Long)obj != null) {
                }
                valueOf = n4.y();
                valueOf.t(intValue);
                valueOf.s((Long)obj.longValue());
                arrayList.add((n4)valueOf.l());
            }
            i2 = arrayList;
        }
        if (i2 != 0) {
            obj7.s(i2);
        }
        Map map2 = this.g;
        if (map2 == null) {
            emptyList = Collections.emptyList();
        } else {
            arrayList = new ArrayList(map2.size());
            Iterator iterator = this.g.keySet().iterator();
            while (iterator.hasNext()) {
                Object next = iterator.next();
                obj = h5.z();
                obj.t((Integer)next.intValue());
                Object obj2 = this.g.get(next);
                if ((List)obj2 != null) {
                }
                arrayList.add((h5)obj.l());
                Collections.sort((List)obj2);
                obj.s(obj2);
            }
            emptyList = arrayList;
        }
        obj7.u(emptyList);
        k4Var.t(obj7);
        return (l4)k4Var.l();
    }

    final void c(com.google.android.gms.measurement.internal.va va) {
        boolean z;
        int contains;
        Boolean booleanValue;
        Boolean booleanValue2;
        Object cmp;
        Object arrayList;
        BitSet set;
        Integer valueOf;
        int valueOf2;
        long longValue;
        Object obj10;
        contains = va.a();
        booleanValue = va.c;
        if (booleanValue != null) {
            this.e.set(contains, booleanValue.booleanValue());
        }
        booleanValue2 = va.d;
        if (booleanValue2 != null) {
            this.d.set(contains, booleanValue2.booleanValue());
        }
        int i = 1000;
        if (va.e != null) {
            valueOf = Integer.valueOf(contains);
            cmp = this.f.get(valueOf);
            longValue4 /= i;
            if ((Long)cmp != null) {
                if (Long.compare(valueOf2, longValue) > 0) {
                    this.f.put(valueOf, Long.valueOf(valueOf2));
                }
            } else {
            }
        }
        Integer valueOf3 = Integer.valueOf(contains);
        if (va.f != null && (List)this.g.get(valueOf3) == null) {
            valueOf3 = Integer.valueOf(contains);
            if ((List)this.g.get(valueOf3) == null) {
                arrayList = new ArrayList();
                this.g.put(valueOf3, arrayList);
            }
            if (va.c()) {
                arrayList.clear();
            }
            yc.b();
            valueOf2 = c3.Z;
            if (xaVar.a.z().B(this.a, valueOf2) && va.b()) {
                if (va.b()) {
                    arrayList.clear();
                }
            }
            yc.b();
            if (xaVar2.a.z().B(this.a, valueOf2)) {
                obj10 = Long.valueOf(longValue2 /= i);
                if (!arrayList.contains(obj10)) {
                    arrayList.add(obj10);
                }
            } else {
                arrayList.add(Long.valueOf(longValue3 /= i));
            }
        }
    }
}
