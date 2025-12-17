package l;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public final class w implements l.g {

    public final l.f a;
    public boolean b;
    public final l.b0 c;

    public static final class a extends OutputStream {

        final l.w a;
        a(l.w w) {
            this.a = w;
            super();
        }

        @Override // java.io.OutputStream
        public void close() {
            this.a.close();
        }

        @Override // java.io.OutputStream
        public void flush() {
            final l.w wVar = this.a;
            if (!wVar.b) {
                wVar.flush();
            }
        }

        @Override // java.io.OutputStream
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append(".outputStream()");
            return stringBuilder.toString();
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            l.w wVar = this.a;
            if (wVar.b) {
            } else {
                wVar.a.z0((byte)i);
                this.a.o0();
            }
            IOException obj3 = new IOException("closed");
            throw obj3;
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) {
            n.f(bArr, "data");
            l.w wVar = this.a;
            if (wVar.b) {
            } else {
                wVar.a.v0(bArr, i2, i3);
                this.a.o0();
            }
            IOException obj3 = new IOException("closed");
            throw obj3;
        }
    }
    public w(l.b0 b0) {
        n.f(b0, "sink");
        super();
        this.c = b0;
        f obj2 = new f();
        this.a = obj2;
    }

    @Override // l.g
    public l.g E0(String string) {
        n.f(string, "string");
        if (z ^= 1 == 0) {
        } else {
            this.a.b1(string);
            o0();
            return this;
        }
        IllegalStateException obj2 = new IllegalStateException("closed".toString());
        throw obj2;
    }

    @Override // l.g
    public l.g G() {
        int cmp;
        l.f fVar;
        if (z ^= 1 == 0) {
        } else {
            long size = this.a.size();
            if (Long.compare(size, i2) > 0) {
                this.c.write(this.a, size);
            }
            return this;
        }
        IllegalStateException illegalStateException = new IllegalStateException("closed".toString());
        throw illegalStateException;
    }

    @Override // l.g
    public l.g I(int i) {
        if (z ^= 1 == 0) {
        } else {
            this.a.L0(i);
            o0();
            return this;
        }
        IllegalStateException obj2 = new IllegalStateException("closed".toString());
        throw obj2;
    }

    @Override // l.g
    public l.g P(int i) {
        if (z ^= 1 == 0) {
        } else {
            this.a.G0(i);
            o0();
            return this;
        }
        IllegalStateException obj2 = new IllegalStateException("closed".toString());
        throw obj2;
    }

    @Override // l.g
    public l.g U0(String string, int i2, int i3) {
        n.f(string, "string");
        if (z ^= 1 == 0) {
        } else {
            this.a.e1(string, i2, i3);
            o0();
            return this;
        }
        IllegalStateException obj2 = new IllegalStateException("closed".toString());
        throw obj2;
    }

    @Override // l.g
    public long W0(l.d0 d0) {
        int i;
        long read;
        long l;
        int cmp;
        n.f(d0, "source");
        i = 0;
        read = d0.read(this.a, (long)i2);
        while (Long.compare(read, i3) == 0) {
            i += read;
            o0();
            read = d0.read(this.a, (long)i2);
        }
        return i;
    }

    @Override // l.g
    public l.g X0(long l) {
        if (z ^= 1 == 0) {
        } else {
            this.a.C0(l);
            o0();
            return this;
        }
        IllegalStateException obj2 = new IllegalStateException("closed".toString());
        throw obj2;
    }

    @Override // l.g
    public l.g Y1(long l) {
        if (z ^= 1 == 0) {
        } else {
            this.a.A0(l);
            o0();
            return this;
        }
        IllegalStateException obj2 = new IllegalStateException("closed".toString());
        throw obj2;
    }

    @Override // l.g
    public l.g b(byte[] bArr, int i2, int i3) {
        n.f(bArr, "source");
        if (z ^= 1 == 0) {
        } else {
            this.a.v0(bArr, i2, i3);
            o0();
            return this;
        }
        IllegalStateException obj2 = new IllegalStateException("closed".toString());
        throw obj2;
    }

    @Override // l.g
    public OutputStream b2() {
        w.a aVar = new w.a(this);
        return aVar;
    }

    @Override // l.g
    public l.g c0(int i) {
        if (z ^= 1 == 0) {
        } else {
            this.a.z0(i);
            o0();
            return this;
        }
        IllegalStateException obj2 = new IllegalStateException("closed".toString());
        throw obj2;
    }

    @Override // l.g
    public void close() {
        int z;
        int cmp;
        l.b0 b0Var;
        int th;
        l.f fVar;
        int size;
        if (this.b) {
        } else {
            z = 0;
            if (Long.compare(size2, size) > 0) {
                fVar = this.a;
                this.c.write(fVar, fVar.size());
            }
            this.c.close();
            this.b = true;
            if (z != 0) {
            } else {
            }
        }
        throw z;
    }

    @Override // l.g
    public void flush() {
        int cmp;
        l.f fVar;
        int size;
        if (z ^= 1 == 0) {
        } else {
            if (Long.compare(size2, size) > 0) {
                fVar = this.a;
                this.c.write(fVar, fVar.size());
            }
            this.c.flush();
        }
        IllegalStateException illegalStateException = new IllegalStateException("closed".toString());
        throw illegalStateException;
    }

    @Override // l.g
    public l.f h() {
        return this.a;
    }

    @Override // l.g
    public boolean isOpen() {
        return z ^= 1;
    }

    @Override // l.g
    public l.g o0() {
        int cmp;
        l.f fVar;
        if (z ^= 1 == 0) {
        } else {
            long l = this.a.e();
            if (Long.compare(l, i2) > 0) {
                this.c.write(this.a, l);
            }
            return this;
        }
        IllegalStateException illegalStateException = new IllegalStateException("closed".toString());
        throw illegalStateException;
    }

    @Override // l.g
    public l.e0 timeout() {
        return this.c.timeout();
    }

    @Override // l.g
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("buffer(");
        stringBuilder.append(this.c);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // l.g
    public l.g w1(byte[] bArr) {
        n.f(bArr, "source");
        if (z ^= 1 == 0) {
        } else {
            this.a.m0(bArr);
            o0();
            return this;
        }
        IllegalStateException obj2 = new IllegalStateException("closed".toString());
        throw obj2;
    }

    @Override // l.g
    public int write(ByteBuffer byteBuffer) {
        n.f(byteBuffer, "source");
        if (z ^= 1 == 0) {
        } else {
            o0();
            return this.a.write(byteBuffer);
        }
        IllegalStateException obj2 = new IllegalStateException("closed".toString());
        throw obj2;
    }

    @Override // l.g
    public void write(l.f f, long l2) {
        n.f(f, "source");
        if (z ^= 1 == 0) {
        } else {
            this.a.write(f, l2);
            o0();
        }
        IllegalStateException obj2 = new IllegalStateException("closed".toString());
        throw obj2;
    }

    @Override // l.g
    public l.g y1(l.i i) {
        n.f(i, "byteString");
        if (z ^= 1 == 0) {
        } else {
            this.a.e0(i);
            o0();
            return this;
        }
        IllegalStateException obj2 = new IllegalStateException("closed".toString());
        throw obj2;
    }
}
