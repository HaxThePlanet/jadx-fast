package io.grpc.j1;

import com.google.common.base.n;
import i.a.c;
import io.grpc.m.b;
import io.grpc.o;
import io.grpc.v;
import java.io.InputStream;

/* compiled from: AbstractStream.java */
/* loaded from: classes3.dex */
public abstract class d implements j2 {

    public static abstract class a implements f.h, l1.b {

        private y a;
        private final Object b = new Object();
        private final o2 c;
        private final l1 d;
        private int e;
        private boolean f;
        private boolean g;
        protected a(int i, i2 i2Var, o2 o2Var) {
            super();
            Object object = new Object();
            n.p(i2Var, "statsTraceCtx");
            n.p(o2Var, "transportTracer");
            this.c = (o2)o2Var;
            super(this, m.b.a, i, i2Var, o2Var);
            this.d = l1Var;
            this.a = l1Var;
        }

        static /* synthetic */ void f(d.a aVar, int i) {
            aVar.u(i);
        }

        static /* synthetic */ boolean g(d.a aVar) {
            return aVar.m();
        }

        static /* synthetic */ void h(d.a aVar, int i) {
            aVar.p(i);
        }

        static /* synthetic */ y i(d.a aVar) {
            return aVar.a;
        }

        private boolean m() {
            boolean z2 = false;
            int i = 32768;
            synchronized (obj2) {
                try {
                    if (this.f) {
                        i = 32768;
                        Throwable th = this.e < 32768 && !this.g ? 1 : 0;
                    }
                    return (this.e < 32768 && !this.g ? 1 : 0);
                } catch (Throwable th) {
                }
                throw (this.e < 32768 && !this.g ? 1 : 0);
            }
        }

        private void o() {
            synchronized (obj) {
                try {
                } catch (Throwable th) {
                }
            }
            if (m()) {
                n().c();
            }
        }

        private void p(int i) {
            synchronized (obj2) {
                try {
                    this.e += i;
                    return;
                } catch (Throwable th) {
                }
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) th;
            }
        }

        private void u(int i) {
            e(new d.a.a(this, c.e(), i));
        }

        public void a(k2.a aVar) {
            n().a(aVar);
        }

        protected final void j(boolean z) {
            if (z) {
                this.a.close();
            } else {
                this.a.i();
            }
        }

        protected final void k(v1 v1Var) {
            try {
                this.a.k(v1Var);
            } catch (Throwable th) {
                d(th);
            }
        }

        protected o2 l() {
            return this.c;
        }

        public final void q(int i) {
            int i2 = 1;
            synchronized (obj2) {
                try {
                    n.v(this.f, "onStreamAllocated was not called, but it seems the stream is active");
                    int i5 = 32768;
                    i2 = 1;
                    i2 = 0;
                    int r5 = i2;
                    this.e -= i;
                    i = i2;
                    if (i2 != 0 || i2 == 0) {
                    }
                } catch (Throwable th) {
                }
            }
            if (i2 != 0) {
                o();
            }
        }

        protected void r() {
            boolean z;
            boolean z2 = false;
            final boolean z3 = true;
            boolean obj = n() != null ? z3 : 0;
            n.u((n() != null ? z3 : 0));
            synchronized (obj2) {
                try {
                    if (!this.f) {
                        int i3 = z3;
                    }
                    n.v(z2, "Already allocated");
                    this.f = z3;
                } catch (Throwable th) {
                }
            }
            o();
        }

        protected final void s() {
            synchronized (obj2) {
                try {
                    this.g = true;
                    return;
                } catch (Throwable th) {
                }
                throw th;
            }
        }

        final void t() {
            this.d.E(this);
            this.a = this.d;
        }

        protected final void v(v vVar) {
            this.a.j(vVar);
        }

        protected void w(s0 s0Var) {
            this.d.x(s0Var);
            this.a = new f(this, this, this.d);
        }

        final void x(int i) {
            this.a.f(i);
        }

        protected abstract k2 n();
    }
    public boolean a() {
        if (s().isClosed()) {
            return false;
        }
        return u().m();
    }

    public final void b(boolean z) {
        s().b(z);
    }

    public final void d(o oVar) {
        n.p(oVar, "compressor");
        s().d(oVar);
    }

    public final void e(int i) {
        u().u(i);
    }

    public final void flush() {
        if (!s().isClosed()) {
            s().flush();
        }
    }

    public final void n(InputStream inputStream) {
        n.p(inputStream, "message");
        try {
            if (!s().isClosed()) {
                s().e(inputStream);
            }
        } finally {
            r0.e(inputStream);
            throw th;
        }
        r0.e(inputStream);
    }

    public void o() {
        u().t();
    }

    protected final void r() {
        s().close();
    }

    protected final void t(int i) {
        u().p(i);
    }

    protected abstract p0 s();

    protected abstract d.a u();
}
