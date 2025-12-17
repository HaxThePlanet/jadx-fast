package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.l.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.b.a;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.i;
import kotlin.reflect.jvm.internal.impl.descriptors.l;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n;
import kotlin.reflect.jvm.internal.impl.descriptors.o;
import kotlin.reflect.jvm.internal.impl.descriptors.p;
import kotlin.reflect.jvm.internal.impl.descriptors.r0;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* loaded from: classes3.dex */
public class f extends kotlin.reflect.jvm.internal.impl.descriptors.j1.p implements d {

    private static final e W;
    protected final boolean V;
    static {
        f.W = e.n("<init>");
    }

    protected f(e e, l l2, g g3, boolean z4, b.a b$a5, u0 u06) {
        final int i = 0;
        if (e == null) {
        } else {
            if (g3 == null) {
            } else {
                if (a5 == null) {
                } else {
                    if (u06 == null) {
                    } else {
                        super(e, l2, g3, f.W, a5, u06);
                        this.V = z4;
                    }
                    f.E(3);
                    throw i;
                }
                f.E(2);
                throw i;
            }
            f.E(1);
            throw i;
        }
        f.E(0);
        throw i;
    }

    private static void E(int i) {
        String str;
        int i2;
        String str2;
        String str3;
        Object obj8;
        final int i3 = 25;
        final int i4 = 19;
        if (i != i4 && i != i3) {
            if (i != i3) {
                str = /* condition */ ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            } else {
            }
        } else {
        }
        final int i5 = 2;
        if (i != i4 && i != i3) {
            if (i != i3) {
                i2 = /* condition */ ? i5 : 3;
            } else {
            }
        } else {
        }
        Object[] arr = new Object[i2];
        str2 = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl";
        int i6 = 0;
        switch (i) {
            case 1:
                arr[i6] = "annotations";
                break;
            case 2:
                arr[i6] = "kind";
                break;
            case 3:
                arr[i6] = "source";
                break;
            case 4:
                arr[i6] = "containingDeclaration";
                break;
            case 5:
                arr[i6] = "unsubstitutedValueParameters";
                break;
            case 6:
                arr[i6] = "visibility";
                break;
            case 7:
                arr[i6] = "typeParameterDescriptors";
                break;
            case 8:
                arr[i6] = str2;
                break;
            case 9:
                arr[i6] = "originalSubstitutor";
                break;
            case 10:
                arr[i6] = "overriddenDescriptors";
                break;
            default:
                arr[i6] = "newOwner";
        }
        int i7 = 1;
        if (i != i4) {
            if (i != i3) {
                switch (i) {
                    case 15:
                        arr[i7] = "getContainingDeclaration";
                        break;
                    case 16:
                        arr[i7] = "getConstructedClass";
                        break;
                    case 17:
                        arr[i7] = "getOriginal";
                        break;
                    default:
                        arr[i7] = str2;
                }
            } else {
                arr[i7] = "copy";
            }
        } else {
            arr[i7] = "getOverriddenDescriptors";
        }
        switch (i) {
            case 4:
                arr[i5] = "create";
                break;
            case 5:
                arr[i5] = "createSynthesized";
                break;
            case 6:
                arr[i5] = "initialize";
                break;
            case 8:
                arr[i5] = "substitute";
                break;
            case 9:
                arr[i5] = "setOverriddenDescriptors";
                break;
            case 10:
                arr[i5] = "createSubstitutedCopy";
                break;
            default:
                arr[i5] = "<init>";
        }
        String format = String.format(str, arr);
        if (i != i4 && i != i3) {
            if (i != i3) {
                if (/* condition */) {
                    obj8 = new IllegalStateException(format);
                } else {
                    obj8 = new IllegalArgumentException(format);
                }
            } else {
            }
        } else {
        }
        throw obj8;
    }

    public static kotlin.reflect.jvm.internal.impl.descriptors.j1.f l1(e e, g g2, boolean z3, u0 u04) {
        int i = 0;
        if (e == null) {
        } else {
            if (g2 == null) {
            } else {
                if (u04 == null) {
                } else {
                    super(e, 0, g2, z3, b.a.DECLARATION, u04);
                    return fVar;
                }
                f.E(6);
                throw i;
            }
            f.E(5);
            throw i;
        }
        f.E(4);
        throw i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public p J() {
        return a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public x J0(m m, z z2, u u3, b.a b$a4, boolean z5) {
        return k1(m, z2, u3, a4, z5);
    }

    public <R, D> R K(o<R, D> o, D d2) {
        return o.h(this, d2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    protected kotlin.reflect.jvm.internal.impl.descriptors.j1.p K0(m m, x x2, b.a b$a3, e e4, g g5, u0 u06) {
        return m1(m, x2, a3, e4, g5, u06);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public a a() {
        return a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public b a() {
        return a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public d a() {
        x xVar = super.a();
        if ((d)xVar == null) {
        } else {
            return (d)xVar;
        }
        f.E(17);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public m a() {
        return a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public x a() {
        return a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public i b() {
        return n1();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public m b() {
        return n1();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public d c(a1 a1) {
        if (a1 == null) {
        } else {
            return (d)super.c(a1);
        }
        f.E(18);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public l c(a1 a1) {
        return c(a1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public n c(a1 a1) {
        return c(a1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public x c(a1 a1) {
        return c(a1);
    }

    public Collection<? extends x> e() {
        java.util.Set emptySet = Collections.emptySet();
        if (emptySet == null) {
        } else {
            return emptySet;
        }
        f.E(19);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public r0 j1() {
        m eVar;
        boolean z;
        eVar = n1();
        eVar = eVar.b();
        if (eVar.k() && eVar instanceof e) {
            eVar = eVar.b();
            if (eVar instanceof e) {
                return (e)eVar.I0();
            }
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public b k0(m m, z z2, u u3, b.a b$a4, boolean z5) {
        return k1(m, z2, u3, a4, z5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public d k1(m m, z z2, u u3, b.a b$a4, boolean z5) {
        x obj1 = super.J0(m, z2, u3, a4, z5);
        if ((d)obj1 == null) {
        } else {
            return (d)obj1;
        }
        f.E(25);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    protected kotlin.reflect.jvm.internal.impl.descriptors.j1.f m1(m m, x x2, b.a b$a3, e e4, g g5, u0 u06) {
        int obj9;
        obj9 = 0;
        if (m == null) {
        } else {
            if (a3 == null) {
            } else {
                if (g5 == null) {
                } else {
                    if (u06 == null) {
                    } else {
                        final b.a dECLARATION = b.a.DECLARATION;
                        if (a3 != dECLARATION) {
                            if (a3 != b.a.SYNTHESIZED) {
                            } else {
                            }
                            StringBuilder obj11 = new StringBuilder();
                            obj11.append("Attempt at creating a constructor that is not a declaration: \ncopy from: ");
                            obj11.append(this);
                            String obj12 = "\n";
                            obj11.append(obj12);
                            obj11.append("newOwner: ");
                            obj11.append(m);
                            obj11.append(obj12);
                            obj11.append("kind: ");
                            obj11.append(a3);
                            obj9 = new IllegalStateException(obj11.toString());
                            throw obj9;
                        }
                        super((e)m, this, g5, this.V, dECLARATION, u06);
                        return obj9;
                    }
                    f.E(24);
                    throw obj9;
                }
                f.E(23);
                throw obj9;
            }
            f.E(22);
            throw obj9;
        }
        f.E(21);
        throw obj9;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public e n1() {
        m mVar = super.b();
        if ((e)mVar == null) {
        } else {
            return (e)mVar;
        }
        f.E(15);
        throw 0;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.j1.f o1(List<c1> list, u u2) {
        int i = 0;
        if (list == null) {
        } else {
            if (u2 == null) {
            } else {
                p1(list, u2, n1().t());
                return this;
            }
            f.E(14);
            throw i;
        }
        f.E(13);
        throw i;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.j1.f p1(List<c1> list, u u2, List<z0> list3) {
        final int i = 0;
        if (list == null) {
        } else {
            if (u2 == null) {
            } else {
                if (list3 == null) {
                } else {
                    super.Q0(0, j1(), list3, list, 0, z.FINAL, u2);
                    return this;
                }
                f.E(12);
                throw i;
            }
            f.E(11);
            throw i;
        }
        f.E(10);
        throw i;
    }

    public void w0(Collection<? extends b> collection) {
        if (collection == null) {
        } else {
        }
        f.E(20);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public boolean y() {
        return this.V;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public e z() {
        e eVar = n1();
        if (eVar == null) {
        } else {
            return eVar;
        }
        f.E(16);
        throw 0;
    }
}
