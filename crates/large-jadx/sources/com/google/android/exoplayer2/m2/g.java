package com.google.android.exoplayer2.m2;

import com.google.android.exoplayer2.decoder.a;
import com.google.android.exoplayer2.util.g;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public abstract class g implements com.google.android.exoplayer2.m2.b {
    @Override // com.google.android.exoplayer2.m2.b
    public final com.google.android.exoplayer2.m2.a a(com.google.android.exoplayer2.m2.d d) {
        int i;
        int arrayOffset;
        com.google.android.exoplayer2.m2.a obj3;
        final ByteBuffer byteBuffer = d.c;
        g.e(byteBuffer);
        if ((ByteBuffer)byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            if (byteBuffer.hasArray()) {
                i = byteBuffer.arrayOffset() == 0 ? 1 : 0;
            } else {
            }
        } else {
        }
        g.a(i);
        if (d.o()) {
            obj3 = 0;
        } else {
            obj3 = b(d, byteBuffer);
        }
        return obj3;
    }

    @Override // com.google.android.exoplayer2.m2.b
    protected abstract com.google.android.exoplayer2.m2.a b(com.google.android.exoplayer2.m2.d d, ByteBuffer byteBuffer2);
}
