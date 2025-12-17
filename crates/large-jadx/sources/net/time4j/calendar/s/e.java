package net.time4j.calendar.s;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class e implements Serializable {

    private static final long serialVersionUID = 5736859564589473324L;
    private final double azimuth;
    private final double declination;
    private final double distance;
    private final double elevation;
    private final double rightAscension;
    static {
    }

    static double a(double d) {
        return e.e(i7 += obj4);
    }

    static double b(double d) {
        return e.e(i5 += obj4);
    }

    static double c(double d) {
        return e.e(i7 += obj4);
    }

    private static int d(double d) {
        long obj2 = Double.doubleToLongBits(d);
        return (int)obj2;
    }

    private static double e(double d) {
        final long l = 4645040803167600640L;
        return d -= i2;
    }

    @Override // java.io.Serializable
    public boolean equals(Object object) {
        int i;
        int cmp;
        double rightAscension2;
        double rightAscension;
        Object obj8;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof e) {
            if (Double.compare(rightAscension2, rightAscension) == 0 && Double.compare(rightAscension2, rightAscension) == 0 && Double.compare(rightAscension2, rightAscension) == 0 && Double.compare(rightAscension2, rightAscension) == 0 && Double.compare(rightAscension2, rightAscension) == 0) {
                if (Double.compare(rightAscension2, rightAscension) == 0) {
                    if (Double.compare(rightAscension2, rightAscension) == 0) {
                        if (Double.compare(rightAscension2, rightAscension) == 0) {
                            if (Double.compare(rightAscension2, rightAscension) == 0) {
                            } else {
                                i = i2;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // java.io.Serializable
    public int hashCode() {
        return i2 += i7;
    }

    @Override // java.io.Serializable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(100);
        stringBuilder.append("moon-position[ra=");
        stringBuilder.append(this.rightAscension);
        stringBuilder.append(",decl=");
        stringBuilder.append(this.declination);
        stringBuilder.append(",azimuth=");
        stringBuilder.append(this.azimuth);
        stringBuilder.append(",elevation=");
        stringBuilder.append(this.elevation);
        stringBuilder.append(",distance=");
        stringBuilder.append(this.distance);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
