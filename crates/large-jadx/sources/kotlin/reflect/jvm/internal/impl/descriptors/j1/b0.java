package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.i.v.o.b;
import kotlin.i0.z.e.m0.l.a1;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.i0.z.e.m0.l.o;
import kotlin.i0.z.e.m0.l.y0;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.b.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.b;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n;
import kotlin.reflect.jvm.internal.impl.descriptors.n0;
import kotlin.reflect.jvm.internal.impl.descriptors.o;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.p;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.q0;
import kotlin.reflect.jvm.internal.impl.descriptors.r0;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.v;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.utils.j;

/* loaded from: classes3.dex */
public class b0 extends kotlin.reflect.jvm.internal.impl.descriptors.j1.m0 implements o0 {

    private u A;
    private Collection<? extends o0> B;
    private final o0 C;
    private final b.a D;
    private final boolean E;
    private final boolean F;
    private final boolean G;
    private final boolean H;
    private final boolean I;
    private final boolean J;
    private r0 K;
    private r0 L;
    private List<z0> M;
    private kotlin.reflect.jvm.internal.impl.descriptors.j1.c0 N;
    private q0 O;
    private boolean P;
    private v Q;
    private v R;
    private final z z;

    public class a {

        private m a;
        private z b;
        private u c;
        private o0 d = null;
        private boolean e = false;
        private b.a f;
        private y0 g;
        private boolean h = true;
        private r0 i;
        private List<z0> j = null;
        private e k;
        private b0 l;
        final kotlin.reflect.jvm.internal.impl.descriptors.j1.b0 m;
        public a(kotlin.reflect.jvm.internal.impl.descriptors.j1.b0 b0) {
            this.m = b0;
            super();
            this.a = b0.b();
            this.b = b0.i();
            this.c = b0.getVisibility();
            int i = 0;
            int i2 = 0;
            this.f = b0.f();
            this.g = y0.a;
            int i3 = 1;
            this.i = b0.K0(b0);
            this.k = b0.getName();
            this.l = b0.getType();
        }

        private static void a(int i) {
            Object illegalArgumentException;
            String str3;
            int i2;
            String str;
            String str2;
            int i4 = i;
            final int i5 = 17;
            final int i6 = 16;
            final int i7 = 14;
            final int i8 = 13;
            final int i9 = 19;
            final int i10 = 11;
            final int i11 = 9;
            final int i12 = 7;
            final int i13 = 5;
            final int i14 = 3;
            final int i15 = 2;
            final int i16 = 1;
            if (i4 != i16 && i4 != i15 && i4 != i14 && i4 != i13 && i4 != i12 && i4 != i11 && i4 != i10 && i4 != i9 && i4 != i8 && i4 != i7 && i4 != i6 && i4 != i5) {
                if (i4 != i15) {
                    if (i4 != i14) {
                        if (i4 != i13) {
                            if (i4 != i12) {
                                if (i4 != i11) {
                                    if (i4 != i10) {
                                        if (i4 != i9) {
                                            if (i4 != i8) {
                                                if (i4 != i7) {
                                                    if (i4 != i6) {
                                                        str3 = i4 != i5 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
                                                    } else {
                                                    }
                                                } else {
                                                }
                                            } else {
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            if (i4 != i16 && i4 != i15 && i4 != i14 && i4 != i13 && i4 != i12 && i4 != i11 && i4 != i10 && i4 != i9 && i4 != i8 && i4 != i7 && i4 != i6 && i4 != i5) {
                if (i4 != i15) {
                    if (i4 != i14) {
                        if (i4 != i13) {
                            if (i4 != i12) {
                                if (i4 != i11) {
                                    if (i4 != i10) {
                                        if (i4 != i9) {
                                            if (i4 != i8) {
                                                if (i4 != i7) {
                                                    if (i4 != i6) {
                                                        i2 = i4 != i5 ? i14 : i15;
                                                    } else {
                                                    }
                                                } else {
                                                }
                                            } else {
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            Object[] arr = new Object[i2];
            str = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
            int i17 = 0;
            switch (i4) {
                case 1:
                    arr[i17] = str;
                    break;
                case 2:
                    arr[i17] = "type";
                    break;
                case 3:
                    arr[i17] = "modality";
                    break;
                case 4:
                    arr[i17] = "visibility";
                    break;
                case 5:
                    arr[i17] = "kind";
                    break;
                case 6:
                    arr[i17] = "typeParameters";
                    break;
                case 7:
                    arr[i17] = "substitution";
                    break;
                case 8:
                    arr[i17] = "name";
                    break;
                default:
                    arr[i17] = "owner";
            }
            String str4 = "setName";
            String str5 = "setSubstitution";
            final String str6 = "setTypeParameters";
            final String str7 = "setKind";
            final String str8 = "setVisibility";
            final String str9 = "setModality";
            final String str10 = "setReturnType";
            final String str11 = "setOwner";
            if (i4 != i16) {
                if (i4 != i15) {
                    if (i4 != i14) {
                        if (i4 != i13) {
                            if (i4 != i12) {
                                if (i4 != i11) {
                                    if (i4 != i10) {
                                        if (i4 != i9) {
                                            if (i4 != i8) {
                                                if (i4 != i7) {
                                                    if (i4 != i6) {
                                                        if (i4 != i5) {
                                                            arr[i16] = str;
                                                        } else {
                                                            arr[i16] = "setCopyOverrides";
                                                        }
                                                    } else {
                                                        arr[i16] = str5;
                                                    }
                                                } else {
                                                    arr[i16] = "setDispatchReceiverParameter";
                                                }
                                            } else {
                                                arr[i16] = str6;
                                            }
                                        } else {
                                            arr[i16] = str4;
                                        }
                                    } else {
                                        arr[i16] = str7;
                                    }
                                } else {
                                    arr[i16] = str8;
                                }
                            } else {
                                arr[i16] = str9;
                            }
                        } else {
                            arr[i16] = str10;
                        }
                    } else {
                        arr[i16] = "setPreserveSourceElement";
                    }
                } else {
                    arr[i16] = "setOriginal";
                }
            } else {
                arr[i16] = str11;
            }
            switch (i4) {
                case 2:
                    arr[i15] = str10;
                    break;
                case 3:
                    arr[i15] = str9;
                    break;
                case 4:
                    arr[i15] = str8;
                    break;
                case 5:
                    arr[i15] = str7;
                    break;
                case 6:
                    arr[i15] = str6;
                    break;
                case 7:
                    arr[i15] = str5;
                    break;
                case 8:
                    arr[i15] = str4;
                    break;
                default:
                    arr[i15] = str11;
            }
            String format = String.format(str3, arr);
            if (i4 != i16 && i4 != i15 && i4 != i14 && i4 != i13 && i4 != i12 && i4 != i11 && i4 != i10 && i4 != i9 && i4 != i8 && i4 != i7 && i4 != i6 && i4 != i5) {
                if (i4 != i15) {
                    if (i4 != i14) {
                        if (i4 != i13) {
                            if (i4 != i12) {
                                if (i4 != i11) {
                                    if (i4 != i10) {
                                        if (i4 != i9) {
                                            if (i4 != i8) {
                                                if (i4 != i7) {
                                                    if (i4 != i6) {
                                                        if (i4 != i5) {
                                                            illegalArgumentException = new IllegalArgumentException(format);
                                                        } else {
                                                            illegalArgumentException = new IllegalStateException(format);
                                                        }
                                                    } else {
                                                    }
                                                } else {
                                                }
                                            } else {
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            throw illegalArgumentException;
        }

        static m b(kotlin.reflect.jvm.internal.impl.descriptors.j1.b0.a b0$a) {
            return a.a;
        }

        static b0 c(kotlin.reflect.jvm.internal.impl.descriptors.j1.b0.a b0$a) {
            return a.l;
        }

        static r0 d(kotlin.reflect.jvm.internal.impl.descriptors.j1.b0.a b0$a) {
            return a.i;
        }

        static boolean e(kotlin.reflect.jvm.internal.impl.descriptors.j1.b0.a b0$a) {
            return a.h;
        }

        static z f(kotlin.reflect.jvm.internal.impl.descriptors.j1.b0.a b0$a) {
            return a.b;
        }

        static u g(kotlin.reflect.jvm.internal.impl.descriptors.j1.b0.a b0$a) {
            return a.c;
        }

        static o0 h(kotlin.reflect.jvm.internal.impl.descriptors.j1.b0.a b0$a) {
            return a.d;
        }

        static b.a i(kotlin.reflect.jvm.internal.impl.descriptors.j1.b0.a b0$a) {
            return a.f;
        }

        static e j(kotlin.reflect.jvm.internal.impl.descriptors.j1.b0.a b0$a) {
            return a.k;
        }

        static boolean k(kotlin.reflect.jvm.internal.impl.descriptors.j1.b0.a b0$a) {
            return a.e;
        }

        static List l(kotlin.reflect.jvm.internal.impl.descriptors.j1.b0.a b0$a) {
            return a.j;
        }

        static y0 m(kotlin.reflect.jvm.internal.impl.descriptors.j1.b0.a b0$a) {
            return a.g;
        }

        public o0 n() {
            return this.m.O0(this);
        }

        p0 o() {
            o0 o0Var = this.d;
            if (o0Var == null) {
                return null;
            }
            return o0Var.getGetter();
        }

        q0 p() {
            o0 o0Var = this.d;
            if (o0Var == null) {
                return null;
            }
            return o0Var.getSetter();
        }

        public kotlin.reflect.jvm.internal.impl.descriptors.j1.b0.a q(boolean z) {
            this.h = z;
            return this;
        }

        public kotlin.reflect.jvm.internal.impl.descriptors.j1.b0.a r(b.a b$a) {
            if (a == null) {
            } else {
                this.f = a;
                return this;
            }
            b0.a.a(10);
            throw 0;
        }

        public kotlin.reflect.jvm.internal.impl.descriptors.j1.b0.a s(z z) {
            if (z == null) {
            } else {
                this.b = z;
                return this;
            }
            b0.a.a(6);
            throw 0;
        }

        public kotlin.reflect.jvm.internal.impl.descriptors.j1.b0.a t(b b) {
            this.d = (o0)b;
            return this;
        }

        public kotlin.reflect.jvm.internal.impl.descriptors.j1.b0.a u(m m) {
            if (m == null) {
            } else {
                this.a = m;
                return this;
            }
            b0.a.a(0);
            throw 0;
        }

        public kotlin.reflect.jvm.internal.impl.descriptors.j1.b0.a v(y0 y0) {
            if (y0 == null) {
            } else {
                this.g = y0;
                return this;
            }
            b0.a.a(15);
            throw 0;
        }

        public kotlin.reflect.jvm.internal.impl.descriptors.j1.b0.a w(u u) {
            if (u == null) {
            } else {
                this.c = u;
                return this;
            }
            b0.a.a(8);
            throw 0;
        }
    }
    protected b0(m m, o0 o02, g g3, z z4, u u5, boolean z6, e e7, b.a b$a8, u0 u09, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        Object obj;
        final Object obj3 = this;
        final z zVar = z4;
        final u uVar = u5;
        final b.a aVar = a8;
        final int i9 = 0;
        if (m == null) {
        } else {
            if (g3 == null) {
            } else {
                if (zVar == null) {
                } else {
                    if (uVar == null) {
                    } else {
                        if (e7 == null) {
                        } else {
                            if (aVar == null) {
                            } else {
                                if (u09 == null) {
                                } else {
                                    super(m, g3, e7, 0, z6, u09);
                                    obj3.B = i9;
                                    obj3.z = zVar;
                                    obj3.A = uVar;
                                    obj = o02 == null ? obj3 : o02;
                                    obj3.C = obj;
                                    obj3.D = aVar;
                                    obj3.E = z10;
                                    obj3.F = z11;
                                    obj3.G = z12;
                                    obj3.H = z13;
                                    obj3.I = z14;
                                    obj3.J = z15;
                                }
                                b0.E(6);
                                throw i9;
                            }
                            b0.E(5);
                            throw i9;
                        }
                        b0.E(4);
                        throw i9;
                    }
                    b0.E(3);
                    throw i9;
                }
                b0.E(2);
                throw i9;
            }
            b0.E(1);
            throw i9;
        }
        b0.E(0);
        throw i9;
    }

    private static void E(int i) {
        String str3;
        int i2;
        String str2;
        String str;
        Object obj11;
        final int i3 = 37;
        final int i4 = 36;
        final int i5 = 34;
        final int i6 = 33;
        final int i7 = 23;
        if (i != i7 && i != i6 && i != i5 && i != i4 && i != i3) {
            if (i != i6) {
                if (i != i5) {
                    if (i != i4) {
                        if (i != i3) {
                            str3 = /* condition */ ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        } else {
                        }
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
                        if (i != i3) {
                            i2 = /* condition */ ? i8 : 3;
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        Object[] arr = new Object[i2];
        str2 = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
        int i9 = 0;
        switch (i) {
            case 1:
                arr[i9] = "annotations";
                break;
            case 2:
                arr[i9] = "modality";
                break;
            case 3:
                arr[i9] = "visibility";
                break;
            case 4:
                arr[i9] = "name";
                break;
            case 5:
                arr[i9] = "kind";
                break;
            case 6:
                arr[i9] = "source";
                break;
            case 7:
                arr[i9] = "containingDeclaration";
                break;
            case 8:
                arr[i9] = "outType";
                break;
            case 9:
                arr[i9] = "typeParameters";
                break;
            case 10:
                arr[i9] = str2;
                break;
            case 11:
                arr[i9] = "originalSubstitutor";
                break;
            case 12:
                arr[i9] = "copyConfiguration";
                break;
            case 13:
                arr[i9] = "substitutor";
                break;
            case 14:
                arr[i9] = "accessorDescriptor";
                break;
            case 15:
                arr[i9] = "newOwner";
                break;
            case 16:
                arr[i9] = "newModality";
                break;
            case 17:
                arr[i9] = "newVisibility";
                break;
            case 18:
                arr[i9] = "newName";
                break;
            default:
                arr[i9] = "overriddenDescriptors";
        }
        int i10 = 1;
        if (i != i7) {
            if (i != i6) {
                if (i != i5) {
                    if (i != i4) {
                        if (i != i3) {
                            switch (i) {
                                case 17:
                                    arr[i10] = "getTypeParameters";
                                    break;
                                case 18:
                                    arr[i10] = "getReturnType";
                                    break;
                                case 19:
                                    arr[i10] = "getModality";
                                    break;
                                case 20:
                                    arr[i10] = "getVisibility";
                                    break;
                                case 21:
                                    arr[i10] = "getAccessors";
                                    break;
                                default:
                                    arr[i10] = str2;
                            }
                        } else {
                            arr[i10] = "copy";
                        }
                    } else {
                        arr[i10] = "getOverriddenDescriptors";
                    }
                } else {
                    arr[i10] = "getKind";
                }
            } else {
                arr[i10] = "getOriginal";
            }
        } else {
            arr[i10] = "getSourceToUseForCopy";
        }
        switch (i) {
            case 7:
                arr[i8] = "create";
                break;
            case 8:
                arr[i8] = "setType";
                break;
            case 9:
                arr[i8] = "setVisibility";
                break;
            case 11:
                arr[i8] = "substitute";
                break;
            case 12:
                arr[i8] = "doSubstitute";
                break;
            case 13:
                arr[i8] = "getSubstitutedInitialSignatureDescriptor";
                break;
            case 14:
                arr[i8] = "createSubstitutedCopy";
                break;
            case 15:
                arr[i8] = "setOverriddenDescriptors";
                break;
            default:
                arr[i8] = "<init>";
        }
        String format = String.format(str3, arr);
        if (i != i7 && i != i6 && i != i5 && i != i4 && i != i3) {
            if (i != i6) {
                if (i != i5) {
                    if (i != i4) {
                        if (i != i3) {
                            if (/* condition */) {
                                obj11 = new IllegalStateException(format);
                            } else {
                                obj11 = new IllegalArgumentException(format);
                            }
                        } else {
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

    static r0 K0(kotlin.reflect.jvm.internal.impl.descriptors.j1.b0 b0) {
        return b0.K;
    }

    public static kotlin.reflect.jvm.internal.impl.descriptors.j1.b0 M0(m m, g g2, z z3, u u4, boolean z5, e e6, b.a b$a7, u0 u08, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
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
                            if (a7 == null) {
                            } else {
                                if (u08 == null) {
                                } else {
                                    super(m, 0, g2, z3, u4, z5, e6, a7, u08, z9, z10, z11, z12, z13, z14);
                                    return b0Var;
                                }
                                b0.E(13);
                                throw i;
                            }
                            b0.E(12);
                            throw i;
                        }
                        b0.E(11);
                        throw i;
                    }
                    b0.E(10);
                    throw i;
                }
                b0.E(9);
                throw i;
            }
            b0.E(8);
            throw i;
        }
        b0.E(7);
        throw i;
    }

    private u0 Q0(boolean z, o0 o02) {
        u0 obj1;
        o0 obj2;
        if (z) {
            if (o02 != null) {
            } else {
                obj2 = a();
            }
            obj1 = obj2.getSource();
        } else {
            obj1 = u0.a;
        }
        if (obj1 == null) {
        } else {
            return obj1;
        }
        b0.E(23);
        throw 0;
    }

    private static x R0(a1 a1, n0 n02) {
        int i;
        x obj3;
        i = 0;
        if (a1 == null) {
        } else {
            if (n02 == null) {
            } else {
                if (n02.d0() != null) {
                    i = n02.d0().c(a1);
                }
                return i;
            }
            b0.E(26);
            throw i;
        }
        b0.E(25);
        throw i;
    }

    private static u W0(u u, b.a b$a2) {
        u obj1;
        b.a obj2;
        if (a2 == b.a.FAKE_OVERRIDE && t.g(u.f())) {
            if (t.g(u.f())) {
                obj1 = t.h;
            }
        }
        return obj1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public boolean B0() {
        return this.H;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public p J() {
        return a();
    }

    public <R, D> R K(o<R, D> o, D d2) {
        return o.d(this, d2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public boolean L() {
        return this.G;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public o0 L0(m m, z z2, u u3, b.a b$a4, boolean z5) {
        final kotlin.reflect.jvm.internal.impl.descriptors.j1.b0.a aVar = V0();
        aVar.u(m);
        final int obj2 = 0;
        aVar.t(obj2);
        aVar.s(z2);
        aVar.w(u3);
        aVar.r(a4);
        aVar.q(z5);
        o0 obj3 = aVar.n();
        if (obj3 == null) {
        } else {
            return obj3;
        }
        b0.E(37);
        throw obj2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public boolean N() {
        return this.J;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    protected kotlin.reflect.jvm.internal.impl.descriptors.j1.b0 N0(m m, z z2, u u3, o0 o04, b.a b$a5, e e6, u0 u07) {
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
                                super(m, o04, getAnnotations(), z2, u3, j0(), e6, a5, u07, r0(), isConst(), L(), B0(), w(), N());
                                return b0Var;
                            }
                            b0.E(32);
                            throw i;
                        }
                        b0.E(31);
                        throw i;
                    }
                    b0.E(30);
                    throw i;
                }
                b0.E(29);
                throw i;
            }
            b0.E(28);
            throw i;
        }
        b0.E(27);
        throw i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    protected o0 O0(kotlin.reflect.jvm.internal.impl.descriptors.j1.b0.a b0$a) {
        List typeParameters;
        boolean const;
        kotlin.reflect.jvm.internal.impl.descriptors.j1.c0 c0Var;
        boolean z2;
        Object b0Var;
        kotlin.reflect.jvm.internal.impl.descriptors.j1.d0 d0Var;
        Object oUT_VARIANCE;
        List singletonList;
        Object annotations;
        Object annotations5;
        int i;
        kotlin.reflect.jvm.internal.impl.descriptors.j1.o oVar2;
        Object annotations3;
        kotlin.reflect.jvm.internal.impl.descriptors.j1.e0 annotations4;
        kotlin.reflect.jvm.internal.impl.descriptors.j1.o oVar;
        b bVar;
        kotlin.i0.z.e.m0.i.v.o.d value;
        g annotations2;
        z zVar;
        u uVar;
        boolean z3;
        boolean z4;
        boolean z;
        b.a aVar;
        p0 p0Var;
        u0 u0Var;
        final Object obj3 = this;
        oVar = 0;
        if (a == null) {
        } else {
            kotlin.reflect.jvm.internal.impl.descriptors.j1.b0 b0Var2 = this.N0(b0.a.b(a), b0.a.f(a), b0.a.g(a), b0.a.h(a), b0.a.i(a), b0.a.j(a), obj3.Q0(b0.a.k(a), b0.a.h(a)));
            if (b0.a.l(a) == null) {
                typeParameters = getTypeParameters();
            } else {
                typeParameters = b0.a.l(a);
            }
            ArrayList arrayList = new ArrayList(typeParameters.size());
            a1 a1Var = o.b(typeParameters, b0.a.m(a), b0Var2, arrayList);
            oUT_VARIANCE = h1.OUT_VARIANCE;
            b0Var = a1Var.p(b0.a.c(a), oUT_VARIANCE);
            if (b0Var == null) {
                return oVar;
            }
            r0 r0Var = b0.a.d(a);
            if (r0Var != null) {
                if (r0Var.c(a1Var) == null) {
                    return oVar;
                }
            } else {
                i = oVar;
            }
            annotations3 = obj3.L;
            if (annotations3 != null) {
                b0 b0Var4 = a1Var.p(annotations3.getType(), h1.IN_VARIANCE);
                if (b0Var4 == null) {
                    return oVar;
                }
                bVar = new b(b0Var2, b0Var4, obj3.L.getValue());
                annotations4 = new e0(b0Var2, bVar, obj3.L.getAnnotations());
            } else {
                annotations4 = oVar;
            }
            b0Var2.Y0(b0Var, arrayList, i, annotations4);
            if (obj3.N == null) {
                c0Var = oVar;
            } else {
                super(b0Var2, obj3.N.getAnnotations(), b0.a.f(a), b0.W0(obj3.N.getVisibility(), b0.a.i(a)), obj3.N.U(), obj3.N.w(), obj3.N.r(), b0.a.i(a), a.o(), u0.a);
            }
            if (c0Var != null) {
                b0 returnType = obj3.N.getReturnType();
                c0Var.M0(b0.R0(a1Var, obj3.N));
                if (returnType != null) {
                    b0Var = a1Var.p(returnType, oUT_VARIANCE);
                } else {
                    b0Var = oVar;
                }
                c0Var.P0(b0Var);
            }
            if (obj3.O == null) {
                d0Var = oVar;
            } else {
                super(b0Var2, obj3.O.getAnnotations(), b0.a.f(a), b0.W0(obj3.O.getVisibility(), b0.a.i(a)), obj3.O.U(), obj3.O.w(), obj3.O.r(), b0.a.i(a), a.p(), u0.a);
            }
            i = 0;
            int i3 = 1;
            if (d0Var != null && p.O0(d0Var, obj3.O.h(), a1Var, false, false, 0) == null) {
                i = 0;
                i3 = 1;
                if (p.O0(d0Var, obj3.O.h(), a1Var, false, false, 0) == null) {
                    b0Var2.X0(i3);
                    singletonList = Collections.singletonList(d0.O0(d0Var, a.g(b0.a.b(a)).H(), (c1)obj3.O.h().get(i).getAnnotations()));
                }
                if (singletonList.size() != i3) {
                } else {
                    d0Var.M0(b0.R0(a1Var, obj3.O));
                    d0Var.Q0((c1)singletonList.get(i));
                }
                IllegalStateException illegalStateException = new IllegalStateException();
                throw illegalStateException;
            }
            annotations = obj3.Q;
            if (annotations == null) {
                oVar2 = oVar;
            } else {
                oVar2 = new o(annotations.getAnnotations(), b0Var2);
            }
            annotations5 = obj3.R;
            if (annotations5 == null) {
            } else {
                oVar = new o(annotations5.getAnnotations(), b0Var2);
            }
            b0Var2.T0(c0Var, d0Var, oVar2, oVar);
            if (b0.a.e(a)) {
                z2 = j.b();
                d0Var = e().iterator();
                for (o0 next : d0Var) {
                    z2.add(next.c(a1Var));
                }
                b0Var2.w0(z2);
            }
            const = obj3.y;
            if (isConst() && const != null) {
                const = obj3.y;
                if (const != null) {
                    b0Var2.J0(const);
                }
            }
            return b0Var2;
        }
        b0.E(24);
        throw oVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public kotlin.reflect.jvm.internal.impl.descriptors.j1.c0 P0() {
        return this.N;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public void S0(kotlin.reflect.jvm.internal.impl.descriptors.j1.c0 c0, q0 q02) {
        final int i = 0;
        T0(c0, q02, i, i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public void T0(kotlin.reflect.jvm.internal.impl.descriptors.j1.c0 c0, q0 q02, v v3, v v4) {
        this.N = c0;
        this.O = q02;
        this.Q = v3;
        this.R = v4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public boolean U0() {
        return this.P;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public kotlin.reflect.jvm.internal.impl.descriptors.j1.b0.a V0() {
        b0.a aVar = new b0.a(this);
        return aVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public void X0(boolean z) {
        this.P = z;
    }

    public void Y0(b0 b0, List<? extends z0> list2, r0 r03, r0 r04) {
        final int i = 0;
        if (b0 == null) {
        } else {
            if (list2 == null) {
            } else {
                C0(b0);
                ArrayList obj2 = new ArrayList(list2);
                this.M = obj2;
                this.L = r04;
                this.K = r03;
            }
            b0.E(15);
            throw i;
        }
        b0.E(14);
        throw i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public void Z0(u u) {
        if (u == null) {
        } else {
            this.A = u;
        }
        b0.E(16);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public a a() {
        return a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public b a() {
        return a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public m a() {
        return a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public o0 a() {
        Object obj;
        o0 o0Var = this.C;
        if (o0Var == this) {
            obj = this;
        } else {
            obj = o0Var.a();
        }
        if (obj == null) {
        } else {
            return obj;
        }
        b0.E(33);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public n c(a1 a1) {
        return c(a1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public o0 c(a1 a1) {
        if (a1 == null) {
        } else {
            if (a1.k()) {
                return this;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.j1.b0.a aVar = V0();
            aVar.v(a1.j());
            aVar.t(a());
            return aVar.n();
        }
        b0.E(22);
        throw 0;
    }

    public Collection<? extends o0> e() {
        Object emptyList;
        if (this.B != null) {
        } else {
            emptyList = Collections.emptyList();
        }
        if (emptyList == null) {
        } else {
            return emptyList;
        }
        b0.E(36);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public b.a f() {
        b.a aVar = this.D;
        if (aVar == null) {
        } else {
            return aVar;
        }
        b0.E(34);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public r0 f0() {
        return this.K;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public p0 getGetter() {
        return P0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public b0 getReturnType() {
        b0 type = getType();
        if (type == null) {
        } else {
            return type;
        }
        b0.E(18);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public q0 getSetter() {
        return this.O;
    }

    public List<z0> getTypeParameters() {
        List list = this.M;
        if (list == null) {
        } else {
            if (list == null) {
            } else {
                return list;
            }
            b0.E(17);
            throw 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("typeParameters == null for ");
        stringBuilder.append(toString());
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public u getVisibility() {
        u uVar = this.A;
        if (uVar == null) {
        } else {
            return uVar;
        }
        b0.E(20);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public z i() {
        z zVar = this.z;
        if (zVar == null) {
        } else {
            return zVar;
        }
        b0.E(19);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public boolean isConst() {
        return this.F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public b k0(m m, z z2, u u3, b.a b$a4, boolean z5) {
        return L0(m, z2, u3, a4, z5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public r0 m0() {
        return this.L;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public v n0() {
        return this.R;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public v q0() {
        return this.Q;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public boolean r0() {
        return this.E;
    }

    public List<n0> u() {
        ArrayList arrayList = new ArrayList(2);
        kotlin.reflect.jvm.internal.impl.descriptors.j1.c0 c0Var = this.N;
        if (c0Var != null) {
            arrayList.add(c0Var);
        }
        q0 q0Var = this.O;
        if (q0Var != null) {
            arrayList.add(q0Var);
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.m0
    public boolean w() {
        return this.I;
    }

    public void w0(Collection<? extends b> collection) {
        if (collection == null) {
        } else {
            this.B = collection;
        }
        b0.E(35);
        throw 0;
    }
}
