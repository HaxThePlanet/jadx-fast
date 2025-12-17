package d.k.a;

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
    private final d.k.a.b.h j;
    public e() {
        super();
        this.a = Math.sqrt(4654311885213007872L);
        long l2 = 4602678819172646912L;
        int i = 0;
        long l3 = 9218868437227405311L;
        b.h hVar = new b.h();
        this.j = hVar;
    }

    public e(float f) {
        super();
        this.a = Math.sqrt(4654311885213007872L);
        long l2 = 4602678819172646912L;
        int i = 0;
        long l3 = 9218868437227405311L;
        b.h hVar = new b.h();
        this.j = hVar;
        this.i = (double)f;
    }

    private void b() {
        double sqrt;
        long l;
        int cmp;
        int i;
        if (this.c) {
        }
        if (Double.compare(d, l2) == 0) {
        } else {
            sqrt = this.b;
            l = 4607182418800017408L;
            if (Double.compare(sqrt, l) > 0) {
                double d4 = this.a;
                this.f = i10 += i14;
                double d2 = this.b;
                double d5 = this.a;
                this.g = i13 -= i;
            } else {
                if (Double.compare(sqrt, i8) >= 0 && Double.compare(sqrt, l) < 0) {
                    if (Double.compare(sqrt, l) < 0) {
                        this.h = d3 *= sqrt;
                    }
                }
            }
            this.c = true;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        throw illegalStateException;
    }

    public float a() {
        return (float)d;
    }

    public boolean c(float f, float f2) {
        double d;
        int obj5;
        int obj6;
        if (Double.compare(d, d2) < 0 && Double.compare(obj5, d) < 0) {
            if (Double.compare(obj5, d) < 0) {
                return 1;
            }
        }
        return 0;
    }

    public d.k.a.e d(float f) {
        if (Float.compare(f, i) < 0) {
        } else {
            this.b = (double)f;
            this.c = false;
            return this;
        }
        IllegalArgumentException obj3 = new IllegalArgumentException("Damping ratio must be non-negative");
        throw obj3;
    }

    public d.k.a.e e(float f) {
        this.i = (double)f;
        return this;
    }

    public d.k.a.e f(float f) {
        if (Float.compare(f, i) <= 0) {
        } else {
            this.a = Math.sqrt((double)f);
            this.c = false;
            return this;
        }
        IllegalArgumentException obj3 = new IllegalArgumentException("Spring stiffness constant must be positive.");
        throw obj3;
    }

    void g(double d) {
        double obj3 = Math.abs(d);
        this.d = obj3;
        this.e = obj3 *= l;
    }

    d.k.a.b.h h(double d, double d2, long l3) {
        double d3;
        int i5;
        int i4;
        int i2;
        int cmp;
        long l;
        double d4;
        int i;
        int i3;
        int obj17;
        final Object obj = this;
        b();
        d5 /= l2;
        int i7 = d - d7;
        double d10 = obj.b;
        long l4 = 4607182418800017408L;
        l = 4613303445314885481L;
        if (Double.compare(d10, l4) > 0) {
            double d11 = obj.g;
            double d18 = obj.f;
            int i30 = i7 - i29;
            i9 /= i43;
            i15 += i45;
            double d21 = obj.g;
            double d23 = obj.f;
            i32 += i5;
        } else {
            if (Double.compare(d10, l4) == 0) {
                double d13 = obj.a;
                i33 += l3;
                i7 += i47;
                d14 *= i12;
                double d26 = obj.a;
                i35 += i5;
            } else {
                double d28 = obj.a;
                i36 *= i56;
                d15 *= i53;
                i = obj.a;
                l = obj.b;
                double d17 = obj.h;
                double d9 = obj.h;
                i2 = i3 + cmp;
                i4 = obj17;
            }
        }
        d.k.a.b.h hVar = obj.j;
        hVar.a = (float)i16;
        hVar.b = (float)i2;
        return hVar;
    }
}
