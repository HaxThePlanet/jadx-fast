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

/* loaded from: classes2.dex */
class i {

    final com.squareup.picasso.i.b a;
    final Context b;
    final ExecutorService c;
    final com.squareup.picasso.j d;
    final Map<String, com.squareup.picasso.c> e;
    final Map<Object, com.squareup.picasso.a> f;
    final Map<Object, com.squareup.picasso.a> g;
    final Set<Object> h;
    final Handler i;
    final Handler j;
    final com.squareup.picasso.d k;
    final com.squareup.picasso.a0 l;
    final List<com.squareup.picasso.c> m;
    final com.squareup.picasso.i.c n;
    final boolean o;
    boolean p;

    private static class a extends Handler {

        private final com.squareup.picasso.i a;
        a(Looper looper, com.squareup.picasso.i i2) {
            super(looper);
            this.a = i2;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            com.squareup.picasso.i what;
            int aVar;
            int i;
            Object obj4;
            switch (what) {
                case 1:
                    this.a.v((a)message.obj);
                    break;
                case 2:
                    this.a.o((a)message.obj);
                    break;
                case 3:
                    aVar = new i.a.a(this, message);
                    t.p.post(aVar);
                    break;
                case 4:
                    this.a.p((c)message.obj);
                    break;
                case 5:
                    this.a.u((c)message.obj);
                    break;
                case 6:
                    this.a.q((c)message.obj, false);
                    break;
                case 7:
                    this.a.n();
                    break;
                case 8:
                    this.a.r((NetworkInfo)message.obj);
                    break;
                case 9:
                    i = 1;
                    aVar = i;
                    this.a.m(aVar);
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

        private final com.squareup.picasso.i a;
        c(com.squareup.picasso.i i) {
            super();
            this.a = i;
        }

        @Override // android.content.BroadcastReceiver
        void a() {
            boolean str;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            if (iVar.o) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            iVar2.b.registerReceiver(this, intentFilter);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent2) {
            Object action;
            int equals;
            boolean obj3;
            boolean obj4;
            if (intent2 == null) {
            }
            action = intent2.getAction();
            if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                obj3 = "state";
                if (!intent2.hasExtra(obj3)) {
                }
                this.a.b(intent2.getBooleanExtra(obj3, false));
            } else {
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    this.a.f((ConnectivityManager)f0.n(context, "connectivity").getActiveNetworkInfo());
                }
            }
        }
    }
    i(Context context, ExecutorService executorService2, Handler handler3, com.squareup.picasso.j j4, com.squareup.picasso.d d5, com.squareup.picasso.a0 a06) {
        super();
        i.b bVar = new i.b();
        this.a = bVar;
        bVar.start();
        f0.h(bVar.getLooper());
        this.b = context;
        this.c = executorService2;
        LinkedHashMap obj4 = new LinkedHashMap();
        this.e = obj4;
        obj4 = new WeakHashMap();
        this.f = obj4;
        obj4 = new WeakHashMap();
        this.g = obj4;
        obj4 = new LinkedHashSet();
        this.h = obj4;
        obj4 = new i.a(bVar.getLooper(), this);
        this.i = obj4;
        this.d = j4;
        this.j = handler3;
        this.k = d5;
        this.l = a06;
        obj4 = new ArrayList(4);
        this.m = obj4;
        this.p = f0.p(context);
        this.o = f0.o(context, "android.permission.ACCESS_NETWORK_STATE");
        i.c obj3 = new i.c(this);
        this.n = obj3;
        obj3.a();
    }

    private void a(com.squareup.picasso.c c) {
        int i;
        boolean obj4;
        if (c.u()) {
        }
        Bitmap bitmap = c.E;
        if (bitmap != null) {
            bitmap.prepareToDraw();
        }
        this.m.add(c);
        int i2 = 7;
        if (!this.i.hasMessages(i2)) {
            this.i.sendEmptyMessageDelayed(i2, 200);
        }
    }

    private void i() {
        boolean iterator;
        Object next;
        int i;
        boolean z;
        String str;
        String str2;
        if (!this.f.isEmpty()) {
            iterator = this.f.values().iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                iterator.remove();
                if (tVar.n) {
                }
                w(next, false);
                f0.s("Dispatcher", "replaying", next.i().d());
            }
        }
    }

    private void j(List<com.squareup.picasso.c> list) {
        boolean empty;
        String str;
        int length;
        String obj4;
        if (list != null) {
            if (list.isEmpty()) {
            } else {
                if (tVar.n) {
                    StringBuilder stringBuilder = new StringBuilder();
                    obj4 = list.iterator();
                    while (obj4.hasNext()) {
                        if (stringBuilder.length() > 0) {
                        }
                        stringBuilder.append(f0.j((c)obj4.next()));
                        stringBuilder.append(", ");
                    }
                    f0.s("Dispatcher", "delivered", stringBuilder.toString());
                }
            }
        }
    }

    private void k(com.squareup.picasso.a a) {
        Map map;
        final Object obj = a.k();
        if (obj != null) {
            a.k = true;
            this.f.put(obj, a);
        }
    }

    private void l(com.squareup.picasso.c c) {
        int aVar;
        int size;
        Object obj;
        aVar = c.h();
        if (aVar != null) {
            k(aVar);
        }
        final List obj4 = c.i();
        if (obj4 != null) {
            aVar = 0;
            while (aVar < obj4.size()) {
                k((a)obj4.get(aVar));
                aVar++;
            }
        }
    }

    void b(boolean z) {
        final Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(10, z, 0));
    }

    void c(com.squareup.picasso.a a) {
        final Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(2, a));
    }

    void d(com.squareup.picasso.c c) {
        final Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(4, c));
    }

    void e(com.squareup.picasso.c c) {
        final Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(6, c));
    }

    void f(NetworkInfo networkInfo) {
        final Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(9, networkInfo));
    }

    void g(com.squareup.picasso.c c) {
        final Handler handler = this.i;
        handler.sendMessageDelayed(handler.obtainMessage(5, c), 500);
    }

    void h(com.squareup.picasso.a a) {
        final Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(1, a));
    }

    void m(boolean z) {
        this.p = z;
    }

    void n() {
        ArrayList arrayList = new ArrayList(this.m);
        this.m.clear();
        Handler handler = this.j;
        handler.sendMessage(handler.obtainMessage(8, arrayList));
        j(arrayList);
    }

    void o(com.squareup.picasso.a a) {
        String str3;
        boolean contains;
        Map str2;
        Object obj;
        Object str;
        Object obj5;
        str3 = a.d();
        obj = this.e.get(str3);
        final String str4 = "canceled";
        final String str5 = "Dispatcher";
        (c)obj.f(a);
        this.e.remove(str3);
        if (obj != null && obj.c() && tVar.n) {
            obj.f(a);
            if (obj.c()) {
                this.e.remove(str3);
                if (tVar.n) {
                    f0.s(str5, str4, a.i().d());
                }
            }
        }
        this.g.remove(a.k());
        if (this.h.contains(a.j()) && tVar3.n) {
            this.g.remove(a.k());
            if (tVar3.n) {
                f0.t(str5, str4, a.i().d(), "because paused request got canceled");
            }
        }
        obj5 = this.f.remove(a.k());
        if (obj5 != null && tVar2.n) {
            if (tVar2.n) {
                f0.t(str5, str4, obj5.i().d(), "from replaying");
            }
        }
    }

    void p(com.squareup.picasso.c c) {
        boolean writeToMemoryCache;
        boolean str3;
        String str2;
        String str;
        Bitmap str4;
        Object obj4;
        if (p.shouldWriteToMemoryCache(c.p())) {
            this.k.b(c.n(), c.s());
        }
        this.e.remove(c.n());
        a(c);
        if (tVar.n) {
            f0.t("Dispatcher", "batched", f0.j(c), "for completion");
        }
    }

    void q(com.squareup.picasso.c c, boolean z2) {
        boolean z;
        String str;
        String str2;
        String obj5;
        if (tVar.n) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("for error");
            obj5 = z2 != null ? " (will replay)" : "";
            stringBuilder.append(obj5);
            f0.t("Dispatcher", "batched", f0.j(c), stringBuilder.toString());
        }
        this.e.remove(c.n());
        a(c);
    }

    void r(NetworkInfo networkInfo) {
        NetworkInfo obj3;
        final ExecutorService service = this.c;
        if (service instanceof v) {
            (v)service.a(networkInfo);
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            if (networkInfo.isConnected()) {
                i();
            }
        }
    }

    void s(Object object) {
        Object next;
        boolean str;
        boolean str2;
        List list;
        int i;
        int equals;
        String str3;
        String str4;
        String str5;
        String str6;
        boolean equals2;
        Object obj;
        if (!this.h.add(object)) {
        }
        Iterator iterator = this.e.values().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            str = tVar.n;
            str2 = next.h();
            list = next.i();
            i = 1;
            if (list != null && !list.isEmpty()) {
            } else {
            }
            equals = 0;
            if (str2 == null && equals == 0) {
            } else {
            }
            str3 = "' was paused";
            str4 = "because tag '";
            str5 = "paused";
            str6 = "Dispatcher";
            next.f(str2);
            this.g.put(str2.k(), str2);
            if (str2 != null && str2.j().equals(object) && str != null) {
            }
            if (equals != 0) {
            }
            iterator.remove();
            if (next.c() && str != null) {
            }
            iterator.remove();
            if (str != null) {
            }
            f0.t(str6, "canceled", f0.j(next), "all actions paused");
            size -= i;
            while (str2 >= 0) {
                i = list.get(str2);
                if (!(a)i.j().equals(object)) {
                } else {
                }
                next.f(i);
                this.g.put(i.k(), i);
                if (str != null) {
                }
                str2--;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str4);
                stringBuilder.append(object);
                stringBuilder.append(str3);
                f0.t(str6, str5, i.b.d(), stringBuilder.toString());
            }
            i = list.get(str2);
            if (!(a)i.j().equals(object)) {
            } else {
            }
            next.f(i);
            this.g.put(i.k(), i);
            if (str != null) {
            }
            str2--;
            stringBuilder = new StringBuilder();
            stringBuilder.append(str4);
            stringBuilder.append(object);
            stringBuilder.append(str3);
            f0.t(str6, str5, i.b.d(), stringBuilder.toString());
            if (str2.j().equals(object)) {
            }
            next.f(str2);
            this.g.put(str2.k(), str2);
            if (str != null) {
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str4);
            stringBuilder2.append(object);
            stringBuilder2.append(str3);
            f0.t(str6, str5, str2.b.d(), stringBuilder2.toString());
            if (equals == 0) {
            } else {
            }
            if (!list.isEmpty()) {
            } else {
            }
            equals = i;
        }
    }

    void t(Object object) {
        int arrayList;
        Iterator iterator;
        Object next;
        boolean equals;
        Object obj5;
        if (!this.h.remove(object)) {
        }
        arrayList = 0;
        iterator = this.g.values().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((a)next.j().equals(object) && arrayList == null) {
            }
            if (arrayList == null) {
            }
            arrayList.add(next);
            iterator.remove();
            arrayList = new ArrayList();
        }
        if (arrayList != null) {
            obj5 = this.j;
            obj5.sendMessage(obj5.obtainMessage(13, arrayList));
        }
    }

    void u(com.squareup.picasso.c c) {
        int activeNetworkInfo;
        boolean submit;
        boolean z;
        boolean z2;
        int index;
        boolean str;
        boolean str2;
        if (c.u()) {
        }
        if (this.c.isShutdown()) {
            q(c, false);
        }
        activeNetworkInfo = 0;
        if (this.o) {
            activeNetworkInfo = (ConnectivityManager)f0.n(this.b, "connectivity").getActiveNetworkInfo();
        }
        if (c.w(this.p, activeNetworkInfo)) {
            if (tVar.n) {
                f0.s("Dispatcher", "retrying", f0.j(c));
            }
            if (exc instanceof r.a) {
                c.A = i |= index;
            }
            c.F = this.c.submit(c);
        } else {
            if (this.o && c.x()) {
                if (c.x()) {
                    index = 1;
                }
            }
            q(c, index);
            if (index != 0) {
                l(c);
            }
        }
    }

    void v(com.squareup.picasso.a a) {
        w(a, true);
    }

    void w(com.squareup.picasso.a a, boolean z2) {
        Object str;
        boolean shutdown;
        Object cVar;
        String str2;
        Object obj5;
        boolean obj6;
        String str3 = "Dispatcher";
        this.g.put(a.k(), a);
        if (this.h.contains(a.j()) && obj6.n) {
            this.g.put(a.k(), a);
            if (obj6.n) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("because tag '");
                stringBuilder.append(a.j());
                stringBuilder.append("' is paused");
                f0.t(str3, "paused", a.b.d(), stringBuilder.toString());
            }
        }
        Object obj = this.e.get(a.d());
        if ((c)obj != null) {
            (c)obj.b(a);
        }
        if (this.c.isShutdown() && obj6.n) {
            if (obj6.n) {
                f0.t(str3, "ignored", a.b.d(), "because shut down");
            }
        }
        cVar = c.g(a.g(), this, this.k, this.l, a);
        cVar.F = this.c.submit(cVar);
        this.e.put(a.d(), cVar);
        if (z2 != null) {
            this.f.remove(a.k());
        }
        if (obj6.n) {
            f0.s(str3, "enqueued", a.b.d());
        }
    }
}
