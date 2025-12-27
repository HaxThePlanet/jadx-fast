package f.c.a.d.b.g;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* loaded from: classes2.dex */
public final class c {
    static {
        c.class.getClassLoader();
    }

    public static boolean a(Parcel parcel) {
        if (parcel.readInt() != 0) {
            return true;
        }
        return false;
    }

    public static void b(Parcel parcel, boolean z) {
        parcel.writeInt(z);
    }

    public static <T extends Parcelable> T c(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable)creator.createFromParcel(parcel);
    }

    public static void d(Parcel parcel, Parcelable parcelable) {
        final int i = 0;
        if (parcelable == null) {
            parcel.writeInt(i);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, i);
    }

    public static void e(Parcel parcel, IInterface iInterface) {
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
            return;
        }
        parcel.writeStrongBinder(iInterface.asBinder());
    }

    private c() {
        super();
    }
}
