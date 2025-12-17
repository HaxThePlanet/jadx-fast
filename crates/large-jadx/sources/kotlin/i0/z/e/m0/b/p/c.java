package kotlin.i0.z.e.m0.b.p;

import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.k;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.k0.l;

/* loaded from: classes3.dex */
public enum c {

    Function(field_1, "Function"),
    SuspendFunction("Function", "SuspendFunction"),
    KFunction("SuspendFunction", "KFunction"),
    KSuspendFunction("SuspendFunction", "KSuspendFunction");

    private final String classNamePrefix;
    private final b packageFqName;

    public static final class a {
        public a(g g) {
            super();
        }

        private final Integer d(String string) {
            int i;
            int i3;
            int i4;
            int i5;
            int i2;
            final int i6 = 1;
            final int i7 = 0;
            i = string.length() == 0 ? i6 : i7;
            final int i8 = 0;
            if (i != 0) {
                return i8;
            }
            i4 = i3;
            while (i3 < string.length()) {
                i3++;
                charAt += -48;
                if (i5 >= 0 && i5 <= 9) {
                } else {
                }
                i2 = i7;
                i9 += i5;
                if (i5 <= 9) {
                } else {
                }
                i2 = i6;
            }
            return Integer.valueOf(i4);
        }

        public final kotlin.i0.z.e.m0.b.p.c a(b b, String string2) {
            int i;
            int i4;
            int i3;
            kotlin.i0.z.e.m0.b.p.c cVar;
            String classNamePrefix;
            int i2;
            n.f(b, "packageFqName");
            n.f(string2, "className");
            kotlin.i0.z.e.m0.b.p.c[] values = c.values();
            final int i5 = 0;
            i = i5;
            while (i < values.length) {
                cVar = values[i];
                if (n.b(cVar.getPackageFqName(), b) && l.M(string2, cVar.getClassNamePrefix(), i5, 2, 0)) {
                } else {
                }
                i4 = i5;
                if (i4 != 0) {
                    break;
                } else {
                }
                i++;
                if (l.M(string2, cVar.getClassNamePrefix(), i5, 2, 0)) {
                } else {
                }
                i4 = 1;
            }
            return i3;
        }

        public final kotlin.i0.z.e.m0.b.p.c b(String string, b b2) {
            int obj2;
            n.f(string, "className");
            n.f(b2, "packageFqName");
            obj2 = c(string, b2);
            if (obj2 == null) {
                obj2 = 0;
            } else {
                obj2 = obj2.c();
            }
            return obj2;
        }

        public final kotlin.i0.z.e.m0.b.p.c.a.a c(String string, b b2) {
            n.f(string, "className");
            n.f(b2, "packageFqName");
            final kotlin.i0.z.e.m0.b.p.c obj4 = a(b2, string);
            int i = 0;
            if (obj4 == null) {
                return i;
            }
            String obj3 = string.substring(obj4.getClassNamePrefix().length());
            n.e(obj3, "(this as java.lang.String).substring(startIndex)");
            obj3 = d(obj3);
            if (obj3 == null) {
                return i;
            }
            c.a.a aVar = new c.a.a(obj4, obj3.intValue());
            return aVar;
        }
    }
    @Override // java.lang.Enum
    public final String getClassNamePrefix() {
        return this.classNamePrefix;
    }

    @Override // java.lang.Enum
    public final b getPackageFqName() {
        return this.packageFqName;
    }

    @Override // java.lang.Enum
    public final e numberedClassName(int i) {
        e obj2 = e.j(n.o(this.classNamePrefix, Integer.valueOf(i)));
        n.e(obj2, "identifier(\"$classNamePrefix$arity\")");
        return obj2;
    }
}
