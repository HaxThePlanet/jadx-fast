package d.h.e;

/* loaded from: classes.dex */
public class j implements d.h.e.u<Integer> {

    private static final d.h.e.j a;
    static {
        j jVar = new j();
        j.a = jVar;
    }

    public static d.h.e.j b() {
        return j.a;
    }

    @Override // d.h.e.u
    public Integer a(float f, Integer integer2, Integer integer3) {
        int obj3 = integer2.intValue();
        return Integer.valueOf((int)i);
    }

    @Override // d.h.e.u
    public Object evaluate(float f, Object object2, Object object3) {
        return a(f, (Integer)object2, (Integer)object3);
    }
}
