package android.support.v4.app;

import androidx.core.app.RemoteActionCompat;
import androidx.core.app.RemoteActionCompatParcelizer;
import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public final class RemoteActionCompatParcelizer extends RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(VersionedParcel parcel) {
        return RemoteActionCompatParcelizer.read(parcel);
    }

    public static void write(RemoteActionCompat obj, VersionedParcel parcel) {
        RemoteActionCompatParcelizer.write(obj, parcel);
    }
}
