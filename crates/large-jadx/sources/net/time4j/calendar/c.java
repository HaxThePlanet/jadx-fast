package net.time4j.calendar;

import java.text.ParsePosition;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class c extends net.time4j.calendar.n {

    private static final net.time4j.calendar.c[] I = null;
    private static final long serialVersionUID = 4908662352833192131L;

    class a extends net.time4j.calendar.j {

        final int a;
        final net.time4j.calendar.c b;
        a(net.time4j.calendar.c c, int i2) {
            this.b = c;
            this.a = i2;
            super();
        }

        @Override // net.time4j.calendar.j
        public int d() {
            return i4--;
        }
    }
    static {
        int i2;
        net.time4j.calendar.c cVar;
        int i;
        final int i3 = 60;
        final net.time4j.calendar.c[] arr = new c[i3];
        i2 = 0;
        while (i2 < i3) {
            i = i2 + 1;
            cVar = new c(i);
            arr[i2] = cVar;
            i2 = i;
        }
        c.I = arr;
    }

    private c(int i) {
        super(i);
    }

    public static net.time4j.calendar.c s(int i) {
        int i2;
        int i3 = 1;
        if (i < i3) {
        } else {
            if (i > 60) {
            } else {
                return c.I[i -= i3];
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Out of range: ");
        stringBuilder.append(i);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    static net.time4j.calendar.c t(java.lang.CharSequence charSequence, ParsePosition parsePosition2, Locale locale3, boolean z4) {
        int obj0;
        obj0 = n.p(charSequence, parsePosition2, locale3, z4);
        if (obj0 == null) {
            obj0 = 0;
        } else {
            obj0 = c.s(obj0.getNumber());
        }
        return obj0;
    }

    @Override // net.time4j.calendar.n
    public net.time4j.calendar.j r(int i) {
        if (i < 1) {
        } else {
            c.a aVar = new c.a(this, i);
            return aVar;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cycle number must not be smaller than 1: ");
        stringBuilder.append(i);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    @Override // net.time4j.calendar.n
    Object readResolve() {
        return c.s(super.getNumber());
    }
}
