package f.e.a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
class b implements Closeable {

    private final InputStream a;
    private final Charset b;
    private byte[] c;
    private int v;
    private int w;

    class a extends ByteArrayOutputStream {

        final f.e.a.b a;
        a(f.e.a.b b, int i2) {
            this.a = b;
            super(i2);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int count;
            byte assertionError;
            int i;
            count = this.count;
            if (count > 0 && this.buf[count + -1] == 13) {
                if (this.buf[count + -1] == 13) {
                    count--;
                }
            }
            String string = new String(this.buf, 0, count, b.a(this.a).name());
            return string;
        }
    }
    public b(InputStream inputStream, int i2, Charset charset3) {
        super();
        if (inputStream == null) {
        } else {
            if (charset3 == null) {
            } else {
                if (i2 < 0) {
                } else {
                    if (!charset3.equals(c.a)) {
                    } else {
                        this.a = inputStream;
                        this.b = charset3;
                        this.c = new byte[i2];
                    }
                    IllegalArgumentException obj2 = new IllegalArgumentException("Unsupported encoding");
                    throw obj2;
                }
                obj2 = new IllegalArgumentException("capacity <= 0");
                throw obj2;
            }
        }
        throw 0;
    }

    public b(InputStream inputStream, Charset charset2) {
        super(inputStream, 8192, charset2);
    }

    static Charset a(f.e.a.b b) {
        return b.b;
    }

    private void c() {
        byte[] bArr = this.c;
        final int i2 = 0;
        int read = this.a.read(bArr, i2, bArr.length);
        if (read == -1) {
        } else {
            this.v = i2;
            this.w = read;
        }
        EOFException eOFException = new EOFException();
        throw eOFException;
    }

    @Override // java.io.Closeable
    public void close() {
        byte[] bArr;
        final InputStream inputStream = this.a;
        synchronized (inputStream) {
            this.c = 0;
            this.a.close();
        }
    }

    @Override // java.io.Closeable
    public String e() {
        int i5;
        int i6;
        int i7;
        int i4;
        int i;
        byte b;
        int i8;
        int i2;
        int i3;
        final InputStream inputStream = this.a;
        synchronized (inputStream) {
            if (this.v >= this.w) {
                c();
            }
            try {
                i5 = this.v;
                i4 = 10;
                while (i5 != this.w) {
                    i6 = this.c;
                    i5++;
                    i4 = 10;
                }
                i6 = this.c;
                if (i6[i5] == i4) {
                } else {
                }
                if (i5 != this.v && i6[i5 + -1] == 13) {
                } else {
                }
                if (i6[i5 + -1] == 13) {
                } else {
                }
                i = i5;
                int i19 = this.v;
                String string2 = new String(this.c, i19, i -= i19, this.b.name());
                this.v = i5++;
                return string2;
                i5++;
                b.a aVar = new b.a(this, i13 += 80);
                while (/* condition */) {
                    while (i7 != this.w) {
                        i2 = this.c;
                        if (i2[i7] != i4) {
                            break loop_14;
                        }
                        i7++;
                    }
                    i2 = this.v;
                    aVar.write(this.c, i2, i18 -= i2);
                    this.w = -1;
                    c();
                    i7 = this.v;
                    i2 = this.c;
                    if (i2[i7] != i4) {
                    }
                    i7++;
                }
                while (i7 != this.w) {
                    i2 = this.c;
                    if (i2[i7] != i4) {
                        break loop_14;
                    }
                    i7++;
                }
                i2 = this.c;
                if (i2[i7] != i4) {
                }
                int i16 = this.v;
                if (i7 != i16) {
                }
                aVar.write(i2, i16, i7 - i16);
                this.v = i7++;
                return aVar.toString();
                i7++;
                IOException iOException = new IOException("LineReader is closed");
                throw iOException;
                throw th;
            }
        }
    }
}
