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

/* loaded from: classes3.dex */
public final class h implements r {

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            h.a.a = iArr;
            iArr[v.WIDE.ordinal()] = 1;
            h.a.a[v.ABBREVIATED.ordinal()] = 2;
            h.a.a[v.SHORT.ordinal()] = 3;
            h.a.a[v.NARROW.ordinal()] = 4;
        }
    }
    private static String F(char c, v v2, n n3) {
        int i2;
        int i;
        int obj3;
        i2 = 3;
        StringBuilder stringBuilder = new StringBuilder(i2);
        stringBuilder.append(c);
        obj3 = h.a.a[v2.ordinal()];
        if (obj3 != 1) {
            if (obj3 != 2 && obj3 != i2) {
                if (obj3 != i2) {
                    if (obj3 != 4) {
                    } else {
                        stringBuilder.append('n');
                    }
                    obj3 = new UnsupportedOperationException(v2.name());
                    throw obj3;
                }
            }
            stringBuilder.append('s');
        } else {
            stringBuilder.append('w');
        }
        stringBuilder.append(n3.ordinal());
        return stringBuilder.toString();
    }

    private static String G(char c, boolean z2, n n3) {
        int obj2;
        StringBuilder stringBuilder = new StringBuilder(3);
        stringBuilder.append(c);
        obj2 = z2 ? 43 : 45;
        stringBuilder.append(obj2);
        stringBuilder.append(n3.ordinal());
        return stringBuilder.toString();
    }

    private static String H(v v, String string2) {
        int i;
        int obj3;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('L');
        int i3 = h.a.a[v.ordinal()];
        if (i3 != 1) {
            if (i3 != 2 && i3 != 3) {
                if (i3 != 3) {
                    if (i3 != 4) {
                    } else {
                        stringBuilder.append('n');
                    }
                    UnsupportedOperationException obj4 = new UnsupportedOperationException(v.name());
                    throw obj4;
                }
            }
            stringBuilder.append('s');
        } else {
            stringBuilder.append('w');
        }
        stringBuilder.append('-');
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    private String I(Locale locale, String string2) {
        int i;
        int i2;
        boolean contains;
        int i3;
        Locale locale2;
        Iterator obj6 = e.c(locale).iterator();
        i = 1;
        i2 = 0;
        while (obj6.hasNext()) {
            contains = obj6.next();
            if (i != 0 && i2 != 0) {
            } else {
            }
            i3 = e.h("i18n/reltime/relpattern", (Locale)contains);
            i2 = i3;
            i = 0;
            if (i2 != 0) {
            } else {
            }
            i3 = i2;
        }
        return "";
    }

    private String J(Locale locale, String string2, String string3, String string4, n n5) {
        int i2;
        int i3;
        boolean oTHER;
        int i;
        Object str;
        Iterator obj6 = e.c(locale).iterator();
        i2 = 1;
        i3 = 0;
        while (obj6.hasNext()) {
            oTHER = obj6.next();
            if (i2 != 0 && i3 != 0) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("i18n/");
            stringBuilder.append(string2);
            i = e.h(stringBuilder.toString(), (Locale)oTHER);
            i3 = i;
            i2 = 0;
            if (i3 != 0) {
            } else {
            }
            i = i3;
        }
        StringBuilder obj9 = new StringBuilder();
        obj9.append("Can't find resource for bundle ");
        obj9.append(string2);
        obj9.append(".properties, key ");
        obj9.append(string3);
        StringBuilder obj10 = new StringBuilder();
        obj10.append(string2);
        obj10.append(".properties");
        obj6 = new MissingResourceException(obj9.toString(), obj10.toString(), string3);
        throw obj6;
    }

    private String K(Locale locale, char c2, boolean z3, n n4) {
        return this.J(locale, "reltime/relpattern", h.G(c2, z3, n4), h.G(c2, z3, n.OTHER), n4);
    }

    private String L(Locale locale, char c2, v v3, n n4) {
        return this.J(locale, "units/upattern", h.F(c2, v3, n4), h.F(c2, v3, n.OTHER), n4);
    }

    private static String M(String string, char c2, int i3) {
        int i;
        char charAt;
        int charAt3;
        char charAt2;
        int i2;
        length += -2;
        i = 0;
        while (i < i4) {
            i++;
            charAt = i + 1;
            charAt3 = i + 2;
        }
        return string;
    }

    @Override // net.time4j.g1.r
    public String A(Locale locale, v v2, n n3) {
        return L(locale, '6', v2, n3);
    }

    @Override // net.time4j.g1.r
    public String B(Locale locale, boolean z2, n n3) {
        return K(locale, 'N', z2, n3);
    }

    @Override // net.time4j.g1.r
    public String C(Locale locale, v v2, n n3) {
        return L(locale, 'Y', v2, n3);
    }

    @Override // net.time4j.g1.r
    public String D(Locale locale, boolean z2, n n3) {
        return K(locale, 'm', z2, n3);
    }

    @Override // net.time4j.g1.r
    public String E(Locale locale, boolean z2, n n3) {
        return K(locale, 'n', z2, n3);
    }

    @Override // net.time4j.g1.r
    public String a(Locale locale, v v2, n n3) {
        return L(locale, 'S', v2, n3);
    }

    @Override // net.time4j.g1.r
    public String b(Locale locale, boolean z2, n n3) {
        return K(locale, 'h', z2, n3);
    }

    @Override // net.time4j.g1.r
    public String c(Locale locale, v v2, n n3) {
        return L(locale, 'M', v2, n3);
    }

    @Override // net.time4j.g1.r
    public String d(Locale locale) {
        return this.J(locale, "reltime/relpattern", "yesterday", 0, n.OTHER);
    }

    @Override // net.time4j.g1.r
    public String e(Locale locale) {
        return this.J(locale, "reltime/relpattern", "now", 0, n.OTHER);
    }

    @Override // net.time4j.g1.r
    public String f(Locale locale, v v2, n n3) {
        return L(locale, '9', v2, n3);
    }

    @Override // net.time4j.g1.r
    public String g(Locale locale, boolean z2, n n3) {
        return K(locale, 'S', z2, n3);
    }

    @Override // net.time4j.g1.r
    public String h(Locale locale, v v2, n n3) {
        return L(locale, 'N', v2, n3);
    }

    @Override // net.time4j.g1.r
    public String i(Locale locale, boolean z2, n n3) {
        return K(locale, 'M', z2, n3);
    }

    @Override // net.time4j.g1.r
    public String j(Locale locale, v v2, n n3) {
        return L(locale, 'H', v2, n3);
    }

    @Override // net.time4j.g1.r
    public String k(Locale locale) {
        return this.J(locale, "reltime/relpattern", "today", 0, n.OTHER);
    }

    @Override // net.time4j.g1.r
    public String l(Locale locale, v v2, n n3) {
        return L(locale, '3', v2, n3);
    }

    @Override // net.time4j.g1.r
    public String m(Locale locale, boolean z2, n n3) {
        return K(locale, 'y', z2, n3);
    }

    @Override // net.time4j.g1.r
    public String n(Locale locale) {
        return this.J(locale, "reltime/relpattern", "tomorrow", 0, n.OTHER);
    }

    @Override // net.time4j.g1.r
    public String o(Locale locale, boolean z2, n n3) {
        return K(locale, 'H', z2, n3);
    }

    @Override // net.time4j.g1.r
    public String p(Locale locale, v v2, n n3) {
        return L(locale, 'D', v2, n3);
    }

    @Override // net.time4j.g1.r
    public String q(Locale locale, v v2, int i3) {
        int i;
        String str;
        int stringBuilder;
        int substring;
        int i2;
        int charAt2;
        char charAt;
        int i4;
        String obj14;
        String obj15;
        final int i5 = 2;
        if (i3 < i5) {
        } else {
            net.time4j.h1.e obj13 = e.h("i18n/units/upattern", locale);
            String str3 = h.H(v2, String.valueOf(i3));
            if (obj13.b(str3)) {
                return obj13.f(str3);
            }
            String str6 = obj13.f(h.H(v2, "end"));
            if (i3 == i5) {
                return str6;
            }
            int i7 = 49;
            final int i8 = 48;
            i = obj15;
            obj15 = obj14;
            while (i >= 0) {
                if (i == 0) {
                } else {
                }
                str = obj13;
                stringBuilder = str.length();
                substring = stringBuilder + -1;
                i2 = -1;
                while (substring >= 0) {
                    substring--;
                    i2 = -1;
                }
                charAt2 = i2;
                obj14 = new StringBuilder();
                obj14.append(str.substring(0, charAt2));
                obj14.append(obj15);
                if (charAt2 > i2 && charAt2 < stringBuilder += -3) {
                }
                if (i > 0) {
                }
                i--;
                obj15 = h.M(obj14, i8, i);
                obj14 = new StringBuilder();
                obj14.append(str.substring(0, charAt2));
                obj14.append(obj15);
                if (charAt2 < stringBuilder += -3) {
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append(obj14.toString());
                stringBuilder.append(str.substring(charAt2 += 3));
                obj14 = stringBuilder.toString();
                if (substring >= i5) {
                } else {
                }
                substring--;
                if (str.charAt(substring) == 125) {
                } else {
                }
                if (str.charAt(substring + -1) == i7) {
                } else {
                }
                if (str.charAt(substring + -2) == 123) {
                } else {
                }
                str = str9;
            }
            return obj14;
        }
        obj13 = new IllegalArgumentException("Size must be greater than 1.");
        throw obj13;
    }

    @Override // net.time4j.g1.r
    public String r(Locale locale, boolean z2, n n3) {
        return K(locale, 'D', z2, n3);
    }

    @Override // net.time4j.g1.r
    public String s(Locale locale, v v2, n n3) {
        return L(locale, 'W', v2, n3);
    }

    @Override // net.time4j.g1.r
    public String t(Locale locale, boolean z2, n n3) {
        return K(locale, 'W', z2, n3);
    }

    @Override // net.time4j.g1.r
    public String u(Locale locale, boolean z2, n n3) {
        return K(locale, 'd', z2, n3);
    }

    @Override // net.time4j.g1.r
    public String v(Locale locale, boolean z2, n n3) {
        return K(locale, 'w', z2, n3);
    }

    @Override // net.time4j.g1.r
    public String w(Locale locale, boolean z2, n n3) {
        return K(locale, 's', z2, n3);
    }

    @Override // net.time4j.g1.r
    public String x(Locale locale, boolean z2, n n3) {
        return K(locale, 'Y', z2, n3);
    }

    @Override // net.time4j.g1.r
    public String y(x0 x0, Locale locale2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(x0.name().substring(0, 3).toLowerCase());
        stringBuilder.append("+");
        return I(locale2, stringBuilder.toString());
    }

    @Override // net.time4j.g1.r
    public String z(x0 x0, Locale locale2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(x0.name().substring(0, 3).toLowerCase());
        stringBuilder.append("-");
        return I(locale2, stringBuilder.toString());
    }
}
