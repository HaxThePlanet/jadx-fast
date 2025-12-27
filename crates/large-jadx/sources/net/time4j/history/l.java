package net.time4j.history;

import java.io.InvalidObjectException;
import java.text.ParsePosition;
import java.util.List;
import java.util.Locale;
import net.time4j.c0;
import net.time4j.engine.ChronoException;
import net.time4j.engine.d;
import net.time4j.engine.e;
import net.time4j.engine.h;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.w;
import net.time4j.engine.y;
import net.time4j.g0;
import net.time4j.g1.b;
import net.time4j.g1.g;
import net.time4j.g1.j;
import net.time4j.g1.s;
import net.time4j.g1.v;

/* compiled from: HistoricIntegerElement.java */
/* loaded from: classes3.dex */
final class l extends net.time4j.history.q.c implements net.time4j.g1.a0.a {

    private static final long serialVersionUID = -6283098762945747308L;
    private final d history;
    private final transient int x;

    private static class a<C extends q<C>> implements y<C, Integer> {

        private final int a;
        private final d b;
        a(int i, d dVar) {
            super();
            this.a = i;
            this.b = dVar;
        }

        private h b(C c, int i) {
            net.time4j.history.p aFTER_NEW_YEAR2;
            int i4 = 1;
            int i3 = 100;
            net.time4j.history.h hVar;
            net.time4j.history.h hVar2 = this.b.e((g0)c.p(g0.G));
            final net.time4j.history.o oVar = this.b.w();
            i4 = 1;
            switch (i) {
                case 2:
                    hVar = this.b.a(h.m(hVar2.e(), i, hVar2.f(), hVar2.c(), aFTER_NEW_YEAR2, oVar));
                    break;
                case 3:
                    hVar = this.b.a(h.k(hVar2.e(), hVar2.i(), this.b, hVar2.c()));
                    break;
                case 4:
                    hVar = h.k(hVar2.e(), hVar2.i(), hVar2.f(), i);
                    break;
                case 5:
                    int i8 = hVar2.j(this.b.w());
                    hVar = this.b.n(hVar2.e(), i8);
                    hVar = this.b.e((g0)this.b.d(hVar).T(h.e((long)i - i4, g0.G)));
                    StringBuilder stringBuilder = new StringBuilder();
                    String str2 = "Out of range: ";
                    i = str2 + i;
                    throw new IllegalArgumentException(str2 + i);
                case 6:
                    i4 = 6;
                    aFTER_NEW_YEAR2 = p.AFTER_NEW_YEAR;
                    aFTER_NEW_YEAR2 = p.BEFORE_NEW_YEAR;
                    hVar = this.b.a(h.m(this.b.e(), i, this.b.f(), this.b.c(), aFTER_NEW_YEAR2, oVar));
                    break;
                case 7:
                    i3 = 100;
                    i3 = this.b.i() % i3;
                    i4 = (i - i4 * i3) + i3;
                    hVar = this.b.a(h.m(this.b.e(), i - i4 * i3 + i3, this.b.f(), this.b.c(), p.DUAL_DATING, oVar));
                    break;
                default:
                    StringBuilder stringBuilder2 = new StringBuilder();
                    String str = "Unknown element index: ";
                    i = str + this.a;
                    throw new UnsupportedOperationException(str + i7);
            }
            return hVar;
        }

        public p<?> d(C c) {
            throw new UnsupportedOperationException("Never called.");
        }

        public p<?> e(C c) {
            throw new UnsupportedOperationException("Never called.");
        }

        public Integer f(C c) throws ChronoException {
            net.time4j.history.j jVar;
            int maximumDayOfMonth;
            int i;
            int c2 = 999979465;
            net.time4j.history.j bYZANTINE2;
            net.time4j.history.h hVar;
            int i2;
            try {
                net.time4j.history.h hVar2 = this.b.e((g0)c.p(g0.G));
                maximumDayOfMonth = 8;
                c2 = 999984973;
                int i14 = this.b.v(hVar2.e(), hVar2.j(this.b.w()));
                if (i14 == -1) {
                    throw new ChronoException("Length of historic year undefined.");
                } else {
                    return Integer.valueOf(i14);
                }
            } catch (RuntimeException e) {
                ChronoException chronoException = new ChronoException(e.getMessage(), e);
                throw chronoException;
            }
        }

        public Integer g(C c) throws ChronoException {
            int i2;
            int i3 = 1;
            int i4;
            net.time4j.history.h hVar2;
            int i5;
            try {
                net.time4j.history.h hVar = this.b.e((g0)c.p(g0.G));
                int i = 2;
                i3 = 1;
                if (this.a != 2 && this.a != 6 && this.a != 7) {
                    i = 8;
                    if (this.a != 8) {
                        if (this.b.B(b(c, i3))) {
                            return 1;
                        }
                        if (this.a != 5) {
                            List list = this.b.q();
                            i2 = list.size() - i3;
                            while (i2 >= 0) {
                                Object item = list.get(i2);
                                if (hVar.a(item.c) >= 0) {
                                    break;
                                }
                            }
                            if (this.a == 3) {
                                i5 = hVar2.f();
                            } else {
                                i5 = hVar2.c();
                            }
                            return Integer.valueOf(i5);
                        }
                    }
                    throw new ChronoException("Historic New Year cannot be determined.");
                }
                if (hVar.e() == j.BYZANTINE && hVar.f() >= 9) {
                    return null;
                }
            } catch (java.lang.IllegalArgumentException iae) {
                throw new ChronoException(iae.getMessage(), iae);
            }
            return Integer.valueOf(i3);
        }

        public Integer h(C c) throws ChronoException {
            int i2;
            try {
                Object obj = c.p(g0.G);
                net.time4j.history.h hVar = this.b.e(obj);
                i2 = (hVar.i() - 1) / 100 + 1;
                i2 = hVar.j(this.b.w());
                long l = 1L;
                i2 = (int)(obj.c() - (this.b.d(this.b.n(hVar.e(), hVar.j(this.b.w()))).c())) + l;
                i2 = hVar.c();
                i2 = hVar.f();
                i2 = hVar.i();
                return Integer.valueOf(i2);
            } catch (java.lang.IllegalArgumentException iae) {
                ChronoException chronoException = new ChronoException(iae.getMessage(), iae);
                throw chronoException;
            }
        }

        public boolean i(C c, Integer integer) {
            if (integer == null) {
                return false;
            }
            try {
            } catch (java.lang.IllegalArgumentException unused) {
                return z;
            }
            return this.b.B(b(c, integer.intValue()));
        }

        public C j(C c, Integer integer, boolean z) {
            if (integer == null) {
                throw new IllegalArgumentException("Missing historic element value.");
            } else {
                return c.G(g0.G, this.b.d(b(c, integer.intValue())));
            }
        }
    }
    l(char c, int i, int i2, d dVar, int i3) {
        super(l.y(i3), c, i, i2);
        this.history = dVar;
        this.x = i3;
    }

    private void n(String str, int i) {
        if (str.length() > i) {
            final StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Element ";
            String name = name();
            String str3 = " cannot be printed as the formatted value ";
            String str4 = " exceeds the maximum width of ";
            String str5 = ".";
            str = str2 + name + str3 + str + str4 + i + str5;
            throw new IllegalArgumentException(str);
        }
    }

    private String o(j jVar, char c, int i, int i2, int i3) {
        boolean decimal;
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(jVar.toNumeral(i));
        stringBuilder.append('/');
        if (jVar.isDecimal() && i2 >= i8) {
            if (c.a(i, i8) == c.a(i2, i8)) {
                int i9 = c.c(i2, i8);
                int i6 = 10;
                if (i9 < 10) {
                    stringBuilder.append(c);
                }
                stringBuilder.append(jVar.toNumeral(i9));
            } else {
                stringBuilder.append(jVar.toNumeral(i2));
            }
        }
        if (jVar.isDecimal()) {
            return l.v(stringBuilder.toString(), i3, c);
        }
        return stringBuilder.toString();
    }

    private int r(int i, int i2, int i3) {
        int i4 = 100;
        if (i2 >= 0 && i2 < i4 && i >= i4 && i2 < i4) {
            if (Math.abs(i2 - (c.c(i, i4))) <= i3) {
                return (c.a(i, i4)) * i4 + i2;
            }
        }
        return 0x7fffffff /* Unknown resource */;
    }

    private Object readResolve() throws InvalidObjectException {
        String name = name();
        if (name.equals("YEAR_OF_ERA")) {
            return this.history.M();
        }
        if (name.equals("HISTORIC_MONTH")) {
            return this.history.C();
        }
        if (name.equals("HISTORIC_DAY_OF_MONTH")) {
            return this.history.g();
        }
        if (name.equals("HISTORIC_DAY_OF_YEAR")) {
            return this.history.h();
        }
        if (name.equals("YEAR_AFTER")) {
            return this.history.L(p.AFTER_NEW_YEAR);
        }
        if (name.equals("YEAR_BEFORE")) {
            return this.history.L(p.BEFORE_NEW_YEAR);
        }
        if (!name.equals("CENTURY_OF_ERA")) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str8 = "Unknown element: ";
            r0 = str8 + name;
            throw new InvalidObjectException(r0);
        } else {
            return this.history.b();
        }
    }

    private s u(d dVar, net.time4j.g1.m mVar) {
        return b.d((Locale)dVar.a(a.c, Locale.ROOT)).l((v)dVar.a(a.g, v.WIDE), mVar);
    }

    private static String v(String str, int i, char c) {
        final int length = str.length();
        if (i <= length) {
            return str;
        }
        final StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < i - length) {
            stringBuilder.append(c);
            i = i + 1;
        }
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    private static int x(j jVar, char c, java.lang.CharSequence charSequence, int i, ParsePosition parsePosition, g gVar) {
        int i42;
        boolean contains;
        long l;
        int i2;
        long l2 = 10;
        int i3 = 9;
        int integer;
        i42 = 0;
        i = 0;
        if (jVar.isDecimal()) {
            if (jVar == j.ARABIC) {
                c = '-';
                i42 = charSequence.charAt(i) == '-' ? 1 : i42;
            }
            if (!(gVar.isStrict())) {
                char charAt2 = jVar.getDigits().charAt(i42);
            }
            while (j.ARABIC < Math.min(i42 + 9, charSequence.length())) {
                i2 = charSequence.charAt(i42) - i42;
                l2 = 10L;
                i3 = 9;
            }
            if (i > 0x7fffffff /* Unknown resource */) {
                parsePosition.setErrorIndex(i);
                return -2147483648;
            }
            if (i42 != 0) {
                integer = i + 1;
                if (i42 != i + 1) {
                }
            }
        } else {
            i42 = i;
            while (j.ARABIC < charSequence.length()) {
            }
            if (i42 > 0) {
                i42 = i42 + i;
                long l7 = (long)(jVar.toInteger(charSequence.subSequence(i, i42).toString(), gVar));
            }
        }
        parsePosition.setIndex(i42);
        return (int)i;
    }

    private static String y(int i) {
        switch (i) {
            case 2:
                return "YEAR_OF_ERA";
            case 3:
                return "HISTORIC_MONTH";
            case 4:
                return "HISTORIC_DAY_OF_MONTH";
            case 5:
                return "HISTORIC_DAY_OF_YEAR";
            case 6:
                return "YEAR_AFTER";
            case 7:
                return "YEAR_BEFORE";
            case 8:
                return "CENTURY_OF_ERA";
            default:
                final StringBuilder stringBuilder = new StringBuilder();
                final String str2 = "Unknown element index: ";
                i = str2 + i;
                throw new UnsupportedOperationException(str2 + i);
        }
    }

    @Override // net.time4j.history.q.c
    protected <T extends q<T>> y<T, Integer> d(w<T> wVar) {
        if (wVar.w(g0.G)) {
            return new l.a(this.x, this.history);
        }
        return null;
    }

    @Override // net.time4j.history.q.c
    protected boolean e(e<?> eVar) {
        return this.history.equals(eVar.history);
    }

    @Override // net.time4j.history.q.c
    public void print(o oVar, java.lang.Appendable appendable, d dVar) {
        char charValue = 48;
        final j jVar = dVar.a(a.l, j.ARABIC);
        net.time4j.engine.c cVar2 = a.m;
        if (dVar.c(cVar2)) {
            charValue = (Character)dVar.b(a.m).charValue();
        } else {
            if (jVar.isDecimal()) {
                charValue = jVar.getDigits().charAt(0);
            } else {
                charValue = '0';
            }
        }
        this.t(oVar, appendable, dVar, jVar, charValue, 1, 10);
    }

    @Override // net.time4j.history.q.c
    public Integer q(java.lang.CharSequence charSequence, ParsePosition parsePosition, d dVar, q<?> qVar) throws ChronoException {
        char charValue = 48;
        Object obj3;
        int length;
        int i2 = 2147483647;
        boolean decimal;
        java.lang.CharSequence charSequence2;
        net.time4j.g1.m fORMAT2;
        int i3 = 2;
        Enum obj;
        int index3;
        d dVar32;
        final Object charSequence3 = this;
        charSequence2 = charSequence;
        final ParsePosition parsePosition22 = parsePosition;
        dVar32 = dVar;
        qVar42 = qVar;
        obj = c0.class;
        final int i7 = 0;
        int i5 = 0;
        int value = 3;
        if (charSequence3.x == 3) {
            if ((Integer)dVar32.a(a.u, null).intValue() == 0) {
                fORMAT2 = m.FORMAT;
                Object obj6 = dVar32.a(a.h, fORMAT2);
                if ((c0)charSequence3.u(dVar32, obj6).d(charSequence2, parsePosition22, obj, dVar32) == null && dVar32.a(a.k, Boolean.TRUE).booleanValue()) {
                    parsePosition22.setErrorIndex(-1);
                    parsePosition22.setIndex(parsePosition.getIndex());
                    if (obj6 == m.FORMAT) {
                        fORMAT2 = m.STANDALONE;
                    }
                }
                if (obj == null) {
                    return null;
                }
                return Integer.valueOf(obj.getValue());
            }
            net.time4j.engine.c cVar2 = a.m;
            if (dVar32.c(cVar2)) {
                charValue = (Character)dVar32.b(a.m).charValue();
            } else {
                if (obj2.isDecimal()) {
                    charValue = obj2.getDigits().charAt(i5);
                } else {
                    charValue = '0';
                }
            }
            if (obj2.isDecimal()) {
                g sMART22 = g.SMART;
            } else {
                obj3 = dVar32.a(a.f, g.SMART);
            }
            final int index2 = parsePosition.getIndex();
            length = l.x(obj2, charValue, charSequence, index2, parsePosition, obj3);
            index3 = parsePosition.getIndex();
            i3 = 2;
            if (charSequence3.x == 2 && index3 > index2) {
                if (!o.d.equals(charSequence3.history.w()) && index3 < charSequence.length()) {
                    charValue = '/';
                    if (charSequence2.charAt(index3) == '/') {
                        net.time4j.history.p dUAL_DATING2 = p.DUAL_DATING;
                        if (dVar32.a(d.H, dUAL_DATING2) != p.DUAL_DATING) {
                        } else {
                            i3 = index3 + 1;
                            length = l.x(obj2, charValue, charSequence, i3, parsePosition, obj3);
                            if (parsePosition.getIndex() == i3) {
                                parsePosition22.setIndex(index3);
                            } else {
                                int r4 = charSequence3.history.w().f(j.AD, length) == n.CALCULUS_PISANUS ? 2 : 1;
                                length = charSequence3.r(length, length, r4);
                                if (!obj2.isDecimal() || length == Integer.MAX_VALUE) {
                                    if (Math.abs(length - length) > r4) {
                                        parsePosition22.setIndex(index3);
                                    } else {
                                        if (Boolean.TRUE != null) {
                                            qVar42.E(c.w, length);
                                        }
                                    }
                                } else {
                                    if (Boolean.TRUE != null) {
                                        qVar42.E(c.w, length);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (index3 == index2) {
                parsePosition22.setErrorIndex(index2);
                return i7;
            }
            return Integer.valueOf(length);
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str = "Not parseable as text element: ";
        String name = name();
        r2 = str + name;
        throw new ChronoException(r2);
    }

    @Override // net.time4j.history.q.c
    public void t(o oVar, java.lang.Appendable appendable, d dVar, j jVar, char c, int i, int i2) throws ChronoException, java.io.IOException {
        net.time4j.history.h hVar;
        Object obj;
        boolean decimal;
        d dVar32;
        net.time4j.history.o oVar2;
        int i3 = 0;
        String str2;
        Object obj7;
        boolean equals;
        int i62;
        int i5 = 0;
        int i4;
        final Object oVar4 = this;
        Object appendable22 = oVar;
        dVar32 = dVar;
        final j jVar42 = jVar;
        final char c52 = c;
        if (oVar4.x == 5) {
            appendable.append(String.valueOf(oVar.p(oVar4.history.h())));
            return;
        }
        if (appendable22 instanceof a) {
            hVar = oVar4.history.e(g0.y0(appendable22));
        } else {
            Object obj3 = oVar.p(oVar4.history.f());
        }
        i5 = 0;
        if (oVar4.x != 2) {
            i2 = 3;
            if (oVar4.x != 3) {
                i = 4;
                if (oVar4.x != 4) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str6 = "Not printable as text: ";
                    String name = name();
                    r1 = str6 + name;
                    throw new ChronoException(r1);
                } else {
                    appendable.append(String.valueOf(hVar.c()));
                }
            }
            int value = (Integer)dVar.a(a.u, null).intValue();
            int i9 = hVar.f();
            if (value == 0) {
                appendable.append(u(dVar, (m)dVar.a(a.h, m.FORMAT)).g(c0.valueOf(i9)));
            } else {
                if (jVar.isDecimal()) {
                    String str3 = l.v(jVar42.toNumeral(i9), value, c52);
                }
                appendable.append(obj);
            }
        } else {
            oVar2 = oVar4.history.w();
            i4 = hVar.i();
            i3 = 0;
            if (!o.d.equals(oVar2) && i4 != i4) {
                net.time4j.history.p dUAL_DATING2 = p.DUAL_DATING;
                if (dVar.a(d.H, dUAL_DATING2) == p.DUAL_DATING) {
                    String str8 = this.o(jVar, c, i4, i4, i);
                } else {
                }
            }
            if (m.FORMAT == 0) {
                if (jVar.isDecimal()) {
                    String str7 = l.v(jVar42.toNumeral(i4), i, c52);
                } else {
                    String numeral3 = jVar42.toNumeral(i4);
                }
            }
            if (jVar.isDecimal()) {
                char charAt = jVar.getDigits().charAt(i5);
                if (c52 != charAt) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    while (i5 < i3.length()) {
                        char charAt2 = i3.charAt(i5);
                        i5 = i5 + 1;
                    }
                }
                n(str2, i2);
            }
            appendable.append(obj7);
        }
    }

    @Override // net.time4j.history.q.c
    public Integer w(java.lang.CharSequence charSequence, ParsePosition parsePosition, d dVar) {
        return q(charSequence, parsePosition, dVar, null);
    }

    @Override // net.time4j.history.q.c
    protected boolean j() {
        return false;
    }
}
