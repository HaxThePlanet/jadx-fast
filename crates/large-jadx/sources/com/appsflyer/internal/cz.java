package com.appsflyer.internal;

/* loaded from: classes.dex */
public final class cz {
    static long[] valueOf(int i, int i2) {
        int i4;
        long l;
        int i3;
        int obj8;
        int obj9;
        final int i5 = 4;
        final long[] lArr = new long[i5];
        l = 4294967295L;
        lArr[0] = obj8 |= i7;
        obj8 = 1;
        while (obj8 < i5) {
            long l3 = lArr[obj8 + -1];
            lArr[obj8] = i9 += l;
            obj8++;
        }
        return lArr;
    }
}
