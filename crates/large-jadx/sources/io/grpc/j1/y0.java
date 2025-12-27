package io.grpc.j1;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.n;
import com.google.common.base.s;
import io.grpc.a;
import io.grpc.c0;
import io.grpc.d;
import io.grpc.d0;
import io.grpc.d1;
import io.grpc.f1;
import io.grpc.f1.c;
import io.grpc.g;
import io.grpc.g.a;
import io.grpc.h0;
import io.grpc.i0;
import io.grpc.l;
import io.grpc.m0;
import io.grpc.r;
import io.grpc.t0;
import io.grpc.u0;
import io.grpc.y;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: InternalSubchannel.java */
/* loaded from: classes3.dex */
final class y0 implements h0<Object>, n2 {

    private final i0 a;
    private final String b;
    private final String c;
    private final k.a d;
    private final y0.j e;
    private final t f;
    private final ScheduledExecutorService g;
    private final d0 h;
    private final m i;
    private final g j;
    private final f1 k;
    private final y0.k l;
    private volatile List<y> m;
    private k n;
    private final com.google.common.base.q o;
    private f1.c p;
    private f1.c q;
    private k1 r;
    private final Collection<v> s;
    private final w0<v> t;
    private v u;
    private volatile k1 v;
    private volatile r w;
    private d1 x;

    class b implements Runnable {

        final /* synthetic */ y0 a;
        b() {
            this.a = y0Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.p = 0;
            this.a.j.a(g.a.INFO, "CONNECTING after backoff");
            this.a.N(q.CONNECTING);
            this.a.T();
        }
    }

    class c implements Runnable {

        final /* synthetic */ y0 a;
        c() {
            this.a = y0Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.w.c() == q.IDLE) {
                str = "CONNECTING as requested";
                this.a.j.a(g.a.INFO, str);
                this.a.N(q.CONNECTING);
                this.a.T();
            }
        }
    }

    class d implements Runnable {

        final /* synthetic */ List a;
        final /* synthetic */ y0 b;
        d(List list) {
            this.b = y0Var;
            this.a = list;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            io.grpc.j1.k1 k1Var;
            io.grpc.j1.y0.k kVar;
            io.grpc.q rEADY2;
            io.grpc.q cONNECTING2;
            Object obj;
            this.b.l.h(this.a);
            this.b.m = this.a;
            rEADY2 = q.READY;
            k1Var = null;
            if (this.b.w.c() != q.READY) {
                if (this.b.w.c() == q.CONNECTING) {
                    if (!this.b.l.g(this.b.l.a())) {
                        if (this.b.w.c() == q.READY) {
                            k1Var = this.b.v;
                            this.b.v = k1Var;
                            this.b.l.f();
                            this.b.N(q.IDLE);
                        } else {
                            this.b.u.c(d1.n.r("InternalSubchannel closed pending transport due to address change"));
                            this.b.u = k1Var;
                            this.b.l.f();
                            this.b.T();
                        }
                    }
                }
            }
            if (this.b.u != null) {
                if (this.b.q != null) {
                    this.b.r.c(d1.n.r("InternalSubchannel closed transport early due to address change"));
                    this.b.q.a();
                    this.b.q = k1Var;
                    this.b.r = k1Var;
                }
                this.b.r = k1Var;
                this.b.q = this.b.k.c(new y0.d.a(this), 5L, TimeUnit.SECONDS, this.b.g);
            }
        }
    }

    class e implements Runnable {

        final /* synthetic */ d1 a;
        final /* synthetic */ y0 b;
        e(d1 d1Var) {
            this.b = y0Var;
            this.a = d1Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            f1.c cVar;
            io.grpc.q sHUTDOWN2 = q.SHUTDOWN;
            if (this.b.w.c() == q.SHUTDOWN) {
                return;
            }
            this.b.x = this.a;
            io.grpc.j1.k1 k1Var = this.b.v;
            io.grpc.j1.v vVar = this.b.u;
            final io.grpc.j1.k1 k1Var3 = null;
            this.b.v = k1Var3;
            this.b.u = k1Var3;
            this.b.N(q.SHUTDOWN);
            this.b.l.f();
            if (this.b.s.isEmpty()) {
                this.b.P();
            }
            this.b.K();
            if (this.b.q != null) {
                this.b.q.a();
                this.b.r.c(this.a);
                this.b.q = k1Var3;
                this.b.r = k1Var3;
            }
            if (k1Var != null) {
                k1Var.c(this.a);
            }
            if (vVar != null) {
                vVar.c(this.a);
            }
        }
    }

    class f implements Runnable {

        final /* synthetic */ y0 a;
        f() {
            this.a = y0Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.j.a(g.a.INFO, "Terminated");
            this.a.e.d(this.a);
        }
    }

    class g implements Runnable {

        final /* synthetic */ v a;
        final /* synthetic */ boolean b;
        final /* synthetic */ y0 c;
        g(v vVar, boolean z) {
            this.c = y0Var;
            this.a = vVar;
            this.b = z;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.t.e(this.a, this.b);
        }
    }

    class h implements Runnable {

        final /* synthetic */ d1 a;
        final /* synthetic */ y0 b;
        h(d1 d1Var) {
            this.b = y0Var;
            this.a = d1Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = new ArrayList(this.b.s).iterator();
            while (it.hasNext()) {
                (k1)it.next().d(this.a);
            }
        }
    }

    static abstract class j {
        j() {
            super();
        }

        abstract void a(y0 y0Var);

        abstract void b(y0 y0Var);

        abstract void c(y0 y0Var, r rVar);

        abstract void d(y0 y0Var);
    }

    static final class k {

        private List<y> a;
        private int b;
        private int c;
        public k(List<y> list) {
            super();
            this.a = list;
        }

        public SocketAddress a() {
            return (SocketAddress)(y)this.a.get(this.b).a().get(this.c);
        }

        public a b() {
            return (y)this.a.get(this.b).b();
        }

        public void c() {
            this.c++;
            if (this.c >= (y)this.a.get(this.b).a().size()) {
                this.b++;
                int size = 0;
                this.c = size;
            }
        }

        public boolean d() {
            boolean z = false;
            int r0 = this.b == 0 && this.c == 0 ? 1 : 0;
            return (this.b == 0 && this.c == 0 ? 1 : 0);
        }

        public boolean e() {
            boolean z = true;
            int r0 = this.b < this.a.size() ? 1 : 0;
            return (this.b < this.a.size() ? 1 : 0);
        }

        public void f() {
            final int i = 0;
            this.b = i;
            this.c = i;
        }

        public boolean g(SocketAddress socketAddress) {
            int i;
            i = 0;
            while (i < this.a.size()) {
                int indexOf = (y)this.a.get(i).a().indexOf(socketAddress);
                int i2 = -1;
                if (indexOf != -1) {
                    this.b = i;
                    this.c = indexOf;
                    return true;
                }
            }
            return false;
        }

        public void h(List<y> list) {
            this.a = list;
            f();
        }
    }

    class a extends w0<v> {

        final /* synthetic */ y0 b;
        a() {
            this.b = y0Var;
            super();
        }

        @Override // io.grpc.j1.w0
        protected void b() {
            this.b.e.a(this.b);
        }

        @Override // io.grpc.j1.w0
        protected void c() {
            this.b.e.b(this.b);
        }
    }

    private class l implements k1.a {

        final v a;
        boolean b = false;
        final /* synthetic */ y0 c;
        l(v vVar, SocketAddress socketAddress) {
            this.c = y0Var;
            super();
            this.a = vVar;
        }

        public void a(d1 d1Var) {
            Object[] arr = new Object[2];
            int i3 = 1;
            arr[i3] = this.c.R(d1Var);
            this.c.j.b(g.a.INFO, "{0} SHUTDOWN with {1}", arr);
            this.b = true;
            this.c.k.execute(new y0.l.b(this, d1Var));
        }

        public void b() {
            this.c.j.a(g.a.INFO, "READY");
            this.c.k.execute(new y0.l.a(this));
        }

        public void c() {
            n.v(this.b, "transportShutdown() must be called before transportTerminated().");
            Object[] arr = new Object[1];
            final int i2 = 0;
            arr[i2] = this.a.f();
            this.c.j.b(g.a.INFO, "{0} Terminated", arr);
            this.c.h.i(this.a);
            this.c.Q(this.a, i2);
            this.c.k.execute(new y0.l.c(this));
        }

        public void d(boolean z) {
            this.c.Q(this.a, z);
        }
    }

    static final class m extends g {

        i0 a;
        m() {
            super();
        }

        @Override // io.grpc.g
        public void a(g.a aVar, String str) {
            n.d(this.a, aVar, str);
        }

        @Override // io.grpc.g
        public void b(g.a aVar, String str, Object... objectArr) {
            n.e(this.a, aVar, str, objectArr);
        }
    }

    static final class i extends k0 {

        private final v a;
        private final m b;
        /* synthetic */ i(v vVar, m mVar, y0.a aVar) {
            this(vVar, mVar);
        }

        static /* synthetic */ m h(y0.i iVar) {
            return iVar.b;
        }

        @Override // io.grpc.j1.k0
        protected v a() {
            return this.a;
        }

        @Override // io.grpc.j1.k0
        public q b(u0<?, ?> u0Var, t0 t0Var, d dVar, l[] lVarArr) {
            return new y0.i.a(this, super.b(u0Var, t0Var, dVar, lVarArr));
        }

        private i(v vVar, m mVar) {
            super();
            this.a = vVar;
            this.b = mVar;
        }
    }
    y0(List<y> list, String str, String str2, k.a aVar, t tVar, ScheduledExecutorService scheduledExecutorService, s<com.google.common.base.q> sVar, f1 f1Var, y0.j jVar, d0 d0Var, m mVar, o oVar, i0 i0Var, g gVar) {
        final io.grpc.j1.y0 list2 = this;
        final Object i0Var132 = i0Var;
        final Object gVar142 = gVar;
        super();
        list2.s = new ArrayList();
        list2.t = new y0.a(this);
        list2.w = r.a(q.IDLE);
        n.p(list, "addressGroups");
        n.e(!list.isEmpty(), "addressGroups is empty");
        y0.L(list, "addressGroups contains null entry");
        List unmodifiable = Collections.unmodifiableList(new ArrayList(list));
        list2.m = unmodifiable;
        list2.l = new y0.k(unmodifiable);
        list2.b = str;
        list2.c = str2;
        list2.d = aVar;
        list2.f = tVar;
        list2.g = scheduledExecutorService;
        list2.o = (q)sVar.get();
        list2.k = f1Var;
        list2.e = jVar;
        list2.h = d0Var;
        list2.i = mVar;
        n.p(oVar, "channelTracer");
        n.p(i0Var132, "logId");
        list2.a = i0Var132;
        n.p(gVar142, "channelLogger");
        list2.j = gVar142;
    }

    static /* synthetic */ void A(y0 y0Var, v vVar, boolean z) {
        y0Var.Q(vVar, z);
    }

    static /* synthetic */ String B(y0 y0Var, d1 d1Var) {
        return y0Var.R(d1Var);
    }

    static /* synthetic */ void C(y0 y0Var, d1 d1Var) {
        y0Var.S(d1Var);
    }

    static /* synthetic */ d0 D(y0 y0Var) {
        return y0Var.h;
    }

    static /* synthetic */ void E(y0 y0Var, io.grpc.q qVar) {
        y0Var.N(qVar);
    }

    static /* synthetic */ void F(y0 y0Var) {
        y0Var.T();
    }

    static /* synthetic */ f1.c G(y0 y0Var, f1.c cVar) {
        y0Var.p = cVar;
        return cVar;
    }

    static /* synthetic */ void H(y0 y0Var) {
        y0Var.K();
    }

    static /* synthetic */ y0.k I(y0 y0Var) {
        return y0Var.l;
    }

    static /* synthetic */ List J(y0 y0Var, List list) {
        y0Var.m = list;
        return list;
    }

    private void K() {
        this.k.d();
        if (this.p != null) {
            this.p.a();
            f1.c cVar = null;
            this.p = cVar;
            this.n = cVar;
        }
    }

    private static void L(List<?> list, String str) {
        final Iterator it = list.iterator();
        while (it.hasNext()) {
            n.p(it.next(), str);
        }
    }

    private void N(io.grpc.q qVar) {
        this.k.d();
        O(r.a(qVar));
    }

    private void O(r rVar) {
        boolean z = false;
        this.k.d();
        if (this.w.c() != rVar.c()) {
            int r0 = this.w.c() != q.SHUTDOWN ? 1 : 0;
            StringBuilder stringBuilder = new StringBuilder();
            str = "Cannot transition out of SHUTDOWN to ";
            str2 = str + rVar;
            n.v((this.w.c() != q.SHUTDOWN ? 1 : 0), str + rVar);
            this.w = rVar;
            (this.w.c() != q.SHUTDOWN ? 1 : 0).c(this, rVar);
        }
    }

    private void P() {
        this.k.execute(new y0.f(this));
    }

    private void Q(v vVar, boolean z) {
        this.k.execute(new y0.g(this, vVar, z));
    }

    private String R(d1 d1Var) {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d1Var.n());
        if (d1Var.o() != null) {
            str = "(";
            stringBuilder.append(str);
            stringBuilder.append(d1Var.o());
            str2 = ")";
            stringBuilder.append(str2);
        }
        return stringBuilder.toString();
    }

    private void S(d1 d1Var) {
        boolean z = false;
        this.k.d();
        O(r.b(d1Var));
        if (this.n == null) {
            this.n = this.d.get();
        }
        final TimeUnit nANOSECONDS2 = TimeUnit.NANOSECONDS;
        final long l3 = this.n.a() - this.o.d(nANOSECONDS2);
        Object[] arr = new Object[2];
        int i = 1;
        arr[i] = Long.valueOf(l3);
        this.j.b(g.a.INFO, "TRANSIENT_FAILURE ({0}). Will reconnect after {1} ns", arr);
        if (this.p == null) {
        }
        n.v(z, "previous reconnectTask is not done");
        this.p = this.k.c(new y0.b(this), l3, TimeUnit.NANOSECONDS, this.g);
    }

    private void T() {
        boolean z2;
        Object obj;
        SocketAddress socketAddress;
        String str;
        this.k.d();
        int i2 = 1;
        final int i = 0;
        int r0 = this.p == null ? i2 : i;
        n.v((this.p == null ? i2 : i), "Should have no reconnectTask scheduled");
        if ((this.p == null ? i2 : i).d()) {
            this.o.f();
            this.o.g();
        }
        socketAddress = this.l.a();
        io.grpc.j1.y0.a aVar = null;
        if (socketAddress instanceof c0) {
            java.net.InetSocketAddress inetSocketAddress = socketAddress.c();
        } else {
            int i3 = aVar;
        }
        a aVar2 = this.l.b();
        io.grpc.j1.t.a aVar3 = new t.a();
        if ((String)aVar2.b(y.d) == null) {
        }
        aVar3.e(str);
        aVar3.f(aVar2);
        aVar3.h(this.c);
        aVar3.g(obj);
        io.grpc.j1.y0.m mVar = new y0.m();
        mVar.a = f();
        io.grpc.j1.y0.i iVar = new y0.i(this.f.S0(socketAddress, aVar3, mVar), this.i, aVar);
        mVar.a = iVar.f();
        this.h.c(iVar);
        this.u = iVar;
        this.s.add(iVar);
        Runnable runnable = iVar.e(new y0.l(this, iVar, socketAddress));
        if (runnable != null) {
            this.k.b(runnable);
        }
        Object[] arr = new Object[i2];
        this.j.b(g.a.INFO, "Started transport {0}", new Object[] { mVar.a });
    }

    static /* synthetic */ y0.j h(y0 y0Var) {
        return y0Var.e;
    }

    static /* synthetic */ r i(y0 y0Var) {
        return y0Var.w;
    }

    static /* synthetic */ k1 j(y0 y0Var) {
        return y0Var.v;
    }

    static /* synthetic */ k1 k(y0 y0Var, k1 k1Var) {
        y0Var.v = k1Var;
        return k1Var;
    }

    static /* synthetic */ v l(y0 y0Var) {
        return y0Var.u;
    }

    static /* synthetic */ v m(y0 y0Var, v vVar) {
        y0Var.u = vVar;
        return vVar;
    }

    static /* synthetic */ f1.c n(y0 y0Var) {
        return y0Var.q;
    }

    static /* synthetic */ f1.c o(y0 y0Var, f1.c cVar) {
        y0Var.q = cVar;
        return cVar;
    }

    static /* synthetic */ k1 p(y0 y0Var) {
        return y0Var.r;
    }

    static /* synthetic */ k1 q(y0 y0Var, k1 k1Var) {
        y0Var.r = k1Var;
        return k1Var;
    }

    static /* synthetic */ ScheduledExecutorService r(y0 y0Var) {
        return y0Var.g;
    }

    static /* synthetic */ f1 s(y0 y0Var) {
        return y0Var.k;
    }

    static /* synthetic */ d1 t(y0 y0Var) {
        return y0Var.x;
    }

    static /* synthetic */ d1 u(y0 y0Var, d1 d1Var) {
        y0Var.x = d1Var;
        return d1Var;
    }

    static /* synthetic */ Collection v(y0 y0Var) {
        return y0Var.s;
    }

    static /* synthetic */ void w(y0 y0Var) {
        y0Var.P();
    }

    static /* synthetic */ w0 x(y0 y0Var) {
        return y0Var.t;
    }

    static /* synthetic */ g y(y0 y0Var) {
        return y0Var.j;
    }

    static /* synthetic */ k z(y0 y0Var, k kVar) {
        y0Var.n = kVar;
        return kVar;
    }

    io.grpc.q M() {
        return this.w.c();
    }

    public void U(List<y> list) {
        n.p(list, "newAddressGroups");
        y0.L(list, "newAddressGroups contains null entry");
        n.e(!list.isEmpty(), "newAddressGroups is empty");
        this.k.execute(new y0.d(this, Collections.unmodifiableList(new ArrayList(list))));
    }

    public s a() {
        if (this.v != null) {
            return this.v;
        }
        this.k.execute(new y0.c(this));
        return null;
    }

    public void c(d1 d1Var) {
        this.k.execute(new y0.e(this, d1Var));
    }

    void d(d1 d1Var) {
        c(d1Var);
        this.k.execute(new y0.h(this, d1Var));
    }

    public i0 f() {
        return this.a;
    }

    @Override // java.lang.Object
    public String toString() {
        j.b bVar = j.c(this);
        bVar.c("logId", this.a.d());
        bVar.d("addressGroups", this.m);
        return bVar.toString();
    }
}
