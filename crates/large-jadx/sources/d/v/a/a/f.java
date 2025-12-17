package d.v.a.a;

import android.animation.TypeEvaluator;

/* loaded from: classes.dex */
public class f implements TypeEvaluator {

    private static final d.v.a.a.f a;
    static {
        f fVar = new f();
        f.a = fVar;
    }

    public static d.v.a.a.f a() {
        return f.a;
    }

    @Override // android.animation.TypeEvaluator
    public Object evaluate(float f, Object object2, Object object3) {
        int obj13 = (Integer)object2.intValue();
        final int i7 = 1132396544;
        f2 /= i7;
        int obj14 = (Integer)object3.intValue();
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
}
