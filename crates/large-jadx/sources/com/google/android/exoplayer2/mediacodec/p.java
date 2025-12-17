package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.audio.b0;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.v;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
final class p {

    private long a;
    private long b;
    private boolean c;
    private long a(long l) {
        return l2 += obj7;
    }

    public long b(i1 i1) {
        return a((long)obj3);
    }

    public void c() {
        int i = 0;
        this.a = i;
        this.b = i;
        this.c = false;
    }

    public long d(i1 i1, DecoderInputBuffer decoderInputBuffer2) {
        int cmp;
        int i2;
        int i3;
        int i;
        final int i7 = 0;
        if (Long.compare(l, i7) == 0) {
            this.a = decoderInputBuffer2.w;
        }
        if (this.c) {
            return decoderInputBuffer2.w;
        }
        ByteBuffer byteBuffer = decoderInputBuffer2.c;
        g.e(byteBuffer);
        i3 = i2;
        while (i2 < 4) {
            i8 |= i;
            i2++;
        }
        int i4 = b0.m(i3);
        if (i4 == -1) {
            this.c = true;
            this.b = i7;
            this.a = decoderInputBuffer2.w;
            v.h("C2Mp3TimestampTracker", "MPEG audio header is invalid.");
            return decoderInputBuffer2.w;
        }
        this.b = l3 += l4;
        return a((long)obj7);
    }
}
