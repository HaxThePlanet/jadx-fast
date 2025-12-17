package kotlin.i0.z.e.m0.h;

import java.lang.reflect.Field;
import java.util.Set;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.t;
import kotlin.d0.d.x;
import kotlin.f0.a;
import kotlin.f0.b;
import kotlin.f0.c;
import kotlin.i0.l;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.k0.l;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.c;
import kotlin.y.q0;

/* loaded from: classes3.dex */
public final class g implements kotlin.i0.z.e.m0.h.f {

    static final l<Object>[] X;
    private final c A;
    private final c B;
    private final c C;
    private final c D;
    private final c E;
    private final c F;
    private final c G;
    private final c H;
    private final c I;
    private final c J;
    private final c K;
    private final c L;
    private final c M;
    private final c N;
    private final c O;
    private final c P;
    private final c Q;
    private final c R;
    private final c S;
    private final c T;
    private final c U;
    private final c V;
    private final c W;
    private boolean a;
    private final c b;
    private final c c;
    private final c d;
    private final c e;
    private final c f;
    private final c g;
    private final c h;
    private final c i;
    private final c j;
    private final c k;
    private final c l;
    private final c m;
    private final c n;
    private final c o;
    private final c p;
    private final c q;
    private final c r;
    private final c s;
    private final c t;
    private final c u;
    private final c v;
    private final c w;
    private final c x;
    private final c y;
    private final c z;

    public static final class b extends b<T> {

        final Object a;
        final kotlin.i0.z.e.m0.h.g b;
        public b(Object object, Object object2, kotlin.i0.z.e.m0.h.g g3) {
            this.a = object;
            this.b = g3;
            super(object2);
        }

        protected boolean beforeChange(l<?> l, T t2, T t3) {
            n.f(l, "property");
            if (this.b.l0()) {
            } else {
                return 1;
            }
            IllegalStateException obj1 = new IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
            throw obj1;
        }
    }

    static final class a extends p implements l<c1, String> {

        public static final kotlin.i0.z.e.m0.h.g.a a;
        static {
            g.a aVar = new g.a();
            g.a.a = aVar;
        }

        a() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final String a(c1 c1) {
            n.f(c1, "it");
            return "...";
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((c1)object);
        }
    }

    static final class c extends p implements l<b0, b0> {

        public static final kotlin.i0.z.e.m0.h.g.c a;
        static {
            g.c cVar = new g.c();
            g.c.a = cVar;
        }

        c() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final b0 a(b0 b0) {
            n.f(b0, "it");
            return b0;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((b0)object);
            return object;
        }
    }
    static {
        Class<kotlin.i0.z.e.m0.h.g> obj = g.class;
        l[] arr = new l[48];
        t tVar = new t(c0.b(obj), "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;");
        t tVar2 = new t(c0.b(obj), "withDefinedIn", "getWithDefinedIn()Z");
        t tVar3 = new t(c0.b(obj), "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z");
        t tVar4 = new t(c0.b(obj), "modifiers", "getModifiers()Ljava/util/Set;");
        t tVar5 = new t(c0.b(obj), "startFromName", "getStartFromName()Z");
        t tVar6 = new t(c0.b(obj), "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z");
        t tVar7 = new t(c0.b(obj), "debugMode", "getDebugMode()Z");
        t tVar8 = new t(c0.b(obj), "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z");
        t tVar9 = new t(c0.b(obj), "verbose", "getVerbose()Z");
        t tVar10 = new t(c0.b(obj), "unitReturnType", "getUnitReturnType()Z");
        t tVar11 = new t(c0.b(obj), "withoutReturnType", "getWithoutReturnType()Z");
        t tVar12 = new t(c0.b(obj), "enhancedTypes", "getEnhancedTypes()Z");
        t tVar13 = new t(c0.b(obj), "normalizedVisibilities", "getNormalizedVisibilities()Z");
        t tVar14 = new t(c0.b(obj), "renderDefaultVisibility", "getRenderDefaultVisibility()Z");
        t tVar15 = new t(c0.b(obj), "renderDefaultModality", "getRenderDefaultModality()Z");
        t tVar16 = new t(c0.b(obj), "renderConstructorDelegation", "getRenderConstructorDelegation()Z");
        t tVar17 = new t(c0.b(obj), "renderPrimaryConstructorParametersAsProperties", "getRenderPrimaryConstructorParametersAsProperties()Z");
        t tVar18 = new t(c0.b(obj), "actualPropertiesInPrimaryConstructor", "getActualPropertiesInPrimaryConstructor()Z");
        t tVar19 = new t(c0.b(obj), "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z");
        t tVar20 = new t(c0.b(obj), "includePropertyConstant", "getIncludePropertyConstant()Z");
        t tVar21 = new t(c0.b(obj), "withoutTypeParameters", "getWithoutTypeParameters()Z");
        t tVar22 = new t(c0.b(obj), "withoutSuperTypes", "getWithoutSuperTypes()Z");
        t tVar23 = new t(c0.b(obj), "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;");
        t tVar24 = new t(c0.b(obj), "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;");
        t tVar25 = new t(c0.b(obj), "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z");
        t tVar26 = new t(c0.b(obj), "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;");
        t tVar27 = new t(c0.b(obj), "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;");
        t tVar28 = new t(c0.b(obj), "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;");
        t tVar29 = new t(c0.b(obj), "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;");
        t tVar30 = new t(c0.b(obj), "receiverAfterName", "getReceiverAfterName()Z");
        t tVar31 = new t(c0.b(obj), "renderCompanionObjectName", "getRenderCompanionObjectName()Z");
        t tVar32 = new t(c0.b(obj), "propertyAccessorRenderingPolicy", "getPropertyAccessorRenderingPolicy()Lorg/jetbrains/kotlin/renderer/PropertyAccessorRenderingPolicy;");
        t tVar33 = new t(c0.b(obj), "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z");
        t tVar34 = new t(c0.b(obj), "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z");
        t tVar35 = new t(c0.b(obj), "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;");
        t tVar36 = new t(c0.b(obj), "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;");
        t tVar37 = new t(c0.b(obj), "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;");
        t tVar38 = new t(c0.b(obj), "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;");
        t tVar39 = new t(c0.b(obj), "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z");
        t tVar40 = new t(c0.b(obj), "renderConstructorKeyword", "getRenderConstructorKeyword()Z");
        t tVar41 = new t(c0.b(obj), "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z");
        t tVar42 = new t(c0.b(obj), "renderTypeExpansions", "getRenderTypeExpansions()Z");
        t tVar43 = new t(c0.b(obj), "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z");
        t tVar44 = new t(c0.b(obj), "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z");
        t tVar45 = new t(c0.b(obj), "renderFunctionContracts", "getRenderFunctionContracts()Z");
        t tVar46 = new t(c0.b(obj), "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z");
        t tVar47 = new t(c0.b(obj), "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z");
        t tVar48 = new t(c0.b(obj), "informativeErrorType", "getInformativeErrorType()Z");
        g.X = arr;
    }

    public g() {
        super();
        this.b = n0(b.c.a);
        Boolean tRUE = Boolean.TRUE;
        this.c = n0(tRUE);
        this.d = n0(tRUE);
        this.e = n0(e.ALL_EXCEPT_ANNOTATIONS);
        Boolean fALSE = Boolean.FALSE;
        this.f = n0(fALSE);
        this.g = n0(fALSE);
        this.h = n0(fALSE);
        this.i = n0(fALSE);
        this.j = n0(fALSE);
        this.k = n0(tRUE);
        this.l = n0(fALSE);
        this.m = n0(fALSE);
        this.n = n0(fALSE);
        this.o = n0(tRUE);
        this.p = n0(tRUE);
        this.q = n0(fALSE);
        this.r = n0(fALSE);
        this.s = n0(fALSE);
        this.t = n0(fALSE);
        this.u = n0(fALSE);
        this.v = n0(fALSE);
        this.w = n0(fALSE);
        this.x = n0(g.c.a);
        this.y = n0(g.a.a);
        this.z = n0(tRUE);
        this.A = n0(j.RENDER_OPEN);
        this.B = n0(c.l.a.a);
        this.C = n0(m.PLAIN);
        this.D = n0(k.ALL);
        this.E = n0(fALSE);
        this.F = n0(fALSE);
        this.G = n0(l.DEBUG);
        this.H = n0(fALSE);
        this.I = n0(fALSE);
        this.J = n0(q0.b());
        this.K = n0(h.a.a());
        this.L = n0(0);
        this.M = n0(a.NO_ARGUMENTS);
        this.N = n0(fALSE);
        this.O = n0(tRUE);
        this.P = n0(tRUE);
        this.Q = n0(fALSE);
        this.R = n0(tRUE);
        this.S = n0(tRUE);
        this.T = n0(fALSE);
        this.U = n0(fALSE);
        this.V = n0(fALSE);
        this.W = n0(tRUE);
    }

    private final <T> c<kotlin.i0.z.e.m0.h.g, T> n0(T t) {
        a aVar = a.a;
        g.b bVar = new g.b(t, t, this);
        return bVar;
    }

    public Set<b> A() {
        return (Set)this.J.getValue(this, g.X[34]);
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean B() {
        return (Boolean)this.R.getValue(this, g.X[42]).booleanValue();
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean C() {
        return f.a.a(this);
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean D() {
        return f.a.b(this);
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean E() {
        return (Boolean)this.u.getValue(this, g.X[19]).booleanValue();
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean F() {
        return (Boolean)this.W.getValue(this, g.X[47]).booleanValue();
    }

    public Set<kotlin.i0.z.e.m0.h.e> G() {
        return (Set)this.e.getValue(this, g.X[3]);
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean H() {
        return (Boolean)this.n.getValue(this, g.X[12]).booleanValue();
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public kotlin.i0.z.e.m0.h.j I() {
        return (j)this.A.getValue(this, g.X[25]);
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public kotlin.i0.z.e.m0.h.k J() {
        return (k)this.D.getValue(this, g.X[28]);
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean K() {
        return (Boolean)this.S.getValue(this, g.X[43]).booleanValue();
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean L() {
        return (Boolean)this.U.getValue(this, g.X[45]).booleanValue();
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public kotlin.i0.z.e.m0.h.l M() {
        return (l)this.G.getValue(this, g.X[31]);
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean N() {
        return (Boolean)this.E.getValue(this, g.X[29]).booleanValue();
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean O() {
        return (Boolean)this.F.getValue(this, g.X[30]).booleanValue();
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean P() {
        return (Boolean)this.q.getValue(this, g.X[15]).booleanValue();
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean Q() {
        return (Boolean)this.O.getValue(this, g.X[39]).booleanValue();
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean R() {
        return (Boolean)this.H.getValue(this, g.X[32]).booleanValue();
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean S() {
        return (Boolean)this.p.getValue(this, g.X[14]).booleanValue();
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean T() {
        return (Boolean)this.o.getValue(this, g.X[13]).booleanValue();
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean U() {
        return (Boolean)this.r.getValue(this, g.X[16]).booleanValue();
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean V() {
        return (Boolean)this.Q.getValue(this, g.X[41]).booleanValue();
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean W() {
        return (Boolean)this.P.getValue(this, g.X[40]).booleanValue();
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean X() {
        return (Boolean)this.z.getValue(this, g.X[24]).booleanValue();
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean Y() {
        return (Boolean)this.g.getValue(this, g.X[5]).booleanValue();
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean Z() {
        return (Boolean)this.f.getValue(this, g.X[4]).booleanValue();
    }

    public void a(Set<b> set) {
        n.f(set, "<set-?>");
        this.K.setValue(this, g.X[35], set);
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public kotlin.i0.z.e.m0.h.m a0() {
        return (m)this.C.getValue(this, g.X[27]);
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public void b(boolean z) {
        this.f.setValue(this, g.X[4], Boolean.valueOf(z));
    }

    public l<b0, b0> b0() {
        return (l)this.x.getValue(this, g.X[22]);
    }

    public void c(Set<? extends kotlin.i0.z.e.m0.h.e> set) {
        n.f(set, "<set-?>");
        this.e.setValue(this, g.X[3], set);
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean c0() {
        return (Boolean)this.t.getValue(this, g.X[18]).booleanValue();
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public void d(kotlin.i0.z.e.m0.h.k k) {
        n.f(k, "<set-?>");
        this.D.setValue(this, g.X[28], k);
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean d0() {
        return (Boolean)this.k.getValue(this, g.X[9]).booleanValue();
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public void e(boolean z) {
        this.c.setValue(this, g.X[1], Boolean.valueOf(z));
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public kotlin.i0.z.e.m0.h.c.l e0() {
        return (c.l)this.B.getValue(this, g.X[26]);
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean f() {
        return (Boolean)this.m.getValue(this, g.X[11]).booleanValue();
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean f0() {
        return (Boolean)this.j.getValue(this, g.X[8]).booleanValue();
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public void g(kotlin.i0.z.e.m0.h.b b) {
        n.f(b, "<set-?>");
        this.b.setValue(this, g.X[0], b);
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean g0() {
        return (Boolean)this.c.getValue(this, g.X[1]).booleanValue();
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public void h(boolean z) {
        this.w.setValue(this, g.X[21], Boolean.valueOf(z));
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean h0() {
        return (Boolean)this.d.getValue(this, g.X[2]).booleanValue();
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public void i(boolean z) {
        this.h.setValue(this, g.X[6], Boolean.valueOf(z));
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean i0() {
        return (Boolean)this.l.getValue(this, g.X[10]).booleanValue();
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public void j(boolean z) {
        this.F.setValue(this, g.X[30], Boolean.valueOf(z));
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean j0() {
        return (Boolean)this.w.getValue(this, g.X[21]).booleanValue();
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public void k(boolean z) {
        this.E.setValue(this, g.X[29], Boolean.valueOf(z));
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean k0() {
        return (Boolean)this.v.getValue(this, g.X[20]).booleanValue();
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public void l(kotlin.i0.z.e.m0.h.m m) {
        n.f(m, "<set-?>");
        this.C.setValue(this, g.X[27], m);
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public final boolean l0() {
        return this.a;
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public void m(kotlin.i0.z.e.m0.h.a a) {
        n.f(a, "<set-?>");
        this.M.setValue(this, g.X[37], a);
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public final void m0() {
        this.a = true;
    }

    public Set<b> n() {
        return (Set)this.K.getValue(this, g.X[35]);
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean o() {
        return (Boolean)this.h.getValue(this, g.X[6]).booleanValue();
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public kotlin.i0.z.e.m0.h.a p() {
        return (a)this.M.getValue(this, g.X[37]);
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public void q(boolean z) {
        this.v.setValue(this, g.X[20], Boolean.valueOf(z));
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public final kotlin.i0.z.e.m0.h.g r() {
        int i2;
        Field field;
        int i;
        x xVar;
        kotlin.i0.d dVar;
        String str2;
        String name;
        String str;
        final Class<kotlin.i0.z.e.m0.h.g> obj = g.class;
        g gVar = new g();
        final Field[] declaredFields = obj.getDeclaredFields();
        n.e(declaredFields, "this::class.java.declaredFields");
        final int i3 = 0;
        i2 = i3;
        while (i2 < declaredFields.length) {
            field = declaredFields[i2];
            i2++;
            if (modifiers &= 8 != 0) {
            } else {
            }
            field.setAccessible(true);
            dVar = 0;
            if (i instanceof b) {
            } else {
            }
            i = dVar;
            if (i == 0) {
            } else {
            }
            String name2 = field.getName();
            String str4 = "field.name";
            n.e(name2, str4);
            l.M(name2, "is", i3, 2, dVar);
            String name3 = field.getName();
            n.e(name3, str4);
            xVar = new x(c0.b(obj), field.getName(), n.o("get", l.r(name3)));
            field.set(gVar, gVar.n0(i.getValue(this, xVar)));
        }
        return gVar;
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean s() {
        return (Boolean)this.s.getValue(this, g.X[17]).booleanValue();
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean t() {
        return (Boolean)this.N.getValue(this, g.X[38]).booleanValue();
    }

    public l<c, Boolean> u() {
        return (l)this.L.getValue(this, g.X[36]);
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean v() {
        return (Boolean)this.V.getValue(this, g.X[46]).booleanValue();
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean w() {
        return (Boolean)this.i.getValue(this, g.X[7]).booleanValue();
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public kotlin.i0.z.e.m0.h.b x() {
        return (b)this.b.getValue(this, g.X[0]);
    }

    public l<c1, String> y() {
        return (l)this.y.getValue(this, g.X[23]);
    }

    @Override // kotlin.i0.z.e.m0.h.f
    public boolean z() {
        return (Boolean)this.I.getValue(this, g.X[33]).booleanValue();
    }
}
