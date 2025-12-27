package io.grpc.j1;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.n;
import io.grpc.d1;
import io.grpc.f1;
import io.grpc.o0;
import io.grpc.o0.b;
import io.grpc.o0.b.a;
import io.grpc.o0.d;
import io.grpc.o0.e;
import io.grpc.o0.f;
import io.grpc.o0.g;
import io.grpc.o0.h;
import io.grpc.o0.i;
import io.grpc.o0.j;
import io.grpc.q;
import io.grpc.r;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: PickFirstLoadBalancer.java */
/* loaded from: classes3.dex */
final class r1 extends o0 {

    private final o0.d b;
    private o0.h c;

    static class b {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[q.values().length];
            r1.b.a = iArr;
            try {
                iArr[q.IDLE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                r1.b.a[q.CONNECTING.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                r1.b.a[q.READY.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                r1.b.a[q.TRANSIENT_FAILURE.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    class a implements o0.j {

        final /* synthetic */ o0.h a;
        final /* synthetic */ r1 b;
        a(o0.h hVar) {
            this.b = r1Var;
            this.a = hVar;
            super();
        }

        public void a(r rVar) {
            this.b.h(this.a, rVar);
        }
    }

    private static final class c extends o0.i {

        private final o0.e a;
        c(o0.e eVar) {
            super();
            n.p(eVar, "result");
            this.a = eVar;
        }

        @Override // io.grpc.o0$i
        public o0.e a(o0.f fVar) {
            return this.a;
        }

        @Override // io.grpc.o0$i
        public String toString() {
            j.b bVar = j.b(r1.c.class);
            bVar.d("result", this.a);
            return bVar.toString();
        }
    }

    private final class d extends o0.i {

        private final o0.h a;
        private final AtomicBoolean b = new AtomicBoolean(0);
        final /* synthetic */ r1 c;
        d(o0.h hVar) {
            this.c = r1Var;
            super();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            n.p(hVar, "subchannel");
            this.a = hVar;
        }

        static /* synthetic */ o0.h c(r1.d dVar) {
            return dVar.a;
        }

        @Override // io.grpc.o0$i
        public o0.e a(o0.f fVar) {
            boolean z = false;
            if (this.b.compareAndSet(z, true)) {
                this.c.b.c().execute(new r1.d.a(this));
            }
            return o0.e.g();
        }
    }
    r1(o0.d dVar) {
        super();
        n.p(dVar, "helper");
        this.b = dVar;
    }

    static /* synthetic */ void f(r1 r1Var, o0.h hVar, r rVar) {
        r1Var.h(hVar, rVar);
    }

    static /* synthetic */ o0.d g(r1 r1Var) {
        return r1Var.b;
    }

    private void h(o0.h hVar, r rVar) {
        q tRANSIENT_FAILURE2;
        int i = 3;
        io.grpc.j1.r1.c rVar22;
        final q qVar2 = rVar.c();
        if (qVar2 == q.SHUTDOWN) {
            return;
        }
        if (rVar.c() != q.TRANSIENT_FAILURE) {
            if (rVar.c() == q.IDLE) {
                this.b.d();
            }
        }
        int i2 = r1.b.a[qVar2.ordinal()];
        i = 1;
        if (this.b != 1) {
            i = 2;
            if (this.b != 2) {
                i = 3;
                if (this.b != 3) {
                    if (this.b != 4) {
                        StringBuilder stringBuilder = new StringBuilder();
                        String str = "Unsupported state:";
                        rVar = str + qVar2;
                        throw new IllegalArgumentException(rVar);
                    } else {
                        rVar22 = new r1.c(o0.e.f(rVar.d()));
                    }
                }
                rVar22 = new r1.c(o0.e.h(hVar));
            } else {
                rVar22 = new r1.c(o0.e.g());
            }
        } else {
            io.grpc.j1.r1.d dVar3 = new r1.d(this, hVar);
        }
        this.b.e(qVar2, rVar22);
    }

    @Override // io.grpc.o0
    public void b(d1 d1Var) {
        if (this.c != null) {
            this.c.f();
            o0.h hVar = null;
            this.c = hVar;
        }
        this.b.e(q.TRANSIENT_FAILURE, new r1.c(o0.e.f(d1Var)));
    }

    @Override // io.grpc.o0
    public void c(o0.g gVar) {
        java.util.List list = gVar.a();
        if (this.c == null) {
            o0.b.a aVar2 = o0.b.c();
            aVar2.e(list);
            o0.h hVar = this.b.a(aVar2.b());
            hVar.g(new r1.a(this, hVar));
            this.c = hVar;
            this.b.e(q.CONNECTING, new r1.c(o0.e.h(hVar)));
            hVar.e();
        } else {
            this.c.h(list);
        }
    }

    @Override // io.grpc.o0
    public void d() {
        if (this.c != null) {
            this.c.e();
        }
    }

    @Override // io.grpc.o0
    public void e() {
        if (this.c != null) {
            this.c.f();
        }
    }
}
