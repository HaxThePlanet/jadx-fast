package com.googlecode.mp4parser.e.i;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.Objects;

/* loaded from: classes2.dex */
public class b extends FilterInputStream {

    int a = -1;
    int b = -1;
    public b(InputStream inputStream) {
        super(inputStream);
        final int obj1 = -1;
    }

    @Override // java.io.FilterInputStream
    public boolean markSupported() {
        return 0;
    }

    @Override // java.io.FilterInputStream
    public int read() {
        int read;
        int i;
        if (super.read() == 3 && this.a == 0 && this.b == 0) {
            if (this.a == 0) {
                if (this.b == 0) {
                    int i2 = -1;
                    this.a = i2;
                    this.b = i2;
                    read = super.read();
                }
            }
        }
        this.a = this.b;
        this.b = read;
        return read;
    }

    @Override // java.io.FilterInputStream
    public int read(byte[] bArr, int i2, int i3) {
        int i5;
        int i;
        byte read;
        int i4;
        Objects.requireNonNull(bArr);
        if (i2 < 0) {
        } else {
            if (i3 < 0) {
            } else {
                if (i3 > length -= i2) {
                } else {
                    if (i3 == 0) {
                        return 0;
                    }
                    int read2 = read();
                    final int i6 = -1;
                    if (read2 == i6) {
                        return i6;
                    }
                    bArr[i2] = (byte)read2;
                    i = 1;
                    while (i >= i3) {
                        read = read();
                        bArr[i2 + i] = (byte)read;
                        i++;
                    }
                    return i;
                }
            }
        }
        IndexOutOfBoundsException obj5 = new IndexOutOfBoundsException();
        throw obj5;
    }
}
