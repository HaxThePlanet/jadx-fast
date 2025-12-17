package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class e0 extends com.google.android.exoplayer2.audio.w {

    private final long i;
    private final long j;
    private final short k;
    private int l;
    private boolean m;
    private byte[] n;
    private byte[] o;
    private int p;
    private int q;
    private int r;
    private boolean s;
    private long t;
    public e0() {
        super(150000, obj2, 20000, obj4, 1024);
    }

    public e0(long l, long l2, short s3) {
        int i;
        super();
        i = Long.compare(s3, l) <= 0 ? 1 : 0;
        g.a(i);
        this.i = l;
        this.j = s3;
        this.k = obj6;
        final byte[] obj2 = p0.f;
        this.n = obj2;
        this.o = obj2;
    }

    private int m(long l) {
        return (int)obj3;
    }

    private int n(ByteBuffer byteBuffer) {
        int i;
        int i2;
        short s;
        limit += -2;
        while (i >= byteBuffer.position()) {
            i += -2;
        }
        return byteBuffer.position();
    }

    private int o(ByteBuffer byteBuffer) {
        int position;
        int i;
        short s;
        position = byteBuffer.position();
        while (position < byteBuffer.limit()) {
            position += 2;
        }
        return byteBuffer.limit();
    }

    private void q(ByteBuffer byteBuffer) {
        ByteBuffer obj3;
        final int remaining = byteBuffer.remaining();
        l(remaining).put(byteBuffer).flip();
        if (remaining > 0) {
            this.s = true;
        }
    }

    private void r(byte[] bArr, int i2) {
        ByteBuffer obj3;
        l(i2).put(bArr, 0, i2).flip();
        if (i2 > 0) {
            this.s = true;
        }
    }

    private void s(ByteBuffer byteBuffer) {
        byte[] i3;
        long l;
        int i6;
        int i4;
        int length;
        int i2;
        int i;
        int i5;
        final int limit = byteBuffer.limit();
        i3 = o(byteBuffer);
        i6 = i3 - position;
        length = this.n;
        i = this.q;
        length2 -= i;
        final int i18 = 0;
        if (i3 < limit && i6 < i2) {
            if (i6 < i2) {
                r(length, i);
                this.q = i18;
                this.p = i18;
            } else {
                int i7 = Math.min(i6, i2);
                byteBuffer.limit(position2 += i7);
                byteBuffer.get(this.n, this.q, i7);
                i11 += i7;
                this.q = i6;
                i3 = this.n;
                if (i6 == i3.length) {
                    i2 = 2;
                    if (this.s) {
                        r(i3, this.r);
                        this.t = l2 += i5;
                    } else {
                        this.t = l3 += l;
                    }
                    w(byteBuffer, this.n, this.q);
                    this.q = i18;
                    this.p = i2;
                }
                byteBuffer.limit(limit);
            }
        } else {
        }
    }

    private void t(ByteBuffer byteBuffer) {
        int i;
        final int limit = byteBuffer.limit();
        byteBuffer.limit(Math.min(limit, position += length));
        i = n(byteBuffer);
        if (i == byteBuffer.position()) {
            this.p = 1;
        } else {
            byteBuffer.limit(i);
            q(byteBuffer);
        }
        byteBuffer.limit(limit);
    }

    private void u(ByteBuffer byteBuffer) {
        int i;
        byte[] bArr;
        final int limit = byteBuffer.limit();
        i = o(byteBuffer);
        byteBuffer.limit(i);
        this.t = l += l2;
        w(byteBuffer, this.o, this.r);
        if (i < limit) {
            r(this.o, this.r);
            this.p = 0;
            byteBuffer.limit(limit);
        }
    }

    private void w(ByteBuffer byteBuffer, byte[] b2Arr2, int i3) {
        int i = Math.min(byteBuffer.remaining(), this.r);
        i4 -= i;
        System.arraycopy(b2Arr2, i3 -= i5, this.o, 0, i5);
        byteBuffer.position(obj6 -= i);
        byteBuffer.get(this.o, i5, i);
    }

    @Override // com.google.android.exoplayer2.audio.w
    public boolean a() {
        return this.m;
    }

    @Override // com.google.android.exoplayer2.audio.w
    public void d(ByteBuffer byteBuffer) {
        int i2;
        boolean remaining;
        int i;
        while (byteBuffer.hasRemaining()) {
            i2 = this.p;
            t(byteBuffer);
            s(byteBuffer);
            u(byteBuffer);
        }
    }

    @Override // com.google.android.exoplayer2.audio.w
    public com.google.android.exoplayer2.audio.AudioProcessor.a h(com.google.android.exoplayer2.audio.AudioProcessor.a audioProcessor$a) {
        Object obj3;
        if (a.c != 2) {
        } else {
            if (this.m) {
            } else {
                obj3 = AudioProcessor.a.e;
            }
            return obj3;
        }
        AudioProcessor.UnhandledAudioFormatException unhandledAudioFormatException = new AudioProcessor.UnhandledAudioFormatException(a);
        throw unhandledAudioFormatException;
    }

    @Override // com.google.android.exoplayer2.audio.w
    protected void i() {
        int bArr2;
        boolean bArr;
        int length;
        this.l = aVar.d;
        i2 *= i5;
        int length2 = bArr3.length;
        if (this.m && length2 != bArr2) {
            this.l = aVar.d;
            i2 *= i5;
            length2 = bArr3.length;
            if (length2 != bArr2) {
                this.n = new byte[bArr2];
            }
            i3 *= i6;
            this.r = bArr;
            if (bArr4.length != bArr) {
                this.o = new byte[bArr];
            }
        }
        int i4 = 0;
        this.p = i4;
        this.t = 0;
        this.q = i4;
        this.s = i4;
    }

    @Override // com.google.android.exoplayer2.audio.w
    protected void j() {
        boolean z;
        byte[] bArr;
        long l;
        int i;
        int i2 = this.q;
        if (i2 > 0) {
            r(this.n, i2);
        }
        if (!this.s) {
            this.t = l2 += l;
        }
    }

    @Override // com.google.android.exoplayer2.audio.w
    protected void k() {
        int i = 0;
        this.m = i;
        this.r = i;
        byte[] bArr = p0.f;
        this.n = bArr;
        this.o = bArr;
    }

    @Override // com.google.android.exoplayer2.audio.w
    public long p() {
        return this.t;
    }

    @Override // com.google.android.exoplayer2.audio.w
    public void v(boolean z) {
        this.m = z;
    }
}
