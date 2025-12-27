package net.time4j.g1.z;

import java.util.Objects;
import java.util.Set;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.g0;
import net.time4j.g1.g;
import net.time4j.g1.j;
import net.time4j.g1.l;

/* compiled from: NumberProcessor.java */
/* loaded from: classes3.dex */
class r<V> implements h<V> {

    private static final int[] G;
    private final int A;
    private final char B;
    private final j C;
    private final int D;
    private final int E;
    private final boolean F;
    private final p<V> a;
    private final boolean b;
    private final int c;
    private final int v;
    private final x w;
    private final boolean x;
    private final boolean y;
    private final g z;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[x.values().length];
            r.a.a = iArr;
            try {
                iArr[x.SHOW_ALWAYS.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                r.a.a[x.SHOW_WHEN_BIG_NUMBER.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    static {
        r.G = new int[] { 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, 0x7fffffff /* Unknown resource */ };
    }

    r(p<V> pVar, boolean z, int i, int i2, x xVar, boolean z2) {
        this(pVar, z, i, i2, xVar, z2, 0, '0', j.ARABIC, g.SMART, 0, false);
    }

    private static void a(int i, java.lang.Appendable appendable, char c) throws java.io.IOException {
        int i3 = (i * 103) >>> 10;
        appendable.append((char)(i3 + c));
        appendable.append((char)(i - (i3 << 3) + (i3 << 1)) + c);
    }

    private int b(j jVar) {
        if (jVar.isDecimal()) {
            Class type = this.a.getType();
            if (type == Integer.class) {
                return 10;
            }
            if (type == Long.class) {
                return 18;
            }
            return 9;
        }
        return 100;
    }

    private static int c(int i) {
        int i2 = 0;
        i2 = 0;
        while (i <= r.G[i2]) {
            i2 = i2 + 1;
        }
        return i2 + 1;
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        boolean equals;
        p pVar;
        boolean z2;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof r) {
            if (this.a.equals(object.a)) {
                if (this.b == object.b) {
                    if (this.c == object.c) {
                        if (this.v == object.v) {
                            if (this.w == object.w) {
                                if (this.x != object.x) {
                                }
                            }
                        }
                    }
                }
            }
            return z;
        }
        return false;
    }

    public p<V> getElement() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.a.hashCode() * 7) + (this.c + (this.v * 10)) * 31;
    }

    public void parse(java.lang.CharSequence charSequence, s sVar, d dVar, t<?> tVar, boolean z) {
        char c = 45;
        g gVar;
        char z52;
        j jVar;
        Class<Integer> obj;
        int i;
        int i2 = 0;
        net.time4j.g1.z.x xVar2;
        char c2 = 43;
        int i3;
        int length;
        int min;
        net.time4j.g1.z.x sHOW_WHEN_BIG_NUMBER2;
        int i4;
        int i5;
        int i6 = 0;
        long l;
        int i7;
        int min2;
        int i8;
        boolean z2;
        int i9;
        int i10 = 0;
        net.time4j.engine.c cVar;
        int i11 = 1;
        char c3;
        boolean z6 = false;
        boolean z4;
        String str6;
        int i13;
        int value;
        boolean decimal;
        int i14 = 48;
        String str2;
        Object obj2;
        final Object charSequence4 = this;
        java.lang.CharSequence charSequence2 = charSequence;
        sVar22 = sVar;
        d dVar32 = dVar;
        tVar42 = tVar;
        obj = Integer.class;
        length = charSequence.length();
        i5 = sVar.f();
        String str4 = "Digit expected.";
        str2 = "Not enough digits found for: ";
        String str3 = "Parsed number does not fit into an integer: ";
        str6 = "Sign not allowed due to sign policy.";
        final long l5 = 0L;
        String str24 = "Missing digits for: ";
        char c6 = '-';
        if (z && charSequence4.F && i5 >= length) {
            StringBuilder stringBuilder8 = new StringBuilder();
            String name6 = charSequence4.a.name();
            str17 = str24 + name6;
            sVar22.k(i5, str17);
            sVar.n();
            return;
        }
        int i12 = 0;
        if (z) {
        } else {
            value = (Integer)dVar32.a(a.s, null).intValue();
        }
        if (charSequence4.D > 0) {
            length = length - value;
        }
        if (i5 >= length) {
            StringBuilder stringBuilder5 = new StringBuilder();
            String name5 = charSequence4.a.name();
            str15 = str24 + name5;
            sVar22.k(i5, str15);
            sVar.n();
            return;
        }
        if (charSequence4.y && pVar14 instanceof a) {
            Integer num = (a)a.class.cast(charSequence4.a).q(charSequence2, sVar.e(), dVar32, tVar42);
            if (sVar.i()) {
                StringBuilder stringBuilder10 = new StringBuilder();
                String str22 = "Unparseable element: ";
                String name7 = charSequence4.a.name();
                str21 = str22 + name7;
                sVar22.k(sVar.c(), str21);
            } else {
                if (num == null) {
                    sVar22.k(i5, "No interpretable value.");
                } else {
                    tVar42.K(charSequence4.a, num);
                }
            }
            return;
        }
        if (z) {
            i10 = 0;
        } else {
            obj2 = dVar32.a(a.l, j.ARABIC);
            decimal = obj2.isDecimal();
            min2 = charSequence4.b(obj2);
            net.time4j.engine.c cVar2 = a.m;
            if (dVar32.c(cVar2)) {
                char charValue = (Character)dVar32.b(a.m).charValue();
                i10 = 0;
            } else {
                if (decimal) {
                    i10 = 0;
                    char charAt3 = obj2.getDigits().charAt(i10);
                } else {
                    i10 = 0;
                    i = 48;
                }
            }
        }
        if (z) {
        } else {
            Object obj5 = dVar32.a(a.f, g.SMART);
        }
        if (!decimal || !charSequence4.b) {
            i11 = 1;
        } else {
            if (!gVar.isLax()) {
            }
        }
        z52 = charSequence2.charAt(i5);
        char c4 = '-';
        if (z52 == '-' || z52 == '+') {
            if (charSequence4.w == x.SHOW_NEVER) {
                sVar22.k(i5, "Sign not allowed due to sign policy.");
                return;
            }
            if (charSequence4.w == x.SHOW_WHEN_NEGATIVE && z52 == '+' && charSequence4.a.isStrict()) {
                sVar22.k(i5, "Positive sign not allowed due to sign policy.");
                return;
            }
            int r5 = z52 == 45 ? 1 : 0;
            i5 = i5 + 1;
        }
        if (i5 >= length) {
            StringBuilder stringBuilder4 = new StringBuilder();
            String name4 = charSequence4.a.name();
            str12 = str24 + name4;
            sVar22.k(i5, str12);
            return;
        }
        if (charSequence4.b || charSequence4.A <= 0 || a.s > 0) {
        } else {
            if (decimal) {
                i13 = 0;
                while (charSequence4.b < length) {
                    value = charSequence2.charAt(i5) - c3;
                    if (a.s < 0) {
                        break;
                    }
                }
            } else {
                i13 = 0;
                while ("Digit expected." < length) {
                }
            }
            min2 = Math.min(min2, i13 - charSequence4.A);
        }
        i11 += i5;
        i8 = min2 + i5;
        min = Math.min(length, i8);
        long r8 = decimal ? l5 : 0;
        Class type = charSequence4.a.getType();
        long l4 = 2147483647L;
        if ("Digit expected." > l4) {
            if (type == obj) {
                StringBuilder stringBuilder3 = new StringBuilder();
                str11 = str3 + l;
                sVar22.k(i5, str11);
                return;
            }
        } else {
        }
        if (i5 < a.l && i5 == x.SHOW_WHEN_NEGATIVE) {
            sVar22.k(i5, str4);
            return;
        }
        if (a.class != 0) {
            if ("Digit expected." == l5 && charSequence4.a.isStrict()) {
                sVar22.k(i5 - 1, "Negative zero is not allowed.");
                return;
            }
            int i25 = -l;
        }
        if (type == a.m) {
            tVar.J(charSequence4.a, (int)l);
            sVar22.l(i5);
            return;
        } else {
            tVar42 = tVar;
            if (type != Long.class) {
                if (charSequence4.a != g0.K) {
                    if (Enum.class.isAssignableFrom(type)) {
                        if (pVar instanceof l) {
                            i3 = (int)l;
                            z6 = pVar.s(tVar42, i3);
                        } else {
                            int i29 = 0;
                        }
                        if (!j.ARABIC && charSequence4.a != '-') {
                            c = '+';
                            if (charSequence4.a == '+') {
                                i5 = i5 - 1;
                            }
                            StringBuilder stringBuilder2 = new StringBuilder();
                            String str18 = "[";
                            String name3 = charSequence4.a.name();
                            String str19 = "] No enum found for value: ";
                            str9 = str18 + name3 + str19 + l;
                            sVar22.k(i5, str9);
                            return;
                        }
                    }
                } else {
                    tVar42.J(g0.L, (int)l);
                }
            } else {
                tVar42.K(charSequence4.a, Long.valueOf(l));
            }
        }
        StringBuilder stringBuilder9 = new StringBuilder();
        String str20 = "Not parseable: ";
        r2 = str20 + charSequence4.a;
        throw new IllegalArgumentException(r2);
    }

    public int print(o oVar, java.lang.Appendable appendable, d dVar, Set<g> set, boolean z) throws java.io.IOException, java.io.UnsupportedEncodingException {
        int numeral;
        String numeral2;
        int i = 0;
        int i2;
        int i4 = -2147483648;
        int i6;
        int i7 = 48;
        char c = 50;
        int abs = -2147483648;
        int i9 = 0;
        char c2 = 43;
        Object obj;
        char charValue = 48;
        String str;
        int i12 = 2;
        int i13 = 0;
        int set42;
        int length;
        Class type;
        String str2;
        int length2;
        int i14 = 0;
        final Object oVar3 = this;
        o oVar2 = oVar;
        final Object appendable22 = appendable;
        d dVar32 = dVar;
        set42 = set;
        Class<Long> obj2 = Long.class;
        z = appendable22 instanceof CharSequence;
        if (appendable22 instanceof CharSequence) {
        } else {
            length = -1;
        }
        if (z) {
        } else {
            obj = dVar32.a(a.l, j.ARABIC);
            net.time4j.engine.c cVar2 = a.m;
            if (dVar32.c(cVar2)) {
                charValue = (Character)dVar32.b(a.m).charValue();
            } else {
                if (obj.isDecimal()) {
                    charValue = obj.getDigits().charAt(0);
                } else {
                    charValue = '0';
                }
            }
        }
        str2 = "Negative value not allowed according to sign policy.";
        final String str7 = ".";
        final String str8 = " exceeds the maximum width of ";
        String str6 = " cannot be printed as the formatted value ";
        str = "Element ";
        int i5 = Integer.MIN_VALUE;
        if (z && oVar3.F) {
            numeral = oVar2.e(oVar3.a);
            if (numeral < 0) {
                if (numeral != Integer.MIN_VALUE) {
                    throw new IllegalArgumentException(str2);
                } else {
                    return -1;
                }
            }
            i2 = r.c(numeral);
            if (i2 > oVar3.v) {
                StringBuilder stringBuilder3 = new StringBuilder();
                String name = oVar3.a.name();
                r1 = str + name + str6 + numeral + str8 + oVar3.v + ".";
                throw new IllegalArgumentException(r1);
            } else {
                i6 = oVar3.c - i2;
                i9 = 0;
                i14 = 0;
                while (i9 < Integer.MIN_VALUE) {
                    appendable22.append('0');
                    i14 = i14 + 1;
                    i9 = i9 + 1;
                }
                char c3 = '0';
                if (i2 == 2) {
                    r.a(numeral, appendable22, c3);
                } else {
                    i6 = 1;
                    if (i2 == 1) {
                        appendable22.append((char)(numeral + c3));
                    } else {
                        i6 = 2000;
                        if (numeral < i6 || numeral >= 2100) {
                            int i31 = 1900;
                            if (numeral < i31 || numeral >= i6) {
                                appendable22.append(Integer.toString(numeral));
                            } else {
                                appendable22.append('1');
                                appendable22.append('9');
                                numeral = numeral - i31;
                                r.a(numeral, appendable22, c3);
                            }
                        } else {
                            c = '2';
                            appendable22.append(c);
                            appendable22.append(c3);
                            numeral = numeral - i6;
                            r.a(numeral, appendable22, c3);
                        }
                    }
                }
                length2 = i14 + i2;
                set42 = -1;
                if (oVar3.F != oVar3.a && length2 > 0) {
                    set42 = set;
                    if (oVar3.a != 0) {
                        length = length + length2;
                        set42.add(new g(oVar3.a, length, length));
                    }
                }
                return length2;
            }
        }
        if (oVar3.y) {
            if (pVar11 instanceof a) {
                StringBuilder stringBuilder5 = new StringBuilder();
                (a)a.class.cast(oVar3.a).t(oVar, stringBuilder5, dVar, obj, charValue, i10, i11);
                appendable22.append(stringBuilder5.toString());
                length2 = stringBuilder5.length();
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        String str5 = "Not formattable: ";
        r2 = str5 + oVar3.a;
        throw new IllegalArgumentException(r2);
    }

    public h<V> quickPath(c<?> cVar, d dVar, int i) {
        Object obj;
        char charValue;
        j aRABIC2;
        boolean z6;
        final Object cVar2 = this;
        Object i33 = dVar;
        aRABIC2 = j.ARABIC;
        final j jVar = i33.a(a.l, aRABIC2);
        net.time4j.engine.c cVar4 = a.m;
        char c = '0';
        int i2 = 0;
        if (i33.c(cVar4)) {
            charValue = (Character)i33.b(a.m).charValue();
        }
        final int value = (Integer)i33.a(a.s, null).intValue();
        if (jVar == j.ARABIC && charValue == c && cVar2.b && value == 0) {
            aRABIC2 = Integer.class;
            i2 = cVar2.a.getType() != j.ARABIC || cVar2.y ? i2 : i;
        }
        r rVar = new r(cVar2.a, cVar2.b, cVar2.c, cVar2.v, cVar2.w, cVar2.x, i, charValue, jVar, (g)i33.a(a.f, g.SMART), value, z6);
        return rVar;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        String name = r.class.getName();
        String str2 = "[element=";
        String name2 = this.a.name();
        String str3 = ", fixed-width-mode=";
        String str4 = ", min-digits=";
        String str5 = ", max-digits=";
        String str6 = ", sign-policy=";
        String str7 = ", protected-mode=";
        str = 64 + name + str2 + name2 + str3 + this.b + str4 + this.c + str5 + this.v + str6 + this.w + str7 + this.x + 93;
        return str;
    }

    public h<V> withElement(p<V> pVar) {
        return this;
    }

    private r(p<V> pVar, boolean z, int i, int i2, x xVar, boolean z2, int i3, char c, j jVar, g gVar, int i4, boolean z3) {
        super();
        this.a = pVar;
        this.b = z;
        this.c = i;
        this.v = i2;
        this.w = xVar;
        this.x = z2;
        this.F = z3;
        Objects.requireNonNull(pVar, "Missing element.");
        Objects.requireNonNull(xVar, "Missing sign policy.");
        if (i < 1) {
            StringBuilder stringBuilder5 = new StringBuilder();
            String str7 = "Not positive: ";
            z = str7 + i;
            throw new IllegalArgumentException(z);
        } else {
            if (i > i2) {
                StringBuilder stringBuilder = new StringBuilder();
                String str8 = "Max smaller than min: ";
                String str4 = " < ";
                z = str8 + i2 + str4 + i;
                throw new IllegalArgumentException(z);
            } else {
                if (z) {
                    if (i != i2) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        String str9 = "Variable width in fixed-width-mode: ";
                        String str5 = " != ";
                        z = str9 + i2 + str5 + i;
                        throw new IllegalArgumentException(z);
                    }
                }
                if (z) {
                    if (xVar != x.SHOW_NEVER) {
                        throw new IllegalArgumentException("Sign policy must be SHOW_NEVER in fixed-width-mode.");
                    }
                }
                i = b(jVar);
                if (jVar.isDecimal() && i <= i) {
                    if (i2 > i) {
                        StringBuilder stringBuilder3 = new StringBuilder();
                        String str2 = "Max digits out of range: ";
                        z = str2 + i2;
                        throw new IllegalArgumentException(z);
                    }
                }
                this.y = pVar.name().equals("YEAR_OF_ERA");
                this.A = i3;
                this.B = c;
                this.C = jVar;
                this.z = gVar;
                this.D = i4;
                this.E = i;
                return;
            }
        }
    }

    public boolean isNumerical() {
        return true;
    }
}
