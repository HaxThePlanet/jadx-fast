package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.b.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n0;
import kotlin.reflect.jvm.internal.impl.descriptors.o;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.p;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.z;

/* loaded from: classes3.dex */
public class c0 extends kotlin.reflect.jvm.internal.impl.descriptors.j1.a0 implements p0 {

    private b0 E;
    private final p0 F;
    public c0(o0 o0, g g2, z z3, u u4, boolean z5, boolean z6, boolean z7, b.a b$a8, p0 p09, u0 u010) {
        p0 p0Var;
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
                                stringBuilder.append("<get-");
                                stringBuilder.append(o0.getName());
                                stringBuilder.append(">");
                                super(z3, u4, o0, g2, e.n(stringBuilder.toString()), z5, z6, z7, a8, u010);
                                if (p09 != null) {
                                    obj = this;
                                    p0Var = p09;
                                } else {
                                    obj = p0Var;
                                }
                                obj.F = p0Var;
                            }
                            Object obj6 = this;
                            c0.E(5);
                            throw i;
                        }
                        Object obj4 = this;
                        c0.E(4);
                        throw i;
                    }
                    Object obj3 = this;
                    c0.E(3);
                    throw i;
                }
                Object obj7 = this;
                c0.E(2);
                throw i;
            }
            Object obj2 = this;
            c0.E(1);
            throw i;
        }
        Object obj8 = this;
        c0.E(0);
        throw i;
    }

    private static void E(int i) {
        String str2;
        int i2;
        String str3;
        String str;
        Object obj9;
        final int i3 = 8;
        final int i4 = 7;
        final int i5 = 6;
        if (i != i5 && i != i4 && i != i3) {
            if (i != i4) {
                str2 = i != i3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            } else {
            }
        } else {
        }
        final int i6 = 2;
        if (i != i5 && i != i4 && i != i3) {
            if (i != i4) {
                i2 = i != i3 ? 3 : i6;
            } else {
            }
        } else {
        }
        Object[] arr = new Object[i2];
        str3 = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
        int i7 = 0;
        switch (i) {
            case 1:
                arr[i7] = "annotations";
                break;
            case 2:
                arr[i7] = "modality";
                break;
            case 3:
                arr[i7] = "visibility";
                break;
            case 4:
                arr[i7] = "kind";
                break;
            case 5:
                arr[i7] = "source";
                break;
            case 6:
                arr[i7] = str3;
                break;
            default:
                arr[i7] = "correspondingProperty";
        }
        int i8 = 1;
        if (i != i5) {
            if (i != i4) {
                if (i != i3) {
                    arr[i8] = str3;
                } else {
                    arr[i8] = "getOriginal";
                }
            } else {
                arr[i8] = "getValueParameters";
            }
        } else {
            arr[i8] = "getOverriddenDescriptors";
        }
        if (i != i5 && i != i4 && i != i3) {
            if (i != i4) {
                if (i != i3) {
                    arr[i6] = "<init>";
                }
            }
        }
        String format = String.format(str2, arr);
        if (i != i5 && i != i4 && i != i3) {
            if (i != i4) {
                if (i != i3) {
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

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a0
    public p J() {
        return O0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a0
    public n0 J0() {
        return O0();
    }

    public <R, D> R K(o<R, D> o, D d2) {
        return o.b(this, d2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a0
    public p0 O0() {
        p0 p0Var = this.F;
        if (p0Var == null) {
        } else {
            return p0Var;
        }
        c0.E(8);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a0
    public void P0(b0 b0) {
        b0 obj1;
        if (b0 == null) {
            obj1 = y0().getType();
        }
        this.E = obj1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a0
    public a a() {
        return O0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a0
    public b a() {
        return O0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a0
    public m a() {
        return O0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a0
    public x a() {
        return O0();
    }

    public Collection<? extends p0> e() {
        Collection collection = super.K0(true);
        if (collection == null) {
        } else {
            return collection;
        }
        c0.E(6);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a0
    public b0 getReturnType() {
        return this.E;
    }

    public List<c1> h() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
        } else {
            return emptyList;
        }
        c0.E(7);
        throw 0;
    }
}
