package net.time4j;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.engine.n;
import net.time4j.engine.q;
import net.time4j.engine.u;
import net.time4j.f1.a;
import net.time4j.g1.m;
import net.time4j.g1.s;
import net.time4j.g1.v;

/* compiled from: Weekday.java */
/* loaded from: classes3.dex */
public enum x0 implements n<a>, u<g0> {

    FRIDAY,
    MONDAY,
    SATURDAY,
    SUNDAY,
    THURSDAY,
    TUESDAY,
    WEDNESDAY;
    public static x0 parse(java.lang.CharSequence charSequence, Locale locale, v vVar, m mVar) throws ParseException {
        final ParsePosition parsePosition = new ParsePosition(0);
        Enum obj = b.d(locale).p(vVar, mVar).c(charSequence, parsePosition, x0.class);
        if (obj == null) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "Cannot parse: ";
            charSequence = str + charSequence;
            throw new ParseException(charSequence, parsePosition.getErrorIndex());
        } else {
            return obj;
        }
    }

    @Override // java.lang.Enum
    public String getDisplayName(Locale locale) {
        return getDisplayName(locale, v.WIDE, m.FORMAT);
    }

    @Override // java.lang.Enum
    public int getValue() {
        return ordinal() + 1;
    }

    @Override // java.lang.Enum
    public x0 next() {
        return roll(1);
    }

    @Override // java.lang.Enum
    public x0 previous() {
        return roll(-1);
    }

    @Override // java.lang.Enum
    public x0 roll(int i) {
        return x0.valueOf((ordinal() + (i % 7) + 7) % 7 + 1);
    }

    public static x0 valueOf(int i) {
        int i3 = 1;
        if (i < i3) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "Out of range: ";
            i = str + i;
            throw new IllegalArgumentException(i);
        } else {
            int i2 = 7;
            if (i <= 7) {
                return x0.ENUMS[i - i3];
            }
        }
    }

    public static x0[] values(z0 z0Var) {
        int i = 0;
        net.time4j.x0 next;
        final int i2 = 7;
        final net.time4j.x0[] arr = new x0[i2];
        next = z0Var.f();
        i = 0;
        while (i < i2) {
            arr[i] = next;
            next = next.next();
            i = i + 1;
        }
        return arr;
    }

    @Override // java.lang.Enum
    public g0 apply(g0 g0Var) {
        return (g0)g0Var.G(g0.N, this);
    }

    @Override // java.lang.Enum
    public String getDisplayName(Locale locale, v vVar, m mVar) {
        return b.d(locale).p(vVar, mVar).g(this);
    }

    @Override // java.lang.Enum
    public int getValue(z0 z0Var) {
        return (ordinal() + 7) - z0Var.f().ordinal() % 7 + 1;
    }

    @Override // java.lang.Enum
    public boolean test(a aVar) {
        boolean z = true;
        aVar = b.c(aVar.m(), aVar.o(), aVar.q()) == getValue() ? 1 : 0;
        return (b.c(aVar.m(), aVar.o(), aVar.q()) == getValue() ? 1 : 0);
    }

    public static x0 valueOf(int i, z0 z0Var) {
        int i3 = 1;
        if (i < i3) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Weekday out of range: ";
            i = str + i;
            throw new IllegalArgumentException(i);
        } else {
            int i2 = 7;
            if (i <= i2) {
                return x0.ENUMS[(i - i3) + z0Var.f().ordinal() % i2];
            }
        }
    }

    public static x0 valueOf(int i, c0 c0Var, int i2) {
        return x0.valueOf(b.c(i, c0Var.getValue(), i2));
    }
}
