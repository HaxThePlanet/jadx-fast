package kotlin.i0.z.e.m0.l;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.e;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.j0;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* loaded from: classes3.dex */
public class o {
    private static void a(int i) {
        String str;
        int i2;
        String str2;
        Object obj7;
        final int i4 = 4;
        str = i != i4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        final int i5 = 2;
        i2 = i != i4 ? 3 : i5;
        Object[] arr = new Object[i2];
        final String str3 = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
        int i6 = 0;
        switch (i) {
            case 1:
                arr[i6] = "originalSubstitution";
                break;
            case 2:
                arr[i6] = "newContainingDeclaration";
                break;
            case 3:
                arr[i6] = "result";
                break;
            case 4:
                arr[i6] = str3;
                break;
            default:
                arr[i6] = "typeParameters";
        }
        String str4 = "substituteTypeParameters";
        int i7 = 1;
        if (i != i4) {
            arr[i7] = str3;
        } else {
            arr[i7] = str4;
        }
        if (i != i4) {
            arr[i5] = str4;
        }
        String format = String.format(str, arr);
        if (i != i4) {
            obj7 = new IllegalArgumentException(format);
        } else {
            obj7 = new IllegalStateException(format);
        }
        throw obj7;
    }

    public static kotlin.i0.z.e.m0.l.a1 b(List<z0> list, kotlin.i0.z.e.m0.l.y0 y02, m m3, List<z0> list4) {
        final int i = 0;
        if (list == null) {
        } else {
            if (y02 == null) {
            } else {
                if (m3 == null) {
                } else {
                    if (list4 == null) {
                    } else {
                        kotlin.i0.z.e.m0.l.a1 obj1 = o.c(list, y02, m3, list4, i);
                        if (obj1 == null) {
                        } else {
                            if (obj1 == null) {
                            } else {
                                return obj1;
                            }
                            o.a(4);
                            throw i;
                        }
                        obj1 = new AssertionError("Substitution failed");
                        throw obj1;
                    }
                    o.a(3);
                    throw i;
                }
                o.a(2);
                throw i;
            }
            o.a(1);
            throw i;
        }
        o.a(0);
        throw i;
    }

    public static kotlin.i0.z.e.m0.l.a1 c(List<z0> list, kotlin.i0.z.e.m0.l.y0 y02, m m3, List<z0> list4, boolean[] z5Arr5) {
        j0 j0Var;
        boolean iterator;
        kotlin.i0.z.e.m0.l.t0 t0Var;
        kotlin.i0.z.e.m0.l.x0 x0Var;
        kotlin.i0.z.e.m0.l.i0 i0Var;
        kotlin.i0.z.e.m0.f.e name;
        int i2;
        u0 u0Var;
        kotlin.i0.z.e.m0.k.n nVar;
        Object obj;
        int i;
        kotlin.i0.z.e.m0.l.y0 y0Var = y02;
        Object obj2 = list4;
        final int i7 = 0;
        if (list == null) {
        } else {
            if (y0Var == null) {
            } else {
                if (m3 == null) {
                } else {
                    if (obj2 == null) {
                    } else {
                        HashMap hashMap = new HashMap();
                        HashMap hashMap2 = new HashMap();
                        final Iterator iterator3 = list.iterator();
                        final int i8 = 0;
                        i2 = i8;
                        for (Object next : iterator3) {
                            obj = next;
                            j0Var = j0.P0(m3, (z0)obj.getAnnotations(), obj.C(), obj.l(), obj.getName(), i2, u0.a, obj.h0());
                            x0Var = new x0(j0Var.q());
                            hashMap.put(obj.g(), x0Var);
                            hashMap2.put(obj, j0Var);
                            obj2.add(j0Var);
                            i2 = i;
                        }
                        kotlin.i0.z.e.m0.l.a1 a1Var = a1.h(y0Var, u0.i(hashMap));
                        Iterator iterator2 = list.iterator();
                        for (z0 next3 : iterator2) {
                            t0Var = hashMap2.get(next3);
                            iterator = next3.getUpperBounds().iterator();
                            for (b0 x0Var : iterator) {
                                i0Var = a1Var.p(x0Var, h1.IN_VARIANCE);
                                if (i0Var != x0Var && z5Arr5 != null) {
                                }
                                (j0)t0Var.L0(i0Var);
                                if (z5Arr5 != null) {
                                }
                                z5Arr5[i8] = 1;
                            }
                            t0Var.T0();
                            x0Var = iterator.next();
                            i0Var = a1Var.p((b0)x0Var, h1.IN_VARIANCE);
                            if (i0Var != x0Var && z5Arr5 != null) {
                            }
                            t0Var.L0(i0Var);
                            if (z5Arr5 != null) {
                            }
                            z5Arr5[i8] = 1;
                        }
                        return a1Var;
                    }
                    o.a(8);
                    throw i7;
                }
                o.a(7);
                throw i7;
            }
            o.a(6);
            throw i7;
        }
        o.a(5);
        throw i7;
    }
}
