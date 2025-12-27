package f.c.a.d.b.j;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* loaded from: classes2.dex */
public class c {
    static {
        c.class.getClassLoader();
    }

    private c() {
        super();
    }

    public static <T extends Parcelable> T a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable)creator.createFromParcel(parcel);
    }

    public static void b(Parcel parcel, IInterface iInterface) {
        android.os.IBinder binder = null;
        if (iInterface == null) {
            int i = 0;
        } else {
            binder = iInterface.asBinder();
        }
        parcel.writeStrongBinder(binder);
    }

    public static boolean c(Parcel parcel) {
        if (parcel.readInt() != 0) {
            return true;
        }
        return false;
    }
}
