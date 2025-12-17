package kotlin.reflect.jvm.internal.impl.descriptors.l1.b;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.e0;
import kotlin.d0.d.j;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.f;
import kotlin.i0.z.e.m0.d.a.i0.a;
import kotlin.i0.z.e.m0.d.a.i0.c0;
import kotlin.i0.z.e.m0.d.a.i0.g;
import kotlin.i0.z.e.m0.d.a.i0.j;
import kotlin.i0.z.e.m0.d.a.i0.w;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.j0.i;
import kotlin.reflect.jvm.internal.impl.descriptors.g1;
import kotlin.y.i;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class j extends kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n implements kotlin.reflect.jvm.internal.impl.descriptors.l1.b.f, kotlin.reflect.jvm.internal.impl.descriptors.l1.b.t, g {

    private final Class<?> a;

    static final class e extends p implements l<Class<?>, Boolean> {

        public static final kotlin.reflect.jvm.internal.impl.descriptors.l1.b.j.e a;
        static {
            j.e eVar = new j.e();
            j.e.a = eVar;
        }

        e() {
            super(1);
        }

        public final boolean a(Class<?> class) {
            int obj2;
            obj2 = class.getSimpleName();
            n.e(obj2, "it.simpleName");
            obj2 = obj2.length() == 0 ? 1 : 0;
            return obj2;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return Boolean.valueOf(a((Class)object));
        }
    }

    static final class f extends p implements l<Class<?>, e> {

        public static final kotlin.reflect.jvm.internal.impl.descriptors.l1.b.j.f a;
        static {
            j.f fVar = new j.f();
            j.f.a = fVar;
        }

        f() {
            super(1);
        }

        public final e a(Class<?> class) {
            e i;
            String obj3;
            if (e.m(class.getSimpleName())) {
            } else {
                obj3 = i;
            }
            if (obj3 == null) {
            } else {
                i = e.j(obj3);
            }
            return i;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((Class)object);
        }
    }

    static final class g extends p implements l<Method, Boolean> {

        final kotlin.reflect.jvm.internal.impl.descriptors.l1.b.j this$0;
        g(kotlin.reflect.jvm.internal.impl.descriptors.l1.b.j j) {
            this.this$0 = j;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(Method method) {
            boolean synthetic;
            int i;
            String str;
            Object obj5;
            i = 1;
            if (method.isSynthetic()) {
                i = i2;
            } else {
            }
            return i;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return Boolean.valueOf(a((Method)object));
        }
    }

    class a extends j implements l<Member, Boolean> {

        public static final kotlin.reflect.jvm.internal.impl.descriptors.l1.b.j.a a;
        static {
            j.a aVar = new j.a();
            j.a.a = aVar;
        }

        a() {
            super(1);
        }

        @Override // kotlin.d0.d.j
        public final String getName() {
            return "isSynthetic";
        }

        @Override // kotlin.d0.d.j
        public final f getOwner() {
            return c0.b(Member.class);
        }

        @Override // kotlin.d0.d.j
        public final String getSignature() {
            return "isSynthetic()Z";
        }

        @Override // kotlin.d0.d.j
        public Object invoke(Object object) {
            return Boolean.valueOf(l((Member)object));
        }

        @Override // kotlin.d0.d.j
        public final boolean l(Member member) {
            n.f(member, "p0");
            return member.isSynthetic();
        }
    }

    class b extends j implements l<Constructor<?>, kotlin.reflect.jvm.internal.impl.descriptors.l1.b.m> {

        public static final kotlin.reflect.jvm.internal.impl.descriptors.l1.b.j.b a;
        static {
            j.b bVar = new j.b();
            j.b.a = bVar;
        }

        b() {
            super(1);
        }

        @Override // kotlin.d0.d.j
        public final String getName() {
            return "<init>";
        }

        @Override // kotlin.d0.d.j
        public final f getOwner() {
            return c0.b(m.class);
        }

        @Override // kotlin.d0.d.j
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Constructor;)V";
        }

        @Override // kotlin.d0.d.j
        public Object invoke(Object object) {
            return l((Constructor)object);
        }

        public final kotlin.reflect.jvm.internal.impl.descriptors.l1.b.m l(Constructor<?> constructor) {
            n.f(constructor, "p0");
            m mVar = new m(constructor);
            return mVar;
        }
    }

    class c extends j implements l<Member, Boolean> {

        public static final kotlin.reflect.jvm.internal.impl.descriptors.l1.b.j.c a;
        static {
            j.c cVar = new j.c();
            j.c.a = cVar;
        }

        c() {
            super(1);
        }

        @Override // kotlin.d0.d.j
        public final String getName() {
            return "isSynthetic";
        }

        @Override // kotlin.d0.d.j
        public final f getOwner() {
            return c0.b(Member.class);
        }

        @Override // kotlin.d0.d.j
        public final String getSignature() {
            return "isSynthetic()Z";
        }

        @Override // kotlin.d0.d.j
        public Object invoke(Object object) {
            return Boolean.valueOf(l((Member)object));
        }

        @Override // kotlin.d0.d.j
        public final boolean l(Member member) {
            n.f(member, "p0");
            return member.isSynthetic();
        }
    }

    class d extends j implements l<Field, kotlin.reflect.jvm.internal.impl.descriptors.l1.b.p> {

        public static final kotlin.reflect.jvm.internal.impl.descriptors.l1.b.j.d a;
        static {
            j.d dVar = new j.d();
            j.d.a = dVar;
        }

        d() {
            super(1);
        }

        @Override // kotlin.d0.d.j
        public final String getName() {
            return "<init>";
        }

        @Override // kotlin.d0.d.j
        public final f getOwner() {
            return c0.b(p.class);
        }

        @Override // kotlin.d0.d.j
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Field;)V";
        }

        @Override // kotlin.d0.d.j
        public Object invoke(Object object) {
            return l((Field)object);
        }

        @Override // kotlin.d0.d.j
        public final kotlin.reflect.jvm.internal.impl.descriptors.l1.b.p l(Field field) {
            n.f(field, "p0");
            p pVar = new p(field);
            return pVar;
        }
    }

    class h extends j implements l<Method, kotlin.reflect.jvm.internal.impl.descriptors.l1.b.s> {

        public static final kotlin.reflect.jvm.internal.impl.descriptors.l1.b.j.h a;
        static {
            j.h hVar = new j.h();
            j.h.a = hVar;
        }

        h() {
            super(1);
        }

        @Override // kotlin.d0.d.j
        public final String getName() {
            return "<init>";
        }

        @Override // kotlin.d0.d.j
        public final f getOwner() {
            return c0.b(s.class);
        }

        @Override // kotlin.d0.d.j
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Method;)V";
        }

        @Override // kotlin.d0.d.j
        public Object invoke(Object object) {
            return l((Method)object);
        }

        @Override // kotlin.d0.d.j
        public final kotlin.reflect.jvm.internal.impl.descriptors.l1.b.s l(Method method) {
            n.f(method, "p0");
            s sVar = new s(method);
            return sVar;
        }
    }
    public j(Class<?> class) {
        n.f(class, "klass");
        super();
        this.a = class;
    }

    public static final boolean Q(kotlin.reflect.jvm.internal.impl.descriptors.l1.b.j j, Method method2) {
        return j.Z(method2);
    }

    private final boolean Z(Method method) {
        boolean arr;
        String str;
        boolean equals;
        int obj5;
        String name = method.getName();
        final int i = 0;
        if (n.b(name, "values")) {
            obj5 = method.getParameterTypes();
            n.e(obj5, "method.parameterTypes");
            if (obj5.length == 0) {
            } else {
                equals = i;
            }
        } else {
            if (n.b(name, "valueOf")) {
                arr = new Class[1];
                arr[i] = String.class;
                equals = Arrays.equals(method.getParameterTypes(), arr);
            } else {
            }
        }
        return equals;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public boolean B() {
        return this.a.isEnum();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public Collection D() {
        return V();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public int E() {
        return this.a.getModifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public boolean H() {
        return this.a.isInterface();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public c0 I() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public Collection K() {
        return W();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public Collection M() {
        return X();
    }

    public Collection<j> N() {
        return p.g();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public kotlin.reflect.jvm.internal.impl.descriptors.l1.b.c R(b b) {
        return f.a.a(this, b);
    }

    public List<kotlin.reflect.jvm.internal.impl.descriptors.l1.b.c> S() {
        return f.a.b(this);
    }

    public List<kotlin.reflect.jvm.internal.impl.descriptors.l1.b.m> T() {
        Constructor[] declaredConstructors = this.a.getDeclaredConstructors();
        n.e(declaredConstructors, "klass.declaredConstructors");
        return i.A(i.u(i.m(i.r(declaredConstructors), j.a.a), j.b.a));
    }

    public Class<?> U() {
        return this.a;
    }

    public List<kotlin.reflect.jvm.internal.impl.descriptors.l1.b.p> V() {
        Field[] declaredFields = this.a.getDeclaredFields();
        n.e(declaredFields, "klass.declaredFields");
        return i.A(i.u(i.m(i.r(declaredFields), j.c.a), j.d.a));
    }

    public List<e> W() {
        Class[] declaredClasses = this.a.getDeclaredClasses();
        n.e(declaredClasses, "klass.declaredClasses");
        return i.A(i.v(i.m(i.r(declaredClasses), j.e.a), j.f.a));
    }

    public List<kotlin.reflect.jvm.internal.impl.descriptors.l1.b.s> X() {
        Method[] declaredMethods = this.a.getDeclaredMethods();
        n.e(declaredMethods, "klass.declaredMethods");
        j.g gVar = new j.g(this);
        return i.A(i.u(i.l(i.r(declaredMethods), gVar), j.h.a));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public kotlin.reflect.jvm.internal.impl.descriptors.l1.b.j Y() {
        int i;
        kotlin.reflect.jvm.internal.impl.descriptors.l1.b.j jVar;
        Class declaringClass = this.a.getDeclaringClass();
        if (declaringClass == null) {
            i = 0;
        } else {
            jVar = new j(declaringClass);
            i = jVar;
        }
        return i;
    }

    public Collection<j> a() {
        Class<Object> obj;
        int next;
        kotlin.reflect.jvm.internal.impl.descriptors.l1.b.l lVar;
        if (n.b(this.a, Object.class)) {
            return p.g();
        }
        e0 e0Var = new e0(2);
        java.lang.reflect.Type genericSuperclass = this.a.getGenericSuperclass();
        if (genericSuperclass == null) {
        } else {
            obj = genericSuperclass;
        }
        e0Var.a(obj);
        java.lang.reflect.Type[] genericInterfaces = this.a.getGenericInterfaces();
        n.e(genericInterfaces, "klass.genericInterfaces");
        e0Var.b(genericInterfaces);
        List list = p.j(e0Var.d(new Type[e0Var.c()]));
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator iterator = list.iterator();
        for (Type next : iterator) {
            lVar = new l(next);
            arrayList.add(lVar);
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public b d() {
        b bVar = b.b(this.a).b();
        n.e(bVar, "klass.classId.asSingleFqName()");
        return bVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public boolean equals(Object object) {
        boolean z;
        Object obj2;
        if (object instanceof j && n.b(this.a, object.a)) {
            obj2 = n.b(this.a, object.a) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public Collection getAnnotations() {
        return S();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public AnnotatedElement getElement() {
        return U();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public e getName() {
        e eVar = e.j(this.a.getSimpleName());
        n.e(eVar, "identifier(klass.simpleName)");
        return eVar;
    }

    public List<kotlin.reflect.jvm.internal.impl.descriptors.l1.b.x> getTypeParameters() {
        int i;
        java.lang.reflect.TypeVariable typeVariable;
        kotlin.reflect.jvm.internal.impl.descriptors.l1.b.x xVar;
        java.lang.reflect.TypeVariable[] typeParameters = this.a.getTypeParameters();
        n.e(typeParameters, "klass.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        i = 0;
        while (i < typeParameters.length) {
            xVar = new x(typeParameters[i]);
            arrayList.add(xVar);
            i++;
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public g1 getVisibility() {
        return t.a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public boolean i() {
        return t.a.d(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public boolean isAbstract() {
        return t.a.b(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public boolean isFinal() {
        return t.a.c(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public Collection j() {
        return T();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public g k() {
        return Y();
    }

    public Collection<w> l() {
        return p.g();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public boolean m() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public boolean n() {
        return f.a.c(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public a o(b b) {
        return R(b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public boolean s() {
        return this.a.isAnnotation();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j.class.getName());
        stringBuilder.append(": ");
        stringBuilder.append(this.a);
        return stringBuilder.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public boolean u() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public boolean v() {
        return 0;
    }
}
