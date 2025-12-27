package io.grpc.j1;

import io.grpc.d1;
import io.grpc.t0;

/* compiled from: ClientStreamListener.java */
/* loaded from: classes3.dex */
public interface r extends k2 {

    public enum a {

        DROPPED,
        PROCESSED,
        REFUSED;
    }
    void b(t0 t0Var);

    void d(d1 d1Var, r.a aVar, t0 t0Var);
}
