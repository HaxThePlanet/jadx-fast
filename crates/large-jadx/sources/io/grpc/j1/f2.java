package io.grpc.j1;

import com.google.common.base.n;
import java.util.IdentityHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class f2 {

    private static final io.grpc.j1.f2 d;
    private final IdentityHashMap<io.grpc.j1.f2.d<?>, io.grpc.j1.f2.c> a;
    private final io.grpc.j1.f2.e b;
    private ScheduledExecutorService c;

    class b implements Runnable {

        final io.grpc.j1.f2.c a;
        final io.grpc.j1.f2.d b;
        final Object c;
        final io.grpc.j1.f2 v;
        b(io.grpc.j1.f2 f2, io.grpc.j1.f2.c f2$c2, io.grpc.j1.f2.d f2$d3, Object object4) {
            this.v = f2;
            this.a = c2;
            this.b = d3;
            this.c = object4;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            Throwable empty;
            io.grpc.j1.f2 f2Var;
            io.grpc.j1.f2.d dVar;
            final io.grpc.j1.f2 f2Var2 = this.v;
            synchronized (f2Var2) {
                this.b.b(this.c);
                f2.a(this.v).remove(this.b);
                if (f2.a(this.v).isEmpty()) {
                    f2.b(this.v).shutdown();
                    f2.c(this.v, 0);
                }
            }
        }
    }

    private static class c {

        final Object a;
        int b;
        ScheduledFuture<?> c;
        c(Object object) {
            super();
            this.a = object;
        }
    }

    public interface d {
        public abstract T a();

        public abstract void b(T t);
    }

    interface e {
        public abstract ScheduledExecutorService a();
    }

    class a implements io.grpc.j1.f2.e {
        @Override // io.grpc.j1.f2$e
        public ScheduledExecutorService a() {
            return Executors.newSingleThreadScheduledExecutor(r0.i("grpc-shared-destroyer-%d", true));
        }
    }
    static {
        f2.a aVar = new f2.a();
        f2 f2Var = new f2(aVar);
        f2.d = f2Var;
    }

    f2(io.grpc.j1.f2.e f2$e) {
        super();
        IdentityHashMap identityHashMap = new IdentityHashMap();
        this.a = identityHashMap;
        this.b = e;
    }

    static IdentityHashMap a(io.grpc.j1.f2 f2) {
        return f2.a;
    }

    static ScheduledExecutorService b(io.grpc.j1.f2 f2) {
        return f2.c;
    }

    static ScheduledExecutorService c(io.grpc.j1.f2 f2, ScheduledExecutorService scheduledExecutorService2) {
        f2.c = scheduledExecutorService2;
        return scheduledExecutorService2;
    }

    public static <T> T d(io.grpc.j1.f2.d<T> f2$d) {
        return f2.d.e(d);
    }

    public static <T> T f(io.grpc.j1.f2.d<T> f2$d, T t2) {
        return f2.d.g(d, t2);
    }

    <T> T e(io.grpc.j1.f2.d<T> f2$d) {
        Object cVar;
        IdentityHashMap map;
        ScheduledFuture obj3;
        synchronized (this) {
            try {
                cVar = new f2.c(d.a());
                this.a.put(d, cVar);
                obj3 = cVar.c;
                if (obj3 != null) {
                }
                obj3.cancel(false);
                cVar.c = 0;
                cVar.b = obj3++;
                return cVar.a;
                throw d;
            }
        }
    }

    <T> T g(io.grpc.j1.f2.d<T> f2$d, T t2) {
        int i3;
        int i;
        int i2;
        ScheduledExecutorService service;
        int d1Var;
        int sECONDS;
        Object obj6;
        Object obj = this.a.get(d);
        synchronized (this) {
            try {
                d1Var = 0;
                sECONDS = 1;
                if (t2 == obj.a) {
                } else {
                }
                i3 = sECONDS;
                i3 = d1Var;
                n.e(i3, "Releasing the wrong instance");
                if (obj.b > 0) {
                } else {
                }
                i = sECONDS;
                i = d1Var;
                n.v(i, "Refcount has already reached zero");
                i5 -= sECONDS;
                obj.b = i2;
                if (i2 == 0 && obj.c == null) {
                }
                if (obj.c == null) {
                }
                d1Var = sECONDS;
                n.v(d1Var, "Destroy task already scheduled");
                if (this.c == null) {
                }
                this.c = this.b.a();
                f2.b bVar = new f2.b(this, (f2.c)obj, d, t2);
                d1Var = new d1(bVar);
                obj.c = this.c.schedule(d1Var, 1, t2);
                return 0;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("No cached instance found for ");
                stringBuilder.append(d);
                IllegalArgumentException obj7 = new IllegalArgumentException(stringBuilder.toString());
                throw obj7;
                throw d;
            }
        }
    }
}
