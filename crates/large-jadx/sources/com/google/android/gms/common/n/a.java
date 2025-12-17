package com.google.android.gms.common.n;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.o.b;
import com.google.android.gms.common.o.c;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class a {

    private static final Object b;
    private static volatile com.google.android.gms.common.n.a c;
    public ConcurrentHashMap<ServiceConnection, ServiceConnection> a;
    static {
        Object object = new Object();
        a.b = object;
    }

    private a() {
        super();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.a = concurrentHashMap;
    }

    public static com.google.android.gms.common.n.a b() {
        Object aVar2;
        com.google.android.gms.common.n.a aVar;
        aVar2 = a.b;
        if (a.c == null && a.c == null) {
            aVar2 = a.b;
            synchronized (aVar2) {
                aVar = new a();
                a.c = aVar;
            }
        }
        com.google.android.gms.common.n.a aVar3 = a.c;
        r.j(aVar3);
        return aVar3;
    }

    private final boolean e(Context context, String string2, Intent intent3, ServiceConnection serviceConnection4, int i5, boolean z6) {
        int action;
        boolean obj4;
        Object obj5;
        int obj9;
        obj9 = intent3.getComponent();
        final String str = "ConnectionTracker";
        final int i = 0;
        if (obj9 == null) {
        } else {
            obj9 = obj9.getPackageName();
            "com.google.android.gms".equals(obj9);
            if (obj9 &= action != 0) {
                Log.w(str, "Attempted to bind to a service in a STOPPED package.");
                return i;
            }
        }
        obj9 = this.a.putIfAbsent(serviceConnection4, serviceConnection4);
        if (a.f(serviceConnection4) && (ServiceConnection)obj9 != null && serviceConnection4 != (ServiceConnection)obj9) {
            obj9 = this.a.putIfAbsent(serviceConnection4, serviceConnection4);
            if ((ServiceConnection)(ServiceConnection)obj9 != null) {
                if (serviceConnection4 != (ServiceConnection)(ServiceConnection)obj9) {
                    obj9 = new Object[3];
                    obj9[i] = serviceConnection4;
                    obj9[1] = string2;
                    obj9[2] = intent3.getAction();
                    Log.w(str, String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", obj9));
                }
            }
            if (context.bindService(intent3, serviceConnection4, i5)) {
                return obj4;
            }
            this.a.remove(serviceConnection4, serviceConnection4);
            return i;
        }
        obj4 = context.bindService(intent3, serviceConnection4, i5);
    }

    private static boolean f(ServiceConnection serviceConnection) {
        if (!serviceConnection instanceof u1) {
            return 1;
        }
        return 0;
    }

    private static void g(Context context, ServiceConnection serviceConnection2) {
        try {
            context.unbindService(serviceConnection2);
        }
    }

    public boolean a(Context context, Intent intent2, ServiceConnection serviceConnection3, int i4) {
        return this.e(context, context.getClass().getName(), intent2, serviceConnection3, i4, true);
    }

    public void c(Context context, ServiceConnection serviceConnection2) {
        boolean key;
        if (a.f(serviceConnection2) && this.a.containsKey(serviceConnection2)) {
            if (this.a.containsKey(serviceConnection2)) {
                a.g(context, (ServiceConnection)this.a.get(serviceConnection2));
                this.a.remove(serviceConnection2);
            }
        }
        a.g(context, serviceConnection2);
    }

    public final boolean d(Context context, String string2, Intent intent3, ServiceConnection serviceConnection4, int i5) {
        return this.e(context, string2, intent3, serviceConnection4, i5, true);
    }
}
