package io.grpc.k1;

import com.google.common.base.n;
import i.a.b;
import i.a.c;
import io.grpc.j1.d2;
import java.io.IOException;
import java.net.Socket;
import l.b0;
import l.e0;
import l.f;

/* compiled from: AsyncSink.java */
/* loaded from: classes3.dex */
final class a implements b0 {

    private Socket A;
    private final Object a = new Object();
    private final f b = new f();
    private final d2 c;
    private final b.a v;
    private boolean w = false;
    private boolean x = false;
    private boolean y = false;
    private b0 z;

    class c implements Runnable {

        final /* synthetic */ a a;
        c() {
            this.a = aVar;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            io.grpc.k1.a obj2;
            this.a.b.close();
            try {
                this.a.z.close();
            } catch (java.io.IOException ioException) {
                io.grpc.k1.a aVar6 = this.a.v;
                this.a.a(ioException);
            }
            try {
                this.a.A.close();
            } catch (java.io.IOException ioException) {
                aVar6 = this.a.v;
                this.a.a(ioException);
            }
        }
    }

    private abstract class d implements Runnable {

        final /* synthetic */ a a;
        private d() {
            this.a = aVar;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() throws IOException {
            try {
                a();
                throw new IOException("Unable to perform write due to unavailable sink.");
            } catch (Exception e) {
                io.grpc.k1.a aVar2 = this.a.v;
                this.a.a(e);
            }
        }

        /* synthetic */ d(a.a aVar) {
            this(aVar);
        }

        public abstract void a();
    }

    class a extends a.d {

        final b b;
        final /* synthetic */ a c;
        a() {
            this.c = aVar;
            super(aVar, null);
            this.b = c.e();
        }

        @Override // io.grpc.k1.a$d
        public void a() {
            c.f("WriteRunnable.runWrite");
            c.d(this.b);
            f fVar = new f();
            Object obj = this.c.a;
            synchronized (obj) {
                try {
                    fVar.write(this.c.b, this.c.b.e());
                    boolean z = false;
                    this.c.w = z;
                } catch (Throwable th) {
                }
            }
            try {
                this.c.z.write(fVar, fVar.size());
            } catch (Throwable th) {
            }
            c.h("WriteRunnable.runWrite");
        }
    }

    class b extends a.d {

        final b b;
        final /* synthetic */ a c;
        b() {
            this.c = aVar;
            super(aVar, null);
            this.b = c.e();
        }

        @Override // io.grpc.k1.a$d
        public void a() {
            c.f("WriteRunnable.runFlush");
            c.d(this.b);
            f fVar = new f();
            Object obj = this.c.a;
            synchronized (obj) {
                try {
                    fVar.write(this.c.b, this.c.b.size());
                    boolean z = false;
                    this.c.x = z;
                } catch (Throwable th) {
                }
            }
            try {
                this.c.z.write(fVar, fVar.size());
                this.c.z.flush();
            } catch (Throwable th) {
            }
            c.h("WriteRunnable.runFlush");
        }
    }
    private a(d2 d2Var, b.a aVar) {
        super();
        Object object = new Object();
        f fVar = new f();
        n.p(d2Var, "executor");
        this.c = d2Var;
        n.p(aVar, "exceptionHandler");
        this.v = aVar;
    }

    static /* synthetic */ Object a(a aVar) {
        return aVar.a;
    }

    static /* synthetic */ f c(a aVar) {
        return aVar.b;
    }

    static /* synthetic */ boolean e(a aVar, boolean z) {
        aVar.w = z;
        return z;
    }

    static /* synthetic */ b0 f(a aVar) {
        return aVar.z;
    }

    static /* synthetic */ boolean i(a aVar, boolean z) {
        aVar.x = z;
        return z;
    }

    static /* synthetic */ b.a j(a aVar) {
        return aVar.v;
    }

    static /* synthetic */ Socket k(a aVar) {
        return aVar.A;
    }

    static a n(d2 d2Var, b.a aVar) {
        return new a(d2Var, aVar);
    }

    public void close() {
        if (this.y) {
            return;
        }
        this.y = true;
        this.c.execute(new a.c(this));
    }

    public void flush() {
        if (this.y) {
            throw new IOException("closed");
        } else {
            c.f("AsyncSink.flush");
            synchronized (obj) {
                try {
                } catch (Throwable th) {
                }
                try {
                    this.x = true;
                } catch (Throwable th) {
                }
                try {
                    this.c.execute(new a.b(this));
                } catch (Throwable th) {
                }
                c.h("AsyncSink.flush");
                return;
            }
            c.h("AsyncSink.flush");
            return;
        }
    }

    void m(b0 b0Var, Socket socket) {
        boolean z = true;
        int r0 = this.z == null ? 1 : 0;
        n.v((this.z == null ? 1 : 0), "AsyncSink's becomeConnected should only be called once.");
        n.p(b0Var, (this.z == null ? 1 : 0));
        this.z = b0Var;
        n.p(socket, "socket");
        this.A = socket;
    }

    public e0 timeout() {
        return e0.NONE;
    }

    public void write(f fVar, long j) {
        n.p(fVar, "source");
        if (this.y) {
            throw new IOException("closed");
        } else {
            c.f("AsyncSink.write");
            synchronized (obj2) {
                try {
                    this.b.write(fVar, j);
                    long l2 = this.b.e();
                    long l = 0L;
                    this.w = true;
                } catch (Throwable th) {
                }
                try {
                } catch (Throwable th) {
                }
                c.h("AsyncSink.write");
                return;
            }
            try {
                this.c.execute(new a.a(this));
            } catch (Throwable th) {
            }
            c.h("AsyncSink.write");
            return;
        }
    }
}
