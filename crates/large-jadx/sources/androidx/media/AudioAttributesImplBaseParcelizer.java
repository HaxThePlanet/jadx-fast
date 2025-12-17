package androidx.media;

import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public class AudioAttributesImplBaseParcelizer {
    public static androidx.media.AudioAttributesImplBase read(VersionedParcel versionedParcel) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.a = versionedParcel.p(audioAttributesImplBase.a, 1);
        audioAttributesImplBase.b = versionedParcel.p(audioAttributesImplBase.b, 2);
        audioAttributesImplBase.c = versionedParcel.p(audioAttributesImplBase.c, 3);
        audioAttributesImplBase.d = versionedParcel.p(audioAttributesImplBase.d, 4);
        return audioAttributesImplBase;
    }

    public static void write(androidx.media.AudioAttributesImplBase audioAttributesImplBase, VersionedParcel versionedParcel2) {
        int i = 0;
        versionedParcel2.x(i, i);
        versionedParcel2.F(audioAttributesImplBase.a, 1);
        versionedParcel2.F(audioAttributesImplBase.b, 2);
        versionedParcel2.F(audioAttributesImplBase.c, 3);
        versionedParcel2.F(audioAttributesImplBase.d, 4);
    }
}
