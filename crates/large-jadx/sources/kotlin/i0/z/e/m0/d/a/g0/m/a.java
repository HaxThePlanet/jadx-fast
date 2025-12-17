package kotlin.i0.z.e.m0.d.a.g0.m;

import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.e0.k;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* loaded from: classes3.dex */
public final class a {

    private final k a;
    private final kotlin.i0.z.e.m0.d.a.g0.m.b b;
    private final boolean c;
    private final z0 d;
    public a(k k, kotlin.i0.z.e.m0.d.a.g0.m.b b2, boolean z3, z0 z04) {
        n.f(k, "howThisTypeIsUsed");
        n.f(b2, "flexibility");
        super();
        this.a = k;
        this.b = b2;
        this.c = z3;
        this.d = z04;
    }

    public a(k k, kotlin.i0.z.e.m0.d.a.g0.m.b b2, boolean z3, z0 z04, int i5, g g6) {
        kotlin.i0.z.e.m0.d.a.g0.m.b obj2;
        int obj3;
        int obj4;
        obj2 = i5 & 2 != 0 ? b.INFLEXIBLE : obj2;
        obj3 = i5 & 4 != 0 ? 0 : obj3;
        obj4 = i5 &= 8 != 0 ? 0 : obj4;
        super(k, obj2, obj3, obj4);
    }

    public static kotlin.i0.z.e.m0.d.a.g0.m.a b(kotlin.i0.z.e.m0.d.a.g0.m.a a, k k2, kotlin.i0.z.e.m0.d.a.g0.m.b b3, boolean z4, z0 z05, int i6, Object object7) {
        k obj1;
        kotlin.i0.z.e.m0.d.a.g0.m.b obj2;
        boolean obj3;
        z0 obj4;
        if (i6 & 1 != 0) {
            obj1 = a.a;
        }
        if (i6 & 2 != 0) {
            obj2 = a.b;
        }
        if (i6 & 4 != 0) {
            obj3 = a.c;
        }
        if (i6 &= 8 != 0) {
            obj4 = a.d;
        }
        return a.a(obj1, obj2, obj3, obj4);
    }

    public final kotlin.i0.z.e.m0.d.a.g0.m.a a(k k, kotlin.i0.z.e.m0.d.a.g0.m.b b2, boolean z3, z0 z04) {
        n.f(k, "howThisTypeIsUsed");
        n.f(b2, "flexibility");
        a aVar = new a(k, b2, z3, z04);
        return aVar;
    }

    public final kotlin.i0.z.e.m0.d.a.g0.m.b c() {
        return this.b;
    }

    public final k d() {
        return this.a;
    }

    public final z0 e() {
        return this.d;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof a) {
            return i2;
        }
        if (this.a != object.a) {
            return i2;
        }
        if (this.b != object.b) {
            return i2;
        }
        if (this.c != object.c) {
            return i2;
        }
        if (!n.b(this.d, object.d)) {
            return i2;
        }
        return i;
    }

    public final boolean f() {
        return this.c;
    }

    public final kotlin.i0.z.e.m0.d.a.g0.m.a g(kotlin.i0.z.e.m0.d.a.g0.m.b b) {
        n.f(b, "flexibility");
        return a.b(this, 0, b, false, 0, 13, 0);
    }

    public int hashCode() {
        boolean z;
        int i;
        if (this.c) {
            z = 1;
        }
        z0 z0Var = this.d;
        if (z0Var == null) {
            i = 0;
        } else {
            i = z0Var.hashCode();
        }
        return i7 += i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("JavaTypeAttributes(howThisTypeIsUsed=");
        stringBuilder.append(this.a);
        stringBuilder.append(", flexibility=");
        stringBuilder.append(this.b);
        stringBuilder.append(", isForAnnotationParameter=");
        stringBuilder.append(this.c);
        stringBuilder.append(", upperBoundOfTypeParameter=");
        stringBuilder.append(this.d);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
