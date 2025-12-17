package net.time4j;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.engine.n;
import net.time4j.f1.g;
import net.time4j.g1.b;
import net.time4j.g1.m;
import net.time4j.g1.s;
import net.time4j.g1.v;

/* loaded from: classes3.dex */
public enum a0 implements n<g> {

    AM,
    PM;
    public static net.time4j.a0 ofHour(int i) {
        int i2;
        net.time4j.a0 obj3;
        if (i < 0) {
        } else {
            i2 = 24;
            if (i > i2) {
            } else {
                if (i >= 12) {
                    if (i == i2) {
                        obj3 = a0.AM;
                    } else {
                        obj3 = a0.PM;
                    }
                } else {
                }
                return obj3;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hour of day out of range: ");
        stringBuilder.append(i);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    public static net.time4j.a0 parse(java.lang.CharSequence charSequence, Locale locale2, v v3, m m4) {
        int charAt;
        int i2;
        int i;
        final int i4 = 0;
        if (charSequence.length() == 2) {
            charAt = charSequence.charAt(1);
            if (charAt != 77) {
                charAt = charSequence.charAt(i4);
                if (charAt == 109 && charAt != 65) {
                    charAt = charSequence.charAt(i4);
                    if (charAt != 65) {
                        if (charAt == 97) {
                        } else {
                            if (charAt != 80 && charAt == 112) {
                                if (charAt == 112) {
                                }
                            }
                        }
                        return a0.PM;
                    }
                }
            } else {
            }
            return a0.AM;
        }
        ParsePosition parsePosition = new ParsePosition(i4);
        Enum obj4 = b.d(locale2).h(v3, m4).c(charSequence, parsePosition, a0.class);
        if ((a0)obj4 == null) {
        } else {
            return (a0)obj4;
        }
        StringBuilder obj5 = new StringBuilder();
        obj5.append("Cannot parse: ");
        obj5.append(charSequence);
        obj4 = new ParseException(obj5.toString(), parsePosition.getErrorIndex());
        throw obj4;
    }

    @Override // java.lang.Enum
    public String getDisplayName(Locale locale) {
        return getDisplayName(locale, v.WIDE, m.FORMAT);
    }

    @Override // java.lang.Enum
    public String getDisplayName(Locale locale, v v2, m m3) {
        return b.d(locale).h(v2, m3).g(this);
    }

    @Override // java.lang.Enum
    public boolean test(Object object) {
        return test((g)object);
    }

    @Override // java.lang.Enum
    public boolean test(g g) {
        int i;
        final int obj6 = g.s();
        i = 1;
        final int i2 = 24;
        final int i4 = 12;
        if (this == a0.AM) {
            if (obj6 >= i4) {
                if (obj6 == i2) {
                } else {
                    i = i3;
                }
            }
        } else {
            if (obj6 >= i4 && obj6 < i2) {
                if (obj6 < i2) {
                } else {
                }
            } else {
            }
        }
        return i;
    }
}
