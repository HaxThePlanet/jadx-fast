package io.grpc;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.n;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes2.dex */
public final class u0<ReqT, RespT>  {

    private final io.grpc.u0.d a;
    private final String b;
    private final String c;
    private final io.grpc.u0.c<ReqT> d;
    private final io.grpc.u0.c<RespT> e;
    private final Object f;
    private final boolean g;
    private final boolean h;
    private final boolean i;

    static class a {
    }

    public static final class b {

        private io.grpc.u0.c<ReqT> a;
        private io.grpc.u0.c<RespT> b;
        private io.grpc.u0.d c;
        private String d;
        private boolean e;
        private boolean f;
        private Object g;
        private boolean h;
        b(io.grpc.u0.a u0$a) {
            super();
        }

        public io.grpc.u0<ReqT, RespT> a() {
            super(this.c, this.d, this.a, this.b, this.g, this.e, this.f, this.h, 0);
            return u0Var2;
        }

        public io.grpc.u0.b<ReqT, RespT> b(String string) {
            this.d = string;
            return this;
        }

        public io.grpc.u0.b<ReqT, RespT> c(io.grpc.u0.c<ReqT> u0$c) {
            this.a = c;
            return this;
        }

        public io.grpc.u0.b<ReqT, RespT> d(io.grpc.u0.c<RespT> u0$c) {
            this.b = c;
            return this;
        }

        public io.grpc.u0.b<ReqT, RespT> e(boolean z) {
            this.h = z;
            return this;
        }

        public io.grpc.u0.b<ReqT, RespT> f(io.grpc.u0.d u0$d) {
            this.c = d;
            return this;
        }
    }

    public interface c {
        public abstract T a(InputStream inputStream);

        public abstract InputStream b(T t);
    }

    public static enum d {

        UNARY,
        CLIENT_STREAMING,
        SERVER_STREAMING,
        BIDI_STREAMING,
        UNKNOWN;
        @Override // java.lang.Enum
        public final boolean clientSendsOneMessage() {
            int i;
            io.grpc.u0.d sERVER_STREAMING;
            if (this != u0.d.UNARY) {
                if (this == u0.d.SERVER_STREAMING) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
            return i;
        }

        @Override // java.lang.Enum
        public final boolean serverSendsOneMessage() {
            int i;
            io.grpc.u0.d cLIENT_STREAMING;
            if (this != u0.d.UNARY) {
                if (this == u0.d.CLIENT_STREAMING) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
            return i;
        }
    }
    static {
    }

    private u0(io.grpc.u0.d u0$d, String string2, io.grpc.u0.c<ReqT> u0$c3, io.grpc.u0.c<RespT> u0$c4, Object object5, boolean z6, boolean z7, boolean z8) {
        super();
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(2);
        n.p(d, "type");
        this.a = (u0.d)d;
        n.p(string2, "fullMethodName");
        this.b = (String)string2;
        this.c = u0.a(string2);
        n.p(c3, "requestMarshaller");
        this.d = (u0.c)c3;
        n.p(c4, "responseMarshaller");
        this.e = (u0.c)c4;
        this.f = object5;
        this.g = z6;
        this.h = z7;
        this.i = z8;
    }

    u0(io.grpc.u0.d u0$d, String string2, io.grpc.u0.c u0$c3, io.grpc.u0.c u0$c4, Object object5, boolean z6, boolean z7, boolean z8, io.grpc.u0.a u0$a9) {
        super(d, string2, c3, c4, object5, z6, z7, z8);
    }

    public static String a(String string) {
        n.p(string, "fullMethodName");
        int lastIndexOf = (String)string.lastIndexOf(47);
        if (lastIndexOf == -1) {
            return null;
        }
        return string.substring(0, lastIndexOf);
    }

    public static String b(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        n.p(string, "fullServiceName");
        stringBuilder.append((String)string);
        stringBuilder.append("/");
        n.p(string2, "methodName");
        stringBuilder.append((String)string2);
        return stringBuilder.toString();
    }

    public static <ReqT, RespT> io.grpc.u0.b<ReqT, RespT> g() {
        int i = 0;
        return u0.h(i, i);
    }

    public static <ReqT, RespT> io.grpc.u0.b<ReqT, RespT> h(io.grpc.u0.c<ReqT> u0$c, io.grpc.u0.c<RespT> u0$c2) {
        u0.b bVar = new u0.b(0);
        bVar.c(c);
        bVar.d(c2);
        return bVar;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public io.grpc.u0.d e() {
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
}
