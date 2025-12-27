package net.time4j.calendar;

import net.time4j.f1.c;

/* compiled from: EastAsianYear.java */
/* loaded from: classes3.dex */
public abstract class j {

    static class a extends j {

        final /* synthetic */ int a;
        a(int i) {
            this.a = i;
            super();
        }

        @Override // net.time4j.calendar.j
        public int d() {
            return c.e(this.a, 2636);
        }
    }
    public static j a(int i) {
        if (i < 1) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "Dangi year must not be smaller than 1: ";
            i = str + i;
            throw new IllegalArgumentException(i);
        } else {
            return j.b(c.e(i, -2333));
        }
    }

    public static j b(int i) {
        return new j.a(i);
    }

    public final int c() {
        return (c.a((d() + 1) - 1, 60)) + 1;
    }

    public final c e() {
        int i = 60;
        i = 60;
        i = c.c(d() + 1, i);
        if (i != 0) {
        }
        return c.s(i);
    }

    public abstract int d();
}
