package net.time4j.calendar;

import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.Locale;
import java.util.Map;
import net.time4j.engine.c;
import net.time4j.engine.d;
import net.time4j.g1.a;
import net.time4j.g1.j;

/* compiled from: EastAsianMonth.java */
/* loaded from: classes3.dex */
public final class h implements Comparable<h>, Serializable {

    public static final c<Character> a;
    public static final c<Boolean> b;
    private static final h[] c;
    private static final long serialVersionUID = 7544059597266533279L;
    private final int index;
    private final boolean leap;
    static {
        int i;
        h.a = a.e("LEAP_MONTH_INDICATOR", Character.class);
        h.b = a.e("LEAP_MONTH_IS_TRAILING", Boolean.class);
        net.time4j.calendar.h[] arr = new h[24];
        boolean z2 = false;
        i = z2;
        while (i < 12) {
            arr[i] = new h(i, z2);
            i2 = i + 12;
            boolean z = true;
            arr[i2] = new h(i, z);
            i = i + 1;
        }
        h.c = arr;
    }

    private h(int i, boolean z) {
        super();
        this.index = i;
        this.leap = z;
    }

    public static h f(int i) {
        int i3 = 1;
        if (i < i3) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "Out of range: ";
            i = str + i;
            throw new IllegalArgumentException(i);
        } else {
            int i2 = 12;
            if (i <= 12) {
                return h.c[i - i3];
            }
        }
    }

    private Object readResolve() throws StreamCorruptedException {
        int i = 12;
        try {
            int r2 = this.leap ? 12 : 0;
        } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
            throw new StreamCorruptedException();
        }
        return h.c[this.index + (this.leap ? 12 : 0)];
    }

    public int a(h hVar) {
        int i = -1;
        i = -1;
        if (this.index < hVar.index) {
            return -1;
        }
        final int i2 = 1;
        if (this.index > hVar.index) {
            return i2;
        }
        if (this.leap) {
            return hVar.leap ^ i2;
        }
        if (!(hVar.leap)) {
            i = 0;
        }
        return i;
    }

    String c(Locale locale, j jVar, d dVar) {
        String locale2;
        Map map = b.c("generic", locale).m();
        final int i = 0;
        locale2 = b.a(jVar, (Character)dVar.a(a.m, Character.valueOf(jVar.getDigits().charAt(i))).charValue(), getNumber());
        if (this.leap) {
            str = "leap-indicator";
            char charValue2 = (Character)dVar.a(h.a, Character.valueOf((String)map.get(str).charAt(i))).charValue();
            if ((Boolean)dVar.a(h.b, Boolean.valueOf("R".equals(map.get("leap-alignment")))).booleanValue()) {
                ;
                ;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                ;
                ;
            }
        }
        return locale2;
    }

    public boolean e() {
        return this.leap;
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        int index2;
        boolean leap2;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof h) {
            if (this.index == object.index) {
                if (this.leap != object.leap) {
                }
            }
            return z;
        }
        return false;
    }

    public int getNumber() {
        return this.index + 1;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 12;
        int r1 = this.leap ? 12 : 0;
        return this.index + (this.leap ? 12 : 0);
    }

    public h i() {
        return h.c[this.index + 12];
    }

    @Override // java.lang.Object
    public String toString() {
        String str;
        str = String.valueOf(this.index + 1);
        if (this.leap) {
            StringBuilder stringBuilder = new StringBuilder();
            str2 = "*";
            str = str2 + str;
        }
        return str;
    }
}
