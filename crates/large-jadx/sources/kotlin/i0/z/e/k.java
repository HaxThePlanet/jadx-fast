package kotlin.i0.z.e;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.c.a;
import kotlin.d0.d.c;
import kotlin.d0.d.c0;
import kotlin.d0.d.d;
import kotlin.d0.d.g;
import kotlin.d0.d.i;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.x;
import kotlin.i0.g;
import kotlin.i0.k;
import kotlin.i0.l;
import kotlin.i0.z.e.l0.a;
import kotlin.i0.z.e.l0.a.a;
import kotlin.i0.z.e.l0.a.b;
import kotlin.i0.z.e.l0.d;
import kotlin.i0.z.e.l0.e;
import kotlin.i0.z.e.l0.e.a;
import kotlin.i0.z.e.l0.e.b;
import kotlin.i0.z.e.l0.e.c;
import kotlin.i0.z.e.l0.e.e;
import kotlin.i0.z.e.l0.e.h;
import kotlin.i0.z.e.l0.e.h.a;
import kotlin.i0.z.e.l0.e.h.b;
import kotlin.i0.z.e.l0.e.h.c;
import kotlin.i0.z.e.l0.e.h.d;
import kotlin.i0.z.e.l0.e.h.e;
import kotlin.i0.z.e.l0.e.h.f;
import kotlin.i0.z.e.l0.f;
import kotlin.i0.z.e.l0.h;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.t.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class k extends kotlin.i0.z.e.f<Object> implements i<Object>, g<Object>, kotlin.i0.z.e.c {

    static final l[] C;
    private final String A;
    private final Object B;
    private final kotlin.i0.z.e.c0.a w;
    private final kotlin.i0.z.e.c0.b x;
    private final kotlin.i0.z.e.c0.b y;
    private final kotlin.i0.z.e.j z;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0010\u0002\u001a\u0012\u0012\u0002\u0008\u0003 \u0001*\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\u0008\u0002\u0010\u0003", d2 = {"Lkotlin/i0/z/e/l0/d;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/i0/z/e/l0/d;"}, k = 3, mv = {1, 4, 1})
    static final class a extends p implements a<d<? extends Member>> {

        final kotlin.i0.z.e.k this$0;
        a(kotlin.i0.z.e.k k) {
            this.this$0 = k;
            super(0);
        }

        public final d<Member> a() {
            Object constructor;
            e hVar;
            int name;
            boolean name2;
            kotlin.i0.z.e.j jVar;
            kotlin.i0.z.e.k this$0;
            int str;
            kotlin.i0.z.e.d dVar = g0.b.g(this.this$0.L());
            str = 10;
            if (dVar instanceof d.d) {
                if (this.this$0.z()) {
                    java.util.List parameters = this.this$0.getParameters();
                    ArrayList arrayList = new ArrayList(p.r(parameters, str));
                    Iterator iterator = parameters.iterator();
                    for (k next2 : iterator) {
                        name = next2.getName();
                        n.d(name);
                        arrayList.add(name);
                    }
                    super(this.this$0.w().d(), arrayList, a.a.POSITIONAL_CALL, a.b.KOTLIN, 0, 16, 0);
                    return aVar;
                }
                constructor = this.this$0.w().s((d.d)dVar.b());
                if (constructor instanceof Constructor) {
                    this$0 = this.this$0;
                    hVar = k.B(this$0, (Constructor)constructor, this$0.L());
                    return h.c(hVar, this.this$0.L(), false, 2, 0);
                } else {
                    if (!constructor instanceof Method) {
                    } else {
                        if (!Modifier.isStatic((Method)constructor.getModifiers())) {
                            hVar = k.C(this.this$0, constructor);
                        } else {
                            if (this.this$0.L().getAnnotations().o(j0.h()) != null) {
                                hVar = k.D(this.this$0, constructor);
                            } else {
                                hVar = k.E(this.this$0, constructor);
                            }
                        }
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Could not compute caller for function: ");
                stringBuilder.append(this.this$0.L());
                stringBuilder.append(" (member = ");
                stringBuilder.append(constructor);
                stringBuilder.append(')');
                a0 a0Var = new a0(stringBuilder.toString());
                throw a0Var;
            } else {
                if (dVar instanceof d.e) {
                    constructor = this.this$0.w().w((d.e)dVar.c(), dVar.b());
                } else {
                    if (dVar instanceof d.c) {
                        constructor = (d.c)dVar.b();
                    } else {
                        if (dVar instanceof d.b) {
                            constructor = (d.b)dVar.b();
                        }
                    }
                }
            }
            if (!dVar instanceof d.a) {
            } else {
                java.util.List list = (d.a)dVar.b();
                ArrayList arrayList2 = new ArrayList(p.r(list, str));
                Iterator iterator2 = list.iterator();
                for (Method next4 : iterator2) {
                    n.e(next4, "it");
                    arrayList2.add(next4.getName());
                }
                super(this.this$0.w().d(), arrayList2, a.a.POSITIONAL_CALL, a.b.JAVA, list);
                return aVar2;
            }
            NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
            throw noWhenBranchMatchedException;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0001\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u0000H\n¢\u0006\u0004\u0008\u0001\u0010\u0002", d2 = {"Lkotlin/i0/z/e/l0/d;", "a", "()Lkotlin/i0/z/e/l0/d;"}, k = 3, mv = {1, 4, 1})
    static final class b extends p implements a<d<? extends Member>> {

        final kotlin.i0.z.e.k this$0;
        b(kotlin.i0.z.e.k k) {
            this.this$0 = k;
            super(0);
        }

        public final d<Member> a() {
            Method method;
            int i;
            kotlin.i0.z.e.j name;
            kotlin.reflect.jvm.internal.impl.descriptors.h1.c cVar;
            boolean this$0;
            int name2;
            int str;
            int i2;
            String str2;
            int i3;
            kotlin.i0.z.e.d dVar = g0.b.g(this.this$0.L());
            str = 1;
            i2 = 0;
            if (dVar instanceof d.e) {
                Member member = this.this$0.v().b();
                n.d(member);
                method = this.this$0.w().u((d.e)dVar.c(), dVar.b(), static ^= str);
            } else {
                str2 = 10;
                if (dVar instanceof d.d) {
                    if (this.this$0.z()) {
                        java.util.List parameters = this.this$0.getParameters();
                        ArrayList arrayList = new ArrayList(p.r(parameters, str2));
                        Iterator iterator = parameters.iterator();
                        for (k next2 : iterator) {
                            name2 = next2.getName();
                            n.d(name2);
                            arrayList.add(name2);
                        }
                        super(this.this$0.w().d(), arrayList, a.a.CALL_BY_NAME, a.b.KOTLIN, 0, 16, 0);
                        return aVar;
                    }
                    method = this.this$0.w().t((d.d)dVar.b());
                } else {
                    if (dVar instanceof d.a) {
                        java.util.List list = (d.a)dVar.b();
                        ArrayList arrayList2 = new ArrayList(p.r(list, str2));
                        Iterator iterator2 = list.iterator();
                        for (Method next4 : iterator2) {
                            n.e(next4, "it");
                            arrayList2.add(next4.getName());
                        }
                        super(this.this$0.w().d(), arrayList2, a.a.CALL_BY_NAME, a.b.JAVA, list);
                        return aVar2;
                    }
                    method = i2;
                }
            }
            if (method instanceof Constructor) {
                this$0 = this.this$0;
                i = k.B(this$0, (Constructor)method, this$0.L());
            } else {
                if (method instanceof Method) {
                    kotlin.reflect.jvm.internal.impl.descriptors.m mVar = this.this$0.L().b();
                    Objects.requireNonNull(mVar, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    if (this.this$0.L().getAnnotations().o(j0.h()) != null && !(e)mVar.x()) {
                        mVar = this.this$0.L().b();
                        Objects.requireNonNull(mVar, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                        if (!(e)mVar.x()) {
                            i = k.D(this.this$0, (Method)method);
                        } else {
                            i = k.E(this.this$0, (Method)method);
                        }
                    } else {
                    }
                } else {
                    i = i2;
                }
            }
            if (i != 0) {
                i2 = h.b(i, this.this$0.L(), str);
            }
            return i2;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\u0008\u0002\u0010\u0003", d2 = {"Lkotlin/reflect/jvm/internal/impl/descriptors/x;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/reflect/jvm/internal/impl/descriptors/x;"}, k = 3, mv = {1, 4, 1})
    static final class c extends p implements a<x> {

        final String $name;
        final kotlin.i0.z.e.k this$0;
        c(kotlin.i0.z.e.k k, String string2) {
            this.this$0 = k;
            this.$name = string2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final x a() {
            return this.this$0.w().v(this.$name, k.F(this.this$0));
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    static {
        Class<kotlin.i0.z.e.k> obj = k.class;
        l[] arr = new l[3];
        x xVar = new x(c0.b(obj), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;");
        x xVar2 = new x(c0.b(obj), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;");
        x xVar3 = new x(c0.b(obj), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/calls/Caller;");
        k.C = arr;
    }

    public k(kotlin.i0.z.e.j j, String string2, String string3, Object object4) {
        n.f(j, "container");
        n.f(string2, "name");
        n.f(string3, "signature");
        super(j, string2, string3, 0, object4);
    }

    private k(kotlin.i0.z.e.j j, String string2, String string3, x x4, Object object5) {
        super();
        this.z = j;
        this.A = string3;
        this.B = object5;
        k.c obj1 = new k.c(this, string2);
        this.w = c0.c(x4, obj1);
        obj1 = new k.a(this);
        this.x = c0.b(obj1);
        obj1 = new k.b(this);
        this.y = c0.b(obj1);
    }

    k(kotlin.i0.z.e.j j, String string2, String string3, x x4, Object object5, int i6, g g7) {
        Object obj11;
        obj11 = i6 &= 16 != 0 ? c.NO_RECEIVER : obj11;
        super(j, string2, string3, x4, obj11);
    }

    public k(kotlin.i0.z.e.j j, x x2) {
        n.f(j, "container");
        n.f(x2, "descriptor");
        final String str4 = x2.getName().c();
        n.e(str4, "descriptor.name.asString()");
        super(j, str4, g0.b.g(x2).a(), x2, 0, 16, 0);
    }

    public static final e B(kotlin.i0.z.e.k k, Constructor constructor2, x x3) {
        return k.G(constructor2, x3);
    }

    public static final e.h C(kotlin.i0.z.e.k k, Method method2) {
        return k.H(method2);
    }

    public static final e.h D(kotlin.i0.z.e.k k, Method method2) {
        return k.I(method2);
    }

    public static final e.h E(kotlin.i0.z.e.k k, Method method2) {
        return k.J(method2);
    }

    public static final String F(kotlin.i0.z.e.k k) {
        return k.A;
    }

    private final e<Constructor<?>> G(Constructor<?> constructor, x x2) {
        Object obj;
        e obj3;
        if (a.f(x2)) {
            if (A()) {
                obj3 = new e.a(constructor, K());
            } else {
                obj3 = new e.b(constructor);
            }
        } else {
            if (A()) {
                obj3 = new e.c(constructor, K());
            } else {
                obj3 = new e.e(constructor);
            }
        }
        return obj3;
    }

    private final e.h H(Method method) {
        e.h aVar;
        Object obj;
        if (A()) {
            aVar = new e.h.a(method, K());
        } else {
            aVar = new e.h.d(method);
        }
        return aVar;
    }

    private final e.h I(Method method) {
        e.h bVar;
        if (A()) {
            bVar = new e.h.b(method);
        } else {
            bVar = new e.h.e(method);
        }
        return bVar;
    }

    private final e.h J(Method method) {
        e.h cVar;
        Object obj;
        if (A()) {
            cVar = new e.h.c(method, K());
        } else {
            cVar = new e.h.f(method);
        }
        return cVar;
    }

    private final Object K() {
        return h.a(this.B, L());
    }

    @Override // kotlin.i0.z.e.f
    public boolean A() {
        return z ^= 1;
    }

    @Override // kotlin.i0.z.e.f
    public x L() {
        return (x)this.w.b(this, k.C[0]);
    }

    @Override // kotlin.i0.z.e.f
    public boolean equals(Object object) {
        int i;
        boolean z;
        Object name;
        kotlin.i0.z.e.k obj4;
        obj4 = j0.b(object);
        i = 0;
        if (obj4 != null && n.b(w(), obj4.w()) && n.b(getName(), obj4.getName()) && n.b(this.A, obj4.A) && n.b(this.B, obj4.B)) {
            if (n.b(w(), obj4.w())) {
                if (n.b(getName(), obj4.getName())) {
                    if (n.b(this.A, obj4.A)) {
                        if (n.b(this.B, obj4.B)) {
                            i = 1;
                        }
                    }
                }
            }
        }
        return i;
    }

    @Override // kotlin.i0.z.e.f
    public int getArity() {
        return f.a(v());
    }

    @Override // kotlin.i0.z.e.f
    public String getName() {
        String str = L().getName().c();
        n.e(str, "descriptor.name.asString()");
        return str;
    }

    @Override // kotlin.i0.z.e.f
    public int hashCode() {
        return i4 += i7;
    }

    @Override // kotlin.i0.z.e.f
    public Object invoke() {
        return c.a.a(this);
    }

    @Override // kotlin.i0.z.e.f
    public Object invoke(Object object) {
        return c.a.b(this, object);
    }

    @Override // kotlin.i0.z.e.f
    public Object invoke(Object object, Object object2) {
        return c.a.c(this, object, object2);
    }

    @Override // kotlin.i0.z.e.f
    public Object invoke(Object object, Object object2, Object object3) {
        return c.a.d(this, object, object2, object3);
    }

    @Override // kotlin.i0.z.e.f
    public boolean isSuspend() {
        return L().isSuspend();
    }

    @Override // kotlin.i0.z.e.f
    public String toString() {
        return f0.b.d(L());
    }

    public d<?> v() {
        return (d)this.x.b(this, k.C[1]);
    }

    @Override // kotlin.i0.z.e.f
    public kotlin.i0.z.e.j w() {
        return this.z;
    }

    public d<?> x() {
        return (d)this.y.b(this, k.C[2]);
    }

    @Override // kotlin.i0.z.e.f
    public b y() {
        return L();
    }
}
