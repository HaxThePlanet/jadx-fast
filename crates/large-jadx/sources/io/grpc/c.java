package io.grpc;

import java.util.concurrent.Executor;

/* compiled from: CallCredentials.java */
/* loaded from: classes2.dex */
public abstract class c {

    public static abstract class a {
        public abstract void a(t0 t0Var);

        public abstract void b(d1 d1Var);
    }

    public static abstract class b {
    }
    public abstract void applyRequestMetadata(c.b bVar, Executor executor, c.a aVar);

    public abstract void thisUsesUnstableApi();
}
