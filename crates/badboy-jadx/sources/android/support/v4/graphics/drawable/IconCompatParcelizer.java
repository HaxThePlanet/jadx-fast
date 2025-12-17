package android.support.v4.graphics.drawable;

import androidx.core.graphics.drawable.IconCompat;
import androidx.core.graphics.drawable.IconCompatParcelizer;
import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public final class IconCompatParcelizer extends IconCompatParcelizer {
    public static IconCompat read(VersionedParcel parcel) {
        return IconCompatParcelizer.read(parcel);
    }

    public static void write(IconCompat obj, VersionedParcel parcel) {
        IconCompatParcelizer.write(obj, parcel);
    }
}
