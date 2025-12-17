package d.h.e;

/* loaded from: classes.dex */
public final class g implements d.h.e.u<Float> {

    private static final d.h.e.g a;
    static {
        g gVar = new g();
        g.a = gVar;
    }

    public static d.h.e.g b() {
        return g.a;
    }

    @Override // d.h.e.u
    public Float a(float f, Float float2, Float float3) {
        float obj2 = float2.floatValue();
        return Float.valueOf(obj2 += obj1);
    }

    @Override // d.h.e.u
    public Object evaluate(float f, Object object2, Object object3) {
        return a(f, (Float)object2, (Float)object3);
    }
}
