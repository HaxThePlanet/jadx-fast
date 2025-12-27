package f.c.f.a.a.a.e;

import io.grpc.e;
import io.grpc.m1.c;
import io.grpc.m1.c.a;
import io.grpc.u0;
import io.grpc.u0.b;
import io.grpc.u0.d;

/* compiled from: InAppMessagingSdkServingGrpc.java */
/* loaded from: classes2.dex */
public final class g {

    private static volatile u0<d, e> a;

    class a implements c.a<g.b> {
        a() {
            super();
        }

        public g.b b(e eVar, io.grpc.d dVar) {
            return new g.b(eVar, dVar, null);
        }
    }

    public static final class b extends io.grpc.m1.b<g.b> {
        /* synthetic */ b(e eVar, io.grpc.d dVar, f fVar) {
            this(eVar, dVar);
        }

        @Override // io.grpc.m1.b
        protected g.b i(e eVar, io.grpc.d dVar) {
            return new g.b(eVar, dVar);
        }

        @Override // io.grpc.m1.b
        public e j(d dVar) {
            return (e)d.b(c(), g.a(), b(), dVar);
        }

        private b(e eVar, io.grpc.d dVar) {
            super(eVar, dVar);
        }
    }
    private g() {
        super();
    }

    public static u0<d, e> a() {
        u0 u0Var;
        io.grpc.u0.c cVar;
        String str;
        if (g.a == null) {
            obj = g.class;
            synchronized (obj) {
                try {
                    if (g.a == null) {
                        u0.b bVar = u0.g();
                        bVar.f(u0.d.UNARY);
                        str = "FetchEligibleCampaigns";
                        bVar.b(u0.b("google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServing", str));
                        bVar.e(true);
                        bVar.c(b.b(d.i()));
                        bVar.d(b.b(e.d()));
                        g.a = bVar.a();
                    }
                } catch (Throwable th) {
                }
            }
        }
        return u0Var;
    }

    public static g.b b(e eVar) {
        return (g.b)b.g(new g.a(), eVar);
    }
}
