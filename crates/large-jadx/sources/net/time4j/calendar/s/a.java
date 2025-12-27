package net.time4j.calendar.s;

/* compiled from: AstroUtils.java */
/* loaded from: classes3.dex */
class a {
    static int a(double d) {
        long doubleToLongBits = Double.doubleToLongBits(d);
        return (int)(doubleToLongBits ^ (doubleToLongBits >>> 32L));
    }

    static double b(int i) {
        return Math.pow(1d - (double)i * 0.0065d / 288.15d, 4.255d);
    }

    static double c(double d) {
        double d2;
        final double d4 = 360d;
        while (Double.compare(0.0d, d) > 0) {
            d4 = 360d;
        }
        while (Double.compare(d2, d4) >= 0) {
            d2 = d2 - d4;
        }
        return d2;
    }
}
