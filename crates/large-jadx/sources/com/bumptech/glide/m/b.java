package com.bumptech.glide.m;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: StrictLineReader.java */
/* loaded from: classes.dex */
class b implements Closeable {

    private final InputStream a;
    private final Charset b;
    private byte[] c;
    private int v;
    private int w;

    class a extends ByteArrayOutputStream {

        final /* synthetic */ b a;
        a(int i) {
            this.a = bVar;
            super(i);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int count2;
            if (this.count > 0) {
                byte b2 = (byte) 13;
                if (this.buf[count2 - 1] == (byte) 13) {
                    count2 = count2 - 1;
                }
            }
            try {
            } catch (java.io.UnsupportedEncodingException unsupportedEncoding) {
                throw new AssertionError(unsupportedEncoding);
            }
            return new String(this.buf, 0, count2, this.a.b.name());
        }
    }
    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    static /* synthetic */ Charset a(b bVar) {
        return bVar.b;
    }

    private void c() throws IOException, EOFException {
        final int i2 = 0;
        int bytesRead = this.a.read(this.c, i2, bArr.length);
        if (bytesRead == -1) {
            throw new EOFException();
        } else {
            this.v = i2;
            this.w = bytesRead;
            return;
        }
    }

    @Override // java.io.Closeable
    public void close() {
        synchronized (inputStream) {
            try {
                if (this.c != null) {
                    this.c = null;
                    this.a.close();
                }
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    public boolean e() {
        boolean z = true;
        int r0 = this.w == -1 ? 1 : 0;
        return (this.w == -1 ? 1 : 0);
    }

    public String f() {
        int i;
        byte[] bArr;
        int i3;
        byte b2 = 13;
        int i6;
        synchronized (inputStream) {
            try {
                if (this.c == null) {
                    throw new IOException("LineReader is closed");
                } else {
                    if (this.v >= this.w) {
                        c();
                    }
                    byte b = (byte) 10;
                    while (this.v != this.w) {
                        if (bArr[i] == b) {
                        }
                    }
                    i3 = (this.w - this.v) + 80;
                    com.bumptech.glide.m.b.a aVar = new b.a(this, i3);
                    while (/* condition */) {
                        while (this.w != this.w) {
                        }
                        i6 = this.w - i5;
                        aVar.write(this.c, this.v, i6);
                        this.w = -1;
                        c();
                    }
                    if (this.c != this.v) {
                        i6 = i3 - i15;
                        aVar.write(this.c, this.v, i6);
                    }
                    this.v = i3 + 1;
                    return aVar.toString();
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    public b(InputStream inputStream, int i, Charset charset) {
        super();
        if (inputStream == null) {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            if (charset != null) {
                if (i < 0) {
                    throw new IllegalArgumentException("capacity <= 0");
                } else {
                    if (!charset.equals(c.a)) {
                        throw new IllegalArgumentException("Unsupported encoding");
                    } else {
                        this.a = inputStream;
                        this.b = charset;
                        this.c = new byte[i];
                        return;
                    }
                }
            }
        }
    }
}
