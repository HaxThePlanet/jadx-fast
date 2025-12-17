package android.support.v4.app;

import androidx.core.app.RemoteActionCompat;
import androidx.core.app.RemoteActionCompatParcelizer;
import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public final class RemoteActionCompatParcelizer extends RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(VersionedParcel versionedParcel) {
        return RemoteActionCompatParcelizer.read(versionedParcel);
    }

    public static void write(RemoteActionCompat remoteActionCompat, VersionedParcel versionedParcel2) {
        RemoteActionCompatParcelizer.write(remoteActionCompat, versionedParcel2);
    }
}
