package com.googlecode.mp4parser;

import java.io.Closeable;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* compiled from: DataSource.java */
/* loaded from: classes2.dex */
public interface a extends Closeable {
    void Z1(long j);

    @Override // java.io.Closeable
    void close();

    ByteBuffer f1(long j, long j2);

    int read(ByteBuffer byteBuffer);

    long size();

    long t(long j, long j2, WritableByteChannel writableByteChannel);

    long w0();
}
