package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import com.google.android.gms.common.n.a;
import f.c.a.d.b.g.h;
import java.util.HashMap;

/* loaded from: classes2.dex */
final class t1 extends com.google.android.gms.common.internal.i {

    private final HashMap<com.google.android.gms.common.internal.p1, com.google.android.gms.common.internal.r1> d;
    private final Context e;
    private final Handler f;
    private final a g;
    private final long h = 5000;
    private final long i = 300000;
    t1(Context context) {
        super();
        HashMap hashMap = new HashMap();
        this.d = hashMap;
        this.e = context.getApplicationContext();
        s1 s1Var = new s1(this, 0);
        h hVar = new h(context.getMainLooper(), s1Var);
        this.f = hVar;
        this.g = a.b();
        int i = 5000;
        int i2 = 300000;
    }

    static HashMap f(com.google.android.gms.common.internal.t1 t1) {
        return t1.d;
    }

    static Handler g(com.google.android.gms.common.internal.t1 t1) {
        return t1.f;
    }

    static Context h(com.google.android.gms.common.internal.t1 t1) {
        return t1.e;
    }

    static a i(com.google.android.gms.common.internal.t1 t1) {
        return t1.g;
    }

    static long j(com.google.android.gms.common.internal.t1 t1) {
        return t1.i;
    }

    @Override // com.google.android.gms.common.internal.i
    protected final boolean d(com.google.android.gms.common.internal.p1 p1, ServiceConnection serviceConnection2, String string3) {
        Object r1Var;
        int i;
        int i2;
        android.content.ComponentName obj5;
        Object obj6;
        Object obj7;
        r.k(serviceConnection2, "ServiceConnection must not be null");
        HashMap map = this.d;
        r1Var = this.d.get(p1);
        synchronized (map) {
            r1Var = new r1(this, p1);
            r1Var.c(serviceConnection2, serviceConnection2, string3);
            r1Var.a(string3);
            this.d.put(p1, r1Var);
            try {
                return r1Var.e();
                obj5 = String.valueOf(p1);
                StringBuilder stringBuilder = new StringBuilder(obj7 += 81);
                stringBuilder.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                stringBuilder.append(obj5);
                obj6 = new IllegalStateException(stringBuilder.toString());
                throw obj6;
                throw p1;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.i
    protected final void e(com.google.android.gms.common.internal.p1 p1, ServiceConnection serviceConnection2, String string3) {
        Object obj;
        Object obj4;
        boolean obj5;
        String obj6;
        r.k(serviceConnection2, "ServiceConnection must not be null");
        HashMap map = this.d;
        obj = this.d.get(p1);
        synchronized (map) {
            final boolean z = (r1)obj.g(serviceConnection2);
            if (!z) {
            } else {
                obj.d(serviceConnection2, string3);
                if (obj.h()) {
                    this.f.sendMessageDelayed(this.f.obtainMessage(0, p1), this.h);
                }
            }
            obj4 = String.valueOf(p1);
            StringBuilder stringBuilder = new StringBuilder(obj6 += 76);
            stringBuilder.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
            stringBuilder.append(obj4);
            obj5 = new IllegalStateException(stringBuilder.toString());
            throw obj5;
        }
    }
}
