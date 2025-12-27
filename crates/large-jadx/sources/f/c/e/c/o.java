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

/* compiled from: FirestoreGrpc.java */
/* loaded from: classes2.dex */
public final class o {

    private static volatile u0<c, d> a;
    private static volatile u0<e, f> b;
    private static volatile u0<a0, b0> c;
    private static volatile u0<p, q> d;

    class a implements c.a<o.b> {
        a() {
            super();
        }

        public o.b b(e eVar, d dVar) {
            return new o.b(eVar, dVar, null);
        }
    }

    public static final class b extends a<o.b> {
        /* synthetic */ b(e eVar, d dVar, o.a aVar) {
            this(eVar, dVar);
        }

        @Override // io.grpc.m1.a
        protected o.b i(e eVar, d dVar) {
            return new o.b(eVar, dVar);
        }

        private b(e eVar, d dVar) {
            super(eVar, dVar);
        }
    }
    private o() {
        super();
    }

    public static u0<c, d> a() {
        u0 u0Var;
        io.grpc.u0.c cVar;
        String str;
        if (o.a == null) {
            obj = o.class;
            synchronized (obj) {
                try {
                    if (o.a == null) {
                        u0.b bVar = u0.g();
                        bVar.f(u0.d.SERVER_STREAMING);
                        str = "BatchGetDocuments";
                        bVar.b(u0.b("google.firestore.v1.Firestore", str));
                        bVar.e(true);
                        bVar.c(b.b(c.g()));
                        bVar.d(b.b(d.c()));
                        o.a = bVar.a();
                    }
                } catch (Throwable th) {
                }
            }
        }
        return u0Var;
    }

    public static u0<e, f> b() {
        u0 u0Var;
        io.grpc.u0.c cVar;
        String str;
        if (o.b == null) {
            obj = o.class;
            synchronized (obj) {
                try {
                    if (o.b == null) {
                        u0.b bVar = u0.g();
                        bVar.f(u0.d.UNARY);
                        str = "Commit";
                        bVar.b(u0.b("google.firestore.v1.Firestore", str));
                        bVar.e(true);
                        bVar.c(b.b(e.e()));
                        bVar.d(b.b(f.d()));
                        o.b = bVar.a();
                    }
                } catch (Throwable th) {
                }
            }
        }
        return u0Var;
    }

    public static u0<p, q> c() {
        u0 u0Var;
        io.grpc.u0.c cVar;
        String str;
        if (o.d == null) {
            obj = o.class;
            synchronized (obj) {
                try {
                    if (o.d == null) {
                        u0.b bVar = u0.g();
                        bVar.f(u0.d.BIDI_STREAMING);
                        str = "Listen";
                        bVar.b(u0.b("google.firestore.v1.Firestore", str));
                        bVar.e(true);
                        bVar.c(b.b(p.g()));
                        bVar.d(b.b(q.c()));
                        o.d = bVar.a();
                    }
                } catch (Throwable th) {
                }
            }
        }
        return u0Var;
    }

    public static u0<a0, b0> d() {
        u0 u0Var;
        io.grpc.u0.c cVar;
        String str;
        if (o.c == null) {
            obj = o.class;
            synchronized (obj) {
                try {
                    if (o.c == null) {
                        u0.b bVar = u0.g();
                        bVar.f(u0.d.BIDI_STREAMING);
                        str = "Write";
                        bVar.b(u0.b("google.firestore.v1.Firestore", str));
                        bVar.e(true);
                        bVar.c(b.b(a0.f()));
                        bVar.d(b.b(b0.d()));
                        o.c = bVar.a();
                    }
                } catch (Throwable th) {
                }
            }
        }
        return u0Var;
    }

    public static o.b e(e eVar) {
        return (o.b)a.g(new o.a(), eVar);
    }
}
