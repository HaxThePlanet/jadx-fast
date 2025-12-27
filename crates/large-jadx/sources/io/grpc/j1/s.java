package io.grpc.j1;

import io.grpc.d;
import io.grpc.h0;
import io.grpc.l;
import io.grpc.t0;
import io.grpc.u0;
import java.util.concurrent.Executor;

/* compiled from: ClientTransport.java */
/* loaded from: classes3.dex */
public interface s extends h0<Object> {

    public interface a {
        void a(Throwable th);

        void b(long j);
    }
    q b(u0<?, ?> u0Var, t0 t0Var, d dVar, l[] lVarArr);

    void g(s.a aVar, Executor executor);
}
