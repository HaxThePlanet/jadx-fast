package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.k.n;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;

/* loaded from: classes3.dex */
public abstract class b extends kotlin.reflect.jvm.internal.impl.descriptors.j1.e {
    public b(n n, m m2, e e3, h1 h14, boolean z5, int i6, u0 u07, x0 x08) {
        int i = 0;
        if (n == null) {
        } else {
            if (m2 == null) {
            } else {
                if (e3 == null) {
                } else {
                    if (h14 == null) {
                    } else {
                        if (u07 == null) {
                        } else {
                            if (x08 == null) {
                            } else {
                                super(n, m2, g.q.b(), e3, h14, z5, i6, u07, x08);
                            }
                            b.E(5);
                            throw i;
                        }
                        b.E(4);
                        throw i;
                    }
                    b.E(3);
                    throw i;
                }
                b.E(2);
                throw i;
            }
            b.E(1);
            throw i;
        }
        b.E(0);
        throw i;
    }

    private static void E(int i) {
        int i2;
        String obj5;
        i2 = 3;
        final Object[] arr = new Object[i2];
        final int i3 = 2;
        final int i4 = 1;
        final int i5 = 0;
        if (i != i4) {
            if (i != i3) {
                if (i != i2) {
                    if (i != 4) {
                        if (i != 5) {
                            arr[i5] = "storageManager";
                        } else {
                            arr[i5] = "supertypeLoopChecker";
                        }
                    } else {
                        arr[i5] = "source";
                    }
                } else {
                    arr[i5] = "variance";
                }
            } else {
                arr[i5] = "name";
            }
        } else {
            arr[i5] = "containingDeclaration";
        }
        arr[i4] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor";
        arr[i3] = "<init>";
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
        throw illegalArgumentException;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.e
    public String toString() {
        String str2;
        String string;
        Object str;
        Object[] arr = new Object[3];
        str2 = C() ? "reified " : string;
        if (l() == h1.INVARIANT) {
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(l());
            stringBuilder.append(" ");
            string = stringBuilder.toString();
        }
        return String.format("%s%s%s", str2, string, getName());
    }
}
