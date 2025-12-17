package kotlin.i0.z.e.m0.l.j1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.d0.c.a;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.i.p.a.b;
import kotlin.i0.z.e.m0.l.g1;
import kotlin.i0.z.e.m0.l.m1.a;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.m0.l.v0;
import kotlin.j;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class j implements b {

    private final v0 a;
    private a<? extends List<? extends g1>> b;
    private final kotlin.i0.z.e.m0.l.j1.j c;
    private final z0 d;
    private final h e;

    static final class a extends p implements a<List<? extends g1>> {

        final List<g1> $supertypes;
        a(List<? extends g1> list) {
            this.$supertypes = list;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        public final List<g1> invoke() {
            return this.$supertypes;
        }
    }

    static final class b extends p implements a<List<? extends g1>> {

        final kotlin.i0.z.e.m0.l.j1.j this$0;
        b(kotlin.i0.z.e.m0.l.j1.j j) {
            this.this$0 = j;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        public final List<g1> invoke() {
            int invoke;
            a aVar = j.f(this.this$0);
            if (aVar == null) {
                invoke = 0;
            } else {
                invoke = aVar.invoke();
            }
            return invoke;
        }
    }

    static final class c extends p implements a<List<? extends g1>> {

        final List<g1> $supertypes;
        c(List<? extends g1> list) {
            this.$supertypes = list;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        public final List<g1> invoke() {
            return this.$supertypes;
        }
    }

    static final class d extends p implements a<List<? extends g1>> {

        final kotlin.i0.z.e.m0.l.j1.g $kotlinTypeRefiner;
        final kotlin.i0.z.e.m0.l.j1.j this$0;
        d(kotlin.i0.z.e.m0.l.j1.j j, kotlin.i0.z.e.m0.l.j1.g g2) {
            this.this$0 = j;
            this.$kotlinTypeRefiner = g2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        public final List<g1> invoke() {
            int i;
            List list = this.this$0.g();
            ArrayList arrayList = new ArrayList(p.r(list, 10));
            Iterator iterator = list.iterator();
            for (g1 next2 : iterator) {
                arrayList.add(next2.Q0(this.$kotlinTypeRefiner));
            }
            return arrayList;
        }
    }
    public j(v0 v0, List<? extends g1> list2, kotlin.i0.z.e.m0.l.j1.j j3) {
        n.f(v0, "projection");
        n.f(list2, "supertypes");
        j.a aVar = new j.a(list2);
        super(v0, aVar, j3, 0, 8, 0);
    }

    public j(v0 v0, List list2, kotlin.i0.z.e.m0.l.j1.j j3, int i4, g g5) {
        int obj3;
        obj3 = i4 &= 4 != 0 ? 0 : obj3;
        super(v0, list2, obj3);
    }

    public j(v0 v0, a<? extends List<? extends g1>> a2, kotlin.i0.z.e.m0.l.j1.j j3, z0 z04) {
        n.f(v0, "projection");
        super();
        this.a = v0;
        this.b = a2;
        this.c = j3;
        this.d = z04;
        j.b obj3 = new j.b(this);
        this.e = j.a(m.PUBLICATION, obj3);
    }

    public j(v0 v0, a a2, kotlin.i0.z.e.m0.l.j1.j j3, z0 z04, int i5, g g6) {
        int obj3;
        int obj4;
        int obj5;
        final int i = 0;
        obj3 = i5 & 2 != 0 ? i : obj3;
        obj4 = i5 & 4 != 0 ? i : obj4;
        obj5 = i5 &= 8 != 0 ? i : obj5;
        super(v0, obj3, obj4, obj5);
    }

    public static final a f(kotlin.i0.z.e.m0.l.j1.j j) {
        return j.b;
    }

    private final List<g1> h() {
        return (List)this.e.getValue();
    }

    @Override // kotlin.i0.z.e.m0.i.p.a.b
    public Collection a() {
        return g();
    }

    @Override // kotlin.i0.z.e.m0.i.p.a.b
    public t0 b(kotlin.i0.z.e.m0.l.j1.g g) {
        return j(g);
    }

    @Override // kotlin.i0.z.e.m0.i.p.a.b
    public h c() {
        return null;
    }

    @Override // kotlin.i0.z.e.m0.i.p.a.b
    public boolean d() {
        return 0;
    }

    @Override // kotlin.i0.z.e.m0.i.p.a.b
    public v0 e() {
        return this.a;
    }

    @Override // kotlin.i0.z.e.m0.i.p.a.b
    public boolean equals(Object object) {
        int i;
        Object jVar;
        int class;
        Object obj5;
        if (this == object) {
            return 1;
        }
        if (object == null) {
            class = 0;
        } else {
            class = object.getClass();
        }
        int i2 = 0;
        if (!n.b(j.class, class)) {
            return i2;
        }
        Objects.requireNonNull(object, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
        if (this.c == null) {
            jVar = this;
        }
        final kotlin.i0.z.e.m0.l.j1.j jVar2 = object.c;
        if (jVar2 == null) {
        } else {
            obj5 = jVar2;
        }
        if (jVar == obj5) {
        } else {
            i = i2;
        }
        return i;
    }

    public List<g1> g() {
        List list;
        if (h() == null) {
            list = p.g();
        }
        return list;
    }

    public List<z0> getParameters() {
        return p.g();
    }

    @Override // kotlin.i0.z.e.m0.i.p.a.b
    public int hashCode() {
        int i;
        kotlin.i0.z.e.m0.l.j1.j jVar = this.c;
        if (jVar == null) {
            i = super.hashCode();
        } else {
            i = jVar.hashCode();
        }
        return i;
    }

    public final void i(List<? extends g1> list) {
        n.f(list, "supertypes");
        a aVar = this.b;
        j.c cVar = new j.c(list);
        this.b = cVar;
    }

    @Override // kotlin.i0.z.e.m0.i.p.a.b
    public kotlin.i0.z.e.m0.l.j1.j j(kotlin.i0.z.e.m0.l.j1.g g) {
        a dVar;
        Object jVar;
        int obj5;
        n.f(g, "kotlinTypeRefiner");
        v0 v0Var2 = e().b(g);
        n.e(v0Var2, "projection.refine(kotlinTypeRefiner)");
        if (this.b == null) {
            obj5 = 0;
        } else {
            dVar = new j.d(this, g);
            obj5 = dVar;
        }
        if (this.c == null) {
            jVar = this;
        }
        j jVar2 = new j(v0Var2, obj5, jVar, this.d);
        return jVar2;
    }

    @Override // kotlin.i0.z.e.m0.i.p.a.b
    public h m() {
        kotlin.i0.z.e.m0.l.b0 type = e().getType();
        n.e(type, "projection.type");
        return a.e(type);
    }

    @Override // kotlin.i0.z.e.m0.i.p.a.b
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CapturedType(");
        stringBuilder.append(e());
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
