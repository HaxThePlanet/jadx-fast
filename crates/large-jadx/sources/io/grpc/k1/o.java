package io.grpc.k1;

import io.grpc.j1.p2;
import io.grpc.j1.q2;
import l.f;

/* loaded from: classes3.dex */
class o implements q2 {
    @Override // io.grpc.j1.q2
    public p2 a(int i) {
        f fVar = new f();
        n nVar = new n(fVar, Math.min(1048576, Math.max(4096, i)));
        return nVar;
    }
}
