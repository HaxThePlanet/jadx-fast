package com.google.android.gms.common.api.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.a.f;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.b;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.j0;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.common.internal.x;
import com.google.android.gms.common.util.i;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import d.e.b;
import f.c.a.d.b.e.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* loaded from: classes2.dex */
public class g implements Handler.Callback {

    public static final Status J;
    private static final Status K;
    private static final Object L;
    private static com.google.android.gms.common.api.internal.g M;
    private final j0 A;
    private final AtomicInteger B;
    private final AtomicInteger C;
    private final Map<com.google.android.gms.common.api.internal.c<?>, com.google.android.gms.common.api.internal.i0<?>> D;
    private com.google.android.gms.common.api.internal.y E = null;
    private final Set<com.google.android.gms.common.api.internal.c<?>> F;
    private final Set<com.google.android.gms.common.api.internal.c<?>> G;
    @NotOnlyInitialized
    private final Handler H;
    private volatile boolean I;
    private long a = 5000;
    private long b = 120000;
    private long c = 10000;
    private boolean v = false;
    private v w;
    private x x;
    private final Context y;
    private final e z;
    static {
        final int i = 4;
        Status status = new Status(i, "Sign-out occurred while this API call was in progress.");
        g.J = status;
        Status status2 = new Status(i, "The user must be signed in to make this API call.");
        g.K = status2;
        Object object = new Object();
        g.L = object;
    }

    private g(Context context, Looper looper2, e e3) {
        super();
        int i = 5000;
        int i2 = 120000;
        int i3 = 10000;
        int i4 = 0;
        final int i6 = 1;
        AtomicInteger atomicInteger = new AtomicInteger(i6);
        this.B = atomicInteger;
        AtomicInteger atomicInteger2 = new AtomicInteger(i4);
        this.C = atomicInteger2;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(5, 1061158912, i6);
        this.D = concurrentHashMap;
        int i5 = 0;
        b bVar = new b();
        this.F = bVar;
        b bVar2 = new b();
        this.G = bVar2;
        this.I = i6;
        this.y = context;
        e eVar = new e(looper2, this);
        this.H = eVar;
        this.z = e3;
        j0 obj7 = new j0(e3);
        this.A = obj7;
        if (i.a(context)) {
            this.I = i4;
        }
        eVar.sendMessage(eVar.obtainMessage(6));
    }

    static Handler D(com.google.android.gms.common.api.internal.g g) {
        return g.H;
    }

    static Context E(com.google.android.gms.common.api.internal.g g) {
        return g.y;
    }

    static long F(com.google.android.gms.common.api.internal.g g) {
        return g.a;
    }

    static long G(com.google.android.gms.common.api.internal.g g) {
        return g.b;
    }

    static j0 H(com.google.android.gms.common.api.internal.g g) {
        return g.A;
    }

    static Object I() {
        return g.L;
    }

    static com.google.android.gms.common.api.internal.y J(com.google.android.gms.common.api.internal.g g) {
        return g.E;
    }

    static Set K(com.google.android.gms.common.api.internal.g g) {
        return g.F;
    }

    public static void a() {
        Object gVar;
        Message message;
        final Object obj = g.L;
        gVar = g.M;
        synchronized (obj) {
            gVar.C.incrementAndGet();
            gVar = gVar.H;
            gVar.sendMessageAtFrontOfQueue(gVar.obtainMessage(10));
        }
    }

    static boolean b(com.google.android.gms.common.api.internal.g g, boolean z2) {
        final int obj1 = 1;
        g.v = obj1;
        return obj1;
    }

    static Status c() {
        return g.K;
    }

    static boolean d(com.google.android.gms.common.api.internal.g g) {
        return g.I;
    }

    static e e(com.google.android.gms.common.api.internal.g g) {
        return g.z;
    }

    static long f(com.google.android.gms.common.api.internal.g g) {
        return g.c;
    }

    static Status g(com.google.android.gms.common.api.internal.c c, b b2) {
        return g.k(c, b2);
    }

    static Map h(com.google.android.gms.common.api.internal.g g) {
        return g.D;
    }

    private final com.google.android.gms.common.api.internal.i0<?> i(c<?> c) {
        Object i0Var;
        Object obj3;
        final com.google.android.gms.common.api.internal.c apiKey = c.getApiKey();
        if ((i0)this.D.get(apiKey) == null) {
            i0Var = new i0(this, c);
            this.D.put(apiKey, i0Var);
        }
        if (i0Var.F()) {
            this.G.add(apiKey);
        }
        i0Var.C();
        return i0Var;
    }

    private final <T> void j(k<T> k, int i2, c c3) {
        j obj1;
        int obj2;
        Object obj3;
        obj2 = q0.a(this, i2, c3.getApiKey());
        if (i2 != 0 && obj2 != null) {
            obj2 = q0.a(this, i2, c3.getApiKey());
            if (obj2 != null) {
                obj3 = this.H;
                obj3.getClass();
                k.a().addOnCompleteListener(c0.a(obj3), obj2);
            }
        }
    }

    private static Status k(com.google.android.gms.common.api.internal.c<?> c, b b2) {
        String obj5 = c.b();
        final String valueOf = String.valueOf(b2);
        StringBuilder stringBuilder = new StringBuilder(i += length2);
        stringBuilder.append("API: ");
        stringBuilder.append(obj5);
        stringBuilder.append(" is not available on this device. Connection failed with: ");
        stringBuilder.append(valueOf);
        Status status = new Status(b2, stringBuilder.toString());
        return status;
    }

    private final void l() {
        v vVar;
        int i;
        vVar = this.w;
        if (vVar != null) {
            if (vVar.j2() <= 0) {
                if (x()) {
                    m().a(vVar);
                }
            } else {
            }
            this.w = 0;
        }
    }

    private final x m() {
        x xVar;
        if (this.x == null) {
            this.x = w.a(this.y);
        }
        return this.x;
    }

    public static com.google.android.gms.common.api.internal.g n(Context context) {
        Object looper;
        com.google.android.gms.common.api.internal.g gVar;
        e eVar;
        Object obj4;
        final Object obj = g.L;
        synchronized (obj) {
            HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
            handlerThread.start();
            gVar = new g(context.getApplicationContext(), handlerThread.getLooper(), e.o());
            g.M = gVar;
            return g.M;
        }
    }

    @Override // android.os.Handler$Callback
    final boolean A(b b, int i2) {
        return this.z.t(this.y, b, i2);
    }

    @Override // android.os.Handler$Callback
    public final void B(b b, int i2) {
        boolean z;
        int i;
        int i3;
        Object obj4;
        if (!A(b, i2)) {
            z = this.H;
            z.sendMessage(z.obtainMessage(5, i2, 0, b));
        }
    }

    @Override // android.os.Handler$Callback
    final void C(o o, int i2, long l3, int i4) {
        final Handler handler = this.H;
        super(o, i2, l3, obj5, obj13);
        handler.sendMessage(handler.obtainMessage(18, r0Var2));
    }

    @Override // android.os.Handler$Callback
    public final boolean handleMessage(Message message) {
        List size;
        Object vVar;
        Object valueOf;
        int f;
        int message2;
        int cREATOR;
        int iterator;
        boolean endpointPackageName;
        String stringBuilder;
        int i;
        int i2;
        Object obj10;
        valueOf = message.what;
        message2 = 13;
        stringBuilder = "GoogleApiManager";
        final int i10 = 17;
        i = 0;
        i2 = 0;
        final int i11 = 1;
        switch (valueOf) {
            case 1:
                iterator = 10000;
                this.c = iterator;
                valueOf = 12;
                this.H.removeMessages(valueOf);
                obj10 = this.D.keySet().iterator();
                iterator = this.H;
                iterator.sendMessageDelayed(iterator.obtainMessage(valueOf, (c)obj10.next()), this.c);
                break;
            case 2:
                obj10 = message.obj;
                valueOf = (l1)obj10.a().iterator();
                iterator = valueOf.next();
                endpointPackageName = this.D.get((c)iterator);
                valueOf = new b(message2);
                obj10.b(iterator, valueOf, i);
                obj10.b(iterator, b.w, endpointPackageName.v().getEndpointPackageName());
                stringBuilder = endpointPackageName.y();
                obj10.b(iterator, stringBuilder, i);
                endpointPackageName.D(obj10);
                endpointPackageName.C();
                break;
            case 3:
                obj10 = this.D.values().iterator();
                valueOf = obj10.next();
                (i0)valueOf.x();
                valueOf.C();
                break;
            case 4:
                obj10 = message.obj;
                valueOf = i(obj10.c);
                obj10.a.a(g.J);
                valueOf.u();
                valueOf.t(obj10.a);
                break;
            case 5:
                int arg1 = message.arg1;
                obj10 = message.obj;
                iterator = this.D.values().iterator();
                endpointPackageName = iterator.next();
                i = endpointPackageName;
                String str3 = this.z.e(obj10.j2());
                obj10 = obj10.k2();
                stringBuilder = new StringBuilder(i7 += endpointPackageName);
                stringBuilder.append("Error resolution was canceled by the user, original error message: ");
                stringBuilder.append(str3);
                stringBuilder.append(": ");
                stringBuilder.append(obj10);
                valueOf = new Status(i10, stringBuilder.toString());
                i0.M(i, valueOf);
                i0.M(i, g.k(i0.N(i), obj10));
                obj10 = new StringBuilder(76);
                obj10.append("Could not find API instance ");
                obj10.append(arg1);
                obj10.append(" while trying to fail enqueued calls.");
                valueOf = new Exception();
                Log.wtf(stringBuilder, obj10.toString(), valueOf);
                break;
            case 6:
                d.c((Application)this.y.getApplicationContext());
                valueOf = new d0(this);
                d.b().a(valueOf);
                this.c = 300000;
                break;
            case 7:
                i((c)message.obj);
                break;
            case 8:
                (i0)this.D.get(message.obj).z();
                break;
            case 9:
                obj10 = this.G.iterator();
                valueOf = this.D.remove((c)obj10.next());
                (i0)valueOf.u();
                this.G.clear();
                break;
            case 10:
                (i0)this.D.get(message.obj).A();
                break;
            case 11:
                (i0)this.D.get(message.obj).B();
                break;
            case 12:
                obj10 = message.obj;
                com.google.android.gms.common.api.internal.c cVar2 = (z)obj10.a();
                obj10.b().c(Boolean.FALSE);
                obj10.b().c(Boolean.valueOf(i0.J((i0)this.D.get(cVar2), i2)));
                break;
            case 13:
                obj10 = message.obj;
                i0.K((i0)this.D.get(j0.a(obj10)), obj10);
                break;
            case 14:
                obj10 = message.obj;
                i0.L((i0)this.D.get(j0.a(obj10)), obj10);
                break;
            case 15:
                l();
                break;
            case 16:
                obj10 = message.obj;
                iterator = new o[i11];
                iterator[i2] = obj10.a;
                valueOf = new v(obj10.b, Arrays.asList(iterator));
                m().a(valueOf);
                vVar = this.w;
                size = vVar.k2();
                this.w.l2(obj10.a);
                this.H.removeMessages(i10);
                l();
                ArrayList arrayList = new ArrayList();
                arrayList.add(obj10.a);
                v vVar3 = new v(obj10.b, arrayList);
                this.w = vVar3;
                valueOf = this.H;
                valueOf.sendMessageDelayed(valueOf.obtainMessage(i10), obj10.c);
                break;
            case 17:
                this.v = i2;
                break;
            default:
                obj10 = new StringBuilder(31);
                obj10.append("Unknown message id: ");
                obj10.append(valueOf);
                Log.w(stringBuilder, obj10.toString());
                return i2;
        }
        return i11;
    }

    @Override // android.os.Handler$Callback
    public final int o() {
        return this.B.getAndIncrement();
    }

    public final void p(c<?> c) {
        final Handler handler = this.H;
        handler.sendMessage(handler.obtainMessage(7, c));
    }

    @Override // android.os.Handler$Callback
    public final void q(com.google.android.gms.common.api.internal.y y) {
        Object yVar;
        final Object obj = g.L;
        synchronized (obj) {
            this.E = y;
            this.F.clear();
            this.F.addAll(y.j());
        }
    }

    @Override // android.os.Handler$Callback
    final void r(com.google.android.gms.common.api.internal.y y) {
        Object obj3;
        final Object obj = g.L;
        synchronized (obj) {
            this.E = 0;
            this.F.clear();
        }
    }

    final com.google.android.gms.common.api.internal.i0 s(com.google.android.gms.common.api.internal.c<?> c) {
        return (i0)this.D.get(c);
    }

    @Override // android.os.Handler$Callback
    public final void t() {
        final Handler handler = this.H;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final j<Boolean> u(c<?> c) {
        z zVar = new z(c.getApiKey());
        Handler obj3 = this.H;
        obj3.sendMessage(obj3.obtainMessage(14, zVar));
        return zVar.b().a();
    }

    public final <O extends com.google.android.gms.common.api.a.d> void v(c<O> c, int i2, com.google.android.gms.common.api.internal.e<? extends i, a.b> e3) {
        h1 h1Var = new h1(i2, e3);
        final Handler obj4 = this.H;
        v0 obj5 = new v0(h1Var, this.C.get(), c);
        obj4.sendMessage(obj4.obtainMessage(4, obj5));
    }

    public final <O extends com.google.android.gms.common.api.a.d, ResultT> void w(c<O> c, int i2, com.google.android.gms.common.api.internal.t<a.b, ResultT> t3, k<ResultT> k4, com.google.android.gms.common.api.internal.r r5) {
        j(k4, t3.zab(), c);
        i1 i1Var = new i1(i2, t3, k4, r5);
        final Handler obj3 = this.H;
        v0 obj4 = new v0(i1Var, this.C.get(), c);
        obj3.sendMessage(obj3.obtainMessage(4, obj4));
    }

    @Override // android.os.Handler$Callback
    final boolean x() {
        t tVar;
        final int i3 = 0;
        if (this.v) {
            return i3;
        }
        tVar = s.b().a();
        if (tVar != null && tVar.l2()) {
            if (tVar.l2()) {
            }
            return i3;
        }
        int i = this.A.b(this.y, 203390000);
        if (i != -1 && i == 0) {
            if (i == 0) {
            }
            return i3;
        }
        return 1;
    }

    public final <O extends com.google.android.gms.common.api.a.d> j<Void> y(c<O> c, com.google.android.gms.common.api.internal.n<a.b, ?> n2, com.google.android.gms.common.api.internal.v<a.b, ?> v3, Runnable runnable4) {
        k obj1 = new k();
        n2.f();
        throw 0;
    }

    public final <O extends com.google.android.gms.common.api.a.d> j<Boolean> z(c<O> c, com.google.android.gms.common.api.internal.j.a j$a2, int i3) {
        k kVar = new k();
        j(kVar, i3, c);
        j1 obj6 = new j1(a2, kVar);
        final Handler obj5 = this.H;
        v0 v0Var = new v0(obj6, this.C.get(), c);
        obj5.sendMessage(obj5.obtainMessage(13, v0Var));
        return kVar.a();
    }
}
