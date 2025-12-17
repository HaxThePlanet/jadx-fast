package kotlin.i0.z.e.m0.b.q;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.b0;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.x;
import kotlin.i0.l;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.c.b.d;
import kotlin.i0.z.e.m0.d.a.e0.g;
import kotlin.i0.z.e.m0.d.a.g0.l.f;
import kotlin.i0.z.e.m0.d.a.g0.l.g;
import kotlin.i0.z.e.m0.d.a.g0.l.j;
import kotlin.i0.z.e.m0.d.b.s;
import kotlin.i0.z.e.m0.d.b.t;
import kotlin.i0.z.e.m0.d.b.v;
import kotlin.i0.z.e.m0.e.c;
import kotlin.i0.z.e.m0.e.i;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.c;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.j;
import kotlin.i0.z.e.m0.i.j.i.a;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.i.v.h.b;
import kotlin.i0.z.e.m0.j.b.d0.d;
import kotlin.i0.z.e.m0.j.b.l;
import kotlin.i0.z.e.m0.j.b.v;
import kotlin.i0.z.e.m0.k.a;
import kotlin.i0.z.e.m0.k.i;
import kotlin.i0.z.e.m0.k.m;
import kotlin.i0.z.e.m0.k.n;
import kotlin.i0.z.e.m0.l.a1;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.e0;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.m0.l.y0;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.a0;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.b.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.f;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.i1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.i1.c;
import kotlin.reflect.jvm.internal.impl.descriptors.i1.d;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.h;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.z;
import kotlin.reflect.jvm.internal.impl.descriptors.l;
import kotlin.reflect.jvm.internal.impl.descriptors.n;
import kotlin.reflect.jvm.internal.impl.descriptors.s;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.x.a;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.jvm.internal.impl.utils.b;
import kotlin.reflect.jvm.internal.impl.utils.b.b;
import kotlin.reflect.jvm.internal.impl.utils.b.c;
import kotlin.reflect.jvm.internal.impl.utils.j;
import kotlin.reflect.jvm.internal.impl.utils.j.b;
import kotlin.y.p;
import kotlin.y.q0;

/* loaded from: classes3.dex */
public final class g implements a, c {

    static final l<Object>[] h;
    private final c0 a;
    private final kotlin.i0.z.e.m0.b.q.d b;
    private final i c;
    private final b0 d;
    private final i e;
    private final a<b, e> f;
    private final i g;

    private static enum a {

        HIDDEN,
        VISIBLE,
        NOT_CONSIDERED,
        DROP;
    }

    public class b {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[g.a.HIDDEN.ordinal()] = 1;
            iArr[g.a.NOT_CONSIDERED.ordinal()] = 2;
            iArr[g.a.DROP.ordinal()] = 3;
            iArr[g.a.VISIBLE.ordinal()] = 4;
            g.b.a = iArr;
        }
    }

    static final class h implements b.c<e> {

        final kotlin.i0.z.e.m0.b.q.g a;
        h(kotlin.i0.z.e.m0.b.q.g g) {
            this.a = g;
            super();
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b$c
        public Iterable a(Object object) {
            return b((e)object);
        }

        public final Iterable<e> b(e e) {
            int i;
            f fVar;
            boolean z;
            Collection obj6 = e.g().a();
            n.e(obj6, "it.typeConstructor.supertypes");
            ArrayList arrayList = new ArrayList();
            obj6 = obj6.iterator();
            while (obj6.hasNext()) {
                h hVar = (b0)obj6.next().L0().c();
                fVar = 0;
                if (hVar == null) {
                } else {
                }
                i = hVar.a();
                if (i instanceof e) {
                } else {
                }
                i = fVar;
                if (i == 0) {
                } else {
                }
                fVar = g.g(this.a, i);
                if (fVar != null) {
                }
                arrayList.add(fVar);
                i = fVar;
            }
            return arrayList;
        }
    }

    static final class j implements b.c<b> {

        public static final kotlin.i0.z.e.m0.b.q.g.j a;
        static {
            g.j jVar = new g.j();
            g.j.a = jVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b$c
        public Iterable a(Object object) {
            return b((b)object);
        }

        public final Iterable<b> b(b b) {
            return b.a().e();
        }
    }

    public static final class i extends b.b<e, kotlin.i0.z.e.m0.b.q.g.a> {

        final String a;
        final b0<kotlin.i0.z.e.m0.b.q.g.a> b;
        i(String string, b0<kotlin.i0.z.e.m0.b.q.g.a> b02) {
            this.a = string;
            this.b = b02;
            super();
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b$b
        public Object a() {
            return e();
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b$b
        public boolean c(Object object) {
            return d((e)object);
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b$b
        public boolean d(e e) {
            Object vISIBLE;
            boolean contains;
            b0 obj3;
            n.f(e, "javaClassDescriptor");
            obj3 = s.a(v.a, e, this.a);
            kotlin.i0.z.e.m0.b.q.i iVar = i.a;
            if (iVar.e().contains(obj3)) {
                obj3.element = g.a.HIDDEN;
            } else {
                if (iVar.h().contains(obj3)) {
                    obj3.element = g.a.VISIBLE;
                } else {
                    if (iVar.c().contains(obj3)) {
                        obj3.element = g.a.DROP;
                    }
                }
            }
            obj3 = obj3.element == null ? 1 : 0;
            return obj3;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b$b
        public kotlin.i0.z.e.m0.b.q.g.a e() {
            Object nOT_CONSIDERED;
            if ((g.a)b0Var.element == null) {
                nOT_CONSIDERED = g.a.NOT_CONSIDERED;
            }
            return nOT_CONSIDERED;
        }
    }

    static final class c extends p implements a<i0> {

        final n $storageManager;
        final kotlin.i0.z.e.m0.b.q.g this$0;
        c(kotlin.i0.z.e.m0.b.q.g g, n n2) {
            this.this$0 = g;
            this.$storageManager = n2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final i0 a() {
            e0 e0Var = new e0(this.$storageManager, g.i(this.this$0).a());
            return w.c(g.i(this.this$0).a(), e.d.a(), e0Var).q();
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    static final class e extends p implements a<b0> {

        final kotlin.i0.z.e.m0.b.q.g this$0;
        e(kotlin.i0.z.e.m0.b.q.g g) {
            this.this$0 = g;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final b0 a() {
            i0 i0Var = g.h(this.this$0).m().i();
            n.e(i0Var, "moduleDescriptor.builtIns.anyType");
            return i0Var;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    static final class f extends p implements a<e> {

        final f $javaAnalogueDescriptor;
        final e $kotlinMutableClassIfContainer;
        f(f f, e e2) {
            this.$javaAnalogueDescriptor = f;
            this.$kotlinMutableClassIfContainer = e2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final e a() {
            final g gVar = g.a;
            n.e(gVar, "EMPTY");
            return this.$javaAnalogueDescriptor.M0(gVar, this.$kotlinMutableClassIfContainer);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    static final class g extends p implements l<h, Collection<? extends t0>> {

        final e $name;
        g(e e) {
            this.$name = e;
            super(1);
        }

        public final Collection<t0> a(h h) {
            n.f(h, "it");
            return h.a(this.$name, d.FROM_BUILTINS);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((h)object);
        }
    }

    static final class k extends p implements l<b, Boolean> {

        final kotlin.i0.z.e.m0.b.q.g this$0;
        k(kotlin.i0.z.e.m0.b.q.g g) {
            this.this$0 = g;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final Boolean a(b b) {
            Object aVar;
            boolean obj3;
            if (b.f() == b.a.DECLARATION && g.f(this.this$0).c((e)b.b())) {
                obj3 = g.f(this.this$0).c((e)b.b()) ? 1 : 0;
            } else {
            }
            return Boolean.valueOf(obj3);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((b)object);
        }
    }

    static final class l extends p implements a<g> {

        final kotlin.i0.z.e.m0.b.q.g this$0;
        l(kotlin.i0.z.e.m0.b.q.g g) {
            this.this$0 = g;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final g a() {
            return g.q.a(p.b(f.b(g.h(this.this$0).m(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", 0, 0, 6, 0)));
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    public static final class d extends z {
        d(c0 c0, b b2) {
            super(c0, b2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.z
        public h.b C0() {
            return h.b.b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.z
        public h o() {
            return C0();
        }
    }
    static {
        Class<kotlin.i0.z.e.m0.b.q.g> obj = g.class;
        l[] arr = new l[3];
        x xVar = new x(c0.b(obj), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;");
        x xVar2 = new x(c0.b(obj), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;");
        x xVar3 = new x(c0.b(obj), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;");
        g.h = arr;
    }

    public g(c0 c0, n n2, a<kotlin.i0.z.e.m0.b.q.f.b> a3) {
        n.f(c0, "moduleDescriptor");
        n.f(n2, "storageManager");
        n.f(a3, "settingsComputation");
        super();
        this.a = c0;
        this.b = d.a;
        this.c = n2.d(a3);
        this.d = k(n2);
        g.c obj2 = new g.c(this, n2);
        this.e = n2.d(obj2);
        this.f = n2.b();
        obj2 = new g.l(this);
        this.g = n2.d(obj2);
    }

    public static final kotlin.i0.z.e.m0.b.q.d f(kotlin.i0.z.e.m0.b.q.g g) {
        return g.b;
    }

    public static final f g(kotlin.i0.z.e.m0.b.q.g g, e e2) {
        return g.p(e2);
    }

    public static final c0 h(kotlin.i0.z.e.m0.b.q.g g) {
        return g.a;
    }

    public static final kotlin.i0.z.e.m0.b.q.f.b i(kotlin.i0.z.e.m0.b.q.g g) {
        return g.s();
    }

    private final t0 j(d d, t0 t02) {
        final x.a obj3 = t02.s();
        obj3.n(d);
        obj3.m(t.e);
        obj3.f(d.q());
        obj3.d(d.I0());
        x obj2 = obj3.build();
        n.d((t0)obj2);
        return obj2;
    }

    private final b0 k(n n) {
        b bVar = new b("java.io");
        g.d dVar = new g.d(this.a, bVar);
        g.e eVar = new g.e(this);
        e0 e0Var = new e0(n, eVar);
        super(dVar, e.j("Serializable"), z.ABSTRACT, f.INTERFACE, p.b(e0Var), u0.a, 0, n);
        hVar.J0(h.b.b, q0.b(), 0);
        i0 obj13 = hVar.q();
        n.e(obj13, "mockSerializableClass.defaultType");
        return obj13;
    }

    private final Collection<t0> l(e e, l<? super h, ? extends Collection<? extends t0>> l2) {
        String next;
        a aVar;
        b bVar;
        Collection iterator;
        int i2;
        kotlin.i0.z.e.m0.b.q.g.f dECLARATION;
        int i3;
        int i;
        String str;
        f fVar = p(e);
        if (fVar == null) {
            return p.g();
        }
        Collection collection = this.b.i(a.i(fVar), b.f.a());
        Object obj2 = p.k0(collection);
        if ((e)obj2 == null) {
            return p.g();
        }
        ArrayList arrayList2 = new ArrayList(p.r(collection, 10));
        Iterator iterator2 = collection.iterator();
        for (e next4 : iterator2) {
            arrayList2.add(a.i(next4));
        }
        dECLARATION = new g.f(fVar, (e)obj2);
        h hVar = (e)this.f.a(a.i(fVar), dECLARATION).A0();
        n.e(hVar, "fakeJavaClassDescriptor.unsubstitutedMemberScope");
        ArrayList arrayList = new ArrayList();
        Iterator obj11 = (Iterable)l2.invoke(hVar).iterator();
        while (obj11.hasNext()) {
            next = obj11.next();
            aVar = next;
            i = 0;
            if ((t0)aVar.f() != b.a.DECLARATION) {
            } else {
            }
            if (aVar.getVisibility().d() == null) {
            } else {
            }
            if (h.k0(aVar) != null) {
            } else {
            }
            iterator = aVar.e();
            n.e(iterator, "analogueMember.overriddenDescriptors");
            if (iterator.isEmpty()) {
            } else {
            }
            iterator = iterator.iterator();
            for (x next5 : iterator) {
                kotlin.reflect.jvm.internal.impl.descriptors.m mVar = next5.b();
                n.e(mVar, "it.containingDeclaration");
            }
            bVar = i;
            if (bVar != null) {
            } else {
            }
            if (t(aVar, this.b.c(e)) != null) {
            }
            i3 = i;
            if (i3 != 0) {
            }
            arrayList.add(next);
            mVar = (x)iterator.next().b();
            n.e(mVar, "it.containingDeclaration");
            if (jVar.contains(a.i(mVar))) {
            } else {
            }
            bVar = i3;
        }
        return arrayList;
    }

    private final i0 m() {
        return (i0)m.a(this.e, this, g.h[1]);
    }

    private static final boolean n(l l, a1 a12, l l3) {
        int obj0;
        obj0 = j.A(l, l3.c(a12)) == j.i.a.OVERRIDABLE ? 1 : 0;
        return obj0;
    }

    private final f p(e e) {
        int i;
        int obj4;
        i = 0;
        if (h.Z(e)) {
            return i;
        }
        if (!h.I0(e)) {
            return i;
        }
        obj4 = a.j(e);
        if (!obj4.f()) {
            return i;
        }
        obj4 = c.a.o(obj4);
        if (obj4 == null) {
            obj4 = i;
        } else {
            obj4 = obj4.b();
        }
        if (obj4 == null) {
            return i;
        }
        obj4 = s.a(s().a(), obj4, d.FROM_BUILTINS);
        if (obj4 instanceof f) {
            i = obj4;
        }
        return i;
    }

    private final kotlin.i0.z.e.m0.b.q.g.a q(x x) {
        int i = 0;
        b0 b0Var = new b0();
        g.h hVar = new g.h(this);
        g.i iVar = new g.i(t.c(x, i, i, 3, 0), b0Var);
        Object obj5 = b.b(p.b((e)x.b()), hVar, iVar);
        n.e(obj5, "private fun FunctionDescriptor.getJdkMethodStatus(): JDKMemberStatus {\n        val owner = containingDeclaration as ClassDescriptor\n        val jvmDescriptor = computeJvmDescriptor()\n        var result: JDKMemberStatus? = null\n        return DFS.dfs<ClassDescriptor, JDKMemberStatus>(\n            listOf(owner),\n            {\n                // Search through mapped supertypes to determine that Set.toArray should be invisible, while we have only\n                // Collection.toArray there explicitly\n                // Note, that we can't find j.u.Collection.toArray within overriddenDescriptors of j.u.Set.toArray\n                it.typeConstructor.supertypes.mapNotNull {\n                    (it.constructor.declarationDescriptor?.original as? ClassDescriptor)?.getJavaAnalogue()\n                }\n            },\n            object : DFS.AbstractNodeHandler<ClassDescriptor, JDKMemberStatus>() {\n                override fun beforeChildren(javaClassDescriptor: ClassDescriptor): Boolean {\n                    val signature = SignatureBuildingComponents.signature(javaClassDescriptor, jvmDescriptor)\n                    when (signature) {\n                        in HIDDEN_METHOD_SIGNATURES -> result = JDKMemberStatus.HIDDEN\n                        in VISIBLE_METHOD_SIGNATURES -> result = JDKMemberStatus.VISIBLE\n                        in DROP_LIST_METHOD_SIGNATURES -> result = JDKMemberStatus.DROP\n                    }\n\n                    return result == null\n                }\n\n                override fun result() = result ?: JDKMemberStatus.NOT_CONSIDERED\n            })\n    }");
        return (g.a)obj5;
    }

    private final g r() {
        return (g)m.a(this.g, this, g.h[2]);
    }

    private final kotlin.i0.z.e.m0.b.q.f.b s() {
        return (f.b)m.a(this.c, this, g.h[0]);
    }

    private final boolean t(t0 t0, boolean z2) {
        int i = 0;
        if (z2 ^= contains != 0) {
            return 1;
        }
        g.k kVar = new g.k(this);
        Boolean obj5 = b.e(p.b(t0), g.j.a, kVar);
        n.e(obj5, "private fun SimpleFunctionDescriptor.isMutabilityViolation(isMutable: Boolean): Boolean {\n        val owner = containingDeclaration as ClassDescriptor\n        val jvmDescriptor = computeJvmDescriptor()\n\n        if ((SignatureBuildingComponents.signature(owner, jvmDescriptor) in MUTABLE_METHOD_SIGNATURES) xor isMutable) return true\n\n        return DFS.ifAny<CallableMemberDescriptor>(\n            listOf(this),\n            { it.original.overriddenDescriptors }\n        ) { overridden ->\n            overridden.kind == CallableMemberDescriptor.Kind.DECLARATION &&\n                    j2kClassMapper.isMutable(overridden.containingDeclaration as ClassDescriptor)\n        }\n    }");
        return obj5.booleanValue();
    }

    private final boolean u(l l, e e2) {
        int size;
        int i;
        boolean obj3;
        Object obj4;
        if (l.h().size() == 1) {
            obj3 = l.h();
            n.e(obj3, "valueParameters");
            obj3 = (c1)p.z0(obj3).getType().L0().c();
            if (obj3 == null) {
                obj3 = 0;
            } else {
                obj3 = a.j(obj3);
            }
            if (n.b(obj3, a.j(e2))) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public Collection<d> a(e e) {
        f fVar;
        ArrayList arrayList;
        boolean contains2;
        int next2;
        boolean next;
        int contains;
        int i3;
        int i2;
        int i;
        boolean z;
        Collection iterator;
        int i4;
        boolean empty;
        String str;
        n.f(e, "classDescriptor");
        if (e.f() == f.CLASS) {
            if (!s().b()) {
            } else {
                f fVar2 = p(e);
                if (fVar2 == null) {
                    return p.g();
                }
                e eVar = d.h(this.b, a.i(fVar2), b.f.a(), 0, 4, 0);
                if (eVar == null) {
                    return p.g();
                }
                a1 a1Var = j.a(eVar, fVar2).c();
                arrayList = new ArrayList();
                Iterator iterator2 = fVar2.N0().iterator();
                contains = 0;
                i3 = 3;
                i2 = 0;
                while (iterator2.hasNext()) {
                    next2 = iterator2.next();
                    i = next2;
                    i4 = 1;
                    if ((d)i.getVisibility().d()) {
                    }
                    if (i2 != 0) {
                    }
                    contains = 0;
                    i3 = 3;
                    i2 = 0;
                    arrayList.add(next2);
                    iterator = eVar.j();
                    n.e(iterator, "defaultKotlinVersion.constructors");
                    if (iterator.isEmpty()) {
                    } else {
                    }
                    iterator = iterator.iterator();
                    for (d next5 : iterator) {
                        n.e(next5, "it");
                    }
                    z = i4;
                    if (z != 0 && !u(i, e) && !h.k0(i) && !i.a.d().contains(s.a(v.a, fVar2, t.c(i, i2, i2, i3, contains)))) {
                    }
                    if (!u(i, e)) {
                    }
                    if (!h.k0(i)) {
                    }
                    if (!i.a.d().contains(s.a(v.a, fVar2, t.c(i, i2, i2, i3, contains)))) {
                    }
                    i2 = i4;
                    Object next5 = iterator.next();
                    n.e((d)next5, "it");
                    if (g.n(next5, a1Var, i)) {
                    } else {
                    }
                    z = i2;
                }
                ArrayList arrayList2 = new ArrayList(p.r(arrayList, 10));
                Iterator iterator3 = arrayList.iterator();
                while (iterator3.hasNext()) {
                    Object next4 = iterator3.next();
                    x.a aVar2 = (d)next4.s();
                    aVar2.n(e);
                    aVar2.f(e.q());
                    aVar2.e();
                    aVar2.k(a1Var.j());
                    if (!i.a.g().contains(s.a(v.a, fVar2, t.c(next4, i2, i2, i3, contains)))) {
                    }
                    arrayList = aVar2.build();
                    Objects.requireNonNull(arrayList, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
                    arrayList2.add((d)arrayList);
                    aVar2.q(r());
                }
            }
            return arrayList2;
        }
        return p.g();
    }

    public Collection<t0> b(e e, e e2) {
        Object iterator;
        boolean z;
        int i2;
        boolean empty;
        int build;
        x.a aVar;
        e eVar;
        int i;
        n.f(e, "name");
        n.f(e2, "classDescriptor");
        if (n.b(e, a.e.a()) && e2 instanceof d && h.c0(e2)) {
            if (e2 instanceof d) {
                if (h.c0(e2)) {
                    iterator = (d)e2.W0().l0();
                    n.e(iterator, "classDescriptor.classProto.functionList");
                    if (iterator instanceof Collection != null && iterator.isEmpty()) {
                        if (iterator.isEmpty()) {
                            i2 = i4;
                        } else {
                            iterator = iterator.iterator();
                            while (iterator.hasNext()) {
                                if (!n.b(v.b(e2.V0().g(), (i)iterator.next().P()), a.e.a())) {
                                    break;
                                }
                            }
                        }
                    } else {
                    }
                    if (i2 != 0) {
                        return p.g();
                    }
                    return p.b(j(e2, (t0)p.y0(m().o().a(e, d.FROM_BUILTINS))));
                }
            }
        }
        if (!s().b()) {
            return p.g();
        }
        g.g gVar = new g.g(e);
        ArrayList arrayList = new ArrayList();
        Iterator obj7 = l(e2, gVar).iterator();
        while (obj7.hasNext()) {
            Object next3 = obj7.next();
            x xVar = next3.c(j.a((e)(t0)next3.b(), e2).c());
            Objects.requireNonNull(xVar, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
            aVar = (t0)xVar.s();
            aVar.n(e2);
            aVar.d(e2.I0());
            aVar.e();
            build = g.b.a[q(next3).ordinal()];
            eVar = 0;
            if (build != 1) {
            } else {
            }
            if (a0.a(e2)) {
            } else {
            }
            aVar.h();
            n.d((t0)aVar.build());
            if (eVar != 0) {
            }
            arrayList.add(eVar);
            if (build != 2) {
            } else {
            }
            aVar.q(r());
            if (build != 3) {
            }
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i1.a
    public boolean c(e e, t0 t02) {
        int i;
        Collection obj7;
        boolean obj8;
        n.f(e, "classDescriptor");
        n.f(t02, "functionDescriptor");
        obj7 = p(e);
        i = 1;
        if (obj7 == null) {
            return i;
        }
        if (!t02.getAnnotations().u1(d.a())) {
            return i;
        }
        int i3 = 0;
        if (!s().b()) {
            return i3;
        }
        int i2 = 3;
        final int i4 = 0;
        obj8 = t02.getName();
        n.e(obj8, "functionDescriptor.name");
        obj7 = obj7.P0().a(obj8, d.FROM_BUILTINS);
        if (obj7 instanceof Collection != null && obj7.isEmpty()) {
            if (obj7.isEmpty()) {
                i = i3;
            } else {
                obj7 = obj7.iterator();
                while (obj7.hasNext()) {
                    if (!n.b(t.c((t0)obj7.next(), i3, i3, i2, i4), t.c(t02, i3, i3, i2, i4))) {
                        break;
                    }
                }
            }
        } else {
        }
        return i;
    }

    public Collection<b0> d(e e) {
        int iVar;
        b0 z;
        String str;
        List obj4;
        n.f(e, "classDescriptor");
        obj4 = a.j(e);
        iVar = i.a;
        if (iVar.i(obj4)) {
            obj4 = new b0[2];
            i0 i0Var = m();
            n.e(i0Var, "cloneableType");
            obj4 = p.j(i0Var, this.d);
        } else {
            if (iVar.j(obj4)) {
                obj4 = p.b(this.d);
            } else {
                obj4 = p.g();
            }
        }
        return obj4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i1.a
    public Collection e(e e) {
        return o(e);
    }

    public Set<e> o(e e) {
        int i;
        Object obj2;
        n.f(e, "classDescriptor");
        if (!s().b()) {
            return q0.b();
        }
        obj2 = p(e);
        i = 0;
        if (obj2 == null) {
        } else {
            obj2 = obj2.P0();
            if (obj2 == null) {
            } else {
                i = obj2.b();
            }
        }
        if (i == 0) {
            i = q0.b();
        }
        return i;
    }
}
