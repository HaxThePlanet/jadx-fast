package nl.dionsegijn.konfetti.f;

import java.util.Random;
import kotlin.d0.d.n;
import nl.dionsegijn.konfetti.e.d;

/* compiled from: VelocityModule.kt */
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
    }

    public final float a() {
        return this.e;
    }

    public final double b() {
        double d;
        if (this.b == null) {
        } else {
            n.d(this.b);
            d = (this.b.doubleValue() - this.a) * this.h.nextDouble() + this.a;
        }
        return d;
    }

    public final float c() {
        return f3 + (this.g * f3) * (this.h.nextFloat() * 2f) - 1f;
    }

    public final float d() {
        float f;
        if (this.d == null) {
        } else {
            n.d(this.d);
            f = (this.d.floatValue() - this.c) * this.h.nextFloat() + this.c;
        }
        return f;
    }

    public final d e() {
        float f = d();
        double d = b();
        return new d((float)Math.cos(d) * f, f * (float)Math.sin(d));
    }

    public final void f(Double double) {
        this.b = double;
    }

    public final void g(Float float) {
        Float num;
        n.d(float);
        float value = float.floatValue();
        float f = (float)0;
        if (value < f) {
            num = 0f;
        }
        this.d = num;
    }

    public final void h(double d) {
        this.a = d;
    }

    public final void i(float f) {
        int i = 0;
        float f2 = (float)0;
        if (f < f2) {
            i = 0;
        }
        this.c = i;
    }
}
