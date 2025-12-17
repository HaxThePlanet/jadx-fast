package android.support.v4.media;

import androidx.media.AudioAttributesCompat;
import androidx.media.AudioAttributesCompatParcelizer;
import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public final class AudioAttributesCompatParcelizer extends AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(VersionedParcel versionedParcel) {
        return AudioAttributesCompatParcelizer.read(versionedParcel);
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, VersionedParcel versionedParcel2) {
        AudioAttributesCompatParcelizer.write(audioAttributesCompat, versionedParcel2);
    }
}
