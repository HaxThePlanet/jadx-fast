package kotlin.i0.z.e.m0.e.a0.b;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.c0.c;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class b {

    public static final kotlin.i0.z.e.m0.e.a0.b.b a;
    private static final String b;
    private static final Map<String, String> c;
    static {
        String str9;
        int i2;
        int string;
        String next;
        boolean next2;
        String str2;
        String str4;
        int i;
        String string2;
        String stringBuilder;
        String str10;
        String str8;
        String str7;
        String string3;
        String str;
        String str3;
        String str5;
        String str11;
        String str6;
        b bVar = new b();
        b.a = bVar;
        Character[] arr = new Character[6];
        i2 = 0;
        arr[i2] = 'k';
        arr[1] = 'o';
        int i11 = 2;
        arr[i11] = 't';
        arr[3] = 'l';
        arr[4] = 'i';
        arr[5] = 'n';
        b.b = p.h0(p.j(arr), "", 0, 0, 0, 0, 0, 62, 0);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List list = p.j(/* result */);
        int i12 = c.b(i2, size--, i11);
        if (i12 >= 0) {
            i = i2;
            StringBuilder stringBuilder3 = new StringBuilder();
            String str43 = b.b;
            stringBuilder3.append(str43);
            int i18 = 47;
            stringBuilder3.append(i18);
            stringBuilder3.append((String)list.get(i));
            str11 = i + 1;
            linkedHashMap.put(stringBuilder3.toString(), list.get(str11));
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(str43);
            stringBuilder4.append(i18);
            stringBuilder4.append((String)list.get(i));
            stringBuilder4.append("Array");
            linkedHashMap.put(stringBuilder4.toString(), n.o("[", list.get(str11)));
            while (i == i12) {
                i = str10;
                stringBuilder3 = new StringBuilder();
                str43 = b.b;
                stringBuilder3.append(str43);
                i18 = 47;
                stringBuilder3.append(i18);
                stringBuilder3.append((String)list.get(i));
                str11 = i + 1;
                linkedHashMap.put(stringBuilder3.toString(), list.get(str11));
                stringBuilder4 = new StringBuilder();
                stringBuilder4.append(str43);
                stringBuilder4.append(i18);
                stringBuilder4.append((String)list.get(i));
                stringBuilder4.append("Array");
                linkedHashMap.put(stringBuilder4.toString(), n.o("[", list.get(str11)));
            }
        }
        linkedHashMap.put(n.o(b.b, "/Unit"), "V");
        b.a(linkedHashMap, "Any", "java/lang/Object");
        b.a(linkedHashMap, "Nothing", "java/lang/Void");
        b.a(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        Iterator iterator = p.j(/* result */).iterator();
        for (String next : iterator) {
            b.a(linkedHashMap, next, n.o("java/lang/", next));
        }
        Iterator iterator2 = p.j(/* result */).iterator();
        for (String next6 : iterator2) {
            str8 = "java/util/";
            b.a(linkedHashMap, n.o("collections/", next6), n.o(str8, next6));
            b.a(linkedHashMap, n.o("collections/Mutable", next6), n.o(str8, next6));
        }
        String str27 = "java/lang/Iterable";
        b.a(linkedHashMap, "collections/Iterable", str27);
        b.a(linkedHashMap, "collections/MutableIterable", str27);
        str2 = "java/util/Map$Entry";
        b.a(linkedHashMap, "collections/Map.Entry", str2);
        b.a(linkedHashMap, "collections/MutableMap.MutableEntry", str2);
        str9 = i2 + 1;
        StringBuilder stringBuilder2 = new StringBuilder();
        str8 = b.b;
        stringBuilder2.append(str8);
        stringBuilder2.append("/jvm/functions/Function");
        stringBuilder2.append(i2);
        b.a(linkedHashMap, n.o("Function", Integer.valueOf(i2)), stringBuilder2.toString());
        b.a(linkedHashMap, n.o("reflect/KFunction", Integer.valueOf(i2)), n.o(str8, "/reflect/KFunction"));
        while (str9 > 22) {
            i2 = str9;
            str9 = i2 + 1;
            stringBuilder2 = new StringBuilder();
            str8 = b.b;
            stringBuilder2.append(str8);
            stringBuilder2.append("/jvm/functions/Function");
            stringBuilder2.append(i2);
            b.a(linkedHashMap, n.o("Function", Integer.valueOf(i2)), stringBuilder2.toString());
            b.a(linkedHashMap, n.o("reflect/KFunction", Integer.valueOf(i2)), n.o(str8, "/reflect/KFunction"));
        }
        Iterator iterator3 = p.j(/* result */).iterator();
        for (String next4 : iterator3) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(b.b);
            stringBuilder.append("/jvm/internal/");
            stringBuilder.append(next4);
            stringBuilder.append("CompanionObject");
            b.a(linkedHashMap, n.o(next4, ".Companion"), stringBuilder.toString());
        }
        b.c = linkedHashMap;
    }

    private static final void a(Map<String, String> map, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b.b);
        stringBuilder.append('/');
        stringBuilder.append(string2);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append('L');
        stringBuilder2.append(string3);
        stringBuilder2.append(';');
        map.put(stringBuilder.toString(), stringBuilder2.toString());
    }

    public static final String b(String string) {
        Object string2;
        int i4;
        Object obj;
        int i6;
        int i;
        int i3;
        int i2;
        int i5;
        Object obj8;
        n.f(string, "classId");
        if ((String)b.c.get(string) == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('L');
            stringBuilder.append(l.F(string, '.', '$', false, 4, 0));
            stringBuilder.append(';');
            string2 = stringBuilder.toString();
        }
        return string2;
    }
}
