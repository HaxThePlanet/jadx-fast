package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import java.util.Collections;
import java.util.List;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.r0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* loaded from: classes3.dex */
public abstract class l0 extends kotlin.reflect.jvm.internal.impl.descriptors.j1.k implements d1 {

    protected b0 w;
    static {
    }

    public l0(m m, g g2, e e3, b0 b04, u0 u05) {
        final int i = 0;
        if (m == null) {
        } else {
            if (g2 == null) {
            } else {
                if (e3 == null) {
                } else {
                    if (u05 == null) {
                    } else {
                        super(m, g2, e3, u05);
                        this.w = b04;
                    }
                    l0.E(3);
                    throw i;
                }
                l0.E(2);
                throw i;
            }
            l0.E(1);
            throw i;
        }
        l0.E(0);
        throw i;
    }

    private static void E(int i) {
        String str2;
        int i2;
        String str3;
        String str;
        Object obj6;
        str2 = /* condition */ ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        i2 = /* condition */ ? i5 : 3;
        Object[] arr = new Object[i2];
        str3 = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
        int i7 = 0;
        switch (i) {
            case 1:
                arr[i7] = "annotations";
                break;
            case 2:
                arr[i7] = "name";
                break;
            case 3:
                arr[i7] = "source";
                break;
            case 4:
                arr[i7] = str3;
                break;
            default:
                arr[i7] = "containingDeclaration";
        }
        int i8 = 1;
        switch (i) {
            case 4:
                arr[i8] = "getType";
                break;
            case 5:
                arr[i8] = "getOriginal";
                break;
            case 6:
                arr[i8] = "getValueParameters";
                break;
            case 7:
                arr[i8] = "getOverriddenDescriptors";
                break;
            case 8:
                arr[i8] = "getTypeParameters";
                break;
            case 9:
                arr[i8] = "getReturnType";
                break;
            default:
                arr[i8] = str3;
        }
        switch (i) {
        }
        if (/* condition */) {
            obj6 = new IllegalStateException(format);
        } else {
            obj6 = new IllegalArgumentException(format);
        }
        throw obj6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public void C0(b0 b0) {
        this.w = b0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public boolean D() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public r0 f0() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public b0 getReturnType() {
        b0 type = getType();
        if (type == null) {
        } else {
            return type;
        }
        l0.E(9);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public b0 getType() {
        b0 b0Var = this.w;
        if (b0Var == null) {
        } else {
            return b0Var;
        }
        l0.E(4);
        throw 0;
    }

    public List<z0> getTypeParameters() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
        } else {
            return emptyList;
        }
        l0.E(8);
        throw 0;
    }

    public List<c1> h() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
        } else {
            return emptyList;
        }
        l0.E(6);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public r0 m0() {
        return null;
    }
}
