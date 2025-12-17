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

/* loaded from: classes3.dex */
public final class c implements Serializable {

    private static final long serialVersionUID = 486345450973062467L;
    private final f scale;
    private final double value;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            c.a.a = iArr;
            iArr[f.UT.ordinal()] = 1;
            c.a.a[f.TT.ordinal()] = 2;
            c.a.a[f.POSIX.ordinal()] = 3;
        }
    }
    private c(double d, f f2) {
        super();
        c.a(d, f2);
        this.value = d;
        this.scale = obj3;
    }

    private static void a(double d, f f2) {
        boolean naN;
        long l;
        int i;
        int obj4;
        if (Double.isNaN(d)) {
        } else {
            if (Double.isInfinite(d)) {
            } else {
                int i2 = c.a.a[obj4.ordinal()];
                if (i2 != 1 && i2 != 2) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                        } else {
                        }
                        StringBuilder obj3 = new StringBuilder();
                        obj3.append("Unsupported time scale: ");
                        obj3.append(obj4);
                        IllegalArgumentException obj2 = new IllegalArgumentException(obj3.toString());
                        throw obj2;
                    }
                }
                if (Double.compare(4696756186551156736L, i) > 0) {
                } else {
                    if (Double.compare(d, f2) > 0) {
                    } else {
                    }
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Out of range: ");
                stringBuilder2.append(d);
                obj4 = new IllegalArgumentException(stringBuilder2.toString());
                throw obj4;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Value is not finite: ");
        stringBuilder.append(d);
        obj4 = new IllegalArgumentException(stringBuilder.toString());
        throw obj4;
    }

    static double e(b0 b0, f f2) {
        return i2 /= obj4;
    }

    private static long f(f f) {
        int i;
        int i2 = c.a.a[f.ordinal()];
        if (i2 != 1 && i2 != 2) {
            if (i2 != 2) {
                if (i2 != 3) {
                } else {
                    return 210866760000L;
                }
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(f.name());
                throw unsupportedOperationException;
            }
        }
        return 210929832000L;
    }

    public static net.time4j.calendar.s.c g(double d) {
        c cVar = new c(d, obj3, f.TT);
        return cVar;
    }

    public static net.time4j.calendar.s.c h(b0 b0) {
        final f tT = f.TT;
        c cVar = new c(c.e(b0, tT), obj3, tT);
        return cVar;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        try {
            objectInputStream.defaultReadObject();
            c.a(this.value, obj1);
            objectInputStream = new StreamCorruptedException();
            throw objectInputStream;
            objectInputStream = new StreamCorruptedException();
            throw objectInputStream;
        }
    }

    @Override // java.io.Serializable
    public double b() {
        return i /= l2;
    }

    @Override // java.io.Serializable
    public double c() {
        return value -= l;
    }

    @Override // java.io.Serializable
    public double d() {
        return this.value;
    }

    @Override // java.io.Serializable
    public boolean equals(Object object) {
        int i;
        int scale;
        Object obj8;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof c) {
            if (Double.compare(value, value2) == 0 && this.scale == object.scale) {
                if (this.scale == object.scale) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // java.io.Serializable
    public int hashCode() {
        return i ^= i3;
    }

    @Override // java.io.Serializable
    public b0 i() {
        int i;
        f scale;
        boolean pOSIX;
        f deltaT;
        long l;
        scale = this.scale;
        pOSIX = f.POSIX;
        if (!d.w().A() && scale != pOSIX && scale == f.TT) {
            pOSIX = f.POSIX;
            if (scale != pOSIX) {
                if (scale == f.TT) {
                    g0 g0Var = g0.P0((long)floor, obj5);
                    i -= deltaT;
                }
                i += l;
                scale = pOSIX;
            }
        }
        return b0.o0(c.m((long)i, l), l, (int)i3);
    }

    @Override // java.io.Serializable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("JD(");
        stringBuilder.append(this.scale.name());
        stringBuilder.append(')');
        stringBuilder.append(this.value);
        return stringBuilder.toString();
    }
}
