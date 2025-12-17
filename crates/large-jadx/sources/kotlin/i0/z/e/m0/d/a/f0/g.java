package kotlin.i0.z.e.m0.d.a.f0;

import java.util.List;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.d.a.j0.t;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.c;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.a.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.b;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.j;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.a0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.j;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.k;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.m0;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n0;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.p;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.z;

/* loaded from: classes3.dex */
public class g extends b0 implements kotlin.i0.z.e.m0.d.a.f0.b {

    private final boolean S;
    private final o<a.a<?>, ?> T;
    protected g(m m, g g2, z z3, u u4, boolean z5, e e6, u0 u07, o0 o08, b.a b$a9, boolean z10, o<a.a<?>, ?> o11) {
        Object obj10 = this;
        int i = 0;
        if (m == null) {
        } else {
            if (g2 == null) {
            } else {
                if (z3 == null) {
                } else {
                    if (u4 == null) {
                    } else {
                        if (e6 == null) {
                        } else {
                            if (u07 == null) {
                            } else {
                                if (a9 == null) {
                                } else {
                                    super(m, o08, g2, z3, u4, z5, e6, a9, u07, 0, 0, 0, 0, 0, 0);
                                    Object obj5 = this;
                                    obj5.S = z10;
                                    obj5.T = o11;
                                }
                                Object obj6 = obj10;
                                g.E(6);
                                throw i;
                            }
                            Object obj7 = obj10;
                            g.E(5);
                            throw i;
                        }
                        Object obj4 = obj10;
                        g.E(4);
                        throw i;
                    }
                    Object obj3 = obj10;
                    g.E(3);
                    throw i;
                }
                Object obj8 = obj10;
                g.E(2);
                throw i;
            }
            Object obj9 = obj10;
            g.E(1);
            throw i;
        }
        Object obj2 = obj10;
        g.E(0);
        throw i;
    }

    private static void E(int i) {
        String str2;
        int i3;
        String str3;
        String str;
        Object obj7;
        final int i4 = 21;
        str2 = i != i4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        final int i5 = 2;
        i3 = i != i4 ? 3 : i5;
        Object[] arr = new Object[i3];
        str3 = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
        int i6 = 0;
        switch (i) {
            case 1:
                arr[i6] = "annotations";
                break;
            case 2:
                arr[i6] = "modality";
                break;
            case 3:
                arr[i6] = "visibility";
                break;
            case 4:
                arr[i6] = "name";
                break;
            case 5:
                arr[i6] = "source";
                break;
            case 6:
                arr[i6] = "kind";
                break;
            case 7:
                arr[i6] = "containingDeclaration";
                break;
            case 8:
                arr[i6] = "newOwner";
                break;
            case 9:
                arr[i6] = "newModality";
                break;
            case 10:
                arr[i6] = "newVisibility";
                break;
            case 11:
                arr[i6] = "newName";
                break;
            case 12:
                arr[i6] = "enhancedValueParametersData";
                break;
            case 13:
                arr[i6] = "enhancedReturnType";
                break;
            default:
                arr[i6] = str3;
        }
        String str4 = "enhance";
        int i7 = 1;
        if (i != i4) {
            arr[i7] = str3;
        } else {
            arr[i7] = str4;
        }
        switch (i) {
            case 7:
                arr[i5] = "create";
                break;
            case 8:
                arr[i5] = "createSubstitutedCopy";
                break;
            case 9:
                arr[i5] = str4;
                break;
            default:
                arr[i5] = "<init>";
        }
        String format = String.format(str2, arr);
        if (i != i4) {
            obj7 = new IllegalArgumentException(format);
        } else {
            obj7 = new IllegalStateException(format);
        }
        throw obj7;
    }

    public static kotlin.i0.z.e.m0.d.a.f0.g a1(m m, g g2, z z3, u u4, boolean z5, e e6, u0 u07, boolean z8) {
        int i = 0;
        if (m == null) {
        } else {
            if (g2 == null) {
            } else {
                if (z3 == null) {
                } else {
                    if (u4 == null) {
                    } else {
                        if (e6 == null) {
                        } else {
                            if (u07 == null) {
                            } else {
                                super(m, g2, z3, u4, z5, e6, u07, 0, b.a.DECLARATION, z8, 0);
                                return gVar;
                            }
                            g.E(12);
                            throw i;
                        }
                        g.E(11);
                        throw i;
                    }
                    g.E(10);
                    throw i;
                }
                g.E(9);
                throw i;
            }
            g.E(8);
            throw i;
        }
        g.E(7);
        throw i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.b0
    public boolean D() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.b0
    protected b0 N0(m m, z z2, u u3, o0 o04, b.a b$a5, e e6, u0 u07) {
        final Object obj = this;
        int i = 0;
        if (m == null) {
        } else {
            if (z2 == null) {
            } else {
                if (u3 == null) {
                } else {
                    if (a5 == null) {
                    } else {
                        if (e6 == null) {
                        } else {
                            if (u07 == null) {
                            } else {
                                super(m, getAnnotations(), z2, u3, j0(), e6, u07, o04, a5, obj.S, obj.T);
                                return gVar;
                            }
                            g.E(18);
                            throw i;
                        }
                        g.E(17);
                        throw i;
                    }
                    g.E(16);
                    throw i;
                }
                g.E(15);
                throw i;
            }
            g.E(14);
            throw i;
        }
        g.E(13);
        throw i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.b0
    public boolean isConst() {
        b0 type;
        int i;
        boolean z;
        type = getType();
        if (this.S && j.a(type)) {
            if (j.a(type)) {
                if (t.i(type)) {
                    i = h.C0(type) ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public kotlin.i0.z.e.m0.d.a.f0.b v(b0 b0, List<kotlin.i0.z.e.m0.d.a.f0.l> list2, b0 b03, o<a.a<?>, ?> o4) {
        c0 c0Var;
        int i;
        int setter;
        Object getter;
        m mVar;
        g annotations;
        z zVar;
        u visibility;
        boolean z;
        boolean name;
        boolean source;
        b.a i2;
        int aVar;
        u0 z2;
        d0 d0Var;
        u0 source2;
        d0 obj22;
        final o0 o0Var = this;
        b0 b0Var = b0;
        b0 b0Var2 = b03;
        if (list2 == null) {
        } else {
            if (b0Var2 == null) {
            } else {
                if (a() == o0Var) {
                    setter = 0;
                } else {
                    setter = a();
                }
                final kotlin.i0.z.e.m0.d.a.f0.g obj20 = gVar4;
                super(b(), getAnnotations(), i(), getVisibility(), j0(), getName(), getSource(), setter, f(), o0Var.S, o4);
                c0 c0Var4 = P0();
                if (c0Var4 != null) {
                    if (setter == 0) {
                        aVar = 0;
                    } else {
                        aVar = getter;
                    }
                    c0Var = c0Var3;
                    super(obj20, c0Var4.getAnnotations(), c0Var4.i(), c0Var4.getVisibility(), c0Var4.U(), c0Var4.w(), c0Var4.r(), f(), aVar, c0Var4.getSource());
                    c0Var.M0(c0Var4.d0());
                    c0Var.P0(b0Var2);
                } else {
                    c0Var = 0;
                }
                kotlin.reflect.jvm.internal.impl.descriptors.q0 setter2 = getSetter();
                if (setter2 != null) {
                    if (setter == 0) {
                        aVar = 0;
                    } else {
                        aVar = setter;
                    }
                    obj22 = d0Var3;
                    super(obj20, setter2.getAnnotations(), setter2.i(), setter2.getVisibility(), setter2.U(), setter2.w(), setter2.r(), f(), aVar, setter2.getSource());
                    getter = obj22;
                    getter.M0(obj22.d0());
                    getter.Q0((c1)setter2.h().get(0));
                    d0Var = getter;
                } else {
                    d0Var = 0;
                }
                kotlin.i0.z.e.m0.d.a.f0.g gVar2 = obj20;
                gVar2.T0(c0Var, d0Var, q0(), n0());
                gVar2.X0(U0());
                kotlin.i0.z.e.m0.k.j jVar = o0Var.y;
                if (jVar != null) {
                    gVar2.J0(jVar);
                }
                gVar2.w0(e());
                if (b0Var == null) {
                    i = 0;
                } else {
                    i = c.f(o0Var, b0Var, g.q.b());
                }
                gVar2.Y0(b0Var2, getTypeParameters(), f0(), i);
                return gVar2;
            }
            g.E(20);
            throw 0;
        }
        g.E(19);
        throw 0;
    }
}
