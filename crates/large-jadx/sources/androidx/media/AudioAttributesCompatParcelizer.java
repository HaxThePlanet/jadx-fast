package androidx.media;

import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public class AudioAttributesCompatParcelizer {
    public static androidx.media.AudioAttributesCompat read(VersionedParcel versionedParcel) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.a = (AudioAttributesImpl)versionedParcel.v(audioAttributesCompat.a, 1);
        return audioAttributesCompat;
    }

    public static void write(androidx.media.AudioAttributesCompat audioAttributesCompat, VersionedParcel versionedParcel2) {
        int i = 0;
        versionedParcel2.x(i, i);
        versionedParcel2.M(audioAttributesCompat.a, 1);
    }
}
