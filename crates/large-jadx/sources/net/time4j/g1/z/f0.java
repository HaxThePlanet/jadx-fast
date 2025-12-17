package net.time4j.g1.z;

import java.util.Set;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.engine.w;
import net.time4j.f1.c;
import net.time4j.g1.a;
import net.time4j.g1.g;

/* loaded from: classes3.dex */
final class f0 implements net.time4j.g1.z.h<Integer> {

    private final p<Integer> a;
    private final int b;
    private final char c;
    private final g v;
    private final int w;
    private final int x;
    static {
    }

    f0(p<Integer> p) {
        super();
        if (!p.name().startsWith("YEAR")) {
        } else {
            this.a = p;
            int obj4 = 0;
            this.b = obj4;
            this.c = '0';
            this.v = g.SMART;
            this.w = obj4;
            this.x = 100;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Year element required: ");
        stringBuilder.append(p);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    private f0(p<Integer> p, int i2, char c3, g g4, int i5, int i6) {
        super();
        this.a = p;
        this.b = i2;
        this.c = c3;
        this.v = g4;
        this.w = i5;
        this.x = i6;
    }

    private int a(boolean z, d d2) {
        Integer valueOf;
        int obj3;
        if (z) {
            obj3 = this.x;
        } else {
            obj3 = (Integer)d2.a(a.q, Integer.valueOf(this.x)).intValue();
        }
        if (obj3 < 100) {
        } else {
            return obj3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Pivot year must not be smaller than 100: ");
        stringBuilder.append(obj3);
        IllegalArgumentException obj4 = new IllegalArgumentException(stringBuilder.toString());
        throw obj4;
    }

    private static int b(int i, int i2) {
        int obj2;
        obj2 = i >= i2 % 100 ? obj2 + -1 : i2 / 100;
        return obj2 += i;
    }

    @Override // net.time4j.g1.z.h
    public boolean equals(Object object) {
        if (this == object) {
            return 1;
        }
        if (object instanceof f0) {
            return this.a.equals(object.a);
        }
        return 0;
    }

    public p<Integer> getElement() {
        return this.a;
    }

    @Override // net.time4j.g1.z.h
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // net.time4j.g1.z.h
    public boolean isNumerical() {
        return 1;
    }

    public void parse(java.lang.CharSequence charSequence, net.time4j.g1.z.s s2, d d3, net.time4j.g1.z.t<?> t4, boolean z5) {
        int length;
        int intValue;
        int i2;
        Integer valueOf2;
        Object obj;
        int i3;
        int i9;
        g sMART;
        char charValue;
        Character valueOf;
        int i6;
        int i8;
        int i;
        int i4;
        int i5;
        int i7;
        int obj11;
        final int i11 = s2.f();
        final int i12 = 0;
        if (z5) {
            intValue = this.w;
        } else {
            intValue = (Integer)d3.a(a.s, Integer.valueOf(i12)).intValue();
        }
        if (intValue > 0) {
            length -= intValue;
        }
        if (i11 >= length) {
            obj11 = new StringBuilder();
            obj11.append("Missing digits for: ");
            obj11.append(this.a.name());
            s2.k(i11, obj11.toString());
            s2.n();
        }
        if (z5) {
            obj = this.v;
        } else {
            obj = d3.a(a.f, g.SMART);
        }
        int i15 = 9;
        i3 = obj.isStrict() ? 2 : i15;
        if (z5) {
            charValue = this.c;
        } else {
            charValue = (Character)d3.a(a.m, '0').charValue();
        }
        if (this.b > 0 && intValue <= 0) {
            if (intValue <= 0) {
                i2 = i11;
                i = i12;
                while (i2 < length) {
                    charAt -= charValue;
                    if (i4 >= 0) {
                    }
                    if (i4 <= i15) {
                    }
                    i++;
                    i2++;
                }
                i3 = Math.min(i3, i -= intValue);
            }
        }
        int i13 = i11 + 2;
        i9 = 1;
        i8 = i11;
        i5 = i12;
        while (i8 < Math.min(length, i3 += i11)) {
            charAt2 -= charValue;
            i17 += i7;
            i8++;
            i9 = i12;
        }
        if (i8 < i13) {
            obj11 = new StringBuilder();
            obj11.append("Not enough digits found for: ");
            obj11.append(this.a.name());
            s2.k(i11, obj11.toString());
        }
        if (i8 == i13) {
            i5 = f0.b(i5, a(z5, d3));
        }
        t4.J(this.a, i5);
        s2.l(i8);
    }

    public int print(o o, java.lang.Appendable appendable2, d d3, Set<net.time4j.g1.z.g> set4, boolean z5) {
        int i;
        int string;
        int length;
        Character valueOf;
        char length2;
        String obj5;
        Object obj6;
        char obj7;
        net.time4j.engine.c obj9;
        i = o.e(this.a);
        if (i < 0 && i == Integer.MIN_VALUE) {
            if (i == Integer.MIN_VALUE) {
                obj7 = new StringBuilder();
                obj7.append("Format context has no year: ");
                obj7.append(o);
                obj6 = new IllegalArgumentException(obj7.toString());
                throw obj6;
            }
            obj6 = new StringBuilder();
            obj6.append("Negative year cannot be printed as two-digit-year: ");
            obj6.append(i);
            obj5 = new IllegalArgumentException(obj6.toString());
            throw obj5;
        }
        int i2 = 100;
        if (a(z5, d3) == i2) {
        } else {
            i = c.c(i, i2);
        }
        string = 48;
        if (z5) {
            obj7 = this.c;
        } else {
            obj7 = (Character)d3.a(a.m, Character.valueOf(string)).charValue();
        }
        if (obj7 != string) {
            obj5 = Integer.toString(i).toCharArray();
            valueOf = obj9;
            for (char c : o) {
                obj5[valueOf] = (char)i5;
            }
            string = new String(obj5);
            obj5 = string;
        }
        int i4 = -1;
        if (appendable2 instanceof CharSequence) {
            length = (CharSequence)appendable2.length();
        } else {
            length = i4;
        }
        if (i < 10) {
            appendable2.append(obj7);
            obj9 = 1;
        }
        appendable2.append(obj5);
        obj9 += obj5;
        if (length != i4 && obj9 > 0 && set4 != null) {
            if (obj9 > 0) {
                if (set4 != null) {
                    obj5 = new g(this.a, length, length + obj9);
                    set4.add(obj5);
                }
            }
        }
        return obj9;
    }

    public net.time4j.g1.z.h<Integer> quickPath(net.time4j.g1.z.c<?> c, d d2, int i3) {
        super(this.a, i3, (Character)d2.a(a.m, '0').charValue(), (g)d2.a(a.f, g.SMART), (Integer)d2.a(a.s, 0).intValue(), (Integer)d2.a(a.q, Integer.valueOf(c.q().d())).intValue());
        return f0Var2;
    }

    @Override // net.time4j.g1.z.h
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append(f0.class.getName());
        stringBuilder.append("[element=");
        stringBuilder.append(this.a.name());
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public net.time4j.g1.z.h<Integer> withElement(p<Integer> p) {
        if (this.a == p) {
            return this;
        }
        f0 f0Var = new f0(p);
        return f0Var;
    }
}
