package kotlin.i0.z.e.m0.l;

import android.app.ActivityManager.MemoryInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.d0.c.l;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.l.j1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.utils.j;
import kotlin.y.p;

/* loaded from: classes3.dex */
public class c1 {

    public static final kotlin.i0.z.e.m0.l.i0 a;
    public static final kotlin.i0.z.e.m0.l.i0 b;
    public static final kotlin.i0.z.e.m0.l.i0 c;
    public static final kotlin.i0.z.e.m0.l.i0 d;

    public static class a extends kotlin.i0.z.e.m0.l.m {

        private final String b;
        public a(String string) {
            super();
            this.b = string;
        }

        private static void X0(int i) {
            String str2;
            int str4;
            int i2;
            String str;
            String str3;
            Object obj9;
            final int i3 = 4;
            final int i4 = 1;
            if (i != i4 && i != i3) {
                str2 = i != i3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            } else {
            }
            str4 = 3;
            final int i5 = 2;
            if (i != i4 && i != i3) {
                i2 = i != i3 ? str4 : i5;
            } else {
            }
            Object[] arr = new Object[i2];
            str = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
            int i6 = 0;
            if (i != i4) {
                if (i != i5) {
                    if (i != str4) {
                        if (i != i3) {
                            arr[i6] = "newAnnotations";
                        } else {
                            arr[i6] = str;
                        }
                    } else {
                        arr[i6] = "kotlinTypeRefiner";
                    }
                } else {
                    arr[i6] = "delegate";
                }
            } else {
            }
            String str5 = "refine";
            if (i != i4) {
                if (i != i3) {
                    arr[i4] = str;
                } else {
                    arr[i4] = str5;
                }
            } else {
                arr[i4] = "toString";
            }
            if (i != i4) {
                if (i != i5) {
                    if (i != str4) {
                        if (i != i3) {
                            arr[i5] = "replaceAnnotations";
                        }
                    } else {
                        arr[i5] = str5;
                    }
                } else {
                    arr[i5] = "replaceDelegate";
                }
            }
            String format = String.format(str2, arr);
            if (i != i4 && i != i3) {
                if (i != i3) {
                    obj9 = new IllegalArgumentException(format);
                } else {
                    obj9 = new IllegalStateException(format);
                }
            } else {
            }
            throw obj9;
        }

        @Override // kotlin.i0.z.e.m0.l.m
        public kotlin.i0.z.e.m0.l.b0 N0(g g) {
            Y0(g);
            return this;
        }

        @Override // kotlin.i0.z.e.m0.l.m
        public kotlin.i0.z.e.m0.l.g1 P0(boolean z) {
            S0(z);
            throw 0;
        }

        @Override // kotlin.i0.z.e.m0.l.m
        public kotlin.i0.z.e.m0.l.g1 Q0(g g) {
            Y0(g);
            return this;
        }

        @Override // kotlin.i0.z.e.m0.l.m
        public kotlin.i0.z.e.m0.l.g1 R0(g g) {
            T0(g);
            throw 0;
        }

        @Override // kotlin.i0.z.e.m0.l.m
        public kotlin.i0.z.e.m0.l.i0 S0(boolean z) {
            IllegalStateException obj2 = new IllegalStateException(this.b);
            throw obj2;
        }

        @Override // kotlin.i0.z.e.m0.l.m
        public kotlin.i0.z.e.m0.l.i0 T0(g g) {
            if (g == null) {
                c1.a.X0(0);
                throw 0;
            }
            IllegalStateException obj2 = new IllegalStateException(this.b);
            throw obj2;
        }

        @Override // kotlin.i0.z.e.m0.l.m
        protected kotlin.i0.z.e.m0.l.i0 U0() {
            IllegalStateException illegalStateException = new IllegalStateException(this.b);
            throw illegalStateException;
        }

        @Override // kotlin.i0.z.e.m0.l.m
        public kotlin.i0.z.e.m0.l.i0 V0(g g) {
            Y0(g);
            return this;
        }

        @Override // kotlin.i0.z.e.m0.l.m
        public kotlin.i0.z.e.m0.l.m W0(kotlin.i0.z.e.m0.l.i0 i0) {
            if (i0 == null) {
                c1.a.X0(2);
                throw 0;
            }
            IllegalStateException obj2 = new IllegalStateException(this.b);
            throw obj2;
        }

        @Override // kotlin.i0.z.e.m0.l.m
        public kotlin.i0.z.e.m0.l.c1.a Y0(g g) {
            if (g == null) {
            } else {
                return this;
            }
            c1.a.X0(3);
            throw 0;
        }

        @Override // kotlin.i0.z.e.m0.l.m
        public String toString() {
            String str = this.b;
            if (str == null) {
            } else {
                return str;
            }
            c1.a.X0(1);
            throw 0;
        }
    }
    static {
        c1.a = t.p("DONT_CARE");
        c1.b = t.j("Cannot be inferred");
        c1.a aVar = new c1.a("NO_EXPECTED_TYPE");
        c1.c = aVar;
        c1.a aVar2 = new c1.a("UNIT_EXPECTED_TYPE");
        c1.d = aVar2;
    }

    private static void a(int i) {
        Object illegalStateException;
        String str3;
        int i3;
        String str;
        String str2;
        int i4 = i;
        final int i5 = 7;
        final int i6 = 6;
        final int i7 = 52;
        final int i8 = 47;
        final int i9 = 35;
        final int i10 = 26;
        final int i11 = 19;
        final int i12 = 17;
        final int i13 = 15;
        final int i14 = 11;
        final int i15 = 9;
        final int i16 = 4;
        if (i4 != i16 && i4 != i15 && i4 != i14 && i4 != i13 && i4 != i12 && i4 != i11 && i4 != i10 && i4 != i9 && i4 != i8 && i4 != i7 && i4 != i6 && i4 != i5) {
            if (i4 != i15) {
                if (i4 != i14) {
                    if (i4 != i13) {
                        if (i4 != i12) {
                            if (i4 != i11) {
                                if (i4 != i10) {
                                    if (i4 != i9) {
                                        if (i4 != i8) {
                                            if (i4 != i7) {
                                                if (i4 != i6) {
                                                    if (i4 != i5) {
                                                        str3 = /* condition */ ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                                                    } else {
                                                    }
                                                } else {
                                                }
                                            } else {
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        final int i17 = 2;
        if (i4 != i16 && i4 != i15 && i4 != i14 && i4 != i13 && i4 != i12 && i4 != i11 && i4 != i10 && i4 != i9 && i4 != i8 && i4 != i7 && i4 != i6 && i4 != i5) {
            if (i4 != i15) {
                if (i4 != i14) {
                    if (i4 != i13) {
                        if (i4 != i12) {
                            if (i4 != i11) {
                                if (i4 != i10) {
                                    if (i4 != i9) {
                                        if (i4 != i8) {
                                            if (i4 != i7) {
                                                if (i4 != i6) {
                                                    if (i4 != i5) {
                                                        i3 = /* condition */ ? i17 : 3;
                                                    } else {
                                                    }
                                                } else {
                                                }
                                            } else {
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        Object[] arr = new Object[i3];
        str = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
        int i18 = 0;
        switch (i4) {
            case 4:
                arr[i18] = str;
                break;
            case 5:
                arr[i18] = "type";
                break;
            case 6:
                arr[i18] = "typeConstructor";
                break;
            case 7:
                arr[i18] = "unsubstitutedMemberScope";
                break;
            case 8:
                arr[i18] = "refinedTypeFactory";
                break;
            case 9:
                arr[i18] = "parameters";
                break;
            case 10:
                arr[i18] = "subType";
                break;
            case 11:
                arr[i18] = "superType";
                break;
            case 12:
                arr[i18] = "substitutor";
                break;
            case 13:
                arr[i18] = "result";
                break;
            case 14:
                arr[i18] = "clazz";
                break;
            case 15:
                arr[i18] = "typeArguments";
                break;
            case 16:
                arr[i18] = "projections";
                break;
            case 17:
                arr[i18] = "a";
                break;
            case 18:
                arr[i18] = "b";
                break;
            case 19:
                arr[i18] = "typeParameters";
                break;
            case 20:
                arr[i18] = "typeParameterConstructors";
                break;
            case 21:
                arr[i18] = "specialType";
                break;
            case 22:
                arr[i18] = "isSpecialType";
                break;
            case 23:
                arr[i18] = "parameterDescriptor";
                break;
            case 24:
                arr[i18] = "numberValueTypeConstructor";
                break;
            case 25:
                arr[i18] = "supertypes";
                break;
            case 26:
                arr[i18] = "expectedType";
                break;
            default:
                arr[i18] = "literalTypeConstructor";
        }
        String str4 = "getAllSupertypes";
        String str5 = "getImmediateSupertypes";
        final String str6 = "getDefaultTypeProjections";
        final String str7 = "makeUnsubstitutedType";
        final String str8 = "makeNullableIfNeeded";
        final String str9 = "makeNullableAsSpecified";
        final int i19 = 1;
        if (i4 != i16) {
            if (i4 != i15) {
                if (i4 != i14 && i4 != i13) {
                    if (i4 != i13) {
                        if (i4 != i12) {
                            if (i4 != i11) {
                                if (i4 != i10) {
                                    if (i4 != i9) {
                                        if (i4 != i8) {
                                            if (i4 != i7) {
                                                if (i4 != i6 && i4 != i5) {
                                                    if (i4 != i5) {
                                                        if (/* condition */) {
                                                            arr[i19] = "getPrimitiveNumberType";
                                                        } else {
                                                            arr[i19] = str;
                                                        }
                                                    } else {
                                                        arr[i19] = str8;
                                                    }
                                                } else {
                                                }
                                            } else {
                                            }
                                        } else {
                                            arr[i19] = "getDefaultPrimitiveNumberType";
                                        }
                                    } else {
                                        arr[i19] = "substituteProjectionsForParameters";
                                    }
                                } else {
                                    arr[i19] = str4;
                                }
                            } else {
                                arr[i19] = str5;
                            }
                        } else {
                            arr[i19] = str6;
                        }
                    } else {
                        arr[i19] = str7;
                    }
                } else {
                }
            } else {
            }
        } else {
            arr[i19] = str9;
        }
        switch (i4) {
            case 1:
                arr[i17] = "makeNullable";
                break;
            case 2:
                arr[i17] = "makeNotNullable";
                break;
            case 3:
                arr[i17] = str9;
                break;
            case 5:
                arr[i17] = str8;
                break;
            case 6:
                arr[i17] = "canHaveSubtypes";
                break;
            case 7:
                arr[i17] = str7;
                break;
            case 8:
                arr[i17] = str6;
                break;
            case 9:
                arr[i17] = str5;
                break;
            case 10:
                arr[i17] = "createSubstitutedSupertype";
                break;
            case 11:
                arr[i17] = "collectAllSupertypes";
                break;
            case 12:
                arr[i17] = str4;
                break;
            case 13:
                arr[i17] = "isNullableType";
                break;
            case 14:
                arr[i17] = "acceptsNullable";
                break;
            case 15:
                arr[i17] = "hasNullableSuperType";
                break;
            case 16:
                arr[i17] = "getClassDescriptor";
                break;
            case 17:
                arr[i17] = "substituteParameters";
                break;
            case 18:
                arr[i17] = "substituteProjectionsForParameters";
                break;
            case 19:
                arr[i17] = "equalTypes";
                break;
            case 20:
                arr[i17] = "dependsOnTypeParameters";
                break;
            case 21:
                arr[i17] = "dependsOnTypeConstructors";
                break;
            case 22:
                arr[i17] = "contains";
                break;
            case 23:
                arr[i17] = "makeStarProjection";
                break;
            case 24:
                arr[i17] = "getDefaultPrimitiveNumberType";
                break;
            case 25:
                arr[i17] = "findByFqName";
                break;
            case 26:
                arr[i17] = "getPrimitiveNumberType";
                break;
            case 27:
                arr[i17] = "isTypeParameter";
                break;
            case 28:
                arr[i17] = "isReifiedTypeParameter";
                break;
            case 29:
                arr[i17] = "isNonReifiedTypeParameter";
                break;
            case 30:
                arr[i17] = "getTypeParameterDescriptorOrNull";
                break;
            default:
                arr[i17] = "noExpectedType";
        }
        String format = String.format(str3, arr);
        if (i4 != i16 && i4 != i15 && i4 != i14 && i4 != i13 && i4 != i12 && i4 != i11 && i4 != i10 && i4 != i9 && i4 != i8 && i4 != i7 && i4 != i6 && i4 != i5) {
            if (i4 != i15) {
                if (i4 != i14) {
                    if (i4 != i13) {
                        if (i4 != i12) {
                            if (i4 != i11) {
                                if (i4 != i10) {
                                    if (i4 != i9) {
                                        if (i4 != i8) {
                                            if (i4 != i7) {
                                                if (i4 != i6) {
                                                    if (i4 != i5) {
                                                        if (/* condition */) {
                                                            illegalStateException = new IllegalStateException(format);
                                                        } else {
                                                            illegalStateException = new IllegalArgumentException(format);
                                                        }
                                                    } else {
                                                    }
                                                } else {
                                                }
                                            } else {
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        throw illegalStateException;
    }

    public static boolean b(kotlin.i0.z.e.m0.l.b0 b0) {
        kotlin.i0.z.e.m0.l.b0 obj2;
        if (b0 == null) {
        } else {
            final int i = 1;
            if (b0.M0()) {
                return i;
            }
            if (y.b(b0) && c1.b(y.a(b0).U0())) {
                if (c1.b(y.a(b0).U0())) {
                    return i;
                }
            }
            return 0;
        }
        c1.a(28);
        throw 0;
    }

    public static boolean c(kotlin.i0.z.e.m0.l.b0 b0, l<kotlin.i0.z.e.m0.l.g1, Boolean> l2) {
        final int i = 0;
        if (l2 == null) {
        } else {
            return c1.d(b0, l2, i);
        }
        c1.a(43);
        throw i;
    }

    private static boolean d(kotlin.i0.z.e.m0.l.b0 b0, l<kotlin.i0.z.e.m0.l.g1, Boolean> l2, j<kotlin.i0.z.e.m0.l.b0> j3) {
        int i;
        boolean z3;
        kotlin.i0.z.e.m0.l.t0 next;
        boolean z;
        boolean contains;
        boolean z2;
        j obj7;
        if (l2 == null) {
        } else {
            final int i2 = 0;
            if (b0 == null) {
                return i2;
            }
            kotlin.i0.z.e.m0.l.g1 g1Var = b0.O0();
            if (c1.v(b0)) {
                return (Boolean)l2.invoke(g1Var).booleanValue();
            }
            if (j3 != null && j3.contains(b0)) {
                if (j3.contains(b0)) {
                    return i2;
                }
            }
            final int i3 = 1;
            if ((Boolean)l2.invoke(g1Var).booleanValue()) {
                return i3;
            }
            if (j3 == null) {
                obj7 = j.b();
            }
            obj7.add(b0);
            if (g1Var instanceof v) {
                i = g1Var;
            }
            if (i != 0 && !c1.d(i.T0(), l2, obj7) && c1.d(i.U0(), l2, obj7)) {
                if (!c1.d(i.T0(), l2, obj7)) {
                    if (c1.d(i.U0(), l2, obj7)) {
                    }
                }
                return i3;
            }
            if (g1Var instanceof k && c1.d((k)g1Var.X0(), l2, obj7)) {
                if (c1.d((k)g1Var.X0(), l2, obj7)) {
                    return i3;
                }
            }
            next = b0.L0();
            if (next instanceof a0) {
                Iterator obj5 = (a0)next.a().iterator();
                for (b0 next3 : obj5) {
                }
                return i2;
            }
            obj5 = b0.K0().iterator();
            for (v0 next : obj5) {
            }
            return i2;
        }
        c1.a(44);
        throw 0;
    }

    public static kotlin.i0.z.e.m0.l.b0 e(kotlin.i0.z.e.m0.l.b0 b0, kotlin.i0.z.e.m0.l.b0 b02, kotlin.i0.z.e.m0.l.a1 a13) {
        final int i = 0;
        if (b0 == null) {
        } else {
            if (b02 == null) {
            } else {
                if (a13 == null) {
                } else {
                    final kotlin.i0.z.e.m0.l.b0 obj3 = a13.p(b02, h1.INVARIANT);
                    if (obj3 != null) {
                        return c1.q(obj3, b0.M0());
                    }
                    return i;
                }
                c1.a(22);
                throw i;
            }
            c1.a(21);
            throw i;
        }
        c1.a(20);
        throw i;
    }

    public static e f(kotlin.i0.z.e.m0.l.b0 b0) {
        final int i = 0;
        if (b0 == null) {
        } else {
            h obj2 = b0.L0().c();
            if (obj2 instanceof e) {
                return (e)obj2;
            }
            return i;
        }
        c1.a(30);
        throw i;
    }

    public static List<kotlin.i0.z.e.m0.l.v0> g(List<z0> list) {
        int size;
        kotlin.i0.z.e.m0.l.x0 x0Var;
        final int i = 0;
        if (list == null) {
        } else {
            ArrayList arrayList = new ArrayList(list.size());
            Iterator obj4 = list.iterator();
            for (z0 next2 : obj4) {
                x0Var = new x0(next2.q());
                arrayList.add(x0Var);
            }
            obj4 = p.L0(arrayList);
            if (obj4 == null) {
            } else {
                return obj4;
            }
            c1.a(17);
            throw i;
        }
        c1.a(16);
        throw i;
    }

    public static List<kotlin.i0.z.e.m0.l.b0> h(kotlin.i0.z.e.m0.l.b0 b0) {
        int size;
        if (b0 == null) {
        } else {
            Collection collection = b0.L0().a();
            ArrayList arrayList = new ArrayList(collection.size());
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                size = c1.e(b0, (b0)iterator.next(), a1.f(b0));
                if (size != 0) {
                }
                arrayList.add(size);
            }
            return arrayList;
        }
        c1.a(18);
        throw 0;
    }

    public static z0 i(kotlin.i0.z.e.m0.l.b0 b0) {
        final int i = 0;
        if (b0 == null) {
        } else {
            if (hVar instanceof z0) {
                return (z0)b0.L0().c();
            }
            return i;
        }
        c1.a(62);
        throw i;
    }

    public static boolean j(kotlin.i0.z.e.m0.l.b0 b0) {
        boolean z;
        if (b0 == null) {
        } else {
            final int i = 0;
            if (hVar instanceof e) {
                return i;
            }
            Iterator obj2 = c1.h(b0).iterator();
            for (b0 next2 : obj2) {
            }
            return i;
        }
        c1.a(29);
        throw 0;
    }

    public static boolean k(kotlin.i0.z.e.m0.l.b0 b0) {
        kotlin.i0.z.e.m0.l.t0 t0Var;
        kotlin.i0.z.e.m0.l.t0 obj1;
        if (b0 != null && b0.L0() == c1.a.L0()) {
            obj1 = b0.L0() == c1.a.L0() ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static boolean l(kotlin.i0.z.e.m0.l.b0 b0) {
        boolean z;
        boolean next;
        Object obj3;
        if (b0 == null) {
        } else {
            final int i = 1;
            if (b0.M0()) {
                return i;
            }
            if (y.b(b0) && c1.l(y.a(b0).U0())) {
                if (c1.l(y.a(b0).U0())) {
                    return i;
                }
            }
            final int i2 = 0;
            if (l0.c(b0)) {
                return i2;
            }
            if (c1.m(b0)) {
                return c1.j(b0);
            }
            obj3 = b0.L0();
            if (obj3 instanceof a0) {
                obj3 = obj3.a().iterator();
                for (b0 next2 : obj3) {
                }
            }
            return i2;
        }
        c1.a(27);
        throw 0;
    }

    public static boolean m(kotlin.i0.z.e.m0.l.b0 b0) {
        int obj1;
        if (b0 == null) {
        } else {
            obj1 = c1.i(b0) == null ? 0 : 1;
            return obj1;
        }
        c1.a(59);
        throw 0;
    }

    public static kotlin.i0.z.e.m0.l.b0 n(kotlin.i0.z.e.m0.l.b0 b0) {
        if (b0 == null) {
        } else {
            return c1.p(b0, false);
        }
        c1.a(2);
        throw 0;
    }

    public static kotlin.i0.z.e.m0.l.b0 o(kotlin.i0.z.e.m0.l.b0 b0) {
        final int i = 1;
        if (b0 == null) {
        } else {
            return c1.p(b0, i);
        }
        c1.a(i);
        throw 0;
    }

    public static kotlin.i0.z.e.m0.l.b0 p(kotlin.i0.z.e.m0.l.b0 b0, boolean z2) {
        final int i = 0;
        if (b0 == null) {
        } else {
            kotlin.i0.z.e.m0.l.g1 obj1 = b0.O0().P0(z2);
            if (obj1 == null) {
            } else {
                return obj1;
            }
            c1.a(4);
            throw i;
        }
        c1.a(3);
        throw i;
    }

    public static kotlin.i0.z.e.m0.l.b0 q(kotlin.i0.z.e.m0.l.b0 b0, boolean z2) {
        final int i = 0;
        if (b0 == null) {
        } else {
            if (z2) {
                return c1.o(b0);
            }
            if (b0 == null) {
            } else {
                return b0;
            }
            c1.a(9);
            throw i;
        }
        c1.a(8);
        throw i;
    }

    public static kotlin.i0.z.e.m0.l.i0 r(kotlin.i0.z.e.m0.l.i0 i0, boolean z2) {
        final int i = 0;
        if (i0 == null) {
        } else {
            if (z2) {
                kotlin.i0.z.e.m0.l.i0 obj1 = i0.S0(true);
                if (obj1 == null) {
                } else {
                    return obj1;
                }
                c1.a(6);
                throw i;
            }
            if (i0 == null) {
            } else {
                return i0;
            }
            c1.a(7);
            throw i;
        }
        c1.a(5);
        throw i;
    }

    public static kotlin.i0.z.e.m0.l.v0 s(z0 z0) {
        if (z0 == null) {
        } else {
            n0 n0Var = new n0(z0);
            return n0Var;
        }
        c1.a(45);
        throw 0;
    }

    public static kotlin.i0.z.e.m0.l.i0 t(h h, h h2, l<g, kotlin.i0.z.e.m0.l.i0> l3) {
        if (t.r(h)) {
            StringBuilder obj2 = new StringBuilder();
            obj2.append("Unsubstituted type for ");
            obj2.append(h);
            kotlin.i0.z.e.m0.l.i0 obj1 = t.j(obj2.toString());
            if (obj1 == null) {
            } else {
                return obj1;
            }
            c1.a(11);
            throw 0;
        }
        return c1.u(h.g(), h2, l3);
    }

    public static kotlin.i0.z.e.m0.l.i0 u(kotlin.i0.z.e.m0.l.t0 t0, h h2, l<g, kotlin.i0.z.e.m0.l.i0> l3) {
        final int i = 0;
        if (t0 == null) {
        } else {
            if (h2 == null) {
            } else {
                if (l3 == null) {
                } else {
                    kotlin.i0.z.e.m0.l.i0 obj8 = c0.k(g.q.b(), t0, c1.g(t0.getParameters()), false, h2, l3);
                    if (obj8 == null) {
                    } else {
                        return obj8;
                    }
                    c1.a(15);
                    throw i;
                }
                c1.a(14);
                throw i;
            }
            c1.a(13);
            throw i;
        }
        c1.a(12);
        throw i;
    }

    public static boolean v(kotlin.i0.z.e.m0.l.b0 b0) {
        int i;
        kotlin.i0.z.e.m0.l.i0 i0Var;
        if (b0 == null) {
        } else {
            if (b0 != c1.c) {
                if (b0 == c1.d) {
                    i = 1;
                }
            } else {
            }
            return i;
        }
        c1.a(0);
        throw 0;
    }
}
