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

/* loaded from: classes3.dex */
public class v0 {

    private static final Logger g;
    private final long a;
    private final q b;
    private Map<io.grpc.j1.s.a, Executor> c;
    private boolean d;
    private Throwable e;
    private long f;

    class a implements Runnable {

        final io.grpc.j1.s.a a;
        final long b;
        a(io.grpc.j1.s.a s$a, long l2) {
            this.a = a;
            this.b = l2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.b(this.b);
        }
    }

    class b implements Runnable {

        final io.grpc.j1.s.a a;
        final Throwable b;
        b(io.grpc.j1.s.a s$a, Throwable throwable2) {
            this.a = a;
            this.b = throwable2;
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

    public v0(long l, q q2) {
        super();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.c = linkedHashMap;
        this.a = l;
        this.b = obj4;
    }

    private static Runnable b(io.grpc.j1.s.a s$a, long l2) {
        v0.a aVar = new v0.a(a, l2, obj3);
        return aVar;
    }

    private static Runnable c(io.grpc.j1.s.a s$a, Throwable throwable2) {
        v0.b bVar = new v0.b(a, throwable2);
        return bVar;
    }

    private static void e(Executor executor, Runnable runnable2) {
        Level sEVERE;
        String str;
        Throwable obj2;
        Runnable obj3;
        try {
            executor.execute(runnable2);
            runnable2 = v0.g;
            runnable2.log(Level.SEVERE, "Failed to execute PingCallback", executor);
        }
    }

    public static void g(io.grpc.j1.s.a s$a, Executor executor2, Throwable throwable3) {
        v0.e(executor2, v0.c(a, throwable3));
    }

    public void a(io.grpc.j1.s.a s$a, Executor executor2) {
        Throwable th;
        Runnable obj3;
        synchronized (this) {
            try {
                this.c.put(a, executor2);
                th = this.e;
                if (th != null) {
                } else {
                }
                obj3 = v0.c(a, th);
                obj3 = v0.b(a, this.f);
                v0.e(executor2, obj3);
                throw a;
            }
        }
    }

    public boolean d() {
        int i;
        Object value;
        synchronized (this) {
            try {
                return 0;
                int i3 = 1;
                this.d = i3;
                final TimeUnit nANOSECONDS = TimeUnit.NANOSECONDS;
                long l = this.b.d(nANOSECONDS);
                this.f = l;
                this.c = 0;
                Iterator iterator = this.c.entrySet().iterator();
                for (Map.Entry next2 : iterator) {
                    v0.e((Executor)next2.getValue(), v0.b((s.a)next2.getKey(), l));
                }
                Object next2 = iterator.next();
                v0.e((Executor)(Map.Entry)next2.getValue(), v0.b((s.a)next2.getKey(), l));
                return i3;
                throw th;
            }
        }
    }

    public void f(Throwable throwable) {
        int value;
        Object key;
        synchronized (this) {
            try {
                this.d = true;
                this.e = throwable;
                this.c = 0;
                Iterator iterator = this.c.entrySet().iterator();
                for (Map.Entry next2 : iterator) {
                    v0.g((s.a)next2.getKey(), (Executor)next2.getValue(), throwable);
                }
                Object next2 = iterator.next();
                v0.g((s.a)(Map.Entry)next2.getKey(), (Executor)next2.getValue(), throwable);
                throw throwable;
            }
        }
    }

    public long h() {
        return this.a;
    }
}
