package net.time4j.g1.z;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.Set;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.g1.a;
import net.time4j.g1.g;

/* loaded from: classes3.dex */
final class j implements net.time4j.g1.z.h<Integer> {

    private final net.time4j.g1.z.h<Void> a;
    private final p<Integer> b;
    private final int c;
    private final int v;
    private final boolean w;
    private final char x;
    private final g y;
    j(p<Integer> p, int i2, int i3, boolean z4) {
        int i;
        int obj5;
        super();
        this.b = p;
        this.c = i2;
        this.v = i3;
        if (!z4 && i2 == i3) {
            i = i2 == i3 ? 1 : 0;
        } else {
        }
        this.w = i;
        if (z4) {
            obj5 = new m(a.o);
        } else {
            obj5 = 0;
        }
        this.a = obj5;
        Objects.requireNonNull(p, "Missing element.");
        if (i2 < 0) {
        } else {
            if (i2 > i3) {
            } else {
                int obj2 = 9;
                if (i2 > obj2) {
                } else {
                    if (i3 > obj2) {
                    } else {
                        this.x = '0';
                        this.y = g.SMART;
                    }
                    StringBuilder obj3 = new StringBuilder();
                    obj3.append("Max digits out of range: ");
                    obj3.append(i3);
                    obj2 = new IllegalArgumentException(obj3.toString());
                    throw obj2;
                }
                StringBuilder obj4 = new StringBuilder();
                obj4.append("Min digits out of range: ");
                obj4.append(i2);
                obj2 = new IllegalArgumentException(obj4.toString());
                throw obj2;
            }
            obj5 = new StringBuilder();
            obj5.append("Max smaller than min: ");
            obj5.append(i3);
            obj5.append(" < ");
            obj5.append(i2);
            obj2 = new IllegalArgumentException(obj5.toString());
            throw obj2;
        }
        obj4 = new StringBuilder();
        obj4.append("Negative min digits: ");
        obj4.append(i2);
        obj2 = new IllegalArgumentException(obj4.toString());
        throw obj2;
    }

    private j(net.time4j.g1.z.h<Void> h, p<Integer> p2, int i3, int i4, boolean z5, char c6, g g7) {
        super();
        this.a = h;
        this.b = p2;
        this.c = i3;
        this.v = i4;
        this.w = z5;
        this.x = c6;
        this.y = g7;
    }

    private int a(BigDecimal bigDecimal, int i2, int i3) {
        final BigDecimal obj4 = BigDecimal.valueOf((long)i2);
        return bigDecimal.multiply(BigDecimal.valueOf((long)i3).subtract(obj4).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(obj4).intValueExact();
    }

    private boolean b() {
        int i;
        i = this.a != null ? 1 : 0;
        return i;
    }

    private static BigDecimal c(Number number) {
        return BigDecimal.valueOf(number.longValue());
    }

    q<?> d(q<?> q, q<?> q2) {
        net.time4j.g1.z.k fRACTION = k.FRACTION;
        if (!q2.v(fRACTION)) {
            return q;
        }
        int i = a((BigDecimal)q2.p(fRACTION), (Integer)q.w(this.b).intValue(), (Integer)q.r(this.b).intValue());
        q2.G(fRACTION, 0);
        q2.E(this.b, i);
        return q.E(this.b, i);
    }

    @Override // net.time4j.g1.z.h
    public boolean equals(Object object) {
        int i;
        boolean equals;
        p pVar;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof j) {
            if (this.b.equals(object.b) && this.c == object.c && this.v == object.v && b() == (j)object.b()) {
                if (this.c == object.c) {
                    if (this.v == object.v) {
                        if (b() == object.b()) {
                        } else {
                            i = i2;
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

    public p<Integer> getElement() {
        return this.b;
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
        Object obj;
        boolean lax;
        int i;
        boolean z;
        int i7;
        g sMART;
        int strict2;
        p pVar;
        String name;
        Object defaultMinimum;
        d dVar;
        String str;
        int i5;
        boolean strict;
        char charValue;
        Object dVar2;
        int i4;
        int i2;
        int i8;
        int i6;
        Character valueOf;
        int i9;
        char charAt;
        int i3;
        final Object obj2 = this;
        final net.time4j.g1.z.s sVar = s2;
        dVar2 = d3;
        final Object obj4 = t4;
        if (z5) {
            obj = obj2.y;
        } else {
            obj = dVar2.a(a.f, g.SMART);
        }
        final Object obj5 = obj;
        if (obj5.isLax()) {
            if (obj2.w) {
                i8 = lax;
                i6 = sMART;
            } else {
                i6 = i4;
                i8 = 0;
            }
        } else {
        }
        final int length = charSequence.length();
        if (s2.f() >= length && i8 > 0) {
            if (i8 > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Expected fraction digits not found for: ");
                stringBuilder.append(obj2.b.name());
                sVar.k(s2.f(), stringBuilder.toString());
            }
        }
        obj2.a.parse(charSequence, s2, d3, 0, z5);
        if (b() && s2.i() && i8 == 0) {
            obj2.a.parse(charSequence, s2, d3, 0, z5);
            if (s2.i()) {
                if (i8 == 0) {
                    s2.a();
                }
            }
        }
        i7 = s2.f();
        strict2 = i7 + i8;
        String str3 = " digits.";
        String str4 = "Expected at least ";
        if (strict2 > length && obj5.isStrict()) {
            if (obj5.isStrict()) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str4);
                stringBuilder2.append(i8);
                stringBuilder2.append(str3);
                sVar.k(s2.f(), stringBuilder2.toString());
            }
        }
        if (z5) {
            charValue = obj2.x;
        } else {
            charValue = (Character)dVar2.a(a.m, '0').charValue();
        }
        i9 = 0;
        while (i7 < Math.min(i6 += i7, length)) {
            i2 = charAt - charValue;
            i17 += l;
            i7++;
            i4 = 9;
        }
        BigDecimal bigDecimal = new BigDecimal(i9, length);
        BigDecimal movePointLeft = bigDecimal.movePointLeft(i7 - i13);
        if (obj2.b.name().equals("NANO_OF_SECOND")) {
            obj4.J(obj2.b, obj2.a(movePointLeft, 0, 999999999));
        } else {
            obj4.K(k.FRACTION, movePointLeft);
            pVar = obj2.b;
            obj4.K(pVar, pVar.getDefaultMinimum());
        }
        sVar.l(i7);
    }

    public int print(o o, java.lang.Appendable appendable2, d d3, Set<net.time4j.g1.z.g> set4, boolean z5) {
        BigDecimal num;
        BigDecimal stripTrailingZeros;
        char charValue;
        int length;
        int plainString;
        boolean z2;
        o oVar;
        int compareTo;
        d dVar;
        Object fLOOR;
        boolean z;
        char c;
        int i;
        int i2;
        final Object obj = this;
        oVar = o;
        final Object obj7 = appendable2;
        final Set set = set4;
        BigDecimal num2 = j.c((Number)oVar.w(obj.b));
        BigDecimal num4 = j.c((Number)oVar.r(obj.b));
        if (j.c((Number)oVar.p(obj.b)).compareTo(num4) > 0) {
            num = num4;
        }
        BigDecimal divide = num.subtract(num2).divide(num4.subtract(num2).add(BigDecimal.ONE), 9, RoundingMode.FLOOR);
        if (divide.compareTo(BigDecimal.ZERO) == 0) {
            stripTrailingZeros = BigDecimal.ZERO;
        } else {
            stripTrailingZeros = divide.stripTrailingZeros();
        }
        final BigDecimal num5 = stripTrailingZeros;
        final int i9 = 48;
        if (z5) {
            charValue = obj.x;
            dVar = d3;
        } else {
            charValue = (Character)d3.a(a.m, Character.valueOf(i9)).charValue();
        }
        c = charValue;
        final int i10 = -1;
        if (obj7 instanceof CharSequence) {
            i = length;
        } else {
            i = i10;
        }
        final int i11 = 1;
        if (num5.scale() == 0) {
            if (obj.c > 0) {
                if (b()) {
                    obj.a.print(o, appendable2, d3, set4, z5);
                    plainString = i11;
                } else {
                    plainString = i2;
                }
                oVar = obj.c;
                while (i2 < oVar) {
                    obj7.append(c);
                    i2++;
                    oVar = obj.c;
                }
                i2 = plainString + oVar;
            }
        } else {
            if (b()) {
                obj.a.print(o, appendable2, d3, set4, z5);
                i2 = i11;
            }
            plainString = num5.setScale(Math.min(Math.max(num5.scale(), obj.c), obj.v), RoundingMode.FLOOR).toPlainString();
            oVar = 2;
            while (oVar < plainString.length()) {
                obj7.append((char)i8);
                i2++;
                oVar++;
            }
        }
        if (i != i10 && i2 > i11 && set != null) {
            if (i2 > i11) {
                if (set != null) {
                    plainString = new g(obj.b, i + 1, i += i2);
                    set.add(plainString);
                }
            }
        }
        return i2;
    }

    public net.time4j.g1.z.h<Integer> quickPath(net.time4j.g1.z.c<?> c, d d2, int i3) {
        super(this.a, this.b, this.c, this.v, this.w, (Character)d2.a(a.m, '0').charValue(), (g)d2.a(a.f, g.SMART));
        return obj9;
    }

    @Override // net.time4j.g1.z.h
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append(j.class.getName());
        stringBuilder.append("[element=");
        stringBuilder.append(this.b.name());
        stringBuilder.append(", min-digits=");
        stringBuilder.append(this.c);
        stringBuilder.append(", max-digits=");
        stringBuilder.append(this.v);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public net.time4j.g1.z.h<Integer> withElement(p<Integer> p) {
        if (this.b == p) {
            return this;
        }
        j jVar = new j(p, this.c, this.v, b());
        return jVar;
    }
}
