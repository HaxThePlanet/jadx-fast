package io.grpc.k1;

import com.google.common.base.n;
import io.grpc.k1.r.j.a;
import io.grpc.k1.r.j.c;
import io.grpc.k1.r.j.d;
import io.grpc.k1.r.j.i;
import java.io.Closeable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import l.f;
import l.i;

/* loaded from: classes3.dex */
final class b implements c {

    private static final Logger v;
    private final io.grpc.k1.b.a a;
    private final c b;
    private final io.grpc.k1.i c;

    interface a {
        public abstract void a(Throwable throwable);
    }
    static {
        b.v = Logger.getLogger(h.class.getName());
    }

    b(io.grpc.k1.b.a b$a, c c2) {
        i iVar = new i(Level.FINE, h.class);
        super(a, c2, iVar);
    }

    b(io.grpc.k1.b.a b$a, c c2, io.grpc.k1.i i3) {
        super();
        n.p(a, "transportExceptionHandler");
        this.a = (b.a)a;
        n.p(c2, "frameWriter");
        this.b = (c)c2;
        n.p(i3, "frameLogger");
        this.c = (i)i3;
    }

    static Level a(Throwable throwable) {
        if (throwable.getClass().equals(IOException.class)) {
            return Level.FINE;
        }
        return Level.INFO;
    }

    @Override // io.grpc.k1.r.j.c
    public void R0(i i) {
        c cVar;
        i obj3;
        this.c.j(i.a.OUTBOUND);
        this.b.R0(i);
    }

    public void T1(boolean z, boolean z2, int i3, int i4, List<d> list5) {
        Throwable obj7;
        io.grpc.k1.b.a obj8;
        try {
            this.b.T1(z, z2, i3, i4, list5);
            z2 = this.a;
            z2.a(z);
        }
    }

    @Override // io.grpc.k1.r.j.c
    public void Z0(i i) {
        c cVar;
        i obj3;
        this.c.i(i.a.OUTBOUND, i);
        this.b.Z0(i);
    }

    @Override // io.grpc.k1.r.j.c
    public void close() {
        c cVar;
        Logger logger;
        Level level;
        String str;
        try {
            this.b.close();
            b.v.log(b.a(th), "Failed closing connection", th);
        }
    }

    @Override // io.grpc.k1.r.j.c
    public void connectionPreface() {
        c cVar;
        io.grpc.k1.b.a aVar;
        try {
            this.b.connectionPreface();
            this.a.a(th);
        }
    }

    @Override // io.grpc.k1.r.j.c
    public void data(boolean z, int i2, f f3, int i4) {
        boolean obj7;
        int obj8;
        f3.A();
        this.c.b(i.a.OUTBOUND, i2, f3, i4, z);
        this.b.data(z, i2, f3, i4);
    }

    @Override // io.grpc.k1.r.j.c
    public void flush() {
        c cVar;
        io.grpc.k1.b.a aVar;
        try {
            this.b.flush();
            this.a.a(th);
        }
    }

    @Override // io.grpc.k1.r.j.c
    public void h2(int i, a a2, byte[] b3Arr3) {
        c obj4;
        a obj5;
        this.c.c(i.a.OUTBOUND, i, a2, i.t(b3Arr3));
        this.b.h2(i, a2, b3Arr3);
        this.b.flush();
    }

    @Override // io.grpc.k1.r.j.c
    public int maxDataLength() {
        return this.b.maxDataLength();
    }

    @Override // io.grpc.k1.r.j.c
    public void p(int i, a a2) {
        int obj3;
        a obj4;
        this.c.h(i.a.OUTBOUND, i, a2);
        this.b.p(i, a2);
    }

    @Override // io.grpc.k1.r.j.c
    public void ping(boolean z, int i2, int i3) {
        int i;
        io.grpc.k1.i iVar;
        io.grpc.k1.i.a oUTBOUND;
        int i4;
        long l;
        boolean obj10;
        int obj11;
        long l2 = 4294967295L;
        final int i7 = 32;
        if (z) {
            this.c.f(i.a.OUTBOUND, i5 |= i4);
        } else {
            this.c.e(i.a.OUTBOUND, i6 |= i4);
        }
        this.b.ping(z, i2, i3);
    }

    @Override // io.grpc.k1.r.j.c
    public void windowUpdate(int i, long l2) {
        int obj3;
        long obj4;
        this.c.k(i.a.OUTBOUND, i, l2);
        this.b.windowUpdate(i, l2);
    }
}
