package kotlin.i0.z.e.m0.m;

import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.x;

/* loaded from: classes3.dex */
public abstract class f implements kotlin.i0.z.e.m0.m.b {

    private final String a;

    public static final class a extends kotlin.i0.z.e.m0.m.f {

        public static final kotlin.i0.z.e.m0.m.f.a b;
        static {
            f.a aVar = new f.a();
            f.a.b = aVar;
        }

        private a() {
            super("must be a member function", 0);
        }

        @Override // kotlin.i0.z.e.m0.m.f
        public boolean c(x x) {
            int obj2;
            n.f(x, "functionDescriptor");
            obj2 = x.f0() != null ? 1 : 0;
            return obj2;
        }
    }

    public static final class b extends kotlin.i0.z.e.m0.m.f {

        public static final kotlin.i0.z.e.m0.m.f.b b;
        static {
            f.b bVar = new f.b();
            f.b.b = bVar;
        }

        private b() {
            super("must be a member or an extension function", 0);
        }

        @Override // kotlin.i0.z.e.m0.m.f
        public boolean c(x x) {
            int obj2;
            n.f(x, "functionDescriptor");
            if (x.f0() == null) {
                if (x.m0() != null) {
                    obj2 = 1;
                } else {
                    obj2 = 0;
                }
            } else {
            }
            return obj2;
        }
    }
    private f(String string) {
        super();
        this.a = string;
    }

    public f(String string, g g2) {
        super(string);
    }

    @Override // kotlin.i0.z.e.m0.m.b
    public String a(x x) {
        return b.a.a(this, x);
    }

    @Override // kotlin.i0.z.e.m0.m.b
    public String b() {
        return this.a;
    }
}
