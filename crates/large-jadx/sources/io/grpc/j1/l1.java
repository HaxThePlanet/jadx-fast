package io.grpc.j1;

import com.google.common.base.n;
import io.grpc.d1;
import io.grpc.m.b;
import io.grpc.v;
import java.io.Closeable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class l1 implements Closeable, io.grpc.j1.y {

    private io.grpc.j1.l1.e A;
    private int B = 5;
    private boolean C;
    private io.grpc.j1.u D;
    private io.grpc.j1.u E;
    private long F;
    private boolean G = false;
    private int H = -1;
    private int I;
    private boolean J = false;
    private volatile boolean K = false;
    private io.grpc.j1.l1.b a;
    private int b;
    private final io.grpc.j1.i2 c;
    private final io.grpc.j1.o2 v;
    private v w;
    private io.grpc.j1.s0 x;
    private byte[] y;
    private int z;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            l1.a.a = iArr;
            iArr[l1.e.HEADER.ordinal()] = 1;
            l1.a.a[l1.e.BODY.ordinal()] = 2;
        }
    }

    public interface b {
        public abstract void a(io.grpc.j1.k2.a k2$a);

        public abstract void b(boolean z);

        public abstract void c(int i);

        public abstract void d(Throwable throwable);
    }

    static final class d extends FilterInputStream {

        private final int a;
        private final io.grpc.j1.i2 b;
        private long c;
        private long v;
        private long w = -1;
        d(InputStream inputStream, int i2, io.grpc.j1.i2 i23) {
            super(inputStream);
            final int i = -1;
            this.a = i2;
            this.b = i23;
        }

        private void a() {
            long l;
            int cmp;
            l = this.v;
            final long l2 = this.c;
            if (Long.compare(l, l2) > 0) {
                this.b.f(l -= l2);
                this.c = this.v;
            }
        }

        private void c() {
            int i2 = this.a;
            if (Long.compare(l, l2) > 0) {
            } else {
            }
            Object[] arr = new Object[1];
            throw d1.l.r(String.format("Decompressed gRPC message exceeds maximum size %d", Integer.valueOf(i2))).d();
        }

        @Override // java.io.FilterInputStream
        public void mark(int i) {
            this.in.mark(i);
            this.w = this.v;
            return;
            synchronized (this) {
                this.in.mark(i);
                this.w = this.v;
            }
        }

        @Override // java.io.FilterInputStream
        public int read() {
            int i;
            int i2;
            int read = this.in.read();
            if (read != -1) {
                this.v = l += i2;
            }
            c();
            a();
            return read;
        }

        @Override // java.io.FilterInputStream
        public int read(byte[] bArr, int i2, int i3) {
            InputStream inputStream;
            int obj4;
            final int obj3 = this.in.read(bArr, i2, i3);
            if (obj3 != -1) {
                this.v = obj4 += inputStream;
            }
            c();
            a();
            return obj3;
        }

        @Override // java.io.FilterInputStream
        public void reset() {
            synchronized (this) {
                try {
                    if (Long.compare(l, i) == 0) {
                    } else {
                    }
                    this.in.reset();
                    this.v = this.w;
                    IOException iOException = new IOException("Mark not set");
                    throw iOException;
                    IOException iOException2 = new IOException("Mark not supported");
                    throw iOException2;
                    throw th;
                }
            }
        }

        @Override // java.io.FilterInputStream
        public long skip(long l) {
            final long obj3 = this.in.skip(l);
            this.v = l2 += obj3;
            c();
            a();
            return obj3;
        }
    }

    private static enum e {

        HEADER,
        BODY;
    }

    private static class c implements io.grpc.j1.k2.a {

        private InputStream a;
        private c(InputStream inputStream) {
            super();
            this.a = inputStream;
        }

        c(InputStream inputStream, io.grpc.j1.l1.a l1$a2) {
            super(inputStream);
        }

        @Override // io.grpc.j1.k2$a
        public InputStream next() {
            this.a = 0;
            return this.a;
        }
    }
    public l1(io.grpc.j1.l1.b l1$b, v v2, int i3, io.grpc.j1.i2 i24, io.grpc.j1.o2 o25) {
        super();
        this.A = l1.e.HEADER;
        int i = 5;
        u uVar = new u();
        this.E = uVar;
        int i2 = 0;
        final int i4 = -1;
        n.p(b, "sink");
        this.a = (l1.b)b;
        n.p(v2, "decompressor");
        this.w = (v)v2;
        this.b = i3;
        n.p(i24, "statsTraceCtx");
        this.c = (i2)i24;
        n.p(o25, "transportTracer");
        this.v = (o2)o25;
    }

    private void a() {
        boolean z;
        boolean z2;
        int i2;
        boolean cmp;
        int ordinal;
        int i;
        if (this.G) {
        }
        int i3 = 1;
        this.G = i3;
        z2 = 0;
        while (!this.K) {
            i2 = l1.a.a[this.A.ordinal()];
            r();
            z2 = 0;
            q();
            this.F = l2 -= i;
        }
        if (this.K) {
            close();
            this.G = z2;
        }
        if (this.J && o()) {
            if (o()) {
                close();
            }
        }
        this.G = z2;
    }

    private InputStream c() {
        v vVar = this.w;
        if (vVar == m.b.a) {
        } else {
            l1.d dVar = new l1.d(vVar.b(w1.c(this.D, true)), this.b, this.c);
            return dVar;
        }
        throw d1.m.r("Can't decode compressed gRPC message as compression not configured").d();
    }

    private InputStream m() {
        this.c.f((long)i);
        return w1.c(this.D, true);
    }

    private boolean n() {
        int i;
        boolean closed;
        if (!isClosed()) {
            if (this.J) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private boolean o() {
        int i;
        io.grpc.j1.s0 s0Var = this.x;
        if (s0Var != null) {
            return s0Var.F();
        }
        i = this.E.g() == 0 ? 1 : 0;
        return i;
    }

    private void q() {
        InputStream inputStream;
        this.c.e(this.H, (long)i5, obj3);
        this.I = 0;
        if (this.C) {
            inputStream = c();
        } else {
            inputStream = m();
        }
        int i4 = 0;
        this.D = i4;
        l1.c cVar = new l1.c(inputStream, i4);
        this.a.a(cVar);
        this.A = l1.e.HEADER;
        this.B = 5;
    }

    private void r() {
        int i;
        int i2;
        int unsignedByte = this.D.readUnsignedByte();
        if (unsignedByte & 254 != 0) {
        } else {
            int i7 = 1;
            int i8 = 0;
            i = unsignedByte &= i7 != 0 ? i7 : i8;
            this.C = i;
            int int = this.D.readInt();
            this.B = int;
            if (int < 0) {
            } else {
                if (int > this.b) {
                } else {
                    i4 += i7;
                    this.H = i5;
                    this.c.d(i5);
                    this.v.d();
                    this.A = l1.e.BODY;
                }
            }
            Object[] arr = new Object[2];
            arr[i8] = Integer.valueOf(this.b);
            arr[i7] = Integer.valueOf(this.B);
            throw d1.l.r(String.format("gRPC message exceeds maximum size %d: %d", arr)).d();
        }
        throw d1.m.r("gRPC frame header malformed: reserved bits not zero").d();
    }

    private boolean w() {
        Throwable th2;
        io.grpc.j1.u uVar;
        int i;
        Throwable th;
        int i3;
        RuntimeException exc;
        int i4;
        io.grpc.j1.l1.e bODY3;
        int bODY2;
        int bArr;
        int bODY;
        int bODY4;
        io.grpc.j1.v1 v1Var;
        int i2;
        Throwable th3;
        int i5 = 0;
        if (this.D == null) {
            try {
                uVar = new u();
                this.D = uVar;
                i3 = i;
                i13 -= bODY4;
                bArr = this.y;
                if (bArr != null) {
                } else {
                }
                if (this.z == bArr.length) {
                }
                this.y = new byte[Math.min(i4, 2097152)];
                this.z = i5;
                exc = this.x.x(this.y, this.z, Math.min(i4, length -= i22));
                i += i18;
                i3 += bODY;
                this.a.c(i);
                bODY = l1.e.BODY;
            } catch (Throwable th) {
            }
            this.a.c(i);
            bODY4 = l1.e.BODY;
            if (i > 0 && this.A == bODY4) {
                this.a.c(i);
                bODY4 = l1.e.BODY;
                if (this.A == bODY4) {
                    if (this.x != null) {
                        try {
                            this.c.g((long)i3);
                            this.I = i9 += i3;
                            this.c.g((long)i);
                            this.I = i12 += i;
                            return 1;
                            th2 = th4;
                            Throwable th4 = th3;
                            th = th4;
                            if (th4 <= 0) {
                            } else {
                            }
                            exc = this.a;
                            exc.c(th4);
                            exc = this.A;
                            bODY3 = l1.e.BODY;
                            if (exc != bODY3) {
                            } else {
                            }
                            exc = this.x;
                            if (exc != null) {
                            } else {
                            }
                            th4 = this.c;
                            exc = (long)th;
                            th4.g(exc);
                            th4 = this.I;
                            th4 += th;
                            this.I = th4;
                            th = this.c;
                            exc = (long)th4;
                            th.g(exc);
                            th = this.I;
                            th += th4;
                            this.I = th;
                            throw th2;
                        }
                    } else {
                    }
                }
            }
        }
    }

    @Override // java.io.Closeable
    void E(io.grpc.j1.l1.b l1$b) {
        this.a = b;
    }

    @Override // java.io.Closeable
    void F() {
        this.K = true;
    }

    @Override // java.io.Closeable
    public void close() {
        int i;
        io.grpc.j1.u uVar;
        int i2;
        if (isClosed()) {
        }
        uVar = this.D;
        final int i3 = 0;
        if (uVar != null && uVar.g() > 0) {
            i = uVar.g() > 0 ? i2 : i3;
        } else {
        }
        final int i4 = 0;
        final io.grpc.j1.s0 s0Var2 = this.x;
        if (s0Var2 != null && i == 0) {
            if (i == 0) {
                if (s0Var2.r()) {
                } else {
                    i2 = i3;
                }
            }
            this.x.close();
            i = i2;
        }
        io.grpc.j1.u uVar2 = this.E;
        if (uVar2 != null) {
            uVar2.close();
        }
        io.grpc.j1.u uVar3 = this.D;
        if (uVar3 != null) {
            uVar3.close();
        }
        this.x = i4;
        this.E = i4;
        this.D = i4;
        this.a.b(i);
    }

    @Override // java.io.Closeable
    public void e(int i) {
        int i2;
        i2 = i > 0 ? 1 : 0;
        n.e(i2, "numMessages must be > 0");
        if (isClosed()) {
        }
        this.F = l += l2;
        a();
    }

    @Override // java.io.Closeable
    public void f(int i) {
        this.b = i;
    }

    @Override // java.io.Closeable
    public void i() {
        boolean z;
        if (isClosed()) {
        }
        if (o()) {
            close();
        } else {
            this.J = true;
        }
    }

    @Override // java.io.Closeable
    public boolean isClosed() {
        Object uVar;
        int i;
        if (this.E == null && this.x == null) {
            i = this.x == null ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // java.io.Closeable
    public void j(v v) {
        int i;
        i = this.x == null ? 1 : 0;
        n.v(i, "Already set full stream decompressor");
        n.p(v, "Can't pass an empty decompressor");
        this.w = (v)v;
    }

    @Override // java.io.Closeable
    public void k(io.grpc.j1.v1 v1) {
        int i;
        Throwable th;
        boolean z;
        n.p(v1, "data");
        i = 1;
        if (!n()) {
            z = this.x;
            if (z != null) {
                z.m(v1);
            } else {
                this.E.c(v1);
            }
            i = 0;
            a();
        }
        if (i != 0) {
            try {
                v1.close();
                if (obj0 == null) {
                } else {
                }
                v1.close();
                throw th;
            }
        }
    }

    @Override // java.io.Closeable
    public void x(io.grpc.j1.s0 s0) {
        int i;
        int i2;
        final int i3 = 0;
        i = this.w == m.b.a ? i2 : i3;
        n.v(i, "per-message decompressor already set");
        if (this.x == null) {
        } else {
            i2 = i3;
        }
        n.v(i2, "full stream decompressor already set");
        n.p(s0, "Can't pass a null full stream decompressor");
        this.x = (s0)s0;
        this.E = 0;
    }
}
