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

/* loaded from: classes3.dex */
public final class h1 extends s0<io.grpc.j1.h1> {

    private static final Logger H;
    static final long I;
    static final long J;
    private static final io.grpc.j1.p1<? extends Executor> K;
    private static final w L;
    private static final p M;
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private final io.grpc.j1.h1.c F;
    private final io.grpc.j1.h1.b G;
    io.grpc.j1.p1<? extends Executor> a;
    io.grpc.j1.p1<? extends Executor> b;
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
        public abstract int a();
    }

    public interface c {
        public abstract io.grpc.j1.t a();
    }

    private static final class d implements io.grpc.j1.h1.b {
        d(io.grpc.j1.h1.a h1$a) {
            super();
        }

        @Override // io.grpc.j1.h1$b
        public int a() {
            return 443;
        }
    }
    static {
        h1.H = Logger.getLogger(h1.class.getName());
        h1.I = TimeUnit.MINUTES.toMillis(30);
        h1.J = TimeUnit.SECONDS.toMillis(1);
        h1.K = g2.c(r0.n);
        h1.L = w.c();
        h1.M = p.a();
    }

    public h1(String string, f f2, c c3, io.grpc.j1.h1.c h1$c4, io.grpc.j1.h1.b h1$b5) {
        Object obj3;
        String obj4;
        super();
        obj4 = h1.K;
        this.a = obj4;
        this.b = obj4;
        obj4 = new ArrayList();
        this.c = obj4;
        obj4 = x0.d();
        this.d = obj4;
        this.e = obj4.c();
        this.k = "pick_first";
        this.m = h1.L;
        this.n = h1.M;
        this.o = h1.I;
        obj4 = 5;
        this.p = obj4;
        this.q = obj4;
        this.r = 16777216;
        this.s = 1048576;
        obj4 = 1;
        this.t = obj4;
        this.u = d0.g();
        this.x = obj4;
        this.A = obj4;
        this.B = obj4;
        this.C = obj4;
        this.D = false;
        this.E = obj4;
        n.p(string, "target");
        this.f = (String)string;
        this.h = c3;
        n.p(c4, "clientTransportFactoryBuilder");
        this.F = (h1.c)c4;
        if (b5 != null) {
            this.G = b5;
        } else {
            obj3 = new h1.d(0);
            this.G = obj3;
        }
    }

    public h1(String string, io.grpc.j1.h1.c h1$c2, io.grpc.j1.h1.b h1$b3) {
        super(string, 0, 0, c2, b3);
    }

    @Override // io.grpc.s0
    public r0 a() {
        e0.a aVar = new e0.a();
        super(this, this.F.a(), aVar, g2.c(r0.n), r0.p, f(), l2.a);
        i1 i1Var = new i1(g1Var2);
        return i1Var;
    }

    @Override // io.grpc.s0
    int e() {
        return this.G.a();
    }

    List<i> f() {
        Throwable th;
        boolean invoke;
        Object invoke2;
        Object[] str;
        int i;
        Logger fINE;
        Level valueOf;
        Class tYPE;
        int i2;
        int i3;
        ArrayList arrayList = new ArrayList(this.c);
        str = "getClientInterceptor";
        i = 0;
        final int i4 = 0;
        final String str4 = "Unable to apply census stats";
        if (this.A) {
            int i5 = 3;
            Class[] arr = new Class[i5];
            tYPE = Boolean.TYPE;
            arr[i4] = tYPE;
            i2 = 1;
            arr[i2] = tYPE;
            i3 = 2;
            arr[i3] = tYPE;
            fINE = new Object[i5];
            fINE[i4] = Boolean.valueOf(this.B);
            fINE[i2] = Boolean.valueOf(this.C);
            fINE[i3] = Boolean.valueOf(this.D);
            invoke = Class.forName("io.grpc.census.InternalCensusStatsAccessor").getDeclaredMethod(str, arr).invoke(i, fINE);
            if (invoke != null) {
                arrayList.add(i4, invoke);
            }
        }
        if (this.E) {
            i = invoke2;
            if (i != null) {
                arrayList.add(i4, i);
            }
        }
        try {
            return arrayList;
        } catch (java.lang.ClassNotFoundException classNotFound) {
        } catch (java.lang.NoSuchMethodException noSuchMethod1) {
        } catch (java.lang.IllegalAccessException illegalAccess2) {
        } catch (java.lang.reflect.InvocationTargetException invocationTarget3) {
        }
    }
}
