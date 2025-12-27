package io.grpc.n1;

import io.grpc.o0;
import io.grpc.o0.d;
import io.grpc.p0;
import io.grpc.v0.c;
import java.util.Map;

/* compiled from: SecretRoundRobinLoadBalancerProvider.java */
/* loaded from: classes3.dex */
public final class b extends p0 {
    @Override // io.grpc.p0
    public o0 a(o0.d dVar) {
        return new a(dVar);
    }

    @Override // io.grpc.p0
    public v0.c e(Map<String, ?> map) {
        return v0.c.a("no service config");
    }

    @Override // io.grpc.p0
    public String b() {
        return "round_robin";
    }

    @Override // io.grpc.p0
    public int c() {
        return 5;
    }

    @Override // io.grpc.p0
    public boolean d() {
        return true;
    }
}
