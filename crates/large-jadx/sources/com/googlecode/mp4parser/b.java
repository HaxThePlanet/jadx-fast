package com.googlecode.mp4parser;

import com.googlecode.mp4parser.h.f;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes2.dex */
public class b implements com.googlecode.mp4parser.a {

    FileChannel a;
    String b;
    static {
        f.a(b.class);
    }

    public b(File file) {
        super();
        FileInputStream fileInputStream = new FileInputStream(file);
        this.a = fileInputStream.getChannel();
        this.b = file.getName();
    }

    @Override // com.googlecode.mp4parser.a
    public void Z1(long l) {
        this.a.position(l);
        return;
        synchronized (this) {
            this.a.position(l);
        }
    }

    @Override // com.googlecode.mp4parser.a
    public void close() {
        this.a.close();
    }

    @Override // com.googlecode.mp4parser.a
    public ByteBuffer f1(long l, long l2) {
        return this.a.map(FileChannel.MapMode.READ_ONLY, l, obj3);
        synchronized (this) {
            return this.a.map(FileChannel.MapMode.READ_ONLY, l, obj3);
        }
    }

    @Override // com.googlecode.mp4parser.a
    public int read(ByteBuffer byteBuffer) {
        return this.a.read(byteBuffer);
        synchronized (this) {
            return this.a.read(byteBuffer);
        }
    }

    @Override // com.googlecode.mp4parser.a
    public long size() {
        return this.a.size();
        synchronized (this) {
            return this.a.size();
        }
    }

    @Override // com.googlecode.mp4parser.a
    public long t(long l, long l2, WritableByteChannel writableByteChannel3) {
        return this.a.transferTo(l, obj2, writableByteChannel3);
        synchronized (this) {
            return this.a.transferTo(l, obj2, writableByteChannel3);
        }
    }

    @Override // com.googlecode.mp4parser.a
    public String toString() {
        return this.b;
    }

    @Override // com.googlecode.mp4parser.a
    public long w0() {
        return this.a.position();
        synchronized (this) {
            return this.a.position();
        }
    }
}
