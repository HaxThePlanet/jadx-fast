package net.time4j.calendar;

import net.time4j.f1.c;

/* loaded from: classes3.dex */
public abstract class j {

    static class a extends net.time4j.calendar.j {

        final int a;
        a(int i) {
            this.a = i;
            super();
        }

        @Override // net.time4j.calendar.j
        public int d() {
            return c.e(this.a, 2636);
        }
    }
    public static net.time4j.calendar.j a(int i) {
        if (i < 1) {
        } else {
            return j.b(c.e(i, -2333));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Dangi year must not be smaller than 1: ");
        stringBuilder.append(i);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    public static net.time4j.calendar.j b(int i) {
        j.a aVar = new j.a(i);
        return aVar;
    }

    public final int c() {
        return i4++;
    }

    public abstract int d();

    public final net.time4j.calendar.c e() {
        int i;
        int i4 = c.c(i2++, 60);
        if (i4 == 0) {
        } else {
            i = i4;
        }
        return c.s(i);
    }
}
