package f.c.a.d.b.b;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

/* loaded from: classes2.dex */
public class d {
    static {
        d.class.getClassLoader();
    }

    public static <T extends android.os.Parcelable> T a(Parcel parcel, Parcelable.Creator<T> parcelable$Creator2) {
        if (parcel.readInt() == 0) {
            return 0;
        }
        return (Parcelable)creator2.createFromParcel(parcel);
    }

    public static void b(Parcel parcel, IInterface iInterface2) {
        if (iInterface2 == null) {
            parcel.writeStrongBinder(0);
        }
        parcel.writeStrongBinder(iInterface2.asBinder());
    }
}
