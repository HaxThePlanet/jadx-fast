package kotlin.i0.z.e.m0.d.a.f0;

import java.util.List;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.c;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.descriptors.a.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b.a;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.b;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.f;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.k;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.p;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;

/* loaded from: classes3.dex */
public class c extends f implements kotlin.i0.z.e.m0.d.a.f0.b {

    private Boolean X = null;
    private Boolean Y = null;
    static {
    }

    protected c(e e, kotlin.i0.z.e.m0.d.a.f0.c c2, g g3, boolean z4, b.a b$a5, u0 u06) {
        final int i = 0;
        if (e == null) {
        } else {
            if (g3 == null) {
            } else {
                if (a5 == null) {
                } else {
                    if (u06 == null) {
                    } else {
                        super(e, c2, g3, z4, a5, u06);
                    }
                    c.E(3);
                    throw i;
                }
                c.E(2);
                throw i;
            }
            c.E(1);
            throw i;
        }
        c.E(0);
        throw i;
    }

    private static void E(int i) {
        String str;
        int i2;
        String str2;
        String str3;
        Object obj9;
        final int i4 = 18;
        final int i5 = 11;
        if (i != i5 && i != i4) {
            str = i != i4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        } else {
        }
        final int i6 = 2;
        if (i != i5 && i != i4) {
            i2 = i != i4 ? 3 : i6;
        } else {
        }
        Object[] arr = new Object[i2];
        str2 = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
        int i7 = 0;
        switch (i) {
            case 1:
                arr[i7] = "annotations";
                break;
            case 2:
                arr[i7] = "kind";
                break;
            case 3:
                arr[i7] = "source";
                break;
            case 4:
                arr[i7] = "containingDeclaration";
                break;
            case 5:
                arr[i7] = "newOwner";
                break;
            case 6:
                arr[i7] = str2;
                break;
            case 7:
                arr[i7] = "sourceElement";
                break;
            case 8:
                arr[i7] = "enhancedValueParametersData";
                break;
            default:
                arr[i7] = "enhancedReturnType";
        }
        String str4 = "enhance";
        String str5 = "createSubstitutedCopy";
        final int i8 = 1;
        if (i != i5) {
            if (i != i4) {
                arr[i8] = str2;
            } else {
                arr[i8] = str4;
            }
        } else {
            arr[i8] = str5;
        }
        switch (i) {
            case 4:
                arr[i6] = "createJavaConstructor";
                break;
            case 5:
                arr[i6] = str5;
                break;
            case 7:
                arr[i6] = "createDescriptor";
                break;
            case 8:
                arr[i6] = str4;
                break;
            default:
                arr[i6] = "<init>";
        }
        String format = String.format(str, arr);
        if (i != i5 && i != i4) {
            if (i != i4) {
                obj9 = new IllegalArgumentException(format);
            } else {
                obj9 = new IllegalStateException(format);
            }
        } else {
        }
        throw obj9;
    }

    public static kotlin.i0.z.e.m0.d.a.f0.c r1(e e, g g2, boolean z3, u0 u04) {
        int i = 0;
        if (e == null) {
        } else {
            if (g2 == null) {
            } else {
                if (u04 == null) {
                } else {
                    super(e, 0, g2, z3, b.a.DECLARATION, u04);
                    return cVar;
                }
                c.E(6);
                throw i;
            }
            c.E(5);
            throw i;
        }
        c.E(4);
        throw i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f
    public boolean D() {
        return this.Y.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f
    protected p K0(m m, x x2, b.a b$a3, e e4, g g5, u0 u06) {
        return s1(m, x2, a3, e4, g5, u06);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f
    public boolean P0() {
        return this.X.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f
    public void X0(boolean z) {
        this.X = Boolean.valueOf(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f
    public void Y0(boolean z) {
        this.Y = Boolean.valueOf(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f
    protected f m1(m m, x x2, b.a b$a3, e e4, g g5, u0 u06) {
        return s1(m, x2, a3, e4, g5, u06);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f
    protected kotlin.i0.z.e.m0.d.a.f0.c q1(e e, kotlin.i0.z.e.m0.d.a.f0.c c2, b.a b$a3, u0 u04, g g5) {
        int i = 0;
        if (e == null) {
        } else {
            if (a3 == null) {
            } else {
                if (u04 == null) {
                } else {
                    if (g5 == null) {
                    } else {
                        super(e, c2, g5, this.V, a3, u04);
                        return cVar;
                    }
                    c.E(15);
                    throw i;
                }
                c.E(14);
                throw i;
            }
            c.E(13);
            throw i;
        }
        c.E(12);
        throw i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f
    protected kotlin.i0.z.e.m0.d.a.f0.c s1(m m, x x2, b.a b$a3, e e4, g g5, u0 u06) {
        b.a dECLARATION;
        int obj10 = 0;
        if (m == null) {
        } else {
            if (a3 == null) {
            } else {
                if (g5 == null) {
                } else {
                    if (u06 == null) {
                    } else {
                        if (a3 != b.a.DECLARATION) {
                            if (a3 != b.a.SYNTHESIZED) {
                            } else {
                            }
                            obj10 = new StringBuilder();
                            obj10.append("Attempt at creating a constructor that is not a declaration: \ncopy from: ");
                            obj10.append(this);
                            String obj11 = "\n";
                            obj10.append(obj11);
                            obj10.append("newOwner: ");
                            obj10.append(m);
                            obj10.append(obj11);
                            obj10.append("kind: ");
                            obj10.append(a3);
                            IllegalStateException obj8 = new IllegalStateException(obj10.toString());
                            throw obj8;
                        }
                        kotlin.i0.z.e.m0.d.a.f0.c obj7 = this.q1((e)m, (c)x2, a3, u06, g5);
                        obj7.X0(P0());
                        obj7.Y0(D());
                        if (obj7 == null) {
                        } else {
                            return obj7;
                        }
                        c.E(11);
                        throw obj10;
                    }
                    c.E(10);
                    throw obj10;
                }
                c.E(9);
                throw obj10;
            }
            c.E(8);
            throw obj10;
        }
        c.E(7);
        throw obj10;
    }

    public kotlin.i0.z.e.m0.d.a.f0.c t1(b0 b0, List<kotlin.i0.z.e.m0.d.a.f0.l> list2, b0 b03, o<a.a<?>, ?> o4) {
        Object b0Var;
        Object list;
        Object collection;
        g gVar;
        int i;
        final int i5 = 0;
        if (list2 == null) {
        } else {
            if (b03 == null) {
            } else {
                final kotlin.i0.z.e.m0.d.a.f0.c cVar2 = this.s1(n1(), 0, f(), 0, getAnnotations(), getSource());
                if (b0 == null) {
                    i = i5;
                } else {
                    i = b0Var;
                }
                cVar2.Q0(i, f0(), getTypeParameters(), k.a(list2, h(), cVar2), b03, i(), getVisibility());
                if (o4 != null) {
                    cVar2.T0((a.a)o4.c(), o4.d());
                }
                if (cVar2 == null) {
                } else {
                    return cVar2;
                }
                c.E(18);
                throw i5;
            }
            c.E(17);
            throw i5;
        }
        c.E(16);
        throw i5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f
    public kotlin.i0.z.e.m0.d.a.f0.b v(b0 b0, List list2, b0 b03, o o4) {
        return t1(b0, list2, b03, o4);
    }
}
