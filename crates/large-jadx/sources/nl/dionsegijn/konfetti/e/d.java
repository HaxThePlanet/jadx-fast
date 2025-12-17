package nl.dionsegijn.konfetti.e;

import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public final class d {

    private float a;
    private float b;
    public d() {
        final int i = 0;
        super(i, i, 3, 0);
    }

    public d(float f, float f2) {
        super();
        this.a = f;
        this.b = f2;
    }

    public d(float f, float f2, int i3, g g4) {
        int obj2;
        int obj3;
        final int i = 0;
        obj2 = i3 & 1 != 0 ? i : obj2;
        obj3 = i3 &= 2 != 0 ? i : obj3;
        super(obj2, obj3);
    }

    public static nl.dionsegijn.konfetti.e.d c(nl.dionsegijn.konfetti.e.d d, float f2, float f3, int i4, Object object5) {
        float obj1;
        float obj2;
        if (i4 & 1 != 0) {
            obj1 = d.a;
        }
        if (i4 &= 2 != 0) {
            obj2 = d.b;
        }
        return d.b(obj1, obj2);
    }

    public final void a(nl.dionsegijn.konfetti.e.d d) {
        n.f(d, "v");
        this.a = f += f3;
        this.b = f2 += obj3;
    }

    public final nl.dionsegijn.konfetti.e.d b(float f, float f2) {
        d dVar = new d(f, f2);
        return dVar;
    }

    public final void d(float f) {
        this.a = f2 /= f;
        this.b = f3 /= f;
    }

    public final float e() {
        return this.a;
    }

    public boolean equals(Object object) {
        boolean compare;
        float f;
        Object obj3;
        if (this != (d)object && object instanceof d && Float.compare(this.a, object.a) == 0 && Float.compare(this.b, object.b) == 0) {
            if (object instanceof d) {
                if (Float.compare(this.a, object.a) == 0) {
                    if (Float.compare(this.b, object.b) == 0) {
                    }
                }
            }
            return 0;
        }
        return 1;
    }

    public final float f() {
        return this.b;
    }

    public final void g(float f) {
        this.a = f2 *= f;
        this.b = f3 *= f;
    }

    public int hashCode() {
        return i += floatToIntBits2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Vector(x=");
        stringBuilder.append(this.a);
        stringBuilder.append(", y=");
        stringBuilder.append(this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
