package kotlin.i0.z.e.m0.j.b;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.h0.g;
import kotlin.i0.z.e.m0.e.c;
import kotlin.i0.z.e.m0.e.m;
import kotlin.i0.z.e.m0.e.z.a;
import kotlin.i0.z.e.m0.e.z.c;
import kotlin.i0.z.e.m0.f.a;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.y.j0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class w implements kotlin.i0.z.e.m0.j.b.g {

    private final c a;
    private final a b;
    private final l<a, u0> c;
    private final Map<a, c> d;
    public w(m m, c c2, a a3, l<? super a, ? extends u0> l4) {
        String str;
        int obj3;
        Object obj5;
        n.f(m, "proto");
        n.f(c2, "nameResolver");
        n.f(a3, "metadataVersion");
        n.f(l4, "classSource");
        super();
        this.a = c2;
        this.b = a3;
        this.c = l4;
        java.util.List obj2 = m.D();
        n.e(obj2, "proto.class_List");
        LinkedHashMap obj4 = new LinkedHashMap(g.b(j0.d(p.r(obj2, 10)), 16));
        obj2 = obj2.iterator();
        for (Object obj3 : obj2) {
            obj4.put(v.a(this.a, (c)obj3.h0()), obj3);
        }
        this.d = obj4;
    }

    @Override // kotlin.i0.z.e.m0.j.b.g
    public kotlin.i0.z.e.m0.j.b.f a(a a) {
        n.f(a, "classId");
        Object obj = this.d.get(a);
        if ((c)obj == null) {
            return null;
        }
        f fVar = new f(this.a, (c)obj, this.b, (u0)this.c.invoke(a));
        return fVar;
    }

    public final Collection<a> b() {
        return this.d.keySet();
    }
}
