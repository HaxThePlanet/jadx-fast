package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import kotlin.d0.c.a;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.q.g;
import kotlin.i0.z.e.m0.k.j;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;

/* loaded from: classes3.dex */
public abstract class m0 extends kotlin.reflect.jvm.internal.impl.descriptors.j1.l0 {

    private final boolean x;
    protected j<g<?>> y;
    static {
    }

    public m0(m m, g g2, e e3, b0 b04, boolean z5, u0 u06) {
        int i = 0;
        if (m == null) {
        } else {
            if (g2 == null) {
            } else {
                if (e3 == null) {
                } else {
                    if (u06 == null) {
                    } else {
                        super(m, g2, e3, b04, u06);
                        this.x = z5;
                    }
                    m0.E(3);
                    throw i;
                }
                m0.E(2);
                throw i;
            }
            m0.E(1);
            throw i;
        }
        m0.E(0);
        throw i;
    }

    private static void E(int i) {
        String str;
        String obj6;
        int i2 = 3;
        final Object[] arr = new Object[i2];
        final int i3 = 4;
        final int i4 = 1;
        final int i5 = 2;
        final int i6 = 0;
        if (i != i4) {
            if (i != i5) {
                if (i != i2) {
                    if (i != i3) {
                        arr[i6] = "containingDeclaration";
                    } else {
                        arr[i6] = "compileTimeInitializer";
                    }
                } else {
                    arr[i6] = "source";
                }
            } else {
                arr[i6] = "name";
            }
        } else {
            arr[i6] = "annotations";
        }
        arr[i4] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl";
        if (i != i3) {
            arr[i5] = "<init>";
        } else {
            arr[i5] = "setCompileTimeInitializer";
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
        throw illegalArgumentException;
    }

    public void J0(j<g<?>> j) {
        if (j == null) {
        } else {
            this.y = j;
        }
        m0.E(4);
        throw 0;
    }

    public g<?> W() {
        j jVar = this.y;
        if (jVar != null) {
            return (g)jVar.invoke();
        }
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.l0
    public boolean j0() {
        return this.x;
    }
}
