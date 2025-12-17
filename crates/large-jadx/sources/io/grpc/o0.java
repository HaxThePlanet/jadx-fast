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

/* loaded from: classes2.dex */
public abstract class o0 {

    public static final io.grpc.a.c<Map<String, ?>> a;

    static class a {
    }

    public static final class b {

        private final List<io.grpc.y> a;
        private final io.grpc.a b;
        private final Object[][] c;
        private b(List<io.grpc.y> list, io.grpc.a a2, Object[][] object3Arr3Arr3) {
            super();
            n.p(list, "addresses are not set");
            this.a = (List)list;
            n.p(a2, "attrs");
            this.b = (a)a2;
            n.p(object3Arr3Arr3, "customOptions");
            this.c = (Object[][])object3Arr3Arr3;
        }

        b(List list, io.grpc.a a2, Object[][] object3Arr3Arr3, io.grpc.o0.a o0$a4) {
            super(list, a2, object3Arr3Arr3);
        }

        public static io.grpc.o0.b.a c() {
            o0.b.a aVar = new o0.b.a();
            return aVar;
        }

        public List<io.grpc.y> a() {
            return this.a;
        }

        public io.grpc.a b() {
            return this.b;
        }

        public io.grpc.o0.b.a d() {
            final io.grpc.o0.b.a aVar = o0.b.c();
            aVar.e(this.a);
            aVar.f(this.b);
            o0.b.a.a(aVar, this.c);
            return aVar;
        }

        public String toString() {
            j.b bVar = j.c(this);
            bVar.d("addrs", this.a);
            bVar.d("attrs", this.b);
            bVar.d("customOptions", Arrays.deepToString(this.c));
            return bVar.toString();
        }
    }

    public static abstract class c {
        public abstract io.grpc.o0 a(io.grpc.o0.d o0$d);
    }

    public static abstract class d {
        public io.grpc.o0.h a(io.grpc.o0.b o0$b) {
            UnsupportedOperationException obj1 = new UnsupportedOperationException();
            throw obj1;
        }

        public io.grpc.g b() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }

        public io.grpc.f1 c() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }

        public void d() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }

        public abstract void e(io.grpc.q q, io.grpc.o0.i o0$i2);
    }

    public static final class e {

        private static final io.grpc.o0.e e;
        private final io.grpc.o0.h a;
        private final io.grpc.l.a b;
        private final io.grpc.d1 c;
        private final boolean d;
        static {
            final int i = 0;
            o0.e eVar = new o0.e(i, i, d1.f, 0);
            o0.e.e = eVar;
        }

        private e(io.grpc.o0.h o0$h, io.grpc.l.a l$a2, io.grpc.d1 d13, boolean z4) {
            super();
            this.a = h;
            this.b = a2;
            n.p(d13, "status");
            this.c = (d1)d13;
            this.d = z4;
        }

        public static io.grpc.o0.e e(io.grpc.d1 d1) {
            final int i2 = 1;
            n.e(z ^= i2, "drop status shouldn't be OK");
            int i3 = 0;
            o0.e eVar = new o0.e(i3, i3, d1, i2);
            return eVar;
        }

        public static io.grpc.o0.e f(io.grpc.d1 d1) {
            n.e(z ^= 1, "error status shouldn't be OK");
            final int i3 = 0;
            o0.e eVar = new o0.e(i3, i3, d1, 0);
            return eVar;
        }

        public static io.grpc.o0.e g() {
            return o0.e.e;
        }

        public static io.grpc.o0.e h(io.grpc.o0.h o0$h) {
            return o0.e.i(h, 0);
        }

        public static io.grpc.o0.e i(io.grpc.o0.h o0$h, io.grpc.l.a l$a2) {
            n.p(h, "subchannel");
            o0.e eVar = new o0.e((o0.h)h, a2, d1.f, 0);
            return eVar;
        }

        public io.grpc.d1 a() {
            return this.c;
        }

        public io.grpc.l.a b() {
            return this.b;
        }

        public io.grpc.o0.h c() {
            return this.a;
        }

        public boolean d() {
            return this.d;
        }

        public boolean equals(Object object) {
            boolean z;
            int i;
            Object hVar;
            Object obj4;
            if (!object instanceof o0.e) {
                return 0;
            }
            if (k.a(this.a, object.a) && k.a(this.c, object.c) && k.a(this.b, object.b) && this.d == object.d) {
                if (k.a(this.c, object.c)) {
                    if (k.a(this.b, object.b)) {
                        if (this.d == object.d) {
                            i = 1;
                        }
                    }
                }
            }
            return i;
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
        public abstract io.grpc.d a();

        public abstract io.grpc.t0 b();

        public abstract io.grpc.u0<?, ?> c();
    }

    public static final class g {

        private final List<io.grpc.y> a;
        private final io.grpc.a b;
        private final Object c;
        private g(List<io.grpc.y> list, io.grpc.a a2, Object object3) {
            super();
            n.p(list, "addresses");
            ArrayList arrayList = new ArrayList((Collection)list);
            this.a = Collections.unmodifiableList(arrayList);
            n.p(a2, "attributes");
            this.b = (a)a2;
            this.c = object3;
        }

        g(List list, io.grpc.a a2, Object object3, io.grpc.o0.a o0$a4) {
            super(list, a2, object3);
        }

        public static io.grpc.o0.g.a d() {
            o0.g.a aVar = new o0.g.a();
            return aVar;
        }

        public List<io.grpc.y> a() {
            return this.a;
        }

        public io.grpc.a b() {
            return this.b;
        }

        public Object c() {
            return this.c;
        }

        public boolean equals(Object object) {
            boolean z;
            int i;
            Object list;
            Object obj4;
            if (!object instanceof o0.g) {
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
            bVar.d("loadBalancingPolicyConfig", this.c);
            return bVar.toString();
        }
    }

    public static abstract class h {
        public final io.grpc.y a() {
            int i;
            List list = b();
            final int i2 = 0;
            if (list.size() == 1) {
            } else {
                i = i2;
            }
            n.x(i, "%s does not have exactly one group", list);
            return (y)list.get(i2);
        }

        public List<io.grpc.y> b() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }

        public abstract io.grpc.a c();

        public Object d() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }

        public abstract void e();

        public abstract void f();

        public void g(io.grpc.o0.j o0$j) {
            UnsupportedOperationException obj2 = new UnsupportedOperationException("Not implemented");
            throw obj2;
        }

        public void h(List<io.grpc.y> list) {
            UnsupportedOperationException obj1 = new UnsupportedOperationException();
            throw obj1;
        }
    }

    public static abstract class i {
        public abstract io.grpc.o0.e a(io.grpc.o0.f o0$f);

        @Deprecated
        public void b() {
        }
    }

    public interface j {
        public abstract void a(io.grpc.r r);
    }
    static {
        o0.a = a.c.a("health-checking-config");
    }

    public boolean a() {
        return 0;
    }

    public abstract void b(io.grpc.d1 d1);

    public abstract void c(io.grpc.o0.g o0$g);

    public void d() {
    }

    public abstract void e();
}
