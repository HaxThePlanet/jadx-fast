package io.grpc.j1;

import io.grpc.d;
import io.grpc.h0;
import io.grpc.l;
import io.grpc.t0;
import io.grpc.u0;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public interface s extends h0<Object> {

    public interface a {
        public abstract void a(Throwable throwable);

        public abstract void b(long l);
    }
    public abstract io.grpc.j1.q b(u0<?, ?> u0, t0 t02, d d3, l[] l4Arr4);

    @Override // io.grpc.h0
    public abstract void g(io.grpc.j1.s.a s$a, Executor executor2);
}
