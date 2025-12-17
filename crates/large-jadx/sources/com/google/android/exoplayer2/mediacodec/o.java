package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.a;
import com.google.android.exoplayer2.util.g;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
final class o extends DecoderInputBuffer {

    private long A;
    private int B;
    private int C = 32;
    public o() {
        super(2);
        int i2 = 32;
    }

    private boolean z(DecoderInputBuffer decoderInputBuffer) {
        boolean z;
        ByteBuffer obj5;
        final int i2 = 1;
        if (!D()) {
            return i2;
        }
        final int i4 = 0;
        if (this.B >= this.C) {
            return i4;
        }
        if (decoderInputBuffer.o() != o()) {
            return i4;
        }
        obj5 = decoderInputBuffer.c;
        z = this.c;
        if (obj5 != null && z != null && position += obj5 > 3072000) {
            z = this.c;
            if (z != null) {
                if (position += obj5 > 3072000) {
                    return i4;
                }
            }
        }
        return i2;
    }

    @Override // com.google.android.exoplayer2.decoder.DecoderInputBuffer
    public long A() {
        return this.w;
    }

    @Override // com.google.android.exoplayer2.decoder.DecoderInputBuffer
    public long B() {
        return this.A;
    }

    @Override // com.google.android.exoplayer2.decoder.DecoderInputBuffer
    public int C() {
        return this.B;
    }

    @Override // com.google.android.exoplayer2.decoder.DecoderInputBuffer
    public boolean D() {
        int i;
        i = this.B > 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.android.exoplayer2.decoder.DecoderInputBuffer
    public void E(int i) {
        int i2;
        i2 = i > 0 ? 1 : 0;
        g.a(i2);
        this.C = i;
    }

    @Override // com.google.android.exoplayer2.decoder.DecoderInputBuffer
    public void j() {
        super.j();
        this.B = 0;
    }

    @Override // com.google.android.exoplayer2.decoder.DecoderInputBuffer
    public boolean y(DecoderInputBuffer decoderInputBuffer) {
        int i2;
        boolean z;
        int i;
        final int i6 = 1;
        g.a(z2 ^= i6);
        g.a(z3 ^= i6);
        g.a(z4 ^= i6);
        if (!z(decoderInputBuffer)) {
            return 0;
        }
        i2 = this.B;
        this.B = i2 + 1;
        this.w = decoderInputBuffer.w;
        if (i2 == 0 && decoderInputBuffer.q()) {
            this.w = decoderInputBuffer.w;
            if (decoderInputBuffer.q()) {
                r(i6);
            }
        }
        if (decoderInputBuffer.o()) {
            r(Integer.MIN_VALUE);
        }
        ByteBuffer byteBuffer = decoderInputBuffer.c;
        if (byteBuffer != null) {
            t(byteBuffer.remaining());
            this.c.put(byteBuffer);
        }
        this.A = decoderInputBuffer.w;
        return i6;
    }
}
