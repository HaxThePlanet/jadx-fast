package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.p0;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
final class h0 extends com.google.android.exoplayer2.audio.w {

    private int i;
    private int j;
    private boolean k;
    private int l;
    private byte[] m;
    private int n;
    private long o;
    public h0() {
        super();
        this.m = p0.f;
    }

    @Override // com.google.android.exoplayer2.audio.w
    public ByteBuffer b() {
        boolean z;
        byte[] bArr;
        int i2;
        int i;
        z = this.n;
        if (super.c() && z > 0) {
            z = this.n;
            if (z > 0) {
                i = 0;
                l(z).put(this.m, i, this.n).flip();
                this.n = i;
            }
        }
        return super.b();
    }

    @Override // com.google.android.exoplayer2.audio.w
    public boolean c() {
        boolean z;
        int i;
        if (super.c() && this.n == 0) {
            i = this.n == 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.audio.w
    public void d(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i11 = limit - position;
        if (i11 == 0) {
        }
        int i15 = Math.min(i11, this.l);
        this.o = l += l2;
        this.l = i17 -= i15;
        byteBuffer.position(position += i15);
        if (this.l > 0) {
        }
        i11 -= i15;
        i4 -= length;
        ByteBuffer byteBuffer2 = l(i5);
        final int i21 = 0;
        int i20 = p0.p(i5, i21, this.n);
        byteBuffer2.put(this.m, i21, i20);
        int i7 = p0.p(i5 -= i20, i21, i12);
        byteBuffer.limit(position2 += i7);
        byteBuffer2.put(byteBuffer);
        byteBuffer.limit(limit);
        i12 -= i7;
        i8 -= i20;
        this.n = i9;
        byte[] bArr2 = this.m;
        System.arraycopy(bArr2, i20, bArr2, i21, i9);
        byteBuffer.get(this.m, this.n, i13);
        this.n = obj9 += i13;
        byteBuffer2.flip();
    }

    @Override // com.google.android.exoplayer2.audio.w
    public com.google.android.exoplayer2.audio.AudioProcessor.a h(com.google.android.exoplayer2.audio.AudioProcessor.a audioProcessor$a) {
        int i;
        Object obj3;
        if (a.c != 2) {
        } else {
            this.k = true;
            if (this.i == 0) {
                if (this.j != 0) {
                } else {
                    obj3 = AudioProcessor.a.e;
                }
            }
            return obj3;
        }
        AudioProcessor.UnhandledAudioFormatException unhandledAudioFormatException = new AudioProcessor.UnhandledAudioFormatException(a);
        throw unhandledAudioFormatException;
    }

    @Override // com.google.android.exoplayer2.audio.w
    protected void i() {
        boolean z;
        int i;
        final int i5 = 0;
        if (this.k) {
            this.k = i5;
            i = aVar.d;
            this.m = new byte[i2 *= i];
            this.l = i4 *= i;
        }
        this.n = i5;
    }

    @Override // com.google.android.exoplayer2.audio.w
    protected void j() {
        int i2;
        boolean z;
        int i;
        long l;
        i2 = this.n;
        if (this.k && i2 > 0) {
            i2 = this.n;
            if (i2 > 0) {
                this.o = l2 += l;
            }
            this.n = 0;
        }
    }

    @Override // com.google.android.exoplayer2.audio.w
    protected void k() {
        this.m = p0.f;
    }

    @Override // com.google.android.exoplayer2.audio.w
    public long m() {
        return this.o;
    }

    @Override // com.google.android.exoplayer2.audio.w
    public void n() {
        this.o = 0;
    }

    @Override // com.google.android.exoplayer2.audio.w
    public void o(int i, int i2) {
        this.i = i;
        this.j = i2;
    }
}
