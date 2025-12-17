package kotlin.i0.z.e.m0.j.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.e.g;
import kotlin.i0.z.e.m0.e.n;
import kotlin.i0.z.e.m0.e.q;
import kotlin.i0.z.e.m0.e.s;
import kotlin.i0.z.e.m0.e.u;
import kotlin.i0.z.e.m0.e.z.c;
import kotlin.i0.z.e.m0.e.z.e;
import kotlin.i0.z.e.m0.i.q.g;
import kotlin.i0.z.e.m0.j.a;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.c;
import kotlin.reflect.jvm.internal.impl.protobuf.h.d;
import kotlin.reflect.jvm.internal.impl.protobuf.o;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class d implements kotlin.i0.z.e.m0.j.b.c<c, g<?>> {

    private final a a;
    private final kotlin.i0.z.e.m0.j.b.e b;

    public class a {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[b.PROPERTY.ordinal()] = 1;
            iArr[b.PROPERTY_GETTER.ordinal()] = 2;
            iArr[b.PROPERTY_SETTER.ordinal()] = 3;
            d.a.a = iArr;
        }
    }
    public d(c0 c0, e0 e02, a a3) {
        n.f(c0, "module");
        n.f(e02, "notFoundClasses");
        n.f(a3, "protocol");
        super();
        this.a = a3;
        e obj4 = new e(c0, e02);
        this.b = obj4;
    }

    public List<c> a(s s, c c2) {
        int i;
        kotlin.i0.z.e.m0.j.b.e eVar;
        Object obj4;
        n.f(s, "proto");
        n.f(c2, "nameResolver");
        if ((List)s.o(this.a.l()) != null) {
        } else {
            obj4 = p.g();
        }
        ArrayList arrayList = new ArrayList(p.r(obj4, 10));
        obj4 = obj4.iterator();
        for (b next2 : obj4) {
            arrayList.add(this.b.a(next2, c2));
        }
        return arrayList;
    }

    public List<c> b(kotlin.i0.z.e.m0.j.b.x x, o o2, kotlin.i0.z.e.m0.j.b.b b3, int i4, u u5) {
        c cVar;
        Object obj3;
        int obj5;
        Object obj6;
        n.f(x, "container");
        n.f(o2, "callableProto");
        n.f(b3, "kind");
        n.f(u5, "proto");
        if ((List)u5.o(this.a.g()) != null) {
        } else {
            obj3 = p.g();
        }
        ArrayList obj4 = new ArrayList(p.r(obj3, 10));
        obj3 = obj3.iterator();
        for (b obj5 : obj3) {
            obj4.add(this.b.a(obj5, x.b()));
        }
        return obj4;
    }

    public List<c> c(kotlin.i0.z.e.m0.j.b.x.a x$a) {
        Object obj;
        int i;
        kotlin.i0.z.e.m0.j.b.e eVar;
        c cVar;
        n.f(a, "container");
        if ((List)a.f().o(this.a.a()) != null) {
        } else {
            obj = p.g();
        }
        ArrayList arrayList = new ArrayList(p.r(obj, 10));
        Iterator iterator = obj.iterator();
        for (b next2 : iterator) {
            arrayList.add(this.b.a(next2, a.b()));
        }
        return arrayList;
    }

    public List<c> d(q q, c c2) {
        int i;
        kotlin.i0.z.e.m0.j.b.e eVar;
        Object obj4;
        n.f(q, "proto");
        n.f(c2, "nameResolver");
        if ((List)q.o(this.a.k()) != null) {
        } else {
            obj4 = p.g();
        }
        ArrayList arrayList = new ArrayList(p.r(obj4, 10));
        obj4 = obj4.iterator();
        for (b next2 : obj4) {
            arrayList.add(this.b.a(next2, c2));
        }
        return arrayList;
    }

    @Override // kotlin.i0.z.e.m0.j.b.c
    public Object e(kotlin.i0.z.e.m0.j.b.x x, n n2, b0 b03) {
        return k(x, n2, b03);
    }

    public List<c> f(kotlin.i0.z.e.m0.j.b.x x, g g2) {
        int i;
        kotlin.i0.z.e.m0.j.b.e eVar;
        c cVar;
        Object obj6;
        n.f(x, "container");
        n.f(g2, "proto");
        if ((List)g2.o(this.a.d()) != null) {
        } else {
            obj6 = p.g();
        }
        ArrayList arrayList = new ArrayList(p.r(obj6, 10));
        obj6 = obj6.iterator();
        for (b next2 : obj6) {
            arrayList.add(this.b.a(next2, x.b()));
        }
        return arrayList;
    }

    public List<c> g(kotlin.i0.z.e.m0.j.b.x x, n n2) {
        n.f(x, "container");
        n.f(n2, "proto");
        return p.g();
    }

    public List<c> h(kotlin.i0.z.e.m0.j.b.x x, o o2, kotlin.i0.z.e.m0.j.b.b b3) {
        n.f(x, "container");
        n.f(o2, "proto");
        n.f(b3, "kind");
        return p.g();
    }

    public List<c> i(kotlin.i0.z.e.m0.j.b.x x, n n2) {
        n.f(x, "container");
        n.f(n2, "proto");
        return p.g();
    }

    public List<c> j(kotlin.i0.z.e.m0.j.b.x x, o o2, kotlin.i0.z.e.m0.j.b.b b3) {
        boolean z;
        int i;
        kotlin.i0.z.e.m0.j.b.e eVar;
        c cVar;
        Object obj5;
        kotlin.reflect.jvm.internal.impl.protobuf.h.f obj6;
        n.f(x, "container");
        n.f(o2, "proto");
        n.f(b3, "kind");
        if (o2 instanceof d) {
            obj5 = (d)o2.o(this.a.c());
            if (obj5 != null) {
            } else {
                obj5 = p.g();
            }
            obj6 = new ArrayList(p.r(obj5, 10));
            obj5 = obj5.iterator();
            for (b next2 : obj5) {
                obj6.add(this.b.a(next2, x.b()));
            }
            return obj6;
        } else {
            if (o2 instanceof i) {
                obj5 = (i)o2.o(this.a.f());
            } else {
                if (!o2 instanceof n) {
                } else {
                    obj6 = d.a.a[b3.ordinal()];
                    if (obj6 != 1) {
                        if (obj6 != 2) {
                            if (obj6 != 3) {
                            } else {
                                obj5 = (n)o2.o(this.a.j());
                            }
                            IllegalStateException obj4 = new IllegalStateException("Unsupported callable kind with property proto".toString());
                            throw obj4;
                        }
                        obj5 = (n)o2.o(this.a.i());
                    } else {
                        obj5 = (n)o2.o(this.a.h());
                    }
                }
            }
        }
        obj5 = new IllegalStateException(n.o("Unknown message: ", o2).toString());
        throw obj5;
    }

    public g<?> k(kotlin.i0.z.e.m0.j.b.x x, n n2, b0 b03) {
        n.f(x, "container");
        n.f(n2, "proto");
        n.f(b03, "expectedType");
        final Object obj3 = e.a(n2, this.a.b());
        if ((b.b.c)obj3 == null) {
            return 0;
        }
        return this.b.f(b03, (b.b.c)obj3, x.b());
    }
}
