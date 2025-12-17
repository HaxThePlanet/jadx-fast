package kotlin.i0.z.e.m0.j.b;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.e.c;
import kotlin.i0.z.e.m0.e.z.a;
import kotlin.i0.z.e.m0.e.z.c;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;

/* loaded from: classes3.dex */
public final class f {

    private final c a;
    private final c b;
    private final a c;
    private final u0 d;
    public f(c c, c c2, a a3, u0 u04) {
        n.f(c, "nameResolver");
        n.f(c2, "classProto");
        n.f(a3, "metadataVersion");
        n.f(u04, "sourceElement");
        super();
        this.a = c;
        this.b = c2;
        this.c = a3;
        this.d = u04;
    }

    public final c a() {
        return this.a;
    }

    public final c b() {
        return this.b;
    }

    public final a c() {
        return this.c;
    }

    public final u0 d() {
        return this.d;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof f) {
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
        if (!n.b(this.d, object.d)) {
            return i2;
        }
        return i;
    }

    public int hashCode() {
        return i6 += i10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ClassData(nameResolver=");
        stringBuilder.append(this.a);
        stringBuilder.append(", classProto=");
        stringBuilder.append(this.b);
        stringBuilder.append(", metadataVersion=");
        stringBuilder.append(this.c);
        stringBuilder.append(", sourceElement=");
        stringBuilder.append(this.d);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
