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

/* loaded from: classes2.dex */
public abstract class v0 {

    public static final class b {

        private final int a;
        private final io.grpc.a1 b;
        private final io.grpc.f1 c;
        private final io.grpc.v0.h d;
        private final ScheduledExecutorService e;
        private final io.grpc.g f;
        private final Executor g;
        private b(Integer integer, io.grpc.a1 a12, io.grpc.f1 f13, io.grpc.v0.h v0$h4, ScheduledExecutorService scheduledExecutorService5, io.grpc.g g6, Executor executor7) {
            super();
            n.p(integer, "defaultPort not set");
            this.a = (Integer)integer.intValue();
            n.p(a12, "proxyDetector not set");
            this.b = (a1)a12;
            n.p(f13, "syncContext not set");
            this.c = (f1)f13;
            n.p(h4, "serviceConfigParser not set");
            this.d = (v0.h)h4;
            this.e = scheduledExecutorService5;
            this.f = g6;
            this.g = executor7;
        }

        b(Integer integer, io.grpc.a1 a12, io.grpc.f1 f13, io.grpc.v0.h v0$h4, ScheduledExecutorService scheduledExecutorService5, io.grpc.g g6, Executor executor7, io.grpc.v0.a v0$a8) {
            super(integer, a12, f13, h4, scheduledExecutorService5, g6, executor7);
        }

        public static io.grpc.v0.b.a f() {
            v0.b.a aVar = new v0.b.a();
            return aVar;
        }

        public int a() {
            return this.a;
        }

        public Executor b() {
            return this.g;
        }

        public io.grpc.a1 c() {
            return this.b;
        }

        public io.grpc.v0.h d() {
            return this.d;
        }

        public io.grpc.f1 e() {
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
    }

    public static final class c {

        private final io.grpc.d1 a;
        private final Object b;
        static {
        }

        private c(io.grpc.d1 d1) {
            super();
            this.b = 0;
            n.p(d1, "status");
            this.a = d1;
            n.k(z ^= 1, "cannot use OK status: %s", d1);
        }

        private c(Object object) {
            super();
            n.p(object, "config");
            this.b = object;
            this.a = 0;
        }

        public static io.grpc.v0.c a(Object object) {
            v0.c cVar = new v0.c(object);
            return cVar;
        }

        public static io.grpc.v0.c b(io.grpc.d1 d1) {
            v0.c cVar = new v0.c(d1);
            return cVar;
        }

        public Object c() {
            return this.b;
        }

        public io.grpc.d1 d() {
            return this.a;
        }

        public boolean equals(Object object) {
            int i;
            Object z;
            Class<io.grpc.v0.c> obj;
            Class class;
            boolean obj5;
            if (this == object) {
                return 1;
            }
            final int i2 = 0;
            if (object != null) {
                if (v0.c.class != object.getClass()) {
                } else {
                    if (k.a(this.a, object.a) && k.a(this.b, object.b)) {
                        if (k.a(this.b, object.b)) {
                        } else {
                            i = i2;
                        }
                    } else {
                    }
                }
                return i;
            }
            return i2;
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
            j.b bVar2 = j.c(this);
            bVar2.d("error", this.a);
            return bVar2.toString();
        }
    }

    public static abstract class d {
        public abstract String a();

        public abstract io.grpc.v0 b(URI uRI, io.grpc.v0.b v0$b2);
    }

    public interface f {
        public abstract void a(io.grpc.d1 d1);

        public abstract void b(List<io.grpc.y> list, io.grpc.a a2);
    }

    public static final class g {

        private final List<io.grpc.y> a;
        private final io.grpc.a b;
        private final io.grpc.v0.c c;
        g(List<io.grpc.y> list, io.grpc.a a2, io.grpc.v0.c v0$c3) {
            super();
            ArrayList arrayList = new ArrayList(list);
            this.a = Collections.unmodifiableList(arrayList);
            n.p(a2, "attributes");
            this.b = (a)a2;
            this.c = c3;
        }

        public static io.grpc.v0.g.a d() {
            v0.g.a aVar = new v0.g.a();
            return aVar;
        }

        public List<io.grpc.y> a() {
            return this.a;
        }

        public io.grpc.a b() {
            return this.b;
        }

        public io.grpc.v0.c c() {
            return this.c;
        }

        public boolean equals(Object object) {
            boolean z;
            int i;
            Object list;
            Object obj4;
            if (!object instanceof v0.g) {
                return 0;
            }
            if (k.a(this.a, object.a) && k.a(this.b, object.b) && k.a(this.c, object.c)) {
                if (k.a(this.b, object.b)) {
                    if (k.a(this.c, object.c)) {
                        i = 1;
                    }
                }
            }
            return i;
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
        public abstract io.grpc.v0.c a(Map<String, ?> map);
    }

    public static abstract class e implements io.grpc.v0.f {
        @Override // io.grpc.v0$f
        public abstract void a(io.grpc.d1 d1);

        @Deprecated
        public final void b(List<io.grpc.y> list, io.grpc.a a2) {
            final io.grpc.v0.g.a aVar = v0.g.d();
            aVar.b(list);
            aVar.c(a2);
            c(aVar.a());
        }

        @Override // io.grpc.v0$f
        public abstract void c(io.grpc.v0.g v0$g);
    }

    class a extends io.grpc.v0.e {

        final io.grpc.v0.f a;
        a(io.grpc.v0 v0, io.grpc.v0.f v0$f2) {
            this.a = f2;
            super();
        }

        @Override // io.grpc.v0$e
        public void a(io.grpc.d1 d1) {
            this.a.a(d1);
        }

        @Override // io.grpc.v0$e
        public void c(io.grpc.v0.g v0$g) {
            this.a.b(g.a(), g.b());
        }
    }
    public abstract String a();

    public void b() {
    }

    public abstract void c();

    public void d(io.grpc.v0.e v0$e) {
        e(e);
    }

    public void e(io.grpc.v0.f v0$f) {
        boolean aVar;
        if (f instanceof v0.e) {
            d((v0.e)f);
        } else {
            aVar = new v0.a(this, f);
            d(aVar);
        }
    }
}
