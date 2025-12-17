package net.time4j.h1;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Set;
import net.time4j.g1.a0.c;
import net.time4j.g1.e;
import net.time4j.g1.m;
import net.time4j.g1.u;
import net.time4j.g1.v;

/* loaded from: classes3.dex */
public final class c implements u, c {

    private static final Set<String> a;
    static {
        Object next;
        Locale locale2;
        int i;
        String name;
        Locale locale;
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, e.h("calendar/names/iso8601/iso8601", Locale.ROOT).f("languages").split(" "));
        Set unmodifiableSet = Collections.unmodifiableSet(hashSet);
        c.a = unmodifiableSet;
        HashSet hashSet2 = new HashSet();
        Iterator iterator = unmodifiableSet.iterator();
        for (String next : iterator) {
            locale2 = new Locale(next);
            hashSet2.add(locale2);
        }
        net.time4j.h1.d[] values = d.values();
        i = 0;
        while (i < values.length) {
            locale = new Locale(values[i].name());
            hashSet2.add(locale);
            i++;
        }
        Collections.unmodifiableSet(hashSet2);
    }

    private static String[] l(Locale locale, v v2) {
        Object aBBREVIATED2;
        int aBBREVIATED;
        String str;
        v vVar;
        int i;
        m fORMAT;
        int i2;
        v obj8;
        aBBREVIATED2 = c.m(locale);
        aBBREVIATED = 0;
        if (aBBREVIATED2 != null && v2 == v.SHORT) {
            if (v2 == v.SHORT) {
                obj8 = v.ABBREVIATED;
            }
            if (obj8 == v.NARROW) {
                aBBREVIATED = v.ABBREVIATED;
            }
            aBBREVIATED2 = v.ABBREVIATED;
            if (c.o(aBBREVIATED2, 5, c.n(aBBREVIATED2, "ERA"), obj8, aBBREVIATED, m.FORMAT, 0) == null && obj8 != aBBREVIATED2) {
                aBBREVIATED2 = v.ABBREVIATED;
                if (obj8 != aBBREVIATED2) {
                    aBBREVIATED = c.l(locale, aBBREVIATED2);
                }
            }
        }
        if (aBBREVIATED == 0) {
        } else {
            return aBBREVIATED;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot find ISO-8601-resource for era and locale: ");
        stringBuilder.append(locale);
        obj8 = new MissingResourceException(stringBuilder.toString(), c.class.getName(), locale.toString());
        throw obj8;
    }

    private static net.time4j.h1.e m(Locale locale) {
        return e.h("calendar/names/iso8601/iso8601", locale);
    }

    private static String n(net.time4j.h1.e e, String string2) {
        String str;
        boolean obj2;
        str = "useShortKeys";
        if (e.b(str) && "true".equals(e.f(str))) {
            if ("true".equals(e.f(str))) {
                return string2.substring(0, 1);
            }
        }
        return string2;
    }

    private static String[] o(net.time4j.h1.e e, int i2, String string3, v v4, v v5, m m6, int i7) {
        int length;
        String string;
        int i;
        char sTANDALONE;
        m sTANDALONE2;
        v vVar;
        int i8;
        m mVar;
        int i3;
        int i5;
        int i4;
        String str;
        int i6;
        final net.time4j.h1.e eVar2 = e;
        final int i14 = i2;
        final m mVar2 = m6;
        final String[] strArr = new String[i14];
        final int i15 = 0;
        i = 1;
        i5 = string3.length() == i ? i : i15;
        i4 = i15;
        while (i4 < i14) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append('(');
            if (i5 != 0) {
            } else {
            }
            stringBuilder.append(v4.name());
            if (mVar2 == m.STANDALONE) {
            }
            stringBuilder.append(')');
            stringBuilder.append('_');
            stringBuilder.append(i4 + i7);
            string = stringBuilder.toString();
            string = c.o(e, i2, string3, v5, 0, m6, i7);
            strArr[i4] = string[i4];
            i4++;
            strArr[i4] = eVar2.f(string);
            stringBuilder.append('|');
            stringBuilder.append(m6.name());
            if (mVar2 != m.STANDALONE) {
            }
            stringBuilder.append(sTANDALONE);
            sTANDALONE = Character.toLowerCase(v4.name().charAt(i15));
        }
        return strArr;
    }

    private static String p(String string, v v2, m m3) {
        char obj2;
        if (m3 == m.FORMAT) {
            obj2 = Character.toLowerCase(v2.name().charAt(0));
        }
        StringBuilder obj3 = new StringBuilder();
        obj3.append("P(");
        obj3.append(String.valueOf(obj2));
        obj3.append(")_");
        obj3.append(string);
        return obj3.toString();
    }

    private static String[] q(Locale locale, v v2, m m3) {
        Object aBBREVIATED;
        String str;
        String str2;
        boolean z;
        v obj5;
        aBBREVIATED = c.m(locale);
        if (aBBREVIATED == null) {
        } else {
            if (v2 == v.SHORT) {
                obj5 = v.ABBREVIATED;
            }
            str = c.p("am", obj5, m3);
            str2 = c.p("pm", obj5, m3);
            if (aBBREVIATED.b(str) && aBBREVIATED.b(str2)) {
                if (aBBREVIATED.b(str2)) {
                    String[] obj4 = new String[2];
                    return obj4;
                }
            }
            v aBBREVIATED2 = v.ABBREVIATED;
            if (m3 == m.STANDALONE && obj5 == aBBREVIATED2) {
                aBBREVIATED2 = v.ABBREVIATED;
                if (obj5 == aBBREVIATED2) {
                    return c.q(locale, obj5, m.FORMAT);
                }
                return c.q(locale, aBBREVIATED2, m3);
            }
            aBBREVIATED = v.ABBREVIATED;
            if (obj5 == aBBREVIATED) {
            } else {
                return c.q(locale, aBBREVIATED, m3);
            }
        }
        StringBuilder obj6 = new StringBuilder();
        obj6.append("Cannot find ISO-8601-resource for am/pm and locale: ");
        obj6.append(locale);
        obj5 = new MissingResourceException(obj6.toString(), c.class.getName(), locale.toString());
        throw obj5;
    }

    private static String[] r(Locale locale, v v2, m m3) {
        int i2;
        int sTANDALONE;
        String str;
        v vVar;
        int i;
        m mVar;
        int i3;
        v obj8;
        Enum obj9;
        net.time4j.h1.e eVar = c.m(locale);
        if (eVar != null) {
            if (v2 == v.SHORT) {
                obj8 = v.ABBREVIATED;
            }
            if (c.o(eVar, 12, c.n(eVar, "MONTH_OF_YEAR"), obj8, 0, m3, 1) == null) {
                sTANDALONE = m.STANDALONE;
                if (m3 == sTANDALONE) {
                    if (obj8 != v.NARROW) {
                        i2 = c.r(locale, obj8, m.FORMAT);
                    }
                } else {
                    if (obj8 == v.ABBREVIATED) {
                        i2 = c.r(locale, v.WIDE, m.FORMAT);
                    } else {
                        if (obj8 == v.NARROW) {
                            i2 = c.r(locale, obj8, sTANDALONE);
                        }
                    }
                }
            }
        } else {
            i2 = 0;
        }
        if (i2 == 0) {
        } else {
            return i2;
        }
        obj9 = new StringBuilder();
        obj9.append("Cannot find ISO-8601-month for locale: ");
        obj9.append(locale);
        obj8 = new MissingResourceException(obj9.toString(), c.class.getName(), locale.toString());
        throw obj8;
    }

    private static String[] s(Locale locale, v v2, m m3) {
        int i3;
        int sTANDALONE;
        String str;
        v vVar;
        int i;
        m mVar;
        int i2;
        v obj8;
        Enum obj9;
        net.time4j.h1.e eVar = c.m(locale);
        if (eVar != null) {
            if (v2 == v.SHORT) {
                obj8 = v.ABBREVIATED;
            }
            if (c.o(eVar, 4, c.n(eVar, "QUARTER_OF_YEAR"), obj8, 0, m3, 1) == null) {
                sTANDALONE = m.STANDALONE;
                if (m3 == sTANDALONE) {
                    if (obj8 != v.NARROW) {
                        i3 = c.s(locale, obj8, m.FORMAT);
                    }
                } else {
                    if (obj8 == v.ABBREVIATED) {
                        i3 = c.s(locale, v.WIDE, m.FORMAT);
                    } else {
                        if (obj8 == v.NARROW) {
                            i3 = c.s(locale, obj8, sTANDALONE);
                        }
                    }
                }
            }
        } else {
            i3 = 0;
        }
        if (i3 == 0) {
        } else {
            return i3;
        }
        obj9 = new StringBuilder();
        obj9.append("Cannot find ISO-8601-quarter-of-year for locale: ");
        obj9.append(locale);
        obj8 = new MissingResourceException(obj9.toString(), c.class.getName(), locale.toString());
        throw obj8;
    }

    private static char t(e e) {
        return Character.toLowerCase(e.name().charAt(0));
    }

    private static String[] u(Locale locale, v v2, m m3) {
        int i;
        int sTANDALONE;
        Object sHORT;
        v vVar;
        int i2;
        m mVar;
        int i3;
        Enum obj8;
        Enum obj9;
        net.time4j.h1.e eVar = c.m(locale);
        if (eVar != null) {
            if (c.o(eVar, 7, c.n(eVar, "DAY_OF_WEEK"), v2, 0, m3, 1) == null) {
                sTANDALONE = m.STANDALONE;
                if (m3 == sTANDALONE) {
                    if (v2 != v.NARROW) {
                        i = c.u(locale, v2, m.FORMAT);
                    }
                } else {
                    obj9 = v.ABBREVIATED;
                    if (v2 == obj9) {
                        i = c.u(locale, v.WIDE, m.FORMAT);
                    } else {
                        if (v2 == v.SHORT) {
                            i = c.u(locale, obj9, m.FORMAT);
                        } else {
                            if (v2 == v.NARROW) {
                                i = c.u(locale, v2, sTANDALONE);
                            }
                        }
                    }
                }
            }
        } else {
            i = 0;
        }
        if (i == 0) {
        } else {
            return i;
        }
        obj9 = new StringBuilder();
        obj9.append("Cannot find ISO-8601-day-of-week for locale: ");
        obj9.append(locale);
        obj8 = new MissingResourceException(obj9.toString(), c.class.getName(), locale.toString());
        throw obj8;
    }

    @Override // net.time4j.g1.u
    public String a(e e, Locale locale2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("F(");
        stringBuilder.append(c.t(e));
        stringBuilder.append(")_d");
        return c.m(locale2).f(stringBuilder.toString());
    }

    @Override // net.time4j.g1.u
    public String[] b(String string, Locale locale2, v v3) {
        return c.l(locale2, v3);
    }

    @Override // net.time4j.g1.u
    public String[] c(String string, Locale locale2, v v3, m m4) {
        return c.u(locale2, v3, m4);
    }

    @Override // net.time4j.g1.u
    public String[] d(String string, Locale locale2, v v3, m m4) {
        return c.q(locale2, v3, m4);
    }

    @Override // net.time4j.g1.u
    public String e(e e, Locale locale2) {
        return g(e, locale2, false);
    }

    @Override // net.time4j.g1.u
    public boolean f(Locale locale) {
        return c.a.contains(d.getAlias(locale));
    }

    @Override // net.time4j.g1.u
    public String g(e e, Locale locale2, boolean z3) {
        String str;
        String obj2;
        e obj4;
        if (z3 != null && e == e.FULL) {
            if (e == e.FULL) {
                obj2 = "F(alt)";
            } else {
                obj4 = new StringBuilder();
                obj4.append("F(");
                obj4.append(c.t(e));
                obj4.append(")_t");
                obj2 = obj4.toString();
            }
        } else {
        }
        return c.m(locale2).f(obj2);
    }

    @Override // net.time4j.g1.u
    public boolean h(String string) {
        return "iso8601".equals(string);
    }

    @Override // net.time4j.g1.u
    public String[] i(String string, Locale locale2, v v3, m m4) {
        return c.s(locale2, v3, m4);
    }

    @Override // net.time4j.g1.u
    public String[] j(String string, Locale locale2, v v3, m m4, boolean z5) {
        return c.r(locale2, v3, m4);
    }

    @Override // net.time4j.g1.u
    public String k(e e, e e2, Locale locale3) {
        Enum obj2;
        if (e.compareTo(e2) < 0) {
            obj2 = e2;
        }
        StringBuilder obj3 = new StringBuilder();
        obj3.append("F(");
        obj3.append(c.t(obj2));
        obj3.append(")_dt");
        return c.m(locale3).f(obj3.toString());
    }

    @Override // net.time4j.g1.u
    public String toString() {
        return "IsoTextProviderSPI";
    }
}
