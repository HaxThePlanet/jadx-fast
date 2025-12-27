package d.h.e;

/* compiled from: IntEvaluator.java */
/* loaded from: classes.dex */
public class j implements u<Integer> {

    private static final j a = new j();

    private j() {
        super();
    }

    public static j b() {
        return j.a;
    }

    public Integer a(float f, Integer integer, Integer integer2) {
        int value = integer.intValue();
        return Integer.valueOf((int)(float)value + (f * (float)(integer2.intValue() - value)));
    }
}
