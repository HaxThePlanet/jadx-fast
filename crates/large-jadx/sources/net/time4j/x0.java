package net.time4j;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.engine.n;
import net.time4j.engine.q;
import net.time4j.engine.u;
import net.time4j.f1.a;
import net.time4j.f1.b;
import net.time4j.g1.b;
import net.time4j.g1.m;
import net.time4j.g1.s;
import net.time4j.g1.v;

/* loaded from: classes3.dex */
public enum x0 implements n<a>, u<net.time4j.g0> {

    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
    public static net.time4j.x0 parse(java.lang.CharSequence charSequence, Locale locale2, v v3, m m4) {
        ParsePosition parsePosition = new ParsePosition(0);
        Enum obj3 = b.d(locale2).p(v3, m4).c(charSequence, parsePosition, x0.class);
        if ((x0)obj3 == null) {
        } else {
            return (x0)obj3;
        }
        StringBuilder obj4 = new StringBuilder();
        obj4.append("Cannot parse: ");
        obj4.append(charSequence);
        obj3 = new ParseException(obj4.toString(), parsePosition.getErrorIndex());
        throw obj3;
    }

    public static net.time4j.x0 valueOf(int i) {
        int i2;
        int i3 = 1;
        if (i < i3) {
        } else {
            if (i > 7) {
            } else {
                return x0.ENUMS[i -= i3];
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Out of range: ");
        stringBuilder.append(i);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    public static net.time4j.x0 valueOf(int i, net.time4j.c0 c02, int i3) {
        return x0.valueOf(b.c(i, c02.getValue(), i3));
    }

    public static net.time4j.x0 valueOf(int i, net.time4j.z0 z02) {
        int i2;
        int i3 = 1;
        if (i < i3) {
        } else {
            i2 = 7;
            if (i > i2) {
            } else {
                return x0.ENUMS[obj3 %= i2];
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Weekday out of range: ");
        stringBuilder.append(i);
        IllegalArgumentException obj4 = new IllegalArgumentException(stringBuilder.toString());
        throw obj4;
    }

    public static net.time4j.x0[] values(net.time4j.z0 z0) {
        int i;
        net.time4j.x0 obj3;
        final int i2 = 7;
        final net.time4j.x0[] arr = new x0[i2];
        obj3 = z0.f();
        i = 0;
        while (i < i2) {
            arr[i] = obj3;
            obj3 = obj3.next();
            i++;
        }
        return arr;
    }

    @Override // java.lang.Enum
    public Object apply(Object object) {
        return apply((g0)object);
    }

    @Override // java.lang.Enum
    public net.time4j.g0 apply(net.time4j.g0 g0) {
        return (g0)g0.G(g0.N, this);
    }

    @Override // java.lang.Enum
    public String getDisplayName(Locale locale) {
        return getDisplayName(locale, v.WIDE, m.FORMAT);
    }

    @Override // java.lang.Enum
    public String getDisplayName(Locale locale, v v2, m m3) {
        return b.d(locale).p(v2, m3).g(this);
    }

    @Override // java.lang.Enum
    public int getValue() {
        return ordinal++;
    }

    @Override // java.lang.Enum
    public int getValue(net.time4j.z0 z0) {
        return i3++;
    }

    @Override // java.lang.Enum
    public net.time4j.x0 next() {
        return roll(1);
    }

    @Override // java.lang.Enum
    public net.time4j.x0 previous() {
        return roll(-1);
    }

    @Override // java.lang.Enum
    public net.time4j.x0 roll(int i) {
        return x0.valueOf(i3++);
    }

    @Override // java.lang.Enum
    public boolean test(Object object) {
        return test((a)object);
    }

    @Override // java.lang.Enum
    public boolean test(a a) {
        int obj3;
        obj3 = b.c(a.m(), a.o(), a.q()) == getValue() ? 1 : 0;
        return obj3;
    }
}
