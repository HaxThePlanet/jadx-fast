package net.time4j.g1.z;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import net.time4j.engine.a0;
import net.time4j.engine.o;
import net.time4j.g1.a;
import net.time4j.g1.g;
import net.time4j.tz.k;
import net.time4j.tz.l;

/* compiled from: TimezoneNameProcessor.java */
/* loaded from: classes3.dex */
final class d0 implements h<k> {

    private static final ConcurrentMap<Locale, d0.a> y = new ConcurrentHashMap<>();
    private static final ConcurrentMap<Locale, d0.a> z = new ConcurrentHashMap<>();
    private final boolean a;
    private final h<k> b;
    private final Set<k> c;
    private final g v;
    private final Locale w;
    private final int x;

    private static class a {

        private final g0 a;
        private final g0 b;
        a(g0 g0Var, g0 g0Var2) {
            super();
            this.a = g0Var;
            this.b = g0Var2;
        }

        void a(java.lang.CharSequence charSequence, int i, List<k> list, List<k> list2, int[] iArr) {
            String str = this.a.f(charSequence, i);
            final int length = str.length();
            iArr[0] = i + length;
            String str2 = this.b.f(charSequence, i);
            int length2 = str2.length();
            iArr[1] = i + length2;
            if (length2 > length) {
                list2.addAll(this.b.b(str2));
            } else {
                if (length2 < length) {
                    list.addAll(this.a.b(str));
                } else {
                    if (length > 0) {
                        list.addAll(this.a.b(str));
                        list2.addAll(this.b.b(str2));
                    }
                }
            }
        }
    }

    d0(boolean z) {
        super();
        this.a = z;
        this.b = new n(z);
        this.c = null;
        this.v = g.SMART;
        this.w = Locale.ROOT;
        this.x = 0;
    }

    private g0 a(Locale locale, boolean z) {
        net.time4j.g1.z.g0.b bVar = null;
        Iterator it = l.t().iterator();
        int i = 0;
        while (it.hasNext()) {
            Object item = it.next();
            String str = l.x(item, d(z), locale);
        }
        return new g0(bVar);
    }

    private static List<k> b(List<k> list) {
        int i = 1;
        Object item;
        boolean startsWith;
        String str;
        i = 1;
        if (list.size() > 1) {
            ArrayList arrayList = new ArrayList(list);
            while (i < list.size()) {
                item = list.get(i);
                str = "WINDOWS~";
                i = i + 1;
            }
            return !arrayList.isEmpty() ? arrayList : list;
        }
    }

    private String c(java.lang.CharSequence charSequence, int i, int i2) {
        int i22;
        char charAt;
        boolean letter;
        final StringBuilder stringBuilder = new StringBuilder();
        i22 = i;
        while (i22 < i2) {
            charAt = charSequence.charAt(i22);
        }
        return stringBuilder.toString().trim();
    }

    private net.time4j.tz.d d(boolean z) {
        net.time4j.tz.d lONG_STANDARD_TIME2;
        net.time4j.tz.d lONG_DAYLIGHT_TIME2;
        if (z) {
            z = this.a ? d.SHORT_DAYLIGHT_TIME : d.LONG_DAYLIGHT_TIME;
            return (this.a ? d.SHORT_DAYLIGHT_TIME : d.LONG_DAYLIGHT_TIME);
        }
        z = this.a ? d.SHORT_STANDARD_TIME : d.LONG_STANDARD_TIME;
        return (this.a ? d.SHORT_STANDARD_TIME : d.LONG_STANDARD_TIME);
    }

    private List<k> e(List<k> list, Locale locale, g gVar) {
        Iterator it;
        String str;
        int i = 0;
        String substring;
        Set set;
        boolean equals;
        Object gVar32;
        boolean hasNext2;
        final HashMap hashMap = new HashMap();
        substring = "DEFAULT";
        hashMap.put(substring, new ArrayList());
        it = list.iterator();
        i = 0;
        while (it.hasNext()) {
            str = (k)it.next().a();
            int indexOf = str.indexOf(126);
            Iterator it2 = set.iterator();
            while (it2.hasNext()) {
                Object item2 = it2.next();
                if (item2.a().equals(str)) {
                    break loop_8;
                }
            }
            item2 = it2.next();
        }
        if ((List)hashMap.get(substring).isEmpty()) {
            hashMap.remove(substring);
            Iterator it3 = hashMap.keySet().iterator();
            while (it3.hasNext()) {
                gVar32 = hashMap.get((String)it3.next());
                if (!gVar32.isEmpty()) {
                    break;
                }
            }
            if (i == 0) {
                List emptyList = Collections.emptyList();
            }
        }
        return gVar32;
    }

    private static String f(List<k> list) {
        int i = 1;
        char c;
        final StringBuilder stringBuilder = new StringBuilder(list.size() * 16);
        stringBuilder.append('{');
        Iterator it = list.iterator();
        i = 1;
        while (it.hasNext()) {
            stringBuilder.append((k)it.next().a());
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        boolean z2;
        boolean equals;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof d0) {
            if (this.a == object.a) {
                if (this.c == null) {
                    if (object.c != null) {
                    }
                }
            }
            return z;
        }
        return false;
    }

    public net.time4j.engine.p<k> getElement() {
        return b0.TIMEZONE_ID;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 0;
        if (this.c == null) {
            i = 0;
        } else {
            i = this.c.hashCode();
        }
        return i + this.a;
    }

    public void parse(java.lang.CharSequence charSequence, s sVar, net.time4j.engine.d dVar, t<?> tVar, boolean z) {
        boolean equals;
        int length;
        int i2;
        ArrayList arrayList;
        int value;
        Object obj2;
        Object obj3;
        ConcurrentMap concurrentMap;
        Integer num;
        Locale rOOT2;
        String str4;
        int i3 = 2;
        int i;
        Object item2;
        Object ifAbsent;
        boolean z4 = true;
        int i5 = 0;
        final Object charSequence3 = this;
        java.lang.CharSequence charSequence2 = charSequence;
        net.time4j.g1.z.s sVar22 = sVar;
        net.time4j.engine.d dVar32 = dVar;
        net.time4j.g1.z.t tVar42 = tVar;
        i = sVar.f();
        int i12 = 0;
        if (z) {
        } else {
            value = (Integer)dVar32.a(a.s, null).intValue();
        }
        if (charSequence3.x > 0) {
            length = charSequence.length() - value;
        }
        if (i >= length) {
            sVar22.k(i, "Missing timezone name.");
            return;
        }
        if (z) {
        } else {
            obj2 = dVar32.a(a.c, Locale.ROOT);
        }
        if (z) {
        } else {
            obj3 = dVar32.a(a.f, g.SMART);
        }
        final g gVar2 = obj3;
        final String str23 = charSequence3.c(charSequence2, i, length);
        if (!str23.startsWith("GMT")) {
            if (!str23.startsWith("UT")) {
                ConcurrentMap r7 = charSequence3.a ? d0.y : d0.z;
                ifAbsent = r7.get(obj2);
                z = true;
                if (ifAbsent != null) {
                } else {
                    int i4 = 25;
                    if (r7.size() < 25) {
                        ifAbsent = r7.putIfAbsent(obj2, new d0.a(charSequence3.a(obj2, false), charSequence3.a(obj2, z)));
                        if (ifAbsent != null) {
                        }
                    }
                }
                arrayList = new ArrayList();
                arrayList = new ArrayList();
                ifAbsent.a(charSequence2.subSequence(i12, length), i, arrayList, arrayList, iArr);
                i2 = arrayList.size() + arrayList.size();
                if (i2 == 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str8 = "\"";
                    String str9 = "\" does not match any known timezone name.";
                    str6 = str8 + str23 + str9;
                    sVar22.k(i, str6);
                    return;
                }
                if (i2 > z && !gVar2.isStrict()) {
                    i2 = d0.b(arrayList).size() + d0.b(arrayList).size();
                }
                if (i2 <= z || gVar2.isLax()) {
                } else {
                    Object obj = dVar32.a(a.d, p.C);
                    if (!(obj instanceof p)) {
                        Iterator it3 = arrayList.iterator();
                        while (it3.hasNext()) {
                            net.time4j.tz.p item = it3.next();
                            if (item.a().equals(obj.a())) {
                                break;
                            }
                        }
                        i5 = 0;
                        if (i5 == 0) {
                            Iterator it4 = arrayList.iterator();
                            while (it4.hasNext()) {
                                arrayList = it4.next();
                                if (arrayList.a().equals(obj.a())) {
                                    break;
                                }
                            }
                        }
                    } else {
                        i5 = 0;
                    }
                    if (i5 == 0 && a.d.size() > 0) {
                        List list = charSequence3.e(arrayList, obj2, gVar2);
                        if (arrayList.size() > 0) {
                            List list2 = charSequence3.e(arrayList, obj2, gVar2);
                        }
                    }
                }
                size = arrayList.size() + arrayList.size();
                if (size == 0) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add((k)it.next().a());
                    }
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add((k)it2.next().a());
                    }
                    StringBuilder stringBuilder3 = new StringBuilder();
                    String str15 = "Time zone name \"";
                    String str16 = "\" not found among preferred timezones in locale ";
                    String str17 = ", candidates=";
                    str7 = str15 + str23 + str16 + obj2 + str17 + arrayList2;
                    sVar22.k(i, str7);
                    return;
                }
                if (arrayList.size() > 0) {
                    i3 = 2;
                    if (size == 2) {
                        i3 = 1;
                        if (arrayList.size() == 1) {
                            int i7 = 0;
                            if (!((k)arrayList.get(i7).a().equals((k)arrayList.get(i7).a()))) {
                                if (!arrayList.isEmpty()) {
                                    arrayList = new ArrayList(arrayList);
                                    arrayList.addAll(arrayList);
                                }
                            }
                        }
                    }
                    int i11 = 0;
                } else {
                    int i10 = 1;
                }
                if (arrayList.size() == 1 || gVar2.isLax()) {
                    tVar42.K(b0.TIMEZONE_ID, arrayList.get(0));
                    tVar42.K(a0.DAYLIGHT_SAVING, Boolean.valueOf(z4));
                    sVar22.l(iArr[z4]);
                }
            }
            return;
        }
        charSequence3.b.parse(charSequence, sVar, dVar, tVar, z);
    }

    public int print(o oVar, java.lang.Appendable appendable, net.time4j.engine.d dVar, Set<g> set, boolean z) throws java.io.IOException {
        Locale locale;
        int z53;
        String str = "Cannot extract timezone name from: ";
        if (!oVar.j()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            oVar = str + oVar;
            throw new IllegalArgumentException(oVar);
        } else {
            k kVar = oVar.t();
            if (kVar instanceof p) {
                return this.b.print(oVar, appendable, dVar, set, z);
            }
            if (!(oVar instanceof f)) {
                StringBuilder stringBuilder = new StringBuilder();
                oVar = str + oVar;
                throw new IllegalArgumentException(oVar);
            } else {
                l lVar = l.N(kVar);
                rOOT2 = f.class;
                if (z) {
                } else {
                    Object obj = dVar.a(a.c, Locale.ROOT);
                }
                String str2 = lVar.w(d(lVar.I((f)rOOT2.cast(oVar))), locale);
                z53 = -1;
                if (appendable instanceof CharSequence) {
                    z53 = (CharSequence)appendable.length();
                } else {
                }
                appendable.append(str2);
                int length = str2.length();
                if (this.w != z53 && length > 0 && set != null) {
                    set.add(new g(b0.TIMEZONE_ID, z53, z53 + length));
                }
                return length;
            }
        }
    }

    public h<k> quickPath(c<?> cVar, net.time4j.engine.d dVar, int i) {
        d0 cVar2 = new d0(this.a, this.b, this.c, (g)dVar.a(a.f, g.SMART), (Locale)dVar.a(a.c, Locale.ROOT), (Integer)dVar.a(a.s, null).intValue());
        return cVar2;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        String name = d0.class.getName();
        String str2 = "[abbreviated=";
        String str3 = ", preferredZones=";
        str = 64 + name + str2 + this.a + str3 + this.c + 93;
        return str;
    }

    private d0(boolean z, h<k> hVar, Set<k> set, g gVar, Locale locale, int i) {
        super();
        this.a = z;
        this.b = hVar;
        this.c = set;
        this.v = gVar;
        this.w = locale;
        this.x = i;
    }

    public boolean isNumerical() {
        return false;
    }

    public h<k> withElement(net.time4j.engine.p<k> pVar) {
        return this;
    }
}
