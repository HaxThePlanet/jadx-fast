package net.time4j.h1;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Set;
import net.time4j.g1.n;
import net.time4j.g1.r;
import net.time4j.g1.v;
import net.time4j.x0;

/* compiled from: UnitPatternProviderSPI.java */
/* loaded from: classes3.dex */
public final class h implements r {

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[v.values().length];
            h.a.a = iArr;
            try {
                iArr[v.WIDE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                h.a.a[v.ABBREVIATED.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                h.a.a[v.SHORT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                h.a.a[v.NARROW.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    private static String F(char c, v vVar, n nVar) {
        int i = 3;
        final StringBuilder stringBuilder = new StringBuilder(i);
        stringBuilder.append(c);
        int i3 = h.a.a[vVar.ordinal()];
        int i2 = 1;
        if (h.a.a != 1) {
            i2 = 2;
            if (h.a.a != 2 && h.a.a != i && h.a.a == 4) {
                char c2 = 'n';
                stringBuilder.append(c2);
            }
            c2 = 's';
            stringBuilder.append(c2);
        } else {
            c2 = 'w';
            stringBuilder.append(c2);
        }
        stringBuilder.append(nVar.ordinal());
        return stringBuilder.toString();
    }

    private static String G(char c, boolean z, n nVar) {
        char c2 = 43;
        final StringBuilder stringBuilder = new StringBuilder(3);
        stringBuilder.append(c);
        c = z ? 43 : 45;
        stringBuilder.append((z ? 43 : 45));
        stringBuilder.append((z ? 43 : 45));
        return (z ? 43 : 45);
    }

    private static String H(v vVar, String str) {
        int i = 2;
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('L');
        int i3 = h.a.a[vVar.ordinal()];
        i = 1;
        if (h.a.a != 1) {
            i = 2;
            if (h.a.a != 2 && h.a.a != 3 && h.a.a == 4) {
                char c = 'n';
                stringBuilder.append(c);
            }
            c = 's';
            stringBuilder.append(c);
        } else {
            c = 'w';
            stringBuilder.append(c);
        }
        stringBuilder.append('-');
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    private String I(Locale locale, String str) {
        int i = 1;
        int i2 = 0;
        Locale locale2;
        Iterator it = e.c(locale).iterator();
        i = 1;
        i2 = 0;
        while (it.hasNext()) {
            Object item = it.next();
            if (i == 0) {
            }
        }
        return "";
    }

    private String J(Locale locale, String str, String str2, String str3, n nVar) {
        int i = 1;
        int i2 = 0;
        Locale locale2;
        Iterator it = e.c(locale).iterator();
        i = 1;
        i2 = 0;
        while (it.hasNext()) {
            Object item = it.next();
            if (i == 0) {
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        String str9 = "Can't find resource for bundle ";
        String str10 = ".properties, key ";
        str3 = str9 + str + str10 + str2;
        StringBuilder stringBuilder3 = new StringBuilder();
        String str8 = ".properties";
        str = str + str8;
        throw new MissingResourceException(str3, str, str2);
    }

    private String K(Locale locale, char c, boolean z, n nVar) {
        return this.J(locale, "reltime/relpattern", h.G(c, z, nVar), h.G(c, z, n.OTHER), nVar);
    }

    private String L(Locale locale, char c, v vVar, n nVar) {
        return this.J(locale, "units/upattern", h.F(c, vVar, nVar), h.F(c, vVar, n.OTHER), nVar);
    }

    private static String M(String str, char c, int i) {
        char charAt;
        char charAt2 = 123;
        char charAt3;
        int i2 = str.length() - 2;
        i = 0;
        while (i < i2) {
            charAt2 = '{';
            if (str.charAt(i) == '{') {
                int i5 = i + 1;
            }
        }
        return str;
    }

    public String A(Locale locale, v vVar, n nVar) {
        return L(locale, '6', vVar, nVar);
    }

    public String B(Locale locale, boolean z, n nVar) {
        return K(locale, 'N', z, nVar);
    }

    public String C(Locale locale, v vVar, n nVar) {
        return L(locale, 'Y', vVar, nVar);
    }

    public String D(Locale locale, boolean z, n nVar) {
        return K(locale, 'm', z, nVar);
    }

    public String E(Locale locale, boolean z, n nVar) {
        return K(locale, 'n', z, nVar);
    }

    public String a(Locale locale, v vVar, n nVar) {
        return L(locale, 'S', vVar, nVar);
    }

    public String b(Locale locale, boolean z, n nVar) {
        return K(locale, 'h', z, nVar);
    }

    public String c(Locale locale, v vVar, n nVar) {
        return L(locale, 'M', vVar, nVar);
    }

    public String d(Locale locale) {
        return this.J(locale, "reltime/relpattern", "yesterday", null, n.OTHER);
    }

    public String e(Locale locale) {
        return this.J(locale, "reltime/relpattern", "now", null, n.OTHER);
    }

    public String f(Locale locale, v vVar, n nVar) {
        return L(locale, '9', vVar, nVar);
    }

    public String g(Locale locale, boolean z, n nVar) {
        return K(locale, 'S', z, nVar);
    }

    public String h(Locale locale, v vVar, n nVar) {
        return L(locale, 'N', vVar, nVar);
    }

    public String i(Locale locale, boolean z, n nVar) {
        return K(locale, 'M', z, nVar);
    }

    public String j(Locale locale, v vVar, n nVar) {
        return L(locale, 'H', vVar, nVar);
    }

    public String k(Locale locale) {
        return this.J(locale, "reltime/relpattern", "today", null, n.OTHER);
    }

    public String l(Locale locale, v vVar, n nVar) {
        return L(locale, '3', vVar, nVar);
    }

    public String m(Locale locale, boolean z, n nVar) {
        return K(locale, 'y', z, nVar);
    }

    public String n(Locale locale) {
        return this.J(locale, "reltime/relpattern", "tomorrow", null, n.OTHER);
    }

    public String o(Locale locale, boolean z, n nVar) {
        return K(locale, 'H', z, nVar);
    }

    public String p(Locale locale, v vVar, n nVar) {
        return L(locale, 'D', vVar, nVar);
    }

    public String q(Locale locale, v vVar, int i) {
        int i32;
        String locale2;
        int length;
        int i2 = -1;
        char charAt;
        char charAt2;
        char c;
        String vVar22;
        final int i4 = 2;
        if (i < i4) {
            throw new IllegalArgumentException("Size must be greater than 1.");
        } else {
            net.time4j.h1.e eVar = e.h("i18n/units/upattern", locale);
            String str3 = h.H(vVar, String.valueOf(i));
            if (eVar.b(str3)) {
                return eVar.f(str3);
            }
            String str6 = eVar.f(h.H(vVar, "end"));
            if (i == i4) {
                return str6;
            }
            char c2 = '1';
            final char c3 = '0';
            while (i32 >= 0) {
                String r5 = i32 == 0 ? eVar.f(h.H(vVar, "start")) : eVar.f(h.H(vVar, "middle"));
                length = r5.length();
                i = length - 1;
                i2 = -1;
                while (i >= 0) {
                    if (i >= i4) {
                        break loop_11;
                    }
                }
                i32 = i32 - 1;
            }
            return vVar22;
        }
    }

    public String r(Locale locale, boolean z, n nVar) {
        return K(locale, 'D', z, nVar);
    }

    public String s(Locale locale, v vVar, n nVar) {
        return L(locale, 'W', vVar, nVar);
    }

    public String t(Locale locale, boolean z, n nVar) {
        return K(locale, 'W', z, nVar);
    }

    public String u(Locale locale, boolean z, n nVar) {
        return K(locale, 'd', z, nVar);
    }

    public String v(Locale locale, boolean z, n nVar) {
        return K(locale, 'w', z, nVar);
    }

    public String w(Locale locale, boolean z, n nVar) {
        return K(locale, 's', z, nVar);
    }

    public String x(Locale locale, boolean z, n nVar) {
        return K(locale, 'Y', z, nVar);
    }

    public String y(x0 x0Var, Locale locale) {
        final StringBuilder stringBuilder = new StringBuilder();
        String str = x0Var.name().substring(0, 3).toLowerCase();
        String str2 = "+";
        str3 = str + str2;
        return I(locale, str3);
    }

    public String z(x0 x0Var, Locale locale) {
        final StringBuilder stringBuilder = new StringBuilder();
        String str = x0Var.name().substring(0, 3).toLowerCase();
        String str2 = "-";
        str3 = str + str2;
        return I(locale, str3);
    }
}
