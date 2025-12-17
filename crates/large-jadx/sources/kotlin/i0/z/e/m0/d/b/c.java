package kotlin.i0.z.e.m0.d.b;

import java.util.List;
import kotlin.d0.c.q;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.g;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.b.l;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.f.g;
import kotlin.i0.z.e.m0.i.f;
import kotlin.i0.z.e.m0.l.a0;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.c1;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.i0.z.e.m0.l.j1.p;
import kotlin.i0.z.e.m0.l.m1.a;
import kotlin.i0.z.e.m0.l.t;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.m0.l.u;
import kotlin.i0.z.e.m0.l.v0;
import kotlin.k0.l;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.utils.d;
import kotlin.w;

/* loaded from: classes3.dex */
public final class c {
    public static final String a(e e, kotlin.i0.z.e.m0.d.b.w<?> w2) {
        String string;
        kotlin.reflect.jvm.internal.impl.descriptors.m mVar;
        boolean str;
        int i;
        int i4;
        int i2;
        int i5;
        int i3;
        String obj8;
        boolean obj9;
        n.f(e, "klass");
        n.f(w2, "typeMappingConfiguration");
        String str4 = w2.b(e);
        kotlin.reflect.jvm.internal.impl.descriptors.m mVar2 = e.b();
        n.e(mVar2, "klass.containingDeclaration");
        string = g.c(e.getName()).f();
        n.e(string, "safeIdentifier(klass.name).identifier");
        if (str4 == null && mVar2 instanceof f0) {
            mVar2 = e.b();
            n.e(mVar2, "klass.containingDeclaration");
            string = g.c(e.getName()).f();
            n.e(string, "safeIdentifier(klass.name).identifier");
            if (mVar2 instanceof f0) {
                obj8 = (f0)mVar2.d();
                if (obj8.d()) {
                } else {
                    obj9 = new StringBuilder();
                    str = obj8.b();
                    n.e(str, "fqName.asString()");
                    obj9.append(l.F(str, '.', '/', false, 4, 0));
                    obj9.append('/');
                    obj9.append(string);
                    string = obj9.toString();
                }
                return string;
            }
            if (mVar2 instanceof e) {
                mVar = mVar2;
            } else {
                mVar = 0;
            }
            if (mVar == null) {
            } else {
                if (w2.d(mVar) == null) {
                    obj8 = c.a(mVar, w2);
                }
                obj9 = new StringBuilder();
                obj9.append(obj8);
                obj9.append('$');
                obj9.append(string);
                return obj9.toString();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected container: ");
            stringBuilder.append(mVar2);
            stringBuilder.append(" for ");
            stringBuilder.append(e);
            obj9 = new IllegalArgumentException(stringBuilder.toString());
            throw obj9;
        }
        return str4;
    }

    public static String b(e e, kotlin.i0.z.e.m0.d.b.w w2, int i3, Object object4) {
        kotlin.i0.z.e.m0.d.b.x obj1;
        if (i3 &= 2 != 0) {
            obj1 = x.a;
        }
        return c.a(e, obj1);
    }

    public static final boolean c(a a) {
        boolean z;
        int i;
        boolean obj2;
        n.f(a, "descriptor");
        if (a instanceof l) {
            return 1;
        }
        b0 returnType = a.getReturnType();
        n.d(returnType);
        b0 returnType2 = a.getReturnType();
        n.d(returnType2);
        if (h.J0(returnType) && !c1.l(returnType2) && !a instanceof p0) {
            returnType2 = a.getReturnType();
            n.d(returnType2);
            if (!c1.l(returnType2)) {
                if (!a instanceof p0) {
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public static final <T> T d(b0 b0, kotlin.i0.z.e.m0.d.b.k<T> k2, kotlin.i0.z.e.m0.d.b.y y3, kotlin.i0.z.e.m0.d.b.w<? extends T> w4, kotlin.i0.z.e.m0.d.b.h<T> h5, q<? super b0, ? super T, ? super kotlin.i0.z.e.m0.d.b.y, w> q6) {
        Object str;
        boolean z;
        Object str2;
        kotlin.reflect.jvm.internal.impl.descriptors.m hVar2;
        boolean z2;
        boolean z3;
        Object obj2;
        kotlin.i0.z.e.m0.d.b.y yVar;
        Object obj3;
        kotlin.i0.z.e.m0.d.b.h hVar;
        Object obj;
        b0 obj10;
        Object obj11;
        Object obj13;
        boolean obj14;
        n.f(b0, "kotlinType");
        n.f(k2, "factory");
        n.f(y3, "mode");
        n.f(w4, "typeMappingConfiguration");
        n.f(q6, "writeGenericType");
        b0 b0Var2 = w4.e(b0);
        if (b0Var2 == null && g.o(b0)) {
            if (g.o(b0)) {
                return c.d(l.b(b0, w4.f()), k2, y3, w4, h5, q6);
            }
            str2 = p.a;
            Object obj4 = z.b(str2, b0, k2, y3);
            t0 t0Var = b0.L0();
            if (obj4 == null && t0Var instanceof a0 && (a0)t0Var.h() == null) {
                t0Var = b0.L0();
                if (t0Var instanceof a0) {
                    if ((a0)t0Var.h() == null) {
                        obj10 = w4.c(t0Var.a());
                    }
                    return c.d(a.m(obj10), k2, y3, w4, h5, q6);
                }
                hVar2 = t0Var.c();
                if (hVar2 == null) {
                } else {
                    int i3 = 0;
                    if (t.r(hVar2)) {
                        obj11 = k2.c("error/NonExistentClass");
                        w4.g(b0, (e)hVar2);
                        if (h5 != null) {
                        } else {
                            return obj11;
                        }
                        h5.c(obj11);
                        throw i3;
                    }
                    boolean z9 = hVar2 instanceof e;
                    if (z9 && h.b0(b0)) {
                        if (h.b0(b0)) {
                            int i2 = 1;
                            if (b0.K0().size() != i2) {
                            } else {
                                obj10 = b0.K0().get(0);
                                b0 type = (v0)obj10.getType();
                                n.e(type, "memberProjection.type");
                                if (obj10.a() == h1.IN_VARIANCE) {
                                    obj10 = k2.c("java/lang/Object");
                                    if (h5 != null) {
                                    } else {
                                        return k2.b(n.o("[", k2.a(obj10)));
                                    }
                                    h5.b();
                                    throw i3;
                                }
                                if (h5 != null) {
                                } else {
                                    obj10 = obj10.a();
                                    n.e(obj10, "memberProjection.projectionKind");
                                    obj10 = c.d(type, k2, y3.f(obj10, i2), w4, h5, q6);
                                    if (h5 != null) {
                                    } else {
                                    }
                                    h5.a();
                                    throw i3;
                                }
                                h5.b();
                                throw i3;
                            }
                            obj10 = new UnsupportedOperationException("arrays must have one type argument");
                            throw obj10;
                        }
                    }
                    z2 = str2;
                    if (z9 && f.b(hVar2) && !y3.c() && (b0)z2 != null) {
                        if (f.b(hVar2)) {
                            if (!y3.c()) {
                                z2 = str2;
                                if ((b0)(b0)z2 != null) {
                                    return c.d((b0)(b0)z2, k2, y3.g(), w4, h5, q6);
                                }
                            }
                        }
                        if (y3.e() && h.q0((e)hVar2)) {
                            if (h.q0((e)hVar2)) {
                                obj11 = k2.e();
                            } else {
                                obj14 = (e)hVar2.a();
                                n.e(obj14, "descriptor.original");
                                obj14 = w4.a(obj14);
                                if (obj14 == null) {
                                    if (hVar2.f() == f.ENUM_ENTRY) {
                                        hVar2 = obj14;
                                    }
                                    obj14 = hVar2.a();
                                    n.e(obj14, "enumClassIfEnumEntry.original");
                                    obj11 = k2.c(c.a(obj14, w4));
                                } else {
                                    obj11 = obj14;
                                }
                            }
                        } else {
                        }
                        q6.invoke(b0, obj11, y3);
                        return obj11;
                    }
                    if (hVar2 instanceof z0) {
                        obj10 = c.d(a.f((z0)hVar2), k2, y3, w4, 0, d.b());
                        if (h5 != null) {
                        } else {
                            return obj10;
                        }
                        obj11 = hVar2.getName();
                        n.e(obj11, "descriptor.getName()");
                        h5.d(obj11, obj10);
                        throw i3;
                    }
                    if (!hVar2 instanceof y0) {
                    } else {
                        if (!y3.b()) {
                        } else {
                            return c.d((y0)hVar2.V(), k2, y3, w4, h5, q6);
                        }
                    }
                    obj11 = new UnsupportedOperationException(n.o("Unknown type ", b0));
                    throw obj11;
                }
                obj11 = new UnsupportedOperationException(n.o("no descriptor for type constructor of ", b0));
                throw obj11;
            }
            obj11 = z.a(k2, obj4, y3.d());
            q6.invoke(b0, obj11, y3);
            return obj11;
        }
        return c.d(b0Var2, k2, y3, w4, h5, q6);
    }

    public static Object e(b0 b0, kotlin.i0.z.e.m0.d.b.k k2, kotlin.i0.z.e.m0.d.b.y y3, kotlin.i0.z.e.m0.d.b.w w4, kotlin.i0.z.e.m0.d.b.h h5, q q6, int i7, Object object8) {
        q obj11;
        if (i7 &= 32 != 0) {
            obj11 = d.b();
        }
        return c.d(b0, k2, y3, w4, h5, obj11);
    }
}
