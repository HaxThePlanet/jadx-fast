package io.grpc.j1;

import com.google.common.base.n;
import com.google.common.io.a;
import io.grpc.d1;
import io.grpc.m.b;
import io.grpc.o;
import io.grpc.x;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class m1 implements io.grpc.j1.p0 {

    private final io.grpc.j1.m1.d a;
    private int b = -1;
    private io.grpc.j1.p2 c;
    private o d;
    private boolean e = true;
    private final io.grpc.j1.m1.c f;
    private final ByteBuffer g;
    private final io.grpc.j1.q2 h;
    private final io.grpc.j1.i2 i;
    private boolean j;
    private int k;
    private int l = -1;
    private long m;

    static class a {
    }

    private final class b extends OutputStream {

        private final List<io.grpc.j1.p2> a;
        private io.grpc.j1.p2 b;
        final io.grpc.j1.m1 c;
        private b(io.grpc.j1.m1 m1) {
            this.c = m1;
            super();
            ArrayList obj1 = new ArrayList();
            this.a = obj1;
        }

        b(io.grpc.j1.m1 m1, io.grpc.j1.m1.a m1$a2) {
            super(m1);
        }

        static int a(io.grpc.j1.m1.b m1$b) {
            return b.g();
        }

        static List c(io.grpc.j1.m1.b m1$b) {
            return b.a;
        }

        private int g() {
            int i;
            int i2;
            Iterator iterator = this.a.iterator();
            i = 0;
            for (p2 next2 : iterator) {
                i += i2;
            }
            return i;
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            io.grpc.j1.p2 p2Var;
            p2Var = this.b;
            if (p2Var != null && p2Var.c() > 0) {
                if (p2Var.c() > 0) {
                    this.b.d((byte)i);
                }
            }
            int i2 = 1;
            final byte[] bArr = new byte[i2];
            final int i3 = 0;
            bArr[i3] = (byte)i;
            write(bArr, i3, i2);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) {
            io.grpc.j1.p2 p2Var;
            List list;
            int obj4;
            int obj5;
            if (this.b == null) {
                p2Var = m1.c(this.c).a(i3);
                this.b = p2Var;
                this.a.add(p2Var);
            }
            while (obj5 > 0) {
                p2Var = Math.min(obj5, this.b.c());
                if (p2Var == null) {
                } else {
                }
                this.b.b(bArr, obj4, p2Var);
                obj4 += p2Var;
                obj5 -= p2Var;
                p2Var = m1.c(this.c).a(Math.max(obj5, i4 *= 2));
                this.b = p2Var;
                this.a.add(p2Var);
            }
        }
    }

    private class c extends OutputStream {

        final io.grpc.j1.m1 a;
        private c(io.grpc.j1.m1 m1) {
            this.a = m1;
            super();
        }

        c(io.grpc.j1.m1 m1, io.grpc.j1.m1.a m1$a2) {
            super(m1);
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            final int i2 = 1;
            final byte[] bArr = new byte[i2];
            final int i3 = 0;
            bArr[i3] = (byte)i;
            write(bArr, i3, i2);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) {
            m1.a(this.a, bArr, i2, i3);
        }
    }

    public interface d {
        public abstract void p(io.grpc.j1.p2 p2, boolean z2, boolean z3, int i4);
    }
    public m1(io.grpc.j1.m1.d m1$d, io.grpc.j1.q2 q22, io.grpc.j1.i2 i23) {
        super();
        int i = -1;
        this.d = m.b.a;
        int i2 = 1;
        m1.c cVar = new m1.c(this, 0);
        this.f = cVar;
        this.g = ByteBuffer.allocate(5);
        n.p(d, "sink");
        this.a = (m1.d)d;
        n.p(q22, "bufferAllocator");
        this.h = (q2)q22;
        n.p(i23, "statsTraceCtx");
        this.i = (i2)i23;
    }

    static void a(io.grpc.j1.m1 m1, byte[] b2Arr2, int i3, int i4) {
        m1.p(b2Arr2, i3, i4);
    }

    static io.grpc.j1.q2 c(io.grpc.j1.m1 m1) {
        return m1.h;
    }

    private void f(boolean z, boolean z2) {
        this.c = 0;
        this.a.p(this.c, z, z2, this.k);
        this.k = 0;
    }

    private int h(InputStream inputStream) {
        boolean z;
        if (!inputStream instanceof n0 && inputStream instanceof ByteArrayInputStream != null) {
            if (inputStream instanceof ByteArrayInputStream != null) {
            }
            return -1;
        }
        return inputStream.available();
    }

    private void i() {
        io.grpc.j1.p2 p2Var;
        p2Var = this.c;
        if (p2Var != null) {
            p2Var.a();
            this.c = 0;
        }
    }

    private void l() {
        if (isClosed()) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("Framer already closed");
        throw illegalStateException;
    }

    private void m(io.grpc.j1.m1.b m1$b, boolean z2) {
        io.grpc.j1.m1.d dVar;
        int i;
        int obj7;
        final int i2 = m1.b.a(b);
        this.g.clear();
        this.g.put(z2).putInt(i2);
        obj7 = this.h.a(5);
        final int i6 = 0;
        obj7.b(this.g.array(), i6, this.g.position());
        if (i2 == 0) {
            this.c = obj7;
        }
        final int i7 = 1;
        this.a.p(obj7, i6, i6, i5 -= i7);
        this.k = i7;
        List obj6 = m1.b.c(b);
        obj7 = i6;
        while (obj7 < size -= i7) {
            this.a.p((p2)obj6.get(obj7), i6, i6, i6);
            obj7++;
        }
        this.c = (p2)obj6.get(obj7 -= i7);
        this.m = (long)i2;
    }

    private int n(InputStream inputStream, int i2) {
        m1.b obj5 = new m1.b(this, 0);
        OutputStream outputStream = this.d.c(obj5);
        int obj4 = m1.q(inputStream, outputStream);
        outputStream.close();
        int i3 = this.b;
        final int i5 = 1;
        if (i3 >= 0) {
            if (obj4 > i3) {
            } else {
            }
            Object[] arr = new Object[2];
            arr[i5] = Integer.valueOf(this.b);
            throw d1.l.r(String.format("message too large %d > %d", arr)).d();
        }
        m(obj5, i5);
        return obj4;
    }

    private int o(InputStream inputStream, int i2) {
        Object p2Var;
        int i;
        int obj5;
        int i3 = this.b;
        int i5 = 0;
        if (i3 >= 0) {
            if (i2 > i3) {
            } else {
            }
            Object[] arr = new Object[2];
            arr[i5] = Integer.valueOf(i2);
            arr[1] = Integer.valueOf(this.b);
            throw d1.l.r(String.format("message too large %d > %d", arr)).d();
        }
        this.g.clear();
        this.g.put(i5).putInt(i2);
        if (this.c == null) {
            this.c = this.h.a(position2 += i2);
        }
        p(this.g.array(), i5, this.g.position());
        return m1.q(inputStream, this.f);
    }

    private void p(byte[] bArr, int i2, int i3) {
        io.grpc.j1.p2 p2Var;
        io.grpc.j1.p2 p2Var2;
        while (i3 > 0) {
            p2Var = this.c;
            if (p2Var != null && p2Var.c() == 0) {
            }
            if (this.c == null) {
            }
            int i4 = Math.min(i3, this.c.c());
            this.c.b(bArr, i2, i4);
            i2 += i4;
            i3 -= i4;
            this.c = this.h.a(i3);
            if (p2Var.c() == 0) {
            }
            p2Var = 0;
            f(p2Var, p2Var);
        }
    }

    private static int q(InputStream inputStream, OutputStream outputStream2) {
        int i;
        if (inputStream instanceof x) {
            return (x)inputStream.a(outputStream2);
        }
        long obj2 = a.b(inputStream, outputStream2);
        i = Long.compare(obj2, i2) <= 0 ? 1 : 0;
        n.j(i, "Message size overflow: %s", obj2);
        return (int)obj2;
    }

    private int r(InputStream inputStream, int i2) {
        if (i2 != -1) {
            this.m = (long)i2;
            return o(inputStream, i2);
        }
        m1.b obj4 = new m1.b(this, 0);
        int obj3 = m1.q(inputStream, obj4);
        int i4 = this.b;
        int i6 = 0;
        if (i4 >= 0) {
            if (obj3 > i4) {
            } else {
            }
            Object[] arr = new Object[2];
            arr[i6] = Integer.valueOf(obj3);
            arr[1] = Integer.valueOf(this.b);
            throw d1.l.r(String.format("message too large %d > %d", arr)).d();
        }
        m(obj4, i6);
        return obj3;
    }

    @Override // io.grpc.j1.p0
    public io.grpc.j1.p0 b(boolean z) {
        k(z);
        return this;
    }

    @Override // io.grpc.j1.p0
    public void close() {
        boolean closed;
        io.grpc.j1.p2 p2Var;
        closed = 1;
        this.j = closed;
        p2Var = this.c;
        if (!isClosed() && p2Var != null && p2Var.g() == 0) {
            closed = 1;
            this.j = closed;
            p2Var = this.c;
            if (p2Var != null) {
                if (p2Var.g() == 0) {
                    i();
                }
            }
            f(closed, closed);
        }
    }

    @Override // io.grpc.j1.p0
    public io.grpc.j1.p0 d(o o) {
        j(o);
        return this;
    }

    @Override // io.grpc.j1.p0
    public void e(InputStream inputStream) {
        boolean z;
        int i;
        io.grpc.m mVar;
        int obj8;
        String str2 = "Failed to frame message";
        l();
        int i8 = 1;
        this.k = i4 += i8;
        i6 += i8;
        this.l = i7;
        this.m = 0;
        this.i.i(i7);
        int i11 = 0;
        if (this.e && this.d != m.b.a) {
            i = this.d != m.b.a ? i8 : i11;
        } else {
        }
        int i12 = h(inputStream);
        if (i12 != 0 && i != 0) {
            if (i != 0) {
                obj8 = n(inputStream, i12);
            } else {
                obj8 = r(inputStream, i12);
            }
        } else {
        }
        if (i12 != -1) {
            if (obj8 != i12) {
            } else {
            }
            Object[] arr = new Object[2];
            arr[i11] = Integer.valueOf(obj8);
            arr[i8] = Integer.valueOf(i12);
            throw d1.m.r(String.format("Message length inaccurate %s != %s", arr)).d();
        }
        final long l3 = (long)obj8;
        this.i.k(l3);
        this.i.l(this.m);
        this.i.j(this.l, this.m, i12);
    }

    @Override // io.grpc.j1.p0
    public void flush() {
        io.grpc.j1.p2 p2Var;
        int i;
        p2Var = this.c;
        if (p2Var != null && p2Var.g() > 0) {
            if (p2Var.g() > 0) {
                f(false, true);
            }
        }
    }

    @Override // io.grpc.j1.p0
    public void g(int i) {
        int i2;
        i2 = this.b == -1 ? 1 : 0;
        n.v(i2, "max size already set");
        this.b = i;
    }

    @Override // io.grpc.j1.p0
    public boolean isClosed() {
        return this.j;
    }

    @Override // io.grpc.j1.p0
    public io.grpc.j1.m1 j(o o) {
        n.p(o, "Can't pass an empty compressor");
        this.d = (o)o;
        return this;
    }

    @Override // io.grpc.j1.p0
    public io.grpc.j1.m1 k(boolean z) {
        this.e = z;
        return this;
    }
}
