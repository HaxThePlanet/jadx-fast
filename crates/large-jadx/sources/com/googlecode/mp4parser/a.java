package com.googlecode.mp4parser;

import java.io.Closeable;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes2.dex */
public interface a extends Closeable {
    @Override // java.io.Closeable
    public abstract void Z1(long l);

    @Override // java.io.Closeable
    public abstract void close();

    @Override // java.io.Closeable
    public abstract ByteBuffer f1(long l, long l2);

    @Override // java.io.Closeable
    public abstract int read(ByteBuffer byteBuffer);

    @Override // java.io.Closeable
    public abstract long size();

    @Override // java.io.Closeable
    public abstract long t(long l, long l2, WritableByteChannel writableByteChannel3);

    @Override // java.io.Closeable
    public abstract long w0();
}
