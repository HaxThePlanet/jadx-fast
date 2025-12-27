package io.grpc.j1;

import com.google.common.base.n;
import com.google.common.io.a;
import io.grpc.d1;
import io.grpc.m.b;
import io.grpc.o;
import io.grpc.x;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: MessageFramer.java */
/* loaded from: classes3.dex */
public class m1 implements p0 {

    private final m1.d a;
    private int b = -1;
    private p2 c;
    private o d;
    private boolean e = true;
    private final m1.c f = new m1$c();
    private final ByteBuffer g;
    private final q2 h;
    private final i2 i;
    private boolean j;
    private int k;
    private int l = -1;
    private long m;

    static class a {
    }

    private final class b extends OutputStream {

        private final List<p2> a;
        private p2 b;
        final /* synthetic */ m1 c;
        private b() {
            this.c = m1Var;
            super();
            this.a = new ArrayList();
        }

        static /* synthetic */ int a(m1.b bVar) {
            return bVar.g();
        }

        static /* synthetic */ List c(m1.b bVar) {
            return bVar.a;
        }

        private int g() {
            int i = 0;
            Iterator it = this.a.iterator();
            i = 0;
            while (it.hasNext()) {
                i = i + (p2)it.next().g();
            }
            return i;
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            if (this.b != null && this.b.c() > 0) {
                this.b.d((byte)i);
                return;
            }
            int i2 = 1;
            final byte[] bArr = new byte[i2];
            final int i4 = 0;
            bArr[i4] = (byte)i;
            write(bArr, i4, i2);
        }

        /* synthetic */ b(m1.a aVar) {
            this(m1Var);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            int i4;
            if (this.b == null) {
                io.grpc.j1.p2 p2Var = this.c.h.a(i2);
                this.b = p2Var;
                this.a.add(p2Var);
            }
            while (i4 > 0) {
                int min = Math.min(i4, this.b.c());
            }
        }
    }

    private class c extends OutputStream {

        final /* synthetic */ m1 a;
        private c() {
            this.a = m1Var;
            super();
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            final int i2 = 1;
            final byte[] bArr = new byte[i2];
            final int i3 = 0;
            bArr[i3] = (byte)i;
            write(bArr, i3, i2);
        }

        /* synthetic */ c(m1.a aVar) {
            this(m1Var);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            this.a.p(bArr, i, i2);
        }
    }

    public interface d {
        void p(p2 p2Var, boolean z, boolean z2, int i);
    }
    public m1(m1.d dVar, q2 q2Var, i2 i2Var) {
        super();
        this.d = m.b.a;
        io.grpc.j1.m1.c cVar = new m1.c(this, null);
        this.g = ByteBuffer.allocate(5);
        n.p(dVar, "sink");
        this.a = dVar;
        n.p(q2Var, "bufferAllocator");
        this.h = q2Var;
        n.p(i2Var, "statsTraceCtx");
        this.i = i2Var;
    }

    static /* synthetic */ void a(m1 m1Var, byte[] bArr, int i, int i2) {
        m1Var.p(bArr, i, i2);
    }

    static /* synthetic */ q2 c(m1 m1Var) {
        return m1Var.h;
    }

    private void f(boolean z, boolean z2) {
        this.c = null;
        this.a.p(this.c, z, z2, this.k);
        this.k = 0;
    }

    private int h(InputStream inputStream) throws IOException {
        z = inputStream instanceof n0;
        if (!(inputStream instanceof n0)) {
            z = inputStream instanceof ByteArrayInputStream;
            return -1;
        }
        return inputStream.available();
    }

    private void i() {
        if (this.c != null) {
            this.c.a();
            io.grpc.j1.p2 p2Var = null;
            this.c = p2Var;
        }
    }

    private void l() {
        if (isClosed()) {
            throw new IllegalStateException("Framer already closed");
        }
    }

    private void m(m1.b bVar, boolean z) {
        int i2;
        final int i3 = bVar.g();
        this.g.clear();
        this.g.put(z).putInt(i3);
        io.grpc.j1.p2 p2Var = this.h.a(5);
        i2 = 0;
        p2Var.b(this.g.array(), i2, this.g.position());
        if (i3 == 0) {
            this.c = p2Var;
            return;
        }
        final int i7 = 1;
        i = this.k - i7;
        this.a.p(p2Var, false, false, i);
        this.k = i7;
        List list = bVar.a;
        while (this.h < list.size() - i7) {
            this.a.p((p2)list.get(i2), false, false, i2);
            i2 = i2 + 1;
        }
        this.c = (p2)list.get(list.size() - i7);
        this.m = (long)i3;
    }

    private int n(InputStream inputStream, int i) {
        io.grpc.j1.m1.b bVar = new m1.b(this, null);
        OutputStream outputStream = this.d.c(bVar);
        try {
            int i7 = m1.q(inputStream, outputStream);
        } finally {
            obj.close();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) inputStream;
        }
        outputStream.close();
        final int i5 = 1;
        m(bVar, true);
        return i7;
    }

    private int o(InputStream inputStream, int i) {
        int i5 = 0;
        if (this.b >= 0) {
            if (i > this.b) {
                Object[] arr = new Object[2];
                throw d1.l.r(String.format("message too large %d > %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.b) })).d();
            }
        }
        this.g.clear();
        this.g.put(i5).putInt(i);
        if (this.c == null) {
            i = this.g.position() + i;
            this.c = this.h.a(i);
        }
        p(this.g.array(), i5, this.g.position());
        return m1.q(inputStream, this.f);
    }

    private void p(byte[] bArr, int i, int i2) {
        while (i2 > 0) {
            int min = Math.min(i2, this.c.c());
            this.c.b(bArr, i, min);
        }
    }

    private static int q(InputStream inputStream, OutputStream outputStream) {
        int i = 1;
        if (inputStream instanceof x) {
            return inputStream.a(outputStream);
        }
        long l = a.b(inputStream, outputStream);
        int r0 = l <= 0x7fffffff /* Unknown resource */ ? 1 : 0;
        n.j((l <= 0x7fffffff /* Unknown resource */ ? 1 : 0), "Message size overflow: %s", l);
        return (int)l;
    }

    private int r(InputStream inputStream, int i) {
        if (i != -1) {
            this.m = (long)i;
            return o(inputStream, i);
        }
        io.grpc.j1.m1.b bVar = new m1.b(this, null);
        int i9 = m1.q(inputStream, bVar);
        int i6 = 0;
        m(bVar, false);
        return i9;
    }

    public void close() {
        io.grpc.j1.p2 p2Var;
        if (!isClosed()) {
            boolean closed = true;
            this.j = closed;
            if (this.c != null && this.c.g() == 0) {
                i();
            }
            f(closed, closed);
        }
    }

    public void e(InputStream inputStream) {
        int i;
        io.grpc.m mVar;
        int i2;
        l();
        i = 1;
        this.k += i;
        this.l += i;
        this.m = 0L;
        this.i.i(i8);
        i = 0;
        if (this.e) {
            d1 d1Var2 = i;
        }
        try {
            int i11 = h(inputStream);
            if (i11 == 0 || this.k + i == 0) {
                i2 = r(inputStream, i11);
            } else {
                i2 = n(inputStream, i11);
            }
        } catch (RuntimeException e) {
            d1Var2 = d1.m;
            String str = d1Var2.r(str);
            e = str.q(e);
            e = e.d();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) e;
        } catch (java.io.IOException ioException1) {
            d1Var2 = d1.m;
            str = d1Var2.r(str);
            ioException1 = str.q(ioException1);
            ioException1 = ioException1.d();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) ioException1;
        }
        final long l3 = (long)i2;
        this.i.k(l3);
        this.i.l(this.m);
        this.i.j(this.l, this.m, l3);
    }

    public void flush() {
        if (this.c != null && this.c.g() > 0) {
            boolean z = true;
            f(false, z);
        }
    }

    public void g(int i) {
        boolean z = true;
        int r0 = this.b == -1 ? 1 : 0;
        n.v((this.b == -1 ? 1 : 0), "max size already set");
        this.b = i;
    }

    public boolean isClosed() {
        return this.j;
    }

    public m1 j(o oVar) {
        n.p(oVar, "Can't pass an empty compressor");
        this.d = oVar;
        return this;
    }

    public m1 k(boolean z) {
        this.e = z;
        return this;
    }
}
