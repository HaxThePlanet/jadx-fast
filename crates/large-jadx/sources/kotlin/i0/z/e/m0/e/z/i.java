package kotlin.i0.z.e.m0.e.z;

import java.util.List;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.e.v;
import kotlin.i0.z.e.m0.e.w;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class i {

    public static final kotlin.i0.z.e.m0.e.z.i.a b;
    private static final kotlin.i0.z.e.m0.e.z.i c;
    private final List<v> a;

    public static final class a {
        public a(g g) {
            super();
        }

        public final kotlin.i0.z.e.m0.e.z.i a(w w) {
            int iVar;
            int i;
            kotlin.i0.z.e.m0.e.z.i obj3;
            n.f(w, "table");
            if (w.p() == 0) {
                obj3 = b();
            } else {
                obj3 = w.q();
                n.e(obj3, "table.requirementList");
                iVar = new i(obj3, 0);
                obj3 = iVar;
            }
            return obj3;
        }

        public final kotlin.i0.z.e.m0.e.z.i b() {
            return i.a();
        }
    }
    static {
        i.a aVar = new i.a(0);
        i.b = aVar;
        i iVar = new i(p.g());
        i.c = iVar;
    }

    private i(List<v> list) {
        super();
        this.a = list;
    }

    public i(List list, g g2) {
        super(list);
    }

    public static final kotlin.i0.z.e.m0.e.z.i a() {
        return i.c;
    }

    public final v b(int i) {
        return (v)p.a0(this.a, i);
    }
}
