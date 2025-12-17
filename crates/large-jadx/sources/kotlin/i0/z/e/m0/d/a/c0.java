package kotlin.i0.z.e.m0.d.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.b.v;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.t.d;
import kotlin.o;
import kotlin.u;
import kotlin.y.j0;
import kotlin.y.p;
import kotlin.y.q0;

/* loaded from: classes3.dex */
public class c0 {

    public static final kotlin.i0.z.e.m0.d.a.c0.a a;
    private static final List<kotlin.i0.z.e.m0.d.a.c0.a.a> b;
    private static final List<String> c;
    private static final Map<kotlin.i0.z.e.m0.d.a.c0.a.a, kotlin.i0.z.e.m0.d.a.c0.c> d;
    private static final Map<String, kotlin.i0.z.e.m0.d.a.c0.c> e;
    private static final Set<e> f;
    private static final Set<String> g;
    private static final kotlin.i0.z.e.m0.d.a.c0.a.a h;
    private static final Map<kotlin.i0.z.e.m0.d.a.c0.a.a, e> i;
    private static final Map<String, e> j;
    private static final List<e> k;
    private static final Map<e, List<e>> l;

    public static final class a {
        public a(g g) {
            super();
        }

        public static final kotlin.i0.z.e.m0.d.a.c0.a.a a(kotlin.i0.z.e.m0.d.a.c0.a c0$a, String string2, String string3, String string4, String string5) {
            return a.k(string2, string3, string4, string5);
        }

        private final kotlin.i0.z.e.m0.d.a.c0.a.a k(String string, String string2, String string3, String string4) {
            final e eVar = e.j(string2);
            n.e(eVar, "identifier(name)");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append('(');
            stringBuilder.append(string3);
            stringBuilder.append(')');
            stringBuilder.append(string4);
            c0.a.a aVar = new c0.a.a(eVar, v.a.k(string, stringBuilder.toString()));
            return aVar;
        }

        public final List<String> b() {
            return c0.a();
        }

        public final Set<e> c() {
            return c0.b();
        }

        public final Set<String> d() {
            return c0.c();
        }

        public final Map<e, List<e>> e() {
            return c0.d();
        }

        public final List<e> f() {
            return c0.e();
        }

        public final kotlin.i0.z.e.m0.d.a.c0.a.a g() {
            return c0.f();
        }

        public final Map<String, kotlin.i0.z.e.m0.d.a.c0.c> h() {
            return c0.g();
        }

        public final Map<String, e> i() {
            return c0.h();
        }

        public final kotlin.i0.z.e.m0.d.a.c0.b j(String string) {
            kotlin.i0.z.e.m0.d.a.c0.b obj2;
            n.f(string, "builtinSignature");
            if (b().contains(string)) {
                return c0.b.ONE_COLLECTION_PARAMETER;
            }
            obj2 = (c0.c)j0.i(h(), string) == c0.c.NULL ? c0.b.OBJECT_PARAMETER_GENERIC : c0.b.OBJECT_PARAMETER_NON_GENERIC;
            return obj2;
        }
    }

    public static enum b {

        ONE_COLLECTION_PARAMETER("Ljava/util/Collection<+Ljava/lang/Object;>;", false),
        OBJECT_PARAMETER_NON_GENERIC(false, true),
        OBJECT_PARAMETER_GENERIC("Ljava/lang/Object;", true);

        private final boolean isObjectReplacedWithTypeParameter;
        private final String valueParametersSignature;
    }

    public static enum c {

        NULL(false),
        INDEX(false),
        FALSE("INDEX"),
        MAP_GET_OR_DEFAULT;

        private final Object defaultValue;
    }
    static {
        int value3;
        boolean next;
        int i4;
        int i3;
        int i2;
        int value;
        int i;
        int value2;
        int i5;
        boolean oVar;
        String str2;
        String desc2;
        o[] arrayList;
        kotlin.i0.z.e.m0.d.a.c0.a aVar;
        String desc;
        String str;
        c0.a aVar2 = new c0.a(0);
        c0.a = aVar2;
        Set set = q0.g(/* result */);
        int i8 = 10;
        ArrayList arrayList3 = new ArrayList(p.r(set, i8));
        Iterator iterator = set.iterator();
        String str9 = "BOOLEAN.desc";
        for (String next17 : iterator) {
            desc = d.BOOLEAN.getDesc();
            n.e(desc, str9);
            arrayList3.add(c0.a.a(c0.a, "java/util/Collection", next17, "Ljava/util/Collection;", desc));
            str9 = "BOOLEAN.desc";
        }
        c0.b = arrayList3;
        ArrayList arrayList2 = new ArrayList(p.r(arrayList3, i8));
        Iterator iterator8 = arrayList3.iterator();
        for (c0.a.a next16 : iterator8) {
            arrayList2.add(next16.b());
        }
        c0.c = arrayList2;
        List list = c0.b;
        ArrayList arrayList4 = new ArrayList(p.r(list, i8));
        Iterator iterator2 = list.iterator();
        for (c0.a.a next15 : iterator2) {
            arrayList4.add(next15.a().c());
        }
        v vVar = v.a;
        o[] arr = new o[i8];
        kotlin.i0.z.e.m0.d.a.c0.a aVar6 = c0.a;
        String str15 = "Collection";
        d bOOLEAN2 = d.BOOLEAN;
        String desc10 = bOOLEAN2.getDesc();
        n.e(desc10, str9);
        String str45 = "Ljava/lang/Object;";
        kotlin.i0.z.e.m0.d.a.c0.c fALSE = c0.c.FALSE;
        int i18 = 0;
        arr[i18] = u.a(c0.a.a(aVar6, vVar.i(str15), "contains", str45, desc10), fALSE);
        String desc7 = bOOLEAN2.getDesc();
        n.e(desc7, str9);
        final String str49 = "remove";
        int i12 = 1;
        arr[i12] = u.a(c0.a.a(aVar6, vVar.i(str15), str49, str45, desc7), fALSE);
        String str17 = "Map";
        String desc16 = bOOLEAN2.getDesc();
        n.e(desc16, str9);
        int i19 = 2;
        arr[i19] = u.a(c0.a.a(aVar6, vVar.i(str17), "containsKey", str45, desc16), fALSE);
        String desc17 = bOOLEAN2.getDesc();
        n.e(desc17, str9);
        arr[3] = u.a(c0.a.a(aVar6, vVar.i(str17), "containsValue", str45, desc17), fALSE);
        String desc9 = bOOLEAN2.getDesc();
        n.e(desc9, str9);
        String str10 = "Ljava/lang/Object;Ljava/lang/Object;";
        arr[4] = u.a(c0.a.a(aVar6, vVar.i(str17), str49, str10, desc9), fALSE);
        arr[5] = u.a(c0.a.a(aVar6, vVar.i(str17), "getOrDefault", str10, str45), c0.c.MAP_GET_OR_DEFAULT);
        String str54 = "get";
        kotlin.i0.z.e.m0.d.a.c0.c nULL = c0.c.NULL;
        final int i22 = 6;
        arr[i22] = u.a(c0.a.a(aVar6, vVar.i(str17), str54, str45, str45), nULL);
        arr[7] = u.a(c0.a.a(aVar6, vVar.i(str17), str49, str45, str45), nULL);
        String str13 = "List";
        final d iNT2 = d.INT;
        String desc5 = iNT2.getDesc();
        String str29 = "INT.desc";
        n.e(desc5, str29);
        kotlin.i0.z.e.m0.d.a.c0.c iNDEX = c0.c.INDEX;
        int i21 = 8;
        arr[i21] = u.a(c0.a.a(aVar6, vVar.i(str13), "indexOf", str45, desc5), iNDEX);
        desc2 = iNT2.getDesc();
        n.e(desc2, str29);
        arr[9] = u.a(c0.a.a(aVar6, vVar.i(str13), "lastIndexOf", str45, desc2), iNDEX);
        Map map = j0.k(arr);
        c0.d = map;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(j0.d(map.size()));
        Iterator iterator3 = map.entrySet().iterator();
        for (Map.Entry next14 : iterator3) {
            linkedHashMap2.put((c0.a.a)next14.getKey().b(), next14.getValue());
        }
        c0.e = linkedHashMap2;
        Set set2 = q0.i(c0.d.keySet(), c0.b);
        ArrayList arrayList5 = new ArrayList(p.r(set2, i8));
        Iterator iterator10 = set2.iterator();
        for (c0.a.a next19 : iterator10) {
            arrayList5.add(next19.a());
        }
        c0.f = p.P0(arrayList5);
        ArrayList arrayList6 = new ArrayList(p.r(set2, i8));
        Iterator iterator4 = set2.iterator();
        for (c0.a.a next13 : iterator4) {
            arrayList6.add(next13.b());
        }
        c0.g = p.P0(arrayList6);
        kotlin.i0.z.e.m0.d.a.c0.a aVar4 = c0.a;
        d iNT = d.INT;
        String desc4 = iNT.getDesc();
        n.e(desc4, str29);
        c0.h = c0.a.a(aVar4, "java/util/List", "removeAt", desc4, str45);
        v vVar2 = v.a;
        arrayList = new o[i21];
        String str19 = "Number";
        String desc15 = d.BYTE.getDesc();
        n.e(desc15, "BYTE.desc");
        String str61 = "";
        arrayList[i18] = u.a(c0.a.a(aVar4, vVar2.h(str19), "toByte", str61, desc15), e.j("byteValue"));
        String desc14 = d.SHORT.getDesc();
        n.e(desc14, "SHORT.desc");
        arrayList[i12] = u.a(c0.a.a(aVar4, vVar2.h(str19), "toShort", str61, desc14), e.j("shortValue"));
        String desc11 = iNT.getDesc();
        n.e(desc11, str29);
        arrayList[i19] = u.a(c0.a.a(aVar4, vVar2.h(str19), "toInt", str61, desc11), e.j("intValue"));
        String desc12 = d.LONG.getDesc();
        n.e(desc12, "LONG.desc");
        arrayList[3] = u.a(c0.a.a(aVar4, vVar2.h(str19), "toLong", str61, desc12), e.j("longValue"));
        String desc13 = d.FLOAT.getDesc();
        n.e(desc13, "FLOAT.desc");
        arrayList[4] = u.a(c0.a.a(aVar4, vVar2.h(str19), "toFloat", str61, desc13), e.j("floatValue"));
        String desc8 = d.DOUBLE.getDesc();
        n.e(desc8, "DOUBLE.desc");
        arrayList[5] = u.a(c0.a.a(aVar4, vVar2.h(str19), "toDouble", str61, desc8), e.j("doubleValue"));
        arrayList[i22] = u.a(aVar4.g(), e.j(str49));
        String desc3 = iNT.getDesc();
        n.e(desc3, str29);
        String desc6 = d.CHAR.getDesc();
        n.e(desc6, "CHAR.desc");
        arrayList[7] = u.a(c0.a.a(aVar4, vVar2.h("CharSequence"), str54, desc3, desc6), e.j("charAt"));
        Map map3 = j0.k(arrayList);
        c0.i = map3;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(j0.d(map3.size()));
        Iterator iterator5 = map3.entrySet().iterator();
        for (Map.Entry next12 : iterator5) {
            linkedHashMap3.put((c0.a.a)next12.getKey().b(), next12.getValue());
        }
        c0.j = linkedHashMap3;
        Set keySet2 = c0.i.keySet();
        ArrayList arrayList7 = new ArrayList(p.r(keySet2, i8));
        Iterator iterator6 = keySet2.iterator();
        for (c0.a.a next11 : iterator6) {
            arrayList7.add(next11.a());
        }
        c0.k = arrayList7;
        Set entrySet3 = c0.i.entrySet();
        ArrayList arrayList8 = new ArrayList(p.r(entrySet3, i8));
        Iterator iterator7 = entrySet3.iterator();
        for (Map.Entry next4 : iterator7) {
            oVar = new o((c0.a.a)next4.getKey().a(), next4.getValue());
            arrayList8.add(oVar);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator iterator9 = arrayList8.iterator();
        while (iterator9.hasNext()) {
            Object next3 = iterator9.next();
            oVar = (o)next3.d();
            if (linkedHashMap.get((e)oVar) == null) {
            }
            (List)arrayList.add((e)next3.c());
            arrayList = new ArrayList();
            linkedHashMap.put(oVar, arrayList);
        }
        c0.l = linkedHashMap;
    }

    public static final List a() {
        return c0.c;
    }

    public static final Set b() {
        return c0.f;
    }

    public static final Set c() {
        return c0.g;
    }

    public static final Map d() {
        return c0.l;
    }

    public static final List e() {
        return c0.k;
    }

    public static final kotlin.i0.z.e.m0.d.a.c0.a.a f() {
        return c0.h;
    }

    public static final Map g() {
        return c0.e;
    }

    public static final Map h() {
        return c0.j;
    }
}
