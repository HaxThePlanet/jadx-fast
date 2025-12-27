package com.bumptech.glide.o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.util.Log;
import com.bumptech.glide.t.f;
import com.bumptech.glide.t.f.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: SingletonConnectivityReceiver.java */
/* loaded from: classes.dex */
final class s {

    private static volatile s d;
    private final s.c a = new s$e();
    final Set<c.a> b = new HashSet<>();
    private boolean c;

    private interface c {
        boolean register();

        void unregister();
    }

    class a implements f.b<ConnectivityManager> {

        final /* synthetic */ Context a;
        a(Context context) {
            this.a = context;
            super();
        }

        public ConnectivityManager a() {
            return (ConnectivityManager)this.a.getSystemService("connectivity");
        }
    }

    class b implements c.a {

        final /* synthetic */ s a;
        b() {
            this.a = sVar;
            super();
        }

        public void a(boolean z) {
            synchronized (sVar) {
                try {
                } catch (Throwable th) {
                }
            }
            Iterator it = new ArrayList(this.a.b).iterator();
            while (it.hasNext()) {
                (c.a)it.next().a(th);
            }
        }
    }

    private static final class d implements s.c {

        boolean a;
        final c.a b;
        private final f.b<ConnectivityManager> c;
        private final ConnectivityManager.NetworkCallback d = new s$d$a();
        d(f.b<ConnectivityManager> bVar, c.a aVar) {
            super();
            aVar = new s.d.a(this);
            this.c = bVar;
            this.b = aVar;
        }

        public boolean register() {
            int i;
            int str;
            String str2;
            i = 1;
            Throwable th = (ConnectivityManager)this.c.get().getActiveNetwork() != null ? i : 0;
            this.a = ((ConnectivityManager)this.c.get().getActiveNetwork() != null ? i : 0);
            try {
                (ConnectivityManager)this.c.get().registerDefaultNetworkCallback(this.d);
            } catch (RuntimeException e) {
                str = 5;
                str2 = "ConnectivityMonitor";
                str = Log.isLoggable(str2, str);
            }
            return true;
        }

        public void unregister() {
            (ConnectivityManager)this.c.get().unregisterNetworkCallback(this.d);
        }
    }

    private static final class e implements s.c {

        private final Context a;
        final c.a b;
        private final f.b<ConnectivityManager> c;
        boolean d;
        private final BroadcastReceiver e = new s$e$a();
        e(Context context, f.b<ConnectivityManager> bVar, c.a aVar) {
            super();
            aVar = new s.e.a(this);
            this.a = context.getApplicationContext();
            this.c = bVar;
            this.b = aVar;
        }

        boolean a() {
            boolean z2 = true;
            Throwable th;
            NetworkInfo activeNetworkInfo;
            int str;
            String str2;
            int i = 1;
            try {
                activeNetworkInfo = (ConnectivityManager)this.c.get().getActiveNetworkInfo();
            } catch (RuntimeException e) {
                str = 5;
                str2 = "ConnectivityMonitor";
                str = Log.isLoggable(str2, str);
            }
            if (this.c == null || !this.c.isConnected()) {
                int i2 = 0;
            }
            return z2;
        }

        public boolean register() throws android.content.IntentFilter.MalformedMimeTypeException {
            int str;
            String str2;
            this.d = a();
            try {
                this.a.registerReceiver(this.e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } catch (java.lang.SecurityException se) {
                str = 5;
                str2 = "ConnectivityMonitor";
                str = Log.isLoggable(str2, str);
            }
            return true;
        }

        public void unregister() {
            this.a.unregisterReceiver(this.e);
        }
    }
    private s(Context context) {
        super();
        HashSet hashSet = new HashSet();
        f.b bVar = f.a(new s.a(this, context));
        final com.bumptech.glide.o.s.b bVar2 = new s.b(this);
        if (Build.VERSION.SDK_INT >= 24) {
            com.bumptech.glide.o.s.d dVar = new s.d(bVar, bVar2);
        }
        com.bumptech.glide.o.s.e eVar = new s.e(context, bVar, bVar2);
    }

    static s a(Context context) {
        com.bumptech.glide.o.s sVar2;
        Context applicationContext;
        if (s.d == null) {
            sVar = s.class;
            synchronized (sVar) {
                try {
                    if (s.d == null) {
                        s.d = new s(context.getApplicationContext());
                    }
                } catch (Throwable th) {
                }
            }
        }
        return s.d;
    }

    private void b() {
        if (!this.c) {
            if (!(this.b.isEmpty())) {
                this.c = this.a.register();
            }
        }
    }

    private void c() {
        if (this.c) {
            if (this.b.isEmpty()) {
                this.a.unregister();
                boolean empty = false;
                this.c = empty;
            }
        }
    }

    synchronized void d(c.a aVar) {
        this.b.add(aVar);
        b();
    }

    synchronized void e(c.a aVar) {
        this.b.remove(aVar);
        c();
    }
}
