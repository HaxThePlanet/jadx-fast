package net.time4j.history;

import java.util.Locale;
import net.time4j.engine.i;
import net.time4j.f1.c;
import net.time4j.g1.b;
import net.time4j.g1.s;
import net.time4j.g1.v;

/* loaded from: classes3.dex */
public enum j implements i {

    BC,
    AD,
    HISPANIC,
    BYZANTINE,
    AB_URBE_CONDITA;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            j.a.a = iArr;
            iArr[j.BC.ordinal()] = 1;
            j.a.a[j.AD.ordinal()] = 2;
            j.a.a[j.HISPANIC.ordinal()] = 3;
            j.a.a[j.BYZANTINE.ordinal()] = 4;
            j.a.a[j.AB_URBE_CONDITA.ordinal()] = 5;
        }
    }
    @Override // java.lang.Enum
    public int annoDomini(int i) {
        int i3;
        int i2;
        int obj4;
        try {
            i3 = j.a.a[ordinal()];
            int i6 = 1;
            if (i3 != i6 && i3 != 2 && i3 != 3 && i3 != 4) {
            }
            if (i3 != 2) {
            }
            if (i3 != 3) {
            }
            if (i3 != 4) {
            }
            if (i3 != 5) {
            } else {
            }
            return c.l(i, 753);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(name());
            throw unsupportedOperationException;
            return c.l(i, 5508);
            obj4 = c.l(i, 38);
            return obj4;
            return c.l(i6, i);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Out of range: ");
            stringBuilder.append(i);
            i = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(i);
            throw illegalArgumentException;
        }
    }

    @Override // java.lang.Enum
    public String getAlternativeName(Locale locale, v v2) {
        String obj5;
        String[] strArr = new String[2];
        obj5 = v2 == v.WIDE ? "w" : "a";
        return b.d(locale).o(d.E().i(), obj5, "alt").g(this);
    }

    @Override // java.lang.Enum
    public String getDisplayName(Locale locale, v v2) {
        return b.d(locale).b(v2).g(this);
    }

    @Override // java.lang.Enum
    int yearOfEra(net.time4j.history.j j, int i2) {
        int i;
        int i3;
        int obj3;
        obj3 = j.annoDomini(i2);
        i = j.a.a[ordinal()];
        int i6 = 1;
        if (i != i6 && i != 2 && i != 3 && i != 4) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        try {
                            if (i != 5) {
                            } else {
                            }
                            return c.e(obj3, 753);
                            obj3 = new UnsupportedOperationException(name());
                            throw obj3;
                            return c.e(obj3, 5508);
                            obj3 = c.e(obj3, 38);
                            return obj3;
                            return c.l(i6, obj3);
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Out of range: ");
                            stringBuilder.append(i2);
                            i2 = stringBuilder.toString();
                            j = new IllegalArgumentException(i2);
                            throw j;
                        }
                    }
                }
            }
        }
    }
}
