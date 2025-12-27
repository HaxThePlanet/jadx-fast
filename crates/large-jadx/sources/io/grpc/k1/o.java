package io.grpc.k1;

import io.grpc.j1.p2;
import io.grpc.j1.q2;
import l.f;

/* compiled from: OkHttpWritableBufferAllocator.java */
/* loaded from: classes3.dex */
class o implements q2 {
    o() {
        super();
    }

    public p2 a(int i) {
        return new n(new f(), Math.min(1048576, Math.max(4096, i)));
    }
}
