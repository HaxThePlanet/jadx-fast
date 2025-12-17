package kotlin.i0.z.e;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.a;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.i0;
import kotlin.d0.d.i0.a;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.x;
import kotlin.i0.l;
import kotlin.i0.o;
import kotlin.i0.p;
import kotlin.i0.s;
import kotlin.i0.z.e.m0.d.b.i;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.j.b.d0.g;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.a.f;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.w;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class y implements p {

    static final l[] v;
    private final kotlin.i0.z.e.c0.a a;
    private final kotlin.i0.z.e.z b;
    private final z0 c;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000c\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\u0008\u0003\u0010\u0004", d2 = {"", "Lkotlin/i0/z/e/w;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class a extends p implements a<List<? extends kotlin.i0.z.e.w>> {

        final kotlin.i0.z.e.y this$0;
        a(kotlin.i0.z.e.y y) {
            this.this$0 = y;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        public final List<kotlin.i0.z.e.w> invoke() {
            int next;
            kotlin.i0.z.e.w wVar;
            int i;
            int i2;
            List upperBounds = this.this$0.b().getUpperBounds();
            n.e(upperBounds, "descriptor.upperBounds");
            ArrayList arrayList = new ArrayList(p.r(upperBounds, 10));
            Iterator iterator = upperBounds.iterator();
            for (b0 next : iterator) {
                i2 = 0;
                wVar = new w(next, i2, 2, i2);
                arrayList.add(wVar);
            }
            return arrayList;
        }
    }
    static {
        l[] arr = new l[1];
        x xVar = new x(c0.b(y.class), "upperBounds", "getUpperBounds()Ljava/util/List;");
        y.v = arr;
    }

    public y(kotlin.i0.z.e.z z, z0 z02) {
        Object aVar;
        boolean str;
        Object obj3;
        Object obj4;
        n.f(z02, "descriptor");
        super();
        this.c = z02;
        obj4 = new y.a(this);
        this.a = c0.d(obj4);
        if (z != null) {
            this.b = obj3;
        } else {
            obj3 = b().b();
            n.e(obj3, "descriptor.containingDeclaration");
            if (obj3 instanceof e) {
                obj3 = c((e)obj3);
                n.e(obj3, "when (val declaration = … $declaration\")\n        }");
            } else {
                if (!obj3 instanceof b) {
                } else {
                    obj4 = (b)obj3.b();
                    n.e(obj4, "declaration.containingDeclaration");
                    if (obj4 instanceof e) {
                        obj4 = c((e)obj4);
                        aVar = new a(obj4);
                        obj3 = obj3.K(aVar, w.a);
                    } else {
                        obj4 = !obj3 instanceof g ? 0 : obj3;
                        if ((g)obj4 == null) {
                        } else {
                            Objects.requireNonNull(a.e(a((g)obj4)), "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                        }
                    }
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Non-class callable descriptor must be deserialized: ");
                    stringBuilder2.append(obj3);
                    obj4 = new a0(stringBuilder2.toString());
                    throw obj4;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown type parameter container: ");
        stringBuilder.append(obj3);
        obj4 = new a0(stringBuilder.toString());
        throw obj4;
    }

    private final Class<?> a(g g) {
        kotlin.i0.z.e.m0.j.b.d0.f fVar;
        kotlin.i0.z.e.m0.d.b.o oVar;
        kotlin.i0.z.e.m0.d.b.o i;
        i = 0;
        if (!fVar instanceof i) {
            fVar = i;
        }
        if ((i)fVar != null) {
            oVar = (i)fVar.f();
        } else {
            oVar = i;
        }
        if (!oVar instanceof f) {
        } else {
            i = oVar;
        }
        if ((f)i == null) {
        } else {
            oVar = (f)i.d();
            if (oVar == null) {
            } else {
                return oVar;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Container of deserialized member is not resolved: ");
        stringBuilder.append(g);
        a0 a0Var = new a0(stringBuilder.toString());
        throw a0Var;
    }

    private final kotlin.i0.z.e.h<?> c(e e) {
        kotlin.i0.d dVar;
        Class cls = j0.n(e);
        if (cls != null) {
            dVar = a.e(cls);
        } else {
            dVar = 0;
        }
        if ((h)dVar == null) {
        } else {
            return (h)dVar;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Type parameter container is not resolved: ");
        stringBuilder.append(e.b());
        a0 a0Var = new a0(stringBuilder.toString());
        throw a0Var;
    }

    @Override // kotlin.i0.p
    public z0 b() {
        return this.c;
    }

    @Override // kotlin.i0.p
    public boolean equals(Object object) {
        String name;
        kotlin.i0.z.e.z zVar;
        int obj3;
        if (object instanceof y && n.b(this.b, object.b) && n.b(getName(), (y)object.getName())) {
            if (n.b(this.b, object.b)) {
                obj3 = n.b(getName(), (y)object.getName()) ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj3;
    }

    @Override // kotlin.i0.p
    public String getName() {
        String str = b().getName().c();
        n.e(str, "descriptor.name.asString()");
        return str;
    }

    public List<o> getUpperBounds() {
        return (List)this.a.b(this, y.v[0]);
    }

    @Override // kotlin.i0.p
    public int hashCode() {
        return i2 += i4;
    }

    @Override // kotlin.i0.p
    public s l() {
        s iNVARIANT;
        int i;
        int i2 = x.a[b().l().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                } else {
                    iNVARIANT = s.OUT;
                }
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
            }
            iNVARIANT = s.IN;
        } else {
            iNVARIANT = s.INVARIANT;
        }
        return iNVARIANT;
    }

    @Override // kotlin.i0.p
    public String toString() {
        return i0.a.a(this);
    }
}
