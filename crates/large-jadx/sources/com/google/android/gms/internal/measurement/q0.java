package com.google.android.gms.internal.measurement;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class q0 {

    private static final java.lang.ClassLoader a;
    static {
        q0.a = q0.class.getClassLoader();
    }

    public static <T extends Parcelable> T a(Parcel parcel, Parcelable.Creator<T> parcelable$Creator2) {
        if (parcel.readInt() == 0) {
            return 0;
        }
        return (Parcelable)creator2.createFromParcel(parcel);
    }

    public static HashMap b(Parcel parcel) {
        return parcel.readHashMap(q0.a);
    }

    public static void c(Parcel parcel, boolean z2) {
        parcel.writeInt(z2);
    }

    public static void d(Parcel parcel, Parcelable parcelable2) {
        final int i = 0;
        if (parcelable2 == null) {
            parcel.writeInt(i);
        }
        parcel.writeInt(1);
        parcelable2.writeToParcel(parcel, i);
    }

    public static void e(Parcel parcel, IInterface iInterface2) {
        if (iInterface2 == null) {
            parcel.writeStrongBinder(0);
        }
        parcel.writeStrongBinder(iInterface2.asBinder());
    }

    public static boolean f(Parcel parcel) {
        if (parcel.readInt() != 0) {
            return 1;
        }
        return 0;
    }
}
