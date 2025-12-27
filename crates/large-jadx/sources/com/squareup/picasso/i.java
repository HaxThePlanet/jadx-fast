package com.squareup.picasso;

import android.accounts.Account;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* compiled from: Dispatcher.java */
/* loaded from: classes2.dex */
class i {

    final i.b a = new i$b();
    final Context b;
    final ExecutorService c;
    final j d;
    final Map<String, c> e = new LinkedHashMap<>();
    final Map<Object, a> f = new WeakHashMap<>();
    final Map<Object, a> g = new WeakHashMap<>();
    final Set<Object> h = new LinkedHashSet<>();
    final Handler i = new i$a();
    final Handler j;
    final d k;
    final a0 l;
    final List<c> m = new ArrayList<>(4);
    final i.c n = new i$c();
    final boolean o;
    boolean p;

    private static class a extends Handler {

        private final i a;
        a(Looper looper, i iVar) {
            super(looper);
            this.a = iVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z = false;
            z = false;
            switch (message.what) {
                case 1:
                    this.a.v((a)message.obj);
                    break;
                case 2:
                    this.a.o((a)message.obj);
                    break;
                case 3:
                    t.p.post(new i.a.a(this, message));
                    break;
                case 4:
                    this.a.p((c)message.obj);
                    break;
                case 5:
                    this.a.u((c)message.obj);
                    break;
                case 6:
                    this.a.q((c)message.obj, z);
                    break;
                case 7:
                    this.a.n();
                    break;
                case 8:
                    this.a.r((NetworkInfo)message.obj);
                    break;
                case 9:
                    int i = 1;
                    this.a.m(z);
                    break;
                case 10:
                    this.a.s(message.obj);
                    break;
                default:
                    this.a.t(message.obj);
            }
        }
    }

    static class b extends HandlerThread {
        b() {
            super("Picasso-Dispatcher", 10);
        }
    }

    static class c extends BroadcastReceiver {

        private final i a;
        c() {
            super();
            this.a = iVar;
        }

        @Override // android.content.BroadcastReceiver
        void a() throws android.content.IntentFilter.MalformedMimeTypeException {
            final IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            if (this.a.o) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            this.a.b.registerReceiver(this, intentFilter);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                String str2 = "state";
                if (!intent.hasExtra(str2)) {
                    return;
                }
                boolean equals = false;
                this.a.b(intent.getBooleanExtra(str2, equals));
            } else {
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    this.a.f((ConnectivityManager)f0.n(context, "connectivity").getActiveNetworkInfo());
                }
            }
        }
    }
    i(Context context, ExecutorService executorService, Handler handler, j jVar, d dVar, a0 a0Var) {
        super();
        com.squareup.picasso.i.b bVar = new i.b();
        bVar.start();
        f0.h(bVar.getLooper());
        this.b = context;
        this.c = executorService;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        WeakHashMap weakHashMap = new WeakHashMap();
        WeakHashMap weakHashMap2 = new WeakHashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        com.squareup.picasso.i.a aVar = new i.a(bVar.getLooper(), this);
        this.d = jVar;
        this.j = handler;
        this.k = dVar;
        this.l = a0Var;
        ArrayList arrayList = new ArrayList(4);
        this.p = f0.p(context);
        this.o = f0.o(context, "android.permission.ACCESS_NETWORK_STATE");
        new i.c(this).a();
    }

    private void a(c cVar) {
        if (cVar.u()) {
            return;
        }
        if (cVar.E != null) {
            cVar.E.prepareToDraw();
        }
        this.m.add(cVar);
        int i = 7;
        if (!this.i.hasMessages(i)) {
            long l = 200L;
            this.i.sendEmptyMessageDelayed(i, l);
        }
    }

    private void i() {
        boolean z = false;
        String str;
        String str2;
        if (!this.f.isEmpty()) {
            Iterator it = this.f.values().iterator();
            while (it.hasNext()) {
                Object item = it.next();
                it.remove();
            }
        }
    }

    private void j(List<c> list) {
        int length;
    }

    private void k(a aVar) {
        final Object obj = aVar.k();
        if (obj != null) {
            aVar.k = true;
            this.f.put(obj, aVar);
        }
    }

    private void l(c cVar) {
        int i = 0;
        Object item;
        com.squareup.picasso.a aVar = cVar.h();
        if (aVar != null) {
            k(aVar);
        }
        final List list = cVar.i();
        if (list != null) {
            i = 0;
            while (i < list.size()) {
                k((a)list.get(i));
                i = i + 1;
            }
        }
    }

    void b(boolean z) {
        this.i.sendMessage(this.i.obtainMessage(10, z, 0));
    }

    void c(a aVar) {
        this.i.sendMessage(this.i.obtainMessage(2, aVar));
    }

    void d(c cVar) {
        this.i.sendMessage(this.i.obtainMessage(4, cVar));
    }

    void e(c cVar) {
        this.i.sendMessage(this.i.obtainMessage(6, cVar));
    }

    void f(NetworkInfo networkInfo) {
        this.i.sendMessage(this.i.obtainMessage(9, networkInfo));
    }

    void g(c cVar) {
        this.i.sendMessageDelayed(this.i.obtainMessage(5, cVar), 500L);
    }

    void h(a aVar) {
        this.i.sendMessage(this.i.obtainMessage(1, aVar));
    }

    void m(boolean z) {
        this.p = z;
    }

    void n() {
        final ArrayList arrayList = new ArrayList(this.m);
        this.m.clear();
        this.j.sendMessage(this.j.obtainMessage(8, arrayList));
        j(arrayList);
    }

    void o(a aVar) {
        String str = aVar.d();
        Object value = this.e.get(str);
        final String str5 = "canceled";
        final String str6 = "Dispatcher";
        if (value != null && value.c() && aVar.g().n) {
            f0.s(str6, str5, aVar.i().d());
        }
        if (this.h.contains(aVar.j()) && aVar.g().n) {
            f0.t(str6, str5, aVar.i().d(), "because paused request got canceled");
        }
        Object remove = this.f.remove(aVar.k());
        if (remove != null) {
            if (remove.g().n) {
                f0.t(str6, str5, remove.i().d(), "from replaying");
            }
        }
    }

    void p(c cVar) {
        Bitmap bitmap;
        if (p.shouldWriteToMemoryCache(cVar.p())) {
            this.k.b(cVar.n(), cVar.s());
        }
        this.e.remove(cVar.n());
        a(cVar);
        if (cVar.q().n) {
            str2 = "batched";
            f0.t("Dispatcher", str2, f0.j(cVar), "for completion");
        }
    }

    void q(c cVar, boolean z) {
        String str3;
        if (cVar.q().n) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("for error");
            z = z ? " (will replay)" : "";
            stringBuilder.append((z ? " (will replay)" : ""));
            str = "Dispatcher";
            str2 = "batched";
            f0.t("Dispatcher", "batched", f0.j(cVar), (z ? " (will replay)" : ""));
        }
        this.e.remove(cVar.n());
        a(cVar);
    }

    void r(NetworkInfo networkInfo) {
        if (executorService instanceof v) {
            executorService.a(networkInfo);
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            i();
        }
    }

    void s(Object object) {
        com.squareup.picasso.a aVar;
        int i;
        int i2 = 1;
        String str;
        String str2;
        String str3;
        String str4;
        boolean equals;
        Object obj;
        if (!this.h.add(object)) {
            return;
        }
        Iterator it = this.e.values().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            aVar = item.h();
            List list = item.i();
            i2 = 1;
            int r6 = list != null && !list.isEmpty() ? i2 : 0;
        }
    }

    void t(Object object) {
        Object obj = null;
        if (!this.h.remove(object)) {
            return;
        }
        int i = 0;
        Iterator it = this.g.values().iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
        if (this.h != null) {
            this.j.sendMessage(this.j.obtainMessage(13, obj));
        }
    }

    void u(c cVar) {
        NetworkInfo activeNetworkInfo = null;
        boolean z;
        boolean z4 = false;
        boolean z6;
        if (cVar.u()) {
            return;
        }
        z4 = false;
        if (this.c.isShutdown()) {
            q(cVar, false);
            return;
        }
        int i = 0;
        if (this.o) {
            activeNetworkInfo = (ConnectivityManager)f0.n(this.b, "connectivity").getActiveNetworkInfo();
        }
        if (cVar.w(this.p, activeNetworkInfo)) {
            if (cVar.q().n) {
                f0.s("Dispatcher", "retrying", f0.j(cVar));
            }
            z3 = cVar.k() instanceof r.a;
            if (cVar.k() instanceof r.a) {
                cVar.A |= index2;
            }
            cVar.F = this.c.submit(cVar);
        } else {
            if (this.o && cVar.x()) {
                int i4 = 1;
            }
            q(cVar, z4);
            if (q.NO_CACHE.index) {
                l(cVar);
            }
        }
    }

    void v(a aVar) {
        w(aVar, true);
    }

    void w(a aVar, boolean z) {
        String str7 = "Dispatcher";
        if (this.h.contains(aVar.j())) {
            this.g.put(aVar.k(), aVar);
            if (aVar.g().n) {
                StringBuilder stringBuilder = new StringBuilder();
                str = "because tag '";
                Object obj4 = aVar.j();
                String str10 = "' is paused";
                str2 = str + obj4 + str10;
                f0.t(str7, "paused", aVar.b.d(), str2);
            }
            return;
        }
        Object value = this.e.get(aVar.d());
        if (value != null) {
            value.b(aVar);
            return;
        }
        if (this.c.isShutdown()) {
            if (aVar.g().n) {
                f0.t(str7, "ignored", aVar.b.d(), "because shut down");
            }
            return;
        }
        com.squareup.picasso.c cVar = c.g(aVar.g(), this, this.k, this.l, aVar);
        cVar.F = this.c.submit(cVar);
        this.e.put(aVar.d(), cVar);
        if (aVar.b) {
            this.f.remove(aVar.k());
        }
        if (aVar.g().n) {
            f0.s(str7, "enqueued", aVar.b.d());
        }
    }
}
