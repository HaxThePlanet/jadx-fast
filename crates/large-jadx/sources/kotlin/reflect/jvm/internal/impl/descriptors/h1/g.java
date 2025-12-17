package kotlin.reflect.jvm.internal.impl.descriptors.h1;

import java.util.Iterator;
import java.util.List;
import kotlin.d0.d.j0.a;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.b;

/* loaded from: classes3.dex */
public interface g extends Iterable<kotlin.reflect.jvm.internal.impl.descriptors.h1.c>, a {

    public static final kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a q;

    public static final class a {

        static final kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a a;
        private static final kotlin.reflect.jvm.internal.impl.descriptors.h1.g b;
        static {
            g.a aVar = new g.a();
            g.a.a = aVar;
            g.a.a aVar2 = new g.a.a();
            g.a.b = aVar2;
        }

        public final kotlin.reflect.jvm.internal.impl.descriptors.h1.g a(List<? extends kotlin.reflect.jvm.internal.impl.descriptors.h1.c> list) {
            boolean hVar;
            kotlin.reflect.jvm.internal.impl.descriptors.h1.g obj2;
            n.f(list, "annotations");
            if (list.isEmpty()) {
                obj2 = g.a.b;
            } else {
                hVar = new h(list);
                obj2 = hVar;
            }
            return obj2;
        }

        public final kotlin.reflect.jvm.internal.impl.descriptors.h1.g b() {
            return g.a.b;
        }
    }

    public static final class b {
        public static kotlin.reflect.jvm.internal.impl.descriptors.h1.c a(kotlin.reflect.jvm.internal.impl.descriptors.h1.g g, b b2) {
            String next;
            boolean z;
            n.f(g, "this");
            n.f(b2, "fqName");
            final Iterator obj2 = g.iterator();
            for (Object next : obj2) {
            }
            next = 0;
            return (c)next;
        }

        public static boolean b(kotlin.reflect.jvm.internal.impl.descriptors.h1.g g, b b2) {
            int obj1;
            n.f(g, "this");
            n.f(b2, "fqName");
            obj1 = g.o(b2) != null ? 1 : 0;
            return obj1;
        }
    }
    static {
        g.q = g.a.a;
    }

    @Override // java.lang.Iterable
    public abstract boolean isEmpty();

    @Override // java.lang.Iterable
    public abstract kotlin.reflect.jvm.internal.impl.descriptors.h1.c o(b b);

    @Override // java.lang.Iterable
    public abstract boolean u1(b b);
}
