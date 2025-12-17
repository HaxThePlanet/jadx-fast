package io.grpc.j1;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.n;
import com.google.common.base.q;
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
import io.grpc.q;
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

/* loaded from: classes3.dex */
final class y0 implements h0<Object>, io.grpc.j1.n2 {

    private final i0 a;
    private final String b;
    private final String c;
    private final io.grpc.j1.k.a d;
    private final io.grpc.j1.y0.j e;
    private final io.grpc.j1.t f;
    private final ScheduledExecutorService g;
    private final d0 h;
    private final io.grpc.j1.m i;
    private final g j;
    private final f1 k;
    private final io.grpc.j1.y0.k l;
    private volatile List<y> m;
    private io.grpc.j1.k n;
    private final q o;
    private f1.c p;
    private f1.c q;
    private io.grpc.j1.k1 r;
    private final Collection<io.grpc.j1.v> s;
    private final io.grpc.j1.w0<io.grpc.j1.v> t;
    private io.grpc.j1.v u;
    private volatile io.grpc.j1.k1 v;
    private volatile r w;
    private d1 x;

    class b implements Runnable {

        final io.grpc.j1.y0 a;
        b(io.grpc.j1.y0 y0) {
            this.a = y0;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            y0.G(this.a, 0);
            y0.y(this.a).a(g.a.INFO, "CONNECTING after backoff");
            y0.E(this.a, q.CONNECTING);
            y0.F(this.a);
        }
    }

    class c implements Runnable {

        final io.grpc.j1.y0 a;
        c(io.grpc.j1.y0 y0) {
            this.a = y0;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Object qVar;
            q cONNECTING;
            String str;
            if (y0.i(this.a).c() == q.IDLE) {
                y0.y(this.a).a(g.a.INFO, "CONNECTING as requested");
                y0.E(this.a, q.CONNECTING);
                y0.F(this.a);
            }
        }
    }

    class d implements Runnable {

        final List a;
        final io.grpc.j1.y0 b;
        d(io.grpc.j1.y0 y0, List list2) {
            this.b = y0;
            this.a = list2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            boolean socket;
            Object qVar;
            Object cVar;
            Object rEADY;
            int i;
            q cONNECTING;
            TimeUnit sECONDS;
            ScheduledExecutorService service;
            y0.I(this.b).h(this.a);
            y0.J(this.b, this.a);
            rEADY = q.READY;
            i = 0;
            if (y0.i(this.b).c() != rEADY) {
                if (y0.i(this.b).c() == q.CONNECTING && !y0.I(this.b).g(y0.I(this.b).a())) {
                    if (!y0.I(this.b).g(socket)) {
                        if (y0.i(this.b).c() == rEADY) {
                            i2 = y0.j(this.b);
                            y0.k(this.b, i);
                            y0.I(this.b).f();
                            y0.E(this.b, q.IDLE);
                        } else {
                            y0.l(this.b).c(d1.n.r("InternalSubchannel closed pending transport due to address change"));
                            y0.m(this.b, i);
                            y0.I(this.b).f();
                            y0.F(this.b);
                            i2 = i;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            if (i2 != 0 && y0.n(this.b) != null) {
                if (y0.n(this.b) != null) {
                    y0.p(this.b).c(d1.n.r("InternalSubchannel closed transport early due to address change"));
                    y0.n(this.b).a();
                    y0.o(this.b, i);
                    y0.q(this.b, i);
                }
                y0.q(this.b, i2);
                i2 = this.b;
                rEADY = new y0.d.a(this);
                y0.o(i2, y0.s(i2).c(rEADY, 5, cONNECTING, TimeUnit.SECONDS));
            }
        }
    }

    class e implements Runnable {

        final d1 a;
        final io.grpc.j1.y0 b;
        e(io.grpc.j1.y0 y0, d1 d12) {
            this.b = y0;
            this.a = d12;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Object k1Var;
            boolean empty;
            Object cVar;
            Object y0Var;
            q sHUTDOWN = q.SHUTDOWN;
            if (y0.i(this.b).c() == sHUTDOWN) {
            }
            y0.u(this.b, this.a);
            k1Var = y0.j(this.b);
            io.grpc.j1.v vVar = y0.l(this.b);
            final int i = 0;
            y0.k(this.b, i);
            y0.m(this.b, i);
            y0.E(this.b, sHUTDOWN);
            y0.I(this.b).f();
            if (y0.v(this.b).isEmpty()) {
                y0.w(this.b);
            }
            y0.H(this.b);
            if (y0.n(this.b) != null) {
                y0.n(this.b).a();
                y0.p(this.b).c(this.a);
                y0.o(this.b, i);
                y0.q(this.b, i);
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

        final io.grpc.j1.y0 a;
        f(io.grpc.j1.y0 y0) {
            this.a = y0;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            y0.y(this.a).a(g.a.INFO, "Terminated");
            y0.h(this.a).d(this.a);
        }
    }

    class g implements Runnable {

        final io.grpc.j1.v a;
        final boolean b;
        final io.grpc.j1.y0 c;
        g(io.grpc.j1.y0 y0, io.grpc.j1.v v2, boolean z3) {
            this.c = y0;
            this.a = v2;
            this.b = z3;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            y0.x(this.c).e(this.a, this.b);
        }
    }

    class h implements Runnable {

        final d1 a;
        final io.grpc.j1.y0 b;
        h(io.grpc.j1.y0 y0, d1 d12) {
            this.b = y0;
            this.a = d12;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Collection next;
            d1 d1Var;
            ArrayList arrayList = new ArrayList(y0.v(this.b));
            Iterator iterator = arrayList.iterator();
            for (k1 next : iterator) {
                next.d(this.a);
            }
        }
    }

    static abstract class j {
        abstract void a(io.grpc.j1.y0 y0);

        abstract void b(io.grpc.j1.y0 y0);

        abstract void c(io.grpc.j1.y0 y0, r r2);

        abstract void d(io.grpc.j1.y0 y0);
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
            int size;
            i4++;
            this.c = i5;
            if (i5 >= (y)this.a.get(this.b).a().size()) {
                this.b = i++;
                this.c = 0;
            }
        }

        public boolean d() {
            int i;
            int i2;
            if (this.b == 0 && this.c == 0) {
                i2 = this.c == 0 ? 1 : 0;
            } else {
            }
            return i2;
        }

        public boolean e() {
            int i;
            i = this.b < this.a.size() ? 1 : 0;
            return i;
        }

        public void f() {
            final int i = 0;
            this.b = i;
            this.c = i;
        }

        public boolean g(SocketAddress socketAddress) {
            int i2;
            int indexOf;
            int i;
            final int i3 = 0;
            i2 = i3;
            while (i2 < this.a.size()) {
                indexOf = (y)this.a.get(i2).a().indexOf(socketAddress);
                i2++;
            }
            return i3;
        }

        public void h(List<y> list) {
            this.a = list;
            f();
        }
    }

    class a extends io.grpc.j1.w0<io.grpc.j1.v> {

        final io.grpc.j1.y0 b;
        a(io.grpc.j1.y0 y0) {
            this.b = y0;
            super();
        }

        @Override // io.grpc.j1.w0
        protected void b() {
            y0.h(this.b).a(this.b);
        }

        @Override // io.grpc.j1.w0
        protected void c() {
            y0.h(this.b).b(this.b);
        }
    }

    private class l implements io.grpc.j1.k1.a {

        final io.grpc.j1.v a;
        boolean b = false;
        final io.grpc.j1.y0 c;
        l(io.grpc.j1.y0 y0, io.grpc.j1.v v2, SocketAddress socketAddress3) {
            this.c = y0;
            super();
            final int obj1 = 0;
            this.a = v2;
        }

        @Override // io.grpc.j1.k1$a
        public void a(d1 d1) {
            Object[] arr = new Object[2];
            int i3 = 1;
            arr[i3] = y0.B(this.c, d1);
            y0.y(this.c).b(g.a.INFO, "{0} SHUTDOWN with {1}", arr);
            this.b = i3;
            y0.l.b bVar = new y0.l.b(this, d1);
            y0.s(this.c).execute(bVar);
        }

        @Override // io.grpc.j1.k1$a
        public void b() {
            y0.y(this.c).a(g.a.INFO, "READY");
            y0.l.a aVar = new y0.l.a(this);
            y0.s(this.c).execute(aVar);
        }

        @Override // io.grpc.j1.k1$a
        public void c() {
            n.v(this.b, "transportShutdown() must be called before transportTerminated().");
            Object[] arr = new Object[1];
            final int i2 = 0;
            arr[i2] = this.a.f();
            y0.y(this.c).b(g.a.INFO, "{0} Terminated", arr);
            y0.D(this.c).i(this.a);
            y0.A(this.c, this.a, i2);
            y0.l.c cVar = new y0.l.c(this);
            y0.s(this.c).execute(cVar);
        }

        @Override // io.grpc.j1.k1$a
        public void d(boolean z) {
            y0.A(this.c, this.a, z);
        }
    }

    static final class m extends g {

        i0 a;
        @Override // io.grpc.g
        public void a(g.a g$a, String string2) {
            n.d(this.a, a, string2);
        }

        @Override // io.grpc.g
        public void b(g.a g$a, String string2, Object... object3Arr3) {
            n.e(this.a, a, string2, object3Arr3);
        }
    }

    static final class i extends io.grpc.j1.k0 {

        private final io.grpc.j1.v a;
        private final io.grpc.j1.m b;
        private i(io.grpc.j1.v v, io.grpc.j1.m m2) {
            super();
            this.a = v;
            this.b = m2;
        }

        i(io.grpc.j1.v v, io.grpc.j1.m m2, io.grpc.j1.y0.a y0$a3) {
            super(v, m2);
        }

        static io.grpc.j1.m h(io.grpc.j1.y0.i y0$i) {
            return i.b;
        }

        @Override // io.grpc.j1.k0
        protected io.grpc.j1.v a() {
            return this.a;
        }

        public io.grpc.j1.q b(u0<?, ?> u0, t0 t02, d d3, l[] l4Arr4) {
            y0.i.a obj2 = new y0.i.a(this, super.b(u0, t02, d3, l4Arr4));
            return obj2;
        }
    }
    y0(List<y> list, String string2, String string3, io.grpc.j1.k.a k$a4, io.grpc.j1.t t5, ScheduledExecutorService scheduledExecutorService6, s<q> s7, f1 f18, io.grpc.j1.y0.j y0$j9, d0 d010, io.grpc.j1.m m11, io.grpc.j1.o o12, i0 i013, g g14) {
        final Object obj = this;
        Object obj2 = list;
        final Object obj4 = i013;
        final Object obj5 = g14;
        super();
        ArrayList arrayList = new ArrayList();
        obj.s = arrayList;
        y0.a aVar2 = new y0.a(this);
        obj.t = aVar2;
        obj.w = r.a(q.IDLE);
        n.p(list, "addressGroups");
        n.e(empty ^= 1, "addressGroups is empty");
        y0.L(list, "addressGroups contains null entry");
        ArrayList arrayList2 = new ArrayList(list);
        List unmodifiableList = Collections.unmodifiableList(arrayList2);
        obj.m = unmodifiableList;
        y0.k kVar = new y0.k(unmodifiableList);
        obj.l = kVar;
        obj.b = string2;
        obj.c = string3;
        obj.d = a4;
        obj.f = t5;
        obj.g = scheduledExecutorService6;
        obj.o = (q)s7.get();
        obj.k = f18;
        obj.e = j9;
        obj.h = d010;
        obj.i = m11;
        n.p(o12, "channelTracer");
        n.p(obj4, "logId");
        obj.a = obj4;
        n.p(obj5, "channelLogger");
        obj.j = obj5;
    }

    static void A(io.grpc.j1.y0 y0, io.grpc.j1.v v2, boolean z3) {
        y0.Q(v2, z3);
    }

    static String B(io.grpc.j1.y0 y0, d1 d12) {
        return y0.R(d12);
    }

    static void C(io.grpc.j1.y0 y0, d1 d12) {
        y0.S(d12);
    }

    static d0 D(io.grpc.j1.y0 y0) {
        return y0.h;
    }

    static void E(io.grpc.j1.y0 y0, q q2) {
        y0.N(q2);
    }

    static void F(io.grpc.j1.y0 y0) {
        y0.T();
    }

    static f1.c G(io.grpc.j1.y0 y0, f1.c f1$c2) {
        y0.p = c2;
        return c2;
    }

    static void H(io.grpc.j1.y0 y0) {
        y0.K();
    }

    static io.grpc.j1.y0.k I(io.grpc.j1.y0 y0) {
        return y0.l;
    }

    static List J(io.grpc.j1.y0 y0, List list2) {
        y0.m = list2;
        return list2;
    }

    private void K() {
        f1.c cVar;
        this.k.d();
        cVar = this.p;
        if (cVar != null) {
            cVar.a();
            cVar = 0;
            this.p = cVar;
            this.n = cVar;
        }
    }

    private static void L(List<?> list, String string2) {
        Object next;
        final Iterator obj1 = list.iterator();
        for (Object next : obj1) {
            n.p(next, string2);
        }
    }

    private void N(q q) {
        this.k.d();
        O(r.a(q));
    }

    private void O(r r) {
        int i;
        Object qVar;
        Object string;
        String str;
        this.k.d();
        if (this.w.c() != r.c()) {
            i = this.w.c() != q.SHUTDOWN ? 1 : 0;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot transition out of SHUTDOWN to ");
            stringBuilder.append(r);
            n.v(i, stringBuilder.toString());
            this.w = r;
            this.e.c(this, r);
        }
    }

    private void P() {
        y0.f fVar = new y0.f(this);
        this.k.execute(fVar);
    }

    private void Q(io.grpc.j1.v v, boolean z2) {
        y0.g gVar = new y0.g(this, v, z2);
        this.k.execute(gVar);
    }

    private String R(d1 d1) {
        String str;
        String obj3;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d1.n());
        if (d1.o() != null) {
            stringBuilder.append("(");
            stringBuilder.append(d1.o());
            stringBuilder.append(")");
        }
        return stringBuilder.toString();
    }

    private void S(d1 d1) {
        io.grpc.j1.k kVar;
        int i;
        this.k.d();
        O(r.b(d1));
        if (this.n == null) {
            this.n = this.d.get();
        }
        final TimeUnit nANOSECONDS = TimeUnit.NANOSECONDS;
        final int i4 = l - l2;
        Object[] arr = new Object[2];
        int i3 = 1;
        arr[i3] = Long.valueOf(i4);
        this.j.b(g.a.INFO, "TRANSIENT_FAILURE ({0}). Will reconnect after {1} ns", arr);
        if (this.p == null) {
            i = i3;
        }
        n.v(i, "previous reconnectTask is not done");
        y0.b bVar = new y0.b(this);
        this.p = this.k.c(bVar, i4, obj6, nANOSECONDS);
    }

    private void T() {
        int i;
        boolean z;
        int socket;
        Object socket2;
        Object lVar;
        Object obj;
        this.k.d();
        int i2 = 1;
        final int i3 = 0;
        i = this.p == null ? i2 : i3;
        n.v(i, "Should have no reconnectTask scheduled");
        if (this.l.d()) {
            z = this.o;
            z.f();
            z.g();
        }
        socket = this.l.a();
        int i4 = 0;
        if (socket instanceof c0) {
            socket2 = (c0)socket.c();
        } else {
            socket2 = socket;
            socket = i4;
        }
        a aVar = this.l.b();
        t.a aVar2 = new t.a();
        if ((String)aVar.b(y.d) != null) {
        } else {
            obj = this.b;
        }
        aVar2.e(obj);
        aVar2.f(aVar);
        aVar2.h(this.c);
        aVar2.g(socket);
        y0.m mVar = new y0.m();
        mVar.a = f();
        y0.i iVar = new y0.i(this.f.S0(socket2, aVar2, mVar), this.i, i4);
        mVar.a = iVar.f();
        this.h.c(iVar);
        this.u = iVar;
        this.s.add(iVar);
        lVar = new y0.l(this, iVar, socket2);
        Runnable runnable = iVar.e(lVar);
        if (runnable != null) {
            this.k.b(runnable);
        }
        Object[] arr = new Object[i2];
        arr[i3] = mVar.a;
        this.j.b(g.a.INFO, "Started transport {0}", arr);
    }

    static io.grpc.j1.y0.j h(io.grpc.j1.y0 y0) {
        return y0.e;
    }

    static r i(io.grpc.j1.y0 y0) {
        return y0.w;
    }

    static io.grpc.j1.k1 j(io.grpc.j1.y0 y0) {
        return y0.v;
    }

    static io.grpc.j1.k1 k(io.grpc.j1.y0 y0, io.grpc.j1.k1 k12) {
        y0.v = k12;
        return k12;
    }

    static io.grpc.j1.v l(io.grpc.j1.y0 y0) {
        return y0.u;
    }

    static io.grpc.j1.v m(io.grpc.j1.y0 y0, io.grpc.j1.v v2) {
        y0.u = v2;
        return v2;
    }

    static f1.c n(io.grpc.j1.y0 y0) {
        return y0.q;
    }

    static f1.c o(io.grpc.j1.y0 y0, f1.c f1$c2) {
        y0.q = c2;
        return c2;
    }

    static io.grpc.j1.k1 p(io.grpc.j1.y0 y0) {
        return y0.r;
    }

    static io.grpc.j1.k1 q(io.grpc.j1.y0 y0, io.grpc.j1.k1 k12) {
        y0.r = k12;
        return k12;
    }

    static ScheduledExecutorService r(io.grpc.j1.y0 y0) {
        return y0.g;
    }

    static f1 s(io.grpc.j1.y0 y0) {
        return y0.k;
    }

    static d1 t(io.grpc.j1.y0 y0) {
        return y0.x;
    }

    static d1 u(io.grpc.j1.y0 y0, d1 d12) {
        y0.x = d12;
        return d12;
    }

    static Collection v(io.grpc.j1.y0 y0) {
        return y0.s;
    }

    static void w(io.grpc.j1.y0 y0) {
        y0.P();
    }

    static io.grpc.j1.w0 x(io.grpc.j1.y0 y0) {
        return y0.t;
    }

    static g y(io.grpc.j1.y0 y0) {
        return y0.j;
    }

    static io.grpc.j1.k z(io.grpc.j1.y0 y0, io.grpc.j1.k k2) {
        y0.n = k2;
        return k2;
    }

    @Override // io.grpc.h0
    q M() {
        return this.w.c();
    }

    public void U(List<y> list) {
        n.p(list, "newAddressGroups");
        y0.L(list, "newAddressGroups contains null entry");
        n.e(empty ^= 1, "newAddressGroups is empty");
        ArrayList arrayList = new ArrayList(list);
        y0.d dVar = new y0.d(this, Collections.unmodifiableList(arrayList));
        this.k.execute(dVar);
    }

    @Override // io.grpc.h0
    public io.grpc.j1.s a() {
        io.grpc.j1.k1 k1Var = this.v;
        if (k1Var != null) {
            return k1Var;
        }
        y0.c cVar = new y0.c(this);
        this.k.execute(cVar);
        return null;
    }

    @Override // io.grpc.h0
    public void c(d1 d1) {
        y0.e eVar = new y0.e(this, d1);
        this.k.execute(eVar);
    }

    @Override // io.grpc.h0
    void d(d1 d1) {
        c(d1);
        y0.h hVar = new y0.h(this, d1);
        this.k.execute(hVar);
    }

    @Override // io.grpc.h0
    public i0 f() {
        return this.a;
    }

    @Override // io.grpc.h0
    public String toString() {
        j.b bVar = j.c(this);
        bVar.c("logId", this.a.d());
        bVar.d("addressGroups", this.m);
        return bVar.toString();
    }
}
