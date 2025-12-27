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

/* compiled from: IsoTextProviderSPI.java */
/* loaded from: classes3.dex */
public final class c implements u, c {

    private static final Set<String> a;
    static {
        int i = 0;
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, e.h("calendar/names/iso8601/iso8601", Locale.ROOT).f("languages").split(" "));
        Set unmodifiable = Collections.unmodifiableSet(hashSet);
        c.a = unmodifiable;
        HashSet hashSet2 = new HashSet();
        Iterator it = unmodifiable.iterator();
        while (it.hasNext()) {
            hashSet2.add(new Locale((String)it.next()));
        }
        net.time4j.h1.d[] values = d.values();
        i = 0;
        for (net.time4j.h1.d dVar : values) {
            hashSet2.add(new Locale(dVar.name()));
        }
        Collections.unmodifiableSet(hashSet2);
    }

    private static String[] l(Locale locale, v vVar) {
        int i = 0;
        v vVar22;
        net.time4j.h1.e eVar = c.m(locale);
        i = 0;
        if (eVar != null && vVar == v.SHORT) {
            vVar22 = v.ABBREVIATED;
            if (vVar22 == v.NARROW) {
                v aBBREVIATED22 = v.ABBREVIATED;
            }
            int i2 = 0;
            if (c.o(eVar, 5, c.n(eVar, "ERA"), vVar22, i, m.FORMAT, i2) == null && vVar22 != v.ABBREVIATED) {
                String[] strArr2 = c.l(locale, v.ABBREVIATED);
            }
        }
        if (i == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Cannot find ISO-8601-resource for era and locale: ";
            r0 = str2 + locale;
            throw new MissingResourceException(r0, c.class.getName(), locale.toString());
        } else {
            return i;
        }
    }

    private static e m(Locale locale) {
        return e.h("calendar/names/iso8601/iso8601", locale);
    }

    private static String n(e eVar, String str) {
        str = "useShortKeys";
        if (eVar.b(str)) {
            str = "true";
            if (str.equals(eVar.f(str))) {
                return str.substring(0, 1);
            }
        }
        return str;
    }

    private static String[] o(e eVar, int i, String str, v vVar, v vVar2, m mVar, int i2) {
        int length;
        int i22;
        char lowerCase;
        m sTANDALONE2;
        v vVar52;
        m mVar62;
        int i72;
        final net.time4j.h1.e eVar2 = eVar;
        i22 = i;
        mVar62 = mVar;
        final String[] strArr2 = new String[i22];
        i22 = 0;
        i22 = 1;
        int r12 = i22;
        while (i22 < i22) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append('(');
            stringBuilder.append(')');
            stringBuilder.append('_');
            stringBuilder.append(i22 + i2);
            str = stringBuilder.toString();
        }
        return strArr2;
    }

    private static String p(String str, v vVar, m mVar) {
        char lowerCase;
        if (mVar == m.FORMAT) {
            lowerCase = Character.toLowerCase(vVar.name().charAt(0));
        }
        final StringBuilder stringBuilder = new StringBuilder();
        String str2 = "P(";
        String str4 = String.valueOf(lowerCase);
        String str5 = ")_";
        str3 = str2 + str4 + str5 + str;
        return str3;
    }

    private static String[] q(Locale locale, v vVar, m mVar) {
        boolean z;
        v aBBREVIATED2;
        net.time4j.h1.e eVar = c.m(locale);
        if (eVar == null) {
            StringBuilder stringBuilder = new StringBuilder();
            String str3 = "Cannot find ISO-8601-resource for am/pm and locale: ";
            mVar = str3 + locale;
            throw new MissingResourceException(mVar, c.class.getName(), locale.toString());
        } else {
            if (vVar == v.SHORT) {
                aBBREVIATED2 = v.ABBREVIATED;
            }
            String str = c.p("am", aBBREVIATED2, mVar);
            String str2 = c.p("pm", aBBREVIATED2, mVar);
            if (eVar.b(str) && eVar.b(str2)) {
                String[] strArr4 = new String[2];
                return new String[] { eVar.f(str), eVar.f(str2) };
            }
            if (mVar == m.STANDALONE) {
                v aBBREVIATED22 = v.ABBREVIATED;
                if (aBBREVIATED2 == v.ABBREVIATED) {
                    return c.q(locale, aBBREVIATED2, m.FORMAT);
                }
                return c.q(locale, v.ABBREVIATED, mVar);
            }
            v aBBREVIATED23 = v.ABBREVIATED;
            if (aBBREVIATED2 != v.ABBREVIATED) {
                return c.q(locale, v.ABBREVIATED, mVar);
            }
        }
    }

    private static String[] r(Locale locale, v vVar, m mVar) {
        int i = 0;
        v vVar22;
        net.time4j.h1.e eVar = c.m(locale);
        if (eVar != null) {
            if (vVar == v.SHORT) {
                vVar22 = v.ABBREVIATED;
            }
            int i2 = 12;
            vVar = null;
            int i3 = 1;
            if (c.o(eVar, i2, c.n(eVar, "MONTH_OF_YEAR"), vVar22, vVar, mVar, i3) == null) {
                m sTANDALONE2 = m.STANDALONE;
                if (mVar == m.STANDALONE) {
                    if (vVar22 != v.NARROW) {
                        String[] strArr4 = c.r(locale, vVar22, m.FORMAT);
                    }
                } else {
                    if (vVar22 == v.ABBREVIATED) {
                        String[] strArr3 = c.r(locale, v.WIDE, m.FORMAT);
                    } else {
                        if (v.WIDE == v.NARROW) {
                            String[] strArr2 = c.r(locale, vVar22, m.STANDALONE);
                        }
                    }
                }
            }
        } else {
            i = 0;
        }
        if (i == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Cannot find ISO-8601-month for locale: ";
            mVar = str2 + locale;
            throw new MissingResourceException(mVar, c.class.getName(), locale.toString());
        } else {
            return i;
        }
    }

    private static String[] s(Locale locale, v vVar, m mVar) {
        int i = 0;
        v vVar22;
        net.time4j.h1.e eVar = c.m(locale);
        if (eVar != null) {
            if (vVar == v.SHORT) {
                vVar22 = v.ABBREVIATED;
            }
            int i2 = 4;
            vVar = null;
            int i3 = 1;
            if (c.o(eVar, i2, c.n(eVar, "QUARTER_OF_YEAR"), vVar22, vVar, mVar, i3) == null) {
                m sTANDALONE2 = m.STANDALONE;
                if (mVar == m.STANDALONE) {
                    if (vVar22 != v.NARROW) {
                        String[] strArr4 = c.s(locale, vVar22, m.FORMAT);
                    }
                } else {
                    if (vVar22 == v.ABBREVIATED) {
                        String[] strArr3 = c.s(locale, v.WIDE, m.FORMAT);
                    } else {
                        if (v.WIDE == v.NARROW) {
                            String[] strArr2 = c.s(locale, vVar22, m.STANDALONE);
                        }
                    }
                }
            }
        } else {
            i = 0;
        }
        if (i == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Cannot find ISO-8601-quarter-of-year for locale: ";
            mVar = str2 + locale;
            throw new MissingResourceException(mVar, c.class.getName(), locale.toString());
        } else {
            return i;
        }
    }

    private static char t(e eVar) {
        return Character.toLowerCase(eVar.name().charAt(0));
    }

    private static String[] u(Locale locale, v vVar, m mVar) {
        int i = 0;
        net.time4j.h1.e eVar = c.m(locale);
        if (eVar == null) {
            i = 0;
        } else {
            int i2 = 7;
            vVar = null;
            int i3 = 1;
            if (c.o(eVar, i2, c.n(eVar, "DAY_OF_WEEK"), vVar, vVar, mVar, i3) == null) {
                m sTANDALONE2 = m.STANDALONE;
                if (mVar == m.STANDALONE) {
                    if (vVar != v.NARROW) {
                        String[] strArr2 = c.u(locale, vVar, m.FORMAT);
                    }
                } else {
                    nARROW2 = v.ABBREVIATED;
                    if (vVar == v.ABBREVIATED) {
                        String[] strArr3 = c.u(locale, v.WIDE, m.FORMAT);
                    } else {
                        if (v.WIDE == v.SHORT) {
                            String[] strArr5 = c.u(locale, v.ABBREVIATED, m.FORMAT);
                        } else {
                            if (v.WIDE == v.NARROW) {
                                String[] strArr4 = c.u(locale, vVar, m.STANDALONE);
                            }
                        }
                    }
                }
            }
        }
        if (i == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Cannot find ISO-8601-day-of-week for locale: ";
            mVar = str2 + locale;
            throw new MissingResourceException(mVar, c.class.getName(), locale.toString());
        } else {
            return i;
        }
    }

    public String a(e eVar, Locale locale) {
        final StringBuilder stringBuilder = new StringBuilder();
        final String str = "F(";
        char c = c.t(eVar);
        String str2 = ")_d";
        str3 = str + c + str2;
        return c.m(locale).f(str3);
    }

    public String[] b(String str, Locale locale, v vVar) {
        return c.l(locale, vVar);
    }

    public String[] c(String str, Locale locale, v vVar, m mVar) {
        return c.u(locale, vVar, mVar);
    }

    public String[] d(String str, Locale locale, v vVar, m mVar) {
        return c.q(locale, vVar, mVar);
    }

    public String e(e eVar, Locale locale) {
        return g(eVar, locale, false);
    }

    public boolean f(Locale locale) {
        return c.a.contains(d.getAlias(locale));
    }

    public String g(e eVar, Locale locale, boolean z) {
        String str2;
        if (!e.FULL || eVar != e.FULL) {
            StringBuilder stringBuilder = new StringBuilder();
            str = "F(";
            char c = c.t(eVar);
            String str3 = ")_t";
            str2 = str + c + str3;
        } else {
            str2 = "F(alt)";
        }
        return c.m(locale).f(str2);
    }

    public boolean h(String str) {
        return "iso8601".equals(str);
    }

    public String[] i(String str, Locale locale, v vVar, m mVar) {
        return c.s(locale, vVar, mVar);
    }

    public String[] j(String str, Locale locale, v vVar, m mVar, boolean z) {
        return c.r(locale, vVar, mVar);
    }

    public String k(e eVar, e eVar2, Locale locale) {
        e eVar3;
        if (eVar.compareTo(eVar2) < 0) {
            Enum eVar22 = eVar2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str = "F(";
        char c = c.t(eVar3);
        String str2 = ")_dt";
        str3 = str + c + str2;
        return c.m(locale).f(str3);
    }

    @Override // java.lang.Object
    public String toString() {
        return "IsoTextProviderSPI";
    }
}
