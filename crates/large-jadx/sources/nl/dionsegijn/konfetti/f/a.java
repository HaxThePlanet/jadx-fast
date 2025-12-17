package nl.dionsegijn.konfetti.f;

import java.util.Random;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public final class a {

    private float a;
    private Float b;
    private float c;
    private Float d;
    private final Random e;
    public a(Random random) {
        n.f(random, "random");
        super();
        this.e = random;
    }

    public final void a(float f, Float float2) {
        this.a = f;
        this.b = float2;
    }

    public final void b(float f, Float float2) {
        this.c = f;
        this.d = float2;
    }

    public final float c() {
        float f;
        int i;
        float f2;
        if (this.b == null) {
            f = this.a;
        } else {
            Float num2 = this.b;
            n.d(num2);
            f2 = this.a;
            i2 += f2;
        }
        return f;
    }

    public final float d() {
        float f;
        int i;
        float f2;
        if (this.d == null) {
            f = this.c;
        } else {
            Float num2 = this.d;
            n.d(num2);
            f2 = this.c;
            i2 += f2;
        }
        return f;
    }
}
