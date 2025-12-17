package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.a.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.b.a;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.p;
import kotlin.reflect.jvm.internal.impl.descriptors.r0;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.x.a;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* loaded from: classes3.dex */
public class f0 extends kotlin.reflect.jvm.internal.impl.descriptors.j1.p implements t0 {
    protected f0(m m, t0 t02, g g3, e e4, b.a b$a5, u0 u06) {
        final int i = 0;
        if (m == null) {
        } else {
            if (g3 == null) {
            } else {
                if (e4 == null) {
                } else {
                    if (a5 == null) {
                    } else {
                        if (u06 == null) {
                        } else {
                            super(m, t02, g3, e4, a5, u06);
                        }
                        f0.E(4);
                        throw i;
                    }
                    f0.E(3);
                    throw i;
                }
                f0.E(2);
                throw i;
            }
            f0.E(1);
            throw i;
        }
        f0.E(0);
        throw i;
    }

    private static void E(int i) {
        String str2;
        int i2;
        String str;
        String str3;
        Object obj11;
        final int i3 = 24;
        final int i4 = 23;
        final int i5 = 18;
        final int i6 = 17;
        final int i7 = 13;
        if (i != i7 && i != i6 && i != i5 && i != i4 && i != i3) {
            if (i != i6) {
                if (i != i5) {
                    if (i != i4) {
                        str2 = i != i3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        final int i8 = 2;
        if (i != i7 && i != i6 && i != i5 && i != i4 && i != i3) {
            if (i != i6) {
                if (i != i5) {
                    if (i != i4) {
                        i2 = i != i3 ? 3 : i8;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        Object[] arr = new Object[i2];
        str = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
        int i9 = 0;
        switch (i) {
            case 1:
                arr[i9] = "annotations";
                break;
            case 2:
                arr[i9] = "name";
                break;
            case 3:
                arr[i9] = "kind";
                break;
            case 4:
                arr[i9] = "source";
                break;
            case 5:
                arr[i9] = "containingDeclaration";
                break;
            case 6:
                arr[i9] = "typeParameters";
                break;
            case 7:
                arr[i9] = "unsubstitutedValueParameters";
                break;
            case 8:
                arr[i9] = "visibility";
                break;
            case 9:
                arr[i9] = str;
                break;
            default:
                arr[i9] = "newOwner";
        }
        String str4 = "initialize";
        int i10 = 1;
        if (i != i7 && i != i6) {
            if (i != i6) {
                if (i != i5) {
                    if (i != i4) {
                        if (i != i3) {
                            arr[i10] = str;
                        } else {
                            arr[i10] = "newCopyBuilder";
                        }
                    } else {
                        arr[i10] = "copy";
                    }
                } else {
                    arr[i10] = "getOriginal";
                }
            } else {
                arr[i10] = str4;
            }
        } else {
        }
        switch (i) {
            case 5:
                arr[i8] = "create";
                break;
            case 6:
                arr[i8] = str4;
                break;
            case 8:
                arr[i8] = "createSubstitutedCopy";
                break;
            default:
                arr[i8] = "<init>";
        }
        String format = String.format(str2, arr);
        if (i != i7 && i != i6 && i != i5 && i != i4 && i != i3) {
            if (i != i6) {
                if (i != i5) {
                    if (i != i4) {
                        if (i != i3) {
                            obj11 = new IllegalArgumentException(format);
                        } else {
                            obj11 = new IllegalStateException(format);
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        throw obj11;
    }

    public static kotlin.reflect.jvm.internal.impl.descriptors.j1.f0 k1(m m, g g2, e e3, b.a b$a4, u0 u05) {
        int i = 0;
        if (m == null) {
        } else {
            if (g2 == null) {
            } else {
                if (e3 == null) {
                } else {
                    if (a4 == null) {
                    } else {
                        if (u05 == null) {
                        } else {
                            super(m, 0, g2, e3, a4, u05);
                            return f0Var;
                        }
                        f0.E(9);
                        throw i;
                    }
                    f0.E(8);
                    throw i;
                }
                f0.E(7);
                throw i;
            }
            f0.E(6);
            throw i;
        }
        f0.E(5);
        throw i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public p J() {
        return l1();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public x J0(m m, z z2, u u3, b.a b$a4, boolean z5) {
        return j1(m, z2, u3, a4, z5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    protected kotlin.reflect.jvm.internal.impl.descriptors.j1.p K0(m m, x x2, b.a b$a3, e e4, g g5, u0 u06) {
        e obj12;
        int i = 0;
        if (m == null) {
        } else {
            if (a3 == null) {
            } else {
                if (g5 == null) {
                } else {
                    if (u06 == null) {
                    } else {
                        if (e4 != null) {
                        } else {
                            obj12 = getName();
                        }
                        super(m, (t0)x2, g5, obj12, a3, u06);
                        return f0Var;
                    }
                    f0.E(22);
                    throw i;
                }
                f0.E(21);
                throw i;
            }
            f0.E(20);
            throw i;
        }
        f0.E(19);
        throw i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public kotlin.reflect.jvm.internal.impl.descriptors.j1.p Q0(r0 r0, r0 r02, List list3, List list4, b0 b05, z z6, u u7) {
        return m1(r0, r02, list3, list4, b05, z6, u7);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public a a() {
        return l1();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public b a() {
        return l1();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public m a() {
        return l1();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public x a() {
        return l1();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public t0 j1(m m, z z2, u u3, b.a b$a4, boolean z5) {
        x obj1 = super.J0(m, z2, u3, a4, z5);
        if ((t0)obj1 == null) {
        } else {
            return (t0)obj1;
        }
        f0.E(23);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public b k0(m m, z z2, u u3, b.a b$a4, boolean z5) {
        return j1(m, z2, u3, a4, z5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public t0 l1() {
        x xVar = super.a();
        if ((t0)xVar == null) {
        } else {
            return (t0)xVar;
        }
        f0.E(18);
        throw 0;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.j1.f0 m1(r0 r0, r0 r02, List<? extends z0> list3, List<c1> list4, b0 b05, z z6, u u7) {
        final int i = 0;
        if (list3 == null) {
        } else {
            if (list4 == null) {
            } else {
                if (u7 == null) {
                } else {
                    kotlin.reflect.jvm.internal.impl.descriptors.j1.f0 f0Var = this.n1(r0, r02, list3, list4, b05, z6, u7, 0);
                    if (f0Var == null) {
                    } else {
                        return f0Var;
                    }
                    f0.E(13);
                    throw i;
                }
                f0.E(12);
                throw i;
            }
            f0.E(11);
            throw i;
        }
        f0.E(10);
        throw i;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.j1.f0 n1(r0 r0, r0 r02, List<? extends z0> list3, List<c1> list4, b0 b05, z z6, u u7, Map<? extends a.a<?>, ?> map8) {
        r0 obj2;
        final int i = 0;
        if (list3 == null) {
        } else {
            if (list4 == null) {
            } else {
                if (u7 == null) {
                } else {
                    super.Q0(r0, r02, list3, list4, b05, z6, u7);
                    if (map8 != null && !map8.isEmpty()) {
                        if (!map8.isEmpty()) {
                            obj2 = new LinkedHashMap(map8);
                            this.U = obj2;
                        }
                    }
                    return this;
                }
                f0.E(16);
                throw i;
            }
            f0.E(15);
            throw i;
        }
        f0.E(14);
        throw i;
    }

    public x.a<? extends t0> s() {
        x.a aVar = super.s();
        if (aVar == null) {
        } else {
            return aVar;
        }
        f0.E(24);
        throw 0;
    }
}
