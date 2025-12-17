package com.google.android.gms.cloudmessaging;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.n.a;
import f.c.a.d.b.f.f;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
final class r implements ServiceConnection {

    int a = 0;
    final Messenger b;
    com.google.android.gms.cloudmessaging.s c;
    final Queue<com.google.android.gms.cloudmessaging.u<?>> v;
    final SparseArray<com.google.android.gms.cloudmessaging.u<?>> w;
    final com.google.android.gms.cloudmessaging.w x;
    r(com.google.android.gms.cloudmessaging.w w, com.google.android.gms.cloudmessaging.q q2) {
        this.x = w;
        super();
        int obj3 = 0;
        k kVar = new k(this);
        f obj4 = new f(Looper.getMainLooper(), kVar);
        obj3 = new Messenger(obj4);
        this.b = obj3;
        obj3 = new ArrayDeque();
        this.v = obj3;
        obj3 = new SparseArray();
        this.w = obj3;
    }

    @Override // android.content.ServiceConnection
    final void a(int i, String string2) {
        b(i, string2, 0);
        return;
        synchronized (this) {
            b(i, string2, 0);
        }
    }

    @Override // android.content.ServiceConnection
    final void b(int i, String string2, Throwable throwable3) {
        String loggable2;
        boolean loggable;
        int str2;
        String str;
        int length;
        int obj6;
        Object obj7;
        str2 = 3;
        synchronized (this) {
            try {
                String valueOf = String.valueOf(string2);
                String str5 = "Disconnected: ";
                if (valueOf.length() != 0) {
                } else {
                }
                loggable2 = str5.concat(valueOf);
                loggable2 = new String(str5);
                Log.d("MessengerIpcClient", loggable2);
                int i2 = this.a;
                if (i2 == 0) {
                } else {
                }
                int i3 = 4;
                int i4 = 2;
                if (i2 != 1 && i2 != i4 && i2 != str2) {
                }
                if (i2 != i4) {
                }
                if (i2 != str2) {
                }
                this.a = i3;
                if (Log.isLoggable("MessengerIpcClient", i4)) {
                }
                Log.v("MessengerIpcClient", "Unbinding service");
                this.a = i3;
                a.b().c(w.a(this.x), this);
                zzq zzq = new zzq(i, string2, throwable3);
                obj6 = this.v.iterator();
                for (u obj7 : obj6) {
                    obj7.c(zzq);
                }
                (u)obj6.next().c(zzq);
                this.v.clear();
                obj6 = 0;
                while (obj6 < this.w.size()) {
                    (u)this.w.valueAt(obj6).c(zzq);
                    obj6++;
                }
                (u)this.w.valueAt(obj6).c(zzq);
                obj6++;
                this.w.clear();
                obj6 = new IllegalStateException();
                throw obj6;
                throw i;
            }
        }
    }

    @Override // android.content.ServiceConnection
    final void c() {
        m mVar = new m(this);
        w.e(this.x).execute(mVar);
    }

    @Override // android.content.ServiceConnection
    final void d() {
        final int i2 = 1;
        synchronized (this) {
            try {
                a(i2, "Timed out while binding");
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    final void e(int i) {
        Object obj = this.w.get(i);
        synchronized (this) {
            try {
                StringBuilder stringBuilder = new StringBuilder(31);
                stringBuilder.append("Timing out request: ");
                stringBuilder.append(i);
                Log.w("MessengerIpcClient", stringBuilder.toString());
                this.w.remove(i);
                zzq obj5 = new zzq(3, "Timed out waiting for response", 0);
                (u)obj.c(obj5);
                f();
                throw i;
            }
        }
    }

    @Override // android.content.ServiceConnection
    final void f() {
        boolean loggable;
        int empty;
        int str;
        str = 2;
        synchronized (this) {
            try {
                if (this.v.isEmpty()) {
                }
                if (this.w.size() == 0) {
                }
                if (Log.isLoggable("MessengerIpcClient", str)) {
                }
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
                this.a = 3;
                a.b().c(w.a(this.x), this);
                throw th;
            }
        }
    }

    final boolean g(com.google.android.gms.cloudmessaging.u<?> u) {
        Object str;
        Object nVar;
        android.content.Context context;
        TimeUnit sECONDS;
        int obj6;
        int i = this.a;
        int i2 = 2;
        final int i3 = 0;
        final int i4 = 1;
        synchronized (this) {
            try {
            } catch (java.lang.SecurityException se) {
            } catch (Throwable th1) {
            }
            this.v.add(u);
            return i4;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder2) {
        boolean loggable;
        String obj2 = "MessengerIpcClient";
        if (Log.isLoggable(obj2, 2)) {
            Log.v(obj2, "Service connected");
        }
        o oVar = new o(this, iBinder2);
        w.e(this.x).execute(oVar);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        boolean loggable;
        String obj2 = "MessengerIpcClient";
        if (Log.isLoggable(obj2, 2)) {
            Log.v(obj2, "Service disconnected");
        }
        l lVar = new l(this);
        w.e(this.x).execute(lVar);
    }
}
