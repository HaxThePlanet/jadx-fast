package kotlin.i0.z.e.m0.d.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.e.b;
import kotlin.i0.z.e.m0.e.z.c;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.q.f;
import kotlin.i0.z.e.m0.i.q.g;
import kotlin.i0.z.e.m0.i.q.h;
import kotlin.i0.z.e.m0.i.q.j;
import kotlin.i0.z.e.m0.i.q.k;
import kotlin.i0.z.e.m0.i.q.k.a;
import kotlin.i0.z.e.m0.i.q.q;
import kotlin.i0.z.e.m0.i.q.w;
import kotlin.i0.z.e.m0.i.q.x;
import kotlin.i0.z.e.m0.i.q.y;
import kotlin.i0.z.e.m0.i.q.z;
import kotlin.i0.z.e.m0.j.b.e;
import kotlin.i0.z.e.m0.k.n;
import kotlin.k0.l;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.c;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.d;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.w;

/* loaded from: classes3.dex */
public final class b extends kotlin.i0.z.e.m0.d.b.a<c, g<?>> {

    private final c0 c;
    private final e0 d;
    private final e e;

    public static final class a implements kotlin.i0.z.e.m0.d.b.o.a {

        private final HashMap<e, g<?>> a;
        final e b;
        final kotlin.i0.z.e.m0.d.b.b c;
        final List<c> d;
        final u0 e;
        a(e e, kotlin.i0.z.e.m0.d.b.b b2, List<c> list3, u0 u04) {
            this.b = e;
            this.c = b2;
            this.d = list3;
            this.e = u04;
            super();
            HashMap obj1 = new HashMap();
            this.a = obj1;
        }

        public static final g g(kotlin.i0.z.e.m0.d.b.b.a b$a, e e2, Object object3) {
            return a.i(e2, object3);
        }

        public static final HashMap h(kotlin.i0.z.e.m0.d.b.b.a b$a) {
            return a.a;
        }

        private final g<?> i(e e, Object object2) {
            Object str;
            Object obj2;
            g obj3;
            if (h.a.c(object2) == null) {
                obj3 = k.b.a(n.o("Unsupported annotation argument: ", e));
            }
            return obj3;
        }

        @Override // kotlin.i0.z.e.m0.d.b.o$a
        public void a() {
            d dVar = new d(this.b.q(), this.a, this.e);
            this.d.add(dVar);
        }

        @Override // kotlin.i0.z.e.m0.d.b.o$a
        public void b(e e, f f2) {
            n.f(e, "name");
            n.f(f2, "value");
            q qVar = new q(f2);
            this.a.put(e, qVar);
        }

        @Override // kotlin.i0.z.e.m0.d.b.o$a
        public void c(e e, Object object2) {
            HashMap map;
            Object obj3;
            if (e != null) {
                this.a.put(e, i(e, object2));
            }
        }

        @Override // kotlin.i0.z.e.m0.d.b.o$a
        public void d(e e, a a2, e e3) {
            n.f(e, "name");
            n.f(a2, "enumClassId");
            n.f(e3, "enumEntryName");
            j jVar = new j(a2, e3);
            this.a.put(e, jVar);
        }

        @Override // kotlin.i0.z.e.m0.d.b.o$a
        public kotlin.i0.z.e.m0.d.b.o.a e(e e, a a2) {
            n.f(e, "name");
            n.f(a2, "classId");
            ArrayList arrayList = new ArrayList();
            final u0 u0Var = u0.a;
            n.e(u0Var, "NO_SOURCE");
            final kotlin.i0.z.e.m0.d.b.o.a obj6 = this.c.w(a2, u0Var, arrayList);
            n.d(obj6);
            b.a.a aVar = new b.a.a(obj6, this, e, arrayList);
            return aVar;
        }

        @Override // kotlin.i0.z.e.m0.d.b.o$a
        public kotlin.i0.z.e.m0.d.b.o.b f(e e) {
            n.f(e, "name");
            b.a.b bVar = new b.a.b(this, e, this.b);
            return bVar;
        }
    }
    public b(c0 c0, e0 e02, n n3, kotlin.i0.z.e.m0.d.b.m m4) {
        n.f(c0, "module");
        n.f(e02, "notFoundClasses");
        n.f(n3, "storageManager");
        n.f(m4, "kotlinClassFinder");
        super(n3, m4);
        this.c = c0;
        this.d = e02;
        e obj4 = new e(c0, e02);
        this.e = obj4;
    }

    private final e G(a a) {
        return w.c(this.c, a, this.d);
    }

    @Override // kotlin.i0.z.e.m0.d.b.a
    protected Object B(b b, c c2) {
        return F(b, c2);
    }

    @Override // kotlin.i0.z.e.m0.d.b.a
    protected Object D(Object object) {
        return H((g)object);
    }

    protected g<?> E(String string, Object object2) {
        boolean equals;
        int i;
        int i2;
        Object obj5;
        Object obj6;
        n.f(string, "desc");
        n.f(object2, "initializer");
        if (l.R("ZBCS", string, false, 2, 0)) {
            obj6 = (Integer)object2.intValue();
            equals = string.hashCode();
            if (equals != 66) {
                if (equals != 67) {
                    if (equals != 83) {
                        if (equals != 90) {
                        } else {
                            if (!string.equals("Z")) {
                            } else {
                                if (obj6 != null) {
                                    i = 1;
                                }
                                obj6 = Boolean.valueOf(i);
                            }
                        }
                    } else {
                        if (!string.equals("S")) {
                        } else {
                            obj6 = Short.valueOf((short)obj6);
                        }
                    }
                } else {
                    if (!string.equals("C")) {
                    } else {
                        obj6 = Character.valueOf((char)obj6);
                    }
                }
            } else {
                if (!string.equals("B")) {
                } else {
                    obj6 = Byte.valueOf((byte)obj6);
                }
            }
            obj6 = new AssertionError(string);
            throw obj6;
        }
        return h.a.c(obj6);
    }

    @Override // kotlin.i0.z.e.m0.d.b.a
    protected c F(b b, c c2) {
        n.f(b, "proto");
        n.f(c2, "nameResolver");
        return this.e.a(b, c2);
    }

    protected g<?> H(g<?> g) {
        kotlin.i0.z.e.m0.i.q.a0 yVar;
        long longValue;
        byte obj4;
        n.f(g, "constant");
        if (g instanceof d) {
            yVar = new w((Number)(d)g.b().byteValue());
            obj4 = yVar;
        } else {
        }
        return obj4;
    }

    protected kotlin.i0.z.e.m0.d.b.o.a w(a a, u0 u02, List<c> list3) {
        n.f(a, "annotationClassId");
        n.f(u02, "source");
        n.f(list3, "result");
        b.a aVar = new b.a(G(a), this, list3, u02);
        return aVar;
    }

    @Override // kotlin.i0.z.e.m0.d.b.a
    protected Object z(String string, Object object2) {
        return E(string, object2);
    }
}
