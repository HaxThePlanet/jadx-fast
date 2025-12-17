package kotlin.i0.z.e.m0.d.a.j0;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.o;
import kotlin.w;

/* loaded from: classes3.dex */
final class m {

    private final Map<String, kotlin.i0.z.e.m0.d.a.j0.k> a;

    public final class a {

        private final String a;
        final kotlin.i0.z.e.m0.d.a.j0.m b;
        public a(kotlin.i0.z.e.m0.d.a.j0.m m, String string2) {
            n.f(m, "this$0");
            n.f(string2, "className");
            this.b = m;
            super();
            this.a = string2;
        }

        public final void a(String string, l<? super kotlin.i0.z.e.m0.d.a.j0.m.a.a, w> l2) {
            n.f(string, "name");
            n.f(l2, "block");
            m.a.a aVar = new m.a.a(this, string);
            l2.invoke(aVar);
            o obj3 = aVar.a();
            m.a(this.b).put(obj3.c(), obj3.d());
        }

        public final String b() {
            return this.a;
        }
    }
    public m() {
        super();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.a = linkedHashMap;
    }

    public static final Map a(kotlin.i0.z.e.m0.d.a.j0.m m) {
        return m.a;
    }

    public final Map<String, kotlin.i0.z.e.m0.d.a.j0.k> b() {
        return this.a;
    }
}
