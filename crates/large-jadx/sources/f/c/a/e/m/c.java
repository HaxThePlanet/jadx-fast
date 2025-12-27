package f.c.a.e.m;

import android.animation.TypeEvaluator;

/* compiled from: ArgbEvaluatorCompat.java */
/* loaded from: classes2.dex */
public class c implements TypeEvaluator<Integer> {

    private static final c a = new c();

    public static c b() {
        return c.a;
    }

    public Integer a(float f, Integer integer, Integer integer2) {
        int value = integer.intValue();
        final float f6 = 255f;
        float f3 = (float)(value >> 24) & 255 / f6;
        int value2 = integer2.intValue();
        final double d12 = 2.2d;
        float f9 = (float)(Math.pow((double)(float)(value >> 16) & 255 / f6, d12));
        float f13 = (float)(Math.pow((double)(float)(value >> 8) & 255 / f6, d12));
        float f34 = (float)(Math.pow((double)(float)(value & 255) / f6, d12));
        double power8 = Math.pow((double)(float)(value2 >> 16) & 255 / f6, d12);
        double power9 = Math.pow((double)(float)(value2 & 255) / f6, d12);
        float f23 = (float)power8 - f9 * f;
        f13 += f28;
        double d5 = 0.45454545454545453d;
        return Integer.valueOf((Math.round((float)(Math.pow((double)(f9 + f23), d5)) * f6)) << 16 | (Math.round((f3 + (float)(value2 >> 24) & 255 / f6 - f3 * f) * f6)) << 24 | (Math.round((float)(Math.pow((double)f14, d5)) * f6)) << 8 | (Math.round((float)(Math.pow((double)(f34 + (f * (float)power9 - f34)), d5)) * f6)));
    }
}
