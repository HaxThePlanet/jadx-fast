package com.bumptech.glide.t;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ContentLengthInputStream.java */
/* loaded from: classes.dex */
public final class c extends FilterInputStream {

    private final long a;
    private int b;
    private c(InputStream inputStream, long j) {
        super(inputStream);
        this.a = j;
    }

    private int a(int i) throws IOException {
        if (i >= 0) {
            this.b += i;
            return i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str = "Failed to read all expected data, expected: ";
        String str2 = ", but read: ";
        r0 = str + this.a + str2 + this.b;
        throw new IOException(r0);
    }

    public static InputStream c(InputStream inputStream, long j) {
        return new c(inputStream, j, r3);
    }

    @Override // java.io.FilterInputStream
    public synchronized int available() {
        return (int)(Math.max(this.a - (long)this.b, (long)this.in.available()));
    }

    @Override // java.io.FilterInputStream
    public synchronized int read() {
        int i = -1;
        final int read = super.read();
        int r1 = read >= 0 ? 1 : -1;
        a((read >= 0 ? 1 : -1));
        return read;
    }

    @Override // java.io.FilterInputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream
    public synchronized int read(byte[] bArr, int i, int i2) {
        final int read = super.read(bArr, i, i2);
        a(read);
        return read;
    }
}
