package androidx.media;

import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;

/* loaded from: classes.dex */
public class AudioAttributesImplApi21 implements androidx.media.AudioAttributesImpl {

    public AudioAttributes a;
    public int b;

    static class a implements androidx.media.AudioAttributesImpl.a {

        final AudioAttributes.Builder a;
        a() {
            super();
            AudioAttributes.Builder builder = new AudioAttributes.Builder();
            this.a = builder;
        }

        @Override // androidx.media.AudioAttributesImpl$a
        public androidx.media.AudioAttributesImpl.a a(int i) {
            b(i);
            return this;
        }

        @Override // androidx.media.AudioAttributesImpl$a
        public androidx.media.AudioAttributesImplApi21.a b(int i) {
            this.a.setLegacyStreamType(i);
            return this;
        }

        @Override // androidx.media.AudioAttributesImpl$a
        public androidx.media.AudioAttributesImpl build() {
            AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21(this.a.build());
            return audioAttributesImplApi21;
        }
    }
    public AudioAttributesImplApi21() {
        super();
        this.b = -1;
    }

    AudioAttributesImplApi21(AudioAttributes audioAttributes) {
        super(audioAttributes, -1);
    }

    AudioAttributesImplApi21(AudioAttributes audioAttributes, int i2) {
        super();
        this.b = -1;
        this.a = audioAttributes;
        this.b = i2;
    }

    @Override // androidx.media.AudioAttributesImpl
    public boolean equals(Object object) {
        if (!object instanceof AudioAttributesImplApi21) {
            return 0;
        }
        return this.a.equals(object.a);
    }

    @Override // androidx.media.AudioAttributesImpl
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // androidx.media.AudioAttributesImpl
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AudioAttributesCompat: audioattributes=");
        stringBuilder.append(this.a);
        return stringBuilder.toString();
    }
}
