package kotlin.i0.z.e.m0.d.a;

import kotlin.i0.z.e.m0.b.c;
import kotlin.i0.z.e.m0.b.d;
import kotlin.i0.z.e.m0.i.d;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.b.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;

/* loaded from: classes3.dex */
public final class l {
    private static void a(int i) {
        String str;
        String obj6;
        int i2 = 3;
        final Object[] arr = new Object[i2];
        int i3 = 0;
        final int i4 = 1;
        final int i5 = 2;
        if (i != i4 && i != i5) {
            if (i != i5) {
                if (i != i2) {
                    arr[i3] = "propertyDescriptor";
                } else {
                    arr[i3] = "memberDescriptor";
                }
            } else {
                arr[i3] = "companionObject";
            }
        } else {
        }
        arr[i4] = "kotlin/reflect/jvm/internal/impl/load/java/DescriptorsJvmAbiUtil";
        if (i != i4) {
            if (i != i5) {
                if (i != i2) {
                    arr[i5] = "isPropertyWithBackingFieldInOuterClass";
                } else {
                    arr[i5] = "hasJvmFieldAnnotation";
                }
            } else {
                arr[i5] = "isMappedIntrinsicCompanionObject";
            }
        } else {
            arr[i5] = "isClassCompanionObjectWithBackingFieldsInOuter";
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
        throw illegalArgumentException;
    }

    public static boolean b(b b) {
        boolean z;
        kotlin.i0.z.e.m0.f.b bVar;
        if (b == null) {
        } else {
            z = (o0)b.q0();
            if (b instanceof o0 && z != null && z.getAnnotations().u1(x.b)) {
                z = (o0)b.q0();
                if (z != null) {
                    if (z.getAnnotations().u1(x.b)) {
                        return 1;
                    }
                }
            }
            return b.getAnnotations().u1(x.b);
        }
        l.a(3);
        throw 0;
    }

    public static boolean c(m m) {
        int i;
        boolean z;
        boolean obj2;
        if (m == null) {
        } else {
            if (d.x(m) && d.w(m.b()) && !l.d((e)m)) {
                if (d.w(m.b())) {
                    if (!l.d((e)m)) {
                    } else {
                        i = 0;
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        l.a(1);
        throw 0;
    }

    public static boolean d(e e) {
        if (e == null) {
        } else {
            return d.a(c.a, e);
        }
        l.a(2);
        throw 0;
    }

    public static boolean e(o0 o0) {
        int i;
        b obj3;
        i = 0;
        if (o0 == null) {
        } else {
            if (o0.f() == b.a.FAKE_OVERRIDE) {
                return i;
            }
            int i2 = 1;
            if (l.c(o0.b())) {
                return i2;
            }
            if (d.x(o0.b()) && l.b(o0)) {
                if (l.b(o0)) {
                    i = i2;
                }
            }
            return i;
        }
        l.a(i);
        throw 0;
    }
}
