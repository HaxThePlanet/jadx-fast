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

/* loaded from: classes3.dex */
final class r1 extends o0 {

    private final o0.d b;
    private o0.h c;

    static class b {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            r1.b.a = iArr;
            iArr[q.IDLE.ordinal()] = 1;
            r1.b.a[q.CONNECTING.ordinal()] = 2;
            r1.b.a[q.READY.ordinal()] = 3;
            r1.b.a[q.TRANSIENT_FAILURE.ordinal()] = 4;
        }
    }

    class a implements o0.j {

        final o0.h a;
        final io.grpc.j1.r1 b;
        a(io.grpc.j1.r1 r1, o0.h o0$h2) {
            this.b = r1;
            this.a = h2;
            super();
        }

        @Override // io.grpc.o0$j
        public void a(r r) {
            r1.f(this.b, this.a, r);
        }
    }

    private static final class c extends o0.i {

        private final o0.e a;
        c(o0.e o0$e) {
            super();
            n.p(e, "result");
            this.a = (o0.e)e;
        }

        @Override // io.grpc.o0$i
        public o0.e a(o0.f o0$f) {
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
        private final AtomicBoolean b;
        final io.grpc.j1.r1 c;
        d(io.grpc.j1.r1 r1, o0.h o0$h2) {
            this.c = r1;
            super();
            AtomicBoolean obj2 = new AtomicBoolean(0);
            this.b = obj2;
            n.p(h2, "subchannel");
            this.a = (o0.h)h2;
        }

        static o0.h c(io.grpc.j1.r1.d r1$d) {
            return d.a;
        }

        @Override // io.grpc.o0$i
        public o0.e a(o0.f o0$f) {
            int aVar;
            boolean obj3;
            if (this.b.compareAndSet(false, true)) {
                aVar = new r1.d.a(this);
                r1.g(this.c).c().execute(aVar);
            }
            return o0.e.g();
        }
    }
    r1(o0.d o0$d) {
        super();
        n.p(d, "helper");
        this.b = (o0.d)d;
    }

    static void f(io.grpc.j1.r1 r1, o0.h o0$h2, r r3) {
        r1.h(h2, r3);
    }

    static o0.d g(io.grpc.j1.r1 r1) {
        return r1.b;
    }

    private void h(o0.h o0$h, r r2) {
        q qVar;
        q tRANSIENT_FAILURE;
        int i;
        Object obj4;
        o0.i obj5;
        final q qVar2 = r2.c();
        if (qVar2 == q.SHUTDOWN) {
        }
        if (r2.c() != q.TRANSIENT_FAILURE) {
            if (r2.c() == q.IDLE) {
                this.b.d();
            }
        } else {
        }
        int i2 = r1.b.a[qVar2.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                    } else {
                        obj4 = new r1.c(o0.e.f(r2.d()));
                    }
                    obj5 = new StringBuilder();
                    obj5.append("Unsupported state:");
                    obj5.append(qVar2);
                    obj4 = new IllegalArgumentException(obj5.toString());
                    throw obj4;
                }
                obj5 = new r1.c(o0.e.h(h));
                obj4 = obj5;
            } else {
                obj4 = new r1.c(o0.e.g());
            }
        } else {
            obj5 = new r1.d(this, h);
        }
        this.b.e(qVar2, obj4);
    }

    @Override // io.grpc.o0
    public void b(d1 d1) {
        o0.h hVar;
        hVar = this.c;
        if (hVar != null) {
            hVar.f();
            this.c = 0;
        }
        r1.c cVar = new r1.c(o0.e.f(d1));
        this.b.e(q.TRANSIENT_FAILURE, cVar);
    }

    @Override // io.grpc.o0
    public void c(o0.g o0$g) {
        Object hVar;
        q cONNECTING;
        io.grpc.j1.r1.c cVar;
        o0.e eVar;
        Object obj5;
        obj5 = g.a();
        hVar = this.c;
        if (hVar == null) {
            o0.b.a aVar2 = o0.b.c();
            aVar2.e(obj5);
            obj5 = this.b.a(aVar2.b());
            r1.a aVar = new r1.a(this, obj5);
            obj5.g(aVar);
            this.c = obj5;
            cVar = new r1.c(o0.e.h(obj5));
            this.b.e(q.CONNECTING, cVar);
            obj5.e();
        } else {
            hVar.h(obj5);
        }
    }

    @Override // io.grpc.o0
    public void d() {
        final o0.h hVar = this.c;
        if (hVar != null) {
            hVar.e();
        }
    }

    @Override // io.grpc.o0
    public void e() {
        final o0.h hVar = this.c;
        if (hVar != null) {
            hVar.f();
        }
    }
}
