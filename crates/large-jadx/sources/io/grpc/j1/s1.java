package io.grpc.j1;

import io.grpc.o0;
import io.grpc.o0.d;
import io.grpc.p0;
import io.grpc.v0.c;
import java.util.Map;

/* loaded from: classes3.dex */
public final class s1 extends p0 {
    @Override // io.grpc.p0
    public o0 a(o0.d o0$d) {
        r1 r1Var = new r1(d);
        return r1Var;
    }

    @Override // io.grpc.p0
    public String b() {
        return "pick_first";
    }

    @Override // io.grpc.p0
    public int c() {
        return 5;
    }

    @Override // io.grpc.p0
    public boolean d() {
        return 1;
    }

    public v0.c e(Map<String, ?> map) {
        return v0.c.a("no service config");
    }
}
