package io.grpc.k1;

import com.google.common.base.j.b;
import com.google.common.base.n;
import com.google.common.base.s;
import f.f.a.c.b;
import f.f.a.e.b;
import io.grpc.StatusException;
import io.grpc.a.b;
import io.grpc.b0;
import io.grpc.b1;
import io.grpc.c0;
import io.grpc.d0.b;
import io.grpc.d0.c;
import io.grpc.d1;
import io.grpc.d1.b;
import io.grpc.i0;
import io.grpc.j1.a.c;
import io.grpc.j1.c1;
import io.grpc.j1.c1.c;
import io.grpc.j1.d2;
import io.grpc.j1.f2;
import io.grpc.j1.i2;
import io.grpc.j1.k1.a;
import io.grpc.j1.o2;
import io.grpc.j1.o2.c;
import io.grpc.j1.q0;
import io.grpc.j1.r.a;
import io.grpc.j1.r0;
import io.grpc.j1.r0.i;
import io.grpc.j1.s.a;
import io.grpc.j1.v;
import io.grpc.j1.v0;
import io.grpc.j1.w0;
import io.grpc.k1.r.j.b.a;
import io.grpc.l;
import io.grpc.t0;
import io.grpc.u0;
import io.grpc.u0.d;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import l.d0;
import l.h;

/* compiled from: OkHttpClientTransport.java */
/* loaded from: classes3.dex */
class h implements v, b.a {

    private static final Map<io.grpc.k1.r.j.a, d1> X;
    private static final Logger Y;
    private static final g[] Z;
    private final SocketFactory A;
    private SSLSocketFactory B;
    private HostnameVerifier C;
    private Socket D;
    private int E;
    private final Deque<g> F;
    private final io.grpc.k1.r.b G;
    private io.grpc.k1.r.j.c H;
    private ScheduledExecutorService I;
    private c1 J;
    private boolean K;
    private long L;
    private long M;
    private boolean N;
    private final Runnable O;
    private final int P;
    private final boolean Q;
    private final o2 R;
    private final w0<g> S;
    private d0.b T;
    final c0 U;
    Runnable V;
    com.google.common.util.concurrent.f<Void> W;
    private final InetSocketAddress a;
    private final String b;
    private final String c;
    private final Random d;
    private final s<com.google.common.base.q> e;
    private final int f;
    private k1.a g;
    private io.grpc.k1.r.j.b h;
    private i i;
    private b j;
    private p k;
    private final Object l;
    private final i0 m;
    private int n;
    private final Map<Integer, g> o;
    private final Executor p;
    private final d2 q;
    private final int r;
    private int s;
    private h.f t;
    private io.grpc.a u;
    private d1 v;
    private boolean w;
    private v0 x;
    private boolean y;
    private boolean z;

    class c implements Runnable {

        final /* synthetic */ h a;
        c() {
            this.a = hVar;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.V != null) {
                this.a.V.run();
            }
            this.a.t = new h.f(hVar2, this.a.h, this.a.i);
            this.a.p.execute(this.a.t);
            Object obj2 = this.a.l;
            synchronized (obj2) {
                try {
                    this.a.E = 0x7fffffff /* Unknown resource */;
                    this.a.n0();
                } catch (Throwable th) {
                }
            }
            Object obj3 = null;
            this.a.W.B(obj3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) obj3;
        }
    }

    class d implements Runnable {

        final /* synthetic */ CountDownLatch a;
        final /* synthetic */ a b;
        final /* synthetic */ io.grpc.k1.r.j.j c;
        final /* synthetic */ h v;
        d(CountDownLatch countDownLatch, a aVar, io.grpc.k1.r.j.j jVar) {
            this.v = hVar;
            this.a = countDownLatch;
            this.b = aVar;
            this.c = jVar;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th;
            javax.net.ssl.SSLSession session = null;
            io.grpc.k1.h hVar10;
            Socket socket;
            io.grpc.k1.r.j.j fVar2;
            InetSocketAddress inetSocketAddress;
            java.net.SocketAddress socketAddress;
            String str3;
            b1 nONE2;
            try {
                this.a.await();
            } catch (Throwable th) {
            } catch (Exception e1) {
            } catch (io.grpc.StatusException status2) {
            }
            int i2 = 0;
            boolean z2 = true;
            try {
                socket = this.v.A.createSocket(this.v.a.getAddress(), this.v.a.getPort());
                socket = this.v.S(hVar15.U.c(), (InetSocketAddress)this.v.U.b(), this.v.U.d(), this.v.U.a());
                if (this.v.B != null) {
                    session = m.b(this.v.B, this.v.C, socket, this.v.X(), this.v.Y(), this.v.G).getSession();
                }
                socket.setTcpNoDelay(z2);
                this.b.m(q.i(socket), socket);
                a.b bVar4 = this.v.u.d();
                bVar4.d(b0.a, socket.getRemoteSocketAddress());
                bVar4.d(b0.b, socket.getLocalSocketAddress());
                bVar4.d(b0.c, session);
                b1 r7 = this.v == null ? b1.NONE : b1.PRIVACY_AND_INTEGRITY;
                bVar4.d(q0.a, (this.v == null ? b1.NONE : b1.PRIVACY_AND_INTEGRITY));
                this.v.u = bVar4.a();
            } catch (Throwable th) {
            } catch (Exception e1) {
            } catch (io.grpc.StatusException status2) {
            }
            try {
                StringBuilder stringBuilder = new StringBuilder();
                String str5 = "Unsupported SocketAddress implementation ";
                Class cls = this.v.U.b().getClass();
                str4 = str5 + cls;
                throw d1.m.r(str4).c();
            } catch (Throwable th) {
            } catch (Exception e1) {
            } catch (io.grpc.StatusException status2) {
            }
            Thread thread = this.c.a(thread, z);
            fVar2 = new h.f(hVar10, thread);
            this.v.t = fVar2;
            throw status2;
        }
    }

    class e implements Runnable {

        final /* synthetic */ h a;
        e() {
            this.a = hVar;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.p.execute(this.a.t);
            Object obj2 = this.a.l;
            synchronized (obj2) {
                try {
                    this.a.E = 0x7fffffff /* Unknown resource */;
                    this.a.n0();
                    return;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
    }

    class a extends w0<g> {

        final /* synthetic */ h b;
        a() {
            this.b = hVar;
            super();
        }

        @Override // io.grpc.j1.w0
        protected void b() {
            this.b.g.d(true);
        }

        @Override // io.grpc.j1.w0
        protected void c() {
            this.b.g.d(false);
        }
    }

    class b implements o2.c {
        b() {
            super();
        }
    }

    class f implements b.a, Runnable {

        private final i a;
        io.grpc.k1.r.j.b b;
        boolean c;
        final /* synthetic */ h v;
        f(io.grpc.k1.r.j.b bVar) {
            this(hVar, bVar, new i(Level.FINE, h.class));
        }

        private int a(List<io.grpc.k1.r.j.d> list) {
            int i = 0;
            int i2 = 0;
            i = 0;
            i2 = 0;
            int size = list.size();
            while (i2 < size) {
                Object item = list.get(i2);
                i3 = (item.a.E() + 32) + item.b.E();
                l = (long)i3;
                i = i + l;
                i2 = i2 + 1;
                size = list.size();
            }
            return (int)(Math.min(i, 2147483647L));
        }

        public void data(boolean z, int i, h hVar, int i2) {
            io.grpc.k1.g.b bVar;
            final int i22 = i;
            this.a.b(i.a.INBOUND, i22, hVar.h(), i2, z);
            io.grpc.k1.g gVar = this.v.a0(i);
            if (gVar == null) {
                if (this.v.e0(i)) {
                    Object obj3 = this.v.l;
                    synchronized (obj3) {
                        try {
                            this.v.j.p(i, a.INVALID_STREAM);
                        } catch (Throwable th) {
                        }
                    }
                    l = (long)i2;
                    hVar.skip(l);
                    h.B(this.v, i2);
                    float f3 = (float)this.v.s;
                    float f2 = 0.5f;
                    f = (float)this.v.f * f2;
                    if (this.v >= this.v) {
                        Object obj2 = this.v.l;
                        synchronized (obj2) {
                            try {
                                i = 0;
                                this.v.j.windowUpdate(i, (long)this.v.s);
                            } catch (Throwable th) {
                            }
                        }
                        this.v.s = i;
                    }
                    return;
                }
                final StringBuilder stringBuilder = new StringBuilder();
                String str = "Received data for unknown stream: ";
                str2 = str + th;
                this.v.h0(a.PROTOCOL_ERROR, str2);
                return;
            }
            long l2 = (long)i2;
            hVar.V1(l2);
            l.f fVar = new f();
            fVar.write(hVar.h(), l2);
            c.c("OkHttpClientTransport$ClientFrameHandler.data", gVar.S().f0());
            Object obj = this.v.l;
            synchronized (obj) {
                try {
                    gVar.S().g0(fVar, th);
                } catch (Throwable th) {
                }
            }
        }

        public void p(int i, io.grpc.k1.r.j.a aVar) {
            int i2 = 0;
            d1.b cANCELLED2;
            r.a aVar22;
            this.a.h(i.a.INBOUND, i, aVar);
            final d1 d1Var2 = h.r0(aVar).f("Rst Stream");
            if (d1Var2.n() != d1.b.CANCELLED) {
                if (d1Var2.n() == d1.b.DEADLINE_EXCEEDED) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
            }
            Object obj2 = this.v.l;
            synchronized (obj2) {
                try {
                    Object value = this.v.o.get(Integer.valueOf(i));
                    if (value != null) {
                        c.c("OkHttpClientTransport$ClientFrameHandler.rstStream", value.S().f0());
                        aVar = aVar == a.REFUSED_STREAM ? r.a.REFUSED : r.a.PROCESSED;
                        aVar = null;
                        t0 t0Var = null;
                        this.v.U(i, d1Var2, (aVar == a.REFUSED_STREAM ? r.a.REFUSED : r.a.PROCESSED), i2, null, null);
                    }
                } catch (Throwable th) {
                }
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) th;
            }
        }

        public void ping(boolean z, int i, int i2) {
            String formatted;
            Level wARNING2;
            String str;
            Object[] arr;
            Long num;
            Logger logger;
            v0 i22 = null;
            long l3 = (long)i << 32L | (long)i2 & 4294967295L;
            this.a.e(i.a.INBOUND, l3);
            boolean z2 = true;
            if (!z) {
                Object obj = this.v.l;
                synchronized (obj) {
                    try {
                        this.v.j.ping(z2, i, i2);
                    } catch (Throwable th) {
                    }
                }
            } else {
                obj = this.v.l;
                synchronized (obj) {
                    try {
                        i22 = null;
                        if (this.v.x == null) {
                            formatted = "Received unexpected ping ack. No ping outstanding";
                            h.Y.warning(formatted);
                        } else {
                            long l7 = this.v.x.h();
                            if (l7 == this.v) {
                                this.v.x = null;
                            } else {
                                str = "Received unexpected ping ack. Expecting %d, got %d";
                                arr = new Object[2];
                                i = 0;
                                arr[i] = Long.valueOf(this.v.x.h());
                                arr[z2] = Long.valueOf(l3);
                                h.Y.log(Level.WARNING, String.format(str, arr));
                            }
                        }
                    } catch (Throwable th) {
                    }
                }
                if (i22 != null) {
                    i22.d();
                }
            }
        }

        public void pushPromise(int i, int i2, List<io.grpc.k1.r.j.d> list) {
            this.a.g(i.a.INBOUND, i, i2, list);
            Object obj = this.v.l;
            synchronized (obj) {
                try {
                    this.v.j.p(i, a.PROTOCOL_ERROR);
                    return;
                } catch (Throwable th) {
                }
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) th;
            }
        }

        public void q(int i, io.grpc.k1.r.j.a aVar, l.i iVar) {
            long l2;
            d1 d1Var;
            this.a.c(i.a.INBOUND, i, aVar, iVar);
            if (aVar == a.ENHANCE_YOUR_CALM && "too_many_pings".equals(str4)) {
                this.v.O.run();
            }
            if (iVar.E() > 0) {
                d1Var = r0.i.statusForCode((long)aVar.httpCode).f("Received Goaway").f(iVar.E());
            }
            this.v.m0(i, 0, d1Var);
        }

        public void r(boolean z, io.grpc.k1.r.j.i iVar) {
            int i2;
            this.a.i(i.a.INBOUND, iVar);
            Object obj = this.v.l;
            int i = 4;
            synchronized (obj) {
                try {
                    if (l.b(iVar, i)) {
                        this.v.E = l.a(iVar, i);
                    }
                    boolean z5 = this.v.k.e(l.a(iVar, i3));
                    i2 = z6;
                    if (this.c) {
                        this.v.g.b();
                        this.c = z6;
                    }
                    this.v.j.R0(iVar);
                    if (i.a.INBOUND != 0) {
                        this.v.k.h();
                    }
                    this.v.n0();
                    return;
                } catch (Throwable th) {
                }
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) th;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th;
            Throwable currentThread4;
            Throwable th2;
            d1 d1Var;
            io.grpc.k1.r.j.a iNFO2;
            d1 str4;
            str = "OkHttpClientTransport";
            Thread.currentThread().setName(str);
            while (/* condition */) {
                try {
                    Object obj = this.v.l;
                } catch (Throwable th) {
                }
            }
        }

        public void s(boolean z, boolean z2, int i, int i2, List<io.grpc.k1.r.j.d> list, io.grpc.k1.r.j.e eVar) {
            String str2;
            d1 d1Var = null;
            boolean z3;
            io.grpc.k1.g.b bVar;
            io.grpc.k1.g.b bVar3;
            int eVar62 = 1;
            this.a.d(i.a.INBOUND, i, list, z2);
            eVar62 = 1;
            eVar62 = 0;
            i = Integer.MAX_VALUE;
            if (this.v.P != Integer.MAX_VALUE) {
                int i5 = a(list);
                if (i5 > this.v.P) {
                    str = "Response %s metadata larger than %d: %d";
                    Object[] arr = new Object[3];
                    String r3 = z2 ? "trailer" : "header";
                    i2 = 2;
                    arr[(z2 ? "trailer" : "header")] = Integer.valueOf(i5);
                    d1Var = d1.l.r(String.format("Response %s metadata larger than %d: %d", arr));
                } else {
                    int i8 = 0;
                }
            }
            Object obj2 = this.v.l;
            synchronized (obj2) {
                try {
                    Object value = this.v.o.get(Integer.valueOf(i));
                    if (value == null) {
                        if (this.v.e0(i)) {
                            this.v.j.p(i, a.INVALID_STREAM);
                        }
                    } else {
                        if (this.v == null) {
                            c.c("OkHttpClientTransport$ClientFrameHandler.headers", value.S().f0());
                            value.S().h0(list, z2);
                        } else {
                            if (a.INVALID_STREAM == null) {
                                this.v.j.p(i, a.CANCEL);
                            }
                            value.S().N(d1Var, false, new t0());
                        }
                    }
                } catch (Throwable th) {
                }
            }
            if (i.a.INBOUND != 0) {
                StringBuilder stringBuilder = new StringBuilder();
                str4 = "Received header for unknown stream: ";
                str3 = str4 + i;
                this.v.h0(a.PROTOCOL_ERROR, str3);
            }
        }

        public void windowUpdate(int i, long j) {
            int i2 = 0;
            boolean z2;
            this.a.k(i.a.INBOUND, i, j);
            if ("Received 0 flow control window increment." == 0 && i == 0) {
                this.v.h0(a.PROTOCOL_ERROR, "Received 0 flow control window increment.");
                return;
            }
            i2 = 0;
            Object obj = this.v.l;
            synchronized (obj) {
                try {
                    this.v.k.g(null, (int)j);
                    return;
                } catch (Throwable th) {
                }
            }
            if (this.a != 0) {
                StringBuilder stringBuilder = new StringBuilder();
                String str2 = "Received window_update for unknown stream: ";
                str = str2 + th;
                this.v.h0(a.PROTOCOL_ERROR, str);
            }
        }

        f(io.grpc.k1.r.j.b bVar, i iVar) {
            this.v = hVar;
            super();
            this.c = true;
            this.b = bVar;
            this.a = iVar;
        }

        public void ackSettings() {
        }

        public void priority(int i, int i2, int i3, boolean z) {
        }
    }
    static {
        h.X = h.Q();
        h.Y = Logger.getLogger(h.class.getName());
        h.Z = new g[0];
    }

    h(InetSocketAddress inetSocketAddress, String str, String str2, io.grpc.a aVar, Executor executor, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, io.grpc.k1.r.b bVar, int i, int i2, c0 c0Var, Runnable runnable, int i3, o2 o2Var, boolean z) {
        SocketFactory socketFactory62;
        final io.grpc.k1.h inetSocketAddress3 = this;
        final Object runnable132 = runnable;
        super();
        inetSocketAddress3.d = new Random();
        inetSocketAddress3.l = new Object();
        inetSocketAddress3.o = new HashMap();
        inetSocketAddress3.E = 0;
        inetSocketAddress3.F = new LinkedList();
        inetSocketAddress3.S = new h.a(this);
        n.p(inetSocketAddress, "address");
        inetSocketAddress3.a = (InetSocketAddress)inetSocketAddress2;
        inetSocketAddress3.b = str;
        inetSocketAddress3.r = i;
        inetSocketAddress3.f = i2;
        n.p(executor, "executor");
        inetSocketAddress3.p = (Executor)executor52;
        inetSocketAddress3.q = new d2(executor);
        inetSocketAddress3.n = 3;
        if (socketFactory == null) {
            socketFactory62 = SocketFactory.getDefault();
        } else {
            socketFactory62 = socketFactory;
        }
        inetSocketAddress3.A = socketFactory62;
        inetSocketAddress3.B = sSLSocketFactory;
        inetSocketAddress3.C = hostnameVerifier;
        n.p(bVar, "connectionSpec");
        inetSocketAddress3.G = (b)bVar92;
        inetSocketAddress3.e = r0.p;
        inetSocketAddress3.c = r0.g("okhttp", str2);
        inetSocketAddress3.U = c0Var;
        n.p(runnable132, "tooManyPingsRunnable");
        inetSocketAddress3.O = (Runnable)runnable132;
        inetSocketAddress3.P = i3;
        n.o(o2Var);
        inetSocketAddress3.R = (o2)o2Var;
        inetSocketAddress3.m = i0.a(h.class, inetSocketAddress.toString());
        a.b bVar2 = a.c();
        bVar2.d(q0.b, aVar);
        inetSocketAddress3.u = bVar2.a();
        inetSocketAddress3.Q = z;
        b0();
    }

    static /* synthetic */ int A(h hVar, int i) {
        hVar.s = i;
        return i;
    }

    static /* synthetic */ int B(h hVar, int i) {
        hVar.s += i;
        return i3;
    }

    static /* synthetic */ int C(h hVar) {
        return hVar.f;
    }

    static /* synthetic */ int D(h hVar) {
        return hVar.P;
    }

    static /* synthetic */ Map E(h hVar) {
        return hVar.o;
    }

    static /* synthetic */ v0 F(h hVar) {
        return hVar.x;
    }

    static /* synthetic */ v0 G(h hVar, v0 v0Var) {
        hVar.x = v0Var;
        return v0Var;
    }

    static /* synthetic */ Runnable H(h hVar) {
        return hVar.O;
    }

    static /* synthetic */ h.f I(h hVar) {
        return hVar.t;
    }

    static /* synthetic */ h.f J(h hVar, h.f fVar) {
        hVar.t = fVar;
        return fVar;
    }

    static /* synthetic */ io.grpc.k1.r.j.b K(h hVar) {
        return hVar.h;
    }

    static /* synthetic */ i L(h hVar) {
        return hVar.i;
    }

    static /* synthetic */ Executor M(h hVar) {
        return hVar.p;
    }

    static /* synthetic */ int N(h hVar, int i) {
        hVar.E = i;
        return i;
    }

    static /* synthetic */ boolean O(h hVar) {
        return hVar.n0();
    }

    static /* synthetic */ InetSocketAddress P(h hVar) {
        return hVar.a;
    }

    private static Map<io.grpc.k1.r.j.a, d1> Q() {
        EnumMap enumMap = new EnumMap(a.class);
        d1 d1Var = d1.m;
        enumMap.put(a.NO_ERROR, d1Var.r("No error: A GRPC status of OK should have been sent"));
        enumMap.put(a.PROTOCOL_ERROR, d1Var.r("Protocol error"));
        enumMap.put(a.INTERNAL_ERROR, d1Var.r("Internal error"));
        enumMap.put(a.FLOW_CONTROL_ERROR, d1Var.r("Flow control error"));
        enumMap.put(a.STREAM_CLOSED, d1Var.r("Stream closed"));
        enumMap.put(a.FRAME_TOO_LARGE, d1Var.r("Frame too large"));
        enumMap.put(a.REFUSED_STREAM, d1.n.r("Refused stream"));
        enumMap.put(a.CANCEL, d1.g.r("Cancelled"));
        enumMap.put(a.COMPRESSION_ERROR, d1Var.r("Compression error"));
        enumMap.put(a.CONNECT_ERROR, d1Var.r("Connect error"));
        enumMap.put(a.ENHANCE_YOUR_CALM, d1.l.r("Enhance your calm"));
        enumMap.put(a.INADEQUATE_SECURITY, d1.j.r("Inadequate security"));
        return Collections.unmodifiableMap(enumMap);
    }

    private f.f.a.e R(InetSocketAddress inetSocketAddress, String str, String str2) {
        c.b bVar = new c.b();
        bVar.k("https");
        bVar.h(inetSocketAddress.getHostName());
        bVar.j(inetSocketAddress.getPort());
        f.f.a.c cVar = bVar.a();
        e.b bVar2 = new e.b();
        bVar2.h(cVar);
        StringBuilder stringBuilder = new StringBuilder();
        String str8 = cVar.c();
        String str9 = ":";
        int i = cVar.j();
        str10 = str8 + str9 + i;
        bVar2.g("Host", str10);
        bVar2.g("User-Agent", this.c);
        if (str != null && str2 != null) {
            str4 = "Proxy-Authorization";
            bVar2.g(str4, a.a(str, str2));
        }
        return bVar2.f();
    }

    private Socket S(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, String str, String str2) throws java.net.SocketException {
        Socket socket;
        int i;
        int i3 = 200;
        str = "\r\n";
        try {
            if (inetSocketAddress2.getAddress() != null) {
                socket = this.A.createSocket(inetSocketAddress2.getAddress(), inetSocketAddress2.getPort());
            } else {
                socket = this.A.createSocket(inetSocketAddress2.getHostName(), inetSocketAddress2.getPort());
            }
            boolean z = true;
            socket.setTcpNoDelay(z);
            d0 d0Var = q.m(socket);
            l.g gVar = q.c(q.i(socket));
            f.f.a.e eVar = R(inetSocketAddress, str, str2);
            f.f.a.c cVar = eVar.b();
            final int i5 = 2;
            Object[] arr = new Object[i5];
            i = 0;
            arr[i] = cVar.c();
            arr[z] = Integer.valueOf(cVar.j());
            gVar.E0(String.format("CONNECT %s:%d HTTP/1.1", arr)).E0(str);
            while ("CONNECT %s:%d HTTP/1.1" < eVar.a().b()) {
                gVar.E0(eVar.a().a(i)).E0(": ").E0(eVar.a().c(i)).E0(str);
                i = i + 1;
            }
            gVar.E0(str);
            gVar.flush();
            com.squareup.okhttp.internal.http.a aVar = a.a(h.i0(d0Var));
            while (!h.i0(d0Var).equals("")) {
            }
            i3 = 200;
            if (aVar.b >= 200 && aVar.b < 300) {
                return socket;
            }
            l.f fVar = new f();
        } catch (java.io.IOException ioException) {
        }
        try {
            socket.shutdownOutput();
            d0Var.read(fVar, 1024L);
        } catch (java.io.IOException ioException) {
        }
        try {
            socket.close();
        } catch (java.io.IOException unused) {
        }
        try {
            Object[] arr2 = new Object[3];
            arr2[i] = Integer.valueOf(aVar.b);
            arr2[z] = aVar.c;
            arr2[i5] = fVar.r1();
            throw d1.n.r(String.format("Response returned from proxy was not successful (expected 2xx, got %d %s). Response body:\n%s", arr2)).c();
        } catch (java.io.IOException ioException) {
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String str5 = "Unable to read body: ";
            ioException = ioException.toString();
            ioException = str5 + ioException;
            str.b1(ioException);
        } catch (java.io.IOException ioException) {
        }
    }

    private Throwable Z() {
        synchronized (obj2) {
            try {
                if (this.v != null) {
                    return this.v.c();
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private void b0() {
        synchronized (obj2) {
            try {
                this.R.g(new h.b(this));
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private boolean c0() {
        boolean z = true;
        int r0 = this.a == null ? 1 : 0;
        return (this.a == null ? 1 : 0);
    }

    private void f0(g gVar) {
        final boolean z2 = false;
        if (this.z && this.F.isEmpty() && this.o.isEmpty() && this.J != null) {
            this.J.o();
        }
        if (gVar.y()) {
            this.S.e(gVar, z2);
        }
    }

    static /* synthetic */ k1.a h(h hVar) {
        return hVar.g;
    }

    private void h0(io.grpc.k1.r.j.a aVar, String str) {
        m0(0, aVar, h.r0(aVar).f(str));
    }

    static /* synthetic */ Object i(h hVar) {
        return hVar.l;
    }

    private static String i0(d0 d0Var) throws EOFException {
        byte b2 = 10;
        l.f fVar = new f();
        long l3 = 1L;
        long read = d0Var.read(fVar, l3);
        long l2 = -1L;
        while (read != l2) {
            l = fVar.size() - 1L;
            b2 = (byte) 10;
            if (fVar.n(l) == (byte) 10) {
                return fVar.m1();
            }
            l3 = 1L;
            read = d0Var.read(fVar, l3);
            l2 = -1L;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "\\n not found: ";
        String str = fVar.Y0().p();
        r0 = str2 + str;
        throw new EOFException(r0);
    }

    static /* synthetic */ SocketFactory j(h hVar) {
        return hVar.A;
    }

    static /* synthetic */ Socket k(h hVar, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, String str, String str2) {
        return hVar.S(inetSocketAddress, inetSocketAddress2, str, str2);
    }

    static /* synthetic */ SSLSocketFactory l(h hVar) {
        return hVar.B;
    }

    private void l0(g gVar) {
        final boolean z3 = true;
        if (!this.z && this.J != null) {
            this.J.n();
        }
        if (gVar.y()) {
            this.S.e(gVar, z3);
        }
    }

    static /* synthetic */ HostnameVerifier m(h hVar) {
        return hVar.C;
    }

    private void m0(int i, io.grpc.k1.r.j.a aVar, d1 d1Var) {
        boolean z;
        byte[] bArr;
        r.a rEFUSED2;
        t0 t0Var;
        synchronized (obj2) {
            try {
                if (this.v == null) {
                    this.v = d1Var;
                    this.g.a(d1Var);
                }
                if (!this.w) {
                    this.w = z2;
                    this.j.h2(i2, aVar, new byte[i2]);
                }
                Iterator item = this.o.entrySet().iterator();
                while (item.hasNext()) {
                    Object item2 = item.next();
                    if ((Integer)item2.getKey().intValue() > i) {
                        item.remove();
                        (g)item2.getValue().S().M(d1Var, r.a.REFUSED, false, new t0());
                        f0((g)item2.getValue());
                    }
                }
                Iterator it = this.F.iterator();
                while (it.hasNext()) {
                    item = it.next();
                    item.S().M(d1Var, r.a.REFUSED, z2, new t0());
                    f0(item);
                }
                this.F.clear();
                p0();
                return;
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }

    static /* synthetic */ io.grpc.k1.r.b n(h hVar) {
        return hVar.G;
    }

    private boolean n0() {
        boolean z = false;
        int i;
        int i2 = 0;
        while (!this.F.isEmpty()) {
        }
        return z;
    }

    static /* synthetic */ io.grpc.a o(h hVar) {
        return hVar.u;
    }

    private void o0(g gVar) {
        boolean z2 = false;
        u0.d dVar;
        u0.d uNARY2;
        int r0 = gVar.Q() == -1 ? 1 : 0;
        n.v((gVar.Q() == -1 ? 1 : 0), "StreamId already assigned");
        (gVar.Q() == -1 ? 1 : 0).put(Integer.valueOf(this.n), gVar);
        l0(gVar);
        (gVar.Q() == -1 ? 1 : 0).d0(this.n);
        if (gVar.P() != u0.d.UNARY) {
            if (gVar.P() != u0.d.SERVER_STREAMING || gVar.T()) {
                this.j.flush();
            }
        }
        int i = 2147483645;
        if (this.n >= 2147483645) {
            int i2 = Integer.MAX_VALUE;
            this.n = i2;
            str = "Stream ids exhausted";
            m0(i2, a.NO_ERROR, d1.n.r(str));
        } else {
            this.n += 2;
        }
    }

    static /* synthetic */ io.grpc.a p(h hVar, io.grpc.a aVar) {
        hVar.u = aVar;
        return aVar;
    }

    private void p0() {
        boolean z2;
        ScheduledExecutorService scheduledExecutorService;
        byte[] bArr;
        if (this.v != null) {
            if (this.o.isEmpty()) {
                if (this.F.isEmpty()) {
                    if (this.y) {
                        return;
                    }
                    boolean z = true;
                    this.y = z;
                    if (this.J != null) {
                        this.J.q();
                        this.I = (ScheduledExecutorService)f2.f(r0.o, this.I);
                    }
                    if (this.x != null) {
                        this.x.f(Z());
                        v0 v0Var = null;
                        this.x = v0Var;
                    }
                    if (!this.w) {
                        this.w = z;
                        int i = 0;
                        this.j.h2(i, a.NO_ERROR, new byte[i]);
                    }
                    this.j.close();
                }
            }
        }
    }

    static /* synthetic */ void q(h hVar, int i, io.grpc.k1.r.j.a aVar, d1 d1Var) {
        hVar.m0(i, aVar, d1Var);
    }

    static /* synthetic */ Socket r(h hVar, Socket socket) {
        hVar.D = socket;
        return socket;
    }

    static d1 r0(io.grpc.k1.r.j.a aVar) {
        Object value;
        if ((d1)h.X.get(aVar) == null) {
            StringBuilder stringBuilder = new StringBuilder();
            str = "Unknown http2 error code: ";
            str2 = str + aVar.httpCode;
            d1 d1Var2 = d1.h.r(str2);
        }
        return value;
    }

    static /* synthetic */ d0.b s(h hVar, d0.b bVar) {
        hVar.T = bVar;
        return bVar;
    }

    static /* synthetic */ c1 t(h hVar) {
        return hVar.J;
    }

    static /* synthetic */ p u(h hVar) {
        return hVar.k;
    }

    static /* synthetic */ d1 v(h hVar) {
        return hVar.v;
    }

    static /* synthetic */ Logger w() {
        return h.Y;
    }

    static /* synthetic */ b x(h hVar) {
        return hVar.j;
    }

    static /* synthetic */ void y(h hVar, io.grpc.k1.r.j.a aVar, String str) {
        hVar.h0(aVar, str);
    }

    static /* synthetic */ int z(h hVar) {
        return hVar.s;
    }

    void T(boolean z, long j, long j2, boolean z2) {
        this.K = z;
        this.L = j;
        this.M = j2;
        this.N = z2;
    }

    void U(int i, d1 d1Var, r.a aVar, boolean z, io.grpc.k1.r.j.a aVar2, t0 t0Var) {
        Integer num;
        io.grpc.k1.b bVar2;
        synchronized (obj2) {
            try {
                Object remove = this.o.remove(Integer.valueOf(i));
                if (remove != null && aVar2 != null) {
                    this.j.p(i, a.CANCEL);
                    if (d1Var != null) {
                        if (t0Var == null) {
                            t0Var = new t0();
                        }
                        remove.S().M(d1Var, aVar, z, t0Var);
                    }
                    if (!n0()) {
                        p0();
                        f0(remove);
                    }
                }
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }

    g[] V() {
        synchronized (obj2) {
            try {
                return (g[])this.o.values().toArray(h.Z);
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    public io.grpc.a W() {
        return this.u;
    }

    String X() {
        URI uri = r0.b(this.b);
        if (uri.getHost() != null) {
            return uri.getHost();
        }
        return this.b;
    }

    int Y() {
        URI uri = r0.b(this.b);
        if (uri.getPort() != -1) {
            return uri.getPort();
        }
        return this.a.getPort();
    }

    public void a(Throwable th) {
        n.p(th, "failureCause");
        m0(0, a.INTERNAL_ERROR, d1.n.q(th));
    }

    g a0(int i) {
        synchronized (obj2) {
            try {
                return (g)this.o.get(Integer.valueOf(i));
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }

    public void c(d1 d1Var) {
        synchronized (obj2) {
            try {
                if (this.v != null) {
                    return;
                }
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }

    public void d(d1 d1Var) {
        io.grpc.k1.g.b bVar;
        boolean z = false;
        t0 t0Var;
        c(d1Var);
        synchronized (obj2) {
            try {
                Iterator it = this.o.entrySet().iterator();
                while (it.hasNext()) {
                    Object item = it.next();
                    it.remove();
                    z = false;
                    (g)item.getValue().S().N(d1Var, z, new t0());
                    f0((g)item.getValue());
                }
                Iterator it2 = this.F.iterator();
                while (it2.hasNext()) {
                    Object item2 = it2.next();
                    z = true;
                    item2.S().N(d1Var, z, new t0());
                    f0(item2);
                }
                this.F.clear();
                p0();
                return;
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }

    boolean d0() {
        boolean z = true;
        int r0 = this.B == null ? 1 : 0;
        return (this.B == null ? 1 : 0);
    }

    public Runnable e(k1.a aVar) {
        str = "listener";
        n.p(aVar, str);
        this.g = aVar;
        if (this.K) {
            this.I = (ScheduledExecutorService)f2.d(r0.o);
            c1 aVar2 = new c1(new c1.c(this), this.I, this.L, l3, this.M, obj3, this.N);
            this.J = aVar2;
            aVar2.p();
        }
        int i = 0;
        if (c0()) {
            synchronized (obj4) {
                try {
                    io.grpc.k1.b bVar = new b(this, this.H, this.i);
                    this.j = bVar;
                    this.k = new p(this, bVar);
                } catch (Throwable th) {
                }
            }
            this.q.execute(new h.c(this));
            return null;
        }
        io.grpc.k1.a aVar3 = a.n(this.q, this);
        io.grpc.k1.r.j.g gVar = new g();
        boolean z3 = true;
        synchronized (obj2) {
            try {
                io.grpc.k1.b bVar2 = new b(this, gVar.b(q.c(aVar3), z3));
                this.j = bVar2;
                this.k = new p(this, bVar2);
            } catch (Throwable th) {
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(z3);
        this.q.execute(new h.d(this, countDownLatch, aVar3, gVar));
        try {
            k0();
        } finally {
            obj.countDown();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
        countDownLatch.countDown();
        this.q.execute(new h.e(this));
        return i;
    }

    boolean e0(int i) {
        boolean z = false;
        int i2;
        synchronized (obj2) {
            try {
                int i4 = 1;
                if (i < this.n) {
                    i2 = i & i4;
                    if ((i & i4) != i4) {
                        int i5 = 0;
                    }
                }
                return z;
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }

    public i0 f() {
        return this.m;
    }

    public void g(s.a aVar, Executor executor) {
        boolean z;
        v0 v0Var;
        int i = 1;
        int i2 = 0;
        synchronized (obj2) {
            try {
                i = 1;
                final boolean z3 = false;
                int r1 = this.j != null ? 1 : z3;
                n.u((this.j != null ? 1 : z3));
                if (this.y) {
                    v0.g(aVar, executor, Z());
                    return;
                }
                if (this.x != null) {
                    i2 = 0;
                    i = z3;
                } else {
                    Object obj3 = this.e.get();
                    obj3.g();
                    v0Var = new v0(this.d.nextLong(), r5, obj3);
                    this.x = v0Var;
                    this.R.b();
                }
                if (i != 0) {
                    i2 = (int)i2;
                    this.j.ping(z3, (int)(i2 >>> 32L), i2);
                }
            } catch (Throwable th) {
            }
        }
        v0Var.a(th, executor);
    }

    public g g0(u0<?, ?> u0Var, t0 t0Var, io.grpc.d dVar, l[] lVarArr) {
        Object obj4;
        Object u0Var4 = this;
        Object t0Var22 = t0Var;
        n.p(u0Var, "method");
        n.p(t0Var22, "headers");
        synchronized (obj) {
            try {
            } catch (Throwable th) {
            }
            try {
                g gVar = new g(u0Var, t0Var, u0Var4.j, this, u0Var4.k, u0Var4.l, u0Var4.r, u0Var4.f, u0Var4.b, u0Var4.c, i2.h(lVarArr, W(), t0Var22), u0Var4.R, dVar, z);
                return gVar;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    void j0(g gVar) {
        this.F.remove(gVar);
        f0(gVar);
    }

    void k0() {
        synchronized (obj2) {
            try {
                this.j.connectionPreface();
                io.grpc.k1.r.j.i iVar = new i();
                l.c(iVar, 7, this.f);
                this.j.Z0(iVar);
                int i6 = 65535;
                if (this.f > i6) {
                    int i3 = 0;
                    this.j.windowUpdate(i3, (long)(i - i6));
                }
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    void q0(g gVar) {
        if (this.v != null) {
            boolean z = true;
            gVar.S().M(this.v, r.a.REFUSED, z, new t0());
        } else {
            if (this.o.size() >= this.E) {
                this.F.add(gVar);
                l0(gVar);
            } else {
                o0(gVar);
            }
        }
    }

    @Override // java.lang.Object
    public String toString() {
        j.b bVar = j.c(this);
        bVar.c("logId", this.m.d());
        bVar.d("address", this.a);
        return bVar.toString();
    }
}
