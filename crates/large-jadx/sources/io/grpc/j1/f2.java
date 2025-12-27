package io.grpc.j1;

import com.google.common.base.n;
import java.util.IdentityHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: SharedResourceHolder.java */
/* loaded from: classes3.dex */
public final class f2 {

    private static final f2 d = new f2();
    private final IdentityHashMap<f2.d<?>, f2.c> a = new IdentityHashMap<>();
    private final f2.e b;
    private ScheduledExecutorService c;

    class b implements Runnable {

        final /* synthetic */ f2.c a;
        final /* synthetic */ f2.d b;
        final /* synthetic */ Object c;
        final /* synthetic */ f2 v;
        b(f2.c cVar, f2.d dVar, Object object) {
            this.v = f2Var;
            this.a = cVar;
            this.b = dVar;
            this.c = object;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th;
            io.grpc.j1.f2 f2Var6;
            io.grpc.j1.f2.d dVar3;
            synchronized (f2Var) {
                try {
                } catch (Throwable unused) {
                }
                if (this.a.b == 0) {
                    try {
                        this.b.b(this.c);
                    } catch (Throwable unused) {
                    }
                    try {
                        this.v.a.remove(this.b);
                        if (this.v.a.isEmpty()) {
                            this.v.c.shutdown();
                            this.v.c = null;
                        }
                        f2Var6 = this.v.c;
                        this.v.shutdown();
                        this.v.c = scheduledExecutorService;
                        throw th;
                    } catch (Throwable th) {
                        f2Var6 = this.v.a;
                        this.v.remove(this.b);
                        f2Var6 = this.v.a;
                        f2Var6 = this.v.isEmpty();
                    }
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) scheduledExecutorService;
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

    public interface d<T> {
        T a();

        void b(T t);
    }

    interface e {
        ScheduledExecutorService a();
    }

    class a implements f2.e {
        a() {
            super();
        }

        public ScheduledExecutorService a() {
            return Executors.newSingleThreadScheduledExecutor(r0.i("grpc-shared-destroyer-%d", true));
        }
    }
    static {
        final io.grpc.j1.f2.a aVar = new f2.a();
    }

    f2(f2.e eVar) {
        super();
        final IdentityHashMap identityHashMap = new IdentityHashMap();
        this.b = eVar;
    }

    static /* synthetic */ IdentityHashMap a(f2 f2Var) {
        return f2Var.a;
    }

    static /* synthetic */ ScheduledExecutorService b(f2 f2Var) {
        return f2Var.c;
    }

    static /* synthetic */ ScheduledExecutorService c(f2 f2Var, ScheduledExecutorService scheduledExecutorService) {
        f2Var.c = scheduledExecutorService;
        return scheduledExecutorService;
    }

    public static <T> T d(f2.d<T> dVar) {
        return f2.d.e(dVar);
    }

    public static <T> T f(f2.d<T> dVar, T t) {
        return f2.d.g(dVar, t);
    }

    synchronized <T> T e(f2.d<T> dVar) {
        Object value;
        IdentityHashMap identityHashMap;
        if ((f2.c)this.a.get(dVar) == null) {
            this.a.put(dVar, new f2.c(dVar.a()));
        }
        if (value.c != null) {
            value.c.cancel(false);
            ScheduledFuture scheduledFuture = null;
            value.c = scheduledFuture;
        }
        value.b++;
        return value.a;
    }

    synchronized <T> T g(f2.d<T> dVar, T t) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        Object value = this.a.get(dVar);
        int i2 = 0;
        int i = 1;
        int r1 = t == value.a ? i : i2;
        n.e((t == value.a ? i : i2), "Releasing the wrong instance");
        r1 = value.b > 0 ? i : i2;
        n.v((value.b > 0 ? i : i2), "Refcount has already reached zero");
        value.b -= i;
        if (value.c == null) {
        }
        n.v(z3, "Destroy task already scheduled");
        if (this.c == null) {
            this.c = this.b.a();
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str = "No cached instance found for ";
        dVar = str + dVar;
        throw new IllegalArgumentException(dVar);
    }
}
