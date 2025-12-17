package com.google.firebase.firestore.util;

import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class ByteBufferInputStream extends InputStream {

    ByteBuffer buffer;
    public ByteBufferInputStream(ByteBuffer byteBuffer) {
        super();
        this.buffer = byteBuffer;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.buffer.remaining();
    }

    @Override // java.io.InputStream
    public int read() {
        if (!this.buffer.hasRemaining()) {
            return -1;
        }
        return b &= 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) {
        if (!this.buffer.hasRemaining()) {
            return -1;
        }
        final int obj4 = Math.min(i3, this.buffer.remaining());
        this.buffer.get(bArr, i2, obj4);
        return obj4;
    }
}
