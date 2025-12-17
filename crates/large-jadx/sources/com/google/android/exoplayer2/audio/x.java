package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.g;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
final class x extends com.google.android.exoplayer2.audio.w {

    private int[] i;
    private int[] j;
    @Override // com.google.android.exoplayer2.audio.w
    public void d(ByteBuffer byteBuffer) {
        int position;
        int i2;
        int i;
        short short;
        final int[] iArr = this.j;
        g.e(iArr);
        final int limit = byteBuffer.limit();
        ByteBuffer byteBuffer2 = l(i4 *= i2);
        while (position < limit) {
            i = 0;
            while (i < iArr.length) {
                byteBuffer2.putShort(byteBuffer.getShort(i8 += position));
                i++;
            }
            position += i2;
            byteBuffer2.putShort(byteBuffer.getShort(i8 += position));
            i++;
        }
        byteBuffer.position(limit);
        byteBuffer2.flip();
    }

    @Override // com.google.android.exoplayer2.audio.w
    public com.google.android.exoplayer2.audio.AudioProcessor.a h(com.google.android.exoplayer2.audio.AudioProcessor.a audioProcessor$a) {
        int length;
        int i4;
        com.google.android.exoplayer2.audio.AudioProcessor.a aVar;
        int i2;
        int i;
        int i3;
        int obj9;
        length = this.i;
        if (length == null) {
            return AudioProcessor.a.e;
        }
        final int i7 = 2;
        if (a.c != i7) {
        } else {
            final int i8 = 1;
            final int i9 = 0;
            i4 = a.b != length.length ? i8 : i9;
            i2 = i9;
            for (int i10 : obj0) {
                if (i10 != i2) {
                } else {
                }
                i = i9;
                i4 |= i;
                i = i8;
            }
            if (i4 != 0) {
                aVar = new AudioProcessor.a(a.a, length.length, i7);
            } else {
                aVar = AudioProcessor.a.e;
            }
            return aVar;
        }
        AudioProcessor.UnhandledAudioFormatException unhandledAudioFormatException2 = new AudioProcessor.UnhandledAudioFormatException(a);
        throw unhandledAudioFormatException2;
    }

    @Override // com.google.android.exoplayer2.audio.w
    protected void i() {
        this.j = this.i;
    }

    @Override // com.google.android.exoplayer2.audio.w
    protected void k() {
        final int i = 0;
        this.j = i;
        this.i = i;
    }

    @Override // com.google.android.exoplayer2.audio.w
    public void m(int[] iArr) {
        this.i = iArr;
    }
}
