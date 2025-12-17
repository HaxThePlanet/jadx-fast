package io.grpc.j1;

import com.google.common.base.n;
import io.grpc.n0;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public final class w1 {

    private static final io.grpc.j1.v1 a;

    private static final class b extends InputStream implements n0 {

        private io.grpc.j1.v1 a;
        public b(io.grpc.j1.v1 v1) {
            super();
            n.p(v1, "buffer");
            this.a = (v1)v1;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.a.g();
        }

        @Override // java.io.InputStream
        public void close() {
            this.a.close();
        }

        @Override // java.io.InputStream
        public void mark(int i) {
            this.a.c1();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return this.a.markSupported();
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.a.g() == 0) {
                return -1;
            }
            return this.a.readUnsignedByte();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            if (this.a.g() == 0) {
                return -1;
            }
            final int obj4 = Math.min(this.a.g(), i3);
            this.a.O0(bArr, i2, obj4);
            return obj4;
        }

        @Override // java.io.InputStream
        public void reset() {
            this.a.reset();
        }

        @Override // java.io.InputStream
        public long skip(long l) {
            int obj3 = (int)obj3;
            this.a.skipBytes(obj3);
            return (long)obj3;
        }
    }

    class a extends io.grpc.j1.o0 {
        a(io.grpc.j1.v1 v1) {
            super(v1);
        }

        @Override // io.grpc.j1.o0
        public void close() {
        }
    }

    private static class c extends io.grpc.j1.c {

        int a;
        final int b;
        final byte[] c;
        int v;
        c(byte[] bArr) {
            super(bArr, 0, bArr.length);
        }

        c(byte[] bArr, int i2, int i3) {
            int i4;
            int i5;
            int i;
            super();
            this.v = -1;
            i4 = 1;
            int i7 = 0;
            i5 = i2 >= 0 ? i4 : i7;
            n.e(i5, "offset must be >= 0");
            i = i3 >= 0 ? i4 : i7;
            n.e(i, "length must be >= 0");
            i3 += i2;
            if (obj7 <= bArr.length) {
            } else {
                i4 = i7;
            }
            n.e(i4, "offset + length exceeds array boundary");
            n.p(bArr, "bytes");
            this.c = (byte[])bArr;
            this.a = i2;
            this.b = obj7;
        }

        @Override // io.grpc.j1.c
        public void D1(OutputStream outputStream, int i2) {
            a(i2);
            outputStream.write(this.c, this.a, i2);
            this.a = obj3 += i2;
        }

        @Override // io.grpc.j1.c
        public void O0(byte[] bArr, int i2, int i3) {
            System.arraycopy(this.c, this.a, bArr, i2, i3);
            this.a = obj3 += i3;
        }

        @Override // io.grpc.j1.c
        public io.grpc.j1.v1 Q(int i) {
            return c(i);
        }

        @Override // io.grpc.j1.c
        public void W1(ByteBuffer byteBuffer) {
            n.p(byteBuffer, "dest");
            int remaining = byteBuffer.remaining();
            a(remaining);
            byteBuffer.put(this.c, this.a, remaining);
            this.a = obj4 += remaining;
        }

        @Override // io.grpc.j1.c
        public io.grpc.j1.w1.c c(int i) {
            a(i);
            final int i2 = this.a;
            this.a = i2 + i;
            w1.c cVar = new w1.c(this.c, i2, i);
            return cVar;
        }

        @Override // io.grpc.j1.c
        public void c1() {
            this.v = this.a;
        }

        @Override // io.grpc.j1.c
        public int g() {
            return i -= i3;
        }

        @Override // io.grpc.j1.c
        public boolean markSupported() {
            return 1;
        }

        @Override // io.grpc.j1.c
        public int readUnsignedByte() {
            a(1);
            final int i3 = this.a;
            this.a = i3 + 1;
            return b &= 255;
        }

        @Override // io.grpc.j1.c
        public void reset() {
            int i = this.v;
            if (i == -1) {
            } else {
                this.a = i;
            }
            InvalidMarkException invalidMarkException = new InvalidMarkException();
            throw invalidMarkException;
        }

        @Override // io.grpc.j1.c
        public void skipBytes(int i) {
            a(i);
            this.a = i2 += i;
        }
    }
    static {
        w1.c cVar = new w1.c(new byte[0]);
        w1.a = cVar;
    }

    public static io.grpc.j1.v1 a() {
        return w1.a;
    }

    public static io.grpc.j1.v1 b(io.grpc.j1.v1 v1) {
        w1.a aVar = new w1.a(v1);
        return aVar;
    }

    public static InputStream c(io.grpc.j1.v1 v1, boolean z2) {
        io.grpc.j1.v1 obj1;
        if (z2) {
        } else {
            obj1 = w1.b(v1);
        }
        w1.b bVar = new w1.b(obj1);
        return bVar;
    }

    public static byte[] d(io.grpc.j1.v1 v1) {
        n.p(v1, "buffer");
        int i = v1.g();
        final byte[] bArr = new byte[i];
        v1.O0(bArr, 0, i);
        return bArr;
    }

    public static String e(io.grpc.j1.v1 v1, Charset charset2) {
        n.p(charset2, "charset");
        String string = new String(w1.d(v1), charset2);
        return string;
    }

    public static io.grpc.j1.v1 f(byte[] bArr, int i2, int i3) {
        w1.c cVar = new w1.c(bArr, i2, i3);
        return cVar;
    }
}
