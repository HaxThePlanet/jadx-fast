package f.c.a.d.b.a;

import android.os.Parcel;

/* loaded from: classes2.dex */
public class c {
    static {
        c.class.getClassLoader();
    }

    private c() {
        super();
    }

    public static void a(Parcel parcel, boolean z) {
        parcel.writeInt(1);
    }

    public static boolean b(Parcel parcel) {
        if (parcel.readInt() != 0) {
            return true;
        }
        return false;
    }
}
