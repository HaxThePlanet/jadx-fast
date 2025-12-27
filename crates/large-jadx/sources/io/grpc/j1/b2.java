package io.grpc.j1;

import com.google.common.base.n;
import io.grpc.d1;
import io.grpc.v0.c;
import io.grpc.v0.h;
import java.util.Map;

/* compiled from: ScParser.java */
/* loaded from: classes3.dex */
public final class b2 extends v0.h {

    private final boolean a;
    private final int b;
    private final int c;
    private final j d;
    public b2(boolean z, int i, int i2, j jVar) {
        super();
        this.a = z;
        this.b = i;
        this.c = i2;
        n.p(jVar, "autoLoadBalancerFactory");
        this.d = jVar;
    }

    @Override // io.grpc.v0$h
    public v0.c a(Map<String, ?> map) {
        Object obj = null;
        try {
            v0.c cVar = this.d.f(map);
            if (cVar != null) {
                if (cVar.d() != null) {
                    return v0.c.b(cVar.d());
                }
                obj = cVar.c();
            } else {
                int i = 0;
            }
        } catch (RuntimeException e) {
            d1 d1Var2 = d1.h;
            d1Var2 = d1Var2.r("failed to parse service config");
            e = d1Var2.q(e);
            e = v0.c.b(e);
            return e;
        }
        return v0.c.a(j1.b(map, this.a, this.b, this.c, obj));
    }
}
