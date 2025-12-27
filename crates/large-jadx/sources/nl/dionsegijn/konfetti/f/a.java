package nl.dionsegijn.konfetti.f;

import java.util.Random;
import kotlin.d0.d.n;

/* compiled from: LocationModule.kt */
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

    public final void a(float f, Float float) {
        this.a = f;
        this.b = float;
    }

    public final void b(float f, Float float) {
        this.c = f;
        this.d = float;
    }

    public final float c() {
        float f;
        if (this.b == null) {
        } else {
            n.d(this.b);
            f2 = this.b.floatValue() - f3;
            f = (this.e.nextFloat() * f2) + f3;
        }
        return f;
    }

    public final float d() {
        float f;
        if (this.d == null) {
        } else {
            n.d(this.d);
            f2 = this.d.floatValue() - f3;
            f = (this.e.nextFloat() * f2) + f3;
        }
        return f;
    }
}
