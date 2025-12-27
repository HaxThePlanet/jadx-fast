package io.grpc.j1;

import com.google.common.base.n;
import io.grpc.n0;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;

/* compiled from: ReadableBuffers.java */
/* loaded from: classes3.dex */
public final class w1 {

    private static final v1 a = new w1$c();

    private static final class b extends InputStream implements n0 {

        private v1 a;
        public b(v1 v1Var) {
            super();
            n.p(v1Var, "buffer");
            this.a = v1Var;
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
        public void reset() {
            this.a.reset();
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            long j2 = Math.min((long)this.a.g(), j);
            this.a.skipBytes((int)j2);
            return j2;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            if (this.a.g() == 0) {
                return -1;
            }
            final int min = Math.min(this.a.g(), i2);
            this.a.O0(bArr, i, min);
            return min;
        }
    }

    class a extends o0 {
        a(v1 v1Var) {
            super(v1Var);
        }

        @Override // io.grpc.j1.o0
        public void close() {
        }
    }

    private static class c extends c {

        int a;
        final int b;
        final byte[] c;
        int v;
        c(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        @Override // io.grpc.j1.c
        public void D1(OutputStream outputStream, int i) throws java.io.IOException {
            a(i);
            outputStream.write(this.c, this.a, i);
            this.a += i;
        }

        @Override // io.grpc.j1.c
        public void O0(byte[] bArr, int i, int i2) {
            System.arraycopy(this.c, this.a, bArr, i, i2);
            this.a += i2;
        }

        @Override // io.grpc.j1.c
        public void W1(ByteBuffer byteBuffer) {
            n.p(byteBuffer, "dest");
            int remaining = byteBuffer.remaining();
            a(remaining);
            byteBuffer.put(this.c, this.a, remaining);
            this.a += remaining;
        }

        @Override // io.grpc.j1.c
        public w1.c c(int i) {
            a(i);
            this.a += i;
            return new w1.c(this.c, i2, i);
        }

        @Override // io.grpc.j1.c
        public void c1() {
            this.v = this.a;
        }

        @Override // io.grpc.j1.c
        public int g() {
            return this.b - this.a;
        }

        @Override // io.grpc.j1.c
        public int readUnsignedByte() {
            a(1);
            this.a++;
            return this.c[i3] & 255;
        }

        @Override // io.grpc.j1.c
        public void reset() throws InvalidMarkException {
            if (this.v == -1) {
                throw new InvalidMarkException();
            } else {
                this.a = this.v;
                return;
            }
        }

        @Override // io.grpc.j1.c
        public void skipBytes(int i) {
            a(i);
            this.a += i;
        }

        c(byte[] bArr, int i, int i2) {
            boolean z = true;
            boolean z2;
            boolean z3;
            super();
            this.v = -1;
            i = 1;
            int i4 = 0;
            int r2 = i >= 0 ? i : i4;
            n.e((i >= 0 ? i : i4), "offset must be >= 0");
            r2 = i2 >= 0 ? i : i4;
            n.e((i2 >= 0 ? i : i4), "length must be >= 0");
            i2 += i;
            if (i6 > bArr.length) {
            }
            n.e(z, "offset + length exceeds array boundary");
            n.p(bArr, "bytes");
            this.c = bArr;
            this.a = i;
            this.b = i6;
        }

        @Override // io.grpc.j1.c
        public boolean markSupported() {
            return true;
        }
    }
    static {
        
    }

    public static v1 a() {
        return w1.a;
    }

    public static v1 b(v1 v1Var) {
        return new w1.a(v1Var);
    }

    public static InputStream c(v1 v1Var, boolean z) {
        io.grpc.j1.v1 v1Var2;
        if (!(z)) {
            v1Var2 = w1.b(v1Var);
        }
        w1.b bVar = new w1.b(v1Var2);
        return bVar;
    }

    public static byte[] d(v1 v1Var) {
        n.p(v1Var, "buffer");
        int i = v1Var.g();
        final byte[] bArr = new byte[i];
        v1Var.O0(bArr, 0, i);
        return bArr;
    }

    public static String e(v1 v1Var, Charset charset) throws java.io.UnsupportedEncodingException {
        n.p(charset, "charset");
        return new String(w1.d(v1Var), charset);
    }

    public static v1 f(byte[] bArr, int i, int i2) {
        return new w1.c(bArr, i, i2);
    }
}
