package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.a;
import com.google.android.exoplayer2.decoder.f;
import com.google.android.exoplayer2.decoder.g;
import com.google.android.exoplayer2.util.g;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public abstract class d extends g<com.google.android.exoplayer2.text.i, com.google.android.exoplayer2.text.j, com.google.android.exoplayer2.text.SubtitleDecoderException> implements com.google.android.exoplayer2.text.g {
    protected d(String string) {
        int obj2 = 2;
        super(new i[obj2], new j[obj2]);
        v(1024);
    }

    public static void B(com.google.android.exoplayer2.text.d d, f f2) {
        d.s(f2);
    }

    @Override // com.google.android.exoplayer2.decoder.g
    protected final com.google.android.exoplayer2.text.SubtitleDecoderException A(com.google.android.exoplayer2.text.i i, com.google.android.exoplayer2.text.j j2, boolean z3) {
        try {
            ByteBuffer byteBuffer = i.c;
            g.e(byteBuffer);
            j2.t(i.w, obj4, z((ByteBuffer)byteBuffer.array(), byteBuffer.limit(), z3));
            j2.k(Integer.MIN_VALUE);
            return null;
            return i;
        }
    }

    @Override // com.google.android.exoplayer2.decoder.g
    public void b(long l) {
    }

    @Override // com.google.android.exoplayer2.decoder.g
    protected DecoderInputBuffer h() {
        return w();
    }

    @Override // com.google.android.exoplayer2.decoder.g
    protected f i() {
        return x();
    }

    @Override // com.google.android.exoplayer2.decoder.g
    protected DecoderException j(Throwable throwable) {
        return y(throwable);
    }

    @Override // com.google.android.exoplayer2.decoder.g
    protected DecoderException k(DecoderInputBuffer decoderInputBuffer, f f2, boolean z3) {
        return A((i)decoderInputBuffer, (j)f2, z3);
    }

    @Override // com.google.android.exoplayer2.decoder.g
    protected final com.google.android.exoplayer2.text.i w() {
        i iVar = new i();
        return iVar;
    }

    @Override // com.google.android.exoplayer2.decoder.g
    protected final com.google.android.exoplayer2.text.j x() {
        b bVar = new b(this);
        e eVar = new e(bVar);
        return eVar;
    }

    @Override // com.google.android.exoplayer2.decoder.g
    protected final com.google.android.exoplayer2.text.SubtitleDecoderException y(Throwable throwable) {
        SubtitleDecoderException subtitleDecoderException = new SubtitleDecoderException("Unexpected decode error", throwable);
        return subtitleDecoderException;
    }

    @Override // com.google.android.exoplayer2.decoder.g
    protected abstract com.google.android.exoplayer2.text.f z(byte[] bArr, int i2, boolean z3);
}
