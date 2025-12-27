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

/* compiled from: DelayedClientCall.java */
/* loaded from: classes3.dex */
public class z<ReqT, RespT> extends h<ReqT, RespT> {

    private static final Logger j;
    private static final h<Object, Object> k = new z$i<>();
    private final ScheduledFuture<?> a;
    private final Executor b;
    private final s c;
    private volatile boolean d;
    private h.a<RespT> e;
    private h<ReqT, RespT> f;
    private d1 g;
    private List<Runnable> h = new ArrayList<>();
    private z.k<RespT> i;

    class a implements Runnable {

        final /* synthetic */ h.a a;
        final /* synthetic */ t0 b;
        final /* synthetic */ z c;
        a(h.a aVar, t0 t0Var) {
            this.c = zVar;
            this.a = aVar;
            this.b = t0Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.f.start(this.a, this.b);
        }
    }

    class b implements Runnable {

        final /* synthetic */ StringBuilder a;
        final /* synthetic */ z b;
        b(StringBuilder sb) {
            this.b = zVar;
            this.a = sb;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.e(d1.i.r(this.a.toString()), 1);
        }
    }

    class d implements Runnable {

        final /* synthetic */ d1 a;
        final /* synthetic */ z b;
        d(d1 d1Var) {
            this.b = zVar;
            this.a = d1Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.f.cancel(this.a.o(), this.a.m());
        }
    }

    class e implements Runnable {

        final /* synthetic */ Object a;
        final /* synthetic */ z b;
        e(Object object) {
            this.b = zVar;
            this.a = object;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.f.sendMessage(this.a);
        }
    }

    class f implements Runnable {

        final /* synthetic */ boolean a;
        final /* synthetic */ z b;
        f(boolean z) {
            this.b = zVar;
            this.a = z;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.f.setMessageCompression(this.a);
        }
    }

    class g implements Runnable {

        final /* synthetic */ int a;
        final /* synthetic */ z b;
        g(int i) {
            this.b = zVar;
            this.a = i;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.f.request(this.a);
        }
    }

    class h implements Runnable {

        final /* synthetic */ z a;
        h() {
            this.a = zVar;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.f.halfClose();
        }
    }

    class c extends x {

        final /* synthetic */ z.k b;
        c(z.k kVar) {
            this.b = kVar;
            super(zVar.c);
        }

        @Override // io.grpc.j1.x
        public void a() {
            this.b.c();
        }
    }

    class i extends h<Object, Object> {
        i() {
            super();
        }

        @Override // io.grpc.h
        public void cancel(String str, Throwable th) {
        }

        @Override // io.grpc.h
        public void halfClose() {
        }

        @Override // io.grpc.h
        public boolean isReady() {
            return false;
        }

        @Override // io.grpc.h
        public void request(int i) {
        }

        @Override // io.grpc.h
        public void sendMessage(Object object) {
        }

        @Override // io.grpc.h
        public void start(h.a<Object> aVar, t0 t0Var) {
        }
    }

    private final class j extends x {

        final h.a<RespT> b;
        final d1 c;
        j(h.a aVar, d1 d1Var) {
            super(zVar.c);
            this.b = aVar;
            this.c = d1Var;
        }

        @Override // io.grpc.j1.x
        public void a() {
            this.b.onClose(this.c, new t0());
        }
    }

    private static final class k<RespT> extends h.a<RespT> {

        private final h.a<RespT> a;
        private volatile boolean b;
        private List<Runnable> c = new ArrayList<>();
        public k(h.a<RespT> aVar) {
            super();
            final ArrayList arrayList = new ArrayList();
            this.a = aVar;
        }

        static /* synthetic */ h.a a(z.k kVar) {
            return kVar.a;
        }

        private void b(Runnable runnable) {
            synchronized (this) {
                try {
                    if (!this.b) {
                        this.c.add(runnable);
                        return;
                    }
                } catch (Throwable th) {
                }
            }
            th.run();
        }

        @Override // io.grpc.h$a
        void c() {
            ArrayList arrayList;
            boolean hasNext;
            arrayList = new ArrayList();
            synchronized (this) {
                try {
                    this.c = null;
                    this.b = true;
                    return;
                } catch (Throwable th) {
                }
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                (Runnable)it.next().run();
            }
            list.clear();
            arrayList = list;
        }

        @Override // io.grpc.h$a
        public void onClose(d1 d1Var, t0 t0Var) {
            b(new z.k.c(this, d1Var, t0Var));
        }

        @Override // io.grpc.h$a
        public void onHeaders(t0 t0Var) {
            if (this.b) {
                this.a.onHeaders(t0Var);
            } else {
                b(new z.k.a(this, t0Var));
            }
        }

        @Override // io.grpc.h$a
        public void onMessage(RespT respt) {
            if (this.b) {
                this.a.onMessage(respt);
            } else {
                b(new z.k.b(this, respt));
            }
        }

        @Override // io.grpc.h$a
        public void onReady() {
            if (this.b) {
                this.a.onReady();
            } else {
                b(new z.k.d(this));
            }
        }

    }
    static {
        z.j = Logger.getLogger(z.class.getName());
    }

    protected z(Executor executor, ScheduledExecutorService scheduledExecutorService, u uVar) {
        super();
        ArrayList arrayList = new ArrayList();
        n.p(executor, "callExecutor");
        this.b = executor;
        n.p(scheduledExecutorService, "scheduler");
        this.c = s.i();
        this.a = h(scheduledExecutorService, uVar);
    }

    static /* synthetic */ void a(z zVar, d1 d1Var, boolean z) {
        zVar.e(d1Var, z);
    }

    static /* synthetic */ h b(z zVar) {
        return zVar.f;
    }

    static /* synthetic */ s c(z zVar) {
        return zVar.c;
    }

    private void e(d1 d1Var, boolean z) {
        h.a aVar = null;
        io.grpc.j1.z.j jVar;
        int i = 1;
        synchronized (this) {
            try {
                if (this.f != null) {
                    if (z) {
                        return;
                    }
                    i = 1;
                    int i2 = 0;
                } else {
                    j(z.k);
                    i = 0;
                    this.g = d1Var;
                }
            } catch (Throwable th) {
            }
        }
        if (z.k != 0) {
            f(new z.d(this, th));
        } else {
            if (this.f != null) {
                this.b.execute(new z.j(this, aVar, th));
            }
            g();
        }
        d();
    }

    private void f(Runnable runnable) {
        synchronized (this) {
            try {
                if (!this.d) {
                    this.h.add(runnable);
                    return;
                }
            } catch (Throwable th) {
            }
        }
        th.run();
    }

    private void g() {
        ArrayList arrayList;
        boolean hasNext;
        arrayList = new ArrayList();
        synchronized (this) {
            try {
                this.h = null;
                this.d = true;
            } catch (Throwable th) {
            }
            try {
                this.h = arrayList;
            } catch (Throwable th) {
            }
            Iterator it = this.h.iterator();
            while (it.hasNext()) {
                (Runnable)it.next().run();
            }
            this.h.clear();
            arrayList = list;
        }
        if (this.i != null) {
            this.b.execute(new z.c(this, kVar));
        }
    }

    private ScheduledFuture<?> h(ScheduledExecutorService scheduledExecutorService, u uVar) {
        long min = 9223372036854775807L;
        TimeUnit nANOSECONDS2;
        int cmp;
        String formatted;
        String str2;
        uVar = this.c.k();
        if (uVar == null && uVar == null) {
            return null;
        }
        min = Long.MAX_VALUE;
        if (uVar != null) {
            min = Math.min(Long.MAX_VALUE, uVar.n(TimeUnit.NANOSECONDS));
        }
        int i = 0;
        int i2 = 1;
        if (uVar != null) {
            nANOSECONDS2 = TimeUnit.NANOSECONDS;
            long l4 = uVar.n(nANOSECONDS2);
            if (l4 < Long.MAX_VALUE) {
                Logger logger = z.j;
                if (logger.isLoggable(Level.FINE)) {
                    Object[] arr2 = new Object[i2];
                    str2 = "Call timeout set to '%d' ns, due to context deadline.";
                    StringBuilder stringBuilder = new StringBuilder(String.format(str2, new Object[] { Long.valueOf(uVar.n(TimeUnit.NANOSECONDS)) }));
                    if (uVar == null) {
                        formatted2 = " Explicit call timeout was not set.";
                        stringBuilder.append(formatted2);
                    } else {
                        Object[] arr3 = new Object[i2];
                        stringBuilder.append(String.format(" Explicit call timeout was '%d' ns.", new Object[] { Long.valueOf(uVar.n(TimeUnit.NANOSECONDS)) }));
                    }
                    z.j.fine(stringBuilder.toString());
                }
            }
        }
        TimeUnit sECONDS2 = TimeUnit.SECONDS;
        long l6 = 1L;
        StringBuilder stringBuilder2 = new StringBuilder();
        if (Long.MAX_VALUE < 0) {
            str = "ClientCall started after deadline exceeded. Deadline exceeded after -";
            stringBuilder2.append(str);
        } else {
            str = "Deadline exceeded after ";
            stringBuilder2.append(str);
        }
        stringBuilder2.append(Math.abs(min) / sECONDS2.toNanos(l6));
        Object[] arr = new Object[i2];
        stringBuilder2.append(String.format(Locale.US, ".%09d", new Object[] { Long.valueOf(Math.abs(min) % sECONDS2.toNanos(l6)) }));
        stringBuilder2.append("s. ");
        return scheduledExecutorService.schedule(new z.b(this, stringBuilder2), min, TimeUnit.NANOSECONDS);
    }

    private void j(h<ReqT, RespT> hVar) {
        boolean z2 = true;
        final boolean z = false;
        int r2 = this.f == null ? 1 : z;
        n.x((this.f == null ? 1 : z), "realCall already set to %s", this.f);
        if (this.a != null) {
            this.a.cancel(z);
        }
        this.f = hVar;
    }

    @Override // io.grpc.h
    public final void cancel(String str, Throwable th) {
        d1 d1Var;
        final d1 d1Var2 = d1.g;
        if (str != null) {
            d1Var = d1.g.r(str);
        } else {
            d1Var = d1.g.r("Call cancelled without message");
        }
        if (th != null) {
            d1Var = d1Var.q(th);
        }
        e(d1Var, false);
    }

    @Override // io.grpc.h
    public final a getAttributes() {
        synchronized (this) {
            try {
            } catch (Throwable th) {
            }
        }
        if (this.f != null) {
            return this.f.getAttributes();
        }
        return a.b;
    }

    @Override // io.grpc.h
    public final void halfClose() {
        f(new z.h(this));
    }

    @Override // io.grpc.h
    public final void i(h<ReqT, RespT> hVar) {
        synchronized (this) {
            try {
                if (this.f != null) {
                    return;
                }
                n.p(hVar, "call");
                j(hVar);
            } catch (Throwable th) {
            }
        }
        g();
    }

    @Override // io.grpc.h
    public final boolean isReady() {
        if (this.d) {
            return this.f.isReady();
        }
        return false;
    }

    @Override // io.grpc.h
    public final void request(int i) {
        if (this.d) {
            this.f.request(i);
        } else {
            f(new z.g(this, i));
        }
    }

    @Override // io.grpc.h
    public final void sendMessage(ReqT reqt) {
        if (this.d) {
            this.f.sendMessage(reqt);
        } else {
            f(new z.e(this, reqt));
        }
    }

    @Override // io.grpc.h
    public final void setMessageCompression(boolean z) {
        if (this.d) {
            this.f.setMessageCompression(z);
        } else {
            f(new z.f(this, z));
        }
    }

    @Override // io.grpc.h
    public final void start(h.a<RespT> aVar, t0 t0Var) {
        boolean z = false;
        io.grpc.j1.z.k kVar;
        int r0 = this.e == null ? 1 : 0;
        n.v((this.e == null ? 1 : 0), "already started");
        synchronized (this) {
            try {
                n.p(aVar, "listener");
                this.e = (h.a)aVar;
                if (!this.d) {
                    kVar = new z.k(aVar);
                    this.i = kVar;
                }
            } catch (Throwable th) {
            }
        }
        if (this.g != null) {
            this.b.execute(new z.j(this, kVar, d1Var));
            return;
        }
        if (this.d) {
            this.f.start(kVar, t0Var);
        } else {
            f(new z.a(this, kVar, t0Var));
        }
    }

    @Override // io.grpc.h
    public String toString() {
        j.b bVar = j.c(this);
        bVar.d("realCall", this.f);
        return bVar.toString();
    }

    @Override // io.grpc.h
    protected void d() {
    }
}
