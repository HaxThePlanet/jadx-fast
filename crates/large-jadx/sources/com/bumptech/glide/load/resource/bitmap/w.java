package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.engine.z.b;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: RecyclableBufferedInputStream.java */
/* loaded from: classes.dex */
public class w extends FilterInputStream {

    private volatile byte[] a;
    private int b;
    private int c;
    private int v;
    private int w;
    private final b x;

    static class a extends IOException {

        private static final long serialVersionUID = -4338378848813561757L;
        a(String str) {
            super(str);
        }
    }
    public w(InputStream inputStream, b bVar) {
        this(inputStream, bVar, 65536);
    }

    private int a(InputStream inputStream, byte[] bArr) throws IOException {
        int length = -1;
        int length2;
        int i;
        int i2;
        length = -1;
        final int i9 = 0;
        if (this.v != length) {
            length2 = this.w - i3;
            if (this.w - i3 < this.c) {
                if (this.v == 0) {
                    length = bArr.length;
                    if (this.c > bArr.length) {
                        length2 = bArr.length;
                        if (this.b == bArr.length) {
                            i = bArr.length * 2;
                            if (bArr.length <= this.c) {
                            }
                            Object obj = this.x.e(i, byte[].class);
                            System.arraycopy(bArr, i9, obj, i9, bArr.length);
                            this.a = obj;
                            this.x.d(bArr);
                        } else {
                            if (this.v > 0) {
                                System.arraycopy(bArr, this.v, bArr, i9, bArr.length - i3);
                            }
                        }
                    }
                }
                this.w -= i6;
                this.v = i9;
                this.b = i9;
                int bytesRead = inputStream.read(bArr, i5, bArr.length - i5);
                if (bytesRead > 0) {
                    i2 = this.w + bytesRead;
                }
            }
            this.b = i2;
            return bytesRead;
        }
        int bytesRead2 = inputStream.read(bArr);
        if (bytesRead2 > 0) {
            this.v = length;
            this.w = i9;
            this.b = bytesRead2;
        }
        return bytesRead2;
    }

    private static IOException f() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream
    public synchronized int available() {
        w.f();
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }

    @Override // java.io.FilterInputStream
    public synchronized void c() {
        this.c = this.a.length;
    }

    @Override // java.io.FilterInputStream
    public void close() throws IOException {
        final byte[] bArr3 = null;
        if (this.a != null) {
            this.x.d(this.a);
            this.a = bArr3;
        }
        this.in = bArr3;
        if (this.in != null) {
            this.in.close();
        }
    }

    @Override // java.io.FilterInputStream
    public synchronized void e() {
        if (this.a != null) {
            this.x.d(this.a);
            byte[] bArr = null;
            this.a = bArr;
        }
    }

    @Override // java.io.FilterInputStream
    public synchronized void mark(int i) {
        this.c = Math.max(this.c, i);
        this.v = this.w;
    }

    @Override // java.io.FilterInputStream
    public synchronized int read() {
        byte[] bArr;
        int i6 = 0;
        final int i10 = -1;
        w.f();
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) i6;
    }

    @Override // java.io.FilterInputStream
    public synchronized void reset() {
        this.w = this.v;
        throw new IOException("Stream is closed");
    }

    @Override // java.io.FilterInputStream
    public synchronized long skip(long j) {
        long l7 = 0L;
        if (j < 1) {
            return l7;
        }
        int i8 = 0;
        long l10 = (long)(i9 - i11);
        this.w = (int)(long)i11 + j;
        w.f();
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) i8;
    }

    w(InputStream inputStream, b bVar, int i) {
        super(inputStream);
        this.v = -1;
        this.x = bVar;
        this.a = (byte[])bVar.e(i, byte[].class);
    }

    @Override // java.io.FilterInputStream
    public synchronized int read(byte[] bArr, int i, int i2) {
        byte[] bArr2;
        int i32;
        int i4;
        int i5;
        final int i6 = 0;
        if (this.a != null && i2 == 0) {
            return 0;
        }
        w.f();
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) i6;
    }

    @Override // java.io.FilterInputStream
    public boolean markSupported() {
        return true;
    }
}
