package kotlin.reflect.jvm.internal.impl.descriptors.l1.a;

import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.b.a0.a;
import kotlin.i0.z.e.m0.d.b.a0.b;
import kotlin.i0.z.e.m0.d.b.o;
import kotlin.i0.z.e.m0.d.b.o.c;
import kotlin.i0.z.e.m0.d.b.o.d;
import kotlin.i0.z.e.m0.f.a;
import kotlin.k0.l;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.b.b;

/* loaded from: classes3.dex */
public final class f implements o {

    public static final kotlin.reflect.jvm.internal.impl.descriptors.l1.a.f.a c;
    private final Class<?> a;
    private final a b;

    public static final class a {
        public a(g g) {
            super();
        }

        public final kotlin.reflect.jvm.internal.impl.descriptors.l1.a.f a(Class<?> class) {
            n.f(class, "klass");
            b bVar = new b();
            c.a.b(class, bVar);
            a aVar = bVar.n();
            final int i = 0;
            if (aVar == null) {
                return i;
            }
            f fVar = new f(class, aVar, i);
            return fVar;
        }
    }
    static {
        f.a aVar = new f.a(0);
        f.c = aVar;
    }

    private f(Class<?> class, a a2) {
        super();
        this.a = class;
        this.b = a2;
    }

    public f(Class class, a a2, g g3) {
        super(class, a2);
    }

    @Override // kotlin.i0.z.e.m0.d.b.o
    public a a() {
        return this.b;
    }

    @Override // kotlin.i0.z.e.m0.d.b.o
    public void b(o.c o$c, byte[] b2Arr2) {
        n.f(c, "visitor");
        c.a.b(this.a, c);
    }

    @Override // kotlin.i0.z.e.m0.d.b.o
    public void c(o.d o$d, byte[] b2Arr2) {
        n.f(d, "visitor");
        c.a.i(this.a, d);
    }

    public final Class<?> d() {
        return this.a;
    }

    @Override // kotlin.i0.z.e.m0.d.b.o
    public a e() {
        return b.b(this.a);
    }

    @Override // kotlin.i0.z.e.m0.d.b.o
    public boolean equals(Object object) {
        boolean z;
        Object obj2;
        if (object instanceof f && n.b(this.a, object.a)) {
            obj2 = n.b(this.a, object.a) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // kotlin.i0.z.e.m0.d.b.o
    public String getLocation() {
        String name = this.a.getName();
        n.e(name, "klass.name");
        return n.o(l.F(name, '.', '/', false, 4, 0), ".class");
    }

    @Override // kotlin.i0.z.e.m0.d.b.o
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // kotlin.i0.z.e.m0.d.b.o
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f.class.getName());
        stringBuilder.append(": ");
        stringBuilder.append(this.a);
        return stringBuilder.toString();
    }
}
