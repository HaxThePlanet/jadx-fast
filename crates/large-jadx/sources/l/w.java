package l;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import kotlin.d0.d.n;

/* compiled from: RealBufferedSink.kt */
/* loaded from: classes3.dex */
public final class w implements g {

    public final f a = new f();
    public boolean b;
    public final b0 c;

    public static final class a extends OutputStream {

        final /* synthetic */ w a;
        a() {
            this.a = wVar;
            super();
        }

        @Override // java.io.OutputStream
        public void close() {
            this.a.close();
        }

        @Override // java.io.OutputStream
        public void flush() {
            if (!wVar.b) {
                this.a.flush();
            }
        }

        @Override // java.io.OutputStream
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = ".outputStream()";
            str = this.a + str2;
            return str;
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            if (wVar.b) {
                throw new IOException("closed");
            } else {
                wVar.a.z0((byte)i);
                this.a.o0();
                return;
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            n.f(bArr, "data");
            if (wVar.b) {
                throw new IOException("closed");
            } else {
                wVar.a.v0(bArr, i, i2);
                this.a.o0();
                return;
            }
        }
    }
    public w(b0 b0Var) {
        n.f(b0Var, "sink");
        super();
        this.c = b0Var;
        final l.f fVar = new f();
    }

    public g E0(String str) {
        n.f(str, "string");
        if (!this.b == 0) {
            throw new IllegalStateException("closed".toString());
        } else {
            this.a.b1(str);
            o0();
            return this;
        }
    }

    public g G() {
        if (!this.b == 0) {
            throw new IllegalStateException("closed".toString());
        } else {
            long size = this.a.size();
            if (size > 0) {
                this.c.write(this.a, size);
            }
            return this;
        }
    }

    public g I(int i) {
        if (!this.b == 0) {
            throw new IllegalStateException("closed".toString());
        } else {
            this.a.L0(i);
            o0();
            return this;
        }
    }

    public g P(int i) {
        if (!this.b == 0) {
            throw new IllegalStateException("closed".toString());
        } else {
            this.a.G0(i);
            o0();
            return this;
        }
    }

    public g U0(String str, int i, int i2) {
        n.f(str, "string");
        if (!this.b == 0) {
            throw new IllegalStateException("closed".toString());
        } else {
            this.a.e1(str, i, i2);
            o0();
            return this;
        }
    }

    public long W0(d0 d0Var) {
        int i = 0;
        int cmp;
        n.f(d0Var, "source");
        i = 0;
        l = (long)8192;
        long read = d0Var.read(this.a, l);
        while (read == -1) {
            i = i + read;
            o0();
            l = (long)8192;
            read = d0Var.read(this.a, (long)8192);
        }
        return i;
    }

    public g X0(long j) {
        if (!this.b == 0) {
            throw new IllegalStateException("closed".toString());
        } else {
            this.a.C0(j);
            o0();
            return this;
        }
    }

    public g Y1(long j) {
        if (!this.b == 0) {
            throw new IllegalStateException("closed".toString());
        } else {
            this.a.A0(j);
            o0();
            return this;
        }
    }

    public g b(byte[] bArr, int i, int i2) {
        n.f(bArr, "source");
        if (!this.b == 0) {
            throw new IllegalStateException("closed".toString());
        } else {
            this.a.v0(bArr, i, i2);
            o0();
            return this;
        }
    }

    public OutputStream b2() {
        return new w.a(this);
    }

    public g c0(int i) {
        if (!this.b == 0) {
            throw new IllegalStateException("closed".toString());
        } else {
            this.a.z0(i);
            o0();
            return this;
        }
    }

    public void close() {
        int i = 0;
        l.f fVar;
        long size = 0;
        if (this.b) {
            return;
        } else {
            i = 0;
            try {
                long size2 = this.a.size();
                size = 0L;
                this.c.write(this.a, this.a.size());
            } catch (Throwable th) {
            }
            try {
                this.c.close();
            } catch (Throwable th) {
            }
            boolean z = true;
            this.b = z;
        }
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) i;
    }

    public void flush() {
        if (!this.b == 0) {
            throw new IllegalStateException("closed".toString());
        } else {
            long size2 = this.a.size();
            long size = 0L;
            if (size2 > size) {
                this.c.write(this.a, this.a.size());
            }
            this.c.flush();
            return;
        }
    }

    public f h() {
        return this.a;
    }

    public boolean isOpen() {
        return !this.b;
    }

    public g o0() {
        if (!this.b == 0) {
            throw new IllegalStateException("closed".toString());
        } else {
            long l = this.a.e();
            if (l > 0) {
                this.c.write(this.a, l);
            }
            return this;
        }
    }

    public e0 timeout() {
        return this.c.timeout();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "buffer(";
        str = str2 + this.c + 41;
        return str;
    }

    public g w1(byte[] bArr) {
        n.f(bArr, "source");
        if (!this.b == 0) {
            throw new IllegalStateException("closed".toString());
        } else {
            this.a.m0(bArr);
            o0();
            return this;
        }
    }

    public int write(ByteBuffer byteBuffer) {
        n.f(byteBuffer, "source");
        if (!this.b == 0) {
            throw new IllegalStateException("closed".toString());
        } else {
            o0();
            return this.a.write(byteBuffer);
        }
    }

    public g y1(i iVar) {
        n.f(iVar, "byteString");
        if (!this.b == 0) {
            throw new IllegalStateException("closed".toString());
        } else {
            this.a.e0(iVar);
            o0();
            return this;
        }
    }

    public void write(f fVar, long j) {
        n.f(fVar, "source");
        if (!this.b == 0) {
            throw new IllegalStateException("closed".toString());
        } else {
            this.a.write(fVar, j);
            o0();
            return;
        }
    }
}
