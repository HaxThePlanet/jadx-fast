package kotlin.i0.z.e.m0.d.a.f0;

import java.util.List;
import java.util.Map;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.c;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.m.a;
import kotlin.i0.z.e.m0.m.c;
import kotlin.i0.z.e.m0.m.i;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.descriptors.a.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b.a;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.j;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.p;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.r0;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.x.a;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* loaded from: classes3.dex */
public class f extends f0 implements kotlin.i0.z.e.m0.d.a.f0.b {

    public static final a.a<c1> X;
    private kotlin.i0.z.e.m0.d.a.f0.f.b V = null;
    private final boolean W;

    private static enum b {

        NON_STABLE_DECLARED(false, false),
        STABLE_DECLARED(true, false),
        NON_STABLE_SYNTHESIZED(false, true),
        STABLE_SYNTHESIZED(true, true);

        public final boolean isStable;
        public final boolean isSynthesized;
        private static void $$$reportNull$$$0(int i) {
            Object[] obj2 = new Object[2];
            IllegalStateException illegalStateException = new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor$ParameterNamesStatus", "get"));
            throw illegalStateException;
        }

        public static kotlin.i0.z.e.m0.d.a.f0.f.b get(boolean z, boolean z2) {
            kotlin.i0.z.e.m0.d.a.f0.f.b obj0;
            int obj1;
            if (z) {
                obj0 = z2 != 0 ? f.b.STABLE_SYNTHESIZED : f.b.STABLE_DECLARED;
            } else {
                obj0 = z2 != 0 ? f.b.NON_STABLE_SYNTHESIZED : f.b.NON_STABLE_DECLARED;
            }
            if (obj0 == null) {
                f.b.$$$reportNull$$$0(0);
            }
            return obj0;
        }
    }

    static class a implements a.a<c1> {
    }
    static {
        f.a aVar = new f.a();
        f.X = aVar;
    }

    protected f(m m, t0 t02, g g3, e e4, b.a b$a5, u0 u06, boolean z7) {
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
                            this.W = z7;
                        }
                        f.E(4);
                        throw i;
                    }
                    f.E(3);
                    throw i;
                }
                f.E(2);
                throw i;
            }
            f.E(1);
            throw i;
        }
        f.E(0);
        throw i;
    }

    private static void E(int i) {
        String str3;
        int i2;
        String str;
        String str2;
        Object obj11;
        final int i4 = 20;
        final int i5 = 17;
        final int i6 = 12;
        if (i != i6 && i != i5 && i != i4) {
            if (i != i5) {
                str3 = i != i4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            } else {
            }
        } else {
        }
        final int i7 = 2;
        if (i != i6 && i != i5 && i != i4) {
            if (i != i5) {
                i2 = i != i4 ? 3 : i7;
            } else {
            }
        } else {
        }
        Object[] arr = new Object[i2];
        str = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
        int i8 = 0;
        switch (i) {
            case 1:
                arr[i8] = "annotations";
                break;
            case 2:
                arr[i8] = "name";
                break;
            case 3:
                arr[i8] = "kind";
                break;
            case 4:
                arr[i8] = "source";
                break;
            case 5:
                arr[i8] = "containingDeclaration";
                break;
            case 6:
                arr[i8] = "typeParameters";
                break;
            case 7:
                arr[i8] = "unsubstitutedValueParameters";
                break;
            case 8:
                arr[i8] = "visibility";
                break;
            case 9:
                arr[i8] = str;
                break;
            case 10:
                arr[i8] = "newOwner";
                break;
            case 11:
                arr[i8] = "enhancedValueParametersData";
                break;
            default:
                arr[i8] = "enhancedReturnType";
        }
        String str4 = "enhance";
        String str5 = "createSubstitutedCopy";
        final String str6 = "initialize";
        final int i9 = 1;
        if (i != i6) {
            if (i != i5) {
                if (i != i4) {
                    arr[i9] = str;
                } else {
                    arr[i9] = str4;
                }
            } else {
                arr[i9] = str5;
            }
        } else {
            arr[i9] = str6;
        }
        switch (i) {
            case 5:
                arr[i7] = "createJavaMethod";
                break;
            case 6:
                arr[i7] = str6;
                break;
            case 8:
                arr[i7] = str5;
                break;
            case 9:
                arr[i7] = str4;
                break;
            default:
                arr[i7] = "<init>";
        }
        String format = String.format(str3, arr);
        if (i != i6 && i != i5 && i != i4) {
            if (i != i5) {
                if (i != i4) {
                    obj11 = new IllegalArgumentException(format);
                } else {
                    obj11 = new IllegalStateException(format);
                }
            } else {
            }
        } else {
        }
        throw obj11;
    }

    public static kotlin.i0.z.e.m0.d.a.f0.f o1(m m, g g2, e e3, u0 u04, boolean z5) {
        int i = 0;
        if (m == null) {
        } else {
            if (g2 == null) {
            } else {
                if (e3 == null) {
                } else {
                    if (u04 == null) {
                    } else {
                        super(m, 0, g2, e3, b.a.DECLARATION, u04, z5);
                        return fVar;
                    }
                    f.E(8);
                    throw i;
                }
                f.E(7);
                throw i;
            }
            f.E(6);
            throw i;
        }
        f.E(5);
        throw i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f0
    public boolean D() {
        return bVar.isSynthesized;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f0
    protected p K0(m m, x x2, b.a b$a3, e e4, g g5, u0 u06) {
        return p1(m, x2, a3, e4, g5, u06);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f0
    public boolean P0() {
        return bVar.isStable;
    }

    public f0 n1(r0 r0, r0 r02, List<? extends z0> list3, List<c1> list4, b0 b05, z z6, u u7, Map<? extends a.a<?>, ?> map8) {
        final int i = 0;
        if (list3 == null) {
        } else {
            if (list4 == null) {
            } else {
                if (u7 == null) {
                } else {
                    super.n1(r0, r02, list3, list4, b05, z6, u7, map8);
                    e1(i.a.a(this).a());
                    return this;
                }
                f.E(11);
                throw i;
            }
            f.E(10);
            throw i;
        }
        f.E(9);
        throw i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f0
    protected kotlin.i0.z.e.m0.d.a.f0.f p1(m m, x x2, b.a b$a3, e e4, g g5, u0 u06) {
        e obj13;
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
                            obj13 = getName();
                        }
                        super(m, (t0)x2, g5, obj13, a3, u06, this.W);
                        fVar.r1(P0(), D());
                        return fVar;
                    }
                    f.E(16);
                    throw i;
                }
                f.E(15);
                throw i;
            }
            f.E(14);
            throw i;
        }
        f.E(13);
        throw i;
    }

    public kotlin.i0.z.e.m0.d.a.f0.f q1(b0 b0, List<kotlin.i0.z.e.m0.d.a.f0.l> list2, b0 b03, o<a.a<?>, ?> o4) {
        Object list;
        int obj3;
        Object obj4;
        Object obj5;
        final int i = 0;
        if (list2 == null) {
        } else {
            if (b03 == null) {
            } else {
                if (b0 == null) {
                    obj3 = i;
                } else {
                    obj3 = c.f(this, b0, g.q.b());
                }
                obj3 = s().b(k.a(list2, h(), this)).f(b03).j(obj3).a().e().build();
                if (o4 != null) {
                    (f)obj3.T0((a.a)o4.c(), o4.d());
                }
                if (obj3 == null) {
                } else {
                    return obj3;
                }
                f.E(20);
                throw i;
            }
            f.E(19);
            throw i;
        }
        f.E(18);
        throw i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f0
    public void r1(boolean z, boolean z2) {
        this.V = f.b.get(z, z2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f0
    public kotlin.i0.z.e.m0.d.a.f0.b v(b0 b0, List list2, b0 b03, o o4) {
        return q1(b0, list2, b03, o4);
    }
}
