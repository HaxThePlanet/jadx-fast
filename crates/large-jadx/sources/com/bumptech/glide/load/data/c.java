package com.bumptech.glide.load.data;

import com.bumptech.glide.load.engine.z.b;
import java.io.OutputStream;

/* compiled from: BufferedOutputStream.java */
/* loaded from: classes.dex */
public final class c extends OutputStream {

    private final OutputStream a;
    private byte[] b;
    private b c;
    private int v;
    public c(OutputStream outputStream, b bVar) {
        this(outputStream, bVar, 65536);
    }

    private void a() throws java.io.IOException {
        if (this.v > 0) {
            int i = 0;
            this.a.write(this.b, i, this.v);
            this.v = i;
        }
    }

    private void c() {
        if (this.v == this.b.length) {
            a();
        }
    }

    private void e() {
        if (this.b != null) {
            this.c.d(this.b);
            byte[] bArr = null;
            this.b = bArr;
        }
    }

    @Override // java.io.OutputStream
    public void close() {
        try {
            flush();
        } finally {
            this.a.close();
            throw th;
        }
        this.a.close();
        e();
    }

    @Override // java.io.OutputStream
    public void flush() throws java.io.IOException {
        a();
        this.a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.v++;
        this.b[this.v] = (byte)i;
        c();
    }

    c(OutputStream outputStream, b bVar, int i) {
        super();
        this.a = outputStream;
        this.c = bVar;
        this.b = (byte[])bVar.e(i, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        int length;
        i = 0;
        int i5 = i2 - i;
        int i6 = i + i;
        while (this.v == 0) {
            length = this.b.length;
            int min = Math.min(i5, this.b.length - i8);
            System.arraycopy(bArr, i6, this.b, this.v, min);
            this.v += min;
            i = i + min;
            c();
            if (i + min >= i2) {
                return;
            }
            i5 = i2 - i;
            i6 = i + i;
        }
        this.a.write(bArr, i6, i5);
    }
}
