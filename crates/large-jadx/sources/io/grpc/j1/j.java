package io.grpc.j1;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.n;
import io.grpc.d1;
import io.grpc.g;
import io.grpc.g.a;
import io.grpc.o0;
import io.grpc.o0.c;
import io.grpc.o0.d;
import io.grpc.o0.e;
import io.grpc.o0.f;
import io.grpc.o0.g;
import io.grpc.o0.g.a;
import io.grpc.o0.i;
import io.grpc.p0;
import io.grpc.q;
import io.grpc.q0;
import io.grpc.v0.c;
import java.util.List;
import java.util.Map;

/* compiled from: AutoConfiguredLoadBalancerFactory.java */
/* loaded from: classes3.dex */
public final class j {

    private final q0 a;
    private final String b;

    static class a {
    }

    public final class b {

        private final o0.d a;
        private o0 b;
        private p0 c;
        final /* synthetic */ j d;
        b(o0.d dVar) {
            this.d = jVar;
            super();
            this.a = dVar;
            p0 p0Var = jVar.a.d(jVar.b);
            this.c = p0Var;
            if (p0Var == null) {
                StringBuilder stringBuilder = new StringBuilder();
                String str2 = "Could not find policy '";
                String str3 = jVar.b;
                String str4 = "'. Make sure its implementation is either registered to LoadBalancerRegistry or included in META-INF/services/io.grpc.LoadBalancerProvider from your jar files.";
                jVar = str2 + str3 + str4;
                throw new IllegalStateException(jVar);
            } else {
                this.b = p0Var.a(dVar);
                return;
            }
        }

        public o0 a() {
            return this.b;
        }

        void b(d1 d1Var) {
            a().b(d1Var);
        }

        void c() {
            a().d();
        }

        void d() {
            this.b.e();
            this.b = null;
        }

        d1 e(o0.g gVar) {
            Object obj;
            String str;
            g.a dEBUG2;
            List list = gVar.a();
            final io.grpc.a aVar2 = gVar.b();
            Object obj3 = null;
            if ((e2.b)gVar.c() == null) {
                try {
                    str2 = "using default policy";
                } catch (io.grpc.j1.j.f e) {
                    d1 d1Var = d1.m;
                    e = e.getMessage();
                    e = d1Var.r(e);
                    this.a.e(q.TRANSIENT_FAILURE, new j.d(e));
                    this.b.e();
                    this.c = p0Var3;
                    e = new j.e(p0Var3);
                    this.b = this.b;
                    e = d1.f;
                    return this.b;
                }
            }
            int i = 1;
            final int i2 = 0;
            if (this.c != null) {
                if (!obj.a.b().equals(this.c.b())) {
                    this.a.e(q.CONNECTING, new j.c(obj3));
                    this.b.e();
                    this.c = obj.a;
                    this.b = obj.a.a(this.a);
                    Object[] arr = new Object[2];
                    str = "Load balancer changed from {0} to {1}";
                    this.a.b().b(g.a.INFO, str, new Object[] { this.b.getClass().getSimpleName(), this.b.getClass().getSimpleName() });
                }
            }
            if (obj.b != null) {
                Object[] arr2 = new Object[i];
                this.a.b().b(g.a.DEBUG, "Load-balancing config: {0}", new Object[] { obj.b });
            }
            o0 o0Var = a();
            if (this.b.a().isEmpty() && !o0Var.a()) {
                StringBuilder stringBuilder = new StringBuilder();
                String str7 = "NameResolver returned no usable address. addrs=";
                String str4 = ", attrs=";
                str5 = str7 + list + str4 + aVar2;
                return d1.n.r(str5);
            }
            o0.g.a aVar = o0.g.d();
            aVar.b(this.b.a());
            aVar.c(aVar2);
            aVar.d(obj.b);
            o0Var.c(aVar.a());
            return d1.f;
        }
    }

    static final class f extends Exception {

        private static final long serialVersionUID = 1L;
        /* synthetic */ f(String str, j.a aVar) {
            this(str);
        }

        private f(String str) {
            super(str);
        }
    }

    private static final class c extends o0.i {
        private c() {
            super();
        }

        @Override // io.grpc.o0$i
        public o0.e a(o0.f fVar) {
            return o0.e.g();
        }

        @Override // io.grpc.o0$i
        public String toString() {
            return j.b(j.c.class).toString();
        }

        /* synthetic */ c(j.a aVar) {
            this();
        }
    }

    private static final class d extends o0.i {

        private final d1 a;
        d(d1 d1Var) {
            super();
            this.a = d1Var;
        }

        @Override // io.grpc.o0$i
        public o0.e a(o0.f fVar) {
            return o0.e.f(this.a);
        }
    }

    private static final class e extends o0 {
        private e() {
            super();
        }

        /* synthetic */ e(j.a aVar) {
            this();
        }

        @Override // io.grpc.o0
        public void b(d1 d1Var) {
        }

        @Override // io.grpc.o0
        public void c(o0.g gVar) {
        }

        @Override // io.grpc.o0
        public void e() {
        }
    }
    public j(String str) {
        this(q0.b(), str);
    }

    static /* synthetic */ String a(j jVar) {
        return jVar.b;
    }

    static /* synthetic */ q0 b(j jVar) {
        return jVar.a;
    }

    static /* synthetic */ p0 c(j jVar, String str, String str2) {
        return jVar.d(str, str2);
    }

    private p0 d(String str, String str2) throws j.f {
        p0 p0Var = this.a.d(str);
        if (p0Var == null) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str3 = "Trying to load '";
            String str4 = "' because ";
            String str5 = ", but it's unavailable";
            str = str3 + str + str4 + str2 + str5;
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) new j.f(str, null);
        } else {
            return p0Var;
        }
    }

    public j.b e(o0.d dVar) {
        return new j.b(this, dVar);
    }

    v0.c f(Map<String, ?> map) {
        List list;
        int i = 0;
        if (map != null) {
            try {
                list = e2.A(e2.g(map));
            } catch (RuntimeException e) {
            }
            d1 d1Var = d1.h;
            d1Var = d1Var.r("can't parse load balancer configuration");
            e = d1Var.q(e);
            e = v0.c.b(e);
            return e;
        }
    }

    j(q0 q0Var, String str) {
        super();
        n.p(q0Var, "registry");
        this.a = q0Var;
        n.p(str, "defaultPolicy");
        this.b = str;
    }
}
