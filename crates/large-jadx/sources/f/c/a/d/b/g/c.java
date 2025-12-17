package f.c.a.d.b.g;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* loaded from: classes2.dex */
public final class c {
    static {
        c.class.getClassLoader();
    }

    public static boolean a(Parcel parcel) {
        if (parcel.readInt() != 0) {
            return 1;
        }
        return 0;
    }

    public static void b(Parcel parcel, boolean z2) {
        parcel.writeInt(z2);
    }

    public static <T extends Parcelable> T c(Parcel parcel, Parcelable.Creator<T> parcelable$Creator2) {
        if (parcel.readInt() == 0) {
            return 0;
        }
        return (Parcelable)creator2.createFromParcel(parcel);
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
}
