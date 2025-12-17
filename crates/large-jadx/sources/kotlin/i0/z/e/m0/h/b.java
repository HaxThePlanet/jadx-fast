package kotlin.i0.z.e.m0.h;

import java.util.ArrayList;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.i.d;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n;
import kotlin.y.p;

/* loaded from: classes3.dex */
public interface b {

    public static final class a implements kotlin.i0.z.e.m0.h.b {

        public static final kotlin.i0.z.e.m0.h.b.a a;
        static {
            b.a aVar = new b.a();
            b.a.a = aVar;
        }

        @Override // kotlin.i0.z.e.m0.h.b
        public String a(h h, kotlin.i0.z.e.m0.h.c c2) {
            n.f(h, "classifier");
            n.f(c2, "renderer");
            if (h instanceof z0) {
                kotlin.i0.z.e.m0.f.e obj2 = (z0)h.getName();
                n.e(obj2, "classifier.name");
                return c2.w(obj2, false);
            }
            obj2 = d.m(h);
            n.e(obj2, "getFqName(classifier)");
            return c2.v(obj2);
        }
    }

    public static final class b implements kotlin.i0.z.e.m0.h.b {

        public static final kotlin.i0.z.e.m0.h.b.b a;
        static {
            b.b bVar = new b.b();
            b.b.a = bVar;
        }

        @Override // kotlin.i0.z.e.m0.h.b
        public String a(h h, kotlin.i0.z.e.m0.h.c c2) {
            boolean z;
            Object obj2;
            n.f(h, "classifier");
            n.f(c2, "renderer");
            if (h instanceof z0) {
                obj2 = (z0)h.getName();
                n.e(obj2, "classifier.name");
                return c2.w(obj2, false);
            }
            ArrayList obj3 = new ArrayList();
            obj3.add(obj2.getName());
            while (!obj2 instanceof e) {
                obj3.add(obj2.getName());
            }
            return n.c(p.F(obj3));
        }
    }

    public static final class c implements kotlin.i0.z.e.m0.h.b {

        public static final kotlin.i0.z.e.m0.h.b.c a;
        static {
            b.c cVar = new b.c();
            b.c.a = cVar;
        }

        private final String b(h h) {
            String string;
            String stringBuilder;
            String obj3;
            kotlin.i0.z.e.m0.f.e name = h.getName();
            n.e(name, "descriptor.name");
            string = n.b(name);
            if (h instanceof z0) {
                return string;
            }
            obj3 = h.b();
            n.e(obj3, "descriptor.containingDeclaration");
            obj3 = c(obj3);
            if (obj3 != null && !n.b(obj3, "")) {
                if (!n.b(obj3, "")) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(obj3);
                    stringBuilder.append('.');
                    stringBuilder.append(string);
                    string = stringBuilder.toString();
                }
            }
            return string;
        }

        private final String c(m m) {
            boolean str;
            String obj2;
            if (m instanceof e) {
                obj2 = b((h)m);
            } else {
                if (m instanceof f0) {
                    obj2 = (f0)m.d().j();
                    n.e(obj2, "descriptor.fqName.toUnsafe()");
                    obj2 = n.a(obj2);
                } else {
                    obj2 = 0;
                }
            }
            return obj2;
        }

        @Override // kotlin.i0.z.e.m0.h.b
        public String a(h h, kotlin.i0.z.e.m0.h.c c2) {
            n.f(h, "classifier");
            n.f(c2, "renderer");
            return b(h);
        }
    }
    public abstract String a(h h, kotlin.i0.z.e.m0.h.c c2);
}
