package net.time4j;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import net.time4j.engine.c;
import net.time4j.engine.d;
import net.time4j.engine.e;
import net.time4j.engine.i0;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.r;
import net.time4j.engine.s;
import net.time4j.engine.w;
import net.time4j.engine.y;
import net.time4j.g1.a;
import net.time4j.g1.b;
import net.time4j.g1.m;
import net.time4j.g1.t;
import net.time4j.g1.v;

/* loaded from: classes3.dex */
public final class l {

    private static final SortedMap<net.time4j.h0, String> d;
    private static net.time4j.l e;
    private static final c<net.time4j.l> f;
    private final transient Locale a;
    private final transient String b;
    private final transient SortedMap<net.time4j.h0, String> c;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            l.a.a = iArr;
            iArr[v.WIDE.ordinal()] = 1;
            l.a.a[v.NARROW.ordinal()] = 2;
        }
    }

    static class c implements r {
        private static net.time4j.l e(Locale locale, d d2) {
            if (d2.c(l.b())) {
                return (l)d2.b(l.b());
            }
            return l.r(locale, (String)d2.a(a.b, "iso8601"));
        }

        private static int f(q<?> q) {
            net.time4j.l0 l0Var;
            boolean z;
            int obj2;
            net.time4j.c cVar = h0.J;
            if (q.v(cVar)) {
                if ((Integer)q.p(cVar).intValue() == 12) {
                    obj2 = 0;
                }
            } else {
                l0Var = h0.L;
                if (q.v(l0Var)) {
                    obj2 = (Integer)q.p(l0Var).intValue();
                } else {
                    obj2 = -1;
                }
            }
            return obj2;
        }

        public boolean a(p<?> p) {
            return p instanceof l.b;
        }

        public q<?> b(q<?> q, Locale locale2, d d3) {
            q qVar;
            q qVar2;
            net.time4j.c1 c1Var;
            Object equals;
            boolean z2;
            net.time4j.l.b bVar;
            int i4;
            String substring;
            Object z3;
            String str;
            int startsWith;
            boolean z;
            int i2;
            int i6;
            int i5;
            int i3;
            int i;
            boolean iterator;
            boolean next;
            boolean equals2;
            net.time4j.h0 h0Var;
            qVar2 = q;
            if (!qVar2.v(h0.H) && !qVar2.v(h0.N) && !qVar2.v(h0.M)) {
                if (!qVar2.v(h0.N)) {
                    if (!qVar2.v(h0.M)) {
                        if (qVar2.v(h0.K)) {
                        } else {
                            z2 = l.c.e(locale2, d3);
                            i4 = 0;
                            bVar = new l.b(i4, z2);
                            str = "midnight";
                            if (qVar2.v(bVar)) {
                                z3 = qVar2.p(bVar);
                                i6 = i4;
                                i5 = 0;
                                int indexOf = (String)z3.indexOf(124, i4);
                                i = -1;
                                while (indexOf == i) {
                                    substring = z3.substring(i4);
                                    indexOf++;
                                    if (l.c(z2) && i5 == 0) {
                                    } else {
                                    }
                                    iterator = l.d(z2).keySet().iterator();
                                    while (iterator.hasNext()) {
                                        next = iterator.next();
                                        if ((String)l.d(z2).get((h0)next).equals(substring)) {
                                        }
                                        startsWith = 1;
                                        equals2 = l.c.f(q);
                                        h0Var = z2.m(next);
                                        int i7 = 12;
                                        if (next.s() >= i7) {
                                        } else {
                                        }
                                        if (!h0Var.z0(h0.I0(i7))) {
                                        } else {
                                        }
                                        if (equals2 != i) {
                                        } else {
                                        }
                                        startsWith = 0;
                                        if (startsWith != null) {
                                        }
                                        if (i5 != 0 && i5 != startsWith) {
                                        } else {
                                        }
                                        i5 = startsWith;
                                        if (i5 != startsWith) {
                                        } else {
                                        }
                                        if (equals2 == i) {
                                        } else {
                                        }
                                        i2 = 6;
                                        if (substring.startsWith("night")) {
                                        } else {
                                        }
                                        if (substring.startsWith("afternoon") != null) {
                                        } else {
                                        }
                                        i5 = 0;
                                        if (equals2 < i2) {
                                        } else {
                                        }
                                        startsWith = a0.AM;
                                        startsWith = a0.PM;
                                        if (equals2 < i2) {
                                        } else {
                                        }
                                        startsWith = a0.PM;
                                        startsWith = a0.AM;
                                        if (equals2 >= next.s()) {
                                        } else {
                                        }
                                        startsWith = a0.PM;
                                        startsWith = a0.AM;
                                        startsWith = a0.AM;
                                        if (!h0Var.z0(next)) {
                                        } else {
                                        }
                                        startsWith = a0.PM;
                                        if (h0Var.E0(h0.H0())) {
                                        } else {
                                        }
                                        if (equals2 != i) {
                                        } else {
                                        }
                                        if (equals2 + 12 >= next.s()) {
                                        } else {
                                        }
                                        startsWith = a0.AM;
                                        startsWith = a0.PM;
                                    }
                                    if (i3 > 0) {
                                    }
                                    i4 = i3;
                                    startsWith = 1;
                                    indexOf = z3.indexOf(124, i4);
                                    i = -1;
                                    substring = z3.substring(i4, indexOf);
                                    next = iterator.next();
                                    if ((String)l.d(z2).get((h0)next).equals(substring)) {
                                    }
                                    startsWith = 1;
                                    equals2 = l.c.f(q);
                                    h0Var = z2.m(next);
                                    i7 = 12;
                                    if (next.s() >= i7) {
                                    } else {
                                    }
                                    if (!h0Var.z0(h0.I0(i7))) {
                                    } else {
                                    }
                                    if (equals2 != i) {
                                    } else {
                                    }
                                    startsWith = 0;
                                    if (startsWith != null) {
                                    }
                                    if (i5 != 0 && i5 != startsWith) {
                                    } else {
                                    }
                                    i5 = startsWith;
                                    if (i5 != startsWith) {
                                    } else {
                                    }
                                    if (equals2 == i) {
                                    } else {
                                    }
                                    i2 = 6;
                                    if (substring.startsWith("night")) {
                                    } else {
                                    }
                                    if (substring.startsWith("afternoon") != null) {
                                    } else {
                                    }
                                    i5 = 0;
                                    if (equals2 < i2) {
                                    } else {
                                    }
                                    startsWith = a0.AM;
                                    startsWith = a0.PM;
                                    if (equals2 < i2) {
                                    } else {
                                    }
                                    startsWith = a0.PM;
                                    startsWith = a0.AM;
                                    if (equals2 >= next.s()) {
                                    } else {
                                    }
                                    startsWith = a0.PM;
                                    startsWith = a0.AM;
                                    startsWith = a0.AM;
                                    if (!h0Var.z0(next)) {
                                    } else {
                                    }
                                    startsWith = a0.PM;
                                    if (h0Var.E0(h0.H0())) {
                                    } else {
                                    }
                                    if (equals2 != i) {
                                    } else {
                                    }
                                    if (equals2 + 12 >= next.s()) {
                                    } else {
                                    }
                                    startsWith = a0.AM;
                                    startsWith = a0.PM;
                                    if (i5 == 0) {
                                    } else {
                                    }
                                    if (substring.equals(str)) {
                                    } else {
                                    }
                                    if (substring.equals("noon")) {
                                    } else {
                                    }
                                    substring = a0.PM;
                                    i5 = substring;
                                    substring = a0.AM;
                                }
                                if (i5 != 0 && i6 += startsWith > 1) {
                                    if (i6 += startsWith > 1) {
                                        qVar2 = qVar2.G(h0.I, i5).G(bVar, 0);
                                    }
                                }
                            } else {
                                bVar = new l.b(1, z2);
                                if (qVar2.v(bVar)) {
                                    equals = qVar2.p(bVar);
                                    if (!(String)equals.equals("am")) {
                                        if (equals.equals(str)) {
                                            qVar = qVar2.G(h0.I, a0.AM);
                                        } else {
                                            qVar = qVar2.G(h0.I, a0.PM);
                                        }
                                    } else {
                                    }
                                    qVar2 = qVar.G(bVar, 0);
                                }
                            }
                        }
                    }
                }
            }
            return qVar2;
        }

        public Set<p<?>> c(Locale locale, d d2) {
            c cVar;
            boolean obj5;
            net.time4j.l obj4 = l.c.e(locale, d2);
            HashSet hashSet = new HashSet();
            l.b bVar = new l.b(0, obj4);
            hashSet.add(bVar);
            if (!d2.c(l.b())) {
                obj5 = new l.b(1, obj4);
                hashSet.add(obj5);
            }
            return Collections.unmodifiableSet(hashSet);
        }

        public boolean d(Class<?> class) {
            return h0.class.isAssignableFrom(class);
        }
    }

    private class d implements s<o, String> {

        private final boolean a;
        private final v b;
        private final m c;
        final net.time4j.l d;
        d(net.time4j.l l, boolean z2, v v3, m m4) {
            this.d = l;
            super();
            Objects.requireNonNull(v3, "Missing text width.");
            Objects.requireNonNull(m4, "Missing output context.");
            this.a = z2;
            this.b = v3;
            this.c = m4;
        }

        @Override // net.time4j.engine.s
        public String a(o o) {
            Object map;
            Locale rOOT;
            String equals2;
            boolean key2;
            Object str;
            String equals;
            boolean key;
            String str2;
            boolean key3;
            Object obj8 = o.p(h0.H);
            net.time4j.l lVar = this.d;
            rOOT = l.h(lVar);
            str = "noon";
            equals = "midnight";
            equals2 = l.e((h0)obj8);
            map = l.f(rOOT, l.i(lVar));
            if (this.a && l.c(lVar) && !map.containsKey(l.g(map, this.b, this.c, equals2))) {
                equals2 = l.e(obj8);
                if (l.c(lVar)) {
                    map = l.f(rOOT, l.i(lVar));
                    if (!map.containsKey(l.g(map, this.b, this.c, equals2))) {
                        if (equals2.equals(equals)) {
                            str2 = l.g(map, this.b, this.c, "am");
                        } else {
                            if (equals2.equals(str)) {
                                str2 = l.g(map, this.b, this.c, "pm");
                            }
                        }
                    }
                    if (map.containsKey(str2)) {
                        return (String)map.get(str2);
                    }
                    if (rOOT == null) {
                        rOOT = Locale.ROOT;
                    }
                    return (a0)obj8.p(h0.I).getDisplayName(rOOT);
                }
                return equals2;
            }
            if (l.c(lVar)) {
                key2 = l.f(rOOT, l.i(lVar));
                if (obj8.D0()) {
                    str = l.g(key2, this.b, this.c, equals);
                    if (key2.containsKey(str)) {
                        return (String)key2.get(str);
                    }
                } else {
                    str = l.g(key2, this.b, this.c, str);
                    if (obj8.E0(h0.I0(12)) && key2.containsKey(str)) {
                        str = l.g(key2, this.b, this.c, str);
                        if (key2.containsKey(str)) {
                            return (String)key2.get(str);
                        }
                    }
                }
                map = l.g(key2, this.b, this.c, (String)l.d(lVar).get(lVar.o(obj8)));
                if (key2.containsKey(map)) {
                    return (String)key2.get(map);
                }
            }
            return (String)l.d(lVar).get(lVar.o(obj8));
        }

        @Override // net.time4j.engine.s
        public Object apply(Object object) {
            return a((o)object);
        }
    }

    static class b extends e<String> implements t<String>, y<q<?>, String> {

        private static final long serialVersionUID = 5589976208326940032L;
        private final transient boolean a;
        private final transient net.time4j.l b;
        b(boolean z, Locale locale2, String string3) {
            super(z, l.r(locale2, string3));
        }

        b(boolean z, net.time4j.l l2) {
            String str;
            str = z ? "FIXED_DAY_PERIOD" : "APPROXIMATE_DAY_PERIOD";
            super(str);
            this.a = z;
            this.b = l2;
        }

        private String D(java.lang.CharSequence charSequence, ParsePosition parsePosition2, d d3, m m4) {
            Object obj2;
            Object obj3;
            String str6;
            Object str3;
            m stringBuilder2;
            Iterator iterator;
            boolean z;
            int stringBuilder;
            String str5;
            int i4;
            String charAt;
            java.util.Collection values;
            int string;
            String str2;
            int index;
            int i2;
            int i;
            boolean equals;
            Iterator it;
            int i5;
            int i3;
            String str4;
            String str;
            final Object obj = this;
            obj2 = parsePosition2;
            Object obj4 = d3;
            stringBuilder2 = m4;
            ArrayList arrayList = new ArrayList();
            final String str7 = "noon";
            final String str8 = "midnight";
            if (obj.a) {
                arrayList.add("am");
                arrayList.add("pm");
                arrayList.add(str8);
                arrayList.add(str7);
            } else {
                LinkedHashSet linkedHashSet = new LinkedHashSet(l.d(obj.b).values());
                arrayList.addAll(linkedHashSet);
                if (l.c(obj.b)) {
                    arrayList.add(str8);
                    arrayList.add(str7);
                }
            }
            if (l.c(obj.b)) {
                stringBuilder = l.f(w(), l());
            } else {
                stringBuilder = 0;
            }
            Object obj8 = obj4.a(a.g, v.WIDE);
            index = parsePosition2.getIndex();
            iterator = arrayList.iterator();
            string = 0;
            i2 = 0;
            while (iterator.hasNext()) {
                Object obj6 = equals;
                if (l.c(obj.b)) {
                } else {
                }
                str3 = obj6;
                if (str3 != null) {
                } else {
                }
                i = stringBuilder;
                str4 = str5;
                str = charAt;
                obj2 = parsePosition2;
                stringBuilder2 = m4;
                stringBuilder = i;
                iterator = it;
                str5 = str4;
                charAt = str;
                stringBuilder2 = str3.length();
                i = stringBuilder;
                i3 = index;
                stringBuilder = 0;
                i5 = 1;
                while (i5 != 0) {
                    if (stringBuilder < stringBuilder2) {
                    }
                    i4 = index + stringBuilder;
                    if (i4 >= charSequence.length()) {
                    } else {
                    }
                    str = charAt;
                    char charAt2 = charSequence.charAt(i4);
                    charAt = str3.charAt(stringBuilder);
                    if ((Boolean)obj4.a(a.i, Boolean.TRUE).booleanValue()) {
                    } else {
                    }
                    if (charAt2 == charAt) {
                    } else {
                    }
                    i4 = 0;
                    if (i4 != 0) {
                    }
                    i5 = i4;
                    stringBuilder++;
                    str5 = str4;
                    charAt = str;
                    i3++;
                    i4 = 1;
                    i4 = obj.k(charAt2, charAt);
                    str = charAt;
                    i5 = 0;
                }
                str4 = str5;
                str = charAt;
                str3 = "|";
                if (!(Boolean)obj4.a(a.j, Boolean.FALSE).booleanValue()) {
                } else {
                }
                stringBuilder2 = i3 - index;
                if (i2 < stringBuilder2) {
                } else {
                }
                if (string != null && i2 == stringBuilder2) {
                }
                if (i2 == stringBuilder2) {
                }
                if (obj.a) {
                } else {
                }
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(string);
                stringBuilder2.append(str3);
                stringBuilder2.append((String)obj6);
                string = stringBuilder2.toString();
                string = 0;
                i2 = stringBuilder2;
                string = obj6;
                if (stringBuilder2 == 1) {
                } else {
                }
                if (i5 != 0) {
                }
                if (string == null) {
                } else {
                }
                if (obj.a) {
                } else {
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(str3);
                stringBuilder.append(obj6);
                string = stringBuilder.toString();
                i2 = stringBuilder2;
                i2 = stringBuilder2;
                if (stringBuilder < stringBuilder2) {
                }
                i4 = index + stringBuilder;
                if (i4 >= charSequence.length()) {
                } else {
                }
                str = charAt;
                charAt2 = charSequence.charAt(i4);
                charAt = str3.charAt(stringBuilder);
                if ((Boolean)obj4.a(a.i, Boolean.TRUE).booleanValue()) {
                } else {
                }
                if (charAt2 == charAt) {
                } else {
                }
                i4 = 0;
                if (i4 != 0) {
                }
                i5 = i4;
                stringBuilder++;
                str5 = str4;
                charAt = str;
                i3++;
                i4 = 1;
                i4 = obj.k(charAt2, charAt);
                str = charAt;
                i5 = 0;
                if (obj.a) {
                } else {
                }
                str6 = l.g(stringBuilder, (v)obj8, stringBuilder2, obj6);
                if (stringBuilder.containsKey(str6)) {
                } else {
                }
                str3 = 0;
                str3 = stringBuilder.get(str6);
                if (!stringBuilder.containsKey(l.g(stringBuilder, obj8, stringBuilder2, obj6))) {
                }
                if (obj6.equals(str8)) {
                } else {
                }
                if (obj6.equals(str7)) {
                }
                str6 = l.g(stringBuilder, obj8, stringBuilder2, str5);
                str6 = l.g(stringBuilder, obj8, stringBuilder2, charAt);
            }
            if (string == null) {
                parsePosition2.setErrorIndex(index);
            } else {
                parsePosition2.setIndex(index += i2);
            }
            return string;
        }

        private boolean k(char c, char c2) {
            int i;
            int obj4;
            int obj5;
            i = 122;
            final int i2 = 65;
            final int i3 = 97;
            if (c >= i3 && c <= i) {
                if (c <= i) {
                    obj4 = (char)obj4;
                }
            }
            if (c2 >= i3 && c2 <= i) {
                if (c2 <= i) {
                    obj5 = (char)obj5;
                }
            }
            if (obj4 >= i2 && obj4 <= 90) {
                if (obj4 <= 90) {
                    obj4 = obj4 == obj5 ? 1 : 0;
                    return obj4;
                }
            }
            Locale locale = w();
            return String.valueOf(obj4).toUpperCase(locale).equals(String.valueOf(obj5).toUpperCase(locale));
        }

        private void readObject(ObjectInputStream objectInputStream) {
            InvalidObjectException obj2 = new InvalidObjectException("Serialization proxy required.");
            throw obj2;
        }

        private Object writeReplace() {
            SPX spx = new SPX(this, 7);
            return spx;
        }

        @Override // net.time4j.engine.e
        boolean A() {
            return this.a;
        }

        public boolean B(q<?> q, String string2) {
            return 0;
        }

        @Override // net.time4j.engine.e
        public String C(java.lang.CharSequence charSequence, ParsePosition parsePosition2, d d3) {
            m sTANDALONE;
            String str;
            boolean booleanValue;
            Boolean tRUE;
            sTANDALONE = m.FORMAT;
            Object obj = d3.a(a.h, sTANDALONE);
            parsePosition2.setErrorIndex(-1);
            parsePosition2.setIndex(parsePosition2.getIndex());
            if (D(charSequence, parsePosition2, d3, (m)obj) == null && (Boolean)d3.a(a.k, Boolean.TRUE).booleanValue() && obj == sTANDALONE) {
                if ((Boolean)d3.a(a.k, Boolean.TRUE).booleanValue()) {
                    parsePosition2.setErrorIndex(-1);
                    parsePosition2.setIndex(index);
                    if (obj == sTANDALONE) {
                        sTANDALONE = m.STANDALONE;
                    }
                    str = D(charSequence, parsePosition2, d3, sTANDALONE);
                }
            }
            return str;
        }

        public q<?> E(q<?> q, String string2, boolean z3) {
            IllegalArgumentException obj1 = new IllegalArgumentException("Day period element cannot be set.");
            throw obj1;
        }

        protected <T extends q<T>> y<T, String> d(w<T> w) {
            if (w.w(h0.H)) {
                return this;
            }
            return 0;
        }

        protected boolean e(e<?> e) {
            return this.b.equals(e.b);
        }

        @Override // net.time4j.engine.e
        public p getChildAtCeiling(Object object) {
            return n((q)object);
        }

        @Override // net.time4j.engine.e
        public p getChildAtFloor(Object object) {
            return o((q)object);
        }

        @Override // net.time4j.engine.e
        public Object getDefaultMaximum() {
            return u();
        }

        @Override // net.time4j.engine.e
        public Object getDefaultMinimum() {
            return v();
        }

        @Override // net.time4j.engine.e
        public Object getMaximum(Object object) {
            return x((q)object);
        }

        @Override // net.time4j.engine.e
        public Object getMinimum(Object object) {
            return y((q)object);
        }

        @Override // net.time4j.engine.e
        public char getSymbol() {
            int i;
            i = this.a ? 98 : 66;
            return i;
        }

        public Class<String> getType() {
            return String.class;
        }

        @Override // net.time4j.engine.e
        public Object getValue(Object object) {
            return z((q)object);
        }

        @Override // net.time4j.engine.e
        public boolean isDateElement() {
            return 0;
        }

        @Override // net.time4j.engine.e
        public boolean isTimeElement() {
            return 1;
        }

        @Override // net.time4j.engine.e
        public boolean isValid(Object object, Object object2) {
            return B((q)object, (String)object2);
        }

        @Override // net.time4j.engine.e
        String l() {
            return l.i(this.b);
        }

        public p<?> n(q<?> q) {
            return 0;
        }

        public p<?> o(q<?> q) {
            return 0;
        }

        @Override // net.time4j.engine.e
        public Object parse(java.lang.CharSequence charSequence, ParsePosition parsePosition2, d d3) {
            return C(charSequence, parsePosition2, d3);
        }

        @Override // net.time4j.engine.e
        public void print(o o, java.lang.Appendable appendable2, d d3) {
            net.time4j.l lVar;
            Object obj4;
            s obj6;
            Object obj = d3.a(a.g, v.WIDE);
            obj6 = d3.a(a.h, m.FORMAT);
            if (this.a) {
                obj4 = this.b.l((v)obj, (m)obj6).apply(o);
            } else {
                obj4 = this.b.j(obj, obj6).apply(o);
            }
            appendable2.append(obj4);
        }

        @Override // net.time4j.engine.e
        Object r() {
            return l.d(this.b);
        }

        @Override // net.time4j.engine.e
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(32);
            stringBuilder.append(name());
            stringBuilder.append('@');
            stringBuilder.append(this.b);
            return stringBuilder.toString();
        }

        @Override // net.time4j.engine.e
        public String u() {
            if (this.a) {
                return "pm";
            }
            return (String)l.d(this.b).get((h0)l.d(this.b).lastKey());
        }

        @Override // net.time4j.engine.e
        public String v() {
            if (this.a) {
                return "am";
            }
            return (String)l.d(this.b).get((h0)l.d(this.b).firstKey());
        }

        @Override // net.time4j.engine.e
        Locale w() {
            return l.h(this.b);
        }

        @Override // net.time4j.engine.e
        public Object withValue(Object object, Object object2, boolean z3) {
            E((q)object, (String)object2, z3);
            throw 0;
        }

        public String x(q<?> q) {
            return u();
        }

        public String y(q<?> q) {
            return v();
        }

        public String z(q<?> q) {
            boolean key;
            int str;
            boolean z;
            m fORMAT;
            Object obj5 = q.p(h0.H);
            if (this.a) {
                return l.e((h0)obj5);
            }
            if (l.c(this.b)) {
                key = l.f(w(), l());
                str = 0;
                if (obj5.D0()) {
                    str = "midnight";
                } else {
                    if (obj5.E0(h0.I0(12))) {
                        str = "noon";
                    }
                }
                if (str != null && key.containsKey(l.g(key, v.ABBREVIATED, m.FORMAT, str))) {
                    if (key.containsKey(l.g(key, v.ABBREVIATED, m.FORMAT, str))) {
                        return str;
                    }
                }
            }
            return (String)l.d(this.b).get(this.b.o(obj5));
        }
    }
    static {
        TreeMap treeMap = new TreeMap();
        treeMap.put(h0.H0(), "am");
        treeMap.put(h0.I0(12), "pm");
        SortedMap unmodifiableSortedMap = Collections.unmodifiableSortedMap(treeMap);
        l.d = unmodifiableSortedMap;
        l lVar = new l(Locale.ROOT, "iso8601", unmodifiableSortedMap);
        l.e = lVar;
        l.f = a.e("CUSTOM_DAY_PERIOD", l.class);
    }

    private l(Locale locale, String string2, SortedMap<net.time4j.h0, String> sortedMap3) {
        super();
        this.a = locale;
        this.b = string2;
        this.c = Collections.unmodifiableSortedMap(sortedMap3);
    }

    private static boolean a(String string) {
        int i;
        char charAt;
        int i2;
        boolean obj4;
        final int i3 = 1;
        if (string.charAt(0) == 84 && string.length() == 5 && Character.isDigit(string.charAt(i3))) {
            if (string.length() == 5) {
                if (Character.isDigit(string.charAt(i3))) {
                    i = i3;
                }
            }
        }
        return i;
    }

    static c b() {
        return l.f;
    }

    static boolean c(net.time4j.l l) {
        return l.p();
    }

    static SortedMap d(net.time4j.l l) {
        return l.c;
    }

    static String e(net.time4j.h0 h0) {
        return l.n(h0);
    }

    static Map f(Locale locale, String string2) {
        return l.q(locale, string2);
    }

    static String g(Map map, v v2, m m3, String string4) {
        return l.k(map, v2, m3, string4);
    }

    static Locale h(net.time4j.l l) {
        return l.a;
    }

    static String i(net.time4j.l l) {
        return l.b;
    }

    private static String k(Map<String, String> map, v v2, m m3, String string4) {
        String string;
        boolean aBBREVIATED;
        v obj3;
        m obj4;
        if (v2 == v.SHORT) {
            obj3 = v.ABBREVIATED;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(l.t(obj3, m3));
        stringBuilder.append(string4);
        if (!map.containsKey(stringBuilder.toString())) {
            if (m3 == m.STANDALONE) {
                v aBBREVIATED2 = v.ABBREVIATED;
                if (obj3 == aBBREVIATED2) {
                    string = l.k(map, obj3, m.FORMAT, string4);
                } else {
                    string = l.k(map, aBBREVIATED2, m3, string4);
                }
            } else {
                aBBREVIATED = v.ABBREVIATED;
                if (obj3 != aBBREVIATED) {
                    string = l.k(map, aBBREVIATED, m3, string4);
                }
            }
        }
        return string;
    }

    private static String n(net.time4j.h0 h0) {
        net.time4j.l0 l0Var;
        int obj1 = (Integer)h0.p(h0.P).intValue();
        if (obj1 != null) {
            if (obj1 == 1440) {
            } else {
                int i = 720;
                if (obj1 < i) {
                    return "am";
                }
                if (obj1 == i) {
                    return "noon";
                }
            }
            return "pm";
        }
        return "midnight";
    }

    private boolean p() {
        int i;
        i = this.a != null ? 1 : 0;
        return i;
    }

    private static Map<String, String> q(Locale locale, String string2) {
        Map map;
        String str;
        Object obj2;
        boolean obj3;
        if (!string2.equals("iso8601") && !"true".equals(b.c(string2, locale).m().get("hasDayPeriods"))) {
            if (!"true".equals(map.get("hasDayPeriods"))) {
                map = b.d(locale).m();
            }
        }
        return map;
    }

    static net.time4j.l r(Locale locale, String string2) {
        String language;
        boolean equals;
        String str;
        Iterator iterator;
        Object next;
        boolean equals2;
        boolean int;
        int int2;
        net.time4j.h0 h0Var;
        String mINUTES;
        int i;
        Locale obj10;
        language = locale.getLanguage();
        if (language.equals("nn")) {
            obj10 = new Locale("nb");
        }
        Map map = l.q(obj10, string2);
        TreeMap treeMap = new TreeMap();
        iterator = map.keySet().iterator();
        for (String next : iterator) {
            int i5 = 3;
            int = Integer.parseInt(next.substring(1, i5));
            int2 = Integer.parseInt(next.substring(i5, 5));
            mINUTES = "Invalid time key: ";
            i = 24;
            h0Var = int;
            treeMap.put(h0Var, map.get(next));
        }
        if (!treeMap.isEmpty()) {
            if (language.isEmpty()) {
            } else {
                Iterator iterator2 = treeMap.keySet().iterator();
                str = "";
                while (iterator2.hasNext()) {
                    iterator = treeMap.get((h0)iterator2.next());
                    if ((String)iterator.equals(str)) {
                    } else {
                    }
                    str = iterator;
                    iterator2.remove();
                }
            }
            l lVar = new l(obj10, string2, treeMap);
            return lVar;
        }
        return l.e;
    }

    public static net.time4j.l s(Map<net.time4j.h0, String> map) {
        boolean empty;
        int i2;
        int i;
        if (map.isEmpty()) {
        } else {
            TreeMap treeMap = new TreeMap(map);
            Iterator iterator = map.keySet().iterator();
            for (h0 empty : iterator) {
                treeMap.put(h0.H0(), map.get(empty));
                treeMap.remove(empty);
            }
            l obj5 = new l(0, "", treeMap);
            return obj5;
        }
        obj5 = new IllegalArgumentException("Label map is empty.");
        throw obj5;
    }

    private static String t(v v, m m2) {
        int i;
        int obj1;
        obj1 = l.a.a[v.ordinal()];
        if (obj1 != 1) {
            obj1 = obj1 != 2 ? 97 : 110;
        } else {
            obj1 = 119;
        }
        if (m2 == m.STANDALONE) {
            obj1 = Character.toUpperCase(obj1);
        }
        StringBuilder obj2 = new StringBuilder();
        obj2.append("P(");
        obj2.append(obj1);
        obj2.append(")_");
        return obj2.toString();
    }

    public boolean equals(Object object) {
        int i;
        boolean equals;
        boolean equals2;
        Locale locale;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof l) {
            Locale locale2 = this.a;
            if (locale2 == null) {
                if (object.a != null) {
                    return i2;
                }
            } else {
                if (!locale2.equals(object.a)) {
                    return i2;
                }
            }
            if (this.c.equals(object.c) && this.b.equals(object.b)) {
                if (this.b.equals(object.b)) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public s<o, String> j(v v, m m2) {
        l.d dVar = new l.d(this, 0, v, m2);
        return dVar;
    }

    public s<o, String> l(v v, m m2) {
        l.d dVar = new l.d(this, 1, v, m2);
        return dVar;
    }

    public net.time4j.h0 m(net.time4j.h0 h0) {
        int next;
        boolean z;
        net.time4j.h0 obj4;
        if (h0.s() == 24) {
            obj4 = h0.H0();
        }
        Iterator iterator = this.c.keySet().iterator();
        for (h0 next : iterator) {
        }
        return (h0)this.c.firstKey();
    }

    public net.time4j.h0 o(net.time4j.h0 h0) {
        Object lastKey;
        Object next;
        boolean z;
        net.time4j.h0 obj5;
        if (h0.s() == 24) {
            obj5 = h0.H0();
        }
        lastKey = this.c.lastKey();
        Iterator iterator = this.c.keySet().iterator();
        for (h0 next : iterator) {
            lastKey = next;
        }
        return lastKey;
    }

    public String toString() {
        boolean z;
        boolean equals;
        String str;
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("DayPeriod[");
        stringBuilder.append("locale=");
        stringBuilder.append(this.a);
        z = 44;
        stringBuilder.append(z);
        if (p() && !this.b.equals("iso8601")) {
            stringBuilder.append("locale=");
            stringBuilder.append(this.a);
            z = 44;
            stringBuilder.append(z);
            if (!this.b.equals("iso8601")) {
                stringBuilder.append(",calendar-type=");
                stringBuilder.append(this.b);
                stringBuilder.append(z);
            }
        }
        stringBuilder.append(this.c);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
