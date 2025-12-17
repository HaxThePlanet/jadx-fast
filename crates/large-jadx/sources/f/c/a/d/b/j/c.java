package f.c.a.d.b.j;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

/* loaded from: classes2.dex */
public class c {
    static {
        c.class.getClassLoader();
    }

    public static <T extends android.os.Parcelable> T a(Parcel parcel, Parcelable.Creator<T> parcelable$Creator2) {
        if (parcel.readInt() == 0) {
            return 0;
        }
        return (Parcelable)creator2.createFromParcel(parcel);
    }

    public static void b(Parcel parcel, IInterface iInterface2) {
        int obj1;
        if (iInterface2 == null) {
            obj1 = 0;
        } else {
            obj1 = iInterface2.asBinder();
        }
        parcel.writeStrongBinder(obj1);
    }

    public static boolean c(Parcel parcel) {
        if (parcel.readInt() != 0) {
            return 1;
        }
        return 0;
    }
}
