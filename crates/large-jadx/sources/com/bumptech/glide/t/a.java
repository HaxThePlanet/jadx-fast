package com.bumptech.glide.t;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ByteBufferUtil.java */
/* loaded from: classes.dex */
public final class a {

    private static final AtomicReference<byte[]> a = new AtomicReference<>();

    private static class a extends InputStream {

        private final ByteBuffer a;
        private int b = -1;
        a(ByteBuffer byteBuffer) {
            super();
            this.a = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.a.remaining();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i) {
            this.b = this.a.position();
        }

        @Override // java.io.InputStream
        public int read() {
            if (!this.a.hasRemaining()) {
                return -1;
            }
            return this.a.get() & 255;
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            this.a.position(this.b);
            throw new IOException("Cannot reset to unset mark position");
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            if (!this.a.hasRemaining()) {
                return -1;
            }
            long min = Math.min(j, (long)available());
            this.a.position((int)(long)this.a.position() + min);
            return min;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            if (!this.a.hasRemaining()) {
                return -1;
            }
            final int min = Math.min(i2, available());
            this.a.get(bArr, i, min);
            return min;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }
    }

    static final class b {

        final int a;
        final int b;
        final byte[] c;
        b(byte[] bArr, int i, int i2) {
            super();
            this.c = bArr;
            this.a = i;
            this.b = i2;
        }
    }

    public static ByteBuffer a(File file) {
        Object obj3;
        try {
            final long length = file.length();
            final RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        } catch (Throwable th) {
        }
        throw new IOException("File too large to map into memory");
    }

    public static ByteBuffer b(InputStream inputStream) throws IOException {
        byte[] bArr;
        int bytesRead = 16384;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bytesRead);
        Object obj = null;
        if ((byte[])a.a.getAndSet(obj) == null) {
            bArr = new byte[bytesRead];
        }
        bytesRead = inputStream.read(bArr);
        while (bytesRead >= 0) {
            byteArrayOutputStream.write(bArr, 0, bytesRead);
            bytesRead = inputStream.read(bArr);
        }
        a.a.set(bArr);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return a.d(ByteBuffer.allocateDirect(byteArray.length).put(byteArray));
    }

    private static a.b c(ByteBuffer byteBuffer) {
        if (!byteBuffer.isReadOnly() && byteBuffer.hasArray()) {
            return new a.b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
        }
        return null;
    }

    public static ByteBuffer d(ByteBuffer byteBuffer) {
        return (ByteBuffer)byteBuffer.position(0);
    }

    public static byte[] e(ByteBuffer byteBuffer) {
        int i;
        byte[] bArr;
        com.bumptech.glide.t.a.b bVar = a.c(byteBuffer);
        if (bVar != null && bVar.a == 0) {
            length = bVar.c.length;
            if (bVar.b == bVar.c.length) {
                bArr = byteBuffer.array();
            } else {
                ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                bArr = new byte[readOnlyBuffer.limit()];
                a.d(readOnlyBuffer);
                readOnlyBuffer.get(bArr);
            }
        }
        return bArr;
    }

    public static void f(ByteBuffer byteBuffer, File file) {
        Object obj2;
        a.d(byteBuffer);
        try {
            final RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (Throwable th) {
        }
        try {
            FileChannel channel = randomAccessFile.getChannel();
            channel.write(th);
            channel.force(false);
            channel.close();
            randomAccessFile.close();
        } catch (java.io.IOException unused) {
            return;
        }
        if (channel != null) {
            try {
                channel.close();
            } catch (java.io.IOException unused) {
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) th;
            }
        }
        try {
            randomAccessFile.close();
        } catch (java.io.IOException unused) {
            return;
        }
    }

    public static InputStream g(ByteBuffer byteBuffer) {
        return new a.a(byteBuffer);
    }
}
