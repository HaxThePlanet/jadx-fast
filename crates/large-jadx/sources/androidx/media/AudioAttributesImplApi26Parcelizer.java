package androidx.media;

import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public class AudioAttributesImplApi26Parcelizer {
    public static androidx.media.AudioAttributesImplApi26 read(VersionedParcel versionedParcel) {
        AudioAttributesImplApi26 audioAttributesImplApi26 = new AudioAttributesImplApi26();
        audioAttributesImplApi26.a = (AudioAttributes)versionedParcel.r(audioAttributesImplApi26.a, 1);
        audioAttributesImplApi26.b = versionedParcel.p(audioAttributesImplApi26.b, 2);
        return audioAttributesImplApi26;
    }

    public static void write(androidx.media.AudioAttributesImplApi26 audioAttributesImplApi26, VersionedParcel versionedParcel2) {
        int i = 0;
        versionedParcel2.x(i, i);
        versionedParcel2.H(audioAttributesImplApi26.a, 1);
        versionedParcel2.F(audioAttributesImplApi26.b, 2);
    }
}
