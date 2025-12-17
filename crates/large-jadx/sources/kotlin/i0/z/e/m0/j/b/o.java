package kotlin.i0.z.e.m0.j.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.e.m;
import kotlin.i0.z.e.m0.e.z.a;
import kotlin.i0.z.e.m0.e.z.d;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.j.b.d0.f;
import kotlin.i0.z.e.m0.j.b.d0.i;
import kotlin.i0.z.e.m0.k.n;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public abstract class o extends kotlin.i0.z.e.m0.j.b.n {

    private final d A;
    private final kotlin.i0.z.e.m0.j.b.w B;
    private m C;
    private h D;
    private final a y;
    private final f z;

    static final class a extends p implements l<a, u0> {

        final kotlin.i0.z.e.m0.j.b.o this$0;
        a(kotlin.i0.z.e.m0.j.b.o o) {
            this.this$0 = o;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final u0 a(a a) {
            String str;
            u0 obj2;
            n.f(a, "it");
            if (o.L0(this.this$0) == null) {
                n.e(u0.a, "NO_SOURCE");
            }
            return obj2;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((a)object);
        }
    }

    static final class b extends p implements a<Collection<? extends e>> {

        final kotlin.i0.z.e.m0.j.b.o this$0;
        b(kotlin.i0.z.e.m0.j.b.o o) {
            this.this$0 = o;
            super(0);
        }

        public final Collection<e> a() {
            Object next;
            int i;
            int i2;
            Object contains;
            Set set;
            ArrayList arrayList2 = new ArrayList();
            Iterator iterator = this.this$0.M0().b().iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                contains = next;
                if (!(a)contains.l() && !h.c.a().contains(contains)) {
                } else {
                }
                i2 = 0;
                if (i2 != 0) {
                }
                arrayList2.add(next);
                if (!h.c.a().contains(contains)) {
                } else {
                }
                i2 = 1;
            }
            ArrayList arrayList = new ArrayList(p.r(arrayList2, 10));
            Iterator iterator2 = arrayList2.iterator();
            for (a next4 : iterator2) {
                arrayList.add(next4.j());
            }
            return arrayList;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    public o(b b, n n2, c0 c03, m m4, a a5, f f6) {
        n.f(b, "fqName");
        n.f(n2, "storageManager");
        n.f(c03, "module");
        n.f(m4, "proto");
        n.f(a5, "metadataVersion");
        super(b, n2, c03);
        this.y = a5;
        this.z = f6;
        kotlin.i0.z.e.m0.e.p obj3 = m4.I();
        n.e(obj3, "proto.strings");
        kotlin.i0.z.e.m0.e.o obj4 = m4.H();
        n.e(obj4, "proto.qualifiedNames");
        d obj2 = new d(obj3, obj4);
        this.A = obj2;
        obj4 = new o.a(this);
        obj3 = new w(m4, obj2, a5, obj4);
        this.B = obj3;
        this.C = m4;
    }

    public static final f L0(kotlin.i0.z.e.m0.j.b.o o) {
        return o.z;
    }

    @Override // kotlin.i0.z.e.m0.j.b.n
    public kotlin.i0.z.e.m0.j.b.g C0() {
        return M0();
    }

    @Override // kotlin.i0.z.e.m0.j.b.n
    public void K0(kotlin.i0.z.e.m0.j.b.j j) {
        n.f(j, "components");
        m mVar = this.C;
        if (mVar == null) {
        } else {
            this.C = 0;
            final kotlin.i0.z.e.m0.e.l lVar = mVar.G();
            n.e(lVar, "proto.`package`");
            o.b bVar = new o.b(this);
            super(this, lVar, this.A, this.y, this.z, j, bVar);
            this.D = iVar;
        }
        IllegalStateException obj11 = new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString());
        throw obj11;
    }

    @Override // kotlin.i0.z.e.m0.j.b.n
    public kotlin.i0.z.e.m0.j.b.w M0() {
        return this.B;
    }

    @Override // kotlin.i0.z.e.m0.j.b.n
    public h o() {
        h hVar = this.D;
        if (hVar == null) {
        } else {
            return hVar;
        }
        n.w("_memberScope");
        throw 0;
    }
}
