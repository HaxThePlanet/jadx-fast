package f.c.a.d.b.i;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* loaded from: classes2.dex */
public final class g {
    static {
        g.class.getClassLoader();
    }

    public static <T extends Parcelable> T a(Parcel parcel, Parcelable.Creator<T> parcelable$Creator2) {
        if (parcel.readInt() == 0) {
            return 0;
        }
        return (Parcelable)creator2.createFromParcel(parcel);
    }

    public static void b(Parcel parcel, Parcelable parcelable2) {
        parcel.writeInt(1);
        parcelable2.writeToParcel(parcel, 0);
    }
}
