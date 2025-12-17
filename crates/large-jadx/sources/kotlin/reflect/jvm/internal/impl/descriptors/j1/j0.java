package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import java.util.ArrayList;
import java.util.List;
import kotlin.d0.c.l;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.d;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.k.n;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.d0;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.descriptors.x0.a;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* loaded from: classes3.dex */
public class j0 extends kotlin.reflect.jvm.internal.impl.descriptors.j1.e {

    private final l<b0, Void> C;
    private final List<b0> D;
    private boolean E;
    private j0(m m, g g2, boolean z3, h1 h14, e e5, int i6, u0 u07, l<b0, Void> l8, x0 x09, n n10) {
        final Object obj2 = this;
        int i = 0;
        if (m == null) {
        } else {
            if (g2 == null) {
            } else {
                if (h14 == null) {
                } else {
                    if (e5 == null) {
                    } else {
                        if (u07 == null) {
                        } else {
                            if (x09 == null) {
                            } else {
                                if (n10 == null) {
                                } else {
                                    super(n10, m, g2, e5, h14, z3, i6, u07, x09);
                                    ArrayList arrayList = new ArrayList(1);
                                    obj2.D = arrayList;
                                    obj2.E = false;
                                    obj2.C = l8;
                                }
                                j0.E(25);
                                throw i;
                            }
                            j0.E(24);
                            throw i;
                        }
                        j0.E(23);
                        throw i;
                    }
                    j0.E(22);
                    throw i;
                }
                j0.E(21);
                throw i;
            }
            j0.E(20);
            throw i;
        }
        j0.E(19);
        throw i;
    }

    private static void E(int i) {
        String str3;
        int i2;
        String str;
        String str2;
        Object obj8;
        final int i3 = 28;
        final int i4 = 5;
        if (i != i4 && i != i3) {
            str3 = i != i3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        } else {
        }
        final int i5 = 2;
        if (i != i4 && i != i3) {
            i2 = i != i3 ? 3 : i5;
        } else {
        }
        Object[] arr = new Object[i2];
        str = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
        int i6 = 0;
        switch (i) {
            case 1:
                arr[i6] = "annotations";
                break;
            case 2:
                arr[i6] = "variance";
                break;
            case 3:
                arr[i6] = "name";
                break;
            case 4:
                arr[i6] = "storageManager";
                break;
            case 5:
                arr[i6] = str;
                break;
            case 6:
                arr[i6] = "containingDeclaration";
                break;
            case 7:
                arr[i6] = "source";
                break;
            case 8:
                arr[i6] = "supertypeLoopsResolver";
                break;
            case 9:
                arr[i6] = "supertypeLoopsChecker";
                break;
            case 10:
                arr[i6] = "bound";
                break;
            default:
                arr[i6] = "type";
        }
        String str4 = "createWithDefaultBound";
        int i7 = 1;
        if (i != i4) {
            if (i != i3) {
                arr[i7] = str;
            } else {
                arr[i7] = "resolveUpperBounds";
            }
        } else {
            arr[i7] = str4;
        }
        switch (i) {
            case 6:
                arr[i5] = "createForFurtherModification";
                break;
            case 7:
                arr[i5] = "<init>";
                break;
            case 8:
                arr[i5] = "addUpperBound";
                break;
            case 9:
                arr[i5] = "reportSupertypeLoopError";
                break;
            default:
                arr[i5] = str4;
        }
        String format = String.format(str3, arr);
        if (i != i4 && i != i3) {
            if (i != i3) {
                obj8 = new IllegalArgumentException(format);
            } else {
                obj8 = new IllegalStateException(format);
            }
        } else {
        }
        throw obj8;
    }

    private void M0() {
        if (!this.E) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Type parameter descriptor is not initialized: ");
        stringBuilder.append(S0());
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    private void N0() {
        if (this.E) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Type parameter descriptor is already initialized: ");
        stringBuilder.append(S0());
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    public static kotlin.reflect.jvm.internal.impl.descriptors.j1.j0 O0(m m, g g2, boolean z3, h1 h14, e e5, int i6, u0 u07, l<b0, Void> l8, x0 x09, n n10) {
        int i = 0;
        if (m == null) {
        } else {
            if (g2 == null) {
            } else {
                if (h14 == null) {
                } else {
                    if (e5 == null) {
                    } else {
                        if (u07 == null) {
                        } else {
                            if (x09 == null) {
                            } else {
                                if (n10 == null) {
                                } else {
                                    super(m, g2, z3, h14, e5, i6, u07, l8, x09, n10);
                                    return j0Var;
                                }
                                j0.E(18);
                                throw i;
                            }
                            j0.E(17);
                            throw i;
                        }
                        j0.E(16);
                        throw i;
                    }
                    j0.E(15);
                    throw i;
                }
                j0.E(14);
                throw i;
            }
            j0.E(13);
            throw i;
        }
        j0.E(12);
        throw i;
    }

    public static kotlin.reflect.jvm.internal.impl.descriptors.j1.j0 P0(m m, g g2, boolean z3, h1 h14, e e5, int i6, u0 u07, n n8) {
        int i = 0;
        if (m == null) {
        } else {
            if (g2 == null) {
            } else {
                if (h14 == null) {
                } else {
                    if (e5 == null) {
                    } else {
                        if (u07 == null) {
                        } else {
                            if (n8 == null) {
                            } else {
                                return j0.O0(m, g2, z3, h14, e5, i6, u07, 0, x0.a.a, n8);
                            }
                            j0.E(11);
                            throw i;
                        }
                        j0.E(10);
                        throw i;
                    }
                    j0.E(9);
                    throw i;
                }
                j0.E(8);
                throw i;
            }
            j0.E(7);
            throw i;
        }
        j0.E(6);
        throw i;
    }

    public static z0 Q0(m m, g g2, boolean z3, h1 h14, e e5, int i6, n n7) {
        final int i = 0;
        if (m == null) {
        } else {
            if (g2 == null) {
            } else {
                if (h14 == null) {
                } else {
                    if (e5 == null) {
                    } else {
                        if (n7 == null) {
                        } else {
                            final kotlin.reflect.jvm.internal.impl.descriptors.j1.j0 obj10 = j0.P0(m, g2, z3, h14, e5, i6, u0.a, n7);
                            obj10.L0(a.g(m).y());
                            obj10.T0();
                            if (obj10 == null) {
                            } else {
                                return obj10;
                            }
                            j0.E(5);
                            throw i;
                        }
                        j0.E(4);
                        throw i;
                    }
                    j0.E(3);
                    throw i;
                }
                j0.E(2);
                throw i;
            }
            j0.E(1);
            throw i;
        }
        j0.E(0);
        throw i;
    }

    private void R0(b0 b0) {
        if (d0.a(b0)) {
        }
        this.D.add(b0);
    }

    private String S0() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getName());
        stringBuilder.append(" declared in ");
        stringBuilder.append(d.m(b()));
        return stringBuilder.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.e
    protected void J0(b0 b0) {
        if (b0 == null) {
        } else {
            final l lVar = this.C;
            if (lVar == null) {
            }
            lVar.invoke(b0);
        }
        j0.E(27);
        throw 0;
    }

    protected List<b0> K0() {
        M0();
        List list = this.D;
        if (list == null) {
        } else {
            return list;
        }
        j0.E(28);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.e
    public void L0(b0 b0) {
        if (b0 == null) {
        } else {
            N0();
            R0(b0);
        }
        j0.E(26);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.e
    public void T0() {
        N0();
        this.E = true;
    }
}
