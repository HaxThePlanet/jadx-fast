package kotlin.reflect.jvm.internal.impl.descriptors.l1.b;

import java.lang.reflect.AnnotatedElement;
import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.i0.d;
import kotlin.i0.z.e.m0.f.b;
import kotlin.y.p;

/* loaded from: classes3.dex */
public interface f extends d {

    public static final class a {
        public static kotlin.reflect.jvm.internal.impl.descriptors.l1.b.c a(kotlin.reflect.jvm.internal.impl.descriptors.l1.b.f f, b b2) {
            int i;
            AnnotatedElement obj1;
            n.f(f, "this");
            n.f(b2, "fqName");
            obj1 = f.getElement();
            i = 0;
            if (obj1 == null) {
            } else {
                obj1 = obj1.getDeclaredAnnotations();
                if (obj1 == null) {
                } else {
                    i = g.a(obj1, b2);
                }
            }
            return i;
        }

        public static List<kotlin.reflect.jvm.internal.impl.descriptors.l1.b.c> b(kotlin.reflect.jvm.internal.impl.descriptors.l1.b.f f) {
            int obj1;
            n.f(f, "this");
            obj1 = f.getElement();
            if (obj1 == null) {
                obj1 = 0;
            } else {
                obj1 = obj1.getDeclaredAnnotations();
            }
            if (obj1 == null) {
                obj1 = p.g();
            } else {
                obj1 = g.b(obj1);
            }
            return obj1;
        }

        public static boolean c(kotlin.reflect.jvm.internal.impl.descriptors.l1.b.f f) {
            n.f(f, "this");
            return 0;
        }
    }
    @Override // kotlin.i0.z.e.m0.d.a.i0.d
    public abstract AnnotatedElement getElement();
}
