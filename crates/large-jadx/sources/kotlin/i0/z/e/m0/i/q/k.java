package kotlin.i0.z.e.m0.i.q;

import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.i0.z.e.m0.l.t;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.w;

/* loaded from: classes3.dex */
public abstract class k extends kotlin.i0.z.e.m0.i.q.g<w> {

    public static final kotlin.i0.z.e.m0.i.q.k.a b;

    public static final class a {
        public a(g g) {
            super();
        }

        public final kotlin.i0.z.e.m0.i.q.k a(String string) {
            n.f(string, "message");
            k.b bVar = new k.b(string);
            return bVar;
        }
    }

    public static final class b extends kotlin.i0.z.e.m0.i.q.k {

        private final String c;
        public b(String string) {
            n.f(string, "message");
            super();
            this.c = string;
        }

        @Override // kotlin.i0.z.e.m0.i.q.k
        public b0 a(c0 c0) {
            return d(c0);
        }

        @Override // kotlin.i0.z.e.m0.i.q.k
        public i0 d(c0 c0) {
            n.f(c0, "module");
            i0 obj2 = t.j(this.c);
            n.e(obj2, "createErrorType(message)");
            return obj2;
        }

        @Override // kotlin.i0.z.e.m0.i.q.k
        public String toString() {
            return this.c;
        }
    }
    static {
        k.a aVar = new k.a(0);
        k.b = aVar;
    }

    public k() {
        super(w.a);
    }

    @Override // kotlin.i0.z.e.m0.i.q.g
    public Object b() {
        c();
        throw 0;
    }

    @Override // kotlin.i0.z.e.m0.i.q.g
    public w c() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}
