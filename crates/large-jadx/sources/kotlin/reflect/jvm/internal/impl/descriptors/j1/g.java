package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.k.n;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;

/* loaded from: classes3.dex */
public abstract class g extends kotlin.reflect.jvm.internal.impl.descriptors.j1.a {

    private final m x;
    private final u0 y;
    private final boolean z;
    protected g(n n, m m2, e e3, u0 u04, boolean z5) {
        final int i = 0;
        if (n == null) {
        } else {
            if (m2 == null) {
            } else {
                if (e3 == null) {
                } else {
                    if (u04 == null) {
                    } else {
                        super(n, e3);
                        this.x = m2;
                        this.y = u04;
                        this.z = z5;
                    }
                    g.J(3);
                    throw i;
                }
                g.J(2);
                throw i;
            }
            g.J(1);
            throw i;
        }
        g.J(0);
        throw i;
    }

    private static void J(int i) {
        String str;
        String str2;
        int i2;
        Object obj9;
        final int i3 = 5;
        final int i4 = 4;
        if (i != i4 && i != i3) {
            str = i != i3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        } else {
        }
        str2 = 3;
        final int i5 = 2;
        if (i != i4 && i != i3) {
            i2 = i != i3 ? str2 : i5;
        } else {
        }
        Object[] arr = new Object[i2];
        final String str3 = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        final int i6 = 1;
        final int i7 = 0;
        if (i != i6) {
            if (i != i5) {
                if (i != str2) {
                    if (i != i4 && i != i3) {
                        if (i != i3) {
                            arr[i7] = "storageManager";
                        } else {
                            arr[i7] = str3;
                        }
                    } else {
                    }
                } else {
                    arr[i7] = "source";
                }
            } else {
                arr[i7] = "name";
            }
        } else {
            arr[i7] = "containingDeclaration";
        }
        if (i != i4) {
            if (i != i3) {
                arr[i6] = str3;
            } else {
                arr[i6] = "getSource";
            }
        } else {
            arr[i6] = "getContainingDeclaration";
        }
        if (i != i4 && i != i3) {
            if (i != i3) {
                arr[i5] = "<init>";
            }
        }
        String format = String.format(str, arr);
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

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    public m b() {
        m mVar = this.x;
        if (mVar == null) {
        } else {
            return mVar;
        }
        g.J(4);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    public u0 getSource() {
        u0 u0Var = this.y;
        if (u0Var == null) {
        } else {
            return u0Var;
        }
        g.J(5);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    public boolean w() {
        return this.z;
    }
}
