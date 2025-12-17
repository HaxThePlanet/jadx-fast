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
import net.time4j.engine.m;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.w;
import net.time4j.engine.y;
import net.time4j.f1.c;
import net.time4j.g0;
import net.time4j.g1.a;
import net.time4j.g1.a0.a;
import net.time4j.g1.b;
import net.time4j.g1.g;
import net.time4j.g1.j;
import net.time4j.g1.m;
import net.time4j.g1.s;
import net.time4j.g1.v;
import net.time4j.history.q.c;

/* loaded from: classes3.dex */
final class l extends c implements a {

    private static final long serialVersionUID = -6283098762945747308L;
    private final net.time4j.history.d history;
    private final transient int x;

    private static class a implements y<C, Integer> {

        private final int a;
        private final net.time4j.history.d b;
        a(int i, net.time4j.history.d d2) {
            super();
            this.a = i;
            this.b = d2;
        }

        private net.time4j.history.h b(C c, int i2) {
            net.time4j.history.p bEFORE_NEW_YEAR;
            int i4;
            int i;
            net.time4j.history.h hVar;
            net.time4j.history.d dVar;
            net.time4j.history.p dUAL_DATING;
            Object jVar;
            int i5;
            int i6;
            int i3;
            net.time4j.history.p pVar;
            net.time4j.history.h obj12;
            net.time4j.history.d obj13;
            obj12 = this.b.e((g0)c.p(g0.G));
            final net.time4j.history.o oVar2 = this.b.w();
            bEFORE_NEW_YEAR = this.a;
            i4 = 1;
            switch (bEFORE_NEW_YEAR) {
                case 2:
                    obj12 = this.b.a(h.m(obj12.e(), i2, obj12.f(), obj12.c(), dUAL_DATING, oVar2));
                    break;
                case 3:
                    obj12 = this.b.a(h.k(obj12.e(), obj12.i(), i2, obj12.c()));
                    break;
                case 4:
                    obj12 = h.k(obj12.e(), obj12.i(), obj12.f(), i2);
                    break;
                case 5:
                    bEFORE_NEW_YEAR = obj12.j(this.b.w());
                    hVar = this.b.n(obj12.e(), bEFORE_NEW_YEAR);
                    obj12 = hVar;
                    obj12 = this.b.e((g0)this.b.d(hVar).T(h.e((long)obj13)));
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Out of range: ");
                    stringBuilder.append(i2);
                    obj12 = new IllegalArgumentException(stringBuilder.toString());
                    throw obj12;
                case 6:
                    bEFORE_NEW_YEAR = p.AFTER_NEW_YEAR;
                    bEFORE_NEW_YEAR = p.BEFORE_NEW_YEAR;
                    dUAL_DATING = bEFORE_NEW_YEAR;
                    obj12 = this.b.a(h.m(obj12.e(), i2, obj12.f(), obj12.c(), dUAL_DATING, oVar2));
                    break;
                case 7:
                    i = 100;
                    i9 %= i;
                    i = i10;
                    obj12 = this.b.a(h.m(obj12.e(), obj13 + i, obj12.f(), obj12.c(), p.DUAL_DATING, oVar2));
                    break;
                default:
                    obj13 = new StringBuilder();
                    obj13.append("Unknown element index: ");
                    obj13.append(this.a);
                    obj12 = new UnsupportedOperationException(obj13.toString());
                    throw obj12;
            }
            return obj12;
        }

        public p<?> d(C c) {
            UnsupportedOperationException obj2 = new UnsupportedOperationException("Never called.");
            throw obj2;
        }

        public p<?> e(C c) {
            UnsupportedOperationException obj2 = new UnsupportedOperationException("Never called.");
            throw obj2;
        }

        public Integer f(C c) {
            Object hVar;
            net.time4j.history.d dVar;
            net.time4j.history.j jVar;
            int maximumDayOfMonth;
            int i;
            int i3;
            int i2;
            net.time4j.history.j bYZANTINE;
            net.time4j.history.j obj6;
            try {
                hVar = this.b.e((g0)c.p(g0.G));
                obj6 = this.b.v(hVar.e(), hVar.j(this.b.w()));
                if (obj6 == -1) {
                } else {
                }
                return Integer.valueOf(obj6);
                obj6 = new ChronoException("Length of historic year undefined.");
                throw obj6;
                obj6 = b(c, this.b.l(hVar).getMaximumDayOfMonth(hVar));
                if (hVar.e() == j.BYZANTINE && hVar.i() == 999984973) {
                } else {
                }
                if (hVar.i() == 999984973) {
                } else {
                }
                i = 12;
                obj6 = b(c, i);
                maximumDayOfMonth = i;
                if (this.b.B(obj6)) {
                }
                return Integer.valueOf(maximumDayOfMonth);
                List list = this.b.q();
                size--;
                while (i3 >= 0) {
                    i2 = list.get(i3);
                    if (hVar.a(i2.c) < 0) {
                        break;
                    } else {
                    }
                    i3--;
                }
                i2 = list.get(i3);
                if (hVar.a(i2.c) < 0) {
                } else {
                }
                obj6 = i2.d;
                i3--;
                if (this.a == 3) {
                } else {
                }
                obj6 = obj6.f();
                obj6 = obj6.c();
                return Integer.valueOf(obj6);
                obj6 = this.b;
                if (obj6 == d.K) {
                } else {
                }
                if (obj6 == d.J) {
                } else {
                }
                i2 = 999979465;
                if (hVar.e() == j.BC) {
                }
                i2 = 999979466;
                if (obj6 == d.I) {
                } else {
                }
                i2 = 999999999;
                if (hVar.e() == j.BC) {
                }
                i2 = 1000000000;
                if (hVar.e() == j.BC) {
                } else {
                }
                obj6 = 45;
                obj6 = 9999;
                i2 = obj6;
                if (this.a == 8) {
                }
                i10++;
                return Integer.valueOf(i2);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown element index: ");
                stringBuilder.append(this.a);
                super(stringBuilder.toString());
                throw obj6;
                ChronoException exc = new ChronoException(c.getMessage(), c);
                throw exc;
                exc = exc;
                exc = exc;
                exc *= exc;
                while (exc >= 0) {
                }
                exc *= exc;
                exc *= exc;
                exc *= exc;
            }
        }

        public Integer g(C c) {
            net.time4j.history.h hVar;
            int i3;
            int i2;
            int i;
            int i4;
            net.time4j.history.h obj6;
            try {
                hVar = this.b.e((g0)c.p(g0.G));
                int i6 = this.a;
                i = 1;
                if (i6 != 2 && i6 != 6 && i6 != 7) {
                }
                if (i6 != 6) {
                }
                if (i6 != 7) {
                }
                if (i6 == 8) {
                } else {
                }
                if (this.b.B(b(c, i))) {
                }
                return Integer.valueOf(i);
                if (this.a == 5) {
                } else {
                }
                List list = this.b.q();
                size -= i;
                while (i3 >= 0) {
                    i = list.get(i3);
                    if (hVar.a(i.c) >= 0) {
                        break;
                    } else {
                    }
                    i3--;
                }
                i = list.get(i3);
                if (hVar.a(i.c) >= 0) {
                } else {
                }
                obj6 = i.c;
                i3--;
                if (this.a == 3) {
                } else {
                }
                obj6 = obj6.f();
                obj6 = obj6.c();
                return Integer.valueOf(obj6);
                obj6 = new ChronoException("Historic New Year cannot be determined.");
                throw obj6;
                if (hVar.e() == j.BYZANTINE && hVar.f() >= 9) {
                }
                if (hVar.f() >= 9) {
                }
                return null;
                return Integer.valueOf(i);
                ChronoException chronoException = new ChronoException(c.getMessage(), c);
                throw chronoException;
            }
        }

        @Override // net.time4j.engine.y
        public p getChildAtCeiling(Object object) {
            d((q)object);
            throw 0;
        }

        @Override // net.time4j.engine.y
        public p getChildAtFloor(Object object) {
            e((q)object);
            throw 0;
        }

        @Override // net.time4j.engine.y
        public Object getMaximum(Object object) {
            return f((q)object);
        }

        @Override // net.time4j.engine.y
        public Object getMinimum(Object object) {
            return g((q)object);
        }

        @Override // net.time4j.engine.y
        public Object getValue(Object object) {
            return h((q)object);
        }

        public Integer h(C c) {
            Object hVar;
            int i;
            int i2;
            int obj6;
            try {
                obj6 = c.p(g0.G);
                hVar = this.b.e((g0)obj6);
                obj6++;
                obj6 = hVar.j(this.b.w());
                obj6 = (int)i;
                obj6 = hVar.c();
                obj6 = hVar.f();
                obj6 = hVar.i();
                return Integer.valueOf(obj6);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown element index: ");
                stringBuilder.append(this.a);
                obj6 = new UnsupportedOperationException(stringBuilder.toString());
                throw obj6;
                ChronoException exc = new ChronoException(c.getMessage(), c);
                throw exc;
                exc = exc;
                exc = exc;
                exc[exc] = exc;
                exc = exc[exc];
                exc = exc[exc];
                exc = byte.class;
                return exc;
                return exc;
            }
        }

        public boolean i(C c, Integer integer2) {
            if (integer2 == null) {
                return 0;
            }
            return this.b.B(b(c, integer2.intValue()));
        }

        @Override // net.time4j.engine.y
        public boolean isValid(Object object, Object object2) {
            return i((q)object, (Integer)object2);
        }

        public C j(C c, Integer integer2, boolean z3) {
            if (integer2 == null) {
            } else {
                return c.G(g0.G, this.b.d(b(c, integer2.intValue())));
            }
            IllegalArgumentException obj2 = new IllegalArgumentException("Missing historic element value.");
            throw obj2;
        }

        @Override // net.time4j.engine.y
        public Object withValue(Object object, Object object2, boolean z3) {
            return j((q)object, (Integer)object2, z3);
        }
    }
    l(char c, int i2, int i3, net.time4j.history.d d4, int i5) {
        super(l.y(i5), c, i2, i3);
        this.history = d4;
        this.x = i5;
    }

    private void n(String string, int i2) {
        if (string.length() > i2) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Element ");
        stringBuilder.append(name());
        stringBuilder.append(" cannot be printed as the formatted value ");
        stringBuilder.append(string);
        stringBuilder.append(" exceeds the maximum width of ");
        stringBuilder.append(i2);
        stringBuilder.append(".");
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    private String o(j j, char c2, int i3, int i4, int i5) {
        boolean decimal;
        int i;
        String obj6;
        int obj7;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j.toNumeral(i3));
        stringBuilder.append('/');
        decimal = 100;
        if (j.isDecimal() && i4 >= decimal && c.a(i3, decimal) == c.a(i4, decimal)) {
            decimal = 100;
            if (i4 >= decimal) {
                if (c.a(i3, decimal) == c.a(i4, decimal)) {
                    obj6 = c.c(i4, decimal);
                    if (obj6 < 10) {
                        stringBuilder.append(c2);
                    }
                    stringBuilder.append(j.toNumeral(obj6));
                } else {
                    stringBuilder.append(j.toNumeral(i4));
                }
            } else {
            }
        } else {
        }
        if (j.isDecimal()) {
            return l.v(stringBuilder.toString(), i5, c2);
        }
        return stringBuilder.toString();
    }

    private int r(int i, int i2, int i3) {
        int i5;
        int i4;
        i5 = 100;
        int i6 = 10;
        if (i2 >= 0 && i2 < i5 && i >= i5 && i2 < i6) {
            i5 = 100;
            if (i2 < i5) {
                if (i >= i5) {
                    i6 = 10;
                    if (i2 < i6) {
                        i5 = i6;
                    }
                    if (Math.abs(i2 - i7) <= i3) {
                        return obj3 += i2;
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    private Object readResolve() {
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
        } else {
            return this.history.b();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown element: ");
        stringBuilder.append(name);
        InvalidObjectException invalidObjectException = new InvalidObjectException(stringBuilder.toString());
        throw invalidObjectException;
    }

    private s u(d d, m m2) {
        return b.d((Locale)d.a(a.c, Locale.ROOT)).l((v)d.a(a.g, v.WIDE), m2);
    }

    private static String v(String string, int i2, char c3) {
        int i;
        final int length = string.length();
        if (i2 <= length) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < i2 -= length) {
            stringBuilder.append(c3);
            i++;
        }
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    private static int x(j j, char c2, java.lang.CharSequence charSequence3, int i4, ParsePosition parsePosition5, g g6) {
        int i3;
        j aRABIC;
        int charAt;
        int i6;
        int contains;
        int i5;
        int i2;
        int i;
        Object obj9;
        int obj10;
        int obj12;
        int obj14;
        charAt = 0;
        i6 = 0;
        if (j.isDecimal()) {
            if (j == j.ARABIC && charSequence3.charAt(i4) == 45) {
                contains = charSequence3.charAt(i4) == 45 ? 1 : charAt;
            } else {
            }
            if (g6.isStrict()) {
            } else {
                charAt = j.getDigits().charAt(charAt);
            }
            obj14 = i3;
            while (i3 < Math.min(i3 + 9, charSequence3.length())) {
                charAt3 -= obj10;
                i2 = 10;
                i = 9;
                if (i5 >= 0) {
                } else {
                }
                if (charAt != 0) {
                }
                if (obj10 != charAt) {
                }
                obj10 -= charAt;
                if (obj10 >= 0) {
                }
                if (obj10 <= i) {
                }
                i8 += i5;
                obj14++;
                obj10 = charAt;
                i3++;
                if (i5 <= i) {
                } else {
                }
                i7 += i5;
                obj14++;
            }
            if (Long.compare(i6, obj9) > 0) {
                parsePosition5.setErrorIndex(i4);
                return Integer.MIN_VALUE;
            }
            if (contains != 0) {
                if (obj14 == i4 + 1) {
                } else {
                    i6 = obj9;
                    obj12 = obj14;
                }
            } else {
            }
        } else {
            i3 = i4;
            while (i3 < charSequence3.length()) {
                if (j.contains(charSequence3.charAt(i3))) {
                }
                charAt++;
                i3++;
            }
            if (charAt > 0) {
                charAt += i4;
                i6 = (long)obj9;
                obj12 = charAt;
            }
        }
        parsePosition5.setIndex(obj12);
        return (int)i6;
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
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown element index: ");
                stringBuilder.append(i);
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(stringBuilder.toString());
                throw unsupportedOperationException;
        }
    }

    protected <T extends q<T>> y<T, Integer> d(w<T> w) {
        if (w.w(g0.G)) {
            l.a obj3 = new l.a(this.x, this.history);
            return obj3;
        }
        return 0;
    }

    protected boolean e(e<?> e) {
        return this.history.equals(e.history);
    }

    @Override // net.time4j.history.q.c
    protected boolean j() {
        return 0;
    }

    @Override // net.time4j.history.q.c
    public Object parse(java.lang.CharSequence charSequence, ParsePosition parsePosition2, d d3) {
        return w(charSequence, parsePosition2, d3);
    }

    @Override // net.time4j.history.q.c
    public void print(o o, java.lang.Appendable appendable2, d d3) {
        char charValue;
        boolean z;
        final Object obj4 = obj;
        net.time4j.engine.c cVar2 = a.m;
        if (d3.c(cVar2)) {
            charValue = (Character)d3.b(cVar2).charValue();
        } else {
            if ((j)obj4.isDecimal()) {
                charValue = obj4.getDigits().charAt(false);
            } else {
                charValue = 48;
            }
        }
        this.t(o, appendable2, d3, obj4, charValue, 1, 10);
    }

    public Integer q(java.lang.CharSequence charSequence, ParsePosition parsePosition2, d d3, q<?> q4) {
        Class<c0> obj;
        char charValue;
        Object sMART2;
        int charAt;
        int index;
        g sMART;
        char dUAL_DATING;
        java.lang.CharSequence charSequence2;
        m sTANDALONE;
        int intValue;
        int i;
        Enum obj2;
        Integer valueOf;
        int index2;
        boolean booleanValue;
        int i2;
        int i4;
        d dVar;
        Boolean tRUE;
        int i3;
        final Object obj3 = this;
        java.lang.CharSequence charSequence3 = charSequence;
        final ParsePosition parsePosition4 = parsePosition2;
        dVar = d3;
        tRUE = q4;
        obj = c0.class;
        index = obj3.x;
        final int i10 = 0;
        int i6 = 0;
        if (index == 3) {
            sTANDALONE = m.FORMAT;
            Object obj7 = dVar.a(a.h, sTANDALONE);
            parsePosition4.setErrorIndex(-1);
            parsePosition4.setIndex(parsePosition2.getIndex());
            if ((Integer)dVar.a(a.u, Integer.valueOf(i6)).intValue() == 0 && (c0)obj3.u(dVar, (m)obj7).d(charSequence3, parsePosition4, obj, dVar) == null && (Boolean)dVar.a(a.k, Boolean.TRUE).booleanValue() && obj7 == sTANDALONE) {
                sTANDALONE = m.FORMAT;
                obj7 = dVar.a(a.h, sTANDALONE);
                if ((c0)obj3.u(dVar, (m)obj7).d(charSequence3, parsePosition4, obj, dVar) == null) {
                    if ((Boolean)dVar.a(a.k, Boolean.TRUE).booleanValue()) {
                        parsePosition4.setErrorIndex(-1);
                        parsePosition4.setIndex(index);
                        if (obj7 == sTANDALONE) {
                            sTANDALONE = m.STANDALONE;
                        }
                        obj2 = obj;
                    }
                }
                if (obj2 == null) {
                    return i10;
                }
                return Integer.valueOf(obj2.getValue());
            }
            final Object obj12 = obj4;
            net.time4j.engine.c cVar2 = a.m;
            if (dVar.c(cVar2)) {
                charValue = (Character)dVar.b(cVar2).charValue();
            } else {
                if ((j)obj12.isDecimal()) {
                    charValue = obj12.getDigits().charAt(i6);
                } else {
                    charValue = '0';
                }
            }
            char c = charValue;
            if (obj12.isDecimal()) {
                sMART2 = g.SMART;
            } else {
                sMART2 = dVar.a(a.f, g.SMART);
            }
            final Object obj13 = sMART2;
            final int index3 = parsePosition2.getIndex();
            i2 = l.x(obj12, c, charSequence, index3, parsePosition2, obj13);
            index2 = parsePosition2.getIndex();
            i = 2;
            dUAL_DATING = p.DUAL_DATING;
            if (obj3.x == i && index2 > index3 && !o.d.equals(obj3.history.w()) && index2 < charSequence.length() && charSequence3.charAt(index2) == 47 && dVar.a(d.H, dUAL_DATING) == dUAL_DATING) {
                if (index2 > index3) {
                    if (!o.d.equals(obj3.history.w())) {
                        if (index2 < charSequence.length()) {
                            if (charSequence3.charAt(index2) == 47) {
                                dUAL_DATING = p.DUAL_DATING;
                                if (dVar.a(d.H, dUAL_DATING) == dUAL_DATING) {
                                    dVar = index2 + 1;
                                    int i9 = i;
                                    i3 = index2;
                                    i4 = i2;
                                    i2 = l.x(obj12, c, charSequence, dVar, parsePosition2, obj13);
                                    if (parsePosition2.getIndex() == dVar) {
                                        parsePosition4.setIndex(i3);
                                        i2 = i4;
                                        index2 = i3;
                                    } else {
                                        i = obj3.history.w().f(j.AD, i4) == n.CALCULUS_PISANUS ? 2 : 1;
                                        charAt = obj3.r(i4, i2, i);
                                        if (obj12.isDecimal() && charAt != Integer.MAX_VALUE) {
                                            if (charAt != Integer.MAX_VALUE) {
                                                if (tRUE != null) {
                                                    tRUE.E(c.w, i4);
                                                }
                                                i2 = charAt;
                                            } else {
                                                if (Math.abs(i2 - i4) <= i) {
                                                    if (tRUE != null) {
                                                        tRUE.E(c.w, i4);
                                                    }
                                                } else {
                                                    parsePosition4.setIndex(i3);
                                                }
                                            }
                                        } else {
                                        }
                                    }
                                } else {
                                    i3 = index2;
                                    i4 = i2;
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            if (index2 == index3) {
                parsePosition4.setErrorIndex(index3);
                return i10;
            }
            return Integer.valueOf(i2);
        } else {
            if (index == 6) {
            } else {
                if (index == 7) {
                } else {
                    if (index == 8) {
                    } else {
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Not parseable as text element: ");
        stringBuilder.append(name());
        ChronoException chronoException = new ChronoException(stringBuilder.toString());
        throw chronoException;
    }

    @Override // net.time4j.history.q.c
    public void t(o o, java.lang.Appendable appendable2, d d3, j j4, char c5, int i6, int i7) {
        Object decimal;
        String valueOf;
        char charAt2;
        j stringBuilder;
        Object history;
        net.time4j.history.o dUAL_DATING;
        int valueOf2;
        boolean charAt;
        int contains;
        int i2;
        int i;
        final Object obj4 = this;
        Object obj = o;
        final Object obj5 = appendable2;
        stringBuilder = d3;
        final j jVar = j4;
        final char c = c5;
        if (obj4.x == 5) {
            appendable2.append(String.valueOf(o.p(obj4.history.h())));
        }
        if (obj instanceof a) {
            decimal = obj4.history.e(g0.y0((a)obj));
        } else {
            decimal = o.p(obj4.history.f());
        }
        dUAL_DATING = obj4.x;
        i2 = 0;
        if (dUAL_DATING != 2) {
            if (dUAL_DATING != 3) {
                if (dUAL_DATING != 4) {
                } else {
                    appendable2.append(String.valueOf(decimal.c()));
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Not printable as text: ");
                stringBuilder2.append(name());
                ChronoException chronoException = new ChronoException(stringBuilder2.toString());
                throw chronoException;
            }
            dUAL_DATING = (Integer)d3.a(a.u, Integer.valueOf(i2)).intValue();
            int i4 = decimal.f();
            if (dUAL_DATING == 0) {
                appendable2.append(u(d3, (m)d3.a(a.h, m.FORMAT)).g(c0.valueOf(i4)));
            } else {
                if (j4.isDecimal()) {
                    valueOf = l.v(jVar.toNumeral(i4), dUAL_DATING, c);
                }
                appendable2.append(valueOf);
            }
        } else {
            dUAL_DATING = obj4.history.w();
            i = decimal.i();
            valueOf2 = 0;
            charAt = decimal.j(dUAL_DATING);
            if (!o.d.equals(dUAL_DATING) && charAt != i) {
                charAt = decimal.j(dUAL_DATING);
                if (charAt != i) {
                    dUAL_DATING = p.DUAL_DATING;
                    if (d3.a(d.H, dUAL_DATING) == dUAL_DATING) {
                        valueOf2 = this.o(j4, c5, charAt, i, i6);
                    } else {
                        i = charAt;
                    }
                }
            }
            if (valueOf2 == 0) {
                if (j4.isDecimal()) {
                    valueOf2 = l.v(jVar.toNumeral(i), i6, c);
                } else {
                    valueOf2 = jVar.toNumeral(i);
                }
            }
            charAt2 = j4.getDigits().charAt(i2);
            if (j4.isDecimal() && c != charAt2) {
                charAt2 = j4.getDigits().charAt(i2);
                if (c != charAt2) {
                    stringBuilder = new StringBuilder();
                    while (i2 < valueOf2.length()) {
                        charAt = valueOf2.charAt(i2);
                        if (jVar.contains(charAt)) {
                        } else {
                        }
                        stringBuilder.append(charAt);
                        i2++;
                        stringBuilder.append((char)i11);
                    }
                    valueOf2 = charAt2;
                }
                n(valueOf2, i7);
            }
            appendable2.append(valueOf2);
        }
    }

    @Override // net.time4j.history.q.c
    public Integer w(java.lang.CharSequence charSequence, ParsePosition parsePosition2, d d3) {
        return q(charSequence, parsePosition2, d3, 0);
    }
}
