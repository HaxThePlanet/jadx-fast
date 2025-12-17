package nl.dionsegijn.konfetti.f;

import java.util.Random;
import kotlin.d0.d.n;
import nl.dionsegijn.konfetti.e.d;

/* loaded from: classes3.dex */
public final class b {

    private double a;
    private Double b;
    private float c;
    private Float d;
    private float e = -1f;
    private float f = 1f;
    private float g = 0.2f;
    private final Random h;
    public b(Random random) {
        n.f(random, "random");
        super();
        this.h = random;
        int obj2 = -1082130432;
        obj2 = 1065353216;
        obj2 = 1045220557;
    }

    public final float a() {
        return this.e;
    }

    public final double b() {
        double d2;
        double d;
        Double num = this.b;
        if (num == null) {
            d2 = this.a;
        } else {
            n.d(num);
            i2 += d;
        }
        return d2;
    }

    public final float c() {
        float f = this.f;
        return f += i7;
    }

    public final float d() {
        float f;
        float f2;
        Float num = this.d;
        if (num == null) {
            f = this.c;
        } else {
            n.d(num);
            i2 += f2;
        }
        return f;
    }

    public final d e() {
        float f = d();
        double d = b();
        d dVar = new d(f3 *= f, f *= f2);
        return dVar;
    }

    public final void f(Double double) {
        this.b = double;
    }

    public final void g(Float float) {
        Object obj3;
        n.d(float);
        if (Float.compare(floatValue, f) < 0) {
            obj3 = 0f;
        }
        this.d = obj3;
    }

    public final void h(double d) {
        this.a = d;
    }

    public final void i(float f) {
        float obj2;
        if (Float.compare(f, f2) < 0) {
            obj2 = 0;
        }
        this.c = obj2;
    }
}
