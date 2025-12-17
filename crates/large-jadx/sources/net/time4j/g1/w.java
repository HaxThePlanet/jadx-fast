package net.time4j.g1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public abstract class w<U, S extends net.time4j.engine.j0<U>>  {

    private final List<net.time4j.g1.w.b<U>> a;

    static class a {
    }

    private static abstract class b {
        b(int i) {
            super();
        }

        abstract int a();

        abstract net.time4j.g1.w.b<U> b(int i);
    }

    private static class c extends net.time4j.g1.w.b<U> {

        private final int a;
        private final U b;
        private c(int i, int i2, U u3) {
            int obj2;
            super(i);
            if (i2 < 1) {
            } else {
                if (i2 > 9) {
                } else {
                    this.a = i2;
                    this.b = u3;
                }
            }
            StringBuilder obj4 = new StringBuilder();
            obj4.append("Fraction width out of bounds: ");
            obj4.append(i2);
            obj2 = new IllegalArgumentException(obj4.toString());
            throw obj2;
        }

        c(int i, int i2, Object object3, net.time4j.g1.w.a w$a4) {
            super(i, i2, object3);
        }

        @Override // net.time4j.g1.w$b
        int a() {
            return this.a;
        }

        net.time4j.g1.w.b<U> b(int i) {
            w.c cVar = new w.c(i, this.a, this.b);
            return cVar;
        }
    }

    private static class d extends net.time4j.g1.w.b<U> {

        private final String a;
        private d(int i, String string2) {
            super(i);
            this.a = string2;
        }

        private d(String string) {
            super(string, 0);
        }

        d(String string, net.time4j.g1.w.a w$a2) {
            super(string);
        }

        private d(String string, boolean z2) {
            boolean obj3;
            super(0);
            if (!z2) {
                if (string.isEmpty()) {
                } else {
                }
                IllegalArgumentException obj2 = new IllegalArgumentException("Literal is empty.");
                throw obj2;
            }
            this.a = string;
        }

        d(String string, boolean z2, net.time4j.g1.w.a w$a3) {
            super(string, z2);
        }

        @Override // net.time4j.g1.w$b
        int a() {
            return this.a.length();
        }

        net.time4j.g1.w.b<U> b(int i) {
            w.d dVar = new w.d(i, this.a);
            return dVar;
        }
    }

    private static class e extends net.time4j.g1.w.b<U> {

        private final int a;
        private final int b;
        private final U c;
        private e(int i, int i2, int i3, U u4) {
            int obj1;
            super(i);
            if (i2 < 1) {
            } else {
                obj1 = 18;
                if (i2 > obj1) {
                } else {
                    if (i3 < i2) {
                    } else {
                        if (i3 > obj1) {
                        } else {
                            Objects.requireNonNull(u4, "Missing unit.");
                            this.a = i2;
                            this.b = i3;
                            this.c = u4;
                        }
                        StringBuilder obj2 = new StringBuilder();
                        obj2.append("Max width out of bounds: ");
                        obj2.append(i3);
                        obj1 = new IllegalArgumentException(obj2.toString());
                        throw obj1;
                    }
                    obj1 = new IllegalArgumentException("Max width smaller than min width.");
                    throw obj1;
                }
            }
            StringBuilder obj3 = new StringBuilder();
            obj3.append("Min width out of bounds: ");
            obj3.append(i2);
            obj1 = new IllegalArgumentException(obj3.toString());
            throw obj1;
        }

        e(int i, int i2, int i3, Object object4, net.time4j.g1.w.a w$a5) {
            super(i, i2, i3, object4);
        }

        @Override // net.time4j.g1.w$b
        int a() {
            return this.a;
        }

        net.time4j.g1.w.b<U> b(int i) {
            w.e eVar = new w.e(i, this.a, this.b, this.c);
            return eVar;
        }
    }

    private static class f extends net.time4j.g1.w.b<U> {

        private final List<net.time4j.g1.w.b<U>> a;
        private f(List<net.time4j.g1.w.b<U>> list) {
            Object obj;
            int i = 0;
            super(i);
            if (list.isEmpty()) {
            } else {
                net.time4j.g1.w.g gVar = w.g.a;
                if (list.get(i) == gVar) {
                } else {
                    if (list.get(size--) == gVar) {
                    } else {
                        this.a = Collections.unmodifiableList(list);
                    }
                }
                IllegalArgumentException obj3 = new IllegalArgumentException("Optional section must not start or end with an or-operator.");
                throw obj3;
            }
            obj3 = new IllegalArgumentException("Optional section is empty.");
            throw obj3;
        }

        f(List list, net.time4j.g1.w.a w$a2) {
            super(list);
        }

        @Override // net.time4j.g1.w$b
        int a() {
            return 0;
        }

        net.time4j.g1.w.b<U> b(int i) {
            int i2;
            int i3;
            net.time4j.g1.w.b bVar;
            int obj5;
            ArrayList arrayList = new ArrayList(this.a);
            size--;
            while (i2 >= 0) {
                Object obj = arrayList.get(i2);
                arrayList.set(i2, (w.b)obj.b(obj5));
                obj5 += i3;
                i2--;
            }
            obj5 = new w.f(arrayList);
            return obj5;
        }
    }

    private static class g extends net.time4j.g1.w.b<U> {

        static final net.time4j.g1.w.g a;
        static {
            w.g gVar = new w.g();
            w.g.a = gVar;
        }

        private g() {
            super(0);
        }

        static <U> net.time4j.g1.w.b<U> c() {
            return w.g.a;
        }

        @Override // net.time4j.g1.w$b
        int a() {
            return 0;
        }

        net.time4j.g1.w.b<U> b(int i) {
            return this;
        }
    }

    private static class h extends net.time4j.g1.w.b<U> {

        private final net.time4j.g1.w.e<U> a;
        private final net.time4j.g1.w.b<U> b;
        private final net.time4j.g1.p c;
        private final Map<net.time4j.g1.n, String> d;
        private final int e;
        private h(int i, net.time4j.g1.w.e<U> w$e2, net.time4j.g1.w.b<U> w$b3, net.time4j.g1.p p4, Map<net.time4j.g1.n, String> map5, int i6) {
            super(i);
            this.a = e2;
            this.b = b3;
            this.c = p4;
            this.d = map5;
            this.e = i6;
        }

        private h(U u, String string2, net.time4j.g1.p p3, Map<net.time4j.g1.n, String> map4) {
            int obj9;
            net.time4j.g1.p obj10;
            Map obj11;
            super(0);
            super(0, 1, 18, u, 0);
            this.a = eVar;
            w.d obj8 = new w.d(string2, 1, 0);
            this.b = obj8;
            this.c = p3;
            this.d = map4;
            obj8 = map4.values().iterator();
            obj9 = Integer.MAX_VALUE;
            while (obj8.hasNext()) {
                obj10 = obj8.next();
                if ((String)obj10.length() < obj9) {
                }
                obj9 = obj10.length();
            }
            this.e = obj9;
        }

        h(Object object, String string2, net.time4j.g1.p p3, Map map4, net.time4j.g1.w.a w$a5) {
            super(object, string2, p3, map4);
        }

        @Override // net.time4j.g1.w$b
        int a() {
            return this.e;
        }

        net.time4j.g1.w.b<U> b(int i) {
            super(i, this.a, this.b, this.c, this.d, this.e);
            return hVar2;
        }
    }

    private static class i extends net.time4j.g1.w.b<U> {

        private final char a;
        private final char b;
        private i(char c, char c2) {
            super(0, c, c2);
        }

        i(char c, char c2, net.time4j.g1.w.a w$a3) {
            super(c, c2);
        }

        private i(int i, char c2, char c3) {
            super(i);
            this.a = c2;
            this.b = c3;
        }

        @Override // net.time4j.g1.w$b
        int a() {
            return 1;
        }

        net.time4j.g1.w.b<U> b(int i) {
            w.i iVar = new w.i(i, this.a, this.b);
            return iVar;
        }
    }

    private static class j extends net.time4j.g1.w.b<U> {

        private final boolean a;
        private j(int i, boolean z2) {
            super(i);
            this.a = z2;
        }

        private j(boolean z) {
            super(0);
            this.a = z;
        }

        j(boolean z, net.time4j.g1.w.a w$a2) {
            super(z);
        }

        @Override // net.time4j.g1.w$b
        int a() {
            return this.a;
        }

        net.time4j.g1.w.b<U> b(int i) {
            w.j jVar = new w.j(i, this.a);
            return jVar;
        }
    }
    static {
    }

    protected w(Class<U> class, String string2) {
        int i;
        int i4;
        String substring;
        int i2;
        int i3;
        char charAt4;
        int charAt;
        char charAt3;
        int charAt2;
        net.time4j.g1.w.i iVar;
        Object obj12;
        super();
        Objects.requireNonNull(class, "Missing unit type.");
        int obj11 = string2.length();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(arrayList2);
        int i6 = 0;
        i2 = i4;
        i3 = 1;
        while (i4 < obj11) {
            charAt4 = string2.charAt(i4);
            charAt = 39;
            if (charAt4 == 91) {
            } else {
            }
            if (charAt4 == 93) {
            } else {
            }
            charAt = 44;
            charAt3 = 46;
            charAt2 = 0;
            if (charAt4 == charAt3) {
            } else {
            }
            if (charAt4 == charAt) {
            } else {
            }
            if (charAt4 == 45) {
            } else {
            }
            if (charAt4 == 43) {
            } else {
            }
            if (charAt4 == 123) {
            } else {
            }
            if (charAt4 == 124) {
            } else {
            }
            a(charAt4, arrayList);
            i4 += i3;
            i3 = 1;
            w.h(arrayList).add(w.g.c());
            i4++;
            charAt4 = i8;
            while (charAt4 < obj11) {
                if (string2.charAt(charAt4) != 125) {
                }
                charAt4++;
            }
            c(string2.substring(i8, charAt4), arrayList);
            i4 = charAt4;
            if (string2.charAt(charAt4) != 125) {
            }
            charAt4++;
            charAt = new w.j(i3, charAt2);
            w.h(arrayList).add(charAt);
            charAt = new w.j(i6, charAt2);
            w.h(arrayList).add(charAt);
            iVar = new w.i(charAt, charAt3, charAt2);
            w.h(arrayList).add(iVar);
            iVar = new w.i(charAt3, charAt, charAt2);
            w.h(arrayList).add(iVar);
            w.e(arrayList);
            w.i(arrayList);
            i4++;
            charAt4 = substring;
            while (charAt4 < obj11) {
                if (string2.charAt(charAt4) == charAt) {
                } else {
                }
                charAt4 += i3;
                charAt3 = charAt4 + 1;
                if (charAt3 < obj11) {
                }
                if (string2.charAt(charAt3) == charAt) {
                }
                charAt4 = charAt3;
            }
            if (substring == charAt4) {
            } else {
            }
            b(string2.substring(substring, charAt4).replace("''", "'"), arrayList);
            a(charAt, arrayList);
            if (string2.charAt(charAt4) == charAt) {
            } else {
            }
            charAt4 += i3;
            charAt3 = charAt4 + 1;
            if (charAt3 < obj11) {
            }
            if (string2.charAt(charAt3) == charAt) {
            }
            charAt4 = charAt3;
            charAt = i4 + 1;
            while (charAt < obj11) {
                if (string2.charAt(charAt) == charAt4) {
                }
                charAt++;
            }
            d(charAt4, charAt - i4, i2, arrayList);
            i4 = charAt + -1;
            i2 = i6;
            if (string2.charAt(charAt) == charAt4) {
            }
            charAt++;
            i2++;
        }
        if (arrayList.size() > i3) {
        } else {
            if (arrayList.isEmpty()) {
            } else {
                obj11 = arrayList.get(i6);
                if ((List)obj11.isEmpty()) {
                } else {
                    net.time4j.g1.w.g gVar = w.g.a;
                    if (obj11.get(i6) == gVar) {
                    } else {
                        if (obj11.get(obj12 -= i3) == gVar) {
                        } else {
                            obj12 = obj11.size();
                            i = (w.b)obj11.get(obj12 + -1).a();
                            obj12 += -2;
                            while (obj12 >= 0) {
                                i4 = obj11.get(obj12);
                                if ((w.b)i4 == w.g.a) {
                                } else {
                                }
                                obj11.set(obj12, (w.b)i4.b(i));
                                i += i4;
                                obj12--;
                                i = i6;
                            }
                            this.a = Collections.unmodifiableList(obj11);
                        }
                    }
                    obj11 = new IllegalArgumentException("Pattern must not start or end with an or-operator.");
                    throw obj11;
                }
                obj11 = new IllegalArgumentException("Missing format pattern.");
                throw obj11;
            }
            obj11 = new IllegalArgumentException("Empty or invalid pattern.");
            throw obj11;
        }
        obj11 = new IllegalArgumentException("Open square bracket without closing one.");
        throw obj11;
    }

    private void a(char c, List<List<net.time4j.g1.w.b<U>>> list2) {
        b(String.valueOf(c), list2);
    }

    private void b(String string, List<List<net.time4j.g1.w.b<U>>> list2) {
        w.d dVar = new w.d(string, 0);
        w.h(list2).add(dVar);
    }

    private void c(String string, List<List<net.time4j.g1.w.b<U>>> list2) {
        int length2;
        int i;
        Locale locale;
        net.time4j.g1.k cARDINALS;
        int length;
        int i2;
        String length3;
        String[] split = string.split(":");
        final String str6 = "Plural information has wrong format: ";
        if (split.length > 9) {
        } else {
            if (split.length < 4) {
            } else {
                int i4 = 0;
                final int i6 = 1;
                if (split[i4].length() != i6) {
                } else {
                    int i5 = 2;
                    String[] split2 = split[i5].split("-|_");
                    String str12 = split2[i4];
                    if (split2.length > i6) {
                        length = split2[i6];
                        if (split2.length > i5) {
                            if (split2.length > 3) {
                            } else {
                                locale = new Locale(str12, length, split2[i5]);
                            }
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Plural information has wrong locale: ");
                            stringBuilder.append(string);
                            IllegalArgumentException obj13 = new IllegalArgumentException(stringBuilder.toString());
                            throw obj13;
                        }
                        locale = new Locale(str12, length);
                    } else {
                        locale = new Locale(str12);
                    }
                    EnumMap enumMap = new EnumMap(n.class);
                    for (Object str10 : obj0) {
                        String[] split3 = str10.split("=");
                        enumMap.put(n.valueOf(split3[i4]), split3[i6]);
                    }
                    if (enumMap.isEmpty()) {
                    } else {
                        if (!enumMap.containsKey(n.OTHER)) {
                        } else {
                            super(f(split[i4].charAt(i4)), split[i6], p.g(locale, k.CARDINALS), enumMap, 0);
                            w.h(list2).add(obj13);
                        }
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append("Missing plural category OTHER: ");
                        stringBuilder3.append(string);
                        obj13 = new IllegalArgumentException(stringBuilder3.toString());
                        throw obj13;
                    }
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append("Missing plural forms: ");
                    stringBuilder4.append(string);
                    obj13 = new IllegalArgumentException(stringBuilder4.toString());
                    throw obj13;
                }
                StringBuilder stringBuilder5 = new StringBuilder();
                stringBuilder5.append("Plural information has wrong symbol: ");
                stringBuilder5.append(string);
                obj13 = new IllegalArgumentException(stringBuilder5.toString());
                throw obj13;
            }
        }
        StringBuilder stringBuilder6 = new StringBuilder();
        stringBuilder6.append(str6);
        stringBuilder6.append(string);
        obj13 = new IllegalArgumentException(stringBuilder6.toString());
        throw obj13;
    }

    private void d(char c, int i2, int i3, List<List<net.time4j.g1.w.b<U>>> list4) {
        int i;
        int i7;
        int i6;
        int i4;
        int i5;
        Object obj7;
        net.time4j.g1.w.c obj9;
        final Object obj10 = list4.get(size--);
        if (c == 102) {
            if (i3 > 0) {
            } else {
                obj9 = new w.c(0, i2, f(c), 0);
                (List)obj10.add(obj9);
            }
            obj7 = new IllegalArgumentException("Combination of # and f-symbol not allowed.");
            throw obj7;
        }
        super(0, i2, i2 + i3, f(c), 0);
        obj10.add(obj7);
    }

    private static <U> void e(List<List<net.time4j.g1.w.b<U>>> list) {
        int i3 = 1;
        size -= i3;
        if (i < i3) {
        } else {
            w.f fVar = new w.f((List)list.remove(i), 0);
            (List)list.get(i -= i3).add(fVar);
        }
        IllegalArgumentException obj3 = new IllegalArgumentException("Closing square bracket without open one.");
        throw obj3;
    }

    private static boolean g(char c) {
        int i;
        int obj1;
        if (c >= 65) {
            if (c > 90) {
                if (c >= 97 && c <= 122) {
                    obj1 = c <= 122 ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return obj1;
    }

    private static <U> List<net.time4j.g1.w.b<U>> h(List<List<net.time4j.g1.w.b<U>>> list) {
        return (List)list.get(size--);
    }

    private static <U> void i(List<List<net.time4j.g1.w.b<U>>> list) {
        ArrayList arrayList = new ArrayList();
        list.add(arrayList);
    }

    protected abstract U f(char c);
}
