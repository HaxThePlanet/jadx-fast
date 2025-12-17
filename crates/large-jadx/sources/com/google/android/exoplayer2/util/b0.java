package com.google.android.exoplayer2.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public final class b0 {

    private static com.google.android.exoplayer2.util.b0 e;
    private final Handler a;
    private final CopyOnWriteArrayList<WeakReference<com.google.android.exoplayer2.util.b0.c>> b;
    private final Object c;
    private int d = 0;

    static class a {
    }

    public static final class b {

        private static volatile boolean a;
        static boolean a() {
            return b0.b.a;
        }
    }

    public interface c {
        public abstract void a(int i);
    }

    private final class d extends BroadcastReceiver {

        final com.google.android.exoplayer2.util.b0 a;
        private d(com.google.android.exoplayer2.util.b0 b0) {
            this.a = b0;
            super();
        }

        d(com.google.android.exoplayer2.util.b0 b0, com.google.android.exoplayer2.util.b0.a b0$a2) {
            super(b0);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent2) {
            int i2;
            int i;
            final int obj6 = b0.a(context);
            int i3 = p0.a;
            if (i3 >= 29 && !b0.b.a() && obj6 == 5) {
                if (!b0.b.a()) {
                    if (obj6 == 5) {
                        Object obj5 = context.getSystemService("phone");
                        g.e((TelephonyManager)obj5);
                        b0.e eVar = new b0.e(this.a, 0);
                        if (i3 < 31) {
                            (TelephonyManager)obj5.listen(eVar, 1);
                        } else {
                            obj5.listen(eVar, 1048576);
                        }
                        obj5.listen(eVar, 0);
                    }
                }
            }
            b0.b(this.a, obj6);
        }
    }

    private class e extends PhoneStateListener {

        final com.google.android.exoplayer2.util.b0 a;
        private e(com.google.android.exoplayer2.util.b0 b0) {
            this.a = b0;
            super();
        }

        e(com.google.android.exoplayer2.util.b0 b0, com.google.android.exoplayer2.util.b0.a b0$a2) {
            super(b0);
        }

        @Override // android.telephony.PhoneStateListener
        public void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
            int i;
            int obj2;
            obj2 = telephonyDisplayInfo.getOverrideNetworkType();
            if (obj2 != 3) {
                if (obj2 == 4) {
                    obj2 = 1;
                } else {
                    obj2 = 0;
                }
            } else {
            }
            obj2 = obj2 != null ? 10 : 5;
            b0.b(this.a, obj2);
        }

        @Override // android.telephony.PhoneStateListener
        public void onServiceStateChanged(ServiceState serviceState) {
            boolean contains;
            String obj2;
            if (serviceState == null) {
                obj2 = "";
            } else {
                obj2 = serviceState.toString();
            }
            if (!obj2.contains("nrState=CONNECTED")) {
                if (obj2.contains("nrState=NOT_RESTRICTED")) {
                    obj2 = 1;
                } else {
                    obj2 = 0;
                }
            } else {
            }
            obj2 = obj2 != null ? 10 : 5;
            b0.b(this.a, obj2);
        }
    }
    private b0(Context context) {
        super();
        Handler handler = new Handler(Looper.getMainLooper());
        this.a = handler;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.b = copyOnWriteArrayList;
        Object object = new Object();
        this.c = object;
        int i = 0;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        b0.d dVar = new b0.d(this, 0);
        context.registerReceiver(dVar, intentFilter);
    }

    static int a(Context context) {
        return b0.f(context);
    }

    static void b(com.google.android.exoplayer2.util.b0 b0, int i2) {
        b0.k(i2);
    }

    public static com.google.android.exoplayer2.util.b0 c(Context context) {
        com.google.android.exoplayer2.util.b0 b0Var;
        final Class<com.google.android.exoplayer2.util.b0> obj = b0.class;
        synchronized (obj) {
            b0Var = new b0(context);
            b0.e = b0Var;
            return b0.e;
        }
    }

    private static int d(NetworkInfo networkInfo) {
        int obj1;
        switch (obj1) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 5;
            case 4:
                return 6;
            case 5:
                return 2;
            default:
                obj1 = 9;
                obj1 = 0;
        }
        return obj1;
    }

    private static int f(Context context) {
        int i;
        boolean connected;
        Object obj2 = context.getSystemService("connectivity");
        if ((ConnectivityManager)obj2 == null) {
            return 0;
        }
        obj2 = (ConnectivityManager)obj2.getActiveNetworkInfo();
        i = 1;
        if (obj2 != null) {
            if (!obj2.isConnected()) {
            } else {
                int type = obj2.getType();
                i = 5;
                if (type != null && type != i && type != 4 && type != i && type != 6 && type != 9) {
                    if (type != i) {
                        if (type != 4) {
                            i = 5;
                            if (type != i) {
                                if (type != 6) {
                                    if (type != 9) {
                                        return 8;
                                    }
                                    try {
                                        return 7;
                                        return i;
                                        return 2;
                                        return b0.d(obj2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return i;
    }

    private void g(com.google.android.exoplayer2.util.b0.c b0$c) {
        c.a(e());
    }

    private void j() {
        Object next;
        Object obj;
        Iterator iterator = this.b.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((WeakReference)next.get() == null) {
            }
            this.b.remove(next);
        }
    }

    private void k(int i) {
        int next;
        Object obj;
        Object obj2 = this.c;
        synchronized (obj2) {
        }
        try {
            while (iterator.hasNext()) {
                next = iterator.next();
                obj = (WeakReference)next.get();
                if ((b0.c)obj != null) {
                } else {
                }
                this.b.remove(next);
                (b0.c)obj.a(i);
            }
            next = iterator.next();
            obj = (WeakReference)next.get();
            if ((b0.c)obj != null) {
            } else {
            }
            (b0.c)obj.a(i);
            this.b.remove(next);
            throw i;
        }
    }

    public int e() {
        final Object obj = this.c;
        return this.d;
        synchronized (obj) {
            obj = this.c;
            return this.d;
        }
    }

    public void h(com.google.android.exoplayer2.util.b0.c b0$c) {
        g(c);
    }

    public void i(com.google.android.exoplayer2.util.b0.c b0$c) {
        j();
        WeakReference weakReference = new WeakReference(c);
        this.b.add(weakReference);
        c cVar = new c(this, c);
        this.a.post(cVar);
    }
}
