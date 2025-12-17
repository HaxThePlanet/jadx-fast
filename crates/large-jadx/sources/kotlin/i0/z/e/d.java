package kotlin.i0.z.e;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.e.a0.b.e.b;
import kotlin.y.i;
import kotlin.y.p;

/* loaded from: classes3.dex */
public abstract class d {

    public static final class a extends kotlin.i0.z.e.d {

        private final List<Method> a;
        private final Class<?> b;
        public a(Class<?> class) {
            n.f(class, "jClass");
            super(0);
            this.b = class;
            Method[] obj2 = class.getDeclaredMethods();
            n.e(obj2, "jClass.declaredMethods");
            d.a.a aVar = new d.a.a();
            this.a = i.Q(obj2, aVar);
        }

        @Override // kotlin.i0.z.e.d
        public String a() {
            return p.h0(this.a, "", "<init>(", ")V", 0, 0, d.a.b.a, 24, 0);
        }

        public final List<Method> b() {
            return this.a;
        }
    }

    public static final class b extends kotlin.i0.z.e.d {

        private final Constructor<?> a;
        public b(Constructor<?> constructor) {
            n.f(constructor, "constructor");
            super(0);
            this.a = constructor;
        }

        @Override // kotlin.i0.z.e.d
        public String a() {
            final Class[] parameterTypes = this.a.getParameterTypes();
            n.e(parameterTypes, "constructor.parameterTypes");
            return i.I(parameterTypes, "", "<init>(", ")V", 0, 0, d.b.a.a, 24, 0);
        }

        public final Constructor<?> b() {
            return this.a;
        }
    }

    public static final class c extends kotlin.i0.z.e.d {

        private final Method a;
        public c(Method method) {
            n.f(method, "method");
            super(0);
            this.a = method;
        }

        @Override // kotlin.i0.z.e.d
        public String a() {
            return h0.a(this.a);
        }

        @Override // kotlin.i0.z.e.d
        public final Method b() {
            return this.a;
        }
    }

    public static final class d extends kotlin.i0.z.e.d {

        private final String a;
        private final e.b b;
        public d(e.b e$b) {
            n.f(b, "signature");
            super(0);
            this.b = b;
            this.a = b.a();
        }

        @Override // kotlin.i0.z.e.d
        public String a() {
            return this.a;
        }

        @Override // kotlin.i0.z.e.d
        public final String b() {
            return this.b.b();
        }
    }

    public static final class e extends kotlin.i0.z.e.d {

        private final String a;
        private final e.b b;
        public e(e.b e$b) {
            n.f(b, "signature");
            super(0);
            this.b = b;
            this.a = b.a();
        }

        @Override // kotlin.i0.z.e.d
        public String a() {
            return this.a;
        }

        @Override // kotlin.i0.z.e.d
        public final String b() {
            return this.b.b();
        }

        @Override // kotlin.i0.z.e.d
        public final String c() {
            return this.b.c();
        }
    }
    public d(g g) {
        super();
    }

    public abstract String a();
}
