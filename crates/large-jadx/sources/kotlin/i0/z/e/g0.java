package kotlin.i0.z.e;

import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.i;
import kotlin.i0.z.e.m0.b.k;
import kotlin.i0.z.e.m0.b.k.a;
import kotlin.i0.z.e.m0.b.q.a;
import kotlin.i0.z.e.m0.b.q.a.a;
import kotlin.i0.z.e.m0.b.q.c;
import kotlin.i0.z.e.m0.d.a.b0;
import kotlin.i0.z.e.m0.d.a.h0.a;
import kotlin.i0.z.e.m0.d.a.x;
import kotlin.i0.z.e.m0.d.b.t;
import kotlin.i0.z.e.m0.e.a0.a;
import kotlin.i0.z.e.m0.e.a0.b.e.b;
import kotlin.i0.z.e.m0.e.a0.b.h;
import kotlin.i0.z.e.m0.e.z.e;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.c;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.c;
import kotlin.i0.z.e.m0.i.d;
import kotlin.i0.z.e.m0.i.f;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.i.t.d;
import kotlin.i0.z.e.m0.j.b.d0.g;
import kotlin.i0.z.e.m0.j.b.d0.j;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.k;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.b.b;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.b.j;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.b.m;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.b.p;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.b.s;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.p;
import kotlin.reflect.jvm.internal.impl.descriptors.x;

/* loaded from: classes3.dex */
public final class g0 {

    private static final a a;
    public static final kotlin.i0.z.e.g0 b;
    static {
        g0 g0Var = new g0();
        g0.b = g0Var;
        b bVar = new b("java.lang.Void");
        a aVar = a.m(bVar);
        n.e(aVar, "ClassId.topLevel(FqName(\"java.lang.Void\"))");
        g0.a = aVar;
    }

    private final i a(Class<?> class) {
        String primitive;
        i obj2;
        if (class.isPrimitive()) {
            obj2 = d.get(class.getSimpleName());
            n.e(obj2, "JvmPrimitiveType.get(simpleName)");
            obj2 = obj2.getPrimitiveType();
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    private final boolean b(x x) {
        boolean z;
        x obj4;
        final int i = 1;
        if (!c.m(x)) {
            if (c.n(x)) {
            } else {
                if (n.b(x.getName(), a.e.a()) && x.h().isEmpty()) {
                    if (x.h().isEmpty()) {
                        return i;
                    }
                }
            }
            return 0;
        }
        return i;
    }

    private final kotlin.i0.z.e.d.e d(x x) {
        final int i = 0;
        e.b bVar = new e.b(e(x), t.c(x, i, i, 1, 0));
        d.e eVar = new d.e(bVar);
        return eVar;
    }

    private final String e(b b) {
        String str;
        String str2;
        Object obj3;
        if (b0.b(b) != null) {
        } else {
            str2 = "descriptor.propertyIfAccessor.name.asString()";
            if (b instanceof p0) {
                obj3 = a.o(b).getName().c();
                n.e(obj3, str2);
                str = x.a(obj3);
            } else {
                if (b instanceof q0) {
                    obj3 = a.o(b).getName().c();
                    n.e(obj3, str2);
                    str = x.d(obj3);
                } else {
                    n.e(b.getName().c(), "descriptor.name.asString()");
                }
            }
        }
        return str;
    }

    public final a c(Class<?> class) {
        boolean z;
        b bVar;
        String str;
        n.f(class, "klass");
        Class obj4 = class.getComponentType();
        n.e(obj4, "klass.componentType");
        obj4 = a(obj4);
        if (class.isArray() && obj4 != null) {
            obj4 = class.getComponentType();
            n.e(obj4, "klass.componentType");
            obj4 = a(obj4);
            if (obj4 != null) {
                a aVar = new a(k.l, obj4.getArrayTypeName());
                return aVar;
            }
            obj4 = a.m(k.a.h.l());
            n.e(obj4, "ClassId.topLevel(Standar…s.FqNames.array.toSafe())");
            return obj4;
        }
        if (n.b(class, Void.TYPE)) {
            return g0.a;
        }
        i iVar = a(class);
        if (iVar != null) {
            obj4 = new a(k.l, iVar.getTypeName());
            return obj4;
        }
        obj4 = b.b(class);
        bVar = obj4.b();
        n.e(bVar, "classId.asSingleFqName()");
        z = c.a.n(bVar);
        if (!obj4.k() && z != null) {
            bVar = obj4.b();
            n.e(bVar, "classId.asSingleFqName()");
            z = c.a.n(bVar);
            if (z != null) {
                return z;
            }
        }
        return obj4;
    }

    public final kotlin.i0.z.e.e f(o0 o0) {
        kotlin.i0.z.e.e aVar;
        int i;
        Object o0Var;
        int source;
        kotlin.i0.z.e.e.b bVar;
        kotlin.i0.z.e.m0.e.n nVar;
        boolean z;
        String str;
        kotlin.reflect.jvm.internal.impl.descriptors.u0 obj8;
        n.f(o0, "possiblyOverriddenProperty");
        obj8 = d.L(o0);
        n.e(obj8, "DescriptorUtils.unwrapFa…ssiblyOverriddenProperty)");
        o0Var = (o0)obj8.a();
        n.e(o0Var, "DescriptorUtils.unwrapFa…rriddenProperty).original");
        i = 0;
        if (o0Var instanceof j) {
            obj8 = o0Var;
            nVar = (j)obj8.a1();
            kotlin.reflect.jvm.internal.impl.protobuf.h.f fVar = a.d;
            n.e(fVar, "JvmProtoBuf.propertySignature");
            z = e.a(nVar, fVar);
            if ((a.d)z != null) {
                super(o0Var, nVar, (a.d)z, obj8.Z(), obj8.S());
                return cVar3;
            }
        } else {
            if (o0Var instanceof g && !obj8 instanceof a) {
                if (!obj8 instanceof a) {
                    obj8 = i;
                }
                if ((a)obj8 != null) {
                    obj8 = (a)obj8.b();
                } else {
                    obj8 = i;
                }
                if (obj8 instanceof p) {
                    aVar = new e.a((p)obj8.V());
                    return aVar;
                } else {
                    if (!obj8 instanceof s) {
                    } else {
                        kotlin.reflect.jvm.internal.impl.descriptors.q0 setter = o0Var.getSetter();
                        if (setter != null) {
                            source = setter.getSource();
                        } else {
                            source = i;
                        }
                        if (!source instanceof a) {
                            source = i;
                        }
                        if ((a)source != 0) {
                            o0Var = (a)source.b();
                        } else {
                            o0Var = i;
                        }
                        if (!o0Var instanceof s) {
                            o0Var = i;
                        }
                        if ((s)o0Var != null) {
                            i = (s)o0Var.V();
                        }
                        bVar = new e.b((s)obj8.V(), i);
                        aVar = bVar;
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Incorrect resolution sequence for Java field ");
                stringBuilder.append(o0Var);
                stringBuilder.append(" (source = ");
                stringBuilder.append(obj8);
                stringBuilder.append(')');
                a0 a0Var = new a0(stringBuilder.toString());
                throw a0Var;
            }
        }
        obj8 = o0Var.getGetter();
        n.d(obj8);
        kotlin.reflect.jvm.internal.impl.descriptors.q0 setter2 = o0Var.getSetter();
        if (setter2 != null) {
            i = d(setter2);
        }
        e.d dVar = new e.d(d(obj8), i);
        return dVar;
    }

    public final kotlin.i0.z.e.d g(x x) {
        Object aVar;
        int i;
        Object xVar;
        boolean bVar;
        boolean hVar;
        boolean z;
        kotlin.reflect.jvm.internal.impl.protobuf.o oVar;
        kotlin.i0.z.e.m0.e.z.c cVar;
        kotlin.i0.z.e.m0.e.z.g gVar;
        kotlin.reflect.jvm.internal.impl.descriptors.u0 obj8;
        n.f(x, "possiblySubstitutedFunction");
        b bVar2 = d.L(x);
        n.e(bVar2, "DescriptorUtils.unwrapFa…siblySubstitutedFunction)");
        x xVar2 = (x)bVar2.a();
        n.e(xVar2, "DescriptorUtils.unwrapFa…titutedFunction).original");
        xVar = xVar2;
        kotlin.reflect.jvm.internal.impl.protobuf.o oVar2 = (b)xVar.B();
        bVar = h.a.e((i)oVar2, xVar.Z(), xVar.S());
        if (xVar2 instanceof b && oVar2 instanceof i && bVar != null) {
            xVar = xVar2;
            oVar2 = (b)xVar.B();
            if (oVar2 instanceof i) {
                bVar = h.a.e((i)oVar2, xVar.Z(), xVar.S());
                if (bVar != null) {
                    obj8 = new d.e(bVar);
                    return obj8;
                }
            }
            xVar = h.a.b((d)oVar2, xVar.Z(), xVar.S());
            if (oVar2 instanceof d && xVar != null) {
                xVar = h.a.b((d)oVar2, xVar.Z(), xVar.S());
                if (xVar != null) {
                    obj8 = x.b();
                    n.e(obj8, "possiblySubstitutedFunction.containingDeclaration");
                    if (f.b(obj8)) {
                        obj8 = new d.e(xVar);
                    } else {
                        obj8 = new d.d(xVar);
                    }
                    return obj8;
                }
            }
            return d(xVar2);
        }
        i = 0;
        if (xVar2 instanceof f && !obj8 instanceof a) {
            if (!obj8 instanceof a) {
                obj8 = i;
            }
            if ((a)obj8 != null) {
                obj8 = (a)obj8.b();
            } else {
                obj8 = i;
            }
            if (!obj8 instanceof s) {
            } else {
                i = obj8;
            }
            if ((s)i == 0) {
            } else {
                obj8 = (s)i.V();
                if (obj8 == null) {
                } else {
                    d.c cVar2 = new d.c(obj8);
                    return cVar2;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Incorrect resolution sequence for Java method ");
            stringBuilder.append(xVar2);
            obj8 = new a0(stringBuilder.toString());
            throw obj8;
        }
        int i2 = 41;
        String str6 = " (";
        if (xVar2 instanceof c && !obj8 instanceof a) {
            if (!obj8 instanceof a) {
                obj8 = i;
            }
            if ((a)obj8 != null) {
                i = (a)obj8.b();
            }
            if (i instanceof m) {
                obj8 = new d.b((m)i.V());
                return obj8;
            } else {
                if (!i instanceof j) {
                } else {
                    obj8 = i;
                    if (!(j)obj8.s()) {
                    } else {
                        aVar = new d.a(obj8.U());
                        obj8 = aVar;
                    }
                }
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Incorrect resolution sequence for Java constructor ");
            stringBuilder3.append(xVar2);
            stringBuilder3.append(str6);
            stringBuilder3.append(i);
            stringBuilder3.append(i2);
            obj8 = new a0(stringBuilder3.toString());
            throw obj8;
        }
        if (!b(xVar2)) {
        } else {
            return d(xVar2);
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Unknown origin of ");
        stringBuilder2.append(xVar2);
        stringBuilder2.append(str6);
        stringBuilder2.append(xVar2.getClass());
        stringBuilder2.append(i2);
        obj8 = new a0(stringBuilder2.toString());
        throw obj8;
    }
}
