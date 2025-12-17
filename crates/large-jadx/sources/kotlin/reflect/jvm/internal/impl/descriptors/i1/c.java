package kotlin.reflect.jvm.internal.impl.descriptors.i1;

import kotlin.d0.d.n;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;

/* loaded from: classes3.dex */
public interface c {

    public static final class a implements kotlin.reflect.jvm.internal.impl.descriptors.i1.c {

        public static final kotlin.reflect.jvm.internal.impl.descriptors.i1.c.a a;
        static {
            c.a aVar = new c.a();
            c.a.a = aVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.i1.c
        public boolean c(e e, t0 t02) {
            n.f(e, "classDescriptor");
            n.f(t02, "functionDescriptor");
            return 1;
        }
    }

    public static final class b implements kotlin.reflect.jvm.internal.impl.descriptors.i1.c {

        public static final kotlin.reflect.jvm.internal.impl.descriptors.i1.c.b a;
        static {
            c.b bVar = new c.b();
            c.b.a = bVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.i1.c
        public boolean c(e e, t0 t02) {
            n.f(e, "classDescriptor");
            n.f(t02, "functionDescriptor");
            return obj2 ^= 1;
        }
    }
    public abstract boolean c(e e, t0 t02);
}
