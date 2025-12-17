package io.grpc;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public abstract class c {

    public static abstract class a {
        public abstract void a(io.grpc.t0 t0);

        public abstract void b(io.grpc.d1 d1);
    }

    public static abstract class b {
    }
    public abstract void applyRequestMetadata(io.grpc.c.b c$b, Executor executor2, io.grpc.c.a c$a3);

    public abstract void thisUsesUnstableApi();
}
