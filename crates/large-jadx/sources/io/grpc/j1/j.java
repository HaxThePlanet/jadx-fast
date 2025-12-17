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
        final io.grpc.j1.j d;
        b(io.grpc.j1.j j, o0.d o0$d2) {
            this.d = j;
            super();
            this.a = d2;
            p0 p0Var = j.b(j).d(j.a(j));
            this.c = p0Var;
            if (p0Var == null) {
            } else {
                this.b = p0Var.a(d2);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not find policy '");
            stringBuilder.append(j.a(j));
            stringBuilder.append("'. Make sure its implementation is either registered to LoadBalancerRegistry or included in META-INF/services/io.grpc.LoadBalancerProvider from your jar files.");
            IllegalStateException obj4 = new IllegalStateException(stringBuilder.toString());
            throw obj4;
        }

        public o0 a() {
            return this.b;
        }

        void b(d1 d1) {
            a().b(d1);
        }

        void c() {
            a().d();
        }

        void d() {
            this.b.e();
            this.b = 0;
        }

        d1 e(o0.g o0$g) {
            Object str2;
            g i;
            io.grpc.j1.e2.b bVar;
            String equals;
            boolean empty;
            String str;
            int arr2;
            Object dEBUG;
            Object[] arr;
            final io.grpc.a aVar2 = g.b();
            i = 0;
            if ((e2.b)g.c() == null) {
                io.grpc.j1.j jVar = this.d;
                bVar = new e2.b(j.c(jVar, j.a(jVar), "using default policy"), i);
                str2 = bVar;
            }
            arr2 = 1;
            final int i2 = 0;
            if (this.c != null) {
                if (!str2.a.b().equals(this.c.b())) {
                    j.c cVar = new j.c(i);
                    this.a.e(q.CONNECTING, cVar);
                    this.b.e();
                    p0 p0Var2 = str2.a;
                    this.c = p0Var2;
                    this.b = p0Var2.a(this.a);
                    arr = new Object[2];
                    arr[i2] = this.b.getClass().getSimpleName();
                    arr[arr2] = this.b.getClass().getSimpleName();
                    this.a.b().b(g.a.INFO, "Load balancer changed from {0} to {1}", arr);
                }
            } else {
            }
            Object obj2 = str2.b;
            if (obj2 != null) {
                arr2 = new Object[arr2];
                arr2[i2] = str2.b;
                this.a.b().b(g.a.DEBUG, "Load-balancing config: {0}", arr2);
            }
            o0 o0Var = a();
            if (g.a().isEmpty() && !o0Var.a()) {
                if (!o0Var.a()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("NameResolver returned no usable address. addrs=");
                    stringBuilder.append(g.a());
                    stringBuilder.append(", attrs=");
                    stringBuilder.append(aVar2);
                    return d1.n.r(stringBuilder.toString());
                }
            }
            o0.g.a aVar = o0.g.d();
            aVar.b(g.a());
            aVar.c(aVar2);
            aVar.d(obj2);
            o0Var.c(aVar.a());
            return d1.f;
        }
    }

    static final class f extends Exception {

        private static final long serialVersionUID = 1L;
        private f(String string) {
            super(string);
        }

        f(String string, io.grpc.j1.j.a j$a2) {
            super(string);
        }
    }

    private static final class c extends o0.i {
        c(io.grpc.j1.j.a j$a) {
            super();
        }

        @Override // io.grpc.o0$i
        public o0.e a(o0.f o0$f) {
            return o0.e.g();
        }

        @Override // io.grpc.o0$i
        public String toString() {
            return j.b(j.c.class).toString();
        }
    }

    private static final class d extends o0.i {

        private final d1 a;
        d(d1 d1) {
            super();
            this.a = d1;
        }

        @Override // io.grpc.o0$i
        public o0.e a(o0.f o0$f) {
            return o0.e.f(this.a);
        }
    }

    private static final class e extends o0 {
        e(io.grpc.j1.j.a j$a) {
            super();
        }

        @Override // io.grpc.o0
        public void b(d1 d1) {
        }

        @Override // io.grpc.o0
        public void c(o0.g o0$g) {
        }

        @Override // io.grpc.o0
        public void e() {
        }
    }
    j(q0 q0, String string2) {
        super();
        n.p(q0, "registry");
        this.a = (q0)q0;
        n.p(string2, "defaultPolicy");
        this.b = (String)string2;
    }

    public j(String string) {
        super(q0.b(), string);
    }

    static String a(io.grpc.j1.j j) {
        return j.b;
    }

    static q0 b(io.grpc.j1.j j) {
        return j.a;
    }

    static p0 c(io.grpc.j1.j j, String string2, String string3) {
        return j.d(string2, string3);
    }

    private p0 d(String string, String string2) {
        p0 p0Var = this.a.d(string);
        if (p0Var == null) {
        } else {
            return p0Var;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Trying to load '");
        stringBuilder.append(string);
        stringBuilder.append("' because ");
        stringBuilder.append(string2);
        stringBuilder.append(", but it's unavailable");
        j.f fVar = new j.f(stringBuilder.toString(), 0);
        throw fVar;
    }

    public io.grpc.j1.j.b e(o0.d o0$d) {
        j.b bVar = new j.b(this, d);
        return bVar;
    }

    v0.c f(Map<String, ?> map) {
        String empty;
        int obj3;
        int i = 0;
        if (map != null) {
            obj3 = e2.A(e2.g(map));
        } else {
            try {
                obj3 = i;
                if (obj3 != null && !obj3.isEmpty()) {
                }
                if (!obj3.isEmpty()) {
                }
                return e2.y(obj3, this.a);
                d1 d1Var = d1.h;
                d1Var = d1Var.r("can't parse load balancer configuration");
                map = d1Var.q(map);
                map = v0.c.b(map);
                return map;
                return i;
            }
        }
    }
}
