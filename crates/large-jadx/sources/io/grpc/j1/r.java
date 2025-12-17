package io.grpc.j1;

import io.grpc.d1;
import io.grpc.t0;

/* loaded from: classes3.dex */
public interface r extends io.grpc.j1.k2 {

    public static enum a {

        PROCESSED,
        REFUSED,
        DROPPED;
    }
    @Override // io.grpc.j1.k2
    public abstract void b(t0 t0);

    @Override // io.grpc.j1.k2
    public abstract void d(d1 d1, io.grpc.j1.r.a r$a2, t0 t03);
}
