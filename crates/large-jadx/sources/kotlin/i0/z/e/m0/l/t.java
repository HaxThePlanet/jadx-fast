package kotlin.i0.z.e.m0.l;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.d0.c.l;
import kotlin.i0.z.e.m0.b.e;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.c.b.b;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.i.v.d;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.k.f;
import kotlin.i0.z.e.m0.l.j1.g;
import kotlin.i0.z.e.m0.l.k1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.f;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.h;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.p;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n;
import kotlin.reflect.jvm.internal.impl.descriptors.o;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public class t {

    private static final c0 a;
    private static final kotlin.i0.z.e.m0.l.t.c b;
    public static final kotlin.i0.z.e.m0.l.i0 c;
    private static final kotlin.i0.z.e.m0.l.b0 d;
    private static final o0 e;
    private static final Set<o0> f;

    static class b implements kotlin.i0.z.e.m0.l.t0 {

        final kotlin.i0.z.e.m0.l.t.c a;
        final String b;
        b(kotlin.i0.z.e.m0.l.t.c t$c, String string2) {
            this.a = c;
            this.b = string2;
            super();
        }

        private static void f(int i) {
            String str2;
            int i2;
            String str3;
            String str;
            Object obj7;
            final int i3 = 3;
            str2 = i != i3 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            final int i4 = 2;
            i2 = i != i3 ? i4 : i3;
            Object[] arr = new Object[i2];
            str3 = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2";
            int i5 = 0;
            if (i != i3) {
                arr[i5] = str3;
            } else {
                arr[i5] = "kotlinTypeRefiner";
            }
            String str4 = "refine";
            int i6 = 1;
            if (i != i6) {
                if (i != i4) {
                    if (i != i3) {
                        if (i != 4) {
                            arr[i6] = "getParameters";
                        } else {
                            arr[i6] = str4;
                        }
                    } else {
                        arr[i6] = str3;
                    }
                } else {
                    arr[i6] = "getBuiltIns";
                }
            } else {
                arr[i6] = "getSupertypes";
            }
            if (i != i3) {
            } else {
                arr[i4] = str4;
            }
            String format = String.format(str2, arr);
            if (i != i3) {
                obj7 = new IllegalStateException(format);
            } else {
                obj7 = new IllegalArgumentException(format);
            }
            throw obj7;
        }

        public Collection<kotlin.i0.z.e.m0.l.b0> a() {
            List list = p.g();
            if (list == null) {
            } else {
                return list;
            }
            t.b.f(1);
            throw 0;
        }

        @Override // kotlin.i0.z.e.m0.l.t0
        public kotlin.i0.z.e.m0.l.t0 b(g g) {
            if (g == null) {
            } else {
                return this;
            }
            t.b.f(3);
            throw 0;
        }

        @Override // kotlin.i0.z.e.m0.l.t0
        public h c() {
            return this.a;
        }

        @Override // kotlin.i0.z.e.m0.l.t0
        public boolean d() {
            return 0;
        }

        public List<z0> getParameters() {
            List list = p.g();
            if (list == null) {
            } else {
                return list;
            }
            t.b.f(0);
            throw 0;
        }

        @Override // kotlin.i0.z.e.m0.l.t0
        public h m() {
            e eVar = e.N0();
            if (eVar == null) {
            } else {
                return eVar;
            }
            t.b.f(2);
            throw 0;
        }

        @Override // kotlin.i0.z.e.m0.l.t0
        public String toString() {
            return this.b;
        }
    }

    public static class d implements h {

        private final String b;
        private d(String string) {
            if (string == null) {
            } else {
                super();
                this.b = string;
            }
            t.d.h(0);
            throw 0;
        }

        d(String string, kotlin.i0.z.e.m0.l.t.a t$a2) {
            super(string);
        }

        private static void h(int i) {
            String str;
            int i2;
            String str2;
            String str3;
            Object obj10;
            final int i3 = 18;
            final int i4 = 7;
            if (i != i4 && i != i3) {
                if (i != i3) {
                    str = /* condition */ ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                } else {
                }
            } else {
            }
            final int i5 = 2;
            if (i != i4 && i != i3) {
                if (i != i3) {
                    i2 = /* condition */ ? i5 : 3;
                } else {
                }
            } else {
            }
            Object[] arr = new Object[i2];
            str2 = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope";
            int i6 = 0;
            switch (i) {
                case 1:
                    arr[i6] = "name";
                    break;
                case 2:
                    arr[i6] = "location";
                    break;
                case 3:
                    arr[i6] = str2;
                    break;
                case 4:
                    arr[i6] = "kindFilter";
                    break;
                case 5:
                    arr[i6] = "nameFilter";
                    break;
                case 6:
                    arr[i6] = "p";
                    break;
                default:
                    arr[i6] = "debugMessage";
            }
            String str4 = "getContributedDescriptors";
            String str5 = "getContributedFunctions";
            final String str6 = "getContributedVariables";
            final int i7 = 1;
            if (i != i4) {
                if (i != i3) {
                    switch (i) {
                        case 10:
                            arr[i7] = str5;
                            break;
                        case 11:
                            arr[i7] = "getFunctionNames";
                            break;
                        case 12:
                            arr[i7] = "getVariableNames";
                            break;
                        case 13:
                            arr[i7] = "getClassifierNames";
                            break;
                        default:
                            arr[i7] = str2;
                    }
                } else {
                    arr[i7] = str4;
                }
            } else {
                arr[i7] = str6;
            }
            switch (i) {
                case 1:
                    arr[i5] = "getContributedClassifier";
                    break;
                case 2:
                    arr[i5] = "getContributedClassifierIncludeDeprecated";
                    break;
                case 3:
                    arr[i5] = str6;
                    break;
                case 5:
                    arr[i5] = str5;
                    break;
                case 6:
                    arr[i5] = "recordLookup";
                    break;
                case 7:
                    arr[i5] = str4;
                    break;
                case 8:
                    arr[i5] = "definitelyDoesNotContainName";
                    break;
                case 9:
                    arr[i5] = "printScopeStructure";
                    break;
                default:
                    arr[i5] = "<init>";
            }
            String format = String.format(str, arr);
            if (i != i4 && i != i3) {
                if (i != i3) {
                    if (/* condition */) {
                        obj10 = new IllegalStateException(format);
                    } else {
                        obj10 = new IllegalArgumentException(format);
                    }
                } else {
                }
            } else {
            }
            throw obj10;
        }

        @Override // kotlin.i0.z.e.m0.i.v.h
        public Collection a(e e, b b2) {
            return i(e, b2);
        }

        public Set<e> b() {
            Set emptySet = Collections.emptySet();
            if (emptySet == null) {
            } else {
                return emptySet;
            }
            t.d.h(11);
            throw 0;
        }

        @Override // kotlin.i0.z.e.m0.i.v.h
        public Collection c(e e, b b2) {
            return j(e, b2);
        }

        public Set<e> d() {
            Set emptySet = Collections.emptySet();
            if (emptySet == null) {
            } else {
                return emptySet;
            }
            t.d.h(12);
            throw 0;
        }

        public Set<e> e() {
            Set emptySet = Collections.emptySet();
            if (emptySet == null) {
            } else {
                return emptySet;
            }
            t.d.h(13);
            throw 0;
        }

        @Override // kotlin.i0.z.e.m0.i.v.h
        public h f(e e, b b2) {
            final int i = 0;
            if (e == null) {
            } else {
                if (b2 == null) {
                } else {
                    return t.e(e.c());
                }
                t.d.h(2);
                throw i;
            }
            t.d.h(1);
            throw i;
        }

        public Collection<m> g(d d, l<? super e, Boolean> l2) {
            final int i = 0;
            if (d == null) {
            } else {
                if (l2 == null) {
                } else {
                    List obj2 = Collections.emptyList();
                    if (obj2 == null) {
                    } else {
                        return obj2;
                    }
                    t.d.h(18);
                    throw i;
                }
                t.d.h(17);
                throw i;
            }
            t.d.h(16);
            throw i;
        }

        public Set<? extends t0> i(e e, b b2) {
            final int i = 0;
            if (e == null) {
            } else {
                if (b2 == null) {
                } else {
                    Set obj2 = Collections.singleton(t.c(this));
                    if (obj2 == null) {
                    } else {
                        return obj2;
                    }
                    t.d.h(10);
                    throw i;
                }
                t.d.h(9);
                throw i;
            }
            t.d.h(8);
            throw i;
        }

        public Set<? extends o0> j(e e, b b2) {
            final int i = 0;
            if (e == null) {
            } else {
                if (b2 == null) {
                } else {
                    Set obj2 = t.b();
                    if (obj2 == null) {
                    } else {
                        return obj2;
                    }
                    t.d.h(7);
                    throw i;
                }
                t.d.h(6);
                throw i;
            }
            t.d.h(5);
            throw i;
        }

        @Override // kotlin.i0.z.e.m0.i.v.h
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ErrorScope{");
            stringBuilder.append(this.b);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    private static class e implements h {

        private final String b;
        private e(String string) {
            if (string == null) {
            } else {
                super();
                this.b = string;
            }
            t.e.h(0);
            throw 0;
        }

        e(String string, kotlin.i0.z.e.m0.l.t.a t$a2) {
            super(string);
        }

        private static void h(int i) {
            String str;
            String obj3;
            Object[] arr = new Object[3];
            int i3 = 0;
            switch (i) {
                case 1:
                    arr[i3] = "name";
                    break;
                case 2:
                    arr[i3] = "location";
                    break;
                case 3:
                    arr[i3] = "kindFilter";
                    break;
                case 4:
                    arr[i3] = "nameFilter";
                    break;
                case 5:
                    arr[i3] = "p";
                    break;
                default:
                    arr[i3] = "message";
            }
            arr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope";
            int i5 = 2;
            switch (i) {
                case 1:
                    arr[i5] = "getContributedClassifier";
                    break;
                case 2:
                    arr[i5] = "getContributedClassifierIncludeDeprecated";
                    break;
                case 3:
                    arr[i5] = "getContributedVariables";
                    break;
                case 4:
                    arr[i5] = "getContributedFunctions";
                    break;
                case 5:
                    arr[i5] = "getContributedDescriptors";
                    break;
                case 6:
                    arr[i5] = "recordLookup";
                    break;
                case 7:
                    arr[i5] = "definitelyDoesNotContainName";
                    break;
                case 8:
                    arr[i5] = "printScopeStructure";
                    break;
                default:
                    arr[i5] = "<init>";
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
            throw illegalArgumentException;
        }

        public Collection<? extends t0> a(e e, b b2) {
            int i = 0;
            if (e == null) {
            } else {
                if (b2 == null) {
                    t.e.h(8);
                    throw i;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.b);
                stringBuilder.append(", required name: ");
                stringBuilder.append(e);
                IllegalStateException obj4 = new IllegalStateException(stringBuilder.toString());
                throw obj4;
            }
            t.e.h(7);
            throw i;
        }

        public Set<e> b() {
            IllegalStateException illegalStateException = new IllegalStateException();
            throw illegalStateException;
        }

        public Collection<? extends o0> c(e e, b b2) {
            int i = 0;
            if (e == null) {
            } else {
                if (b2 == null) {
                    t.e.h(6);
                    throw i;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.b);
                stringBuilder.append(", required name: ");
                stringBuilder.append(e);
                IllegalStateException obj4 = new IllegalStateException(stringBuilder.toString());
                throw obj4;
            }
            t.e.h(5);
            throw i;
        }

        public Set<e> d() {
            IllegalStateException illegalStateException = new IllegalStateException();
            throw illegalStateException;
        }

        public Set<e> e() {
            IllegalStateException illegalStateException = new IllegalStateException();
            throw illegalStateException;
        }

        @Override // kotlin.i0.z.e.m0.i.v.h
        public h f(e e, b b2) {
            int i = 0;
            if (e == null) {
            } else {
                if (b2 == null) {
                    t.e.h(2);
                    throw i;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.b);
                stringBuilder.append(", required name: ");
                stringBuilder.append(e);
                IllegalStateException obj4 = new IllegalStateException(stringBuilder.toString());
                throw obj4;
            }
            t.e.h(1);
            throw i;
        }

        public Collection<m> g(d d, l<? super e, Boolean> l2) {
            final int i = 0;
            if (d == null) {
            } else {
                if (l2 == null) {
                    t.e.h(10);
                    throw i;
                }
                IllegalStateException obj2 = new IllegalStateException(this.b);
                throw obj2;
            }
            t.e.h(9);
            throw i;
        }

        @Override // kotlin.i0.z.e.m0.i.v.h
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ThrowingScope{");
            stringBuilder.append(this.b);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    public static class f implements kotlin.i0.z.e.m0.l.t0 {

        private final z0 a;
        private final kotlin.i0.z.e.m0.l.t0 b;
        private static void f(int i) {
            String str;
            int i2;
            String str3;
            String str2;
            Object obj10;
            final int i3 = 6;
            final int i4 = 4;
            final int i5 = 3;
            final int i6 = 2;
            final int i7 = 1;
            if (i != i7 && i != i6 && i != i5 && i != i4 && i != i3) {
                if (i != i6) {
                    if (i != i5) {
                        if (i != i4) {
                            str = i != i3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            if (i != i7 && i != i6 && i != i5 && i != i4 && i != i3) {
                if (i != i6) {
                    if (i != i5) {
                        if (i != i4) {
                            i2 = i != i3 ? i5 : i6;
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            Object[] arr = new Object[i2];
            str3 = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor";
            int i8 = 0;
            switch (i) {
                case 1:
                    arr[i8] = str3;
                    break;
                case 2:
                    arr[i8] = "kotlinTypeRefiner";
                    break;
                default:
                    arr[i8] = "descriptor";
            }
            String str4 = "refine";
            if (i != i7) {
                if (i != i6) {
                    if (i != i5) {
                        if (i != i4) {
                            if (i != i3) {
                                arr[i7] = str3;
                            } else {
                                arr[i7] = str4;
                            }
                        } else {
                            arr[i7] = "getBuiltIns";
                        }
                    } else {
                        arr[i7] = "getSupertypes";
                    }
                } else {
                    arr[i7] = "getParameters";
                }
            } else {
                arr[i7] = "getTypeParameterDescriptor";
            }
            switch (i) {
                case 2:
                    arr[i6] = str4;
                    break;
                default:
                    arr[i6] = "<init>";
            }
            String format = String.format(str, arr);
            if (i != i7 && i != i6 && i != i5 && i != i4 && i != i3) {
                if (i != i6) {
                    if (i != i5) {
                        if (i != i4) {
                            if (i != i3) {
                                obj10 = new IllegalArgumentException(format);
                            } else {
                                obj10 = new IllegalStateException(format);
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            throw obj10;
        }

        public Collection<kotlin.i0.z.e.m0.l.b0> a() {
            Collection collection = this.b.a();
            if (collection == null) {
            } else {
                return collection;
            }
            t.f.f(3);
            throw 0;
        }

        @Override // kotlin.i0.z.e.m0.l.t0
        public kotlin.i0.z.e.m0.l.t0 b(g g) {
            if (g == null) {
            } else {
                return this;
            }
            t.f.f(5);
            throw 0;
        }

        @Override // kotlin.i0.z.e.m0.l.t0
        public h c() {
            return this.b.c();
        }

        @Override // kotlin.i0.z.e.m0.l.t0
        public boolean d() {
            return this.b.d();
        }

        @Override // kotlin.i0.z.e.m0.l.t0
        public z0 g() {
            z0 z0Var = this.a;
            if (z0Var == null) {
            } else {
                return z0Var;
            }
            t.f.f(1);
            throw 0;
        }

        public List<z0> getParameters() {
            List parameters = this.b.getParameters();
            if (parameters == null) {
            } else {
                return parameters;
            }
            t.f.f(2);
            throw 0;
        }

        @Override // kotlin.i0.z.e.m0.l.t0
        public h m() {
            h hVar = a.g(this.a);
            if (hVar == null) {
            } else {
                return hVar;
            }
            t.f.f(4);
            throw 0;
        }
    }

    static class a implements c0 {
        private static void E(int i) {
            String str2;
            int i2;
            String str3;
            String str;
            Object obj12;
            final int i3 = 14;
            final int i4 = 13;
            final int i5 = 6;
            final int i6 = 5;
            final int i7 = 4;
            final int i8 = 1;
            if (i != i8 && i != i7 && i != i6 && i != i5 && i != i4 && i != i3) {
                if (i != i7) {
                    if (i != i6) {
                        if (i != i5) {
                            if (i != i4) {
                                if (i != i3) {
                                    str2 = /* condition */ ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
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
            final int i9 = 2;
            if (i != i8 && i != i7 && i != i6 && i != i5 && i != i4 && i != i3) {
                if (i != i7) {
                    if (i != i6) {
                        if (i != i5) {
                            if (i != i4) {
                                if (i != i3) {
                                    i2 = /* condition */ ? i9 : 3;
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
            str3 = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1";
            int i10 = 0;
            switch (i) {
                case 1:
                    arr[i10] = str3;
                    break;
                case 2:
                    arr[i10] = "fqName";
                    break;
                case 3:
                    arr[i10] = "nameFilter";
                    break;
                case 4:
                    arr[i10] = "visitor";
                    break;
                case 5:
                    arr[i10] = "targetModule";
                    break;
                default:
                    arr[i10] = "capability";
            }
            String str4 = "getSubPackagesOf";
            if (i != i8) {
                if (i != i7) {
                    if (i != i6) {
                        if (i != i5) {
                            if (i != i4) {
                                if (i != i3) {
                                    switch (i) {
                                        case 8:
                                            arr[i8] = "getAllDependencyModules";
                                            break;
                                        case 9:
                                            arr[i8] = "getExpectedByModules";
                                            break;
                                        case 10:
                                            arr[i8] = "getAllExpectedByModules";
                                            break;
                                        default:
                                            arr[i8] = str3;
                                    }
                                } else {
                                    arr[i8] = "getBuiltIns";
                                }
                            } else {
                                arr[i8] = "getOriginal";
                            }
                        } else {
                            arr[i8] = "getStableName";
                        }
                    } else {
                        arr[i8] = "getName";
                    }
                } else {
                    arr[i8] = str4;
                }
            } else {
                arr[i8] = "getAnnotations";
            }
            switch (i) {
                case 2:
                    arr[i9] = str4;
                    break;
                case 3:
                    arr[i9] = "getPackage";
                    break;
                case 4:
                    arr[i9] = "accept";
                    break;
                case 5:
                    arr[i9] = "shouldSeeInternalsOf";
                    break;
                default:
                    arr[i9] = "getCapability";
            }
            String format = String.format(str2, arr);
            if (i != i8 && i != i7 && i != i6 && i != i5 && i != i4 && i != i3) {
                if (i != i7) {
                    if (i != i6) {
                        if (i != i5) {
                            if (i != i4) {
                                if (i != i3) {
                                    if (/* condition */) {
                                        obj12 = new IllegalStateException(format);
                                    } else {
                                        obj12 = new IllegalArgumentException(format);
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
            throw obj12;
        }

        public <T> T F0(b0<T> b0) {
            final int i = 0;
            if (b0 == null) {
            } else {
                return i;
            }
            t.a.E(0);
            throw i;
        }

        public <R, D> R K(o<R, D> o, D d2) {
            final int obj2 = 0;
            if (o == null) {
            } else {
                return obj2;
            }
            t.a.E(11);
            throw obj2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
        public k0 M(b b) {
            if (b == null) {
                t.a.E(7);
                throw 0;
            }
            IllegalStateException obj2 = new IllegalStateException("Should not be called!");
            throw obj2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
        public m a() {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
        public m b() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
        public boolean e0(c0 c0) {
            if (c0 == null) {
            } else {
                return 0;
            }
            t.a.E(12);
            throw 0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
        public g getAnnotations() {
            g gVar = g.q.b();
            if (gVar == null) {
            } else {
                return gVar;
            }
            t.a.E(1);
            throw 0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
        public e getName() {
            e eVar = e.n("<ERROR MODULE>");
            if (eVar == null) {
            } else {
                return eVar;
            }
            t.a.E(5);
            throw 0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
        public h m() {
            e eVar = e.N0();
            if (eVar == null) {
            } else {
                return eVar;
            }
            t.a.E(14);
            throw 0;
        }

        public Collection<b> n(b b, l<? super e, Boolean> l2) {
            final int i = 0;
            if (b == null) {
            } else {
                if (l2 == null) {
                } else {
                    List obj2 = p.g();
                    if (obj2 == null) {
                    } else {
                        return obj2;
                    }
                    t.a.E(4);
                    throw i;
                }
                t.a.E(3);
                throw i;
            }
            t.a.E(2);
            throw i;
        }

        public List<c0> s0() {
            List list = p.g();
            if (list == null) {
            } else {
                return list;
            }
            t.a.E(9);
            throw 0;
        }
    }

    private static class c extends h {
        public c(e e) {
            if (e == null) {
            } else {
                final u0 u0Var2 = u0.a;
                super(t.q(), e, z.OPEN, f.CLASS, Collections.emptyList(), u0Var2, 0, f.e);
                f obj11 = f.l1(this, g.q.b(), true, u0Var2);
                obj11.o1(Collections.emptyList(), t.d);
                h hVar = t.h(getName().c());
                s sVar = new s(t.d("<ERROR>", this), hVar);
                obj11.f1(sVar);
                J0(hVar, Collections.singleton(obj11), obj11);
            }
            t.c.J(0);
            throw 0;
        }

        private static void J(int i) {
            String str2;
            int i2;
            String str3;
            String str;
            Object obj9;
            final int i3 = 8;
            final int i4 = 5;
            final int i5 = 2;
            if (i != i5 && i != i4 && i != i3) {
                if (i != i4) {
                    str2 = i != i3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
                } else {
                }
            } else {
            }
            if (i != i5 && i != i4 && i != i3) {
                if (i != i4) {
                    i2 = i != i3 ? 3 : i5;
                } else {
                }
            } else {
            }
            Object[] arr = new Object[i2];
            str3 = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor";
            int i6 = 0;
            switch (i) {
                case 1:
                    arr[i6] = "substitutor";
                    break;
                case 2:
                    arr[i6] = str3;
                    break;
                case 3:
                    arr[i6] = "typeArguments";
                    break;
                case 4:
                    arr[i6] = "kotlinTypeRefiner";
                    break;
                case 5:
                    arr[i6] = "typeSubstitution";
                    break;
                default:
                    arr[i6] = "name";
            }
            String str5 = "getMemberScope";
            String str6 = "substitute";
            final int i7 = 1;
            if (i != i5) {
                if (i != i4 && i != i3) {
                    if (i != i3) {
                        arr[i7] = str3;
                    } else {
                        arr[i7] = str5;
                    }
                } else {
                }
            } else {
                arr[i7] = str6;
            }
            switch (i) {
                case 1:
                    arr[i5] = str6;
                    break;
                case 3:
                    arr[i5] = str5;
                    break;
                default:
                    arr[i5] = "<init>";
            }
            String format = String.format(str2, arr);
            if (i != i5 && i != i4 && i != i3) {
                if (i != i4) {
                    if (i != i3) {
                        obj9 = new IllegalArgumentException(format);
                    } else {
                        obj9 = new IllegalStateException(format);
                    }
                } else {
                }
            } else {
            }
            throw obj9;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.h
        public e C0(kotlin.i0.z.e.m0.l.a1 a1) {
            if (a1 == null) {
            } else {
                return this;
            }
            t.c.J(1);
            throw 0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.h
        public h E(kotlin.i0.z.e.m0.l.y0 y0, g g2) {
            final int i = 0;
            if (y0 == null) {
            } else {
                if (g2 == null) {
                } else {
                    StringBuilder obj4 = new StringBuilder();
                    obj4.append("Error scope for class ");
                    obj4.append(getName());
                    obj4.append(" with arguments: ");
                    obj4.append(y0);
                    h obj3 = t.h(obj4.toString());
                    if (obj3 == null) {
                    } else {
                        return obj3;
                    }
                    t.c.J(8);
                    throw i;
                }
                t.c.J(7);
                throw i;
            }
            t.c.J(6);
            throw i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.h
        public n c(kotlin.i0.z.e.m0.l.a1 a1) {
            C0(a1);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.h
        public String toString() {
            return getName().c();
        }
    }
    static {
        t.a aVar = new t.a();
        t.a = aVar;
        t.c cVar = new t.c(e.n("<ERROR CLASS>"));
        t.b = cVar;
        t.c = t.j("<LOOP IN SUPERTYPES>");
        t.d = t.j("<ERROR PROPERTY TYPE>");
        b0 b0Var = t.g();
        t.e = b0Var;
        t.f = Collections.singleton(b0Var);
    }

    private static void a(int i) {
        String str3;
        int i3;
        String str2;
        String str;
        Object obj9;
        final int i4 = 19;
        final int i5 = 6;
        final int i6 = 4;
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
                i3 = i != i4 ? 3 : i7;
            } else {
            }
        } else {
        }
        Object[] arr = new Object[i3];
        str2 = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils";
        int i8 = 0;
        switch (i) {
            case 1:
                arr[i8] = "debugMessage";
                break;
            case 2:
                arr[i8] = str2;
                break;
            case 3:
                arr[i8] = "ownerScope";
                break;
            case 4:
                arr[i8] = "debugName";
                break;
            case 5:
                arr[i8] = "typeConstructor";
                break;
            case 6:
                arr[i8] = "arguments";
                break;
            case 7:
                arr[i8] = "presentableName";
                break;
            case 8:
                arr[i8] = "errorClass";
                break;
            case 9:
                arr[i8] = "typeParameterDescriptor";
                break;
            default:
                arr[i8] = "function";
        }
        String str4 = "createErrorFunction";
        int i9 = 1;
        if (i != i6) {
            if (i != i5) {
                if (i != i4) {
                    arr[i9] = str2;
                } else {
                    arr[i9] = "getErrorModule";
                }
            } else {
                arr[i9] = str4;
            }
        } else {
            arr[i9] = "createErrorProperty";
        }
        switch (i) {
            case 1:
                arr[i7] = "createErrorClass";
                break;
            case 2:
                arr[i7] = "createErrorScope";
                break;
            case 4:
                arr[i7] = str4;
                break;
            case 5:
                arr[i7] = "createErrorType";
                break;
            case 6:
                arr[i7] = "createErrorTypeWithCustomDebugName";
                break;
            case 7:
                arr[i7] = "createErrorTypeWithCustomConstructor";
                break;
            case 8:
                arr[i7] = "createErrorTypeWithArguments";
                break;
            case 9:
                arr[i7] = "createUnresolvedType";
                break;
            case 10:
                arr[i7] = "createErrorTypeConstructor";
                break;
            case 11:
                arr[i7] = "createErrorTypeConstructorWithCustomDebugName";
                break;
            case 12:
                arr[i7] = "createUninferredParameterType";
                break;
            default:
                arr[i7] = "containsErrorTypeInParameters";
        }
        String format = String.format(str3, arr);
        if (i != i6 && i != i5 && i != i4) {
            if (i != i5) {
                if (i != i4) {
                    obj9 = new IllegalArgumentException(format);
                } else {
                    obj9 = new IllegalStateException(format);
                }
            } else {
            }
        } else {
        }
        throw obj9;
    }

    static Set b() {
        return t.f;
    }

    static t0 c(kotlin.i0.z.e.m0.l.t.d t$d) {
        return t.f(d);
    }

    static kotlin.i0.z.e.m0.l.t0 d(String string, kotlin.i0.z.e.m0.l.t.c t$c2) {
        return t.m(string, c2);
    }

    public static e e(String string) {
        if (string == null) {
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<ERROR CLASS: ");
            stringBuilder.append(string);
            stringBuilder.append(">");
            t.c cVar = new t.c(e.n(stringBuilder.toString()));
            return cVar;
        }
        t.a(1);
        throw 0;
    }

    private static t0 f(kotlin.i0.z.e.m0.l.t.d t$d) {
        if (d == null) {
        } else {
            a aVar2 = new a(t.b, d);
            aVar2.m1(0, 0, Collections.emptyList(), Collections.emptyList(), t.j("<ERROR FUNCTION RETURN TYPE>"), z.OPEN, t.e);
            return aVar2;
        }
        t.a(5);
        throw 0;
    }

    private static b0 g() {
        b0 b0Var = b0.M0(t.b, g.q.b(), z.OPEN, t.e, true, e.n("<ERROR PROPERTY>"), b.a.DECLARATION, u0.a, false, false, false, false, false, false);
        int i2 = 0;
        b0Var.Y0(t.d, Collections.emptyList(), i2, i2);
        if (b0Var == null) {
        } else {
            return b0Var;
        }
        t.a(4);
        throw i2;
    }

    public static h h(String string) {
        if (string == null) {
        } else {
            return t.i(string, false);
        }
        t.a(2);
        throw 0;
    }

    public static h i(String string, boolean z2) {
        final int i = 0;
        if (string == null) {
        } else {
            if (z2) {
                t.e obj2 = new t.e(string, i);
                return obj2;
            }
            obj2 = new t.d(string, i);
            return obj2;
        }
        t.a(3);
        throw i;
    }

    public static kotlin.i0.z.e.m0.l.i0 j(String string) {
        if (string == null) {
        } else {
            return t.n(string, Collections.emptyList());
        }
        t.a(7);
        throw 0;
    }

    public static kotlin.i0.z.e.m0.l.t0 k(String string) {
        if (string == null) {
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[ERROR : ");
            stringBuilder.append(string);
            stringBuilder.append("]");
            return t.m(stringBuilder.toString(), t.b);
        }
        t.a(15);
        throw 0;
    }

    public static kotlin.i0.z.e.m0.l.t0 l(String string) {
        if (string == null) {
        } else {
            return t.m(string, t.b);
        }
        t.a(16);
        throw 0;
    }

    private static kotlin.i0.z.e.m0.l.t0 m(String string, kotlin.i0.z.e.m0.l.t.c t$c2) {
        int i = 0;
        if (string == null) {
        } else {
            if (c2 == null) {
            } else {
                t.b bVar = new t.b(c2, string);
                return bVar;
            }
            t.a(18);
            throw i;
        }
        t.a(17);
        throw i;
    }

    public static kotlin.i0.z.e.m0.l.i0 n(String string, List<kotlin.i0.z.e.m0.l.v0> list2) {
        int i = 0;
        if (string == null) {
        } else {
            if (list2 == null) {
            } else {
                s sVar = new s(t.k(string), t.h(string), list2, 0);
                return sVar;
            }
            t.a(12);
            throw i;
        }
        t.a(11);
        throw i;
    }

    public static kotlin.i0.z.e.m0.l.i0 o(String string, kotlin.i0.z.e.m0.l.t0 t02) {
        int i = 0;
        if (string == null) {
        } else {
            if (t02 == null) {
            } else {
                s sVar = new s(t02, t.h(string));
                return sVar;
            }
            t.a(10);
            throw i;
        }
        t.a(9);
        throw i;
    }

    public static kotlin.i0.z.e.m0.l.i0 p(String string) {
        if (string == null) {
        } else {
            return t.o(string, t.l(string));
        }
        t.a(8);
        throw 0;
    }

    public static c0 q() {
        c0 c0Var = t.a;
        if (c0Var == null) {
        } else {
            return c0Var;
        }
        t.a(19);
        throw 0;
    }

    public static boolean r(m m) {
        int i;
        boolean z;
        if (m == null) {
            return 0;
        }
        if (!t.s(m) && !t.s(m.b())) {
            if (!t.s(m.b())) {
                if (m == t.a) {
                    i = 1;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private static boolean s(m m) {
        return m instanceof t.c;
    }

    public static boolean t(kotlin.i0.z.e.m0.l.b0 b0) {
        boolean obj0;
        if (b0 && obj0 instanceof t.f) {
            obj0 = obj0 instanceof t.f ? 1 : 0;
        } else {
        }
        return obj0;
    }
}
