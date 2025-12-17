package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.d0.c.l;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.d;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.i.v.m;
import kotlin.i0.z.e.m0.k.f;
import kotlin.i0.z.e.m0.l.a1;
import kotlin.i0.z.e.m0.l.c0;
import kotlin.i0.z.e.m0.l.c1;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.i0.z.e.m0.l.i;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.i0.z.e.m0.l.j1.g;
import kotlin.i0.z.e.m0.l.o;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.m0.l.y0;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.i;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n;
import kotlin.reflect.jvm.internal.impl.descriptors.o;
import kotlin.reflect.jvm.internal.impl.descriptors.r0;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.x.a;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public class s extends kotlin.reflect.jvm.internal.impl.descriptors.j1.t {

    private final kotlin.reflect.jvm.internal.impl.descriptors.j1.t b;
    private final a1 c;
    private a1 v;
    private List<z0> w;
    private List<z0> x;
    private t0 y;

    class a implements l<z0, Boolean> {
        a(kotlin.reflect.jvm.internal.impl.descriptors.j1.s s) {
            super();
        }

        @Override // kotlin.d0.c.l
        public Boolean a(z0 z0) {
            return Boolean.valueOf(obj1 ^= 1);
        }

        @Override // kotlin.d0.c.l
        public Object invoke(Object object) {
            return a((z0)object);
        }
    }
    static {
    }

    public s(kotlin.reflect.jvm.internal.impl.descriptors.j1.t t, a1 a12) {
        super();
        this.b = t;
        this.c = a12;
    }

    private a1 C0() {
        Object a1Var;
        kotlin.reflect.jvm.internal.impl.descriptors.j1.s.a aVar;
        List list;
        if (this.v == null) {
            if (this.c.k()) {
                this.v = this.c;
            } else {
                List parameters = this.b.g().getParameters();
                ArrayList arrayList = new ArrayList(parameters.size());
                this.w = arrayList;
                this.v = o.b(parameters, this.c.j(), this, this.w);
                aVar = new s.a(this);
                this.x = p.T(this.w, aVar);
            }
        }
        return this.v;
    }

    private static void J(int i) {
        String str3;
        int i2;
        String str2;
        String str;
        Object obj15;
        final int i3 = 22;
        final int i4 = 13;
        final int i5 = 10;
        final int i6 = 8;
        final int i7 = 6;
        final int i8 = 5;
        final int i9 = 3;
        final int i10 = 2;
        if (i != i10 && i != i9 && i != i8 && i != i7 && i != i6 && i != i5 && i != i4 && i != i3) {
            if (i != i9) {
                if (i != i8) {
                    if (i != i7) {
                        if (i != i6) {
                            if (i != i5) {
                                if (i != i4) {
                                    str3 = i != i3 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
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
        if (i != i10 && i != i9 && i != i8 && i != i7 && i != i6 && i != i5 && i != i4 && i != i3) {
            if (i != i9) {
                if (i != i8) {
                    if (i != i7) {
                        if (i != i6) {
                            if (i != i5) {
                                if (i != i4) {
                                    i2 = i != i3 ? i10 : i9;
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
        str2 = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
        int i11 = 0;
        if (i != i10) {
            if (i != i9) {
                if (i != i8) {
                    if (i != i7) {
                        if (i != i6) {
                            if (i != i5) {
                                if (i != i4) {
                                    if (i != i3) {
                                        arr[i11] = str2;
                                    } else {
                                        arr[i11] = "substitutor";
                                    }
                                } else {
                                    arr[i11] = "kotlinTypeRefiner";
                                }
                            } else {
                                arr[i11] = "typeSubstitution";
                            }
                        } else {
                            arr[i11] = "typeArguments";
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        String str4 = "substitute";
        String str5 = "getUnsubstitutedMemberScope";
        final String str6 = "getMemberScope";
        final int i12 = 1;
        switch (i) {
            case 2:
                arr[i12] = str2;
                break;
            case 3:
                arr[i12] = str6;
                break;
            case 4:
                arr[i12] = str5;
                break;
            case 5:
                arr[i12] = "getStaticScope";
                break;
            case 6:
                arr[i12] = "getDefaultType";
                break;
            case 7:
                arr[i12] = "getConstructors";
                break;
            case 8:
                arr[i12] = "getAnnotations";
                break;
            case 9:
                arr[i12] = "getName";
                break;
            case 10:
                arr[i12] = "getOriginal";
                break;
            case 11:
                arr[i12] = "getContainingDeclaration";
                break;
            case 12:
                arr[i12] = str4;
                break;
            case 13:
                arr[i12] = "getKind";
                break;
            case 14:
                arr[i12] = "getModality";
                break;
            case 15:
                arr[i12] = "getVisibility";
                break;
            case 16:
                arr[i12] = "getUnsubstitutedInnerClassesScope";
                break;
            case 17:
                arr[i12] = "getSource";
                break;
            case 18:
                arr[i12] = "getDeclaredTypeParameters";
                break;
            case 19:
                arr[i12] = "getSealedSubclasses";
                break;
            default:
                arr[i12] = "getTypeConstructor";
        }
        if (i != i10 && i != i9 && i != i8 && i != i7 && i != i6 && i != i5) {
            if (i != i9) {
                if (i != i8) {
                    if (i != i7) {
                        if (i != i6) {
                            if (i != i5) {
                                if (i != i4) {
                                    if (i != i3) {
                                    } else {
                                        arr[i10] = str4;
                                    }
                                } else {
                                    arr[i10] = str5;
                                }
                            } else {
                                arr[i10] = str6;
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
        String format = String.format(str3, arr);
        if (i != i10 && i != i9 && i != i8 && i != i7 && i != i6 && i != i5 && i != i4 && i != i3) {
            if (i != i9) {
                if (i != i8) {
                    if (i != i7) {
                        if (i != i6) {
                            if (i != i5) {
                                if (i != i4) {
                                    if (i != i3) {
                                        obj15 = new IllegalStateException(format);
                                    } else {
                                        obj15 = new IllegalArgumentException(format);
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
        throw obj15;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public boolean A() {
        return this.b.A();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public h A0() {
        h hVar = F(a.k(d.g(this.b)));
        if (hVar == null) {
        } else {
            return hVar;
        }
        s.J(12);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public boolean B0() {
        return this.b.B0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public h E(y0 y0, g g2) {
        int i = 0;
        if (y0 == null) {
        } else {
            if (g2 == null) {
            } else {
                h obj3 = this.b.E(y0, g2);
                if (this.c.k()) {
                    if (obj3 == null) {
                    } else {
                        return obj3;
                    }
                    s.J(7);
                    throw i;
                }
                m obj4 = new m(obj3, C0());
                return obj4;
            }
            s.J(6);
            throw i;
        }
        s.J(5);
        throw i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public h F(g g) {
        int i = 0;
        if (g == null) {
        } else {
            h obj3 = this.b.F(g);
            if (this.c.k()) {
                if (obj3 == null) {
                } else {
                    return obj3;
                }
                s.J(14);
                throw i;
            }
            m mVar = new m(obj3, C0());
            return mVar;
        }
        s.J(13);
        throw i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public boolean G0() {
        return this.b.G0();
    }

    public Collection<e> H() {
        Collection collection = this.b.H();
        if (collection == null) {
        } else {
            return collection;
        }
        s.J(30);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public boolean I() {
        return this.b.I();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public r0 I0() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public e J0(a1 a1) {
        if (a1 == null) {
        } else {
            if (a1.k()) {
                return this;
            }
            s sVar = new s(this, a1.h(a1.j(), C0().j()));
            return sVar;
        }
        s.J(22);
        throw 0;
    }

    public <R, D> R K(o<R, D> o, D d2) {
        return o.a(this, d2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public boolean L() {
        return this.b.L();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public d Q() {
        return this.b.Q();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public h R() {
        h hVar = this.b.R();
        if (hVar == null) {
        } else {
            return hVar;
        }
        s.J(15);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public e T() {
        return this.b.T();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public e a() {
        e eVar = this.b.a();
        if (eVar == null) {
        } else {
            return eVar;
        }
        s.J(20);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public h a0(y0 y0) {
        final int i = 0;
        if (y0 == null) {
        } else {
            h obj3 = E(y0, a.k(d.g(this)));
            if (obj3 == null) {
            } else {
                return obj3;
            }
            s.J(11);
            throw i;
        }
        s.J(10);
        throw i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public m b() {
        m mVar = this.b.b();
        if (mVar == null) {
        } else {
            return mVar;
        }
        s.J(21);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public n c(a1 a1) {
        return J0(a1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public f f() {
        f fVar = this.b.f();
        if (fVar == null) {
        } else {
            return fVar;
        }
        s.J(24);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public t0 g() {
        t0 iVar;
        Object t0Var;
        ArrayList arrayList;
        kotlin.i0.z.e.m0.k.n nVar;
        int size;
        h1 iNVARIANT;
        iVar = this.b.g();
        final int i3 = 0;
        if (this.c.k()) {
            if (iVar == null) {
            } else {
                return iVar;
            }
            s.J(0);
            throw i3;
        }
        if (this.y == null) {
            Collection collection = iVar.a();
            arrayList = new ArrayList(collection.size());
            Iterator iterator = collection.iterator();
            for (b0 next2 : iterator) {
                arrayList.add(C0().p(next2, h1.INVARIANT));
            }
            iVar = new i(this, this.w, arrayList, f.e);
            this.y = iVar;
        }
        t0 t0Var2 = this.y;
        if (t0Var2 == null) {
        } else {
            return t0Var2;
        }
        s.J(1);
        throw i3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public g getAnnotations() {
        g annotations = this.b.getAnnotations();
        if (annotations == null) {
        } else {
            return annotations;
        }
        s.J(18);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public e getName() {
        e name = this.b.getName();
        if (name == null) {
        } else {
            return name;
        }
        s.J(19);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public u0 getSource() {
        u0 u0Var = u0.a;
        if (u0Var == null) {
        } else {
            return u0Var;
        }
        s.J(28);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public u getVisibility() {
        u visibility = this.b.getVisibility();
        if (visibility == null) {
        } else {
            return visibility;
        }
        s.J(26);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public z i() {
        z zVar = this.b.i();
        if (zVar == null) {
        } else {
            return zVar;
        }
        s.J(25);
        throw 0;
    }

    public Collection<d> j() {
        int size;
        a1 a1Var;
        u visibility;
        Collection collection = this.b.j();
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator iterator = collection.iterator();
        for (d next2 : iterator) {
            arrayList.add((d)next2.s().g(next2.a()).c(next2.i()).m(next2.getVisibility()).p(next2.f()).i(false).build().c(C0()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public boolean k() {
        return this.b.k();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public i0 q() {
        i0 i0Var = c0.j(getAnnotations(), g(), c1.g(g().getParameters()), false, A0());
        if (i0Var == null) {
        } else {
            return i0Var;
        }
        s.J(16);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public boolean r() {
        return this.b.r();
    }

    public List<z0> t() {
        C0();
        List list = this.x;
        if (list == null) {
        } else {
            return list;
        }
        s.J(29);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public boolean w() {
        return this.b.w();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public boolean x() {
        return this.b.x();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public h x0() {
        h hVar = this.b.x0();
        if (hVar == null) {
        } else {
            return hVar;
        }
        s.J(27);
        throw 0;
    }
}
