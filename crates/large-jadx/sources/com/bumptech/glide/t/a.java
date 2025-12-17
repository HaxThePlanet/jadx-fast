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

/* loaded from: classes.dex */
public final class a {

    private static final AtomicReference<byte[]> a;

    private static class a extends InputStream {

        private final ByteBuffer a;
        private int b = -1;
        a(ByteBuffer byteBuffer) {
            super();
            final int i = -1;
            this.a = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.a.remaining();
        }

        @Override // java.io.InputStream
        public void mark(int i) {
            this.b = this.a.position();
            return;
            synchronized (this) {
                this.b = this.a.position();
            }
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return 1;
        }

        @Override // java.io.InputStream
        public int read() {
            if (!this.a.hasRemaining()) {
                return -1;
            }
            return b &= 255;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            if (!this.a.hasRemaining()) {
                return -1;
            }
            final int obj4 = Math.min(i3, available());
            this.a.get(bArr, i2, obj4);
            return obj4;
        }

        @Override // java.io.InputStream
        public void reset() {
            int i = this.b;
            synchronized (this) {
                try {
                    this.a.position(i);
                    IOException iOException = new IOException("Cannot reset to unset mark position");
                    throw iOException;
                    throw th;
                }
            }
        }

        @Override // java.io.InputStream
        public long skip(long l) {
            if (!this.a.hasRemaining()) {
                return -1;
            }
            long obj4 = Math.min(l, obj5);
            ByteBuffer byteBuffer2 = this.a;
            byteBuffer2.position((int)i);
            return obj4;
        }
    }

    static final class b {

        final int a;
        final int b;
        final byte[] c;
        b(byte[] bArr, int i2, int i3) {
            super();
            this.c = bArr;
            this.a = i2;
            this.b = i3;
        }
    }
    static {
        AtomicReference atomicReference = new AtomicReference();
        a.a = atomicReference;
    }

    public static ByteBuffer a(File file) {
        Object obj;
        int i = 0;
        final long length = file.length();
        if (Long.compare(length, i2) > 0) {
        } else {
            try {
                if (Long.compare(length, i3) == 0) {
                } else {
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
                FileChannel channel = randomAccessFile.getChannel();
                if (channel != null) {
                }
                channel.close();
                randomAccessFile.close();
                return channel.map(FileChannel.MapMode.READ_ONLY, 0, obj4).load();
                IOException obj8 = new IOException("File unsuitable for memory mapping");
                throw obj8;
                obj8 = new IOException("File too large to map into memory");
                throw obj8;
                obj = obj0;
                if (obj0 != null) {
                }
                obj0.close();
                if (obj == null) {
                } else {
                }
                obj.close();
                throw file;
            } catch (Throwable th) {
            }
        }
    }

    public static ByteBuffer b(InputStream inputStream) {
        int read;
        Object andSet;
        int i;
        read = 16384;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(read);
        if ((byte[])a.a.getAndSet(0) == null) {
            andSet = new byte[read];
        }
        read = inputStream.read(andSet);
        while (read >= 0) {
            byteArrayOutputStream.write(andSet, 0, read);
            read = inputStream.read(andSet);
        }
        a.a.set(andSet);
        byte[] obj4 = byteArrayOutputStream.toByteArray();
        return a.d(ByteBuffer.allocateDirect(obj4.length).put(obj4));
    }

    private static com.bumptech.glide.t.a.b c(ByteBuffer byteBuffer) {
        boolean readOnly;
        if (!byteBuffer.isReadOnly() && byteBuffer.hasArray()) {
            if (byteBuffer.hasArray()) {
                a.b bVar = new a.b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
                return bVar;
            }
        }
        return null;
    }

    public static ByteBuffer d(ByteBuffer byteBuffer) {
        return (ByteBuffer)byteBuffer.position(0);
    }

    public static byte[] e(ByteBuffer byteBuffer) {
        int bArr;
        int i;
        byte[] obj2;
        bArr = a.c(byteBuffer);
        if (bArr != null && bArr.a == 0 && bArr.b == bArr2.length) {
            if (bArr.a == 0) {
                if (bArr.b == bArr2.length) {
                    obj2 = byteBuffer.array();
                } else {
                    obj2 = byteBuffer.asReadOnlyBuffer();
                    bArr = new byte[obj2.limit()];
                    a.d(obj2);
                    obj2.get(bArr);
                    obj2 = bArr;
                }
            } else {
            }
        } else {
        }
        return obj2;
    }

    public static void f(ByteBuffer byteBuffer, File file2) {
        Object obj;
        a.d(byteBuffer);
        int i = 0;
        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
        FileChannel channel = randomAccessFile.getChannel();
        channel.write(byteBuffer);
        channel.force(false);
        channel.close();
        randomAccessFile.close();
        if (channel != null) {
            channel.close();
        }
        randomAccessFile.close();
    }

    public static InputStream g(ByteBuffer byteBuffer) {
        a.a aVar = new a.a(byteBuffer);
        return aVar;
    }
}
