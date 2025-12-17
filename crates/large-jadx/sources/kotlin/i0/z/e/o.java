package kotlin.i0.z.e;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.p;
import kotlin.d0.d.c0;
import kotlin.d0.d.j;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.x;
import kotlin.i0.f;
import kotlin.i0.l;
import kotlin.i0.z.e.m0.c.b.d;
import kotlin.i0.z.e.m0.e.a0.a;
import kotlin.i0.z.e.m0.e.a0.b.f;
import kotlin.i0.z.e.m0.e.a0.b.g;
import kotlin.i0.z.e.m0.e.l;
import kotlin.i0.z.e.m0.e.n;
import kotlin.i0.z.e.m0.e.z.e;
import kotlin.i0.z.e.m0.e.z.g;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.j.b.u;
import kotlin.reflect.jvm.internal.impl.descriptors.l;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.a.f;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.b.b;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.t;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class o extends kotlin.i0.z.e.j {

    private final kotlin.i0.z.e.c0.b<kotlin.i0.z.e.o.a> v;
    private final Class<?> w;

    private final class a extends kotlin.i0.z.e.j.b {

        static final l[] i;
        private final kotlin.i0.z.e.c0.a d;
        private final kotlin.i0.z.e.c0.a e;
        private final kotlin.i0.z.e.c0.b f;
        private final kotlin.i0.z.e.c0.b g;
        final kotlin.i0.z.e.o h;
        static {
            Class<kotlin.i0.z.e.o.a> obj = o.a.class;
            l[] arr = new l[5];
            x xVar = new x(c0.b(obj), "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;");
            x xVar2 = new x(c0.b(obj), "scope", "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;");
            x xVar3 = new x(c0.b(obj), "multifileFacade", "getMultifileFacade()Ljava/lang/Class;");
            x xVar4 = new x(c0.b(obj), "metadata", "getMetadata()Lkotlin/Triple;");
            x xVar5 = new x(c0.b(obj), "members", "getMembers()Ljava/util/Collection;");
            o.a.i = arr;
        }

        public a(kotlin.i0.z.e.o o) {
            this.h = o;
            super(o);
            o.a.a obj1 = new o.a.a(this);
            this.d = c0.d(obj1);
            obj1 = new o.a.e(this);
            this.e = c0.d(obj1);
            obj1 = new o.a.d(this);
            this.f = c0.b(obj1);
            obj1 = new o.a.c(this);
            this.g = c0.b(obj1);
            obj1 = new o.a.b(this);
            c0.d(obj1);
        }

        public static final f b(kotlin.i0.z.e.o.a o$a) {
            return a.c();
        }

        private final f c() {
            return (f)this.d.b(this, o.a.i[0]);
        }

        public final t<g, l, f> d() {
            return (t)this.g.b(this, o.a.i[3]);
        }

        public final Class<?> e() {
            return (Class)this.f.b(this, o.a.i[2]);
        }

        @Override // kotlin.i0.z.e.j$b
        public final h f() {
            return (h)this.e.b(this, o.a.i[1]);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0010\u0003\u001a\u0012 \u0002*\u0008\u0018\u00010\u0000R\u00020\u00010\u0000R\u00020\u0001H\n¢\u0006\u0004\u0008\u0003\u0010\u0004", d2 = {"Lkotlin/i0/z/e/o$a;", "Lkotlin/i0/z/e/o;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/i0/z/e/o$a;"}, k = 3, mv = {1, 4, 1})
    static final class b extends p implements a<kotlin.i0.z.e.o.a> {

        final kotlin.i0.z.e.o this$0;
        b(kotlin.i0.z.e.o o) {
            this.this$0 = o;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final kotlin.i0.z.e.o.a a() {
            o.a aVar = new o.a(this.this$0);
            return aVar;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006", d2 = {"Lkotlin/i0/z/e/m0/j/b/u;", "p1", "Lkotlin/i0/z/e/m0/e/n;", "p2", "Lkotlin/reflect/jvm/internal/impl/descriptors/o0;", "l", "(Lkotlin/i0/z/e/m0/j/b/u;Lkotlin/i0/z/e/m0/e/n;)Lkotlin/reflect/jvm/internal/impl/descriptors/o0;"}, k = 3, mv = {1, 4, 1})
    static final class c extends j implements p<u, n, o0> {

        public static final kotlin.i0.z.e.o.c a;
        static {
            o.c cVar = new o.c();
            o.c.a = cVar;
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
    public o(Class<?> class, String string2) {
        n.f(class, "jClass");
        super();
        this.w = class;
        o.b obj1 = new o.b(this);
        obj1 = c0.b(obj1);
        n.e(obj1, "ReflectProperties.lazy { Data() }");
        this.v = obj1;
    }

    private final h K() {
        return (o.a)this.v.invoke().f();
    }

    @Override // kotlin.i0.z.e.j
    public o0 A(int i) {
        Object str2;
        int i2;
        Object obj3;
        Object str;
        Object obj4;
        Object obj2;
        g gVar;
        Object obj;
        kotlin.i0.z.e.o.c cVar;
        int obj10;
        str2 = (o.a)this.v.invoke().d();
        i2 = 0;
        obj3 = str2.b();
        str2 = a.n;
        n.e(str2, "JvmProtoBuf.packageLocalVariable");
        obj4 = obj10;
        if (str2 != null && (n)obj4 != null) {
            obj3 = str2.b();
            str2 = a.n;
            n.e(str2, "JvmProtoBuf.packageLocalVariable");
            obj4 = obj10;
            if ((n)(n)obj4 != null) {
                obj10 = obj3.P();
                n.e(obj10, "packageProto.typeTable");
                gVar = new g(obj10);
                i2 = obj10;
            }
        }
        return i2;
    }

    protected Class<?> C() {
        Class cls;
        if ((o.a)this.v.invoke().e() != null) {
        } else {
            cls = d();
        }
        return cls;
    }

    public Collection<o0> D(e e) {
        n.f(e, "name");
        return K().c(e, d.FROM_REFLECTION);
    }

    public Class<?> d() {
        return this.w;
    }

    @Override // kotlin.i0.z.e.j
    public boolean equals(Object object) {
        boolean z;
        Object obj2;
        if (object instanceof o && n.b(d(), (o)object.d())) {
            obj2 = n.b(d(), (o)object.d()) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // kotlin.i0.z.e.j
    public int hashCode() {
        return d().hashCode();
    }

    @Override // kotlin.i0.z.e.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("file class ");
        stringBuilder.append(b.b(d()).b());
        return stringBuilder.toString();
    }

    public Collection<l> y() {
        return p.g();
    }

    public Collection<x> z(e e) {
        n.f(e, "name");
        return K().a(e, d.FROM_REFLECTION);
    }
}
