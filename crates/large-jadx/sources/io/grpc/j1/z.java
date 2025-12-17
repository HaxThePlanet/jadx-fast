package io.grpc.j1;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.n;
import io.grpc.a;
import io.grpc.d1;
import io.grpc.h;
import io.grpc.h.a;
import io.grpc.s;
import io.grpc.t0;
import io.grpc.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public class z<ReqT, RespT>  extends h<ReqT, RespT> {

    private static final Logger j;
    private static final h<Object, Object> k;
    private final ScheduledFuture<?> a;
    private final Executor b;
    private final s c;
    private volatile boolean d;
    private h.a<RespT> e;
    private h<ReqT, RespT> f;
    private d1 g;
    private List<Runnable> h;
    private io.grpc.j1.z.k<RespT> i;

    class a implements Runnable {

        final h.a a;
        final t0 b;
        final io.grpc.j1.z c;
        a(io.grpc.j1.z z, h.a h$a2, t0 t03) {
            this.c = z;
            this.a = a2;
            this.b = t03;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            z.b(this.c).start(this.a, this.b);
        }
    }

    class b implements Runnable {

        final StringBuilder a;
        final io.grpc.j1.z b;
        b(io.grpc.j1.z z, StringBuilder stringBuilder2) {
            this.b = z;
            this.a = stringBuilder2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            z.a(this.b, d1.i.r(this.a.toString()), true);
        }
    }

    class d implements Runnable {

        final d1 a;
        final io.grpc.j1.z b;
        d(io.grpc.j1.z z, d1 d12) {
            this.b = z;
            this.a = d12;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            z.b(this.b).cancel(this.a.o(), this.a.m());
        }
    }

    class e implements Runnable {

        final Object a;
        final io.grpc.j1.z b;
        e(io.grpc.j1.z z, Object object2) {
            this.b = z;
            this.a = object2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            z.b(this.b).sendMessage(this.a);
        }
    }

    class f implements Runnable {

        final boolean a;
        final io.grpc.j1.z b;
        f(io.grpc.j1.z z, boolean z2) {
            this.b = z;
            this.a = z2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            z.b(this.b).setMessageCompression(this.a);
        }
    }

    class g implements Runnable {

        final int a;
        final io.grpc.j1.z b;
        g(io.grpc.j1.z z, int i2) {
            this.b = z;
            this.a = i2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            z.b(this.b).request(this.a);
        }
    }

    class h implements Runnable {

        final io.grpc.j1.z a;
        h(io.grpc.j1.z z) {
            this.a = z;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            z.b(this.a).halfClose();
        }
    }

    class c extends io.grpc.j1.x {

        final io.grpc.j1.z.k b;
        c(io.grpc.j1.z z, io.grpc.j1.z.k z$k2) {
            this.b = k2;
            super(z.c(z));
        }

        @Override // io.grpc.j1.x
        public void a() {
            this.b.c();
        }
    }

    class i extends h<Object, Object> {
        @Override // io.grpc.h
        public void cancel(String string, Throwable throwable2) {
        }

        @Override // io.grpc.h
        public void halfClose() {
        }

        @Override // io.grpc.h
        public boolean isReady() {
            return 0;
        }

        @Override // io.grpc.h
        public void request(int i) {
        }

        @Override // io.grpc.h
        public void sendMessage(Object object) {
        }

        public void start(h.a<Object> h$a, t0 t02) {
        }
    }

    private final class j extends io.grpc.j1.x {

        final h.a<RespT> b;
        final d1 c;
        j(io.grpc.j1.z z, h.a h$a2, d1 d13) {
            super(z.c(z));
            this.b = a2;
            this.c = d13;
        }

        @Override // io.grpc.j1.x
        public void a() {
            t0 t0Var = new t0();
            this.b.onClose(this.c, t0Var);
        }
    }

    private static final class k extends h.a<RespT> {

        private final h.a<RespT> a;
        private volatile boolean b;
        private List<Runnable> c;
        static {
        }

        public k(h.a<RespT> h$a) {
            super();
            ArrayList arrayList = new ArrayList();
            this.c = arrayList;
            this.a = a;
        }

        static h.a a(io.grpc.j1.z.k z$k) {
            return k.a;
        }

        private void b(Runnable runnable) {
            synchronized (this) {
                try {
                    this.c.add(runnable);
                    runnable.run();
                    throw runnable;
                }
            }
        }

        @Override // io.grpc.h$a
        void c() {
            ArrayList arrayList;
            List list;
            boolean next;
            arrayList = new ArrayList();
            synchronized (this) {
                this.c = 0;
                this.b = true;
            }
            for (Runnable next : iterator) {
                next.run();
            }
            try {
                list.clear();
                arrayList = list;
                throw th;
            }
        }

        @Override // io.grpc.h$a
        public void onClose(d1 d1, t0 t02) {
            z.k.c cVar = new z.k.c(this, d1, t02);
            b(cVar);
        }

        @Override // io.grpc.h$a
        public void onHeaders(t0 t0) {
            Object aVar;
            if (this.b) {
                this.a.onHeaders(t0);
            } else {
                aVar = new z.k.a(this, t0);
                b(aVar);
            }
        }

        public void onMessage(RespT respt) {
            Object bVar;
            if (this.b) {
                this.a.onMessage(respt);
            } else {
                bVar = new z.k.b(this, respt);
                b(bVar);
            }
        }

        @Override // io.grpc.h$a
        public void onReady() {
            Object dVar;
            if (this.b) {
                this.a.onReady();
            } else {
                dVar = new z.k.d(this);
                b(dVar);
            }
        }
    }
    static {
        z.j = Logger.getLogger(z.class.getName());
        z.i iVar = new z.i();
        z.k = iVar;
    }

    protected z(Executor executor, ScheduledExecutorService scheduledExecutorService2, u u3) {
        super();
        ArrayList arrayList = new ArrayList();
        this.h = arrayList;
        n.p(executor, "callExecutor");
        this.b = (Executor)executor;
        n.p(scheduledExecutorService2, "scheduler");
        this.c = s.i();
        this.a = h(scheduledExecutorService2, u3);
    }

    static void a(io.grpc.j1.z z, d1 d12, boolean z3) {
        z.e(d12, z3);
    }

    static h b(io.grpc.j1.z z) {
        return z.f;
    }

    static s c(io.grpc.j1.z z) {
        return z.c;
    }

    private void e(d1 d1, boolean z2) {
        int i;
        io.grpc.j1.z.j jVar;
        int obj4;
        synchronized (this) {
            try {
                j(z.k);
                obj4 = 0;
                i = this.e;
                this.g = d1;
                if (z2) {
                }
                obj4 = 1;
                i = 0;
                if (obj4 != null) {
                } else {
                }
                obj4 = new z.d(this, d1);
                f(obj4);
                if (i != 0) {
                }
                jVar = new z.j(this, i, d1);
                this.b.execute(jVar);
                g();
                d();
                throw d1;
            }
        }
    }

    private void f(Runnable runnable) {
        synchronized (this) {
            try {
                this.h.add(runnable);
                runnable.run();
                throw runnable;
            }
        }
    }

    private void g() {
        ArrayList arrayList;
        List list;
        boolean empty;
        boolean cVar;
        arrayList = new ArrayList();
        synchronized (this) {
            this.h = 0;
            this.d = true;
            io.grpc.j1.z.k kVar = this.i;
            if (kVar != null) {
            }
        }
        cVar = new z.c(this, kVar);
        this.b.execute(cVar);
    }

    private ScheduledFuture<?> h(ScheduledExecutorService scheduledExecutorService, u u2) {
        Object uVar;
        String str;
        long l2;
        long l;
        Object nANOSECONDS;
        int stringBuilder;
        String format;
        String str2;
        String obj13;
        uVar = this.c.k();
        if (u2 == null && uVar == null) {
            if (uVar == null) {
                return 0;
            }
        }
        if (u2 != null) {
            l2 = Math.min(Long.MAX_VALUE, obj2);
        }
        int i = 0;
        int i2 = 1;
        nANOSECONDS = TimeUnit.NANOSECONDS;
        uVar = z.j;
        if (uVar != null && Long.compare(l4, l2) < 0 && uVar.isLoggable(Level.FINE)) {
            nANOSECONDS = TimeUnit.NANOSECONDS;
            if (Long.compare(l4, l2) < 0) {
                uVar = z.j;
                if (uVar.isLoggable(Level.FINE)) {
                    Object[] arr2 = new Object[i2];
                    arr2[i] = Long.valueOf(uVar.n(nANOSECONDS));
                    str2 = "Call timeout set to '%d' ns, due to context deadline.";
                    stringBuilder = new StringBuilder(String.format(str2, arr2));
                    if (u2 == null) {
                        stringBuilder.append(" Explicit call timeout was not set.");
                    } else {
                        obj13 = new Object[i2];
                        obj13[i] = Long.valueOf(u2.n(nANOSECONDS));
                        stringBuilder.append(String.format(" Explicit call timeout was '%d' ns.", obj13));
                    }
                    uVar.fine(stringBuilder.toString());
                }
            }
        }
        obj13 = TimeUnit.SECONDS;
        int i4 = 1;
        obj13 = new StringBuilder();
        if (Long.compare(l2, i5) < 0) {
            obj13.append("ClientCall started after deadline exceeded. Deadline exceeded after -");
        } else {
            obj13.append("Deadline exceeded after ");
        }
        obj13.append(l3 /= nanos2);
        Object[] arr = new Object[i2];
        arr[i] = Long.valueOf(l5 %= nanos);
        obj13.append(String.format(Locale.US, ".%09d", arr));
        obj13.append("s. ");
        z.b bVar = new z.b(this, obj13);
        return scheduledExecutorService.schedule(bVar, l2, obj2);
    }

    private void j(h<ReqT, RespT> h) {
        int i;
        h hVar = this.f;
        final int i2 = 0;
        i = hVar == null ? 1 : i2;
        n.x(i, "realCall already set to %s", hVar);
        ScheduledFuture future = this.a;
        if (future != null) {
            future.cancel(i2);
        }
        this.f = h;
    }

    @Override // io.grpc.h
    public final void cancel(String string, Throwable throwable2) {
        d1 obj2;
        final d1 d1Var = d1.g;
        if (string != null) {
            obj2 = d1Var.r(string);
        } else {
            obj2 = d1Var.r("Call cancelled without message");
        }
        if (throwable2 != null) {
            obj2 = obj2.q(throwable2);
        }
        e(obj2, false);
    }

    @Override // io.grpc.h
    protected void d() {
    }

    @Override // io.grpc.h
    public final a getAttributes() {
        h hVar = this.f;
        synchronized (this) {
            hVar = this.f;
        }
        try {
            return hVar.getAttributes();
            return a.b;
            throw th;
        }
    }

    @Override // io.grpc.h
    public final void halfClose() {
        z.h hVar = new z.h(this);
        f(hVar);
    }

    public final void i(h<ReqT, RespT> h) {
        synchronized (this) {
            try {
                n.p(h, "call");
                j((h)h);
                g();
                throw h;
            }
        }
    }

    @Override // io.grpc.h
    public final boolean isReady() {
        if (this.d) {
            return this.f.isReady();
        }
        return 0;
    }

    @Override // io.grpc.h
    public final void request(int i) {
        Object gVar;
        if (this.d) {
            this.f.request(i);
        } else {
            gVar = new z.g(this, i);
            f(gVar);
        }
    }

    public final void sendMessage(ReqT reqt) {
        Object eVar;
        if (this.d) {
            this.f.sendMessage(reqt);
        } else {
            eVar = new z.e(this, reqt);
            f(eVar);
        }
    }

    @Override // io.grpc.h
    public final void setMessageCompression(boolean z) {
        Object fVar;
        if (this.d) {
            this.f.setMessageCompression(z);
        } else {
            fVar = new z.f(this, z);
            f(fVar);
        }
    }

    public final void start(h.a<RespT> h$a, t0 t02) {
        int i;
        Object aVar;
        io.grpc.j1.z.k kVar;
        Object obj4;
        i = this.e == null ? 1 : 0;
        n.v(i, "already started");
        n.p(a, "listener");
        this.e = (h.a)a;
        d1 d1Var = this.g;
        boolean z = this.d;
        synchronized (this) {
            kVar = new z.k(a);
            this.i = kVar;
            obj4 = kVar;
            if (d1Var != null) {
            }
            if (z) {
                this.f.start(obj4, t02);
            } else {
                aVar = new z.a(this, obj4, t02);
                f(aVar);
            }
        }
        z.j jVar = new z.j(this, obj4, d1Var);
        this.b.execute(jVar);
    }

    @Override // io.grpc.h
    public String toString() {
        j.b bVar = j.c(this);
        bVar.d("realCall", this.f);
        return bVar.toString();
    }
}
