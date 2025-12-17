package io.grpc.k1;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.n;
import com.google.common.base.q;
import com.google.common.base.s;
import com.google.common.util.concurrent.f;
import com.squareup.okhttp.internal.http.a;
import f.f.a.a;
import f.f.a.b;
import f.f.a.c;
import f.f.a.c.b;
import f.f.a.e;
import f.f.a.e.b;
import i.a.c;
import io.grpc.StatusException;
import io.grpc.a;
import io.grpc.a.b;
import io.grpc.b0;
import io.grpc.b1;
import io.grpc.c0;
import io.grpc.d;
import io.grpc.d0.b;
import io.grpc.d0.c;
import io.grpc.d1;
import io.grpc.d1.b;
import io.grpc.i0;
import io.grpc.j1.a;
import io.grpc.j1.a.c;
import io.grpc.j1.c1;
import io.grpc.j1.c1.c;
import io.grpc.j1.d2;
import io.grpc.j1.f2;
import io.grpc.j1.i2;
import io.grpc.j1.k1.a;
import io.grpc.j1.o2;
import io.grpc.j1.o2.c;
import io.grpc.j1.q;
import io.grpc.j1.q0;
import io.grpc.j1.r.a;
import io.grpc.j1.r0;
import io.grpc.j1.r0.i;
import io.grpc.j1.s.a;
import io.grpc.j1.v;
import io.grpc.j1.v0;
import io.grpc.j1.w0;
import io.grpc.k1.r.b;
import io.grpc.k1.r.j.a;
import io.grpc.k1.r.j.b;
import io.grpc.k1.r.j.b.a;
import io.grpc.k1.r.j.c;
import io.grpc.k1.r.j.d;
import io.grpc.k1.r.j.e;
import io.grpc.k1.r.j.g;
import io.grpc.k1.r.j.i;
import io.grpc.k1.r.j.j;
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
import l.f;
import l.g;
import l.h;
import l.i;
import l.q;

/* loaded from: classes3.dex */
class h implements v, io.grpc.k1.b.a {

    private static final Map<a, d1> X;
    private static final Logger Y;
    private static final io.grpc.k1.g[] Z;
    private final SocketFactory A;
    private SSLSocketFactory B;
    private HostnameVerifier C;
    private Socket D;
    private int E;
    private final Deque<io.grpc.k1.g> F;
    private final b G;
    private c H;
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
    private final w0<io.grpc.k1.g> S;
    private d0.b T;
    final c0 U;
    Runnable V;
    f<Void> W;
    private final InetSocketAddress a;
    private final String b;
    private final String c;
    private final Random d;
    private final s<q> e;
    private final int f;
    private k1.a g;
    private b h;
    private io.grpc.k1.i i;
    private io.grpc.k1.b j;
    private io.grpc.k1.p k;
    private final Object l;
    private final i0 m;
    private int n;
    private final Map<Integer, io.grpc.k1.g> o;
    private final Executor p;
    private final d2 q;
    private final int r;
    private int s;
    private io.grpc.k1.h.f t;
    private a u;
    private d1 v;
    private boolean w;
    private v0 x;
    private boolean y;
    private boolean z;

    class c implements Runnable {

        final io.grpc.k1.h a;
        c(io.grpc.k1.h h) {
            this.a = h;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = hVar.V;
            if (runnable == null) {
            } else {
                runnable.run();
            }
            io.grpc.k1.h hVar2 = this.a;
            h.f fVar2 = new h.f(hVar2, h.K(hVar2), h.L(this.a));
            h.J(hVar2, fVar2);
            h.M(this.a).execute(h.I(this.a));
            Object obj = h.i(this.a);
            h.N(this.a, Integer.MAX_VALUE);
            h.O(this.a);
            int i = 0;
            hVar5.W.B(i);
            throw i;
            synchronized (obj) {
                hVar2 = this.a;
                fVar2 = new h.f(hVar2, h.K(hVar2), h.L(this.a));
                h.J(hVar2, fVar2);
                h.M(this.a).execute(h.I(this.a));
                obj = h.i(this.a);
                h.N(this.a, Integer.MAX_VALUE);
                h.O(this.a);
                i = 0;
                hVar5.W.B(i);
                throw i;
            }
        }
    }

    class d implements Runnable {

        final CountDownLatch a;
        final io.grpc.k1.a b;
        final j c;
        final io.grpc.k1.h v;
        d(io.grpc.k1.h h, CountDownLatch countDownLatch2, io.grpc.k1.a a3, j j4) {
            this.v = h;
            this.a = countDownLatch2;
            this.b = a3;
            this.c = j4;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownLatch countDownLatch;
            io.grpc.k1.h hVar2;
            Throwable th;
            int session;
            Object bVar2;
            io.grpc.k1.h hVar;
            Socket socket2;
            j fVar;
            java.net.InetAddress address;
            Object fVar2;
            a aVar;
            int port;
            String str;
            Object socket;
            String str2;
            b1 pRIVACY_AND_INTEGRITY;
            int i;
            b bVar;
            try {
                this.a.await();
                Thread thread = Thread.currentThread();
                thread.interrupt();
                h.d.a aVar2 = new h.d.a(this);
                h hVar3 = q.d(aVar2);
                session = 0;
                int i2 = 1;
                io.grpc.k1.h hVar11 = this.v;
                c0 c0Var = hVar11.U;
                socket2 = h.j(hVar11).createSocket(h.P(this.v).getAddress(), h.P(this.v).getPort());
            } catch (io.grpc.StatusException status) {
            } catch (Exception e1) {
            } catch (Throwable th2) {
            }
            if (!socket3 instanceof InetSocketAddress) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unsupported SocketAddress implementation ");
            stringBuilder.append(hVar17.U.b().getClass());
            throw d1.m.r(stringBuilder.toString()).c();
        }
    }

    class e implements Runnable {

        final io.grpc.k1.h a;
        e(io.grpc.k1.h h) {
            this.a = h;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            h.M(this.a).execute(h.I(this.a));
            Object obj = h.i(this.a);
            h.N(this.a, Integer.MAX_VALUE);
            h.O(this.a);
            return;
            synchronized (obj) {
                h.M(this.a).execute(h.I(this.a));
                obj = h.i(this.a);
                h.N(this.a, Integer.MAX_VALUE);
                h.O(this.a);
            }
        }
    }

    class a extends w0<io.grpc.k1.g> {

        final io.grpc.k1.h b;
        a(io.grpc.k1.h h) {
            this.b = h;
            super();
        }

        @Override // io.grpc.j1.w0
        protected void b() {
            h.h(this.b).d(true);
        }

        @Override // io.grpc.j1.w0
        protected void c() {
            h.h(this.b).d(false);
        }
    }

    class b implements o2.c {
        b(io.grpc.k1.h h) {
            super();
        }
    }

    class f implements b.a, Runnable {

        private final io.grpc.k1.i a;
        b b;
        boolean c;
        final io.grpc.k1.h v;
        f(io.grpc.k1.h h, b b2) {
            i iVar = new i(Level.FINE, h.class);
            super(h, b2, iVar);
        }

        f(io.grpc.k1.h h, b b2, io.grpc.k1.i i3) {
            this.v = h;
            super();
            this.c = true;
            this.b = b2;
            this.a = i3;
        }

        private int a(List<d> list) {
            int i2;
            int i3;
            long l;
            int i;
            i2 = 0;
            i3 = 0;
            int size = list.size();
            while (i3 < size) {
                Object obj = list.get(i3);
                i2 += l;
                i3++;
                size = list.size();
            }
            return (int)l2;
        }

        @Override // io.grpc.k1.r.j.b$a
        public void ackSettings() {
        }

        @Override // io.grpc.k1.r.j.b$a
        public void data(boolean z, int i2, h h3, int i4) {
            Object obj;
            Object iNVALID_STREAM;
            boolean obj7;
            f obj8;
            Object obj9;
            final int i = i2;
            this.a.b(i.a.INBOUND, i, h3.h(), i4, z);
            io.grpc.k1.g gVar = this.v.a0(i2);
            if (gVar == null && this.v.e0(i2)) {
                if (this.v.e0(i2)) {
                    obj7 = h.i(this.v);
                    h.x(this.v).p(i2, a.INVALID_STREAM);
                    h3.skip((long)i4);
                    synchronized (obj7) {
                        obj7 = h.i(this.v);
                        h.x(this.v).p(i2, a.INVALID_STREAM);
                        h3.skip((long)i4);
                    }
                    h.B(this.v, i4);
                    if (Float.compare(obj7, obj8) >= 0) {
                        obj7 = h.i(this.v);
                        obj = 0;
                        h.x(this.v).windowUpdate(obj, (long)obj9);
                        h.A(this.v, obj);
                        synchronized (obj7) {
                            obj7 = h.i(this.v);
                            obj = 0;
                            h.x(this.v).windowUpdate(obj, (long)obj9);
                            h.A(this.v, obj);
                        }
                    }
                }
                StringBuilder obj10 = new StringBuilder();
                obj10.append("Received data for unknown stream: ");
                obj10.append(i2);
                h.y(this.v, a.PROTOCOL_ERROR, obj10.toString());
            }
            long l = (long)i4;
            h3.V1(l);
            obj8 = new f();
            obj8.write(h3.h(), l);
            c.c("OkHttpClientTransport$ClientFrameHandler.data", gVar.S().f0());
            obj9 = h.i(this.v);
            gVar.S().g0(obj8, z);
            synchronized (obj9) {
                l = (long)i4;
                h3.V1(l);
                obj8 = new f();
                obj8.write(h3.h(), l);
                c.c("OkHttpClientTransport$ClientFrameHandler.data", gVar.S().f0());
                obj9 = h.i(this.v);
                gVar.S().g0(obj8, z);
            }
        }

        @Override // io.grpc.k1.r.j.b$a
        public void p(int i, a a2) {
            int i3;
            d1.b bVar;
            d1.b dEADLINE_EXCEEDED;
            Object rEFUSED_STREAM;
            Object valueOf;
            int i5;
            r.a aVar;
            int i2;
            int i4;
            Enum obj11;
            this.a.h(i.a.INBOUND, i, a2);
            final d1 d1Var2 = h.r0(a2).f("Rst Stream");
            if (d1Var2.n() != d1.b.CANCELLED) {
                if (d1Var2.n() == d1.b.DEADLINE_EXCEEDED) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
            } else {
            }
            Object obj = h.i(this.v);
            rEFUSED_STREAM = h.E(this.v).get(Integer.valueOf(i));
            synchronized (obj) {
                c.c("OkHttpClientTransport$ClientFrameHandler.rstStream", (g)rEFUSED_STREAM.S().f0());
                obj11 = a2 == a.REFUSED_STREAM ? r.a.REFUSED : r.a.PROCESSED;
                this.v.U(i, d1Var2, obj11, i3, 0, 0);
            }
        }

        @Override // io.grpc.k1.r.j.b$a
        public void ping(boolean z, int i2, int i3) {
            Object format;
            io.grpc.k1.i.a iNBOUND;
            long str;
            Object[] arr;
            int i;
            Long valueOf;
            Object obj10;
            Object obj11;
            int obj12;
            i4 |= i7;
            this.a.e(i.a.INBOUND, i5);
            int i8 = 1;
            if (!z) {
                obj10 = h.i(this.v);
                h.x(this.v).ping(i8, i2, i3);
                synchronized (obj10) {
                    obj10 = h.i(this.v);
                    h.x(this.v).ping(i8, i2, i3);
                }
            } else {
                obj10 = h.i(this.v);
                synchronized (obj10) {
                    if (Long.compare(iNBOUND, i5) == 0) {
                        h.G(this.v, 0);
                        obj12 = obj11;
                    } else {
                        arr = new Object[2];
                        arr[i8] = Long.valueOf(i5);
                        h.w().log(Level.WARNING, String.format("Received unexpected ping ack. Expecting %d, got %d", arr));
                    }
                    if (obj12 != null) {
                    }
                }
                obj12.d();
            }
        }

        @Override // io.grpc.k1.r.j.b$a
        public void priority(int i, int i2, int i3, boolean z4) {
        }

        public void pushPromise(int i, int i2, List<d> list3) {
            this.a.g(i.a.INBOUND, i, i2, list3);
            Object obj4 = h.i(this.v);
            h.x(this.v).p(i, a.PROTOCOL_ERROR);
            return;
            synchronized (obj4) {
                this.a.g(i.a.INBOUND, i, i2, list3);
                obj4 = h.i(this.v);
                h.x(this.v).p(i, a.PROTOCOL_ERROR);
            }
        }

        @Override // io.grpc.k1.r.j.b$a
        public void q(int i, a a2, i i3) {
            a eNHANCE_YOUR_CALM;
            Object iNBOUND;
            Level wARNING;
            String format;
            String str;
            d1 obj7;
            Object obj8;
            this.a.c(i.a.INBOUND, i, a2, i3);
            String str3 = i3.E();
            Object[] arr = new Object[2];
            h.w().log(Level.WARNING, String.format("%s: Received GOAWAY with ENHANCE_YOUR_CALM. Debug data: %s", this, str3));
            if (a2 == a.ENHANCE_YOUR_CALM && "too_many_pings".equals(str3)) {
                str3 = i3.E();
                arr = new Object[2];
                h.w().log(Level.WARNING, String.format("%s: Received GOAWAY with ENHANCE_YOUR_CALM. Debug data: %s", this, str3));
                if ("too_many_pings".equals(str3)) {
                    h.H(this.v).run();
                }
            }
            if (i3.A() > 0) {
                obj7 = r0.i.statusForCode((long)obj7).f("Received Goaway").f(i3.E());
            }
            h.q(this.v, i, 0, obj7);
        }

        @Override // io.grpc.k1.r.j.b$a
        public void r(boolean z, i i2) {
            int i;
            boolean z3;
            boolean z4;
            io.grpc.k1.p z5;
            boolean z2;
            Object obj5;
            this.a.i(i.a.INBOUND, i2);
            Object obj4 = h.i(this.v);
            i = 4;
            synchronized (obj4) {
                h.N(this.v, l.a(i2, i));
                int i3 = 7;
                final int i5 = 0;
                if (l.b(i2, i3)) {
                    z3 = h.u(this.v).e(l.a(i2, i3));
                } else {
                    z3 = i5;
                }
                if (this.c) {
                    h.h(this.v).b();
                    this.c = i5;
                }
                h.x(this.v).R0(i2);
                if (z3) {
                    h.u(this.v).h();
                }
                h.O(this.v);
            }
        }

        @Override // io.grpc.k1.r.j.b$a
        public void run() {
            Throwable th2;
            Thread currentThread2;
            b bVar;
            Throwable currentThread;
            String str2;
            Object obj;
            io.grpc.k1.h hVar;
            Throwable th;
            d1 d1Var;
            a iNFO;
            a iNTERNAL_ERROR;
            d1 str;
            String str3;
            Thread.currentThread().setName("OkHttpClientTransport");
            while (this.b.d0(this)) {
                if (h.t(this.v) != null) {
                }
                h.t(this.v).m();
            }
            obj = h.i(this.v);
            synchronized (obj) {
                obj = h.i(this.v);
            }
            d1Var = d1.n.r("End of stream or IOException");
            h.q(this.v, null, a.INTERNAL_ERROR, d1Var);
            this.b.close();
            h.h(this.v).c();
            Thread.currentThread().setName(Thread.currentThread().getName());
        }

        public void s(boolean z, boolean z2, int i3, int i4, List<d> list5, e e6) {
            int i2;
            String str;
            Object[] arr;
            String str2;
            int i;
            int obj5;
            boolean obj6;
            int obj7;
            i.a.d obj8;
            Object obj9;
            this.a.d(i.a.INBOUND, i3, list5, z2);
            final int obj10 = 0;
            obj5 = a(list5);
            if (h.D(this.v) != Integer.MAX_VALUE && obj5 > h.D(this.v)) {
                obj5 = a(list5);
                if (obj5 > h.D(this.v)) {
                    arr = new Object[3];
                    str2 = z2 ? "trailer" : "header";
                    arr[obj10] = str2;
                    arr[1] = Integer.valueOf(h.D(this.v));
                    arr[2] = Integer.valueOf(obj5);
                    obj5 = d1.l.r(String.format("Response %s metadata larger than %d: %d", arr));
                } else {
                    obj5 = 0;
                }
            } else {
            }
            Object obj = h.i(this.v);
            Object obj2 = h.E(this.v).get(Integer.valueOf(i3));
            synchronized (obj) {
                if (this.v.e0(i3)) {
                    h.x(this.v).p(i3, a.INVALID_STREAM);
                    obj8 = obj10;
                }
                if (obj8 != null) {
                }
            }
            obj8 = new StringBuilder();
            obj8.append("Received header for unknown stream: ");
            obj8.append(i3);
            h.y(this.v, a.PROTOCOL_ERROR, obj8.toString());
        }

        @Override // io.grpc.k1.r.j.b$a
        public void windowUpdate(int i, long l2) {
            int stringBuilder;
            io.grpc.k1.h cmp;
            Object str;
            int iNBOUND;
            d1 d1Var;
            Object valueOf;
            r.a pROCESSED;
            int i2;
            a pROTOCOL_ERROR;
            int i3;
            int obj8;
            boolean obj9;
            a obj10;
            this.a.k(i.a.INBOUND, i, l2);
            if (Long.compare(l2, i4) == 0) {
                obj9 = "Received 0 flow control window increment.";
                if (i == 0) {
                    h.y(this.v, a.PROTOCOL_ERROR, obj9);
                } else {
                    this.v.U(i, d1.m.r(obj9), r.a.PROCESSED, false, a.PROTOCOL_ERROR, 0);
                }
            }
            stringBuilder = 0;
            str = h.i(this.v);
            synchronized (str) {
                h.u(this.v).g(0, (int)l2);
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Received window_update for unknown stream: ");
            stringBuilder.append(i);
            h.y(this.v, a.PROTOCOL_ERROR, stringBuilder.toString());
        }
    }
    static {
        h.X = h.Q();
        h.Y = Logger.getLogger(h.class.getName());
        h.Z = new g[0];
    }

    h(InetSocketAddress inetSocketAddress, String string2, String string3, a a4, Executor executor5, SocketFactory socketFactory6, SSLSocketFactory sSLSocketFactory7, HostnameVerifier hostnameVerifier8, b b9, int i10, int i11, c0 c012, Runnable runnable13, int i14, o2 o215, boolean z16) {
        SocketFactory default;
        final Object obj = this;
        final Object obj9 = runnable13;
        super();
        Random random = new Random();
        obj.d = random;
        Object object = new Object();
        obj.l = object;
        HashMap hashMap = new HashMap();
        obj.o = hashMap;
        obj.E = 0;
        LinkedList linkedList = new LinkedList();
        obj.F = linkedList;
        h.a aVar2 = new h.a(this);
        obj.S = aVar2;
        n.p(inetSocketAddress, "address");
        obj.a = (InetSocketAddress)inetSocketAddress;
        obj.b = string2;
        obj.r = i10;
        obj.f = i11;
        n.p(executor5, "executor");
        obj.p = (Executor)executor5;
        d2 d2Var = new d2(executor5);
        obj.q = d2Var;
        obj.n = 3;
        if (socketFactory6 == null) {
            default = SocketFactory.getDefault();
        } else {
            default = socketFactory6;
        }
        obj.A = default;
        obj.B = sSLSocketFactory7;
        obj.C = hostnameVerifier8;
        n.p(b9, "connectionSpec");
        obj.G = (b)b9;
        obj.e = r0.p;
        String str5 = string3;
        obj.c = r0.g("okhttp", string3);
        obj.U = c012;
        n.p(obj9, "tooManyPingsRunnable");
        obj.O = (Runnable)obj9;
        obj.P = i14;
        n.o(o215);
        obj.R = (o2)o215;
        obj.m = i0.a(h.class, inetSocketAddress.toString());
        a.b bVar = a.c();
        Object obj8 = a4;
        bVar.d(q0.b, a4);
        obj.u = bVar.a();
        obj.Q = z16;
        b0();
    }

    static int A(io.grpc.k1.h h, int i2) {
        h.s = i2;
        return i2;
    }

    static int B(io.grpc.k1.h h, int i2) {
        i += i2;
        h.s = i3;
        return i3;
    }

    static int C(io.grpc.k1.h h) {
        return h.f;
    }

    static int D(io.grpc.k1.h h) {
        return h.P;
    }

    static Map E(io.grpc.k1.h h) {
        return h.o;
    }

    static v0 F(io.grpc.k1.h h) {
        return h.x;
    }

    static v0 G(io.grpc.k1.h h, v0 v02) {
        h.x = v02;
        return v02;
    }

    static Runnable H(io.grpc.k1.h h) {
        return h.O;
    }

    static io.grpc.k1.h.f I(io.grpc.k1.h h) {
        return h.t;
    }

    static io.grpc.k1.h.f J(io.grpc.k1.h h, io.grpc.k1.h.f h$f2) {
        h.t = f2;
        return f2;
    }

    static b K(io.grpc.k1.h h) {
        return h.h;
    }

    static io.grpc.k1.i L(io.grpc.k1.h h) {
        return h.i;
    }

    static Executor M(io.grpc.k1.h h) {
        return h.p;
    }

    static int N(io.grpc.k1.h h, int i2) {
        h.E = i2;
        return i2;
    }

    static boolean O(io.grpc.k1.h h) {
        return h.n0();
    }

    static InetSocketAddress P(io.grpc.k1.h h) {
        return h.a;
    }

    private static Map<a, d1> Q() {
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

    private e R(InetSocketAddress inetSocketAddress, String string2, String string3) {
        String obj4;
        String obj5;
        c.b bVar = new c.b();
        bVar.k("https");
        bVar.h(inetSocketAddress.getHostName());
        bVar.j(inetSocketAddress.getPort());
        obj4 = bVar.a();
        e.b bVar2 = new e.b();
        bVar2.h(obj4);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(obj4.c());
        stringBuilder.append(":");
        stringBuilder.append(obj4.j());
        bVar2.g("Host", stringBuilder.toString());
        bVar2.g("User-Agent", this.c);
        if (string2 != null && string3 != null) {
            if (string3 != null) {
                bVar2.g("Proxy-Authorization", a.a(string2, string3));
            }
        }
        return bVar2.f();
    }

    private Socket S(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, String string3, String string4) {
        String str2;
        SocketFactory factory;
        Object hostName;
        d0 d0Var;
        Object[] arr;
        String str;
        Socket obj10;
        int obj11;
        int obj12;
        str2 = "\r\n";
        if (inetSocketAddress2.getAddress() != null) {
            obj10 = this.A.createSocket(inetSocketAddress2.getAddress(), inetSocketAddress2.getPort());
        } else {
            try {
                obj10 = this.A.createSocket(inetSocketAddress2.getHostName(), inetSocketAddress2.getPort());
                int i2 = 1;
                obj10.setTcpNoDelay(i2);
                d0Var = q.m(obj10);
                g gVar = q.c(q.i(obj10));
                e obj9 = R(inetSocketAddress, string3, string4);
                obj11 = obj9.b();
                final int i3 = 2;
                arr = new Object[i3];
                final int i5 = 0;
                arr[i5] = obj11.c();
                arr[i2] = Integer.valueOf(obj11.j());
                gVar.E0(String.format("CONNECT %s:%d HTTP/1.1", arr)).E0(str2);
                obj12 = i5;
                while (obj12 < obj9.a().b()) {
                    gVar.E0(obj9.a().a(obj12)).E0(": ").E0(obj9.a().c(obj12)).E0(str2);
                    obj12++;
                }
                gVar.E0(obj9.a().a(obj12)).E0(": ").E0(obj9.a().c(obj12)).E0(str2);
                obj12++;
                gVar.E0(str2);
                gVar.flush();
                obj9 = a.a(h.i0(d0Var));
                while (h.i0(d0Var).equals("") == 0) {
                }
                obj11 = obj9.b;
                if (obj11 >= 200 && obj11 < 300) {
                }
                if (obj11 < 300) {
                }
                return obj10;
                obj11 = new f();
                obj10.shutdownOutput();
                d0Var.read(obj11, 1024);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to read body: ");
                string4 = string4.toString();
                stringBuilder.append(string4);
                string4 = stringBuilder.toString();
                string3.b1(string4);
                obj10.close();
                obj12 = new Object[3];
                obj12[i5] = Integer.valueOf(obj9.b);
                obj12[i2] = obj9.c;
                obj12[i3] = obj11.r1();
                throw d1.n.r(String.format("Response returned from proxy was not successful (expected 2xx, got %d %s). Response body:\n%s", obj12)).c();
                inetSocketAddress2 = d1.n;
                string3 = "Failed trying to connect with proxy";
                inetSocketAddress2 = inetSocketAddress2.r(string3);
                inetSocketAddress = inetSocketAddress2.q(inetSocketAddress);
                inetSocketAddress = inetSocketAddress.c();
                throw inetSocketAddress;
            } catch (java.io.IOException ioException) {
            }
        }
    }

    private Throwable Z() {
        final Object obj = this.l;
        d1 d1Var = this.v;
        synchronized (obj) {
            return d1Var.c();
        }
    }

    private void b0() {
        final Object obj = this.l;
        h.b bVar = new h.b(this);
        this.R.g(bVar);
        return;
        synchronized (obj) {
            obj = this.l;
            bVar = new h.b(this);
            this.R.g(bVar);
        }
    }

    private boolean c0() {
        int i;
        i = this.a == null ? 1 : 0;
        return i;
    }

    private void f0(io.grpc.k1.g g) {
        boolean empty;
        boolean z;
        final int i = 0;
        this.z = i;
        empty = this.J;
        if (this.z && this.F.isEmpty() && this.o.isEmpty() && empty != null) {
            if (this.F.isEmpty()) {
                if (this.o.isEmpty()) {
                    this.z = i;
                    empty = this.J;
                    if (empty != null) {
                        empty.o();
                    }
                }
            }
        }
        if (g.y()) {
            this.S.e(g, i);
        }
    }

    static k1.a h(io.grpc.k1.h h) {
        return h.g;
    }

    private void h0(a a, String string2) {
        m0(0, a, h.r0(a).f(string2));
    }

    static Object i(io.grpc.k1.h h) {
        return h.l;
    }

    private static String i0(d0 d0) {
        byte b;
        int i3;
        int i2;
        int i;
        f fVar = new f();
        int i4 = 1;
        while (Long.compare(read, i) != 0) {
            i4 = 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\\n not found: ");
        stringBuilder.append(fVar.Y0().p());
        EOFException obj7 = new EOFException(stringBuilder.toString());
        throw obj7;
    }

    static SocketFactory j(io.grpc.k1.h h) {
        return h.A;
    }

    static Socket k(io.grpc.k1.h h, InetSocketAddress inetSocketAddress2, InetSocketAddress inetSocketAddress3, String string4, String string5) {
        return h.S(inetSocketAddress2, inetSocketAddress3, string4, string5);
    }

    static SSLSocketFactory l(io.grpc.k1.h h) {
        return h.B;
    }

    private void l0(io.grpc.k1.g g) {
        boolean z;
        boolean z2;
        final int i = 1;
        this.z = i;
        z = this.J;
        if (!this.z && z != null) {
            this.z = i;
            z = this.J;
            if (z != null) {
                z.n();
            }
        }
        if (g.y()) {
            this.S.e(g, i);
        }
    }

    static HostnameVerifier m(io.grpc.k1.h h) {
        return h.C;
    }

    private void m0(int i, a a2, d1 d13) {
        Object d1Var;
        int i2;
        boolean value;
        boolean rEFUSED;
        byte[] intValue;
        r.a rEFUSED2;
        t0 t0Var;
        Iterator obj9;
        final Object obj = this.l;
        synchronized (obj) {
            this.v = d13;
            this.g.a(d13);
            int i3 = 1;
            i2 = 0;
            if (a2 != null && !this.w) {
                try {
                    if (!this.w) {
                    }
                    this.w = i3;
                    this.j.h2(i2, a2, new byte[i2]);
                    obj9 = this.o.entrySet().iterator();
                    while (obj9.hasNext()) {
                        value = obj9.next();
                        if ((Integer)(Map.Entry)value.getKey().intValue() > i) {
                        }
                        obj9.remove();
                        t0Var = new t0();
                        (g)value.getValue().S().M(d13, r.a.REFUSED, i2, t0Var);
                        f0((g)value.getValue());
                    }
                    value = obj9.next();
                    if ((Integer)(Map.Entry)value.getKey().intValue() > i) {
                    }
                    obj9.remove();
                    t0Var = new t0();
                    (g)value.getValue().S().M(d13, r.a.REFUSED, i2, t0Var);
                    f0((g)value.getValue());
                    Iterator obj8 = this.F.iterator();
                    for (g obj9 : obj8) {
                        intValue = new t0();
                        obj9.S().M(d13, r.a.REFUSED, i3, intValue);
                        f0(obj9);
                    }
                    obj9 = obj8.next();
                    intValue = new t0();
                    (g)obj9.S().M(d13, r.a.REFUSED, i3, intValue);
                    f0(obj9);
                    this.F.clear();
                    p0();
                    throw i;
                }
            }
        }
    }

    static b n(io.grpc.k1.h h) {
        return h.G;
    }

    private boolean n0() {
        int i;
        int empty;
        int i2;
        i = 0;
        while (!this.F.isEmpty()) {
            if (this.o.size() < this.E) {
            }
            o0((g)this.F.poll());
            i = 1;
        }
        return i;
    }

    static a o(io.grpc.k1.h h) {
        return h.u;
    }

    private void o0(io.grpc.k1.g g) {
        int i;
        u0.d dVar;
        int nO_ERROR;
        u0.d sERVER_STREAMING;
        String str;
        io.grpc.k1.b obj4;
        i = g.Q() == -1 ? 1 : 0;
        n.v(i, "StreamId already assigned");
        this.o.put(Integer.valueOf(this.n), g);
        l0(g);
        g.S().d0(this.n);
        if (g.P() != u0.d.UNARY) {
            if (g.P() == u0.d.SERVER_STREAMING) {
                if (g.T()) {
                    this.j.flush();
                }
            } else {
            }
        } else {
        }
        obj4 = this.n;
        if (obj4 >= 2147483645) {
            obj4 = Integer.MAX_VALUE;
            this.n = obj4;
            m0(obj4, a.NO_ERROR, d1.n.r("Stream ids exhausted"));
        } else {
            this.n = obj4 += 2;
        }
    }

    static a p(io.grpc.k1.h h, a a2) {
        h.u = a2;
        return a2;
    }

    private void p0() {
        d1 empty;
        int i;
        boolean nO_ERROR;
        Object c1Var;
        v0 v0Var;
        ScheduledExecutorService service;
        byte[] bArr;
        if (this.v != null && this.o.isEmpty()) {
            if (this.o.isEmpty()) {
                if (!this.F.isEmpty()) {
                } else {
                    if (this.y) {
                    }
                    i = 1;
                    this.y = i;
                    c1Var = this.J;
                    if (c1Var != null) {
                        c1Var.q();
                        this.I = (ScheduledExecutorService)f2.f(r0.o, this.I);
                    }
                    v0Var = this.x;
                    if (v0Var != null) {
                        v0Var.f(Z());
                        this.x = 0;
                    }
                    if (!this.w) {
                        this.w = i;
                        service = 0;
                        this.j.h2(service, a.NO_ERROR, new byte[service]);
                    }
                    this.j.close();
                }
            }
        }
    }

    static void q(io.grpc.k1.h h, int i2, a a3, d1 d14) {
        h.m0(i2, a3, d14);
    }

    static Socket r(io.grpc.k1.h h, Socket socket2) {
        h.D = socket2;
        return socket2;
    }

    static d1 r0(a a) {
        Object obj;
        StringBuilder stringBuilder;
        String str;
        Object obj3;
        if ((d1)h.X.get(a) != null) {
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown http2 error code: ");
            stringBuilder.append(a.httpCode);
            obj = d1.h.r(stringBuilder.toString());
        }
        return obj;
    }

    static d0.b s(io.grpc.k1.h h, d0.b d0$b2) {
        h.T = b2;
        return b2;
    }

    static c1 t(io.grpc.k1.h h) {
        return h.J;
    }

    static io.grpc.k1.p u(io.grpc.k1.h h) {
        return h.k;
    }

    static d1 v(io.grpc.k1.h h) {
        return h.v;
    }

    static Logger w() {
        return h.Y;
    }

    static io.grpc.k1.b x(io.grpc.k1.h h) {
        return h.j;
    }

    static void y(io.grpc.k1.h h, a a2, String string3) {
        h.h0(a2, string3);
    }

    static int z(io.grpc.k1.h h) {
        return h.s;
    }

    @Override // io.grpc.j1.v
    void T(boolean z, long l2, long l3, boolean z4) {
        this.K = z;
        this.L = l2;
        this.M = z4;
        this.N = obj6;
    }

    @Override // io.grpc.j1.v
    void U(int i, d1 d12, r.a r$a3, boolean z4, a a5, t0 t06) {
        Object valueOf;
        int obj4;
        io.grpc.k1.b obj8;
        t0 obj9;
        final Object obj = this.l;
        Object remove = this.o.remove(Integer.valueOf(i));
        synchronized (obj) {
            if (a5 != null) {
                this.j.p(i, a.CANCEL);
            }
            try {
                if (d12 != null) {
                }
                if (t06 != null) {
                } else {
                }
                obj9 = new t0();
                (g)remove.S().M(d12, a3, z4, obj9);
                if (!n0()) {
                }
                p0();
                f0(remove);
                throw i;
            }
        }
    }

    @Override // io.grpc.j1.v
    io.grpc.k1.g[] V() {
        final Object obj = this.l;
        return (g[])this.o.values().toArray(h.Z);
        synchronized (obj) {
            obj = this.l;
            return (g[])this.o.values().toArray(h.Z);
        }
    }

    @Override // io.grpc.j1.v
    public a W() {
        return this.u;
    }

    @Override // io.grpc.j1.v
    String X() {
        URI uri = r0.b(this.b);
        if (uri.getHost() != null) {
            return uri.getHost();
        }
        return this.b;
    }

    @Override // io.grpc.j1.v
    int Y() {
        URI uri = r0.b(this.b);
        if (uri.getPort() != -1) {
            return uri.getPort();
        }
        return this.a.getPort();
    }

    @Override // io.grpc.j1.v
    public void a(Throwable throwable) {
        n.p(throwable, "failureCause");
        m0(0, a.INTERNAL_ERROR, d1.n.q(throwable));
    }

    @Override // io.grpc.j1.v
    io.grpc.k1.g a0(int i) {
        final Object obj = this.l;
        return (g)this.o.get(Integer.valueOf(i));
        synchronized (obj) {
            obj = this.l;
            return (g)this.o.get(Integer.valueOf(i));
        }
    }

    @Override // io.grpc.j1.v
    public q b(u0 u0, t0 t02, d d3, l[] l4Arr4) {
        return g0(u0, t02, d3, l4Arr4);
    }

    @Override // io.grpc.j1.v
    public void c(d1 d1) {
        final Object obj = this.l;
        synchronized (obj) {
        }
    }

    @Override // io.grpc.j1.v
    public void d(d1 d1) {
        Object value;
        boolean next;
        io.grpc.k1.g.b bVar;
        int i;
        t0 t0Var;
        c(d1);
        final Object obj = this.l;
        Iterator iterator = this.o.entrySet().iterator();
        synchronized (obj) {
            for (Map.Entry next3 : iterator) {
                iterator.remove();
                t0Var = new t0();
                (g)next3.getValue().S().N(d1, false, t0Var);
                f0((g)next3.getValue());
            }
            Iterator iterator2 = this.F.iterator();
            for (g next : iterator2) {
                t0Var = new t0();
                next.S().N(d1, true, t0Var);
                f0(next);
            }
            try {
                this.F.clear();
                p0();
                throw d1;
            }
        }
    }

    @Override // io.grpc.j1.v
    boolean d0() {
        int i;
        i = this.B == null ? 1 : 0;
        return i;
    }

    @Override // io.grpc.j1.v
    public Runnable e(k1.a k1$a) {
        Object str;
        c1.c cVar;
        ScheduledExecutorService service;
        long l;
        long l2;
        boolean z;
        boolean obj9;
        n.p(a, "listener");
        this.g = (k1.a)a;
        if (this.K) {
            this.I = (ScheduledExecutorService)f2.d(r0.o);
            cVar = new c1.c(this);
            super(cVar, this.I, this.L, obj4, this.M, obj6, this.N);
            this.J = obj9;
            obj9.p();
        }
        int i = 0;
        if (c0()) {
            obj9 = this.l;
            b bVar = new b(this, this.H, this.i);
            this.j = bVar;
            p pVar2 = new p(this, bVar);
            this.k = pVar2;
            h.c cVar2 = new h.c(this);
            this.q.execute(cVar2);
            return i;
            synchronized (obj9) {
                obj9 = this.l;
                bVar = new b(this, this.H, this.i);
                this.j = bVar;
                pVar2 = new p(this, bVar);
                this.k = pVar2;
                cVar2 = new h.c(this);
                this.q.execute(cVar2);
                return i;
            }
        }
        obj9 = a.n(this.q, this);
        g gVar = new g();
        int i2 = 1;
        Object obj = this.l;
        b bVar2 = new b(this, gVar.b(q.c(obj9), i2));
        this.j = bVar2;
        p pVar = new p(this, bVar2);
        this.k = pVar;
        CountDownLatch countDownLatch = new CountDownLatch(i2);
        h.d dVar = new h.d(this, countDownLatch, obj9, gVar);
        this.q.execute(dVar);
        k0();
        countDownLatch.countDown();
        h.e eVar = new h.e(this);
        this.q.execute(eVar);
        return i;
        synchronized (obj) {
            obj9 = a.n(this.q, this);
            gVar = new g();
            i2 = 1;
            obj = this.l;
            bVar2 = new b(this, gVar.b(q.c(obj9), i2));
            this.j = bVar2;
            pVar = new p(this, bVar2);
            this.k = pVar;
            countDownLatch = new CountDownLatch(i2);
            dVar = new h.d(this, countDownLatch, obj9, gVar);
            this.q.execute(dVar);
            k0();
            countDownLatch.countDown();
            eVar = new h.e(this);
            this.q.execute(eVar);
            return i;
        }
    }

    @Override // io.grpc.j1.v
    boolean e0(int i) {
        int i2;
        int obj4;
        final Object obj = this.l;
        i2 = 1;
        synchronized (obj) {
            if (i &= i2 == i2) {
            } else {
                try {
                    i2 = 0;
                    return i2;
                    throw i;
                }
            }
        }
    }

    @Override // io.grpc.j1.v
    public i0 f() {
        return this.m;
    }

    @Override // io.grpc.j1.v
    public void g(s.a s$a, Executor executor2) {
        int i2;
        v0 v0Var2;
        int i;
        long nextLong;
        v0 v0Var;
        final Object obj = this.l;
        final int i3 = 0;
        synchronized (obj) {
            i2 = i;
            try {
                n.u(i2);
                if (this.y) {
                }
                v0.g(a, executor2, Z());
                if (this.x != null) {
                } else {
                }
                nextLong = 0;
                i = i3;
                Object obj2 = this.e.get();
                (q)obj2.g();
                v0Var = new v0(this.d.nextLong(), obj5, obj2);
                this.x = v0Var;
                this.R.b();
                v0Var2 = v0Var;
                if (i != 0) {
                }
                this.j.ping(i3, (int)i5, (int)nextLong);
                v0Var2.a(a, executor2);
                throw a;
            }
        }
    }

    public io.grpc.k1.g g0(u0<?, ?> u0, t0 t02, d d3, l[] l4Arr4) {
        Object obj6;
        Object obj5 = this;
        Object obj = t02;
        n.p(u0, "method");
        n.p(obj, "headers");
        Object obj4 = obj5.l;
        super(u0, t02, obj5.j, this, obj5.k, obj5.l, obj5.r, obj5.f, obj5.b, obj5.c, i2.h(l4Arr4, W(), obj), obj5.R, d3, obj5.Q);
        return gVar2;
        synchronized (obj4) {
            obj5 = this;
            obj = t02;
            n.p(u0, "method");
            n.p(obj, "headers");
            obj4 = obj5.l;
            super(u0, t02, obj5.j, this, obj5.k, obj5.l, obj5.r, obj5.f, obj5.b, obj5.c, i2.h(l4Arr4, W(), obj), obj5.R, d3, obj5.Q);
            return gVar2;
        }
    }

    @Override // io.grpc.j1.v
    void j0(io.grpc.k1.g g) {
        this.F.remove(g);
        f0(g);
    }

    @Override // io.grpc.j1.v
    void k0() {
        int i2;
        int i3;
        int i;
        final Object obj = this.l;
        this.j.connectionPreface();
        i iVar = new i();
        l.c(iVar, 7, this.f);
        this.j.Z0(iVar);
        i2 = this.f;
        int i6 = 65535;
        synchronized (obj) {
            this.j.windowUpdate(0, (long)i4);
        }
    }

    @Override // io.grpc.j1.v
    void q0(io.grpc.k1.g g) {
        d1 size;
        r.a rEFUSED;
        int i;
        t0 t0Var;
        Object obj5;
        if (this.v != null) {
            t0Var = new t0();
            g.S().M(this.v, r.a.REFUSED, true, t0Var);
        } else {
            if (this.o.size() >= this.E) {
                this.F.add(g);
                l0(g);
            } else {
                o0(g);
            }
        }
    }

    @Override // io.grpc.j1.v
    public String toString() {
        j.b bVar = j.c(this);
        bVar.c("logId", this.m.d());
        bVar.d("address", this.a);
        return bVar.toString();
    }
}
