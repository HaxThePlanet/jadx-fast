package androidx.media;

import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public class AudioAttributesImplApi21Parcelizer {
    public static androidx.media.AudioAttributesImplApi21 read(VersionedParcel versionedParcel) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.a = (AudioAttributes)versionedParcel.r(audioAttributesImplApi21.a, 1);
        audioAttributesImplApi21.b = versionedParcel.p(audioAttributesImplApi21.b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(androidx.media.AudioAttributesImplApi21 audioAttributesImplApi21, VersionedParcel versionedParcel2) {
        int i = 0;
        versionedParcel2.x(i, i);
        versionedParcel2.H(audioAttributesImplApi21.a, 1);
        versionedParcel2.F(audioAttributesImplApi21.b, 2);
    }
}
