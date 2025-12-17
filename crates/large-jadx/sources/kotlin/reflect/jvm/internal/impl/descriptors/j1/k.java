package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import kotlin.i0.z.e.m0.f.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n;
import kotlin.reflect.jvm.internal.impl.descriptors.p;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;

/* loaded from: classes3.dex */
public abstract class k extends kotlin.reflect.jvm.internal.impl.descriptors.j1.j implements n {

    private final m c;
    private final u0 v;
    protected k(m m, g g2, e e3, u0 u04) {
        final int i = 0;
        if (m == null) {
        } else {
            if (g2 == null) {
            } else {
                if (e3 == null) {
                } else {
                    if (u04 == null) {
                    } else {
                        super(g2, e3);
                        this.c = m;
                        this.v = u04;
                    }
                    k.E(3);
                    throw i;
                }
                k.E(2);
                throw i;
            }
            k.E(1);
            throw i;
        }
        k.E(0);
        throw i;
    }

    private static void E(int i) {
        String str2;
        int i2;
        String str3;
        String str;
        Object obj9;
        final int i4 = 6;
        final int i6 = 5;
        final int i7 = 4;
        if (i != i7 && i != i6 && i != i4) {
            if (i != i6) {
                str2 = i != i4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            } else {
            }
        } else {
        }
        final int i8 = 2;
        if (i != i7 && i != i6 && i != i4) {
            if (i != i6) {
                i2 = i != i4 ? 3 : i8;
            } else {
            }
        } else {
        }
        Object[] arr = new Object[i2];
        str3 = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
        int i9 = 0;
        switch (i) {
            case 1:
                arr[i9] = "annotations";
                break;
            case 2:
                arr[i9] = "name";
                break;
            case 3:
                arr[i9] = "source";
                break;
            case 4:
                arr[i9] = str3;
                break;
            default:
                arr[i9] = "containingDeclaration";
        }
        int i10 = 1;
        if (i != i7) {
            if (i != i6) {
                if (i != i4) {
                    arr[i10] = str3;
                } else {
                    arr[i10] = "getSource";
                }
            } else {
                arr[i10] = "getContainingDeclaration";
            }
        } else {
            arr[i10] = "getOriginal";
        }
        if (i != i7 && i != i6 && i != i4) {
            if (i != i6) {
                if (i != i4) {
                    arr[i8] = "<init>";
                }
            }
        }
        String format = String.format(str2, arr);
        if (i != i7 && i != i6 && i != i4) {
            if (i != i6) {
                if (i != i4) {
                    obj9 = new IllegalArgumentException(format);
                } else {
                    obj9 = new IllegalStateException(format);
                }
            } else {
            }
        } else {
        }
        throw obj9;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public p J() {
        super.a();
        return (p)this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public m a() {
        return J();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public m b() {
        m mVar = this.c;
        if (mVar == null) {
        } else {
            return mVar;
        }
        k.E(5);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public u0 getSource() {
        u0 u0Var = this.v;
        if (u0Var == null) {
        } else {
            return u0Var;
        }
        k.E(6);
        throw 0;
    }
}
