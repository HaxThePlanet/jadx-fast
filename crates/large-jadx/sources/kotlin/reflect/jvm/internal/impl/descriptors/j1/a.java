package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import kotlin.d0.c.a;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.d;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.i.v.f;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.i.v.m;
import kotlin.i0.z.e.m0.k.i;
import kotlin.i0.z.e.m0.k.n;
import kotlin.i0.z.e.m0.l.a1;
import kotlin.i0.z.e.m0.l.c1;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.i0.z.e.m0.l.j1.g;
import kotlin.i0.z.e.m0.l.y0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n;
import kotlin.reflect.jvm.internal.impl.descriptors.o;
import kotlin.reflect.jvm.internal.impl.descriptors.r0;

/* loaded from: classes3.dex */
public abstract class a extends kotlin.reflect.jvm.internal.impl.descriptors.j1.t {

    private final e b;
    protected final i<i0> c;
    private final i<h> v;
    private final i<r0> w;

    class a implements a<i0> {

        final kotlin.reflect.jvm.internal.impl.descriptors.j1.a a;
        a(kotlin.reflect.jvm.internal.impl.descriptors.j1.a a) {
            this.a = a;
            super();
        }

        @Override // kotlin.d0.c.a
        public i0 a() {
            kotlin.reflect.jvm.internal.impl.descriptors.j1.a aVar = this.a;
            a.a.a aVar2 = new a.a.a(this);
            return c1.t(aVar, aVar.A0(), aVar2);
        }

        @Override // kotlin.d0.c.a
        public Object invoke() {
            return a();
        }
    }

    class b implements a<h> {

        final kotlin.reflect.jvm.internal.impl.descriptors.j1.a a;
        b(kotlin.reflect.jvm.internal.impl.descriptors.j1.a a) {
            this.a = a;
            super();
        }

        @Override // kotlin.d0.c.a
        public h a() {
            f fVar = new f(this.a.A0());
            return fVar;
        }

        @Override // kotlin.d0.c.a
        public Object invoke() {
            return a();
        }
    }

    class c implements a<r0> {

        final kotlin.reflect.jvm.internal.impl.descriptors.j1.a a;
        c(kotlin.reflect.jvm.internal.impl.descriptors.j1.a a) {
            this.a = a;
            super();
        }

        @Override // kotlin.d0.c.a
        public r0 a() {
            q qVar = new q(this.a);
            return qVar;
        }

        @Override // kotlin.d0.c.a
        public Object invoke() {
            return a();
        }
    }
    static {
    }

    public a(n n, e e2) {
        final int i = 0;
        if (n == null) {
        } else {
            if (e2 == null) {
            } else {
                super();
                this.b = e2;
                a.a obj3 = new a.a(this);
                this.c = n.d(obj3);
                obj3 = new a.b(this);
                this.v = n.d(obj3);
                obj3 = new a.c(this);
                this.w = n.d(obj3);
            }
            a.J(1);
            throw i;
        }
        a.J(0);
        throw i;
    }

    private static void J(int i) {
        Object illegalArgumentException;
        String str;
        int i2;
        String str2;
        String str3;
        int i4 = i;
        final int i5 = 19;
        final int i6 = 18;
        final int i7 = 16;
        final int i8 = 15;
        final int i9 = 13;
        final int i10 = 11;
        final int i11 = 8;
        final int i12 = 5;
        final int i13 = 4;
        final int i14 = 3;
        final int i15 = 2;
        if (i4 != i15 && i4 != i14 && i4 != i13 && i4 != i12 && i4 != i11 && i4 != i10 && i4 != i9 && i4 != i8 && i4 != i7 && i4 != i6 && i4 != i5) {
            if (i4 != i14) {
                if (i4 != i13) {
                    if (i4 != i12) {
                        if (i4 != i11) {
                            if (i4 != i10) {
                                if (i4 != i9) {
                                    if (i4 != i8) {
                                        if (i4 != i7) {
                                            if (i4 != i6) {
                                                str = i4 != i5 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
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
        if (i4 != i15 && i4 != i14 && i4 != i13 && i4 != i12 && i4 != i11 && i4 != i10 && i4 != i9 && i4 != i8 && i4 != i7 && i4 != i6 && i4 != i5) {
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
        Object[] arr = new Object[i2];
        str2 = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
        int i16 = 0;
        switch (i4) {
            case 1:
                arr[i16] = "name";
                break;
            case 2:
                arr[i16] = str2;
                break;
            case 3:
                arr[i16] = "typeArguments";
                break;
            case 4:
                arr[i16] = "kotlinTypeRefiner";
                break;
            case 5:
                arr[i16] = "typeSubstitution";
                break;
            case 6:
                arr[i16] = "substitutor";
                break;
            default:
                arr[i16] = "storageManager";
        }
        String str4 = "substitute";
        String str5 = "getMemberScope";
        final int i17 = 1;
        if (i4 != i15) {
            if (i4 != i14) {
                if (i4 != i13) {
                    if (i4 != i12) {
                        if (i4 != i11 && i4 != i10 && i4 != i9 && i4 != i8) {
                            if (i4 != i10) {
                                if (i4 != i9) {
                                    if (i4 != i8) {
                                        if (i4 != i7) {
                                            if (i4 != i6) {
                                                if (i4 != i5) {
                                                    arr[i17] = str2;
                                                } else {
                                                    arr[i17] = "getDefaultType";
                                                }
                                            } else {
                                                arr[i17] = str4;
                                            }
                                        } else {
                                            arr[i17] = "getUnsubstitutedMemberScope";
                                        }
                                    } else {
                                        arr[i17] = str5;
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                        arr[i17] = "getThisAsReceiverParameter";
                    }
                } else {
                    arr[i17] = "getUnsubstitutedInnerClassesScope";
                }
            } else {
                arr[i17] = "getOriginal";
            }
        } else {
            arr[i17] = "getName";
        }
        switch (i4) {
            case 3:
                arr[i15] = str5;
                break;
            case 4:
                arr[i15] = str4;
                break;
            default:
                arr[i15] = "<init>";
        }
        String format = String.format(str, arr);
        if (i4 != i15 && i4 != i14 && i4 != i13 && i4 != i12 && i4 != i11 && i4 != i10 && i4 != i9 && i4 != i8 && i4 != i7 && i4 != i6 && i4 != i5) {
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
        throw illegalArgumentException;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public h A0() {
        h hVar = F(a.k(d.g(this)));
        if (hVar == null) {
        } else {
            return hVar;
        }
        a.J(16);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public e C0(a1 a1) {
        if (a1 == null) {
        } else {
            if (a1.k()) {
                return this;
            }
            s sVar = new s(this, a1);
            return sVar;
        }
        a.J(17);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public h E(y0 y0, g g2) {
        int i = 0;
        if (y0 == null) {
        } else {
            if (g2 == null) {
            } else {
                if (y0.f()) {
                    h obj3 = F(g2);
                    if (obj3 == null) {
                    } else {
                        return obj3;
                    }
                    a.J(11);
                    throw i;
                }
                m mVar = new m(F(g2), a1.g(y0));
                return mVar;
            }
            a.J(10);
            throw i;
        }
        a.J(9);
        throw i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public r0 I0() {
        Object invoke = this.w.invoke();
        if ((r0)invoke == null) {
        } else {
            return (r0)invoke;
        }
        a.J(5);
        throw 0;
    }

    public <R, D> R K(o<R, D> o, D d2) {
        return o.a(this, d2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public e a() {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public h a() {
        a();
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public m a() {
        a();
        return this;
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
            a.J(15);
            throw i;
        }
        a.J(14);
        throw i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public n c(a1 a1) {
        return C0(a1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public e getName() {
        e eVar = this.b;
        if (eVar == null) {
        } else {
            return eVar;
        }
        a.J(2);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public i0 q() {
        Object invoke = this.c.invoke();
        if ((i0)invoke == null) {
        } else {
            return (i0)invoke;
        }
        a.J(19);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.t
    public h x0() {
        Object invoke = this.v.invoke();
        if ((h)invoke == null) {
        } else {
            return (h)invoke;
        }
        a.J(4);
        throw 0;
    }
}
