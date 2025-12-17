package io.grpc.j1;

import com.google.common.base.n;
import io.grpc.d1;
import io.grpc.e1;
import io.grpc.l;
import io.grpc.t0;

/* loaded from: classes3.dex */
public final class f0 extends io.grpc.j1.o1 {

    private boolean b;
    private final d1 c;
    private final io.grpc.j1.r.a d;
    private final l[] e;
    public f0(d1 d1, io.grpc.j1.r.a r$a2, l[] l3Arr3) {
        super();
        n.e(z ^= 1, "error must not be OK");
        this.c = d1;
        this.d = a2;
        this.e = l3Arr3;
    }

    public f0(d1 d1, l[] l2Arr2) {
        super(d1, r.a.PROCESSED, l2Arr2);
    }

    @Override // io.grpc.j1.o1
    public void j(io.grpc.j1.x0 x0) {
        x0.b("error", this.c);
        x0.b("progress", this.d);
    }

    @Override // io.grpc.j1.o1
    public void m(io.grpc.j1.r r) {
        int i;
        l lVar;
        d1 d1Var;
        int i3 = 1;
        n.v(z ^= i3, "already started");
        this.b = i3;
        l[] objArr = this.e;
        i = 0;
        while (i < objArr.length) {
            objArr[i].i(this.c);
            i++;
        }
        t0 t0Var = new t0();
        r.d(this.c, this.d, t0Var);
    }
}
