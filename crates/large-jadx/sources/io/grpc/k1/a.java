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

/* loaded from: classes3.dex */
final class a implements b0 {

    private Socket A;
    private final Object a;
    private final f b;
    private final d2 c;
    private final io.grpc.k1.b.a v;
    private boolean w = false;
    private boolean x = false;
    private boolean y = false;
    private b0 z;

    class c implements Runnable {

        final io.grpc.k1.a a;
        c(io.grpc.k1.a a) {
            this.a = a;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            b0 b0Var;
            Socket socket;
            io.grpc.k1.a aVar;
            a.c(this.a).close();
            if (a.f(this.a) != null) {
                a.f(this.a).close();
            }
            if (a.k(this.a) != null) {
                a.k(this.a).close();
            }
        }
    }

    private abstract class d implements Runnable {

        final io.grpc.k1.a a;
        private d(io.grpc.k1.a a) {
            this.a = a;
            super();
        }

        d(io.grpc.k1.a a, io.grpc.k1.a.a a$a2) {
            super(a);
        }

        @Override // java.lang.Runnable
        public abstract void a();

        @Override // java.lang.Runnable
        public final void run() {
            b0 b0Var;
            io.grpc.k1.a aVar;
            try {
                if (a.f(this.a) == null) {
                } else {
                }
                a();
                IOException iOException = new IOException("Unable to perform write due to unavailable sink.");
                throw iOException;
                aVar = this.a;
                aVar = a.j(aVar);
                aVar.a(th);
            }
        }
    }

    class a extends io.grpc.k1.a.d {

        final b b;
        final io.grpc.k1.a c;
        a(io.grpc.k1.a a) {
            this.c = a;
            super(a, 0);
            this.b = c.e();
        }

        @Override // io.grpc.k1.a$d
        public void a() {
            c.f("WriteRunnable.runWrite");
            c.d(this.b);
            f fVar = new f();
            Object obj = a.a(this.c);
            fVar.write(a.c(this.c), a.c(this.c).e());
            int i = 0;
            a.e(this.c, i);
            a.f(this.c).write(fVar, fVar.size());
            c.h("WriteRunnable.runWrite");
            return;
            synchronized (obj) {
                c.f("WriteRunnable.runWrite");
                c.d(this.b);
                fVar = new f();
                obj = a.a(this.c);
                fVar.write(a.c(this.c), a.c(this.c).e());
                i = 0;
                a.e(this.c, i);
                a.f(this.c).write(fVar, fVar.size());
                c.h("WriteRunnable.runWrite");
            }
        }
    }

    class b extends io.grpc.k1.a.d {

        final b b;
        final io.grpc.k1.a c;
        b(io.grpc.k1.a a) {
            this.c = a;
            super(a, 0);
            this.b = c.e();
        }

        @Override // io.grpc.k1.a$d
        public void a() {
            c.f("WriteRunnable.runFlush");
            c.d(this.b);
            f fVar = new f();
            Object obj = a.a(this.c);
            fVar.write(a.c(this.c), a.c(this.c).size());
            int i = 0;
            a.i(this.c, i);
            a.f(this.c).write(fVar, fVar.size());
            a.f(this.c).flush();
            c.h("WriteRunnable.runFlush");
            return;
            synchronized (obj) {
                c.f("WriteRunnable.runFlush");
                c.d(this.b);
                fVar = new f();
                obj = a.a(this.c);
                fVar.write(a.c(this.c), a.c(this.c).size());
                i = 0;
                a.i(this.c, i);
                a.f(this.c).write(fVar, fVar.size());
                a.f(this.c).flush();
                c.h("WriteRunnable.runFlush");
            }
        }
    }
    private a(d2 d2, io.grpc.k1.b.a b$a2) {
        super();
        Object object = new Object();
        this.a = object;
        f fVar = new f();
        this.b = fVar;
        int i = 0;
        n.p(d2, "executor");
        this.c = (d2)d2;
        n.p(a2, "exceptionHandler");
        this.v = (b.a)a2;
    }

    static Object a(io.grpc.k1.a a) {
        return a.a;
    }

    static f c(io.grpc.k1.a a) {
        return a.b;
    }

    static boolean e(io.grpc.k1.a a, boolean z2) {
        a.w = z2;
        return z2;
    }

    static b0 f(io.grpc.k1.a a) {
        return a.z;
    }

    static boolean i(io.grpc.k1.a a, boolean z2) {
        a.x = z2;
        return z2;
    }

    static io.grpc.k1.b.a j(io.grpc.k1.a a) {
        return a.v;
    }

    static Socket k(io.grpc.k1.a a) {
        return a.A;
    }

    static io.grpc.k1.a n(d2 d2, io.grpc.k1.b.a b$a2) {
        a aVar = new a(d2, a2);
        return aVar;
    }

    @Override // l.b0
    public void close() {
        if (this.y) {
        }
        this.y = true;
        a.c cVar = new a.c(this);
        this.c.execute(cVar);
    }

    @Override // l.b0
    public void flush() {
        if (this.y) {
        } else {
            c.f("AsyncSink.flush");
            Object obj = this.a;
            synchronized (obj) {
                c.h("AsyncSink.flush");
            }
        }
        IOException iOException = new IOException("closed");
        throw iOException;
    }

    @Override // l.b0
    void m(b0 b0, Socket socket2) {
        int i;
        i = this.z == null ? 1 : 0;
        n.v(i, "AsyncSink's becomeConnected should only be called once.");
        n.p(b0, "sink");
        this.z = (b0)b0;
        n.p(socket2, "socket");
        this.A = (Socket)socket2;
    }

    @Override // l.b0
    public e0 timeout() {
        return e0.NONE;
    }

    @Override // l.b0
    public void write(f f, long l2) {
        f fVar;
        boolean obj4;
        n.p(f, "source");
        if (this.y) {
        } else {
            c.f("AsyncSink.write");
            Object obj = this.a;
            this.b.write(f, l2);
            synchronized (obj) {
                if (!this.x) {
                    if (Long.compare(obj4, fVar) <= 0) {
                    }
                    this.w = true;
                    a.a obj5 = new a.a(this);
                    this.c.execute(obj5);
                    c.h("AsyncSink.write");
                }
                c.h("AsyncSink.write");
            }
        }
        obj4 = new IOException("closed");
        throw obj4;
    }
}
