package net.time4j.tz.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.time4j.engine.z;
import net.time4j.f1.a;
import net.time4j.f1.b;
import net.time4j.f1.c;
import net.time4j.f1.g;
import net.time4j.tz.m;
import net.time4j.tz.p;
import net.time4j.tz.q;

/* loaded from: classes3.dex */
public abstract class l implements m, Serializable {
    static {
        System.getProperty("line.separator");
    }

    static long f(int i) {
        return i3 += l;
    }

    static m g(p p, List<q> list2, List<net.time4j.tz.model.d> list3, boolean z4, boolean z5) {
        boolean equals;
        Object obj;
        int i;
        int obj9;
        Object obj10;
        Object obj11;
        ArrayList obj12;
        if (z4 != null) {
            obj12 = new ArrayList(list2);
            obj10 = new ArrayList(list3);
            Collections.sort(obj12);
            Collections.sort(obj10, k.INSTANCE);
            obj = obj12;
        } else {
            obj = list2;
            obj10 = list3;
        }
        final int size = obj.size();
        obj11 = 0;
        if (size == 0 && obj10.isEmpty()) {
            if (obj10.isEmpty()) {
                obj10 = new e(p);
                return obj10;
            }
            obj12 = new j(p, obj10, obj11);
            return obj12;
        }
        obj12 = p.u((q)obj.get(obj11).j());
        if (z5) {
            if (!p.equals(obj12)) {
            } else {
            }
            obj11 = new StringBuilder();
            obj11.append("Initial offset ");
            obj11.append(p);
            obj11.append(" not equal ");
            obj11.append("to previous offset of first transition: ");
            obj11.append(obj12);
            obj10 = new IllegalArgumentException(obj11.toString());
            throw obj10;
        }
        if (obj10.isEmpty()) {
            obj9 = new a(obj, obj11, z5);
            return obj9;
        }
        Object obj2 = obj9;
        int i3 = obj11 + i;
        final long l = l.f(1);
        if (Long.compare(i3, l) < 0) {
            obj.addAll(j.s(obj2, obj10, i3, obj6));
        }
        super(size, obj, obj10, 0, z5);
        return obj9;
    }

    static List<p> h(int i) {
        return Collections.singletonList(p.u(i));
    }

    static List<p> i(int i, int i2) {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(p.u(i));
        arrayList.add(p.u(i2));
        return Collections.unmodifiableList(arrayList);
    }

    static long j(a a, g g2) {
        final int i5 = a.o();
        return i3 += obj4;
    }

    @Override // net.time4j.tz.m
    public boolean isEmpty() {
        return 0;
    }
}
