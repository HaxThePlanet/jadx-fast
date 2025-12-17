package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.play.core.tasks.d;
import com.google.android.play.core.tasks.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class t<T extends IInterface>  {

    private static final Map<String, Handler> o;
    private final Context a;
    private final com.google.android.play.core.internal.h b;
    private final String c;
    private final List<com.google.android.play.core.internal.i> d;
    private final Set<o<?>> e;
    private final Object f;
    private boolean g;
    private final Intent h;
    private final com.google.android.play.core.internal.o<T> i;
    private final WeakReference<com.google.android.play.core.internal.n> j;
    private final IBinder.DeathRecipient k;
    private final AtomicInteger l;
    private ServiceConnection m;
    private T n;
    static {
        HashMap hashMap = new HashMap();
        t.o = hashMap;
    }

    public t(Context context, com.google.android.play.core.internal.h h2, String string3, Intent intent4, com.google.android.play.core.internal.o<T> o5, com.google.android.play.core.internal.n n6) {
        super();
        ArrayList obj7 = new ArrayList();
        this.d = obj7;
        obj7 = new HashSet();
        this.e = obj7;
        obj7 = new Object();
        this.f = obj7;
        obj7 = new j(this);
        this.k = obj7;
        obj7 = new AtomicInteger(0);
        this.l = obj7;
        this.a = context;
        this.b = h2;
        this.c = string3;
        this.h = intent4;
        this.i = o5;
        WeakReference obj2 = new WeakReference(0);
        this.j = obj2;
    }

    static Context a(com.google.android.play.core.internal.t t) {
        return t.a;
    }

    static ServiceConnection b(com.google.android.play.core.internal.t t) {
        return t.m;
    }

    static IInterface d(com.google.android.play.core.internal.t t) {
        return t.n;
    }

    static com.google.android.play.core.internal.h f(com.google.android.play.core.internal.t t) {
        return t.b;
    }

    static com.google.android.play.core.internal.o g(com.google.android.play.core.internal.t t) {
        return t.i;
    }

    static List h(com.google.android.play.core.internal.t t) {
        return t.d;
    }

    public static void i(com.google.android.play.core.internal.t t) {
        Object obj;
        Object[] next2;
        String next;
        com.google.android.play.core.internal.h arr;
        String str;
        int i = 0;
        t.b.d("reportBinderDeath", new Object[i]);
        obj = t.j.get();
        if ((n)obj != null) {
            t.b.d("calling onBinderDied", new Object[i]);
            (n)obj.zza();
        } else {
            arr = new Object[1];
            arr[i] = t.c;
            t.b.d("%s : Binder has died.", arr);
            Iterator iterator = t.d.iterator();
            for (i next : iterator) {
                next.c(t.t());
            }
            t.d.clear();
        }
        t.u();
    }

    static void j(com.google.android.play.core.internal.t t, ServiceConnection serviceConnection2) {
        t.m = 0;
    }

    static void k(com.google.android.play.core.internal.t t, boolean z2) {
        t.g = false;
    }

    static void l(com.google.android.play.core.internal.t t, IInterface iInterface2) {
        t.n = iInterface2;
    }

    static void m(com.google.android.play.core.internal.t t) {
        t.u();
    }

    static void n(com.google.android.play.core.internal.t t, com.google.android.play.core.internal.i i2) {
        int next;
        Object[] next2;
        IInterface iInterface;
        int zzat;
        Object str;
        Object obj4;
        boolean obj5;
        zzat = 0;
        t.b.d("Initiate binding to the service.", new Object[zzat]);
        t.d.add(i2);
        obj5 = new s(t, 0);
        t.m = obj5;
        next = 1;
        t.g = next;
        if (t.n == null && !t.g && !t.a.bindService(t.h, obj5, next)) {
            if (!t.g) {
                t.b.d("Initiate binding to the service.", new Object[zzat]);
                t.d.add(i2);
                obj5 = new s(t, 0);
                t.m = obj5;
                next = 1;
                t.g = next;
                if (!t.a.bindService(t.h, obj5, next)) {
                    t.b.d("Failed to bind to the service.", new Object[zzat]);
                    t.g = zzat;
                    obj5 = t.d.iterator();
                    for (i next2 : obj5) {
                        zzat = new zzat();
                        next2.c(zzat);
                    }
                    t.d.clear();
                }
            }
        }
        if (t.g) {
            t.b.d("Waiting to bind to the service.", new Object[zzat]);
            t.d.add(i2);
        }
        i2.run();
    }

    static void o(com.google.android.play.core.internal.t t) {
        final int i = 0;
        t.b.d("linkToDeath", new Object[i]);
        t.n.asBinder().linkToDeath(t.k, i);
    }

    static void p(com.google.android.play.core.internal.t t) {
        final int i = 0;
        t.b.d("unlinkToDeath", new Object[i]);
        t.n.asBinder().unlinkToDeath(t.k, i);
    }

    private final RemoteException t() {
        RemoteException remoteException;
        int concat;
        String str;
        if (Build.VERSION.SDK_INT < 15) {
            remoteException = new RemoteException();
        } else {
            remoteException = new RemoteException(String.valueOf(this.c).concat(" : Binder has died."));
        }
        return remoteException;
    }

    private final void u() {
        Object next;
        RemoteException exc;
        final Object obj = this.f;
        Iterator iterator = this.e.iterator();
        synchronized (obj) {
            for (o next : iterator) {
                next.d(t());
            }
            try {
                this.e.clear();
                throw th;
            }
        }
    }

    public final Handler c() {
        boolean looper;
        String str;
        Handler handler;
        final Map map = t.o;
        synchronized (map) {
            HandlerThread handlerThread = new HandlerThread(this.c, 10);
            handlerThread.start();
            handler = new Handler(handlerThread.getLooper());
            map.put(this.c, handler);
            return (Handler)map.get(this.c);
        }
    }

    public final T e() {
        return this.n;
    }

    public final void q(com.google.android.play.core.internal.i i, o<?> o2) {
        int andIncrement;
        Object str;
        com.google.android.play.core.internal.k kVar;
        Object obj = this.f;
        this.e.add(o2);
        kVar = new k(this, o2);
        o2.a().a(kVar);
        Object obj5 = this.f;
        synchronized (obj) {
            obj = this.f;
            this.e.add(o2);
            kVar = new k(this, o2);
            o2.a().a(kVar);
            obj5 = this.f;
        }
        this.b.a("Already connected to the service.", new Object[0]);
        obj5 = new l(this, i.b(), i);
        c().post(obj5);
    }

    final void r(o o, d d2) {
        final Object obj3 = this.f;
        this.e.remove(o);
        return;
        synchronized (obj3) {
            obj3 = this.f;
            this.e.remove(o);
        }
    }

    public final void s(o<?> o) {
        Object obj = this.f;
        this.e.remove(o);
        Object obj4 = this.f;
        synchronized (obj) {
            obj = this.f;
            this.e.remove(o);
            obj4 = this.f;
        }
        this.b.d("Leaving the connection open for other ongoing calls.", new Object[0]);
    }
}
