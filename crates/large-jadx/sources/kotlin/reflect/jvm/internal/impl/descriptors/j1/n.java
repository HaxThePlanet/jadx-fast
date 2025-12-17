package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.i0.z.e.m0.c.b.b;
import kotlin.i0.z.e.m0.c.b.d;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.j;
import kotlin.i0.z.e.m0.i.v.d;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.i.v.h.b;
import kotlin.i0.z.e.m0.i.v.i;
import kotlin.i0.z.e.m0.k.g;
import kotlin.i0.z.e.m0.k.i;
import kotlin.i0.z.e.m0.k.n;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.i;
import kotlin.i0.z.e.m0.l.j1.g;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* loaded from: classes3.dex */
public class n extends kotlin.reflect.jvm.internal.impl.descriptors.j1.g {

    private final t0 A;
    private final h B;
    private final i<Set<e>> C;
    private final g D;

    private class a extends i {

        private final g<e, Collection<? extends t0>> b;
        private final g<e, Collection<? extends o0>> c;
        private final i<Collection<m>> d;
        final kotlin.reflect.jvm.internal.impl.descriptors.j1.n e;
        static {
        }

        public a(kotlin.reflect.jvm.internal.impl.descriptors.j1.n n, n n2) {
            if (n2 == null) {
            } else {
                this.e = n;
                super();
                n.a.a aVar = new n.a.a(this, n);
                this.b = n2.h(aVar);
                n.a.b bVar = new n.a.b(this, n);
                this.c = n2.h(bVar);
                n.a.c cVar = new n.a.c(this, n);
                this.d = n2.d(cVar);
            }
            n.a.h(0);
            throw 0;
        }

        private static void h(int i) {
            String str;
            int i2;
            String str2;
            String str3;
            Object obj13;
            final int i4 = 12;
            final int i5 = 9;
            final int i6 = 7;
            final int i7 = 3;
            if (i != i7 && i != i6 && i != i5 && i != i4) {
                if (i != i6) {
                    if (i != i5) {
                        if (i != i4) {
                            str = /* condition */ ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            final int i8 = 2;
            if (i != i7 && i != i6 && i != i5 && i != i4) {
                if (i != i6) {
                    if (i != i5) {
                        if (i != i4) {
                            i2 = /* condition */ ? i8 : i7;
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            Object[] arr = new Object[i2];
            str2 = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope";
            int i9 = 0;
            switch (i) {
                case 1:
                    arr[i9] = "name";
                    break;
                case 2:
                    arr[i9] = "location";
                    break;
                case 3:
                    arr[i9] = str2;
                    break;
                case 4:
                    arr[i9] = "fromSupertypes";
                    break;
                case 5:
                    arr[i9] = "kindFilter";
                    break;
                case 6:
                    arr[i9] = "nameFilter";
                    break;
                case 7:
                    arr[i9] = "p";
                    break;
                default:
                    arr[i9] = "storageManager";
            }
            String str4 = "getContributedDescriptors";
            String str5 = "resolveFakeOverrides";
            final String str6 = "getContributedFunctions";
            final String str7 = "getContributedVariables";
            final int i10 = 1;
            if (i != i7) {
                if (i != i6) {
                    if (i != i5) {
                        if (i != i4) {
                            switch (i) {
                                case 15:
                                    arr[i10] = str4;
                                    break;
                                case 16:
                                    arr[i10] = "computeAllDeclarations";
                                    break;
                                case 17:
                                    arr[i10] = "getFunctionNames";
                                    break;
                                case 18:
                                    arr[i10] = "getClassifierNames";
                                    break;
                                case 19:
                                    arr[i10] = "getVariableNames";
                                    break;
                                default:
                                    arr[i10] = str2;
                            }
                        } else {
                            arr[i10] = str5;
                        }
                    } else {
                        arr[i10] = "getSupertypeScope";
                    }
                } else {
                    arr[i10] = str6;
                }
            } else {
                arr[i10] = str7;
            }
            switch (i) {
                case 1:
                    arr[i8] = str7;
                    break;
                case 3:
                    arr[i8] = "computeProperties";
                    break;
                case 4:
                    arr[i8] = str6;
                    break;
                case 5:
                    arr[i8] = "computeFunctions";
                    break;
                case 6:
                    arr[i8] = str5;
                    break;
                case 7:
                    arr[i8] = str4;
                    break;
                case 8:
                    arr[i8] = "printScopeStructure";
                    break;
                default:
                    arr[i8] = "<init>";
            }
            String format = String.format(str, arr);
            if (i != i7 && i != i6 && i != i5 && i != i4) {
                if (i != i6) {
                    if (i != i5) {
                        if (i != i4) {
                            if (/* condition */) {
                                obj13 = new IllegalStateException(format);
                            } else {
                                obj13 = new IllegalArgumentException(format);
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            throw obj13;
        }

        static Collection i(kotlin.reflect.jvm.internal.impl.descriptors.j1.n.a n$a, e e2) {
            return a.m(e2);
        }

        static Collection j(kotlin.reflect.jvm.internal.impl.descriptors.j1.n.a n$a, e e2) {
            return a.n(e2);
        }

        static Collection k(kotlin.reflect.jvm.internal.impl.descriptors.j1.n.a n$a) {
            return a.l();
        }

        private Collection<m> l() {
            Collection collection2;
            d fOR_NON_TRACKED_SCOPE;
            Collection collection;
            HashSet hashSet = new HashSet();
            Iterator iterator = (Set)n.J0(this.e).invoke().iterator();
            for (e next2 : iterator) {
                fOR_NON_TRACKED_SCOPE = d.FOR_NON_TRACKED_SCOPE;
                hashSet.addAll(a(next2, fOR_NON_TRACKED_SCOPE));
                hashSet.addAll(c(next2, fOR_NON_TRACKED_SCOPE));
            }
            return hashSet;
        }

        private Collection<? extends t0> m(e e) {
            if (e == null) {
            } else {
                return p(e, o().a(e, d.FOR_NON_TRACKED_SCOPE));
            }
            n.a.h(8);
            throw 0;
        }

        private Collection<? extends o0> n(e e) {
            if (e == null) {
            } else {
                return p(e, o().c(e, d.FOR_NON_TRACKED_SCOPE));
            }
            n.a.h(4);
            throw 0;
        }

        private h o() {
            h hVar = (b0)this.e.g().a().iterator().next().o();
            if (hVar == null) {
            } else {
                return hVar;
            }
            n.a.h(9);
            throw 0;
        }

        private <D extends kotlin.reflect.jvm.internal.impl.descriptors.b> Collection<? extends D> p(e e, Collection<? extends D> collection2) {
            int i = 0;
            if (e == null) {
            } else {
                if (collection2 == null) {
                } else {
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    n.a.d dVar = new n.a.d(this, linkedHashSet);
                    j.d.y(e, collection2, Collections.emptySet(), this.e, dVar);
                    return linkedHashSet;
                }
                n.a.h(11);
                throw i;
            }
            n.a.h(10);
            throw i;
        }

        public Collection<? extends t0> a(e e, b b2) {
            final int i = 0;
            if (e == null) {
            } else {
                if (b2 == null) {
                } else {
                    Object obj2 = this.b.invoke(e);
                    if ((Collection)obj2 == null) {
                    } else {
                        return (Collection)obj2;
                    }
                    n.a.h(7);
                    throw i;
                }
                n.a.h(6);
                throw i;
            }
            n.a.h(5);
            throw i;
        }

        public Set<e> b() {
            Object invoke = n.J0(this.e).invoke();
            if ((Set)invoke == null) {
            } else {
                return (Set)invoke;
            }
            n.a.h(17);
            throw 0;
        }

        public Collection<? extends o0> c(e e, b b2) {
            final int i = 0;
            if (e == null) {
            } else {
                if (b2 == null) {
                } else {
                    Object obj2 = this.c.invoke(e);
                    if ((Collection)obj2 == null) {
                    } else {
                        return (Collection)obj2;
                    }
                    n.a.h(3);
                    throw i;
                }
                n.a.h(2);
                throw i;
            }
            n.a.h(1);
            throw i;
        }

        public Set<e> d() {
            Object invoke = n.J0(this.e).invoke();
            if ((Set)invoke == null) {
            } else {
                return (Set)invoke;
            }
            n.a.h(19);
            throw 0;
        }

        public Set<e> e() {
            Set emptySet = Collections.emptySet();
            if (emptySet == null) {
            } else {
                return emptySet;
            }
            n.a.h(18);
            throw 0;
        }

        public Collection<m> g(d d, l<? super e, Boolean> l2) {
            final int i = 0;
            if (d == null) {
            } else {
                if (l2 == null) {
                } else {
                    Object obj2 = this.d.invoke();
                    if ((Collection)obj2 == null) {
                    } else {
                        return (Collection)obj2;
                    }
                    n.a.h(15);
                    throw i;
                }
                n.a.h(14);
                throw i;
            }
            n.a.h(13);
            throw i;
        }
    }
    static {
    }

    private n(n n, e e2, b0 b03, e e4, i<Set<e>> i5, g g6, u0 u07) {
        final int i = 0;
        if (n == null) {
        } else {
            if (e2 == null) {
            } else {
                if (b03 == null) {
                } else {
                    if (e4 == null) {
                    } else {
                        if (i5 == null) {
                        } else {
                            if (g6 == null) {
                            } else {
                                if (u07 == null) {
                                } else {
                                    super(n, e2, e4, u07, 0);
                                    this.D = g6;
                                    i obj9 = new i(this, Collections.emptyList(), Collections.singleton(b03), n);
                                    this.A = obj9;
                                    obj9 = new n.a(this, n);
                                    this.B = obj9;
                                    this.C = i5;
                                }
                                n.J(12);
                                throw i;
                            }
                            n.J(11);
                            throw i;
                        }
                        n.J(10);
                        throw i;
                    }
                    n.J(9);
                    throw i;
                }
                n.J(8);
                throw i;
            }
            n.J(7);
            throw i;
        }
        n.J(6);
        throw i;
    }

    private static void J(int i) {
        String str3;
        int i2;
        String str;
        String str2;
        Object obj6;
        str3 = /* condition */ ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        i2 = /* condition */ ? i3 : 3;
        Object[] arr = new Object[i2];
        str = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
        int i4 = 0;
        switch (i) {
            case 1:
                arr[i4] = "enumClass";
                break;
            case 2:
                arr[i4] = "name";
                break;
            case 3:
                arr[i4] = "enumMemberNames";
                break;
            case 4:
                arr[i4] = "annotations";
                break;
            case 5:
                arr[i4] = "source";
                break;
            case 6:
                arr[i4] = "storageManager";
                break;
            case 7:
                arr[i4] = "containingClass";
                break;
            case 8:
                arr[i4] = "supertype";
                break;
            case 9:
                arr[i4] = "kotlinTypeRefiner";
                break;
            default:
                arr[i4] = str;
        }
        String str4 = "getUnsubstitutedMemberScope";
        int i5 = 1;
        switch (i) {
            case 14:
                arr[i5] = str4;
                break;
            case 15:
                arr[i5] = "getStaticScope";
                break;
            case 16:
                arr[i5] = "getConstructors";
                break;
            case 17:
                arr[i5] = "getTypeConstructor";
                break;
            case 18:
                arr[i5] = "getKind";
                break;
            case 19:
                arr[i5] = "getModality";
                break;
            case 20:
                arr[i5] = "getVisibility";
                break;
            case 21:
                arr[i5] = "getAnnotations";
                break;
            case 22:
                arr[i5] = "getDeclaredTypeParameters";
                break;
            case 23:
                arr[i5] = "getSealedSubclasses";
                break;
            default:
                arr[i5] = str;
        }
        switch (i) {
            case 6:
                arr[i3] = "<init>";
                break;
            case 7:
                arr[i3] = str4;
                break;
            default:
                arr[i3] = "create";
        }
        if (/* condition */) {
            obj6 = new IllegalStateException(format);
        } else {
            obj6 = new IllegalArgumentException(format);
        }
        throw obj6;
    }

    static i J0(kotlin.reflect.jvm.internal.impl.descriptors.j1.n n) {
        return n.C;
    }

    public static kotlin.reflect.jvm.internal.impl.descriptors.j1.n K0(n n, e e2, e e3, i<Set<e>> i4, g g5, u0 u06) {
        int i = 0;
        if (n == null) {
        } else {
            if (e2 == null) {
            } else {
                if (e3 == null) {
                } else {
                    if (i4 == null) {
                    } else {
                        if (g5 == null) {
                        } else {
                            if (u06 == null) {
                            } else {
                                super(n, e2, e2.q(), e3, i4, g5, u06);
                                return nVar;
                            }
                            n.J(5);
                            throw i;
                        }
                        n.J(4);
                        throw i;
                    }
                    n.J(3);
                    throw i;
                }
                n.J(2);
                throw i;
            }
            n.J(1);
            throw i;
        }
        n.J(0);
        throw i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public boolean A() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public boolean B0() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public h F(g g) {
        final int i = 0;
        if (g == null) {
        } else {
            h obj2 = this.B;
            if (obj2 == null) {
            } else {
                return obj2;
            }
            n.J(14);
            throw i;
        }
        n.J(13);
        throw i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public boolean G0() {
        return 0;
    }

    public Collection<e> H() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
        } else {
            return emptyList;
        }
        n.J(23);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public boolean I() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public boolean L() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public d Q() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public h R() {
        h.b bVar = h.b.b;
        if (bVar == null) {
        } else {
            return bVar;
        }
        n.J(15);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public e T() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public f f() {
        f eNUM_ENTRY = f.ENUM_ENTRY;
        if (eNUM_ENTRY == null) {
        } else {
            return eNUM_ENTRY;
        }
        n.J(18);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public t0 g() {
        t0 t0Var = this.A;
        if (t0Var == null) {
        } else {
            return t0Var;
        }
        n.J(17);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public g getAnnotations() {
        g gVar = this.D;
        if (gVar == null) {
        } else {
            return gVar;
        }
        n.J(21);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public u getVisibility() {
        u uVar = t.e;
        if (uVar == null) {
        } else {
            return uVar;
        }
        n.J(20);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public z i() {
        z fINAL = z.FINAL;
        if (fINAL == null) {
        } else {
            return fINAL;
        }
        n.J(19);
        throw 0;
    }

    public Collection<d> j() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
        } else {
            return emptyList;
        }
        n.J(16);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public boolean k() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public boolean r() {
        return 0;
    }

    public List<z0> t() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
        } else {
            return emptyList;
        }
        n.J(22);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("enum entry ");
        stringBuilder.append(getName());
        return stringBuilder.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
    public boolean x() {
        return 0;
    }
}
