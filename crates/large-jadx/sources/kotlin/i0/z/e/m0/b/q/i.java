package kotlin.i0.z.e.m0.b.q;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.k;
import kotlin.i0.z.e.m0.b.k.a;
import kotlin.i0.z.e.m0.d.b.v;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.c;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.t.d;
import kotlin.y.p;
import kotlin.y.q0;

/* loaded from: classes3.dex */
public final class i {

    public static final kotlin.i0.z.e.m0.b.q.i a;
    private static final Set<String> b;
    private static final Set<String> c;
    private static final Set<String> d;
    private static final Set<String> e;
    private static final Set<String> f;
    private static final Set<String> g;
    static {
        i iVar = new i();
        i.a = iVar;
        final v vVar = v.a;
        String str6 = "Collection";
        i.b = q0.j(vVar.f(str6, /* result */), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
        String str8 = "sort(Ljava/util/Comparator;)V";
        final String str17 = "List";
        String str19 = "String";
        String str9 = "isInfinite()Z";
        String str21 = "isNaN()Z";
        String str22 = "Float";
        String str26 = "CharSequence";
        i.c = q0.i(q0.i(q0.i(q0.i(q0.i(q0.i(iVar.b(), vVar.f(str17, /* result */)), vVar.e(str19, /* result */)), vVar.e("Double", /* result */)), vVar.e(str22, /* result */)), vVar.e("Enum", /* result */)), vVar.e(str26, /* result */));
        String str28 = "spliterator()Ljava/util/Spliterator;";
        String str33 = "Throwable";
        String str41 = "removeIf(Ljava/util/function/Predicate;)Z";
        String str16 = "replaceAll(Ljava/util/function/UnaryOperator;)V";
        String str37 = "Map";
        i.d = q0.i(q0.i(q0.i(q0.i(q0.i(q0.i(vVar.e(str26, /* result */), vVar.f("Iterator", /* result */)), vVar.e("Iterable", /* result */)), vVar.e(str33, /* result */)), vVar.f(str6, /* result */)), vVar.f(str17, /* result */)), vVar.f(str37, /* result */));
        i.e = q0.i(q0.i(vVar.f(str6, /* result */), vVar.f(str17, /* result */)), vVar.f(str37, /* result */));
        String[] strArr7 = vVar.b(/* result */);
        String[] strArr13 = new String[strArr7.length];
        int i = 0;
        System.arraycopy(strArr7, i, strArr13, i, strArr7.length);
        String[] strArr9 = vVar.b(/* result */);
        String[] strArr14 = new String[strArr9.length];
        System.arraycopy(strArr9, i, strArr14, i, strArr9.length);
        i.f = q0.i(q0.i(iVar.a(), vVar.e(str22, strArr13)), vVar.e(str19, strArr14));
        String[] strArr2 = vVar.b(/* result */);
        String[] strArr10 = new String[strArr2.length];
        System.arraycopy(strArr2, i, strArr10, i, strArr2.length);
        i.g = vVar.e(str33, strArr10);
    }

    private final Set<String> a() {
        int i2;
        int i;
        String[] strArr;
        int length;
        final v vVar = v.a;
        d[] arr = new d[8];
        final int i4 = 0;
        arr[i4] = d.BOOLEAN;
        d bYTE = d.BYTE;
        arr[1] = bYTE;
        arr[2] = d.DOUBLE;
        arr[3] = d.FLOAT;
        arr[4] = bYTE;
        arr[5] = d.INT;
        arr[6] = d.LONG;
        arr[7] = d.SHORT;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator iterator = p.j(arr).iterator();
        for (d next2 : iterator) {
            String str = next2.getWrapperFqName().g().c();
            n.e(str, "it.wrapperFqName.shortName().asString()");
            i = vVar.b(/* result */);
            strArr = new String[i.length];
            System.arraycopy(i, i4, strArr, i4, i.length);
            p.y(linkedHashSet, vVar.e(str, strArr));
        }
        return linkedHashSet;
    }

    private final Set<String> b() {
        Set set;
        String str;
        String[] strArr;
        StringBuilder stringBuilder;
        String str2;
        d[] arr = new d[2];
        final int i2 = 0;
        arr[i2] = d.BOOLEAN;
        final int i3 = 1;
        arr[i3] = d.CHAR;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator iterator = p.j(arr).iterator();
        for (d next2 : iterator) {
            str = next2.getWrapperFqName().g().c();
            n.e(str, "it.wrapperFqName.shortName().asString()");
            strArr = new String[i3];
            stringBuilder = new StringBuilder();
            stringBuilder.append(next2.getJavaKeywordName());
            stringBuilder.append("Value()");
            stringBuilder.append(next2.getDesc());
            strArr[i2] = stringBuilder.toString();
            p.y(linkedHashSet, v.a.e(str, strArr));
        }
        return linkedHashSet;
    }

    public final Set<String> c() {
        return i.b;
    }

    public final Set<String> d() {
        return i.f;
    }

    public final Set<String> e() {
        return i.c;
    }

    public final Set<String> f() {
        return i.e;
    }

    public final Set<String> g() {
        return i.g;
    }

    public final Set<String> h() {
        return i.d;
    }

    public final boolean i(c c) {
        k z;
        int obj2;
        n.f(c, "fqName");
        if (!n.b(c, k.a.h)) {
            z = k.a;
            if (k.e(c)) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    public final boolean j(c c) {
        n.f(c, "fqName");
        if (i(c)) {
            return 1;
        }
        a obj2 = c.a.o(c);
        if (obj2 == null) {
            return 0;
        }
        return Serializable.class.isAssignableFrom(Class.forName(obj2.b().b()));
    }
}
