package kotlin.i0.z.e.m0.j.b;

import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.e.c;
import kotlin.i0.z.e.m0.e.c.c;
import kotlin.i0.z.e.m0.e.z.b;
import kotlin.i0.z.e.m0.e.z.b.b;
import kotlin.i0.z.e.m0.e.z.b.d;
import kotlin.i0.z.e.m0.e.z.c;
import kotlin.i0.z.e.m0.e.z.g;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;

/* loaded from: classes3.dex */
public abstract class x {

    private final c a;
    private final g b;
    private final u0 c;

    public static final class a extends kotlin.i0.z.e.m0.j.b.x {

        private final c d;
        private final kotlin.i0.z.e.m0.j.b.x.a e;
        private final a f;
        private final c.c g;
        private final boolean h;
        public a(c c, c c2, g g3, u0 u04, kotlin.i0.z.e.m0.j.b.x.a x$a5) {
            Object obj3;
            n.f(c, "classProto");
            n.f(c2, "nameResolver");
            n.f(g3, "typeTable");
            super(c2, g3, u04, 0);
            this.d = c;
            this.e = a5;
            this.f = v.a(c2, c.h0());
            obj3 = (c.c)b.e.d(c.g0()) == null ? c.c.CLASS : obj3;
            this.g = obj3;
            Boolean obj2 = b.f.g(c.g0());
            n.e(obj2, "IS_INNER.get(classProto.flags)");
            this.h = obj2.booleanValue();
        }

        @Override // kotlin.i0.z.e.m0.j.b.x
        public b a() {
            b bVar = this.f.b();
            n.e(bVar, "classId.asSingleFqName()");
            return bVar;
        }

        @Override // kotlin.i0.z.e.m0.j.b.x
        public final a e() {
            return this.f;
        }

        @Override // kotlin.i0.z.e.m0.j.b.x
        public final c f() {
            return this.d;
        }

        @Override // kotlin.i0.z.e.m0.j.b.x
        public final c.c g() {
            return this.g;
        }

        @Override // kotlin.i0.z.e.m0.j.b.x
        public final kotlin.i0.z.e.m0.j.b.x.a h() {
            return this.e;
        }

        @Override // kotlin.i0.z.e.m0.j.b.x
        public final boolean i() {
            return this.h;
        }
    }

    public static final class b extends kotlin.i0.z.e.m0.j.b.x {

        private final b d;
        public b(b b, c c2, g g3, u0 u04) {
            n.f(b, "fqName");
            n.f(c2, "nameResolver");
            n.f(g3, "typeTable");
            super(c2, g3, u04, 0);
            this.d = b;
        }

        @Override // kotlin.i0.z.e.m0.j.b.x
        public b a() {
            return this.d;
        }
    }
    private x(c c, g g2, u0 u03) {
        super();
        this.a = c;
        this.b = g2;
        this.c = u03;
    }

    public x(c c, g g2, u0 u03, g g4) {
        super(c, g2, u03);
    }

    public abstract b a();

    public final c b() {
        return this.a;
    }

    public final u0 c() {
        return this.c;
    }

    public final g d() {
        return this.b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(": ");
        stringBuilder.append(a());
        return stringBuilder.toString();
    }
}
