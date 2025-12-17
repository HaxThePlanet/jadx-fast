package io.grpc.j1;

import java.io.Closeable;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public interface v1 extends Closeable {
    @Override // java.io.Closeable
    public abstract void D1(OutputStream outputStream, int i2);

    @Override // java.io.Closeable
    public abstract void O0(byte[] bArr, int i2, int i3);

    @Override // java.io.Closeable
    public abstract io.grpc.j1.v1 Q(int i);

    @Override // java.io.Closeable
    public abstract void W1(ByteBuffer byteBuffer);

    @Override // java.io.Closeable
    public abstract void c1();

    @Override // java.io.Closeable
    public abstract void close();

    @Override // java.io.Closeable
    public abstract int g();

    @Override // java.io.Closeable
    public abstract boolean markSupported();

    @Override // java.io.Closeable
    public abstract int readUnsignedByte();

    @Override // java.io.Closeable
    public abstract void reset();

    @Override // java.io.Closeable
    public abstract void skipBytes(int i);
}
