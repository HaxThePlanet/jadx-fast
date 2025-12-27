package com.airbnb.lottie.y;

/* compiled from: GammaEvaluator.java */
/* loaded from: classes.dex */
public class b {
    private static float a(float f) {
        float f3;
        if (f <= 1025879782) {
            float f2 = 12.92f;
            f3 = f / f2;
        } else {
            double d = 2.4000000953674316d;
            f3 = (float)(Math.pow((double)(f + 0.055f) / 1.055f, d));
        }
        return f3;
    }

    private static float b(float f) {
        float f3;
        if (f <= 994913820) {
            float f2 = 12.92f;
            f3 = f * f2;
        } else {
            double d = 0.054999999701976776d;
            f3 = (float)(Math.pow((double)f, 0.4166666567325592d)) * 1.0549999475479126d - d;
        }
        return f3;
    }

    public static int c(float f, int i, int i2) {
        if (i == i2) {
            return i;
        }
        final float f6 = 255f;
        float f3 = (float)(i >> 24) & 255 / f6;
        float f9 = b.a((float)(i >> 16) & 255 / f6);
        float f13 = b.a((float)(i >> 8) & 255 / f6);
        float f34 = b.a((float)(i & 255) / f6);
        return (Math.round((b.b(f9 + (b.a((float)(i2 >> 16) & 255 / f6)) - f9 * f)) * f6)) << 16 | (Math.round((f3 + (float)(i2 >> 24) & 255 / f6 - f3 * f) * f6)) << 24 | (Math.round((b.b(f13 + (b.a((float)(i2 >> 8) & 255 / f6)) - f13 * f)) * f6)) << 8 | (Math.round((b.b(f34 + (f * (b.a((float)(i2 & 255) / f6)) - f34))) * f6));
    }
}
