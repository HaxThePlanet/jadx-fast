package kotlin.reflect.jvm.internal.impl.descriptors.l1.b;

import java.lang.reflect.Modifier;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.i0.s;
import kotlin.reflect.jvm.internal.impl.descriptors.f1.e;
import kotlin.reflect.jvm.internal.impl.descriptors.f1.h;
import kotlin.reflect.jvm.internal.impl.descriptors.g1;
import kotlin.reflect.jvm.internal.impl.descriptors.k1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.k1.b;
import kotlin.reflect.jvm.internal.impl.descriptors.k1.c;

/* loaded from: classes3.dex */
public interface t extends s {

    public static final class a {
        public static g1 a(kotlin.reflect.jvm.internal.impl.descriptors.l1.b.t t) {
            boolean protected;
            g1 obj1;
            n.f(t, "this");
            obj1 = t.E();
            if (Modifier.isPublic(obj1)) {
                obj1 = f1.h.c;
            } else {
                if (Modifier.isPrivate(obj1)) {
                    obj1 = f1.e.c;
                } else {
                    if (Modifier.isProtected(obj1)) {
                        obj1 = Modifier.isStatic(obj1) ? c.c : b.c;
                    } else {
                        obj1 = a.c;
                    }
                }
            }
            return obj1;
        }

        public static boolean b(kotlin.reflect.jvm.internal.impl.descriptors.l1.b.t t) {
            n.f(t, "this");
            return Modifier.isAbstract(t.E());
        }

        public static boolean c(kotlin.reflect.jvm.internal.impl.descriptors.l1.b.t t) {
            n.f(t, "this");
            return Modifier.isFinal(t.E());
        }

        public static boolean d(kotlin.reflect.jvm.internal.impl.descriptors.l1.b.t t) {
            n.f(t, "this");
            return Modifier.isStatic(t.E());
        }
    }
    @Override // kotlin.i0.z.e.m0.d.a.i0.s
    public abstract int E();
}
