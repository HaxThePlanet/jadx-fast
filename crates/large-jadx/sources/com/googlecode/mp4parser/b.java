package com.googlecode.mp4parser;

import com.googlecode.mp4parser.h.f;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.channels.WritableByteChannel;

/* compiled from: FileDataSourceImpl.java */
/* loaded from: classes2.dex */
public class b implements a {

    FileChannel a;
    String b;
    static {
        f.a(b.class);
    }

    public b(File file) throws java.io.FileNotFoundException, java.io.IOException {
        super();
        this.a = new FileInputStream(file).getChannel();
        this.b = file.getName();
    }

    public synchronized void Z1(long j) {
        this.a.position(j);
    }

    public void close() throws java.io.IOException {
        this.a.close();
    }

    public synchronized ByteBuffer f1(long j, long j2) {
        return this.a.map(FileChannel.MapMode.READ_ONLY, j, j2);
    }

    public synchronized int read(ByteBuffer byteBuffer) {
        return this.a.read(byteBuffer);
    }

    public synchronized long size() {
        return this.a.size();
    }

    public synchronized long t(long j, long j2, WritableByteChannel writableByteChannel) {
        return this.a.transferTo(j, j2, writableByteChannel);
    }

    @Override // java.lang.Object
    public String toString() {
        return this.b;
    }

    public synchronized long w0() {
        return this.a.position();
    }
}
