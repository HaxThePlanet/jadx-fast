package io.grpc;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.k;
import com.google.common.base.n;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: NameResolver.java */
/* loaded from: classes2.dex */
public abstract class v0 {

    public static final class b {

        private final int a;
        private final a1 b;
        private final f1 c;
        private final v0.h d;
        private final ScheduledExecutorService e;
        private final g f;
        private final Executor g;
        /* synthetic */ b(Integer integer, a1 a1Var, f1 f1Var, v0.h hVar, ScheduledExecutorService scheduledExecutorService, g gVar, Executor executor, v0.a aVar) {
            this(integer, a1Var, f1Var, hVar, scheduledExecutorService, gVar, executor);
        }

        public static v0.b.a f() {
            return new v0.b.a();
        }

        public int a() {
            return this.a;
        }

        public Executor b() {
            return this.g;
        }

        public a1 c() {
            return this.b;
        }

        public v0.h d() {
            return this.d;
        }

        public f1 e() {
            return this.c;
        }

        public String toString() {
            j.b bVar = j.c(this);
            bVar.b("defaultPort", this.a);
            bVar.d("proxyDetector", this.b);
            bVar.d("syncContext", this.c);
            bVar.d("serviceConfigParser", this.d);
            bVar.d("scheduledExecutorService", this.e);
            bVar.d("channelLogger", this.f);
            bVar.d("executor", this.g);
            return bVar.toString();
        }

        private b(Integer integer, a1 a1Var, f1 f1Var, v0.h hVar, ScheduledExecutorService scheduledExecutorService, g gVar, Executor executor) {
            super();
            n.p(integer, "defaultPort not set");
            this.a = integer.intValue();
            n.p(a1Var, "proxyDetector not set");
            this.b = a1Var;
            n.p(f1Var, "syncContext not set");
            this.c = f1Var;
            n.p(hVar, "serviceConfigParser not set");
            this.d = hVar;
            this.e = scheduledExecutorService;
            this.f = gVar;
            this.g = executor;
        }
    }

    public static final class c {

        private final d1 a;
        private final Object b;
        private c(Object object) {
            super();
            n.p(object, "config");
            this.b = object;
            this.a = null;
        }

        public static v0.c a(Object object) {
            return new v0.c(object);
        }

        public static v0.c b(d1 d1Var) {
            return new v0.c(d1Var);
        }

        public Object c() {
            return this.b;
        }

        public d1 d() {
            return this.a;
        }

        public boolean equals(Object object) {
            boolean z = true;
            boolean z2;
            boolean z3;
            z = true;
            if (this == object) {
                return true;
            }
            final int i = 0;
            if (object != null) {
                obj = v0.c.class;
                if (obj == object.getClass()) {
                    if (k.a(this.a, object.a)) {
                        if (!(k.a(this.b, object.b))) {
                        }
                    }
                }
                return z;
            }
            return false;
        }

        public int hashCode() {
            Object[] arr = new Object[2];
            return k.b(this.a, this.b);
        }

        public String toString() {
            if (this.b != null) {
                j.b bVar = j.c(this);
                bVar.d("config", this.b);
                return bVar.toString();
            }
            j.b bVar3 = j.c(this);
            bVar3.d("error", this.a);
            return bVar3.toString();
        }

        private c(d1 d1Var) {
            super();
            this.b = null;
            n.p(d1Var, "status");
            this.a = d1Var;
            n.k(!d1Var.p(), "cannot use OK status: %s", d1Var);
        }

    }

    public static abstract class d {
        public abstract String a();

        public abstract v0 b(URI uri, v0.b bVar);
    }

    public interface f {
        void a(d1 d1Var);

        void b(List<y> list, a aVar);
    }

    public static final class g {

        private final List<y> a;
        private final a b;
        private final v0.c c;
        g(List<y> list, a aVar, v0.c cVar) {
            super();
            this.a = Collections.unmodifiableList(new ArrayList(list));
            n.p(aVar, "attributes");
            this.b = aVar;
            this.c = cVar;
        }

        public static v0.g.a d() {
            return new v0.g.a();
        }

        public List<y> a() {
            return this.a;
        }

        public a b() {
            return this.b;
        }

        public v0.c c() {
            return this.c;
        }

        public boolean equals(Object object) {
            boolean z2 = false;
            z2 = false;
            if (!(object instanceof v0.g)) {
                return false;
            }
            if (k.a(this.a, object.a)) {
                if (k.a(this.b, object.b)) {
                    if (k.a(this.c, object.c)) {
                        int i = 1;
                    }
                }
            }
            return z2;
        }

        public int hashCode() {
            Object[] arr = new Object[3];
            return k.b(this.a, this.b, this.c);
        }

        public String toString() {
            j.b bVar = j.c(this);
            bVar.d("addresses", this.a);
            bVar.d("attributes", this.b);
            bVar.d("serviceConfig", this.c);
            return bVar.toString();
        }
    }

    public static abstract class h {
        public abstract v0.c a(Map<String, ?> map);
    }

    public static abstract class e implements v0.f {
        @Deprecated
        public final void b(List<y> list, a aVar) {
            final io.grpc.v0.g.a aVar2 = v0.g.d();
            aVar2.b(list);
            aVar2.c(aVar);
            c(aVar2.a());
        }

        public abstract void a(d1 d1Var);

        public abstract void c(v0.g gVar);
    }

    class a extends v0.e {

        final /* synthetic */ v0.f a;
        a(v0.f fVar) {
            this.a = fVar;
            super();
        }

        @Override // io.grpc.v0$e
        public void a(d1 d1Var) {
            this.a.a(d1Var);
        }

        @Override // io.grpc.v0$e
        public void c(v0.g gVar) {
            this.a.b(gVar.a(), gVar.b());
        }
    }
    public void d(v0.e eVar) {
        e(eVar);
    }

    public void e(v0.f fVar) {
        z = fVar instanceof v0.e;
        if (fVar instanceof v0.e) {
            d(fVar);
        } else {
            d(new v0.a(this, fVar));
        }
    }

    public abstract String a();

    public void b() {
    }

    public abstract void c();
}
