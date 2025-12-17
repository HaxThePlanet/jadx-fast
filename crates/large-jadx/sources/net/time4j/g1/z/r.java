package net.time4j.g1.z;

import java.util.Objects;
import java.util.Set;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.g0;
import net.time4j.g1.a;
import net.time4j.g1.a0.a;
import net.time4j.g1.g;
import net.time4j.g1.j;
import net.time4j.g1.l;

/* loaded from: classes3.dex */
class r<V>  implements net.time4j.g1.z.h<V> {

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
    private final net.time4j.g1.z.x w;
    private final boolean x;
    private final boolean y;
    private final g z;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            r.a.a = iArr;
            iArr[x.SHOW_ALWAYS.ordinal()] = 1;
            r.a.a[x.SHOW_WHEN_BIG_NUMBER.ordinal()] = 2;
        }
    }
    static {
        int[] iArr = new int[10];
        iArr = new int[]{9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, 2147483647};
        r.G = iArr;
    }

    r(p<V> p, boolean z2, int i3, int i4, net.time4j.g1.z.x x5, boolean z6) {
        super(p, z2, i3, i4, x5, z6, 0, 48, j.ARABIC, g.SMART, 0, 0);
    }

    private r(p<V> p, boolean z2, int i3, int i4, net.time4j.g1.z.x x5, boolean z6, int i7, char c8, j j9, g g10, int i11, boolean z12) {
        boolean obj2;
        super();
        this.a = p;
        this.b = z2;
        this.c = i3;
        this.v = i4;
        this.w = x5;
        this.x = z6;
        this.F = z12;
        Objects.requireNonNull(p, "Missing element.");
        Objects.requireNonNull(x5, "Missing sign policy.");
        if (i3 < 1) {
        } else {
            if (i3 > i4) {
            } else {
                if (z2) {
                    if (i3 != i4) {
                    } else {
                    }
                    obj2 = new StringBuilder();
                    obj2.append("Variable width in fixed-width-mode: ");
                    obj2.append(i4);
                    obj2.append(" != ");
                    obj2.append(i3);
                    IllegalArgumentException obj1 = new IllegalArgumentException(obj2.toString());
                    throw obj1;
                }
                if (z2) {
                    if (x5 != x.SHOW_NEVER) {
                    } else {
                    }
                    obj1 = new IllegalArgumentException("Sign policy must be SHOW_NEVER in fixed-width-mode.");
                    throw obj1;
                }
                obj2 = b(j9);
                if (j9.isDecimal()) {
                    if (i3 > obj2) {
                    } else {
                        if (i4 > obj2) {
                        } else {
                        }
                        obj2 = new StringBuilder();
                        obj2.append("Max digits out of range: ");
                        obj2.append(i4);
                        obj1 = new IllegalArgumentException(obj2.toString());
                        throw obj1;
                    }
                    obj2 = new StringBuilder();
                    obj2.append("Min digits out of range: ");
                    obj2.append(i3);
                    obj1 = new IllegalArgumentException(obj2.toString());
                    throw obj1;
                }
                this.y = p.name().equals("YEAR_OF_ERA");
                this.A = i7;
                this.B = c8;
                this.C = j9;
                this.z = g10;
                this.D = i11;
                this.E = obj2;
            }
            obj2 = new StringBuilder();
            obj2.append("Max smaller than min: ");
            obj2.append(i4);
            obj2.append(" < ");
            obj2.append(i3);
            obj1 = new IllegalArgumentException(obj2.toString());
            throw obj1;
        }
        obj2 = new StringBuilder();
        obj2.append("Not positive: ");
        obj2.append(i3);
        obj1 = new IllegalArgumentException(obj2.toString());
        throw obj1;
    }

    private static void a(int i, java.lang.Appendable appendable2, char c3) {
        i2 >>>= 10;
        appendable2.append((char)i4);
        appendable2.append((char)obj3);
    }

    private int b(j j) {
        Class obj2 = this.a.getType();
        if (j.isDecimal() && obj2 == Integer.class) {
            obj2 = this.a.getType();
            if (obj2 == Integer.class) {
                return 10;
            }
            if (obj2 == Long.class) {
                return 18;
            }
            return 9;
        }
        return 100;
    }

    private static int c(int i) {
        int i2;
        int i3;
        i2 = 0;
        while (i <= r.G[i2]) {
            i2++;
        }
        return i2++;
    }

    @Override // net.time4j.g1.z.h
    public boolean equals(Object object) {
        int i;
        boolean equals;
        Object pVar;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof r) {
            if (this.a.equals(object.a) && this.b == object.b && this.c == object.c && this.v == object.v && this.w == object.w && this.x == object.x) {
                if (this.b == object.b) {
                    if (this.c == object.c) {
                        if (this.v == object.v) {
                            if (this.w == object.w) {
                                if (this.x == object.x) {
                                } else {
                                    i = i2;
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
            return i;
        }
        return i2;
    }

    public p<V> getElement() {
        return this.a;
    }

    @Override // net.time4j.g1.z.h
    public int hashCode() {
        return i2 += i6;
    }

    @Override // net.time4j.g1.z.h
    public boolean isNumerical() {
        return 1;
    }

    public void parse(java.lang.CharSequence charSequence, net.time4j.g1.z.s s2, d d3, net.time4j.g1.z.t<?> t4, boolean z5) {
        int integer;
        Object valueOf;
        int i6;
        Integer str3;
        String string;
        p pVar;
        Object strict;
        char c2;
        boolean string2;
        String name;
        Object jVar;
        Class<Integer> obj3;
        net.time4j.engine.q qVar;
        int charValue;
        Object name2;
        boolean sHOW_NEVER;
        net.time4j.g1.z.x strict2;
        int i8;
        int str2;
        int length;
        int sHOW_WHEN_BIG_NUMBER;
        int i11;
        int i5;
        int charAt;
        int i16;
        long i3;
        Object sMART;
        int i9;
        int contains2;
        boolean contains;
        int i12;
        Object i10;
        boolean z2;
        int lax;
        int i13;
        int i7;
        int i4;
        net.time4j.g1.z.x strict3;
        boolean z3;
        int i14;
        char c;
        int i15;
        Object sHOW_ALWAYS;
        int i17;
        int intValue;
        boolean z;
        int i;
        int i2;
        Object obj;
        String str;
        Class<Integer> obj2;
        char obj28;
        final Object obj4 = this;
        integer = charSequence;
        pVar = s2;
        d dVar = d3;
        name2 = t4;
        Class<Integer> obj6 = Integer.class;
        length = charSequence.length();
        i5 = s2.f();
        String str14 = "Digit expected.";
        sMART = "Not enough digits found for: ";
        String str16 = "Parsed number does not fit into an integer: ";
        sHOW_ALWAYS = "Sign not allowed due to sign policy.";
        final int i31 = 0;
        String str15 = "Missing digits for: ";
        i10 = 45;
        if (z5 != 0 && obj4.F && i5 >= length) {
            if (obj4.F) {
                if (i5 >= length) {
                    StringBuilder stringBuilder8 = new StringBuilder();
                    stringBuilder8.append(str15);
                    stringBuilder8.append(obj4.a.name());
                    pVar.k(i5, stringBuilder8.toString());
                    s2.n();
                }
                char charAt2 = integer.charAt(i5);
                if (charAt2 != i10) {
                    if (charAt2 == 43) {
                    } else {
                        i19 += i5;
                        i11 = i5;
                        i12 = i31;
                        while (i11 < Math.min(length, name)) {
                            i = 48;
                            charAt6 += -48;
                            if (z3 >= 0) {
                            }
                            if (z3 <= 9) {
                            }
                            i24 += z3;
                            i11++;
                        }
                        if (Long.compare(i12, i28) > 0) {
                            StringBuilder stringBuilder7 = new StringBuilder();
                            stringBuilder7.append(str16);
                            stringBuilder7.append(i12);
                            pVar.k(i5, stringBuilder7.toString());
                        }
                        if (i11 < name) {
                            if (i11 == i5) {
                                pVar.k(i5, str14);
                            } else {
                                StringBuilder stringBuilder6 = new StringBuilder();
                                stringBuilder6.append(sMART);
                                stringBuilder6.append(obj4.a.name());
                                pVar.k(i5, stringBuilder6.toString());
                            }
                        }
                    }
                    name2.J(obj4.a, (int)i12);
                    pVar.l(i11);
                }
                pVar.k(i5, sHOW_ALWAYS);
            }
        }
        if (z5 != 0) {
            intValue = obj4.D;
        } else {
            intValue = (Integer)dVar.a(a.s, 0).intValue();
        }
        if (intValue > 0) {
            length -= intValue;
        }
        if (i5 >= length) {
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append(str15);
            stringBuilder5.append(obj4.a.name());
            pVar.k(i5, stringBuilder5.toString());
            s2.n();
        }
        z2 = obj4.a;
        if (obj4.y && z2 instanceof a) {
            z2 = obj4.a;
            if (z2 instanceof a) {
                str3 = (a)a.class.cast(z2).q(integer, s2.e(), dVar, name2);
                if (s2.i()) {
                    StringBuilder stringBuilder10 = new StringBuilder();
                    stringBuilder10.append("Unparseable element: ");
                    stringBuilder10.append(obj4.a.name());
                    pVar.k(s2.c(), stringBuilder10.toString());
                } else {
                    if (str3 == null) {
                        pVar.k(i5, "No interpretable value.");
                    } else {
                        name2.K(obj4.a, str3);
                    }
                }
            }
        }
        if (z5 != 0) {
            j jVar2 = obj4.C;
            i2 = i25;
            jVar = jVar3;
            z = decimal;
            c = c3;
            lax = 0;
        } else {
            Object obj9 = dVar.a(a.l, j.ARABIC);
            boolean decimal2 = (j)obj9.isDecimal();
            i2 = obj4.b(obj9);
            net.time4j.engine.c cVar = a.m;
            if (dVar.c(cVar)) {
                charValue = (Character)dVar.b(cVar).charValue();
                obj = obj9;
                lax = 0;
            } else {
                if (decimal2) {
                    obj = obj9;
                    charValue = obj9.getDigits().charAt(0);
                } else {
                    obj = obj9;
                    lax = 0;
                    charValue = i32;
                }
            }
            z = decimal2;
            c = charValue;
            jVar = obj;
        }
        if (z5 != 0) {
            strict = obj4.z;
            str = sMART;
        } else {
            str = sMART;
            strict = dVar.a(a.f, g.SMART);
        }
        if (z) {
            if (!obj4.b) {
                if (!strict.isLax()) {
                    i13 = obj4.c;
                    i9 = obj4.v;
                } else {
                    i9 = i2;
                    i13 = 1;
                }
            } else {
            }
        } else {
        }
        charAt = integer.charAt(i5);
        if (charAt != 45) {
            if (charAt == 43) {
                obj2 = obj6;
                if (obj4.w == x.SHOW_NEVER && !obj4.b && strict.isStrict()) {
                    if (!obj4.b) {
                        if (strict.isStrict()) {
                        }
                    }
                    pVar.k(i5, sHOW_ALWAYS);
                }
                if (obj4.w == x.SHOW_WHEN_NEGATIVE && charAt == 43 && strict.isStrict()) {
                    if (charAt == 43) {
                        if (strict.isStrict()) {
                            pVar.k(i5, "Positive sign not allowed due to sign policy.");
                        }
                    }
                }
                i8 = charAt == 45 ? 1 : 0;
                i4 = i5;
            } else {
                if (obj4.w == x.SHOW_ALWAYS && strict.isStrict()) {
                    if (strict.isStrict()) {
                        pVar.k(i5, "Missing sign of number.");
                    }
                }
                obj2 = obj6;
                i4 = i5;
                i8 = 0;
            }
        } else {
        }
        if (i5 >= length) {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(str15);
            stringBuilder4.append(obj4.a.name());
            pVar.k(i4, stringBuilder4.toString());
        }
        if (!obj4.b && obj4.A > 0 && intValue <= 0) {
            if (obj4.A > 0) {
                if (intValue <= 0) {
                    if (z) {
                        contains = i5;
                        i17 = 0;
                        while (contains < length) {
                            charAt7 -= c;
                            if (intValue <= 9) {
                                break;
                            }
                            i17++;
                            contains++;
                            charAt = obj28;
                        }
                        obj28 = charAt;
                    } else {
                        obj28 = charAt;
                        charAt = i5;
                        i17 = 0;
                        while (charAt < length) {
                            if (jVar.contains(integer.charAt(charAt)) != 0) {
                            }
                            i17++;
                            charAt++;
                        }
                    }
                    i9 = Math.min(i9, i17 -= charAt);
                } else {
                    obj28 = charAt;
                }
            } else {
            }
        } else {
        }
        i13 += i5;
        sHOW_WHEN_BIG_NUMBER = Math.min(length, i9 += i5);
        if (z) {
            i3 = i31;
            while (i5 < sHOW_WHEN_BIG_NUMBER) {
                charAt3 -= c;
                if (jVar >= 0) {
                }
                if (jVar <= true) {
                }
                i23 += sHOW_ALWAYS;
                i5++;
            }
        } else {
            i16 = 0;
            while (i5 < sHOW_WHEN_BIG_NUMBER) {
                if (jVar.contains(integer.charAt(i5)) != 0) {
                }
                i16++;
                i5++;
            }
            if (i16 > 0) {
                i3 = (long)integer;
            } else {
                i3 = i31;
            }
        }
        Class type = obj4.a.getType();
        if (Long.compare(i3, i15) > 0) {
            if (type == obj2) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(str16);
                stringBuilder3.append(i3);
                pVar.k(i4, stringBuilder3.toString());
            }
        } else {
            obj3 = obj2;
        }
        if (i5 < i26 && i5 == i4) {
            if (i5 == i4) {
                pVar.k(i4, str14);
            }
            if (!obj4.b && !strict.isLax()) {
                if (!strict.isLax()) {
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(obj4.a.name());
            pVar.k(i4, stringBuilder2.toString());
        }
        if (i8 != 0) {
            if (Long.compare(i3, i31) == 0 && strict.isStrict()) {
                if (strict.isStrict()) {
                    pVar.k(i4 -= i18, "Negative zero is not allowed.");
                }
            }
            i3 = -i3;
            c2 = obj28;
        } else {
        }
        if (type == obj3) {
            t4.J(obj4.a, (int)i3);
            pVar.l(i5);
        } else {
            qVar = t4;
            if (type == Long.class) {
                qVar.K(obj4.a, Long.valueOf(i3));
            } else {
                if (obj4.a == g0.K) {
                    qVar.J(g0.L, (int)i3);
                } else {
                    if (!Enum.class.isAssignableFrom(type)) {
                    } else {
                        valueOf = obj4.a;
                        if (valueOf instanceof l) {
                            i15 = (l)valueOf.s(qVar, (int)i3);
                        } else {
                            i15 = 0;
                        }
                        if (i15 == 0) {
                            if (c2 != 45) {
                                if (c2 == 43) {
                                    i4--;
                                }
                            } else {
                            }
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("[");
                            stringBuilder.append(obj4.a.name());
                            stringBuilder.append("] No enum found for value: ");
                            stringBuilder.append(i3);
                            pVar.k(i4, stringBuilder.toString());
                        }
                    }
                }
            }
        }
        StringBuilder stringBuilder9 = new StringBuilder();
        stringBuilder9.append("Not parseable: ");
        stringBuilder9.append(obj4.a);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder9.toString());
        throw illegalArgumentException;
    }

    public int print(o o, java.lang.Appendable appendable2, d d3, Set<net.time4j.g1.z.g> set4, boolean z5) {
        int numeral3;
        int i6;
        String string2;
        int i8;
        int gVar;
        int i7;
        int i;
        int i12;
        boolean length;
        int numeral;
        int i3;
        int string;
        int i13;
        boolean z4;
        int i2;
        int sHOW_NEVER;
        Object obj;
        int charValue;
        boolean z;
        String str;
        int i4;
        int i5;
        boolean z3;
        int stringBuilder;
        boolean z2;
        Class charArray;
        int length2;
        String str2;
        int length3;
        int i9;
        int i11;
        boolean decimal;
        String numeral2;
        int i10;
        char obj27;
        final Object obj2 = this;
        o oVar = o;
        final Object obj11 = appendable2;
        d dVar = d3;
        i4 = set4;
        Class<Long> obj3 = Long.class;
        if (obj11 instanceof CharSequence) {
            length2 = length;
        } else {
            length2 = -1;
        }
        if (z5 != 0) {
            obj = obj2.C;
            charValue = obj2.B;
        } else {
            obj = dVar.a(a.l, j.ARABIC);
            net.time4j.engine.c cVar2 = a.m;
            if (dVar.c(cVar2)) {
                charValue = (Character)dVar.b(cVar2).charValue();
            } else {
                if ((j)obj.isDecimal()) {
                    charValue = obj.getDigits().charAt(0);
                } else {
                    charValue = 48;
                }
            }
        }
        str2 = "Negative value not allowed according to sign policy.";
        final String str7 = ".";
        final String str8 = " exceeds the maximum width of ";
        String str6 = " cannot be printed as the formatted value ";
        str = "Element ";
        numeral3 = oVar.e(obj2.a);
        if (z5 != 0 && obj2.F && numeral3 < 0) {
            if (obj2.F) {
                numeral3 = oVar.e(obj2.a);
                if (numeral3 < 0) {
                    if (numeral3 != Integer.MIN_VALUE) {
                    } else {
                        return -1;
                    }
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(str2);
                    throw illegalArgumentException;
                }
                gVar = r.c(numeral3);
                if (gVar > obj2.v) {
                } else {
                    sHOW_NEVER = 0;
                    i9 = 0;
                    while (sHOW_NEVER < i23 -= gVar) {
                        obj11.append(true);
                        i9++;
                        sHOW_NEVER++;
                    }
                    stringBuilder = 48;
                    if (gVar == 2) {
                        r.a(numeral3, obj11, stringBuilder);
                    } else {
                        if (gVar == 1) {
                            obj11.append((char)i15);
                        } else {
                            numeral = 2000;
                            if (numeral3 >= numeral && numeral3 < 2100) {
                                if (numeral3 < 2100) {
                                    obj11.append('2');
                                    obj11.append(stringBuilder);
                                    r.a(numeral3 -= numeral, obj11, stringBuilder);
                                } else {
                                    i2 = 1900;
                                    if (numeral3 >= i2 && numeral3 < numeral) {
                                        if (numeral3 < numeral) {
                                            obj11.append('1');
                                            obj11.append('9');
                                            r.a(numeral3 -= i2, obj11, stringBuilder);
                                        } else {
                                            obj11.append(Integer.toString(numeral3));
                                        }
                                    } else {
                                    }
                                }
                            } else {
                            }
                        }
                    }
                    i9 += gVar;
                    i5 = length2;
                    i6 = set4;
                    if (i5 != -1 && length3 > 0 && i6 != 0) {
                        if (length3 > 0) {
                            i6 = set4;
                            if (i6 != 0) {
                                gVar = new g(obj2.a, i5, i5 + length3);
                                i6.add(gVar);
                            }
                        }
                    }
                    return length3;
                }
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append(str);
                stringBuilder4.append(obj2.a.name());
                stringBuilder4.append(str6);
                stringBuilder4.append(numeral3);
                stringBuilder4.append(str8);
                stringBuilder4.append(obj2.v);
                stringBuilder4.append(str7);
                IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException(stringBuilder4.toString());
                throw illegalArgumentException5;
            }
        }
        z2 = obj2.a;
        if (obj2.y && z2 instanceof a) {
            z2 = obj2.a;
            if (z2 instanceof a) {
                stringBuilder = new StringBuilder();
                (a)a.class.cast(z2).t(o, stringBuilder, d3, obj, charValue, obj2.c, obj2.v);
                obj11.append(stringBuilder.toString());
                length3 = stringBuilder.length();
            } else {
            }
        } else {
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("Not formattable: ");
        stringBuilder3.append(obj2.a);
        IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException(stringBuilder3.toString());
        throw illegalArgumentException4;
    }

    public net.time4j.g1.z.h<V> quickPath(net.time4j.g1.z.c<?> c, d d2, int i3) {
        boolean charValue;
        int type;
        Class<Integer> aRABIC;
        int i2;
        int i;
        final Object obj = this;
        Object obj2 = d2;
        aRABIC = j.ARABIC;
        final Object obj6 = obj4;
        net.time4j.engine.c cVar2 = a.m;
        int i4 = 48;
        int i5 = 0;
        if (obj2.c(cVar2)) {
            charValue = (Character)obj2.b(cVar2).charValue();
            i2 = charValue;
        } else {
        }
        final int intValue = (Integer)obj2.a(a.s, Integer.valueOf(i5)).intValue();
        if ((j)obj6 == aRABIC && i2 == i4 && obj.b && intValue == 0 && obj.a.getType() == Integer.class && !obj.y) {
            if (i2 == i4) {
                if (obj.b) {
                    if (intValue == 0) {
                        if (obj.a.getType() == Integer.class) {
                            i = !obj.y ? type : i5;
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
        super(obj.a, obj.b, obj.c, obj.v, obj.w, obj.x, i3, i2, (j)obj6, (g)obj2.a(a.f, g.SMART), intValue, i);
        return rVar;
    }

    @Override // net.time4j.g1.z.h
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append(r.class.getName());
        stringBuilder.append("[element=");
        stringBuilder.append(this.a.name());
        stringBuilder.append(", fixed-width-mode=");
        stringBuilder.append(this.b);
        stringBuilder.append(", min-digits=");
        stringBuilder.append(this.c);
        stringBuilder.append(", max-digits=");
        stringBuilder.append(this.v);
        stringBuilder.append(", sign-policy=");
        stringBuilder.append(this.w);
        stringBuilder.append(", protected-mode=");
        stringBuilder.append(this.x);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public net.time4j.g1.z.h<V> withElement(p<V> p) {
        boolean z;
        if (!this.x && this.a == p) {
            if (this.a == p) {
            }
            super(p, this.b, this.c, this.v, this.w, 0);
            return rVar;
        }
        return this;
    }
}
