package net.time4j.history;

import net.time4j.engine.z;
import net.time4j.g0;

/* loaded from: classes3.dex */
public enum e {

    WESTERN,
    EASTERN;
    @Override // java.lang.Enum
    public g0 easterSunday(int i) {
        int marchDay;
        int i2;
        net.time4j.history.e wESTERN;
        g0 obj4;
        marchDay = marchDay(i);
        if (marchDay > 31) {
            i2 = 4;
            marchDay += -31;
        } else {
            i2 = 3;
        }
        if (this == e.WESTERN && i > 1582) {
            if (i > 1582) {
                obj4 = g0.K0(i, i2, marchDay);
            } else {
                obj4 = g0.P0(m.h(i, i2, marchDay), i2);
            }
        } else {
        }
        return obj4;
    }

    @Override // java.lang.Enum
    int marchDay(int i) {
        int i3;
        int i2;
        int i4;
        net.time4j.history.e wESTERN;
        if (i < 532) {
        } else {
            i3 = i / 100;
            i2 = 15;
            i4 = 0;
            if (this == e.WESTERN && i > 1582) {
                if (i > 1582) {
                    i15 /= 4;
                    i4 = i16 - 2;
                    i2 = i3;
                }
            }
            int i6 = i % 19;
            i19 %= 30;
            int i12 = i20 / 29;
            i21 -= i13;
            return i22 += obj6;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Out of range: ");
        stringBuilder.append(i);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }
}
