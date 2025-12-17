package net.time4j.g1.z;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import net.time4j.engine.a0;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.g1.a;
import net.time4j.g1.g;
import net.time4j.tz.d;
import net.time4j.tz.k;
import net.time4j.tz.l;
import net.time4j.tz.p;

/* loaded from: classes3.dex */
final class d0 implements net.time4j.g1.z.h<k> {

    private static final ConcurrentMap<Locale, net.time4j.g1.z.d0.a> y;
    private static final ConcurrentMap<Locale, net.time4j.g1.z.d0.a> z;
    private final boolean a;
    private final net.time4j.g1.z.h<k> b;
    private final Set<k> c;
    private final g v;
    private final Locale w;
    private final int x;

    private static class a {

        private final net.time4j.g1.z.g0 a;
        private final net.time4j.g1.z.g0 b;
        a(net.time4j.g1.z.g0 g0, net.time4j.g1.z.g0 g02) {
            super();
            this.a = g0;
            this.b = g02;
        }

        void a(java.lang.CharSequence charSequence, int i2, List<k> list3, List<k> list4, int[] i5Arr5) {
            Object obj5;
            net.time4j.g1.z.g0 obj6;
            String str = this.a.f(charSequence, i2);
            final int length = str.length();
            i5Arr5[0] = i2 + length;
            obj5 = this.b.f(charSequence, i2);
            int length2 = obj5.length();
            i5Arr5[1] = i2 += length2;
            if (length2 > length) {
                list4.addAll(this.b.b(obj5));
            } else {
                if (length2 < length) {
                    list3.addAll(this.a.b(str));
                } else {
                    if (length > 0) {
                        list3.addAll(this.a.b(str));
                        list4.addAll(this.b.b(obj5));
                    }
                }
            }
        }
    }
    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        d0.y = concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        d0.z = concurrentHashMap2;
    }

    d0(boolean z) {
        super();
        this.a = z;
        n nVar = new n(z);
        this.b = nVar;
        this.c = 0;
        this.v = g.SMART;
        this.w = Locale.ROOT;
        this.x = 0;
    }

    private d0(boolean z, net.time4j.g1.z.h<k> h2, Set<k> set3, g g4, Locale locale5, int i6) {
        super();
        this.a = z;
        this.b = h2;
        this.c = set3;
        this.v = g4;
        this.w = locale5;
        this.x = i6;
    }

    private net.time4j.g1.z.g0 a(Locale locale, boolean z2) {
        int i;
        Object next;
        String str;
        boolean equals;
        Iterator iterator = l.t().iterator();
        i = 0;
        while (iterator.hasNext()) {
            next = iterator.next();
            str = l.x((k)next, d(z2), locale);
            if (str.equals(next.a())) {
            } else {
            }
            i = g0.d(i, str, next);
        }
        g0 obj6 = new g0(i);
        return obj6;
    }

    private static List<k> b(List<k> list) {
        int arrayList;
        int empty;
        int size;
        Object obj;
        boolean startsWith;
        String str;
        if (list.size() > 1) {
            arrayList = new ArrayList(list);
            while (empty < list.size()) {
                obj = list.get(empty);
                if ((k)obj.a().startsWith("WINDOWS~")) {
                }
                empty++;
                arrayList.remove(obj);
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
        }
        return list;
    }

    private String c(java.lang.CharSequence charSequence, int i2, int i3) {
        int i;
        char charAt;
        boolean letter;
        StringBuilder stringBuilder = new StringBuilder();
        i = i2;
        while (i < i3) {
            charAt = charSequence.charAt(i);
            if (!Character.isLetter(charAt)) {
            } else {
            }
            stringBuilder.append(charAt);
            i++;
            if (!this.a) {
            }
            if (i > i2) {
            }
            if (!Character.isDigit(charAt)) {
            }
        }
        return stringBuilder.toString().trim();
    }

    private d d(boolean z) {
        d obj1;
        if (z) {
            obj1 = this.a ? d.SHORT_DAYLIGHT_TIME : d.LONG_DAYLIGHT_TIME;
            return obj1;
        }
        obj1 = this.a ? d.SHORT_STANDARD_TIME : d.LONG_STANDARD_TIME;
        return obj1;
    }

    private List<k> e(List<k> list, Locale locale2, g g3) {
        Iterator iterator2;
        Object arrayList;
        String substring;
        int i;
        Iterator iterator;
        Set set;
        boolean indexOf;
        boolean equals;
        boolean obj9;
        Object obj10;
        boolean obj11;
        HashMap hashMap = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        final String str = "DEFAULT";
        hashMap.put(str, arrayList2);
        iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            arrayList = (k)iterator2.next().a();
            indexOf = arrayList.indexOf(126);
            if (indexOf >= 0) {
            } else {
            }
            substring = str;
            if (this.c == null) {
            }
            iterator = set.iterator();
            while (iterator.hasNext()) {
                indexOf = iterator.next();
                if ((k)indexOf.a().equals(arrayList)) {
                    break loop_8;
                } else {
                }
            }
            indexOf = iterator.next();
            if ((k)indexOf.a().equals(arrayList)) {
            } else {
            }
            if ((List)hashMap.get(substring) == null) {
            }
            arrayList.add(indexOf);
            arrayList = new ArrayList();
            hashMap.put(substring, arrayList);
            set = l.C(locale2, g3.isSmart(), substring);
            substring = arrayList.substring(0, indexOf);
        }
        if ((List)hashMap.get(str).isEmpty()) {
            hashMap.remove(str);
            obj10 = hashMap.keySet().iterator();
            while (obj10.hasNext()) {
                obj11 = hashMap.get((String)obj10.next());
                if ((List)obj11.isEmpty() == null) {
                    break;
                } else {
                }
            }
            if (i == 0) {
                obj9 = Collections.emptyList();
            }
            obj10 = obj9;
        }
        return obj10;
    }

    private static String f(List<k> list) {
        int i;
        String str;
        int i2;
        StringBuilder stringBuilder = new StringBuilder(size *= 16);
        stringBuilder.append('{');
        Iterator obj4 = list.iterator();
        i = 1;
        while (obj4.hasNext()) {
            if (i != 0) {
            } else {
            }
            stringBuilder.append(',');
            stringBuilder.append((k)obj4.next().a());
            i = 0;
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    @Override // net.time4j.g1.z.h
    public boolean equals(Object object) {
        int i;
        boolean z;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof d0) {
            if (this.a == object.a) {
                z = this.c;
                obj5 = object.c;
                if (z == null) {
                    if (obj5 == null) {
                    } else {
                        i = i2;
                    }
                } else {
                    if (z.equals(obj5)) {
                    } else {
                    }
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    public p<k> getElement() {
        return b0.TIMEZONE_ID;
    }

    @Override // net.time4j.g1.z.h
    public int hashCode() {
        int i;
        Set set = this.c;
        if (set == null) {
            i = 0;
        } else {
            i = set.hashCode();
        }
        return i += z;
    }

    @Override // net.time4j.g1.z.h
    public boolean isNumerical() {
        return 0;
    }

    public void parse(java.lang.CharSequence charSequence, net.time4j.g1.z.s s2, d d3, net.time4j.g1.z.t<?> t4, boolean z5) {
        int i4;
        String string;
        Object size4;
        int arrayList3;
        Object valueOf2;
        int size2;
        Object tVar;
        boolean next;
        int length;
        int lax;
        Object singletonList2;
        int intValue;
        Object obj2;
        Object obj;
        boolean startsWith;
        ConcurrentMap ifAbsent;
        int strict;
        Object singletonList;
        p next3;
        Integer valueOf;
        Object size;
        int iterator;
        int size3;
        int i3;
        ArrayList next2;
        Object aVar;
        ArrayList equals;
        int[] iArr;
        int i2;
        int i;
        Object arrayList2;
        Object arrayList;
        final Object obj3 = this;
        java.lang.CharSequence charSequence2 = charSequence;
        net.time4j.g1.z.s sVar = s2;
        size4 = d3;
        tVar = t4;
        i4 = s2.f();
        int i11 = 0;
        if (z5) {
            intValue = obj3.x;
        } else {
            intValue = (Integer)size4.a(a.s, Integer.valueOf(i11)).intValue();
        }
        if (intValue > 0) {
            length -= intValue;
        }
        if (i4 >= length) {
            sVar.k(i4, "Missing timezone name.");
        }
        if (z5) {
            obj2 = obj3.w;
        } else {
            obj2 = size4.a(a.c, Locale.ROOT);
        }
        final Object obj8 = obj2;
        if (z5) {
            obj = obj3.v;
        } else {
            obj = size4.a(a.f, g.SMART);
        }
        final Object obj9 = obj;
        final String str14 = obj3.c(charSequence2, i4, length);
        if (!str14.startsWith("GMT")) {
            if (str14.startsWith("UT")) {
            } else {
                ifAbsent = obj3.a ? d0.y : d0.z;
                size = ifAbsent.get(obj8);
                int i10 = 1;
                if ((d0.a)size == null) {
                    aVar = new d0.a(obj3.a(obj8, i11), obj3.a(obj8, i10));
                    ifAbsent = ifAbsent.putIfAbsent(obj8, aVar);
                    if (ifAbsent.size() < 25 && (d0.a)ifAbsent != null) {
                        ifAbsent = ifAbsent.putIfAbsent(obj8, aVar);
                        if ((d0.a)(d0.a)ifAbsent != null) {
                            aVar = ifAbsent;
                        }
                    }
                } else {
                    aVar = size;
                }
                arrayList2 = new ArrayList();
                arrayList = new ArrayList();
                int i8 = 2;
                string = iArr2;
                int i12 = i9;
                i = i10;
                aVar.a(charSequence2.subSequence(i11, length), i4, arrayList2, arrayList, string);
                size7 += strict;
                if (lax == 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("\"");
                    stringBuilder.append(str14);
                    stringBuilder.append("\" does not match any known timezone name.");
                    sVar.k(i4, stringBuilder.toString());
                }
                if (lax > i && !obj9.isStrict()) {
                    if (!obj9.isStrict()) {
                        size8 += strict;
                    }
                }
                if (lax > i && !obj9.isLax()) {
                    if (!obj9.isLax()) {
                        size4 = size4.a(a.d, p.C);
                        if (!size4 instanceof p) {
                            Iterator iterator4 = arrayList2.iterator();
                            for (k next3 : iterator4) {
                            }
                            singletonList2 = arrayList2;
                            singletonList = arrayList;
                            iArr = 0;
                            if (iArr == 0) {
                                iterator = singletonList.iterator();
                                while (iterator.hasNext()) {
                                    next2 = iterator.next();
                                    if ((k)next2.a().equals(size4.a()) != null) {
                                        break;
                                    } else {
                                    }
                                    i = 1;
                                }
                            }
                        } else {
                            singletonList2 = arrayList2;
                            singletonList = arrayList;
                            iArr = 0;
                        }
                        if (iArr == 0 && singletonList2.size() > 0) {
                            if (singletonList2.size() > 0) {
                                singletonList2 = obj3.e(singletonList2, obj8, obj9);
                            }
                            if (singletonList.size() > 0) {
                                singletonList = obj3.e(singletonList, obj8, obj9);
                            }
                        }
                    } else {
                        singletonList2 = arrayList2;
                        singletonList = arrayList;
                    }
                } else {
                }
                size5 += size9;
                if (arrayList3 == null) {
                    ArrayList arrayList4 = new ArrayList();
                    Iterator iterator2 = arrayList2.iterator();
                    for (k next6 : iterator2) {
                        arrayList4.add(next6.a());
                    }
                    Iterator iterator3 = arrayList.iterator();
                    for (k next5 : iterator3) {
                        arrayList4.add(next5.a());
                    }
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("Time zone name \"");
                    stringBuilder3.append(str14);
                    stringBuilder3.append("\" not found among preferred timezones in locale ");
                    stringBuilder3.append(obj8);
                    stringBuilder3.append(", candidates=");
                    stringBuilder3.append(arrayList4);
                    sVar.k(i4, stringBuilder3.toString());
                }
                if (singletonList2.size() > 0) {
                    int i6 = 0;
                    if (arrayList3 == 2 && singletonList.size() == 1 && (k)singletonList2.get(i6).a().equals((k)singletonList.get(i6).a())) {
                        if (singletonList.size() == 1) {
                            i6 = 0;
                            if ((k)singletonList2.get(i6).a().equals((k)singletonList.get(i6).a())) {
                            } else {
                                if (!singletonList.isEmpty()) {
                                    arrayList3 = new ArrayList(singletonList2);
                                    arrayList3.addAll(singletonList);
                                    singletonList2 = arrayList3;
                                }
                            }
                        } else {
                        }
                    } else {
                    }
                    i2 = 0;
                } else {
                    singletonList2 = singletonList;
                    i2 = 1;
                }
                if (singletonList2.size() != 1) {
                    if (obj9.isLax()) {
                        tVar.K(b0.TIMEZONE_ID, singletonList2.get(0));
                        tVar.K(a0.DAYLIGHT_SAVING, Boolean.valueOf(i2));
                        sVar.l(string[i2]);
                    } else {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Time zone name is not unique: \"");
                        stringBuilder2.append(str14);
                        stringBuilder2.append("\" in ");
                        stringBuilder2.append(d0.f(singletonList2));
                        sVar.k(i4, stringBuilder2.toString());
                    }
                } else {
                }
            }
        }
        obj3.b.parse(charSequence, s2, d3, t4, z5);
    }

    public int print(o o, java.lang.Appendable appendable2, d d3, Set<net.time4j.g1.z.g> set4, boolean z5) {
        l lVar;
        Locale rOOT;
        Object obj11;
        Object obj12;
        net.time4j.engine.c obj14;
        String str = "Cannot extract timezone name from: ";
        if (!o.j()) {
        } else {
            k kVar = o.t();
            if (kVar instanceof p) {
                return this.b.print(o, appendable2, d3, set4, z5);
            }
            if (!o instanceof f) {
            } else {
                lVar = l.N(kVar);
                if (z5 != null) {
                    obj12 = this.w;
                } else {
                    obj12 = d3.a(a.c, Locale.ROOT);
                }
                String obj10 = lVar.w(d(lVar.I((f)f.class.cast(o))), obj12);
                obj14 = -1;
                if (appendable2 instanceof CharSequence) {
                    obj12 = (CharSequence)appendable2.length();
                } else {
                    obj12 = obj14;
                }
                appendable2.append(obj10);
                obj10 = obj10.length();
                if (obj12 != obj14 && obj10 > 0 && set4 != null) {
                    if (obj10 > 0) {
                        if (set4 != null) {
                            obj11 = new g(b0.TIMEZONE_ID, obj12, obj12 + obj10);
                            set4.add(obj11);
                        }
                    }
                }
                return obj10;
            }
            obj12 = new StringBuilder();
            obj12.append(str);
            obj12.append(o);
            obj11 = new IllegalArgumentException(obj12.toString());
            throw obj11;
        }
        obj12 = new StringBuilder();
        obj12.append(str);
        obj12.append(o);
        obj11 = new IllegalArgumentException(obj12.toString());
        throw obj11;
    }

    public net.time4j.g1.z.h<k> quickPath(net.time4j.g1.z.c<?> c, d d2, int i3) {
        super(this.a, this.b, this.c, (g)d2.a(a.f, g.SMART), (Locale)d2.a(a.c, Locale.ROOT), (Integer)d2.a(a.s, 0).intValue());
        return obj8;
    }

    @Override // net.time4j.g1.z.h
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append(d0.class.getName());
        stringBuilder.append("[abbreviated=");
        stringBuilder.append(this.a);
        stringBuilder.append(", preferredZones=");
        stringBuilder.append(this.c);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public net.time4j.g1.z.h<k> withElement(p<k> p) {
        return this;
    }
}
