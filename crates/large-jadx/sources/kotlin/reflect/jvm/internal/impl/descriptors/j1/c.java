package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.v.o.d;
import kotlin.i0.z.e.m0.i.v.o.g;
import kotlin.i0.z.e.m0.l.a1;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.b;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n;
import kotlin.reflect.jvm.internal.impl.descriptors.o;
import kotlin.reflect.jvm.internal.impl.descriptors.r0;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* loaded from: classes3.dex */
public abstract class c extends kotlin.reflect.jvm.internal.impl.descriptors.j1.j implements r0 {

    private static final e c;
    static {
        c.c = e.n("<this>");
    }

    public c(g g) {
        if (g == null) {
        } else {
            super(g, c.c);
        }
        c.E(0);
        throw 0;
    }

    private static void E(int i) {
        String str;
        int i2;
        String str3;
        String str2;
        Object obj6;
        str = /* condition */ ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        i2 = /* condition */ ? i3 : 3;
        Object[] arr = new Object[i2];
        str3 = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
        int i4 = 0;
        switch (i) {
            case 1:
                arr[i4] = "substitutor";
                break;
            case 2:
                arr[i4] = str3;
                break;
            default:
                arr[i4] = "annotations";
        }
        int i5 = 1;
        switch (i) {
            case 2:
                arr[i5] = "getTypeParameters";
                break;
            case 3:
                arr[i5] = "getType";
                break;
            case 4:
                arr[i5] = "getValueParameters";
                break;
            case 5:
                arr[i5] = "getOverriddenDescriptors";
                break;
            case 6:
                arr[i5] = "getVisibility";
                break;
            case 7:
                arr[i5] = "getOriginal";
                break;
            case 8:
                arr[i5] = "getSource";
                break;
            default:
                arr[i5] = str3;
        }
        switch (i) {
            case 1:
                arr[i3] = "substitute";
                break;
            default:
                arr[i3] = "<init>";
        }
        if (/* condition */) {
            obj6 = new IllegalStateException(format);
        } else {
            obj6 = new IllegalArgumentException(format);
        }
        throw obj6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public boolean D() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public l0 J() {
        return this;
    }

    public <R, D> R K(o<R, D> o, D d2) {
        return o.l(this, d2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public a a() {
        J();
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public m a() {
        J();
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public n c(a1 a1) {
        return c(a1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public r0 c(a1 a1) {
        b0 type;
        h1 oUT_VARIANCE;
        b0 obj4;
        int i = 0;
        if (a1 == null) {
        } else {
            if (a1.k()) {
                return this;
            }
            if (mVar instanceof e) {
                obj4 = a1.p(getType(), h1.OUT_VARIANCE);
            } else {
                obj4 = a1.p(getType(), h1.INVARIANT);
            }
            if (obj4 == null) {
                return i;
            }
            if (obj4 == getType()) {
                return this;
            }
            g gVar = new g(obj4);
            e0 e0Var = new e0(b(), gVar, getAnnotations());
            return e0Var;
        }
        c.E(1);
        throw i;
    }

    public Collection<? extends a> e() {
        java.util.Set emptySet = Collections.emptySet();
        if (emptySet == null) {
        } else {
            return emptySet;
        }
        c.E(5);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public r0 f0() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public b0 getReturnType() {
        return getType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public u0 getSource() {
        u0 u0Var = u0.a;
        if (u0Var == null) {
        } else {
            return u0Var;
        }
        c.E(8);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public b0 getType() {
        b0 type = getValue().getType();
        if (type == null) {
        } else {
            return type;
        }
        c.E(3);
        throw 0;
    }

    public List<z0> getTypeParameters() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
        } else {
            return emptyList;
        }
        c.E(2);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public u getVisibility() {
        u uVar = t.f;
        if (uVar == null) {
        } else {
            return uVar;
        }
        c.E(6);
        throw 0;
    }

    public List<c1> h() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
        } else {
            return emptyList;
        }
        c.E(4);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public r0 m0() {
        return null;
    }
}
