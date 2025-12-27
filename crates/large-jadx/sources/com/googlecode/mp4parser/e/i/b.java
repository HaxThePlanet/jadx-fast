package com.googlecode.mp4parser.e.i;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* compiled from: CleanInputStream.java */
/* loaded from: classes2.dex */
public class b extends FilterInputStream {

    int a = -1;
    int b = -1;
    public b(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.FilterInputStream
    public int read() throws IOException {
        int read;
        int i = 3;
        if (super.read() == 3 && this.a == 0 && this.b == 0) {
            int i2 = -1;
            this.a = i2;
            this.b = i2;
            read = super.read();
        }
        this.a = this.b;
        this.b = read;
        return read;
    }

    @Override // java.io.FilterInputStream
    public int read(byte[] bArr, int i, int i2) {
        int i4 = 1;
        byte b;
        Objects.requireNonNull(bArr);
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            if (i2 >= 0) {
                i = bArr.length - i;
                if (i2 <= bArr.length - i) {
                    if (i2 == 0) {
                        return 0;
                    }
                    int read2 = read();
                    final int i6 = -1;
                    if (read2 == i6) {
                        return i6;
                    }
                    bArr[i] = (byte)read2;
                    i4 = 1;
                    while (bArr.length - i >= i2) {
                        try {
                            int read = read();
                            i5 = i + i4;
                            b = (byte)read;
                            bArr[i5] = b;
                        } catch (java.io.IOException unused) {
                            return i4;
                        }
                        i4 = i4 + 1;
                    }
                }
            }
        }
    }

    @Override // java.io.FilterInputStream
    public boolean markSupported() {
        return false;
    }
}
