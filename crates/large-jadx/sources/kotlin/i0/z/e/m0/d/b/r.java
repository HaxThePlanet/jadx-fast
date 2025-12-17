package kotlin.i0.z.e.m0.d.b;

import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.e.a0.a.c;
import kotlin.i0.z.e.m0.e.a0.b.e;
import kotlin.i0.z.e.m0.e.z.c;

/* loaded from: classes3.dex */
public final class r {

    public static final kotlin.i0.z.e.m0.d.b.r.a b;
    private final String a;

    public static final class a {
        public a(g g) {
            super();
        }

        public final kotlin.i0.z.e.m0.d.b.r a(String string, String string2) {
            n.f(string, "name");
            n.f(string2, "desc");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append('#');
            stringBuilder.append(string2);
            r rVar = new r(stringBuilder.toString(), 0);
            return rVar;
        }

        public final kotlin.i0.z.e.m0.d.b.r b(e e) {
            String str;
            kotlin.i0.z.e.m0.d.b.r obj2;
            n.f(e, "signature");
            if (e instanceof e.b) {
                obj2 = d(e.c(), e.b());
                return obj2;
            } else {
                if (!e instanceof e.a) {
                } else {
                    obj2 = a(e.c(), e.b());
                }
            }
            obj2 = new NoWhenBranchMatchedException();
            throw obj2;
        }

        public final kotlin.i0.z.e.m0.d.b.r c(c c, a.c a$c2) {
            n.f(c, "nameResolver");
            n.f(c2, "signature");
            return d(c.getString(c2.r()), c.getString(c2.q()));
        }

        public final kotlin.i0.z.e.m0.d.b.r d(String string, String string2) {
            n.f(string, "name");
            n.f(string2, "desc");
            r rVar = new r(n.o(string, string2), 0);
            return rVar;
        }

        public final kotlin.i0.z.e.m0.d.b.r e(kotlin.i0.z.e.m0.d.b.r r, int i2) {
            n.f(r, "signature");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(r.a());
            stringBuilder.append('@');
            stringBuilder.append(i2);
            r rVar = new r(stringBuilder.toString(), 0);
            return rVar;
        }
    }
    static {
        r.a aVar = new r.a(0);
        r.b = aVar;
    }

    private r(String string) {
        super();
        this.a = string;
    }

    public r(String string, g g2) {
        super(string);
    }

    public final String a() {
        return this.a;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof r) {
            return i2;
        }
        if (!n.b(this.a, object.a)) {
            return i2;
        }
        return i;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MemberSignature(signature=");
        stringBuilder.append(this.a);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
