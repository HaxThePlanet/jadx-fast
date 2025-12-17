package com.google.android.exoplayer2.decoder;

import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodec.CryptoInfo.Pattern;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;

/* loaded from: classes2.dex */
public final class b {

    public byte[] a;
    public byte[] b;
    public int c;
    public int[] d;
    public int[] e;
    public int f;
    public int g;
    public int h;
    private final MediaCodec.CryptoInfo i;
    private final com.google.android.exoplayer2.decoder.b.b j;

    static class a {
    }

    private static final class b {

        private final MediaCodec.CryptoInfo a;
        private final MediaCodec.CryptoInfo.Pattern b;
        private b(MediaCodec.CryptoInfo mediaCodec$CryptoInfo) {
            super();
            this.a = cryptoInfo;
            final int i = 0;
            MediaCodec.CryptoInfo.Pattern obj2 = new MediaCodec.CryptoInfo.Pattern(i, i);
            this.b = obj2;
        }

        b(MediaCodec.CryptoInfo mediaCodec$CryptoInfo, com.google.android.exoplayer2.decoder.b.a b$a2) {
            super(cryptoInfo);
        }

        static void a(com.google.android.exoplayer2.decoder.b.b b$b, int i2, int i3) {
            b.b(i2, i3);
        }

        private void b(int i, int i2) {
            this.b.set(i, i2);
            this.a.setPattern(this.b);
        }
    }
    public b() {
        int bVar;
        int i;
        super();
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.i = cryptoInfo;
        if (p0.a >= 24) {
            bVar = new b.b(cryptoInfo, 0);
            i = bVar;
        }
        this.j = i;
    }

    public MediaCodec.CryptoInfo a() {
        return this.i;
    }

    public void b(int i) {
        int[] iArr;
        MediaCodec.CryptoInfo cryptoInfo;
        if (i == 0) {
        }
        if (this.d == null) {
            iArr = new int[1];
            this.d = iArr;
            cryptoInfo.numBytesOfClearData = iArr;
        }
        int[] iArr2 = this.d;
        int i3 = 0;
        iArr2[i3] = i4 += i;
    }

    public void c(int i, int[] i2Arr2, int[] i3Arr3, byte[] b4Arr4, byte[] b5Arr5, int i6, int i7, int i8) {
        int obj2;
        this.f = i;
        this.d = i2Arr2;
        this.e = i3Arr3;
        this.b = b4Arr4;
        this.a = b5Arr5;
        this.c = i6;
        this.g = i7;
        this.h = i8;
        final MediaCodec.CryptoInfo cryptoInfo = this.i;
        cryptoInfo.numSubSamples = i;
        cryptoInfo.numBytesOfClearData = i2Arr2;
        cryptoInfo.numBytesOfEncryptedData = i3Arr3;
        cryptoInfo.key = b4Arr4;
        cryptoInfo.iv = b5Arr5;
        cryptoInfo.mode = i6;
        if (p0.a >= 24) {
            obj2 = this.j;
            g.e(obj2);
            b.b.a((b.b)obj2, i7, i8);
        }
    }
}
