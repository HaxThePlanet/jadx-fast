package io.grpc;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.k;
import com.google.common.base.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: LoadBalancer.java */
/* loaded from: classes2.dex */
public abstract class o0 {

    public static final a.c<Map<String, ?>> a;

    static class a {
    }

    public static final class b {

        private final List<y> a;
        private final a b;
        private final Object[][] c;
        /* synthetic */ b(List list, a aVar, Object[][] objectArrArr, o0.a aVar2) {
            this(list, aVar, objectArrArr);
        }

        public static o0.b.a c() {
            return new o0.b.a();
        }

        public List<y> a() {
            return this.a;
        }

        public a b() {
            return this.b;
        }

        public o0.b.a d() {
            final io.grpc.o0.b.a aVar = o0.b.c();
            aVar.e(this.a);
            aVar.f(this.b);
            aVar.c(this.c);
            return aVar;
        }

        public String toString() {
            j.b bVar = j.c(this);
            bVar.d("addrs", this.a);
            bVar.d("attrs", this.b);
            bVar.d("customOptions", Arrays.deepToString(this.c));
            return bVar.toString();
        }

        private b(List<y> list, a aVar, Object[][] objectArrArr) {
            super();
            n.p(list, "addresses are not set");
            this.a = list;
            n.p(aVar, "attrs");
            this.b = aVar;
            n.p(objectArrArr, "customOptions");
            this.c = objectArrArr;
        }
    }

    public static abstract class c {
        public abstract o0 a(o0.d dVar);
    }

    public static abstract class d {
        public o0.h a(o0.b bVar) {
            throw new UnsupportedOperationException();
        }

        public g b() {
            throw new UnsupportedOperationException();
        }

        public f1 c() {
            throw new UnsupportedOperationException();
        }

        public void d() {
            throw new UnsupportedOperationException();
        }

        public abstract void e(q qVar, o0.i iVar);
    }

    public static final class e {

        private static final o0.e e = new o0$e();
        private final o0.h a;
        private final l.a b;
        private final d1 c;
        private final boolean d;
        static {
        }

        private e(o0.h hVar, l.a aVar, d1 d1Var, boolean z) {
            super();
            this.a = hVar;
            this.b = aVar;
            n.p(d1Var, "status");
            this.c = d1Var;
            this.d = z;
        }

        public static o0.e e(d1 d1Var) {
            final boolean z2 = true;
            n.e(d1Var.p() ^ z2, "drop status shouldn't be OK");
            io.grpc.o0.h hVar = null;
            return new o0.e(hVar, hVar, d1Var, z2);
        }

        public static o0.e f(d1 d1Var) {
            n.e(!d1Var.p(), "error status shouldn't be OK");
            final io.grpc.o0.h hVar = null;
            return new o0.e(hVar, hVar, d1Var, false);
        }

        public static o0.e g() {
            return o0.e.e;
        }

        public static o0.e h(o0.h hVar) {
            return o0.e.i(hVar, null);
        }

        public static o0.e i(o0.h hVar, l.a aVar) {
            n.p(hVar, "subchannel");
            return new o0.e(hVar, aVar, d1.f, false);
        }

        public d1 a() {
            return this.c;
        }

        public l.a b() {
            return this.b;
        }

        public o0.h c() {
            return this.a;
        }

        public boolean d() {
            return this.d;
        }

        public boolean equals(Object object) {
            boolean z2 = false;
            z2 = false;
            if (!(object instanceof o0.e)) {
                return false;
            }
            if (k.a(this.a, object.a)) {
                if (k.a(this.c, object.c)) {
                    if (k.a(this.b, object.b)) {
                        if (this.d == object.d) {
                            int i = 1;
                        }
                    }
                }
            }
            return z2;
        }

        public int hashCode() {
            Object[] arr = new Object[4];
            return k.b(this.a, this.c, this.b, Boolean.valueOf(this.d));
        }

        public String toString() {
            j.b bVar = j.c(this);
            bVar.d("subchannel", this.a);
            bVar.d("streamTracerFactory", this.b);
            bVar.d("status", this.c);
            bVar.e("drop", this.d);
            return bVar.toString();
        }
    }

    public static abstract class f {
        public abstract d a();

        public abstract t0 b();

        public abstract u0<?, ?> c();
    }

    public static final class g {

        private final List<y> a;
        private final a b;
        private final Object c;
        /* synthetic */ g(List list, a aVar, Object object, o0.a aVar2) {
            this(list, aVar, object);
        }

        public static o0.g.a d() {
            return new o0.g.a();
        }

        public List<y> a() {
            return this.a;
        }

        public a b() {
            return this.b;
        }

        public Object c() {
            return this.c;
        }

        public boolean equals(Object object) {
            boolean z2 = false;
            z2 = false;
            if (!(object instanceof o0.g)) {
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
            bVar.d("loadBalancingPolicyConfig", this.c);
            return bVar.toString();
        }

        private g(List<y> list, a aVar, Object object) {
            super();
            n.p(list, "addresses");
            this.a = Collections.unmodifiableList(new ArrayList(list));
            n.p(aVar, "attributes");
            this.b = aVar;
            this.c = object;
        }
    }

    public static abstract class h {
        public final y a() {
            boolean z = true;
            List list = b();
            final int i = 0;
            if (list.size() != 1) {
            }
            n.x(z, "%s does not have exactly one group", list);
            return (y)list.get(i);
        }

        public List<y> b() {
            throw new UnsupportedOperationException();
        }

        public Object d() {
            throw new UnsupportedOperationException();
        }

        public void g(o0.j jVar) {
            throw new UnsupportedOperationException("Not implemented");
        }

        public void h(List<y> list) {
            throw new UnsupportedOperationException();
        }

        public abstract a c();

        public abstract void e();

        public abstract void f();
    }

    public static abstract class i {
        public abstract o0.e a(o0.f fVar);

        @Deprecated
        public void b() {
        }
    }

    public interface j {
        void a(r rVar);
    }
    static {
        o0.a = a.c.a("health-checking-config");
    }

    public boolean a() {
        return false;
    }

    public abstract void b(d1 d1Var);

    public abstract void c(o0.g gVar);

    public void d() {
    }

    public abstract void e();
}
