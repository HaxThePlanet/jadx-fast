package android.support.v4.media;

import androidx.media.AudioAttributesImplBase;
import androidx.media.AudioAttributesImplBaseParcelizer;
import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public final class AudioAttributesImplBaseParcelizer extends AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(VersionedParcel versionedParcel) {
        return AudioAttributesImplBaseParcelizer.read(versionedParcel);
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, VersionedParcel versionedParcel2) {
        AudioAttributesImplBaseParcelizer.write(audioAttributesImplBase, versionedParcel2);
    }
}
