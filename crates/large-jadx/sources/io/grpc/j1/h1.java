package io.grpc.j1;

import com.google.common.base.n;
import io.grpc.a1;
import io.grpc.b;
import io.grpc.c;
import io.grpc.d0;
import io.grpc.f;
import io.grpc.i;
import io.grpc.p;
import io.grpc.r0;
import io.grpc.s0;
import io.grpc.v0.d;
import io.grpc.w;
import io.grpc.x0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: ManagedChannelImplBuilder.java */
/* loaded from: classes3.dex */
public final class h1 extends s0<h1> {

    private static final Logger H;
    static final long I = 0L;
    static final long J = 0L;
    private static final p1<? extends Executor> K;
    private static final w L;
    private static final p M;
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private final h1.c F;
    private final h1.b G;
    p1<? extends Executor> a;
    p1<? extends Executor> b;
    private final List<i> c;
    final x0 d;
    v0.d e;
    final String f;
    final f g;
    final c h;
    String i;
    String j;
    String k;
    boolean l;
    w m;
    p n;
    long o;
    int p;
    int q;
    long r;
    long s;
    boolean t;
    d0 u;
    int v;
    Map<String, ?> w;
    boolean x;
    b y;
    a1 z;

    static class a {
    }

    public interface b {
        int a();
    }

    public interface c {
        t a();
    }

    private static final class d implements h1.b {
        private d() {
            super();
        }

        /* synthetic */ d(h1.a aVar) {
            this();
        }

        public int a() {
            return 443;
        }
    }
    static {
        h1.H = Logger.getLogger(h1.class.getName());
        h1.I = TimeUnit.MINUTES.toMillis(30L);
        h1.J = TimeUnit.SECONDS.toMillis(1L);
        h1.K = g2.c(r0.n);
        h1.L = w.c();
        h1.M = p.a();
    }

    public h1(String str, h1.c cVar, h1.b bVar) {
        this(str, null, null, cVar, bVar);
    }

    @Override // io.grpc.s0
    public r0 a() {
        g1 g1Var = new g1(this, this.F.a(), new e0.a(), g2.c(r0.n), r0.p, f(), l2.a);
        return new i1(g1Var);
    }

    @Override // io.grpc.s0
    int e() {
        return this.G.a();
    }

    @Override // io.grpc.s0
    List<i> f() {
        Throwable th;
        Object invoke;
        Object invoke2;
        Object[] arr;
        Logger fINE2;
        Object[] arr2;
        Class[] arr3;
        Level fINE22;
        Boolean str2;
        final ArrayList arrayList = new ArrayList(this.c);
        str = "getClientInterceptor";
        invoke = null;
        final int i3 = 0;
        if (this.A) {
            try {
                int i4 = 3;
                Class[] arr4 = new Class[i4];
                tYPE2 = Boolean.TYPE;
                arr4[i3] = tYPE2;
                int i = 1;
                arr4[i] = tYPE2;
                int i2 = 2;
                arr4[i2] = tYPE2;
                arr2 = new Object[i4];
                arr2[i3] = Boolean.valueOf(this.B);
                arr2[i] = Boolean.valueOf(this.C);
                arr2[i2] = Boolean.valueOf(this.D);
                invoke2 = Class.forName("io.grpc.census.InternalCensusStatsAccessor").getDeclaredMethod(str, arr4).invoke(invoke, arr2);
            } catch (java.lang.reflect.InvocationTargetException invocationTarget) {
                Logger logger = h1.H;
                fINE2 = Level.FINE;
                logger.log(fINE2, str5, invocationTarget);
            } catch (java.lang.IllegalAccessException illegalAccess1) {
                logger = h1.H;
                fINE2 = Level.FINE;
                logger.log(fINE2, str5, illegalAccess1);
            } catch (java.lang.NoSuchMethodException noSuchMethod2) {
                logger = h1.H;
                fINE2 = Level.FINE;
                logger.log(fINE2, str5, noSuchMethod2);
            } catch (java.lang.ClassNotFoundException classNotFound3) {
                logger = h1.H;
                fINE2 = Level.FINE;
                logger.log(fINE2, str5, classNotFound3);
            }
            if (this.c != null) {
                arrayList.add(i3, invoke2);
            }
        }
        if (this.E) {
            try {
            } catch (java.lang.reflect.InvocationTargetException invocationTarget) {
                logger = h1.H;
                fINE2 = Level.FINE;
                logger.log(fINE2, str5, invocationTarget);
            } catch (java.lang.IllegalAccessException illegalAccess1) {
                logger = h1.H;
                fINE2 = Level.FINE;
                logger.log(fINE2, str5, illegalAccess1);
            } catch (java.lang.NoSuchMethodException noSuchMethod2) {
                logger = h1.H;
                fINE2 = Level.FINE;
                logger.log(fINE2, str5, noSuchMethod2);
            } catch (java.lang.ClassNotFoundException classNotFound3) {
                logger = h1.H;
                fINE2 = Level.FINE;
                logger.log(fINE2, str5, classNotFound3);
            }
            if (invoke != null) {
                arrayList.add(i3, invoke);
            }
        }
        return arrayList;
    }

    public h1(String str, f fVar, c cVar, h1.c cVar2, h1.b bVar) {
        super();
        io.grpc.j1.p1 p1Var = h1.K;
        this.a = p1Var;
        this.b = p1Var;
        this.c = new ArrayList();
        x0 x0Var = x0.d();
        this.d = x0Var;
        this.e = x0Var.c();
        this.k = "pick_first";
        this.m = h1.L;
        this.n = h1.M;
        this.o = h1.I;
        int i4 = 5;
        this.p = i4;
        this.q = i4;
        this.r = 16777216L;
        this.s = 1048576L;
        boolean z = true;
        this.t = z;
        this.u = d0.g();
        this.x = z;
        this.A = z;
        this.B = z;
        this.C = z;
        this.D = false;
        this.E = z;
        str3 = "target";
        n.p(str, str3);
        this.f = str;
        this.h = cVar;
        str2 = "clientTransportFactoryBuilder";
        n.p(cVar2, str2);
        this.F = cVar2;
        if (bVar != null) {
            this.G = bVar;
        } else {
            this.G = new h1.d(null);
        }
    }
}
