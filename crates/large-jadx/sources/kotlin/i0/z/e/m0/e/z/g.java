package kotlin.i0.z.e.m0.e.z;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.e.q;
import kotlin.i0.z.e.m0.e.q.c;
import kotlin.i0.z.e.m0.e.t;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class g {

    private final List<q> a;
    public g(t t) {
        Object list;
        boolean arrayList;
        int i2;
        boolean next;
        int i;
        Object obj6;
        n.f(t, "typeTable");
        super();
        list = t.u();
        if (t.v()) {
            obj6 = t.u();
            n.e(obj6, "typeTable.typeList");
            arrayList = new ArrayList(p.r(obj6, 10));
            i2 = 0;
            obj6 = obj6.iterator();
            for (Object next : obj6) {
                if (i2 >= t.r()) {
                }
                arrayList.add(next);
                i2 = i;
                i2 = (q)next.v0();
                i2.E(true);
                next = i2.n();
            }
            list = arrayList;
        }
        n.e(list, "run {\n        val originalTypes = typeTable.typeList\n        if (typeTable.hasFirstNullable()) {\n            val firstNullable = typeTable.firstNullable\n            typeTable.typeList.mapIndexed { i, type ->\n                if (i >= firstNullable) {\n                    type.toBuilder().setNullable(true).build()\n                } else type\n            }\n        } else originalTypes\n    }");
        this.a = list;
    }

    public final q a(int i) {
        return (q)this.a.get(i);
    }
}
