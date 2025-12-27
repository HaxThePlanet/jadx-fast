package io.grpc.j1;

import com.google.common.base.q;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Http2Ping.java */
/* loaded from: classes3.dex */
public class v0 {

    private static final Logger g;
    private final long a;
    private final q b;
    private Map<s.a, Executor> c = new LinkedHashMap<>();
    private boolean d;
    private Throwable e;
    private long f;

    class a implements Runnable {

        final /* synthetic */ s.a a;
        final /* synthetic */ long b;
        a(s.a aVar, long j) {
            this.a = aVar;
            this.b = j;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.b(this.b);
        }
    }

    class b implements Runnable {

        final /* synthetic */ s.a a;
        final /* synthetic */ Throwable b;
        b(s.a aVar, Throwable th) {
            this.a = aVar;
            this.b = th;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.b);
        }
    }
    static {
        v0.g = Logger.getLogger(v0.class.getName());
    }

    public v0(long j, q qVar) {
        super();
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.a = j;
        this.b = qVar;
    }

    private static Runnable b(s.a aVar, long j) {
        return new v0.a(aVar, j, r3);
    }

    private static Runnable c(s.a aVar, Throwable th) {
        return new v0.b(aVar, th);
    }

    private static void e(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (Throwable th) {
            runnable = v0.g;
            runnable.log(Level.SEVERE, "Failed to execute PingCallback", th);
        }
    }

    public static void g(s.a aVar, Executor executor, Throwable th) {
        v0.e(executor, v0.c(aVar, th));
    }

    public void a(s.a aVar, Executor executor) {
        Runnable runnable;
        synchronized (this) {
            try {
                if (!this.d) {
                    this.c.put(aVar, executor);
                    return;
                }
                if (this.e != null) {
                    runnable = v0.c(aVar, this.e);
                } else {
                    runnable = v0.b(aVar, this.f);
                }
            } catch (Throwable th) {
            }
        }
        v0.e(executor, runnable);
    }

    public boolean d() {
        synchronized (this) {
            try {
                if (this.d) {
                    return false;
                }
            } catch (Throwable th) {
            }
        }
        Iterator it = map2.entrySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            v0.e((Executor)item.getValue(), v0.b((s.a)item.getKey(), l));
        }
        return true;
    }

    public void f(Throwable th) {
        synchronized (this) {
            try {
                if (this.d) {
                    return;
                }
            } catch (Throwable th) {
            }
        }
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            v0.g((s.a)item.getKey(), (Executor)item.getValue(), th);
        }
    }

    public long h() {
        return this.a;
    }
}
