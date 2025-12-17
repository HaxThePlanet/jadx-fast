package kotlin.i0.z.e.m0.m;

import kotlin.d0.c.l;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.x;

/* loaded from: classes3.dex */
public abstract class k implements kotlin.i0.z.e.m0.m.b {

    private final String a;
    private final l<h, b0> b;
    private final String c;

    public static final class a extends kotlin.i0.z.e.m0.m.k {

        public static final kotlin.i0.z.e.m0.m.k.a d;
        static {
            k.a aVar = new k.a();
            k.a.d = aVar;
        }

        private a() {
            super("Boolean", k.a.a.a, 0);
        }
    }

    public static final class b extends kotlin.i0.z.e.m0.m.k {

        public static final kotlin.i0.z.e.m0.m.k.b d;
        static {
            k.b bVar = new k.b();
            k.b.d = bVar;
        }

        private b() {
            super("Int", k.b.a.a, 0);
        }
    }

    public static final class c extends kotlin.i0.z.e.m0.m.k {

        public static final kotlin.i0.z.e.m0.m.k.c d;
        static {
            k.c cVar = new k.c();
            k.c.d = cVar;
        }

        private c() {
            super("Unit", k.c.a.a, 0);
        }
    }
    private k(String string, l<? super h, ? extends b0> l2) {
        super();
        this.a = string;
        this.b = l2;
        this.c = n.o("must return ", string);
    }

    public k(String string, l l2, g g3) {
        super(string, l2);
    }

    @Override // kotlin.i0.z.e.m0.m.b
    public String a(x x) {
        return b.a.a(this, x);
    }

    @Override // kotlin.i0.z.e.m0.m.b
    public String b() {
        return this.c;
    }

    @Override // kotlin.i0.z.e.m0.m.b
    public boolean c(x x) {
        n.f(x, "functionDescriptor");
        return n.b(x.getReturnType(), this.b.invoke(a.g(x)));
    }
}
