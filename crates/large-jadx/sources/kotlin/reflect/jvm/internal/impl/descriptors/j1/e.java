package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.d0.c.a;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.i.v.g;
import kotlin.i0.z.e.m0.k.i;
import kotlin.i0.z.e.m0.k.n;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.c0;
import kotlin.i0.z.e.m0.l.g;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.i0.z.e.m0.l.t;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.o;
import kotlin.reflect.jvm.internal.impl.descriptors.p;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* loaded from: classes3.dex */
public abstract class e extends kotlin.reflect.jvm.internal.impl.descriptors.j1.k implements z0 {

    private final i<i0> A;
    private final n B;
    private final h1 w;
    private final boolean x;
    private final int y;
    private final i<t0> z;

    class a implements a<t0> {

        final n a;
        final x0 b;
        final kotlin.reflect.jvm.internal.impl.descriptors.j1.e c;
        a(kotlin.reflect.jvm.internal.impl.descriptors.j1.e e, n n2, x0 x03) {
            this.c = e;
            this.a = n2;
            this.b = x03;
            super();
        }

        @Override // kotlin.d0.c.a
        public t0 a() {
            e.c cVar = new e.c(this.c, this.a, this.b);
            return cVar;
        }

        @Override // kotlin.d0.c.a
        public Object invoke() {
            return a();
        }
    }

    class b implements a<i0> {

        final e a;
        final kotlin.reflect.jvm.internal.impl.descriptors.j1.e b;
        b(kotlin.reflect.jvm.internal.impl.descriptors.j1.e e, e e2) {
            this.b = e;
            this.a = e2;
            super();
        }

        @Override // kotlin.d0.c.a
        public i0 a() {
            e.b.a aVar2 = new e.b.a(this);
            g gVar2 = new g(aVar2);
            return c0.j(g.q.b(), this.b.g(), Collections.emptyList(), false, gVar2);
        }

        @Override // kotlin.d0.c.a
        public Object invoke() {
            return a();
        }
    }

    private class c extends g {

        private final x0 c;
        final kotlin.reflect.jvm.internal.impl.descriptors.j1.e d;
        public c(kotlin.reflect.jvm.internal.impl.descriptors.j1.e e, n n2, x0 x03) {
            if (n2 == null) {
            } else {
                this.d = e;
                super(n2);
                this.c = x03;
            }
            e.c.r(0);
            throw 0;
        }

        private static void r(int i) {
            String str2;
            int i2;
            String str;
            String str3;
            Object obj11;
            final int i4 = 8;
            final int i5 = 5;
            final int i6 = 4;
            final int i7 = 3;
            final int i8 = 2;
            final int i9 = 1;
            if (i != i9 && i != i8 && i != i7 && i != i6 && i != i5 && i != i4) {
                if (i != i8) {
                    if (i != i7) {
                        if (i != i6) {
                            if (i != i5) {
                                str2 = i != i4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
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
            if (i != i9 && i != i8 && i != i7 && i != i6 && i != i5 && i != i4) {
                if (i != i8) {
                    if (i != i7) {
                        if (i != i6) {
                            if (i != i5) {
                                i2 = i != i4 ? i7 : i8;
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
            str = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
            int i10 = 0;
            switch (i) {
                case 1:
                    arr[i10] = str;
                    break;
                case 2:
                    arr[i10] = "type";
                    break;
                case 3:
                    arr[i10] = "supertypes";
                    break;
                default:
                    arr[i10] = "storageManager";
            }
            String str4 = "processSupertypesWithoutCycles";
            if (i != i9) {
                if (i != i8) {
                    if (i != i7) {
                        if (i != i6) {
                            if (i != i5) {
                                if (i != i4) {
                                    arr[i9] = str;
                                } else {
                                    arr[i9] = str4;
                                }
                            } else {
                                arr[i9] = "getSupertypeLoopChecker";
                            }
                        } else {
                            arr[i9] = "getBuiltIns";
                        }
                    } else {
                        arr[i9] = "getDeclarationDescriptor";
                    }
                } else {
                    arr[i9] = "getParameters";
                }
            } else {
                arr[i9] = "computeSupertypes";
            }
            switch (i) {
                case 2:
                    arr[i8] = "reportSupertypeLoopError";
                    break;
                case 3:
                    arr[i8] = str4;
                    break;
                default:
                    arr[i8] = "<init>";
            }
            String format = String.format(str2, arr);
            if (i != i9 && i != i8 && i != i7 && i != i6 && i != i5 && i != i4) {
                if (i != i8) {
                    if (i != i7) {
                        if (i != i6) {
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
                    } else {
                    }
                } else {
                }
            } else {
            }
            throw obj11;
        }

        @Override // kotlin.i0.z.e.m0.l.g
        public h c() {
            kotlin.reflect.jvm.internal.impl.descriptors.j1.e eVar = this.d;
            if (eVar == null) {
            } else {
                return eVar;
            }
            e.c.r(3);
            throw 0;
        }

        @Override // kotlin.i0.z.e.m0.l.g
        public boolean d() {
            return 1;
        }

        public List<z0> getParameters() {
            List emptyList = Collections.emptyList();
            if (emptyList == null) {
            } else {
                return emptyList;
            }
            e.c.r(2);
            throw 0;
        }

        protected Collection<b0> h() {
            List list = this.d.K0();
            if (list == null) {
            } else {
                return list;
            }
            e.c.r(1);
            throw 0;
        }

        @Override // kotlin.i0.z.e.m0.l.g
        protected b0 i() {
            return t.j("Cyclic upper bounds");
        }

        @Override // kotlin.i0.z.e.m0.l.g
        protected x0 l() {
            x0 x0Var = this.c;
            if (x0Var == null) {
            } else {
                return x0Var;
            }
            e.c.r(5);
            throw 0;
        }

        @Override // kotlin.i0.z.e.m0.l.g
        public h m() {
            h hVar = a.g(this.d);
            if (hVar == null) {
            } else {
                return hVar;
            }
            e.c.r(4);
            throw 0;
        }

        protected List<b0> o(List<b0> list) {
            final int i = 0;
            if (list == null) {
            } else {
                List obj3 = this.d.C0(list);
                if (obj3 == null) {
                } else {
                    return obj3;
                }
                e.c.r(8);
                throw i;
            }
            e.c.r(7);
            throw i;
        }

        @Override // kotlin.i0.z.e.m0.l.g
        protected void q(b0 b0) {
            if (b0 == null) {
            } else {
                this.d.J0(b0);
            }
            e.c.r(6);
            throw 0;
        }

        @Override // kotlin.i0.z.e.m0.l.g
        public String toString() {
            return this.d.getName().toString();
        }
    }
    protected e(n n, m m2, g g3, e e4, h1 h15, boolean z6, int i7, u0 u08, x0 x09) {
        final int i = 0;
        if (n == null) {
        } else {
            if (m2 == null) {
            } else {
                if (g3 == null) {
                } else {
                    if (e4 == null) {
                    } else {
                        if (h15 == null) {
                        } else {
                            if (u08 == null) {
                            } else {
                                if (x09 == null) {
                                } else {
                                    super(m2, g3, e4, u08);
                                    this.w = h15;
                                    this.x = z6;
                                    this.y = i7;
                                    e.a obj3 = new e.a(this, n, x09);
                                    this.z = n.d(obj3);
                                    obj3 = new e.b(this, e4);
                                    this.A = n.d(obj3);
                                    this.B = n;
                                }
                                e.E(6);
                                throw i;
                            }
                            e.E(5);
                            throw i;
                        }
                        e.E(4);
                        throw i;
                    }
                    e.E(3);
                    throw i;
                }
                e.E(2);
                throw i;
            }
            e.E(1);
            throw i;
        }
        e.E(0);
        throw i;
    }

    private static void E(int i) {
        String str4;
        int i2;
        String str;
        String str3;
        Object obj6;
        str4 = /* condition */ ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        i2 = /* condition */ ? i3 : 3;
        Object[] arr = new Object[i2];
        str = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
        int i4 = 0;
        switch (i) {
            case 1:
                arr[i4] = "containingDeclaration";
                break;
            case 2:
                arr[i4] = "annotations";
                break;
            case 3:
                arr[i4] = "name";
                break;
            case 4:
                arr[i4] = "variance";
                break;
            case 5:
                arr[i4] = "source";
                break;
            case 6:
                arr[i4] = "supertypeLoopChecker";
                break;
            case 7:
                arr[i4] = str;
                break;
            case 8:
                arr[i4] = "bounds";
                break;
            default:
                arr[i4] = "storageManager";
        }
        String str5 = "processBoundsWithoutCycles";
        int i5 = 1;
        switch (i) {
            case 7:
                arr[i5] = "getVariance";
                break;
            case 8:
                arr[i5] = "getUpperBounds";
                break;
            case 9:
                arr[i5] = "getTypeConstructor";
                break;
            case 10:
                arr[i5] = "getDefaultType";
                break;
            case 11:
                arr[i5] = "getOriginal";
                break;
            case 12:
                arr[i5] = str;
                break;
            case 13:
                arr[i5] = str5;
                break;
            default:
                arr[i5] = "getStorageManager";
        }
        switch (i) {
            case 8:
                arr[i3] = str5;
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

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public boolean C() {
        return this.x;
    }

    protected List<b0> C0(List<b0> list) {
        final int i = 0;
        if (list == null) {
        } else {
            if (list == null) {
            } else {
                return list;
            }
            e.E(13);
            throw i;
        }
        e.E(12);
        throw i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public p J() {
        return a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    protected abstract void J0(b0 b0);

    public <R, D> R K(o<R, D> o, D d2) {
        return o.m(this, d2);
    }

    protected abstract List<b0> K0();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public h a() {
        return a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public m a() {
        return a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public z0 a() {
        p pVar = super.J();
        if ((z0)pVar == null) {
        } else {
            return (z0)pVar;
        }
        e.E(11);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public final t0 g() {
        Object invoke = this.z.invoke();
        if ((t0)invoke == null) {
        } else {
            return (t0)invoke;
        }
        e.E(9);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public int getIndex() {
        return this.y;
    }

    public List<b0> getUpperBounds() {
        List list = (e.c)g().n();
        if (list == null) {
        } else {
            return list;
        }
        e.E(8);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public n h0() {
        n nVar = this.B;
        if (nVar == null) {
        } else {
            return nVar;
        }
        e.E(14);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public h1 l() {
        h1 h1Var = this.w;
        if (h1Var == null) {
        } else {
            return h1Var;
        }
        e.E(7);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public boolean o0() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public i0 q() {
        Object invoke = this.A.invoke();
        if ((i0)invoke == null) {
        } else {
            return (i0)invoke;
        }
        e.E(10);
        throw 0;
    }
}
