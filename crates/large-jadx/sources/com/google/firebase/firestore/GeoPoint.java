package com.google.firebase.firestore;

import com.google.firebase.firestore.util.Util;

/* loaded from: classes2.dex */
public class GeoPoint implements Comparable<com.google.firebase.firestore.GeoPoint> {

    private final double latitude;
    private final double longitude;
    public GeoPoint(double d, double d2) {
        boolean naN2;
        boolean naN;
        super();
        if (Double.isNaN(d)) {
        } else {
            if (Double.compare(d, l) < 0) {
            } else {
                if (Double.compare(d, l2) > 0) {
                } else {
                    if (Double.isNaN(obj5)) {
                    } else {
                        if (Double.compare(obj5, l3) < 0) {
                        } else {
                            if (Double.compare(obj5, l4) > 0) {
                            } else {
                                this.latitude = d;
                                this.longitude = obj5;
                            }
                        }
                    }
                    IllegalArgumentException obj3 = new IllegalArgumentException("Longitude must be in the range of [-180, 180]");
                    throw obj3;
                }
            }
        }
        obj3 = new IllegalArgumentException("Latitude must be in the range of [-90, 90]");
        throw obj3;
    }

    @Override // java.lang.Comparable
    public int compareTo(com.google.firebase.firestore.GeoPoint geoPoint) {
        int compareDoubles = Util.compareDoubles(this.latitude, obj1);
        if (compareDoubles == 0) {
            return Util.compareDoubles(this.longitude, obj1);
        }
        return compareDoubles;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object object) {
        return compareTo((GeoPoint)object);
    }

    @Override // java.lang.Comparable
    public boolean equals(Object object) {
        int i;
        double longitude2;
        double longitude;
        Object obj7;
        if (!object instanceof GeoPoint) {
            return 0;
        }
        if (Double.compare(longitude2, longitude) == 0 && Double.compare(longitude2, longitude) == 0) {
            if (Double.compare(longitude2, longitude) == 0) {
                i = 1;
            }
        }
        return i;
    }

    @Override // java.lang.Comparable
    public double getLatitude() {
        return this.latitude;
    }

    @Override // java.lang.Comparable
    public double getLongitude() {
        return this.longitude;
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.latitude);
        final int i8 = 32;
        long doubleToLongBits2 = Double.doubleToLongBits(this.longitude);
        return i3 += i7;
    }

    @Override // java.lang.Comparable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GeoPoint { latitude=");
        stringBuilder.append(this.latitude);
        stringBuilder.append(", longitude=");
        stringBuilder.append(this.longitude);
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}
