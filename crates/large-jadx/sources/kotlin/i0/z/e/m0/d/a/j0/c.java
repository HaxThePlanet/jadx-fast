package kotlin.i0.z.e.m0.d.a.j0;

import kotlin.d0.d.n;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;

/* loaded from: classes3.dex */
final class c<T>  {

    private final T a;
    private final g b;
    public c(T t, g g2) {
        super();
        this.a = t;
        this.b = g2;
    }

    public final T a() {
        return this.a;
    }

    public final g b() {
        return this.b;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof c) {
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

    public int hashCode() {
        int i2;
        int i;
        Object obj = this.a;
        if (obj == null) {
            i2 = i;
        } else {
            i2 = obj.hashCode();
        }
        final g gVar = this.b;
        if (gVar == null) {
        } else {
            i = gVar.hashCode();
        }
        return i3 += i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EnhancementResult(result=");
        stringBuilder.append(this.a);
        stringBuilder.append(", enhancementAnnotations=");
        stringBuilder.append(this.b);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
