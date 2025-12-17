package com.airbnb.lottie.y;

/* loaded from: classes.dex */
public class b {
    private static float a(float f) {
        int i;
        long l;
        int obj4;
        if (Float.compare(f, i2) <= 0) {
            f /= i;
        } else {
            obj4 = (float)i;
        }
        return obj4;
    }

    private static float b(float f) {
        int i;
        long l;
        int obj4;
        if (Float.compare(f, i2) <= 0) {
            f *= i;
        } else {
            obj4 = (float)i;
        }
        return obj4;
    }

    public static int c(float f, int i2, int i3) {
        if (i2 == i3) {
            return i2;
        }
        final int i9 = 1132396544;
        f2 /= i9;
        float f4 = b.a(f3 /= i9);
        float f6 = b.a(f5 /= i9);
        float obj8 = b.a(obj8 /= i9);
        return obj7 |= obj8;
    }
}
