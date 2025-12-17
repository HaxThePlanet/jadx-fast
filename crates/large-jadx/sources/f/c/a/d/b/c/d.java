package f.c.a.d.b.c;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* loaded from: classes2.dex */
public final class d {
    static {
        d.class.getClassLoader();
    }

    public static <T extends Parcelable> T a(Parcel parcel, Parcelable.Creator<T> parcelable$Creator2) {
        if (parcel.readInt() == 0) {
            return 0;
        }
        return (Parcelable)creator2.createFromParcel(parcel);
    }

    public static void b(Parcel parcel, Parcelable parcelable2) {
        final int i = 0;
        if (parcelable2 == null) {
            parcel.writeInt(i);
        }
        parcel.writeInt(1);
        parcelable2.writeToParcel(parcel, i);
    }

    public static void c(Parcel parcel, IInterface iInterface2) {
        if (iInterface2 == null) {
            parcel.writeStrongBinder(0);
        }
        parcel.writeStrongBinder(iInterface2.asBinder());
    }
}
