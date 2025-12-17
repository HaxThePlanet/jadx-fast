package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.b.a;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n0;
import kotlin.reflect.jvm.internal.impl.descriptors.o;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.p;
import kotlin.reflect.jvm.internal.impl.descriptors.q0;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.z;

/* loaded from: classes3.dex */
public class d0 extends kotlin.reflect.jvm.internal.impl.descriptors.j1.a0 implements q0 {

    private c1 E;
    private final q0 F;
    static {
    }

    public d0(o0 o0, g g2, z z3, u u4, boolean z5, boolean z6, boolean z7, b.a b$a8, q0 q09, u0 u010) {
        q0 q0Var;
        Object obj;
        int i = 0;
        if (o0 == null) {
        } else {
            if (g2 == null) {
            } else {
                if (z3 == null) {
                } else {
                    if (u4 == null) {
                    } else {
                        if (a8 == null) {
                        } else {
                            if (u010 == null) {
                            } else {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("<set-");
                                stringBuilder.append(o0.getName());
                                stringBuilder.append(">");
                                super(z3, u4, o0, g2, e.n(stringBuilder.toString()), z5, z6, z7, a8, u010);
                                if (q09 != null) {
                                    obj = this;
                                    q0Var = q09;
                                } else {
                                    obj = q0Var;
                                }
                                obj.F = q0Var;
                            }
                            Object obj6 = this;
                            d0.E(5);
                            throw i;
                        }
                        Object obj4 = this;
                        d0.E(4);
                        throw i;
                    }
                    Object obj3 = this;
                    d0.E(3);
                    throw i;
                }
                Object obj7 = this;
                d0.E(2);
                throw i;
            }
            Object obj2 = this;
            d0.E(1);
            throw i;
        }
        Object obj8 = this;
        d0.E(0);
        throw i;
    }

    private static void E(int i) {
        String str;
        int i2;
        String str2;
        String str3;
        Object obj6;
        str = /* condition */ ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        i2 = /* condition */ ? i3 : 3;
        Object[] arr = new Object[i2];
        str2 = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
        int i4 = 0;
        switch (i) {
            case 1:
                arr[i4] = "annotations";
                break;
            case 2:
                arr[i4] = "modality";
                break;
            case 3:
                arr[i4] = "visibility";
                break;
            case 4:
                arr[i4] = "kind";
                break;
            case 5:
                arr[i4] = "source";
                break;
            case 6:
                arr[i4] = "parameter";
                break;
            case 7:
                arr[i4] = "setterDescriptor";
                break;
            case 8:
                arr[i4] = "type";
                break;
            case 9:
                arr[i4] = str2;
                break;
            default:
                arr[i4] = "correspondingProperty";
        }
        int i5 = 1;
        switch (i) {
            case 10:
                arr[i5] = "getOverriddenDescriptors";
                break;
            case 11:
                arr[i5] = "getValueParameters";
                break;
            case 12:
                arr[i5] = "getReturnType";
                break;
            case 13:
                arr[i5] = "getOriginal";
                break;
            default:
                arr[i5] = str2;
        }
        switch (i) {
            case 6:
                arr[i3] = "initialize";
                break;
            case 7:
                arr[i3] = "createSetterParameter";
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

    public static kotlin.reflect.jvm.internal.impl.descriptors.j1.k0 O0(q0 q0, b0 b02, g g3) {
        int i = 0;
        if (q0 == null) {
        } else {
            if (b02 == null) {
            } else {
                if (g3 == null) {
                } else {
                    super(q0, 0, 0, g3, e.n("<set-?>"), b02, 0, 0, 0, 0, u0.a);
                    return k0Var;
                }
                d0.E(9);
                throw i;
            }
            d0.E(8);
            throw i;
        }
        d0.E(7);
        throw i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a0
    public p J() {
        return P0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a0
    public n0 J0() {
        return P0();
    }

    public <R, D> R K(o<R, D> o, D d2) {
        return o.i(this, d2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a0
    public q0 P0() {
        q0 q0Var = this.F;
        if (q0Var == null) {
        } else {
            return q0Var;
        }
        d0.E(13);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a0
    public void Q0(c1 c1) {
        if (c1 == null) {
        } else {
            this.E = c1;
        }
        d0.E(6);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a0
    public a a() {
        return P0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a0
    public b a() {
        return P0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a0
    public m a() {
        return P0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a0
    public x a() {
        return P0();
    }

    public Collection<? extends q0> e() {
        Collection collection = super.K0(false);
        if (collection == null) {
        } else {
            return collection;
        }
        d0.E(10);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a0
    public b0 getReturnType() {
        kotlin.i0.z.e.m0.l.i0 i0Var = a.g(this).Y();
        if (i0Var == null) {
        } else {
            return i0Var;
        }
        d0.E(12);
        throw 0;
    }

    public List<c1> h() {
        c1 c1Var = this.E;
        if (c1Var == null) {
        } else {
            List singletonList = Collections.singletonList(c1Var);
            if (singletonList == null) {
            } else {
                return singletonList;
            }
            d0.E(11);
            throw 0;
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }
}
