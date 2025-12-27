package io.grpc.j1;

import io.grpc.d;
import io.grpc.d1;
import io.grpc.e1;
import io.grpc.f1;
import io.grpc.i0;
import io.grpc.l;
import io.grpc.o0.f;
import io.grpc.o0.i;
import io.grpc.s;
import io.grpc.t0;
import io.grpc.u0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;

/* compiled from: DelayedClientTransport.java */
/* loaded from: classes3.dex */
final class a0 implements k1 {

    private final i0 a;
    private final Object b = new Object();
    private final Executor c;
    private final f1 d;
    private Runnable e;
    private Runnable f;
    private Runnable g;
    private k1.a h;
    private Collection<a0.e> i = new LinkedHashSet<>();
    private d1 j;
    private o0.i k;
    private long l;

    class a implements Runnable {

        final /* synthetic */ k1.a a;
        a(k1.a aVar) {
            this.a = aVar;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.d(true);
        }
    }

    class b implements Runnable {

        final /* synthetic */ k1.a a;
        b(k1.a aVar) {
            this.a = aVar;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.d(false);
        }
    }

    class c implements Runnable {

        final /* synthetic */ k1.a a;
        c(k1.a aVar) {
            this.a = aVar;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.c();
        }
    }

    class d implements Runnable {

        final /* synthetic */ d1 a;
        final /* synthetic */ a0 b;
        d(d1 d1Var) {
            this.b = a0Var;
            this.a = d1Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.h.a(this.a);
        }
    }

    private class e extends b0 {

        private final o0.f j;
        private final s k;
        private final l[] l;
        final /* synthetic */ a0 m;
        /* synthetic */ e(o0.f fVar, l[] lVarArr, a0.a aVar) {
            this(a0Var, fVar, lVarArr);
        }

        static /* synthetic */ Runnable A(a0.e eVar, s sVar) {
            return eVar.B(sVar);
        }

        private Runnable B(s sVar) {
            try {
            } finally {
                this.k.j(sVar2);
                throw sVar;
            }
            this.k.j(this.k.c());
            return x(sVar.b(this.j.c(), this.j.b(), this.j.a(), this.l));
        }

        static /* synthetic */ l[] y(a0.e eVar) {
            return eVar.l;
        }

        static /* synthetic */ o0.f z(a0.e eVar) {
            return eVar.j;
        }

        @Override // io.grpc.j1.b0
        public void c(d1 d1Var) {
            super.c(d1Var);
            Object obj = this.m.b;
            synchronized (obj) {
                try {
                    if (this.m.g != null && !this.m.q() && a0.l(this.m).remove(this) && a0.h(this.m) != null) {
                        this.m.d.b(this.m.g);
                        this.m.g = null;
                    }
                } catch (Throwable th) {
                }
            }
            this.m.d.a();
        }

        @Override // io.grpc.j1.b0
        public void j(x0 x0Var) {
            if (this.j.a().j()) {
                x0Var.a("wait_for_ready");
            }
            super.j(x0Var);
        }

        @Override // io.grpc.j1.b0
        protected void v(d1 d1Var) {
            int i = 0;
            i = 0;
            for (l lVar : objArr) {
                lVar.i(d1Var);
            }
        }

        private e(o0.f fVar, l[] lVarArr) {
            this.m = a0Var;
            super();
            this.k = s.i();
            this.j = fVar;
            this.l = lVarArr;
        }
    }
    a0(Executor executor, f1 f1Var) {
        super();
        this.a = i0.a(a0.class, null);
        Object object = new Object();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.c = executor;
        this.d = f1Var;
    }

    static /* synthetic */ k1.a a(a0 a0Var) {
        return a0Var.h;
    }

    static /* synthetic */ d1 h(a0 a0Var) {
        return a0Var.j;
    }

    static /* synthetic */ Object i(a0 a0Var) {
        return a0Var.b;
    }

    static /* synthetic */ Runnable j(a0 a0Var) {
        return a0Var.g;
    }

    static /* synthetic */ Runnable k(a0 a0Var, Runnable runnable) {
        a0Var.g = runnable;
        return runnable;
    }

    static /* synthetic */ Collection l(a0 a0Var) {
        return a0Var.i;
    }

    static /* synthetic */ Runnable m(a0 a0Var) {
        return a0Var.f;
    }

    static /* synthetic */ f1 n(a0 a0Var) {
        return a0Var.d;
    }

    private a0.e o(o0.f fVar, l[] lVarArr) {
        final io.grpc.j1.a0.e eVar = new a0.e(this, fVar, lVarArr, null);
        this.i.add(eVar);
        int i2 = 1;
        if (p() == 1) {
            this.d.b(this.e);
        }
        return eVar;
    }

    public final q b(u0<?, ?> u0Var, t0 t0Var, d dVar, l[] lVarArr) {
        int i = -1;
        long l;
        int cmp = 0;
        io.grpc.j1.f0 f0Var;
        try {
            io.grpc.j1.t1 t1Var = new t1(u0Var, t0Var, dVar);
            cmp = 0;
            i = -1;
        } catch (Throwable th) {
        }
        try {
            f0Var = new f0(this.j, lVarArr);
        } catch (Throwable th) {
        }
        try {
            Object obj4 = o(t1Var, lVarArr);
            Object obj5 = o(t1Var, lVarArr);
        } catch (Throwable th) {
        }
        this.d.a();
        return f0Var;
    }

    public final void c(d1 d1Var) {
        synchronized (obj2) {
            try {
                if (this.j != null) {
                    return;
                }
                this.j = d1Var;
                this.d.b(new a0.d(this, d1Var));
                if (!q() && this.g != null) {
                    this.d.b(this.g);
                    this.g = null;
                }
            } catch (Throwable th) {
            }
        }
        this.d.a();
    }

    public final void d(d1 d1Var) {
        boolean empty;
        io.grpc.j1.r.a rEFUSED2;
        l[] objArr;
        c(d1Var);
        synchronized (obj) {
            try {
                this.g = null;
                if (!this.i.isEmpty()) {
                    this.i = Collections.emptyList();
                }
            } catch (Throwable th) {
            }
        }
        if (this.g != null) {
            Iterator it = this.i.iterator();
            while (it.hasNext()) {
                Object item = it.next();
                Object obj3 = item.x(new f0(th, r.a.REFUSED, item.l));
            }
            this.d.execute(this.g);
        }
    }

    public final Runnable e(k1.a aVar) {
        this.h = aVar;
        this.e = new a0.a(this, aVar);
        this.f = new a0.b(this, aVar);
        this.g = new a0.c(this, aVar);
        return null;
    }

    public i0 f() {
        return this.a;
    }

    final int p() {
        synchronized (obj2) {
            try {
                return this.i.size();
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    public final boolean q() {
        boolean z = false;
        synchronized (obj2) {
            try {
                Throwable th = !this.i.isEmpty() ? 1 : 0;
                return (!this.i.isEmpty() ? 1 : 0);
            } catch (Throwable th) {
            }
            throw (!this.i.isEmpty() ? 1 : 0);
        }
    }

    final void r(o0.i iVar) {
        boolean z2;
        Executor executor;
        synchronized (obj) {
            try {
                this.k = iVar;
                long l2 = 1L;
                this.l += l2;
            } catch (Throwable th) {
            }
            try {
                return;
            } catch (Throwable th) {
            }
            try {
            } catch (Throwable th) {
            }
            throw th;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = new ArrayList(this.i).iterator();
        while (it.hasNext()) {
            Collection item = it.next();
            d dVar = item.j.a();
            io.grpc.j1.s sVar = r0.j(iVar.a(item.j), dVar.j());
        }
        synchronized (obj2) {
            try {
                if (!q()) {
                    return;
                }
                this.i.removeAll(arrayList);
                if (this.i.isEmpty()) {
                    this.i = new LinkedHashSet();
                }
                if (!q() && this.j != null && this.g != null) {
                    this.d.b(this.g);
                    this.g = null;
                }
            } catch (Throwable th) {
            }
        }
        this.d.a();
    }
}
