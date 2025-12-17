package kotlin.i0.z.e.m0.b.q;

import java.util.List;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.x;
import kotlin.i0.l;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.k.i;
import kotlin.i0.z.e.m0.k.m;
import kotlin.i0.z.e.m0.k.n;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.i1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.i1.b;
import kotlin.reflect.jvm.internal.impl.descriptors.i1.c;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class f extends h {

    static final l<Object>[] h;
    private a<kotlin.i0.z.e.m0.b.q.f.b> f;
    private final i g;

    public static enum a {

        FROM_DEPENDENCIES,
        FROM_CLASS_LOADER,
        FALLBACK;
    }

    public static final class b {

        private final c0 a;
        private final boolean b;
        public b(c0 c0, boolean z2) {
            n.f(c0, "ownerModuleDescriptor");
            super();
            this.a = c0;
            this.b = z2;
        }

        public final c0 a() {
            return this.a;
        }

        public final boolean b() {
            return this.b;
        }
    }

    public class c {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[f.a.FROM_DEPENDENCIES.ordinal()] = 1;
            iArr[f.a.FROM_CLASS_LOADER.ordinal()] = 2;
            iArr[f.a.FALLBACK.ordinal()] = 3;
            f.c.a = iArr;
        }
    }

    static final class d extends p implements a<kotlin.i0.z.e.m0.b.q.g> {

        final n $storageManager;
        final kotlin.i0.z.e.m0.b.q.f this$0;
        d(kotlin.i0.z.e.m0.b.q.f f, n n2) {
            this.this$0 = f;
            this.$storageManager = n2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final kotlin.i0.z.e.m0.b.q.g a() {
            kotlin.reflect.jvm.internal.impl.descriptors.j1.x xVar = this.this$0.r();
            n.e(xVar, "builtInsModule");
            f.d.a aVar = new f.d.a(this.this$0);
            g gVar = new g(xVar, this.$storageManager, aVar);
            return gVar;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    static final class e extends p implements a<kotlin.i0.z.e.m0.b.q.f.b> {

        final boolean $isAdditionalBuiltInsFeatureSupported;
        final c0 $moduleDescriptor;
        e(c0 c0, boolean z2) {
            this.$moduleDescriptor = c0;
            this.$isAdditionalBuiltInsFeatureSupported = z2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final kotlin.i0.z.e.m0.b.q.f.b a() {
            f.b bVar = new f.b(this.$moduleDescriptor, this.$isAdditionalBuiltInsFeatureSupported);
            return bVar;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    static {
        l[] arr = new l[1];
        x xVar = new x(c0.b(f.class), "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;");
        f.h = arr;
    }

    public f(n n, kotlin.i0.z.e.m0.b.q.f.a f$a2) {
        int obj2;
        int obj3;
        n.f(n, "storageManager");
        n.f(a2, "kind");
        super(n);
        f.d dVar = new f.d(this, n);
        this.g = n.d(dVar);
        obj2 = f.c.a[a2.ordinal()];
        if (obj2 != 2) {
            if (obj2 != 3) {
            } else {
                f(true);
            }
        } else {
            f(false);
        }
    }

    public static final a M0(kotlin.i0.z.e.m0.b.q.f f) {
        return f.f;
    }

    public static final void N0(kotlin.i0.z.e.m0.b.q.f f, a a2) {
        f.f = a2;
    }

    @Override // kotlin.i0.z.e.m0.b.h
    protected c M() {
        return P0();
    }

    protected List<b> O0() {
        Iterable iterable = super.v();
        n.e(iterable, "super.getClassDescriptorFactories()");
        final n nVar = T();
        n.e(nVar, "storageManager");
        final kotlin.reflect.jvm.internal.impl.descriptors.j1.x xVar = r();
        n.e(xVar, "builtInsModule");
        super(nVar, xVar, 0, 4, 0);
        return p.s0(iterable, eVar);
    }

    @Override // kotlin.i0.z.e.m0.b.h
    public final kotlin.i0.z.e.m0.b.q.g P0() {
        return (g)m.a(this.g, this, f.h[0]);
    }

    @Override // kotlin.i0.z.e.m0.b.h
    public final void Q0(c0 c0, boolean z2) {
        n.f(c0, "moduleDescriptor");
        f.e eVar = new f.e(c0, z2);
        R0(eVar);
    }

    public final void R0(a<kotlin.i0.z.e.m0.b.q.f.b> a) {
        n.f(a, "computation");
        a aVar = this.f;
        this.f = a;
    }

    @Override // kotlin.i0.z.e.m0.b.h
    protected a g() {
        return P0();
    }

    @Override // kotlin.i0.z.e.m0.b.h
    protected Iterable v() {
        return O0();
    }
}
