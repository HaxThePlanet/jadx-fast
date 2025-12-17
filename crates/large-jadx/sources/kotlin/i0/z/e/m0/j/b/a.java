package kotlin.i0.z.e.m0.j.b;

import java.util.Collection;
import java.util.List;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.k.h;
import kotlin.i0.z.e.m0.k.n;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.j0;
import kotlin.reflect.jvm.internal.impl.utils.a;
import kotlin.y.p;
import kotlin.y.q0;

/* loaded from: classes3.dex */
public abstract class a implements j0 {

    private final n a;
    private final kotlin.i0.z.e.m0.j.b.s b;
    private final c0 c;
    protected kotlin.i0.z.e.m0.j.b.j d;
    private final h<b, f0> e;

    static final class a extends p implements l<b, f0> {

        final kotlin.i0.z.e.m0.j.b.a this$0;
        a(kotlin.i0.z.e.m0.j.b.a a) {
            this.this$0 = a;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final f0 a(b b) {
            Object this$0;
            int obj2;
            n.f(b, "fqName");
            obj2 = this.this$0.c(b);
            if (obj2 == null) {
                obj2 = 0;
            } else {
                obj2.K0(this.this$0.d());
            }
            return obj2;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((b)object);
        }
    }
    public a(n n, kotlin.i0.z.e.m0.j.b.s s2, c0 c03) {
        n.f(n, "storageManager");
        n.f(s2, "finder");
        n.f(c03, "moduleDescriptor");
        super();
        this.a = n;
        this.b = s2;
        this.c = c03;
        a.a obj3 = new a.a(this);
        this.e = n.i(obj3);
    }

    public List<f0> a(b b) {
        n.f(b, "fqName");
        return p.k(this.e.invoke(b));
    }

    public void b(b b, Collection<f0> collection2) {
        n.f(b, "fqName");
        n.f(collection2, "packageFragments");
        a.a(collection2, this.e.invoke(b));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j0
    protected abstract kotlin.i0.z.e.m0.j.b.n c(b b);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j0
    protected final kotlin.i0.z.e.m0.j.b.j d() {
        kotlin.i0.z.e.m0.j.b.j jVar = this.d;
        if (jVar == null) {
        } else {
            return jVar;
        }
        n.w("components");
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j0
    protected final kotlin.i0.z.e.m0.j.b.s e() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j0
    protected final c0 f() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j0
    protected final n g() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j0
    protected final void h(kotlin.i0.z.e.m0.j.b.j j) {
        n.f(j, "<set-?>");
        this.d = j;
    }

    public Collection<b> n(b b, l<? super e, Boolean> l2) {
        n.f(b, "fqName");
        n.f(l2, "nameFilter");
        return q0.b();
    }
}
