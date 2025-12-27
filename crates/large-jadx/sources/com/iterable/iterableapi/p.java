package com.iterable.iterableapi;

import android.util.Base64;
import com.iterable.iterableapi.k1.a;
import com.iterable.iterableapi.k1.a.d;
import com.iterable.iterableapi.k1.a.e;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: IterableAuthManager.java */
/* loaded from: classes2.dex */
public class p {

    private final j a;
    private final o b;
    private final long c;
    Timer d;
    private boolean e;
    private boolean f;
    private boolean g;

    class c implements Callable<String> {

        final /* synthetic */ p a;
        c() {
            this.a = pVar;
            super();
        }

        public String a() {
            return this.a.b.a();
        }
    }

    class d extends TimerTask {

        final /* synthetic */ p a;
        d() {
            this.a = pVar;
            super();
        }

        @Override // java.util.TimerTask
        public void run() {
            this.a.a.m().i(false);
        }
    }

    class a implements a.d {

        final /* synthetic */ p a;
        a() {
            this.a = pVar;
            super();
        }

        public void a(Throwable th) {
            j0.d("IterableAuth", "Error while requesting Auth Token", th);
            this.a.f = 0;
            this.a.h();
        }
    }

    class b implements a.e<String> {

        final /* synthetic */ p a;
        b() {
            this.a = pVar;
            super();
        }

        public void a(String str) {
            if (str != null) {
                this.a.g(str);
            }
            j.s().K(str);
            this.a.f = 0;
            this.a.h();
        }
    }
    p(j jVar, o oVar, long j) {
        super();
        this.a = jVar;
        this.b = oVar;
        this.c = j;
    }

    static /* synthetic */ boolean a(p pVar, boolean z) {
        pVar.f = z;
        return z;
    }

    static /* synthetic */ o b(p pVar) {
        return pVar.b;
    }

    static /* synthetic */ j c(p pVar) {
        return pVar.a;
    }

    private static long e(String str) throws org.json.JSONException {
        return new JSONObject(p.f(str.split("\\.")[1])).getLong("exp");
    }

    private static String f(String str) throws java.io.UnsupportedEncodingException {
        return new String(Base64.decode(str, 8), "UTF-8");
    }

    private void k(long j) {
        Timer timer = new Timer(true);
        this.d = timer;
        try {
            timer.schedule(new p.d(this), j);
        } catch (Exception e) {
            r4 = new StringBuilder();
            String str = "timer exception: ";
            r4.append(str);
            r4.append(this.d);
            r4 = r4.toString();
            str = "IterableAuth";
            j0.d(this.d, r4, e);
        }
    }

    void d() {
        if (this.d != null) {
            this.d.cancel();
            Timer timer = null;
            this.d = timer;
        }
    }

    public void g(String str) {
        d();
        try {
            l = (p.e(str) * 1000L) - this.c - z0.a();
            k(l);
            str2 = "The expiringAuthTokenRefreshPeriod has already passed for the current JWT";
            j0.i("IterableAuth", str2);
        } catch (Exception e) {
            j0.d(str3, "Error while parsing JWT for the expiration", e);
        }
    }

    void h() {
        if (this.g) {
            boolean z = false;
            this.g = z;
            i(z);
        }
    }

    public synchronized void i(boolean z) {
        final boolean z4 = true;
        if (this.b == null) {
            j.s().L(null, z4);
        } else {
            if (!this.f) {
                if (!this.e || !z) {
                    this.e = z;
                    this.f = z4;
                    a aVar2 = a.i(new p.c(this));
                    aVar2.h(new p.b(this));
                    aVar2.g(new p.a(this));
                }
            } else {
                if (!z) {
                    this.g = z4;
                }
            }
        }
    }

    void j() {
        this.e = false;
    }
}
