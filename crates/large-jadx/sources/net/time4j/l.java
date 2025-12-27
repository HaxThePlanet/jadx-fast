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

/* compiled from: DayPeriod.java */
/* loaded from: classes3.dex */
public final class l {

    private static final SortedMap<h0, String> d;
    private static l e;
    private static final c<l> f;
    private final transient Locale a;
    private final transient String b;
    private final transient SortedMap<h0, String> c;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[v.values().length];
            l.a.a = iArr;
            try {
                iArr[v.WIDE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                l.a.a[v.NARROW.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    static class c implements r {
        c() {
            super();
        }

        private static l e(Locale locale, d dVar) {
            if (dVar.c(l.f)) {
                return (l)dVar.b(l.f);
            }
            return l.r(locale, (String)dVar.a(a.b, "iso8601"));
        }

        private static int f(q<?> qVar) {
            int value = -1;
            net.time4j.c cVar = h0.J;
            if (qVar.v(cVar)) {
                if ((Integer)qVar.p(h0.J).intValue() == 12) {
                    value = 0;
                }
            } else {
                l0Var = h0.L;
                if (qVar.v(l0Var)) {
                    value = (Integer)qVar.p(h0.L).intValue();
                } else {
                    value = -1;
                }
            }
            return value;
        }

        public boolean a(p<?> pVar) {
            return pVar instanceof l.b;
        }

        public q<?> b(q<?> qVar, Locale locale, d dVar) {
            q qVar3;
            q qVar2;
            int i = 0;
            String substring;
            net.time4j.a0 pM2;
            int i2 = 1;
            net.time4j.a0 pM22 = null;
            int i3;
            boolean z2;
            int i4 = 0;
            boolean equals;
            boolean hasNext;
            boolean equals2;
            net.time4j.h0 h0Var;
            qVar2 = qVar;
            if (!qVar2.v(h0.H)) {
                if (!qVar2.v(h0.N)) {
                    if (!qVar2.v(h0.M)) {
                        if (!(qVar2.v(h0.K))) {
                            net.time4j.l lVar = l.c.e(locale, dVar);
                            z2 = false;
                            net.time4j.l.b bVar = new l.b(z2, lVar);
                            str = "midnight";
                            i2 = 1;
                            if (qVar2.v(bVar)) {
                                Object obj2 = qVar2.p(bVar);
                                i4 = 0;
                                int indexOf = obj2.indexOf(124, i);
                                int i5 = -1;
                                while (indexOf == i5) {
                                    substring = obj2.substring(i);
                                    i = indexOf + 1;
                                    z2 = z2 + i2;
                                    substring = obj2.substring(i, indexOf);
                                }
                                if (pM2 != null) {
                                    if (z2 + i2 > 1) {
                                        qVar2 = qVar2.G(h0.I, pM2).G(bVar, null);
                                    }
                                }
                            } else {
                                bVar = new l.b(true, lVar);
                                if (qVar2.v(bVar)) {
                                    Object obj = qVar2.p(bVar);
                                    if (obj.equals("am") || obj.equals(str)) {
                                        qVar3 = qVar2.G(h0.I, a0.AM);
                                    }
                                    qVar2 = qVar3.G(bVar, null);
                                }
                            }
                        }
                    }
                }
            }
            return qVar2;
        }

        public Set<p<?>> c(Locale locale, d dVar) {
            net.time4j.l lVar = l.c.e(locale, dVar);
            final HashSet hashSet = new HashSet();
            hashSet.add(new l.b(false, lVar));
            if (!dVar.c(l.f)) {
                hashSet.add(new l.b(true, lVar));
            }
            return Collections.unmodifiableSet(hashSet);
        }

        public boolean d(Class<?> cls) {
            return h0.class.isAssignableFrom(cls);
        }
    }

    private class d implements s<o, String> {

        private final boolean a;
        private final v b;
        private final m c;
        final /* synthetic */ l d;
        d(boolean z, v vVar, m mVar) {
            this.d = lVar;
            super();
            Objects.requireNonNull(vVar, "Missing text width.");
            Objects.requireNonNull(mVar, "Missing output context.");
            this.a = z;
            this.b = vVar;
            this.c = mVar;
        }

        public String a(o oVar) {
            Locale rOOT2;
            String str2;
            String str3;
            String str4;
            boolean z;
            Object obj = oVar.p(h0.H);
            rOOT2 = this.d.a;
            str2 = "noon";
            str3 = "midnight";
            if (this.a) {
                String str = l.n(obj);
                if (this.d.p()) {
                    Map map = l.q(rOOT2, this.d.b);
                    if (!map.containsKey(l.k(map, this.b, this.c, str))) {
                        if (str.equals(str3)) {
                            str3 = "am";
                            str4 = l.k(map, this.b, this.c, str3);
                        } else {
                            if (str.equals(str2)) {
                                str3 = "pm";
                                str4 = l.k(map, this.b, this.c, str3);
                            }
                        }
                    }
                    if (map.containsKey(str4)) {
                        return (String)map.get(str4);
                    }
                    if (rOOT2 == null) {
                        rOOT2 = Locale.ROOT;
                    }
                    return (a0)obj.p(h0.I).getDisplayName(rOOT2);
                }
                return str;
            }
            if (this.d.p()) {
                Map map2 = l.q(rOOT2, this.d.b);
                if (obj.D0()) {
                    str2 = l.k(map2, this.b, this.c, str3);
                    if (map2.containsKey(str2)) {
                        return (String)map2.get(str2);
                    }
                } else {
                    if (obj.E0(h0.I0(12)) && map2.containsKey(str2)) {
                        return (String)map2.get(str2);
                    }
                }
                String str6 = l.k(map2, this.b, this.c, (String)this.d.c.get(this.d.o(obj)));
                if (map2.containsKey(str6)) {
                    return (String)map2.get(str6);
                }
            }
            return (String)this.d.c.get(this.d.o(obj));
        }
    }

    static class b extends e<String> implements t<String>, y<q<?>, String> {

        private static final long serialVersionUID = 5589976208326940032L;
        private final transient boolean a;
        private final transient l b;
        b(boolean z, Locale locale, String str) {
            this(z, l.r(locale, str));
        }

        private String D(java.lang.CharSequence charSequence, ParsePosition parsePosition, d dVar, m mVar) {
            String str;
            Object value = null;
            m mVar42;
            int length;
            Iterator it;
            int i = 0;
            Map map;
            int i2 = 0;
            boolean z2;
            String str4;
            int i3 = 0;
            String str5;
            String str3 = null;
            int index;
            final Object charSequence2 = this;
            obj = parsePosition;
            Object mVar43 = dVar;
            mVar42 = mVar;
            ArrayList arrayList = new ArrayList();
            str4 = "pm";
            str5 = "am";
            final String str7 = "noon";
            final String str8 = "midnight";
            if (charSequence2.a) {
                arrayList.add("am");
                arrayList.add("pm");
                arrayList.add(str8);
                arrayList.add(str7);
            } else {
                arrayList.addAll(new LinkedHashSet(charSequence2.b.c.values()));
                if (charSequence2.b.p()) {
                    arrayList.add(str8);
                    arrayList.add(str7);
                }
            }
            if (charSequence2.b.p()) {
                Map map2 = l.q(w(), l());
            } else {
                i = 0;
            }
            Object obj4 = mVar43.a(a.g, v.WIDE);
            index = parsePosition.getIndex();
            it = arrayList.iterator();
            int i5 = 0;
            length = 0;
            while (it.hasNext()) {
                str3 = it.next();
                obj = parsePosition;
                mVar42 = mVar;
            }
            if (charSequence2.b.c == null) {
                parsePosition.setErrorIndex(index);
            } else {
                index = index + length;
                parsePosition.setIndex(index);
            }
            return str3;
        }

        private boolean k(char c, char c2) {
            char c3;
            boolean z = false;
            char c4;
            int i = 122;
            final int i2 = 65;
            final int i3 = 97;
            if (c >= i3 && c <= i) {
                c3 = (char)(c - 97) + i2;
            }
            if (c2 >= i3 && c2 <= i) {
                c4 = (char)(c2 - 97) + i2;
            }
            if (c3 >= i2 && c3 <= 'Z' && c3 == c4) {
                int i5 = 1;
                return z;
            }
            Locale locale = w();
            return String.valueOf(c3).toUpperCase(locale).equals(String.valueOf(c4).toUpperCase(locale));
        }

        private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Serialization proxy required.");
        }

        private Object writeReplace() {
            return new SPX(this, 7);
        }

        @Override // net.time4j.engine.e
        boolean A() {
            return this.a;
        }

        @Override // net.time4j.engine.e
        public String C(java.lang.CharSequence charSequence, ParsePosition parsePosition, d dVar) {
            m fORMAT2;
            String str;
            fORMAT2 = m.FORMAT;
            Object obj = dVar.a(a.h, fORMAT2);
            if (D(charSequence, parsePosition, dVar, obj) == null) {
                if ((Boolean)dVar.a(a.k, Boolean.TRUE).booleanValue()) {
                    parsePosition.setErrorIndex(-1);
                    parsePosition.setIndex(parsePosition.getIndex());
                    if (obj == m.FORMAT) {
                        fORMAT2 = m.STANDALONE;
                    }
                    str = D(charSequence, parsePosition, dVar, fORMAT2);
                }
            }
            return str;
        }

        @Override // net.time4j.engine.e
        public q<?> E(q<?> qVar, String str, boolean z) {
            throw new IllegalArgumentException("Day period element cannot be set.");
        }

        @Override // net.time4j.engine.e
        protected <T extends q<T>> y<T, String> d(w<T> wVar) {
            if (wVar.w(h0.H)) {
                return this;
            }
            return null;
        }

        @Override // net.time4j.engine.e
        protected boolean e(e<?> eVar) {
            return this.b.equals(eVar.b);
        }

        @Override // net.time4j.engine.e
        public char getSymbol() {
            char c = 98;
            int r0 = this.a ? 98 : 66;
            return (this.a ? 98 : 66);
        }

        @Override // net.time4j.engine.e
        public Class<String> getType() {
            return String.class;
        }

        @Override // net.time4j.engine.e
        String l() {
            return this.b.b;
        }

        @Override // net.time4j.engine.e
        public void print(o oVar, java.lang.Appendable appendable, d dVar) throws java.io.IOException {
            java.lang.CharSequence charSequence;
            Object obj = dVar.a(a.g, v.WIDE);
            Object obj2 = dVar.a(a.h, m.FORMAT);
            if (this.a) {
                Object apply = this.b.l(obj, obj2).apply(oVar);
            } else {
                Object apply2 = this.b.j(obj, obj2).apply(oVar);
            }
            appendable.append(charSequence);
        }

        @Override // net.time4j.engine.e
        Object r() {
            return this.b.c;
        }

        @Override // net.time4j.engine.e
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(32);
            String name = name();
            str = 32 + name + 64 + this.b;
            return str;
        }

        @Override // net.time4j.engine.e
        public String u() {
            if (this.a) {
                return "pm";
            }
            return (String)this.b.c.get((h0)this.b.c.lastKey());
        }

        @Override // net.time4j.engine.e
        public String v() {
            if (this.a) {
                return "am";
            }
            return (String)this.b.c.get((h0)this.b.c.firstKey());
        }

        @Override // net.time4j.engine.e
        Locale w() {
            return this.b.a;
        }

        @Override // net.time4j.engine.e
        public String x(q<?> qVar) {
            return u();
        }

        @Override // net.time4j.engine.e
        public String y(q<?> qVar) {
            return v();
        }

        @Override // net.time4j.engine.e
        public String z(q<?> qVar) {
            String str = null;
            boolean z;
            Object obj = qVar.p(h0.H);
            if (this.a) {
                return l.n(obj);
            }
            if (this.b.p()) {
                Map map = l.q(w(), l());
                int i = 0;
                if (obj.D0()) {
                    str = "midnight";
                } else {
                    if (obj.E0(h0.I0(12))) {
                        str = "noon";
                    }
                }
                if (str != null) {
                    if (map.containsKey(l.k(map, v.ABBREVIATED, m.FORMAT, str))) {
                        return str;
                    }
                }
            }
            return (String)this.b.c.get(this.b.o(obj));
        }

        b(boolean z, l lVar) {
            String str;
            String r0 = z ? "FIXED_DAY_PERIOD" : "APPROXIMATE_DAY_PERIOD";
            super((z ? "FIXED_DAY_PERIOD" : "APPROXIMATE_DAY_PERIOD"));
            this.a = z;
            this.b = lVar;
        }

        @Override // net.time4j.engine.e
        public boolean B(q<?> qVar, String str) {
            return false;
        }

        @Override // net.time4j.engine.e
        public boolean isDateElement() {
            return false;
        }

        @Override // net.time4j.engine.e
        public boolean isTimeElement() {
            return true;
        }

        @Override // net.time4j.engine.e
        public p<?> n(q<?> qVar) {
            return null;
        }

        @Override // net.time4j.engine.e
        public p<?> o(q<?> qVar) {
            return null;
        }
    }
    static {
        TreeMap treeMap = new TreeMap();
        treeMap.put(h0.H0(), "am");
        treeMap.put(h0.I0(12), "pm");
        SortedMap unmodifiableSortedMap = Collections.unmodifiableSortedMap(treeMap);
        l.d = unmodifiableSortedMap;
        l.e = new l(Locale.ROOT, "iso8601", unmodifiableSortedMap);
        l.f = a.e("CUSTOM_DAY_PERIOD", l.class);
    }

    private l(Locale locale, String str, SortedMap<h0, String> sortedMap) {
        super();
        this.a = locale;
        this.b = str;
        this.c = Collections.unmodifiableSortedMap(sortedMap);
    }

    private static boolean a(String str) {
        boolean z = false;
        final int i = 1;
        char c = 'T';
        if (str.charAt(0) == 'T') {
            if (str.length() == 5) {
                if (Character.isDigit(str.charAt(i))) {
                }
            }
        }
        return z;
    }

    static /* synthetic */ c b() {
        return l.f;
    }

    static /* synthetic */ boolean c(l lVar) {
        return lVar.p();
    }

    static /* synthetic */ SortedMap d(l lVar) {
        return lVar.c;
    }

    static /* synthetic */ String e(h0 h0Var) {
        return l.n(h0Var);
    }

    static /* synthetic */ Map f(Locale locale, String str) {
        return l.q(locale, str);
    }

    static /* synthetic */ String g(Map map, v vVar, m mVar, String str) {
        return l.k(map, vVar, mVar, str);
    }

    static /* synthetic */ Locale h(l lVar) {
        return lVar.a;
    }

    static /* synthetic */ String i(l lVar) {
        return lVar.b;
    }

    private static String k(Map<String, String> map, v vVar, m mVar, String str) {
        v aBBREVIATED2;
        if (vVar == v.SHORT) {
            aBBREVIATED2 = v.ABBREVIATED;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = l.t(aBBREVIATED2, mVar);
        str = str2 + str;
        if (!map.containsKey(str) && mVar == m.STANDALONE && aBBREVIATED2 == v.ABBREVIATED) {
            str = l.k(map, aBBREVIATED2, m.FORMAT, str);
        }
        return str;
    }

    private static String n(h0 h0Var) {
        int value = (Integer)h0Var.p(h0.P).intValue();
        return "midnight";
    }

    private boolean p() {
        boolean z = true;
        int r0 = this.a != null ? 1 : 0;
        return (this.a != null ? 1 : 0);
    }

    private static Map<String, String> q(Locale locale, String str) {
        Map map;
        str = "iso8601";
        if (!str.equals(str)) {
            str = "true";
            if (!str.equals(b.c(str, locale).m().get("hasDayPeriods"))) {
                map = b.d(locale).m();
            }
        }
        return map;
    }

    static l r(Locale locale, String str) {
        boolean z;
        int parsed;
        Object obj;
        net.time4j.h0 h0Var;
        String str3;
        int i;
        Locale locale2;
        String language = locale.getLanguage();
        if (language.equals("nn")) {
            locale2 = new Locale("nb");
        }
        Map map = l.q(locale2, str);
        final TreeMap treeMap = new TreeMap();
        Iterator value = map.keySet().iterator();
        while (value.hasNext()) {
            Object value2 = value.next();
            if (l.a(value2)) {
                int i5 = 3;
                int parsed2 = Integer.parseInt(value2.substring(1, i5));
                parsed = Integer.parseInt(value2.substring(i5, 5));
                str3 = "Invalid time key: ";
                i = 24;
            }
        }
        return l.e;
    }

    public static l s(Map<h0, String> map) {
        if (map.isEmpty()) {
            throw new IllegalArgumentException("Label map is empty.");
        } else {
            TreeMap treeMap = new TreeMap(map);
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                Object item = it.next();
            }
            return new l(null, "", treeMap);
        }
    }

    private static String t(v vVar, m mVar) {
        char upperCase = 110;
        int i2 = l.a.a[vVar.ordinal()];
        int i = 1;
        if (i2 != 1) {
            i = 2;
            vVar = i2 != 2 ? 97 : 110;
        } else {
            upperCase = 'w';
        }
        if (mVar == m.STANDALONE) {
            upperCase = Character.toUpperCase(upperCase);
        }
        final StringBuilder stringBuilder = new StringBuilder();
        String str = "P(";
        String str2 = ")_";
        str3 = str + upperCase + str2;
        return str3;
    }

    public boolean equals(Object object) {
        boolean z = true;
        boolean equals2;
        boolean equals3;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof l) {
            if (this.a == null) {
                if (object.a != null) {
                    return false;
                }
            } else {
                if (!this.a.equals(object.a)) {
                    return false;
                }
            }
            if (this.c.equals(object.c)) {
                if (!(this.b.equals(object.b))) {
                }
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public s<o, String> j(v vVar, m mVar) {
        return new l.d(this, false, vVar, mVar);
    }

    public s<o, String> l(v vVar, m mVar) {
        return new l.d(this, true, vVar, mVar);
    }

    public h0 m(h0 h0Var) {
        net.time4j.h0 h0Var2;
        int i = 24;
        if (h0Var.s() == 24) {
            h0Var2 = h0.H0();
        }
        Iterator it = this.c.keySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            if (h0Var2.A0(item)) {
                return item;
            }
        }
        return (h0)this.c.firstKey();
    }

    public h0 o(h0 h0Var) {
        Object lastKey;
        boolean z;
        net.time4j.h0 h0Var2;
        if (h0Var.s() == 24) {
            h0Var2 = h0.H0();
        }
        lastKey = this.c.lastKey();
        Iterator it = this.c.keySet().iterator();
        while (it.hasNext()) {
            lastKey = it.next();
            if (h0Var2.A0(lastKey)) {
                break;
            }
        }
        return lastKey;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("DayPeriod[");
        if (p()) {
            stringBuilder.append("locale=");
            stringBuilder.append(this.a);
            char c = ',';
            stringBuilder.append(c);
            str = "iso8601";
            if (!this.b.equals(str)) {
                stringBuilder.append(",calendar-type=");
                stringBuilder.append(this.b);
                stringBuilder.append(c);
            }
        }
        stringBuilder.append(this.c);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
