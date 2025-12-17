package io.grpc.j1;

import com.google.common.base.n;
import io.grpc.d1;
import io.grpc.v0.c;
import io.grpc.v0.h;
import java.util.Map;

/* loaded from: classes3.dex */
public final class b2 extends v0.h {

    private final boolean a;
    private final int b;
    private final int c;
    private final io.grpc.j1.j d;
    public b2(boolean z, int i2, int i3, io.grpc.j1.j j4) {
        super();
        this.a = z;
        this.b = i2;
        this.c = i3;
        n.p(j4, "autoLoadBalancerFactory");
        this.d = (j)j4;
    }

    public v0.c a(Map<String, ?> map) {
        int i;
        Object str;
        try {
            v0.c cVar = this.d.f(map);
            if (cVar == null) {
            } else {
            }
            i = 0;
            if (cVar.d() != null) {
            }
            return v0.c.b(cVar.d());
            i = cVar.c();
            return v0.c.a(j1.b(map, this.a, this.b, this.c, i));
            d1 d1Var = d1.h;
            d1Var = d1Var.r("failed to parse service config");
            map = d1Var.q(map);
            map = v0.c.b(map);
            return map;
        }
    }
}
