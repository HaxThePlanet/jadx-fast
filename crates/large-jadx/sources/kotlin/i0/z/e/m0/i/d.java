package kotlin.i0.z.e.m0.i;

import android.app.ActivityManager.MemoryInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.b.o;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.c;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.f.g;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.c1;
import kotlin.i0.z.e.m0.l.d0;
import kotlin.i0.z.e.m0.l.j1.f;
import kotlin.i0.z.e.m0.l.t;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.b.a;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n0;
import kotlin.reflect.jvm.internal.impl.descriptors.p;
import kotlin.reflect.jvm.internal.impl.descriptors.q;
import kotlin.reflect.jvm.internal.impl.descriptors.r0;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.z;

/* loaded from: classes3.dex */
public class d {
    static {
        b bVar = new b("kotlin.jvm.JvmName");
    }

    public static boolean A(m m) {
        return d.D(m, f.ENUM_CLASS);
    }

    public static boolean B(m m) {
        if (m == null) {
        } else {
            return d.D(m, f.ENUM_ENTRY);
        }
        d.a(34);
        throw 0;
    }

    public static boolean C(m m) {
        return d.D(m, f.INTERFACE);
    }

    private static boolean D(m m, f f2) {
        int obj1;
        if (f2 == null) {
        } else {
            if (m instanceof e && (e)m.f() == f2) {
                obj1 = (e)m.f() == f2 ? 1 : 0;
            } else {
            }
            return obj1;
        }
        d.a(35);
        throw 0;
    }

    public static boolean E(m m) {
        boolean z;
        m obj2;
        final int i = 1;
        if (m == null) {
        }
        d.a(i);
        throw 0;
    }

    private static boolean F(b0 b0, m m2) {
        int i;
        h obj1;
        Object obj2;
        i = 0;
        if (b0 == null) {
        } else {
            if (m2 == null) {
            } else {
                obj1 = b0.L0().c();
                obj1 = obj1.a();
                if (obj1 != null && obj1 instanceof h && m2 instanceof h && (h)m2.g().equals((h)obj1.g())) {
                    obj1 = obj1.a();
                    if (obj1 instanceof h) {
                        if (m2 instanceof h) {
                            if ((h)m2.g().equals((h)obj1.g())) {
                                return 1;
                            }
                        }
                    }
                }
                return 0;
            }
            d.a(29);
            throw i;
        }
        d.a(28);
        throw i;
    }

    public static boolean G(m m) {
        boolean sEALED;
        int obj1;
        if (!d.D(m, f.CLASS)) {
            if (d.D(m, f.INTERFACE) && (e)m.i() == z.SEALED) {
                obj1 = (e)m.i() == z.SEALED ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj1;
    }

    public static boolean H(e e, e e2) {
        final int i = 0;
        if (e == null) {
        } else {
            if (e2 == null) {
            } else {
                return d.I(e.q(), e2.a());
            }
            d.a(27);
            throw i;
        }
        d.a(26);
        throw i;
    }

    public static boolean I(b0 b0, m m2) {
        boolean z;
        int i = 0;
        if (b0 == null) {
        } else {
            if (m2 == null) {
            } else {
                final int i2 = 1;
                if (d.F(b0, m2)) {
                    return i2;
                }
                Iterator obj2 = b0.L0().a().iterator();
                for (b0 next2 : obj2) {
                }
                return 0;
            }
            d.a(31);
            throw i;
        }
        d.a(30);
        throw i;
    }

    public static boolean J(m m) {
        boolean obj0;
        if (m && obj0 instanceof f0) {
            obj0 = obj0 instanceof f0 ? 1 : 0;
        } else {
        }
        return obj0;
    }

    public static boolean K(d1 d1, b0 b02) {
        boolean z;
        int i;
        int i2;
        boolean z2;
        h obj4;
        int i3 = 0;
        if (d1 == null) {
        } else {
            if (b02 == null) {
            } else {
                i = 0;
                if (!d1.j0()) {
                    if (d0.a(b02)) {
                    } else {
                        i2 = 1;
                        if (c1.b(b02)) {
                            return i2;
                        }
                        obj4 = a.g(d1);
                        z = f.a;
                        if (!h.y0(b02) && !z.b(obj4.V(), b02) && !z.b(obj4.K().q(), b02) && !z.b(obj4.i(), b02)) {
                            z = f.a;
                            if (!z.b(obj4.V(), b02)) {
                                if (!z.b(obj4.K().q(), b02)) {
                                    if (!z.b(obj4.i(), b02)) {
                                        obj4 = o.a;
                                        if (o.d(b02)) {
                                            i = i2;
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    }
                }
                return i;
            }
            d.a(62);
            throw i3;
        }
        d.a(61);
        throw i3;
    }

    public static <D extends b> D L(D d) {
        Collection collection;
        boolean empty;
        Object obj3;
        int i = 0;
        if (d == null) {
        }
        d.a(57);
        throw i;
    }

    public static <D extends q> D M(D d) {
        final int i = 0;
        if (d == null) {
        } else {
            if (d instanceof b) {
                return d.L((b)d);
            }
            if (d == null) {
            } else {
                return d;
            }
            d.a(60);
            throw i;
        }
        d.a(59);
        throw i;
    }

    private static void a(int i) {
        String str2;
        int i2;
        Object illegalStateException;
        int i3;
        String str3;
        String str;
        str2 = /* condition */ ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        i3 = /* condition */ ? i4 : 3;
        Object[] arr = new Object[i3];
        str3 = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
        int i5 = 0;
        switch (i) {
            case 1:
                arr[i5] = "descriptor";
                break;
            case 2:
                arr[i5] = str3;
                break;
            case 3:
                arr[i5] = "first";
                break;
            case 4:
                arr[i5] = "second";
                break;
            case 5:
                arr[i5] = "aClass";
                break;
            case 6:
                arr[i5] = "kotlinType";
                break;
            case 7:
                arr[i5] = "declarationDescriptor";
                break;
            case 8:
                arr[i5] = "subClass";
                break;
            case 9:
                arr[i5] = "superClass";
                break;
            case 10:
                arr[i5] = "type";
                break;
            case 11:
                arr[i5] = "other";
                break;
            case 12:
                arr[i5] = "classKind";
                break;
            case 13:
                arr[i5] = "classDescriptor";
                break;
            case 14:
                arr[i5] = "typeConstructor";
                break;
            case 15:
                arr[i5] = "innerClassName";
                break;
            case 16:
                arr[i5] = "location";
                break;
            case 17:
                arr[i5] = "variable";
                break;
            case 18:
                arr[i5] = "f";
                break;
            case 19:
                arr[i5] = "current";
                break;
            case 20:
                arr[i5] = "result";
                break;
            case 21:
                arr[i5] = "memberDescriptor";
                break;
            case 22:
                arr[i5] = "annotated";
                break;
            case 23:
                arr[i5] = "scope";
                break;
            case 24:
                arr[i5] = "name";
                break;
            default:
                arr[i5] = "containingDeclaration";
        }
        String str4 = "getDirectMember";
        String str5 = "getPropertyByName";
        final String str6 = "getFunctionByName";
        final String str7 = "getAllDescriptors";
        final String str8 = "getContainingSourceFile";
        final String str9 = "getAllOverriddenDeclarations";
        final String str10 = "getAllOverriddenDescriptors";
        final String str11 = "unwrapFakeOverrideToAnyDeclaration";
        final String str12 = "unwrapFakeOverride";
        final String str13 = "getDefaultConstructorVisibility";
        final String str14 = "getClassDescriptorForTypeConstructor";
        final String str15 = "getSuperClassType";
        final String str16 = "getSuperclassDescriptors";
        final String str17 = "getContainingModule";
        final String str18 = "getFqNameFromTopLevelClass";
        final String str19 = "getFqNameUnsafe";
        final String str20 = "getFqNameSafe";
        final int i6 = 1;
        switch (i) {
            case 4:
                arr[i6] = str20;
                break;
            case 7:
                arr[i6] = str19;
                break;
            case 9:
                arr[i6] = str18;
                break;
            case 10:
                arr[i6] = str17;
                break;
            case 20:
                arr[i6] = str16;
                break;
            case 38:
                arr[i6] = str15;
                break;
            case 40:
                arr[i6] = str14;
                break;
            case 41:
                arr[i6] = str13;
                break;
            case 45:
                arr[i6] = str12;
                break;
            case 47:
                arr[i6] = str11;
                break;
            case 48:
                arr[i6] = str10;
                break;
            case 49:
                arr[i6] = str9;
                break;
            case 50:
                arr[i6] = str8;
                break;
            case 51:
                arr[i6] = str7;
                break;
            case 58:
                arr[i6] = str6;
                break;
            case 60:
                arr[i6] = str5;
                break;
            case 67:
                arr[i6] = str4;
                break;
            default:
                arr[i6] = str3;
        }
        switch (i) {
            case 1:
                arr[i4] = "isLocal";
                break;
            case 2:
                arr[i4] = "getFqName";
                break;
            case 3:
                arr[i4] = str20;
                break;
            case 5:
                arr[i4] = "getFqNameSafeIfPossible";
                break;
            case 6:
                arr[i4] = str19;
                break;
            case 7:
                arr[i4] = str18;
                break;
            case 8:
                arr[i4] = "isExtension";
                break;
            case 9:
                arr[i4] = "isOverride";
                break;
            case 10:
                arr[i4] = "isStaticDeclaration";
                break;
            case 11:
                arr[i4] = "areInSameModule";
                break;
            case 12:
                arr[i4] = "getParentOfType";
                break;
            case 13:
                arr[i4] = "getContainingModuleOrNull";
                break;
            case 14:
                arr[i4] = str17;
                break;
            case 15:
                arr[i4] = "getContainingClass";
                break;
            case 16:
                arr[i4] = "isAncestor";
                break;
            case 17:
                arr[i4] = "isDirectSubclass";
                break;
            case 18:
                arr[i4] = "isSubclass";
                break;
            case 19:
                arr[i4] = "isSameClass";
                break;
            case 20:
                arr[i4] = "isSubtypeOfClass";
                break;
            case 21:
                arr[i4] = "isAnonymousObject";
                break;
            case 22:
                arr[i4] = "isAnonymousFunction";
                break;
            case 23:
                arr[i4] = "isEnumEntry";
                break;
            case 24:
                arr[i4] = "isKindOf";
                break;
            case 25:
                arr[i4] = "hasAbstractMembers";
                break;
            case 26:
                arr[i4] = str16;
                break;
            case 27:
                arr[i4] = str15;
                break;
            case 28:
                arr[i4] = "getSuperClassDescriptor";
                break;
            case 29:
                arr[i4] = "getClassDescriptorForType";
                break;
            case 30:
                arr[i4] = str14;
                break;
            case 31:
                arr[i4] = str13;
                break;
            case 32:
                arr[i4] = "getInnerClassByName";
                break;
            case 33:
                arr[i4] = "isStaticNestedClass";
                break;
            case 34:
                arr[i4] = "isTopLevelOrInnerClass";
                break;
            case 35:
                arr[i4] = str12;
                break;
            case 36:
                arr[i4] = str11;
                break;
            case 37:
                arr[i4] = "shouldRecordInitializerForProperty";
                break;
            case 38:
                arr[i4] = "classCanHaveAbstractFakeOverride";
                break;
            case 39:
                arr[i4] = "classCanHaveAbstractDeclaration";
                break;
            case 40:
                arr[i4] = "classCanHaveOpenMembers";
                break;
            case 41:
                arr[i4] = str10;
                break;
            case 42:
                arr[i4] = "collectAllOverriddenDescriptors";
                break;
            case 43:
                arr[i4] = str9;
                break;
            case 44:
                arr[i4] = "isSingletonOrAnonymousObject";
                break;
            case 45:
                arr[i4] = "canHaveDeclaredConstructors";
                break;
            case 46:
                arr[i4] = "getJvmName";
                break;
            case 47:
                arr[i4] = "findJvmNameAnnotation";
                break;
            case 48:
                arr[i4] = "hasJvmNameAnnotation";
                break;
            case 49:
                arr[i4] = str8;
                break;
            case 50:
                arr[i4] = str7;
                break;
            case 51:
                arr[i4] = str6;
                break;
            case 52:
                arr[i4] = "getFunctionByNameOrNull";
                break;
            case 53:
                arr[i4] = str5;
                break;
            case 54:
                arr[i4] = str4;
                break;
            case 55:
                arr[i4] = "isMethodOfAny";
                break;
            default:
                arr[i4] = "getDispatchReceiverParameterIfNeeded";
        }
        if (/* condition */) {
            illegalStateException = new IllegalStateException(format);
        } else {
            illegalStateException = new IllegalArgumentException(format);
        }
        throw illegalStateException;
    }

    public static boolean b(m m, m m2) {
        final int i = 0;
        if (m == null) {
        } else {
            if (m2 == null) {
            } else {
                return d.g(m).equals(d.g(m2));
            }
            d.a(15);
            throw i;
        }
        d.a(14);
        throw i;
    }

    private static <D extends a> void c(D d, Set<D> set2) {
        boolean contains;
        int i = 0;
        if (d == null) {
        } else {
            if (set2 == null) {
            } else {
                if (set2.contains(d)) {
                }
                Iterator obj1 = d.a().e().iterator();
                for (a next2 : obj1) {
                    contains = next2.a();
                    d.c(contains, set2);
                    set2.add(contains);
                }
            }
            d.a(69);
            throw i;
        }
        d.a(68);
        throw i;
    }

    public static <D extends a> Set<D> d(D d) {
        if (d == 0) {
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            d.c(d.a(), linkedHashSet);
            return linkedHashSet;
        }
        d.a(66);
        throw 0;
    }

    public static e e(b0 b0) {
        if (b0 == null) {
        } else {
            return d.f(b0.L0());
        }
        d.a(43);
        throw 0;
    }

    public static e f(t0 t0) {
        final int i = 0;
        if (t0 == null) {
        } else {
            h obj1 = t0.c();
            if ((e)obj1 == null) {
            } else {
                return (e)obj1;
            }
            d.a(45);
            throw i;
        }
        d.a(44);
        throw i;
    }

    public static c0 g(m m) {
        final int i = 0;
        if (m == null) {
        } else {
            c0 obj1 = d.h(m);
            if (obj1 == null) {
            } else {
                return obj1;
            }
            d.a(20);
            throw i;
        }
        d.a(19);
        throw i;
    }

    public static c0 h(m m) {
        boolean z;
        Object obj2;
        final int i = 0;
        if (m == null) {
        }
        d.a(21);
        throw i;
    }

    public static c0 i(b0 b0) {
        final int i = 0;
        if (b0 == null) {
        } else {
            h obj1 = b0.L0().c();
            if (obj1 == null) {
                return i;
            }
            return d.h(obj1);
        }
        d.a(18);
        throw i;
    }

    public static v0 j(m m) {
        Object obj2;
        final int i = 0;
        if (m == null) {
        } else {
            if (m instanceof q0) {
                obj2 = (q0)m.y0();
            }
            if (obj2 instanceof p) {
                obj2 = (p)obj2.getSource().a();
                if (obj2 == null) {
                } else {
                    return obj2;
                }
                d.a(78);
                throw i;
            }
            obj2 = v0.a;
            if (obj2 == null) {
            } else {
                return obj2;
            }
            d.a(79);
            throw i;
        }
        d.a(77);
        throw i;
    }

    public static u k(e e, boolean z2) {
        f singleton;
        final int i = 0;
        if (e == null) {
        } else {
            singleton = e.f();
            if (singleton != f.ENUM_CLASS) {
                if (singleton.isSingleton()) {
                } else {
                    if (d.G(e) && z2) {
                        if (z2) {
                            u obj3 = t.d;
                            if (obj3 == null) {
                            } else {
                                return obj3;
                            }
                            d.a(48);
                            throw i;
                        }
                        obj3 = t.a;
                        if (obj3 == null) {
                        } else {
                            return obj3;
                        }
                        d.a(49);
                        throw i;
                    }
                    if (d.u(e)) {
                        obj3 = t.k;
                        if (obj3 == null) {
                        } else {
                            return obj3;
                        }
                        d.a(50);
                        throw i;
                    }
                    obj3 = t.e;
                    if (obj3 == null) {
                    } else {
                        return obj3;
                    }
                }
                d.a(51);
                throw i;
            }
            obj3 = t.a;
            if (obj3 == null) {
            } else {
                return obj3;
            }
            d.a(47);
            throw i;
        }
        d.a(46);
        throw i;
    }

    public static r0 l(m m) {
        final int i = 0;
        if (m == null) {
        } else {
            if (m instanceof e) {
                return (e)m.I0();
            }
            return i;
        }
        d.a(0);
        throw i;
    }

    public static c m(m m) {
        c obj1;
        if (m == null) {
        } else {
            final b bVar = d.o(m);
            if (bVar != null) {
                obj1 = bVar.j();
            } else {
                obj1 = d.p(m);
            }
            return obj1;
        }
        d.a(2);
        throw 0;
    }

    public static b n(m m) {
        b bVar;
        Object obj2;
        final int i = 0;
        if (m == null) {
        } else {
            if (d.o(m) != null) {
            } else {
                bVar = d.p(m).l();
            }
            if (bVar == null) {
            } else {
                return bVar;
            }
            d.a(4);
            throw i;
        }
        d.a(3);
        throw i;
    }

    private static b o(m m) {
        boolean z;
        final int i = 0;
        if (m == null) {
        } else {
            if (!m instanceof c0) {
                if (t.r(m)) {
                } else {
                    if (m instanceof k0) {
                        return (k0)m.d();
                    }
                    if (m instanceof f0) {
                        return (f0)m.d();
                    }
                }
                return i;
            }
            return b.c;
        }
        d.a(5);
        throw i;
    }

    private static c p(m m) {
        final int i = 0;
        if (m == null) {
        } else {
            c obj2 = d.m(m.b()).c(m.getName());
            if (obj2 == null) {
            } else {
                return obj2;
            }
            d.a(7);
            throw i;
        }
        d.a(6);
        throw i;
    }

    public static <D extends m> D q(m m, Class<D> class2) {
        if (class2 == null) {
        } else {
            return d.r(m, class2, true);
        }
        d.a(16);
        throw 0;
    }

    public static <D extends m> D r(m m, Class<D> class2, boolean z3) {
        m obj1;
        boolean obj3;
        final int i = 0;
        if (class2 == null) {
        } else {
            if (m == null) {
                return i;
            }
            if (z3) {
                obj1 = m.b();
            }
            while (obj1 != null) {
                obj1 = obj1.b();
            }
            return i;
        }
        d.a(17);
        throw i;
    }

    public static e s(e e) {
        e eVar;
        f fVar;
        f iNTERFACE;
        final int i = 0;
        if (e == null) {
        } else {
            Iterator obj4 = e.g().a().iterator();
            for (b0 next2 : obj4) {
                eVar = d.e(next2);
            }
            return i;
        }
        d.a(42);
        throw i;
    }

    public static boolean t(m m) {
        return d.D(m, f.ANNOTATION_CLASS);
    }

    public static boolean u(m m) {
        boolean z;
        int obj1;
        if (m == null) {
        } else {
            if (d.v(m) && m.getName().equals(g.a)) {
                obj1 = m.getName().equals(g.a) ? 1 : 0;
            } else {
            }
            return obj1;
        }
        d.a(32);
        throw 0;
    }

    public static boolean v(m m) {
        return d.D(m, f.CLASS);
    }

    public static boolean w(m m) {
        int obj1;
        if (!d.v(m)) {
            if (d.A(m)) {
                obj1 = 1;
            } else {
                obj1 = 0;
            }
        } else {
        }
        return obj1;
    }

    public static boolean x(m m) {
        m obj1;
        if (d.D(m, f.OBJECT) && (e)m.x()) {
            obj1 = (e)m.x() ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static boolean y(m m) {
        boolean z;
        Object obj1;
        if (m instanceof q && (q)m.getVisibility() == t.f) {
            obj1 = (q)m.getVisibility() == t.f ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static boolean z(e e, e e2) {
        int i;
        e eVar;
        i = 0;
        if (e == null) {
        } else {
            if (e2 == null) {
            } else {
                Iterator obj2 = e.g().a().iterator();
                for (b0 next2 : obj2) {
                }
                return 0;
            }
            d.a(25);
            throw i;
        }
        d.a(24);
        throw i;
    }
}
