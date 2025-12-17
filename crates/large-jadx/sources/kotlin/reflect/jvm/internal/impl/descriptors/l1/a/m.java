package kotlin.reflect.jvm.internal.impl.descriptors.l1.a;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.h0.a;
import kotlin.i0.z.e.m0.d.a.h0.b;
import kotlin.i0.z.e.m0.d.a.i0.l;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;

/* loaded from: classes3.dex */
public final class m implements b {

    public static final kotlin.reflect.jvm.internal.impl.descriptors.l1.a.m a;

    public static final class a implements a {

        private final n b;
        public a(n n) {
            n.f(n, "javaElement");
            super();
            this.b = n;
        }

        @Override // kotlin.i0.z.e.m0.d.a.h0.a
        public v0 a() {
            final v0 v0Var = v0.a;
            n.e(v0Var, "NO_SOURCE_FILE");
            return v0Var;
        }

        @Override // kotlin.i0.z.e.m0.d.a.h0.a
        public l b() {
            return d();
        }

        @Override // kotlin.i0.z.e.m0.d.a.h0.a
        public n d() {
            return this.b;
        }

        @Override // kotlin.i0.z.e.m0.d.a.h0.a
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(m.a.class.getName());
            stringBuilder.append(": ");
            stringBuilder.append(d());
            return stringBuilder.toString();
        }
    }
    static {
        m mVar = new m();
        m.a = mVar;
    }

    @Override // kotlin.i0.z.e.m0.d.a.h0.b
    public a a(l l) {
        n.f(l, "javaElement");
        m.a aVar = new m.a((n)l);
        return aVar;
    }
}
