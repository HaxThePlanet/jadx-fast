package io.grpc.j1;

import java.io.Closeable;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* compiled from: ReadableBuffer.java */
/* loaded from: classes3.dex */
public interface v1 extends Closeable {
    void D1(OutputStream outputStream, int i);

    void O0(byte[] bArr, int i, int i2);

    v1 Q(int i);

    void W1(ByteBuffer byteBuffer);

    void c1();

    @Override // java.io.Closeable
    void close();

    int g();

    boolean markSupported();

    int readUnsignedByte();

    void reset();

    void skipBytes(int i);
}
