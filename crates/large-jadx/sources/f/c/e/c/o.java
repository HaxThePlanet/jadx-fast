package f.c.e.c;

import io.grpc.d;
import io.grpc.e;
import io.grpc.l1.a.b;
import io.grpc.m1.a;
import io.grpc.m1.c;
import io.grpc.m1.c.a;
import io.grpc.u0;
import io.grpc.u0.b;
import io.grpc.u0.d;

/* loaded from: classes2.dex */
public final class o {

    private static volatile u0<f.c.e.c.c, f.c.e.c.d> a;
    private static volatile u0<f.c.e.c.e, f.c.e.c.f> b;
    private static volatile u0<f.c.e.c.a0, f.c.e.c.b0> c;
    private static volatile u0<f.c.e.c.p, f.c.e.c.q> d;

    class a implements c.a<f.c.e.c.o.b> {
        @Override // io.grpc.m1.c$a
        public c a(e e, d d2) {
            return b(e, d2);
        }

        @Override // io.grpc.m1.c$a
        public f.c.e.c.o.b b(e e, d d2) {
            o.b bVar = new o.b(e, d2, 0);
            return bVar;
        }
    }

    public static final class b extends a<f.c.e.c.o.b> {
        private b(e e, d d2) {
            super(e, d2);
        }

        b(e e, d d2, f.c.e.c.o.a o$a3) {
            super(e, d2);
        }

        @Override // io.grpc.m1.a
        protected c a(e e, d d2) {
            return i(e, d2);
        }

        @Override // io.grpc.m1.a
        protected f.c.e.c.o.b i(e e, d d2) {
            o.b bVar = new o.b(e, d2);
            return bVar;
        }
    }
    public static u0<f.c.e.c.c, f.c.e.c.d> a() {
        u0 u0Var;
        Class<f.c.e.c.o> obj;
        io.grpc.u0.c cVar;
        String str;
        obj = o.class;
        if (o.a == null && o.a == null) {
            obj = o.class;
            synchronized (obj) {
                u0.b bVar = u0.g();
                bVar.f(u0.d.SERVER_STREAMING);
                bVar.b(u0.b("google.firestore.v1.Firestore", "BatchGetDocuments"));
                bVar.e(true);
                bVar.c(b.b(c.g()));
                bVar.d(b.b(d.c()));
                o.a = bVar.a();
            }
        }
        return u0Var;
    }

    public static u0<f.c.e.c.e, f.c.e.c.f> b() {
        u0 u0Var;
        Class<f.c.e.c.o> obj;
        io.grpc.u0.c cVar;
        String str;
        obj = o.class;
        if (o.b == null && o.b == null) {
            obj = o.class;
            synchronized (obj) {
                u0.b bVar = u0.g();
                bVar.f(u0.d.UNARY);
                bVar.b(u0.b("google.firestore.v1.Firestore", "Commit"));
                bVar.e(true);
                bVar.c(b.b(e.e()));
                bVar.d(b.b(f.d()));
                o.b = bVar.a();
            }
        }
        return u0Var;
    }

    public static u0<f.c.e.c.p, f.c.e.c.q> c() {
        u0 u0Var;
        Class<f.c.e.c.o> obj;
        io.grpc.u0.c cVar;
        String str;
        obj = o.class;
        if (o.d == null && o.d == null) {
            obj = o.class;
            synchronized (obj) {
                u0.b bVar = u0.g();
                bVar.f(u0.d.BIDI_STREAMING);
                bVar.b(u0.b("google.firestore.v1.Firestore", "Listen"));
                bVar.e(true);
                bVar.c(b.b(p.g()));
                bVar.d(b.b(q.c()));
                o.d = bVar.a();
            }
        }
        return u0Var;
    }

    public static u0<f.c.e.c.a0, f.c.e.c.b0> d() {
        u0 u0Var;
        Class<f.c.e.c.o> obj;
        io.grpc.u0.c cVar;
        String str;
        obj = o.class;
        if (o.c == null && o.c == null) {
            obj = o.class;
            synchronized (obj) {
                u0.b bVar = u0.g();
                bVar.f(u0.d.BIDI_STREAMING);
                bVar.b(u0.b("google.firestore.v1.Firestore", "Write"));
                bVar.e(true);
                bVar.c(b.b(a0.f()));
                bVar.d(b.b(b0.d()));
                o.c = bVar.a();
            }
        }
        return u0Var;
    }

    public static f.c.e.c.o.b e(e e) {
        o.a aVar = new o.a();
        return (o.b)a.g(aVar, e);
    }
}
