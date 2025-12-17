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

/* loaded from: classes2.dex */
public final class a extends z<io.grpc.i1.a> {

    private final s0<?> a;
    private Context b;

    static class a {
    }

    static final class b extends r0 {

        private final r0 a;
        private final Context b;
        private final ConnectivityManager c = null;
        private final Object d;
        private Runnable e;
        b(r0 r0, Context context2) {
            Object object;
            int obj2;
            Context obj3;
            super();
            object = new Object();
            this.d = object;
            this.a = r0;
            this.b = context2;
            if (context2 != null) {
                this.c = (ConnectivityManager)context2.getSystemService("connectivity");
                r();
            } else {
                obj2 = 0;
            }
        }

        static ConnectivityManager o(io.grpc.i1.a.b a$b) {
            return b.c;
        }

        static Context p(io.grpc.i1.a.b a$b) {
            return b.b;
        }

        static r0 q(io.grpc.i1.a.b a$b) {
            return b.a;
        }

        private void r() {
            int sDK_INT;
            Object dVar;
            Object bVar;
            Context i;
            int i2 = 0;
            if (Build.VERSION.SDK_INT >= 24 && this.c != null) {
                if (this.c != null) {
                    dVar = new a.b.c(this, i2);
                    this.c.registerDefaultNetworkCallback(dVar);
                    bVar = new a.b.a(this, dVar);
                    this.e = bVar;
                } else {
                    dVar = new a.b.d(this, i2);
                    IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                    this.b.registerReceiver(dVar, intentFilter);
                    bVar = new a.b.b(this, dVar);
                    this.e = bVar;
                }
            } else {
            }
        }

        private void s() {
            Runnable runnable;
            final Object obj = this.d;
            runnable = this.e;
            synchronized (obj) {
                runnable.run();
                this.e = 0;
            }
        }

        @Override // io.grpc.r0
        public String a() {
            return this.a.a();
        }

        public <RequestT, ResponseT> h<RequestT, ResponseT> h(u0<RequestT, ResponseT> u0, d d2) {
            return this.a.h(u0, d2);
        }

        @Override // io.grpc.r0
        public boolean i(long l, TimeUnit timeUnit2) {
            return this.a.i(l, timeUnit2);
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
        public void l(q q, Runnable runnable2) {
            this.a.l(q, runnable2);
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

    private a(s0<?> s0) {
        super();
        n.p(s0, "delegateBuilder");
        this.a = (s0)s0;
    }

    private static Class<?> j() {
        try {
            return Class.forName("io.grpc.k1.e");
            return 0;
        }
    }

    public static io.grpc.i1.a k(s0<?> s0) {
        a aVar = new a(s0);
        return aVar;
    }

    @Override // io.grpc.z
    public r0 a() {
        a.b bVar = new a.b(this.a.a(), this.b);
        return bVar;
    }

    protected s0<?> e() {
        return this.a;
    }

    @Override // io.grpc.z
    public io.grpc.i1.a i(Context context) {
        this.b = context;
        return this;
    }
}
