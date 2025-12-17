package android.support.v4.media;

import androidx.media.AudioAttributesImplApi21;
import androidx.media.AudioAttributesImplApi21Parcelizer;
import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public final class AudioAttributesImplApi21Parcelizer extends AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(VersionedParcel versionedParcel) {
        return AudioAttributesImplApi21Parcelizer.read(versionedParcel);
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, VersionedParcel versionedParcel2) {
        AudioAttributesImplApi21Parcelizer.write(audioAttributesImplApi21, versionedParcel2);
    }
}
