package d.k.a;

/* compiled from: SpringForce.java */
/* loaded from: classes.dex */
public final class e {

    double a;
    double b = 0.5d;
    private boolean c = false;
    private double d;
    private double e;
    private double f;
    private double g;
    private double h;
    private double i = 179769313486231570000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000d;
    private final b.h j = new b$h();
    public e() {
        super();
        this.a = Math.sqrt(1500d);
        d.k.a.b.h hVar = new b.h();
    }

    private void b() {
        if (this.c) {
            return;
        }
        if (this.i == 9218868437227405311L) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        } else {
            double d = 1d;
            if (this.b > d) {
                this.f = (-sqrt * d18) + (d18 * (Math.sqrt((sqrt * sqrt) - d)));
                d2 = d20 * (Math.sqrt((d7 * d7) - d));
                this.g = (-d7 * d20) - d2;
            } else {
                if (this.b >= 0) {
                    if (this.b < d) {
                        d = d - (sqrt * sqrt);
                        this.h = this.a * Math.sqrt(d);
                    }
                }
            }
            this.c = true;
            return;
        }
    }

    public float a() {
        return (float)this.i;
    }

    public boolean c(float f, float f2) {
        d = (double)Math.abs(f2);
        if (d < this.e) {
            double d3 = (double)(Math.abs(f - a()));
            if (d3 < this.d) {
                return true;
            }
        }
        return false;
    }

    public e d(float f) {
        if (f < 0) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        } else {
            this.b = (double)f;
            this.c = false;
            return this;
        }
    }

    public e e(float f) {
        this.i = (double)f;
        return this;
    }

    public e f(float f) {
        if (f <= 0) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        } else {
            this.a = Math.sqrt((double)f);
            this.c = false;
            return this;
        }
    }

    void g(double d) {
        double abs = Math.abs(d);
        this.d = abs;
        this.e = abs * 62.5d;
    }

    b.h h(double d, double d2, long j) {
        double d4;
        double d5;
        final Object d9 = this;
        b();
        double d11 = (double)j / 1000d;
        double d14 = d - d9.i;
        double d35 = 1d;
        long l = 4613303445314885481L;
        if (d9.b > d35) {
            d8 = d24 - d55;
            double d39 = d14 - (d24 * d14) - d2 / d8;
            double d17 = (d14 * d24) - d2 / (d24 - d55);
            d4 = (Math.pow(l, d24 * d11)) * d39 + (Math.pow(l, d9.f * d11)) * d17;
            d7 = d62 * d11;
            d3 = (d17 * d62) * (Math.pow(l, d7));
            d5 = (d39 * d60) * (Math.pow(l, d60 * d11)) + d3;
        } else {
            if (d9.b == d35) {
                double d43 = d2 + (d28 * d14);
                d14 += d63;
                d4 = (Math.pow(l, -d28 * d11)) * d19;
                d3 = (d19 * (Math.pow(l, -d9.a * d11))) * (-d66);
                d7 = -d66 * d11;
                d5 = (d43 * (Math.pow(l, d7))) + d3;
            } else {
                double d46 = (d35 / d9.h) * (d23 * d68) * d14 + d2;
                d4 = (Math.pow(l, (-d23 * d68) * d11)) * (Math.cos(d9.h * d11)) * d14 + (Math.sin(d9.h * d11)) * d46;
                d8 = (-d7 * d4) * d52;
                d6 = d54 * d11;
                d3 = d21 * d11;
                d5 = d8 + (Math.pow(2.718281828459045d, (-d52 * d7) * d11)) * (-d54 * d14) * Math.sin(d6) + (d46 * d21) * Math.cos(d3);
            }
        }
        d9.j.a = (float)(d4 + d9.i);
        d9.j.b = (float)d5;
        return d9.j;
    }

    public e(float f) {
        super();
        this.a = Math.sqrt(1500d);
        d.k.a.b.h hVar = new b.h();
        this.i = (double)f;
    }
}
