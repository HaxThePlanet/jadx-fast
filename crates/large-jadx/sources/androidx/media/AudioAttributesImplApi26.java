package androidx.media;

import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;

/* loaded from: classes.dex */
public class AudioAttributesImplApi26 extends androidx.media.AudioAttributesImplApi21 {

    static class a extends androidx.media.AudioAttributesImplApi21.a {
        @Override // androidx.media.AudioAttributesImplApi21$a
        public androidx.media.AudioAttributesImpl build() {
            AudioAttributesImplApi26 audioAttributesImplApi26 = new AudioAttributesImplApi26(this.a.build());
            return audioAttributesImplApi26;
        }
    }
    AudioAttributesImplApi26(AudioAttributes audioAttributes) {
        super(audioAttributes, -1);
    }
}
