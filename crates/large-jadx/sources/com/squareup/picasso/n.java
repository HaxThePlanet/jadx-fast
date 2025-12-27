package com.squareup.picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: MarkableInputStream.java */
/* loaded from: classes2.dex */
final class n extends InputStream {

    private final InputStream a;
    private long b;
    private long c;
    private long v;
    private long w;
    private boolean x;
    private int y;
    n(InputStream inputStream) {
        this(inputStream, 4096);
    }

    private void f(long j) {
        try {
            if (this.c < this.b) {
                if (this.b <= this.v) {
                    this.a.reset();
                    i = (int)(j - this.c);
                    this.a.mark(i);
                    i(this.c, this.b);
                } else {
                    this.c = this.b;
                    i = (int)(j - l);
                    this.a.mark(i);
                }
            }
            this.v = j;
        } catch (java.io.IOException ioException) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Unable to mark: ";
            ioException = str + ioException;
            r6 = new IllegalStateException(ioException);
            throw r6;
        }
    }

    private void i(long j, long j2) throws IOException {
        long skipped = 1;
        while (j < j2) {
            l = j2 - j;
            skipped = this.a.skip(l);
            if (skipped == 0) {
                break;
            }
        }
    }

    @Override // java.io.InputStream
    public void a(boolean z) {
        this.x = z;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.a.available();
    }

    @Override // java.io.InputStream
    public void c(long j) throws IOException {
        if (this.b > this.v) {
            throw new IOException("Cannot reset");
        } else {
            if (j >= this.c) {
                this.a.reset();
                i(this.c, j);
                this.b = j;
                return;
            }
        }
    }

    @Override // java.io.InputStream
    public void close() throws IOException {
        this.a.close();
    }

    @Override // java.io.InputStream
    public long e(int i) {
        long l2 = this.b + (long)i;
        if (this.v < this.b) {
            f(l2);
        }
        return this.b;
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.w = e(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        final long l3 = 1L;
        if (!this.x) {
            l = this.b + 1L;
            if (this.b > this.v) {
                l = (long)this.y;
                l2 = l2 + l;
                f(l2);
            }
        }
        int bytesRead = this.a.read();
        int i = -1;
        if (bytesRead != -1) {
            this.b += l3;
        }
        return bytesRead;
    }

    @Override // java.io.InputStream
    public void reset() {
        c(this.w);
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        if (!this.x) {
            long l7 = l4 + j;
            if (l7 > this.v) {
                f((l4 + j) + (long)this.y);
            }
        }
        final long skipped = this.a.skip(j);
        this.b += skipped;
        return skipped;
    }

    n(InputStream inputStream, int i) {
        this(inputStream, i, 1024);
    }

    private n(InputStream inputStream, int i, int i2) throws IOException {
        BufferedInputStream bufferedInputStream;
        super();
        this.w = -1L;
        this.x = true;
        this.y = -1;
        if (!inputStream.markSupported()) {
        }
        this.a = bufferedInputStream;
        this.y = i2;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int cmp;
        if (!this.x) {
            long l9 = (long)bArr.length + l4;
            if (bArr.length > this.v) {
                f((l4 + (long)bArr.length) + (long)this.y);
            }
        }
        final int bytesRead = this.a.read(bArr);
        int i = -1;
        if (bytesRead != -1) {
            this.b += l7;
        }
        return bytesRead;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (!this.x) {
            l = (long)i2;
            long l7 = l4 + l;
            if (l7 > this.v) {
                l = (long)this.y;
                f((l4 + l) + l);
            }
        }
        final int bytesRead = this.a.read(bArr, i, i2);
        i = -1;
        if (bytesRead != -1) {
            this.b += l3;
        }
        return bytesRead;
    }
}
