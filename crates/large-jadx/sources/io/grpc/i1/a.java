package io.grpc.i1;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build.VERSION;
import android.util.Log;
import com.google.common.base.n;
import io.grpc.d;
import io.grpc.e;
import io.grpc.h;
import io.grpc.q;
import io.grpc.r0;
import io.grpc.s0;
import io.grpc.u0;
import io.grpc.z;
import java.util.concurrent.TimeUnit;

/* compiled from: AndroidChannelBuilder.java */
/* loaded from: classes2.dex */
public final class a extends z<a> {

    private final s0<?> a;
    private Context b;

    static class a {
    }

    static final class b extends r0 {

        private final r0 a;
        private final Context b;
        private final ConnectivityManager c = null;
        private final Object d = new Object();
        private Runnable e;
        b(r0 r0Var, Context context) {
            super();
            Object object = new Object();
            this.a = r0Var;
            this.b = context;
            if (context != null) {
                this.c = (ConnectivityManager)context.getSystemService("connectivity");
                try {
                    r();
                } catch (java.lang.SecurityException se) {
                    context = "AndroidChannelBuilder";
                    Log.w(context, "Failed to configure network monitoring. Does app have ACCESS_NETWORK_STATE permission?", se);
                }
            } else {
                int i = 0;
            }
        }

        static /* synthetic */ ConnectivityManager o(a.b bVar) {
            return bVar.c;
        }

        static /* synthetic */ Context p(a.b bVar) {
            return bVar.b;
        }

        static /* synthetic */ r0 q(a.b bVar) {
            return bVar.a;
        }

        private void r() throws android.content.IntentFilter.MalformedMimeTypeException {
            io.grpc.i1.a.a aVar = null;
            if (Build.VERSION.SDK_INT < 24 || this.c == null) {
                io.grpc.i1.a.b.d dVar = new a.b.d(this, aVar);
                this.b.registerReceiver(dVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.e = new a.b.b(this, dVar);
            } else {
                io.grpc.i1.a.b.c cVar = new a.b.c(this, aVar);
                this.c.registerDefaultNetworkCallback(cVar);
                this.e = new a.b.a(this, cVar);
            }
        }

        private void s() {
            synchronized (obj2) {
                try {
                    if (this.e != null) {
                        this.e.run();
                        Runnable runnable = null;
                        this.e = runnable;
                    }
                    return;
                } catch (Throwable th) {
                }
                throw th;
            }
        }

        @Override // io.grpc.r0
        public String a() {
            return this.a.a();
        }

        @Override // io.grpc.r0
        public <RequestT, ResponseT> h<RequestT, ResponseT> h(u0<RequestT, ResponseT> u0Var, d dVar) {
            return this.a.h(u0Var, dVar);
        }

        @Override // io.grpc.r0
        public boolean i(long j, TimeUnit timeUnit) {
            return this.a.i(j, timeUnit);
        }

        @Override // io.grpc.r0
        public void j() {
            this.a.j();
        }

        @Override // io.grpc.r0
        public q k(boolean z) {
            return this.a.k(z);
        }

        @Override // io.grpc.r0
        public void l(q qVar, Runnable runnable) {
            this.a.l(qVar, runnable);
        }

        @Override // io.grpc.r0
        public r0 m() {
            s();
            return this.a.m();
        }

        @Override // io.grpc.r0
        public r0 n() {
            s();
            return this.a.n();
        }
    }
    static {
        a.j();
    }

    private a(s0<?> s0Var) {
        super();
        n.p(s0Var, "delegateBuilder");
        this.a = s0Var;
    }

    private static Class<?> j() {
        try {
        } catch (java.lang.ClassNotFoundException unused) {
            return null;
        }
        return Class.forName("io.grpc.k1.e");
    }

    public static a k(s0<?> s0Var) {
        return new a(s0Var);
    }

    @Override // io.grpc.z
    public r0 a() {
        return new a.b(this.a.a(), this.b);
    }

    @Override // io.grpc.z
    protected s0<?> e() {
        return this.a;
    }

    @Override // io.grpc.z
    public a i(Context context) {
        this.b = context;
        return this;
    }
}
