package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.a;

/* loaded from: classes2.dex */
public final class ea extends a {

    public static final Parcelable.Creator<com.google.android.gms.measurement.internal.ea> CREATOR;
    public final int a;
    public final String b;
    public final long c;
    public final Long v;
    public final String w;
    public final String x;
    public final Double y;
    static {
        fa faVar = new fa();
        ea.CREATOR = faVar;
    }

    ea(int i, String string2, long l3, Long long4, Float float5, String string6, String string7, Double double8) {
        int obj1;
        super();
        this.a = i;
        this.b = string2;
        this.c = l3;
        this.v = float5;
        final int obj2 = 1;
        if (i == obj2) {
            if (string6 != null) {
                obj1 = Double.valueOf(string6.doubleValue());
            } else {
                obj1 = 0;
            }
            this.y = obj1;
        } else {
            this.y = obj9;
        }
        this.w = string7;
        this.x = double8;
    }

    ea(com.google.android.gms.measurement.internal.ga ga) {
        super(ga.c, ga.d, obj3, ga.e, ga.b);
    }

    ea(String string, long l2, Object object3, String string4) {
        super();
        r.f(string);
        this.a = 2;
        this.b = string;
        this.c = l2;
        this.x = obj6;
        int obj2 = 0;
        if (string4 == null) {
            this.v = obj2;
            this.y = obj2;
            this.w = obj2;
        }
        if (string4 instanceof Long) {
            this.v = (Long)string4;
            this.y = obj2;
            this.w = obj2;
        }
        if (string4 instanceof String != null) {
            this.v = obj2;
            this.y = obj2;
            this.w = (String)string4;
        }
        if (!string4 instanceof Double) {
        } else {
            this.v = obj2;
            this.y = (Double)string4;
            this.w = obj2;
        }
        obj2 = new IllegalArgumentException("User attribute given of un-supported type");
        throw obj2;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final Object j2() {
        Long num = this.v;
        if (num != null) {
            return num;
        }
        Double num2 = this.y;
        if (num2 != null) {
            return num2;
        }
        String str = this.w;
        if (str != null) {
            return str;
        }
        return null;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        fa.a(this, parcel, i2);
    }
}
