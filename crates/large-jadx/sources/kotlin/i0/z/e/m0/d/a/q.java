package kotlin.i0.z.e.m0.d.a;

import java.util.Arrays;
import java.util.Set;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.i0.g;
import kotlin.i0.z.e.m0.d.a.i0.u;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;

/* loaded from: classes3.dex */
public interface q {

    public static final class a {

        private final a a;
        private final byte[] b;
        private final g c;
        public a(a a, byte[] b2Arr2, g g3) {
            n.f(a, "classId");
            super();
            this.a = a;
            this.b = b2Arr2;
            this.c = g3;
        }

        public a(a a, byte[] b2Arr2, g g3, int i4, g g5) {
            int obj3;
            int obj4;
            final int i = 0;
            obj3 = i4 & 2 != 0 ? i : obj3;
            obj4 = i4 &= 4 != 0 ? i : obj4;
            super(a, obj3, obj4);
        }

        public final a a() {
            return this.a;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof q.a) {
                return i2;
            }
            if (!n.b(this.a, object.a)) {
                return i2;
            }
            if (!n.b(this.b, object.b)) {
                return i2;
            }
            if (!n.b(this.c, object.c)) {
                return i2;
            }
            return i;
        }

        public int hashCode() {
            int i;
            int i2;
            byte[] bArr = this.b;
            if (bArr == null) {
                i = i2;
            } else {
                i = Arrays.hashCode(bArr);
            }
            g gVar = this.c;
            if (gVar == null) {
            } else {
                i2 = gVar.hashCode();
            }
            return i6 += i2;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Request(classId=");
            stringBuilder.append(this.a);
            stringBuilder.append(", previouslyFoundClassFileContent=");
            stringBuilder.append(Arrays.toString(this.b));
            stringBuilder.append(", outerClass=");
            stringBuilder.append(this.c);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }
    public abstract g a(kotlin.i0.z.e.m0.d.a.q.a q$a);

    public abstract u b(b b);

    public abstract Set<String> c(b b);
}
