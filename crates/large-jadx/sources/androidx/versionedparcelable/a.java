package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class a {
    public static <T extends androidx.versionedparcelable.c> T a(Parcelable parcelable) {
        if (!parcelable instanceof ParcelImpl) {
        } else {
            return (ParcelImpl)parcelable.a();
        }
        IllegalArgumentException obj1 = new IllegalArgumentException("Invalid parcel");
        throw obj1;
    }

    public static <T extends androidx.versionedparcelable.c> T b(Bundle bundle, String string2) {
        Parcelable obj1 = bundle.getParcelable(string2);
        if ((Bundle)obj1 == null) {
            try {
                return 0;
                (Bundle)obj1.setClassLoader(a.class.getClassLoader());
                return a.a(obj1.getParcelable("a"));
                return obj0;
            }
        }
    }
}
