package io.grpc.k1;

import com.google.common.base.n;
import io.grpc.k1.r.j.a;
import io.grpc.k1.r.j.c;
import io.grpc.k1.r.j.d;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import l.f;

/* compiled from: ExceptionHandlingFrameWriter.java */
/* loaded from: classes3.dex */
final class b implements c {

    private static final Logger v;
    private final b.a a;
    private final c b;
    private final i c;

    interface a {
        void a(Throwable th);
    }
    static {
        b.v = Logger.getLogger(h.class.getName());
    }

    b(b.a aVar, c cVar) {
        this(aVar, cVar, new i(Level.FINE, h.class));
    }

    static Level a(Throwable th) {
        if (th.getClass().equals(IOException.class)) {
            return Level.FINE;
        }
        return Level.INFO;
    }

    public void R0(io.grpc.k1.r.j.i iVar) {
        this.c.j(i.a.OUTBOUND);
        try {
            this.b.R0(iVar);
        } catch (java.io.IOException ioException) {
            this.a.a(ioException);
        }
    }

    public void T1(boolean z, boolean z2, int i, int i2, List<d> list) {
        try {
            this.b.T1(z, z2, i, i2, list);
        } catch (java.io.IOException ioException) {
            this.a.a(ioException);
        }
    }

    public void Z0(io.grpc.k1.r.j.i iVar) {
        this.c.i(i.a.OUTBOUND, iVar);
        try {
            this.b.Z0(iVar);
        } catch (java.io.IOException ioException) {
            this.a.a(ioException);
        }
    }

    public void close() {
        try {
            this.b.close();
        } catch (java.io.IOException ioException) {
            b.v.log(b.a(ioException), "Failed closing connection", ioException);
        }
    }

    public void connectionPreface() {
        try {
            this.b.connectionPreface();
        } catch (java.io.IOException ioException) {
            this.a.a(ioException);
        }
    }

    public void data(boolean z, int i, f fVar, int i2) {
        fVar.A();
        this.c.b(i.a.OUTBOUND, i, fVar, i2, z);
        try {
            this.b.data(z, i, fVar, i2);
        } catch (java.io.IOException ioException) {
            this.a.a(ioException);
        }
    }

    public void flush() {
        try {
            this.b.flush();
        } catch (java.io.IOException ioException) {
            this.a.a(ioException);
        }
    }

    public void h2(int i, a aVar, byte[] bArr) {
        this.c.c(i.a.OUTBOUND, i, aVar, i.f(bArr));
        try {
            this.b.h2(i, aVar, bArr);
            this.b.flush();
        } catch (java.io.IOException ioException) {
            this.a.a(ioException);
        }
    }

    public int maxDataLength() {
        return this.b.maxDataLength();
    }

    public void p(int i, a aVar) {
        this.c.h(i.a.OUTBOUND, i, aVar);
        try {
            this.b.p(i, aVar);
        } catch (java.io.IOException ioException) {
            this.a.a(ioException);
        }
    }

    public void ping(boolean z, int i, int i2) {
        long l4 = 4294967295L;
        i = 32;
        if (z) {
            l2 = (long)i << 32L;
            l3 = (long)i2;
            l = (4294967295L & l3) | l2;
            this.c.f(i.a.OUTBOUND, l);
        } else {
            l2 = (long)i << 32L;
            l3 = (long)i2;
            l = (4294967295L & l3) | l2;
            this.c.e(i.a.OUTBOUND, l);
        }
        try {
            this.b.ping(z, i, i2);
        } catch (java.io.IOException ioException) {
            this.a.a(ioException);
        }
    }

    public void windowUpdate(int i, long j) {
        this.c.k(i.a.OUTBOUND, i, j);
        try {
            this.b.windowUpdate(i, j);
        } catch (java.io.IOException ioException) {
            this.a.a(ioException);
        }
    }

    b(b.a aVar, c cVar, i iVar) {
        super();
        n.p(aVar, "transportExceptionHandler");
        this.a = aVar;
        n.p(cVar, "frameWriter");
        this.b = cVar;
        n.p(iVar, "frameLogger");
        this.c = iVar;
    }
}
