package net.time4j.history;

import net.time4j.engine.z;
import net.time4j.g0;

/* compiled from: Computus.java */
/* loaded from: classes3.dex */
public enum e {

    EASTERN,
    WESTERN;
    @Override // java.lang.Enum
    public g0 easterSunday(int i) {
        int marchDay;
        int i2 = 3;
        net.time4j.history.e wESTERN2;
        g0 g0Var;
        marchDay = marchDay(i);
        if (marchDay > 31) {
            i2 = 4;
            marchDay = marchDay - 31;
        } else {
            i2 = 3;
        }
        if (this != e.WESTERN || i <= 1582) {
            g0Var = g0.P0(m.h(i, i2, marchDay), z.MODIFIED_JULIAN_DATE);
        } else {
            g0Var = g0.K0(i, i2, marchDay);
        }
        return g0Var;
    }

    @Override // java.lang.Enum
    int marchDay(int i) {
        int i2 = 15;
        int i3 = 0;
        if (i < 532) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Out of range: ";
            i = str + i;
            throw new IllegalArgumentException(i);
        } else {
            i2 = i / 100;
            i2 = 15;
            i3 = 0;
            if (this == e.WESTERN && i > 1582) {
                int i15 = (i2 * 3) + 3 / 4;
                i2 = (i15 + 15) - (i2 * 8) + 13 / 25;
                i3 = i15 - 2;
            }
            int i5 = i % 19;
            int i19 = (i5 * 19) + i2 % 30;
            int i11 = i19 / 29;
            int i21 = (i19 + 21) - (i11 + (i19 / 28) - i11 * (i5 / 11));
            return i21 + (i21 - (i + (i / 4)) + i3 % 7 - 7) % 7 - 7;
        }
    }
}
