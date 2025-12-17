package kotlin.i0.z.e.m0.d.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.k.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.o;
import kotlin.u;
import kotlin.y.j0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class g {

    public static final kotlin.i0.z.e.m0.d.a.g a;
    private static final Map<b, e> b;
    private static final Map<e, List<e>> c;
    private static final Set<b> d;
    private static final Set<e> e;
    static {
        int i;
        int value;
        boolean next;
        o oVar;
        e arrayList;
        g gVar = new g();
        g.a = gVar;
        o[] arr = new o[8];
        kotlin.i0.z.e.m0.f.c cVar = k.a.r;
        String str = "name";
        String str2 = "ordinal";
        String str3 = "size";
        b bVar4 = k.a.N;
        String str8 = "length";
        String str5 = "values";
        Map map = j0.k(u.a(h.b(cVar, str), e.j(str)), u.a(h.b(cVar, str2), e.j(str2)), u.a(h.a(k.a.J, str3), e.j(str3)), u.a(h.a(bVar4, str3), e.j(str3)), u.a(h.b(k.a.f, str8), e.j(str8)), u.a(h.a(bVar4, "keys"), e.j("keySet")), u.a(h.a(bVar4, str5), e.j(str5)), u.a(h.a(bVar4, "entries"), e.j("entrySet")));
        g.b = map;
        Set entrySet = map.entrySet();
        int i5 = 10;
        ArrayList arrayList2 = new ArrayList(p.r(entrySet, i5));
        Iterator iterator = entrySet.iterator();
        for (Map.Entry next6 : iterator) {
            oVar = new o((b)next6.getKey().g(), next6.getValue());
            arrayList2.add(oVar);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator iterator3 = arrayList2.iterator();
        while (iterator3.hasNext()) {
            Object next5 = iterator3.next();
            oVar = (o)next5.d();
            if (linkedHashMap.get((e)oVar) == null) {
            }
            (List)arrayList.add((e)next5.c());
            arrayList = new ArrayList();
            linkedHashMap.put(oVar, arrayList);
        }
        g.c = linkedHashMap;
        Set keySet = g.b.keySet();
        g.d = keySet;
        ArrayList arrayList3 = new ArrayList(p.r(keySet, i5));
        Iterator iterator2 = keySet.iterator();
        for (b next3 : iterator2) {
            arrayList3.add(next3.g());
        }
        g.e = p.P0(arrayList3);
    }

    public final Map<b, e> a() {
        return g.b;
    }

    public final List<e> b(e e) {
        Object obj2;
        n.f(e, "name1");
        if ((List)g.c.get(e) == null) {
            obj2 = p.g();
        }
        return obj2;
    }

    public final Set<b> c() {
        return g.d;
    }

    public final Set<e> d() {
        return g.e;
    }
}
