package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Map;
import kotlin.d0.d.n;
import kotlin.y.j0;

/* loaded from: classes3.dex */
public final class f1 {

    public static final kotlin.reflect.jvm.internal.impl.descriptors.f1 a;
    private static final Map<kotlin.reflect.jvm.internal.impl.descriptors.g1, Integer> b;

    public static final class a extends kotlin.reflect.jvm.internal.impl.descriptors.g1 {

        public static final kotlin.reflect.jvm.internal.impl.descriptors.f1.a c;
        static {
            f1.a aVar = new f1.a();
            f1.a.c = aVar;
        }

        private a() {
            super("inherited", 0);
        }
    }

    public static final class b extends kotlin.reflect.jvm.internal.impl.descriptors.g1 {

        public static final kotlin.reflect.jvm.internal.impl.descriptors.f1.b c;
        static {
            f1.b bVar = new f1.b();
            f1.b.c = bVar;
        }

        private b() {
            super("internal", 0);
        }
    }

    public static final class c extends kotlin.reflect.jvm.internal.impl.descriptors.g1 {

        public static final kotlin.reflect.jvm.internal.impl.descriptors.f1.c c;
        static {
            f1.c cVar = new f1.c();
            f1.c.c = cVar;
        }

        private c() {
            super("invisible_fake", 0);
        }
    }

    public static final class d extends kotlin.reflect.jvm.internal.impl.descriptors.g1 {

        public static final kotlin.reflect.jvm.internal.impl.descriptors.f1.d c;
        static {
            f1.d dVar = new f1.d();
            f1.d.c = dVar;
        }

        private d() {
            super("local", 0);
        }
    }

    public static final class e extends kotlin.reflect.jvm.internal.impl.descriptors.g1 {

        public static final kotlin.reflect.jvm.internal.impl.descriptors.f1.e c;
        static {
            f1.e eVar = new f1.e();
            f1.e.c = eVar;
        }

        private e() {
            super("private", 0);
        }
    }

    public static final class f extends kotlin.reflect.jvm.internal.impl.descriptors.g1 {

        public static final kotlin.reflect.jvm.internal.impl.descriptors.f1.f c;
        static {
            f1.f fVar = new f1.f();
            f1.f.c = fVar;
        }

        private f() {
            super("private_to_this", 0);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.g1
        public String b() {
            return "private/*private to this*/";
        }
    }

    public static final class g extends kotlin.reflect.jvm.internal.impl.descriptors.g1 {

        public static final kotlin.reflect.jvm.internal.impl.descriptors.f1.g c;
        static {
            f1.g gVar = new f1.g();
            f1.g.c = gVar;
        }

        private g() {
            super("protected", 1);
        }
    }

    public static final class h extends kotlin.reflect.jvm.internal.impl.descriptors.g1 {

        public static final kotlin.reflect.jvm.internal.impl.descriptors.f1.h c;
        static {
            f1.h hVar = new f1.h();
            f1.h.c = hVar;
        }

        private h() {
            super("public", 1);
        }
    }

    public static final class i extends kotlin.reflect.jvm.internal.impl.descriptors.g1 {

        public static final kotlin.reflect.jvm.internal.impl.descriptors.f1.i c;
        static {
            f1.i iVar = new f1.i();
            f1.i.c = iVar;
        }

        private i() {
            super("unknown", 0);
        }
    }
    static {
        f1 f1Var = new f1();
        f1.a = f1Var;
        Map map = j0.c();
        Integer valueOf = 0;
        map.put(f1.f.c, valueOf);
        map.put(f1.e.c, valueOf);
        Integer valueOf2 = 1;
        map.put(f1.b.c, valueOf2);
        map.put(f1.g.c, valueOf2);
        map.put(f1.h.c, 2);
        f1.b = j0.b(map);
    }

    public final Integer a(kotlin.reflect.jvm.internal.impl.descriptors.g1 g1, kotlin.reflect.jvm.internal.impl.descriptors.g1 g12) {
        Map map;
        int obj2;
        Object obj3;
        n.f(g1, "first");
        n.f(g12, "second");
        if (g1 == g12) {
            return null;
        }
        map = f1.b;
        obj2 = map.get(g1);
        obj3 = map.get(g12);
        if ((Integer)obj2 != null && (Integer)obj3 != null) {
            if ((Integer)obj3 != null) {
                if (n.b((Integer)obj2, (Integer)obj3)) {
                    obj2 = 0;
                } else {
                    obj2 = Integer.valueOf(obj2 -= obj3);
                }
            } else {
            }
        } else {
        }
        return obj2;
    }

    public final boolean b(kotlin.reflect.jvm.internal.impl.descriptors.g1 g1) {
        kotlin.reflect.jvm.internal.impl.descriptors.g1 eVar;
        int obj2;
        n.f(g1, "visibility");
        if (g1 != f1.e.c) {
            if (g1 == f1.f.c) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }
}
