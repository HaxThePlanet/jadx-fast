package net.time4j.calendar.s;

import java.io.Serializable;

/* compiled from: MoonPosition.java */
/* loaded from: classes3.dex */
public class e implements Serializable {

    private static final long serialVersionUID = 5736859564589473324L;
    private final double azimuth;
    private final double declination;
    private final double distance;
    private final double elevation;
    private final double rightAscension;
    static double a(double d) {
        return e.e((0.000014347408140719379d - (0.00000006797172376291463d * d)) * d + 0.0087414d * d + 477198.8675055d * d + 134.9633964d);
    }

    static double b(double d) {
        return e.e((0.00000004083299305839118d * d) - 4673573173058501770L * d + 35999.0502909d * d + 357.5291092d);
    }

    static double c(double d) {
        return e.e((0.0000018319447192361523d - (0.000000008844469995135542d * d)) * d - 4657050482037755355L * d + 445267.1114034d * d + 297.8501921d);
    }

    private static int d(double d) {
        long doubleToLongBits = Double.doubleToLongBits(d);
        return (int)(doubleToLongBits ^ (doubleToLongBits >>> 32L));
    }

    private static double e(double d) {
        final double d2 = 360d;
        return d - (Math.floor(d / d2)) * d2;
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        int cmp;
        double rightAscension2;
        double rightAscension22;
        int cmp2;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof e) {
            if (this.rightAscension == object.rightAscension) {
                if (this.declination == object.declination) {
                    if (this.azimuth == object.azimuth) {
                        if (this.elevation == object.elevation) {
                            if (this.distance != object.distance) {
                            }
                        }
                    }
                }
            }
            return z;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (e.d(this.rightAscension) + (e.d(this.declination) * 31)) + (e.d(this.distance) * 37);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(100);
        String str2 = "moon-position[ra=";
        String str3 = ",decl=";
        String str4 = ",azimuth=";
        String str5 = ",elevation=";
        String str6 = ",distance=";
        str = 100 + str2 + this.rightAscension + str3 + this.declination + str4 + this.azimuth + str5 + this.elevation + str6 + this.distance + 93;
        return str;
    }

}
