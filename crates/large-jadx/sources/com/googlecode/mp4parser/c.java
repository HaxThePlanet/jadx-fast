package com.googlecode.mp4parser;

import com.googlecode.mp4parser.h.b;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* compiled from: MemoryDataSourceImpl.java */
/* loaded from: classes2.dex */
public class c implements a {

    ByteBuffer a;
    public c(ByteBuffer byteBuffer) {
        super();
        this.a = byteBuffer;
    }

    public void Z1(long j) {
        this.a.position(b.a(j));
    }

    public ByteBuffer f1(long j, long j2) {
        this.a.position(b.a(j));
        ByteBuffer slice = this.a.slice();
        slice.limit(b.a(j2));
        this.a.position(this.a.position());
        return slice;
    }

    public int read(ByteBuffer byteBuffer) {
        if (this.a.remaining() == 0 && byteBuffer.remaining() != 0) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), this.a.remaining());
        if (byteBuffer.hasArray()) {
            byteBuffer.put(this.a.array(), this.a.position(), min);
            this.a.position(this.a.position() + min);
        } else {
            byte[] bArr = new byte[min];
            this.a.get(bArr);
            byteBuffer.put(bArr);
        }
        return min;
    }

    public long size() {
        return (long)this.a.capacity();
    }

    public long t(long j, long j2, WritableByteChannel writableByteChannel) throws java.io.IOException {
        return (long)writableByteChannel.write((ByteBuffer)(ByteBuffer)this.a.position(b.a(j)).slice().limit(b.a(j2)));
    }

    public long w0() {
        return (long)this.a.position();
    }

    public void close() {
    }
}
