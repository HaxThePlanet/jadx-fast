package io.grpc.j1;

import com.google.common.base.n;
import i.a.c;
import io.grpc.m.b;
import io.grpc.o;
import io.grpc.v;
import java.io.InputStream;

/* loaded from: classes3.dex */
public abstract class d implements io.grpc.j1.j2 {

    public static abstract class a implements io.grpc.j1.f.h, io.grpc.j1.l1.b {

        private io.grpc.j1.y a;
        private final Object b;
        private final io.grpc.j1.o2 c;
        private final io.grpc.j1.l1 d;
        private int e;
        private boolean f;
        private boolean g;
        protected a(int i, io.grpc.j1.i2 i22, io.grpc.j1.o2 o23) {
            super();
            Object object = new Object();
            this.b = object;
            n.p(i22, "statsTraceCtx");
            n.p(o23, "transportTracer");
            this.c = (o2)o23;
            super(this, m.b.a, i, i22, o23);
            this.d = l1Var;
            this.a = l1Var;
        }

        static void f(io.grpc.j1.d.a d$a, int i2) {
            a.u(i2);
        }

        static boolean g(io.grpc.j1.d.a d$a) {
            return a.m();
        }

        static void h(io.grpc.j1.d.a d$a, int i2) {
            a.p(i2);
        }

        static io.grpc.j1.y i(io.grpc.j1.d.a d$a) {
            return a.a;
        }

        private boolean m() {
            int i;
            boolean z;
            int i2;
            final Object obj = this.b;
            synchronized (obj) {
                if (this.e < 32768) {
                    if (!this.g) {
                        try {
                            i = 1;
                            i = 0;
                            return i;
                            throw th;
                        }
                    } else {
                    }
                } else {
                }
            }
        }

        private void o() {
            Object obj;
            obj = this.b;
            synchronized (obj) {
                obj = this.b;
            }
            n().c();
        }

        private void p(int i) {
            final Object obj = this.b;
            this.e = i2 += i;
            return;
            synchronized (obj) {
                obj = this.b;
                this.e = i2 += i;
            }
        }

        private void u(int i) {
            d.a.a aVar = new d.a.a(this, c.e(), i);
            e(aVar);
        }

        @Override // io.grpc.j1.f$h
        public void a(io.grpc.j1.k2.a k2$a) {
            n().a(a);
        }

        @Override // io.grpc.j1.f$h
        protected final void j(boolean z) {
            io.grpc.j1.y obj1;
            if (z) {
                this.a.close();
            } else {
                this.a.i();
            }
        }

        @Override // io.grpc.j1.f$h
        protected final void k(io.grpc.j1.v1 v1) {
            io.grpc.j1.v1 obj2;
            try {
                this.a.k(v1);
                d(v1);
            }
        }

        @Override // io.grpc.j1.f$h
        protected io.grpc.j1.o2 l() {
            return this.c;
        }

        @Override // io.grpc.j1.f$h
        protected abstract io.grpc.j1.k2 n();

        @Override // io.grpc.j1.f$h
        public final void q(int i) {
            int i3;
            int i2;
            int obj7;
            final Object obj = this.b;
            n.v(this.f, "onStreamAllocated was not called, but it seems the stream is active");
            int i4 = this.e;
            int i6 = 32768;
            i3 = 1;
            final int i7 = 0;
            synchronized (obj) {
                i2 = i3;
                try {
                    i4 -= i;
                    this.e = i5;
                    if (i5 < i6) {
                    } else {
                    }
                    obj7 = i3;
                    obj7 = i7;
                    if (i2 == 0 && obj7 != null) {
                    } else {
                    }
                    if (obj7 != null) {
                    } else {
                    }
                    i3 = i7;
                    if (i3 != 0) {
                    }
                    o();
                    throw i;
                }
            }
        }

        @Override // io.grpc.j1.f$h
        protected void r() {
            int i2;
            int i;
            final int i3 = 1;
            i2 = n() != null ? i3 : i;
            n.u(i2);
            Object obj = this.b;
            synchronized (obj) {
                i = i3;
                n.v(i, "Already allocated");
                this.f = i3;
                o();
            }
        }

        @Override // io.grpc.j1.f$h
        protected final void s() {
            final Object obj = this.b;
            this.g = true;
            return;
            synchronized (obj) {
                obj = this.b;
                this.g = true;
            }
        }

        @Override // io.grpc.j1.f$h
        final void t() {
            this.d.E(this);
            this.a = this.d;
        }

        @Override // io.grpc.j1.f$h
        protected final void v(v v) {
            this.a.j(v);
        }

        @Override // io.grpc.j1.f$h
        protected void w(io.grpc.j1.s0 s0) {
            this.d.x(s0);
            f obj2 = new f(this, this, this.d);
            this.a = obj2;
        }

        @Override // io.grpc.j1.f$h
        final void x(int i) {
            this.a.f(i);
        }
    }
    @Override // io.grpc.j1.j2
    public boolean a() {
        if (s().isClosed()) {
            return 0;
        }
        return d.a.g(u());
    }

    @Override // io.grpc.j1.j2
    public final void b(boolean z) {
        s().b(z);
    }

    @Override // io.grpc.j1.j2
    public final void d(o o) {
        n.p(o, "compressor");
        s().d((o)o);
    }

    @Override // io.grpc.j1.j2
    public final void e(int i) {
        d.a.f(u(), i);
    }

    @Override // io.grpc.j1.j2
    public final void flush() {
        boolean closed;
        if (!s().isClosed()) {
            s().flush();
        }
    }

    @Override // io.grpc.j1.j2
    public final void n(InputStream inputStream) {
        boolean closed;
        n.p(inputStream, "message");
        if (!s().isClosed()) {
            s().e(inputStream);
        }
        r0.e(inputStream);
    }

    @Override // io.grpc.j1.j2
    public void o() {
        u().t();
    }

    @Override // io.grpc.j1.j2
    protected final void r() {
        s().close();
    }

    @Override // io.grpc.j1.j2
    protected abstract io.grpc.j1.p0 s();

    @Override // io.grpc.j1.j2
    protected final void t(int i) {
        d.a.h(u(), i);
    }

    @Override // io.grpc.j1.j2
    protected abstract io.grpc.j1.d.a u();
}
