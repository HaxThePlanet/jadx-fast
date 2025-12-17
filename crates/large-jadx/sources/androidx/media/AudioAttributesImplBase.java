package androidx.media;

import android.util.Log;
import java.util.Arrays;

/* loaded from: classes.dex */
public class AudioAttributesImplBase implements androidx.media.AudioAttributesImpl {

    public int a = 0;
    public int b = 0;
    public int c = 0;
    public int d = -1;

    static class a implements androidx.media.AudioAttributesImpl.a {

        private int a = 0;
        private int b = 0;
        private int c = 0;
        private int d = -1;
        a() {
            super();
            int i = 0;
            int i2 = -1;
        }

        private androidx.media.AudioAttributesImplBase.a b(int i) {
            int string;
            int str;
            int i2;
            string = 1;
            str = 4;
            switch (i) {
                case 0:
                    this.b = string;
                    break;
                case 1:
                    this.b = str;
                    break;
                case 2:
                    this.b = str;
                    break;
                case 3:
                    this.b = 2;
                    break;
                case 4:
                    this.b = str;
                    break;
                case 5:
                    this.b = str;
                    break;
                case 6:
                    this.b = string;
                    this.c = i3 |= str;
                    break;
                case 7:
                    this.c = string |= i2;
                    this.b = str;
                    break;
                case 8:
                    this.b = str;
                    break;
                case 9:
                    this.b = str;
                    break;
                case 10:
                    this.b = string;
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid stream type ");
                    stringBuilder.append(i);
                    stringBuilder.append(" for AudioAttributesCompat");
                    Log.e("AudioAttributesCompat", stringBuilder.toString());
            }
            this.a = AudioAttributesImplBase.e(i);
            return this;
        }

        @Override // androidx.media.AudioAttributesImpl$a
        public androidx.media.AudioAttributesImpl.a a(int i) {
            c(i);
            return this;
        }

        @Override // androidx.media.AudioAttributesImpl$a
        public androidx.media.AudioAttributesImpl build() {
            AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase(this.b, this.c, this.a, this.d);
            return audioAttributesImplBase;
        }

        @Override // androidx.media.AudioAttributesImpl$a
        public androidx.media.AudioAttributesImplBase.a c(int i) {
            if (i == 10) {
            } else {
                this.d = i;
                b(i);
                return this;
            }
            IllegalArgumentException obj2 = new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
            throw obj2;
        }
    }
    public AudioAttributesImplBase() {
        super();
        int i = 0;
        int i2 = -1;
    }

    AudioAttributesImplBase(int i, int i2, int i3, int i4) {
        super();
        int i5 = 0;
        int i6 = -1;
        this.b = i;
        this.c = i2;
        this.a = i3;
        this.d = i4;
    }

    static int e(int i) {
        final int i3 = 2;
        switch (i) {
            case 0:
                return i3;
            case 1:
                return 13;
            case 2:
                return 6;
            case 3:
                return 1;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return i3;
            case 7:
                return 3;
            case 8:
                return 0;
            default:
                return 11;
        }
    }

    @Override // androidx.media.AudioAttributesImpl
    public int a() {
        return this.b;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int b() {
        int i2;
        int i;
        i2 = this.c;
        final int i4 = c();
        if (i4 == 6) {
            i2 |= 4;
        } else {
            if (i4 == 7) {
                i2 |= 1;
            }
        }
        return i2 &= 273;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int c() {
        int i = this.d;
        if (i != -1) {
            return i;
        }
        return AudioAttributesCompat.a(false, this.c, this.a);
    }

    @Override // androidx.media.AudioAttributesImpl
    public int d() {
        return this.a;
    }

    @Override // androidx.media.AudioAttributesImpl
    public boolean equals(Object object) {
        int i;
        int i2;
        int i3;
        Object obj4;
        if (!object instanceof AudioAttributesImplBase) {
            return 0;
        }
        if (this.b == (AudioAttributesImplBase)object.a() && this.c == object.b() && this.a == object.d() && this.d == object.d) {
            if (this.c == object.b()) {
                if (this.a == object.d()) {
                    if (this.d == object.d) {
                        i2 = 1;
                    }
                }
            }
        }
        return i2;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int hashCode() {
        Object[] arr = new Object[4];
        return Arrays.hashCode(Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.a), Integer.valueOf(this.d));
    }

    @Override // androidx.media.AudioAttributesImpl
    public String toString() {
        int str;
        StringBuilder stringBuilder = new StringBuilder("AudioAttributesCompat:");
        if (this.d != -1) {
            stringBuilder.append(" stream=");
            stringBuilder.append(this.d);
            stringBuilder.append(" derived");
        }
        stringBuilder.append(" usage=");
        stringBuilder.append(AudioAttributesCompat.b(this.a));
        stringBuilder.append(" content=");
        stringBuilder.append(this.b);
        stringBuilder.append(" flags=0x");
        stringBuilder.append(Integer.toHexString(this.c).toUpperCase());
        return stringBuilder.toString();
    }
}
