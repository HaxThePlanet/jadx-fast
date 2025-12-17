package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class q3 {
    static {
    }

    public static int a(int i) {
        int i2 = 1;
        int i4 = 2;
        int i3 = 3;
        int i5 = 4;
        if (i != 0 && i != i2 && i != i4 && i != i3 && i != i5) {
            i4 = 2;
            if (i != i2) {
                i3 = 3;
                if (i != i4) {
                    i5 = 4;
                    if (i != i3) {
                        if (i != i5) {
                            return 0;
                        }
                        return 5;
                    }
                    return i5;
                }
                return i3;
            }
            return i4;
        }
        return i2;
    }
}
