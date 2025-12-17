package kotlin.i0.z.e.m0.d.a.j0;

import java.util.List;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class k {

    private final kotlin.i0.z.e.m0.d.a.j0.s a;
    private final List<kotlin.i0.z.e.m0.d.a.j0.s> b;
    public k() {
        final int i = 0;
        super(i, i, 3, i);
    }

    public k(kotlin.i0.z.e.m0.d.a.j0.s s, List<kotlin.i0.z.e.m0.d.a.j0.s> list2) {
        n.f(list2, "parametersInfo");
        super();
        this.a = s;
        this.b = list2;
    }

    public k(kotlin.i0.z.e.m0.d.a.j0.s s, List list2, int i3, g g4) {
        int obj1;
        List obj2;
        obj1 = i3 & 1 != 0 ? 0 : obj1;
        if (i3 &= 2 != 0) {
            obj2 = p.g();
        }
        super(obj1, obj2);
    }

    public final List<kotlin.i0.z.e.m0.d.a.j0.s> a() {
        return this.b;
    }

    public final kotlin.i0.z.e.m0.d.a.j0.s b() {
        return this.a;
    }
}
