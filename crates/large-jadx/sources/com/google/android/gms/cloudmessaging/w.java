package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.util.q.a;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import f.c.a.d.b.f.e;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public final class w {

    private static com.google.android.gms.cloudmessaging.w e;
    private final Context a;
    private final ScheduledExecutorService b;
    private com.google.android.gms.cloudmessaging.r c;
    private int d = 1;
    w(Context context, ScheduledExecutorService scheduledExecutorService2) {
        super();
        r rVar = new r(this, 0);
        this.c = rVar;
        int i = 1;
        this.b = scheduledExecutorService2;
        this.a = context.getApplicationContext();
    }

    static Context a(com.google.android.gms.cloudmessaging.w w) {
        return w.a;
    }

    public static com.google.android.gms.cloudmessaging.w b(Context context) {
        com.google.android.gms.cloudmessaging.w wVar;
        ScheduledExecutorService unconfigurableScheduledExecutorService;
        int i;
        final Class<com.google.android.gms.cloudmessaging.w> obj = w.class;
        synchronized (obj) {
            e.a();
            a aVar = new a("MessengerIpcClient");
            wVar = new w(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, aVar)));
            w.e = wVar;
            return w.e;
        }
    }

    static ScheduledExecutorService e(com.google.android.gms.cloudmessaging.w w) {
        return w.b;
    }

    private final int f() {
        final int i = this.d;
        this.d = i + 1;
        return i;
        synchronized (this) {
            i = this.d;
            this.d = i + 1;
            return i;
        }
    }

    private final <T> j<T> g(com.google.android.gms.cloudmessaging.u<T> u) {
        boolean loggable;
        boolean rVar;
        int string;
        StringBuilder stringBuilder;
        synchronized (this) {
            try {
                String valueOf = String.valueOf(u);
                stringBuilder = new StringBuilder(length += 9);
                stringBuilder.append("Queueing ");
                stringBuilder.append(valueOf);
                Log.d("MessengerIpcClient", stringBuilder.toString());
                if (!this.c.g(u)) {
                }
                rVar = new r(this, 0);
                this.c = rVar;
                rVar.g(u);
                return u.b.a();
                throw u;
            }
        }
    }

    public final j<Void> c(int i, Bundle bundle2) {
        t obj3 = new t(f(), 2, bundle2);
        return g(obj3);
    }

    public final j<Bundle> d(int i, Bundle bundle2) {
        v obj3 = new v(f(), 1, bundle2);
        return g(obj3);
    }
}
