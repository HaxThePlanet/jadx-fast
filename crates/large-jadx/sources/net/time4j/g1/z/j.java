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

/* compiled from: FractionProcessor.java */
/* loaded from: classes3.dex */
final class j implements h<Integer> {

    private final h<Void> a;
    private final p<Integer> b;
    private final int c;
    private final int v;
    private final boolean w;
    private final char x;
    private final g y;
    j(p<Integer> pVar, int i, int i2, boolean z) {
        int i4 = 0;
        super();
        this.b = pVar;
        this.c = i;
        this.v = i2;
        int r0 = !z && i == i2 ? 1 : 0;
        this.w = (!z && i == i2 ? 1 : 0);
        if (z) {
            net.time4j.g1.z.m mVar = new m(a.o);
        } else {
            i4 = 0;
        }
        this.a = i4;
        Objects.requireNonNull(pVar, "Missing element.");
        if (i < 0) {
            StringBuilder stringBuilder2 = new StringBuilder();
            String str4 = "Negative min digits: ";
            i = str4 + i;
            throw new IllegalArgumentException(i);
        } else {
            if (i > i2) {
                StringBuilder stringBuilder4 = new StringBuilder();
                String str = "Max smaller than min: ";
                String str2 = " < ";
                i = str + i2 + str2 + i;
                throw new IllegalArgumentException(i);
            } else {
                int i5 = 9;
                if (i > i5) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    String str6 = "Min digits out of range: ";
                    i = str6 + i;
                    throw new IllegalArgumentException(i);
                } else {
                    if (i2 > i5) {
                        StringBuilder stringBuilder = new StringBuilder();
                        String str5 = "Max digits out of range: ";
                        i = str5 + i2;
                        throw new IllegalArgumentException(i);
                    } else {
                        this.x = '0';
                        this.y = g.SMART;
                        return;
                    }
                }
            }
        }
    }

    private int a(BigDecimal bigDecimal, int i, int i2) {
        final BigDecimal str = BigDecimal.valueOf((long)i);
        return bigDecimal.multiply(BigDecimal.valueOf((long)i2).subtract(str).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(str).intValueExact();
    }

    private boolean b() {
        boolean z = true;
        int r0 = this.a != null ? 1 : 0;
        return (this.a != null ? 1 : 0);
    }

    private static BigDecimal c(Number number) {
        return BigDecimal.valueOf(number.longValue());
    }

    q<?> d(q<?> qVar, q<?> qVar2) {
        net.time4j.g1.z.k fRACTION2 = k.FRACTION;
        if (!qVar2.v(fRACTION2)) {
            return qVar;
        }
        int i = a((BigDecimal)qVar2.p(k.FRACTION), (Integer)qVar.w(this.b).intValue(), (Integer)qVar.r(this.b).intValue());
        qVar2.G(k.FRACTION, null);
        qVar2.E(this.b, i);
        return qVar.E(this.b, i);
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
        if (object instanceof j) {
            if (this.b.equals(object.b)) {
                if (this.c == object.c) {
                    if (this.v == object.v) {
                        if (b() != object.b()) {
                        }
                    }
                }
            }
            return z;
        }
        return false;
    }

    public p<Integer> getElement() {
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.b.hashCode() * 7) + (this.c + (this.v * 10)) * 31;
    }

    public void parse(java.lang.CharSequence charSequence, s sVar, d dVar, t<?> tVar, boolean z) {
        Object obj;
        int i2;
        g sMART2;
        boolean z52;
        char charValue;
        d dVar32;
        int i5 = 9;
        int i6;
        int i3 = 0;
        int i7 = 0;
        char charAt;
        final Object charSequence3 = this;
        final net.time4j.g1.z.s sVar22 = sVar;
        dVar32 = dVar;
        final Object z53 = tVar;
        if (z) {
        } else {
            obj = dVar32.a(a.f, g.SMART);
        }
        i5 = 9;
        if (!obj.isLax() || charSequence3.w) {
        }
        final int length = charSequence.length();
        if (sVar.f() >= length && i3 > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String str6 = "Expected fraction digits not found for: ";
            String name = charSequence3.b.name();
            str3 = str6 + name;
            sVar22.k(sVar.f(), str3);
            return;
        }
        if (b() && sVar.i() && i3 == 0) {
            sVar.a();
            return;
        }
        i2 = sVar.f();
        i4 = i2 + i3;
        String str7 = " digits.";
        String str8 = "Expected at least ";
        if (charSequence3.v > length && obj.isStrict()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            str4 = str8 + i3 + " digits.";
            sVar22.k(sVar.f(), str4);
            return;
        }
        if (z) {
        } else {
            charValue = (Character)dVar32.a(a.m, '0').charValue();
        }
        i7 = 0;
        while (charSequence3.a < Math.min(i5 + i2, length)) {
            i6 = charSequence.charAt(i2) - charValue;
            if (i6 >= 0 && i6 <= i5) {
            }
        }
        BigDecimal movePointLeft = new BigDecimal(i7, length).movePointLeft(i2 - sVar.f());
        str = "NANO_OF_SECOND";
        if (charSequence3.b.name().equals(str)) {
            z53.J(charSequence3.b, charSequence3.a(movePointLeft, 0, 999999999));
        } else {
            z53.K(k.FRACTION, movePointLeft);
            z53.K(charSequence3.b, charSequence3.b.getDefaultMinimum());
        }
        sVar22.l(i2);
    }

    public int print(o oVar, java.lang.Appendable appendable, d dVar, Set<g> set, boolean z) throws java.io.IOException {
        BigDecimal num;
        BigDecimal stripTrailingZeros;
        char charValue;
        int i;
        int i2;
        int compareTo;
        d dVar32;
        RoundingMode fLOOR2;
        boolean z52;
        int length;
        final Object oVar3 = this;
        o oVar2 = oVar;
        final Object appendable22 = appendable;
        final Set set42 = set;
        BigDecimal num2 = j.c((Number)oVar2.w(oVar3.b));
        num = j.c((Number)oVar2.r(oVar3.b));
        if (j.c((Number)oVar2.p(oVar3.b)).compareTo(num) > 0) {
        }
        BigDecimal divide = num.subtract(num2).divide(num.subtract(num2).add(BigDecimal.ONE), 9, RoundingMode.FLOOR);
        if (divide.compareTo(BigDecimal.ZERO) == 0) {
            stripTrailingZeros = BigDecimal.ZERO;
        } else {
            stripTrailingZeros = divide.stripTrailingZeros();
        }
        final char c2 = '0';
        if (z) {
            dVar32 = dVar;
        } else {
            charValue = (Character)dVar.a(a.m, Character.valueOf(c2)).charValue();
        }
        length = -1;
        if (appendable22 instanceof CharSequence) {
        } else {
        }
        i = 0;
        i = 1;
        if (stripTrailingZeros.scale() != 0) {
            if (b()) {
                oVar3.a.print(oVar, appendable, dVar, set, z);
            }
            String plainString = stripTrailingZeros.setScale(Math.min(Math.max(stripTrailingZeros.scale(), oVar3.c), oVar3.v), RoundingMode.FLOOR).toPlainString();
            i2 = 2;
            while (oVar3.c < plainString.length()) {
                appendable22.append((char)(plainString.charAt(i2) + (charValue - c2)));
                i = i + 1;
                i2 = i2 + 1;
            }
        } else {
            if (oVar3.c > 0) {
                if (b()) {
                    oVar3.a.print(oVar, appendable, dVar, set, z);
                } else {
                }
                while (i < oVar3.c) {
                    appendable22.append(charValue);
                    i = i + 1;
                }
                i = i + i2;
            }
        }
        if (length != length && i > i && set42 != null) {
            compareTo = length + 1;
            length = length + i;
            set42.add(new g(oVar3.b, compareTo, length));
        }
        return i;
    }

    public h<Integer> quickPath(c<?> cVar, d dVar, int i) {
        j cVar2 = new j(this.a, this.b, this.c, this.v, this.w, (Character)dVar.a(a.m, '0').charValue(), (g)dVar.a(a.f, g.SMART));
        return cVar2;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        String name = j.class.getName();
        String str2 = "[element=";
        String name2 = this.b.name();
        String str3 = ", min-digits=";
        String str4 = ", max-digits=";
        str = 64 + name + str2 + name2 + str3 + this.c + str4 + this.v + 93;
        return str;
    }

    public h<Integer> withElement(p<Integer> pVar) {
        if (this.b == pVar) {
            return this;
        }
        return new j(pVar, this.c, this.v, b());
    }

    private j(h<Void> hVar, p<Integer> pVar, int i, int i2, boolean z, char c, g gVar) {
        super();
        this.a = hVar;
        this.b = pVar;
        this.c = i;
        this.v = i2;
        this.w = z;
        this.x = c;
        this.y = gVar;
    }

    public boolean isNumerical() {
        return true;
    }
}
