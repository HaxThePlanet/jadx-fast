package android.support.v4.media;

import androidx.media.AudioAttributesImplApi26;
import androidx.media.AudioAttributesImplApi26Parcelizer;
import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public final class AudioAttributesImplApi26Parcelizer extends AudioAttributesImplApi26Parcelizer {
    public static AudioAttributesImplApi26 read(VersionedParcel versionedParcel) {
        return AudioAttributesImplApi26Parcelizer.read(versionedParcel);
    }

    public static void write(AudioAttributesImplApi26 audioAttributesImplApi26, VersionedParcel versionedParcel2) {
        AudioAttributesImplApi26Parcelizer.write(audioAttributesImplApi26, versionedParcel2);
    }
}
