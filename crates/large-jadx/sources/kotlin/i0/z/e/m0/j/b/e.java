package kotlin.i0.z.e.m0.j.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.d0.d.n;
import kotlin.h0.g;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.e.b;
import kotlin.i0.z.e.m0.e.b.b;
import kotlin.i0.z.e.m0.e.b.b.c;
import kotlin.i0.z.e.m0.e.b.b.c.c;
import kotlin.i0.z.e.m0.e.z.b;
import kotlin.i0.z.e.m0.e.z.b.b;
import kotlin.i0.z.e.m0.e.z.c;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.d;
import kotlin.i0.z.e.m0.i.q.a;
import kotlin.i0.z.e.m0.i.q.c;
import kotlin.i0.z.e.m0.i.q.d;
import kotlin.i0.z.e.m0.i.q.e;
import kotlin.i0.z.e.m0.i.q.g;
import kotlin.i0.z.e.m0.i.q.h;
import kotlin.i0.z.e.m0.i.q.i;
import kotlin.i0.z.e.m0.i.q.j;
import kotlin.i0.z.e.m0.i.q.k;
import kotlin.i0.z.e.m0.i.q.k.a;
import kotlin.i0.z.e.m0.i.q.l;
import kotlin.i0.z.e.m0.i.q.m;
import kotlin.i0.z.e.m0.i.q.q;
import kotlin.i0.z.e.m0.i.q.r;
import kotlin.i0.z.e.m0.i.q.u;
import kotlin.i0.z.e.m0.i.q.v;
import kotlin.i0.z.e.m0.i.q.w;
import kotlin.i0.z.e.m0.i.q.x;
import kotlin.i0.z.e.m0.i.q.y;
import kotlin.i0.z.e.m0.i.q.z;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.t;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.c;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.d;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.y.h0;
import kotlin.y.j0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class e {

    private final c0 a;
    private final e0 b;

    public class a {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[b.b.c.c.BYTE.ordinal()] = 1;
            iArr[b.b.c.c.CHAR.ordinal()] = 2;
            iArr[b.b.c.c.SHORT.ordinal()] = 3;
            iArr[b.b.c.c.INT.ordinal()] = 4;
            iArr[b.b.c.c.LONG.ordinal()] = 5;
            iArr[b.b.c.c.FLOAT.ordinal()] = 6;
            iArr[b.b.c.c.DOUBLE.ordinal()] = 7;
            iArr[b.b.c.c.BOOLEAN.ordinal()] = 8;
            iArr[b.b.c.c.STRING.ordinal()] = 9;
            iArr[b.b.c.c.CLASS.ordinal()] = 10;
            iArr[b.b.c.c.ENUM.ordinal()] = 11;
            iArr[b.b.c.c.ANNOTATION.ordinal()] = 12;
            iArr[b.b.c.c.ARRAY.ordinal()] = 13;
            e.a.a = iArr;
        }
    }
    public e(c0 c0, e0 e02) {
        n.f(c0, "module");
        n.f(e02, "notFoundClasses");
        super();
        this.a = c0;
        this.b = e02;
    }

    private final boolean b(g<?> g, b0 b02, b.b.c b$b$c3) {
        int iterator;
        boolean size;
        int i;
        int[] iArr;
        boolean empty;
        int i2;
        Object obj;
        String str;
        Object obj7;
        b0 obj8;
        c0 obj9;
        b.b.c.c cVar = c3.M();
        if (cVar == null) {
            iterator = -1;
        } else {
            iterator = e.a.a[cVar.ordinal()];
        }
        final int i4 = 1;
        if (iterator != 10) {
            if (iterator != 13) {
                i2 = n.b(g.a(this.a), b02);
                return i2;
            } else {
                if (g instanceof b && (List)(b)g.b().size() == c3.D().size()) {
                    i = (List)(b)g.b().size() == c3.D().size() ? i4 : i2;
                } else {
                }
                if (i == 0) {
                } else {
                    obj8 = c().k(b02);
                    n.e(obj8, "builtIns.getArrayElementType(expectedType)");
                    iterator = p.h((Collection)(b)g.b());
                    if (iterator instanceof Collection != null && (Collection)iterator.isEmpty()) {
                        if ((Collection)iterator.isEmpty()) {
                            i2 = i4;
                        } else {
                            iterator = iterator.iterator();
                            while (iterator.hasNext()) {
                                int i3 = (h0)iterator.d();
                                b.b.c cVar2 = c3.B(i3);
                                n.e(cVar2, "value.getArrayElement(i)");
                            }
                        }
                    } else {
                    }
                }
            }
            obj8 = new IllegalStateException(n.o("Deserialized ArrayValue should have the same number of elements as the original array value: ", g).toString());
            throw obj8;
        }
        if (obj7 instanceof e) {
        } else {
            obj7 = 0;
        }
        if (obj7 != null) {
            if (h.q0(obj7)) {
            }
        } else {
        }
    }

    private final h c() {
        return this.a.m();
    }

    private final o<e, g<?>> d(b.b b$b, Map<e, ? extends c1> map2, c c3) {
        Object obj5 = map2.get(v.b(c3, b.q()));
        if ((c1)obj5 == null) {
            return 0;
        }
        obj5 = (c1)obj5.getType();
        n.e(obj5, "parameter.type");
        b.b.c obj4 = b.r();
        n.e(obj4, "proto.value");
        o oVar = new o(v.b(c3, b.q()), g(obj5, obj4, c3));
        return oVar;
    }

    private final e e(a a) {
        return w.c(this.a, a, this.b);
    }

    private final g<?> g(b0 b0, b.b.c b$b$c2, c c3) {
        boolean stringBuilder;
        String str;
        Object obj3;
        Object obj4;
        g obj5;
        if (b(f(b0, c2, c3), b0, c2)) {
        } else {
            obj5 = 0;
        }
        if (obj5 == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected argument value: actual type ");
            stringBuilder.append(c2.M());
            stringBuilder.append(" != expected type ");
            stringBuilder.append(b0);
            obj5 = k.b.a(stringBuilder.toString());
        }
        return obj5;
    }

    public final c a(b b, c c2) {
        Map map;
        int next3;
        boolean next2;
        int next;
        Object linkedHashMap;
        e name;
        Object obj6;
        n.f(b, "proto");
        n.f(c2, "nameResolver");
        e eVar = e(v.a(c2, b.u()));
        map = j0.h();
        Collection collection = eVar.j();
        n.e(collection, "annotationClass.constructors");
        next = p.A0(collection);
        if (b.r() != 0 && !t.r(eVar) && d.t(eVar) && (d)next != null) {
            if (!t.r(eVar)) {
                if (d.t(eVar)) {
                    collection = eVar.j();
                    n.e(collection, "annotationClass.constructors");
                    next = p.A0(collection);
                    if ((d)(d)next != null) {
                        List list = (d)(d)next.h();
                        n.e(list, "constructor.valueParameters");
                        linkedHashMap = new LinkedHashMap(g.b(j0.d(p.r(list, 10)), 16));
                        Iterator iterator = list.iterator();
                        for (Object next3 : iterator) {
                            linkedHashMap.put((c1)next3.getName(), next3);
                        }
                        obj6 = b.s();
                        n.e(obj6, "proto.argumentList");
                        ArrayList arrayList = new ArrayList();
                        obj6 = obj6.iterator();
                        while (obj6.hasNext()) {
                            Object next4 = obj6.next();
                            n.e((b.b)next4, "it");
                            next2 = d(next4, linkedHashMap, c2);
                            if (next2) {
                            }
                            arrayList.add(next2);
                        }
                        map = j0.s(arrayList);
                    }
                }
            }
        }
        obj6 = new d(eVar.q(), map, u0.a);
        return obj6;
    }

    public final g<?> f(b0 b0, b.b.c b$b$c2, c c3) {
        String booleanValue;
        int arrayList;
        int[] next;
        int i;
        kotlin.i0.z.e.m0.l.i0 i0Var;
        String str;
        g obj6;
        c obj7;
        Object obj8;
        n.f(b0, "expectedType");
        n.f(c2, "value");
        n.f(c3, "nameResolver");
        Boolean bool = b.M.g(c2.I());
        n.e(bool, "IS_UNSIGNED.get(value.flags)");
        booleanValue = bool.booleanValue();
        b.b.c.c cVar = c2.M();
        if (cVar == null) {
            arrayList = -1;
        } else {
            arrayList = e.a.a[cVar.ordinal()];
        }
        switch (arrayList) {
            case 1:
                obj6 = (byte)obj6;
                obj7 = new w(obj6);
                obj7 = new d(obj6);
                break;
            case 2:
                obj6 = new e((char)obj7);
                return obj6;
            case 3:
                obj6 = (short)obj6;
                obj7 = new z(obj6);
                obj7 = new u(obj6);
                break;
            case 4:
                obj6 = (int)obj6;
                obj7 = new x(obj6);
                obj7 = new m(obj6);
                break;
            case 5:
                obj6 = c2.K();
                obj8 = new y(obj6, c2);
                obj8 = new r(obj6, c2);
                obj6 = obj8;
                return obj6;
            case 6:
                obj6 = new l(c2.J());
                return obj6;
            case 7:
                obj6 = new i(c2.G(), c3);
                return obj6;
            case 8:
                obj7 = 1;
                obj7 = 0;
                obj6 = new c(obj7);
                return obj6;
            case 9:
                obj6 = new v(c3.getString(c2.L()));
                return obj6;
            case 10:
                obj6 = new q(v.a(c3, c2.E()), c2.A());
                return obj6;
            case 11:
                obj6 = new j(v.a(c3, c2.E()), v.b(c3, c2.H()));
                return obj6;
            case 12:
                obj7 = c2.z();
                n.e(obj7, "value.annotation");
                obj6 = new a(a(obj7, c3));
                return obj6;
            case 13:
                obj7 = c2.D();
                n.e(obj7, "value.arrayElementList");
                arrayList = new ArrayList(p.r(obj7, 10));
                obj7 = obj7.iterator();
                Object next2 = obj7.next();
                i0Var = c().i();
                n.e(i0Var, "builtIns.anyType");
                n.e((b.b.c)next2, "it");
                arrayList.add(f(i0Var, next2, c3));
                obj6 = h.a.b(arrayList, b0);
                return obj6;
            default:
                obj8 = new StringBuilder();
                obj8.append("Unsupported annotation argument type: ");
                obj8.append(c2.M());
                obj8.append(" (expected ");
                obj8.append(b0);
                obj8.append(')');
                obj7 = new IllegalStateException(obj8.toString().toString());
                throw obj7;
        }
        obj6 = obj7;
    }
}
