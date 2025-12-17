package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.p0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public interface AudioProcessor {

    public static final ByteBuffer a;

    public static final class UnhandledAudioFormatException extends Exception {
        public UnhandledAudioFormatException(com.google.android.exoplayer2.audio.AudioProcessor.a audioProcessor$a) {
            String obj3 = String.valueOf(a);
            StringBuilder stringBuilder = new StringBuilder(length += 18);
            stringBuilder.append("Unhandled format: ");
            stringBuilder.append(obj3);
            super(stringBuilder.toString());
        }
    }

    public static final class a {

        public static final com.google.android.exoplayer2.audio.AudioProcessor.a e;
        public final int a;
        public final int b;
        public final int c;
        public final int d = -1;
        static {
            final int i = -1;
            AudioProcessor.a aVar = new AudioProcessor.a(i, i, i);
            AudioProcessor.a.e = aVar;
        }

        public a(int i, int i2, int i3) {
            super();
            this.a = i;
            this.b = i2;
            this.c = i3;
            if (p0.g0(i3)) {
                int obj1 = p0.U(i3, i2);
            }
            obj1 = -1;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(83);
            stringBuilder.append("AudioFormat[sampleRate=");
            stringBuilder.append(this.a);
            stringBuilder.append(", channelCount=");
            stringBuilder.append(this.b);
            stringBuilder.append(", encoding=");
            stringBuilder.append(this.c);
            stringBuilder.append(']');
            return stringBuilder.toString();
        }
    }
    static {
        AudioProcessor.a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());
    }

    public abstract boolean a();

    public abstract ByteBuffer b();

    public abstract boolean c();

    public abstract void d(ByteBuffer byteBuffer);

    public abstract com.google.android.exoplayer2.audio.AudioProcessor.a e(com.google.android.exoplayer2.audio.AudioProcessor.a audioProcessor$a);

    public abstract void f();

    public abstract void flush();

    public abstract void reset();
}
