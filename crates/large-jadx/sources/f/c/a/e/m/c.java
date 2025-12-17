package f.c.a.e.m;

import android.animation.TypeEvaluator;

/* loaded from: classes2.dex */
public class c implements TypeEvaluator<Integer> {

    private static final f.c.a.e.m.c a;
    static {
        c cVar = new c();
        c.a = cVar;
    }

    public static f.c.a.e.m.c b() {
        return c.a;
    }

    @Override // android.animation.TypeEvaluator
    public Integer a(float f, Integer integer2, Integer integer3) {
        int obj13 = integer2.intValue();
        final int i7 = 1132396544;
        f2 /= i7;
        int obj14 = integer3.intValue();
        final long l2 = 4612136378390124954L;
        float f4 = (float)d10;
        float f6 = (float)d12;
        obj13 = (float)d14;
        double d16 = Math.pow((double)i23, obj8);
        double d18 = Math.pow((double)obj14, obj8);
        i24 *= f;
        f6 += i30;
        long l = 4601859982876761367L;
        return Integer.valueOf(obj12 |= obj13);
    }

    @Override // android.animation.TypeEvaluator
    public Object evaluate(float f, Object object2, Object object3) {
        return a(f, (Integer)object2, (Integer)object3);
    }
}
