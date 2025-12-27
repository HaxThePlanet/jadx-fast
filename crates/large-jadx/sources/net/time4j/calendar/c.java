package net.time4j.calendar;

import java.text.ParsePosition;
import java.util.Locale;

/* compiled from: CyclicYear.java */
/* loaded from: classes3.dex */
public final class c extends n {

    private static final c[] I;
    private static final long serialVersionUID = 4908662352833192131L;

    class a extends j {

        final /* synthetic */ int a;
        final /* synthetic */ c b;
        a(int i) {
            this.b = cVar;
            this.a = i;
            super();
        }

        @Override // net.time4j.calendar.j
        public int d() {
            return (this.a - 1) * 60 + this.b.getNumber() - 1;
        }
    }
    static {
        int i = 0;
        final int i2 = 60;
        final net.time4j.calendar.c[] arr = new c[i2];
        i = 0;
        while (i < i2) {
            i = i + 1;
            arr[i] = new c(i);
        }
        c.I = arr;
    }

    private c(int i) {
        super(i);
    }

    public static c s(int i) {
        int i3 = 1;
        if (i < i3) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "Out of range: ";
            i = str + i;
            throw new IllegalArgumentException(i);
        } else {
            int i2 = 60;
            if (i <= 60) {
                return c.I[i - i3];
            }
        }
    }

    static c t(java.lang.CharSequence charSequence, ParsePosition parsePosition, Locale locale, boolean z) {
        int i = 0;
        net.time4j.calendar.n nVar = n.p(charSequence, parsePosition, locale, z);
        if (nVar == null) {
            i = 0;
        } else {
            net.time4j.calendar.c cVar = c.s(nVar.getNumber());
        }
        return i;
    }

    @Override // net.time4j.calendar.n
    public j r(int i) {
        if (i < 1) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "Cycle number must not be smaller than 1: ";
            i = str + i;
            throw new IllegalArgumentException(i);
        } else {
            return new c.a(this, i);
        }
    }

    @Override // net.time4j.calendar.n
    Object readResolve() {
        return c.s(super.getNumber());
    }
}
