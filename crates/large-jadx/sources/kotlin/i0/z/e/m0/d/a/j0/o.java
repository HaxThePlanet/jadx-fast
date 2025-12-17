package kotlin.i0.z.e.m0.d.a.j0;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.s;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* loaded from: classes3.dex */
final class o {

    private final b0 a;
    private final s b;
    private final z0 c;
    private final boolean d;
    public o(b0 b0, s s2, z0 z03, boolean z4) {
        n.f(b0, "type");
        super();
        this.a = b0;
        this.b = s2;
        this.c = z03;
        this.d = z4;
    }

    public final b0 a() {
        return this.a;
    }

    public final s b() {
        return this.b;
    }

    public final z0 c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final b0 e() {
        return this.a;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof o) {
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
        if (this.d != object.d) {
            return i2;
        }
        return i;
    }

    public int hashCode() {
        int i;
        boolean z;
        int i2;
        s sVar = this.b;
        if (sVar == null) {
            i = i2;
        } else {
            i = sVar.hashCode();
        }
        z0 z0Var = this.c;
        if (z0Var == null) {
        } else {
            i2 = z0Var.hashCode();
        }
        if (this.d) {
            z = 1;
        }
        return i8 += z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TypeAndDefaultQualifiers(type=");
        stringBuilder.append(this.a);
        stringBuilder.append(", defaultQualifiers=");
        stringBuilder.append(this.b);
        stringBuilder.append(", typeParameterForArgument=");
        stringBuilder.append(this.c);
        stringBuilder.append(", isFromStarProjection=");
        stringBuilder.append(this.d);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
