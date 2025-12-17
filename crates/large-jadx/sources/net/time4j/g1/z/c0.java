package net.time4j.g1.z;

import java.util.List;
import java.util.Set;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.tz.k;
import net.time4j.tz.l;
import net.time4j.tz.p;

/* loaded from: classes3.dex */
enum c0 implements net.time4j.g1.z.h<k> {

    INSTANCE;
    public p<k> getElement() {
        return b0.TIMEZONE_ID;
    }

    @Override // java.lang.Enum
    public boolean isNumerical() {
        return 0;
    }

    public void parse(java.lang.CharSequence charSequence, net.time4j.g1.z.s s2, d d3, net.time4j.g1.z.t<?> t4, boolean z5) {
        int charAt;
        int i4;
        int i5;
        int i;
        int i6;
        int i2;
        char charAt2;
        boolean letter;
        boolean equals;
        int i3;
        int compareTo;
        java.lang.CharSequence charSequence2 = charSequence;
        net.time4j.g1.z.s sVar = s2;
        net.time4j.g1.z.t tVar = t4;
        charAt = charSequence.length();
        i5 = s2.f();
        if (i5 >= charAt) {
            s2.k(i5, "Missing timezone name.");
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        i = i5;
        i6 = 45;
        while (i < charAt) {
            charAt2 = charSequence.charAt(i);
            if (charAt2 >= 97) {
            } else {
            }
            if (charAt2 >= 65) {
            } else {
            }
            if (charAt2 != i6) {
            } else {
            }
            stringBuilder2.append(charAt2);
            i++;
            i6 = 45;
            if (charAt2 != 95) {
            } else {
            }
            if (charAt2 == 47) {
            }
            if (charAt2 > 90) {
            } else {
            }
            if (charAt2 > 122) {
            } else {
            }
        }
        if (!Character.isLetter(stringBuilder2.charAt(length--))) {
            stringBuilder2.deleteCharAt(length2--);
            i--;
        }
        String string2 = stringBuilder2.toString();
        if (string2.isEmpty()) {
            s2.k(i5, "Missing valid timezone id.");
        }
        if (string2.startsWith("Etc/GMT")) {
            s2.k(i5, "Inverse Etc/GMT-Offsets are not supported, use UTC-Offsets instead.");
        }
        if (string2.equals("Z")) {
            t4.K(b0.TIMEZONE_OFFSET, p.C);
            s2.l(i);
        }
        if (!string2.equals("UTC") && !string2.equals("GMT")) {
            if (!string2.equals("GMT")) {
                if (string2.equals("UT")) {
                } else {
                    List list = l.u("INCLUDE_ALIAS");
                    i4 = 0;
                    size--;
                    while (i4 <= i2) {
                        i8 >>>= 1;
                        i3 = list.get(i9);
                        compareTo = (k)i3.a().compareTo(string2);
                        i2 = equals;
                        i4 = equals;
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot parse to timezone id: ");
                stringBuilder.append(string2);
                s2.k(i5, stringBuilder.toString());
            }
        }
        charAt = charSequence.charAt(i);
        if (charAt > i && charAt != 43 && charAt == i6) {
            charAt = charSequence.charAt(i);
            if (charAt != 43) {
                if (charAt == i6) {
                }
            }
            s2.l(i);
            e0.x.parse(charSequence, s2, d3, t4, z5);
        }
        t4.K(b0.TIMEZONE_OFFSET, p.C);
        s2.l(i);
    }

    public int print(o o, java.lang.Appendable appendable2, d d3, Set<net.time4j.g1.z.g> set4, boolean z5) {
        int i;
        Object obj3;
        int obj4;
        int obj6;
        if (!o.j()) {
        } else {
            obj6 = -1;
            if (appendable2 instanceof CharSequence) {
                obj4 = (CharSequence)appendable2.length();
            } else {
                obj4 = obj6;
            }
            String obj2 = o.t().a();
            appendable2.append(obj2);
            obj2 = obj2.length();
            if (obj4 != obj6 && obj2 > 0 && set4 != null) {
                if (obj2 > 0) {
                    if (set4 != null) {
                        obj3 = new g(b0.TIMEZONE_ID, obj4, obj4 + obj2);
                        set4.add(obj3);
                    }
                }
            }
            return obj2;
        }
        obj4 = new StringBuilder();
        obj4.append("Cannot extract timezone id from: ");
        obj4.append(o);
        obj3 = new IllegalArgumentException(obj4.toString());
        throw obj3;
    }

    public net.time4j.g1.z.h<k> quickPath(net.time4j.g1.z.c<?> c, d d2, int i3) {
        return c0.INSTANCE;
    }

    public net.time4j.g1.z.h<k> withElement(p<k> p) {
        return c0.INSTANCE;
    }
}
