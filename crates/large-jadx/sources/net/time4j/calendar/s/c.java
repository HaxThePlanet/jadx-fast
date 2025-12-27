package net.time4j.calendar.s;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import net.time4j.b0;
import net.time4j.engine.z;
import net.time4j.f1.c;
import net.time4j.g0;
import net.time4j.i1.d;
import net.time4j.i1.f;

/* compiled from: JulianDay.java */
/* loaded from: classes3.dex */
public final class c implements Serializable {

    private static final long serialVersionUID = 486345450973062467L;
    private final f scale;
    private final double value;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[f.values().length];
            c.a.a = iArr;
            try {
                iArr[f.UT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                c.a.a[f.TT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                c.a.a[f.POSIX.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    private c(double d, f fVar) {
        super();
        c.a(d, fVar);
        this.value = d;
        this.scale = fVar;
    }

    private static void a(double d, f fVar) {
        int i = 1;
        if (Double.isNaN(d)) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Value is not finite: ";
            d = str2 + d;
            throw new IllegalArgumentException(d);
        } else {
            if (!Double.isInfinite(d)) {
                int i2 = c.a.a[fVar.ordinal()];
                i = 1;
                long l = 4696756186551156736L;
                if (Double.compare(l, d) > 0) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    String str3 = "Out of range: ";
                    d = str3 + d;
                    throw new IllegalArgumentException(d);
                } else {
                    if (Double.compare(d, 2817152d) <= 0) {
                        return;
                    }
                }
            }
        }
    }

    static double e(b0 b0Var, f fVar) {
        return (double)(b0Var.f(fVar) + c.f(fVar)) + (double)b0Var.n(fVar) / 1000000000d / 86400d;
    }

    private static long f(f fVar) {
        int i2 = c.a.a[fVar.ordinal()];
        int i = 1;
        if (c.a.a != 1 && c.a.a != 2 && c.a.a == 3) {
            return 210866760000L;
        }
        return 210929832000L;
    }

    public static c g(double d) {
        return new c(d, r3, f.TT);
    }

    public static c h(b0 b0Var) {
        final f tT2 = f.TT;
        return new c(c.e(b0Var, tT2), r3, tT2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws java.io.IOException, StreamCorruptedException {
        try {
            objectInputStream.defaultReadObject();
            c.a(this.value, this.scale);
        } catch (java.lang.IllegalArgumentException unused) {
            objectInputStream = new StreamCorruptedException();
            throw objectInputStream;
        } catch (java.lang.ClassNotFoundException unused) {
            objectInputStream = new StreamCorruptedException();
            throw objectInputStream;
        }
    }

    public double b() {
        return (this.value - 2451545d) / 36525d;
    }

    public double c() {
        return this.value - 2400000.5d;
    }

    public double d() {
        return this.value;
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        int cmp;
        f scale2;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof c) {
            if (this.value == object.value) {
                if (this.scale != object.scale) {
                }
            }
            return z;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return a.a(this.value) ^ this.scale.hashCode();
    }

    public b0 i() {
        double d;
        f scale2;
        long l5 = 4723734190397325312L;
        d = this.value * 86400d;
        if (!d.w().A() && this.scale != f.POSIX && this.scale == f.TT) {
            g0 g0Var = g0.P0((long)Math.floor(c()), z.MODIFIED_JULIAN_DATE);
            d = (this.value * 4680673776000565248L) - (f.deltaT(g0Var.m(), g0Var.o()));
            d = d + 63072000d;
        }
        return b0.o0(c.m((long)d, c.f(scale2)), (int)(d - Math.floor(d)) * 1000000000d, scale2);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "JD(";
        String name = this.scale.name();
        str = str2 + name + 41 + this.value;
        return str;
    }
}
