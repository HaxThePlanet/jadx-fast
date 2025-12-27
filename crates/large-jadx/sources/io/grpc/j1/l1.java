package io.grpc.j1;

import com.google.common.base.n;
import io.grpc.d1;
import io.grpc.m.b;
import io.grpc.v;
import java.io.Closeable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.DataFormatException;

/* compiled from: MessageDeframer.java */
/* loaded from: classes3.dex */
public class l1 implements Closeable, y {

    private l1.e A;
    private int B = 5;
    private boolean C;
    private u D;
    private u E = new u();
    private long F;
    private boolean G = false;
    private int H = -1;
    private int I;
    private boolean J = false;
    private volatile boolean K = false;
    private l1.b a;
    private int b;
    private final i2 c;
    private final o2 v;
    private v w;
    private s0 x;
    private byte[] y;
    private int z;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[l1.e.values().length];
            l1.a.a = iArr;
            try {
                iArr[l1.e.HEADER.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                l1.a.a[l1.e.BODY.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    public interface b {
        void a(k2.a aVar);

        void b(boolean z);

        void c(int i);

        void d(Throwable th);
    }

    static final class d extends FilterInputStream {

        private final int a;
        private final i2 b;
        private long c;
        private long v;
        private long w = -1;
        d(InputStream inputStream, int i, i2 i2Var) {
            super(inputStream);
            this.a = i;
            this.b = i2Var;
        }

        private void a() {
            if (this.v > this.c) {
                this.b.f(l - l3);
                this.c = this.v;
            }
        }

        private void c() {
            long l2 = (long)i2;
            if (this.v > l2) {
                Object[] arr = new Object[1];
                throw d1.l.r(String.format("Decompressed gRPC message exceeds maximum size %d", new Object[] { Integer.valueOf(this.a) })).d();
            }
        }

        @Override // java.io.FilterInputStream
        public synchronized void mark(int i) {
            this.in.mark(i);
            this.w = this.v;
        }

        @Override // java.io.FilterInputStream
        public int read() throws IOException {
            int bytesRead = this.in.read();
            int i = -1;
            if (bytesRead != -1) {
                long l = 1L;
                this.v += l;
            }
            c();
            a();
            return bytesRead;
        }

        @Override // java.io.FilterInputStream
        public synchronized void reset() {
            this.in.reset();
            this.v = this.w;
            throw new IOException("Mark not supported");
        }

        @Override // java.io.FilterInputStream
        public long skip(long j) throws IOException {
            final long skipped = this.in.skip(j);
            this.v += skipped;
            c();
            a();
            return skipped;
        }

        @Override // java.io.FilterInputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            final int bytesRead = this.in.read(bArr, i, i2);
            i = -1;
            if (bytesRead != -1) {
                this.v += l;
            }
            c();
            a();
            return bytesRead;
        }
    }

    private enum e {

        BODY,
        HEADER;
    }

    private static class c implements k2.a {

        private InputStream a;
        /* synthetic */ c(InputStream inputStream, l1.a aVar) {
            this(inputStream);
        }

        public InputStream next() {
            this.a = null;
            return this.a;
        }

        private c(InputStream inputStream) {
            super();
            this.a = inputStream;
        }
    }
    public l1(l1.b bVar, v vVar, int i, i2 i2Var, o2 o2Var) {
        super();
        this.A = l1.e.HEADER;
        io.grpc.j1.u uVar = new u();
        n.p(bVar, "sink");
        this.a = bVar;
        n.p(vVar, "decompressor");
        this.w = vVar;
        this.b = i;
        n.p(i2Var, "statsTraceCtx");
        this.c = i2Var;
        n.p(o2Var, "transportTracer");
        this.v = o2Var;
    }

    private void a() {
        long l = 0;
        if (this.G) {
            return;
        }
        boolean z5 = true;
        this.G = z5;
        while (/* condition */) {
            try {
                close();
            } finally {
                this.G = z7;
                throw th;
            }
        }
    }

    private InputStream c() {
        if (this.w == m.b.a) {
            throw d1.m.r("Can't decode compressed gRPC message as compression not configured").d();
        } else {
            try {
            } catch (java.io.IOException ioException) {
                throw new RuntimeException(ioException);
            }
            return new l1.d(this.w.b(w1.c(this.D, true)), this.b, this.c);
        }
    }

    private InputStream m() {
        this.c.f((long)this.D.g());
        return w1.c(this.D, true);
    }

    private boolean n() {
        boolean z = false;
        if (isClosed() || this.J) {
            int i2 = 1;
        }
        return z;
    }

    private boolean o() {
        boolean z2 = true;
        if (this.x != null) {
            return this.x.F();
        }
        int r0 = this.E.g() == 0 ? 1 : 0;
        return (this.E.g() == 0 ? 1 : 0);
    }

    private void q() {
        InputStream inputStream;
        this.c.e(this.H, (long)this.I, -1L);
        this.I = 0;
        if (this.C) {
            inputStream = c();
        } else {
            inputStream = m();
        }
        io.grpc.j1.u uVar = null;
        this.D = uVar;
        this.a.a(new l1.c(inputStream, uVar));
        this.A = l1.e.HEADER;
        this.B = 5;
    }

    private void r() {
        int i;
        int unsignedByte = this.D.readUnsignedByte();
        if (unsignedByte & 254 != 0) {
            throw d1.m.r("gRPC frame header malformed: reserved bits not zero").d();
        } else {
            i = 1;
            i = 0;
            int r0 = i;
            this.C = i;
            r0 = i.readInt();
            this.B = r0;
            if (r0 < 0) {
                Object[] arr = new Object[2];
                throw d1.l.r(String.format("gRPC message exceeds maximum size %d: %d", new Object[] { Integer.valueOf(this.b), Integer.valueOf(this.B) })).d();
            } else {
                if (r0 <= this.b) {
                    this.H += i;
                    this.c.d(i5);
                    this.v.d();
                    this.A = l1.e.BODY;
                    return;
                }
            }
        }
    }

    private boolean w() {
        Throwable th;
        int i;
        Object obj;
        RuntimeException l;
        io.grpc.j1.l1.e bODY2;
        io.grpc.j1.u uVar3;
        int i7;
        i = 0;
        try {
            if (this.D == null) {
                this.D = new u();
            }
        } catch (Throwable th) {
        }
        i2 = this.B - this.D.g();
        while (this.B > 0) {
            if (this.E.g() == 0) {
            }
            try {
                int i3 = this.x.x(this.y, this.z, Math.min(i2, this.y.length - this.z));
                i = i + this.x.o();
            } catch (java.util.zip.DataFormatException dataFormat) {
            } catch (java.io.IOException unused) {
            } catch (Throwable th2) {
                th = th2;
                th2 = th;
            }
            i = i + this.x.q();
            if (this.B == 0) {
            }
        }
        if (this.D > 0) {
            this.a.c(i);
            io.grpc.j1.l1.e bODY24 = l1.e.BODY;
            if (this.A == l1.e.BODY && this.x != null) {
                this.c.g((long)i);
                this.I += i;
            }
        }
        return true;
    }

    void E(l1.b bVar) {
        this.a = bVar;
    }

    void F() {
        this.K = true;
    }

    @Override // java.io.Closeable
    public void close() {
        int i;
        boolean z;
        if (isClosed()) {
            return;
        }
        i = 1;
        i = 0;
        Throwable th = this.D != null && this.D.g() > 0 ? 1 : i;
        final io.grpc.j1.s0 s0Var3 = null;
        try {
            if (this.x != null && this.D == 0) {
                if (!(this.x.r())) {
                }
                this.x.close();
            }
            if (this.E != null) {
                this.E.close();
            }
            if (this.D != null) {
                this.D.close();
            }
        } finally {
            this.x = s0Var2;
            this.E = s0Var2;
            this.D = s0Var2;
            throw (this.D != null && this.D.g() > 0 ? 1 : i);
        }
        this.x = s0Var3;
        this.E = s0Var3;
        this.D = s0Var3;
        this.a.b(z);
    }

    public void e(int i) {
        boolean z = true;
        int r0 = i > 0 ? 1 : 0;
        n.e((i > 0 ? 1 : 0), "numMessages must be > 0");
        if (this.isClosed()) {
            return;
        }
        this.F += l3;
        a();
    }

    public void f(int i) {
        this.b = i;
    }

    public void i() {
        if (isClosed()) {
            return;
        }
        if (o()) {
            close();
        } else {
            boolean z = true;
            this.J = z;
        }
    }

    public boolean isClosed() {
        boolean z = false;
        int r0 = this.E == null && this.x == null ? 1 : 0;
        return (this.E == null && this.x == null ? 1 : 0);
    }

    public void j(v vVar) {
        boolean z = true;
        int r0 = this.x == null ? 1 : 0;
        n.v((this.x == null ? 1 : 0), "Already set full stream decompressor");
        n.p(vVar, (this.x == null ? 1 : 0));
        this.w = vVar;
    }

    public void k(v1 v1Var) {
        int i = 1;
        Throwable th;
        io.grpc.j1.s0 s0Var;
        n.p(v1Var, "data");
        i = 1;
        try {
            if (!n()) {
                if (this.x != null) {
                    this.x.m(v1Var);
                } else {
                    this.E.c(v1Var);
                }
                i = 0;
                a();
            }
        } catch (Throwable th) {
        }
        if (i != 0) {
            v1Var.close();
        }
    }

    public void x(s0 s0Var) {
        boolean z;
        boolean z2 = true;
        final int i2 = 0;
        int r0 = this.w == m.b.a ? 1 : i2;
        n.v((this.w == m.b.a ? 1 : i2), "per-message decompressor already set");
        if (this.x != null) {
        }
        n.v(z2, "full stream decompressor already set");
        n.p(s0Var, "Can't pass a null full stream decompressor");
        this.x = s0Var;
        this.E = null;
    }
}
