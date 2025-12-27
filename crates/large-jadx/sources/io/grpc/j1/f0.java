package io.grpc.j1;

import com.google.common.base.n;
import io.grpc.d1;
import io.grpc.e1;
import io.grpc.l;
import io.grpc.t0;

/* compiled from: FailingClientStream.java */
/* loaded from: classes3.dex */
public final class f0 extends o1 {

    private boolean b;
    private final d1 c;
    private final r.a d;
    private final l[] e;
    public f0(d1 d1Var, l[] lVarArr) {
        this(d1Var, r.a.PROCESSED, lVarArr);
    }

    @Override // io.grpc.j1.o1
    public void j(x0 x0Var) {
        x0Var.b("error", this.c);
        x0Var.b("progress", this.d);
    }

    @Override // io.grpc.j1.o1
    public void m(r rVar) {
        int i = 0;
        boolean z2 = true;
        n.v(this.b ^ z2, "already started");
        this.b = z2;
        i = 0;
        for (l lVar : objArr) {
            lVar.i(this.c);
        }
        rVar.d(this.c, this.d, new t0());
    }

    public f0(d1 d1Var, r.a aVar, l[] lVarArr) {
        super();
        n.e(!d1Var.p(), "error must not be OK");
        this.c = d1Var;
        this.d = aVar;
        this.e = lVarArr;
    }
}
