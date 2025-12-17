package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.p0;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
final class z extends com.google.android.exoplayer2.audio.w {

    private static final int i;
    static {
        z.i = Float.floatToIntBits(2143289344);
    }

    private static void m(int i, ByteBuffer byteBuffer2) {
        int obj4;
        if (Float.floatToIntBits((float)i2) == z.i) {
            obj4 = Float.floatToIntBits(0);
        }
        byteBuffer2.putInt(obj4);
    }

    @Override // com.google.android.exoplayer2.audio.w
    public void d(ByteBuffer byteBuffer) {
        int position;
        ByteBuffer byteBuffer2;
        int i;
        int i2;
        final int limit2 = byteBuffer.limit();
        int i3 = limit2 - position;
        i = aVar.c;
        if (i != 536870912) {
            if (i != 805306368) {
            } else {
                while (position < limit2) {
                    z.m(i11 |= i2, l(i3));
                    position += 4;
                }
                byteBuffer.position(byteBuffer.limit());
                byteBuffer2.flip();
            }
            IllegalStateException obj6 = new IllegalStateException();
            throw obj6;
        }
        while (position < limit2) {
            z.m(i8 |= i2, l(i4 *= 4));
            position += 3;
        }
    }

    @Override // com.google.android.exoplayer2.audio.w
    public com.google.android.exoplayer2.audio.AudioProcessor.a h(com.google.android.exoplayer2.audio.AudioProcessor.a audioProcessor$a) {
        com.google.android.exoplayer2.audio.AudioProcessor.a aVar;
        int i;
        Object obj4;
        int i2 = a.c;
        if (!p0.f0(i2)) {
        } else {
            int i3 = 4;
            if (i2 != i3) {
                aVar = new AudioProcessor.a(a.a, a.b, i3);
            } else {
                aVar = AudioProcessor.a.e;
            }
            return aVar;
        }
        AudioProcessor.UnhandledAudioFormatException unhandledAudioFormatException = new AudioProcessor.UnhandledAudioFormatException(a);
        throw unhandledAudioFormatException;
    }
}
