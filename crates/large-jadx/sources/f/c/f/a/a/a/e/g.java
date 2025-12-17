package f.c.f.a.a.a.e;

import io.grpc.d;
import io.grpc.e;
import io.grpc.l1.a.b;
import io.grpc.m1.b;
import io.grpc.m1.c;
import io.grpc.m1.c.a;
import io.grpc.m1.d;
import io.grpc.u0;
import io.grpc.u0.b;
import io.grpc.u0.d;

/* loaded from: classes2.dex */
public final class g {

    private static volatile u0<f.c.f.a.a.a.e.d, f.c.f.a.a.a.e.e> a;

    class a implements c.a<f.c.f.a.a.a.e.g.b> {
        @Override // io.grpc.m1.c$a
        public c a(e e, d d2) {
            return b(e, d2);
        }

        @Override // io.grpc.m1.c$a
        public f.c.f.a.a.a.e.g.b b(e e, d d2) {
            g.b bVar = new g.b(e, d2, 0);
            return bVar;
        }
    }

    public static final class b extends b<f.c.f.a.a.a.e.g.b> {
        private b(e e, d d2) {
            super(e, d2);
        }

        b(e e, d d2, f.c.f.a.a.a.e.f f3) {
            super(e, d2);
        }

        @Override // io.grpc.m1.b
        protected c a(e e, d d2) {
            return i(e, d2);
        }

        @Override // io.grpc.m1.b
        protected f.c.f.a.a.a.e.g.b i(e e, d d2) {
            g.b bVar = new g.b(e, d2);
            return bVar;
        }

        @Override // io.grpc.m1.b
        public f.c.f.a.a.a.e.e j(f.c.f.a.a.a.e.d d) {
            return (e)d.b(c(), g.a(), b(), d);
        }
    }
    public static u0<f.c.f.a.a.a.e.d, f.c.f.a.a.a.e.e> a() {
        u0 u0Var;
        Class<f.c.f.a.a.a.e.g> obj;
        io.grpc.u0.c cVar;
        String str;
        obj = g.class;
        if (g.a == null && g.a == null) {
            obj = g.class;
            synchronized (obj) {
                u0.b bVar = u0.g();
                bVar.f(u0.d.UNARY);
                bVar.b(u0.b("google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServing", "FetchEligibleCampaigns"));
                bVar.e(true);
                bVar.c(b.b(d.i()));
                bVar.d(b.b(e.d()));
                g.a = bVar.a();
            }
        }
        return u0Var;
    }

    public static f.c.f.a.a.a.e.g.b b(e e) {
        g.a aVar = new g.a();
        return (g.b)b.g(aVar, e);
    }
}
