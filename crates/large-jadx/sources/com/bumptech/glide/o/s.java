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

/* loaded from: classes.dex */
final class s {

    private static volatile com.bumptech.glide.o.s d;
    private final com.bumptech.glide.o.s.c a;
    final Set<com.bumptech.glide.o.c.a> b;
    private boolean c;

    private interface c {
        public abstract boolean register();

        public abstract void unregister();
    }

    class a implements f.b<ConnectivityManager> {

        final Context a;
        a(com.bumptech.glide.o.s s, Context context2) {
            this.a = context2;
            super();
        }

        @Override // com.bumptech.glide.t.f$b
        public ConnectivityManager a() {
            return (ConnectivityManager)this.a.getSystemService("connectivity");
        }

        @Override // com.bumptech.glide.t.f$b
        public Object get() {
            return a();
        }
    }

    class b implements com.bumptech.glide.o.c.a {

        final com.bumptech.glide.o.s a;
        b(com.bumptech.glide.o.s s) {
            this.a = s;
            super();
        }

        @Override // com.bumptech.glide.o.c$a
        public void a(boolean z) {
            ArrayList arrayList;
            com.bumptech.glide.o.s sVar = this.a;
            arrayList = new ArrayList(sVar2.b);
            Iterator iterator = arrayList.iterator();
            synchronized (sVar) {
                sVar = this.a;
                arrayList = new ArrayList(sVar2.b);
                iterator = arrayList.iterator();
            }
            for (c.a arrayList : iterator) {
                arrayList.a(z);
            }
            try {
                throw z;
            }
        }
    }

    private static final class d implements com.bumptech.glide.o.s.c {

        boolean a;
        final com.bumptech.glide.o.c.a b;
        private final f.b<ConnectivityManager> c;
        private final ConnectivityManager.NetworkCallback d;
        d(f.b<ConnectivityManager> f$b, com.bumptech.glide.o.c.a c$a2) {
            super();
            s.d.a aVar = new s.d.a(this);
            this.d = aVar;
            this.c = b;
            this.b = a2;
        }

        @Override // com.bumptech.glide.o.s$c
        public boolean register() {
            int i;
            int str;
            String str2;
            final int i2 = 1;
            i = (ConnectivityManager)this.c.get().getActiveNetwork() != null ? i2 : i3;
            this.a = i;
            (ConnectivityManager)this.c.get().registerDefaultNetworkCallback(this.d);
            return i2;
        }

        @Override // com.bumptech.glide.o.s$c
        public void unregister() {
            (ConnectivityManager)this.c.get().unregisterNetworkCallback(this.d);
        }
    }

    private static final class e implements com.bumptech.glide.o.s.c {

        private final Context a;
        final com.bumptech.glide.o.c.a b;
        private final f.b<ConnectivityManager> c;
        boolean d;
        private final BroadcastReceiver e;
        e(Context context, f.b<ConnectivityManager> f$b2, com.bumptech.glide.o.c.a c$a3) {
            super();
            s.e.a aVar = new s.e.a(this);
            this.e = aVar;
            this.a = context.getApplicationContext();
            this.c = b2;
            this.b = a3;
        }

        @Override // com.bumptech.glide.o.s$c
        boolean a() {
            int i;
            Throwable th;
            NetworkInfo activeNetworkInfo;
            int str;
            String str2;
            i = 1;
            activeNetworkInfo = (ConnectivityManager)this.c.get().getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                try {
                    if (activeNetworkInfo.isConnected()) {
                    } else {
                    }
                    i = 0;
                    return i;
                    str = 5;
                    str2 = "ConnectivityMonitor";
                    str = Log.isLoggable(str2, str);
                    if (str != null) {
                    }
                    str = "Failed to determine connectivity status when connectivity changed";
                    Log.w(str2, str, th);
                    return obj0;
                }
            } else {
            }
        }

        @Override // com.bumptech.glide.o.s$c
        public boolean register() {
            int str;
            String str2;
            this.d = a();
            IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            this.a.registerReceiver(this.e, intentFilter);
            return 1;
        }

        @Override // com.bumptech.glide.o.s$c
        public void unregister() {
            this.a.unregisterReceiver(this.e);
        }
    }
    private s(Context context) {
        int sDK_INT;
        Object obj5;
        super();
        HashSet hashSet = new HashSet();
        this.b = hashSet;
        s.a aVar = new s.a(this, context);
        f.b bVar = f.a(aVar);
        s.b bVar2 = new s.b(this);
        if (Build.VERSION.SDK_INT >= 24) {
            obj5 = new s.d(bVar, bVar2);
        } else {
            sDK_INT = new s.e(context, bVar, bVar2);
            obj5 = sDK_INT;
        }
        this.a = obj5;
    }

    static com.bumptech.glide.o.s a(Context context) {
        com.bumptech.glide.o.s sVar2;
        com.bumptech.glide.o.s sVar;
        Object obj2;
        sVar2 = s.class;
        if (s.d == null && s.d == null) {
            sVar2 = s.class;
            synchronized (sVar2) {
                sVar = new s(context.getApplicationContext());
                s.d = sVar;
            }
        }
        return s.d;
    }

    private void b() {
        boolean register;
        if (!this.c) {
            if (this.b.isEmpty()) {
            } else {
                this.c = this.a.register();
            }
        }
    }

    private void c() {
        boolean empty;
        if (this.c) {
            if (!this.b.isEmpty()) {
            } else {
                this.a.unregister();
                this.c = false;
            }
        }
    }

    void d(com.bumptech.glide.o.c.a c$a) {
        this.b.add(a);
        b();
        return;
        synchronized (this) {
            this.b.add(a);
            b();
        }
    }

    void e(com.bumptech.glide.o.c.a c$a) {
        this.b.remove(a);
        c();
        return;
        synchronized (this) {
            this.b.remove(a);
            c();
        }
    }
}
