package com.iterable.iterableapi;

import android.util.Base64;
import com.iterable.iterableapi.k1.a;
import com.iterable.iterableapi.k1.a.d;
import com.iterable.iterableapi.k1.a.e;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class p {

    private final com.iterable.iterableapi.j a;
    private final com.iterable.iterableapi.o b;
    private final long c;
    Timer d;
    private boolean e;
    private boolean f;
    private boolean g;

    class c implements Callable<String> {

        final com.iterable.iterableapi.p a;
        c(com.iterable.iterableapi.p p) {
            this.a = p;
            super();
        }

        @Override // java.util.concurrent.Callable
        public String a() {
            return p.b(this.a).a();
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class d extends TimerTask {

        final com.iterable.iterableapi.p a;
        d(com.iterable.iterableapi.p p) {
            this.a = p;
            super();
        }

        @Override // java.util.TimerTask
        public void run() {
            p.c(this.a).m().i(false);
        }
    }

    class a implements a.d {

        final com.iterable.iterableapi.p a;
        a(com.iterable.iterableapi.p p) {
            this.a = p;
            super();
        }

        @Override // com.iterable.iterableapi.k1.a$d
        public void a(Throwable throwable) {
            j0.d("IterableAuth", "Error while requesting Auth Token", throwable);
            p.a(this.a, false);
            this.a.h();
        }
    }

    class b implements a.e<String> {

        final com.iterable.iterableapi.p a;
        b(com.iterable.iterableapi.p p) {
            this.a = p;
            super();
        }

        @Override // com.iterable.iterableapi.k1.a$e
        public void a(String string) {
            com.iterable.iterableapi.p pVar;
            if (string != null) {
                this.a.g(string);
            }
            j.s().K(string);
            p.a(this.a, false);
            this.a.h();
        }

        @Override // com.iterable.iterableapi.k1.a$e
        public void onSuccess(Object object) {
            a((String)object);
        }
    }
    p(com.iterable.iterableapi.j j, com.iterable.iterableapi.o o2, long l3) {
        super();
        this.a = j;
        this.b = o2;
        this.c = l3;
    }

    static boolean a(com.iterable.iterableapi.p p, boolean z2) {
        p.f = z2;
        return z2;
    }

    static com.iterable.iterableapi.o b(com.iterable.iterableapi.p p) {
        return p.b;
    }

    static com.iterable.iterableapi.j c(com.iterable.iterableapi.p p) {
        return p.a;
    }

    private static long e(String string) {
        JSONObject jSONObject = new JSONObject(p.f(string.split("\\.")[1]));
        return jSONObject.getLong("exp");
    }

    private static String f(String string) {
        String string2 = new String(Base64.decode(string, 8), "UTF-8");
        return string2;
    }

    private void k(long l) {
        Timer timer;
        long obj3;
        StringBuilder obj4;
        timer = new Timer(1);
        this.d = timer;
        p.d dVar = new p.d(this);
        timer.schedule(dVar, l);
    }

    void d() {
        Timer time;
        time = this.d;
        if (time != null) {
            time.cancel();
            this.d = 0;
        }
    }

    public void g(String string) {
        int i;
        int obj6;
        d();
        i3 -= l3;
        if (Long.compare(i, i5) > 0) {
            k(i);
        } else {
            j0.i("IterableAuth", "The expiringAuthTokenRefreshPeriod has already passed for the current JWT");
        }
    }

    void h() {
        boolean z;
        if (this.g) {
            z = 0;
            this.g = z;
            i(z);
        }
    }

    public void i(boolean z) {
        int aVar;
        com.iterable.iterableapi.j obj3;
        final int i = 1;
        synchronized (this) {
            try {
                if (!this.f) {
                } else {
                }
                if (this.e) {
                } else {
                }
                if (!z) {
                }
                this.e = z;
                this.f = i;
                obj3 = new p.c(this);
                obj3 = a.i(obj3);
                p.b bVar = new p.b(this);
                obj3.h(bVar);
                aVar = new p.a(this);
                obj3.g(aVar);
                if (!z) {
                }
                this.g = i;
                j.s().L(0, i);
                throw z;
            }
        }
    }

    void j() {
        this.e = false;
    }
}
