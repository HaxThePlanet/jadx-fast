package kotlin.i0.z.e.m0.d.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class v {

    public static final kotlin.i0.z.e.m0.d.b.v a;

    static final class a extends p implements l<String, java.lang.CharSequence> {

        final kotlin.i0.z.e.m0.d.b.v this$0;
        a(kotlin.i0.z.e.m0.d.b.v v) {
            this.this$0 = v;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final java.lang.CharSequence invoke(String string) {
            n.f(string, "it");
            return v.a(this.this$0, string);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return invoke((String)object);
        }
    }
    static {
        v vVar = new v();
        v.a = vVar;
    }

    public static final String a(kotlin.i0.z.e.m0.d.b.v v, String string2) {
        return v.c(string2);
    }

    private final String c(String string) {
        int stringBuilder;
        int i;
        String obj3;
        if (string.length() > 1) {
            stringBuilder = new StringBuilder();
            stringBuilder.append('L');
            stringBuilder.append(string);
            stringBuilder.append(';');
            obj3 = stringBuilder.toString();
        }
        return obj3;
    }

    public final String[] b(String... stringArr) {
        int i;
        String string;
        StringBuilder stringBuilder;
        String str;
        n.f(stringArr, "signatures");
        ArrayList arrayList = new ArrayList(stringArr.length);
        final int i2 = 0;
        i = i2;
        while (i < stringArr.length) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("<init>(");
            stringBuilder.append(stringArr[i]);
            stringBuilder.append(")V");
            arrayList.add(stringBuilder.toString());
            i++;
        }
        Object[] obj8 = arrayList.toArray(new String[i2]);
        Objects.requireNonNull(obj8, "null cannot be cast to non-null type kotlin.Array<T>");
        return (String[])obj8;
    }

    public final Set<String> d(String string, String... string2Arr2) {
        int i;
        String string2;
        StringBuilder stringBuilder;
        int i2;
        n.f(string, "internalName");
        n.f(string2Arr2, "signatures");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        i = 0;
        while (i < string2Arr2.length) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append('.');
            stringBuilder.append(string2Arr2[i]);
            linkedHashSet.add(stringBuilder.toString());
            i++;
        }
        return linkedHashSet;
    }

    public final Set<String> e(String string, String... string2Arr2) {
        n.f(string, "name");
        n.f(string2Arr2, "signatures");
        String[] strArr = new String[string2Arr2.length];
        final int i = 0;
        System.arraycopy(string2Arr2, i, strArr, i, string2Arr2.length);
        return d(h(string), strArr);
    }

    public final Set<String> f(String string, String... string2Arr2) {
        n.f(string, "name");
        n.f(string2Arr2, "signatures");
        String[] strArr = new String[string2Arr2.length];
        final int i = 0;
        System.arraycopy(string2Arr2, i, strArr, i, string2Arr2.length);
        return d(i(string), strArr);
    }

    public final String g(String string) {
        n.f(string, "name");
        return n.o("java/util/function/", string);
    }

    public final String h(String string) {
        n.f(string, "name");
        return n.o("java/lang/", string);
    }

    public final String i(String string) {
        n.f(string, "name");
        return n.o("java/util/", string);
    }

    public final String j(String string, List<String> list2, String string3) {
        n.f(string, "name");
        n.f(list2, "parameters");
        n.f(string3, "ret");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append('(');
        v.a aVar = new v.a(this);
        stringBuilder.append(p.h0(list2, "", 0, 0, 0, 0, aVar, 30, 0));
        stringBuilder.append(')');
        stringBuilder.append(c(string3));
        return stringBuilder.toString();
    }

    public final String k(String string, String string2) {
        n.f(string, "internalName");
        n.f(string2, "jvmDescriptor");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append('.');
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}
