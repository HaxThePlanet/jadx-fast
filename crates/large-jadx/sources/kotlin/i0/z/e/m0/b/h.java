package kotlin.i0.z.e.m0.b;

import android.app.ActivityManager.MemoryInfo;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.i0.z.e.m0.b.p.a;
import kotlin.i0.z.e.m0.c.b.d;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.c;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.d;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.i.v.k;
import kotlin.i0.z.e.m0.k.g;
import kotlin.i0.z.e.m0.k.i;
import kotlin.i0.z.e.m0.k.n;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.c0;
import kotlin.i0.z.e.m0.l.c1;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.m0.l.v0;
import kotlin.i0.z.e.m0.l.x0;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.i1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.i1.a.a;
import kotlin.reflect.jvm.internal.impl.descriptors.i1.b;
import kotlin.reflect.jvm.internal.impl.descriptors.i1.c;
import kotlin.reflect.jvm.internal.impl.descriptors.i1.c.b;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.x;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.s;
import kotlin.reflect.jvm.internal.impl.descriptors.w;

/* loaded from: classes3.dex */
public abstract class h {

    public static final e e;
    private x a;
    private final i<kotlin.i0.z.e.m0.b.h.e> b;
    private final g<e, e> c;
    private final n d;

    private static class e {

        public final Map<kotlin.i0.z.e.m0.b.i, i0> a;
        public final Map<b0, i0> b;
        public final Map<i0, i0> c;
        private e(Map<kotlin.i0.z.e.m0.b.i, i0> map, Map<b0, i0> map2, Map<i0, i0> map3) {
            final int i = 0;
            if (map == null) {
            } else {
                if (map2 == null) {
                } else {
                    if (map3 == null) {
                    } else {
                        super();
                        this.a = map;
                        this.b = map2;
                        this.c = map3;
                    }
                    h.e.a(2);
                    throw i;
                }
                h.e.a(1);
                throw i;
            }
            h.e.a(0);
            throw i;
        }

        e(Map map, Map map2, Map map3, kotlin.i0.z.e.m0.b.h.a h$a4) {
            super(map, map2, map3);
        }

        private static void a(int i) {
            String obj4;
            Object[] arr = new Object[3];
            final int i3 = 2;
            final int i4 = 1;
            final int i5 = 0;
            if (i != i4) {
                if (i != i3) {
                    arr[i5] = "primitiveTypeToArrayKotlinType";
                } else {
                    arr[i5] = "kotlinArrayTypeToPrimitiveKotlinType";
                }
            } else {
                arr[i5] = "primitiveKotlinTypeToKotlinArrayType";
            }
            arr[i4] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$Primitives";
            arr[i3] = "<init>";
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
            throw illegalArgumentException;
        }
    }

    class a implements a<Collection<k0>> {

        final kotlin.i0.z.e.m0.b.h a;
        a(kotlin.i0.z.e.m0.b.h h) {
            this.a = h;
            super();
        }

        public Collection<k0> a() {
            k0[] arr = new k0[4];
            return Arrays.asList(h.b(this.a).M(k.l), h.b(this.a).M(k.n), h.b(this.a).M(k.o), h.b(this.a).M(k.m));
        }

        @Override // kotlin.d0.c.a
        public Object invoke() {
            return a();
        }
    }

    class b implements a<kotlin.i0.z.e.m0.b.h.e> {

        final kotlin.i0.z.e.m0.b.h a;
        b(kotlin.i0.z.e.m0.b.h h) {
            this.a = h;
            super();
        }

        @Override // kotlin.d0.c.a
        public kotlin.i0.z.e.m0.b.h.e a() {
            int i;
            kotlin.i0.z.e.m0.b.i iVar;
            i0 i0Var2;
            i0 i0Var;
            String str;
            EnumMap enumMap = new EnumMap(i.class);
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            kotlin.i0.z.e.m0.b.i[] values = i.values();
            i = 0;
            while (i < values.length) {
                iVar = values[i];
                i0Var2 = h.d(this.a, iVar.getTypeName().c());
                i0Var = h.d(this.a, iVar.getArrayTypeName().c());
                enumMap.put(iVar, i0Var);
                hashMap.put(i0Var2, i0Var);
                hashMap2.put(i0Var, i0Var2);
                i++;
            }
            h.e eVar = new h.e(enumMap, hashMap, hashMap2, 0);
            return eVar;
        }

        @Override // kotlin.d0.c.a
        public Object invoke() {
            return a();
        }
    }

    class c implements l<e, e> {

        final kotlin.i0.z.e.m0.b.h a;
        c(kotlin.i0.z.e.m0.b.h h) {
            this.a = h;
            super();
        }

        @Override // kotlin.d0.c.l
        public e a(e e) {
            h hVar3 = this.a.s().f(e, d.FROM_BUILTINS);
            if (hVar3 == null) {
            } else {
                if (!hVar3 instanceof e) {
                } else {
                    return (e)hVar3;
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Must be a class descriptor ");
                stringBuilder2.append(e);
                stringBuilder2.append(", but was ");
                stringBuilder2.append(hVar3);
                AssertionError assertionError2 = new AssertionError(stringBuilder2.toString());
                throw assertionError2;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Built-in class ");
            stringBuilder.append(k.l.c(e));
            stringBuilder.append(" is not found");
            AssertionError assertionError = new AssertionError(stringBuilder.toString());
            throw assertionError;
        }

        @Override // kotlin.d0.c.l
        public Object invoke(Object object) {
            return a((e)object);
        }
    }

    class d implements a<Void> {

        final x a;
        final kotlin.i0.z.e.m0.b.h b;
        d(kotlin.i0.z.e.m0.b.h h, x x2) {
            this.b = h;
            this.a = x2;
            super();
        }

        @Override // kotlin.d0.c.a
        public Void a() {
            if (h.b(this.b) != null) {
            } else {
                h.c(this.b, this.a);
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Built-ins module is already set: ");
            stringBuilder.append(h.b(this.b));
            stringBuilder.append(" (attempting to reset to ");
            stringBuilder.append(this.a);
            stringBuilder.append(")");
            AssertionError assertionError = new AssertionError(stringBuilder.toString());
            throw assertionError;
        }

        @Override // kotlin.d0.c.a
        public Object invoke() {
            return a();
        }
    }
    static {
        h.e = e.n("<built-ins module>");
    }

    protected h(n n) {
        if (n == null) {
        } else {
            super();
            this.d = n;
            h.a aVar = new h.a(this);
            n.d(aVar);
            h.b bVar = new h.b(this);
            this.b = n.d(bVar);
            h.c cVar = new h.c(this);
            this.c = n.h(cVar);
        }
        h.a(0);
        throw 0;
    }

    private static b0 A(b0 b0, c0 c02) {
        final int i = 0;
        if (b0 == null) {
        } else {
            if (c02 == null) {
            } else {
                h obj3 = b0.L0().c();
                if (obj3 == null) {
                    return i;
                }
                final kotlin.i0.z.e.m0.b.o oVar = o.a;
                if (!oVar.b(obj3.getName())) {
                    return i;
                }
                obj3 = a.h(obj3);
                if (obj3 == null) {
                    return i;
                }
                obj3 = oVar.a(obj3);
                if (obj3 == null) {
                    return i;
                }
                obj3 = w.a(c02, obj3);
                if (obj3 == null) {
                    return i;
                }
                return obj3.q();
            }
            h.a(71);
            throw i;
        }
        h.a(70);
        throw i;
    }

    public static boolean A0(b0 b0) {
        if (b0 == null) {
        } else {
            return h.i0(b0, k.a.l);
        }
        h.a(119);
        throw 0;
    }

    public static boolean B0(e e) {
        c z;
        int obj1;
        if (e == null) {
        } else {
            if (!h.e(e, k.a.b)) {
                if (h.e(e, k.a.c)) {
                    obj1 = 1;
                } else {
                    obj1 = 0;
                }
            } else {
            }
            return obj1;
        }
        h.a(106);
        throw 0;
    }

    public static boolean C0(b0 b0) {
        c cVar;
        b0 obj1;
        if (b0 != null && h.s0(b0, k.a.g)) {
            obj1 = h.s0(b0, k.a.g) ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static boolean D0(t0 t0, c c2) {
        int obj1;
        int i = 0;
        if (t0 == null) {
        } else {
            if (c2 == null) {
            } else {
                obj1 = t0.c();
                if (obj1 instanceof e && h.e(obj1, c2)) {
                    obj1 = h.e(obj1, c2) ? 1 : 0;
                } else {
                }
                return obj1;
            }
            h.a(101);
            throw i;
        }
        h.a(100);
        throw i;
    }

    public static boolean E0(b0 b0) {
        if (b0 == null) {
        } else {
            return h.i0(b0, k.a.i0.j());
        }
        h.a(127);
        throw 0;
    }

    public static boolean F0(b0 b0) {
        if (b0 == null) {
        } else {
            return h.i0(b0, k.a.k0.j());
        }
        h.a(129);
        throw 0;
    }

    public static boolean G0(b0 b0) {
        if (b0 == null) {
        } else {
            return h.i0(b0, k.a.l0.j());
        }
        h.a(130);
        throw 0;
    }

    public static boolean H0(b0 b0) {
        if (b0 == null) {
        } else {
            return h.i0(b0, k.a.j0.j());
        }
        h.a(128);
        throw 0;
    }

    public static boolean I0(m m) {
        boolean z;
        Object obj1;
        if (m == null) {
        }
        h.a(9);
        throw 0;
    }

    public static boolean J0(b0 b0) {
        if (b0 == null) {
        } else {
            return h.s0(b0, k.a.e);
        }
        h.a(141);
        throw 0;
    }

    public static boolean K0(b0 b0) {
        boolean z;
        b0 obj1;
        if (b0 == null) {
        } else {
            if (!h.E0(b0) && !h.H0(b0) && !h.F0(b0)) {
                if (!h.H0(b0)) {
                    if (!h.F0(b0)) {
                        if (h.G0(b0)) {
                            obj1 = 1;
                        } else {
                            obj1 = 0;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return obj1;
        }
        h.a(131);
        throw 0;
    }

    public static kotlin.i0.z.e.m0.b.i O(m m) {
        int i;
        Object obj3;
        if (m == null) {
        } else {
            if (k.a.n0.contains(m.getName())) {
                i = obj3;
            }
            return i;
        }
        h.a(76);
        throw 0;
    }

    private e P(kotlin.i0.z.e.m0.b.i i) {
        if (i == null) {
        } else {
            return p(i.getTypeName().c());
        }
        h.a(15);
        throw 0;
    }

    public static kotlin.i0.z.e.m0.b.i R(m m) {
        int i;
        Object obj3;
        if (m == null) {
        } else {
            if (k.a.m0.contains(m.getName())) {
                i = obj3;
            }
            return i;
        }
        h.a(75);
        throw 0;
    }

    public static boolean Z(e e) {
        if (e == null) {
        } else {
            return h.e(e, k.a.b);
        }
        h.a(107);
        throw 0;
    }

    private static void a(int i) {
        String str;
        Object obj2;
        int i2;
        String str2;
        String str3;
        Object obj13;
        str = /* condition */ ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        i2 = /* condition */ ? i3 : 3;
        Object[] arr = new Object[i2];
        str2 = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
        int i4 = 0;
        switch (i) {
            case 1:
                arr[i4] = "module";
                break;
            case 2:
                arr[i4] = str2;
                break;
            case 3:
                arr[i4] = "descriptor";
                break;
            case 4:
                arr[i4] = "fqName";
                break;
            case 5:
                arr[i4] = "simpleName";
                break;
            case 6:
                arr[i4] = "type";
                break;
            case 7:
                arr[i4] = "classSimpleName";
                break;
            case 8:
                arr[i4] = "arrayType";
                break;
            case 9:
                arr[i4] = "notNullArrayType";
                break;
            case 10:
                arr[i4] = "primitiveType";
                break;
            case 11:
                arr[i4] = "kotlinType";
                break;
            case 12:
                arr[i4] = "projectionType";
                break;
            case 13:
                arr[i4] = "argument";
                break;
            case 14:
                arr[i4] = "annotations";
                break;
            case 15:
                arr[i4] = "typeConstructor";
                break;
            case 16:
                arr[i4] = "classDescriptor";
                break;
            case 17:
                arr[i4] = "declarationDescriptor";
                break;
            default:
                arr[i4] = "storageManager";
        }
        String str4 = "getEnumType";
        String str5 = "getArrayType";
        final String str6 = "getPrimitiveArrayKotlinType";
        final String str7 = "getArrayElementType";
        final String str8 = "getPrimitiveKotlinType";
        final String str9 = "getBuiltInTypeByClassName";
        final String str10 = "getBuiltInClassByName";
        final String str11 = "getBuiltInClassByFqName";
        final int i5 = 1;
        switch (i) {
            case 2:
                arr[i5] = "getAdditionalClassPartsProvider";
                break;
            case 3:
                arr[i5] = "getPlatformDependentDeclarationFilter";
                break;
            case 4:
                arr[i5] = "getClassDescriptorFactories";
                break;
            case 5:
                arr[i5] = "getStorageManager";
                break;
            case 6:
                arr[i5] = "getBuiltInsModule";
                break;
            case 7:
                arr[i5] = "getBuiltInPackagesImportedByDefault";
                break;
            case 8:
                arr[i5] = str2;
                break;
            case 9:
                arr[i5] = "getBuiltInsPackageScope";
                break;
            case 10:
                arr[i5] = str11;
                break;
            case 11:
                arr[i5] = str10;
                break;
            case 12:
                arr[i5] = "getSuspendFunction";
                break;
            case 13:
                arr[i5] = "getKFunction";
                break;
            case 14:
                arr[i5] = "getKSuspendFunction";
                break;
            case 15:
                arr[i5] = "getKClass";
                break;
            case 16:
                arr[i5] = "getKCallable";
                break;
            case 17:
                arr[i5] = "getKProperty";
                break;
            case 18:
                arr[i5] = "getKProperty0";
                break;
            case 19:
                arr[i5] = "getKProperty1";
                break;
            case 20:
                arr[i5] = "getKProperty2";
                break;
            case 21:
                arr[i5] = "getKMutableProperty0";
                break;
            case 22:
                arr[i5] = "getKMutableProperty1";
                break;
            case 23:
                arr[i5] = "getKMutableProperty2";
                break;
            case 24:
                arr[i5] = "getIterator";
                break;
            case 25:
                arr[i5] = "getIterable";
                break;
            case 26:
                arr[i5] = "getMutableIterable";
                break;
            case 27:
                arr[i5] = "getMutableIterator";
                break;
            case 28:
                arr[i5] = "getCollection";
                break;
            case 29:
                arr[i5] = "getMutableCollection";
                break;
            case 30:
                arr[i5] = "getList";
                break;
            case 31:
                arr[i5] = "getMutableList";
                break;
            case 32:
                arr[i5] = "getSet";
                break;
            case 33:
                arr[i5] = "getMutableSet";
                break;
            case 34:
                arr[i5] = "getMap";
                break;
            case 35:
                arr[i5] = "getMutableMap";
                break;
            case 36:
                arr[i5] = "getMapEntry";
                break;
            case 37:
                arr[i5] = "getMutableMapEntry";
                break;
            case 38:
                arr[i5] = "getListIterator";
                break;
            case 39:
                arr[i5] = "getMutableListIterator";
                break;
            case 40:
                arr[i5] = str9;
                break;
            case 41:
                arr[i5] = "getNothingType";
                break;
            case 42:
                arr[i5] = "getNullableNothingType";
                break;
            case 43:
                arr[i5] = "getAnyType";
                break;
            case 44:
                arr[i5] = "getNullableAnyType";
                break;
            case 45:
                arr[i5] = "getDefaultBound";
                break;
            case 46:
                arr[i5] = str8;
                break;
            case 47:
                arr[i5] = "getNumberType";
                break;
            case 48:
                arr[i5] = "getByteType";
                break;
            case 49:
                arr[i5] = "getShortType";
                break;
            case 50:
                arr[i5] = "getIntType";
                break;
            case 51:
                arr[i5] = "getLongType";
                break;
            case 52:
                arr[i5] = "getFloatType";
                break;
            case 53:
                arr[i5] = "getDoubleType";
                break;
            case 54:
                arr[i5] = "getCharType";
                break;
            case 55:
                arr[i5] = "getBooleanType";
                break;
            case 56:
                arr[i5] = "getUnitType";
                break;
            case 57:
                arr[i5] = "getStringType";
                break;
            case 58:
                arr[i5] = "getIterableType";
                break;
            case 59:
                arr[i5] = str7;
                break;
            case 60:
                arr[i5] = str6;
                break;
            case 61:
                arr[i5] = str5;
                break;
            case 62:
                arr[i5] = str4;
                break;
            default:
                arr[i5] = "getAnnotationType";
        }
        switch (i) {
            case 1:
                arr[i3] = "setBuiltInsModule";
                break;
            case 3:
                arr[i3] = "isBuiltIn";
                break;
            case 4:
                arr[i3] = "isUnderKotlinPackage";
                break;
            case 5:
                arr[i3] = str11;
                break;
            case 6:
                arr[i3] = str10;
                break;
            case 7:
                arr[i3] = "getPrimitiveClassDescriptor";
                break;
            case 8:
                arr[i3] = "getPrimitiveArrayClassDescriptor";
                break;
            case 9:
                arr[i3] = str9;
                break;
            case 10:
                arr[i3] = str8;
                break;
            case 11:
                arr[i3] = str7;
                break;
            case 12:
                arr[i3] = "getElementTypeForUnsignedArray";
                break;
            case 13:
                arr[i3] = str6;
                break;
            case 14:
                arr[i3] = "getPrimitiveArrayKotlinTypeByPrimitiveKotlinType";
                break;
            case 15:
                arr[i3] = "getPrimitiveType";
                break;
            case 16:
                arr[i3] = "getPrimitiveArrayType";
                break;
            case 17:
                arr[i3] = str5;
                break;
            case 18:
                arr[i3] = str4;
                break;
            case 19:
                arr[i3] = "isArray";
                break;
            case 20:
                arr[i3] = "isArrayOrPrimitiveArray";
                break;
            case 21:
                arr[i3] = "isPrimitiveArray";
                break;
            case 22:
                arr[i3] = "getPrimitiveArrayElementType";
                break;
            case 23:
                arr[i3] = "isPrimitiveType";
                break;
            case 24:
                arr[i3] = "isPrimitiveTypeOrNullablePrimitiveType";
                break;
            case 25:
                arr[i3] = "isPrimitiveClass";
                break;
            case 26:
                arr[i3] = "isConstructedFromGivenClass";
                break;
            case 27:
                arr[i3] = "isTypeConstructorForGivenClass";
                break;
            case 28:
                arr[i3] = "classFqNameEquals";
                break;
            case 29:
                arr[i3] = "isNotNullConstructedFromGivenClass";
                break;
            case 30:
                arr[i3] = "isSpecialClassWithNoSupertypes";
                break;
            case 31:
                arr[i3] = "isAny";
                break;
            case 32:
                arr[i3] = "isBoolean";
                break;
            case 33:
                arr[i3] = "isBooleanOrNullableBoolean";
                break;
            case 34:
                arr[i3] = "isNumber";
                break;
            case 35:
                arr[i3] = "isChar";
                break;
            case 36:
                arr[i3] = "isCharOrNullableChar";
                break;
            case 37:
                arr[i3] = "isInt";
                break;
            case 38:
                arr[i3] = "isByte";
                break;
            case 39:
                arr[i3] = "isLong";
                break;
            case 40:
                arr[i3] = "isLongOrNullableLong";
                break;
            case 41:
                arr[i3] = "isShort";
                break;
            case 42:
                arr[i3] = "isFloat";
                break;
            case 43:
                arr[i3] = "isFloatOrNullableFloat";
                break;
            case 44:
                arr[i3] = "isDouble";
                break;
            case 45:
                arr[i3] = "isUByte";
                break;
            case 46:
                arr[i3] = "isUShort";
                break;
            case 47:
                arr[i3] = "isUInt";
                break;
            case 48:
                arr[i3] = "isULong";
                break;
            case 49:
                arr[i3] = "isUByteArray";
                break;
            case 50:
                arr[i3] = "isUShortArray";
                break;
            case 51:
                arr[i3] = "isUIntArray";
                break;
            case 52:
                arr[i3] = "isULongArray";
                break;
            case 53:
                arr[i3] = "isUnsignedArrayType";
                break;
            case 54:
                arr[i3] = "isDoubleOrNullableDouble";
                break;
            case 55:
                arr[i3] = "isConstructedFromGivenClassAndNotNullable";
                break;
            case 56:
                arr[i3] = "isNothing";
                break;
            case 57:
                arr[i3] = "isNullableNothing";
                break;
            case 58:
                arr[i3] = "isNothingOrNullableNothing";
                break;
            case 59:
                arr[i3] = "isAnyOrNullableAny";
                break;
            case 60:
                arr[i3] = "isNullableAny";
                break;
            case 61:
                arr[i3] = "isDefaultBound";
                break;
            case 62:
                arr[i3] = "isUnit";
                break;
            case 63:
                arr[i3] = "isUnitOrNullableUnit";
                break;
            case 64:
                arr[i3] = "isBooleanOrSubtype";
                break;
            case 65:
                arr[i3] = "isMemberOfAny";
                break;
            case 66:
                arr[i3] = "isEnum";
                break;
            case 67:
                arr[i3] = "isComparable";
                break;
            case 68:
                arr[i3] = "isCollectionOrNullableCollection";
                break;
            case 69:
                arr[i3] = "isListOrNullableList";
                break;
            case 70:
                arr[i3] = "isSetOrNullableSet";
                break;
            case 71:
                arr[i3] = "isMapOrNullableMap";
                break;
            case 72:
                arr[i3] = "isIterableOrNullableIterable";
                break;
            case 73:
                arr[i3] = "isThrowableOrNullableThrowable";
                break;
            case 74:
                arr[i3] = "isKClass";
                break;
            case 75:
                arr[i3] = "isNonPrimitiveArray";
                break;
            case 76:
                arr[i3] = "isCloneable";
                break;
            case 77:
                arr[i3] = "isDeprecated";
                break;
            case 78:
                arr[i3] = "isNotNullOrNullableFunctionSupertype";
                break;
            default:
                arr[i3] = "<init>";
        }
        if (/* condition */) {
            obj13 = new IllegalStateException(format);
        } else {
            obj13 = new IllegalArgumentException(format);
        }
        throw obj13;
    }

    public static boolean a0(b0 b0) {
        if (b0 == null) {
        } else {
            return h.h0(b0, k.a.b);
        }
        h.a(138);
        throw 0;
    }

    static x b(kotlin.i0.z.e.m0.b.h h) {
        return h.a;
    }

    public static boolean b0(b0 b0) {
        if (b0 == null) {
        } else {
            return h.h0(b0, k.a.h);
        }
        h.a(87);
        throw 0;
    }

    static x c(kotlin.i0.z.e.m0.b.h h, x x2) {
        h.a = x2;
        return x2;
    }

    public static boolean c0(e e) {
        int obj1;
        if (e == null) {
        } else {
            if (!h.e(e, k.a.h)) {
                if (h.O(e) != null) {
                    obj1 = 1;
                } else {
                    obj1 = 0;
                }
            } else {
            }
            return obj1;
        }
        h.a(88);
        throw 0;
    }

    static i0 d(kotlin.i0.z.e.m0.b.h h, String string2) {
        return h.q(string2);
    }

    public static boolean d0(b0 b0) {
        if (b0 == null) {
        } else {
            return h.i0(b0, k.a.i);
        }
        h.a(109);
        throw 0;
    }

    private static boolean e(h h, c c2) {
        int obj2;
        int i = 0;
        if (h == null) {
        } else {
            if (c2 == null) {
            } else {
                if (h.getName().equals(c2.i()) && c2.equals(d.m(h))) {
                    obj2 = c2.equals(d.m(h)) ? 1 : 0;
                } else {
                }
                return obj2;
            }
            h.a(103);
            throw i;
        }
        h.a(102);
        throw i;
    }

    public static boolean e0(m m) {
        int i;
        if (m == null) {
        } else {
            if (d.r(m, b.class, false) != null) {
                i = 1;
            }
            return i;
        }
        h.a(8);
        throw 0;
    }

    public static boolean f0(b0 b0) {
        if (b0 == null) {
        } else {
            return h.i0(b0, k.a.k);
        }
        h.a(116);
        throw 0;
    }

    public static boolean g0(b0 b0) {
        if (b0 == null) {
        } else {
            return h.i0(b0, k.a.j);
        }
        h.a(113);
        throw 0;
    }

    private static boolean h0(b0 b0, c c2) {
        final int i = 0;
        if (b0 == null) {
        } else {
            if (c2 == null) {
            } else {
                return h.D0(b0.L0(), c2);
            }
            h.a(97);
            throw i;
        }
        h.a(96);
        throw i;
    }

    private static boolean i0(b0 b0, c c2) {
        int obj1;
        final int i = 0;
        if (b0 == null) {
        } else {
            if (c2 == null) {
            } else {
                if (h.h0(b0, c2) && !b0.M0()) {
                    obj1 = !b0.M0() ? 1 : 0;
                } else {
                }
                return obj1;
            }
            h.a(134);
            throw i;
        }
        h.a(133);
        throw i;
    }

    public static boolean j0(b0 b0) {
        if (b0 == null) {
        } else {
            return h.v0(b0);
        }
        h.a(140);
        throw 0;
    }

    public static boolean k0(m m) {
        int i;
        kotlin.reflect.jvm.internal.impl.descriptors.p0 getter;
        kotlin.reflect.jvm.internal.impl.descriptors.q0 obj4;
        if (m == null) {
        } else {
            if (m.a().getAnnotations().u1(k.a.u)) {
                return 1;
            }
            final int i2 = 0;
            if (m instanceof o0) {
                getter = m.getGetter();
                obj4 = m.getSetter();
                if (getter != null && h.k0(getter)) {
                    if (h.k0(getter)) {
                        if ((o0)m.j0()) {
                            if (obj4 != null && h.k0(obj4)) {
                                if (h.k0(obj4)) {
                                } else {
                                    i = i2;
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                } else {
                }
                return i;
            }
            return i2;
        }
        h.a(158);
        throw 0;
    }

    public static boolean l0(b0 b0) {
        int obj1;
        if (b0 == null) {
        } else {
            if (h.m0(b0) && !b0.M0()) {
                obj1 = !b0.M0() ? 1 : 0;
            } else {
            }
            return obj1;
        }
        h.a(122);
        throw 0;
    }

    public static boolean m0(b0 b0) {
        if (b0 == null) {
        } else {
            return h.h0(b0, k.a.p);
        }
        h.a(132);
        throw 0;
    }

    public static boolean n0(b0 b0) {
        int obj1;
        if (b0 == null) {
        } else {
            if (h.o0(b0) && !b0.M0()) {
                obj1 = !b0.M0() ? 1 : 0;
            } else {
            }
            return obj1;
        }
        h.a(120);
        throw 0;
    }

    public static boolean o0(b0 b0) {
        if (b0 == null) {
        } else {
            return h.h0(b0, k.a.o);
        }
        h.a(121);
        throw 0;
    }

    private e p(String string) {
        final int i = 0;
        if (string == null) {
        } else {
            Object obj3 = this.c.invoke(e.j(string));
            if ((e)obj3 == null) {
            } else {
                return (e)obj3;
            }
            h.a(14);
            throw i;
        }
        h.a(13);
        throw i;
    }

    public static boolean p0(b0 b0) {
        if (b0 == null) {
        } else {
            return h.i0(b0, k.a.m);
        }
        h.a(115);
        throw 0;
    }

    private i0 q(String string) {
        final int i = 0;
        if (string == null) {
        } else {
            i0 obj2 = p(string).q();
            if (obj2 == null) {
            } else {
                return obj2;
            }
            h.a(46);
            throw i;
        }
        h.a(45);
        throw i;
    }

    public static boolean q0(e e) {
        if (e == null) {
        } else {
            return h.e(e, k.a.X);
        }
        h.a(155);
        throw 0;
    }

    public static boolean r0(b0 b0) {
        if (b0 == null) {
        } else {
            return h.i0(b0, k.a.n);
        }
        h.a(117);
        throw 0;
    }

    private static boolean s0(b0 b0, c c2) {
        int obj1;
        int i = 0;
        if (b0 == null) {
        } else {
            if (c2 == null) {
            } else {
                if (!b0.M0() && h.h0(b0, c2)) {
                    obj1 = h.h0(b0, c2) ? 1 : 0;
                } else {
                }
                return obj1;
            }
            h.a(105);
            throw i;
        }
        h.a(104);
        throw i;
    }

    public static boolean t0(b0 b0) {
        int obj1;
        if (b0 == null) {
        } else {
            if (h.u0(b0) && !c1.l(b0)) {
                obj1 = !c1.l(b0) ? 1 : 0;
            } else {
            }
            return obj1;
        }
        h.a(135);
        throw 0;
    }

    public static boolean u0(b0 b0) {
        if (b0 == null) {
        } else {
            return h.h0(b0, k.a.c);
        }
        h.a(137);
        throw 0;
    }

    public static boolean v0(b0 b0) {
        int obj1;
        if (b0 == null) {
        } else {
            if (h.a0(b0) && b0.M0()) {
                obj1 = b0.M0() ? 1 : 0;
            } else {
            }
            return obj1;
        }
        h.a(139);
        throw 0;
    }

    public static boolean w0(b0 b0) {
        int obj0;
        if (b0 == null) {
        } else {
            obj0 = b0.L0().c();
            if (obj0 != null && h.O(obj0) != null) {
                obj0 = h.O(obj0) != null ? 1 : 0;
            } else {
            }
            return obj0;
        }
        h.a(90);
        throw 0;
    }

    public static boolean x0(e e) {
        int obj0;
        if (e == null) {
        } else {
            obj0 = h.R(e) != null ? 1 : 0;
            return obj0;
        }
        h.a(95);
        throw 0;
    }

    public static boolean y0(b0 b0) {
        int obj1;
        if (b0 == null) {
        } else {
            if (!b0.M0() && h.z0(b0)) {
                obj1 = h.z0(b0) ? 1 : 0;
            } else {
            }
            return obj1;
        }
        h.a(93);
        throw 0;
    }

    public static boolean z0(b0 b0) {
        int obj1;
        if (b0 == null) {
        } else {
            obj1 = b0.L0().c();
            if (obj1 instanceof e && h.x0((e)obj1)) {
                obj1 = h.x0((e)obj1) ? 1 : 0;
            } else {
            }
            return obj1;
        }
        h.a(94);
        throw 0;
    }

    public i0 B() {
        i0 i0Var = Q(i.FLOAT);
        if (i0Var == null) {
        } else {
            return i0Var;
        }
        h.a(59);
        throw 0;
    }

    public e C(int i) {
        return p(k.b(i));
    }

    public i0 D() {
        i0 i0Var = Q(i.INT);
        if (i0Var == null) {
        } else {
            return i0Var;
        }
        h.a(57);
        throw 0;
    }

    public e E() {
        e eVar = o(k.a.X.l());
        if (eVar == null) {
        } else {
            return eVar;
        }
        h.a(20);
        throw 0;
    }

    public i0 F() {
        i0 i0Var = Q(i.LONG);
        if (i0Var == null) {
        } else {
            return i0Var;
        }
        h.a(58);
        throw 0;
    }

    public e G() {
        return p("Nothing");
    }

    public i0 H() {
        i0 i0Var = G().q();
        if (i0Var == null) {
        } else {
            return i0Var;
        }
        h.a(47);
        throw 0;
    }

    public i0 I() {
        i0 i0Var2 = i().S0(true);
        if (i0Var2 == null) {
        } else {
            return i0Var2;
        }
        h.a(50);
        throw 0;
    }

    public i0 J() {
        i0 i0Var2 = H().S0(true);
        if (i0Var2 == null) {
        } else {
            return i0Var2;
        }
        h.a(48);
        throw 0;
    }

    public e K() {
        return p("Number");
    }

    public i0 L() {
        i0 i0Var = K().q();
        if (i0Var == null) {
        } else {
            return i0Var;
        }
        h.a(54);
        throw 0;
    }

    public void L0(x x) {
        if (x == null) {
        } else {
            h.d dVar = new h.d(this, x);
            this.d.e(dVar);
        }
        h.a(1);
        throw 0;
    }

    protected c M() {
        c.b bVar = c.b.a;
        if (bVar == null) {
        } else {
            return bVar;
        }
        h.a(3);
        throw 0;
    }

    public i0 N(kotlin.i0.z.e.m0.b.i i) {
        final int i2 = 0;
        if (i == null) {
        } else {
            Object obj3 = invoke.a.get(i);
            if ((i0)obj3 == null) {
            } else {
                return (i0)obj3;
            }
            h.a(73);
            throw i2;
        }
        h.a(72);
        throw i2;
    }

    public i0 Q(kotlin.i0.z.e.m0.b.i i) {
        final int i2 = 0;
        if (i == null) {
        } else {
            i0 obj2 = P(i).q();
            if (obj2 == null) {
            } else {
                return obj2;
            }
            h.a(53);
            throw i2;
        }
        h.a(52);
        throw i2;
    }

    public i0 S() {
        i0 i0Var = Q(i.SHORT);
        if (i0Var == null) {
        } else {
            return i0Var;
        }
        h.a(56);
        throw 0;
    }

    protected n T() {
        n nVar = this.d;
        if (nVar == null) {
        } else {
            return nVar;
        }
        h.a(5);
        throw 0;
    }

    public e U() {
        return p("String");
    }

    public i0 V() {
        i0 i0Var = U().q();
        if (i0Var == null) {
        } else {
            return i0Var;
        }
        h.a(64);
        throw 0;
    }

    public e W(int i) {
        e obj2 = o(k.d.c(e.j(k.d(i))));
        if (obj2 == null) {
        } else {
            return obj2;
        }
        h.a(17);
        throw 0;
    }

    public e X() {
        return p("Unit");
    }

    public i0 Y() {
        i0 i0Var = X().q();
        if (i0Var == null) {
        } else {
            return i0Var;
        }
        h.a(63);
        throw 0;
    }

    protected void f(boolean z) {
        x xVar = new x(h.e, this.d, this, 0);
        this.a = xVar;
        xVar.Q0(a.a.a().a(this.d, this.a, v(), M(), g(), z));
        x obj10 = this.a;
        x[] arr = new x[1];
        obj10.W0(obj10);
    }

    protected a g() {
        a.a aVar = a.a.a;
        if (aVar == null) {
        } else {
            return aVar;
        }
        h.a(2);
        throw 0;
    }

    public e h() {
        return p("Any");
    }

    public i0 i() {
        i0 i0Var = h().q();
        if (i0Var == null) {
        } else {
            return i0Var;
        }
        h.a(49);
        throw 0;
    }

    public e j() {
        return p("Array");
    }

    public b0 k(b0 b0) {
        b0 b0Var;
        int i = 0;
        if (b0 == null) {
        } else {
            if (h.b0(b0)) {
                if (b0.K0().size() != 1) {
                } else {
                    b0 obj4 = (v0)b0.K0().get(0).getType();
                    if (obj4 == null) {
                    } else {
                        return obj4;
                    }
                    h.a(67);
                    throw i;
                }
                obj4 = new IllegalStateException();
                throw obj4;
            }
            b0Var = c1.n(b0);
            Object obj = invoke.c.get(b0Var);
            if ((b0)obj != null) {
                if ((b0)obj == null) {
                } else {
                    return (b0)obj;
                }
                h.a(68);
                throw i;
            }
            c0 c0Var = d.i(b0Var);
            if (c0Var == null) {
            } else {
                b0Var = h.A(b0Var, c0Var);
                if (b0Var == null) {
                } else {
                    if (b0Var == null) {
                    } else {
                        return b0Var;
                    }
                    h.a(69);
                    throw i;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("not array: ");
            stringBuilder.append(b0);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            throw illegalStateException;
        }
        h.a(66);
        throw i;
    }

    public i0 l(h1 h1, b0 b02) {
        final int i = 0;
        if (h1 == null) {
        } else {
            if (b02 == null) {
            } else {
                i0 obj3 = m(h1, b02, g.q.b());
                if (obj3 == null) {
                } else {
                    return obj3;
                }
                h.a(83);
                throw i;
            }
            h.a(82);
            throw i;
        }
        h.a(81);
        throw i;
    }

    public i0 m(h1 h1, b0 b02, g g3) {
        final int i = 0;
        if (h1 == null) {
        } else {
            if (b02 == null) {
            } else {
                if (g3 == null) {
                } else {
                    x0 x0Var = new x0(h1, b02);
                    i0 obj3 = c0.g(g3, j(), Collections.singletonList(x0Var));
                    if (obj3 == null) {
                    } else {
                        return obj3;
                    }
                    h.a(80);
                    throw i;
                }
                h.a(79);
                throw i;
            }
            h.a(78);
            throw i;
        }
        h.a(77);
        throw i;
    }

    public i0 n() {
        i0 i0Var = Q(i.BOOLEAN);
        if (i0Var == null) {
        } else {
            return i0Var;
        }
        h.a(62);
        throw 0;
    }

    public e o(b b) {
        final int i = 0;
        if (b == null) {
        } else {
            e obj4 = s.a(this.a, b, d.FROM_BUILTINS);
            if (obj4 == null) {
            } else {
                return obj4;
            }
            h.a(12);
            throw i;
        }
        h.a(11);
        throw i;
    }

    public x r() {
        x xVar = this.a;
        if (xVar == null) {
        } else {
            return xVar;
        }
        h.a(6);
        throw 0;
    }

    public h s() {
        h hVar = this.a.M(k.l).o();
        if (hVar == null) {
        } else {
            return hVar;
        }
        h.a(10);
        throw 0;
    }

    public i0 t() {
        i0 i0Var = Q(i.BYTE);
        if (i0Var == null) {
        } else {
            return i0Var;
        }
        h.a(55);
        throw 0;
    }

    public i0 u() {
        i0 i0Var = Q(i.CHAR);
        if (i0Var == null) {
        } else {
            return i0Var;
        }
        h.a(61);
        throw 0;
    }

    protected Iterable<b> v() {
        a aVar = new a(this.d, this.a);
        List singletonList = Collections.singletonList(aVar);
        if (singletonList == null) {
        } else {
            return singletonList;
        }
        h.a(4);
        throw 0;
    }

    public e w() {
        e eVar = o(k.a.J);
        if (eVar == null) {
        } else {
            return eVar;
        }
        h.a(33);
        throw 0;
    }

    public e x() {
        return p("Comparable");
    }

    public i0 y() {
        i0 i0Var = I();
        if (i0Var == null) {
        } else {
            return i0Var;
        }
        h.a(51);
        throw 0;
    }

    public i0 z() {
        i0 i0Var = Q(i.DOUBLE);
        if (i0Var == null) {
        } else {
            return i0Var;
        }
        h.a(60);
        throw 0;
    }
}
