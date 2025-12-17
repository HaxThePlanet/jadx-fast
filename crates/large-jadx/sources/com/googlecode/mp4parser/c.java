package com.googlecode.mp4parser;

import com.googlecode.mp4parser.h.b;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes2.dex */
public class c implements com.googlecode.mp4parser.a {

    ByteBuffer a;
    public c(ByteBuffer byteBuffer) {
        super();
        this.a = byteBuffer;
    }

    @Override // com.googlecode.mp4parser.a
    public void Z1(long l) {
        this.a.position(b.a(l));
    }

    @Override // com.googlecode.mp4parser.a
    public void close() {
    }

    @Override // com.googlecode.mp4parser.a
    public ByteBuffer f1(long l, long l2) {
        this.a.position(b.a(l));
        ByteBuffer obj3 = this.a.slice();
        obj3.limit(b.a(obj5));
        this.a.position(this.a.position());
        return obj3;
    }

    @Override // com.googlecode.mp4parser.a
    public int read(ByteBuffer byteBuffer) {
        int remaining;
        byte[] bArr;
        ByteBuffer position;
        ByteBuffer obj4;
        if (this.a.remaining() == 0 && byteBuffer.remaining() != 0) {
            if (byteBuffer.remaining() != 0) {
                return -1;
            }
        }
        int i = Math.min(byteBuffer.remaining(), this.a.remaining());
        if (byteBuffer.hasArray()) {
            byteBuffer.put(this.a.array(), this.a.position(), i);
            obj4 = this.a;
            obj4.position(position2 += i);
        } else {
            bArr = new byte[i];
            this.a.get(bArr);
            byteBuffer.put(bArr);
        }
        return i;
    }

    @Override // com.googlecode.mp4parser.a
    public long size() {
        return (long)capacity;
    }

    @Override // com.googlecode.mp4parser.a
    public long t(long l, long l2, WritableByteChannel writableByteChannel3) {
        return (long)obj2;
    }

    @Override // com.googlecode.mp4parser.a
    public long w0() {
        return (long)position;
    }
}
