package d.v.a.a;

import android.animation.TypeEvaluator;

/* compiled from: ArgbEvaluator.java */
/* loaded from: classes.dex */
public class f implements TypeEvaluator {

    private static final f a = new f();

    public static f a() {
        return f.a;
    }

    public Object evaluate(float f, Object object, Object object2) {
        int value = object.intValue();
        final float f6 = 255f;
        float f3 = (float)(value >> 24) & 255 / f6;
        int value2 = object2.intValue();
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
