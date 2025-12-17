package kotlin.i0.z.e.m0.d.a.j0;

import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public final class i {

    private final kotlin.i0.z.e.m0.d.a.j0.h a;
    private final boolean b;
    public i(kotlin.i0.z.e.m0.d.a.j0.h h, boolean z2) {
        n.f(h, "qualifier");
        super();
        this.a = h;
        this.b = z2;
    }

    public i(kotlin.i0.z.e.m0.d.a.j0.h h, boolean z2, int i3, g g4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(h, obj2);
    }

    public static kotlin.i0.z.e.m0.d.a.j0.i b(kotlin.i0.z.e.m0.d.a.j0.i i, kotlin.i0.z.e.m0.d.a.j0.h h2, boolean z3, int i4, Object object5) {
        kotlin.i0.z.e.m0.d.a.j0.h obj1;
        boolean obj2;
        if (i4 & 1 != 0) {
            obj1 = i.a;
        }
        if (i4 &= 2 != 0) {
            obj2 = i.b;
        }
        return i.a(obj1, obj2);
    }

    public final kotlin.i0.z.e.m0.d.a.j0.i a(kotlin.i0.z.e.m0.d.a.j0.h h, boolean z2) {
        n.f(h, "qualifier");
        i iVar = new i(h, z2);
        return iVar;
    }

    public final kotlin.i0.z.e.m0.d.a.j0.h c() {
        return this.a;
    }

    public final boolean d() {
        return this.b;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof i) {
            return i2;
        }
        if (this.a != object.a) {
            return i2;
        }
        if (this.b != object.b) {
            return i2;
        }
        return i;
    }

    public int hashCode() {
        boolean z;
        if (this.b) {
            z = 1;
        }
        return i2 += z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NullabilityQualifierWithMigrationStatus(qualifier=");
        stringBuilder.append(this.a);
        stringBuilder.append(", isForWarningOnly=");
        stringBuilder.append(this.b);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
