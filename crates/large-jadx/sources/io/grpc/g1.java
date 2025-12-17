package io.grpc;

import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
final class g1 extends io.grpc.s.e {

    private static final Logger a;
    static final java.lang.ThreadLocal<io.grpc.s> b;
    static {
        g1.a = Logger.getLogger(g1.class.getName());
        ThreadLocal threadLocal = new ThreadLocal();
        g1.b = threadLocal;
    }

    @Override // io.grpc.s$e
    public io.grpc.s b() {
        Object obj;
        if ((s)g1.b.get() == null) {
            obj = s.v;
        }
        return obj;
    }

    @Override // io.grpc.s$e
    public void c(io.grpc.s s, io.grpc.s s2) {
        Object sEVERE;
        Throwable fillInStackTrace;
        String str;
        Object obj4;
        io.grpc.s obj5;
        if (b() != s) {
            Throwable throwable = new Throwable();
            g1.a.log(Level.SEVERE, "Context was not attached when detaching", throwable.fillInStackTrace());
        }
        if (s2 != s.v) {
            g1.b.set(s2);
        } else {
            g1.b.set(0);
        }
    }

    @Override // io.grpc.s$e
    public io.grpc.s d(io.grpc.s s) {
        g1.b.set(s);
        return b();
    }
}
