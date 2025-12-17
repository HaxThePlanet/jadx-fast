package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.x;
import kotlin.i0.l;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.i.v.b;
import kotlin.i0.z.e.m0.i.v.b.a;
import kotlin.i0.z.e.m0.i.v.g;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.i.v.h.b;
import kotlin.i0.z.e.m0.k.i;
import kotlin.i0.z.e.m0.k.m;
import kotlin.i0.z.e.m0.k.n;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.i0;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.k0.a;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.o;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class r extends kotlin.reflect.jvm.internal.impl.descriptors.j1.j implements k0 {

    static final l<Object>[] y;
    private final kotlin.reflect.jvm.internal.impl.descriptors.j1.x c;
    private final b v;
    private final i w;
    private final h x;

    static final class a extends p implements a<List<? extends f0>> {

        final kotlin.reflect.jvm.internal.impl.descriptors.j1.r this$0;
        a(kotlin.reflect.jvm.internal.impl.descriptors.j1.r r) {
            this.this$0 = r;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        public final List<f0> invoke() {
            return i0.b(this.this$0.C0().O0(), this.this$0.d());
        }
    }

    static final class b extends p implements a<h> {

        final kotlin.reflect.jvm.internal.impl.descriptors.j1.r this$0;
        b(kotlin.reflect.jvm.internal.impl.descriptors.j1.r r) {
            this.this$0 = r;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final h a() {
            h bVar;
            b.a aVar;
            String string;
            int i;
            kotlin.i0.z.e.m0.f.e name;
            if (this.this$0.G().isEmpty()) {
                bVar = h.b.b;
            } else {
                List list2 = this.this$0.G();
                ArrayList arrayList = new ArrayList(p.r(list2, 10));
                Iterator iterator = list2.iterator();
                for (f0 next2 : iterator) {
                    arrayList.add(next2.o());
                }
                g0 g0Var = new g0(this.this$0.C0(), this.this$0.d());
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("package view scope for ");
                stringBuilder.append(this.this$0.d());
                stringBuilder.append(" in ");
                stringBuilder.append(this.this$0.C0().getName());
                bVar = b.d.a(stringBuilder.toString(), p.u0(arrayList, g0Var));
            }
            return bVar;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    static {
        l[] arr = new l[1];
        x xVar = new x(c0.b(r.class), "fragments", "getFragments()Ljava/util/List;");
        r.y = arr;
    }

    public r(kotlin.reflect.jvm.internal.impl.descriptors.j1.x x, b b2, n n3) {
        n.f(x, "module");
        n.f(b2, "fqName");
        n.f(n3, "storageManager");
        super(g.q.b(), b2.h());
        this.c = x;
        this.v = b2;
        r.a obj3 = new r.a(this);
        this.w = n3.d(obj3);
        r.b obj4 = new r.b(this);
        obj3 = new g(n3, obj4);
        this.x = obj3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public kotlin.reflect.jvm.internal.impl.descriptors.j1.x C0() {
        return this.c;
    }

    public List<f0> G() {
        return (List)m.a(this.w, this, r.y[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public k0 J() {
        int i;
        b bVar;
        String str;
        if (d().d()) {
            i = 0;
        } else {
            bVar = d().e();
            n.e(bVar, "fqName.parent()");
            i = C0().M(bVar);
        }
        return i;
    }

    public <R, D> R K(o<R, D> o, D d2) {
        n.f(o, "visitor");
        return o.c(this, d2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public m b() {
        return J();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public b d() {
        return this.v;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public boolean equals(Object object) {
        int i;
        boolean z;
        int obj4;
        if (object instanceof k0) {
        } else {
            obj4 = 0;
        }
        if (obj4 == null) {
            return 0;
        }
        if (n.b(d(), obj4.d()) && n.b(C0(), obj4.u0())) {
            if (n.b(C0(), obj4.u0())) {
                i = 1;
            }
        }
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public int hashCode() {
        return i2 += i4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public boolean isEmpty() {
        return k0.a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public h o() {
        return this.x;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public c0 u0() {
        return C0();
    }
}
