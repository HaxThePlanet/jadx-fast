package androidx.media;

import android.os.Build.VERSION;
import android.util.SparseIntArray;
import androidx.versionedparcelable.c;

/* loaded from: classes.dex */
public class AudioAttributesCompat implements c {

    private static final SparseIntArray b;
    static boolean c;
    public androidx.media.AudioAttributesImpl a;

    public static class a {

        final androidx.media.AudioAttributesImpl.a a;
        public a() {
            Object aVar;
            int i;
            super();
            if (AudioAttributesCompat.c) {
                aVar = new AudioAttributesImplBase.a();
                this.a = aVar;
            } else {
                int sDK_INT = Build.VERSION.SDK_INT;
                if (sDK_INT >= 26) {
                    aVar = new AudioAttributesImplApi26.a();
                    this.a = aVar;
                } else {
                    if (sDK_INT >= 21) {
                        aVar = new AudioAttributesImplApi21.a();
                        this.a = aVar;
                    } else {
                        aVar = new AudioAttributesImplBase.a();
                        this.a = aVar;
                    }
                }
            }
        }

        public androidx.media.AudioAttributesCompat a() {
            AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat(this.a.build());
            return audioAttributesCompat;
        }

        public androidx.media.AudioAttributesCompat.a b(int i) {
            this.a.a(i);
            return this;
        }
    }
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        AudioAttributesCompat.b = sparseIntArray;
        final int i7 = 1;
        sparseIntArray.put(5, i7);
        final int i8 = 2;
        sparseIntArray.put(6, i8);
        sparseIntArray.put(7, i8);
        sparseIntArray.put(8, i7);
        sparseIntArray.put(9, i7);
        sparseIntArray.put(10, i7);
    }

    AudioAttributesCompat(androidx.media.AudioAttributesImpl audioAttributesImpl) {
        super();
        this.a = audioAttributesImpl;
    }

    static int a(boolean z, int i2, int i3) {
        int i4;
        int i;
        i4 = 1;
        if (i2 & 1 == i4) {
            if (z) {
            } else {
                i4 = 7;
            }
            return i4;
        }
        int i7 = 4;
        i = 0;
        if (i2 &= i7 == i7) {
            if (z) {
            } else {
                i = 6;
            }
            return i;
        }
        int obj4 = 3;
        switch (i3) {
            case 0:
                return obj4;
            case 1:
                return i;
            case 2:
                i = 8;
                return i;
            case 3:
                return i7;
            case 4:
                return 5;
            case 5:
                return 2;
            case 6:
                return 10;
            case 7:
                return i4;
            default:
                return obj4;
        }
        obj4 = new StringBuilder();
        obj4.append("Unknown usage value ");
        obj4.append(i3);
        obj4.append(" in audio attributes");
        IllegalArgumentException obj3 = new IllegalArgumentException(obj4.toString());
        throw obj3;
    }

    static String b(int i) {
        switch (i) {
            case 0:
                return "USAGE_UNKNOWN";
            case 1:
                return "USAGE_MEDIA";
            case 2:
                return "USAGE_VOICE_COMMUNICATION";
            case 3:
                return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
            case 4:
                return "USAGE_ALARM";
            case 5:
                return "USAGE_NOTIFICATION";
            case 6:
                return "USAGE_NOTIFICATION_RINGTONE";
            case 7:
                return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
            case 8:
                return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
            case 9:
                return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
            case 10:
                return "USAGE_NOTIFICATION_EVENT";
            case 11:
                return "USAGE_ASSISTANCE_ACCESSIBILITY";
            case 12:
                return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
            case 13:
                return "USAGE_ASSISTANCE_SONIFICATION";
            case 14:
                return "USAGE_GAME";
            case 15:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unknown usage ");
                stringBuilder.append(i);
                return stringBuilder.toString();
            default:
                return "USAGE_ASSISTANT";
        }
    }

    public static androidx.media.AudioAttributesCompat c(Object object) {
        int i = 0;
        if (AudioAttributesCompat.c) {
            return i;
        }
        int sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 26) {
            AudioAttributesImplApi26 audioAttributesImplApi26 = new AudioAttributesImplApi26((AudioAttributes)object);
            AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat(audioAttributesImplApi26);
            return audioAttributesCompat;
        }
        if (sDK_INT >= 21) {
            AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21((AudioAttributes)object);
            AudioAttributesCompat audioAttributesCompat2 = new AudioAttributesCompat(audioAttributesImplApi21);
            return audioAttributesCompat2;
        }
        return i;
    }

    @Override // androidx.versionedparcelable.c
    public boolean equals(Object object) {
        int i;
        if (!object instanceof AudioAttributesCompat) {
            return 0;
        }
        androidx.media.AudioAttributesImpl audioAttributesImpl = this.a;
        if (audioAttributesImpl == null && object.a == null) {
            if (object.a == null) {
                i = 1;
            }
            return i;
        }
        return audioAttributesImpl.equals(object.a);
    }

    @Override // androidx.versionedparcelable.c
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // androidx.versionedparcelable.c
    public String toString() {
        return this.a.toString();
    }
}
