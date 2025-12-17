package io.grpc.k1;

import com.google.common.base.n;
import io.grpc.g;
import io.grpc.h1;
import io.grpc.j1.b;
import io.grpc.j1.c1;
import io.grpc.j1.f2;
import io.grpc.j1.f2.d;
import io.grpc.j1.h;
import io.grpc.j1.h.b;
import io.grpc.j1.h1;
import io.grpc.j1.h1.b;
import io.grpc.j1.h1.c;
import io.grpc.j1.o2;
import io.grpc.j1.o2.b;
import io.grpc.j1.r0;
import io.grpc.j1.t;
import io.grpc.j1.t.a;
import io.grpc.j1.v;
import io.grpc.k1.r.a;
import io.grpc.k1.r.b;
import io.grpc.k1.r.b.b;
import io.grpc.k1.r.f;
import io.grpc.k1.r.h;
import io.grpc.s0;
import java.net.SocketAddress;
import java.util.EnumSet;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes3.dex */
public final class e extends b<io.grpc.k1.e> {

    static final b q;
    private static final long r;
    private static final f2.d<Executor> s;
    private final h1 a;
    private o2.b b;
    private Executor c;
    private ScheduledExecutorService d;
    private SocketFactory e;
    private SSLSocketFactory f;
    private final boolean g = false;
    private HostnameVerifier h;
    private b i;
    private io.grpc.k1.e.c j;
    private long k = Long.MAX_VALUE;
    private long l = Long.MAX_VALUE;
    private int m = 65535;
    private boolean n;
    private int o = 4194304;
    private int p = Integer.MAX_VALUE;

    static class b {

        static final int[] a;
        static final int[] b;
        static {
            int[] iArr = new int[values.length];
            e.b.b = iArr;
            int i2 = 1;
            iArr[e.c.PLAINTEXT.ordinal()] = i2;
            int i = 2;
            e.b.b[e.c.TLS.ordinal()] = i;
            int[] iArr4 = new int[values2.length];
            e.b.a = iArr4;
            iArr4[d.TLS.ordinal()] = i2;
            e.b.a[d.PLAINTEXT.ordinal()] = i;
        }
    }

    private static enum c {

        TLS,
        PLAINTEXT;
    }

    class a implements f2.d<Executor> {
        @Override // io.grpc.j1.f2$d
        public Object a() {
            return d();
        }

        @Override // io.grpc.j1.f2$d
        public void b(Object object) {
            c((Executor)object);
        }

        @Override // io.grpc.j1.f2$d
        public void c(Executor executor) {
            (ExecutorService)executor.shutdown();
        }

        @Override // io.grpc.j1.f2$d
        public Executor d() {
            return Executors.newCachedThreadPool(r0.i("grpc-okhttp-%d", true));
        }
    }

    private final class d implements h1.b {

        final io.grpc.k1.e a;
        private d(io.grpc.k1.e e) {
            this.a = e;
            super();
        }

        d(io.grpc.k1.e e, io.grpc.k1.e.a e$a2) {
            super(e);
        }

        @Override // io.grpc.j1.h1$b
        public int a() {
            return this.a.i();
        }
    }

    private final class e implements h1.c {

        final io.grpc.k1.e a;
        private e(io.grpc.k1.e e) {
            this.a = e;
            super();
        }

        e(io.grpc.k1.e e, io.grpc.k1.e.a e$a2) {
            super(e);
        }

        @Override // io.grpc.j1.h1$c
        public t a() {
            return this.a.g();
        }
    }

    static final class f implements t {

        private final int A;
        private final boolean B;
        private final h C;
        private final long D;
        private final int E;
        private final boolean F;
        private final int G;
        private final ScheduledExecutorService H;
        private final boolean I;
        private boolean J;
        private final Executor a;
        private final boolean b;
        private final boolean c;
        private final o2.b v;
        private final SocketFactory w;
        private final SSLSocketFactory x;
        private final HostnameVerifier y;
        private final b z;
        private f(Executor executor, ScheduledExecutorService scheduledExecutorService2, SocketFactory socketFactory3, SSLSocketFactory sSLSocketFactory4, HostnameVerifier hostnameVerifier5, b b6, int i7, boolean z8, long l9, long l10, int i11, boolean z12, int i13, o2.b o2$b14, boolean z15) {
            Object executor2;
            int i;
            int i2;
            Object obj;
            final Object obj2 = this;
            executor2 = executor;
            final Object obj3 = obj25;
            super();
            int i3 = 0;
            i2 = scheduledExecutorService2 == null ? i : i3;
            obj2.c = i2;
            if (i2 != 0) {
                obj = f2.d(r0.o);
            } else {
                obj = scheduledExecutorService2;
            }
            obj2.H = obj;
            obj2.w = socketFactory3;
            obj2.x = sSLSocketFactory4;
            obj2.y = hostnameVerifier5;
            obj2.z = b6;
            obj2.A = i7;
            obj2.B = z8;
            h hVar = new h("keepalive time nanos", l9, obj8);
            obj2.C = hVar;
            obj2.D = i11;
            obj2.E = i13;
            obj2.F = b14;
            obj2.G = z15;
            obj2.I = obj26;
            if (executor2 == null) {
            } else {
                i = i3;
            }
            obj2.b = i;
            n.p(obj3, "transportTracerFactory");
            obj2.v = (o2.b)obj3;
            if (i != 0) {
                obj2.a = (Executor)f2.d(e.f());
            } else {
                obj2.a = executor2;
            }
        }

        f(Executor executor, ScheduledExecutorService scheduledExecutorService2, SocketFactory socketFactory3, SSLSocketFactory sSLSocketFactory4, HostnameVerifier hostnameVerifier5, b b6, int i7, boolean z8, long l9, long l10, int i11, boolean z12, int i13, o2.b o2$b14, boolean z15, io.grpc.k1.e.a e$a16) {
            super(executor, scheduledExecutorService2, socketFactory3, sSLSocketFactory4, hostnameVerifier5, b6, i7, z8, l9, l10, i11, z12, i13, b14, z15, a16, obj17);
        }

        @Override // io.grpc.j1.t
        public ScheduledExecutorService K1() {
            return this.H;
        }

        @Override // io.grpc.j1.t
        public v S0(SocketAddress socketAddress, t.a t$a2, g g3) {
            Object str2;
            String str;
            io.grpc.a aVar;
            SocketFactory factory;
            HostnameVerifier hostnameVerifier;
            final Object obj = this;
            if (obj.J) {
            } else {
                h.b bVar = obj.C.d();
                e.f.a aVar2 = new e.f.a(obj, bVar);
                final Executor executor = obj.a;
                final SSLSocketFactory factory2 = obj.x;
                super((InetSocketAddress)socketAddress, a2.a(), a2.d(), a2.b(), executor, obj.w, factory2, obj.y, obj.z, obj.A, obj.E, a2.c(), aVar2, obj.G, obj.v.a(), obj.I);
                if (obj.B) {
                    hVar3.T(true, bVar.b(), executor, obj.D);
                }
                return hVar3;
            }
            IllegalStateException illegalStateException = new IllegalStateException("The transport factory is closed.");
            throw illegalStateException;
        }

        @Override // io.grpc.j1.t
        public void close() {
            boolean z2;
            boolean z;
            ScheduledExecutorService service;
            if (this.J) {
            }
            this.J = true;
            if (this.c) {
                f2.f(r0.o, this.H);
            }
            if (this.b) {
                f2.f(e.f(), this.a);
            }
        }
    }
    static {
        Logger.getLogger(e.class.getName());
        b.b bVar = new b.b(b.f);
        a[] arr = new a[8];
        final int i3 = 0;
        arr[i3] = a.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;
        final int i4 = 1;
        arr[i4] = a.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
        arr[2] = a.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384;
        arr[3] = a.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
        arr[4] = a.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256;
        arr[5] = a.TLS_DHE_DSS_WITH_AES_128_GCM_SHA256;
        arr[6] = a.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384;
        arr[7] = a.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384;
        bVar.f(arr);
        h[] arr2 = new h[i4];
        h tLS_1_2 = h.TLS_1_2;
        arr2[i3] = tLS_1_2;
        bVar.i(arr2);
        bVar.h(i4);
        e.q = bVar.e();
        e.r = TimeUnit.DAYS.toNanos(1000);
        e.a aVar = new e.a();
        e.s = aVar;
        EnumSet.of(h1.MTLS, h1.CUSTOM_MANAGERS);
    }

    private e(String string) {
        super();
        this.b = o2.a();
        this.i = e.q;
        this.j = e.c.TLS;
        long l = Long.MAX_VALUE;
        long l2 = r0.j;
        int i = 65535;
        int i2 = 4194304;
        int i3 = Integer.MAX_VALUE;
        final int i4 = 0;
        e.e eVar = new e.e(this, i4);
        e.d dVar = new e.d(this, i4);
        h1 h1Var = new h1(string, eVar, dVar);
        this.a = h1Var;
        final int obj5 = 0;
    }

    static f2.d f() {
        return e.s;
    }

    public static io.grpc.k1.e forTarget(String string) {
        e eVar = new e(string);
        return eVar;
    }

    @Override // io.grpc.j1.b
    public s0 c(long l, TimeUnit timeUnit2) {
        j(l, timeUnit2);
        return this;
    }

    @Override // io.grpc.j1.b
    public s0 d() {
        k();
        return this;
    }

    protected s0<?> e() {
        return this.a;
    }

    @Override // io.grpc.j1.b
    t g() {
        int i;
        final Object obj = this;
        i = Long.compare(l, l2) != 0 ? 1 : 0;
        super(obj.c, obj.d, obj.e, h(), obj.h, obj.i, obj.o, i, obj.k, obj12, obj.l, obj14, obj.m, obj.n, obj.p, obj.b, 0, 0);
        return fVar;
    }

    @Override // io.grpc.j1.b
    SSLSocketFactory h() {
        SSLSocketFactory socketFactory;
        int i;
        int i2 = e.b.b[this.j.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
            } else {
                if (this.f == null) {
                    this.f = SSLContext.getInstance("Default", f.e().g()).getSocketFactory();
                }
                return this.f;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown negotiation type: ");
            stringBuilder.append(this.j);
            RuntimeException runtimeException = new RuntimeException(stringBuilder.toString());
            throw runtimeException;
        }
        return null;
    }

    @Override // io.grpc.j1.b
    int i() {
        int i = e.b.b[this.j.ordinal()];
        if (i != 1) {
            if (i != 2) {
            } else {
                return 443;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.j);
            stringBuilder.append(" not handled");
            AssertionError assertionError = new AssertionError(stringBuilder.toString());
            throw assertionError;
        }
        return 80;
    }

    @Override // io.grpc.j1.b
    public io.grpc.k1.e j(long l, TimeUnit timeUnit2) {
        int i;
        int obj3;
        i = Long.compare(l, i2) > 0 ? 1 : 0;
        n.e(i, "keepalive time must be positive");
        obj3 = obj5.toNanos(l);
        this.k = obj3;
        obj3 = c1.l(obj3);
        this.k = obj3;
        if (Long.compare(obj3, l2) >= 0) {
            this.k = Long.MAX_VALUE;
        }
        return this;
    }

    @Override // io.grpc.j1.b
    public io.grpc.k1.e k() {
        n.v(z ^= 1, "Cannot change security when using ChannelCredentials");
        this.j = e.c.PLAINTEXT;
        return this;
    }

    @Override // io.grpc.j1.b
    public io.grpc.k1.e scheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        n.p(scheduledExecutorService, "scheduledExecutorService");
        this.d = (ScheduledExecutorService)scheduledExecutorService;
        return this;
    }

    @Override // io.grpc.j1.b
    public io.grpc.k1.e sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        n.v(z ^= 1, "Cannot change security when using ChannelCredentials");
        this.f = sSLSocketFactory;
        this.j = e.c.TLS;
        return this;
    }

    @Override // io.grpc.j1.b
    public io.grpc.k1.e transportExecutor(Executor executor) {
        this.c = executor;
        return this;
    }
}
