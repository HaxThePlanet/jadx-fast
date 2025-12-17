package kotlin.i0.z.e.m0.h;

import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.c.l;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.f.c;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.c;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.e;
import kotlin.reflect.jvm.internal.impl.descriptors.i;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.w;
import kotlin.y.q0;

/* loaded from: classes3.dex */
public abstract class c {

    public static final kotlin.i0.z.e.m0.h.c.k a;
    public static final kotlin.i0.z.e.m0.h.c b;
    public static final kotlin.i0.z.e.m0.h.c c;

    public static final class k {
        public k(g g) {
            super();
        }

        public final String a(i i) {
            boolean z;
            String obj3;
            n.f(i, "classifier");
            if (i instanceof y0) {
                obj3 = "typealias";
                return obj3;
            } else {
                if (!i instanceof e) {
                } else {
                    if ((e)i.x()) {
                        obj3 = "companion object";
                    } else {
                        switch (obj3) {
                            case 1:
                                obj3 = "class";
                                break;
                            case 2:
                                obj3 = "interface";
                                break;
                            case 3:
                                obj3 = "enum class";
                                break;
                            case 4:
                                obj3 = "object";
                                break;
                            case 5:
                                obj3 = "annotation class";
                                break;
                            case 6:
                                obj3 = "enum entry";
                                break;
                            default:
                                obj3 = new NoWhenBranchMatchedException();
                                throw obj3;
                        }
                    }
                }
            }
            AssertionError assertionError = new AssertionError(n.o("Unexpected classifier: ", i));
            throw assertionError;
        }

        public final kotlin.i0.z.e.m0.h.c b(l<? super kotlin.i0.z.e.m0.h.f, w> l) {
            n.f(l, "changeOptions");
            g gVar = new g();
            l.invoke(gVar);
            gVar.m0();
            d obj2 = new d(gVar);
            return obj2;
        }
    }

    public interface l {
        public abstract void a(c1 c1, int i2, int i3, StringBuilder stringBuilder4);

        public abstract void b(int i, StringBuilder stringBuilder2);

        public abstract void c(int i, StringBuilder stringBuilder2);

        public abstract void d(c1 c1, int i2, int i3, StringBuilder stringBuilder4);
    }

    static final class a extends p implements l<kotlin.i0.z.e.m0.h.f, w> {

        public static final kotlin.i0.z.e.m0.h.c.a a;
        static {
            c.a aVar = new c.a();
            c.a.a = aVar;
        }

        a() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(kotlin.i0.z.e.m0.h.f f) {
            n.f(f, "<this>");
            f.e(false);
            f.c(q0.b());
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((f)object);
            return w.a;
        }
    }

    static final class b extends p implements l<kotlin.i0.z.e.m0.h.f, w> {

        public static final kotlin.i0.z.e.m0.h.c.b a;
        static {
            c.b bVar = new c.b();
            c.b.a = bVar;
        }

        b() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(kotlin.i0.z.e.m0.h.f f) {
            n.f(f, "<this>");
            f.e(false);
            f.c(q0.b());
            f.h(true);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((f)object);
            return w.a;
        }
    }

    static final class c extends p implements l<kotlin.i0.z.e.m0.h.f, w> {

        public static final kotlin.i0.z.e.m0.h.c.c a;
        static {
            c.c cVar = new c.c();
            c.c.a = cVar;
        }

        c() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(kotlin.i0.z.e.m0.h.f f) {
            n.f(f, "<this>");
            f.e(false);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((f)object);
            return w.a;
        }
    }

    static final class d extends p implements l<kotlin.i0.z.e.m0.h.f, w> {

        public static final kotlin.i0.z.e.m0.h.c.d a;
        static {
            c.d dVar = new c.d();
            c.d.a = dVar;
        }

        d() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(kotlin.i0.z.e.m0.h.f f) {
            n.f(f, "<this>");
            f.c(q0.b());
            f.g(b.b.a);
            f.d(k.ONLY_NON_SYNTHESIZED);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((f)object);
            return w.a;
        }
    }

    static final class e extends p implements l<kotlin.i0.z.e.m0.h.f, w> {

        public static final kotlin.i0.z.e.m0.h.c.e a;
        static {
            c.e eVar = new c.e();
            c.e.a = eVar;
        }

        e() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(kotlin.i0.z.e.m0.h.f f) {
            n.f(f, "<this>");
            f.i(true);
            f.g(b.a.a);
            f.c(e.ALL);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((f)object);
            return w.a;
        }
    }

    static final class f extends p implements l<kotlin.i0.z.e.m0.h.f, w> {

        public static final kotlin.i0.z.e.m0.h.c.f a;
        static {
            c.f fVar = new c.f();
            c.f.a = fVar;
        }

        f() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(kotlin.i0.z.e.m0.h.f f) {
            n.f(f, "<this>");
            f.c(e.ALL_EXCEPT_ANNOTATIONS);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((f)object);
            return w.a;
        }
    }

    static final class g extends p implements l<kotlin.i0.z.e.m0.h.f, w> {

        public static final kotlin.i0.z.e.m0.h.c.g a;
        static {
            c.g gVar = new c.g();
            c.g.a = gVar;
        }

        g() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(kotlin.i0.z.e.m0.h.f f) {
            n.f(f, "<this>");
            f.c(e.ALL);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((f)object);
            return w.a;
        }
    }

    static final class h extends p implements l<kotlin.i0.z.e.m0.h.f, w> {

        public static final kotlin.i0.z.e.m0.h.c.h a;
        static {
            c.h hVar = new c.h();
            c.h.a = hVar;
        }

        h() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(kotlin.i0.z.e.m0.h.f f) {
            n.f(f, "<this>");
            f.l(m.HTML);
            f.c(e.ALL);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((f)object);
            return w.a;
        }
    }

    static final class i extends p implements l<kotlin.i0.z.e.m0.h.f, w> {

        public static final kotlin.i0.z.e.m0.h.c.i a;
        static {
            c.i iVar = new c.i();
            c.i.a = iVar;
        }

        i() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(kotlin.i0.z.e.m0.h.f f) {
            n.f(f, "<this>");
            f.e(false);
            f.c(q0.b());
            f.g(b.b.a);
            int i2 = 1;
            f.q(i2);
            f.d(k.NONE);
            f.k(i2);
            f.j(i2);
            f.h(i2);
            f.b(i2);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((f)object);
            return w.a;
        }
    }

    static final class j extends p implements l<kotlin.i0.z.e.m0.h.f, w> {

        public static final kotlin.i0.z.e.m0.h.c.j a;
        static {
            c.j jVar = new c.j();
            c.j.a = jVar;
        }

        j() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(kotlin.i0.z.e.m0.h.f f) {
            n.f(f, "<this>");
            f.g(b.b.a);
            f.d(k.ONLY_NON_SYNTHESIZED);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((f)object);
            return w.a;
        }
    }
    static {
        c.k kVar = new c.k(0);
        c.a = kVar;
        kVar.b(c.c.a);
        kVar.b(c.a.a);
        kVar.b(c.b.a);
        kVar.b(c.d.a);
        kVar.b(c.i.a);
        c.b = kVar.b(c.f.a);
        kVar.b(c.g.a);
        kVar.b(c.j.a);
        c.c = kVar.b(c.e.a);
        kVar.b(c.h.a);
    }

    public static String t(kotlin.i0.z.e.m0.h.c c, c c2, e e3, int i4, Object object5) {
        int obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 2 != 0) {
                obj2 = 0;
            }
            return c.s(c2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderAnnotation");
        throw obj0;
    }

    public abstract String r(m m);

    public abstract String s(c c, e e2);

    public abstract String u(String string, String string2, h h3);

    public abstract String v(c c);

    public abstract String w(e e, boolean z2);

    public abstract String x(b0 b0);

    public abstract String y(v0 v0);

    public final kotlin.i0.z.e.m0.h.c z(l<? super kotlin.i0.z.e.m0.h.f, w> l) {
        n.f(l, "changeOptions");
        kotlin.i0.z.e.m0.h.g gVar2 = (d)this.i0().r();
        l.invoke(gVar2);
        gVar2.m0();
        d obj2 = new d(gVar2);
        return obj2;
    }
}
