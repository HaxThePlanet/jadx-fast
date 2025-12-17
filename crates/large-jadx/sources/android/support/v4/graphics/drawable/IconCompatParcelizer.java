package android.support.v4.graphics.drawable;

import androidx.core.graphics.drawable.IconCompat;
import androidx.core.graphics.drawable.IconCompatParcelizer;
import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public final class IconCompatParcelizer extends IconCompatParcelizer {
    public static IconCompat read(VersionedParcel versionedParcel) {
        return IconCompatParcelizer.read(versionedParcel);
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel2) {
        IconCompatParcelizer.write(iconCompat, versionedParcel2);
    }
}
