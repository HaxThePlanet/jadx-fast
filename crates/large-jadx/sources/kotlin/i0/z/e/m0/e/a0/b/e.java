package kotlin.i0.z.e.m0.e.a0.b;

import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public abstract class e {

    public static final class a extends kotlin.i0.z.e.m0.e.a0.b.e {

        private final String a;
        private final String b;
        public a(String string, String string2) {
            n.f(string, "name");
            n.f(string2, "desc");
            super(0);
            this.a = string;
            this.b = string2;
        }

        @Override // kotlin.i0.z.e.m0.e.a0.b.e
        public String a() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(c());
            stringBuilder.append(':');
            stringBuilder.append(b());
            return stringBuilder.toString();
        }

        @Override // kotlin.i0.z.e.m0.e.a0.b.e
        public String b() {
            return this.b;
        }

        @Override // kotlin.i0.z.e.m0.e.a0.b.e
        public String c() {
            return this.a;
        }

        @Override // kotlin.i0.z.e.m0.e.a0.b.e
        public final String d() {
            return this.a;
        }

        @Override // kotlin.i0.z.e.m0.e.a0.b.e
        public final String e() {
            return this.b;
        }

        @Override // kotlin.i0.z.e.m0.e.a0.b.e
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof e.a) {
                return i2;
            }
            if (!n.b(this.a, object.a)) {
                return i2;
            }
            if (!n.b(this.b, object.b)) {
                return i2;
            }
            return i;
        }

        @Override // kotlin.i0.z.e.m0.e.a0.b.e
        public int hashCode() {
            return i2 += i4;
        }
    }

    public static final class b extends kotlin.i0.z.e.m0.e.a0.b.e {

        private final String a;
        private final String b;
        public b(String string, String string2) {
            n.f(string, "name");
            n.f(string2, "desc");
            super(0);
            this.a = string;
            this.b = string2;
        }

        @Override // kotlin.i0.z.e.m0.e.a0.b.e
        public String a() {
            return n.o(c(), b());
        }

        @Override // kotlin.i0.z.e.m0.e.a0.b.e
        public String b() {
            return this.b;
        }

        @Override // kotlin.i0.z.e.m0.e.a0.b.e
        public String c() {
            return this.a;
        }

        @Override // kotlin.i0.z.e.m0.e.a0.b.e
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof e.b) {
                return i2;
            }
            if (!n.b(this.a, object.a)) {
                return i2;
            }
            if (!n.b(this.b, object.b)) {
                return i2;
            }
            return i;
        }

        @Override // kotlin.i0.z.e.m0.e.a0.b.e
        public int hashCode() {
            return i2 += i4;
        }
    }
    public e(g g) {
        super();
    }

    public abstract String a();

    public abstract String b();

    public abstract String c();

    public final String toString() {
        return a();
    }
}
