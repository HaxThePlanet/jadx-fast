package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.d0.c.a;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.v.o.b;
import kotlin.i0.z.e.m0.l.a1;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.i0.z.e.m0.l.o;
import kotlin.i0.z.e.m0.l.y0;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.a.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.b.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.b;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.i;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n;
import kotlin.reflect.jvm.internal.impl.descriptors.o;
import kotlin.reflect.jvm.internal.impl.descriptors.p;
import kotlin.reflect.jvm.internal.impl.descriptors.r0;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.x.a;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.utils.i;
import kotlin.y.p;

/* loaded from: classes3.dex */
public abstract class p extends kotlin.reflect.jvm.internal.impl.descriptors.j1.k implements x {

    private r0 A;
    private z B;
    private u C;
    private boolean D = false;
    private boolean E = false;
    private boolean F = false;
    private boolean G = false;
    private boolean H = false;
    private boolean I = false;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private boolean N = true;
    private boolean O = false;
    private Collection<? extends x> P = null;
    private volatile a<Collection<x>> Q = null;
    private final x R;
    private final b.a S;
    private x T = null;
    protected Map<a.a<?>, Object> U = null;
    private List<z0> w;
    private List<c1> x;
    private b0 y;
    private r0 z;

    public class c implements x.a<x> {

        protected y0 a;
        protected m b;
        protected z c;
        protected u d;
        protected x e = null;
        protected b.a f;
        protected List<c1> g;
        protected r0 h;
        protected r0 i;
        protected b0 j;
        protected e k;
        protected boolean l = true;
        protected boolean m = false;
        protected boolean n = false;
        protected boolean o = false;
        private boolean p;
        private List<z0> q = null;
        private g r = null;
        private boolean s;
        private Map<a.a<?>, Object> t;
        private Boolean u = null;
        protected boolean v = false;
        final kotlin.reflect.jvm.internal.impl.descriptors.j1.p w;
        public c(kotlin.reflect.jvm.internal.impl.descriptors.j1.p p, y0 y02, m m3, z z4, u u5, b.a b$a6, List list7, r0 r08, b0 b09, e e10) {
            final int i2 = 0;
            if (y02 == null) {
            } else {
                if (m3 == null) {
                } else {
                    if (z4 == null) {
                    } else {
                        if (u5 == null) {
                        } else {
                            if (a6 == null) {
                            } else {
                                if (list7 == null) {
                                } else {
                                    if (b09 == null) {
                                    } else {
                                        this.w = p;
                                        super();
                                        this.i = p.C0(p);
                                        this.p = p.v0();
                                        this.s = p.z0();
                                        LinkedHashMap obj5 = new LinkedHashMap();
                                        this.t = obj5;
                                        this.a = y02;
                                        this.b = m3;
                                        this.c = z4;
                                        this.d = u5;
                                        this.f = a6;
                                        this.g = list7;
                                        this.h = r08;
                                        this.j = b09;
                                        this.k = e10;
                                    }
                                    p.c.t(6);
                                    throw i2;
                                }
                                p.c.t(5);
                                throw i2;
                            }
                            p.c.t(4);
                            throw i2;
                        }
                        p.c.t(3);
                        throw i2;
                    }
                    p.c.t(2);
                    throw i2;
                }
                p.c.t(1);
                throw i2;
            }
            p.c.t(0);
            throw i2;
        }

        private static void t(int i) {
            String str3;
            Object illegalStateException;
            int i2;
            String str2;
            String str;
            str3 = /* condition */ ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            i2 = /* condition */ ? i3 : 3;
            Object[] arr = new Object[i2];
            str2 = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
            int i4 = 0;
            switch (i) {
                case 1:
                    arr[i4] = "newOwner";
                    break;
                case 2:
                    arr[i4] = "newModality";
                    break;
                case 3:
                    arr[i4] = "newVisibility";
                    break;
                case 4:
                    arr[i4] = "kind";
                    break;
                case 5:
                    arr[i4] = "newValueParameterDescriptors";
                    break;
                case 6:
                    arr[i4] = "newReturnType";
                    break;
                case 7:
                    arr[i4] = "owner";
                    break;
                case 8:
                    arr[i4] = str2;
                    break;
                case 9:
                    arr[i4] = "modality";
                    break;
                case 10:
                    arr[i4] = "visibility";
                    break;
                case 11:
                    arr[i4] = "name";
                    break;
                case 12:
                    arr[i4] = "parameters";
                    break;
                case 13:
                    arr[i4] = "type";
                    break;
                case 14:
                    arr[i4] = "additionalAnnotations";
                    break;
                case 15:
                    arr[i4] = "substitution";
                    break;
                default:
                    arr[i4] = "userDataKey";
            }
            String str4 = "putUserData";
            String str5 = "setSubstitution";
            final String str6 = "setAdditionalAnnotations";
            final String str7 = "setReturnType";
            final String str8 = "setTypeParameters";
            final String str9 = "setValueParameters";
            final String str10 = "setName";
            final String str11 = "setKind";
            final String str12 = "setVisibility";
            final String str13 = "setModality";
            final String str14 = "setOwner";
            final int i5 = 1;
            switch (i) {
                case 8:
                    arr[i5] = str14;
                    break;
                case 9:
                    arr[i5] = str2;
                    break;
                case 10:
                    arr[i5] = str13;
                    break;
                case 11:
                    arr[i5] = str12;
                    break;
                case 12:
                    arr[i5] = str11;
                    break;
                case 13:
                    arr[i5] = "setCopyOverrides";
                    break;
                case 14:
                    arr[i5] = str10;
                    break;
                case 15:
                    arr[i5] = str9;
                    break;
                case 16:
                    arr[i5] = str8;
                    break;
                case 17:
                    arr[i5] = str7;
                    break;
                case 18:
                    arr[i5] = "setExtensionReceiverParameter";
                    break;
                case 19:
                    arr[i5] = "setDispatchReceiverParameter";
                    break;
                case 20:
                    arr[i5] = "setOriginal";
                    break;
                case 21:
                    arr[i5] = "setSignatureChange";
                    break;
                case 22:
                    arr[i5] = "setPreserveSourceElement";
                    break;
                case 23:
                    arr[i5] = "setDropOriginalInContainingParts";
                    break;
                case 24:
                    arr[i5] = "setHiddenToOvercomeSignatureClash";
                    break;
                case 25:
                    arr[i5] = "setHiddenForResolutionEverywhereBesideSupercalls";
                    break;
                case 26:
                    arr[i5] = str6;
                    break;
                case 27:
                    arr[i5] = str5;
                    break;
                case 28:
                    arr[i5] = str4;
                    break;
                case 29:
                    arr[i5] = "getSubstitution";
                    break;
                default:
                    arr[i5] = "setJustForTypeSubstitution";
            }
            switch (i) {
                case 7:
                    arr[i3] = str14;
                    break;
                case 9:
                    arr[i3] = str13;
                    break;
                case 10:
                    arr[i3] = str12;
                    break;
                case 11:
                    arr[i3] = str11;
                    break;
                case 12:
                    arr[i3] = str10;
                    break;
                case 13:
                    arr[i3] = str9;
                    break;
                case 14:
                    arr[i3] = str8;
                    break;
                case 15:
                    arr[i3] = str7;
                    break;
                case 16:
                    arr[i3] = str6;
                    break;
                case 17:
                    arr[i3] = str5;
                    break;
                case 18:
                    arr[i3] = str4;
                    break;
                default:
                    arr[i3] = "<init>";
            }
            if (/* condition */) {
                illegalStateException = new IllegalStateException(format);
            } else {
                illegalStateException = new IllegalArgumentException(format);
            }
            throw illegalStateException;
        }

        static g u(kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c p$c) {
            return c.r;
        }

        static List v(kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c p$c) {
            return c.q;
        }

        static boolean w(kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c p$c) {
            return c.p;
        }

        static boolean x(kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c p$c) {
            return c.s;
        }

        static Boolean y(kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c p$c) {
            return c.u;
        }

        static Map z(kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c p$c) {
            return c.t;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c A(g g) {
            if (g == null) {
            } else {
                this.r = g;
                return this;
            }
            p.c.t(32);
            throw 0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c B(boolean z) {
            this.l = z;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c C(r0 r0) {
            this.i = r0;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c D() {
            this.o = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c E(r0 r0) {
            this.h = r0;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c F(boolean z) {
            this.u = Boolean.valueOf(z);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c G() {
            this.s = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c H() {
            this.p = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c I(boolean z) {
            this.v = z;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c J(b.a b$a) {
            if (a == null) {
            } else {
                this.f = a;
                return this;
            }
            p.c.t(13);
            throw 0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c K(z z) {
            if (z == null) {
            } else {
                this.c = z;
                return this;
            }
            p.c.t(9);
            throw 0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c L(e e) {
            if (e == null) {
            } else {
                this.k = e;
                return this;
            }
            p.c.t(16);
            throw 0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c M(b b) {
            this.e = (x)b;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c N(m m) {
            if (m == null) {
            } else {
                this.b = m;
                return this;
            }
            p.c.t(7);
            throw 0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c O() {
            this.n = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c P(b0 b0) {
            if (b0 == null) {
            } else {
                this.j = b0;
                return this;
            }
            p.c.t(22);
            throw 0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c Q() {
            this.m = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c R(y0 y0) {
            if (y0 == null) {
            } else {
                this.a = y0;
                return this;
            }
            p.c.t(34);
            throw 0;
        }

        public kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c S(List<z0> list) {
            if (list == null) {
            } else {
                this.q = list;
                return this;
            }
            p.c.t(20);
            throw 0;
        }

        public kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c T(List<c1> list) {
            if (list == null) {
            } else {
                this.g = list;
                return this;
            }
            p.c.t(18);
            throw 0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c U(u u) {
            if (u == null) {
            } else {
                this.d = u;
                return this;
            }
            p.c.t(11);
            throw 0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public x.a a() {
            D();
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public x.a b(List list) {
            T(list);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public x build() {
            return this.w.L0(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public x.a c(z z) {
            K(z);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public x.a d(r0 r0) {
            C(r0);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public x.a e() {
            O();
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public x.a f(b0 b0) {
            P(b0);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public x.a g(b b) {
            M(b);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public x.a h() {
            G();
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public x.a i(boolean z) {
            B(z);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public x.a j(r0 r0) {
            E(r0);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public x.a k(y0 y0) {
            R(y0);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public x.a l(List list) {
            S(list);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public x.a m(u u) {
            U(u);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public x.a n(m m) {
            N(m);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public x.a o() {
            H();
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public x.a p(b.a b$a) {
            J(a);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public x.a q(g g) {
            A(g);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public x.a r(e e) {
            L(e);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.x$a
        public x.a s() {
            Q();
            return this;
        }
    }

    class a implements a<Collection<x>> {

        final a1 a;
        final kotlin.reflect.jvm.internal.impl.descriptors.j1.p b;
        a(kotlin.reflect.jvm.internal.impl.descriptors.j1.p p, a1 a12) {
            this.b = p;
            this.a = a12;
            super();
        }

        public Collection<x> a() {
            x xVar;
            a1 a1Var;
            i iVar = new i();
            Iterator iterator = this.b.e().iterator();
            for (x next2 : iterator) {
                iVar.add(next2.c(this.a));
            }
            return iVar;
        }

        @Override // kotlin.d0.c.a
        public Object invoke() {
            return a();
        }
    }

    static class b implements a<List<d1>> {

        final List a;
        b(List list) {
            this.a = list;
            super();
        }

        public List<d1> a() {
            return this.a;
        }

        @Override // kotlin.d0.c.a
        public Object invoke() {
            return a();
        }
    }
    protected p(m m, x x2, g g3, e e4, b.a b$a5, u0 u06) {
        Object obj5;
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
                            super(m, g3, e4, u06);
                            this.C = t.i;
                            obj5 = x2 == null ? this : obj5;
                            this.R = obj5;
                            this.S = a5;
                        }
                        p.E(4);
                        throw i;
                    }
                    p.E(3);
                    throw i;
                }
                p.E(2);
                throw i;
            }
            p.E(1);
            throw i;
        }
        p.E(0);
        throw i;
    }

    static r0 C0(kotlin.reflect.jvm.internal.impl.descriptors.j1.p p) {
        return p.A;
    }

    private static void E(int i) {
        String str2;
        int i3;
        String str3;
        String str;
        Object obj7;
        str2 = /* condition */ ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        i3 = /* condition */ ? i4 : 3;
        Object[] arr = new Object[i3];
        str3 = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
        int i5 = 0;
        switch (i) {
            case 1:
                arr[i5] = "annotations";
                break;
            case 2:
                arr[i5] = "name";
                break;
            case 3:
                arr[i5] = "kind";
                break;
            case 4:
                arr[i5] = "source";
                break;
            case 5:
                arr[i5] = "typeParameters";
                break;
            case 6:
                arr[i5] = "unsubstitutedValueParameters";
                break;
            case 7:
                arr[i5] = "visibility";
                break;
            case 8:
                arr[i5] = str3;
                break;
            case 9:
                arr[i5] = "unsubstitutedReturnType";
                break;
            case 10:
                arr[i5] = "extensionReceiverParameter";
                break;
            case 11:
                arr[i5] = "overriddenDescriptors";
                break;
            case 12:
                arr[i5] = "originalSubstitutor";
                break;
            case 13:
                arr[i5] = "substitutor";
                break;
            case 14:
                arr[i5] = "configuration";
                break;
            default:
                arr[i5] = "containingDeclaration";
        }
        String str4 = "newCopyBuilder";
        String str5 = "initialize";
        final int i6 = 1;
        switch (i) {
            case 8:
                arr[i6] = str5;
                break;
            case 9:
                arr[i6] = str3;
                break;
            case 10:
                arr[i6] = "getOverriddenDescriptors";
                break;
            case 11:
                arr[i6] = "getModality";
                break;
            case 12:
                arr[i6] = "getVisibility";
                break;
            case 13:
                arr[i6] = "getTypeParameters";
                break;
            case 14:
                arr[i6] = "getValueParameters";
                break;
            case 15:
                arr[i6] = "getOriginal";
                break;
            case 16:
                arr[i6] = "getKind";
                break;
            case 17:
                arr[i6] = str4;
                break;
            case 18:
                arr[i6] = "copy";
                break;
            default:
                arr[i6] = "getSourceToUseForCopy";
        }
        switch (i) {
            case 5:
                arr[i4] = str5;
                break;
            case 7:
                arr[i4] = "setVisibility";
                break;
            case 8:
                arr[i4] = "setReturnType";
                break;
            case 9:
                arr[i4] = "setExtensionReceiverParameter";
                break;
            case 10:
                arr[i4] = "setOverriddenDescriptors";
                break;
            case 11:
                arr[i4] = "substitute";
                break;
            case 12:
                arr[i4] = str4;
                break;
            case 13:
                arr[i4] = "doSubstitute";
                break;
            case 14:
                arr[i4] = "getSubstitutedValueParameters";
                break;
            default:
                arr[i4] = "<init>";
        }
        if (/* condition */) {
            obj7 = new IllegalStateException(format);
        } else {
            obj7 = new IllegalArgumentException(format);
        }
        throw obj7;
    }

    private u0 M0(boolean z, x x2) {
        u0 obj1;
        x obj2;
        if (z) {
            if (x2 != null) {
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
        p.E(25);
        throw 0;
    }

    public static List<c1> N0(x x, List<c1> list2, a1 a13) {
        final int i = 0;
        if (list2 == null) {
        } else {
            if (a13 == null) {
            } else {
                return p.O0(x, list2, a13, false, false, 0);
            }
            p.E(27);
            throw i;
        }
        p.E(26);
        throw i;
    }

    public static List<c1> O0(x x, List<c1> list2, a1 a13, boolean z4, boolean z5, boolean[] z6Arr6) {
        kotlin.reflect.jvm.internal.impl.descriptors.j1.k0 k0Var;
        u0 source;
        List list;
        b0 b0Var4;
        b0 b0Var2;
        a aVar;
        b0 bVar;
        int i;
        int index;
        g annotations;
        e name;
        b0 b0Var3;
        boolean z3;
        boolean z2;
        boolean z;
        b0 b0Var;
        u0 u0Var;
        kotlin.reflect.jvm.internal.impl.descriptors.j1.p.b bVar2;
        Object obj = a13;
        final int i4 = 0;
        if (list2 == null) {
        } else {
            if (obj == null) {
            } else {
                ArrayList arrayList = new ArrayList(list2.size());
                Iterator iterator = list2.iterator();
                while (iterator.hasNext()) {
                    Object next2 = iterator.next();
                    h1 iN_VARIANCE = h1.IN_VARIANCE;
                    b0Var3 = obj.p((c1)next2.getType(), iN_VARIANCE);
                    b0Var4 = next2.l0();
                    if (b0Var4 == null) {
                    } else {
                    }
                    b0Var2 = obj.p(b0Var4, iN_VARIANCE);
                    if (b0Var3 == next2.getType()) {
                    } else {
                    }
                    if (z6Arr6 != null) {
                    }
                    if (next2 instanceof k0.b) {
                    } else {
                    }
                    bVar2 = i4;
                    if (z4) {
                    } else {
                    }
                    i = next2;
                    if (z5) {
                    } else {
                    }
                    source = u0.a;
                    arrayList.add(k0.J0(x, i, next2.getIndex(), next2.getAnnotations(), next2.getName(), b0Var3, next2.t0(), next2.b0(), next2.X(), b0Var2, source, bVar2));
                    source = next2.getSource();
                    i = i4;
                    bVar = new p.b((k0.b)next2.M0());
                    bVar2 = bVar;
                    z6Arr6[0] = 1;
                    if (b0Var4 != b0Var2 && z6Arr6 != null) {
                    }
                    b0Var2 = i4;
                }
                return arrayList;
            }
            p.E(29);
            throw i4;
        }
        p.E(28);
        throw i4;
    }

    private void S0() {
        a aVar;
        aVar = this.Q;
        if (aVar != null) {
            this.P = (Collection)aVar.invoke();
            this.Q = 0;
        }
    }

    private void Z0(boolean z) {
        this.L = z;
    }

    private void a1(boolean z) {
        this.K = z;
    }

    private void c1(x x) {
        this.T = x;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public boolean B0() {
        return this.J;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public boolean D() {
        return this.O;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public boolean E0() {
        boolean z;
        final int i2 = 1;
        if (this.E) {
            return i2;
        }
        Iterator iterator = a().e().iterator();
        for (x next2 : iterator) {
        }
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public p J() {
        return a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public x J0(m m, z z2, u u3, b.a b$a4, boolean z5) {
        x obj2 = s().n(m).c(z2).m(u3).p(a4).i(z5).build();
        if (obj2 == null) {
        } else {
            return obj2;
        }
        p.E(24);
        throw 0;
    }

    public <R, D> R K(o<R, D> o, D d2) {
        return o.g(this, d2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    protected abstract kotlin.reflect.jvm.internal.impl.descriptors.j1.p K0(m m, x x2, b.a b$a3, e e4, g g5, u0 u06);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public boolean L() {
        return this.I;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    protected x L0(kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c p$c) {
        g annotations;
        List typeParameters;
        int r0Var3;
        r0 r0Var;
        boolean booleanValue;
        Map singletonMap;
        boolean z2;
        Object obj;
        boolean aVar;
        int i2;
        g gVar;
        Object e0Var;
        int size;
        Object iterator;
        boolean i;
        boolean z;
        z value;
        Object type;
        int i3;
        u key;
        kotlin.reflect.jvm.internal.impl.descriptors.j1.e0 e0Var2;
        r0 r0Var2;
        final Object obj3 = this;
        final Object obj4 = c;
        final int i7 = 0;
        if (obj4 == null) {
        } else {
            final int i8 = 1;
            final boolean[] zArr2 = new boolean[i8];
            if (p.c.u(c) != null) {
                annotations = i.a(getAnnotations(), p.c.u(c));
            } else {
                annotations = getAnnotations();
            }
            x xVar3 = obj4.e;
            kotlin.reflect.jvm.internal.impl.descriptors.j1.p pVar2 = this.K0(obj4.b, xVar3, obj4.f, obj4.k, annotations, obj3.M0(obj4.n, xVar3));
            if (p.c.v(c) == null) {
                typeParameters = getTypeParameters();
            } else {
                typeParameters = p.c.v(c);
            }
            int i9 = 0;
            zArr2[i9] = z16 |= i;
            ArrayList arrayList = new ArrayList(typeParameters.size());
            a1 a1Var3 = o.c(typeParameters, obj4.a, pVar2, arrayList, zArr2);
            if (a1Var3 == null) {
                return i7;
            }
            r0Var3 = obj4.h;
            if (r0Var3 != null) {
                b0 b0Var = a1Var3.p(r0Var3.getType(), h1.IN_VARIANCE);
                if (b0Var == null) {
                    return i7;
                }
                b bVar = new b(pVar2, b0Var, obj4.h.getValue());
                e0Var = new e0(pVar2, bVar, obj4.h.getAnnotations());
                i2 = b0Var != obj4.h.getType() ? i8 : i9;
                zArr2[i9] = i2 |= i;
                e0Var2 = e0Var;
            } else {
                e0Var2 = i7;
            }
            r0Var = obj4.i;
            if (r0Var != null) {
                r0Var = r0Var.c(a1Var3);
                if (r0Var == null) {
                    return i7;
                }
                i = r0Var != obj4.i ? i8 : i9;
                zArr2[i9] = z17 |= i;
                r0Var2 = r0Var;
            } else {
                r0Var2 = i7;
            }
            List list2 = p.O0(pVar2, obj4.g, a1Var3, obj4.o, obj4.n, zArr2);
            if (list2 == null) {
                return i7;
            }
            size = a1Var3.p(obj4.j, h1.OUT_VARIANCE);
            if (size == null) {
                return i7;
            }
            i3 = size != obj4.j ? i8 : i9;
            zArr2[i9] = z18 |= i3;
            if (!zArr2[i9] && obj4.v) {
                if (obj4.v) {
                    return obj3;
                }
            }
            a1 a1Var2 = a1Var3;
            pVar2.Q0(e0Var2, r0Var2, arrayList, list2, size, obj4.c, obj4.d);
            pVar2.e1(obj3.D);
            pVar2.b1(obj3.E);
            pVar2.W0(obj3.F);
            pVar2.d1(obj3.G);
            pVar2.h1(obj3.H);
            pVar2.g1(obj3.M);
            pVar2.V0(obj3.I);
            pVar2.U0(obj3.J);
            pVar2.X0(obj3.N);
            pVar2.a1(p.c.w(c));
            pVar2.Z0(p.c.x(c));
            if (p.c.y(c) != null) {
                booleanValue = p.c.y(c).booleanValue();
            } else {
                booleanValue = obj3.O;
            }
            pVar2.Y0(booleanValue);
            if (p.c.z(c).isEmpty()) {
                singletonMap = p.c.z(c);
                iterator = obj3.U;
                if (obj3.U != null && iterator != null) {
                    singletonMap = p.c.z(c);
                    iterator = obj3.U;
                    if (iterator != null) {
                        iterator = iterator.entrySet().iterator();
                        while (iterator.hasNext()) {
                            value = iterator.next();
                            if (singletonMap.containsKey((Map.Entry)value.getKey()) == null) {
                            }
                            singletonMap.put(value.getKey(), value.getValue());
                        }
                    }
                    if (singletonMap.size() == i8) {
                        pVar2.U = Collections.singletonMap(singletonMap.keySet().iterator().next(), singletonMap.values().iterator().next());
                    } else {
                        pVar2.U = singletonMap;
                    }
                }
            } else {
            }
            if (!obj4.m) {
                if (d0() != null) {
                    if (d0() != null) {
                        obj = d0();
                    } else {
                        obj = obj3;
                    }
                    pVar2.c1(obj.c(a1Var2));
                }
            } else {
            }
            if (obj4.l && !a().e().isEmpty()) {
                if (!a().e().isEmpty()) {
                    if (obj4.a.f()) {
                        aVar = obj3.Q;
                        if (aVar != null) {
                            pVar2.Q = aVar;
                        } else {
                            pVar2.w0(e());
                        }
                    } else {
                        aVar = new p.a(obj3, a1Var2);
                        pVar2.Q = aVar;
                    }
                }
            }
            return pVar2;
        }
        p.E(23);
        throw i7;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public boolean O() {
        return this.H;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public boolean P() {
        boolean z;
        final int i2 = 1;
        if (this.D) {
            return i2;
        }
        Iterator iterator = a().e().iterator();
        for (x next2 : iterator) {
        }
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public boolean P0() {
        return this.N;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.j1.p Q0(r0 r0, r0 r02, List<? extends z0> list3, List<c1> list4, b0 b05, z z6, u u7) {
        int obj2;
        int obj3;
        Iterable obj4;
        b0 obj6;
        z obj7;
        u obj8;
        int i = 0;
        if (list3 == null) {
        } else {
            if (list4 == null) {
            } else {
                if (u7 == null) {
                } else {
                    this.w = p.L0(list3);
                    this.x = p.L0(list4);
                    this.y = b05;
                    this.B = z6;
                    this.C = u7;
                    this.z = r0;
                    this.A = r02;
                    obj3 = obj2;
                    obj7 = " but position is ";
                    while (obj3 < list3.size()) {
                        obj6 = list3.get(obj3);
                        obj3++;
                        obj7 = " but position is ";
                    }
                    while (obj2 < list4.size()) {
                        obj3 = list4.get(obj2);
                        obj2++;
                    }
                    return this;
                }
                p.E(7);
                throw i;
            }
            p.E(6);
            throw i;
        }
        p.E(5);
        throw i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    protected kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c R0(a1 a1) {
        if (a1 == null) {
        } else {
            super(this, a1.j(), b(), i(), getVisibility(), f(), h(), m0(), getReturnType(), 0);
            return cVar2;
        }
        p.E(22);
        throw 0;
    }

    public <V> void T0(a.a<V> a$a, Object object2) {
        Object linkedHashMap;
        if (this.U == null) {
            linkedHashMap = new LinkedHashMap();
            this.U = linkedHashMap;
        }
        this.U.put(a, object2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public void U0(boolean z) {
        this.J = z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public void V0(boolean z) {
        this.I = z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public void W0(boolean z) {
        this.F = z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public void X0(boolean z) {
        this.N = z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public void Y0(boolean z) {
        this.O = z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public a a() {
        return a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public b a() {
        return a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public m a() {
        return a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public x a() {
        Object obj;
        x xVar = this.R;
        if (xVar == this) {
            obj = this;
        } else {
            obj = xVar.a();
        }
        if (obj == null) {
        } else {
            return obj;
        }
        p.E(18);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public void b1(boolean z) {
        this.E = z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public n c(a1 a1) {
        return c(a1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public x c(a1 a1) {
        if (a1 == null) {
        } else {
            if (a1.k()) {
                return this;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c obj2 = R0(a1);
            obj2.M(a());
            obj2.O();
            obj2.I(true);
            return obj2.build();
        }
        p.E(20);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public x d0() {
        return this.T;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public void d1(boolean z) {
        this.G = z;
    }

    public Collection<? extends x> e() {
        Object emptyList;
        S0();
        if (this.P != null) {
        } else {
            emptyList = Collections.emptyList();
        }
        if (emptyList == null) {
        } else {
            return emptyList;
        }
        p.E(12);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public void e1(boolean z) {
        this.D = z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public b.a f() {
        b.a aVar = this.S;
        if (aVar == null) {
        } else {
            return aVar;
        }
        p.E(19);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public r0 f0() {
        return this.A;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public void f1(b0 b0) {
        if (b0 == null) {
        } else {
            this.y = b0;
        }
        p.E(10);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public void g1(boolean z) {
        this.M = z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public b0 getReturnType() {
        return this.y;
    }

    public List<z0> getTypeParameters() {
        List list = this.w;
        if (list == null) {
        } else {
            if (list == null) {
            } else {
                return list;
            }
            p.E(16);
            throw 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("typeParameters == null for ");
        stringBuilder.append(this);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public u getVisibility() {
        u uVar = this.C;
        if (uVar == null) {
        } else {
            return uVar;
        }
        p.E(14);
        throw 0;
    }

    public List<c1> h() {
        List list = this.x;
        if (list == null) {
        } else {
            return list;
        }
        p.E(17);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public void h1(boolean z) {
        this.H = z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public z i() {
        z zVar = this.B;
        if (zVar == null) {
        } else {
            return zVar;
        }
        p.E(13);
        throw 0;
    }

    public <V> V i0(a.a<V> a$a) {
        final Map map = this.U;
        if (map == null) {
            return 0;
        }
        return map.get(a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public void i1(u u) {
        if (u == null) {
        } else {
            this.C = u;
        }
        p.E(9);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public boolean isSuspend() {
        return this.M;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public b k0(m m, z z2, u u3, b.a b$a4, boolean z5) {
        return J0(m, z2, u3, a4, z5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public r0 m0() {
        return this.z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public boolean r() {
        return this.G;
    }

    public x.a<? extends x> s() {
        kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c cVar = R0(a1.b);
        if (cVar == null) {
        } else {
            return cVar;
        }
        p.E(21);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public boolean v0() {
        return this.K;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public boolean w() {
        return this.F;
    }

    public void w0(Collection<? extends b> collection) {
        boolean next;
        Iterator obj2;
        if (collection == null) {
        } else {
            this.P = collection;
            obj2 = collection.iterator();
            while (obj2.hasNext()) {
                if ((x)obj2.next().z0()) {
                    break;
                } else {
                }
            }
        }
        p.E(15);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public boolean z0() {
        return this.L;
    }
}
