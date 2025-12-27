package io.grpc.j1;

import com.google.common.base.k;
import com.google.common.base.n;
import io.grpc.d;
import io.grpc.o0.f;
import io.grpc.t0;
import io.grpc.u0;

/* compiled from: PickSubchannelArgsImpl.java */
/* loaded from: classes3.dex */
public final class t1 extends o0.f {

    private final d a;
    private final t0 b;
    private final u0<?, ?> c;
    public t1(u0<?, ?> u0Var, t0 t0Var, d dVar) {
        super();
        n.p(u0Var, "method");
        this.c = u0Var;
        n.p(t0Var, "headers");
        this.b = t0Var;
        n.p(dVar, "callOptions");
        this.a = dVar;
    }

    @Override // io.grpc.o0$f
    public d a() {
        return this.a;
    }

    @Override // io.grpc.o0$f
    public t0 b() {
        return this.b;
    }

    @Override // io.grpc.o0$f
    public u0<?, ?> c() {
        return this.c;
    }

    @Override // io.grpc.o0$f
    public boolean equals(Object object) {
        boolean z = true;
        boolean z2;
        d dVar;
        boolean z3;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object != null) {
            obj = t1.class;
            if (obj == object.getClass()) {
                if (k.a(this.a, object.a)) {
                    if (k.a(this.b, object.b)) {
                        if (!(k.a(this.c, object.c))) {
                        }
                    }
                }
            }
            return z;
        }
        return false;
    }

    @Override // io.grpc.o0$f
    public int hashCode() {
        Object[] arr = new Object[3];
        return k.b(new Object[] { this.a, this.b, this.c });
    }

    @Override // io.grpc.o0$f
    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "[method=";
        String str3 = " headers=";
        String str4 = " callOptions=";
        String str5 = "]";
        str = str2 + this.c + str3 + this.b + str4 + this.a + str5;
        return str;
    }
}
