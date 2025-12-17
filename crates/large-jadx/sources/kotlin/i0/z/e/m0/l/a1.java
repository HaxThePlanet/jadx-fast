package kotlin.i0.z.e.m0.l;

import java.util.ArrayList;
import java.util.List;
import kotlin.d0.c.l;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.b.k.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.i.p.a.d;
import kotlin.i0.z.e.m0.l.j1.j;
import kotlin.i0.z.e.m0.l.m1.a;
import kotlin.i0.z.e.m0.l.n1.b;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.k;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.l;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.utils.c;

/* loaded from: classes3.dex */
public class a1 {

    public static final kotlin.i0.z.e.m0.l.a1 b;
    private final kotlin.i0.z.e.m0.l.y0 a;

    static class b {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            a1.b.a = iArr;
            iArr[a1.d.OUT_IN_IN_POSITION.ordinal()] = 1;
            a1.b.a[a1.d.IN_IN_OUT_POSITION.ordinal()] = 2;
            a1.b.a[a1.d.NO_CONFLICT.ordinal()] = 3;
        }
    }

    private static final class c extends Exception {
        public c(String string) {
            super(string);
        }
    }

    private static enum d {

        NO_CONFLICT,
        IN_IN_OUT_POSITION,
        OUT_IN_IN_POSITION;
    }

    static class a implements l<b, Boolean> {
        private static void a(int i) {
            Object[] obj2 = new Object[3];
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1", "invoke"));
            throw illegalArgumentException;
        }

        @Override // kotlin.d0.c.l
        public Boolean b(b b) {
            if (b == null) {
            } else {
                return Boolean.valueOf(obj2 ^= 1);
            }
            a1.a.a(0);
            throw 0;
        }

        @Override // kotlin.d0.c.l
        public Object invoke(Object object) {
            return b((b)object);
        }
    }
    static {
        a1.b = a1.g(y0.a);
    }

    protected a1(kotlin.i0.z.e.m0.l.y0 y0) {
        if (y0 == null) {
        } else {
            super();
            this.a = y0;
        }
        a1.a(6);
        throw 0;
    }

    private static void a(int i) {
        String str;
        int i2;
        String str3;
        String str2;
        Object obj13;
        final int i3 = 35;
        final int i4 = 32;
        final int i5 = 7;
        final int i6 = 1;
        if (i != i6 && i != i5 && i != i4 && i != i3) {
            if (i != i5) {
                if (i != i4) {
                    if (i != i3) {
                        if (/* condition */) {
                            str = "@NotNull method %s.%s must not return null";
                        } else {
                            if (/* condition */) {
                            } else {
                                if (/* condition */) {
                                } else {
                                    if (/* condition */) {
                                    } else {
                                        str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                                    }
                                }
                            }
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        final int i7 = 2;
        if (i != i6 && i != i5 && i != i4 && i != i3) {
            if (i != i5) {
                if (i != i4) {
                    if (i != i3) {
                        if (/* condition */) {
                            i2 = i7;
                        } else {
                            if (/* condition */) {
                            } else {
                                if (/* condition */) {
                                } else {
                                    if (/* condition */) {
                                    } else {
                                        i2 = 3;
                                    }
                                }
                            }
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        Object[] arr = new Object[i2];
        str3 = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
        int i8 = 0;
        switch (i) {
            case 1:
                arr[i8] = str3;
                break;
            case 2:
                arr[i8] = "first";
                break;
            case 3:
                arr[i8] = "second";
                break;
            case 4:
                arr[i8] = "substitutionContext";
                break;
            case 5:
                arr[i8] = "context";
                break;
            case 6:
                arr[i8] = "substitution";
                break;
            case 7:
                arr[i8] = "type";
                break;
            case 8:
                arr[i8] = "howThisTypeIsUsed";
                break;
            case 9:
                arr[i8] = "typeProjection";
                break;
            case 10:
                arr[i8] = "originalProjection";
                break;
            case 11:
                arr[i8] = "originalType";
                break;
            case 12:
                arr[i8] = "substituted";
                break;
            case 13:
                arr[i8] = "annotations";
                break;
            case 14:
                arr[i8] = "typeParameterVariance";
                break;
            default:
                arr[i8] = "projectionKind";
        }
        String str4 = "combine";
        String str5 = "filterOutUnsafeVariance";
        final String str6 = "projectedTypeForConflictedTypeWithUnsafeVariance";
        final String str7 = "unsafeSubstitute";
        final String str8 = "safeSubstitute";
        if (i != i6) {
            if (i != i5) {
                if (i != i4) {
                    if (i != i3) {
                        if (/* condition */) {
                            arr[i6] = str8;
                        } else {
                            if (/* condition */) {
                                arr[i6] = str7;
                            } else {
                                if (/* condition */) {
                                    arr[i6] = str6;
                                } else {
                                    if (/* condition */) {
                                        arr[i6] = str4;
                                    } else {
                                        arr[i6] = str3;
                                    }
                                }
                            }
                        }
                    } else {
                    }
                } else {
                    arr[i6] = str5;
                }
            } else {
                arr[i6] = "getSubstitution";
            }
        } else {
            arr[i6] = "replaceWithNonApproximatingSubstitution";
        }
        switch (i) {
            case 2:
                arr[i7] = "createChainedSubstitutor";
                break;
            case 3:
                arr[i7] = "create";
                break;
            case 4:
                arr[i7] = "<init>";
                break;
            case 5:
                arr[i7] = str8;
                break;
            case 6:
                arr[i7] = "substitute";
                break;
            case 7:
                arr[i7] = "substituteWithoutApproximation";
                break;
            case 8:
                arr[i7] = str7;
                break;
            case 9:
                arr[i7] = str6;
                break;
            case 10:
                arr[i7] = str5;
                break;
            default:
                arr[i7] = str4;
        }
        String format = String.format(str, arr);
        if (i != i6 && i != i5 && i != i4 && i != i3) {
            if (i != i5) {
                if (i != i4) {
                    if (i != i3) {
                        if (/* condition */) {
                            obj13 = new IllegalStateException(format);
                        } else {
                            if (/* condition */) {
                            } else {
                                if (/* condition */) {
                                } else {
                                    if (/* condition */) {
                                    } else {
                                        obj13 = new IllegalArgumentException(format);
                                    }
                                }
                            }
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        throw obj13;
    }

    private static void b(int i, kotlin.i0.z.e.m0.l.v0 v02, kotlin.i0.z.e.m0.l.y0 y03) {
        if (i > 100) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Recursion too deep. Most likely infinite loop while substituting ");
        stringBuilder.append(a1.o(v02));
        stringBuilder.append("; substitution: ");
        stringBuilder.append(a1.o(y03));
        IllegalStateException obj2 = new IllegalStateException(stringBuilder.toString());
        throw obj2;
    }

    public static kotlin.i0.z.e.m0.l.h1 c(kotlin.i0.z.e.m0.l.h1 h1, kotlin.i0.z.e.m0.l.v0 v02) {
        final int i = 0;
        if (h1 == null) {
        } else {
            if (v02 == null) {
            } else {
                if (v02.c()) {
                    kotlin.i0.z.e.m0.l.h1 obj2 = h1.OUT_VARIANCE;
                    if (obj2 == null) {
                    } else {
                        return obj2;
                    }
                    a1.a(35);
                    throw i;
                }
                return a1.d(h1, v02.a());
            }
            a1.a(34);
            throw i;
        }
        a1.a(33);
        throw i;
    }

    public static kotlin.i0.z.e.m0.l.h1 d(kotlin.i0.z.e.m0.l.h1 h1, kotlin.i0.z.e.m0.l.h1 h12) {
        int i = 0;
        if (h1 == null) {
        } else {
            if (h12 == null) {
            } else {
                kotlin.i0.z.e.m0.l.h1 iNVARIANT = h1.INVARIANT;
                if (h1 == iNVARIANT) {
                    if (h12 == null) {
                    } else {
                        return h12;
                    }
                    a1.a(38);
                    throw i;
                }
                if (h12 == iNVARIANT) {
                    if (h1 == null) {
                    } else {
                        return h1;
                    }
                    a1.a(39);
                    throw i;
                }
                if (h1 != h12) {
                } else {
                    if (h12 == null) {
                    } else {
                        return h12;
                    }
                    a1.a(40);
                    throw i;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Variance conflict: type parameter variance '");
                stringBuilder.append(h1);
                stringBuilder.append("' and ");
                stringBuilder.append("projection kind '");
                stringBuilder.append(h12);
                stringBuilder.append("' cannot be combined");
                AssertionError assertionError = new AssertionError(stringBuilder.toString());
                throw assertionError;
            }
            a1.a(37);
            throw i;
        }
        a1.a(36);
        throw i;
    }

    private static kotlin.i0.z.e.m0.l.a1.d e(kotlin.i0.z.e.m0.l.h1 h1, kotlin.i0.z.e.m0.l.h1 h12) {
        kotlin.i0.z.e.m0.l.h1 oUT_VARIANCE;
        final kotlin.i0.z.e.m0.l.h1 iN_VARIANCE = h1.IN_VARIANCE;
        if (h1 == iN_VARIANCE && h12 == h1.OUT_VARIANCE) {
            if (h12 == h1.OUT_VARIANCE) {
                return a1.d.OUT_IN_IN_POSITION;
            }
        }
        if (h1 == h1.OUT_VARIANCE && h12 == iN_VARIANCE) {
            if (h12 == iN_VARIANCE) {
                return a1.d.IN_IN_OUT_POSITION;
            }
        }
        return a1.d.NO_CONFLICT;
    }

    public static kotlin.i0.z.e.m0.l.a1 f(kotlin.i0.z.e.m0.l.b0 b0) {
        if (b0 == null) {
        } else {
            return a1.g(u0.h(b0.L0(), b0.K0()));
        }
        a1.a(5);
        throw 0;
    }

    public static kotlin.i0.z.e.m0.l.a1 g(kotlin.i0.z.e.m0.l.y0 y0) {
        if (y0 == null) {
        } else {
            a1 a1Var = new a1(y0);
            return a1Var;
        }
        a1.a(0);
        throw 0;
    }

    public static kotlin.i0.z.e.m0.l.a1 h(kotlin.i0.z.e.m0.l.y0 y0, kotlin.i0.z.e.m0.l.y0 y02) {
        final int i = 0;
        if (y0 == null) {
        } else {
            if (y02 == null) {
            } else {
                return a1.g(p.h(y0, y02));
            }
            a1.a(3);
            throw i;
        }
        a1.a(2);
        throw i;
    }

    private static g i(g g) {
        int i = 0;
        if (g == null) {
        } else {
            if (!g.u1(k.a.G)) {
                if (g == null) {
                } else {
                    return g;
                }
                a1.a(32);
                throw i;
            }
            a1.a aVar = new a1.a();
            l lVar = new l(g, aVar);
            return lVar;
        }
        a1.a(31);
        throw i;
    }

    private static kotlin.i0.z.e.m0.l.v0 l(kotlin.i0.z.e.m0.l.b0 b0, kotlin.i0.z.e.m0.l.v0 v02, z0 z03, kotlin.i0.z.e.m0.l.v0 v04) {
        final int i = 0;
        if (b0 == null) {
        } else {
            if (v02 == null) {
            } else {
                if (v04 == null) {
                } else {
                    if (!b0.getAnnotations().u1(k.a.G)) {
                        if (v02 == null) {
                        } else {
                            return v02;
                        }
                        a1.a(27);
                        throw i;
                    }
                    kotlin.i0.z.e.m0.l.t0 obj3 = v02.getType().L0();
                    if (!obj3 instanceof j) {
                        if (v02 == null) {
                        } else {
                            return v02;
                        }
                        a1.a(28);
                        throw i;
                    }
                    obj3 = (j)obj3.e();
                    kotlin.i0.z.e.m0.l.h1 h1Var = obj3.a();
                    final kotlin.i0.z.e.m0.l.a1.d oUT_IN_IN_POSITION = a1.d.OUT_IN_IN_POSITION;
                    if (a1.e(v04.a(), h1Var) == oUT_IN_IN_POSITION) {
                        x0 obj4 = new x0(obj3.getType());
                        return obj4;
                    }
                    if (z03 == null) {
                        if (v02 == null) {
                        } else {
                            return v02;
                        }
                        a1.a(29);
                        throw i;
                    }
                    if (a1.e(z03.l(), h1Var) == oUT_IN_IN_POSITION) {
                        obj4 = new x0(obj3.getType());
                        return obj4;
                    }
                    if (v02 == null) {
                    } else {
                        return v02;
                    }
                    a1.a(30);
                    throw i;
                }
                a1.a(26);
                throw i;
            }
            a1.a(25);
            throw i;
        }
        a1.a(24);
        throw i;
    }

    private static String o(Object object) {
        try {
            return object.toString();
            boolean stringBuilder = c.a(object);
            if (stringBuilder != null) {
            } else {
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("[Exception while computing toString(): ");
            stringBuilder.append(object);
            object = "]";
            stringBuilder.append(object);
            object = stringBuilder.toString();
            return object;
            throw (RuntimeException)object;
        }
    }

    private kotlin.i0.z.e.m0.l.v0 r(kotlin.i0.z.e.m0.l.v0 v0, int i2) {
        boolean z;
        kotlin.i0.z.e.m0.l.h1 iNVARIANT;
        int obj5;
        kotlin.i0.z.e.m0.l.b0 obj6;
        kotlin.i0.z.e.m0.l.b0 type = v0.getType();
        if (hVar instanceof z0) {
            return v0;
        }
        obj5 = 0;
        kotlin.i0.z.e.m0.l.i0 i0Var = l0.b(type);
        if (i0Var != null) {
            obj5 = m().p(i0Var, h1.INVARIANT);
        }
        obj6 = z0.b(type, s(type.L0().getParameters(), type.K0(), i2), this.a.d(type.getAnnotations()));
        if (obj6 instanceof i0 && obj5 instanceof i0) {
            if (obj5 instanceof i0) {
                obj6 = l0.j((i0)obj6, (i0)obj5);
            }
        }
        obj5 = new x0(v0.a(), obj6);
        return obj5;
    }

    private List<kotlin.i0.z.e.m0.l.v0> s(List<z0> list, List<kotlin.i0.z.e.m0.l.v0> list2, int i3) {
        int i2;
        int i4;
        kotlin.i0.z.e.m0.l.h1 x0Var;
        Object obj;
        int i;
        kotlin.i0.z.e.m0.l.v0 v0Var;
        kotlin.i0.z.e.m0.l.h1 iNVARIANT;
        int ordinal;
        kotlin.i0.z.e.m0.l.h1 h1Var;
        ArrayList arrayList = new ArrayList(list.size());
        i4 = i2;
        while (i2 < list.size()) {
            x0Var = list.get(i2);
            obj = list2.get(i2);
            i = 1;
            v0Var = u((v0)obj, (z0)x0Var, i3 + 1);
            iNVARIANT = a1.b.a[a1.e(x0Var.l(), v0Var.a()).ordinal()];
            if (iNVARIANT != i && iNVARIANT != 2) {
            } else {
            }
            v0Var = c1.s(x0Var);
            if (v0Var != obj) {
            }
            arrayList.add(v0Var);
            i2++;
            i4 = i;
            if (iNVARIANT != 2) {
            } else {
            }
            if (iNVARIANT != 3) {
            } else {
            }
            iNVARIANT = h1.INVARIANT;
            if (x0Var.l() != iNVARIANT && !v0Var.c()) {
            }
            if (!v0Var.c()) {
            }
            x0Var = new x0(iNVARIANT, v0Var.getType());
            v0Var = x0Var;
        }
        if (i4 == 0) {
            return list2;
        }
        return arrayList;
    }

    private kotlin.i0.z.e.m0.l.v0 u(kotlin.i0.z.e.m0.l.v0 v0, z0 z02, int i3) {
        kotlin.i0.z.e.m0.l.b0 type;
        boolean empty;
        Object kVar;
        kotlin.i0.z.e.m0.l.g1 vVar;
        boolean z2;
        int i;
        kotlin.i0.z.e.m0.l.b0 type2;
        kotlin.i0.z.e.m0.l.h1 h1Var;
        boolean ordinal;
        boolean z;
        g annotations;
        Enum obj8;
        boolean obj9;
        int obj10;
        int i2 = 0;
        if (v0 == null) {
        } else {
            a1.b(i3, v0, this.a);
            if (v0.c()) {
                if (v0 == null) {
                } else {
                    return v0;
                }
                a1.a(18);
                throw i2;
            }
            kVar = v0.getType();
            int i4 = 1;
            if (kVar instanceof d1) {
                x0 x0Var = new x0(v0.a(), (d1)kVar.C0());
                obj9 = u(x0Var, z02, i3 += i4);
                obj10 = new x0(obj9.a(), e1.d(obj9.getType().O0(), p(kVar.F(), v0.a())));
                return obj10;
            }
            if (!r.a(kVar)) {
                if (g1Var2 instanceof h0) {
                } else {
                    kotlin.i0.z.e.m0.l.v0 v0Var = this.a.e(kVar);
                    if (v0Var != null) {
                        i = a1.l(kVar, v0Var, z02, v0);
                    } else {
                        i = i2;
                    }
                    h1Var = v0.a();
                    vVar = y.a(kVar);
                    x0 x0Var2 = new x0(h1Var, vVar.T0());
                    i3 += i4;
                    kotlin.i0.z.e.m0.l.v0 v0Var2 = u(x0Var2, z02, obj10);
                    x0 x0Var3 = new x0(h1Var, vVar.U0());
                    obj9 = u(x0Var3, z02, obj10);
                    if (i == 0 && y.b(kVar) && !s0.b(kVar) && v0Var2.getType() == vVar.T0() && obj9.getType() == vVar.U0()) {
                        if (y.b(kVar)) {
                            if (!s0.b(kVar)) {
                                vVar = y.a(kVar);
                                x0Var2 = new x0(h1Var, vVar.T0());
                                i3 += i4;
                                v0Var2 = u(x0Var2, z02, obj10);
                                x0Var3 = new x0(h1Var, vVar.U0());
                                obj9 = u(x0Var3, z02, obj10);
                                if (v0Var2.getType() == vVar.T0()) {
                                    if (obj9.getType() == vVar.U0()) {
                                        if (v0 == null) {
                                        } else {
                                            return v0;
                                        }
                                        a1.a(20);
                                        throw i2;
                                    }
                                }
                                obj9 = new x0(v0Var2.a(), c0.d(z0.a(v0Var2.getType()), z0.a(obj9.getType())));
                                return obj9;
                            }
                        }
                    }
                    if (!h.t0(kVar)) {
                        if (d0.a(kVar)) {
                        } else {
                            obj8 = a1.e(h1Var, i.a());
                            obj10 = 2;
                            if (i != 0 && !d.d(kVar)) {
                                obj8 = a1.e(h1Var, i.a());
                                obj10 = 2;
                                if (!d.d(kVar)) {
                                    obj9 = a1.b.a[obj8.ordinal()];
                                    if (obj9 == i4) {
                                    } else {
                                        if (obj9 != obj10) {
                                        }
                                        obj8 = new x0(h1.OUT_VARIANCE, kVar.L0().m().I());
                                        return obj8;
                                    }
                                    obj8 = new a1.c("Out-projection in in-position");
                                    throw obj8;
                                }
                                obj9 = s0.a(kVar);
                                if (i.c()) {
                                    if (i == 0) {
                                    } else {
                                        return i;
                                    }
                                    a1.a(22);
                                    throw i2;
                                }
                                if (obj9 != null) {
                                    obj9 = obj9.J(i.getType());
                                } else {
                                    obj9 = c1.q(i.getType(), kVar.M0());
                                }
                                if (!kVar.getAnnotations().isEmpty()) {
                                    obj10 = new g[obj10];
                                    obj10[0] = obj9.getAnnotations();
                                    obj10[i4] = a1.i(this.a.d(kVar.getAnnotations()));
                                    kVar = new k(obj10);
                                    obj9 = a.l(obj9, kVar);
                                }
                                if (obj8 == a1.d.NO_CONFLICT) {
                                    h1Var = a1.d(h1Var, i.a());
                                }
                                obj8 = new x0(h1Var, obj9);
                                return obj8;
                            }
                            obj8 = r(v0, i3);
                            if (obj8 == null) {
                            } else {
                                return obj8;
                            }
                        }
                        a1.a(23);
                        throw i2;
                    }
                    if (v0 == null) {
                    } else {
                        return v0;
                    }
                }
                a1.a(21);
                throw i2;
            }
            if (v0 == null) {
            } else {
                return v0;
            }
            a1.a(19);
            throw i2;
        }
        a1.a(17);
        throw i2;
    }

    public kotlin.i0.z.e.m0.l.y0 j() {
        kotlin.i0.z.e.m0.l.y0 y0Var = this.a;
        if (y0Var == null) {
        } else {
            return y0Var;
        }
        a1.a(7);
        throw 0;
    }

    public boolean k() {
        return this.a.f();
    }

    public kotlin.i0.z.e.m0.l.a1 m() {
        kotlin.i0.z.e.m0.l.y0 y0Var;
        y0Var = this.a;
        if (y0Var instanceof z && !y0Var.b()) {
            if (!y0Var.b()) {
            }
            z zVar = new z((z)this.a.i(), (z)this.a.h(), 0);
            a1 a1Var = new a1(zVar);
            return a1Var;
        }
        return this;
    }

    public kotlin.i0.z.e.m0.l.b0 n(kotlin.i0.z.e.m0.l.b0 b0, kotlin.i0.z.e.m0.l.h1 h12) {
        final int i = 0;
        if (b0 == null) {
        } else {
            if (h12 == null) {
            } else {
                if (k()) {
                    if (b0 == null) {
                    } else {
                        return b0;
                    }
                    a1.a(10);
                    throw i;
                }
                x0 x0Var = new x0(h12, b0);
                kotlin.i0.z.e.m0.l.b0 obj3 = u(x0Var, i, 0).getType();
                if (obj3 == null) {
                } else {
                    return obj3;
                }
                a1.a(11);
                throw i;
            }
            a1.a(9);
            throw i;
        }
        a1.a(8);
        throw i;
    }

    public kotlin.i0.z.e.m0.l.b0 p(kotlin.i0.z.e.m0.l.b0 b0, kotlin.i0.z.e.m0.l.h1 h12) {
        int type;
        type = 0;
        if (b0 == null) {
        } else {
            if (h12 == null) {
            } else {
                x0 x0Var = new x0(h12, j().g(b0, h12));
                kotlin.i0.z.e.m0.l.v0 obj4 = q(x0Var);
                if (obj4 == null) {
                } else {
                    type = obj4.getType();
                }
                return type;
            }
            a1.a(14);
            throw type;
        }
        a1.a(13);
        throw type;
    }

    public kotlin.i0.z.e.m0.l.v0 q(kotlin.i0.z.e.m0.l.v0 v0) {
        boolean z;
        if (v0 == null) {
        } else {
            kotlin.i0.z.e.m0.l.v0 obj2 = t(v0);
            if (!this.a.a() && !this.a.b()) {
                if (!this.a.b()) {
                    return obj2;
                }
            }
            return b.c(obj2, this.a.b());
        }
        a1.a(15);
        throw 0;
    }

    public kotlin.i0.z.e.m0.l.v0 t(kotlin.i0.z.e.m0.l.v0 v0) {
        final int i = 0;
        if (v0 == null) {
        } else {
            if (k()) {
                return v0;
            }
            return u(v0, i, 0);
        }
        a1.a(16);
        throw i;
    }
}
