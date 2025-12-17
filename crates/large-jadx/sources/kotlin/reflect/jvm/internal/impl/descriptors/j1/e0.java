package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import kotlin.i0.z.e.m0.i.v.o.d;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.m;

/* loaded from: classes3.dex */
public class e0 extends kotlin.reflect.jvm.internal.impl.descriptors.j1.c {

    private final m v;
    private final d w;
    public e0(m m, d d2, g g3) {
        final int i = 0;
        if (m == null) {
        } else {
            if (d2 == null) {
            } else {
                if (g3 == null) {
                } else {
                    super(g3);
                    this.v = m;
                    this.w = d2;
                }
                e0.E(2);
                throw i;
            }
            e0.E(1);
            throw i;
        }
        e0.E(0);
        throw i;
    }

    private static void E(int i) {
        String str3;
        int i2;
        String str2;
        String str;
        Object obj10;
        final int i3 = 4;
        final int i4 = 3;
        if (i != i4 && i != i3) {
            str3 = i != i3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        } else {
        }
        final int i5 = 2;
        if (i != i4 && i != i3) {
            i2 = i != i3 ? i4 : i5;
        } else {
        }
        Object[] arr = new Object[i2];
        str2 = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        final int i6 = 5;
        final int i7 = 1;
        final int i8 = 0;
        if (i != i7) {
            if (i != i5) {
                if (i != i4 && i != i3) {
                    if (i != i3) {
                        if (i != i6) {
                            arr[i8] = "containingDeclaration";
                        } else {
                            arr[i8] = "newOwner";
                        }
                    } else {
                        arr[i8] = str2;
                    }
                } else {
                }
            } else {
                arr[i8] = "annotations";
            }
        } else {
            arr[i8] = "value";
        }
        if (i != i4) {
            if (i != i3) {
                arr[i7] = str2;
            } else {
                arr[i7] = "getContainingDeclaration";
            }
        } else {
            arr[i7] = "getValue";
        }
        if (i != i4 && i != i3) {
            if (i != i3) {
                if (i != i6) {
                    arr[i5] = "<init>";
                } else {
                    arr[i5] = "copy";
                }
            }
        }
        String format = String.format(str3, arr);
        if (i != i4 && i != i3) {
            if (i != i3) {
                obj10 = new IllegalArgumentException(format);
            } else {
                obj10 = new IllegalStateException(format);
            }
        } else {
        }
        throw obj10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.c
    public m b() {
        m mVar = this.v;
        if (mVar == null) {
        } else {
            return mVar;
        }
        e0.E(4);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.c
    public d getValue() {
        d dVar = this.w;
        if (dVar == null) {
        } else {
            return dVar;
        }
        e0.E(3);
        throw 0;
    }
}
