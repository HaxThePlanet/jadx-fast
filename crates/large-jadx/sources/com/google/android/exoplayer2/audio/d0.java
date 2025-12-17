package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.p0;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
final class d0 extends com.google.android.exoplayer2.audio.w {
    @Override // com.google.android.exoplayer2.audio.w
    public void d(ByteBuffer byteBuffer) {
        int position;
        int i;
        int i4;
        int i2;
        int i3;
        final int limit2 = byteBuffer.limit();
        i = limit2 - position;
        int i5 = aVar.c;
        i2 = 805306368;
        i3 = 536870912;
        final int i21 = 268435456;
        final int i22 = 4;
        final int i23 = 3;
        if (i5 != i23) {
            if (i5 != i22) {
                if (i5 != i21 && i5 != i3) {
                    if (i5 != i3) {
                        if (i5 != i2) {
                        } else {
                            i /= 2;
                        }
                        IllegalStateException obj10 = new IllegalStateException();
                        throw obj10;
                    }
                    i /= 3;
                    i *= 2;
                }
            } else {
            }
        } else {
        }
        ByteBuffer byteBuffer2 = l(i);
        i4 = aVar2.c;
        if (i4 != i23 && i4 != i22 && i4 != i21 && i4 != i3 && i4 == i2) {
            if (i4 != i22) {
                if (i4 != i21) {
                    if (i4 != i3) {
                        if (i4 != i2) {
                        }
                        obj10 = new IllegalStateException();
                        throw obj10;
                    }
                    while (position < limit2) {
                        byteBuffer2.put(byteBuffer.get(position + 1));
                        byteBuffer2.put(byteBuffer.get(position + 2));
                        position += 3;
                    }
                }
            }
        }
        byteBuffer.position(byteBuffer.limit());
        byteBuffer2.flip();
    }

    @Override // com.google.android.exoplayer2.audio.w
    public com.google.android.exoplayer2.audio.AudioProcessor.a h(com.google.android.exoplayer2.audio.AudioProcessor.a audioProcessor$a) {
        com.google.android.exoplayer2.audio.AudioProcessor.a aVar;
        int i;
        Object obj4;
        int i2 = a.c;
        final int i3 = 2;
        if (i2 != 3 && i2 != i3 && i2 != 268435456 && i2 != 536870912 && i2 != 805306368) {
            if (i2 != i3) {
                if (i2 != 268435456) {
                    if (i2 != 536870912) {
                        if (i2 != 805306368) {
                            if (i2 != 4) {
                            } else {
                            }
                            AudioProcessor.UnhandledAudioFormatException unhandledAudioFormatException = new AudioProcessor.UnhandledAudioFormatException(a);
                            throw unhandledAudioFormatException;
                        }
                    }
                }
            }
        }
        if (i2 != i3) {
            aVar = new AudioProcessor.a(a.a, a.b, i3);
        } else {
            aVar = AudioProcessor.a.e;
        }
        return aVar;
    }
}
