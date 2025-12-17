package kotlin.i0.z.e.m0.d.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.k.a;
import kotlin.i0.z.e.m0.f.b;

/* loaded from: classes3.dex */
public final class o {

    public static final kotlin.i0.z.e.m0.d.a.o a;
    private static final HashMap<b, b> b;
    static {
        o oVar = new o();
        o.a = oVar;
        HashMap hashMap = new HashMap();
        o.b = hashMap;
        oVar.c(k.a.S, oVar.a(/* result */));
        oVar.c(k.a.U, oVar.a(/* result */));
        oVar.c(k.a.V, oVar.a(/* result */));
        b bVar4 = new b("java.util.function.Function");
        oVar.c(bVar4, oVar.a(/* result */));
        b bVar5 = new b("java.util.function.BiFunction");
        oVar.c(bVar5, oVar.a(/* result */));
    }

    private final List<b> a(String... stringArr) {
        int i;
        Object obj;
        b bVar;
        ArrayList arrayList = new ArrayList(stringArr.length);
        i = 0;
        while (i < stringArr.length) {
            bVar = new b(stringArr[i]);
            arrayList.add(bVar);
            i++;
        }
        return arrayList;
    }

    private final void c(b b, List<b> list2) {
        Object next;
        Object obj;
        final Iterator obj5 = list2.iterator();
        for (Object next : obj5) {
            obj = next;
            o.b.put(next, b);
        }
    }

    public final b b(b b) {
        n.f(b, "classFqName");
        return (b)o.b.get(b);
    }
}
