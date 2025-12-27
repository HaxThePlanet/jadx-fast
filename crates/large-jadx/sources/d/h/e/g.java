package d.h.e;

/* compiled from: FloatEvaluator.java */
/* loaded from: classes.dex */
public final class g implements u<Float> {

    private static final g a = new g();

    private g() {
        super();
    }

    public static g b() {
        return g.a;
    }

    public Float a(float f, Float float, Float float2) {
        float value = float.floatValue();
        return Float.valueOf(value + (f * (float2.floatValue() - value)));
    }
}
