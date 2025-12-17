package com.bumptech.glide.load.data;

import com.bumptech.glide.load.engine.z.b;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class c extends OutputStream {

    private final OutputStream a;
    private byte[] b;
    private b c;
    private int v;
    public c(OutputStream outputStream, b b2) {
        super(outputStream, b2, 65536);
    }

    c(OutputStream outputStream, b b2, int i3) {
        super();
        this.a = outputStream;
        this.c = b2;
        this.b = (byte[])b2.e(i3, byte[].class);
    }

    private void a() {
        OutputStream outputStream;
        byte[] bArr;
        int i;
        final int i2 = this.v;
        if (i2 > 0) {
            i = 0;
            this.a.write(this.b, i, i2);
            this.v = i;
        }
    }

    private void c() {
        if (this.v == bArr.length) {
            a();
        }
    }

    private void e() {
        byte[] bArr;
        b bVar;
        bArr = this.b;
        if (bArr != null) {
            this.c.d(bArr);
            this.b = 0;
        }
    }

    @Override // java.io.OutputStream
    public void close() {
        try {
            flush();
            this.a.close();
            e();
            this.a.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream
    public void flush() {
        a();
        this.a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        final int i2 = this.v;
        this.v = i2 + 1;
        this.b[i2] = (byte)i;
        c();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) {
        int i4;
        int i;
        int i5;
        byte[] bArr2;
        int length;
        i4 = 0;
        int i6 = i3 - i4;
        int i7 = i2 + i4;
        int i9 = this.v;
        while (i9 == 0) {
            i = Math.min(i6, length2 -= i9);
            System.arraycopy(bArr, i7, this.b, this.v, i);
            this.v = i8 += i;
            c();
            i6 = i3 - i4;
            i7 = i2 + i4;
            i9 = this.v;
        }
        this.a.write(bArr, i7, i6);
    }
}
