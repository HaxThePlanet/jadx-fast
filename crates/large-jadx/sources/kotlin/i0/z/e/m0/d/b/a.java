package kotlin.i0.z.e.m0.d.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.a;
import kotlin.i0.z.e.m0.b.o;
import kotlin.i0.z.e.m0.d.b.a0.a;
import kotlin.i0.z.e.m0.e.a0.a;
import kotlin.i0.z.e.m0.e.a0.a.d;
import kotlin.i0.z.e.m0.e.a0.b.b;
import kotlin.i0.z.e.m0.e.a0.b.h;
import kotlin.i0.z.e.m0.e.b;
import kotlin.i0.z.e.m0.e.c.c;
import kotlin.i0.z.e.m0.e.g;
import kotlin.i0.z.e.m0.e.n;
import kotlin.i0.z.e.m0.e.q;
import kotlin.i0.z.e.m0.e.s;
import kotlin.i0.z.e.m0.e.u;
import kotlin.i0.z.e.m0.e.z.a;
import kotlin.i0.z.e.m0.e.z.b;
import kotlin.i0.z.e.m0.e.z.b.b;
import kotlin.i0.z.e.m0.e.z.c;
import kotlin.i0.z.e.m0.e.z.e;
import kotlin.i0.z.e.m0.e.z.f;
import kotlin.i0.z.e.m0.e.z.g;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.t.c;
import kotlin.i0.z.e.m0.j.b.b;
import kotlin.i0.z.e.m0.j.b.c;
import kotlin.i0.z.e.m0.j.b.x;
import kotlin.i0.z.e.m0.j.b.x.a;
import kotlin.i0.z.e.m0.k.g;
import kotlin.i0.z.e.m0.k.n;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.k0.l;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.protobuf.h.d;
import kotlin.reflect.jvm.internal.impl.protobuf.o;
import kotlin.y.p;

/* loaded from: classes3.dex */
public abstract class a<A, C>  implements c<A, C> {

    private final kotlin.i0.z.e.m0.d.b.m a;
    private final g<kotlin.i0.z.e.m0.d.b.o, kotlin.i0.z.e.m0.d.b.a.b<A, C>> b;

    private static enum a {

        PROPERTY,
        BACKING_FIELD,
        DELEGATE_FIELD;
    }

    private static final class b {

        private final Map<kotlin.i0.z.e.m0.d.b.r, List<A>> a;
        private final Map<kotlin.i0.z.e.m0.d.b.r, C> b;
        public b(Map<kotlin.i0.z.e.m0.d.b.r, ? extends List<? extends A>> map, Map<kotlin.i0.z.e.m0.d.b.r, ? extends C> map2) {
            n.f(map, "memberAnnotations");
            n.f(map2, "propertyConstants");
            super();
            this.a = map;
            this.b = map2;
        }

        public final Map<kotlin.i0.z.e.m0.d.b.r, List<A>> a() {
            return this.a;
        }

        public final Map<kotlin.i0.z.e.m0.d.b.r, C> b() {
            return this.b;
        }
    }

    public class c {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[b.PROPERTY_GETTER.ordinal()] = 1;
            iArr[b.PROPERTY_SETTER.ordinal()] = 2;
            iArr[b.PROPERTY.ordinal()] = 3;
            a.c.a = iArr;
        }
    }

    public static final class d implements kotlin.i0.z.e.m0.d.b.o.d {

        final kotlin.i0.z.e.m0.d.b.a<A, C> a;
        final HashMap<kotlin.i0.z.e.m0.d.b.r, List<A>> b;
        final HashMap<kotlin.i0.z.e.m0.d.b.r, C> c;
        d(kotlin.i0.z.e.m0.d.b.a<A, C> a, HashMap<kotlin.i0.z.e.m0.d.b.r, List<A>> hashMap2, HashMap<kotlin.i0.z.e.m0.d.b.r, C> hashMap3) {
            this.a = a;
            this.b = hashMap2;
            this.c = hashMap3;
            super();
        }

        @Override // kotlin.i0.z.e.m0.d.b.o$d
        public kotlin.i0.z.e.m0.d.b.o.c a(e e, String string2, Object object3) {
            Object aVar;
            Object obj4;
            Object obj5;
            n.f(e, "name");
            n.f(string2, "desc");
            String obj3 = e.c();
            n.e(obj3, "name.asString()");
            obj3 = r.b.a(obj3, string2);
            obj4 = this.a.z(string2, object3);
            if (object3 != null && obj4 != null) {
                obj4 = this.a.z(string2, object3);
                if (obj4 != null) {
                    this.c.put(obj3, obj4);
                }
            }
            obj4 = new a.d.b(this, obj3);
            return obj4;
        }

        @Override // kotlin.i0.z.e.m0.d.b.o$d
        public kotlin.i0.z.e.m0.d.b.o.e b(e e, String string2) {
            n.f(e, "name");
            n.f(string2, "desc");
            String obj4 = e.c();
            n.e(obj4, "name.asString()");
            a.d.a aVar = new a.d.a(this, r.b.d(obj4, string2));
            return aVar;
        }
    }

    public static final class e implements kotlin.i0.z.e.m0.d.b.o.c {

        final kotlin.i0.z.e.m0.d.b.a<A, C> a;
        final ArrayList<A> b;
        e(kotlin.i0.z.e.m0.d.b.a<A, C> a, ArrayList<A> arrayList2) {
            this.a = a;
            this.b = arrayList2;
            super();
        }

        @Override // kotlin.i0.z.e.m0.d.b.o$c
        public void a() {
        }

        @Override // kotlin.i0.z.e.m0.d.b.o$c
        public kotlin.i0.z.e.m0.d.b.o.a b(a a, u0 u02) {
            n.f(a, "classId");
            n.f(u02, "source");
            return a.k(this.a, a, u02, this.b);
        }
    }

    static final class f extends p implements l<kotlin.i0.z.e.m0.d.b.o, kotlin.i0.z.e.m0.d.b.a.b<? extends A, ? extends C>> {

        final kotlin.i0.z.e.m0.d.b.a<A, C> this$0;
        f(kotlin.i0.z.e.m0.d.b.a<A, C> a) {
            this.this$0 = a;
            super(1);
        }

        public final kotlin.i0.z.e.m0.d.b.a.b<A, C> a(kotlin.i0.z.e.m0.d.b.o o) {
            n.f(o, "kotlinClass");
            return a.l(this.this$0, o);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((o)object);
        }
    }
    public a(n n, kotlin.i0.z.e.m0.d.b.m m2) {
        n.f(n, "storageManager");
        n.f(m2, "kotlinClassFinder");
        super();
        this.a = m2;
        a.f obj3 = new a.f(this);
        this.b = n.h(obj3);
    }

    private final List<A> A(x x, n n2, kotlin.i0.z.e.m0.d.b.a.a a$a3) {
        int i;
        kotlin.i0.z.e.m0.d.b.a.a aVar = a3;
        Boolean bool = b.z.g(n2.M());
        n.e(bool, "IS_CONST.get(proto.flags)");
        boolean booleanValue = bool.booleanValue();
        h hVar = h.a;
        final boolean z2 = h.f(n2);
        kotlin.i0.z.e.m0.d.b.r rVar = a.u(this, n2, x.b(), x.d(), false, true, false, 40, 0);
        if (aVar == a.a.PROPERTY && rVar == null) {
            rVar = a.u(this, n2, x.b(), x.d(), false, true, false, 40, 0);
            if (rVar == null) {
                return p.g();
            }
            return a.o(this, x, rVar, true, false, Boolean.valueOf(booleanValue), z2, 8, 0);
        }
        kotlin.i0.z.e.m0.d.b.r rVar2 = a.u(this, n2, x.b(), x.d(), true, false, false, 48, 0);
        if (rVar2 == null) {
            return p.g();
        }
        if (aVar == a.a.DELEGATE_FIELD) {
            i = 1;
        }
        if (l.R(rVar2.a(), "$delegate", false, 2, 0) != i) {
            return p.g();
        }
        return this.n(x, rVar2, true, true, Boolean.valueOf(booleanValue), z2);
    }

    private final kotlin.i0.z.e.m0.d.b.o C(x.a x$a) {
        kotlin.i0.z.e.m0.d.b.o i;
        u0 obj3;
        if (obj3 instanceof q) {
        } else {
            obj3 = i;
        }
        if (obj3 == null) {
        } else {
            i = obj3.d();
        }
        return i;
    }

    public static final kotlin.i0.z.e.m0.d.b.o.a k(kotlin.i0.z.e.m0.d.b.a a, a a2, u0 u03, List list4) {
        return a.x(a2, u03, list4);
    }

    public static final kotlin.i0.z.e.m0.d.b.a.b l(kotlin.i0.z.e.m0.d.b.a a, kotlin.i0.z.e.m0.d.b.o o2) {
        return a.y(o2);
    }

    private final int m(x x, o o2) {
        boolean eNUM_CLASS;
        int i;
        boolean obj4;
        Object obj5;
        i = 1;
        if (o2 instanceof i && f.d((i)o2)) {
            if (f.d((i)o2)) {
            } else {
                i = i2;
            }
            return i;
        } else {
        }
        obj4 = new UnsupportedOperationException(n.o("Unsupported message: ", o2.getClass()));
        throw obj4;
    }

    private final List<A> n(x x, kotlin.i0.z.e.m0.d.b.r r2, boolean z3, boolean z4, Boolean boolean5, boolean z6) {
        Object obj7;
        obj7 = p(x, this.v(x, z3, z4, boolean5, z6));
        if (obj7 == null) {
            return p.g();
        }
        if ((List)(a.b)this.b.invoke(obj7).a().get(r2) == null) {
            obj7 = p.g();
        }
        return obj7;
    }

    static List o(kotlin.i0.z.e.m0.d.b.a a, x x2, kotlin.i0.z.e.m0.d.b.r r3, boolean z4, boolean z5, Boolean boolean6, boolean z7, int i8, Object object9) {
        int i4;
        int i3;
        int i2;
        int i5;
        int i;
        if (object9 != null) {
        } else {
            int i10 = 0;
            i3 = i8 & 4 != 0 ? i10 : z4;
            i2 = i8 & 8 != 0 ? i10 : z5;
            i5 = i8 & 16 != 0 ? i4 : boolean6;
            i = i8 & 32 != 0 ? i10 : z7;
            return a.n(x2, r3, i3, i2, i5, i);
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findClassAndLoadMemberAnnotations");
        throw unsupportedOperationException;
    }

    private final kotlin.i0.z.e.m0.d.b.o p(x x, kotlin.i0.z.e.m0.d.b.o o2) {
        kotlin.i0.z.e.m0.d.b.o obj2;
        if (o2 != null) {
        } else {
            if (x instanceof x.a) {
                obj2 = C((x.a)x);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    private final kotlin.i0.z.e.m0.d.b.r r(o o, c c2, g g3, b b4, boolean z5) {
        boolean z;
        kotlin.i0.z.e.m0.d.b.r i4;
        int i2;
        Object str;
        c cVar;
        g gVar;
        int i;
        int i3;
        boolean z2;
        kotlin.i0.z.e.m0.e.a0.b.e.b obj10;
        Object obj12;
        kotlin.i0.z.e.m0.d.b.r.a obj13;
        h obj14;
        i4 = 0;
        if (o instanceof d) {
            obj10 = h.a.b((d)o, c2, g3);
            if (obj10 == null) {
                return i4;
            }
            i4 = r.b.b(obj10);
        } else {
            if (o instanceof i) {
                obj10 = h.a.e((i)o, c2, g3);
                if (obj10 == null) {
                    return i4;
                }
                i4 = r.b.b(obj10);
            } else {
                kotlin.reflect.jvm.internal.impl.protobuf.h.f fVar = a.d;
                n.e(fVar, "propertySignature");
                z = e.a((h.d)o, fVar);
                if (o instanceof n && (a.d)z == null) {
                    fVar = a.d;
                    n.e(fVar, "propertySignature");
                    z = e.a((h.d)o, fVar);
                    if ((a.d)(a.d)z == null) {
                        return i4;
                    }
                    obj13 = a.c.a[b4.ordinal()];
                    if (obj13 != 1) {
                        if (obj13 != 2) {
                            if (obj13 != 3) {
                            } else {
                                i4 = this.t((n)o, c2, g3, true, true, z5);
                            }
                        } else {
                            if ((a.d)(a.d)z.y()) {
                                obj12 = z.u();
                                n.e(obj12, "signature.setter");
                                i4 = r.b.c(c2, obj12);
                            }
                        }
                    } else {
                        if (z.x()) {
                            obj12 = z.t();
                            n.e(obj12, "signature.getter");
                            i4 = r.b.c(c2, obj12);
                        }
                    }
                }
            }
        }
        return i4;
    }

    static kotlin.i0.z.e.m0.d.b.r s(kotlin.i0.z.e.m0.d.b.a a, o o2, c c3, g g4, b b5, boolean z6, int i7, Object object8) {
        int obj11;
        if (object8 != null) {
        } else {
            if (i7 &= 16 != 0) {
                obj11 = 0;
            }
            return a.r(o2, c3, g4, b5, obj11);
        }
        UnsupportedOperationException obj6 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCallableSignature");
        throw obj6;
    }

    private final kotlin.i0.z.e.m0.d.b.r t(n n, c c2, g g3, boolean z4, boolean z5, boolean z6) {
        h.d obj3;
        kotlin.reflect.jvm.internal.impl.protobuf.h.f fVar = a.d;
        n.e(fVar, "propertySignature");
        Object obj = e.a(n, fVar);
        int i = 0;
        if ((a.d)obj == null) {
            return i;
        }
        obj3 = h.a.c(n, c2, g3, z6);
        if (z4 && obj3 == null) {
            obj3 = h.a.c(n, c2, g3, z6);
            if (obj3 == null) {
                return i;
            }
            return r.b.b(obj3);
        }
        if (z5 && (a.d)obj.z()) {
            if (obj.z()) {
                final kotlin.i0.z.e.m0.e.a0.a.c obj5 = obj.v();
                n.e(obj5, "signature.syntheticMethod");
                return r.b.c(c2, obj5);
            }
        }
        return i;
    }

    static kotlin.i0.z.e.m0.d.b.r u(kotlin.i0.z.e.m0.d.b.a a, n n2, c c3, g g4, boolean z5, boolean z6, boolean z7, int i8, Object object9) {
        int i3;
        int i4;
        int i;
        int i2;
        if (object9 != null) {
        } else {
            int i7 = 0;
            i4 = i8 & 8 != 0 ? i7 : z5;
            i = i8 & 16 != 0 ? i7 : z6;
            i2 = i8 & 32 != 0 ? i3 : z7;
            return a.t(n2, c3, g4, i4, i, i2);
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPropertySignature");
        throw unsupportedOperationException;
    }

    private final kotlin.i0.z.e.m0.d.b.o v(x x, boolean z2, boolean z3, Boolean boolean4, boolean z5) {
        c.c cVar;
        c.c iNTERFACE;
        Object obj7;
        boolean obj8;
        c.c obj9;
        boolean obj10;
        int i = 0;
        if (z2) {
            if (!boolean4) {
            } else {
                obj8 = x;
                if (x instanceof x.a && (x.a)obj8.g() == c.c.INTERFACE) {
                    obj8 = x;
                    if ((x.a)obj8.g() == c.c.INTERFACE) {
                        obj8 = obj8.e().d(e.j("DefaultImpls"));
                        n.e(obj8, "container.classId.createNestedClassId(Name.identifier(JvmAbi.DEFAULT_IMPLS_CLASS_NAME))");
                        return n.b(this.a, obj8);
                    }
                }
                if (boolean4.booleanValue() && x instanceof x.b) {
                    if (x instanceof x.b) {
                        if (obj8 instanceof i) {
                        } else {
                            obj8 = i;
                        }
                        if (obj8 == null) {
                            obj8 = i;
                        } else {
                            obj8 = obj8.e();
                        }
                        if (obj8 != null) {
                            String str = obj8.f();
                            n.e(str, "facadeClassName.internalName");
                            obj9 = new b(l.F(str, '/', '.', false, 4, 0));
                            obj8 = a.m(obj9);
                            n.e(obj8, "topLevel(FqName(facadeClassName.internalName.replace('/', '.')))");
                            return n.b(this.a, obj8);
                        }
                    }
                }
            }
            obj8 = new StringBuilder();
            obj8.append("isConst should not be null for property (container=");
            obj8.append(x);
            obj8.append(')');
            obj8 = new IllegalStateException(obj8.toString().toString());
            throw obj8;
        }
        obj8 = x;
        obj8 = obj8.h();
        if (z3 != null && x instanceof x.a && (x.a)obj8.g() == c.c.COMPANION_OBJECT && obj8 != null && obj8.g() != c.c.CLASS && obj8.g() != c.c.ENUM_CLASS && z5 && obj8.g() != c.c.INTERFACE && obj8.g() == c.c.ANNOTATION_CLASS) {
            if (x instanceof x.a) {
                obj8 = x;
                if ((x.a)obj8.g() == c.c.COMPANION_OBJECT) {
                    obj8 = obj8.h();
                    if (obj8 != null) {
                        if (obj8.g() != c.c.CLASS) {
                            if (obj8.g() != c.c.ENUM_CLASS) {
                                if (z5) {
                                    if (obj8.g() != c.c.INTERFACE) {
                                        if (obj8.g() == c.c.ANNOTATION_CLASS) {
                                        }
                                    }
                                }
                            }
                        }
                        return C(obj8);
                    }
                }
            }
        }
        obj7 = x.c();
        Objects.requireNonNull(obj7, "null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
        if (x instanceof x.b && obj8 instanceof i && (i)obj7.f() == null) {
            if (obj8 instanceof i) {
                obj7 = x.c();
                Objects.requireNonNull(obj7, "null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
                if ((i)obj7.f() == null) {
                    obj8 = n.b(this.a, obj7.d());
                }
                return obj8;
            }
        }
        return i;
    }

    private final kotlin.i0.z.e.m0.d.b.o.a x(a a, u0 u02, List<A> list3) {
        if (a.a.a().contains(a)) {
            return null;
        }
        return w(a, u02, list3);
    }

    private final kotlin.i0.z.e.m0.d.b.a.b<A, C> y(kotlin.i0.z.e.m0.d.b.o o) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        a.d dVar = new a.d(this, hashMap, hashMap2);
        o.c(dVar, q(o));
        a.b obj5 = new a.b(hashMap, hashMap2);
        return obj5;
    }

    protected abstract A B(b b, c c2);

    protected abstract C D(C c);

    public List<A> a(s s, c c2) {
        int i;
        String str;
        n.f(s, "proto");
        n.f(c2, "nameResolver");
        Object obj4 = s.o(a.h);
        n.e(obj4, "proto.getExtension(JvmProtoBuf.typeParameterAnnotation)");
        ArrayList arrayList = new ArrayList(p.r((Iterable)obj4, 10));
        obj4 = obj4.iterator();
        for (b next2 : obj4) {
            n.e(next2, "it");
            arrayList.add(B(next2, c2));
        }
        return arrayList;
    }

    public List<A> b(x x, o o2, b b3, int i4, u u5) {
        n.f(x, "container");
        n.f(o2, "callableProto");
        n.f(b3, "kind");
        n.f(u5, "proto");
        final kotlin.i0.z.e.m0.d.b.r obj12 = a.s(this, o2, x.b(), x.d(), b3, false, 16, 0);
        if (obj12 != null) {
            return a.o(this, x, r.b.e(obj12, i4 += obj11), false, false, 0, false, 60, 0);
        }
        return p.g();
    }

    public List<A> c(x.a x$a) {
        n.f(a, "container");
        kotlin.i0.z.e.m0.d.b.o oVar = C(a);
        if (oVar == null) {
        } else {
            ArrayList obj4 = new ArrayList(1);
            a.e eVar = new a.e(this, obj4);
            oVar.b(eVar, q(oVar));
            return obj4;
        }
        IllegalStateException illegalStateException = new IllegalStateException(n.o("Class for loading annotations is not found: ", a.a()).toString());
        throw illegalStateException;
    }

    public List<A> d(q q, c c2) {
        int i;
        String str;
        n.f(q, "proto");
        n.f(c2, "nameResolver");
        Object obj4 = q.o(a.f);
        n.e(obj4, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
        ArrayList arrayList = new ArrayList(p.r((Iterable)obj4, 10));
        obj4 = obj4.iterator();
        for (b next2 : obj4) {
            n.e(next2, "it");
            arrayList.add(B(next2, c2));
        }
        return arrayList;
    }

    public C e(x x, n n2, b0 b03) {
        Object obj11;
        n.f(x, "container");
        n.f(n2, "proto");
        n.f(b03, "expectedType");
        h hVar = h.a;
        kotlin.i0.z.e.m0.d.b.o oVar2 = p(x, this.v(x, true, true, b.z.g(n2.M()), h.f(n2)));
        int i2 = 0;
        if (oVar2 == null) {
            return i2;
        }
        obj11 = this.r(n2, x.b(), x.d(), b.PROPERTY, oVar2.a().d().d(e.b.a()));
        if (obj11 == null) {
            return i2;
        }
        obj11 = (a.b)this.b.invoke(oVar2).b().get(obj11);
        if (obj11 == null) {
            return i2;
        }
        o obj12 = o.a;
        if (o.d(b03)) {
            obj11 = D(obj11);
        }
        return obj11;
    }

    public List<A> f(x x, g g2) {
        n.f(x, "container");
        n.f(g2, "proto");
        b bVar = b.a;
        String str3 = (x.a)x.e().c();
        n.e(str3, "container as ProtoContainer.Class).classId.asString()");
        return a.o(this, x, r.b.a(x.b().getString(g2.z()), b.b(str3)), false, false, 0, false, 60, 0);
    }

    public List<A> g(x x, n n2) {
        n.f(x, "container");
        n.f(n2, "proto");
        return A(x, n2, a.a.BACKING_FIELD);
    }

    public List<A> h(x x, o o2, b b3) {
        n.f(x, "container");
        n.f(o2, "proto");
        n.f(b3, "kind");
        final kotlin.i0.z.e.m0.d.b.r obj12 = a.s(this, o2, x.b(), x.d(), b3, false, 16, 0);
        if (obj12 != null) {
            return a.o(this, x, r.b.e(obj12, 0), false, false, 0, false, 60, 0);
        }
        return p.g();
    }

    public List<A> i(x x, n n2) {
        n.f(x, "container");
        n.f(n2, "proto");
        return A(x, n2, a.a.DELEGATE_FIELD);
    }

    public List<A> j(x x, o o2, b b3) {
        n.f(x, "container");
        n.f(o2, "proto");
        n.f(b3, "kind");
        if (b3 == b.PROPERTY) {
            return A(x, (n)o2, a.a.PROPERTY);
        }
        kotlin.i0.z.e.m0.d.b.r rVar = a.s(this, o2, x.b(), x.d(), b3, false, 16, 0);
        if (rVar == null) {
            return p.g();
        }
        return a.o(this, x, rVar, false, false, 0, false, 60, 0);
    }

    @Override // kotlin.i0.z.e.m0.j.b.c
    protected byte[] q(kotlin.i0.z.e.m0.d.b.o o) {
        n.f(o, "kotlinClass");
        return null;
    }

    protected abstract kotlin.i0.z.e.m0.d.b.o.a w(a a, u0 u02, List<A> list3);

    protected abstract C z(String string, Object object2);
}
