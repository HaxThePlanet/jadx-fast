package kotlin.i0.z.e;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.a;
import kotlin.d0.c.a;
import kotlin.d0.c.p;
import kotlin.d0.d.c0;
import kotlin.d0.d.g0;
import kotlin.d0.d.j;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.x;
import kotlin.i0.d;
import kotlin.i0.f;
import kotlin.i0.g;
import kotlin.i0.l;
import kotlin.i0.z.e.m0.c.b.d;
import kotlin.i0.z.e.m0.d.b.a0.a;
import kotlin.i0.z.e.m0.e.a0.a;
import kotlin.i0.z.e.m0.e.n;
import kotlin.i0.z.e.m0.e.z.e;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.j.b.d0.d;
import kotlin.i0.z.e.m0.j.b.l;
import kotlin.i0.z.e.m0.j.b.u;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.k0.l;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.i;
import kotlin.reflect.jvm.internal.impl.descriptors.l;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.a.f;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.a.f.a;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.b.b;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class h<T>  extends kotlin.i0.z.e.j implements d<T>, kotlin.i0.z.e.z {

    private final kotlin.i0.z.e.c0.b<kotlin.i0.z.e.h.a<T>> v;
    private final Class<T> w;

    public final class a extends kotlin.i0.z.e.j.b {

        static final l[] q;
        private final kotlin.i0.z.e.c0.a d;
        private final kotlin.i0.z.e.c0.a e;
        private final kotlin.i0.z.e.c0.a f;
        private final kotlin.i0.z.e.c0.a g;
        private final kotlin.i0.z.e.c0.a h;
        private final kotlin.i0.z.e.c0.b i;
        private final kotlin.i0.z.e.c0.a j;
        private final kotlin.i0.z.e.c0.a k;
        private final kotlin.i0.z.e.c0.a l;
        private final kotlin.i0.z.e.c0.a m;
        private final kotlin.i0.z.e.c0.a n;
        private final kotlin.i0.z.e.c0.a o;
        final kotlin.i0.z.e.h p;
        static {
            Class<kotlin.i0.z.e.h.a> obj = h.a.class;
            l[] arr = new l[18];
            x xVar = new x(c0.b(obj), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;");
            x xVar2 = new x(c0.b(obj), "annotations", "getAnnotations()Ljava/util/List;");
            x xVar3 = new x(c0.b(obj), "simpleName", "getSimpleName()Ljava/lang/String;");
            x xVar4 = new x(c0.b(obj), "qualifiedName", "getQualifiedName()Ljava/lang/String;");
            x xVar5 = new x(c0.b(obj), "constructors", "getConstructors()Ljava/util/Collection;");
            x xVar6 = new x(c0.b(obj), "nestedClasses", "getNestedClasses()Ljava/util/Collection;");
            x xVar7 = new x(c0.b(obj), "objectInstance", "getObjectInstance()Ljava/lang/Object;");
            x xVar8 = new x(c0.b(obj), "typeParameters", "getTypeParameters()Ljava/util/List;");
            x xVar9 = new x(c0.b(obj), "supertypes", "getSupertypes()Ljava/util/List;");
            x xVar10 = new x(c0.b(obj), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;");
            x xVar11 = new x(c0.b(obj), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;");
            x xVar12 = new x(c0.b(obj), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;");
            x xVar13 = new x(c0.b(obj), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;");
            x xVar14 = new x(c0.b(obj), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;");
            x xVar15 = new x(c0.b(obj), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;");
            x xVar16 = new x(c0.b(obj), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;");
            x xVar17 = new x(c0.b(obj), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;");
            x xVar18 = new x(c0.b(obj), "allMembers", "getAllMembers()Ljava/util/Collection;");
            h.a.q = arr;
        }

        public a(kotlin.i0.z.e.h h) {
            this.p = h;
            super(h);
            h.a.i obj1 = new h.a.i(this);
            this.d = c0.d(obj1);
            obj1 = new h.a.d(this);
            this.e = c0.d(obj1);
            obj1 = new h.a.p(this);
            this.f = c0.d(obj1);
            obj1 = new h.a.n(this);
            this.g = c0.d(obj1);
            obj1 = new h.a.e(this);
            this.h = c0.d(obj1);
            obj1 = new h.a.l(this);
            c0.d(obj1);
            obj1 = new h.a.m(this);
            this.i = c0.b(obj1);
            obj1 = new h.a.r(this);
            c0.d(obj1);
            obj1 = new h.a.q(this);
            c0.d(obj1);
            obj1 = new h.a.o(this);
            c0.d(obj1);
            obj1 = new h.a.g(this);
            this.j = c0.d(obj1);
            obj1 = new h.a.h(this);
            this.k = c0.d(obj1);
            obj1 = new h.a.j(this);
            this.l = c0.d(obj1);
            obj1 = new h.a.k(this);
            this.m = c0.d(obj1);
            obj1 = new h.a.b(this);
            this.n = c0.d(obj1);
            obj1 = new h.a.c(this);
            this.o = c0.d(obj1);
            obj1 = new h.a.f(this);
            c0.d(obj1);
            obj1 = new h.a.a(this);
            c0.d(obj1);
        }

        public static final String b(kotlin.i0.z.e.h.a h$a, Class class2) {
            return a.f(class2);
        }

        public static final Collection c(kotlin.i0.z.e.h.a h$a) {
            return a.l();
        }

        public static final Collection d(kotlin.i0.z.e.h.a h$a) {
            return a.n();
        }

        public static final Collection e(kotlin.i0.z.e.h.a h$a) {
            return a.o();
        }

        private final String f(Class<?> class) {
            final String simpleName = class.getSimpleName();
            Method enclosingMethod = class.getEnclosingMethod();
            final String str = "$";
            final int i = 2;
            final String str2 = "name";
            final int i2 = 0;
            if (enclosingMethod != null) {
                n.e(simpleName, str2);
                StringBuilder obj7 = new StringBuilder();
                obj7.append(enclosingMethod.getName());
                obj7.append(str);
                return l.P0(simpleName, obj7.toString(), i2, i, i2);
            }
            obj7 = class.getEnclosingConstructor();
            if (obj7 != null) {
                n.e(simpleName, str2);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(obj7.getName());
                stringBuilder.append(str);
                return l.P0(simpleName, stringBuilder.toString(), i2, i, i2);
            }
            n.e(simpleName, str2);
            return l.O0(simpleName, '$', i2, i, i2);
        }

        private final Collection<kotlin.i0.z.e.f<?>> l() {
            return (Collection)this.k.b(this, h.a.q[11]);
        }

        private final Collection<kotlin.i0.z.e.f<?>> n() {
            return (Collection)this.l.b(this, h.a.q[12]);
        }

        private final Collection<kotlin.i0.z.e.f<?>> o() {
            return (Collection)this.m.b(this, h.a.q[13]);
        }

        public final Collection<kotlin.i0.z.e.f<?>> g() {
            return (Collection)this.n.b(this, h.a.q[14]);
        }

        public final Collection<kotlin.i0.z.e.f<?>> h() {
            return (Collection)this.o.b(this, h.a.q[15]);
        }

        public final List<Annotation> i() {
            return (List)this.e.b(this, h.a.q[1]);
        }

        public final Collection<g<T>> j() {
            return (Collection)this.h.b(this, h.a.q[4]);
        }

        public final Collection<kotlin.i0.z.e.f<?>> k() {
            return (Collection)this.j.b(this, h.a.q[10]);
        }

        @Override // kotlin.i0.z.e.j$b
        public final e m() {
            return (e)this.d.b(this, h.a.q[0]);
        }

        public final T p() {
            return this.i.b(this, h.a.q[6]);
        }

        @Override // kotlin.i0.z.e.j$b
        public final String q() {
            return (String)this.g.b(this, h.a.q[3]);
        }

        @Override // kotlin.i0.z.e.j$b
        public final String r() {
            return (String)this.f.b(this, h.a.q[2]);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0010\u0005\u001a\u001e \u0004*\u000e\u0018\u00010\u0002R\u0008\u0012\u0004\u0012\u00028\u00000\u00030\u0002R\u0008\u0012\u0004\u0012\u00028\u00000\u0003\"\u0008\u0008\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\u0008\u0005\u0010\u0006", d2 = {"", "T", "Lkotlin/i0/z/e/h$a;", "Lkotlin/i0/z/e/h;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/i0/z/e/h$a;"}, k = 3, mv = {1, 4, 1})
    static final class b extends p implements a<kotlin.i0.z.e.h.a<T>> {

        final kotlin.i0.z.e.h this$0;
        b(kotlin.i0.z.e.h h) {
            this.this$0 = h;
            super(0);
        }

        public final kotlin.i0.z.e.h.a<T> a() {
            h.a aVar = new h.a(this.this$0);
            return aVar;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0007\u001a\u00020\u0006\"\u0008\u0008\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\u0008\u0007\u0010\u0008", d2 = {"", "T", "Lkotlin/i0/z/e/m0/j/b/u;", "p1", "Lkotlin/i0/z/e/m0/e/n;", "p2", "Lkotlin/reflect/jvm/internal/impl/descriptors/o0;", "l", "(Lkotlin/i0/z/e/m0/j/b/u;Lkotlin/i0/z/e/m0/e/n;)Lkotlin/reflect/jvm/internal/impl/descriptors/o0;"}, k = 3, mv = {1, 4, 1})
    static final class c extends j implements p<u, n, o0> {

        public static final kotlin.i0.z.e.h.c a;
        static {
            h.c cVar = new h.c();
            h.c.a = cVar;
        }

        c() {
            super(2);
        }

        @Override // kotlin.d0.d.j
        public final String getName() {
            return "loadProperty";
        }

        @Override // kotlin.d0.d.j
        public final f getOwner() {
            return c0.b(u.class);
        }

        @Override // kotlin.d0.d.j
        public final String getSignature() {
            return "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;";
        }

        @Override // kotlin.d0.d.j
        public Object invoke(Object object, Object object2) {
            return l((u)object, (n)object2);
        }

        @Override // kotlin.d0.d.j
        public final o0 l(u u, n n2) {
            n.f(u, "p1");
            n.f(n2, "p2");
            return u.p(n2);
        }
    }
    public h(Class<T> class) {
        n.f(class, "jClass");
        super();
        this.w = class;
        h.b obj2 = new h.b(this);
        obj2 = c0.b(obj2);
        n.e(obj2, "ReflectProperties.lazy { Data() }");
        this.v = obj2;
    }

    public static final a K(kotlin.i0.z.e.h h) {
        return h.M();
    }

    public static final Void L(kotlin.i0.z.e.h h) {
        h.S();
        throw 0;
    }

    private final a M() {
        return g0.b.c(d());
    }

    private final Void S() {
        Object fVar;
        int i;
        Class cls;
        int ordinal;
        fVar = f.c.a(d());
        fVar = fVar.a();
        if (fVar != null && fVar != null) {
            fVar = fVar.a();
            if (fVar != null) {
                i = fVar.c();
            } else {
                i = 0;
            }
        } else {
        }
        if (i == 0) {
        } else {
            switch (cls) {
                case 1:
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Packages and file facades are not yet supported in Kotlin reflection. ");
                    stringBuilder2.append("Meanwhile please use Java reflection to inspect this class: ");
                    stringBuilder2.append(d());
                    UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(stringBuilder2.toString());
                    throw unsupportedOperationException;
                case 2:
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("This class is an internal synthetic class generated by the Kotlin compiler, such as an anonymous class for a lambda, a SAM wrapper, a callable reference, etc. It's not a Kotlin class or interface, so the reflection ");
                    stringBuilder3.append("library has no idea what declarations does it have. Please use Java reflection to inspect this class: ");
                    stringBuilder3.append(d());
                    UnsupportedOperationException unsupportedOperationException2 = new UnsupportedOperationException(stringBuilder3.toString());
                    throw unsupportedOperationException2;
                case 3:
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append("Unknown class: ");
                    stringBuilder4.append(d());
                    stringBuilder4.append(" (kind = ");
                    stringBuilder4.append(i);
                    stringBuilder4.append(')');
                    a0 a0Var2 = new a0(stringBuilder4.toString());
                    throw a0Var2;
                case 4:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unresolved class: ");
                    stringBuilder.append(d());
                    a0 a0Var = new a0(stringBuilder.toString());
                    throw a0Var;
                default:
                    NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                    throw noWhenBranchMatchedException;
            }
        }
    }

    @Override // kotlin.i0.z.e.j
    public o0 A(int i) {
        boolean declaringClass;
        e eVar;
        String interface;
        boolean cVar2;
        int i2;
        Object fVar;
        Object obj;
        kotlin.i0.z.e.m0.e.z.c cVar3;
        kotlin.i0.z.e.m0.e.z.g gVar;
        kotlin.i0.z.e.m0.e.z.a aVar;
        kotlin.i0.z.e.h.c cVar;
        int obj10;
        declaringClass = d().getDeclaringClass();
        if (n.b(d().getSimpleName(), "DefaultImpls") && declaringClass != null && declaringClass.isInterface()) {
            declaringClass = d().getDeclaringClass();
            if (declaringClass != null) {
                if (declaringClass.isInterface()) {
                    d dVar = a.e(declaringClass);
                    Objects.requireNonNull(dVar, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                    return (h)dVar.A(i);
                }
            }
        }
        if (!eVar instanceof d) {
            eVar = i2;
        }
        fVar = a.j;
        n.e(fVar, "JvmProtoBuf.classLocalVariable");
        obj = obj10;
        if (eVar != null && (n)obj != null) {
            fVar = a.j;
            n.e(fVar, "JvmProtoBuf.classLocalVariable");
            obj = obj10;
            if ((n)(n)obj != null) {
                i2 = obj10;
            }
        }
        return i2;
    }

    public Collection<o0> D(e e) {
        n.f(e, "name");
        final d fROM_REFLECTION = d.FROM_REFLECTION;
        return p.t0(Q().c(e, fROM_REFLECTION), R().c(e, fROM_REFLECTION));
    }

    public Collection<g<T>> N() {
        return (h.a)this.v.invoke().j();
    }

    public final kotlin.i0.z.e.c0.b<kotlin.i0.z.e.h.a<T>> O() {
        return this.v;
    }

    @Override // kotlin.i0.z.e.j
    public e P() {
        return (h.a)this.v.invoke().m();
    }

    @Override // kotlin.i0.z.e.j
    public final h Q() {
        return P().q().o();
    }

    @Override // kotlin.i0.z.e.j
    public final h R() {
        h hVar = P().R();
        n.e(hVar, "descriptor.staticScope");
        return hVar;
    }

    public Class<T> d() {
        return this.w;
    }

    @Override // kotlin.i0.z.e.j
    public boolean equals(Object object) {
        boolean z;
        Object obj2;
        if (object instanceof h && n.b(a.c(this), a.c((d)object))) {
            obj2 = n.b(a.c(this), a.c((d)object)) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    public List<Annotation> getAnnotations() {
        return (h.a)this.v.invoke().i();
    }

    @Override // kotlin.i0.z.e.j
    public int hashCode() {
        return a.c(this).hashCode();
    }

    @Override // kotlin.i0.z.e.j
    public boolean isAbstract() {
        int i;
        i = P().i() == z.ABSTRACT ? 1 : 0;
        return i;
    }

    @Override // kotlin.i0.z.e.j
    public boolean k() {
        return P().k();
    }

    @Override // kotlin.i0.z.e.j
    public boolean m() {
        int i;
        i = P().i() == z.SEALED ? 1 : 0;
        return i;
    }

    @Override // kotlin.i0.z.e.j
    public String n() {
        return (h.a)this.v.invoke().q();
    }

    @Override // kotlin.i0.z.e.j
    public String o() {
        return (h.a)this.v.invoke().r();
    }

    public T p() {
        return (h.a)this.v.invoke().p();
    }

    @Override // kotlin.i0.z.e.j
    public boolean q(Object object) {
        Class cls;
        Integer num = b.d(d());
        if (num != null) {
            return g0.k(object, num.intValue());
        }
        if (b.h(d()) != null) {
        } else {
            cls = d();
        }
        return cls.isInstance(object);
    }

    @Override // kotlin.i0.z.e.j
    public String toString() {
        String string;
        boolean stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("class ");
        a aVar = M();
        b bVar2 = aVar.h();
        n.e(bVar2, "classId.packageFqName");
        if (bVar2.d()) {
            string = "";
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(bVar2.b());
            stringBuilder.append(".");
            string = stringBuilder.toString();
        }
        String str7 = aVar.i().b();
        n.e(str7, "classId.relativeClassName.asString()");
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(string);
        stringBuilder3.append(l.F(str7, '.', '$', false, 4, 0));
        stringBuilder2.append(stringBuilder3.toString());
        return stringBuilder2.toString();
    }

    public Collection<l> y() {
        f fVar;
        f iNTERFACE;
        e eVar = P();
        if (eVar.f() != f.INTERFACE && eVar.f() == f.OBJECT) {
            if (eVar.f() == f.OBJECT) {
            }
            Collection collection = eVar.j();
            n.e(collection, "descriptor.constructors");
            return collection;
        }
        return p.g();
    }

    public Collection<x> z(e e) {
        n.f(e, "name");
        final d fROM_REFLECTION = d.FROM_REFLECTION;
        return p.t0(Q().a(e, fROM_REFLECTION), R().a(e, fROM_REFLECTION));
    }
}
