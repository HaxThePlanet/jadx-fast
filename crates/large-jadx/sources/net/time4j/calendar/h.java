package net.time4j.calendar;

import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.Locale;
import java.util.Map;
import net.time4j.engine.c;
import net.time4j.engine.d;
import net.time4j.g1.a;
import net.time4j.g1.a0.b;
import net.time4j.g1.b;
import net.time4j.g1.j;

/* loaded from: classes3.dex */
public final class h implements Comparable<net.time4j.calendar.h>, Serializable {

    public static final c<Character> a = null;
    public static final c<Boolean> b = null;
    private static final net.time4j.calendar.h[] c = null;
    private static final long serialVersionUID = 7544059597266533279L;
    private final int index;
    private final boolean leap;
    static {
        int i2;
        int i3;
        net.time4j.calendar.h hVar;
        int i;
        h.a = a.e("LEAP_MONTH_INDICATOR", Character.class);
        h.b = a.e("LEAP_MONTH_IS_TRAILING", Boolean.class);
        net.time4j.calendar.h[] arr = new h[24];
        int i5 = 0;
        i2 = i5;
        while (i2 < 12) {
            h hVar2 = new h(i2, i5);
            arr[i2] = hVar2;
            hVar = new h(i2, 1);
            arr[i2 + 12] = hVar;
            i2++;
        }
        h.c = arr;
    }

    private h(int i, boolean z2) {
        super();
        this.index = i;
        this.leap = z2;
    }

    public static net.time4j.calendar.h f(int i) {
        int i2;
        int i3 = 1;
        if (i < i3) {
        } else {
            if (i > 12) {
            } else {
                return h.c[i -= i3];
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Out of range: ");
        stringBuilder.append(i);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    private Object readResolve() {
        int i;
        try {
            if (this.leap) {
            } else {
            }
            i = 12;
            i = 0;
            return h.c[index += i];
            StreamCorruptedException streamCorruptedException = new StreamCorruptedException();
            throw streamCorruptedException;
        }
    }

    @Override // java.lang.Comparable
    public int a(net.time4j.calendar.h h) {
        int i;
        int index = this.index;
        final int index2 = h.index;
        if (index < index2) {
            return -1;
        }
        final int i2 = 1;
        if (index > index2) {
            return i2;
        }
        if (this.leap) {
            return obj5 ^= i2;
        }
        if (h.leap) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // java.lang.Comparable
    String c(Locale locale, j j2, d d3) {
        boolean booleanValue;
        int number;
        String str;
        Object obj5;
        String obj6;
        StringBuilder obj7;
        obj5 = b.c("generic", locale).m();
        final int i = 0;
        obj6 = b.a(j2, (Character)d3.a(a.m, Character.valueOf(j2.getDigits().charAt(i))).charValue(), getNumber());
        if (this.leap) {
            obj5 = (Character)d3.a(h.a, Character.valueOf((String)obj5.get("leap-indicator").charAt(i))).charValue();
            if ((Boolean)d3.a(h.b, Boolean.valueOf("R".equals(obj5.get("leap-alignment")))).booleanValue()) {
                obj7 = new StringBuilder();
                obj7.append(obj6);
                obj7.append(obj5);
            } else {
                super();
                obj7.append(obj5);
                obj7.append(obj6);
            }
            obj6 = obj5;
        }
        return obj6;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object object) {
        return a((h)object);
    }

    @Override // java.lang.Comparable
    public boolean e() {
        return this.leap;
    }

    @Override // java.lang.Comparable
    public boolean equals(Object object) {
        int i;
        int index;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof h) {
            if (this.index == object.index && this.leap == object.leap) {
                if (this.leap == object.leap) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // java.lang.Comparable
    public int getNumber() {
        return index++;
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        int i;
        i = this.leap ? 12 : 0;
        return index += i;
    }

    @Override // java.lang.Comparable
    public net.time4j.calendar.h i() {
        return h.c[index += 12];
    }

    @Override // java.lang.Comparable
    public String toString() {
        String valueOf;
        boolean stringBuilder;
        String str;
        if (this.leap) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("*");
            stringBuilder.append(String.valueOf(index++));
            valueOf = stringBuilder.toString();
        }
        return valueOf;
    }
}
