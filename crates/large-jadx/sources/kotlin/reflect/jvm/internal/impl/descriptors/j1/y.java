package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.i.v.h.b;
import kotlin.i0.z.e.m0.k.n;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.i;
import kotlin.i0.z.e.m0.l.j1.g;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* loaded from: classes3.dex */
public class y extends kotlin.reflect.jvm.internal.impl.descriptors.j1.g {

    private final f A;
    private final boolean B;
    private z C;
    private u D;
    private t0 E;
    private List<z0> F;
    private final Collection<b0> G;
    private final n H;
    static {
    }

    public y(m m, f f2, boolean z3, boolean z4, e e5, u0 u06, n n7) {
        int i = 0;
        if (m == null) {
        } else {
            if (f2 == null) {
            } else {
                if (e5 == null) {
                } else {
                    if (u06 == null) {
                    } else {
                        if (n7 == null) {
                        } else {
                            super(n7, m, e5, u06, z4);
                            ArrayList obj7 = new ArrayList();
                            this.G = obj7;
                            this.H = n7;
                            this.A = f2;
                            this.B = z3;
                        }
                        y.J(4);
                        throw i;
                    }
                    y.J(3);
                    throw i;
                }
                y.J(2);
                throw i;
            }
            y.J(1);
            throw i;
        }
        y.J(0);
        throw i;
    }

    private static void J(int i) {
        String str;
        int i2;
        String str3;
        String str4;
        Object obj6;
        str = /* condition */ ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        i2 = /* condition */ ? i3 : 3;
        Object[] arr = new Object[i2];
        str3 = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
        int i4 = 0;
        switch (i) {
            case 1:
                arr[i4] = "kind";
                break;
            case 2:
                arr[i4] = "name";
                break;
            case 3:
                arr[i4] = "source";
                break;
            case 4:
                arr[i4] = "storageManager";
                break;
            case 5:
                arr[i4] = str3;
                break;
            case 6:
                arr[i4] = "modality";
                break;
            case 7:
                arr[i4] = "visibility";
                break;
            case 8:
                arr[i4] = "supertype";
                break;
            case 9:
                arr[i4] = "typeParameters";
                break;
            case 10:
                arr[i4] = "kotlinTypeRefiner";
                break;
            default:
                arr[i4] = "containingDeclaration";
        }
        String str5 = "getUnsubstitutedMemberScope";
        int i5 = 1;
        switch (i) {
            case 5:
                arr[i5] = "getAnnotations";
                break;
            case 6:
                arr[i5] = str3;
                break;
            case 7:
                arr[i5] = "getModality";
                break;
            case 8:
                arr[i5] = "getKind";
                break;
            case 9:
                arr[i5] = "getVisibility";
                break;
            case 10:
                arr[i5] = "getTypeConstructor";
                break;
            case 11:
                arr[i5] = "getConstructors";
                break;
            case 12:
                arr[i5] = "getDeclaredTypeParameters";
                break;
            case 13:
                arr[i5] = str5;
                break;
            case 14:
                arr[i5] = "getStaticScope";
                break;
            default:
                arr[i5] = "getSealedSubclasses";
        }
        switch (i) {
            case 6:
                arr[i3] = "setModality";
                break;
            case 7:
                arr[i3] = "setVisibility";
                break;
            case 8:
                arr[i3] = "addSupertype";
                break;
            case 9:
                arr[i3] = "setTypeParameterDescriptors";
                break;
            case 10:
                arr[i3] = str5;
                break;
            default:
                arr[i3] = "<init>";
        }
        if (/* condition */) {
            obj6 = new IllegalStateException(format);
        } else {
            obj6 = new IllegalArgumentException(format);
        }
        throw obj6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public boolean A() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public boolean B0() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public h F(g g) {
        final int i = 0;
        if (g == null) {
        } else {
            h.b obj2 = h.b.b;
            if (obj2 == null) {
            } else {
                return obj2;
            }
            y.J(17);
            throw i;
        }
        y.J(16);
        throw i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public boolean G0() {
        return 0;
    }

    public Collection<e> H() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
        } else {
            return emptyList;
        }
        y.J(19);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public boolean I() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public void J0() {
        List next;
        Collection collection;
        i iVar = new i(this, this.F, this.G, this.H);
        this.E = iVar;
        Iterator iterator = K0().iterator();
        for (d next : iterator) {
            (f)next.f1(q());
        }
    }

    public Set<d> K0() {
        Set emptySet = Collections.emptySet();
        if (emptySet == null) {
        } else {
            return emptySet;
        }
        y.J(13);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public boolean L() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public void L0(z z) {
        if (z == null) {
        } else {
            this.C = z;
        }
        y.J(6);
        throw 0;
    }

    public void M0(List<z0> list) {
        if (list == null) {
        } else {
            if (this.F != null) {
            } else {
                ArrayList arrayList = new ArrayList(list);
                this.F = arrayList;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Type parameters are already set for ");
            stringBuilder.append(getName());
            IllegalStateException obj3 = new IllegalStateException(stringBuilder.toString());
            throw obj3;
        }
        y.J(14);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public void N0(u u) {
        if (u == null) {
        } else {
            this.D = u;
        }
        y.J(9);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public d Q() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public h R() {
        h.b bVar = h.b.b;
        if (bVar == null) {
        } else {
            return bVar;
        }
        y.J(18);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public e T() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public f f() {
        f fVar = this.A;
        if (fVar == null) {
        } else {
            return fVar;
        }
        y.J(8);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public t0 g() {
        t0 t0Var = this.E;
        if (t0Var == null) {
        } else {
            return t0Var;
        }
        y.J(11);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public g getAnnotations() {
        g gVar = g.q.b();
        if (gVar == null) {
        } else {
            return gVar;
        }
        y.J(5);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public u getVisibility() {
        u uVar = this.D;
        if (uVar == null) {
        } else {
            return uVar;
        }
        y.J(10);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public z i() {
        z zVar = this.C;
        if (zVar == null) {
        } else {
            return zVar;
        }
        y.J(7);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public Collection j() {
        return K0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public boolean k() {
        return this.B;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public boolean r() {
        return 0;
    }

    public List<z0> t() {
        List list = this.F;
        if (list == null) {
        } else {
            return list;
        }
        y.J(15);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public String toString() {
        return j.F(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public boolean x() {
        return 0;
    }
}
