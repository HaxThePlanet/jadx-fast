package androidx.core.app;

import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static androidx.core.app.RemoteActionCompat read(VersionedParcel versionedParcel) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.a = (IconCompat)versionedParcel.v(remoteActionCompat.a, 1);
        remoteActionCompat.b = versionedParcel.l(remoteActionCompat.b, 2);
        remoteActionCompat.c = versionedParcel.l(remoteActionCompat.c, 3);
        remoteActionCompat.d = (PendingIntent)versionedParcel.r(remoteActionCompat.d, 4);
        remoteActionCompat.e = versionedParcel.h(remoteActionCompat.e, 5);
        remoteActionCompat.f = versionedParcel.h(remoteActionCompat.f, 6);
        return remoteActionCompat;
    }

    public static void write(androidx.core.app.RemoteActionCompat remoteActionCompat, VersionedParcel versionedParcel2) {
        int i = 0;
        versionedParcel2.x(i, i);
        versionedParcel2.M(remoteActionCompat.a, 1);
        versionedParcel2.D(remoteActionCompat.b, 2);
        versionedParcel2.D(remoteActionCompat.c, 3);
        versionedParcel2.H(remoteActionCompat.d, 4);
        versionedParcel2.z(remoteActionCompat.e, 5);
        versionedParcel2.z(remoteActionCompat.f, 6);
    }
}
