package io.grpc.j1;

import com.google.common.base.n;
import io.grpc.d;
import io.grpc.d1;
import io.grpc.i0;
import io.grpc.l;
import io.grpc.t0;
import io.grpc.u0;

/* loaded from: classes3.dex */
class g0 implements io.grpc.j1.s {

    final d1 a;
    private final io.grpc.j1.r.a b;
    g0(d1 d1, io.grpc.j1.r.a r$a2) {
        super();
        n.e(z ^= 1, "error must not be OK");
        this.a = d1;
        this.b = a2;
    }

    public io.grpc.j1.q b(u0<?, ?> u0, t0 t02, d d3, l[] l4Arr4) {
        f0 obj1 = new f0(this.a, this.b, l4Arr4);
        return obj1;
    }

    @Override // io.grpc.j1.s
    public i0 f() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Not a real transport");
        throw unsupportedOperationException;
    }
}
