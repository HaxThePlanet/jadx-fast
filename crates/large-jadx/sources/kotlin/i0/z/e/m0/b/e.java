package kotlin.i0.z.e.m0.b;

import kotlin.d0.d.g;
import kotlin.i0.z.e.m0.k.f;

/* loaded from: classes3.dex */
public final class e extends kotlin.i0.z.e.m0.b.h {

    public static final kotlin.i0.z.e.m0.b.e.a f;
    private static final kotlin.i0.z.e.m0.b.e g;

    public static final class a {
        public a(g g) {
            super();
        }

        public final kotlin.i0.z.e.m0.b.e a() {
            return e.M0();
        }
    }
    static {
        final int i = 0;
        e.a aVar = new e.a(i);
        e.f = aVar;
        e eVar = new e(0, 1, i);
        e.g = eVar;
    }

    public e(boolean z) {
        int obj3;
        f fVar = new f("DefaultBuiltIns");
        super(fVar);
        if (z != 0) {
            f(false);
        }
    }

    public e(boolean z, int i2, g g3) {
        int obj1;
        final int obj3 = 1;
        obj1 = i2 &= obj3 != 0 ? obj3 : obj1;
        super(obj1);
    }

    public static final kotlin.i0.z.e.m0.b.e M0() {
        return e.g;
    }

    public static final kotlin.i0.z.e.m0.b.e N0() {
        return e.f.a();
    }
}
