package io.grpc.k1;

import com.google.common.base.n;
import io.grpc.g;
import io.grpc.j1.c1;
import io.grpc.j1.f2;
import io.grpc.j1.f2.d;
import io.grpc.j1.h.b;
import io.grpc.j1.h1.b;
import io.grpc.j1.h1.c;
import io.grpc.j1.o2;
import io.grpc.j1.o2.b;
import io.grpc.j1.r0;
import io.grpc.j1.t;
import io.grpc.j1.t.a;
import io.grpc.j1.v;
import io.grpc.k1.r.a;
import io.grpc.k1.r.b.b;
import io.grpc.k1.r.f;
import io.grpc.s0;
import java.net.SocketAddress;
import java.security.GeneralSecurityException;
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

/* compiled from: OkHttpChannelBuilder.java */
/* loaded from: classes3.dex */
public final class e extends io.grpc.j1.b<e> {

    static final io.grpc.k1.r.b q;
    private static final long r = 0L;
    private static final f2.d<Executor> s = new e$a<>();
    private final io.grpc.j1.h1 a = new h1();
    private o2.b b;
    private Executor c;
    private ScheduledExecutorService d;
    private SocketFactory e;
    private SSLSocketFactory f;
    private final boolean g = false;
    private HostnameVerifier h;
    private io.grpc.k1.r.b i;
    private e.c j;
    private long k = Long.MAX_VALUE;
    private long l;
    private int m = 65535;
    private boolean n;
    private int o = 4194304;
    private int p = Integer.MAX_VALUE;

    static class b {

        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static {
            int[] iArr = new int[e.c.values().length];
            e.b.b = iArr;
            int i2 = 1;
            try {
                iArr[e.c.PLAINTEXT.ordinal()] = i2;
            } catch (java.lang.NoSuchFieldError unused) {
                int[] iArr4 = new int[d.values().length];
                e.b.a = iArr4;
                return;
            }
            int i = 2;
            try {
                e.b.b[e.c.TLS.ordinal()] = i;
            } catch (java.lang.NoSuchFieldError unused) {
                iArr4 = new int[d.values().length];
                e.b.a = iArr4;
                return;
            }
            try {
                iArr4[d.TLS.ordinal()] = i2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                e.b.a[d.PLAINTEXT.ordinal()] = i;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    private enum c {

        PLAINTEXT,
        TLS;
    }

    class a implements f2.d<Executor> {
        a() {
            super();
        }

        public void c(Executor executor) {
            executor.shutdown();
        }

        public Executor d() {
            return Executors.newCachedThreadPool(r0.i("grpc-okhttp-%d", true));
        }
    }

    private final class d implements h1.b {

        final /* synthetic */ e a;
        private d() {
            this.a = eVar;
            super();
        }

        public int a() {
            return this.a.i();
        }

        /* synthetic */ d(e.a aVar) {
            this(eVar);
        }
    }

    private final class e implements h1.c {

        final /* synthetic */ e a;
        private e() {
            this.a = eVar;
            super();
        }

        public t a() {
            return this.a.g();
        }

        /* synthetic */ e(e.a aVar) {
            this(eVar);
        }
    }

    static final class f implements t {

        private final int A;
        private final boolean B;
        private final io.grpc.j1.h C;
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
        private final io.grpc.k1.r.b z;
        /* synthetic */ f(Executor executor, ScheduledExecutorService scheduledExecutorService, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, io.grpc.k1.r.b bVar, int i, boolean z, long j, long j2, int i2, boolean z2, int i3, o2.b bVar2, boolean z3, e.a aVar) {
            this(executor, scheduledExecutorService, socketFactory, sSLSocketFactory, hostnameVerifier, bVar, i, z, j, r10, j2, r12, i2, z2, i3, bVar2, z3);
        }

        public ScheduledExecutorService K1() {
            return this.H;
        }

        public v S0(SocketAddress socketAddress, t.a aVar, g gVar) {
            final Object socketAddress3 = this;
            if (socketAddress3.J) {
                throw new IllegalStateException("The transport factory is closed.");
            } else {
                h.b bVar = socketAddress3.C.d();
                h hVar = new h((InetSocketAddress)socketAddress, aVar.a(), aVar.d(), aVar.b(), executor, socketAddress3.w, sSLSocketFactory, socketAddress3.y, socketAddress3.z, socketAddress3.A, socketAddress3.E, aVar.c(), aVar, i, socketAddress3.v.a(), z);
                if (socketAddress3.B) {
                    hVar.T(true, bVar.b(), socketAddress3.D, socketAddress3.F);
                }
                return hVar;
            }
        }

        public void close() {
            ScheduledExecutorService scheduledExecutorService;
            if (this.J) {
                return;
            }
            this.J = true;
            if (this.c) {
                f2.f(r0.o, this.H);
            }
            if (this.b) {
                f2.f(e.s, this.a);
            }
        }

        private f(Executor executor, ScheduledExecutorService scheduledExecutorService, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, io.grpc.k1.r.b bVar, int i, boolean z, long j, long j2, int i2, boolean z2, int i3, o2.b bVar2, boolean z3) {
            Object scheduledExecutorService22;
            final Object executor3 = this;
            executor2 = executor;
            final Object obj = bVar2;
            super();
            i = 1;
            i = 0;
            int r5 = scheduledExecutorService == null ? 1 : i;
            executor3.c = r5;
            if (r5 != 0) {
                scheduledExecutorService22 = f2.d(r0.o);
            } else {
                scheduledExecutorService22 = scheduledExecutorService;
            }
            executor3.H = scheduledExecutorService22;
            executor3.w = socketFactory;
            executor3.x = sSLSocketFactory;
            executor3.y = hostnameVerifier;
            executor3.z = bVar;
            executor3.A = i;
            executor3.B = z;
            executor3.C = new h("keepalive time nanos", j, r8);
            executor3.D = j2;
            executor3.E = i2;
            executor3.F = z2;
            executor3.G = i3;
            executor3.I = z3;
            if (executor2 != null) {
            }
            executor3.b = i;
            n.p(obj, "transportTracerFactory");
            executor3.v = obj;
            if (i != 0) {
                executor3.a = (Executor)f2.d(e.s);
            } else {
                executor3.a = executor2;
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
        io.grpc.k1.r.h[] arr2 = new h[i4];
        io.grpc.k1.r.h tLS_1_22 = h.TLS_1_2;
        arr2[i3] = tLS_1_22;
        bVar.i(arr2);
        bVar.h(true);
        e.q = bVar.e();
        e.r = TimeUnit.DAYS.toNanos(1000L);
        EnumSet.of(h1.MTLS, h1.CUSTOM_MANAGERS);
    }

    private e(String str) {
        super();
        this.b = o2.a();
        this.i = e.q;
        this.j = e.c.TLS;
        this.l = r0.j;
        final io.grpc.k1.e.a aVar = null;
        io.grpc.j1.h1 h1Var = new h1(str, new e.e(this, aVar), new e.d(this, aVar));
    }

    static /* synthetic */ f2.d f() {
        return e.s;
    }

    public static e forTarget(String str) {
        return new e(str);
    }

    @Override // io.grpc.j1.b
    protected s0<?> e() {
        return this.a;
    }

    @Override // io.grpc.j1.b
    t g() {
        int i = 1;
        final Object obj = this;
        int r1 = obj.k != 9223372036854775807L ? 1 : 0;
        e.f fVar = new e.f(obj.c, obj.d, obj.e, this.h(), obj.h, obj.i, obj.o, (obj.k != 9223372036854775807L ? 1 : 0), obj.k, l4, obj.l, z3, obj.m, (obj.k != 9223372036854775807L ? 1 : 0), (obj.k != 9223372036854775807L ? 1 : 0), (obj.k != 9223372036854775807L ? 1 : 0), 0, 0);
        return (obj.k != 9223372036854775807L ? 1 : 0);
    }

    @Override // io.grpc.j1.b
    SSLSocketFactory h() throws java.security.NoSuchAlgorithmException {
        int i2 = e.b.b[this.j.ordinal()];
        if (e.b.b != 1 && e.b.b == 2) {
            try {
                if (this.f == null) {
                    this.f = SSLContext.getInstance("Default", f.e().g()).getSocketFactory();
                }
            } catch (java.security.GeneralSecurityException generalSecurity) {
                throw new RuntimeException("TLS Provider failure", generalSecurity);
            }
            return this.f;
        }
        return null;
    }

    @Override // io.grpc.j1.b
    int i() {
        int i = e.b.b[this.j.ordinal()];
        if (e.b.b != 1 && e.b.b == 2) {
            return 443;
        }
        return 80;
    }

    @Override // io.grpc.j1.b
    public e j(long j, TimeUnit timeUnit) {
        boolean z = true;
        int r0 = j > 0 ? 1 : 0;
        n.e((j > 0 ? 1 : 0), "keepalive time must be positive");
        long nanos = timeUnit.toNanos(j);
        this.k = nanos;
        long l2 = c1.l(nanos);
        this.k = l2;
        r0 = e.r;
        if (l2 >= r0) {
            this.k = Long.MAX_VALUE;
        }
        return this;
    }

    @Override // io.grpc.j1.b
    public e k() {
        n.v(!this.g, "Cannot change security when using ChannelCredentials");
        this.j = e.c.PLAINTEXT;
        return this;
    }

    @Override // io.grpc.j1.b
    public e scheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        n.p(scheduledExecutorService, "scheduledExecutorService");
        this.d = scheduledExecutorService;
        return this;
    }

    @Override // io.grpc.j1.b
    public e sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        n.v(!this.g, "Cannot change security when using ChannelCredentials");
        this.f = sSLSocketFactory;
        this.j = e.c.TLS;
        return this;
    }

    @Override // io.grpc.j1.b
    public e transportExecutor(Executor executor) {
        this.c = executor;
        return this;
    }
}
