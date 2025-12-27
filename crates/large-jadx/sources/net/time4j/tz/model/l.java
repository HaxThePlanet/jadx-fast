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

/* compiled from: TransitionModel.java */
/* loaded from: classes3.dex */
public abstract class l implements m, Serializable {
    static {
        System.getProperty("line.separator");
    }

    l() {
        super();
    }

    static long f(int i) {
        return (System.currentTimeMillis() / 1000L) + (long)(double)i * 31556952d;
    }

    static m g(p pVar, List<q> list, List<d> list2, boolean z, boolean z2) {
        ArrayList z42;
        ArrayList list23;
        if (z) {
            z42 = new ArrayList(list);
            Collections.sort(z42);
            Collections.sort(new ArrayList(list2), k.INSTANCE);
        } else {
            java.util.Collection list22 = list;
            java.util.Collection list32 = list2;
        }
        final int size = z42.size();
        z = false;
        if (size == 0) {
            if (list23.isEmpty()) {
                return new e(pVar);
            }
            return new j(pVar, list23, z);
        }
        p pVar4 = p.u((q)z42.get(z).j());
        if (z2) {
            if (!pVar.equals(pVar4)) {
                StringBuilder stringBuilder = new StringBuilder();
                final String str3 = "Initial offset ";
                String str = " not equal ";
                String str2 = "to previous offset of first transition: ";
                pVar = str3 + pVar + str + str2 + pVar4;
                throw new IllegalArgumentException(pVar);
            }
        }
        if (list23.isEmpty()) {
            return new a(z42, z, z2);
        }
        long l = 1L;
        long l2 = pVar3.i() + l;
        final long l4 = l.f(1);
        if (l2 < l4) {
            z42.addAll(j.s(pVar3, list23, l2, l4));
        }
        b pVar2 = new b(size, z42, list23, false, z2);
        return pVar2;
    }

    static List<p> h(int i) {
        return Collections.singletonList(p.u(i));
    }

    static List<p> i(int i, int i2) {
        final ArrayList arrayList = new ArrayList(2);
        arrayList.add(p.u(i));
        arrayList.add(p.u(i2));
        return Collections.unmodifiableList(arrayList);
    }

    static long j(a aVar, g gVar) {
        final int i2 = aVar.o();
        return (c.i(z.UNIX.transform(b.j(aVar.m(), i2, aVar.q()), z.MODIFIED_JULIAN_DATE), 86400L)) + (long)(gVar.s() * 3600) + (long)(gVar.i() * 60) + (long)gVar.u();
    }

    public boolean isEmpty() {
        return false;
    }
}
