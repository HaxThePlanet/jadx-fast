package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import java.util.Collection;
import java.util.Collections;
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
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* loaded from: classes3.dex */
public class h extends kotlin.reflect.jvm.internal.impl.descriptors.j1.g {

    private final z A;
    private final f B;
    private final t0 C;
    private h D;
    private Set<d> E;
    private d F;
    static {
    }

    public h(m m, e e2, z z3, f f4, Collection<b0> collection5, u0 u06, boolean z7, n n8) {
        int i = 0;
        if (m == null) {
        } else {
            if (e2 == null) {
            } else {
                if (z3 == null) {
                } else {
                    if (f4 == null) {
                    } else {
                        if (collection5 == null) {
                        } else {
                            if (u06 == null) {
                            } else {
                                if (n8 == null) {
                                } else {
                                    super(n8, m, e2, u06, z7);
                                    this.A = z3;
                                    this.B = f4;
                                    i obj7 = new i(this, Collections.emptyList(), collection5, n8);
                                    this.C = obj7;
                                }
                                h.J(6);
                                throw i;
                            }
                            h.J(5);
                            throw i;
                        }
                        h.J(4);
                        throw i;
                    }
                    h.J(3);
                    throw i;
                }
                h.J(2);
                throw i;
            }
            h.J(1);
            throw i;
        }
        h.J(0);
        throw i;
    }

    private static void J(int i) {
        String str;
        int i2;
        String str2;
        String str3;
        Object obj6;
        str = /* condition */ ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        i2 = /* condition */ ? i3 : 3;
        Object[] arr = new Object[i2];
        str2 = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
        int i4 = 0;
        switch (i) {
            case 1:
                arr[i4] = "name";
                break;
            case 2:
                arr[i4] = "modality";
                break;
            case 3:
                arr[i4] = "kind";
                break;
            case 4:
                arr[i4] = "supertypes";
                break;
            case 5:
                arr[i4] = "source";
                break;
            case 6:
                arr[i4] = "storageManager";
                break;
            case 7:
                arr[i4] = "unsubstitutedMemberScope";
                break;
            case 8:
                arr[i4] = "constructors";
                break;
            case 9:
                arr[i4] = str2;
                break;
            case 10:
                arr[i4] = "kotlinTypeRefiner";
                break;
            default:
                arr[i4] = "containingDeclaration";
        }
        String str4 = "getUnsubstitutedMemberScope";
        int i5 = 1;
        switch (i) {
            case 9:
                arr[i5] = "getAnnotations";
                break;
            case 10:
                arr[i5] = "getTypeConstructor";
                break;
            case 11:
                arr[i5] = "getConstructors";
                break;
            case 12:
                arr[i5] = str2;
                break;
            case 13:
                arr[i5] = str4;
                break;
            case 14:
                arr[i5] = "getStaticScope";
                break;
            case 15:
                arr[i5] = "getKind";
                break;
            case 16:
                arr[i5] = "getModality";
                break;
            case 17:
                arr[i5] = "getVisibility";
                break;
            case 18:
                arr[i5] = "getDeclaredTypeParameters";
                break;
            default:
                arr[i5] = "getSealedSubclasses";
        }
        switch (i) {
            case 7:
                arr[i3] = "initialize";
                break;
            case 9:
                arr[i3] = str4;
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
            h obj2 = this.D;
            if (obj2 == null) {
            } else {
                return obj2;
            }
            h.J(13);
            throw i;
        }
        h.J(12);
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
        h.J(19);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public boolean I() {
        return 0;
    }

    public final void J0(h h, Set<d> set2, d d3) {
        final int i = 0;
        if (h == null) {
        } else {
            if (set2 == null) {
            } else {
                this.D = h;
                this.E = set2;
                this.F = d3;
            }
            h.J(8);
            throw i;
        }
        h.J(7);
        throw i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public boolean L() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public d Q() {
        return this.F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public h R() {
        h.b bVar = h.b.b;
        if (bVar == null) {
        } else {
            return bVar;
        }
        h.J(14);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public e T() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public f f() {
        f fVar = this.B;
        if (fVar == null) {
        } else {
            return fVar;
        }
        h.J(15);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public t0 g() {
        t0 t0Var = this.C;
        if (t0Var == null) {
        } else {
            return t0Var;
        }
        h.J(10);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public g getAnnotations() {
        g gVar = g.q.b();
        if (gVar == null) {
        } else {
            return gVar;
        }
        h.J(9);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public u getVisibility() {
        u uVar = t.e;
        if (uVar == null) {
        } else {
            return uVar;
        }
        h.J(17);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public z i() {
        z zVar = this.A;
        if (zVar == null) {
        } else {
            return zVar;
        }
        h.J(16);
        throw 0;
    }

    public Collection<d> j() {
        Set set = this.E;
        if (set == null) {
        } else {
            return set;
        }
        h.J(11);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public boolean k() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public boolean r() {
        return 0;
    }

    public List<z0> t() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
        } else {
            return emptyList;
        }
        h.J(18);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("class ");
        stringBuilder.append(getName());
        return stringBuilder.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public boolean x() {
        return 0;
    }
}
