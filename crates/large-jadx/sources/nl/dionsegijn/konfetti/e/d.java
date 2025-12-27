package nl.dionsegijn.konfetti.e;

import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: Vector.kt */
/* loaded from: classes3.dex */
public final class d {

    private float a;
    private float b;
    public d(float f, float f2) {
        super();
        this.a = f;
        this.b = f2;
    }

    public final void a(d dVar) {
        n.f(dVar, "v");
        this.a += f5;
        this.b += f6;
    }

    public final void d(float f) {
        this.a /= f;
        this.b /= f;
    }

    public final float e() {
        return this.a;
    }

    public final float f() {
        return this.b;
    }

    public final void g(float f) {
        this.a *= f;
        this.b *= f;
    }

    public /* synthetic */ d(float f, float f2, int i, g gVar) {
        i = 0;
        i = i & 1 != 0 ? i : i;
        i = i & 2 != 0 ? i : i;
        this(i, i);
    }

    public d() {
        final float f = 0.0f;
        this(f, f, 3, null);
    }

    public static /* synthetic */ d c(d dVar, float f, float f2, int i, Object object) {
        float f4;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        return dVar.b(f, f4);
    }

    public final d b(float f, float f2) {
        return new d(f, f2);
    }

    public boolean equals(Object object) {
        if (this != object) {
            z = object instanceof d;
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Vector(x=";
        String str3 = ", y=";
        String str4 = ")";
        str = str2 + this.a + str3 + this.b + str4;
        return str;
    }
}
