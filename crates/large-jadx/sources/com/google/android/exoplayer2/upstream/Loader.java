package com.google.android.exoplayer2.upstream;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.n0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public final class Loader {

    public static final com.google.android.exoplayer2.upstream.Loader.c d;
    public static final com.google.android.exoplayer2.upstream.Loader.c e;
    public static final com.google.android.exoplayer2.upstream.Loader.c f;
    private final ExecutorService a;
    private com.google.android.exoplayer2.upstream.Loader.d<? extends com.google.android.exoplayer2.upstream.Loader.e> b;
    private IOException c;

    public static final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Throwable throwable) {
            String simpleName = throwable.getClass().getSimpleName();
            final String message = throwable.getMessage();
            StringBuilder stringBuilder = new StringBuilder(i += length2);
            stringBuilder.append("Unexpected ");
            stringBuilder.append(simpleName);
            stringBuilder.append(": ");
            stringBuilder.append(message);
            super(stringBuilder.toString(), throwable);
        }
    }

    static class a {
    }

    public interface b {
        public abstract void h(T t, long l2, long l3, boolean z4);

        public abstract void j(T t, long l2, long l3);

        public abstract com.google.android.exoplayer2.upstream.Loader.c s(T t, long l2, long l3, IOException iOException4, int i5);
    }

    public static final class c {

        private final int a;
        private final long b;
        private c(int i, long l2) {
            super();
            this.a = i;
            this.b = l2;
        }

        c(int i, long l2, com.google.android.exoplayer2.upstream.Loader.a loader$a3) {
            super(i, l2, a3);
        }

        static int a(com.google.android.exoplayer2.upstream.Loader.c loader$c) {
            return c.a;
        }

        static long b(com.google.android.exoplayer2.upstream.Loader.c loader$c) {
            return c.b;
        }

        public boolean c() {
            int i;
            final int i2 = this.a;
            if (i2 != 0) {
                if (i2 == 1) {
                } else {
                    i = 0;
                }
            }
            return i;
        }
    }

    private final class d extends Handler implements Runnable {

        private volatile boolean A;
        final com.google.android.exoplayer2.upstream.Loader B;
        public final int a;
        private final T b;
        private final long c;
        private com.google.android.exoplayer2.upstream.Loader.b<T> v;
        private IOException w;
        private int x;
        private Thread y;
        private boolean z;
        public d(com.google.android.exoplayer2.upstream.Loader loader, Looper looper2, com.google.android.exoplayer2.upstream.Loader.e loader$e3, com.google.android.exoplayer2.upstream.Loader.b loader$b4, int i5, long l6) {
            this.B = loader;
            super(looper2);
            this.b = e3;
            this.v = b4;
            this.a = i5;
            this.c = l6;
        }

        private void b() {
            this.w = 0;
            com.google.android.exoplayer2.upstream.Loader.d dVar = Loader.a(this.B);
            g.e(dVar);
            Loader.d(this.B).execute((Runnable)dVar);
        }

        private void c() {
            Loader.b(this.B, 0);
        }

        private long d() {
            return (long)i4;
        }

        @Override // android.os.Handler
        public void a(boolean z) {
            Thread i3;
            boolean messages;
            int elapsedRealtime;
            int i;
            int i2;
            boolean obj9;
            this.A = z;
            final int i4 = 0;
            this.w = i4;
            i3 = 0;
            elapsedRealtime = 1;
            if (hasMessages(i3)) {
                this.z = elapsedRealtime;
                removeMessages(i3);
                if (!z) {
                    sendEmptyMessage(elapsedRealtime);
                }
            } else {
                this.z = elapsedRealtime;
                this.b.b();
                i3 = this.y;
                synchronized (this) {
                    i3.interrupt();
                }
            }
            if (z) {
                c();
                elapsedRealtime = SystemClock.elapsedRealtime();
                obj9 = this.v;
                g.e(obj9);
                (Loader.b)obj9.h(this.b, elapsedRealtime, obj4, elapsedRealtime - l);
                this.v = i4;
            }
        }

        @Override // android.os.Handler
        public void e(int i) {
            int i2;
            final IOException exc = this.w;
            if (exc != null) {
                if (this.x > i) {
                } else {
                }
                throw exc;
            }
        }

        @Override // android.os.Handler
        public void f(long l) {
            int i;
            final int i2 = 0;
            i = Loader.a(this.B) == null ? 1 : i2;
            g.f(i);
            Loader.b(this.B, this);
            if (Long.compare(l, i3) > 0) {
                sendEmptyMessageDelayed(i2, l);
            } else {
                b();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int what;
            int i;
            com.google.android.exoplayer2.upstream.Loader.b bVar;
            com.google.android.exoplayer2.upstream.Loader.e eVar;
            Object obj;
            int i3;
            int i2;
            Object obj13;
            if (this.A) {
            }
            int what2 = message.what;
            if (what2 == 0) {
                b();
            }
            i = 3;
            if (what2 == i) {
            } else {
                c();
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                final int i6 = elapsedRealtime - l2;
                com.google.android.exoplayer2.upstream.Loader.b bVar2 = this.v;
                g.e(bVar2);
                bVar = bVar2;
                if (this.z) {
                    (Loader.b)bVar.h(this.b, elapsedRealtime, obj5, i6);
                }
                what = message.what;
                final int i8 = 1;
                if (what != i8) {
                    i2 = 2;
                    if (what != i2) {
                    } else {
                        obj = obj13;
                        this.w = (IOException)obj;
                        i3 = obj13 + 1;
                        this.x = i3;
                        obj13 = bVar.s(this.b, elapsedRealtime, obj5, i6, obj7);
                        if (Loader.c.a(obj13) == i) {
                            Loader.c(this.B, this.w);
                        } else {
                            if (Loader.c.a(obj13) != i2 && Loader.c.a(obj13) == i8) {
                                if (Loader.c.a(obj13) == i8) {
                                    this.x = i8;
                                }
                                if (Long.compare(l, bVar) != 0) {
                                    what = Loader.c.b(obj13);
                                } else {
                                    what = d();
                                }
                                f(what);
                            }
                        }
                    }
                } else {
                    bVar.j(this.b, elapsedRealtime, obj5);
                }
            }
            throw (Error)message.obj;
        }

        @Override // android.os.Handler
        public void run() {
            int i;
            Throwable th;
            int i3;
            boolean z;
            String concat;
            String str;
            int i2;
            Object currentThread;
            int length;
            i = 2;
            i2 = 1;
            synchronized (this) {
                try {
                    i3 = i2;
                } catch (Throwable th) {
                }
                this.y = Thread.currentThread();
                if (i3 != 0) {
                }
                this.y = 0;
                Thread.interrupted();
                synchronized (this) {
                    this.y = 0;
                    Thread.interrupted();
                }
                sendEmptyMessage(i2);
            }
            String str2 = "load:";
            currentThread = String.valueOf(this.b.getClass().getSimpleName());
            if (currentThread.length() != 0) {
                concat = str2.concat(currentThread);
            } else {
                currentThread = new String(str2);
                concat = currentThread;
            }
            n0.a(concat);
            this.b.a();
            n0.c();
        }
    }

    public interface e {
        public abstract void a();

        public abstract void b();
    }

    public interface f {
        public abstract void g();
    }

    private static final class g implements Runnable {

        private final com.google.android.exoplayer2.upstream.Loader.f a;
        public g(com.google.android.exoplayer2.upstream.Loader.f loader$f) {
            super();
            this.a = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.g();
        }
    }
    static {
        final long l = -9223372036854775807L;
        Loader.d = Loader.g(false, l);
        Loader.g(true, l);
        final int i5 = 0;
        Loader.c cVar2 = new Loader.c(2, l, obj2, i5);
        Loader.e = cVar2;
        Loader.c cVar3 = new Loader.c(3, l, obj2, i5);
        Loader.f = cVar3;
    }

    public Loader(String string) {
        String obj3;
        super();
        obj3 = String.valueOf(string);
        final String str = "ExoPlayer:Loader:";
        if (obj3.length() != 0) {
            obj3 = str.concat(obj3);
        } else {
            obj3 = new String(str);
        }
        this.a = p0.o0(obj3);
    }

    static com.google.android.exoplayer2.upstream.Loader.d a(com.google.android.exoplayer2.upstream.Loader loader) {
        return loader.b;
    }

    static com.google.android.exoplayer2.upstream.Loader.d b(com.google.android.exoplayer2.upstream.Loader loader, com.google.android.exoplayer2.upstream.Loader.d loader$d2) {
        loader.b = d2;
        return d2;
    }

    static IOException c(com.google.android.exoplayer2.upstream.Loader loader, IOException iOException2) {
        loader.c = iOException2;
        return iOException2;
    }

    static ExecutorService d(com.google.android.exoplayer2.upstream.Loader loader) {
        return loader.a;
    }

    public static com.google.android.exoplayer2.upstream.Loader.c g(boolean z, long l2) {
        Loader.c cVar = new Loader.c(z, l2, obj4, 0);
        return cVar;
    }

    public void e() {
        final com.google.android.exoplayer2.upstream.Loader.d dVar = this.b;
        g.h(dVar);
        (Loader.d)dVar.a(false);
    }

    public void f() {
        this.c = 0;
    }

    public boolean h() {
        int i;
        i = this.c != null ? 1 : 0;
        return i;
    }

    public boolean i() {
        int i;
        i = this.b != null ? 1 : 0;
        return i;
    }

    public void j() {
        k(Integer.MIN_VALUE);
    }

    public void k(int i) {
        int i2;
        int obj3;
        IOException exc = this.c;
        if (exc != null) {
        } else {
            com.google.android.exoplayer2.upstream.Loader.d dVar = this.b;
            if (dVar != null && i == Integer.MIN_VALUE) {
                if (i == Integer.MIN_VALUE) {
                    obj3 = dVar.a;
                }
                dVar.e(obj3);
            }
        }
        throw exc;
    }

    public void l() {
        m(0);
    }

    public void m(com.google.android.exoplayer2.upstream.Loader.f loader$f) {
        Object dVar;
        int gVar;
        dVar = this.b;
        if (dVar != null) {
            dVar.a(true);
        }
        if (f != null) {
            gVar = new Loader.g(f);
            this.a.execute(gVar);
        }
        this.a.shutdown();
    }

    public <T extends com.google.android.exoplayer2.upstream.Loader.e> long n(T t, com.google.android.exoplayer2.upstream.Loader.b<T> loader$b2, int i3) {
        Looper myLooper = Looper.myLooper();
        g.h(myLooper);
        this.c = 0;
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        super(this, (Looper)myLooper, t, b2, i3, elapsedRealtime, obj8);
        dVar.f(0);
        return elapsedRealtime;
    }
}
