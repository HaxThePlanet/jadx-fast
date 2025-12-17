package kotlin.i0.z.e;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.x;
import kotlin.i0.k;
import kotlin.i0.k.a;
import kotlin.i0.l;
import kotlin.i0.o;
import kotlin.i0.z.e.l0.d;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.b.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.n;

/* loaded from: classes3.dex */
public final class p implements k {

    static final l[] x;
    private final kotlin.i0.z.e.c0.a a;
    private final kotlin.i0.z.e.c0.a b;
    private final kotlin.i0.z.e.f<?> c;
    private final int v;
    private final k.a w;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000c\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0008\u0004\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\u0008\u0003\u0010\u0004", d2 = {"", "", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class a extends p implements a<List<? extends Annotation>> {

        final kotlin.i0.z.e.p this$0;
        a(kotlin.i0.z.e.p p) {
            this.this$0 = p;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        public final List<Annotation> invoke() {
            return j0.d(p.d(this.this$0));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\u0008\u0001\u0010\u0002", d2 = {"Ljava/lang/reflect/Type;", "a", "()Ljava/lang/reflect/Type;"}, k = 3, mv = {1, 4, 1})
    static final class b extends p implements a<Type> {

        final kotlin.i0.z.e.p this$0;
        b(kotlin.i0.z.e.p p) {
            this.this$0 = p;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final Type a() {
            Object l0Var;
            Object obj;
            boolean z;
            Object fAKE_OVERRIDE;
            l0Var = p.d(this.this$0);
            if (l0Var instanceof r0 && n.b(j0.g(this.this$0.j().y()), l0Var) && this.this$0.j().y().f() == b.a.FAKE_OVERRIDE) {
                if (n.b(j0.g(this.this$0.j().y()), l0Var)) {
                    if (this.this$0.j().y().f() == b.a.FAKE_OVERRIDE) {
                        kotlin.reflect.jvm.internal.impl.descriptors.m mVar = this.this$0.j().y().b();
                        Objects.requireNonNull(mVar, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                        if (j0.n((e)mVar) == null) {
                        } else {
                            return obj;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Cannot determine receiver Java type of inherited declaration: ");
                        stringBuilder.append(l0Var);
                        a0 a0Var = new a0(stringBuilder.toString());
                        throw a0Var;
                    }
                }
            }
            obj = l0Var;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    static {
        Class<kotlin.i0.z.e.p> obj = p.class;
        l[] arr = new l[2];
        x xVar = new x(c0.b(obj), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;");
        x xVar2 = new x(c0.b(obj), "annotations", "getAnnotations()Ljava/util/List;");
        p.x = arr;
    }

    public p(kotlin.i0.z.e.f<?> f, int i2, k.a k$a3, a<? extends l0> a4) {
        n.f(f, "callable");
        n.f(a3, "kind");
        n.f(a4, "computeDescriptor");
        super();
        this.c = f;
        this.v = i2;
        this.w = a3;
        this.a = c0.d(a4);
        p.a obj2 = new p.a(this);
        this.b = c0.d(obj2);
    }

    public static final l0 d(kotlin.i0.z.e.p p) {
        return p.l();
    }

    private final l0 l() {
        return (l0)this.a.b(this, p.x[0]);
    }

    @Override // kotlin.i0.k
    public boolean equals(Object object) {
        int index;
        kotlin.i0.z.e.f fVar;
        int obj3;
        if (object instanceof p && n.b(this.c, object.c) && getIndex() == (p)object.getIndex()) {
            if (n.b(this.c, object.c)) {
                obj3 = getIndex() == (p)object.getIndex() ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj3;
    }

    @Override // kotlin.i0.k
    public k.a f() {
        return this.w;
    }

    @Override // kotlin.i0.k
    public boolean g() {
        Object l0Var;
        int i;
        l0Var = l();
        if (l0Var instanceof c1 && (c1)l0Var.l0() != null) {
            i = (c1)l0Var.l0() != null ? 1 : 0;
        } else {
        }
        return i;
    }

    public List<Annotation> getAnnotations() {
        return (List)this.b.b(this, p.x[1]);
    }

    @Override // kotlin.i0.k
    public int getIndex() {
        return this.v;
    }

    @Override // kotlin.i0.k
    public String getName() {
        l0 name;
        boolean z;
        int i;
        i = 0;
        if (!name instanceof c1) {
            name = i;
        }
        if (name != null && (c1)name.b().D()) {
            if (name.b().D()) {
                return i;
            }
            name = name.getName();
            n.e(name, "valueParameter.name");
            if (name.k()) {
            } else {
                i = name.c();
            }
        }
        return i;
    }

    @Override // kotlin.i0.k
    public o getType() {
        kotlin.i0.z.e.m0.l.b0 type = l().getType();
        n.e(type, "descriptor.type");
        p.b bVar = new p.b(this);
        w wVar = new w(type, bVar);
        return wVar;
    }

    @Override // kotlin.i0.k
    public boolean h() {
        l0 l0Var;
        boolean z;
        if (!l0Var instanceof c1) {
            l0Var = 0;
        }
        if ((c1)l0Var != null) {
            z = a.a((c1)l0Var);
        } else {
            z = 0;
        }
        return z;
    }

    @Override // kotlin.i0.k
    public int hashCode() {
        return i2 += i4;
    }

    public final kotlin.i0.z.e.f<?> j() {
        return this.c;
    }

    @Override // kotlin.i0.k
    public String toString() {
        return f0.b.f(this);
    }
}
