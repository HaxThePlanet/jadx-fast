package net.time4j.g1.z;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import net.time4j.tz.k;

/* loaded from: classes3.dex */
class g0 {

    private final net.time4j.g1.z.g0.b a;

    static class a {
    }

    static class b {

        private final char a;
        private final net.time4j.g1.z.g0.b b;
        private final net.time4j.g1.z.g0.b c;
        private final net.time4j.g1.z.g0.b d;
        private final List<k> e;
        private b(char c) {
            super(c, 0, 0, 0, 0);
        }

        b(char c, net.time4j.g1.z.g0.a g0$a2) {
            super(c);
        }

        private b(char c, net.time4j.g1.z.g0.b g0$b2, net.time4j.g1.z.g0.b g0$b3, net.time4j.g1.z.g0.b g0$b4, List<k> list5) {
            super();
            this.a = c;
            this.b = b2;
            this.c = b3;
            this.d = b4;
            this.e = list5;
        }

        static char a(net.time4j.g1.z.g0.b g0$b) {
            return b.a;
        }

        static net.time4j.g1.z.g0.b b(net.time4j.g1.z.g0.b g0$b) {
            return b.b;
        }

        static net.time4j.g1.z.g0.b c(net.time4j.g1.z.g0.b g0$b) {
            return b.d;
        }

        static List d(net.time4j.g1.z.g0.b g0$b) {
            return b.e;
        }

        static net.time4j.g1.z.g0.b e(net.time4j.g1.z.g0.b g0$b) {
            return b.c;
        }

        static net.time4j.g1.z.g0.b f(net.time4j.g1.z.g0.b g0$b, net.time4j.g1.z.g0.b g0$b2) {
            return b.k(b2);
        }

        static net.time4j.g1.z.g0.b g(net.time4j.g1.z.g0.b g0$b, net.time4j.g1.z.g0.b g0$b2) {
            return b.m(b2);
        }

        static net.time4j.g1.z.g0.b h(net.time4j.g1.z.g0.b g0$b, net.time4j.g1.z.g0.b g0$b2) {
            return b.l(b2);
        }

        static net.time4j.g1.z.g0.b i(net.time4j.g1.z.g0.b g0$b, k k2) {
            return b.j(k2);
        }

        private net.time4j.g1.z.g0.b j(k k) {
            ArrayList arrayList = new ArrayList();
            List list = this.e;
            if (list != null) {
                arrayList.addAll(list);
            }
            arrayList.add(k);
            super(this.a, this.b, this.c, this.d, arrayList);
            return obj7;
        }

        private net.time4j.g1.z.g0.b k(net.time4j.g1.z.g0.b g0$b) {
            super(this.a, b, this.c, this.d, this.e);
            return bVar5;
        }

        private net.time4j.g1.z.g0.b l(net.time4j.g1.z.g0.b g0$b) {
            super(this.a, this.b, b, this.d, this.e);
            return bVar5;
        }

        private net.time4j.g1.z.g0.b m(net.time4j.g1.z.g0.b g0$b) {
            super(this.a, this.b, this.c, b, this.e);
            return bVar5;
        }
    }
    g0(net.time4j.g1.z.g0.b g0$b) {
        super();
        this.a = b;
    }

    private void a(net.time4j.g1.z.g0.b g0$b, StringBuilder stringBuilder2, List<String> list3) {
        Object string;
        char c;
        if (b == null) {
        }
        a(g0.b.b(b), stringBuilder2, list3);
        if (g0.b.d(b) != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append(g0.b.a(b));
            list3.add(stringBuilder.toString());
        }
        stringBuilder2.append(g0.b.a(b));
        a(g0.b.e(b), stringBuilder2, list3);
        stringBuilder2.deleteCharAt(length--);
        a(g0.b.c(b), stringBuilder2, list3);
    }

    private static net.time4j.g1.z.g0.b c(net.time4j.g1.z.g0.b g0$b, String string2, int i3) {
        net.time4j.g1.z.g0.b obj2;
        int obj4;
        if (b == null) {
            return null;
        }
        char charAt = string2.charAt(i3);
        if (charAt < g0.b.a(b)) {
            return g0.c(g0.b.b(b), string2, i3);
        }
        if (charAt > g0.b.a(b)) {
            return g0.c(g0.b.c(b), string2, i3);
        }
        if (i3 < length--) {
            obj2 = g0.c(g0.b.e(b), string2, i3++);
        }
        return obj2;
    }

    static net.time4j.g1.z.g0.b d(net.time4j.g1.z.g0.b g0$b, String string2, k k3) {
        if (string2.isEmpty()) {
        } else {
            Objects.requireNonNull(k3, "Missing timezone id.");
            return g0.e(b, string2, k3, 0);
        }
        IllegalArgumentException obj1 = new IllegalArgumentException("Empty key cannot be inserted.");
        throw obj1;
    }

    private static net.time4j.g1.z.g0.b e(net.time4j.g1.z.g0.b g0$b, String string2, k k3, int i4) {
        net.time4j.g1.z.g0.b bVar;
        int i;
        char c;
        net.time4j.g1.z.g0.b obj2;
        Object obj3;
        int obj5;
        char charAt = string2.charAt(i4);
        if (b == null) {
            obj2 = new g0.b(charAt, 0);
        }
        if (charAt < g0.b.a(obj2)) {
            obj2 = g0.b.f(obj2, g0.e(g0.b.b(obj2), string2, k3, i4));
        } else {
            if (charAt > g0.b.a(obj2)) {
                obj2 = g0.b.g(obj2, g0.e(g0.b.c(obj2), string2, k3, i4));
            } else {
                if (i4 < length--) {
                    obj2 = g0.b.h(obj2, g0.e(g0.b.e(obj2), string2, k3, i4++));
                } else {
                    obj2 = g0.b.i(obj2, k3);
                }
            }
        }
        return obj2;
    }

    List<k> b(String string) {
        if (string.isEmpty()) {
            return Collections.emptyList();
        }
        net.time4j.g1.z.g0.b obj3 = g0.c(this.a, string, 0);
        if (obj3 == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(g0.b.d(obj3));
    }

    String f(java.lang.CharSequence charSequence, int i2) {
        net.time4j.g1.z.g0.b bVar;
        int i;
        int i3;
        List charAt;
        char c;
        String obj7;
        bVar = this.a;
        i3 = i;
        while (bVar != null) {
            if (i < charSequence.length()) {
            }
            charAt = charSequence.charAt(i);
            if (charAt < g0.b.a(bVar)) {
            } else {
            }
            if (charAt > g0.b.a(bVar)) {
            } else {
            }
            if (g0.b.d(bVar) != null) {
            }
            bVar = g0.b.e(bVar);
            i3 = i;
            bVar = g0.b.c(bVar);
            bVar = g0.b.b(bVar);
        }
        if (i2 >= i3) {
            obj7 = "";
        } else {
            obj7 = charSequence.subSequence(i2, i3).toString();
        }
        return obj7;
    }

    public String toString() {
        String str;
        String str2;
        ArrayList arrayList = new ArrayList();
        StringBuilder stringBuilder2 = new StringBuilder();
        a(this.a, stringBuilder2, arrayList);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("count=");
        stringBuilder.append(arrayList.size());
        stringBuilder.append(",labels={");
        Iterator iterator = arrayList.iterator();
        for (String next2 : iterator) {
            stringBuilder.append(next2);
            stringBuilder.append("=>");
            stringBuilder.append(b(next2));
            stringBuilder.append(',');
        }
        stringBuilder.deleteCharAt(length--).append('}');
        return stringBuilder.toString();
    }
}
