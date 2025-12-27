package io.grpc;

import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: ThreadLocalContextStorage.java */
/* loaded from: classes2.dex */
final class g1 extends s.e {

    private static final Logger a;
    static final java.lang.ThreadLocal<s> b = new ThreadLocal<>();
    static {
        g1.a = Logger.getLogger(g1.class.getName());
    }

    g1() {
        super();
    }

    @Override // io.grpc.s$e
    public s b() {
        Object obj;
        if ((s)g1.b.get() == null) {
            io.grpc.s sVar = s.v;
        }
        return obj;
    }

    @Override // io.grpc.s$e
    public void c(s sVar, s sVar2) {
        if (b() != sVar) {
            str = "Context was not attached when detaching";
            g1.a.log(Level.SEVERE, str, new Throwable().fillInStackTrace());
        }
        if (sVar2 != s.v) {
            g1.b.set(sVar2);
        } else {
            Object obj = null;
            g1.b.set(obj);
        }
    }

    @Override // io.grpc.s$e
    public s d(s sVar) {
        g1.b.set(sVar);
        return b();
    }
}
