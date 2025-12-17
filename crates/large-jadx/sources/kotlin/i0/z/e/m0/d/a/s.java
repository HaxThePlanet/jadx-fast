package kotlin.i0.z.e.m0.d.a;

import java.util.Collection;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.j0.h;
import kotlin.i0.z.e.m0.d.a.j0.i;

/* loaded from: classes3.dex */
public final class s {

    private final i a;
    private final Collection<kotlin.i0.z.e.m0.d.a.a> b;
    private final boolean c;
    public s(i i, Collection<? extends kotlin.i0.z.e.m0.d.a.a> collection2, boolean z3) {
        n.f(i, "nullabilityQualifier");
        n.f(collection2, "qualifierApplicabilityTypes");
        super();
        this.a = i;
        this.b = collection2;
        this.c = z3;
    }

    public s(i i, Collection collection2, boolean z3, int i4, g g5) {
        int obj3;
        int obj4;
        if (i4 &= 4 != 0) {
            obj3 = i.c() == h.NOT_NULL ? 1 : 0;
        }
        super(i, collection2, obj3);
    }

    public static kotlin.i0.z.e.m0.d.a.s b(kotlin.i0.z.e.m0.d.a.s s, i i2, Collection collection3, boolean z4, int i5, Object object6) {
        i obj1;
        Collection obj2;
        boolean obj3;
        if (i5 & 1 != 0) {
            obj1 = s.a;
        }
        if (i5 & 2 != 0) {
            obj2 = s.b;
        }
        if (i5 &= 4 != 0) {
            obj3 = s.c;
        }
        return s.a(obj1, obj2, obj3);
    }

    public final kotlin.i0.z.e.m0.d.a.s a(i i, Collection<? extends kotlin.i0.z.e.m0.d.a.a> collection2, boolean z3) {
        n.f(i, "nullabilityQualifier");
        n.f(collection2, "qualifierApplicabilityTypes");
        s sVar = new s(i, collection2, z3);
        return sVar;
    }

    public final boolean c() {
        return this.c;
    }

    public final boolean d() {
        h hVar;
        int i;
        if (this.a.c() == h.NOT_NULL && this.c) {
            i = this.c ? 1 : 0;
        } else {
        }
        return i;
    }

    public final i e() {
        return this.a;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof s) {
            return i2;
        }
        if (!n.b(this.a, object.a)) {
            return i2;
        }
        if (!n.b(this.b, object.b)) {
            return i2;
        }
        if (this.c != object.c) {
            return i2;
        }
        return i;
    }

    public final Collection<kotlin.i0.z.e.m0.d.a.a> f() {
        return this.b;
    }

    public int hashCode() {
        boolean z;
        if (this.c) {
            z = 1;
        }
        return i4 += z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("JavaDefaultQualifiers(nullabilityQualifier=");
        stringBuilder.append(this.a);
        stringBuilder.append(", qualifierApplicabilityTypes=");
        stringBuilder.append(this.b);
        stringBuilder.append(", affectsTypeParameterBasedTypes=");
        stringBuilder.append(this.c);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
