package io.grpc;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.n;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: MethodDescriptor.java */
/* loaded from: classes2.dex */
public final class u0<ReqT, RespT> {

    private final u0.d a;
    private final String b;
    private final String c;
    private final u0.c<ReqT> d;
    private final u0.c<RespT> e;
    private final Object f;
    private final boolean g;
    private final boolean h;
    private final boolean i;

    static class a {
    }

    public static final class b<ReqT, RespT> {

        private u0.c<ReqT> a;
        private u0.c<RespT> b;
        private u0.d c;
        private String d;
        private boolean e;
        private boolean f;
        private Object g;
        private boolean h;
        /* synthetic */ b(u0.a aVar) {
            this();
        }

        public u0<ReqT, RespT> a() {
            u0 u0Var = new u0(this.c, this.d, this.a, this.b, this.g, this.e, this.f, this.h, null);
            return u0Var;
        }

        public u0.b<ReqT, RespT> b(String str) {
            this.d = str;
            return this;
        }

        public u0.b<ReqT, RespT> c(u0.c<ReqT> cVar) {
            this.a = cVar;
            return this;
        }

        public u0.b<ReqT, RespT> d(u0.c<RespT> cVar) {
            this.b = cVar;
            return this;
        }

        public u0.b<ReqT, RespT> e(boolean z) {
            this.h = z;
            return this;
        }

        public u0.b<ReqT, RespT> f(u0.d dVar) {
            this.c = dVar;
            return this;
        }

        private b() {
            super();
        }
    }

    public interface c<T> {
        T a(InputStream inputStream);

        InputStream b(T t);
    }

    public enum d {

        BIDI_STREAMING,
        CLIENT_STREAMING,
        SERVER_STREAMING,
        UNARY,
        UNKNOWN;
        @Override // java.lang.Enum
        public final boolean clientSendsOneMessage() {
            boolean z = false;
            if (this == u0.d.UNARY || this == u0.d.SERVER_STREAMING) {
                int i2 = 1;
            }
            return z;
        }

        @Override // java.lang.Enum
        public final boolean serverSendsOneMessage() {
            boolean z = false;
            if (this == u0.d.UNARY || this == u0.d.CLIENT_STREAMING) {
                int i2 = 1;
            }
            return z;
        }
    }
    /* synthetic */ u0(u0.d dVar, String str, u0.c cVar, u0.c cVar2, Object object, boolean z, boolean z2, boolean z3, u0.a aVar) {
        this(dVar, str, cVar, cVar2, object, z, z2, z3);
    }

    public static String a(String str) {
        n.p(str, "fullMethodName");
        int lastIndexOf = (String)str.lastIndexOf(47);
        if (lastIndexOf == -1) {
            return null;
        }
        return str.substring(0, lastIndexOf);
    }

    public static String b(String str, String str2) {
        final StringBuilder stringBuilder = new StringBuilder();
        n.p(str, "fullServiceName");
        String str4 = "/";
        n.p(str2, "methodName");
        str6 = str + str4 + str2;
        return str6;
    }

    public static <ReqT, RespT> u0.b<ReqT, RespT> g() {
        io.grpc.u0.c cVar = null;
        return u0.h(cVar, cVar);
    }

    public static <ReqT, RespT> u0.b<ReqT, RespT> h(u0.c<ReqT> cVar, u0.c<RespT> cVar2) {
        final io.grpc.u0.b bVar = new u0.b(null);
        bVar.c(cVar);
        bVar.d(cVar2);
        return bVar;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public u0.d e() {
        return this.a;
    }

    public boolean f() {
        return this.h;
    }

    public RespT i(InputStream inputStream) {
        return this.e.a(inputStream);
    }

    public InputStream j(ReqT reqt) {
        return this.d.b(reqt);
    }

    public String toString() {
        j.b bVar = j.c(this);
        bVar.d("fullMethodName", this.b);
        bVar.d("type", this.a);
        bVar.e("idempotent", this.g);
        bVar.e("safe", this.h);
        bVar.e("sampledToLocalTracing", this.i);
        bVar.d("requestMarshaller", this.d);
        bVar.d("responseMarshaller", this.e);
        bVar.d("schemaDescriptor", this.f);
        bVar.k();
        return bVar.toString();
    }

    private u0(u0.d dVar, String str, u0.c<ReqT> cVar, u0.c<RespT> cVar2, Object object, boolean z, boolean z2, boolean z3) {
        super();
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(2);
        n.p(dVar, "type");
        this.a = dVar;
        n.p(str, "fullMethodName");
        this.b = (String)str;
        this.c = u0.a(str);
        n.p(cVar, "requestMarshaller");
        this.d = cVar;
        n.p(cVar2, "responseMarshaller");
        this.e = cVar2;
        this.f = object;
        this.g = z;
        this.h = z2;
        this.i = z3;
    }

}
